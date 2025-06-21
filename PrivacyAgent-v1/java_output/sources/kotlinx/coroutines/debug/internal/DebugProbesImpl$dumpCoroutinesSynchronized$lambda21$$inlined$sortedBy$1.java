package kotlinx.coroutines.debug.internal;

@kotlin.Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"<anonymous>", "", androidx.exifinterface.media.ExifInterface.GPS_DIRECTION_TRUE, "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k = 3, mv = {1, 5, 1})
/* renamed from: kotlinx.coroutines.debug.internal.DebugProbesImpl$dumpCoroutinesSynchronized$lambda-21$$inlined$sortedBy$1, reason: invalid class name */
/* loaded from: classes16.dex */
public final class DebugProbesImpl$dumpCoroutinesSynchronized$lambda21$$inlined$sortedBy$1<T> implements java.util.Comparator<T> {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T t, T t2) {
        int compareValues;
        compareValues = kotlin.comparisons.ComparisonsKt__ComparisonsKt.compareValues(java.lang.Long.valueOf(((kotlinx.coroutines.debug.internal.DebugProbesImpl.CoroutineOwner) t).info.sequenceNumber), java.lang.Long.valueOf(((kotlinx.coroutines.debug.internal.DebugProbesImpl.CoroutineOwner) t2).info.sequenceNumber));
        return compareValues;
    }
}
