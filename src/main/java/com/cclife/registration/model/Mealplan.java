/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cclife.registration.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author CH1CHOO1
 */
@Entity
@Table(name = "mealplan")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Mealplan.findAll", query = "SELECT m FROM Mealplan m"),
    @NamedQuery(name = "Mealplan.findByRegistrationID", query = "SELECT m FROM Mealplan m WHERE m.registrationID = :registrationID"),
    @NamedQuery(name = "Mealplan.findByBreakfast1", query = "SELECT m FROM Mealplan m WHERE m.breakfast1 = :breakfast1"),
    @NamedQuery(name = "Mealplan.findByBreakfast2", query = "SELECT m FROM Mealplan m WHERE m.breakfast2 = :breakfast2"),
    @NamedQuery(name = "Mealplan.findByBreakfast3", query = "SELECT m FROM Mealplan m WHERE m.breakfast3 = :breakfast3"),
    @NamedQuery(name = "Mealplan.findByBreakfast4", query = "SELECT m FROM Mealplan m WHERE m.breakfast4 = :breakfast4"),
    @NamedQuery(name = "Mealplan.findByBreakfast5", query = "SELECT m FROM Mealplan m WHERE m.breakfast5 = :breakfast5"),
    @NamedQuery(name = "Mealplan.findByDinner1", query = "SELECT m FROM Mealplan m WHERE m.dinner1 = :dinner1"),
    @NamedQuery(name = "Mealplan.findByDinner2", query = "SELECT m FROM Mealplan m WHERE m.dinner2 = :dinner2"),
    @NamedQuery(name = "Mealplan.findByDinner3", query = "SELECT m FROM Mealplan m WHERE m.dinner3 = :dinner3"),
    @NamedQuery(name = "Mealplan.findByDinner4", query = "SELECT m FROM Mealplan m WHERE m.dinner4 = :dinner4"),
    @NamedQuery(name = "Mealplan.findByDinner5", query = "SELECT m FROM Mealplan m WHERE m.dinner5 = :dinner5"),
    @NamedQuery(name = "Mealplan.findByLastScannedPerson", query = "SELECT m FROM Mealplan m WHERE m.lastScannedPerson = :lastScannedPerson"),
    @NamedQuery(name = "Mealplan.findByLunch1", query = "SELECT m FROM Mealplan m WHERE m.lunch1 = :lunch1"),
    @NamedQuery(name = "Mealplan.findByLunch2", query = "SELECT m FROM Mealplan m WHERE m.lunch2 = :lunch2"),
    @NamedQuery(name = "Mealplan.findByLunch3", query = "SELECT m FROM Mealplan m WHERE m.lunch3 = :lunch3"),
    @NamedQuery(name = "Mealplan.findByLunch4", query = "SELECT m FROM Mealplan m WHERE m.lunch4 = :lunch4"),
    @NamedQuery(name = "Mealplan.findByLunch5", query = "SELECT m FROM Mealplan m WHERE m.lunch5 = :lunch5")})
public class Mealplan implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "RegistrationID")
    private Long registrationID;
    @Column(name = "breakfast1")
    private Integer breakfast1;
    @Column(name = "breakfast2")
    private Integer breakfast2;
    @Column(name = "breakfast3")
    private Integer breakfast3;
    @Column(name = "breakfast4")
    private Integer breakfast4;
    @Column(name = "breakfast5")
    private Integer breakfast5;
    @Column(name = "dinner1")
    private Integer dinner1;
    @Column(name = "dinner2")
    private Integer dinner2;
    @Column(name = "dinner3")
    private Integer dinner3;
    @Column(name = "dinner4")
    private Integer dinner4;
    @Column(name = "dinner5")
    private Integer dinner5;
    @Column(name = "lastScannedPerson")
    private String lastScannedPerson;
    @Column(name = "lunch1")
    private Integer lunch1;
    @Column(name = "lunch2")
    private Integer lunch2;
    @Column(name = "lunch3")
    private Integer lunch3;
    @Column(name = "lunch4")
    private Integer lunch4;
    @Column(name = "lunch5")
    private Integer lunch5;

    public Mealplan() {
    }

    public Mealplan(Long registrationID) {
        this.registrationID = registrationID;
    }

    public Long getRegistrationID() {
        return registrationID;
    }

    public void setRegistrationID(Long registrationID) {
        this.registrationID = registrationID;
    }

    public Integer getBreakfast1() {
        return breakfast1;
    }

    public void setBreakfast1(Integer breakfast1) {
        this.breakfast1 = breakfast1;
    }

    public Integer getBreakfast2() {
        return breakfast2;
    }

    public void setBreakfast2(Integer breakfast2) {
        this.breakfast2 = breakfast2;
    }

    public Integer getBreakfast3() {
        return breakfast3;
    }

    public void setBreakfast3(Integer breakfast3) {
        this.breakfast3 = breakfast3;
    }

    public Integer getBreakfast4() {
        return breakfast4;
    }

    public void setBreakfast4(Integer breakfast4) {
        this.breakfast4 = breakfast4;
    }

    public Integer getBreakfast5() {
        return breakfast5;
    }

    public void setBreakfast5(Integer breakfast5) {
        this.breakfast5 = breakfast5;
    }

    public Integer getDinner1() {
        return dinner1;
    }

    public void setDinner1(Integer dinner1) {
        this.dinner1 = dinner1;
    }

    public Integer getDinner2() {
        return dinner2;
    }

    public void setDinner2(Integer dinner2) {
        this.dinner2 = dinner2;
    }

    public Integer getDinner3() {
        return dinner3;
    }

    public void setDinner3(Integer dinner3) {
        this.dinner3 = dinner3;
    }

    public Integer getDinner4() {
        return dinner4;
    }

    public void setDinner4(Integer dinner4) {
        this.dinner4 = dinner4;
    }

    public Integer getDinner5() {
        return dinner5;
    }

    public void setDinner5(Integer dinner5) {
        this.dinner5 = dinner5;
    }

    public String getLastScannedPerson() {
        return lastScannedPerson;
    }

    public void setLastScannedPerson(String lastScannedPerson) {
        this.lastScannedPerson = lastScannedPerson;
    }

    public Integer getLunch1() {
        return lunch1;
    }

    public void setLunch1(Integer lunch1) {
        this.lunch1 = lunch1;
    }

    public Integer getLunch2() {
        return lunch2;
    }

    public void setLunch2(Integer lunch2) {
        this.lunch2 = lunch2;
    }

    public Integer getLunch3() {
        return lunch3;
    }

    public void setLunch3(Integer lunch3) {
        this.lunch3 = lunch3;
    }

    public Integer getLunch4() {
        return lunch4;
    }

    public void setLunch4(Integer lunch4) {
        this.lunch4 = lunch4;
    }

    public Integer getLunch5() {
        return lunch5;
    }

    public void setLunch5(Integer lunch5) {
        this.lunch5 = lunch5;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (registrationID != null ? registrationID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mealplan)) {
            return false;
        }
        Mealplan other = (Mealplan) object;
        if ((this.registrationID == null && other.registrationID != null) || (this.registrationID != null && !this.registrationID.equals(other.registrationID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ws.cccm.application.model.Mealplan[ registrationID=" + registrationID + " ]";
    }
    
}
