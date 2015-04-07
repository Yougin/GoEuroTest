package ebeletskiy.goeuro.test.data.api;

import ebeletskiy.goeuro.test.data.api.error.CustomErrorHandler;
import retrofit.Endpoints;
import retrofit.RestAdapter;

public class WebServiceFactory {
  private static final java.lang.String PRODUCTION_API_URL = "http://www.goeuro.com";

  public static WebService getWebService() {
    return new RestAdapter.Builder()
        .setEndpoint(Endpoints.newFixedEndpoint(PRODUCTION_API_URL))
        .setErrorHandler(new CustomErrorHandler())
        .build()
        .create(WebService.class);
  }
}
