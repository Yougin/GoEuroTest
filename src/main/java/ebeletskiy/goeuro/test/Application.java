package ebeletskiy.goeuro.test;

import ebeletskiy.goeuro.test.data.DataInteractorImpl;
import ebeletskiy.goeuro.test.data.storage.DataSaver;
import ebeletskiy.goeuro.test.utils.Preconditions;

public class Application {

  private final DataInteractorImpl dataInteractorImpl;
  private final DataSaver localStorageDataSaver;

  public Application(DataInteractorImpl dataInteractorImpl, DataSaver dataSaver) {
    this.dataInteractorImpl =
        Preconditions.checkNotNull(dataInteractorImpl, "dataInteractor must be initialized");

    this.localStorageDataSaver =
        Preconditions.checkNotNull(dataSaver, "dataSaver must be initialized");
  }

  public void execute() {
  }
}
