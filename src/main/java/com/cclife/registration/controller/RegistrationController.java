/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cclife.registration.controller;

import com.cclife.registration.domain.Expense;
import com.cclife.registration.domain.Fee;
import com.cclife.registration.domain.LabelValue;
import com.cclife.registration.domain.PaymentMethod;
import com.cclife.registration.domain.PaymentProvider;
import com.cclife.registration.domain.Registrant;
import com.cclife.registration.domain.RegistrationForm;
import com.cclife.registration.model.Mealplan;
import com.cclife.registration.model.Person;
import com.cclife.registration.service.RegistrationService;
import com.cclife.registration.util.DateUtil;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.logging.Level;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.webflow.core.collection.LocalAttributeMap;
import org.springframework.webflow.execution.RequestContext;

/**
 *
 * @author Ephesus
 */
@Component
public class RegistrationController {

    private static final Logger logger = Logger.getLogger(RegistrationController.class);

    @Autowired
    @Resource(name = "feeMap")
    private Map<String, String> feeMap;

//    @Autowired
//    private PaymentProvider paymentProvider;
    @Autowired
    private RegistrationService registrationService;
    @Resource(name = "paymentProviderMap")
    private Map<String, PaymentProvider> paymentProviderMap;

    public RegistrationForm initializeForm() {
        RegistrationForm registrationForm = new RegistrationForm();

        // Setup Form ID (Registration ID)
        String generatedId = DateUtil.getDateTime("MMddHHmmss", new Date());
        logger.debug("Generated Form ID  =" + generatedId);
        registrationForm.setFormID(Long.valueOf(generatedId));

        List<LabelValue> ageGroup;
        ageGroup = new ArrayList<LabelValue>();

        ageGroup.add(new LabelValue("18-30", "A2"));
        ageGroup.add(new LabelValue("31-40", "A3"));
        ageGroup.add(new LabelValue("41-50", "A4"));
        ageGroup.add(new LabelValue("51-60", "A5"));
        ageGroup.add(new LabelValue("61+", "A6"));
        ageGroup.add(new LabelValue("17", "17"));
        ageGroup.add(new LabelValue("16", "16"));
        ageGroup.add(new LabelValue("15", "15"));
        ageGroup.add(new LabelValue("14", "14"));
        ageGroup.add(new LabelValue("13", "13"));
        ageGroup.add(new LabelValue("12", "12"));
        ageGroup.add(new LabelValue("11", "11"));
        ageGroup.add(new LabelValue("10", "10"));
        ageGroup.add(new LabelValue("9", "9"));
        ageGroup.add(new LabelValue("8", "8"));
        ageGroup.add(new LabelValue("7", "7"));
        ageGroup.add(new LabelValue("6", "6"));
        ageGroup.add(new LabelValue("5", "5"));
        ageGroup.add(new LabelValue("4", "4"));
        ageGroup.add(new LabelValue("3", "3"));
        ageGroup.add(new LabelValue("2", "2"));
        ageGroup.add(new LabelValue("1", "1"));
        ageGroup.add(new LabelValue("0", "0"));

        registrationForm.setAgeGroup(ageGroup);

        List<LabelValue> months;
        months = new ArrayList<LabelValue>();

        List<LabelValue> days;
        days = new ArrayList<LabelValue>();
        days.add(new LabelValue("1", "01"));
        days.add(new LabelValue("2", "02"));
        days.add(new LabelValue("3", "03"));
        days.add(new LabelValue("4", "04"));
        days.add(new LabelValue("5", "05"));
        days.add(new LabelValue("6", "06"));
        days.add(new LabelValue("7", "07"));
        days.add(new LabelValue("8", "08"));
        days.add(new LabelValue("9", "09"));
        days.add(new LabelValue("10", "10"));
        days.add(new LabelValue("11", "11"));
        days.add(new LabelValue("12", "12"));
        days.add(new LabelValue("13", "13"));
        days.add(new LabelValue("14", "14"));
        days.add(new LabelValue("15", "15"));
        days.add(new LabelValue("16", "16"));
        days.add(new LabelValue("17", "17"));
        days.add(new LabelValue("18", "18"));
        days.add(new LabelValue("19", "19"));
        days.add(new LabelValue("20", "20"));
        days.add(new LabelValue("21", "21"));
        days.add(new LabelValue("22", "22"));
        days.add(new LabelValue("23", "23"));
        days.add(new LabelValue("24", "24"));
        days.add(new LabelValue("25", "25"));
        days.add(new LabelValue("26", "26"));
        days.add(new LabelValue("27", "27"));
        days.add(new LabelValue("28", "28"));
        days.add(new LabelValue("29", "29"));
        days.add(new LabelValue("30", "30"));
        days.add(new LabelValue("31", "31"));

//        registrationForm.setDayOfMonth(days);
        List<LabelValue> relationshipGroup;
        relationshipGroup = new ArrayList<LabelValue>();

        relationshipGroup.add(new LabelValue("H \u4e08\u592b", "H")); // H(?)
        relationshipGroup.add(new LabelValue("W \u59bb\u5b50", "W")); // W(?)
        relationshipGroup.add(new LabelValue("S \u5152\u5b50", "S")); // S(?)
        relationshipGroup.add(new LabelValue("D \u5973\u5152", "D")); // D(?) 
        relationshipGroup.add(new LabelValue("F \u7236\u89aa", "F")); // F(?)
        relationshipGroup.add(new LabelValue("M \u6bcd\u89aa", "M")); // M(?)
        relationshipGroup.add(new LabelValue("B \u5144\u5F1F", "B")); // B(??)
        relationshipGroup.add(new LabelValue("T \u59CA\u59B9", "T")); // T(??)
        relationshipGroup.add(new LabelValue("C \u540C\u5B66", "C")); // C(??)
        relationshipGroup.add(new LabelValue("O \u540C\u4E8B", "O")); // O(??)
        //relationshipGroup.add(new LabelValue("P \u4E3B\u62A5\u4EBA", "P"));  //P is not selectable, will be added on dynamically
        registrationForm.setRelationshipGroup(relationshipGroup);

        /**
         * statusGroup is the list of serving roles *
         */
        List<LabelValue> statusGroup;
        statusGroup = new ArrayList<LabelValue>();

        statusGroup.add(new LabelValue("P \u7267\u5e08 / \u4f20\u9053\u4eba", "1"));
        statusGroup.add(new LabelValue("S \u795e\u5b66\u751f", "2"));
        statusGroup.add(new LabelValue("D \u6559\u4f1a\u957f\u6267 / \u56e2\u5951\u540c\u5de5", "3"));
        statusGroup.add(new LabelValue("O \u798f\u97f3\u673a\u6784\u540c\u5de5", "4"));
        statusGroup.add(new LabelValue("M \u6559\u4f1a\u6210\u5458", "5"));
        statusGroup.add(new LabelValue("U \u6155\u9053\u53cb", "6"));

        registrationForm.setStatusGroup(statusGroup);

        List<LabelValue> statusGroup2;
        statusGroup2 = new ArrayList<LabelValue>();

        statusGroup2.add(new LabelValue("Senior High - Sr \u5341\u4e8c\u5e74\u7ea7", "12th"));
        statusGroup2.add(new LabelValue("Senior High - Jr \u5341\u4e00\u5e74\u7ea7", "11th"));
        statusGroup2.add(new LabelValue("Senior High - So \u5341\u5e74\u7ea7", "10th"));
        statusGroup2.add(new LabelValue("Senior High - Fr \u4e5d\u5e74\u7ea7", "9th"));
        statusGroup2.add(new LabelValue("Junior High - 8th grade \u516b\u5e74\u7ea7", "8th"));
        statusGroup2.add(new LabelValue("Junior High - 7th grade \u4e03\u5e74\u7ea7", "7th"));
        statusGroup2.add(new LabelValue("Junior High - 6th grade \u516d\u5e74\u7ea7", "6th"));
        statusGroup2.add(new LabelValue("Elementary (EL)(K-5) \u5c0f\u5b66\u751f", "EL"));
        statusGroup2.add(new LabelValue("Toddlers (TO)(age 1-3) \u5e7c\u513f", "TO"));
        statusGroup2.add(new LabelValue("Other (O) \u5176\u4ed6", "O"));

        registrationForm.setStatusGroup2(statusGroup2);

        List<LabelValue> stateList;
        stateList = new ArrayList<LabelValue>();

        stateList.add(new LabelValue("Alabama", "AL"));
        stateList.add(new LabelValue("Alaska", "AK"));
        stateList.add(new LabelValue("Arizona", "AZ"));
        stateList.add(new LabelValue("Arkansas", "AR"));

        stateList.add(new LabelValue("California", "CA"));
        stateList.add(new LabelValue("Colorado", "CO"));
        stateList.add(new LabelValue("Connecticut", "CT"));
        
        stateList.add(new LabelValue("Delaware", "DE"));
        stateList.add(new LabelValue("Florida", "FL"));
        stateList.add(new LabelValue("Georgia", "GA"));
        stateList.add(new LabelValue("Hawaii", "HI"));
        
        stateList.add(new LabelValue("Idaho", "ID"));
        stateList.add(new LabelValue("Illinois", "IL"));
        stateList.add(new LabelValue("Indiana", "IN"));
        stateList.add(new LabelValue("Iowa", "IA"));
        
        stateList.add(new LabelValue("Kansas", "KS"));
        stateList.add(new LabelValue("Kentucky", "KY"));
        stateList.add(new LabelValue("Louisiana", "LA"));
        
        stateList.add(new LabelValue("Maine", "ME"));
        stateList.add(new LabelValue("Maryland", "MD"));
        stateList.add(new LabelValue("Massachusetts", "MA"));
        stateList.add(new LabelValue("Michigan", "MI"));
        stateList.add(new LabelValue("Minnesota", "MN"));
        stateList.add(new LabelValue("Mississippi", "MS"));
        stateList.add(new LabelValue("Missouri", "MO"));
        stateList.add(new LabelValue("Montana", "MT"));
        
        stateList.add(new LabelValue("Nebraska", "NE"));
        stateList.add(new LabelValue("Nevada", "NV"));
        stateList.add(new LabelValue("New Hampshire", "NH"));
        stateList.add(new LabelValue("New Jersey", "NJ"));
        stateList.add(new LabelValue("New Mexico", "NM"));
        stateList.add(new LabelValue("New York", "NY"));
        stateList.add(new LabelValue("North Carolina", "NC"));
        stateList.add(new LabelValue("North Dakota", "ND"));
        
        stateList.add(new LabelValue("Ohio", "OH"));
        stateList.add(new LabelValue("Oklahoma", "OK"));
        stateList.add(new LabelValue("Oregon", "OR"));
        
        stateList.add(new LabelValue("Pennsylvania", "PA"));
        stateList.add(new LabelValue("Rhode Island", "RI"));
        stateList.add(new LabelValue("South Carolina", "SC"));
        stateList.add(new LabelValue("South Dakota", "SD"));
        stateList.add(new LabelValue("Tennessee", "TN"));
        stateList.add(new LabelValue("Texas", "TX"));
        
        stateList.add(new LabelValue("Utah", "UT"));
        stateList.add(new LabelValue("Vermont", "VT"));
        stateList.add(new LabelValue("Virginia", "VA"));
        stateList.add(new LabelValue("Washington", "WA"));
        stateList.add(new LabelValue("West Virginia", "WV"));
        stateList.add(new LabelValue("Wisconsin", "WI"));
        stateList.add(new LabelValue("Wyoming", "WY"));

        registrationForm.setStateList(stateList);

        List<LabelValue> countryList;
        countryList = new ArrayList<LabelValue>();

        countryList.add(new LabelValue("United States America", "US"));
        countryList.add(new LabelValue("Canada", "CA"));
        countryList.add(new LabelValue("Other Country", "OC"));

        registrationForm.setCountries(countryList);

        /**
         * The following code added for issue5.
         */
        List<LabelValue> languageList = new ArrayList<LabelValue>();
        languageList.add(new LabelValue("Mandarin \u666e\u901a\u8bdd", "M"));
        languageList.add(new LabelValue("Cantonese \u5e7f\u4e1c\u8bdd", "C"));
        languageList.add(new LabelValue("English \u82f1\u6587", "E"));
        registrationForm.setLanguages(languageList);

        List<LabelValue> headphoneList = new ArrayList<LabelValue>();
        headphoneList.add(new LabelValue("\u7ca4\u8bed\u8033\u673a (M to C)", "MtoC"));
        headphoneList.add(new LabelValue("\u82f1\u8bed\u8033\u673a (M to E)", "MtoE"));
        registrationForm.setHeadphones(headphoneList);
        /**
         * End of code for issue5.
         */
        List<Fee> fees;
        fees = new ArrayList<Fee>();

        for (Map.Entry<String, String> entry : feeMap.entrySet()) {
            logger.debug("Key : " + entry.getKey() + " Value : "
                    + entry.getValue());
            StringTokenizer st = new StringTokenizer(entry.getValue(), ",");
            int count = 0;
            Fee fee = new Fee();
            while (st.hasMoreTokens()) {

                count++;

                switch (count) {
                    case 1:
                        fee.setEventID(st.nextToken());
                        logger.debug("event id:" + fee.getEventID());
                        break;
                    case 2:
                        DateTime dt = new DateTime(st.nextToken());
                        fee.setEffectiveDate(dt);
                        logger.debug("effective date:" + fee.getEffectiveDate());
                        break;
                    case 3:
                        fee.setAgeLevel(Integer.parseInt(st.nextToken()));
                        logger.debug("age level:" + fee.getAgeLevel());
                        break;
                    case 4:
                        fee.setPriority(Integer.parseInt(st.nextToken()));
                        logger.debug("priority:" + fee.getPriority());
                        break;
                    case 5:
                        fee.setCodeName(st.nextToken());
                        logger.debug("code name:" + fee.getCodeName());
                        break;
                    case 6:
                        fee.setDescription(st.nextToken());
                        logger.debug("description:" + fee.getDescription());
                        break;
                    case 7:
                        fee.setCurrency(st.nextToken());
                        logger.debug("currency:" + fee.getCurrency());
                        break;
                    case 8:
                        fee.setAmount(Double.valueOf(st.nextToken()));
                        logger.debug("amount:" + fee.getAmount());
                        break;
                }

            }
            fees.add(fee);
        }
        registrationForm.setFees(fees);

        try {
            Date d = DateUtil.getToday().getTime();
            //        registrationForm.setQuantity(1);
            registrationForm.setRegistrationDate(d);

        } catch (ParseException ex) {
            logger.error("Error generating Registration ID");
        }
        registrationForm.setPaymentMethod(PaymentMethod.WAIVED);
        logger.info("initialize Form exiting");
        return registrationForm;
    }

