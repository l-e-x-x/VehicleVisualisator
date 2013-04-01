/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bradley.dupont.odu.edu.vanet.ns3.dto.highway;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import java.util.List;

/**
 *
 * @author bdupont
 */
@XStreamAlias("highway")
public class Highway {

    @XStreamAsAttribute
    private int highwayId;
    @XStreamAsAttribute
    private int numberOfLanes;
    @XStreamAsAttribute
    private double direction;
    @XStreamAsAttribute
    private double length;
    @XStreamAsAttribute
    private double startX;
    @XStreamAsAttribute
    private double startY;
    @XStreamAsAttribute
    private double leftTurnSpeed;
    @XStreamAsAttribute
    private double rightTurnSpeed;
    @XStreamAsAttribute
    private double laneWidth;
    private List<HighwayConnection> frontHighways;
    private List<HighwayConnection> backHighways;
    private List<HighwayConnection> rightHighways;
    private List<HighwayConnection> leftHighways;

    public Highway() {
        laneWidth = 5.0;
        leftTurnSpeed = 2.2352;
        rightTurnSpeed = 2.2352;
    }

    public List<HighwayConnection> getBackHighways() {
        return backHighways;
    }

    public void setBackHighways(List<HighwayConnection> backHighways) {
        this.backHighways = backHighways;
    }

    public double getDirection() {
        return direction;
    }

    public void setDirection(double direction) {
        this.direction = direction;
    }

    public List<HighwayConnection> getFrontHighways() {
        return frontHighways;
    }

    public void setFrontHighways(List<HighwayConnection> frontHighways) {
        this.frontHighways = frontHighways;
    }

    public int getHighwayId() {
        return highwayId;
    }

    public void setHighwayId(int highwayId) {
        this.highwayId = highwayId;
    }

    public List<HighwayConnection> getLeftHighways() {
        return leftHighways;
    }

    public void setLeftHighways(List<HighwayConnection> leftHighways) {
        this.leftHighways = leftHighways;
    }

    public double getLeftTurnSpeed() {
        return leftTurnSpeed;
    }

    public void setLeftTurnSpeed(double leftTurnSpeed) {
        this.leftTurnSpeed = leftTurnSpeed;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public int getNumberOfLanes() {
        return numberOfLanes;
    }

    public void setNumberOfLanes(int numberOfLanes) {
        this.numberOfLanes = numberOfLanes;
    }

    public List<HighwayConnection> getRightHighways() {
        return rightHighways;
    }

    public void setRightHighways(List<HighwayConnection> rightHighways) {
        this.rightHighways = rightHighways;
    }

    public double getRightTurnSpeed() {
        return rightTurnSpeed;
    }

    public void setRightTurnSpeed(double rightTurnSpeed) {
        this.rightTurnSpeed = rightTurnSpeed;
    }

    public double getStartX() {
        return startX;
    }

    public void setStartX(double startX) {
        this.startX = startX;
    }

    public double getStartY() {
        return startY;
    }

    public void setStartY(double startY) {
        this.startY = startY;
    }

    public double getLaneWidth() {
        return laneWidth;
    }

    public void setLaneWidth(double laneWidth) {
        this.laneWidth = laneWidth;
    }

}
