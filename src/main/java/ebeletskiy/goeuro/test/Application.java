package ebeletskiy.goeuro.test;

import ebeletskiy.goeuro.test.data.DataInteractor;
import ebeletskiy.goeuro.test.data.api.model.DestinationPoint;
import ebeletskiy.goeuro.test.data.storage.DataSaver;
import ebeletskiy.goeuro.test.utils.FileNameHelper;
import ebeletskiy.goeuro.test.utils.Preconditions;
import java.io.IOException;
import java.util.List;

public class Application implements Executable {

  private final DataInteractor dataInteractorImpl;
  private final DataSaver localStorageDataSaver;

  public Application(DataInteractor dataInteractor, DataSaver dataSaver) {
    this.dataInteractorImpl =
        Preconditions.checkNotNull(dataInteractor, "dataInteractor must be initialized");

    this.localStorageDataSaver =
        Preconditions.checkNotNull(dataSaver, "dataSaver must be initialized");
  }

  public void execute(String city) {
    System.out.println("The application is about to process " + city + " city");

    List<DestinationPoint> points = dataInteractorImpl.getDestinationPoints(city);
    System.out.println("The amount of fetched points is " + points.size());

    if (points.isEmpty()) {
      System.out.println("So there is nothing to save, exiting");
    } else {
      persistData(points);
    }
  }

  private void persistData(List<DestinationPoint> destinationPoints) {
    try {
      localStorageDataSaver.persist(destinationPoints);
      System.out.println("Done! Results saved into "
          + FileNameHelper.getCurrentFileName()
          + " file" + "\n");

    } catch (IOException e) {
      System.out.println("Data was not saved ");
    }
  }
}
