package androidx.loader.content;

/* loaded from: classes.dex */
abstract class ModernAsyncTask<Params, Progress, Result> {
    private static final int CORE_POOL_SIZE = 5;
    private static final int KEEP_ALIVE = 1;
    private static final java.lang.String LOG_TAG = "AsyncTask";
    private static final int MAXIMUM_POOL_SIZE = 128;
    private static final int MESSAGE_POST_PROGRESS = 2;
    private static final int MESSAGE_POST_RESULT = 1;
    public static final java.util.concurrent.Executor THREAD_POOL_EXECUTOR;
    private static volatile java.util.concurrent.Executor sDefaultExecutor;
    private static androidx.loader.content.ModernAsyncTask.InternalHandler sHandler;
    private static final java.util.concurrent.BlockingQueue<java.lang.Runnable> sPoolWorkQueue;
    private static final java.util.concurrent.ThreadFactory sThreadFactory;
    private final java.util.concurrent.FutureTask<Result> mFuture;
    private final androidx.loader.content.ModernAsyncTask.WorkerRunnable<Params, Result> mWorker;
    private volatile androidx.loader.content.ModernAsyncTask.Status mStatus = androidx.loader.content.ModernAsyncTask.Status.PENDING;
    final java.util.concurrent.atomic.AtomicBoolean mCancelled = new java.util.concurrent.atomic.AtomicBoolean();
    final java.util.concurrent.atomic.AtomicBoolean mTaskInvoked = new java.util.concurrent.atomic.AtomicBoolean();

    /* renamed from: androidx.loader.content.ModernAsyncTask$1, reason: invalid class name */
    public static class AnonymousClass1 implements java.util.concurrent.ThreadFactory {
        private final java.util.concurrent.atomic.AtomicInteger mCount = new java.util.concurrent.atomic.AtomicInteger(1);

        @Override // java.util.concurrent.ThreadFactory
        public java.lang.Thread newThread(java.lang.Runnable runnable) {
            return new java.lang.Thread(runnable, "ModernAsyncTask #" + this.mCount.getAndIncrement());
        }
    }

    /* renamed from: androidx.loader.content.ModernAsyncTask$2, reason: invalid class name */
    public class AnonymousClass2 extends androidx.loader.content.ModernAsyncTask.WorkerRunnable<Params, Result> {
        public AnonymousClass2() {
        }

        @Override // java.util.concurrent.Callable
        public Result call() throws java.lang.Exception {
            androidx.loader.content.ModernAsyncTask.this.mTaskInvoked.set(true);
            Result result = null;
            try {
                android.os.Process.setThreadPriority(10);
                result = (Result) androidx.loader.content.ModernAsyncTask.this.doInBackground(this.mParams);
                android.os.Binder.flushPendingCommands();
                return result;
            } finally {
            }
        }
    }

    /* renamed from: androidx.loader.content.ModernAsyncTask$3, reason: invalid class name */
    public class AnonymousClass3 extends java.util.concurrent.FutureTask<Result> {
        public AnonymousClass3(java.util.concurrent.Callable callable) {
            super(callable);
        }

        @Override // java.util.concurrent.FutureTask
        public void done() {
            try {
                androidx.loader.content.ModernAsyncTask.this.postResultIfNotInvoked(get());
            } catch (java.lang.InterruptedException unused) {
            } catch (java.util.concurrent.CancellationException unused2) {
                androidx.loader.content.ModernAsyncTask.this.postResultIfNotInvoked(null);
            } catch (java.util.concurrent.ExecutionException e) {
                throw new java.lang.RuntimeException("An error occurred while executing doInBackground()", e.getCause());
            } catch (java.lang.Throwable th) {
                throw new java.lang.RuntimeException("An error occurred while executing doInBackground()", th);
            }
        }
    }

    /* renamed from: androidx.loader.content.ModernAsyncTask$4, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass4 {
        static final /* synthetic */ int[] $SwitchMap$androidx$loader$content$ModernAsyncTask$Status;

