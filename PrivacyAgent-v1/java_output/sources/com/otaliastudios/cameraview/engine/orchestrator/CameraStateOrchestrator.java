package com.otaliastudios.cameraview.engine.orchestrator;

/* loaded from: classes19.dex */
public class CameraStateOrchestrator extends com.otaliastudios.cameraview.engine.orchestrator.CameraOrchestrator {
    public com.otaliastudios.cameraview.engine.orchestrator.CameraState b;
    public com.otaliastudios.cameraview.engine.orchestrator.CameraState c;
    public int d;

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* renamed from: com.otaliastudios.cameraview.engine.orchestrator.CameraStateOrchestrator$1, reason: invalid class name */
    public class AnonymousClass1<T> implements com.google.android.gms.tasks.OnCompleteListener<T> {
        public final /* synthetic */ int a;

        public AnonymousClass1(int i) {
            this.a = i;
        }

        @Override // com.google.android.gms.tasks.OnCompleteListener
        public void onComplete(@androidx.annotation.NonNull com.google.android.gms.tasks.Task<T> task) {
            if (this.a == com.otaliastudios.cameraview.engine.orchestrator.CameraStateOrchestrator.this.d) {
                com.otaliastudios.cameraview.engine.orchestrator.CameraStateOrchestrator cameraStateOrchestrator = com.otaliastudios.cameraview.engine.orchestrator.CameraStateOrchestrator.this;
                cameraStateOrchestrator.c = cameraStateOrchestrator.b;
            }
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* renamed from: com.otaliastudios.cameraview.engine.orchestrator.CameraStateOrchestrator$2, reason: invalid class name */
    public class AnonymousClass2<T> implements java.util.concurrent.Callable<com.google.android.gms.tasks.Task<T>> {
        public final /* synthetic */ com.otaliastudios.cameraview.engine.orchestrator.CameraState n;
        public final /* synthetic */ java.lang.String t;
        public final /* synthetic */ com.otaliastudios.cameraview.engine.orchestrator.CameraState u;
        public final /* synthetic */ java.util.concurrent.Callable v;
        public final /* synthetic */ boolean w;

        /* renamed from: com.otaliastudios.cameraview.engine.orchestrator.CameraStateOrchestrator$2$1, reason: invalid class name */
        public class AnonymousClass1 implements com.google.android.gms.tasks.Continuation<T, com.google.android.gms.tasks.Task<T>> {
            public AnonymousClass1() {
            }

            @Override // com.google.android.gms.tasks.Continuation
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public com.google.android.gms.tasks.Task<T> then(@androidx.annotation.NonNull com.google.android.gms.tasks.Task<T> task) {
                if (task.isSuccessful() || com.otaliastudios.cameraview.engine.orchestrator.CameraStateOrchestrator.AnonymousClass2.this.w) {
                    com.otaliastudios.cameraview.engine.orchestrator.CameraStateOrchestrator.AnonymousClass2 anonymousClass2 = com.otaliastudios.cameraview.engine.orchestrator.CameraStateOrchestrator.AnonymousClass2.this;
                    com.otaliastudios.cameraview.engine.orchestrator.CameraStateOrchestrator.this.b = anonymousClass2.u;
                }
                return task;
            }
        }

        public AnonymousClass2(com.otaliastudios.cameraview.engine.orchestrator.CameraState cameraState, java.lang.String str, com.otaliastudios.cameraview.engine.orchestrator.CameraState cameraState2, java.util.concurrent.Callable callable, boolean z) {
            this.n = cameraState;
            this.t = str;
            this.u = cameraState2;
            this.v = callable;
            this.w = z;
        }

        @Override // java.util.concurrent.Callable
        public com.google.android.gms.tasks.Task<T> call() throws java.lang.Exception {
            if (com.otaliastudios.cameraview.engine.orchestrator.CameraStateOrchestrator.this.getCurrentState() == this.n) {
                return ((com.google.android.gms.tasks.Task) this.v.call()).continueWithTask(com.otaliastudios.cameraview.engine.orchestrator.CameraStateOrchestrator.this.mCallback.getJobWorker(this.t).getExecutor(), new com.otaliastudios.cameraview.engine.orchestrator.CameraStateOrchestrator.AnonymousClass2.AnonymousClass1());
            }
            com.otaliastudios.cameraview.engine.orchestrator.CameraOrchestrator.LOG.w(this.t.toUpperCase(), "- State mismatch, aborting. current:", com.otaliastudios.cameraview.engine.orchestrator.CameraStateOrchestrator.this.getCurrentState(), "from:", this.n, "to:", this.u);
            return com.google.android.gms.tasks.Tasks.forCanceled();
        }
    }

    /* renamed from: com.otaliastudios.cameraview.engine.orchestrator.CameraStateOrchestrator$3, reason: invalid class name */
    public class AnonymousClass3 implements java.lang.Runnable {
        public final /* synthetic */ com.otaliastudios.cameraview.engine.orchestrator.CameraState n;
        public final /* synthetic */ java.lang.Runnable t;

        public AnonymousClass3(com.otaliastudios.cameraview.engine.orchestrator.CameraState cameraState, java.lang.Runnable runnable) {
            this.n = cameraState;
            this.t = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (com.otaliastudios.cameraview.engine.orchestrator.CameraStateOrchestrator.this.getCurrentState().isAtLeast(this.n)) {
                this.t.run();
            }
        }
    }

    /* renamed from: com.otaliastudios.cameraview.engine.orchestrator.CameraStateOrchestrator$4, reason: invalid class name */
    public class AnonymousClass4 implements java.lang.Runnable {
        public final /* synthetic */ com.otaliastudios.cameraview.engine.orchestrator.CameraState n;
        public final /* synthetic */ java.lang.Runnable t;

        public AnonymousClass4(com.otaliastudios.cameraview.engine.orchestrator.CameraState cameraState, java.lang.Runnable runnable) {
            this.n = cameraState;
            this.t = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (com.otaliastudios.cameraview.engine.orchestrator.CameraStateOrchestrator.this.getCurrentState().isAtLeast(this.n)) {
                this.t.run();
            }
        }
    }

    public CameraStateOrchestrator(@androidx.annotation.NonNull com.otaliastudios.cameraview.engine.orchestrator.CameraOrchestrator.Callback callback) {
        super(callback);
        com.otaliastudios.cameraview.engine.orchestrator.CameraState cameraState = com.otaliastudios.cameraview.engine.orchestrator.CameraState.OFF;
        this.b = cameraState;
        this.c = cameraState;
        this.d = 0;
    }

    @androidx.annotation.NonNull
    public com.otaliastudios.cameraview.engine.orchestrator.CameraState getCurrentState() {
        return this.b;
    }

    @androidx.annotation.NonNull
    public com.otaliastudios.cameraview.engine.orchestrator.CameraState getTargetState() {
        return this.c;
    }

    public boolean hasPendingStateChange() {
        synchronized (this.mLock) {
            java.util.Iterator<com.otaliastudios.cameraview.engine.orchestrator.CameraOrchestrator.Token> it = this.mJobs.iterator();
            while (it.hasNext()) {
                com.otaliastudios.cameraview.engine.orchestrator.CameraOrchestrator.Token next = it.next();
                if (next.name.contains(" >> ") || next.name.contains(" << ")) {
                    if (!next.task.isComplete()) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    @androidx.annotation.NonNull
    public <T> com.google.android.gms.tasks.Task<T> scheduleStateChange(@androidx.annotation.NonNull com.otaliastudios.cameraview.engine.orchestrator.CameraState cameraState, @androidx.annotation.NonNull com.otaliastudios.cameraview.engine.orchestrator.CameraState cameraState2, boolean z, @androidx.annotation.NonNull java.util.concurrent.Callable<com.google.android.gms.tasks.Task<T>> callable) {
        java.lang.StringBuilder sb;
        java.lang.String sb2;
        int i = this.d + 1;
        this.d = i;
        this.c = cameraState2;
        boolean z2 = !cameraState2.isAtLeast(cameraState);
        if (z2) {
            sb = new java.lang.StringBuilder();
            sb.append(cameraState.name());
            sb.append(" << ");
            sb.append(cameraState2.name());
            sb2 = sb.toString();
        } else {
            sb = new java.lang.StringBuilder();
            sb.append(cameraState.name());
            sb.append(" >> ");
            sb.append(cameraState2.name());
            sb2 = sb.toString();
        }
        return schedule(sb2, z, new com.otaliastudios.cameraview.engine.orchestrator.CameraStateOrchestrator.AnonymousClass2(cameraState, sb2, cameraState2, callable, z2)).addOnCompleteListener(new com.otaliastudios.cameraview.engine.orchestrator.CameraStateOrchestrator.AnonymousClass1(i));
    }

    @androidx.annotation.NonNull
    public com.google.android.gms.tasks.Task<java.lang.Void> scheduleStateful(@androidx.annotation.NonNull java.lang.String str, @androidx.annotation.NonNull com.otaliastudios.cameraview.engine.orchestrator.CameraState cameraState, @androidx.annotation.NonNull java.lang.Runnable runnable) {
        return schedule(str, true, (java.lang.Runnable) new com.otaliastudios.cameraview.engine.orchestrator.CameraStateOrchestrator.AnonymousClass3(cameraState, runnable));
    }

    public void scheduleStatefulDelayed(@androidx.annotation.NonNull java.lang.String str, @androidx.annotation.NonNull com.otaliastudios.cameraview.engine.orchestrator.CameraState cameraState, long j, @androidx.annotation.NonNull java.lang.Runnable runnable) {
        scheduleDelayed(str, j, new com.otaliastudios.cameraview.engine.orchestrator.CameraStateOrchestrator.AnonymousClass4(cameraState, runnable));
    }
}
