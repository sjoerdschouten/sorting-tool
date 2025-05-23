package sorting.view;

/**
 * simple Log4j wrapper class for printing to stdout.
 */
//@Slf4j
public class ConsolePrinter {

    public void printObject(Object object) {
        System.out.println(object);
        //log.info(object.toString());
    }
}