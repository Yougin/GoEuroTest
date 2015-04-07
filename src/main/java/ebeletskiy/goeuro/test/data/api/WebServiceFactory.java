package ebeletskiy.goeuro.test.data.api;

import retrofit.Endpoints;
import retrofit.RestAdapter;

public class WebServiceFactory {
  private static final String TAG = WebServiceFactory.class.getSimpleName();

  private static final java.lang.String PRODUCTION_API_URL = "http://www.goeuro.com";

  public WebService getWebService() {
    return new RestAdapter.Builder()
        .setEndpoint(Endpoints.newFixedEndpoint(PRODUCTION_API_URL))
        .build()
        .create(WebService.class);
  }
}
