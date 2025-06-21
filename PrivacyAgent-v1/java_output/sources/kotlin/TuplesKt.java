package kotlin;

@kotlin.Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\u001a2\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0002H\u00022\u0006\u0010\u0004\u001a\u0002H\u0003H\u0086\u0004¢\u0006\u0002\u0010\u0005\u001a\"\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\b0\u0007\"\u0004\b\u0000\u0010\b*\u000e\u0012\u0004\u0012\u0002H\b\u0012\u0004\u0012\u0002H\b0\u0001\u001a(\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\b0\u0007\"\u0004\b\u0000\u0010\b*\u0014\u0012\u0004\u0012\u0002H\b\u0012\u0004\u0012\u0002H\b\u0012\u0004\u0012\u0002H\b0\t¨\u0006\n"}, d2 = {com.huawei.hms.push.constant.RemoteMessageConst.TO, "Lkotlin/Pair;", androidx.exifinterface.media.ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", "that", "(Ljava/lang/Object;Ljava/lang/Object;)Lkotlin/Pair;", "toList", "", androidx.exifinterface.media.ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/Triple;", "kotlin-stdlib"}, k = 2, mv = {1, 7, 1}, xi = 48)
@kotlin.jvm.JvmName(name = "TuplesKt")
/* loaded from: classes14.dex */
public final class TuplesKt {
    @org.jetbrains.annotations.NotNull
    public static final <A, B> kotlin.Pair<A, B> to(A a, B b) {
        return new kotlin.Pair<>(a, b);
    }

    @org.jetbrains.annotations.NotNull
    public static final <T> java.util.List<T> toList(@org.jetbrains.annotations.NotNull kotlin.Pair<? extends T, ? extends T> pair) {
        java.util.List<T> listOf;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(pair, "<this>");
        listOf = kotlin.collections.CollectionsKt__CollectionsKt.listOf(pair.getFirst(), pair.getSecond());
        return listOf;
    }

    @org.jetbrains.annotations.NotNull
    public static final <T> java.util.List<T> toList(@org.jetbrains.annotations.NotNull kotlin.Triple<? extends T, ? extends T, ? extends T> triple) {
        java.util.List<T> listOf;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(triple, "<this>");
        listOf = kotlin.collections.CollectionsKt__CollectionsKt.listOf(triple.getFirst(), triple.getSecond(), triple.getThird());
        return listOf;
    }
}