        static {
            int[] iArr = new int[androidx.loader.content.ModernAsyncTask.Status.values().length];
            $SwitchMap$androidx$loader$content$ModernAsyncTask$Status = iArr;
            try {
                iArr[androidx.loader.content.ModernAsyncTask.Status.RUNNING.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$androidx$loader$content$ModernAsyncTask$Status[androidx.loader.content.ModernAsyncTask.Status.FINISHED.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
        }
    }

    public static class AsyncTaskResult<Data> {
        final Data[] mData;
        final androidx.loader.content.ModernAsyncTask mTask;

        public AsyncTaskResult(androidx.loader.content.ModernAsyncTask modernAsyncTask, Data... dataArr) {
            this.mTask = modernAsyncTask;
            this.mData = dataArr;
        }
    }

    public static class InternalHandler extends android.os.Handler {
        public InternalHandler() {
            super(android.os.Looper.getMainLooper());
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.os.Handler
        public void handleMessage(android.os.Message message) {
            androidx.loader.content.ModernAsyncTask.AsyncTaskResult asyncTaskResult = (androidx.loader.content.ModernAsyncTask.AsyncTaskResult) message.obj;
            int i = message.what;
            if (i == 1) {
                asyncTaskResult.mTask.finish(asyncTaskResult.mData[0]);
            } else {
                if (i != 2) {
                    return;
                }
                asyncTaskResult.mTask.onProgressUpdate(asyncTaskResult.mData);
            }
        }
    }

    public enum Status {
        PENDING,
        RUNNING,
        FINISHED
    }

    public static abstract class WorkerRunnable<Params, Result> implements java.util.concurrent.Callable<Result> {
        Params[] mParams;
    }

    static {
        androidx.loader.content.ModernAsyncTask.AnonymousClass1 anonymousClass1 = new androidx.loader.content.ModernAsyncTask.AnonymousClass1();
        sThreadFactory = anonymousClass1;
        java.util.concurrent.LinkedBlockingQueue linkedBlockingQueue = new java.util.concurrent.LinkedBlockingQueue(10);
        sPoolWorkQueue = linkedBlockingQueue;
        java.util.concurrent.ThreadPoolExecutor threadPoolExecutor = new java.util.concurrent.ThreadPoolExecutor(5, 128, 1L, java.util.concurrent.TimeUnit.SECONDS, linkedBlockingQueue, anonymousClass1);
        THREAD_POOL_EXECUTOR = threadPoolExecutor;
        sDefaultExecutor = threadPoolExecutor;
    }

    public ModernAsyncTask() {
        androidx.loader.content.ModernAsyncTask.AnonymousClass2 anonymousClass2 = new androidx.loader.content.ModernAsyncTask.AnonymousClass2();
        this.mWorker = anonymousClass2;
        this.mFuture = new androidx.loader.content.ModernAsyncTask.AnonymousClass3(anonymousClass2);
    }

    public static void execute(java.lang.Runnable runnable) {
        sDefaultExecutor.execute(runnable);
    }

    private static android.os.Handler getHandler() {
        androidx.loader.content.ModernAsyncTask.InternalHandler internalHandler;
        synchronized (androidx.loader.content.ModernAsyncTask.class) {
            if (sHandler == null) {
                sHandler = new androidx.loader.content.ModernAsyncTask.InternalHandler();
            }
            internalHandler = sHandler;
        }
        return internalHandler;
    }

    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    public static void setDefaultExecutor(java.util.concurrent.Executor executor) {
        sDefaultExecutor = executor;
    }

    public final boolean cancel(boolean z) {
        this.mCancelled.set(true);
        return this.mFuture.cancel(z);
    }

    public abstract Result doInBackground(Params... paramsArr);

    public final androidx.loader.content.ModernAsyncTask<Params, Progress, Result> execute(Params... paramsArr) {
        return executeOnExecutor(sDefaultExecutor, paramsArr);
    }

    public final androidx.loader.content.ModernAsyncTask<Params, Progress, Result> executeOnExecutor(java.util.concurrent.Executor executor, Params... paramsArr) {
        if (this.mStatus == androidx.loader.content.ModernAsyncTask.Status.PENDING) {
            this.mStatus = androidx.loader.content.ModernAsyncTask.Status.RUNNING;
            onPreExecute();
            this.mWorker.mParams = paramsArr;
            executor.execute(this.mFuture);
            return this;
        }
        int i = androidx.loader.content.ModernAsyncTask.AnonymousClass4.$SwitchMap$androidx$loader$content$ModernAsyncTask$Status[this.mStatus.ordinal()];
        if (i == 1) {
            throw new java.lang.IllegalStateException("Cannot execute task: the task is already running.");
        }
        if (i != 2) {
            throw new java.lang.IllegalStateException("We should never reach this state");
        }
        throw new java.lang.IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
    }

    public void finish(Result result) {
        if (isCancelled()) {
            onCancelled(result);
        } else {
            onPostExecute(result);
        }
        this.mStatus = androidx.loader.content.ModernAsyncTask.Status.FINISHED;
    }

    public final Result get() throws java.lang.InterruptedException, java.util.concurrent.ExecutionException {
        return this.mFuture.get();
    }

    public final Result get(long j, java.util.concurrent.TimeUnit timeUnit) throws java.lang.InterruptedException, java.util.concurrent.ExecutionException, java.util.concurrent.TimeoutException {
        return this.mFuture.get(j, timeUnit);
    }

    public final androidx.loader.content.ModernAsyncTask.Status getStatus() {
        return this.mStatus;
    }

    public final boolean isCancelled() {
        return this.mCancelled.get();
    }

    public void onCancelled() {
    }

    public void onCancelled(Result result) {
        onCancelled();
    }

    public void onPostExecute(Result result) {
    }

    public void onPreExecute() {
    }

    public void onProgressUpdate(Progress... progressArr) {
    }

    public Result postResult(Result result) {
        getHandler().obtainMessage(1, new androidx.loader.content.ModernAsyncTask.AsyncTaskResult(this, result)).sendToTarget();
        return result;
    }

    public void postResultIfNotInvoked(Result result) {
        if (this.mTaskInvoked.get()) {
            return;
        }
        postResult(result);
    }

    public final void publishProgress(Progress... progressArr) {
        if (isCancelled()) {
            return;
        }
        getHandler().obtainMessage(2, new androidx.loader.content.ModernAsyncTask.AsyncTaskResult(this, progressArr)).sendToTarget();
    }
}
