/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bradley.dupont.odu.edu.vanet.ns3.dto.highway;

import bradley.dupont.odu.edu.vanet.ns3.dto.highway.utility.HighwayProjectUtil;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author bdupont
 */
@XStreamAlias("highwayProject")
public class HighwayProject {

    public static final XStream xs;
    
    static {
        xs = new XStream();
        xs.processAnnotations(HighwayProject.class);
        xs.processAnnotations(Highway.class);
        xs.processAnnotations(WifiConfiguration.class);
        xs.processAnnotations(VehicleGenerator.class);
        xs.processAnnotations(TrafficLightGenerator.class);
        xs.processAnnotations(HighwayConnection.class);
        xs.processAnnotations(Destination.class);
    }


    @XStreamAsAttribute
    private int numberOfRuns;
    @XStreamAsAttribute
    private int totalTimeInSeconds;
    @XStreamAsAttribute
    private double dt;
    private List<Highway> highways;
    private List<WifiConfiguration> wifiConfigurations;
    private List<VehicleGenerator> vehicleGenerators;
    private List<TrafficLightGenerator> trafficLightGenerators;

    public HighwayProject() {
        dt = 0.1;
        numberOfRuns = 1;
        totalTimeInSeconds = 30;
    }

    public int getNumberOfRuns() {
        return numberOfRuns;
    }

    public void setNumberOfRuns(int numberOfRuns) {
        this.numberOfRuns = numberOfRuns;
    }

    public int getTotalTimeInSeconds() {
        return totalTimeInSeconds;
    }

    public void setTotalTimeInSeconds(int totalTimeInSeconds) {
        this.totalTimeInSeconds = totalTimeInSeconds;
    }

    public double getDt() {
        return dt;
    }

    public void setDt(double dt) {
        this.dt = dt;
    }

    public List<Highway> getHighways() {
        return highways;
    }

    public void setHighways(List<Highway> highways) {
        this.highways = highways;
    }

    public List<VehicleGenerator> getVehicleGenerators() {
        return vehicleGenerators;
    }

    public void setVehicleGenerators(List<VehicleGenerator> vehicleGenerators) {
        this.vehicleGenerators = vehicleGenerators;
    }

    public List<WifiConfiguration> getWifiConfigurations() {
        return wifiConfigurations;
    }

    public void setWifiConfigurations(List<WifiConfiguration> wifiConfigurations) {
        this.wifiConfigurations = wifiConfigurations;
    }

    public List<TrafficLightGenerator> getTrafficLightGenerators() {
        return trafficLightGenerators;
    }

    public void setTrafficLightGenerators(List<TrafficLightGenerator> trafficLightGenerators) {
        this.trafficLightGenerators = trafficLightGenerators;
    }

