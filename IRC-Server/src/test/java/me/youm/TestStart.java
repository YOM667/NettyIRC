package me.youm;

import me.youm.api.ServerStart;
import me.youm.services.ServicesSql;
import me.youm.services.UseStatus;
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
        ServerStart start = ServerStart.getStart();
        start.config(UseStatus.CUSTOM,new ServicesSql());
        boolean run = start.run();
        log.info(run);
    }
}
