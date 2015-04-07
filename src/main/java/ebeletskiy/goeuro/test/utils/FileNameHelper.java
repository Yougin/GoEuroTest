package ebeletskiy.goeuro.test.utils;

public class FileNameHelper {

  public static int counter;

  public static String getFileName() {
    String fileName = "output_" + counter + ".csv";
    counter++;
    return fileName;
  }
}
