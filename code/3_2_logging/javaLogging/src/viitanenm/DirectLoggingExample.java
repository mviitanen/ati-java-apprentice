package viitanenm;

import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DirectLoggingExample {

  public static void main(String[] args) {
    new DirectLoggingExample().doIt();
  }

  private void doIt() {
    Logger logger = Logger.getLogger(this.getClass().getName());
    logger.setUseParentHandlers(false);
    ConsoleHandler handler = new ConsoleHandler();
    handler.setLevel(Level.SEVERE);
    logger.setLevel(Level.ALL);
    logger.addHandler(handler);

    logger.log(Level.SEVERE, "LOG LEVEL SEVERE");

    logger.log(Level.SEVERE, "Logging SEVERE");
    logger.log(Level.WARNING, "Logging WARN");
    logger.log(Level.INFO, "Logging INFO");
    logger.log(Level.FINEST, "Logging FINEST");

    handler.setLevel(Level.INFO);
    logger.log(Level.SEVERE, "Logging SEVERE");
    logger.log(Level.WARNING, "Logging WARN");
    logger.log(Level.INFO, "Logging INFO");
    logger.log(Level.FINEST, "Logging FINEST");


    handler.setLevel(Level.FINEST);
    logger.log(Level.SEVERE, "Logging SEVERE");
    logger.log(Level.WARNING, "Logging WARN");
    logger.log(Level.INFO, "Logging INFO");
    logger.log(Level.FINEST, "Logging FINEST");

  }
}
