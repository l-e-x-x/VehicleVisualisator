/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bradley.dupont.odu.edu.vanet.ns3.dto;

import java.awt.geom.Point2D;
import java.awt.geom.Point2D.Double;

/**
 *
 * @author bdupont
 */
public class VehicleLocation {

    private int vehicleId;
    private int vehicleType;
    private Point2D.Double location;
    private double direction;
    private double velocity;
    private double acceleration;

    public VehicleLocation() {
    }

    public VehicleLocation(int vehicleId, int vehicleType, Double location, double direction, double velocity, double acceleration) {
        this.vehicleId = vehicleId;
        this.vehicleType = vehicleType;
        this.direction = direction;
        this.location = location;
        this.velocity = velocity;
        this.acceleration = acceleration;
    }

    public double getAcceleration() {
        return acceleration;
    }

    public void setAcceleration(double acceleration) {
        this.acceleration = acceleration;
    }

    public Point2D.Double getLocation() {
        return location;
    }

    public void setLocation(Point2D.Double location) {
        this.location = location;
    }

    public double getDirection() {
        return direction;
    }

    public void setDirection(double direction) {
        this.direction = direction;
    }

    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    public int getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(int vehicleType) {
        this.vehicleType = vehicleType;
    }

    public double getVelocity() {
        return velocity;
    }

    public void setVelocity(double velocity) {
        this.velocity = velocity;
    }


}
