/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws.cccm.application.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "person", catalog = "cccmdb", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Person.findAll", query = "SELECT p FROM Person p"),
    @NamedQuery(name = "Person.findByPersonID", query = "SELECT p FROM Person p WHERE p.personID = :personID"),
    @NamedQuery(name = "Person.findByFamilyID", query = "SELECT p FROM Person p WHERE p.familyID = :familyID"),
    @NamedQuery(name = "Person.findByChurchID", query = "SELECT p FROM Person p WHERE p.churchID = :churchID"),
    @NamedQuery(name = "Person.findByTitle", query = "SELECT p FROM Person p WHERE p.title = :title"),
    @NamedQuery(name = "Person.findByLastName", query = "SELECT p FROM Person p WHERE p.lastName = :lastName"),
    @NamedQuery(name = "Person.findByFirstName", query = "SELECT p FROM Person p WHERE p.firstName = :firstName"),
    @NamedQuery(name = "Person.findByChineseName", query = "SELECT p FROM Person p WHERE p.chineseName = :chineseName"),
    @NamedQuery(name = "Person.findByGender", query = "SELECT p FROM Person p WHERE p.gender = :gender"),
    @NamedQuery(name = "Person.findByAge", query = "SELECT p FROM Person p WHERE p.age = :age"),
    @NamedQuery(name = "Person.findByStatus", query = "SELECT p FROM Person p WHERE p.status = :status"),
    @NamedQuery(name = "Person.findByRelationship", query = "SELECT p FROM Person p WHERE p.relationship = :relationship"),
    @NamedQuery(name = "Person.findByServingRole", query = "SELECT p FROM Person p WHERE p.servingRole = :servingRole"),
    @NamedQuery(name = "Person.findByBaptized", query = "SELECT p FROM Person p WHERE p.baptized = :baptized"),
    @NamedQuery(name = "Person.findByBaptizedDate", query = "SELECT p FROM Person p WHERE p.baptizedDate = :baptizedDate"),
    @NamedQuery(name = "Person.findByPrc", query = "SELECT p FROM Person p WHERE p.prc = :prc"),
    @NamedQuery(name = "Person.findByCommitServe", query = "SELECT p FROM Person p WHERE p.commitServe = :commitServe"),
    @NamedQuery(name = "Person.findByWillingToAttendCCCMTraining", query = "SELECT p FROM Person p WHERE p.willingToAttendCCCMTraining = :willingToAttendCCCMTraining"),
    @NamedQuery(name = "Person.findByWillingToBeVolunteer", query = "SELECT p FROM Person p WHERE p.willingToBeVolunteer = :willingToBeVolunteer"),
    @NamedQuery(name = "Person.findByVolunteerCode", query = "SELECT p FROM Person p WHERE p.volunteerCode = :volunteerCode"),
    @NamedQuery(name = "Person.findByPhone", query = "SELECT p FROM Person p WHERE p.phone = :phone"),
    @NamedQuery(name = "Person.findByCellPhone", query = "SELECT p FROM Person p WHERE p.cellPhone = :cellPhone"),
    @NamedQuery(name = "Person.findByWorkPhone", query = "SELECT p FROM Person p WHERE p.workPhone = :workPhone"),
    @NamedQuery(name = "Person.findByEmail", query = "SELECT p FROM Person p WHERE p.email = :email"),
    @NamedQuery(name = "Person.findByLanguage", query = "SELECT p FROM Person p WHERE p.language = :language"),
    @NamedQuery(name = "Person.findByLoginID", query = "SELECT p FROM Person p WHERE p.loginID = :loginID"),
    @NamedQuery(name = "Person.findByPassword", query = "SELECT p FROM Person p WHERE p.password = :password"),
    @NamedQuery(name = "Person.findByFamilyAdmin", query = "SELECT p FROM Person p WHERE p.familyAdmin = :familyAdmin"),
    @NamedQuery(name = "Person.findByChurchAdmin", query = "SELECT p FROM Person p WHERE p.churchAdmin = :churchAdmin"),
    @NamedQuery(name = "Person.findBySearchable", query = "SELECT p FROM Person p WHERE p.searchable = :searchable"),
    @NamedQuery(name = "Person.findByMisc1", query = "SELECT p FROM Person p WHERE p.misc1 = :misc1"),
    @NamedQuery(name = "Person.findByMisc2", query = "SELECT p FROM Person p WHERE p.misc2 = :misc2"),
    @NamedQuery(name = "Person.findByMisc3", query = "SELECT p FROM Person p WHERE p.misc3 = :misc3"),
    @NamedQuery(name = "Person.findByLastModified", query = "SELECT p FROM Person p WHERE p.lastModified = :lastModified"),
    @NamedQuery(name = "Person.findByRemarks", query = "SELECT p FROM Person p WHERE p.remarks = :remarks"),
    @NamedQuery(name = "Person.findByAcceptedChrist", query = "SELECT p FROM Person p WHERE p.acceptedChrist = :acceptedChrist"),
    @NamedQuery(name = "Person.findByAcceptedChristDate", query = "SELECT p FROM Person p WHERE p.acceptedChristDate = :acceptedChristDate"),
    @NamedQuery(name = "Person.findByAcceptedChristLocation", query = "SELECT p FROM Person p WHERE p.acceptedChristLocation = :acceptedChristLocation"),
    @NamedQuery(name = "Person.findBySeeker", query = "SELECT p FROM Person p WHERE p.seeker = :seeker")})
