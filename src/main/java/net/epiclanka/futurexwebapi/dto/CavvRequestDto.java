package net.epiclanka.futurexwebapi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;

public class CavvRequestDto {
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

    public CavvRequestDto() {
    }

    public String getAO() {
        return AO;
    }

    @JsonProperty("AO")
    public void setAO(String AO) {
        this.AO = AO;
    }

    public String getCA() {
        return CA;
    }

    @JsonProperty("CA")
    public void setCA(String CA) {
        this.CA = CA;
    }

    public String getBZ() {
        return BZ;
    }

    @JsonProperty("BZ")
    public void setBZ(String BZ) {
        this.BZ = BZ;
    }

    public String getKR() {
        return KR;
    }

    @JsonProperty("KR")
    public void setKR(String KR) {
        this.KR = KR;
    }

    public String getKS() {
        return KS;
    }

    @JsonProperty("KS")
    public void setKS(String KS) {
        this.KS = KS;
    }

    public String getKU() {
        return KU;
    }

    @JsonProperty("KU")
    public void setKU(String KU) {
        this.KU = KU;
    }
}
