package lessons16.Drink;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BarWithExecutorService {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();

        for (int drinker = 1; drinker <= 50; drinker++) {
            executorService.execute(new Drinker());
        }
        executorService.shutdown();

        ThreadUtils.println("Goodbye");
    }
}