package ebeletskiy.goeuro.test.data.storage;

import java.io.Serializable;

public interface DataSaver {

  void persist(Serializable object);

}
