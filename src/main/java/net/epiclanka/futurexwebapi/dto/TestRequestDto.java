package net.epiclanka.futurexwebapi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TestRequestDto {
    private String AO;
    private String AG;

    public String getAO() {
        return AO;
    }

    @JsonProperty("AO")
    public void setAO(String AO) {
        this.AO = AO;
    }

    public String getAG() {
        return AG;
    }

    @JsonProperty("AG")
    public void setAG(String AG) {
        this.AG = AG;
    }

    @Override
    public String toString() {
        return "TestRequest {" +
                "AO='" + AO + '\'' +
                ", AG='" + AG + '\'' +
                '}';
    }
}
