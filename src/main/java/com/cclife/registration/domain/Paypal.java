/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cclife.registration.domain;

/**
 *
 * @author JianxinYao
 */
import java.io.Serializable;

/**
 * Object mapping for hibernate-handled table: tblperson.
 *
 * @author autogenerated
 */
public class Paypal extends BaseObject implements Serializable {

    /**
     * Serial Version UID.
     */
    private static final long serialVersionUID = 3832626162173359488L;
    private String cmd = "_ext-enter";
    private String redirect_cmd = "_xclick";
    private String business = "registration@cccm.ws";
    private String item_name = "";
    private String item_number = "";
    private String amount = "";
    private String custom = "";
    private String no_shipping = "0";
    private String no_note = "1";
    private String currency_code = "USD";
    private String lc = "US";
    private String bn = "PP-BuyNowBF";
    private String reten = "";
    private String rm = "2";
    private String email = "";
    private String first_name = "";
    private String last_name = "";
    private String address1 = "";
    private String address2 = "";
    private String city = "";
    private String state = "";
    private String zip = "";
    private String notify_url = "";

    /**
     * Default constructor - creates a new instance with no values set.
     */
    public Paypal() {
    }

    @Override
    public String toString() {
        return "cmd:" + cmd + "\n"
                + "redirect_cmd:" + redirect_cmd + "\n"
                + "business" + business + "\n";
    }

    @Override
    public boolean equals(Object o) {
        return true;
    }

    @Override
    public int hashCode() {
        return 12345678;
    }

    /**
     * @return the cmd
     */
    public String getCmd() {
        return cmd;
    }

    /**
     * @param cmd the cmd to set
     */
    public void setCmd(String cmd) {
        this.cmd = cmd;
    }

    /**
     * @return the redirect_cmd
     */
    public String getRedirect_cmd() {
        return redirect_cmd;
    }

    /**
     * @param redirectCmd
     */
    public void setRedirect_cmd(String redirectCmd) {
        this.redirect_cmd = redirectCmd;
    }

    /**
     * @return the business
     */
    public String getBusiness() {
        return business;
    }

    /**
     * @param business the business to set
     */
    public void setBusiness(String business) {
        this.business = business;
    }

    /**
     * @return the item_name
     */
    public String getItem_name() {
        return item_name;
    }

    /**
     * @param itemName
     */
    public void setItem_name(String itemName) {
        this.item_name = itemName;
    }

    /**
     * @return the item_number
     */
    public String getItem_number() {
        return item_number;
    }

    /**
     * @param itemNumber
     */
    public void setItem_number(String itemNumber) {
        this.item_number = itemNumber;
    }

    /**
     * @return the amount
     */
    public String getAmount() {
        return amount;
    }

    /**
     * @param amount the amount to set
     */
    public void setAmount(String amount) {
        this.amount = amount;
    }

    /**
     * @return the custom
     */
    public String getCustom() {
        return custom;
    }

    /**
     * @param custom the custom to set
     */
    public void setCustom(String custom) {
        this.custom = custom;
    }

    /**
     * @return the no_shipping
     */
    public String getNo_shipping() {
        return no_shipping;
    }

    /**
     * @param no_shipping the no_shipping to set
     */
    public void setNo_shipping(String noShipping) {
        this.no_shipping = noShipping;
    }

    /**
     * @return the no_note
     */
    public String getNo_note() {
        return no_note;
    }

    /**
     * @param no_note the no_note to set
     */
    public void setNo_note(String noNote) {
        this.no_note = noNote;
    }

    /**
     * @return the currency_code
     */
    public String getCurrency_code() {
        return currency_code;
    }

    /**
     * @param currency_code the currency_code to set
     */
    public void setCurrency_code(String currencyCode) {
        this.currency_code = currencyCode;
    }

    /**
     * @return the lc
     */
    public String getLc() {
        return lc;
    }

    /**
     * @param lc the lc to set
     */
    public void setLc(String lc) {
        this.lc = lc;
    }

    /**
     * @return the bn
     */
    public String getBn() {
        return bn;
    }

    /**
     * @param bn the bn to set
     */
    public void setBn(String bn) {
        this.bn = bn;
    }

    /**
     * @return the reten
     */
    public String getReturn() {
        return reten;
    }

    /**
     * @param reten the reten to set
     */
    public void setReturn(String reten) {
        this.reten = reten;
    }

    /**
     * @return the rm
     */
    public String getRm() {
        return rm;
    }

    /**
     * @param rm the rm to set
     */
    public void setRm(String rm) {
        this.rm = rm;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the first_name
     */
    public String getFirst_name() {
        return first_name;
    }

    /**
     * @param first_name the first_name to set
     */
    public void setFirst_name(String firstName) {
        this.first_name = firstName;
    }

    /**
     * @return the last_name
     */
    public String getLast_name() {
        return last_name;
    }

    /**
     * @param last_name the last_name to set
     */
    public void setLast_name(String lastName) {
        this.last_name = lastName;
    }

    /**
     * @return the address1
     */
    public String getAddress1() {
        return address1;
    }

    /**
     * @param address1 the address1 to set
     */
    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    /**
     * @return the address2
     */
    public String getAddress2() {
        return address2;
    }

    /**
     * @param address2 the address2 to set
     */
    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    /**
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city the city to set
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @return the state
     */
    public String getState() {
        return state;
    }

    /**
     * @param state the state to set
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * @return the zip
     */
    public String getZip() {
        return zip;
    }

    /**
     * @param zip the zip to set
     */
    public void setZip(String zip) {
        this.zip = zip;
    }

    /**
     * @return the notify_url
     */
    public String getNotify_url() {
        return notify_url;
    }

    /**
     * @param notify_url the notify_url to set
     */
    public void setNotify_url(String notify_url) {
        this.notify_url = notify_url;
    }
}
