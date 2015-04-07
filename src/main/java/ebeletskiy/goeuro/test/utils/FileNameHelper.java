package ebeletskiy.goeuro.test.utils;

public class FileNameHelper {

  public static int counter;
  private static String fileName;

  public static String getFileName() {
    fileName = "output_" + counter + ".csv";
    counter++;
    return fileName;
  }

  public static String getCurrentFileName() {
    return fileName;
  }


}
