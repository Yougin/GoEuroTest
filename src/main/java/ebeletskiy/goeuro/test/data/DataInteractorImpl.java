package ebeletskiy.goeuro.test.data;

import com.sun.istack.internal.NotNull;
import ebeletskiy.goeuro.test.data.api.WebService;
import ebeletskiy.goeuro.test.data.api.model.DestinationPoint;
import ebeletskiy.goeuro.test.utils.Preconditions;
import java.util.Collections;
import java.util.List;
import org.jetbrains.annotations.Nullable;

public class DataInteractorImpl implements DataInteractor {
  private static final String TAG = DataInteractorImpl.class.getSimpleName();

  private WebService webService;

  public DataInteractorImpl(WebService webService) {
    this.webService = Preconditions.checkNotNull(webService, "webService must be initialized");
  }

  /**
   * Get destination points for requested city
   *
   * @param city of interest
   * @return a list of DestinationPoint {@link ebeletskiy.goeuro.test.data.api.model.DestinationPoint}
   * objects or empty collection if parameter null or empty.
   */
  @NotNull public List<DestinationPoint> getDestinationPoints(@Nullable String city) {
    if (city == null || city.isEmpty()) {
      return Collections.EMPTY_LIST;
    }

    return null; //TODO: stopped here
  }
}
