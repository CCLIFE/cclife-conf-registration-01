/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cclife.registration.validator;

import com.cclife.registration.domain.Registrant;
import org.apache.log4j.Logger;
import org.springframework.binding.message.MessageBuilder;
import org.springframework.binding.message.MessageContext;
import org.springframework.binding.validation.ValidationContext;
import org.springframework.stereotype.Component;


@Component
/**
 *
 * @author Weimin
 */
public class RegistrantValidator {
    
    private static final Logger logger = Logger.getLogger(RegistrantValidator.class);
    
    /**
     * Added for issue5.
     * Validation for step2.
     */
    public void validateStep2(Registrant registrant, ValidationContext context) {
    
        logger.debug("Start validate step2.");

        MessageContext messages = context.getMessageContext();

        if (registrant.getPerson().getFirstName().trim().isEmpty() ) {
            messages.addMessage(new MessageBuilder().error().source("person.firstName").
                    defaultText("Please enter your English first name. ").build());
        }
        
        if (registrant.getPerson().getLastName().trim().isEmpty() ) {
            messages.addMessage(new MessageBuilder().error().source("person.lastName").
                    defaultText("Please enter your English last name. ").build());
        }

        if ( ( registrant.getPerson().getGender() == null ) || ( registrant.getPerson().getGender().trim().isEmpty() ) ){
            messages.addMessage(new MessageBuilder().error().source("person.gender").
                    defaultText("Please enter your gender. ").build());
        }

        if (registrant.getPerson().getAge().trim().isEmpty() ) { 
            messages.addMessage(new MessageBuilder().error().source("person.age").
                    defaultText("Please select your age or age group. ").build());
        }
        else if (  !registrant.getPerson().getAge().trim().contains("A")  ) { 
            if (registrant.getPerson().getStatus().trim().isEmpty() ) {
               messages.addMessage(new MessageBuilder().error().source("person.status").
                       defaultText("Grade is required for youth. ").build());
            }
        }
        
        /** 
         * Need to add logic to check if the registrant is youth, if true, then email is required. 
         */
        
        if( true ){ 
            String email1 = registrant.getPerson().getEmail().trim();
            String email2 = registrant.getPerson().getMisc1().trim();
            if ( email1.isEmpty() || !email1.contains("@") ) {
                messages.addMessage(new MessageBuilder().error().source("person.email").
                        defaultText("Please enter valid email address. ").build());
            }
            else{
                if ( email2.isEmpty() || !email2.contains("@") ) {
                    messages.addMessage(new MessageBuilder().error().source("person.misc1").
                            defaultText("Please enter valid confirm email. ").build());
                }
                else{
                    if( !email1.equalsIgnoreCase(email2) ){
                         messages.addMessage(new MessageBuilder().error().source("person.email").
                                defaultText("Email and confirm email are not identical. ").build());

                    }
                }
            }
        }
        
        logger.debug("Done validate step2.");
    }
}
