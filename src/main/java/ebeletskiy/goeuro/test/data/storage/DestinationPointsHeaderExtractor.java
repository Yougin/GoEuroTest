package ebeletskiy.goeuro.test.data.storage;

import ebeletskiy.goeuro.test.data.api.model.DestinationPoint;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class DestinationPointsHeaderExtractor {
  private static final String TAG = DestinationPointsHeaderExtractor.class.getSimpleName();

  public static final String EMPTY_STRING = "";
  public static final String SEPARATOR = ", ";

  private StringBuilder stringBuilder = new StringBuilder();

  /**
   * @param destinationPoint - the DestinationPoint {@link ebeletskiy.goeuro.test.data.api.model.DestinationPoint}
   * object you need to get headers from
   * @return a String object with enumerated headers or empty String if destionationPoint is
   * null
   */
  @NotNull public String getHeaders(@Nullable DestinationPoint destinationPoint) {
    if (destinationPoint == null) {
      return EMPTY_STRING;
    }

    resetStringBuilder();

    DestinationPoint.GeoPosition geoPosition = destinationPoint.getGeoPosition();
    stringBuilder.append(destinationPoint.getmType())
        .append(SEPARATOR)
        .append(destinationPoint.getId())
        .append(SEPARATOR)
        .append(destinationPoint.getName())
        .append(SEPARATOR)
        .append(destinationPoint.getType())
        .append(SEPARATOR)
        .append(geoPosition != null ? geoPosition.getLatitude() : 0.0)
        .append(SEPARATOR)
        .append(geoPosition != null ? geoPosition.getLongitude() : 0.0);

    return stringBuilder.toString();
  }

  private void resetStringBuilder() {
    stringBuilder.setLength(0);
  }
}
