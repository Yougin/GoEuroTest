package ebeletskiy.goeuro.test.data.api;

import ebeletskiy.goeuro.test.data.api.model.DestinationPoint;
import java.util.List;
import retrofit.http.GET;
import retrofit.http.Path;

public interface WebService {

  @GET("/GoEuroAPI/rest/ebeletskiy.goeuro.test.data.api/v2/position/suggest/en/{city}")
  List<DestinationPoint> getPointsOfInterest(@Path("city") String city);
}
