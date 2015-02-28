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
}
