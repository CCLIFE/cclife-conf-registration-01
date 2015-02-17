/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cclife.registration.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ephesus
 */
@Entity
@Table(name = "profile", catalog = "cccmdb1", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Profile.findAll", query = "SELECT p FROM Profile p"),
    @NamedQuery(name = "Profile.findByPersonID", query = "SELECT p FROM Profile p WHERE p.personID = :personID"),
    @NamedQuery(name = "Profile.findByLeader", query = "SELECT p FROM Profile p WHERE p.leader = :leader"),
    @NamedQuery(name = "Profile.findByDecision", query = "SELECT p FROM Profile p WHERE p.decision = :decision"),
    @NamedQuery(name = "Profile.findBySeeker", query = "SELECT p FROM Profile p WHERE p.seeker = :seeker"),
    @NamedQuery(name = "Profile.findByChurchID", query = "SELECT p FROM Profile p WHERE p.churchID = :churchID"),
    @NamedQuery(name = "Profile.findByRoomID", query = "SELECT p FROM Profile p WHERE p.roomID = :roomID"),
    @NamedQuery(name = "Profile.findByGroupID", query = "SELECT p FROM Profile p WHERE p.groupID = :groupID"),
    @NamedQuery(name = "Profile.findByComments", query = "SELECT p FROM Profile p WHERE p.comments = :comments"),
    @NamedQuery(name = "Profile.findByCheckIn", query = "SELECT p FROM Profile p WHERE p.checkIn = :checkIn"),
    @NamedQuery(name = "Profile.findByCheckInDate", query = "SELECT p FROM Profile p WHERE p.checkInDate = :checkInDate"),
    @NamedQuery(name = "Profile.findByCheckOut", query = "SELECT p FROM Profile p WHERE p.checkOut = :checkOut"),
    @NamedQuery(name = "Profile.findByCheckOutDate", query = "SELECT p FROM Profile p WHERE p.checkOutDate = :checkOutDate"),
    @NamedQuery(name = "Profile.findByRegisteredDate", query = "SELECT p FROM Profile p WHERE p.registeredDate = :registeredDate"),
    @NamedQuery(name = "Profile.findByNametag", query = "SELECT p FROM Profile p WHERE p.nametag = :nametag"),
    @NamedQuery(name = "Profile.findByArchive", query = "SELECT p FROM Profile p WHERE p.archive = :archive"),
    @NamedQuery(name = "Profile.findByPreferredLanguage", query = "SELECT p FROM Profile p WHERE p.preferredLanguage = :preferredLanguage"),
    @NamedQuery(name = "Profile.findByFaithYear", query = "SELECT p FROM Profile p WHERE p.faithYear = :faithYear"),
    @NamedQuery(name = "Profile.findByWorkshop", query = "SELECT p FROM Profile p WHERE p.workshop = :workshop"),
    @NamedQuery(name = "Profile.findByWorkshop1", query = "SELECT p FROM Profile p WHERE p.workshop1 = :workshop1"),
    @NamedQuery(name = "Profile.findByWorkshop2", query = "SELECT p FROM Profile p WHERE p.workshop2 = :workshop2"),
    @NamedQuery(name = "Profile.findByLastModified", query = "SELECT p FROM Profile p WHERE p.lastModified = :lastModified")})
