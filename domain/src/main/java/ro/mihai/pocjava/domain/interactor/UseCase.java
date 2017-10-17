package ro.mihai.pocjava.domain.interactor;

import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import ro.mihai.pocjava.domain.executor.PostExecutionThread;
import ro.mihai.pocjava.domain.executor.ThreadExecutor;

/**
 * Created by mihai on 16.10.2017.
 * Abstract class for a Use Case (Interactor).
 * This represents a execution unit for different use cases. Any use case should implement this contract.
 * <p>
 * By convention any UseCase implementation will return the result using a {@link DisposableObserver}
 * that will execute its job in background and will post the result in the UI thread
 */

public abstract class UseCase<T, Params> {

    private final ThreadExecutor threadExecutor;
    private final PostExecutionThread postExecutionThread;
    private final CompositeDisposable disposables;

    public UseCase(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread) {
        this.threadExecutor = threadExecutor;
        this.postExecutionThread = postExecutionThread;
        this.disposables = new CompositeDisposable();
    }

    /**
     * Builds an {@link Observable} which will be used when executing the current {@link UseCase}
     */
    public abstract Observable<T> buildUseCaseObservable(Params params);

    /**
     * Execute the current use case.
     *
     * @param observer {@link DisposableObserver} which wil be listening to the observable build
     *                 by {@link #buildUseCaseObservable(Params) ()} method
     * @param params   Parameters (Optional) used to build/execute this use case.
     */
    public void execute(DisposableObserver<T> observer, Params params) {
        final Observable<T> observable = this.buildUseCaseObservable(params)
                .subscribeOn(Schedulers.from(threadExecutor))
                .observeOn(postExecutionThread.getScheduler());
        addDisposable(observable.subscribeWith(observer));
    }

    /**
     * Dispose from current {@link CompositeDisposable}
     */
    public void dispose() {
        if (!disposables.isDisposed()) {
            disposables.dispose();
        }
    }

    /**
     * Dispose from current {@link CompositeDisposable}
     */
    private void addDisposable(Disposable disposable) {
        disposables.add(disposable);
    }
}
