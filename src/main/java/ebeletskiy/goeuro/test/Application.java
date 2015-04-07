package ebeletskiy.goeuro.test;

import ebeletskiy.goeuro.test.data.DataInteractor;
import ebeletskiy.goeuro.test.data.api.model.DestinationPoint;
import ebeletskiy.goeuro.test.data.storage.DataSaver;
import ebeletskiy.goeuro.test.utils.Preconditions;
import java.io.IOException;
import java.util.List;

public class Application {

  private final DataInteractor dataInteractorImpl;
  private final DataSaver localStorageDataSaver;

  public Application(DataInteractor dataInteractor, DataSaver dataSaver) {
    this.dataInteractorImpl =
        Preconditions.checkNotNull(dataInteractor, "dataInteractor must be initialized");

    this.localStorageDataSaver =
        Preconditions.checkNotNull(dataSaver, "dataSaver must be initialized");
  }

  public void execute(String... cities) {
    for (String city : cities) {
      System.out.println("About to process the " + city + " city");

      List<DestinationPoint> points = dataInteractorImpl.getDestinationPoints(city);
      persistData(points);
    }
  }

  private void persistData(List<DestinationPoint> destinationPoints) {
    try {
      localStorageDataSaver.persist(destinationPoints);
      System.out.println("Data saved successfully");
    } catch (IOException e) {
      System.out.println("Data was not saved");
    }
  }
}
