package kotlin;

@kotlin.Metadata(d1 = {"\u0000,\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a4\u0010\u0004\u001a\u00028\u0001\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00022\u0006\u0010\u0003\u001a\u00028\u0000H\u0087\u0002¢\u0006\u0004\b\u0004\u0010\u0005\"#\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0002X\u0083\u0004ø\u0001\u0000¢\u0006\f\n\u0004\b\b\u0010\t\u0012\u0004\b\n\u0010\u000b*r\b\u0002\u0010\u0011\"5\b\u0001\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u00070\r¢\u0006\u0002\b\u001025\b\u0001\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u00070\r¢\u0006\u0002\b\u0010\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0012"}, d2 = {androidx.exifinterface.media.ExifInterface.GPS_DIRECTION_TRUE, "R", "Lkotlin/DeepRecursiveFunction;", "value", "invoke", "(Lkotlin/DeepRecursiveFunction;Ljava/lang/Object;)Ljava/lang/Object;", "Lkotlin/Result;", "", "a", "Ljava/lang/Object;", "getUNDEFINED_RESULT$annotations", "()V", "UNDEFINED_RESULT", "Lkotlin/Function3;", "Lkotlin/DeepRecursiveScope;", "Lkotlin/coroutines/Continuation;", "Lkotlin/ExtensionFunctionType;", "DeepRecursiveFunctionBlock", "kotlin-stdlib"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class DeepRecursiveKt {

    @org.jetbrains.annotations.NotNull
    public static final java.lang.Object a;

    static {
        java.lang.Object coroutine_suspended;
        kotlin.Result.Companion companion = kotlin.Result.INSTANCE;
        coroutine_suspended = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        a = kotlin.Result.m156constructorimpl(coroutine_suspended);
    }

    @kotlin.SinceKotlin(version = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_7)
    @kotlin.WasExperimental(markerClass = {kotlin.ExperimentalStdlibApi.class})
    public static final <T, R> R invoke(@org.jetbrains.annotations.NotNull kotlin.DeepRecursiveFunction<T, R> deepRecursiveFunction, T t) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(deepRecursiveFunction, "<this>");
        return (R) new kotlin.DeepRecursiveScopeImpl(deepRecursiveFunction.getBlock$kotlin_stdlib(), t).e();
    }
}
