package com.otaliastudios.cameraview.engine.orchestrator;

/* loaded from: classes19.dex */
public class CameraOrchestrator {
    protected static final com.otaliastudios.cameraview.CameraLogger LOG = com.otaliastudios.cameraview.CameraLogger.create(com.otaliastudios.cameraview.engine.orchestrator.CameraOrchestrator.class.getSimpleName());
    protected static final java.lang.String TAG = "CameraOrchestrator";
    protected final com.otaliastudios.cameraview.engine.orchestrator.CameraOrchestrator.Callback mCallback;
    protected final java.util.ArrayDeque<com.otaliastudios.cameraview.engine.orchestrator.CameraOrchestrator.Token> mJobs = new java.util.ArrayDeque<>();
    protected final java.lang.Object mLock = new java.lang.Object();
    public final java.util.Map<java.lang.String, java.lang.Runnable> a = new java.util.HashMap();

    /* renamed from: com.otaliastudios.cameraview.engine.orchestrator.CameraOrchestrator$1, reason: invalid class name */
    public class AnonymousClass1 implements java.util.concurrent.Callable<com.google.android.gms.tasks.Task<java.lang.Void>> {
        public final /* synthetic */ java.lang.Runnable n;

        public AnonymousClass1(java.lang.Runnable runnable) {
            this.n = runnable;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public com.google.android.gms.tasks.Task<java.lang.Void> call() {
            this.n.run();
            return com.google.android.gms.tasks.Tasks.forResult(null);
        }
    }

    /* renamed from: com.otaliastudios.cameraview.engine.orchestrator.CameraOrchestrator$2, reason: invalid class name */
    public class AnonymousClass2 implements com.google.android.gms.tasks.OnCompleteListener {
        public final /* synthetic */ java.lang.String a;
        public final /* synthetic */ java.util.concurrent.Callable b;
        public final /* synthetic */ com.otaliastudios.cameraview.internal.WorkerHandler c;
        public final /* synthetic */ boolean d;
        public final /* synthetic */ com.google.android.gms.tasks.TaskCompletionSource e;

        /* JADX INFO: Add missing generic type declarations: [T] */
        /* renamed from: com.otaliastudios.cameraview.engine.orchestrator.CameraOrchestrator$2$1, reason: invalid class name */
        public class AnonymousClass1<T> implements com.google.android.gms.tasks.OnCompleteListener<T> {
            public AnonymousClass1() {
            }

            @Override // com.google.android.gms.tasks.OnCompleteListener
            public void onComplete(@androidx.annotation.NonNull com.google.android.gms.tasks.Task<T> task) {
                java.lang.Exception exception = task.getException();
                if (exception != null) {
                    com.otaliastudios.cameraview.engine.orchestrator.CameraOrchestrator.LOG.w(com.otaliastudios.cameraview.engine.orchestrator.CameraOrchestrator.AnonymousClass2.this.a.toUpperCase(), "- Finished with ERROR.", exception);
                    com.otaliastudios.cameraview.engine.orchestrator.CameraOrchestrator.AnonymousClass2 anonymousClass2 = com.otaliastudios.cameraview.engine.orchestrator.CameraOrchestrator.AnonymousClass2.this;
                    if (anonymousClass2.d) {
                        com.otaliastudios.cameraview.engine.orchestrator.CameraOrchestrator.this.mCallback.handleJobException(anonymousClass2.a, exception);
                    }
                    com.otaliastudios.cameraview.engine.orchestrator.CameraOrchestrator.AnonymousClass2.this.e.trySetException(exception);
                    return;
                }
                if (task.isCanceled()) {
                    com.otaliastudios.cameraview.engine.orchestrator.CameraOrchestrator.LOG.i(com.otaliastudios.cameraview.engine.orchestrator.CameraOrchestrator.AnonymousClass2.this.a.toUpperCase(), "- Finished because ABORTED.");
                    com.otaliastudios.cameraview.engine.orchestrator.CameraOrchestrator.AnonymousClass2.this.e.trySetException(new java.util.concurrent.CancellationException());
                } else {
                    com.otaliastudios.cameraview.engine.orchestrator.CameraOrchestrator.LOG.i(com.otaliastudios.cameraview.engine.orchestrator.CameraOrchestrator.AnonymousClass2.this.a.toUpperCase(), "- Finished.");
                    com.otaliastudios.cameraview.engine.orchestrator.CameraOrchestrator.AnonymousClass2.this.e.trySetResult(task.getResult());
                }
            }
        }

