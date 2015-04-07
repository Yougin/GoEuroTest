package ebeletskiy.goeuro.test;

import ebeletskiy.goeuro.test.data.api.WebService;
import ebeletskiy.goeuro.test.data.api.WebServiceFactory;
import ebeletskiy.goeuro.test.data.api.model.DestinationPoint;
import java.util.List;

public class Main {

  public static void main(String[] args) {
    WebServiceFactory webServiceFactory = new WebServiceFactory();
    WebService webService = webServiceFactory.getWebService();

    List<DestinationPoint> points = webService.getPointsOfInterest("BERLIN");

    System.out.print(points.size());
  }

}
