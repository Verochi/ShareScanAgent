package kotlin;

@kotlin.SinceKotlin(version = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_7)
@kotlin.Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0002\u0018\u0002\n\u0000\b7\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003B\u0007\b\u0004¢\u0006\u0002\u0010\u0004J\u0019\u0010\u0005\u001a\u00028\u00012\u0006\u0010\u0006\u001a\u00028\u0000H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0007J5\u0010\u0005\u001a\u0002H\b\"\u0004\b\u0002\u0010\t\"\u0004\b\u0003\u0010\b*\u000e\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u0002H\b0\n2\u0006\u0010\u0006\u001a\u0002H\tH¦@ø\u0001\u0000¢\u0006\u0002\u0010\u000bJ\u001f\u0010\f\u001a\u00020\r*\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\n2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003H\u0087\u0002\u0082\u0001\u0001\u000e\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u000f"}, d2 = {"Lkotlin/DeepRecursiveScope;", androidx.exifinterface.media.ExifInterface.GPS_DIRECTION_TRUE, "R", "", "()V", "callRecursive", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", androidx.exifinterface.media.ExifInterface.LATITUDE_SOUTH, "U", "Lkotlin/DeepRecursiveFunction;", "(Lkotlin/DeepRecursiveFunction;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "invoke", "", "Lkotlin/DeepRecursiveScopeImpl;", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
@kotlin.coroutines.RestrictsSuspension
@kotlin.WasExperimental(markerClass = {kotlin.ExperimentalStdlibApi.class})
/* loaded from: classes14.dex */
public abstract class DeepRecursiveScope<T, R> {
    public DeepRecursiveScope() {
    }

    public /* synthetic */ DeepRecursiveScope(kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object callRecursive(T t, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super R> continuation);

    @org.jetbrains.annotations.Nullable
    public abstract <U, S> java.lang.Object callRecursive(@org.jetbrains.annotations.NotNull kotlin.DeepRecursiveFunction<U, S> deepRecursiveFunction, U u, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super S> continuation);

    @kotlin.Deprecated(level = kotlin.DeprecationLevel.ERROR, message = "'invoke' should not be called from DeepRecursiveScope. Use 'callRecursive' to do recursion in the heap instead of the call stack.", replaceWith = @kotlin.ReplaceWith(expression = "this.callRecursive(value)", imports = {}))
    @org.jetbrains.annotations.NotNull
    public final java.lang.Void invoke(@org.jetbrains.annotations.NotNull kotlin.DeepRecursiveFunction<?, ?> deepRecursiveFunction, @org.jetbrains.annotations.Nullable java.lang.Object obj) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(deepRecursiveFunction, "<this>");
        throw new java.lang.UnsupportedOperationException("Should not be called from DeepRecursiveScope");
    }
}
