import io.github.yeffycodegit.poglog.PogLogger;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        final PogLogger LOGGER = new PogLogger(false);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println(">> ");
            String o = scanner.nextLine();
            if (o.equals("stop")) {
                Exception e = new IllegalStateException("idfk");
                LOGGER.error(e);
                break;
            } else {
                LOGGER.info(o);
            }
        }
    }
}