public class Person implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PersonID", nullable = false)
    private Integer personID;
    @Column(name = "FamilyID")
    private Integer familyID;
    @Column(name = "ChurchID")
    private Integer churchID;
    @Column(name = "Title", length = 50)
    private String title;
    @Column(name = "LastName", length = 20)
    private String lastName;
    @Column(name = "FirstName", length = 20)
    private String firstName;
    @Column(name = "ChineseName", length = 50)
    private String chineseName;
    @Column(name = "Gender", length = 2)
    private String gender;
    @Column(name = "Age", length = 5)
    private String age;
    @Column(name = "Status", length = 2)
    private String status;
    @Column(name = "Relationship", length = 2)
    private String relationship;
    @Column(name = "ServingRole", length = 50)
    private String servingRole;
    @Column(name = "Baptized")
    private Boolean baptized;
    @Column(name = "BaptizedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date baptizedDate;
    @Column(name = "PRC", length = 50)
    private String prc;
    @Column(name = "CommitServe", length = 50)
    private String commitServe;
    @Column(name = "WillingToAttendCCCMTraining")
    private Boolean willingToAttendCCCMTraining;
    @Column(name = "WillingToBeVolunteer")
    private Boolean willingToBeVolunteer;
    @Column(name = "VolunteerCode")
    private Integer volunteerCode;
    @Column(name = "Phone", length = 15)
    private String phone;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "CellPhone", precision = 22)
    private Double cellPhone;
    @Column(name = "WorkPhone", precision = 22)
    private Double workPhone;
    @Column(name = "Email", length = 50)
    private String email;
    @Column(name = "Language", length = 50)
    private String language;
    @Column(name = "LoginID", length = 50)
    private String loginID;
    @Column(name = "Password", length = 50)
    private String password;
    @Column(name = "FamilyAdmin")
    private Boolean familyAdmin;
    @Column(name = "ChurchAdmin")
    private Boolean churchAdmin;
    @Column(name = "Searchable")
    private Boolean searchable;
    @Column(name = "Misc1", length = 50)
    private String misc1;
    @Column(name = "Misc2", length = 50)
    private String misc2;
    @Column(name = "Misc3", length = 50)
    private String misc3;
    @Basic(optional = false)
    @Column(name = "LastModified", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModified;
    @Column(name = "Remarks", length = 255)
    private String remarks;
    @Column(name = "AcceptedChrist")
    private Boolean acceptedChrist;
    @Column(name = "AcceptedChristDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date acceptedChristDate;
    @Column(name = "AcceptedChristLocation")
    private Integer acceptedChristLocation;
    @Column(name = "Seeker")
    private Boolean seeker;

    public Person() {
    }

    public Person(Integer personID) {
        this.personID = personID;
    }

    public Person(Integer personID, Date lastModified) {
        this.personID = personID;
        this.lastModified = lastModified;
    }

    public Integer getPersonID() {
        return personID;
    }

    public void setPersonID(Integer personID) {
        this.personID = personID;
    }

    public Integer getFamilyID() {
        return familyID;
    }

    public void setFamilyID(Integer familyID) {
        this.familyID = familyID;
    }

    public Integer getChurchID() {
        return churchID;
    }

    public void setChurchID(Integer churchID) {
        this.churchID = churchID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getChineseName() {
        return chineseName;
    }

    public void setChineseName(String chineseName) {
        this.chineseName = chineseName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRelationship() {
        return relationship;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }

    public String getServingRole() {
        return servingRole;
    }

    public void setServingRole(String servingRole) {
        this.servingRole = servingRole;
    }

    public Boolean getBaptized() {
        return baptized;
    }

    public void setBaptized(Boolean baptized) {
        this.baptized = baptized;
    }

    public Date getBaptizedDate() {
        return baptizedDate;
    }

    public void setBaptizedDate(Date baptizedDate) {
        this.baptizedDate = baptizedDate;
    }

    public String getPrc() {
        return prc;
    }

    public void setPrc(String prc) {
        this.prc = prc;
    }

    public String getCommitServe() {
        return commitServe;
    }

    public void setCommitServe(String commitServe) {
        this.commitServe = commitServe;
    }

    public Boolean getWillingToAttendCCCMTraining() {
        return willingToAttendCCCMTraining;
    }

    public void setWillingToAttendCCCMTraining(Boolean willingToAttendCCCMTraining) {
        this.willingToAttendCCCMTraining = willingToAttendCCCMTraining;
    }

    public Boolean getWillingToBeVolunteer() {
        return willingToBeVolunteer;
    }

    public void setWillingToBeVolunteer(Boolean willingToBeVolunteer) {
        this.willingToBeVolunteer = willingToBeVolunteer;
    }

    public Integer getVolunteerCode() {
        return volunteerCode;
    }

    public void setVolunteerCode(Integer volunteerCode) {
        this.volunteerCode = volunteerCode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Double getCellPhone() {
        return cellPhone;
    }

    public void setCellPhone(Double cellPhone) {
        this.cellPhone = cellPhone;
    }

    public Double getWorkPhone() {
        return workPhone;
    }

    public void setWorkPhone(Double workPhone) {
        this.workPhone = workPhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getLoginID() {
        return loginID;
    }

    public void setLoginID(String loginID) {
        this.loginID = loginID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getFamilyAdmin() {
        return familyAdmin;
    }

    public void setFamilyAdmin(Boolean familyAdmin) {
        this.familyAdmin = familyAdmin;
    }

    public Boolean getChurchAdmin() {
        return churchAdmin;
    }

    public void setChurchAdmin(Boolean churchAdmin) {
        this.churchAdmin = churchAdmin;
    }

    public Boolean getSearchable() {
        return searchable;
    }

    public void setSearchable(Boolean searchable) {
        this.searchable = searchable;
    }

    public String getMisc1() {
        return misc1;
    }

    public void setMisc1(String misc1) {
        this.misc1 = misc1;
    }

    public String getMisc2() {
        return misc2;
    }

    public void setMisc2(String misc2) {
        this.misc2 = misc2;
    }

    public String getMisc3() {
        return misc3;
    }

    public void setMisc3(String misc3) {
        this.misc3 = misc3;
    }

    public Date getLastModified() {
        return lastModified;
    }

    public void setLastModified(Date lastModified) {
        this.lastModified = lastModified;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Boolean getAcceptedChrist() {
        return acceptedChrist;
    }

    public void setAcceptedChrist(Boolean acceptedChrist) {
        this.acceptedChrist = acceptedChrist;
    }

    public Date getAcceptedChristDate() {
        return acceptedChristDate;
    }

    public void setAcceptedChristDate(Date acceptedChristDate) {
        this.acceptedChristDate = acceptedChristDate;
    }

    public Integer getAcceptedChristLocation() {
        return acceptedChristLocation;
    }

    public void setAcceptedChristLocation(Integer acceptedChristLocation) {
        this.acceptedChristLocation = acceptedChristLocation;
    }

    public Boolean getSeeker() {
        return seeker;
    }

    public void setSeeker(Boolean seeker) {
        this.seeker = seeker;
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
        if (!(object instanceof Person)) {
            return false;
        }
        Person other = (Person) object;
        if ((this.personID == null && other.personID != null) || (this.personID != null && !this.personID.equals(other.personID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ws.cccm.model.Person[ personID=" + personID + " ]";
    }
    
}
