import api.WebService;
import api.model.DestinationPoint;
import java.util.List;
import retrofit.RestAdapter;

public class Main {

  public static void main(String[] args) {
    WebService webService = getWebService();

    List<DestinationPoint> points = webService.getPointsOfInterest("BERLIN");

    System.out.print(points.size());
  }

  private static WebService getWebService() {
    RestAdapter restAdapter =
        new RestAdapter.Builder().setEndpoint("http://www.goeuro.com").build();

    return restAdapter.create(WebService.class);
  }

}
