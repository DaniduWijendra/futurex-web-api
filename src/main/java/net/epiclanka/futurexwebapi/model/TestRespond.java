package net.epiclanka.futurexwebapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TestRespond {
    private String AG;
    private String AO;
    private String BC;

    public String getAG() {
        return AG;
    }

    @JsonProperty("AG")
    public void setAG(String AG) {
        this.AG = AG;
    }

    public String getAO() {
        return AO;
    }

    @JsonProperty("AO")
    public void setAO(String AO) {
        this.AO = AO;
    }

    public String getBC() {
        return BC;
    }
    @JsonProperty("BC")
    public void setBC(String BC) {
        this.BC = BC;
    }

    @Override
    public String toString() {
        return "TestRespond {" +
                "AG='" + AG + '\'' +
                ", AO='" + AO + '\'' +
                ", BC='" + BC + '\'' +
                '}';
    }
}
