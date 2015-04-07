package ebeletskiy.goeuro.test;

public class Main {

  public static void main(String[] args) {
    if (args.length == 0) {
      System.out.println("Please specify what cities you want to get data for.");
    }

    for (String city : args) {
      System.out.println("I'm about to process " + city + " city");

      ApplicationFactory.getApplication().execute(city);

      System.out.println("I'm done with " + city + " city" + "\n");
    }
  }
}
