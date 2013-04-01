/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bradley.dupont.odu.edu.vanet.ns3.dto.highway.utility;

import bradley.dupont.odu.edu.vanet.ns3.dto.highway.Highway;

/**
 *
 * @author bdupont
 */
public class HighwayProjectUtil {

    public enum JoinType {
        STRAIGHT, LEFT, RIGHT
    }

    public static Highway createHighway(double startX, double startY, double endX, double endY, int numberOfLanes, double laneWidth) {
        Highway highway = new Highway();
        highway.setStartX(startX);
        highway.setStartY(startY);
        highway.setDirection(Geometry.angleToPoint(startX, startY, endX, endY));
        highway.setLength(Geometry.directDistance(startX, startY, endX, endY));
        highway.setNumberOfLanes(numberOfLanes);
        highway.setLaneWidth(laneWidth);
        return highway;
    }

    public static Highway createHighway(Highway startHighway, double direction, double length, int numberOfLanes, double laneWidth, int laneOffset) {
        Highway highway = new Highway();
        highway.setNumberOfLanes(numberOfLanes);
        double[] result = new double[2];
        result[0] = startHighway.getStartX();
        result[1] = startHighway.getStartY();
        Geometry.translatePoint(result, startHighway.getDirection(), startHighway.getLength());
        if(numberOfLanes == startHighway.getNumberOfLanes() && laneOffset == 0) {
            highway.setStartX(result[0]);
            highway.setStartY(result[1]);
        } else {

        }


        return highway;
    }

    public static Highway createJoinHighway(Highway start, Highway end, int startLane, int endLane, int numberOfLanes, double laneWidth, JoinType type) {
        Highway highway = new Highway();

        return highway;
    }

}
