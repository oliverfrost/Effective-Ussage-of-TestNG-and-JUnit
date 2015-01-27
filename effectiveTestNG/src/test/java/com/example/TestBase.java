package com.example;

import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;

public class TestBase {


    @BeforeClass
    public void prepareTestEnvironment() {
       /* String current = getCurrentFolderAddress();

        String currentDir = System.getProperty("user.dir");
        System.out.println("Current dir using System:" +currentDir);

        System.out.println("\n" + current);*/

        File folder = new File("TestDirectory");
        if (!folder.exists()) {
            if (folder.mkdir()) {
                System.out.println("[INFO] Directory is created!");
            } else {
                System.out.println("[ERROR] Failed to create directory!");
            }
        }
        else {
            System.out.println("[WARNING] Directory already exists!");
        }

    }

    @AfterClass
    public void clearTestEnvironment() {


    }

/*
    private String getCurrentFolderAddress(){
        String currentPath = null;

        try {
            currentPath = new File( "." ).getCanonicalPath();
        } catch (IOException e) {
            System.out.println("[ERROR] Was unable to get path for current directory");
            e.printStackTrace();
        }

        return currentPath;
    }*/


}
