package ebeletskiy.goeuro.test;

import ebeletskiy.goeuro.test.data.DataInteractor;
import ebeletskiy.goeuro.test.data.api.model.DestinationPoint;
import ebeletskiy.goeuro.test.data.storage.DataSaver;
import java.util.Collections;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Matchers.anyListOf;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;

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

  @Test public void should_be_no_interaction_with_saver_if_zero_points_fetched() throws Exception {
    when(dataInteractor.getDestinationPoints(anyString())).thenReturn(Collections.EMPTY_LIST);

    application.execute("");

    verifyZeroInteractions(dataSaver);
  }
}