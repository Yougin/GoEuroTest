package ebeletskiy.goeuro.test;

import org.junit.Before;
import org.junit.Test;

public class MainTest {

  private Application application;
  private Main main;

  @Before public void setUp() throws Exception {
    main = new Main();
  }

  @Test public void testName() throws Exception {
    String[] args = { "BERLIN", "AMSTERDAM" };

    main.main(args);
  }
}