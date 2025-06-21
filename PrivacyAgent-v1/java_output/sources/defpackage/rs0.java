package defpackage;

/* loaded from: classes.dex */
public final /* synthetic */ class rs0 implements java.lang.Runnable {
    public final /* synthetic */ androidx.room.InvalidationTracker n;

    public /* synthetic */ rs0(androidx.room.InvalidationTracker invalidationTracker) {
        this.n = invalidationTracker;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.n.onAutoCloseCallback();
    }
}
