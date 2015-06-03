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
                    code("personFirstName").build());
        }
        
        if (registrant.getPerson().getLastName().trim().isEmpty() ) {
            messages.addMessage(new MessageBuilder().error().source("person.lastName").
                    code("personLastName").build());
        }

        if ( ( registrant.getPerson().getGender() == null ) || ( registrant.getPerson().getGender().trim().isEmpty() ) ){
            messages.addMessage(new MessageBuilder().error().source("person.gender").
                    code("personGender").build());
        }

        //Age is required for all registrants
        if (registrant.getPerson().getAge().trim().isEmpty() ) { 
            messages.addMessage(new MessageBuilder().error().source("person.age").
                    code("personAge").build());
        } 
        //Grade and Dietary restrictions are required for all under 18
        else if (  !registrant.getPerson().getAge().trim().contains("A")  ) { 
            if (registrant.getPerson().getStatus().trim().isEmpty() ) {
               messages.addMessage(new MessageBuilder().error().source("person.status").
                       code("personGrade").build());
            }
            if (registrant.getPerson().getAllergies().trim().isEmpty() ) {
               messages.addMessage(new MessageBuilder().error().source("person.allergies").
                       code("personAllergies").build());
            }
            //Email and Health Card number are required for youth 13 to 18
            int ageToCheck = Integer.parseInt(registrant.getPerson().getAge().trim() );
            if( ( ageToCheck >= 13 ) && ( ageToCheck <=18 ) ){
                if (registrant.getPerson().getHealthCardNo().trim().isEmpty() ) {
                   messages.addMessage(new MessageBuilder().error().source("person.healthCardNo").
                           code("personHealthCardNo").build());
                }
                
                 String email1 = registrant.getPerson().getEmail().trim();
                 String email2 = registrant.getPerson().getMisc1().trim();
                 if ( email1.isEmpty() || !email1.contains("@") ) {
                     messages.addMessage(new MessageBuilder().error().source("person.email").
                             code("validEmail").build());
                 }
                 else{
                     if ( email2.isEmpty() || !email2.contains("@") ) {
                         messages.addMessage(new MessageBuilder().error().source("person.misc1").
                                 code("validConfirmEmail").build());
                     }
                     else{
                         if( !email1.equalsIgnoreCase(email2) ){
                              messages.addMessage(new MessageBuilder().error().source("person.email").
                                     code("identicalEmail").build());

                         }
                     }
                 }
            }    
        }
        
        logger.debug("Done validate step2.");
    }
}