    public Registrant createNewPerson(RegistrationForm form) {

        if (form.getRegistrants() == null) {
            ArrayList<Registrant> rlist = new ArrayList<Registrant>();
            form.setRegistrants(rlist);
        }

        Registrant registrant = new Registrant();
        Person person = new Person();
        //person.setFirstName("New");
        if (form.getRegistrants().isEmpty()) {
            person.setChineseName(form.getPrimaryChineseName());
            person.setFirstName(form.getPrimaryFirstName());
            person.setLastName(form.getPrimaryLastName());
            person.setPhone(form.getAddress().getHomePhone());
            person.setEmail(form.getAddress().getMisc1());
            person.setRelationship("A");
        }

        registrant.setPerson(person);
        form.getRegistrants().add(registrant);
        Mealplan mealPlan = new Mealplan();
        registrant.setMealplan(mealPlan);

        return registrant;
    }

    public Registrant removeNewPerson(RegistrationForm form) {
        return form.getRegistrants().remove((form.getRegistrants().size() - 1));
    }

    public Registrant editPerson(RegistrationForm form, LocalAttributeMap currentEvent) {

        logger.debug("Value:" + currentEvent);
        //Debug
        Map<String, String> map = currentEvent.asMap();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            logger.debug(entry.getKey() + "/" + entry.getValue());
        }

