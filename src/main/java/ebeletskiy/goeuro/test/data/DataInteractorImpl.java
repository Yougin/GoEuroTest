package ebeletskiy.goeuro.test.data;

import ebeletskiy.goeuro.test.data.api.WebService;
import ebeletskiy.goeuro.test.data.api.error.NetworkConnectionException;
import ebeletskiy.goeuro.test.data.api.model.DestinationPoint;
import ebeletskiy.goeuro.test.utils.Preconditions;
import java.util.Collections;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class DataInteractorImpl implements DataInteractor {

  private final WebService webService;

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

    List<DestinationPoint> destinationPoints = executeNetworkRequest(city);

    if (destinationPoints == null || destinationPoints.isEmpty()) {
      return Collections.EMPTY_LIST;
    }

    return destinationPoints;
  }

  @Nullable private List<DestinationPoint> executeNetworkRequest(String city) {
    try {
      return webService.getDestinationPoints(city);
    } catch (NetworkConnectionException e) {
      System.out.println("Oh! Looks like you don't have internet connection, try again later");
    }

    return null;
  }
}
