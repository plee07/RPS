package com.company;

import org.junit.Assert;
import org.junit.Test;

public class MainTest {

    @Test
    public void MenuValidatorTest() {
        // test for validator to be case insensitive
        Assert.assertEquals(true, Validator.menuInputValidator("pLaY"));
        Assert.assertEquals(true, Validator.menuInputValidator("hIsToRY"));
        Assert.assertEquals(true, Validator.menuInputValidator("QUIT"));

        // test for false for invalid input
        Assert.assertEquals(false, Validator.menuInputValidator("p1aY"));
        Assert.assertEquals(false, Validator.menuInputValidator("HISSTORY"));
        Assert.assertEquals(false, Validator.menuInputValidator("quit1"));
    }

    @Test
    public void MoveValidatorTest() {
        // test for validator to be case insensitive
        Assert.assertEquals(true, Validator.moveInputValidator("ROCK"));
        Assert.assertEquals(true, Validator.moveInputValidator("paper"));
        Assert.assertEquals(true, Validator.moveInputValidator("SCIssor"));

        // test for false for invalid input
        Assert.assertEquals(false, Validator.moveInputValidator(""));
        Assert.assertEquals(false, Validator.moveInputValidator("111"));
        Assert.assertEquals(false, Validator.moveInputValidator("rock "));
    }

    @Test
    public void OpponentValidatorTest(){
        // test for validator to be case insensitive
        Assert.assertEquals(true, Validator.opponentInputValidator("PlAyER"));
        Assert.assertEquals(true, Validator.opponentInputValidator("CoMpUtER"));

        // test for false for invalid input
        Assert.assertEquals(false, Validator.opponentInputValidator(""));
        Assert.assertEquals(false, Validator.opponentInputValidator("111"));
    }
}
