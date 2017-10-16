package ro.mihai.pocjava.data.executor;

import android.os.Process;
import android.support.annotation.NonNull;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;
import javax.inject.Singleton;

import ro.mihai.pocjava.domain.executor.ThreadExecutor;

/**
 * Created by mihai on 16.10.2017.
 */

@Singleton
public class JobExecutor implements ThreadExecutor {

    private final static int NUMBER_OF_CORES = Runtime.getRuntime().availableProcessors();
    private final ThreadPoolExecutor threadPoolExecutor;

    @Inject
    public JobExecutor() {
        threadPoolExecutor = new ThreadPoolExecutor(
                NUMBER_OF_CORES * 2,
                NUMBER_OF_CORES * 2,
                60L,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(),
                new PriorityThreadFactory(Process.THREAD_PRIORITY_BACKGROUND)
        );
    }

    @Override
    public void execute(@NonNull Runnable command) {
        threadPoolExecutor.execute(command);
    }

    private static class PriorityThreadFactory implements ThreadFactory {
        private int mThreadPriority;

        public PriorityThreadFactory(int mThreadPriority) {
            this.mThreadPriority = mThreadPriority;
        }

        @Override
        public Thread newThread(final Runnable runnable) {
            Runnable wrapperRunnable = new Runnable() {
                @Override
                public void run() {
                    try {
                        android.os.Process.setThreadPriority(mThreadPriority);
                    } catch (Throwable t) {

                    }
                    runnable.run();
                }
            };
            return new Thread(wrapperRunnable);
        }
    }
}
