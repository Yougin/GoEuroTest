package ebeletskiy.goeuro.test.data.storage;

import org.junit.Before;
import org.junit.Test;

import static ebeletskiy.goeuro.test.data.DestinationPointsCreator.createDestinationPointWithNullGeoLocation;
import static ebeletskiy.goeuro.test.data.DestinationPointsCreator.createProperDestinationPoint;
import static org.assertj.core.api.Assertions.assertThat;

public class DestinationPointHeadersExtractorTest {

  private DestinationPointHeadersExtractor extractor;

  @Before public void setUp() throws Exception {
    extractor = new DestinationPointHeadersExtractor();
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
}