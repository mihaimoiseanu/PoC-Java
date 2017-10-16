package ro.mihai.pocjava.domain.executor;

import io.reactivex.Scheduler;

/**
 * Created by mihai on 16.10.2017.
 */

public interface PostExecutionThread {
    Scheduler getScheduler();
}
