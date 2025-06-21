package kotlinx.coroutines;

@kotlin.Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\b&\u0018\u0000 \u00172\u00020\u00012\u00020\u0002:\u0001\u0017B\u0005¢\u0006\u0002\u0010\u0003J\u001c\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\n\u0010\b\u001a\u00060\tj\u0002`\nH&J\u001c\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\n\u0010\b\u001a\u00060\tj\u0002`\nH\u0017J \u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u000e0\r\"\u0004\b\u0000\u0010\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u000e0\rJ\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0011\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u0000H\u0087\u0002J\u0014\u0010\u0014\u001a\u00020\u00052\n\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\rH\u0017J\b\u0010\u0015\u001a\u00020\u0016H\u0016¨\u0006\u0018"}, d2 = {"Lkotlinx/coroutines/CoroutineDispatcher;", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlin/coroutines/ContinuationInterceptor;", "()V", "dispatch", "", "context", "Lkotlin/coroutines/CoroutineContext;", "block", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "dispatchYield", "interceptContinuation", "Lkotlin/coroutines/Continuation;", androidx.exifinterface.media.ExifInterface.GPS_DIRECTION_TRUE, "continuation", "isDispatchNeeded", "", "plus", "other", "releaseInterceptedContinuation", "toString", "", "Key", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes15.dex */
public abstract class CoroutineDispatcher extends kotlin.coroutines.AbstractCoroutineContextElement implements kotlin.coroutines.ContinuationInterceptor {

    /* renamed from: Key, reason: from kotlin metadata */
    @org.jetbrains.annotations.NotNull
    public static final kotlinx.coroutines.CoroutineDispatcher.Companion INSTANCE = new kotlinx.coroutines.CoroutineDispatcher.Companion(null);

    @kotlin.Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lkotlinx/coroutines/CoroutineDispatcher$Key;", "Lkotlin/coroutines/AbstractCoroutineContextKey;", "Lkotlin/coroutines/ContinuationInterceptor;", "Lkotlinx/coroutines/CoroutineDispatcher;", "()V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
    @kotlin.ExperimentalStdlibApi
    /* renamed from: kotlinx.coroutines.CoroutineDispatcher$Key, reason: from kotlin metadata */
    public static final class Companion extends kotlin.coroutines.AbstractCoroutineContextKey<kotlin.coroutines.ContinuationInterceptor, kotlinx.coroutines.CoroutineDispatcher> {

        @kotlin.Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"Lkotlin/coroutines/CoroutineContext$Element;", "it", "Lkotlinx/coroutines/CoroutineDispatcher;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
        /* renamed from: kotlinx.coroutines.CoroutineDispatcher$Key$1, reason: invalid class name */
        public static final class AnonymousClass1 extends kotlin.jvm.internal.Lambda implements kotlin.jvm.functions.Function1<kotlin.coroutines.CoroutineContext.Element, kotlinx.coroutines.CoroutineDispatcher> {
            public static final kotlinx.coroutines.CoroutineDispatcher.Companion.AnonymousClass1 INSTANCE = new kotlinx.coroutines.CoroutineDispatcher.Companion.AnonymousClass1();

            public AnonymousClass1() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @org.jetbrains.annotations.Nullable
            public final kotlinx.coroutines.CoroutineDispatcher invoke(@org.jetbrains.annotations.NotNull kotlin.coroutines.CoroutineContext.Element element) {
                if (element instanceof kotlinx.coroutines.CoroutineDispatcher) {
                    return (kotlinx.coroutines.CoroutineDispatcher) element;
                }
                return null;
            }
        }

        public Companion() {
            super(kotlin.coroutines.ContinuationInterceptor.INSTANCE, kotlinx.coroutines.CoroutineDispatcher.Companion.AnonymousClass1.INSTANCE);
        }

        public /* synthetic */ Companion(kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public CoroutineDispatcher() {
        super(kotlin.coroutines.ContinuationInterceptor.INSTANCE);
    }

    public abstract void dispatch(@org.jetbrains.annotations.NotNull kotlin.coroutines.CoroutineContext context, @org.jetbrains.annotations.NotNull java.lang.Runnable block);

    @kotlinx.coroutines.InternalCoroutinesApi
    public void dispatchYield(@org.jetbrains.annotations.NotNull kotlin.coroutines.CoroutineContext context, @org.jetbrains.annotations.NotNull java.lang.Runnable block) {
        dispatch(context, block);
    }

    @Override // kotlin.coroutines.AbstractCoroutineContextElement, kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    @org.jetbrains.annotations.Nullable
    public <E extends kotlin.coroutines.CoroutineContext.Element> E get(@org.jetbrains.annotations.NotNull kotlin.coroutines.CoroutineContext.Key<E> key) {
        return (E) kotlin.coroutines.ContinuationInterceptor.DefaultImpls.get(this, key);
    }

    @Override // kotlin.coroutines.ContinuationInterceptor
    @org.jetbrains.annotations.NotNull
    public final <T> kotlin.coroutines.Continuation<T> interceptContinuation(@org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super T> continuation) {
        return new kotlinx.coroutines.internal.DispatchedContinuation(this, continuation);
    }

    public boolean isDispatchNeeded(@org.jetbrains.annotations.NotNull kotlin.coroutines.CoroutineContext context) {
        return true;
    }

    @Override // kotlin.coroutines.AbstractCoroutineContextElement, kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    @org.jetbrains.annotations.NotNull
    public kotlin.coroutines.CoroutineContext minusKey(@org.jetbrains.annotations.NotNull kotlin.coroutines.CoroutineContext.Key<?> key) {
        return kotlin.coroutines.ContinuationInterceptor.DefaultImpls.minusKey(this, key);
    }

    @kotlin.Deprecated(level = kotlin.DeprecationLevel.ERROR, message = "Operator '+' on two CoroutineDispatcher objects is meaningless. CoroutineDispatcher is a coroutine context element and `+` is a set-sum operator for coroutine contexts. The dispatcher to the right of `+` just replaces the dispatcher to the left.")
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.CoroutineDispatcher plus(@org.jetbrains.annotations.NotNull kotlinx.coroutines.CoroutineDispatcher other) {
        return other;
    }

    @Override // kotlin.coroutines.ContinuationInterceptor
    @kotlinx.coroutines.InternalCoroutinesApi
    public void releaseInterceptedContinuation(@org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<?> continuation) {
        ((kotlinx.coroutines.internal.DispatchedContinuation) continuation).release();
    }

    @org.jetbrains.annotations.NotNull
    public java.lang.String toString() {
        return kotlinx.coroutines.DebugStringsKt.getClassSimpleName(this) + '@' + kotlinx.coroutines.DebugStringsKt.getHexAddress(this);
    }
}
