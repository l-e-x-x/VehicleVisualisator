/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bradley.dupont.odu.edu.vanet.ns3.dto.highway;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamImplicit;
import java.util.List;

/**
 *
 * @author bdupont
 */
@XStreamAlias("trafficPoint")
public class TrafficPoint {

    @XStreamAsAttribute
    private String side;
    @XStreamAsAttribute
    private int highwayId;
    @XStreamAsAttribute
    private double distance;
    @XStreamImplicit(itemFieldName="leftTurnLane")
    private List<Integer> leftTurnLanes;

    public TrafficPoint() {
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public int getHighwayId() {
        return highwayId;
    }

    public void setHighwayId(int highwayId) {
        this.highwayId = highwayId;
    }

    public List<Integer> getLeftTurnLanes() {
        return leftTurnLanes;
    }

    public void setLeftTurnLanes(List<Integer> leftTurnLanes) {
        this.leftTurnLanes = leftTurnLanes;
    }

    public String getSide() {
        return side;
    }

    public void setSide(String side) {
        this.side = side;
    }

}
