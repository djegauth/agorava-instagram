package org.agorava.instagram.model;

/**
 * User: Dje
 * Date: 21/04/13
 * Time: 00:02
 */
public class Relationship {

    private final String outgoingStatus;
    private final String incomingStatus;

    public Relationship(String incomingStatus, String outgoingStatus) {
        this.incomingStatus = incomingStatus;
        this.outgoingStatus = outgoingStatus;
    }

    public String getIncomingStatus() {
        return incomingStatus;
    }

    public String getOutgoingStatus() {
        return outgoingStatus;
    }
}
