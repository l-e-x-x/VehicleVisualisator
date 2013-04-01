/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bradley.dupont.odu.edu.vanet.ns3.dto.highway;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

/**
 *
 * @author bdupont
 */
@XStreamAlias("destination")
public class Destination {

    @XStreamAsAttribute
    private Double weight;
    @XStreamAsAttribute
    private Integer destinationId;

    public Destination(Double weight, Integer destination) {
        this.weight = weight;
        this.destinationId = destination;
    }

    public Integer getDestinationId() {
        return destinationId;
    }

    public void setDestinationId(Integer destinationId) {
        this.destinationId = destinationId;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

}