        public AnonymousClass2(java.lang.String str, java.util.concurrent.Callable callable, com.otaliastudios.cameraview.internal.WorkerHandler workerHandler, boolean z, com.google.android.gms.tasks.TaskCompletionSource taskCompletionSource) {
            this.a = str;
            this.b = callable;
            this.c = workerHandler;
            this.d = z;
            this.e = taskCompletionSource;
        }

        @Override // com.google.android.gms.tasks.OnCompleteListener
        public void onComplete(@androidx.annotation.NonNull com.google.android.gms.tasks.Task task) {
            synchronized (com.otaliastudios.cameraview.engine.orchestrator.CameraOrchestrator.this.mLock) {
                com.otaliastudios.cameraview.engine.orchestrator.CameraOrchestrator.this.mJobs.removeFirst();
                com.otaliastudios.cameraview.engine.orchestrator.CameraOrchestrator.this.e();
            }
            try {
                com.otaliastudios.cameraview.engine.orchestrator.CameraOrchestrator.LOG.i(this.a.toUpperCase(), "- Executing.");
                com.otaliastudios.cameraview.engine.orchestrator.CameraOrchestrator.d((com.google.android.gms.tasks.Task) this.b.call(), this.c, new com.otaliastudios.cameraview.engine.orchestrator.CameraOrchestrator.AnonymousClass2.AnonymousClass1());
            } catch (java.lang.Exception e) {
                com.otaliastudios.cameraview.engine.orchestrator.CameraOrchestrator.LOG.i(this.a.toUpperCase(), "- Finished.", e);
                if (this.d) {
                    com.otaliastudios.cameraview.engine.orchestrator.CameraOrchestrator.this.mCallback.handleJobException(this.a, e);
                }
                this.e.trySetException(e);
            }
        }
    }

    /* renamed from: com.otaliastudios.cameraview.engine.orchestrator.CameraOrchestrator$3, reason: invalid class name */
    public class AnonymousClass3 implements java.lang.Runnable {
        public final /* synthetic */ java.lang.String n;
        public final /* synthetic */ java.lang.Runnable t;

        public AnonymousClass3(java.lang.String str, java.lang.Runnable runnable) {
            this.n = str;
            this.t = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.otaliastudios.cameraview.engine.orchestrator.CameraOrchestrator.this.schedule(this.n, true, this.t);
            synchronized (com.otaliastudios.cameraview.engine.orchestrator.CameraOrchestrator.this.mLock) {
                if (com.otaliastudios.cameraview.engine.orchestrator.CameraOrchestrator.this.a.containsValue(this)) {
                    com.otaliastudios.cameraview.engine.orchestrator.CameraOrchestrator.this.a.remove(this.n);
                }
            }
        }
    }

    /* renamed from: com.otaliastudios.cameraview.engine.orchestrator.CameraOrchestrator$4, reason: invalid class name */
    public static class AnonymousClass4 implements java.lang.Runnable {
        public final /* synthetic */ com.google.android.gms.tasks.OnCompleteListener n;
        public final /* synthetic */ com.google.android.gms.tasks.Task t;

        public AnonymousClass4(com.google.android.gms.tasks.OnCompleteListener onCompleteListener, com.google.android.gms.tasks.Task task) {
            this.n = onCompleteListener;
            this.t = task;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.n.onComplete(this.t);
        }
    }

    public interface Callback {
        @androidx.annotation.NonNull
        com.otaliastudios.cameraview.internal.WorkerHandler getJobWorker(@androidx.annotation.NonNull java.lang.String str);

        void handleJobException(@androidx.annotation.NonNull java.lang.String str, @androidx.annotation.NonNull java.lang.Exception exc);
    }

    public static class Token {
        public final java.lang.String name;
        public final com.google.android.gms.tasks.Task<?> task;

        public Token(@androidx.annotation.NonNull java.lang.String str, @androidx.annotation.NonNull com.google.android.gms.tasks.Task<?> task) {
            this.name = str;
            this.task = task;
        }

        public /* synthetic */ Token(java.lang.String str, com.google.android.gms.tasks.Task task, com.otaliastudios.cameraview.engine.orchestrator.CameraOrchestrator.AnonymousClass1 anonymousClass1) {
            this(str, task);
        }

