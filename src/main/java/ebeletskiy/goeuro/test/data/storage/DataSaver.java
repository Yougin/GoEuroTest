package ebeletskiy.goeuro.test.data.storage;

import ebeletskiy.goeuro.test.data.api.model.DestinationPoint;
import java.io.IOException;
import java.util.List;

public interface DataSaver {

  void persist(List<DestinationPoint> destinationPoints) throws IOException;
}
