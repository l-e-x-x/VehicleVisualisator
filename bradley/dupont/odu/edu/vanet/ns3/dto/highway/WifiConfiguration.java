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
@XStreamAlias("wifiConfiguration")
public class WifiConfiguration {

    public static final String WIFI_PHY_STANDARD_80211a = "WIFI_PHY_STANDARD_80211a";

    @XStreamAsAttribute
    private int wifiConfigId;
    @XStreamAsAttribute
    private String wifiStandard;
    @XStreamAsAttribute
    private String dataMode;
    @XStreamAsAttribute
    private double txPowerStart;
    @XStreamAsAttribute
    private double txPowerEnd;
    @XStreamAsAttribute
    private int txPowerLevels;
    @XStreamAsAttribute
    private double txGain;
    @XStreamAsAttribute
    private double rxGain;
    @XStreamAsAttribute
    private double energyDetectionThreshold;

    public WifiConfiguration() {
        wifiStandard = WIFI_PHY_STANDARD_80211a;
        dataMode = "OfdmRate6MbpsBW10MHz";
        txPowerStart = 21.5;
        txPowerEnd = 21.5;
        txPowerLevels = 1;
        txGain = 2.0;
        rxGain = 2.0;
        energyDetectionThreshold = -101.0;
    }

    public String getDataMode() {
        return dataMode;
    }

    public void setDataMode(String dataMode) {
        this.dataMode = dataMode;
    }

    public double getEnergyDetectionThreshold() {
        return energyDetectionThreshold;
    }

    public void setEnergyDetectionThreshold(double energyDetectionThreshold) {
        this.energyDetectionThreshold = energyDetectionThreshold;
    }

    public double getRxGain() {
        return rxGain;
    }

    public void setRxGain(double rxGain) {
        this.rxGain = rxGain;
    }

    public double getTxGain() {
        return txGain;
    }

    public void setTxGain(double txGain) {
        this.txGain = txGain;
    }

    public double getTxPowerEnd() {
        return txPowerEnd;
    }

    public void setTxPowerEnd(double txPowerEnd) {
        this.txPowerEnd = txPowerEnd;
    }

    public int getTxPowerLevels() {
        return txPowerLevels;
    }

    public void setTxPowerLevels(int txPowerLevels) {
        this.txPowerLevels = txPowerLevels;
    }

    public double getTxPowerStart() {
        return txPowerStart;
    }

    public void setTxPowerStart(double txPowerStart) {
        this.txPowerStart = txPowerStart;
    }

    public int getWifiConfigId() {
        return wifiConfigId;
    }

    public void setWifiConfigId(int wifiConfigId) {
        this.wifiConfigId = wifiConfigId;
    }

    public String getWifiStandard() {
        return wifiStandard;
    }

    public void setWifiStandard(String wifiStandard) {
        this.wifiStandard = wifiStandard;
    }

}
