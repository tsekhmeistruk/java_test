package com.sample.test.demo.tests;

import org.testng.annotations.Test;
import com.sample.test.demo.abstracts.TestBase;

public class DemoTest extends TestBase {

    @Test
    public void demoTest() {
        System.out.println("HELLO WORLD");
    }
}
