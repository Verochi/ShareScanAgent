package io.reactivex.internal.schedulers;

/* loaded from: classes13.dex */
public final class NewThreadScheduler extends io.reactivex.Scheduler {
    public static final io.reactivex.internal.schedulers.RxThreadFactory u = new io.reactivex.internal.schedulers.RxThreadFactory("RxNewThreadScheduler", java.lang.Math.max(1, java.lang.Math.min(10, java.lang.Integer.getInteger("rx2.newthread-priority", 5).intValue())));
    public final java.util.concurrent.ThreadFactory t;

    public NewThreadScheduler() {
        this(u);
    }

    public NewThreadScheduler(java.util.concurrent.ThreadFactory threadFactory) {
        this.t = threadFactory;
    }

    @Override // io.reactivex.Scheduler
    @io.reactivex.annotations.NonNull
    public io.reactivex.Scheduler.Worker createWorker() {
        return new io.reactivex.internal.schedulers.NewThreadWorker(this.t);
    }
}
