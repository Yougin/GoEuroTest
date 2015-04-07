package ebeletskiy.goeuro.test.data;

import com.sun.istack.internal.NotNull;
import ebeletskiy.goeuro.test.data.api.model.DestinationPoint;
import java.util.List;

public interface DataInteractor {

  @NotNull List<DestinationPoint> getDestinationPoints(@NotNull String city);

}
