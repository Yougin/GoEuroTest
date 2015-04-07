package ebeletskiy.goeuro.test;

import ebeletskiy.goeuro.test.data.DataInteractorImpl;
import ebeletskiy.goeuro.test.data.api.WebServiceFactory;
import ebeletskiy.goeuro.test.data.storage.DestinationPointHeadersExtractor;
import ebeletskiy.goeuro.test.data.storage.LocalStorageDataSaver;
import ebeletskiy.goeuro.test.utils.FileNameHelper;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

  public static void main(String[] args) {
    System.out.println("--------------------------------------");

    Application application = null;

    for (String city : args) {
      try {
        application = initApplication();
      } catch (IOException e) {
        System.out.println("Failed create a file for output, exiting the application");
        return;
      }

      application.execute(city);
    }
  }

  /**
   * This is what we normally use Dagger for :)
   */
  private static Application initApplication() throws IOException {
    DataInteractorImpl interactor = new DataInteractorImpl(WebServiceFactory.getWebService());

    DestinationPointHeadersExtractor extractor = new DestinationPointHeadersExtractor();
    LocalStorageDataSaver dataSaver =
        new LocalStorageDataSaver(new FileWriter(FileNameHelper.getFileName()), extractor);

    return new Application(interactor, dataSaver);
  }
}