public class Profile implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "PersonID", nullable = false)
    private Integer personID;
    @Column(name = "Leader")
    private Boolean leader;
    @Column(name = "Decision")
    private Boolean decision;
    @Column(name = "Seeker")
    private Boolean seeker;
    @Column(name = "ChurchID")
    private Integer churchID;
    @Column(name = "RoomID", length = 10)
    private String roomID;
    @Column(name = "GroupID")
    private Integer groupID;
    @Column(name = "Comments", length = 255)
    private String comments;
    @Column(name = "CheckIn")
    private Boolean checkIn;
    @Column(name = "CheckInDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date checkInDate;
    @Column(name = "CheckOut")
    private Boolean checkOut;
    @Column(name = "CheckOutDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date checkOutDate;
    @Column(name = "RegisteredDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date registeredDate;
    @Column(name = "Nametag")
    private Boolean nametag;
    @Column(name = "Archive")
    private Boolean archive;
    @Column(name = "PreferredLanguage", length = 50)
    private String preferredLanguage;
    @Column(name = "FaithYear")
    private Integer faithYear;
    @Column(name = "Workshop")
    private Boolean workshop;
    @Column(name = "Workshop1", length = 5)
    private String workshop1;
    @Column(name = "Workshop2", length = 5)
    private String workshop2;
    @Basic(optional = false)
    @Column(name = "LastModified", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModified;

    public Profile() {
    }

    public Profile(Integer personID) {
        this.personID = personID;
    }

    public Profile(Integer personID, Date lastModified) {
        this.personID = personID;
        this.lastModified = lastModified;
    }

    public Integer getPersonID() {
        return personID;
    }

    public void setPersonID(Integer personID) {
        this.personID = personID;
    }

    public Boolean getLeader() {
        return leader;
    }

    public void setLeader(Boolean leader) {
        this.leader = leader;
    }

    public Boolean getDecision() {
        return decision;
    }

    public void setDecision(Boolean decision) {
        this.decision = decision;
    }

    public Boolean getSeeker() {
        return seeker;
    }

    public void setSeeker(Boolean seeker) {
        this.seeker = seeker;
    }

    public Integer getChurchID() {
        return churchID;
    }

    public void setChurchID(Integer churchID) {
        this.churchID = churchID;
    }

    public String getRoomID() {
        return roomID;
    }

    public void setRoomID(String roomID) {
        this.roomID = roomID;
    }

    public Integer getGroupID() {
        return groupID;
    }

    public void setGroupID(Integer groupID) {
        this.groupID = groupID;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Boolean getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(Boolean checkIn) {
        this.checkIn = checkIn;
    }

    public Date getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(Date checkInDate) {
        this.checkInDate = checkInDate;
    }

    public Boolean getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(Boolean checkOut) {
        this.checkOut = checkOut;
    }

    public Date getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(Date checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public Date getRegisteredDate() {
        return registeredDate;
    }

    public void setRegisteredDate(Date registeredDate) {
        this.registeredDate = registeredDate;
    }

    public Boolean getNametag() {
        return nametag;
    }

    public void setNametag(Boolean nametag) {
        this.nametag = nametag;
    }

    public Boolean getArchive() {
        return archive;
    }

    public void setArchive(Boolean archive) {
        this.archive = archive;
    }

    public String getPreferredLanguage() {
        return preferredLanguage;
    }

    public void setPreferredLanguage(String preferredLanguage) {
        this.preferredLanguage = preferredLanguage;
    }

    public Integer getFaithYear() {
        return faithYear;
    }

    public void setFaithYear(Integer faithYear) {
        this.faithYear = faithYear;
    }

    public Boolean getWorkshop() {
        return workshop;
    }

    public void setWorkshop(Boolean workshop) {
        this.workshop = workshop;
    }

    public String getWorkshop1() {
        return workshop1;
    }

    public void setWorkshop1(String workshop1) {
        this.workshop1 = workshop1;
    }

    public String getWorkshop2() {
        return workshop2;
    }

    public void setWorkshop2(String workshop2) {
        this.workshop2 = workshop2;
    }

    public Date getLastModified() {
        return lastModified;
    }

    public void setLastModified(Date lastModified) {
        this.lastModified = lastModified;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (personID != null ? personID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Profile)) {
            return false;
        }
        Profile other = (Profile) object;
        if ((this.personID == null && other.personID != null) || (this.personID != null && !this.personID.equals(other.personID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ws.cccm.model.Profile[ personID=" + personID + " ]";
    }
    
}
