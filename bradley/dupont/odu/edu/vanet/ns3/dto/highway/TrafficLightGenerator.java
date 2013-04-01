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
@XStreamAlias("trafficGenerator")
public class TrafficLightGenerator {

    @XStreamAsAttribute
    private double timeLeft;
    @XStreamAsAttribute
    private double timeStraight;
    @XStreamAsAttribute
    private double timeBuffer;
    @XStreamImplicit(itemFieldName="trafficPoint")
    private List<TrafficPoint> trafficPoints;

    public TrafficLightGenerator() {
    }

    public List<TrafficPoint> getTrafficPoints() {
        return trafficPoints;
    }

    public void setTrafficPoints(List<TrafficPoint> trafficPoints) {
        this.trafficPoints = trafficPoints;
    }

    public double getTimeBuffer() {
        return timeBuffer;
    }

    public void setTimeBuffer(double timeBuffer) {
        this.timeBuffer = timeBuffer;
    }

    public double getTimeLeft() {
        return timeLeft;
    }

    public void setTimeLeft(double timeLeft) {
        this.timeLeft = timeLeft;
    }

    public double getTimeStraight() {
        return timeStraight;
    }

    public void setTimeStraight(double timeStraight) {
        this.timeStraight = timeStraight;
    }

}
