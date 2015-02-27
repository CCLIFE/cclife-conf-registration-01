/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cclife.registration.model;

import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ephesus
 */
@Entity
@Table(name = "donation")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Donation.findAll", query = "SELECT d FROM Donation d"),
    @NamedQuery(name = "Donation.findByReceiptNumber", query = "SELECT d FROM Donation d WHERE d.receiptNumber = :receiptNumber"),
    @NamedQuery(name = "Donation.findByPersonID", query = "SELECT d FROM Donation d WHERE d.personID = :personID"),
    @NamedQuery(name = "Donation.findByAmounts", query = "SELECT d FROM Donation d WHERE d.amounts = :amounts"),
    @NamedQuery(name = "Donation.findByDate", query = "SELECT d FROM Donation d WHERE d.date = :date"),
    @NamedQuery(name = "Donation.findByCheckNumber", query = "SELECT d FROM Donation d WHERE d.checkNumber = :checkNumber"),
    @NamedQuery(name = "Donation.findByPurpose", query = "SELECT d FROM Donation d WHERE d.purpose = :purpose")})
public class Donation implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ReceiptNumber")
    private Integer receiptNumber;
    @Column(name = "PersonID")
    private Integer personID;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Amounts")
    private BigDecimal amounts;
    @Column(name = "Date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @Size(max = 10)
    @Column(name = "CheckNumber")
    private String checkNumber;
    @Size(max = 50)
    @Column(name = "Purpose")
    private String purpose;

    public Donation() {
    }

    public Donation(Integer receiptNumber) {
        this.receiptNumber = receiptNumber;
    }

    public Integer getReceiptNumber() {
        return receiptNumber;
    }

    public void setReceiptNumber(Integer receiptNumber) {
        this.receiptNumber = receiptNumber;
    }

    public Integer getPersonID() {
        return personID;
    }

    public void setPersonID(Integer personID) {
        this.personID = personID;
    }

    public BigDecimal getAmounts() {
        return amounts;
    }

    public void setAmounts(BigDecimal amounts) {
        this.amounts = amounts;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getCheckNumber() {
        return checkNumber;
    }

    public void setCheckNumber(String checkNumber) {
        this.checkNumber = checkNumber;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (receiptNumber != null ? receiptNumber.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Donation)) {
            return false;
        }
        Donation other = (Donation) object;
        if ((this.receiptNumber == null && other.receiptNumber != null) || (this.receiptNumber != null && !this.receiptNumber.equals(other.receiptNumber))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cclife.registration.model.Donation[ receiptNumber=" + receiptNumber + " ]";
    }
    
}
