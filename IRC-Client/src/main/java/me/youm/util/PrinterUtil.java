package me.youm.util;

import me.youm.command.Command;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

/**
 * @author : You_M
 * @date : 2022/8/4 12:47 21
 * @projectName : KES-IRC-Server
 * @className : PrinterUtil
 */
public class PrinterUtil {
    private static final Logger log = LogManager.getLogger(PrinterUtil.class);
    public static void printHelp(List<Command> list){
        System.out.println("=================================");
        for (Command o : list) {
             String name = o.getName();
             log.info("|{}  {}|",name,o.getDes());
             System.out.println("|"+name+"  "+ o.getDes()+"|");
        }
        System.out.println("=================================");
    }
}
