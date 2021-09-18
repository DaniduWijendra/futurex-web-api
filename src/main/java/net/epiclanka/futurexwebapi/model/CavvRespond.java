package net.epiclanka.futurexwebapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CavvRespond {
    private String AO;
    private String FC;
    private String KX;
    private String KZ;

    public String getAO() {
        return AO;
    }
@JsonProperty("AO")
    public void setAO(String AO) {
        this.AO = AO;
    }

    public String getFC() {
        return FC;
    }
@JsonProperty("FC")
    public void setFC(String FC) {
        this.FC = FC;
    }

    public String getKX() {
        return KX;
    }
@JsonProperty("KX")
    public void setKX(String KX) {
        this.KX = KX;
    }

    public String getKZ() {
        return KZ;
    }
@JsonProperty("KZ")
    public void setKZ(String KZ) {
        this.KZ = KZ;
    }

    @Override
    public String toString() {
        return "CavvRespond{" +
                "AO='" + AO + '\'' +
                ", FC='" + FC + '\'' +
                ", KX='" + KX + '\'' +
                ", KZ='" + KZ + '\'' +
                '}';
    }
}
