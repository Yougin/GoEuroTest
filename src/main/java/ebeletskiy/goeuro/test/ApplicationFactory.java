package ebeletskiy.goeuro.test;

import ebeletskiy.goeuro.test.data.DataInteractorImpl;
import ebeletskiy.goeuro.test.data.api.WebServiceFactory;
import ebeletskiy.goeuro.test.data.storage.DestinationPointHeadersExtractor;
import ebeletskiy.goeuro.test.data.storage.LocalStorageDataSaver;
import ebeletskiy.goeuro.test.utils.FileNameHelper;
import java.io.FileWriter;
import java.io.IOException;

public class ApplicationFactory {

  /**
   * This is why we normally use Dagger :)
   */
  public static Executable getApplication() {
    DataInteractorImpl interactor = new DataInteractorImpl(WebServiceFactory.getWebService());

    DestinationPointHeadersExtractor extractor = new DestinationPointHeadersExtractor();
    LocalStorageDataSaver dataSaver = null;
    try {
      dataSaver =
          new LocalStorageDataSaver(new FileWriter(FileNameHelper.getFileName()), extractor);
    } catch (IOException e) {
      System.out.println("Failed to create a file for output");
      return new DoNothingApplication();
    }

    return new Application(interactor, dataSaver);
  }

  private static class DoNothingApplication implements Executable {

    @Override public void execute(String city) {
      System.out.println("We failed with preparation for the last argument, so doing nothing");
    }
  }
}
