package ebeletskiy.goeuro.test.data;

import ebeletskiy.goeuro.test.data.api.model.DestinationPoint;
import java.util.List;
import org.jetbrains.annotations.NotNull;

public interface DataInteractor {

  @NotNull List<DestinationPoint> getDestinationPoints(@NotNull String city);

}
