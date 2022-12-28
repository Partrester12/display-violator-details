package org.tn.model;

/**
 * Class that represents all the necessary information linked to a specific drone
 */
public class droneOwnerDetails {

    protected String pilotId;
    protected String firstName;
    protected String lastName;
    protected String phoneNumber;
    protected String createdDt;
    protected String email;

    public droneOwnerDetails(String pilotId, String firstName, String lastName, String phoneNumber, String createdDt, String email) {
        this.pilotId = pilotId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.createdDt = createdDt;
        this.email = email;
    }

    public String getPilotId() {
        return pilotId;
    }

    public void setPilotId(String pilotId) {
        this.pilotId = pilotId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCreatedDt() {
        return createdDt;
    }

    public void setCreatedDt(String createdDt) {
        this.createdDt = createdDt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }




}
