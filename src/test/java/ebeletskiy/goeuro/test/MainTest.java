package ebeletskiy.goeuro.test;

import org.junit.Before;
import org.junit.Test;

public class MainTest {

  private Application application;
  private Main main;

  @Before public void setUp() throws Exception {
    main = new Main();
  }

  @Test public void test_success_flow() throws Exception {
    String[] args = { "BERLIN", "AMSTERDAM" };

    main.main(args);
  }

  @Test public void test_no_args_flow() throws Exception {
    String[] args = { };

    main.main(args);
  }
}