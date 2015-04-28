package com.cclife.registration.validator;

import com.cclife.registration.domain.PaymentMethod;
import com.cclife.registration.domain.RegistrationForm;
import com.cclife.registration.domain.LabelValue;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.binding.message.MessageBuilder;
import org.springframework.binding.message.MessageContext;
import org.springframework.binding.validation.ValidationContext;
import org.springframework.stereotype.Component;


@Component
public class FormValidator {

    private static final Logger logger = Logger.getLogger(FormValidator.class);

    public void validateReview(RegistrationForm form, ValidationContext context) {

        MessageContext messages = context.getMessageContext();

         if( !form.getChkPmt() ){
           messages.addMessage(new MessageBuilder().error().source("chkPmt").
                    defaultText("Please check the checkbox to authorize payment." ).build());
        }
                
        if (form.getPaymentMethod() != PaymentMethod.CREDIT_CARD && form.getPaymentMethod() != PaymentMethod.PERSONAL_CHECK) {
            messages.addMessage(new MessageBuilder().error().source("paymentMethod").
                    defaultText("Please select your payment option").build());
        }

        logger.debug("Validate review1 state..[" + form.getPaymentMethod() + "]");

    }
        
    public void validateStep1(RegistrationForm form, ValidationContext context) {
        
        MessageContext messages = context.getMessageContext();

        if (form.getAddress().getHomeAddress().trim().isEmpty() ) {
            messages.addMessage(new MessageBuilder().error().source("address.homeAddress").
                    defaultText("Please enter your home address. ").build());
        }

        if (form.getAddress().getHomeCity().trim().isEmpty() ) {
            messages.addMessage(new MessageBuilder().error().source("address.homeCity").
                    defaultText("Please enter your city. ").build());
        }

        if (form.getAddress().getUcCountry().trim().isEmpty() ) {
            messages.addMessage(new MessageBuilder().error().source("address.ucCountry").
                    defaultText("Please enter your country. ").build());
        }else{
             String countrySelected = form.getAddress().getUcCountry().trim();
             if( !countrySelected.equals("OC")){  //US or Canada
                if (form.getAddress().getUcState().trim().isEmpty() ) {
                   messages.addMessage(new MessageBuilder().error().source("address.ucState").
                           defaultText("Please enter your state/province. ").build());
                }else{
    
                    form.getAddress().setCountry( countrySelected );
                    form.getAddress().setHomeState( form.getAddress().getUcState().trim() );
                }
                if( countrySelected.equals("CA")){  //if CA, then initialize the select drop down list
                    List<LabelValue> stateList = new ArrayList<LabelValue>();

                    stateList.add(new LabelValue("Alberta", "AB"));
                    stateList.add(new LabelValue("British Columbia", "BC"));
                    stateList.add(new LabelValue("Manitoba", "MB"));
                    stateList.add(new LabelValue("New Brunswick", "NB"));
                    
                    stateList.add(new LabelValue("Newfoundland and Labrador", "NL"));
                    stateList.add(new LabelValue("Nova Scotia", "NS"));
                    stateList.add(new LabelValue("Northwest Territories", "NT"));
                    stateList.add(new LabelValue("Nunavut", "NU"));
                    
                    stateList.add(new LabelValue("Ontario", "ON"));
                    stateList.add(new LabelValue("rince Edward Island", "PE"));
                    stateList.add(new LabelValue("Quebec", "QC"));
                    stateList.add(new LabelValue("Saskatchewan", "SK"));
                    
                    stateList.add(new LabelValue("Yukon", "YT"));
                    
                    form.setStateList(stateList);
                }
            }else{ //other country
                if (form.getAddress().getOtherCountry().trim().isEmpty() ) {
                   messages.addMessage(new MessageBuilder().error().source("address.otherCountry").
                           defaultText("Please enter your country. ").build());
                }
                 
                if (form.getAddress().getOtherState().trim().isEmpty() ) {
                   messages.addMessage(new MessageBuilder().error().source("address.otherState").
                           defaultText("Please enter your state/province. ").build());
                }else{
                    form.getAddress().setCountry( form.getAddress().getOtherCountry().trim() );
                    form.getAddress().setHomeState( form.getAddress().getOtherState().trim() );
                }
              }
         }

        if (form.getAddress().getHomeZip().trim().isEmpty() ) {
            messages.addMessage(new MessageBuilder().error().source("address.homeZip").
                    defaultText("Please enter your zip code. ").build());
        }
        else{
            String zip = form.getAddress().getHomeZip().trim();
            zip=zip.replaceAll("[\\-]","");
            if(!zip.matches("[0-9]+") ){
                messages.addMessage(new MessageBuilder().error().source("address.homeZip").
                        defaultText("Please enter valid zip code.").build());
            }
         }
                
        if (form.getAddress().getHomePhone().trim().isEmpty() ) {
            messages.addMessage(new MessageBuilder().error().source("address.homePhone").
                    defaultText("Please enter your phone number. ").build());
        }
        else{  
            String phone = form.getAddress().getHomePhone().trim();
            phone=phone.replaceAll("[\\-]","");
            if(!phone.matches("[0-9]+") ){
                messages.addMessage(new MessageBuilder().error().source("address.homePhone").
                        defaultText("Please enter valid phone number.").build());
            }
        }
        
        String email1 = form.getAddress().getMisc1().trim();
        String email2 = form.getAddress().getMisc2().trim();
        if ( email1.isEmpty() || !email1.contains("@") ) {
            messages.addMessage(new MessageBuilder().error().source("address.misc1").
                    defaultText("Please enter valid email address. ").build());
        }
        else{
            if ( email2.isEmpty() || !email2.contains("@") ) {
                messages.addMessage(new MessageBuilder().error().source("address.misc2").
                        defaultText("Please enter valid confirm email. ").build());
            }
            else{
                if( !email1.equalsIgnoreCase(email2) ){
                     messages.addMessage(new MessageBuilder().error().source("address.misc1").
                            defaultText("Email and confirm email are not identical. ").build());

                }
            }
        }
            
     logger.debug("Validate step1 state..[" + form.getAddress() + "]");

        
    }
}
