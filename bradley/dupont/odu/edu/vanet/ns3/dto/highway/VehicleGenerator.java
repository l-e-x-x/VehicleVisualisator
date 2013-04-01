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
@XStreamAlias("vehicleGenerator")
public class VehicleGenerator {
    
    @XStreamAsAttribute
    private int highwayId;
    @XStreamAsAttribute
    private int wifiConfigId;
    @XStreamAsAttribute
    private double flow;
    @XStreamAsAttribute
    private double lowVelocity;
    @XStreamAsAttribute
    private double highVelocity;
    @XStreamAsAttribute
    private double minGap;
    @XStreamAsAttribute
    private double penetrationRate;
    @XStreamImplicit(itemFieldName="destination")
    private List<Destination> destinations;

    public VehicleGenerator(int highwayId, int wifiConfigId) {
        this.highwayId = highwayId;
        this.wifiConfigId = wifiConfigId;
        flow = 1.0;
        lowVelocity = highVelocity = 11.176;
        minGap = 33.0;
        penetrationRate = 100.0;
    }

    public double getFlow() {
        return flow;
    }

    public void setFlow(double flow) {
        this.flow = flow;
    }

    public int getHighwayId() {
        return highwayId;
    }

    public int getWifiConfigId() {
        return wifiConfigId;
    }

    public double getMinGap() {
        return minGap;
    }

    public void setMinGap(double minGap) {
        this.minGap = minGap;
    }

    public double getPenetrationRate() {
        return penetrationRate;
    }

    public void setPenetrationRate(double penetrationRate) {
        this.penetrationRate = penetrationRate;
    }

    public double getLowVelocity() {
        return lowVelocity;
    }

    public void setLowVelocity(double lowVelocity) {
        this.lowVelocity = lowVelocity;
    }

    public double getHighVelocity() {
        return highVelocity;
    }

    public void setHighVelocity(double highVelocity) {
        this.highVelocity = highVelocity;
    }

    public List<Destination> getDestinations() {
        return destinations;
    }

    public void setDestinations(List<Destination> destinations) {
        this.destinations = destinations;
    }

}
