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
@XStreamAlias("highwayConnection")
public class HighwayConnection {

    @XStreamAsAttribute
    private int highwayId;
    @XStreamAsAttribute
    private int laneOffset;
    @XStreamAsAttribute
    private int offset;

    public HighwayConnection() {
    }

    public HighwayConnection(int highwayId, int laneOffset, int offset) {
        this.highwayId = highwayId;
        this.laneOffset = laneOffset;
        this.offset = offset;
    }

    public int getHighwayId() {
        return highwayId;
    }

    public void setHighwayId(int highwayId) {
        this.highwayId = highwayId;
    }

    public int getLaneOffset() {
        return laneOffset;
    }

    public void setLaneOffset(int laneOffset) {
        this.laneOffset = laneOffset;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

}
