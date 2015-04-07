package ebeletskiy.goeuro.test.data;

import ebeletskiy.goeuro.test.data.api.WebService;
import ebeletskiy.goeuro.test.data.api.model.DestinationPoint;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

public class DataInteractorImplTest {

  public static final String EMPTY_STRING = "";
  public static final int AMOUNT_OF_FAKE_POINTS = 3;
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
      throws Exception {
    when(webService.getDestinationPoints(BERLIN_ARGUMENT)).thenReturn(getListOfFakePoints());

    List<DestinationPoint> points = interactor.getDestinationPoints(BERLIN_ARGUMENT);

    assertThat(points).hasSize(AMOUNT_OF_FAKE_POINTS);
  }

  @Test public void should_return_empty_collection_on_negative_web_response() throws Exception {
    when(webService.getDestinationPoints(BERLIN_ARGUMENT)).thenReturn(null);

    List<DestinationPoint> points = interactor.getDestinationPoints(BERLIN_ARGUMENT);

    assertThat(points).isEmpty();
  }

  private List<DestinationPoint> getListOfFakePoints() {
    List<DestinationPoint> points = new ArrayList<DestinationPoint>();

    for (int i = 0; i < AMOUNT_OF_FAKE_POINTS; i++) {
      points.add(new DestinationPoint());
    }

    return points;
  }
}