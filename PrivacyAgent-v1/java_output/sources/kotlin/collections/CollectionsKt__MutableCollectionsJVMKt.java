package kotlin.collections;

@kotlin.Metadata(d1 = {"\u0000\u001c\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a \u0010\u0004\u001a\u00020\u0003\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0002\u001a2\u0010\b\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00022\u001a\u0010\u0007\u001a\u0016\u0012\u0006\b\u0000\u0012\u00028\u00000\u0005j\n\u0012\u0006\b\u0000\u0012\u00028\u0000`\u0006¨\u0006\t"}, d2 = {"", androidx.exifinterface.media.ExifInterface.GPS_DIRECTION_TRUE, "", "", com.aliyun.svideo.downloader.FileDownloaderModel.SORT, "Ljava/util/Comparator;", "Lkotlin/Comparator;", "comparator", "sortWith", "kotlin-stdlib"}, k = 5, mv = {1, 7, 1}, xs = "kotlin/collections/CollectionsKt")
/* loaded from: classes14.dex */
class CollectionsKt__MutableCollectionsJVMKt extends kotlin.collections.CollectionsKt__IteratorsKt {
    public static <T extends java.lang.Comparable<? super T>> void sort(@org.jetbrains.annotations.NotNull java.util.List<T> list) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(list, "<this>");
        if (list.size() > 1) {
            java.util.Collections.sort(list);
        }
    }

    public static <T> void sortWith(@org.jetbrains.annotations.NotNull java.util.List<T> list, @org.jetbrains.annotations.NotNull java.util.Comparator<? super T> comparator) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(list, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(comparator, "comparator");
        if (list.size() > 1) {
            java.util.Collections.sort(list, comparator);
        }
    }
}
