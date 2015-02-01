package com.example;

import org.testng.annotations.*;
import java.io.File;

public class TestBase {

    @BeforeSuite(alwaysRun = true)
    public void prepareTestEnvironment() {
        File folder = new File("TestDirectory");
        createTestDirectory(folder);
    }


    @AfterSuite(alwaysRun = true)
    public void clearTestEnvironment() {
        System.out.println("--------------------FIXTURE 2");
    }


    /** Creates directory in the current folder
     *
     * @param folder example of File type with directory`s name
     */
    private void createTestDirectory(File folder){
        if (!folder.exists()) {
            if (folder.mkdir()) {
                System.out.println("[INFO] Directory was created.");
            } else {
                System.out.println("[ERROR] Failed to create directory!");
            }
        } else {
            System.out.println("[WARNING] Directory already exists!");
        }
    }


    /** At first removes all the files inside the directory
     *  and then removes the directory itself.
     *
     * @param folder example of File type with directory`s name
     */
    private void deleteDirectoryAndAllFilesInIt(File folder) {
        try {
            if (folder.isDirectory()) {
                File[] entries = folder.listFiles();
                for (File currentFile : entries) {
                    deleteDirectoryAndAllFilesInIt(currentFile);
                }
                folder.delete();
            } else {
                folder.delete();
            }
            System.out.println("[INFO] Removed file: " + folder.getPath());
        } catch (Throwable e) {
            System.out.println("[ERROR] Was not able to remove file: " + folder.getPath());
            e.printStackTrace();
        }
    }
}








