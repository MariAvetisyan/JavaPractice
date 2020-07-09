import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by mari.avetisyan on 07/07/2020.
 */
public class loging {
    private static final Logger LOG = LoggerFactory.getLogger(loging.class);

    public static void main(String... arg) {

        if(LOG.isTraceEnabled()) {
            LOG.trace("trace");
        }

        if(LOG.isDebugEnabled()) {
            LOG.debug("debug");
        }

        LOG.info("info");
        LOG.warn("warn");
        LOG.error("error");

    }
}
