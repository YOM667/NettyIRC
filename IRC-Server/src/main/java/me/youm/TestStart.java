package me.youm;

import me.youm.api.ServerStart;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author : You_M
 * @date : 2022/8/7 12:59 10
 * @projectName : KES-IRC-Server
 * @className : TestStart
 */
public class TestStart {
    private static Logger log = LogManager.getLogger(TestStart.class);
    public static void main(String[] args) throws InterruptedException {
        ServerStart start = new ServerStart();
        boolean run = start.run();
        log.info(run);
    }
}
