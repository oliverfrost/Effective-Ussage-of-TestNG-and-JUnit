package com.example;


import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import static org.hamcrest.MatcherAssert.assertThat;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.testng.Assert.*;


public class CreateFilesTest extends TestBase{

    /* Passing parameters with .xml file */
    @Test(groups = {"positive"})
    @Parameters({"fileName", "fileFormat"})
    public void createFileWithCombinedName(String fileName, String fileFormat) {
        // Test
        String combinedName = fileName + "." + fileFormat;
        FileHelper fileHelper = new FileHelper();
        fileHelper.createFile(combinedName);

        // Asserts
        assertTrue(fileHelper.isFilePresent(combinedName), "[ERROR] No file '" + combinedName + "' in folder.");
    }


    /* Passing parameters with Data Provider that generates random names */
    @Test(groups = {"positive"}, dataProvider = "generateRandomFileNames")
    public void createFileWithNameFromDataProvider(String name, String format) {
        // Test
        String combinedName = name + format;
        FileHelper fileHelper = new FileHelper();
        fileHelper.createFile(combinedName);

        // Asserts
        assertTrue(fileHelper.isFilePresent(combinedName), "[ERROR] No file '" + combinedName + "' in folder.");
    }


    /* Passing parameters with Data Provider that loads names from file */
    @Test(groups = {"positive"}, dataProviderClass = DataProviders.class, dataProvider = "loadNamesFromFile")
    public void createFileWithNameLoadedFromFile(String name, String format) {
        // Test
        String combinedName = name + format;
        FileHelper fileHelper = new FileHelper();
        fileHelper.createFile(combinedName);

        // Asserts
        assertTrue(fileHelper.isFilePresent(combinedName), "[ERROR] No file '" + combinedName + "' in folder.");
    }


    // ======== OLD TESTS THAT WERE NOT CHANGED =======


     @Test(groups = {"positive"})
     public void createFileWithPermanentName() {
         // Test
         String fileName = "new_file1.txt";
         FileHelper fileHelper = new FileHelper();
         fileHelper.createFile(fileName);

         // Asserts
         assertTrue(fileHelper.isFilePresent(fileName), "[ERROR] No file '" + fileName + "' in folder.");
     }


     @Test(groups = {"positive"})
      public void createFileWithRandomName()  {
         // Test
    	 FileHelper fileHelper = new FileHelper();
         String fileName = "new_file"+ (fileHelper.getRandomNumber(1,100)).toString()+".txt";
         fileHelper.createFile(fileName);

         // Asserts
         SoftAssert softAssert = new SoftAssert();
         softAssert.assertTrue(fileName.length() > 0, "[ERROR] File`s length is 0.");
         softAssert.assertEquals(fileName.substring(0,8), "new_file", "[ERROR] File name is incorrect.");
         softAssert.assertAll();

      }


      @Test(groups = {"negative"})
      public void createFileWithEmptyName()  {
         // Test
    	 FileHelper fileHelper = new FileHelper();
         fileHelper.createFile("");

         // Asserts
         assert !(new File("")).exists();
      }


      @Test(groups = {"negative"})
      public void createFileWithAlreadyExistingName()  {
         // Test
         String fileName = "new_file1.txt";
         FileHelper fileHelper = new FileHelper();

         // Create file if it doesn`t exist
         if (!fileHelper.isFilePresent(fileName)){
             fileHelper.createFile(fileName);
         }

         fileHelper.createFile(fileName);

          // Asserts
          assertThat("[ERROR] There is more than 1 file with name: " + fileName, fileHelper.isTheOnlyFileWithThisName());
      }


    @DataProvider
    public Iterator<Object[]> generateRandomFileNames() {
        List<Object[]> data = new ArrayList<Object[]>();
        FileHelper fileHelper = new FileHelper();

        for (int i = 0; i < 10; i++) {
            data.add(new Object[]{
                    fileHelper.generateRandomFileName(),
                    fileHelper.generateRandomFileFormat()
            });
        }
        return data.iterator();
    }
}
