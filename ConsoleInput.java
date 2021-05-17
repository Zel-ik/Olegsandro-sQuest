package Quest;
import java.util.concurrent.*;

public class ConsoleInput {
    private final int tries;
    private final int timeout;
    private final int secondTimeout;
    private final TimeUnit unit;

    public ConsoleInput(int tries, int timeout,int secondTimeout, TimeUnit unit) {
        this.tries = tries;
        this.timeout = timeout;
        this.secondTimeout = secondTimeout;
        this.unit = unit;
    }

    public String readLine() throws InterruptedException {
        ExecutorService ex = Executors.newSingleThreadExecutor();
        String input = null;
        try {
            // start working
            for (int i = 0; i < tries; i++) {
                Future<String> result = ex.submit(
                        new ConsoleInputAnswer());
                try {
                    if(i == tries-2)input = result.get(secondTimeout, unit);
                    else input = result.get(timeout,unit);
                    break;
                } catch (ExecutionException e) {
                    e.getCause().printStackTrace();
                } catch (TimeoutException e) {
                    if(i < tries-1) System.out.println("заебал вводи уже");
                    else System.out.println("пошел ты");
                    result.cancel(true);
                }
            }
        } finally {
            ex.shutdownNow();
        }
        return input;
    }
}