    public static void main(String[] args) {
        /*
        HighwayProject highwayProject = new HighwayProject();

        List<Highway> highways = new ArrayList<Highway>();

        Highway highway1 = HighwayProjectUtil.createHighway(-150.0, 10.0, -100.0, 10.0, 2, 5.0);
        highway1.setHighwayId(1);
        highways.add(highway1);
        List<HighwayConnection> front = new ArrayList<HighwayConnection>();
        front.add(new HighwayConnection(2, 0, -1));
        highway1.setFrontHighways(front);

        Highway highway2 = HighwayProjectUtil.createHighway(-100.0, 12.5, 0.0, 12.5, 3, 5);
        highway2.setHighwayId(2);
        highways.add(highway2);
        front = new ArrayList<HighwayConnection>();
        front.add(new HighwayConnection(3, 1, 1));
        highway2.setFrontHighways(front);
        List<HighwayConnection> back = new ArrayList<HighwayConnection>();
        back.add(new HighwayConnection(1, 1, 1));
        highway2.setBackHighways(back);
        List<HighwayConnection> left = new ArrayList<HighwayConnection>();
        left.add(new HighwayConnection(5, 0, 0));
        highway2.setLeftHighways(left);
        List<HighwayConnection> right = new ArrayList<HighwayConnection>();
        right.add(new HighwayConnection(6, 2, 2));
        highway2.setRightHighways(right);

        Highway highway3 = HighwayProjectUtil.createHighway(0.0, 10.0, 40.0, 10.0, 2, 5.0);
        highway3.setHighwayId(3);
        highways.add(highway3);
        front = new ArrayList<HighwayConnection>();
        front.add(new HighwayConnection(4,0,0));
        highway3.setFrontHighways(front);
        back = new ArrayList<HighwayConnection>();
        back.add(new HighwayConnection(2, 0, -1));
        highway3.setBackHighways(back);

        Highway highway4 = HighwayProjectUtil.createHighway(40.0, 10.0, 190.0, 10.0, 2, 5.0);
        highway4.setHighwayId(4);
        highways.add(highway4);
        back = new ArrayList<HighwayConnection>();
        back.add(new HighwayConnection(3, 0, 0));
        highway4.setBackHighways(back);

        Highway highway5 = HighwayProjectUtil.createHighway(0.0, 17.5, 27.5, 40.0, 1, 5.0);
        highway5.setHighwayId(5);
        highways.add(highway5);
        front = new ArrayList<HighwayConnection>();
        front.add(new HighwayConnection(22, 0, 0));
        highway5.setFrontHighways(front);
        back = new ArrayList<HighwayConnection>();
        back.add(new HighwayConnection(2, 0, 0));
        highway5.setBackHighways(back);

        Highway highway6 = HighwayProjectUtil.createHighway(0.0, 7.5, 7.5, 0.0, 1, 5.0);
        highway6.setHighwayId(6);
        highways.add(highway6);
        front = new ArrayList<HighwayConnection>();
        front.add(new HighwayConnection(16, 0, -1));
        highway6.setFrontHighways(front);
        back = new ArrayList<HighwayConnection>();
        back.add(new HighwayConnection(2, 0, -2));
        highway6.setBackHighways(back);

        Highway highway7 = HighwayProjectUtil.createHighway(190.0, 30.0, 140.0, 30, 2, 5.0);
        highway7.setHighwayId(7);
        highways.add(highway7);
        front = new ArrayList<HighwayConnection>();
        front.add(new HighwayConnection(8, 0, -1));
        highway7.setFrontHighways(front);

        Highway highway8 = HighwayProjectUtil.createHighway(140.0, 27.5, 40.0, 27.5, 3, 5.0);
        highway8.setHighwayId(8);
        highways.add(highway8);
        front = new ArrayList<HighwayConnection>();
        front.add(new HighwayConnection(9, 1, 1));
        highway8.setFrontHighways(front);
        back = new ArrayList<HighwayConnection>();
        back.add(new HighwayConnection(7, 1, 1));
        highway8.setBackHighways(back);
        left = new ArrayList<HighwayConnection>();
        left.add(new HighwayConnection(11, 0, 0));
        highway8.setLeftHighways(left);
        right = new ArrayList<HighwayConnection>();
        right.add(new HighwayConnection(12, 2, 2));
        highway8.setRightHighways(right);

        Highway highway9 = HighwayProjectUtil.createHighway(40.0, 30.0, 0.0, 30.0, 2, 5.0);
        highway9.setHighwayId(9);
        highways.add(highway9);
        front = new ArrayList<HighwayConnection>();
        front.add(new HighwayConnection(10,0,0));
        highway9.setFrontHighways(front);
        back = new ArrayList<HighwayConnection>();
        back.add(new HighwayConnection(8, 0, -1));
        highway9.setBackHighways(back);

        Highway highway10 = HighwayProjectUtil.createHighway(0.0, 30.0, -150.0, 30.0, 2, 5.0);
        highway10.setHighwayId(10);
        highways.add(highway10);
        back = new ArrayList<HighwayConnection>();
        back.add(new HighwayConnection(9, 0, 0));
        highway10.setBackHighways(back);

        Highway highway11 = HighwayProjectUtil.createHighway(40.0, 22.5, 12.5, 0.0, 1, 5.0);
        highway11.setHighwayId(11);
        highways.add(highway11);
        front = new ArrayList<HighwayConnection>();
        front.add(new HighwayConnection(16, 0, 0));
        highway11.setFrontHighways(front);
        back = new ArrayList<HighwayConnection>();
        back.add(new HighwayConnection(8, 0, 0));
        highway11.setBackHighways(back);

        Highway highway12 = HighwayProjectUtil.createHighway(40.0, 32.5, 32.5, 40.0, 1, 5.0);
        highway12.setHighwayId(12);
        highways.add(highway12);
        front = new ArrayList<HighwayConnection>();
        front.add(new HighwayConnection(22, 0, -1));
        highway12.setFrontHighways(front);
        back = new ArrayList<HighwayConnection>();
        back.add(new HighwayConnection(8, 0, -2));
        highway12.setBackHighways(back);

        Highway highway13 = HighwayProjectUtil.createHighway(10.0, 190.0, 10.0, 140.0, 2, 5.0);
        highway13.setHighwayId(13);
        highways.add(highway13);
        front = new ArrayList<HighwayConnection>();
        front.add(new HighwayConnection(14, 0, -1));
        highway13.setFrontHighways(front);

        Highway highway14 = HighwayProjectUtil.createHighway(12.5, 140.0, 12.5, 40.0, 3, 5.0);
        highway14.setHighwayId(14);
        highways.add(highway14);
        front = new ArrayList<HighwayConnection>();
        front.add(new HighwayConnection(15, 1, 1));
        highway14.setFrontHighways(front);
        back = new ArrayList<HighwayConnection>();
        back.add(new HighwayConnection(13, 1, 1));
        highway14.setBackHighways(back);
        left = new ArrayList<HighwayConnection>();
        left.add(new HighwayConnection(17, 0, 0));
        highway14.setLeftHighways(left);
        right = new ArrayList<HighwayConnection>();
        right.add(new HighwayConnection(18, 2, 2));
        highway14.setRightHighways(right);

        Highway highway15 = HighwayProjectUtil.createHighway(10.0, 40.0, 10.0, 0.0, 2, 5.0);
        highway15.setHighwayId(15);
        highways.add(highway15);
        front = new ArrayList<HighwayConnection>();
        front.add(new HighwayConnection(16,0,0));
        highway15.setFrontHighways(front);
        back = new ArrayList<HighwayConnection>();
        back.add(new HighwayConnection(14, 0, -1));
        highway15.setBackHighways(back);

        Highway highway16 = HighwayProjectUtil.createHighway(10.0, 0.0, 10.0, -150.0, 2, 5.0);
        highway16.setHighwayId(16);
        highways.add(highway16);
        back = new ArrayList<HighwayConnection>();
        back.add(new HighwayConnection(15, 0, 0));
        highway16.setBackHighways(back);

        Highway highway17 = HighwayProjectUtil.createHighway(17.5, 40.0, 40.0, 12.5, 1, 5.0);
        highway17.setHighwayId(17);
        highways.add(highway17);
        front = new ArrayList<HighwayConnection>();
        front.add(new HighwayConnection(4, 0, 0));
        highway17.setFrontHighways(front);
        back = new ArrayList<HighwayConnection>();
        back.add(new HighwayConnection(14, 0, 0));
        highway17.setBackHighways(back);

        Highway highway18 = HighwayProjectUtil.createHighway(7.5, 40.0, 0.0, 32.5, 1, 5.0);
        highway18.setHighwayId(18);
        highways.add(highway18);
        front = new ArrayList<HighwayConnection>();
        front.add(new HighwayConnection(10, 0, -1));
        highway18.setFrontHighways(front);
        back = new ArrayList<HighwayConnection>();
        back.add(new HighwayConnection(14, 0, -2));
        highway18.setBackHighways(back);

        Highway highway19 = HighwayProjectUtil.createHighway(30.0, -150.0, 30, -100.0, 2, 5.0);
        highway19.setHighwayId(19);
        highways.add(highway19);
        front = new ArrayList<HighwayConnection>();
        front.add(new HighwayConnection(20, 0, -1));
        highway19.setFrontHighways(front);

        Highway highway20 = HighwayProjectUtil.createHighway(27.5, -100.0, 27.5, 0, 3, 5.0);
        highway20.setHighwayId(20);
        highways.add(highway20);
        front = new ArrayList<HighwayConnection>();
        front.add(new HighwayConnection(21, 1, 1));
        highway20.setFrontHighways(front);
        back = new ArrayList<HighwayConnection>();
        back.add(new HighwayConnection(19, 1, 1));
        highway20.setBackHighways(back);
        left = new ArrayList<HighwayConnection>();
        left.add(new HighwayConnection(23, 0, 0));
        highway20.setLeftHighways(left);
        right = new ArrayList<HighwayConnection>();
        right.add(new HighwayConnection(24, 2, 2));
        highway20.setRightHighways(right);

        Highway highway21 = HighwayProjectUtil.createHighway(30.0, 0.0, 30.0, 40.0, 2, 5.0);
        highway21.setHighwayId(21);
        highways.add(highway21);
        front = new ArrayList<HighwayConnection>();
        front.add(new HighwayConnection(22,0,0));
        highway21.setFrontHighways(front);
        back = new ArrayList<HighwayConnection>();
        back.add(new HighwayConnection(20, 0, -1));
        highway21.setBackHighways(back);

        Highway highway22 = HighwayProjectUtil.createHighway(30.0, 40.0, 30.0, 190.0, 2, 5.0);
        highway22.setHighwayId(22);
        highways.add(highway22);
        back = new ArrayList<HighwayConnection>();
        back.add(new HighwayConnection(21, 0, 0));
        highway22.setBackHighways(back);

        Highway highway23 = HighwayProjectUtil.createHighway(22.5, 0, 0, 27.5, 1, 5.0);
        highway23.setHighwayId(23);
        highways.add(highway23);
        front = new ArrayList<HighwayConnection>();
        front.add(new HighwayConnection(10, 0, 0));
        highway23.setFrontHighways(front);
        back = new ArrayList<HighwayConnection>();
        back.add(new HighwayConnection(20, 0, 0));
        highway23.setBackHighways(back);

        Highway highway24 = HighwayProjectUtil.createHighway(32.5, 0, 40, 7.5, 1, 5.0);
        highway24.setHighwayId(24);
        highways.add(highway24);
        front = new ArrayList<HighwayConnection>();
        front.add(new HighwayConnection(4, 0, -1));
        highway18.setFrontHighways(front);
        back = new ArrayList<HighwayConnection>();
        back.add(new HighwayConnection(20, 0, -2));
        highway18.setBackHighways(back);

        highwayProject.setHighways(highways);

        List<WifiConfiguration> wifiConfigs = new ArrayList<WifiConfiguration>();
        wifiConfigs.add(new WifiConfiguration());
        wifiConfigs.get(0).setWifiConfigId(1);
        highwayProject.setWifiConfigurations(wifiConfigs);

        List<VehicleGenerator> generators = new ArrayList<VehicleGenerator>();
        
        VehicleGenerator gen1 = new VehicleGenerator(1, 1);
        List<Destination> destinationMap = new ArrayList<Destination>();
        destinationMap.add(new Destination(0.3, 22));
        destinationMap.add(new Destination(0.3, 16));
        destinationMap.add(new Destination(0.4, 4));
        gen1.setDestinations(destinationMap);
        gen1.setLowVelocity(18.1168);
        gen1.setHighVelocity(23.1168);
        gen1.setMinGap(45.0);
        generators.add(gen1);

        VehicleGenerator gen2 = new VehicleGenerator(7, 1);
        destinationMap = new ArrayList<Destination>();
        destinationMap.add(new Destination(0.3, 16));
        destinationMap.add(new Destination(0.3, 22));
        destinationMap.add(new Destination(0.4, 10));
        gen2.setDestinations(destinationMap);
        gen2.setLowVelocity(18.1168);
        gen2.setHighVelocity(23.1168);
        gen2.setMinGap(45.0);
        generators.add(gen2);

        VehicleGenerator gen3 = new VehicleGenerator(13, 1);
        destinationMap = new ArrayList<Destination>();
        destinationMap.add(new Destination(0.3, 10));
        destinationMap.add(new Destination(0.3, 4));
        destinationMap.add(new Destination(0.4, 16));
        gen3.setDestinations(destinationMap);
        gen3.setLowVelocity(18.1168);
        gen3.setHighVelocity(23.1168);
        gen3.setMinGap(45.0);
        generators.add(gen3);

        VehicleGenerator gen4 = new VehicleGenerator(19, 1);
        destinationMap = new ArrayList<Destination>();
        destinationMap.add(new Destination(0.3, 4));
        destinationMap.add(new Destination(0.3, 10));
        destinationMap.add(new Destination(0.4, 22));
        gen4.setDestinations(destinationMap);
        gen4.setLowVelocity(18.1168);
        gen4.setHighVelocity(23.1168);
        gen4.setMinGap(45.0);
        generators.add(gen4);

        highwayProject.setVehicleGenerators(generators);

        List<TrafficLightGenerator> tlGens = new ArrayList<TrafficLightGenerator>();

        TrafficLightGenerator tlGen = new TrafficLightGenerator();
        List<TrafficPoint> tps = new ArrayList<TrafficPoint>();
        TrafficPoint leftTP = new TrafficPoint();
        leftTP.setHighwayId(2);
        leftTP.setDistance(95);
        leftTP.setSide("LEFT");
        List<Integer> turnLanes = new ArrayList<Integer>();
        turnLanes.add(1);
        leftTP.setLeftTurnLanes(turnLanes);
        tps.add(leftTP);
        TrafficPoint rightTP = new TrafficPoint();
        rightTP.setHighwayId(8);
        rightTP.setDistance(95);
        rightTP.setSide("RIGHT");
        turnLanes = new ArrayList<Integer>();
        turnLanes.add(1);
        rightTP.setLeftTurnLanes(turnLanes);
        tps.add(rightTP);
        TrafficPoint topTP = new TrafficPoint();
        topTP.setHighwayId(14);
        topTP.setDistance(95);
        topTP.setSide("TOP");
        turnLanes = new ArrayList<Integer>();
        turnLanes.add(1);
        topTP.setLeftTurnLanes(turnLanes);
        tps.add(topTP);
        TrafficPoint bottomTP = new TrafficPoint();
        bottomTP.setHighwayId(20);
        bottomTP.setDistance(95);
        bottomTP.setSide("BOTTOM");
        turnLanes = new ArrayList<Integer>();
        turnLanes.add(1);
        bottomTP.setLeftTurnLanes(turnLanes);
        tps.add(bottomTP);

        tlGen.setTrafficPoints(tps);
        tlGen.setTimeBuffer(5.0);
        tlGen.setTimeLeft(20.0);
        tlGen.setTimeStraight(40.0);

        tlGens.add(tlGen);

        highwayProject.setTrafficLightGenerators(tlGens);
        */

        HighwayProject highwayProject = new HighwayProject();

        Highway highway1 = new Highway();
        highway1.setStartX(0.0);
        highway1.setStartY(5.0);
        highway1.setDirection(0.0);
        highway1.setLength(1000.0);

        List<Highway> highways = new ArrayList<Highway>();
        highways.add(highway1);

        highwayProject.setHighways(highways);

        XStream xs = new XStream();
        xs.processAnnotations(HighwayProject.class);
        xs.processAnnotations(Highway.class);
        xs.processAnnotations(HighwayConnection.class);
        xs.processAnnotations(VehicleGenerator.class);
        xs.processAnnotations(WifiConfiguration.class);
        xs.processAnnotations(TrafficLightGenerator.class);
        System.out.println(xs.toXML(highwayProject));
    }

}
