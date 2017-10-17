package ro.mihai.pocjava.domain.executor;

import java.util.concurrent.Executor;

/**
 * Created by mihai on 16.10.2017.
 */

/**
 * Wrapper around {@link Executor} used to run different task out of the UI thread.
 */
public interface ThreadExecutor extends Executor {
}
