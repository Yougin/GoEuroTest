package ebeletskiy.goeuro.test.data;

import ebeletskiy.goeuro.test.data.api.model.DestinationPoint;
import java.util.ArrayList;
import java.util.List;

public class DestinationPointsCreator {
  private static final String TAG = DestinationPointsCreator.class.getSimpleName();

  public static final String M_TYPE = "mType";
  public static final int ID = 42;
  public static final String NAME = "name";
  public static final String TYPE = "type";

  public static final int AMOUNT_OF_FAKE_POINTS = 3;

  public static DestinationPoint createProperDestinationPoint() {
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

  public static List<DestinationPoint> createListOfDestinationPoints() {
    List<DestinationPoint> points = new ArrayList<DestinationPoint>();

    for (int i = 0; i < AMOUNT_OF_FAKE_POINTS; i++) {
      DestinationPoint point = new DestinationPoint();

      point.setmType(M_TYPE);
      point.setId(ID);
      point.setName(NAME);
      point.setType(TYPE);

      DestinationPoint.GeoPosition geoPosition = new DestinationPoint.GeoPosition();
      geoPosition.setLatitude(123.0);
      geoPosition.setLongitude(456.0);

      point.setGeoPosition(geoPosition);

      points.add(point);
    }

    return points;
  }

  public static DestinationPoint createDestinationPointWithNullGeoLocation() {
    DestinationPoint point = new DestinationPoint();

    point.setmType(M_TYPE);
    point.setId(ID);
    point.setName(NAME);
    point.setType(TYPE);

    return point;
  }
}
