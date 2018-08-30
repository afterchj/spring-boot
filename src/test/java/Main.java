
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by hongjian.chen on 2018/8/24.
 */
public class Main {

    final static Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) throws InterruptedException {

        logger.debug("现在的时间是 {}", new Date().toString());

        logger.info(" This time is {}", new Date().toString());

        logger.warn(" This time is {}", new Date().toString());

        logger.error(" This time is {}", new Date().toString());

    }
}
