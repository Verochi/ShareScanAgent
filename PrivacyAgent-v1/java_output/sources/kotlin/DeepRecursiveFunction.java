package kotlin;

@kotlin.SinceKotlin(version = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_7)
@kotlin.Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003BE\u00129\u0010\f\u001a5\b\u0001\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0004¢\u0006\u0002\b\u0007ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000eRP\u0010\f\u001a5\b\u0001\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0004¢\u0006\u0002\b\u00078\u0000X\u0080\u0004ø\u0001\u0000¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u000f"}, d2 = {"Lkotlin/DeepRecursiveFunction;", androidx.exifinterface.media.ExifInterface.GPS_DIRECTION_TRUE, "R", "", "Lkotlin/Function3;", "Lkotlin/DeepRecursiveScope;", "Lkotlin/coroutines/Continuation;", "Lkotlin/ExtensionFunctionType;", "a", "Lkotlin/jvm/functions/Function3;", "getBlock$kotlin_stdlib", "()Lkotlin/jvm/functions/Function3;", "block", "<init>", "(Lkotlin/jvm/functions/Function3;)V", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1})
@kotlin.WasExperimental(markerClass = {kotlin.ExperimentalStdlibApi.class})
/* loaded from: classes14.dex */
public final class DeepRecursiveFunction<T, R> {

    /* renamed from: a, reason: from kotlin metadata */
    @org.jetbrains.annotations.NotNull
    public final kotlin.jvm.functions.Function3<kotlin.DeepRecursiveScope<T, R>, T, kotlin.coroutines.Continuation<? super R>, java.lang.Object> block;

    /* JADX WARN: Multi-variable type inference failed */
    public DeepRecursiveFunction(@org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function3<? super kotlin.DeepRecursiveScope<T, R>, ? super T, ? super kotlin.coroutines.Continuation<? super R>, ? extends java.lang.Object> block) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(block, "block");
        this.block = block;
    }

    @org.jetbrains.annotations.NotNull
    public final kotlin.jvm.functions.Function3<kotlin.DeepRecursiveScope<T, R>, T, kotlin.coroutines.Continuation<? super R>, java.lang.Object> getBlock$kotlin_stdlib() {
        return this.block;
    }
}
