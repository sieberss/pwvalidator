package org.example;

public class PwValidator {

    public static boolean isValid(String pw) {
        return isLongEnough(pw) && hasNumber(pw) && hasUpperAndLowercase(pw) && isNoCommonPassword(pw) && hasSpecialCharacter(pw);
    }

    public static boolean isLongEnough(String pw){
        return pw.length()>=8;
    }

    public static boolean hasNumber(String pw){
        for (char c='0'; c<='9'; c++){
            if (pw.indexOf(c)!=-1) return true;
        }
        return false;
    }

    public static boolean hasUpperAndLowercase(String pw){
        boolean foundUpper = false;
        boolean foundLower = false;
        for (int i=0; i<pw.length(); i++) {
            char c = pw.charAt(i);
            if (Character.isUpperCase(c)) {
                foundUpper = true;
            }
            if (Character.isLowerCase(c)) {
                foundLower = true;
            }
        }
        return foundUpper && foundLower;
    }

    public static boolean isNoCommonPassword(String pw){
        String[] commonPasswords = {"Admin123", "Aa123456", "P@ssw0rd", "Pass@123", "Aa@123456", "Abcd1234", "Eliska81", "Admin@123", "Demo@123", "Password1", "Passwort1", "Password123", "Passwort123"};
        for (String commonPassword : commonPasswords) {
            if (pw.equals(commonPassword)) {
                return false;
            }
        }
        return true;
    }

    public static boolean hasSpecialCharacter(String pw){
        for (int i=0; i<pw.length(); i++) {
            char c = pw.charAt(i);
            if ((!Character.isLetter(c)) && (!Character.isDigit(c)) ) {
                return true;
            }
        }
        return false;
    }

    public static String getRandomPw(){
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<8; i++){
            sb.append(getRandomCharacterBetweenSpaceAndDel());
        }
        while (!isValid(sb.toString())){
            sb.append(getRandomCharacterBetweenSpaceAndDel());
        }
        return sb.toString();
    }

     static char getRandomCharacterBetweenSpaceAndDel() {
        return (char) (33 + Math.random() * 95);
    }

}
