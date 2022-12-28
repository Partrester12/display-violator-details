package org.tn.model;


import javax.xml.datatype.XMLGregorianCalendar;

public class violatorDetails{



    private double closestDistance;

    private XMLGregorianCalendar lastSeen;

    private String pilotName;

    private String pilotEmail;

    private String phoneNumber;

    public violatorDetails(double closestDistance, XMLGregorianCalendar lastSeen, String pilotName, String pilotEmail, String phoneNumber) {
        this.closestDistance = closestDistance;
        this.lastSeen = lastSeen;
        this.pilotName = pilotName;
        this.pilotEmail = pilotEmail;
        this.phoneNumber = phoneNumber;
    }

    //Alternative constructor used when no information about the droneOwner can be received from the device
    public violatorDetails(double closestDistance, XMLGregorianCalendar lastSeen){
        this.closestDistance = closestDistance;
        this.lastSeen = lastSeen;
        pilotName = "Unknown";
        pilotEmail = "Unknown";
        phoneNumber = "Unknown";
    }

    public double getClosestDistance() {
        return closestDistance;
    }

    public void setClosestDistance(double closestDistance) {
        this.closestDistance = closestDistance;
    }

    public XMLGregorianCalendar getLastSeen() {
        return lastSeen;
    }

    public void setLastSeen(XMLGregorianCalendar lastSeen) {
        this.lastSeen = lastSeen;
    }

    public String getPilotName() {
        return pilotName;
    }

    public void setPilotName(String pilotName) {
        this.pilotName = pilotName;
    }

    public String getPilotEmail() {
        return pilotEmail;
    }

    public void setPilotEmail(String pilotEmail) {
        this.pilotEmail = pilotEmail;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

}


