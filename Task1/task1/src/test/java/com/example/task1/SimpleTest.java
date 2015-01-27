package com.example.task1;

import org.testng.annotations.*;


public class SimpleTest {
   
   
 @BeforeClass
 public void setUp() {
   System.out.println("[INFO] Starting Driver!");
 }
 
 @Test
 public void smallTest() {
   System.out.println("[TEST] Test is going...");
 }
 

@AfterClass
 public void tearDown() {
   System.out.println("[INFO] Stopping Driver!");
 }

}
