package kotlinx.coroutines;

@kotlin.Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002#\u0012\u0015\u0012\u0013\u0018\u00010\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u00060\u0001j\u0002`\u0007B\u000f\u0012\u0006\u0010\u0015\u001a\u00020\u0012¢\u0006\u0004\b\u001f\u0010 J\r\u0010\b\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\r\u0010\n\u001a\u00020\u0006¢\u0006\u0004\b\n\u0010\tJ\u001a\u0010\u000b\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0096\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0015\u001a\u00020\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u001c\u0010\u001a\u001a\n \u0017*\u0004\u0018\u00010\u00160\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001d¨\u0006!"}, d2 = {"Lkotlinx/coroutines/ThreadState;", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "cause", "", "Lkotlinx/coroutines/CompletionHandler;", "d", "()V", "a", "c", "(Ljava/lang/Throwable;)V", "", com.anythink.expressad.atsignalcommon.mraid.CallMraidJS.b, "", "b", "(I)Ljava/lang/Void;", "Lkotlinx/coroutines/Job;", com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.AD_COUNT, "Lkotlinx/coroutines/Job;", "job", "Ljava/lang/Thread;", "kotlin.jvm.PlatformType", "t", "Ljava/lang/Thread;", "targetThread", "Lkotlinx/coroutines/DisposableHandle;", com.umeng.analytics.pro.bo.aN, "Lkotlinx/coroutines/DisposableHandle;", "cancelHandle", "<init>", "(Lkotlinx/coroutines/Job;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes15.dex */
final class ThreadState implements kotlin.jvm.functions.Function1<java.lang.Throwable, kotlin.Unit> {
    public static final /* synthetic */ java.util.concurrent.atomic.AtomicIntegerFieldUpdater v = java.util.concurrent.atomic.AtomicIntegerFieldUpdater.newUpdater(kotlinx.coroutines.ThreadState.class, "_state");

    /* renamed from: n, reason: from kotlin metadata */
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.Job job;

    /* renamed from: u, reason: from kotlin metadata */
    @org.jetbrains.annotations.Nullable
    public kotlinx.coroutines.DisposableHandle cancelHandle;

    @org.jetbrains.annotations.NotNull
    private volatile /* synthetic */ int _state = 0;

    /* renamed from: t, reason: from kotlin metadata */
    public final java.lang.Thread targetThread = java.lang.Thread.currentThread();

    public ThreadState(@org.jetbrains.annotations.NotNull kotlinx.coroutines.Job job) {
        this.job = job;
    }

    public final void a() {
        while (true) {
            int i = this._state;
            if (i != 0) {
                if (i != 2) {
                    if (i == 3) {
                        java.lang.Thread.interrupted();
                        return;
                    } else {
                        b(i);
                        throw new kotlin.KotlinNothingValueException();
                    }
                }
            } else if (v.compareAndSet(this, i, 1)) {
                kotlinx.coroutines.DisposableHandle disposableHandle = this.cancelHandle;
                if (disposableHandle == null) {
                    return;
                }
                disposableHandle.dispose();
                return;
            }
        }
    }

    public final java.lang.Void b(int state) {
        throw new java.lang.IllegalStateException(kotlin.jvm.internal.Intrinsics.stringPlus("Illegal state ", java.lang.Integer.valueOf(state)).toString());
    }

    public void c(@org.jetbrains.annotations.Nullable java.lang.Throwable cause) {
        int i;
        do {
            i = this._state;
            if (i != 0) {
                if (i == 1 || i == 2 || i == 3) {
                    return;
                }
                b(i);
                throw new kotlin.KotlinNothingValueException();
            }
        } while (!v.compareAndSet(this, i, 2));
        this.targetThread.interrupt();
        this._state = 3;
    }

    public final void d() {
        int i;
        this.cancelHandle = this.job.invokeOnCompletion(true, true, this);
        do {
            i = this._state;
            if (i != 0) {
                if (i == 2 || i == 3) {
                    return;
                }
                b(i);
                throw new kotlin.KotlinNothingValueException();
            }
        } while (!v.compareAndSet(this, i, 0));
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ kotlin.Unit invoke(java.lang.Throwable th) {
        c(th);
        return kotlin.Unit.INSTANCE;
    }
}
