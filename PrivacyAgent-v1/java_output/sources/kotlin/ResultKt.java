package kotlin;

@kotlin.Metadata(d1 = {"\u0000\u0018\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a\u0010\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0001\u001a\u001a\u0010\u0006\u001a\u00020\u0005*\u0006\u0012\u0002\b\u00030\u0004H\u0001ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\b"}, d2 = {"", "exception", "", "createFailure", "Lkotlin/Result;", "", "throwOnFailure", "(Ljava/lang/Object;)V", "kotlin-stdlib"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class ResultKt {
    @kotlin.SinceKotlin(version = "1.3")
    @kotlin.PublishedApi
    @org.jetbrains.annotations.NotNull
    public static final java.lang.Object createFailure(@org.jetbrains.annotations.NotNull java.lang.Throwable exception) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(exception, "exception");
        return new kotlin.Result.Failure(exception);
    }

    @kotlin.SinceKotlin(version = "1.3")
    @kotlin.PublishedApi
    public static final void throwOnFailure(@org.jetbrains.annotations.NotNull java.lang.Object obj) {
        if (obj instanceof kotlin.Result.Failure) {
            throw ((kotlin.Result.Failure) obj).exception;
        }
    }
}
