package ebeletskiy.goeuro.test.data.storage;

import ebeletskiy.goeuro.test.data.api.model.DestinationPoint;
import java.io.FileWriter;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static ebeletskiy.goeuro.test.data.DestinationPointsCreator.AMOUNT_OF_FAKE_POINTS;
import static ebeletskiy.goeuro.test.data.DestinationPointsCreator.createListOfDestinationPoints;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class LocalStorageDataSaverTest {

  @Mock FileWriter fileWriter;
  @Mock DestinationPointHeadersExtractor extractor;

  private LocalStorageDataSaver dataSaver;

  @Before public void setUp() throws Exception {
    MockitoAnnotations.initMocks(this);

    dataSaver = new LocalStorageDataSaver(fileWriter, extractor);
  }

  @Test public void should_invoke_append_for_file_writer_as_many_times_as_list_size()
      throws Exception {
    when(extractor.getHeaders(any(DestinationPoint.class))).thenReturn("asdf");
    when(fileWriter.append(anyString())).thenReturn(fileWriter);

    dataSaver.persist(createListOfDestinationPoints());

    verify(fileWriter, atLeast(AMOUNT_OF_FAKE_POINTS)).append(anyString());
    verify(fileWriter, atLeast(AMOUNT_OF_FAKE_POINTS)).append("\n");
  }

  @Test public void should_flush() throws Exception {
    when(extractor.getHeaders(any(DestinationPoint.class))).thenReturn("asdf");
    when(fileWriter.append(anyString())).thenReturn(fileWriter);

    dataSaver.persist(createListOfDestinationPoints());

    verify(fileWriter, times(1)).flush();
  }

  @Test public void writter_should_be_closed() throws Exception {
    when(extractor.getHeaders(any(DestinationPoint.class))).thenReturn("asdf");
    when(fileWriter.append(anyString())).thenReturn(fileWriter);

    dataSaver.persist(createListOfDestinationPoints());

    verify(fileWriter, times(1)).close();

  }

  @Test public void should_invoke_getHeaders_as_many_times_as_list_size() throws Exception {
    when(extractor.getHeaders(any(DestinationPoint.class))).thenReturn("asdf");
    when(fileWriter.append(anyString())).thenReturn(fileWriter);

    dataSaver.persist(createListOfDestinationPoints());

    verify(extractor, times(AMOUNT_OF_FAKE_POINTS)).getHeaders(any(DestinationPoint.class));
  }

  @Test(expected = IllegalArgumentException.class)
  public void should_throw_an_exception_if_file_writer_wasnt_initialized() throws Exception {
    new LocalStorageDataSaver(null, extractor);
  }

  @Test(expected = IllegalArgumentException.class)
  public void should_throw_an_exception_if_headers_extractor_wasnt_initialized() throws Exception {
    new LocalStorageDataSaver(fileWriter, null);
  }

  @Test(expected = IllegalArgumentException.class)
  public void should_thrown_an_exception_on_attempt_to_persist_null_object() throws Exception {
    dataSaver.persist(null);
  }
}