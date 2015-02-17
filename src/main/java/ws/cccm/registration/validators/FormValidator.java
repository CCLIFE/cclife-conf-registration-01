package ws.cccm.registration.validators;

import org.apache.log4j.Logger;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ws.cccm.application.model.Form;

public class FormValidator implements Validator {

    private static final Logger logger = Logger.getLogger(FormValidator.class);

    /**
     * This Validator validates just Person instances
     */
    @Override
    public boolean supports(Class clazz) {
        return Form.class.equals(clazz);
    }

    @Override
    public void validate(Object obj, Errors e) {

//        ValidationUtils.rejectIfEmpty(e, "homeCity", "errors.required");

        Form p = (Form) obj;

//        if (p.getHomeStreetAddress() == null || p.getHomeStreetAddress().length() == 0) {
//            e.rejectValue("homeStreetAddress", "errors.required");
//        }

        logger.debug("RegistrationFormValidator- validate Start : Church ID[" + p.getRegistrationDate() + "]");

        //        Registration data = getRegistration();
//        Iterator itr = p.getRegistrants().iterator();
//        int count = 0;
//        Boolean incomplete = true;
//
//        while (itr.hasNext()) {
//
//            Person registration = (Person) itr.next();
//
//
//            if (registration != null) {
//                count++;
//                if ((((registration.getFirstName() != null && registration.getFirstName().length() > 0) && (registration.getLastName() != null && registration.getLastName().length() > 0)) || ((registration.getChineseName() != null && registration.getChineseName().length() > 0)))) {
//                    if ((registration.getAge() != null && registration.getAge().length() > 0)) {
//                        incomplete = false;
//                    } else {
//                        e.reject("Age is required information for Registrant #" + count + " ");
//                    }
//                }
//            }
//        }

        logger.debug("RegistrationFormValidator- validate End : Church ID[ " + p.getRegistrationDate() + "]");

    }
}
