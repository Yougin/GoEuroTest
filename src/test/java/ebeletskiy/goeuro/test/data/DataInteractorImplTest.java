package ebeletskiy.goeuro.test.data;

import ebeletskiy.goeuro.test.data.api.WebService;
import ebeletskiy.goeuro.test.data.api.error.NetworkConnectionException;
import ebeletskiy.goeuro.test.data.api.model.DestinationPoint;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static ebeletskiy.goeuro.test.data.DestinationPointsCreator.AMOUNT_OF_FAKE_POINTS;
import static ebeletskiy.goeuro.test.data.DestinationPointsCreator.createListOfDestinationPoints;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

public class DataInteractorImplTest {

  public static final String EMPTY_STRING = "";
  public static final String BERLIN_ARGUMENT = "Berlin";

  private DataInteractorImpl interactor;

  @Mock WebService webService;

  @Before public void setUp() throws Exception {
    MockitoAnnotations.initMocks(this);

    interactor = new DataInteractorImpl(webService);
  }

  @Test(expected = NullPointerException.class)
  public void should_throw_an_exception_if_webservice_wasnt_instantiated() throws Exception {
    new DataInteractorImpl(null);
  }

  @Test public void should_return_empty_collection_if_passed_argument_is_null() throws Exception {
    List<DestinationPoint> points = interactor.getDestinationPoints(null);

    assertThat(points).isEmpty();
  }

  @Test public void should_return_empty_collection_if_passed_argument_is_empty_string()
      throws Exception {
    List<DestinationPoint> points = interactor.getDestinationPoints(EMPTY_STRING);

    assertThat(points).isEmpty();
  }

  @Test public void should_return_proper_amount_of_points_on_positive_web_response()
      throws Exception, NetworkConnectionException {
    when(webService.getDestinationPoints(BERLIN_ARGUMENT)).thenReturn(
        createListOfDestinationPoints());

    List<DestinationPoint> points = interactor.getDestinationPoints(BERLIN_ARGUMENT);

    assertThat(points).hasSize(AMOUNT_OF_FAKE_POINTS);
  }

  @Test public void should_return_empty_collection_on_negative_web_response()
      throws Exception, NetworkConnectionException {
    when(webService.getDestinationPoints(BERLIN_ARGUMENT)).thenReturn(null);

    List<DestinationPoint> points = interactor.getDestinationPoints(BERLIN_ARGUMENT);

    assertThat(points).isEmpty();
  }

  @Test public void should_return_empty_collection_if_no_network_connection()
      throws Exception, NetworkConnectionException {
    when(webService.getDestinationPoints(BERLIN_ARGUMENT)).thenThrow(new NetworkConnectionException());

    List<DestinationPoint> points = interactor.getDestinationPoints(BERLIN_ARGUMENT);

    assertThat(points).isEmpty();
  }
}