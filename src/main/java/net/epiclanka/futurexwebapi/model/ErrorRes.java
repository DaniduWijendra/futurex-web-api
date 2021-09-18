package net.epiclanka.futurexwebapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ErrorRes {
    private String AO;
    private String AM;
    private String AN;
    private String BB;
    private String messageType;
    private String messageId;
    private String messageDescription;

    public String getAO() {
        return AO;
    }

    @JsonProperty("AO")
    public void setAO(String AO) {
        this.AO = AO;
    }

    public String getAM() {
        return AM;
    }

    @JsonProperty("AM")
    public void setAM(String AM) {
        this.AM = AM;
    }

    public String getAN() {
        return AN;
    }

    @JsonProperty("AN")
    public void setAN(String AN) {
        this.AN = AN;
    }

    public String getBB() {
        return BB;
    }

    @JsonProperty("BB")
    public void setBB(String BB) {
        this.BB = BB;
    }

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public String getMessageDescription() {
        return messageDescription;
    }

    public void setMessageDescription(String messageDescription) {
        this.messageDescription = messageDescription;
    }

    @Override
    public String toString() {
        return "ErrorRes{" +
                "AO='" + AO + '\'' +
                ", AM='" + AM + '\'' +
                ", AN='" + AN + '\'' +
                ", BB='" + BB + '\'' +
                ", messageType='" + messageType + '\'' +
                ", messageId='" + messageId + '\'' +
                ", messageDescription='" + messageDescription + '\'' +
                '}';
    }
}
