package com.cclife.registration.validator;

import com.cclife.registration.domain.PaymentMethod;
import com.cclife.registration.domain.RegistrationForm;
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

         if (form.getAddress().getHomeState().trim().isEmpty() ) {
            messages.addMessage(new MessageBuilder().error().source("address.homeState").
                    defaultText("Please enter your state. ").build());
        }

         if (form.getAddress().getCountry().trim().isEmpty() ) {
            messages.addMessage(new MessageBuilder().error().source("address.country").
                    defaultText("Please enter your country. ").build());
        }

        if (form.getAddress().getHomeZip().trim().isEmpty() ) {
            messages.addMessage(new MessageBuilder().error().source("address.homeZip").
                    defaultText("Please enter your zip code. ").build());
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
