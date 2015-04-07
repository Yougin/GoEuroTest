package ebeletskiy.goeuro.test.data.api.error;

import retrofit.ErrorHandler;
import retrofit.RetrofitError;

public class CustomErrorHandler implements ErrorHandler {

  @Override public Throwable handleError(RetrofitError cause) {
    if (cause.getKind() == RetrofitError.Kind.NETWORK) {
      return new NetworkConnectionException();
    }

    return cause;
  }

}
