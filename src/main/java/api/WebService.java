package api;

import api.model.DestinationPoint;
import java.util.List;
import retrofit.http.GET;
import retrofit.http.Path;

public interface WebService {

  @GET("/GoEuroAPI/rest/api/v2/position/suggest/en/{city}")
  List<DestinationPoint> getPointsOfInterest(@Path("city") String city);
}
