package org.agorava.instagram.model;

import com.google.common.base.Objects;

/**
 * User: Dje
 * Date: 21/04/13
 * Time: 00:02
 */
public class Relationship {

    private final String outgoingStatus;
    private final boolean privateUser;
    private String incomingStatus;

    public Relationship(String outgoingStatus, boolean privateUser) {
        this.outgoingStatus = outgoingStatus;
        this.privateUser = privateUser;
    }

    public String getOutgoingStatus() {
        return outgoingStatus;
    }

    public boolean isPrivateUser() {
        return privateUser;
    }

    public String getIncomingStatus() {
        return incomingStatus;
    }

    public void setIncomingStatus(String incomingStatus) {
        this.incomingStatus = incomingStatus;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("incomingStatus", incomingStatus)
                .add("outgoingStatus", outgoingStatus)
                .toString();
    }
}
