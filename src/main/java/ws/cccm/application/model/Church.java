/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*
To try some changes for github
*/

package ws.cccm.application.model;

import java.io.Serializable;
import java.math.BigInteger;
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
@Table(name = "church")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Church.findAll", query = "SELECT c FROM Church c"),
    @NamedQuery(name = "Church.findByChurchID", query = "SELECT c FROM Church c WHERE c.churchID = :churchID"),
    @NamedQuery(name = "Church.findByAcronym", query = "SELECT c FROM Church c WHERE c.acronym = :acronym"),
    @NamedQuery(name = "Church.findByAddress", query = "SELECT c FROM Church c WHERE c.address = :address"),
    @NamedQuery(name = "Church.findByChurchNameChn", query = "SELECT c FROM Church c WHERE c.churchNameChn = :churchNameChn"),
    @NamedQuery(name = "Church.findByChurchNameEng", query = "SELECT c FROM Church c WHERE c.churchNameEng = :churchNameEng"),
    @NamedQuery(name = "Church.findByCity", query = "SELECT c FROM Church c WHERE c.city = :city"),
    @NamedQuery(name = "Church.findByContactPersonID1", query = "SELECT c FROM Church c WHERE c.contactPersonID1 = :contactPersonID1"),
    @NamedQuery(name = "Church.findByContactPersonID2", query = "SELECT c FROM Church c WHERE c.contactPersonID2 = :contactPersonID2"),
    @NamedQuery(name = "Church.findByContactPersonID3", query = "SELECT c FROM Church c WHERE c.contactPersonID3 = :contactPersonID3"),
    @NamedQuery(name = "Church.findByFax", query = "SELECT c FROM Church c WHERE c.fax = :fax"),
    @NamedQuery(name = "Church.findByLastModified", query = "SELECT c FROM Church c WHERE c.lastModified = :lastModified"),
    @NamedQuery(name = "Church.findByMisc1", query = "SELECT c FROM Church c WHERE c.misc1 = :misc1"),
    @NamedQuery(name = "Church.findByMisc2", query = "SELECT c FROM Church c WHERE c.misc2 = :misc2"),
    @NamedQuery(name = "Church.findByMisc3", query = "SELECT c FROM Church c WHERE c.misc3 = :misc3"),
    @NamedQuery(name = "Church.findByPastorPersonID1", query = "SELECT c FROM Church c WHERE c.pastorPersonID1 = :pastorPersonID1"),
    @NamedQuery(name = "Church.findByPastorPersonID2", query = "SELECT c FROM Church c WHERE c.pastorPersonID2 = :pastorPersonID2"),
    @NamedQuery(name = "Church.findByPastorPersonID3", query = "SELECT c FROM Church c WHERE c.pastorPersonID3 = :pastorPersonID3"),
    @NamedQuery(name = "Church.findByPhone", query = "SELECT c FROM Church c WHERE c.phone = :phone"),
    @NamedQuery(name = "Church.findByRegion", query = "SELECT c FROM Church c WHERE c.region = :region"),
    @NamedQuery(name = "Church.findByState", query = "SELECT c FROM Church c WHERE c.state = :state"),
    @NamedQuery(name = "Church.findByWebURL", query = "SELECT c FROM Church c WHERE c.webURL = :webURL"),
    @NamedQuery(name = "Church.findByZip", query = "SELECT c FROM Church c WHERE c.zip = :zip")})
public class Church implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ChurchID")
    private Long churchID;
    @Column(name = "acronym")
    private String acronym;
    @Column(name = "address")
    private String address;
    @Column(name = "churchNameChn")
    private String churchNameChn;
    @Column(name = "churchNameEng")
    private String churchNameEng;
    @Column(name = "city")
    private String city;
    @Column(name = "contactPersonID1")
    private BigInteger contactPersonID1;
    @Column(name = "contactPersonID2")
    private BigInteger contactPersonID2;
    @Column(name = "contactPersonID3")
    private BigInteger contactPersonID3;
    @Column(name = "fax")
    private String fax;
    @Column(name = "lastModified")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModified;
    @Column(name = "misc1")
    private String misc1;
    @Column(name = "misc2")
    private String misc2;
    @Column(name = "misc3")
    private String misc3;
    @Column(name = "pastorPersonID1")
    private Integer pastorPersonID1;
    @Column(name = "pastorPersonID2")
    private Integer pastorPersonID2;
    @Column(name = "pastorPersonID3")
    private Integer pastorPersonID3;
    @Column(name = "phone")
    private String phone;
    @Column(name = "region")
    private String region;
    @Column(name = "state")
    private String state;
    @Column(name = "webURL")
    private String webURL;
    @Column(name = "zip")
    private String zip;

    public Church() {
    }

    public Church(Long churchID) {
        this.churchID = churchID;
    }

    public Long getChurchID() {
        return churchID;
    }

    public void setChurchID(Long churchID) {
        this.churchID = churchID;
    }

    public String getAcronym() {
        return acronym;
    }

    public void setAcronym(String acronym) {
        this.acronym = acronym;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getChurchNameChn() {
        return churchNameChn;
    }

    public void setChurchNameChn(String churchNameChn) {
        this.churchNameChn = churchNameChn;
    }

    public String getChurchNameEng() {
        return churchNameEng;
    }

    public void setChurchNameEng(String churchNameEng) {
        this.churchNameEng = churchNameEng;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public BigInteger getContactPersonID1() {
        return contactPersonID1;
    }

    public void setContactPersonID1(BigInteger contactPersonID1) {
        this.contactPersonID1 = contactPersonID1;
    }

    public BigInteger getContactPersonID2() {
        return contactPersonID2;
    }

    public void setContactPersonID2(BigInteger contactPersonID2) {
        this.contactPersonID2 = contactPersonID2;
    }

    public BigInteger getContactPersonID3() {
        return contactPersonID3;
    }

    public void setContactPersonID3(BigInteger contactPersonID3) {
        this.contactPersonID3 = contactPersonID3;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public Date getLastModified() {
        return lastModified;
    }

    public void setLastModified(Date lastModified) {
        this.lastModified = lastModified;
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

    public Integer getPastorPersonID1() {
        return pastorPersonID1;
    }

    public void setPastorPersonID1(Integer pastorPersonID1) {
        this.pastorPersonID1 = pastorPersonID1;
    }

    public Integer getPastorPersonID2() {
        return pastorPersonID2;
    }

    public void setPastorPersonID2(Integer pastorPersonID2) {
        this.pastorPersonID2 = pastorPersonID2;
    }

    public Integer getPastorPersonID3() {
        return pastorPersonID3;
    }

    public void setPastorPersonID3(Integer pastorPersonID3) {
        this.pastorPersonID3 = pastorPersonID3;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getWebURL() {
        return webURL;
    }

    public void setWebURL(String webURL) {
        this.webURL = webURL;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (churchID != null ? churchID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Church)) {
            return false;
        }
        Church other = (Church) object;
        if ((this.churchID == null && other.churchID != null) || (this.churchID != null && !this.churchID.equals(other.churchID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ws.cccm.application.model.Church[ churchID=" + churchID + " ]";
    }
    
}