        String index = null;
        if (map.get("index") != null && isInteger(map.get("index"))) {
            index = map.get("index");
        } else if (map.get("_eventId_remove") != null && isInteger(map.get("_eventId_remove"))) {
            index = map.get("_eventId_remove");
        }

        if (index != null) {
            return form.getRegistrants().get(Integer.parseInt(index));
        }

        return null;
    }

    public Registrant deletePerson(RegistrationForm form, LocalAttributeMap currentEvent) {

        logger.debug("Value:" + currentEvent);
        //Debug
        Map<String, String> map = currentEvent.asMap();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            logger.debug(entry.getKey() + "/" + entry.getValue());
        }

        String index = null;
        if (map.get("index") != null && isInteger(map.get("index"))) {
            index = map.get("index");
        } else if (map.get("_eventId_remove") != null && isInteger(map.get("_eventId_remove"))) {
            index = map.get("_eventId_remove");
        }

        if (index != null) {
            return form.getRegistrants().remove(Integer.parseInt(index));
        }

        return null;
    }

    public String getPaymentProviderUrl(RegistrationForm form) {

        logger.info("getPaymentProviderUrl entering");

        PaymentProvider provider = paymentProviderMap.get(form.getPaymentCurrency());
        logger.debug("ServiceProvider:" + provider.getBusiness());

        form.setPaymentProvider(provider);

        return provider.getProviderUrl();
    }

    public PaymentProvider createPaymentRequest(RegistrationForm form, RequestContext context) {

        logger.info("createPaypalRequest entering");

        this.submit(form);

        // Get http request  
        HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getNativeRequest();
        // Generate Spring Webflow return URL
        String url = request.getRequestURL()
                + ";jsessionid=" + request.getSession().getId() + "?"
                + request.getQueryString();

        String paypalCancelUrl = url + "&_eventId=cancel";
        String paypalSuccessUrl = url + "&_eventId=success";
        logger.debug("Approved URL:" + paypalSuccessUrl);
        logger.debug("Cancel URL:" + paypalCancelUrl);

        form.getPaymentProvider().setItem_number(String.valueOf(form.getFormID().longValue()));

//        p.setCmd("_ext-enter");
//        p.setRedirect_cmd("_xclick");
//        p.setBusiness("Registration@cccm.ws");
//        p.setBusiness("clhoo_1288811245_biz@msn.com");
//        p.setItem_name("CCCC/Grace 2014");
        double total = form.getExpense().getTotalRegistrationFee() + form.getExpense().getTotalMealsFee();
        form.getPaymentProvider().setAmount(String.valueOf(total));
        form.getPaymentProvider().setCustom(String.valueOf(total));
//        p.setNo_shipping("0");
//        p.setNo_note("1");
//        p.setCurrency_code("USD");
//        p.setLc("US");
//        p.setBn("PP-BuyNowBF");
//        p.setReturn("http://localhost:9090/Registration/confirm.htm");
//        form.getPaymentProvider().setReturn(paypalSuccessUrl);
//        p.setNotify_url("http://cccm.biz:8084/registration/instantPaymentNotification.htm");
//        p.setRm("2");
        form.getPaymentProvider().setEmail(form.getAddress().getMisc1());
        form.getPaymentProvider().setFirst_name(form.getPrimaryFirstName());
        form.getPaymentProvider().setLast_name(form.getPrimaryLastName());
        form.getPaymentProvider().setAddress1(form.getAddress().getHomeAddress());
        form.getPaymentProvider().setAddress2(form.getAddress().getHomeAddress2());
        form.getPaymentProvider().setCity(form.getAddress().getHomeCity());
        form.getPaymentProvider().setState(form.getAddress().getHomeState());
        form.getPaymentProvider().setZip(form.getAddress().getHomeZip());
//        form.getPaymentProvider().setReturn(confirmationUrl);

//        if (form.getEventID().compareTo(201403) == 0) {
//            paypalInstance.setReturn(confirmationAltUrl);
//        }
        logger.debug("Business:" + form.getPaymentProvider().getBusiness());
        logger.debug("Currency:" + form.getPaymentProvider().getCurrency_code());
        logger.debug("Lc:" + form.getPaymentProvider().getLc());
        logger.info("createPaypalRequest exiting");

        return form.getPaymentProvider();
    }

    public void submit(RegistrationForm form) {
        try {

            registrationService.submit(form);
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(RegistrationController.class.getName()).log(Level.SEVERE, "Submit registration form", ex);
        }
    }

    public void sendMail(RegistrationForm form) {
        try {

            if (form.getPaymentMethod() == PaymentMethod.PERSONAL_CHECK) {
                String template = "CCLIFE_2015_Registration_Recieved_CA.html";
                if (form.getPaymentCurrency().equalsIgnoreCase("USD")) {
                    template = "CCLIFE_2015_Registration_Recieved_US.html";
                }
                Map<String, Object> params = new HashMap<String, Object>();
                params.put("primaryName", form.getPrimaryChineseName());
                params.put("currency", form.getPaymentCurrency());
                params.put("registrationId", form.getFormID());
                params.put("amountPaid", form.getExpense().getTotalMealsFee() + form.getExpense().getTotalRegistrationFee());

                registrationService.sendEmail(form, params, template);
            }
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(RegistrationController.class.getName()).log(Level.SEVERE, "Submit registration form", ex);
        }
    }

    public void calculateFee(RegistrationForm form) {

        String currency;
        if (form.getAddress().getCountry().equalsIgnoreCase("CA")) {
            currency = "CAD";

        } else {
            currency = "USD";
        }
        form.setPaymentCurrency(currency);

        Expense expense = createExpenseByCurrency(form.getRegistrants(), form.getFees(), currency);
        form.setExpense(expense);

    }

    private Expense createExpenseByCurrency(List<Registrant> registrants, List<Fee> fees, String currency) {

        Expense expense = new Expense();

        double grpTotalRegistrationFee = 0;
        double grpTotalMealFee = 0;

        Double lunchFee = 0.0;
        Double dinnerFee = 0.0;
        Double breakfastFee = 0.0;
        Double adultRegistrationFee = 0.0;
        Double nonAdultRegistrationFee = 0.0;
        Integer ageLevel = 0;

        DateTime now = new DateTime();
        DateTime effectiveDate = null;
        for (Fee fee : fees) {
            if (fee.getCodeName().contains("REGISTRATION") && fee.getCurrency().equalsIgnoreCase(currency) && now.isBefore(fee.getEffectiveDate())) {

                if (effectiveDate == null || effectiveDate.isAfter(fee.getEffectiveDate())) {
                    adultRegistrationFee = fee.getAmount();
                    ageLevel = fee.getAgeLevel();
                    effectiveDate = fee.getEffectiveDate();
                }
            }
            if (fee.getCodeName().contains("LUNCH") && fee.getCurrency().equalsIgnoreCase(currency)) {
                lunchFee = fee.getAmount();
            }
            if (fee.getCodeName().contains("DINNER") && fee.getCurrency().equalsIgnoreCase(currency)) {
                dinnerFee = fee.getAmount();
            }
        }

        for (Registrant regt : registrants) {

            if (regt.getExpense() == null) {
                Expense exp = new Expense();
                regt.setExpense(exp);
            }

            // >>>>>>>>>>>>>>>>>>>>> Registration fee >>>>>>>>>>>>>>>>>>>>> 
            if (regt.getPerson().getAge().startsWith("A")) {
                regt.getExpense().setTotalRegistrationFee(adultRegistrationFee);
                regt.getExpense().setAdultHeadcount(1);
            } else if (Integer.parseInt(regt.getPerson().getAge()) > ageLevel) {
                regt.getExpense().setTotalRegistrationFee(adultRegistrationFee);
                regt.getExpense().setAdultHeadcount(1);
            } else {
                regt.getExpense().setTotalRegistrationFee(nonAdultRegistrationFee);
                regt.getExpense().setNonAdultHeadcount(1);
            }
            // >>>>>>>>>>>>>>>>>>>>> Meal fee >>>>>>>>>>>>>>>>>>>>>            
            Mealplan mp = regt.getMealplan();

            Integer breakfastCount = (mp.getBreakfast1() != null ? mp.getBreakfast1() : 0)
                    + (mp.getBreakfast2() != null ? mp.getBreakfast2() : 0)
                    + (mp.getBreakfast3() != null ? mp.getBreakfast3() : 0)
                    + (mp.getBreakfast4() != null ? mp.getBreakfast4() : 0)
                    + (mp.getBreakfast5() != null ? mp.getBreakfast5() : 0);
            regt.getExpense().setBreakfastCount(breakfastCount);
            regt.getExpense().setTotalBreakfastFee(breakfastCount * 0);

            Integer lunchCount = (mp.getLunch1() != null ? mp.getLunch1() : 0)
                    + (mp.getLunch2() != null ? mp.getLunch2() : 0)
                    + (mp.getLunch3() != null ? mp.getLunch3() : 0)
                    + (mp.getLunch4() != null ? mp.getLunch4() : 0)
                    + (mp.getLunch5() != null ? mp.getLunch5() : 0);
            regt.getExpense().setLunchCount(lunchCount);
            regt.getExpense().setTotalLunchFee(lunchCount * lunchFee);

            Integer dinnerCount = (mp.getDinner1() != null ? mp.getDinner1() : 0)
                    + (mp.getDinner2() != null ? mp.getDinner2() : 0)
                    + (mp.getDinner3() != null ? mp.getDinner3() : 0)
                    + (mp.getDinner4() != null ? mp.getDinner4() : 0)
                    + (mp.getDinner5() != null ? mp.getDinner5() : 0);
            regt.getExpense().setDinnerCount(dinnerCount);
            regt.getExpense().setTotalDinnerFee(dinnerCount * dinnerFee);

            regt.getExpense().setTotalMealsFee(regt.getExpense().getTotalBreakfastFee() + regt.getExpense().getTotalLunchFee() + regt.getExpense().getTotalDinnerFee());
            // Grand total
            grpTotalRegistrationFee += regt.getExpense().getTotalRegistrationFee();
            grpTotalMealFee += regt.getExpense().getTotalMealsFee();
        }

        expense.setTotalRegistrationFee(grpTotalRegistrationFee);
        expense.setTotalMealsFee(grpTotalMealFee);

        return expense;
    }

    public static boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
        } catch (NumberFormatException e) {
            return false;
        } catch (NullPointerException e) {
            return false;
        }
        // only got here if we didn't return false
        return true;
    }
}
