package ebeletskiy.goeuro.test.data.api;

import ebeletskiy.goeuro.test.data.api.model.DestinationPoint;
import java.util.List;
import retrofit.http.GET;
import retrofit.http.Path;

public interface WebService {

  /**
   * The endpoint to fetch a list of destination points objects.
   *
   * @param city - you would like to get destination points for (from?)
   * @return If no matches are found an empty JSON array is returned.
   */
  @GET("/GoEuroAPI/rest/ebeletskiy.goeuro.test.data.api/v2/position/suggest/en/{city}")
  List<DestinationPoint> getDestinationPoints(@Path("city") String city);
}
