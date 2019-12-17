package com.netcracker.edu.fapi.Validator;

import com.netcracker.edu.fapi.models.RegistrationAdvertiserViewModel;

public class AdvertiserValidator {

    public AdvertiserValidator() {
    }

    private static final String EMAIL_PATTERN =
            "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" +
                    "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    public boolean validate(RegistrationAdvertiserViewModel obj) {
        if(validateEmail(obj.getEmail())&&(validatePassword(obj.getPassword()))&&(validateNickname(obj.getUsername()))&&(validateName(obj.getName())))
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
}
