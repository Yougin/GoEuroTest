package ebeletskiy.goeuro.test;

import ebeletskiy.goeuro.test.data.DataInteractor;
import ebeletskiy.goeuro.test.data.api.model.DestinationPoint;
import ebeletskiy.goeuro.test.data.storage.DataSaver;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Matchers.anyListOf;
import static org.mockito.Mockito.verify;

public class ApplicationTest {

  @Mock DataInteractor dataInteractor;
  @Mock DataSaver dataSaver;
  private Application application;

  @Before public void setUp() throws Exception {
    MockitoAnnotations.initMocks(this);

    application = new Application(dataInteractor, dataSaver);
  }

  @Test public void should_invoke_method_for_data_fetching_for_data_interactor() throws Exception {
    application.execute("Berlin");

    verify(dataInteractor).getDestinationPoints("Berlin");
  }

  @Test public void should_invoke_persist_for_data_saver() throws Exception {
    application.execute("Berlin");

    verify(dataSaver).persist(anyListOf((DestinationPoint.class)));
  }
}