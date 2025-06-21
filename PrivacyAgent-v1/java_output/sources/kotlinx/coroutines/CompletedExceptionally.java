package kotlinx.coroutines;

@kotlin.Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0000\b\u0010\u0018\u00002\u00020\u000fB\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\u0002\u001a\u00020\u00018\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0002\u0010\fR\u0013\u0010\u0004\u001a\u00020\u00038F@\u0006¢\u0006\u0006\u001a\u0004\b\r\u0010\b¨\u0006\u000e"}, d2 = {"Lkotlinx/coroutines/CompletedExceptionally;", "", "cause", "", "handled", "<init>", "(Ljava/lang/Throwable;Z)V", "makeHandled", "()Z", "", "toString", "()Ljava/lang/String;", "Ljava/lang/Throwable;", "getHandled", "kotlinx-coroutines-core", ""}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes15.dex */
public class CompletedExceptionally {
    public static final /* synthetic */ java.util.concurrent.atomic.AtomicIntegerFieldUpdater a = java.util.concurrent.atomic.AtomicIntegerFieldUpdater.newUpdater(kotlinx.coroutines.CompletedExceptionally.class, "_handled");

    @org.jetbrains.annotations.NotNull
    private volatile /* synthetic */ int _handled;

    @kotlin.jvm.JvmField
    @org.jetbrains.annotations.NotNull
    public final java.lang.Throwable cause;

    public CompletedExceptionally(@org.jetbrains.annotations.NotNull java.lang.Throwable th, boolean z) {
        this.cause = th;
        this._handled = z ? 1 : 0;
    }

    public /* synthetic */ CompletedExceptionally(java.lang.Throwable th, boolean z, int i, kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
        this(th, (i & 2) != 0 ? false : z);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [boolean, int] */
    public final boolean getHandled() {
        return this._handled;
    }

    public final boolean makeHandled() {
        return a.compareAndSet(this, 0, 1);
    }

    @org.jetbrains.annotations.NotNull
    public java.lang.String toString() {
        return kotlinx.coroutines.DebugStringsKt.getClassSimpleName(this) + '[' + this.cause + ']';
    }
}
