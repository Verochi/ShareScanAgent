package androidx.core.util;

@kotlin.Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\u001aø\u0001\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0004\"\b\b\u0001\u0010\u0003*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u000628\b\u0006\u0010\u0007\u001a2\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u0011H\u0003¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u00060\b2%\b\u0006\u0010\r\u001a\u001f\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0006\u0012\u0004\u0018\u0001H\u00030\u000e2d\b\u0006\u0010\u000f\u001a^\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u0011H\u0003¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0013\u0012\u0015\u0012\u0013\u0018\u0001H\u0003¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u00150\u0010H\u0086\b¨\u0006\u0016"}, d2 = {"lruCache", "Landroid/util/LruCache;", "K", androidx.exifinterface.media.ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "", "maxSize", "", "sizeOf", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "key", "value", "create", "Lkotlin/Function1;", "onEntryRemoved", "Lkotlin/Function4;", "", "evicted", "oldValue", "newValue", "", "core-ktx_release"}, k = 2, mv = {1, 1, 16})
/* loaded from: classes.dex */
public final class LruCacheKt {
    @org.jetbrains.annotations.NotNull
    public static final <K, V> android.util.LruCache<K, V> lruCache(int i, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super K, ? super V, java.lang.Integer> sizeOf, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super K, ? extends V> create, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function4<? super java.lang.Boolean, ? super K, ? super V, ? super V, kotlin.Unit> onEntryRemoved) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(sizeOf, "sizeOf");
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(create, "create");
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(onEntryRemoved, "onEntryRemoved");
        return new androidx.core.util.LruCacheKt$lruCache$4(sizeOf, create, onEntryRemoved, i, i);
    }

    public static /* synthetic */ android.util.LruCache lruCache$default(int i, kotlin.jvm.functions.Function2 function2, kotlin.jvm.functions.Function1 function1, kotlin.jvm.functions.Function4 function4, int i2, java.lang.Object obj) {
        if ((i2 & 2) != 0) {
            function2 = androidx.core.util.LruCacheKt$lruCache$1.INSTANCE;
        }
        kotlin.jvm.functions.Function2 sizeOf = function2;
        if ((i2 & 4) != 0) {
            function1 = androidx.core.util.LruCacheKt$lruCache$2.INSTANCE;
        }
        kotlin.jvm.functions.Function1 create = function1;
        if ((i2 & 8) != 0) {
            function4 = androidx.core.util.LruCacheKt$lruCache$3.INSTANCE;
        }
        kotlin.jvm.functions.Function4 onEntryRemoved = function4;
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(sizeOf, "sizeOf");
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(create, "create");
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(onEntryRemoved, "onEntryRemoved");
        return new androidx.core.util.LruCacheKt$lruCache$4(sizeOf, create, onEntryRemoved, i, i);
    }
}
