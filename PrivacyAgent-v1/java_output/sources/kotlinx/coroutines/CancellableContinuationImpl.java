package kotlinx.coroutines;

@kotlin.Metadata(d1 = {"\u0000¶\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0014\b\u0011\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\b\u0012\u0004\u0012\u00028\u00000\u00022\b\u0012\u0004\u0012\u00028\u00000\u00032\u00060\u0004j\u0002`\u0005B\u001f\u0012\f\u0010v\u001a\b\u0012\u0004\u0012\u00028\u00000r\u0012\u0006\u0010f\u001a\u00020`¢\u0006\u0006\b\u0089\u0001\u0010\u008a\u0001J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\n\u0018\u00010\fj\u0004\u0018\u0001`\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0011\u0010\u0013\u001a\u0004\u0018\u00010\u0010H\u0010¢\u0006\u0004\b\u0011\u0010\u0012J!\u0010\u0019\u001a\u00020\u00062\b\u0010\u0014\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0016\u001a\u00020\u0015H\u0010¢\u0006\u0004\b\u0017\u0010\u0018J\u0019\u0010\u001a\u001a\u00020\t2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0015H\u0000¢\u0006\u0004\b\u001c\u0010\u001dJ\u001f\u0010!\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u001f2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015¢\u0006\u0004\b!\u0010\"J8\u0010'\u001a\u00020\u00062!\u0010&\u001a\u001d\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u00060#2\u0006\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b'\u0010(J\u0017\u0010+\u001a\u00020\u00152\u0006\u0010*\u001a\u00020)H\u0016¢\u0006\u0004\b+\u0010,J\u0011\u0010-\u001a\u0004\u0018\u00010\u0010H\u0001¢\u0006\u0004\b-\u0010\u0012J \u00100\u001a\u00020\u00062\f\u0010/\u001a\b\u0012\u0004\u0012\u00028\u00000.H\u0016ø\u0001\u0000¢\u0006\u0004\b0\u00101J<\u00103\u001a\u00020\u00062\u0006\u00102\u001a\u00028\u00002#\u0010&\u001a\u001f\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010#H\u0016¢\u0006\u0004\b3\u00104J8\u00106\u001a\u00020\u00062'\u0010 \u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0015¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u00060#j\u0002`5H\u0016¢\u0006\u0004\b6\u00107J\u000f\u00109\u001a\u00020\u0006H\u0000¢\u0006\u0004\b8\u0010\bJ#\u0010;\u001a\u0004\u0018\u00010\u00102\u0006\u00102\u001a\u00028\u00002\b\u0010:\u001a\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0004\b;\u0010<JH\u0010;\u001a\u0004\u0018\u00010\u00102\u0006\u00102\u001a\u00028\u00002\b\u0010:\u001a\u0004\u0018\u00010\u00102#\u0010&\u001a\u001f\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010#H\u0016¢\u0006\u0004\b;\u0010=J\u0019\u0010?\u001a\u0004\u0018\u00010\u00102\u0006\u0010>\u001a\u00020\u0015H\u0016¢\u0006\u0004\b?\u0010@J\u0017\u0010B\u001a\u00020\u00062\u0006\u0010A\u001a\u00020\u0010H\u0016¢\u0006\u0004\bB\u00101J\u001b\u0010D\u001a\u00020\u0006*\u00020C2\u0006\u00102\u001a\u00028\u0000H\u0016¢\u0006\u0004\bD\u0010EJ\u001b\u0010F\u001a\u00020\u0006*\u00020C2\u0006\u0010>\u001a\u00020\u0015H\u0016¢\u0006\u0004\bF\u0010GJ\u001f\u0010K\u001a\u00028\u0001\"\u0004\b\u0001\u0010\u00012\b\u0010H\u001a\u0004\u0018\u00010\u0010H\u0010¢\u0006\u0004\bI\u0010JJ\u001b\u0010N\u001a\u0004\u0018\u00010\u00152\b\u0010H\u001a\u0004\u0018\u00010\u0010H\u0010¢\u0006\u0004\bL\u0010MJ\u000f\u0010P\u001a\u00020OH\u0016¢\u0006\u0004\bP\u0010QJ\u000f\u0010R\u001a\u00020OH\u0014¢\u0006\u0004\bR\u0010QJ\u000f\u0010S\u001a\u00020\tH\u0002¢\u0006\u0004\bS\u0010\u000bJ\u0017\u0010T\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u0015H\u0002¢\u0006\u0004\bT\u0010\u001bJB\u0010U\u001a\u00020\u00062'\u0010 \u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0015¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u00060#j\u0002`52\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0002¢\u0006\u0004\bU\u0010(J\u000f\u0010V\u001a\u00020\tH\u0002¢\u0006\u0004\bV\u0010\u000bJ\u000f\u0010W\u001a\u00020\tH\u0002¢\u0006\u0004\bW\u0010\u000bJ\u0011\u0010Y\u001a\u0004\u0018\u00010XH\u0002¢\u0006\u0004\bY\u0010ZJ\u000f\u0010[\u001a\u00020\u0006H\u0002¢\u0006\u0004\b[\u0010\bJB\u0010\\\u001a\u00020\u00062'\u0010 \u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0015¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u00060#j\u0002`52\b\u0010H\u001a\u0004\u0018\u00010\u0010H\u0002¢\u0006\u0004\b\\\u0010]J8\u0010^\u001a\u00020\u001f2'\u0010 \u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0015¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u00060#j\u0002`5H\u0002¢\u0006\u0004\b^\u0010_J\u0017\u0010b\u001a\u00020\u00062\u0006\u0010a\u001a\u00020`H\u0002¢\u0006\u0004\bb\u0010cJZ\u0010g\u001a\u0004\u0018\u00010\u00102\u0006\u0010H\u001a\u00020d2\b\u0010e\u001a\u0004\u0018\u00010\u00102\u0006\u0010f\u001a\u00020`2#\u0010&\u001a\u001f\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010#2\b\u0010:\u001a\u0004\u0018\u00010\u0010H\u0002¢\u0006\u0004\bg\u0010hJH\u0010i\u001a\u00020\u00062\b\u0010e\u001a\u0004\u0018\u00010\u00102\u0006\u0010f\u001a\u00020`2%\b\u0002\u0010&\u001a\u001f\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010#H\u0002¢\u0006\u0004\bi\u0010jJJ\u0010l\u001a\u0004\u0018\u00010k2\b\u0010e\u001a\u0004\u0018\u00010\u00102\b\u0010:\u001a\u0004\u0018\u00010\u00102#\u0010&\u001a\u001f\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010#H\u0002¢\u0006\u0004\bl\u0010mJ\u0019\u0010o\u001a\u00020n2\b\u0010e\u001a\u0004\u0018\u00010\u0010H\u0002¢\u0006\u0004\bo\u0010pJ\u000f\u0010q\u001a\u00020\u0006H\u0002¢\u0006\u0004\bq\u0010\bR \u0010v\u001a\b\u0012\u0004\u0012\u00028\u00000r8\u0000X\u0080\u0004¢\u0006\f\n\u0004\bg\u0010s\u001a\u0004\bt\u0010uR\u001a\u0010|\u001a\u00020w8\u0016X\u0096\u0004¢\u0006\f\n\u0004\bx\u0010y\u001a\u0004\bz\u0010{R\u0018\u0010\u007f\u001a\u0004\u0018\u00010X8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b}\u0010~R\u0017\u0010H\u001a\u0004\u0018\u00010\u00108@X\u0080\u0004¢\u0006\u0007\u001a\u0005\b\u0080\u0001\u0010\u0012R\u0016\u0010\u0081\u0001\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0007\u001a\u0005\b\u0081\u0001\u0010\u000bR\u0016\u0010\u0082\u0001\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0007\u001a\u0005\b\u0082\u0001\u0010\u000bR\u0016\u0010\u0083\u0001\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0007\u001a\u0005\b\u0083\u0001\u0010\u000bR\u001f\u0010\u0086\u0001\u001a\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u00058VX\u0096\u0004¢\u0006\b\u001a\u0006\b\u0084\u0001\u0010\u0085\u0001R\u0016\u0010\u0088\u0001\u001a\u00020O8BX\u0082\u0004¢\u0006\u0007\u001a\u0005\b\u0087\u0001\u0010Q\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u008b\u0001"}, d2 = {"Lkotlinx/coroutines/CancellableContinuationImpl;", androidx.exifinterface.media.ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/DispatchedTask;", "Lkotlinx/coroutines/CancellableContinuation;", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "Lkotlinx/coroutines/internal/CoroutineStackFrame;", "", "initCancellability", "()V", "", "resetStateReusable", "()Z", "Ljava/lang/StackTraceElement;", "Lkotlinx/coroutines/internal/StackTraceElement;", "getStackTraceElement", "()Ljava/lang/StackTraceElement;", "", "takeState$kotlinx_coroutines_core", "()Ljava/lang/Object;", "takeState", "takenState", "", "cause", "cancelCompletedResult$kotlinx_coroutines_core", "(Ljava/lang/Object;Ljava/lang/Throwable;)V", "cancelCompletedResult", com.anythink.expressad.d.a.b.dO, "(Ljava/lang/Throwable;)Z", "parentCancelled$kotlinx_coroutines_core", "(Ljava/lang/Throwable;)V", "parentCancelled", "Lkotlinx/coroutines/CancelHandler;", "handler", "callCancelHandler", "(Lkotlinx/coroutines/CancelHandler;Ljava/lang/Throwable;)V", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "onCancellation", "callOnCancellation", "(Lkotlin/jvm/functions/Function1;Ljava/lang/Throwable;)V", "Lkotlinx/coroutines/Job;", "parent", "getContinuationCancellationCause", "(Lkotlinx/coroutines/Job;)Ljava/lang/Throwable;", "getResult", "Lkotlin/Result;", "result", "resumeWith", "(Ljava/lang/Object;)V", "value", com.anythink.expressad.foundation.d.c.cc, "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "Lkotlinx/coroutines/CompletionHandler;", "invokeOnCancellation", "(Lkotlin/jvm/functions/Function1;)V", "detachChild$kotlinx_coroutines_core", "detachChild", "idempotent", "tryResume", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "(Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "exception", "tryResumeWithException", "(Ljava/lang/Throwable;)Ljava/lang/Object;", "token", "completeResume", "Lkotlinx/coroutines/CoroutineDispatcher;", "resumeUndispatched", "(Lkotlinx/coroutines/CoroutineDispatcher;Ljava/lang/Object;)V", "resumeUndispatchedWithException", "(Lkotlinx/coroutines/CoroutineDispatcher;Ljava/lang/Throwable;)V", com.anythink.expressad.atsignalcommon.mraid.CallMraidJS.b, "getSuccessfulResult$kotlinx_coroutines_core", "(Ljava/lang/Object;)Ljava/lang/Object;", "getSuccessfulResult", "getExceptionalResult$kotlinx_coroutines_core", "(Ljava/lang/Object;)Ljava/lang/Throwable;", "getExceptionalResult", "", "toString", "()Ljava/lang/String;", "nameString", "h", "c", "b", "q", "o", "Lkotlinx/coroutines/DisposableHandle;", "g", "()Lkotlinx/coroutines/DisposableHandle;", "k", "j", "(Lkotlin/jvm/functions/Function1;Ljava/lang/Object;)V", "i", "(Lkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/CancelHandler;", "", "mode", "e", "(I)V", "Lkotlinx/coroutines/NotCompleted;", "proposedUpdate", "resumeMode", com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.AD_COUNT, "(Lkotlinx/coroutines/NotCompleted;Ljava/lang/Object;ILkotlin/jvm/functions/Function1;Ljava/lang/Object;)Ljava/lang/Object;", "l", "(Ljava/lang/Object;ILkotlin/jvm/functions/Function1;)V", "Lkotlinx/coroutines/internal/Symbol;", "p", "(Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/internal/Symbol;", "", "a", "(Ljava/lang/Object;)Ljava/lang/Void;", "d", "Lkotlin/coroutines/Continuation;", "Lkotlin/coroutines/Continuation;", "getDelegate$kotlinx_coroutines_core", "()Lkotlin/coroutines/Continuation;", "delegate", "Lkotlin/coroutines/CoroutineContext;", "t", "Lkotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "context", com.umeng.analytics.pro.bo.aN, "Lkotlinx/coroutines/DisposableHandle;", "parentHandle", "getState$kotlinx_coroutines_core", "isActive", "isCompleted", "isCancelled", "getCallerFrame", "()Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "callerFrame", "f", "stateDebugRepresentation", "<init>", "(Lkotlin/coroutines/Continuation;I)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1})
@kotlin.PublishedApi
/* loaded from: classes15.dex */
public class CancellableContinuationImpl<T> extends kotlinx.coroutines.DispatchedTask<T> implements kotlinx.coroutines.CancellableContinuation<T>, kotlin.coroutines.jvm.internal.CoroutineStackFrame {
    public static final /* synthetic */ java.util.concurrent.atomic.AtomicIntegerFieldUpdater v = java.util.concurrent.atomic.AtomicIntegerFieldUpdater.newUpdater(kotlinx.coroutines.CancellableContinuationImpl.class, "_decision");
    public static final /* synthetic */ java.util.concurrent.atomic.AtomicReferenceFieldUpdater w = java.util.concurrent.atomic.AtomicReferenceFieldUpdater.newUpdater(kotlinx.coroutines.CancellableContinuationImpl.class, java.lang.Object.class, "_state");

    @org.jetbrains.annotations.NotNull
    private volatile /* synthetic */ int _decision;

    @org.jetbrains.annotations.NotNull
    private volatile /* synthetic */ java.lang.Object _state;

    /* renamed from: n, reason: from kotlin metadata */
    @org.jetbrains.annotations.NotNull
    public final kotlin.coroutines.Continuation<T> delegate;

    /* renamed from: t, reason: from kotlin metadata */
    @org.jetbrains.annotations.NotNull
    public final kotlin.coroutines.CoroutineContext context;

    /* renamed from: u, reason: from kotlin metadata */
    @org.jetbrains.annotations.Nullable
    public kotlinx.coroutines.DisposableHandle parentHandle;

    /* JADX WARN: Multi-variable type inference failed */
    public CancellableContinuationImpl(@org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super T> continuation, int i) {
        super(i);
        this.delegate = continuation;
        this.context = continuation.getContext();
        this._decision = 0;
        this._state = kotlinx.coroutines.Active.n;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void m(kotlinx.coroutines.CancellableContinuationImpl cancellableContinuationImpl, java.lang.Object obj, int i, kotlin.jvm.functions.Function1 function1, int i2, java.lang.Object obj2) {
        if (obj2 != null) {
            throw new java.lang.UnsupportedOperationException("Super calls with default arguments not supported in this target, function: resumeImpl");
        }
        if ((i2 & 4) != 0) {
            function1 = null;
        }
        cancellableContinuationImpl.l(obj, i, function1);
    }

    public final java.lang.Void a(java.lang.Object proposedUpdate) {
        throw new java.lang.IllegalStateException(kotlin.jvm.internal.Intrinsics.stringPlus("Already resumed, but proposed with update ", proposedUpdate).toString());
    }

    public final void b(kotlin.jvm.functions.Function1<? super java.lang.Throwable, kotlin.Unit> handler, java.lang.Throwable cause) {
        try {
            handler.invoke(cause);
        } catch (java.lang.Throwable th) {
            kotlinx.coroutines.CoroutineExceptionHandlerKt.handleCoroutineException(getContext(), new kotlinx.coroutines.CompletionHandlerException(kotlin.jvm.internal.Intrinsics.stringPlus("Exception in invokeOnCancellation handler for ", this), th));
        }
    }

    public final boolean c(java.lang.Throwable cause) {
        if (kotlinx.coroutines.DispatchedTaskKt.isReusableMode(this.resumeMode) && h()) {
            return ((kotlinx.coroutines.internal.DispatchedContinuation) this.delegate).postponeCancellation(cause);
        }
        return false;
    }

    public final void callCancelHandler(@org.jetbrains.annotations.NotNull kotlinx.coroutines.CancelHandler handler, @org.jetbrains.annotations.Nullable java.lang.Throwable cause) {
        try {
            handler.invoke(cause);
        } catch (java.lang.Throwable th) {
            kotlinx.coroutines.CoroutineExceptionHandlerKt.handleCoroutineException(getContext(), new kotlinx.coroutines.CompletionHandlerException(kotlin.jvm.internal.Intrinsics.stringPlus("Exception in invokeOnCancellation handler for ", this), th));
        }
    }

    public final void callOnCancellation(@org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super java.lang.Throwable, kotlin.Unit> onCancellation, @org.jetbrains.annotations.NotNull java.lang.Throwable cause) {
        try {
            onCancellation.invoke(cause);
        } catch (java.lang.Throwable th) {
            kotlinx.coroutines.CoroutineExceptionHandlerKt.handleCoroutineException(getContext(), new kotlinx.coroutines.CompletionHandlerException(kotlin.jvm.internal.Intrinsics.stringPlus("Exception in resume onCancellation handler for ", this), th));
        }
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public boolean cancel(@org.jetbrains.annotations.Nullable java.lang.Throwable cause) {
        java.lang.Object obj;
        boolean z;
        do {
            obj = this._state;
            if (!(obj instanceof kotlinx.coroutines.NotCompleted)) {
                return false;
            }
            z = obj instanceof kotlinx.coroutines.CancelHandler;
        } while (!defpackage.q1.a(w, this, obj, new kotlinx.coroutines.CancelledContinuation(this, cause, z)));
        kotlinx.coroutines.CancelHandler cancelHandler = z ? (kotlinx.coroutines.CancelHandler) obj : null;
        if (cancelHandler != null) {
            callCancelHandler(cancelHandler, cause);
        }
        d();
        e(this.resumeMode);
        return true;
    }

    @Override // kotlinx.coroutines.DispatchedTask
    public void cancelCompletedResult$kotlinx_coroutines_core(@org.jetbrains.annotations.Nullable java.lang.Object takenState, @org.jetbrains.annotations.NotNull java.lang.Throwable cause) {
        while (true) {
            java.lang.Object obj = this._state;
            if (obj instanceof kotlinx.coroutines.NotCompleted) {
                throw new java.lang.IllegalStateException("Not completed".toString());
            }
            if (obj instanceof kotlinx.coroutines.CompletedExceptionally) {
                return;
            }
            if (obj instanceof kotlinx.coroutines.CompletedContinuation) {
                kotlinx.coroutines.CompletedContinuation completedContinuation = (kotlinx.coroutines.CompletedContinuation) obj;
                if (!(!completedContinuation.c())) {
                    throw new java.lang.IllegalStateException("Must be called at most once".toString());
                }
                if (defpackage.q1.a(w, this, obj, kotlinx.coroutines.CompletedContinuation.b(completedContinuation, null, null, null, null, cause, 15, null))) {
                    completedContinuation.d(this, cause);
                    return;
                }
            } else if (defpackage.q1.a(w, this, obj, new kotlinx.coroutines.CompletedContinuation(obj, null, null, null, cause, 14, null))) {
                return;
            }
        }
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public void completeResume(@org.jetbrains.annotations.NotNull java.lang.Object token) {
        e(this.resumeMode);
    }

    public final void d() {
        if (h()) {
            return;
        }
        detachChild$kotlinx_coroutines_core();
    }

    public final void detachChild$kotlinx_coroutines_core() {
        kotlinx.coroutines.DisposableHandle disposableHandle = this.parentHandle;
        if (disposableHandle == null) {
            return;
        }
        disposableHandle.dispose();
        this.parentHandle = kotlinx.coroutines.NonDisposableHandle.INSTANCE;
    }

    public final void e(int mode) {
        if (o()) {
            return;
        }
        kotlinx.coroutines.DispatchedTaskKt.dispatch(this, mode);
    }

    public final java.lang.String f() {
        java.lang.Object obj = get_state();
        return obj instanceof kotlinx.coroutines.NotCompleted ? "Active" : obj instanceof kotlinx.coroutines.CancelledContinuation ? "Cancelled" : "Completed";
    }

    public final kotlinx.coroutines.DisposableHandle g() {
        kotlinx.coroutines.Job job = (kotlinx.coroutines.Job) getContext().get(kotlinx.coroutines.Job.INSTANCE);
        if (job == null) {
            return null;
        }
        kotlinx.coroutines.DisposableHandle invokeOnCompletion$default = kotlinx.coroutines.Job.DefaultImpls.invokeOnCompletion$default(job, true, false, new kotlinx.coroutines.ChildContinuation(this), 2, null);
        this.parentHandle = invokeOnCompletion$default;
        return invokeOnCompletion$default;
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    @org.jetbrains.annotations.Nullable
    public kotlin.coroutines.jvm.internal.CoroutineStackFrame getCallerFrame() {
        kotlin.coroutines.Continuation<T> continuation = this.delegate;
        if (continuation instanceof kotlin.coroutines.jvm.internal.CoroutineStackFrame) {
            return (kotlin.coroutines.jvm.internal.CoroutineStackFrame) continuation;
        }
        return null;
    }

    @Override // kotlin.coroutines.Continuation
    @org.jetbrains.annotations.NotNull
    public kotlin.coroutines.CoroutineContext getContext() {
        return this.context;
    }

    @org.jetbrains.annotations.NotNull
    public java.lang.Throwable getContinuationCancellationCause(@org.jetbrains.annotations.NotNull kotlinx.coroutines.Job parent) {
        return parent.getCancellationException();
    }

    @Override // kotlinx.coroutines.DispatchedTask
    @org.jetbrains.annotations.NotNull
    public final kotlin.coroutines.Continuation<T> getDelegate$kotlinx_coroutines_core() {
        return this.delegate;
    }

    @Override // kotlinx.coroutines.DispatchedTask
    @org.jetbrains.annotations.Nullable
    public java.lang.Throwable getExceptionalResult$kotlinx_coroutines_core(@org.jetbrains.annotations.Nullable java.lang.Object state) {
        java.lang.Throwable exceptionalResult$kotlinx_coroutines_core = super.getExceptionalResult$kotlinx_coroutines_core(state);
        if (exceptionalResult$kotlinx_coroutines_core == null) {
            return null;
        }
        getDelegate$kotlinx_coroutines_core();
        return exceptionalResult$kotlinx_coroutines_core;
    }

    @kotlin.PublishedApi
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object getResult() {
        kotlinx.coroutines.Job job;
        java.lang.Object coroutine_suspended;
        boolean h = h();
        if (q()) {
            if (this.parentHandle == null) {
                g();
            }
            if (h) {
                k();
            }
            coroutine_suspended = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            return coroutine_suspended;
        }
        if (h) {
            k();
        }
        java.lang.Object obj = get_state();
        if (obj instanceof kotlinx.coroutines.CompletedExceptionally) {
            throw ((kotlinx.coroutines.CompletedExceptionally) obj).cause;
        }
        if (!kotlinx.coroutines.DispatchedTaskKt.isCancellableMode(this.resumeMode) || (job = (kotlinx.coroutines.Job) getContext().get(kotlinx.coroutines.Job.INSTANCE)) == null || job.isActive()) {
            return getSuccessfulResult$kotlinx_coroutines_core(obj);
        }
        java.util.concurrent.CancellationException cancellationException = job.getCancellationException();
        cancelCompletedResult$kotlinx_coroutines_core(obj, cancellationException);
        throw cancellationException;
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    @org.jetbrains.annotations.Nullable
    public java.lang.StackTraceElement getStackTraceElement() {
        return null;
    }

    @org.jetbrains.annotations.Nullable
    /* renamed from: getState$kotlinx_coroutines_core, reason: from getter */
    public final java.lang.Object get_state() {
        return this._state;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.DispatchedTask
    public <T> T getSuccessfulResult$kotlinx_coroutines_core(@org.jetbrains.annotations.Nullable java.lang.Object state) {
        return state instanceof kotlinx.coroutines.CompletedContinuation ? (T) ((kotlinx.coroutines.CompletedContinuation) state).result : state;
    }

    public final boolean h() {
        kotlin.coroutines.Continuation<T> continuation = this.delegate;
        return (continuation instanceof kotlinx.coroutines.internal.DispatchedContinuation) && ((kotlinx.coroutines.internal.DispatchedContinuation) continuation).isReusable(this);
    }

    public final kotlinx.coroutines.CancelHandler i(kotlin.jvm.functions.Function1<? super java.lang.Throwable, kotlin.Unit> handler) {
        return handler instanceof kotlinx.coroutines.CancelHandler ? (kotlinx.coroutines.CancelHandler) handler : new kotlinx.coroutines.InvokeOnCancel(handler);
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public void initCancellability() {
        kotlinx.coroutines.DisposableHandle g = g();
        if (g != null && isCompleted()) {
            g.dispose();
            this.parentHandle = kotlinx.coroutines.NonDisposableHandle.INSTANCE;
        }
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public void invokeOnCancellation(@org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super java.lang.Throwable, kotlin.Unit> handler) {
        kotlinx.coroutines.CancelHandler i = i(handler);
        while (true) {
            java.lang.Object obj = this._state;
            if (obj instanceof kotlinx.coroutines.Active) {
                if (defpackage.q1.a(w, this, obj, i)) {
                    return;
                }
            } else if (obj instanceof kotlinx.coroutines.CancelHandler) {
                j(handler, obj);
            } else {
                boolean z = obj instanceof kotlinx.coroutines.CompletedExceptionally;
                if (z) {
                    kotlinx.coroutines.CompletedExceptionally completedExceptionally = (kotlinx.coroutines.CompletedExceptionally) obj;
                    if (!completedExceptionally.makeHandled()) {
                        j(handler, obj);
                    }
                    if (obj instanceof kotlinx.coroutines.CancelledContinuation) {
                        if (!z) {
                            completedExceptionally = null;
                        }
                        b(handler, completedExceptionally != null ? completedExceptionally.cause : null);
                        return;
                    }
                    return;
                }
                if (obj instanceof kotlinx.coroutines.CompletedContinuation) {
                    kotlinx.coroutines.CompletedContinuation completedContinuation = (kotlinx.coroutines.CompletedContinuation) obj;
                    if (completedContinuation.cancelHandler != null) {
                        j(handler, obj);
                    }
                    if (i instanceof kotlinx.coroutines.BeforeResumeCancelHandler) {
                        return;
                    }
                    if (completedContinuation.c()) {
                        b(handler, completedContinuation.cancelCause);
                        return;
                    } else {
                        if (defpackage.q1.a(w, this, obj, kotlinx.coroutines.CompletedContinuation.b(completedContinuation, null, i, null, null, null, 29, null))) {
                            return;
                        }
                    }
                } else {
                    if (i instanceof kotlinx.coroutines.BeforeResumeCancelHandler) {
                        return;
                    }
                    if (defpackage.q1.a(w, this, obj, new kotlinx.coroutines.CompletedContinuation(obj, i, null, null, null, 28, null))) {
                        return;
                    }
                }
            }
        }
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public boolean isActive() {
        return get_state() instanceof kotlinx.coroutines.NotCompleted;
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public boolean isCancelled() {
        return get_state() instanceof kotlinx.coroutines.CancelledContinuation;
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public boolean isCompleted() {
        return !(get_state() instanceof kotlinx.coroutines.NotCompleted);
    }

    public final void j(kotlin.jvm.functions.Function1<? super java.lang.Throwable, kotlin.Unit> handler, java.lang.Object state) {
        throw new java.lang.IllegalStateException(("It's prohibited to register multiple handlers, tried to register " + handler + ", already has " + state).toString());
    }

    public final void k() {
        kotlin.coroutines.Continuation<T> continuation = this.delegate;
        kotlinx.coroutines.internal.DispatchedContinuation dispatchedContinuation = continuation instanceof kotlinx.coroutines.internal.DispatchedContinuation ? (kotlinx.coroutines.internal.DispatchedContinuation) continuation : null;
        java.lang.Throwable tryReleaseClaimedContinuation = dispatchedContinuation != null ? dispatchedContinuation.tryReleaseClaimedContinuation(this) : null;
        if (tryReleaseClaimedContinuation == null) {
            return;
        }
        detachChild$kotlinx_coroutines_core();
        cancel(tryReleaseClaimedContinuation);
    }

    public final void l(java.lang.Object proposedUpdate, int resumeMode, kotlin.jvm.functions.Function1<? super java.lang.Throwable, kotlin.Unit> onCancellation) {
        java.lang.Object obj;
        do {
            obj = this._state;
            if (!(obj instanceof kotlinx.coroutines.NotCompleted)) {
                if (obj instanceof kotlinx.coroutines.CancelledContinuation) {
                    kotlinx.coroutines.CancelledContinuation cancelledContinuation = (kotlinx.coroutines.CancelledContinuation) obj;
                    if (cancelledContinuation.makeResumed()) {
                        if (onCancellation == null) {
                            return;
                        }
                        callOnCancellation(onCancellation, cancelledContinuation.cause);
                        return;
                    }
                }
                a(proposedUpdate);
                throw new kotlin.KotlinNothingValueException();
            }
        } while (!defpackage.q1.a(w, this, obj, n((kotlinx.coroutines.NotCompleted) obj, proposedUpdate, resumeMode, onCancellation, null)));
        d();
        e(resumeMode);
    }

    public final java.lang.Object n(kotlinx.coroutines.NotCompleted state, java.lang.Object proposedUpdate, int resumeMode, kotlin.jvm.functions.Function1<? super java.lang.Throwable, kotlin.Unit> onCancellation, java.lang.Object idempotent) {
        if (proposedUpdate instanceof kotlinx.coroutines.CompletedExceptionally) {
            return proposedUpdate;
        }
        if (!kotlinx.coroutines.DispatchedTaskKt.isCancellableMode(resumeMode) && idempotent == null) {
            return proposedUpdate;
        }
        if (onCancellation != null || (((state instanceof kotlinx.coroutines.CancelHandler) && !(state instanceof kotlinx.coroutines.BeforeResumeCancelHandler)) || idempotent != null)) {
            return new kotlinx.coroutines.CompletedContinuation(proposedUpdate, state instanceof kotlinx.coroutines.CancelHandler ? (kotlinx.coroutines.CancelHandler) state : null, onCancellation, idempotent, null, 16, null);
        }
        return proposedUpdate;
    }

    @org.jetbrains.annotations.NotNull
    public java.lang.String nameString() {
        return "CancellableContinuation";
    }

    public final boolean o() {
        do {
            int i = this._decision;
            if (i != 0) {
                if (i == 1) {
                    return false;
                }
                throw new java.lang.IllegalStateException("Already resumed".toString());
            }
        } while (!v.compareAndSet(this, 0, 2));
        return true;
    }

    public final kotlinx.coroutines.internal.Symbol p(java.lang.Object proposedUpdate, java.lang.Object idempotent, kotlin.jvm.functions.Function1<? super java.lang.Throwable, kotlin.Unit> onCancellation) {
        java.lang.Object obj;
        do {
            obj = this._state;
            if (!(obj instanceof kotlinx.coroutines.NotCompleted)) {
                if ((obj instanceof kotlinx.coroutines.CompletedContinuation) && idempotent != null && ((kotlinx.coroutines.CompletedContinuation) obj).idempotentResume == idempotent) {
                    return kotlinx.coroutines.CancellableContinuationImplKt.RESUME_TOKEN;
                }
                return null;
            }
        } while (!defpackage.q1.a(w, this, obj, n((kotlinx.coroutines.NotCompleted) obj, proposedUpdate, this.resumeMode, onCancellation, idempotent)));
        d();
        return kotlinx.coroutines.CancellableContinuationImplKt.RESUME_TOKEN;
    }

    public final void parentCancelled$kotlinx_coroutines_core(@org.jetbrains.annotations.NotNull java.lang.Throwable cause) {
        if (c(cause)) {
            return;
        }
        cancel(cause);
        d();
    }

    public final boolean q() {
        do {
            int i = this._decision;
            if (i != 0) {
                if (i == 2) {
                    return false;
                }
                throw new java.lang.IllegalStateException("Already suspended".toString());
            }
        } while (!v.compareAndSet(this, 0, 1));
        return true;
    }

    @kotlin.jvm.JvmName(name = "resetStateReusable")
    public final boolean resetStateReusable() {
        java.lang.Object obj = this._state;
        if ((obj instanceof kotlinx.coroutines.CompletedContinuation) && ((kotlinx.coroutines.CompletedContinuation) obj).idempotentResume != null) {
            detachChild$kotlinx_coroutines_core();
            return false;
        }
        this._decision = 0;
        this._state = kotlinx.coroutines.Active.n;
        return true;
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public void resume(T value, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function1<? super java.lang.Throwable, kotlin.Unit> onCancellation) {
        l(value, this.resumeMode, onCancellation);
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public void resumeUndispatched(@org.jetbrains.annotations.NotNull kotlinx.coroutines.CoroutineDispatcher coroutineDispatcher, T t) {
        kotlin.coroutines.Continuation<T> continuation = this.delegate;
        kotlinx.coroutines.internal.DispatchedContinuation dispatchedContinuation = continuation instanceof kotlinx.coroutines.internal.DispatchedContinuation ? (kotlinx.coroutines.internal.DispatchedContinuation) continuation : null;
        m(this, t, (dispatchedContinuation != null ? dispatchedContinuation.dispatcher : null) == coroutineDispatcher ? 4 : this.resumeMode, null, 4, null);
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public void resumeUndispatchedWithException(@org.jetbrains.annotations.NotNull kotlinx.coroutines.CoroutineDispatcher coroutineDispatcher, @org.jetbrains.annotations.NotNull java.lang.Throwable th) {
        kotlin.coroutines.Continuation<T> continuation = this.delegate;
        kotlinx.coroutines.internal.DispatchedContinuation dispatchedContinuation = continuation instanceof kotlinx.coroutines.internal.DispatchedContinuation ? (kotlinx.coroutines.internal.DispatchedContinuation) continuation : null;
        m(this, new kotlinx.coroutines.CompletedExceptionally(th, false, 2, null), (dispatchedContinuation != null ? dispatchedContinuation.dispatcher : null) == coroutineDispatcher ? 4 : this.resumeMode, null, 4, null);
    }

    @Override // kotlin.coroutines.Continuation
    public void resumeWith(@org.jetbrains.annotations.NotNull java.lang.Object result) {
        m(this, kotlinx.coroutines.CompletionStateKt.toState(result, this), this.resumeMode, null, 4, null);
    }

    @Override // kotlinx.coroutines.DispatchedTask
    @org.jetbrains.annotations.Nullable
    public java.lang.Object takeState$kotlinx_coroutines_core() {
        return get_state();
    }

    @org.jetbrains.annotations.NotNull
    public java.lang.String toString() {
        return nameString() + '(' + kotlinx.coroutines.DebugStringsKt.toDebugString(this.delegate) + "){" + f() + "}@" + kotlinx.coroutines.DebugStringsKt.getHexAddress(this);
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    @org.jetbrains.annotations.Nullable
    public java.lang.Object tryResume(T value, @org.jetbrains.annotations.Nullable java.lang.Object idempotent) {
        return p(value, idempotent, null);
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    @org.jetbrains.annotations.Nullable
    public java.lang.Object tryResume(T value, @org.jetbrains.annotations.Nullable java.lang.Object idempotent, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function1<? super java.lang.Throwable, kotlin.Unit> onCancellation) {
        return p(value, idempotent, onCancellation);
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    @org.jetbrains.annotations.Nullable
    public java.lang.Object tryResumeWithException(@org.jetbrains.annotations.NotNull java.lang.Throwable exception) {
        return p(new kotlinx.coroutines.CompletedExceptionally(exception, false, 2, null), null, null);
    }
}