        public boolean equals(@androidx.annotation.Nullable java.lang.Object obj) {
            return (obj instanceof com.otaliastudios.cameraview.engine.orchestrator.CameraOrchestrator.Token) && ((com.otaliastudios.cameraview.engine.orchestrator.CameraOrchestrator.Token) obj).name.equals(this.name);
        }
    }

    public CameraOrchestrator(@androidx.annotation.NonNull com.otaliastudios.cameraview.engine.orchestrator.CameraOrchestrator.Callback callback) {
        this.mCallback = callback;
        e();
    }

    public static <T> void d(@androidx.annotation.NonNull com.google.android.gms.tasks.Task<T> task, @androidx.annotation.NonNull com.otaliastudios.cameraview.internal.WorkerHandler workerHandler, @androidx.annotation.NonNull com.google.android.gms.tasks.OnCompleteListener<T> onCompleteListener) {
        if (task.isComplete()) {
            workerHandler.run(new com.otaliastudios.cameraview.engine.orchestrator.CameraOrchestrator.AnonymousClass4(onCompleteListener, task));
        } else {
            task.addOnCompleteListener(workerHandler.getExecutor(), onCompleteListener);
        }
    }

    public final void e() {
        synchronized (this.mLock) {
            if (this.mJobs.isEmpty()) {
                this.mJobs.add(new com.otaliastudios.cameraview.engine.orchestrator.CameraOrchestrator.Token("BASE", com.google.android.gms.tasks.Tasks.forResult(null), null));
            }
        }
    }

    public void remove(@androidx.annotation.NonNull java.lang.String str) {
        synchronized (this.mLock) {
            if (this.a.get(str) != null) {
                this.mCallback.getJobWorker(str).remove(this.a.get(str));
                this.a.remove(str);
            }
            while (this.mJobs.remove(new com.otaliastudios.cameraview.engine.orchestrator.CameraOrchestrator.Token(str, com.google.android.gms.tasks.Tasks.forResult(null), null))) {
            }
            e();
        }
    }

    public void reset() {
        synchronized (this.mLock) {
            java.util.ArrayList arrayList = new java.util.ArrayList();
            arrayList.addAll(this.a.keySet());
            java.util.Iterator<com.otaliastudios.cameraview.engine.orchestrator.CameraOrchestrator.Token> it = this.mJobs.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().name);
            }
            java.util.Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                remove((java.lang.String) it2.next());
            }
        }
    }

    @androidx.annotation.NonNull
    public com.google.android.gms.tasks.Task<java.lang.Void> schedule(@androidx.annotation.NonNull java.lang.String str, boolean z, @androidx.annotation.NonNull java.lang.Runnable runnable) {
        return schedule(str, z, new com.otaliastudios.cameraview.engine.orchestrator.CameraOrchestrator.AnonymousClass1(runnable));
    }

    @androidx.annotation.NonNull
    public <T> com.google.android.gms.tasks.Task<T> schedule(@androidx.annotation.NonNull java.lang.String str, boolean z, @androidx.annotation.NonNull java.util.concurrent.Callable<com.google.android.gms.tasks.Task<T>> callable) {
        LOG.i(str.toUpperCase(), "- Scheduling.");
        com.google.android.gms.tasks.TaskCompletionSource taskCompletionSource = new com.google.android.gms.tasks.TaskCompletionSource();
        com.otaliastudios.cameraview.internal.WorkerHandler jobWorker = this.mCallback.getJobWorker(str);
        synchronized (this.mLock) {
            d(this.mJobs.getLast().task, jobWorker, new com.otaliastudios.cameraview.engine.orchestrator.CameraOrchestrator.AnonymousClass2(str, callable, jobWorker, z, taskCompletionSource));
            this.mJobs.addLast(new com.otaliastudios.cameraview.engine.orchestrator.CameraOrchestrator.Token(str, taskCompletionSource.getTask(), null));
        }
        return taskCompletionSource.getTask();
    }

    public void scheduleDelayed(@androidx.annotation.NonNull java.lang.String str, long j, @androidx.annotation.NonNull java.lang.Runnable runnable) {
        com.otaliastudios.cameraview.engine.orchestrator.CameraOrchestrator.AnonymousClass3 anonymousClass3 = new com.otaliastudios.cameraview.engine.orchestrator.CameraOrchestrator.AnonymousClass3(str, runnable);
        synchronized (this.mLock) {
            this.a.put(str, anonymousClass3);
            this.mCallback.getJobWorker(str).post(j, anonymousClass3);
        }
    }
}
