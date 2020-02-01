package solutions.designs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class CustomExecutor {

    private static int DEFAULT_CONCURRENT_TASK_NUMBER = 5;
    private ConcurrentHashMap<User, List<Runnable>> taskRecords = new ConcurrentHashMap<>();
    private ExecutorService executor = Executors.newFixedThreadPool(10);
    private ScheduledExecutorService backgroundExecutor = Executors.newScheduledThreadPool(1);

    public CustomExecutor() {
        Runnable submitTask = this::run;
        backgroundExecutor.schedule(submitTask, 100, TimeUnit.SECONDS);
    }

    public boolean submit(final User user,
                          final Runnable task) {
        List<Runnable> tasks = taskRecords
                .getOrDefault(user, Collections.synchronizedList(new ArrayList<>()));
        if (tasks.size() > DEFAULT_CONCURRENT_TASK_NUMBER) {
            return false;
        } else {
            tasks.add(task);
            return true;
        }
    }

    private void run() {
        // Should do some round robin stuff here.
        // Also need to limit the runnables submitted per user.
        taskRecords.forEach((user, runnables) -> runnables.forEach(r -> executor.submit(r)));
    }

    static class User {

        String userName;
    }

}

