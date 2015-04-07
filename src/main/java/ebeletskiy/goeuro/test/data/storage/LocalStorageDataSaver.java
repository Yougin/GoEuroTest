package ebeletskiy.goeuro.test.data.storage;

import ebeletskiy.goeuro.test.data.api.model.DestinationPoint;
import ebeletskiy.goeuro.test.utils.Preconditions;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import org.jetbrains.annotations.NotNull;

public class LocalStorageDataSaver implements DataSaver {
  private static final String TAG = LocalStorageDataSaver.class.getSimpleName();

  public FileWriter fileWriter;
  public DestinationPointHeadersExtractor extractor;

  public LocalStorageDataSaver(@NotNull FileWriter fileWriter,
      @NotNull DestinationPointHeadersExtractor extractor) {
    this.fileWriter = Preconditions.checkNotNull(fileWriter, "fileWriter must be initialized");
    this.extractor = Preconditions.checkNotNull(extractor, "extractor must be initialized");
  }

  @Override public void persist(@NotNull List<DestinationPoint> destinationPoints)
      throws IOException {
    Preconditions.checkNotNull(destinationPoints, "destinationPoints can't be null");

    for (DestinationPoint point : destinationPoints) {
      fileWriter
          .append(extractor.getHeaders(point))
          .append("\n");
    }

    fileWriter.flush();
    fileWriter.close();
  }
}
