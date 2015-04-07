package ebeletskiy.goeuro.test.utils;

public class FileNameHelper {
  private static final String TAG = FileNameHelper.class.getSimpleName();

  public static int counter;

  public static String getFileName() {
    String fileName = "output_" + counter + ".csv";
    counter++;
    return fileName;
  }
}
