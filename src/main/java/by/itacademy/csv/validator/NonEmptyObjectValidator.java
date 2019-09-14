package by.itacademy.csv.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.reflect.Field;
import java.util.Collection;

public class NonEmptyObjectValidator implements ConstraintValidator<NonEmptyObject, Object> {

    @Override
    public void initialize(NonEmptyObject constraintAnnotation) {
    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        try {
            for (Field field : o.getClass().getDeclaredFields()) {
                field.setAccessible(true);
                if (field.get(o) != null) {
                    if (Collection.class.isAssignableFrom(field.getType())) {
                        if (((Collection) field.get(o)).size() > 0) {
                            return true;
                        }
                    } else {
                        return true;
                    }
                }
            }
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
        }
        return false;
    }
}
