package ebeletskiy.goeuro.test;

public class Main {

  public static void main(String[] args) {
    if (args.length == 0) {
      System.out.println("Please specify what cities you want to get data for.");
    }

    for (String city : args) {
      ApplicationFactory.getApplication().execute(city);
    }
  }
}
