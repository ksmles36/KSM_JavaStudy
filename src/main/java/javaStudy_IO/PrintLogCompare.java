package javaStudy_IO;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PrintLogCompare {

    final static Logger logger = LogManager.getLogger(PrintLogCompare.class);

    public static void main(String[] args) {

//        printTest();
        logTest();

    }

    private static void logTest() {
        long start = System.currentTimeMillis();
        for(int i=0; i<10000; i++){
            logger.info("test");
            logger.info("test");
        }
        long end = System.currentTimeMillis();
        System.out.println("logTest() : " + (end-start) + "ms 소요");
    }

    private static void printTest() {
        long start = System.currentTimeMillis();
        for(int i=0; i<10000; i++){
            System.out.println("test");
            System.out.println("test");
        }
        long end = System.currentTimeMillis();
        System.out.println("printTest() : " + (end-start) + "ms 소요");
    }

}
