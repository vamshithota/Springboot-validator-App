package com.company.Sampler.exceptionhandlers;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.company.Sampler.beans.Employee;
@Component
@PropertySource("messages.properties")
public class EmployeeValidator implements Validator{
	 @Autowired
	 private MessageSource messageSource;
	 
	@Override
	public boolean supports(Class<?> clazz) {
	
		return Employee.class.equals(clazz);
	}

	/*
	 * employee.name.error= employee Name field can't be empty.
	 * employee.grade.error= Grade should be greater than 0. employee.address.error=
	 * employee address details should not be empty.
	 */
	@Override
	public void validate(Object target, Errors errors) {
		Employee employee = (Employee) target;
    ValidationUtils.rejectIfEmpty(errors, "name",
            messageSource.getMessage("employee.name.error", null, Locale.US));
    if (employee.getGrade() <= 0) {
        errors.rejectValue("grade", messageSource.getMessage("employee.grade.error", null, Locale.US),
                "employee grade should be greater than zero");
    }
    if (null != employee.getAddress() && Boolean.TRUE.equals(employee.getAddress())
            && null == employee.getActorDetails()) {
        errors.rejectValue("address", messageSource.getMessage("employee.address.error", null, Locale.US),
                "employee address details should not be empty");
    }}

}
