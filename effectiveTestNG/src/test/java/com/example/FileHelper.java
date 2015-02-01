package com.example;

import java.io.File;
import java.io.IOException;
import java.util.Random;

public class FileHelper {
    private String testDirName = "TestDirectory";

    /** Creates new file inside test directory if the file with
     *  the same name doesn`t exist yet.
     *
     * @param fileName any string value
     */
    public void createFile(String fileName){
        File file = new File(testDirName + "/" + fileName);

        try {
            if (file.createNewFile()){
                System.out.println("[INFO] File is created: "+ file.getName());
            }else{
                System.out.println("[WARNING] File with name " + file.getName() +
                                    "already exists or another issue appeared.");
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


    /** Checks if file with given name exists in Test folder
     *
     * @param fileName name of the file you want to find
     * @return true if file exists or else if not
     */
    public boolean isFilePresent(String fileName){
        File file = new File(testDirName + "/" + fileName);
        return file.exists();
    }


    public boolean isTheOnlyFileWithThisName() {
        int filesWithSameName = 0;
        File folder = new File(testDirName);
        File[] entries = folder.listFiles();

        for (File currentFile : entries) {
            if(currentFile.getName().equals("new_file1.txt")){
                filesWithSameName++;
            }
        }

        return (filesWithSameName == 1);
    }

    public Object generateRandomFileName() {
        return "new_file" + new Random().nextInt();
    }

    public Object generateRandomFileFormat() {
        String[] formats = new String[]{".xml",".txt",".json", ".csv", ".jpeg", ".bmp", ".gif", ".mp3"};
        return formats[getRandomNumber(0,7)];
    }
}
