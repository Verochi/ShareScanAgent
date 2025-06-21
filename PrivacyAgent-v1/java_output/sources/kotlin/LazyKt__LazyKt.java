package kotlin;

@kotlin.Metadata(d1 = {"\u0000\f\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a!\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0001\u001a\u00028\u0000¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {androidx.exifinterface.media.ExifInterface.GPS_DIRECTION_TRUE, "value", "Lkotlin/Lazy;", "lazyOf", "(Ljava/lang/Object;)Lkotlin/Lazy;", "kotlin-stdlib"}, k = 5, mv = {1, 7, 1}, xs = "kotlin/LazyKt")
/* loaded from: classes14.dex */
class LazyKt__LazyKt extends kotlin.LazyKt__LazyJVMKt {
    @org.jetbrains.annotations.NotNull
    public static final <T> kotlin.Lazy<T> lazyOf(T t) {
        return new kotlin.InitializedLazyImpl(t);
    }
}
