package com.upb.backend.utils;

public class AuthUtils {

    public static Boolean verifiedCredentials(String username, String password) {

        return username != null || password != null;
    }

    public static Boolean securedPassword(String username, String password){

        Boolean secured = false;

        int min =8;
        int max=16;
        int digit=0;
        int special=0;
        int upCount=0;
        int loCount=0;

        if(password.contains(username)) {return false;}
        if(password.length()>=min && password.length()<=max){


            for(int i =0;i<password.length();i++){

                char c = password.charAt(i);

                if(Character.isUpperCase(c)){
                    upCount++;
                }

                if(Character.isLowerCase(c)){
                    loCount++;
                }

                if(Character.isDigit(c)){
                    digit++;
                }

                if(c>=33 && c<=46||c==64){
                    special++;
                }
            }
            if(special>=1 && loCount>=1 && upCount>=1 && digit>=1){
                secured = true;
            }

        }
        return secured;
    }

}
