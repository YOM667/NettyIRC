package me.youm.util;

import me.youm.command.Command;
import java.util.List;

/**
 * @author : You_M
 * @date : 2022/8/4 12:47 21
 * @projectName : KES-IRC-Server
 * @className : PrinterUtil
 */
public class PrinterUtil {
    public static void printHelp(List<Command> list){
        System.out.println("=================================");
        for (Command o : list) {
             String name = o.getName();
             System.out.println("|"+name+"  "+ o.getDes()+"|");
        }
        System.out.println("=================================");
    }
}
