package vaildation;



import org.apache.commons.validator.routines.EmailValidator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;



/**
 * Created by root on 6/5/17.
 */
public class VaildEmailimpl implements ConstraintValidator<ValidEmail,String> {

    private int min;

    public void initialize(ValidEmail validEmail) {

        min = validEmail.min();

    }

    public boolean isValid(String email, ConstraintValidatorContext constraintValidatorContext) {
        if(email.length() < min) {
            return false;
        }

        if (!EmailValidator.getInstance().isValid(email)) {
            // ! for false boolean
            return false;
        }

        return true;

    }
}
