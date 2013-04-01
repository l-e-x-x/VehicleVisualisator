/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bradley.dupont.odu.edu.vanet.ns3.db;

import au.com.bytecode.opencsv.CSVReader;
import bradley.dupont.odu.edu.vanet.ns3.dto.VehicleLocation;
import java.awt.geom.Point2D;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author bdupont
 */
public enum DBManager {

    INSTANCE;
    private double minX = Double.POSITIVE_INFINITY;
    private double minY = Double.POSITIVE_INFINITY;
    private double maxX = Double.NEGATIVE_INFINITY;
    private double maxY = Double.NEGATIVE_INFINITY;

    private DBManager() {
        try {
            Class.forName("org.hsqldb.jdbc.JDBCDriver");
            conn = DriverManager.getConnection("jdbc:hsqldb:vehicledb", "SA", "");
        } catch (Exception ex) {
        }

    }
    private Connection conn;

    public Connection getConn() {
        return conn;
    }

    public void loadVehicleData(String vehicleDataCsvFile) {
        FileReader fr = null;
        try {

            try {
                conn.createStatement().execute("drop table vehicle_msg");
            } catch (Exception ex) {
            }

            try {
                conn.createStatement().execute("drop table vehicle_loc");
            } catch (Exception ex) {
            }

            try {
                conn.createStatement().execute("drop table sim_times");
            } catch (Exception ex) {
            }

            try {
                conn.createStatement().execute("drop table vehicles");
            } catch (Exception ex) {
            }

            conn.createStatement().execute("create table vehicles (veh_id integer, type_id integer, primary key (veh_id))");
            conn.createStatement().execute("create table sim_times (sim_time BIGINT, primary key (sim_time))");
            conn.createStatement().execute("create table vehicle_loc (sim_time BIGINT, veh_id integer, x_loc real, y_loc real, direction real, velocity real, acceleration real, primary key (sim_time, veh_id), foreign key (veh_id) references vehicles (veh_id), foreign key (sim_time) references sim_times (sim_time))");
            conn.createStatement().execute("create table vehicle_msg (sim_time BIGINT, veh_id integer, message varchar(4000), user_index integer, foreign key (veh_id) references vehicles (veh_id))");

            fr = new FileReader(vehicleDataCsvFile);
            CSVReader reader = new CSVReader(fr);
            String[] line = null;

            minX = Double.POSITIVE_INFINITY;
            minY = Double.POSITIVE_INFINITY;
            maxX = Double.NEGATIVE_INFINITY;
            maxY = Double.NEGATIVE_INFINITY;

            while ((line = reader.readNext()) != null) {
                long simTime = Long.valueOf(line[0]);
                int vehicleId = Integer.valueOf(line[1]);
                int typeId = Integer.valueOf(line[2]);
                double xPos = Double.valueOf(line[3]);
                minX = Math.min(xPos, minX);
                maxX = Math.max(xPos, maxX);
                double yPos = Double.valueOf(line[4]);
                minY = Math.min(yPos, minY);
                maxY = Math.max(yPos, maxY);
                double direction = Double.valueOf(cleanDouble(line[5]));
                double velocity = Double.valueOf(cleanDouble(line[6]));
                double acceleration = Double.valueOf(cleanDouble(line[7]));
                addVehicleTime(simTime, vehicleId, typeId, xPos, yPos, direction, velocity, acceleration);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (fr != null) {
                try {
                    fr.close();
                } catch (Exception ex) {

                }
            }
        }

    }

    private String cleanDouble(String str) {
        String str2 = str.toLowerCase();
        if(str2.equals("nan")) {
            return "NaN";
        } else if (str2.equals("infinity") || str2.equals("inf")) {
            return "Infinity";
        } else {
            return str;
        }
    }

    public void loadMessageData(String vehicleMsgCsvFile) {
        try {
            CSVReader reader = new CSVReader(new FileReader(vehicleMsgCsvFile));
            String[] line = null;

            while ((line = reader.readNext()) != null) {
                long simTime = Long.valueOf(line[0]);
                int vehicleId = Integer.valueOf(line[1]);
                String message = line[2];
                int userIndex = Integer.valueOf(line[3]);
                addVehicleMessage(simTime, vehicleId, message, userIndex);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public List<VehicleLocation> getVehiclesForTime(long simTime) {
        List<VehicleLocation> values = new LinkedList<VehicleLocation>();

        PreparedStatement st = null;
        try {
            st = conn.prepareStatement("select l.veh_id, v.type_id, l.x_loc, l.y_loc, l.direction, l.velocity, l.acceleration from vehicle_loc l, vehicles v where l.sim_time=? and l.veh_id = v.veh_id order by veh_id");
            st.setLong(1, simTime);
            ResultSet rs = st.executeQuery();
            while(rs.next()) {
                int vehId = rs.getInt("veh_id");
                int typeId = rs.getInt("type_id");
                double direction = rs.getDouble("direction");
                double velocity = rs.getDouble("velocity");
                double acceleration = rs.getDouble("acceleration");
                double xLoc = rs.getDouble("x_loc");
                double yLoc = rs.getDouble("y_loc");
                Point2D.Double newPoint = new Point2D.Double(xLoc, yLoc);
                values.add(new VehicleLocation(vehId, typeId, newPoint, direction, velocity, acceleration));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (st != null) {
                try {
                    st.close();
                } catch (Exception ex) {

                }
            }
        }

        return values;
    }

    public ResultSet getTimes(Long startTime) throws SQLException {
        PreparedStatement ps = conn.prepareStatement("select sim_time from sim_times where sim_time > ? order by sim_time asc");
        if(startTime == null) {
            startTime = -1L;
        }
        ps.setLong(1, startTime);
        return ps.executeQuery();
    }

    public double getMaxX() {
        if (maxX == Double.NEGATIVE_INFINITY) {
            loadRanges();
        }
        return maxX;
    }

    public double getMaxY() {
        if (maxY == Double.NEGATIVE_INFINITY) {
            loadRanges();
        }
        return maxY;
    }

    public double getMinX() {
        if (minX == Double.POSITIVE_INFINITY) {
            loadRanges();
        }
        return minX;
    }

    public double getMinY() {
        if (minY == Double.POSITIVE_INFINITY) {
            loadRanges();
        }
        return minY;
    }

    private void loadRanges() {
        Statement st = null;
        try {
            st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from sim_times");
            if (rs.next()) {
                st.close();
                rs = conn.createStatement().executeQuery("select max(x_loc) as max_x, min(x_loc) as min_x, max(y_loc) as max_y, min(y_loc) as min_y from vehicle_loc");
                rs.next();
                maxX = rs.getDouble("max_x");
                minX = rs.getDouble("min_x");
                maxY = rs.getDouble("max_y");
                minY = rs.getDouble("min_y");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (st != null) {
                try {
                    st.close();
                } catch (Exception ex) {
                }
            }
        }

    }

    private boolean simTimeExists(long simTime) throws Exception {
        boolean result = false;
        PreparedStatement ps = conn.prepareStatement("select * from sim_times where sim_time = ?");
        ps.setLong(1, simTime);
        result = ps.executeQuery().next();
        return result;
    }

    private boolean vehicleExists(int vehId) throws Exception {
        boolean result = false;
        PreparedStatement ps = conn.prepareStatement("select * from vehicles where veh_id = ?");
        ps.setInt(1, vehId);
        result = ps.executeQuery().next();
        return result;
    }

    private void addVehicleMessage(long simTime, int vehicleId, String message, int userIndex) {
        try {
            if (!vehicleExists(vehicleId)) {
                return;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        try {
            if (!simTimeExists(simTime)) {
                PreparedStatement ps = conn.prepareStatement("insert into sim_times (sim_time) values (?)");
                ps.setLong(1, simTime);
                ps.executeUpdate();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        try {
            PreparedStatement ps = conn.prepareStatement("insert into vehicle_msg (sim_time, veh_id, message, user_index) values (?,?,?,?)");
            ps.setLong(1, simTime);
            ps.setInt(2, vehicleId);
            ps.setString(3, message);
            ps.setInt(4, userIndex);
            ps.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void addVehicleTime(long simTime, int vehicleId, int typeId, double xPos, double yPos, double direction, double velocity, double acceleration) {
        try {
            if (!vehicleExists(vehicleId)) {
                PreparedStatement ps = conn.prepareStatement("insert into vehicles (veh_id, type_id) values (?,?)");
                ps.setInt(1, vehicleId);
                ps.setInt(2, typeId);
                ps.executeUpdate();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        try {
            if (!simTimeExists(simTime)) {
                PreparedStatement ps = conn.prepareStatement("insert into sim_times (sim_time) values (?)");
                ps.setLong(1, simTime);
                ps.executeUpdate();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        try {
            PreparedStatement ps = conn.prepareStatement("insert into vehicle_loc (sim_time, veh_id, x_loc, y_loc, direction, velocity, acceleration) values (?,?,?,?,?,?,?)");
            ps.setLong(1, simTime);
            ps.setInt(2, vehicleId);
            ps.setDouble(3, xPos);
            ps.setDouble(4, yPos);
            ps.setDouble(5, direction);
            ps.setDouble(6, velocity);
            ps.setDouble(7, acceleration);
            ps.executeUpdate();
        } catch (Exception ex) {
            System.err.println("sim time: " + simTime + ", vehId: " + vehicleId);
            ex.printStackTrace();
        }
    }
}
