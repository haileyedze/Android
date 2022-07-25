package com.example.and10_intentresult;

import java.io.Serializable;

public class TestDTO implements Serializable {
    private int testInt;
    private String testString;

    public TestDTO(int testInt, String testString) {
        this.testInt = testInt;
        this.testString = testString;
    }

    public int getTestInt() {
        return testInt;
    }

    public void setTestInt(int testInt) {
        this.testInt = testInt;
    }

    public String getTestString() {
        return testString;
    }

    public void setTestString(String testString) {
        this.testString = testString;
    }
}
