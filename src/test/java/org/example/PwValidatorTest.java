package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PwValidatorTest {

    @Test
    void isLongEnough_shouldReturnFalseWhenCalledWith_1234567(){
        String testPw = "1234567";
        assertFalse(PwValidator.isLongEnough(testPw));
    }

    @Test
    void isLongEnough_shouldReturnTrueWhenCalledWith_12345678(){
        String testPw = "12345678";
        assertTrue(PwValidator.isLongEnough(testPw));
    }

    @Test
    void hasNumber_shouldReturnFalseWhenCalledWithLettersOnly(){
        assertFalse(PwValidator.hasNumber("Dieser Text enthält keine Ziffern"));
    }

    @Test
    void hasNumber_shouldReturnTrueWhenCalledWithDigitInPw(){
        assertTrue(PwValidator.hasNumber("Dieser Text enthält 1 Ziffer"));
    }

    @Test
    void hasUpperAndLowercase_shouldReturnFalseWhenCalledWithLowercaseOnly(){
        assertFalse(PwValidator.hasUpperAndLowercase("alles kleingeschrieben"));
    }

    @Test
    void hasUpperAndLowercase_shouldReturnFalseWhenCalledWithUppercaseOnly(){
        assertFalse(PwValidator.hasUpperAndLowercase("HIER IST ALLES GROSS"));
    }

    @Test
    void hasUpperAndLowercase_shouldReturnTrueWhenCalledWithMixedcase(){
        assertTrue(PwValidator.hasUpperAndLowercase("Fast alles kleingeschrieben"));
    }

    @Test
    void isNoCommonPassword_shouldReturnFalseWhenCalledWith_Passwort1(){
        assertFalse(PwValidator.isNoCommonPassword("Passwort1"));
    }

    @Test
    void isNoCommonPassword_shouldReturnFalseWhenCalledWith_Aa123456(){
        assertFalse(PwValidator.isNoCommonPassword("Aa123456"));
    }

    @Test
    void isNoCommonPassword_shouldReturnFalseWhenCalledWith_Admin123(){
        assertFalse(PwValidator.isNoCommonPassword("Admin123"));
    }
    @Test
    void isNoCommonPassword_shouldReturnTrueWhenCalledWithQrd347fre(){
        assertTrue(PwValidator.isNoCommonPassword("Qrd347fre123"));
    }



}