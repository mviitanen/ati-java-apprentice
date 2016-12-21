package viitanenm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConfigLoggingExample {

  public static void main(String[] args) {
    new ConfigLoggingExample().doIt();
  }

  private void doIt() {
    Logger logger = LoggerFactory.getLogger(this.getClass());
    logger.error("Logging ERROR");
    logger.warn("Logging WARN");
    logger.info("Logging INFO");
    logger.debug("Logging DEBUG");
  }
}
