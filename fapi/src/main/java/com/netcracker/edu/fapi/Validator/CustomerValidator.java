package com.netcracker.edu.fapi.Validator;

import com.netcracker.edu.fapi.models.RegistrationCustomerViewModel;

public class CustomerValidator {

    public CustomerValidator() {
    }

    private static final String EMAIL_PATTERN =
            "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" +
                    "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    public boolean validate(RegistrationCustomerViewModel obj) {
        if(validateEmail(obj.getEmail())&&(validatePassword(obj.getPassword()))&&(validateNickname(obj.getUsername()))&&(validateName(obj.getFirstName()))&&(validateSurname(obj.getSurname())))
        {
            return true;
        }else{return false;}
    }

    public boolean validateEmail(String email){
        return email.matches(EMAIL_PATTERN);
    }

    public boolean validatePassword(String password){
        if(password.length()> 0){
            return true;
        }else{
            return false;
        }
    }

    public boolean validateNickname(String nickname){
        if(nickname.length()> 0){
            return true;
        }else{
            return false;
        }
    }

    public boolean validateName(String name){
        if(name.length()> 0){
            return true;
        }else{
            return false;
        }
    }

    public boolean validateSurname(String surname){
        if(surname.length() > 0){
            return true;
        }else{
            return false;
        }
    }

}
