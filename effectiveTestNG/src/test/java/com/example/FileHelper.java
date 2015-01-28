package com.example;

import java.io.File;
import java.io.IOException;
import java.util.Random;

public class FileHelper {
    private String testDirName = "TestDirectory";

    public void createFile(String fileName){
        File file = new File(testDirName + "/" + fileName);

        try {
            if (file.createNewFile()){
                System.out.println("[INFO] File is created.");
            }else{
                System.out.println("[WARNING] File already exists!");
            }
        } catch (IOException e) {
            System.out.println("[ERROR] Was unable to create new file with name: "+ fileName);
            e.printStackTrace();
        }
    }

    /**
     *  Generates one number in the range you specified with parameters.
     *
     * @param minValue first range value.
     * @param maxValue second range value.
     * @return one integer that is present in the range.
     */
    public static Integer getRandomNumber(int minValue, int maxValue)
    {
        Random random = new Random();
        int randomNumber = 0;
        randomNumber = random.nextInt((maxValue + 1) - minValue) + (minValue);
        return randomNumber;
    }


}
