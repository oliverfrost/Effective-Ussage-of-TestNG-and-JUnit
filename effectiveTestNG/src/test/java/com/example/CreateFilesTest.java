package com.example;

import org.testng.annotations.*;
import java.io.IOException;


public class CreateFilesTest extends TestBase{
     @Test
     public void createFileWithPermanentName() throws IOException {
         FileHelper fileHelper = new FileHelper();
         fileHelper.createFile("new_file1.txt");
     }

     @Test
      public void createFileWithRandomName()  {
         FileHelper fileHelper = new FileHelper();
         String fileName = "new_file"+ (fileHelper.getRandomNumber(1,100)).toString();
         fileHelper.createFile(fileName);
      }

      @Test
      public void createFileWithEmptyName()  {
         FileHelper fileHelper = new FileHelper();
         fileHelper.createFile("");
      }

      @Test(dependsOnMethods = { "createFileWithPermanentName" })
      public void createFileWithAlreadyExistingName()  {
         FileHelper fileHelper = new FileHelper();
         fileHelper.createFile("new_file1.txt");
      }
}
