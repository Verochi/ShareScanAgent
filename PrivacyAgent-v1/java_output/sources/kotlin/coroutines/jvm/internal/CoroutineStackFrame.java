package kotlin.coroutines.jvm.internal;

@kotlin.SinceKotlin(version = "1.3")
@kotlin.Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0006H&R\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u0000X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "", "callerFrame", "getCallerFrame", "()Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "getStackTraceElement", "Ljava/lang/StackTraceElement;", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes14.dex */
public interface CoroutineStackFrame {
    @org.jetbrains.annotations.Nullable
    kotlin.coroutines.jvm.internal.CoroutineStackFrame getCallerFrame();

    @org.jetbrains.annotations.Nullable
    java.lang.StackTraceElement getStackTraceElement();
}
