/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cclife.registration.domain;

import com.cclife.registration.model.Mealplan;
import com.cclife.registration.model.Person;
import java.util.Set;

/**
 *
 * @author Ephesus
 */
public class Registrant extends BaseObject {
    private Person person;
    private Mealplan mealplan;
    private Set<Server> volunteerJobs;
    private Fee fee;
    /**
     * @return the person
     */
    public Person getPerson() {
        return person;
    }

    /**
     * @param person the person to set
     */
    public void setPerson(Person person) {
        this.person = person;
    }

    /**
     * @return the mealplan
     */
    public Mealplan getMealplan() {
        return mealplan;
    }

    /**
     * @param mealplan the mealplan to set
     */
    public void setMealplan(Mealplan mealplan) {
        this.mealplan = mealplan;
    }

    /**
     * @return the volunteerJobs
     */
    public Set<Server> getVolunteerJobs() {
        return volunteerJobs;
    }

    /**
     * @param volunteerJobs the volunteerJobs to set
     */
    public void setVolunteerJobs(Set<Server> volunteerJobs) {
        this.volunteerJobs = volunteerJobs;
    }

    @Override
    public String toString() {
        return "Registrant:" + this.person.getFirstName();
    }

    @Override
    public boolean equals(Object o) {
        return true ;
    }

    @Override
    public int hashCode() {
        return 0 ;
    }

    /**
     * @return the fee
     */
    public Fee getFee() {
        return fee;
    }

    /**
     * @param fee the fee to set
     */
    public void setFee(Fee fee) {
        this.fee = fee;
    }

        
}
