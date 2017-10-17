package ro.mihai.pocjava.domain.executor;

import io.reactivex.Scheduler;

/**
 * Created by mihai on 16.10.2017.
 * Thread abstractions created to change the execution context from any thread to another.
 * Used to encapsulate the UI thread because some jobs will be done in background.
 */

public interface PostExecutionThread {
    Scheduler getScheduler();
}
