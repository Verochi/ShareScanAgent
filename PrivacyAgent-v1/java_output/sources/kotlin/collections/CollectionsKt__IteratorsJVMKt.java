package kotlin.collections;

@kotlin.Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010(\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u001f\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0086\u0002¨\u0006\u0004"}, d2 = {"iterator", "", androidx.exifinterface.media.ExifInterface.GPS_DIRECTION_TRUE, "Ljava/util/Enumeration;", "kotlin-stdlib"}, k = 5, mv = {1, 7, 1}, xi = 49, xs = "kotlin/collections/CollectionsKt")
/* loaded from: classes14.dex */
class CollectionsKt__IteratorsJVMKt extends kotlin.collections.CollectionsKt__IterablesKt {
    @org.jetbrains.annotations.NotNull
    public static final <T> java.util.Iterator<T> iterator(@org.jetbrains.annotations.NotNull java.util.Enumeration<T> enumeration) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(enumeration, "<this>");
        return new kotlin.collections.CollectionsKt__IteratorsJVMKt$iterator$1(enumeration);
    }
}
