package ebeletskiy.goeuro.test.data.storage;

import ebeletskiy.goeuro.test.data.api.model.DestinationPoint;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DestinationPointsHeaderExtractorTest {

  public static final String M_TYPE = "mType";
  public static final int ID = 42;
  public static final String NAME = "name";
  public static final String TYPE = "type";
  private DestinationPointsHeaderExtractor extractor;

  @Before public void setUp() throws Exception {
    extractor = new DestinationPointsHeaderExtractor();
  }

  @Test public void should_return_empty_string_if_passed_argument_is_null() throws Exception {
    String headers = extractor.getHeaders(null);

    assertThat(headers).isEmpty();
  }

  @Test public void should_return_string_in_right_format_for_proper_destination_point()
      throws Exception {
    String headers = extractor.getHeaders(createProperDestinationPoint());

    assertThat(headers).isEqualTo("mType, 42, name, type, 123.0, 456.0");
  }

  @Test public void should_return_proper_results_one_by_one() throws Exception {
    String first = extractor.getHeaders(createProperDestinationPoint());
    assertThat(first).isEqualTo("mType, 42, name, type, 123.0, 456.0");

    String second = extractor.getHeaders(createProperDestinationPoint());
    assertThat(second).isEqualTo("mType, 42, name, type, 123.0, 456.0");
  }

  @Test public void should_return_zero_values_for_coordinate_if_they_are_null() throws Exception {
    String first = extractor.getHeaders(createDestinationPointWithNullGeoLocation());
    assertThat(first).isEqualTo("mType, 42, name, type, 0.0, 0.0");

  }

  private DestinationPoint createProperDestinationPoint() {
    DestinationPoint point = new DestinationPoint();

    point.setmType(M_TYPE);
    point.setId(ID);
    point.setName(NAME);
    point.setType(TYPE);

    DestinationPoint.GeoPosition geoPosition = new DestinationPoint.GeoPosition();
    geoPosition.setLatitude(123.0);
    geoPosition.setLongitude(456.0);

    point.setGeoPosition(geoPosition);

    return point;
  }

  private DestinationPoint createDestinationPointWithNullGeoLocation() {
    DestinationPoint point = new DestinationPoint();

    point.setmType(M_TYPE);
    point.setId(ID);
    point.setName(NAME);
    point.setType(TYPE);

    return point;
  }
}