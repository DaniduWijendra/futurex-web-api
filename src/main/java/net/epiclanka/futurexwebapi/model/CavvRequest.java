package net.epiclanka.futurexwebapi.model;


import javax.validation.constraints.NotBlank;

public class CavvRequest {
    @NotBlank
    private String AO;
    @NotBlank
    private String CA;
    @NotBlank
    private String BZ;
    @NotBlank
    private String KR;
    @NotBlank
    private String KU;
    @NotBlank
    private String KS;

    public String getAO() {
        return AO;
    }

    public void setAO(String AO) {
        this.AO = AO;
    }

    public String getCA() {
        return CA;
    }

    public void setCA(String CA) {
        this.CA = CA;
    }

    public String getBZ() {
        return BZ;
    }

    public void setBZ(String BZ) {
        this.BZ = BZ;
    }

    public String getKR() {
        return KR;
    }

    public void setKR(String KR) {
        this.KR = KR;
    }

    public String getKU() {
        return KU;
    }

    public void setKU(String KU) {
        this.KU = KU;
    }

    public String getKS() {
        return KS;
    }

    public void setKS(String KS) {
        this.KS = KS;
    }

    public CavvRequest() {
    }

    @Override
    public String toString() {
        return "CavvRequest{" +
                "AO='" + AO + '\'' +
                ", CA='" + CA + '\'' +
                ", BZ='" + BZ + '\'' +
                ", KR='" + KR + '\'' +
                ", KU='" + KU + '\'' +
                ", KS='" + KS + '\'' +
                '}';
    }
}
