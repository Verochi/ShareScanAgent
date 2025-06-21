package androidx.core.util;

/* JADX INFO: Add missing generic type declarations: [V, K] */
@kotlin.Metadata(bv = {1, 0, 3}, d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0001J\u0017\u0010\u0002\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0003\u001a\u00028\u0000H\u0014¢\u0006\u0002\u0010\u0004J/\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00028\u00002\u0006\u0010\t\u001a\u00028\u00012\b\u0010\n\u001a\u0004\u0018\u00018\u0001H\u0014¢\u0006\u0002\u0010\u000bJ\u001d\u0010\f\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00028\u00002\u0006\u0010\u000e\u001a\u00028\u0001H\u0014¢\u0006\u0002\u0010\u000f¨\u0006\u0010"}, d2 = {"androidx/core/util/LruCacheKt$lruCache$4", "Landroid/util/LruCache;", "create", "key", "(Ljava/lang/Object;)Ljava/lang/Object;", "entryRemoved", "", "evicted", "", "oldValue", "newValue", "(ZLjava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V", "sizeOf", "", "value", "(Ljava/lang/Object;Ljava/lang/Object;)I", "core-ktx_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes.dex */
public final class LruCacheKt$lruCache$4<K, V> extends android.util.LruCache<K, V> {
    final /* synthetic */ kotlin.jvm.functions.Function1 $create;
    final /* synthetic */ int $maxSize;
    final /* synthetic */ kotlin.jvm.functions.Function4 $onEntryRemoved;
    final /* synthetic */ kotlin.jvm.functions.Function2 $sizeOf;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LruCacheKt$lruCache$4(kotlin.jvm.functions.Function2 function2, kotlin.jvm.functions.Function1 function1, kotlin.jvm.functions.Function4 function4, int i, int i2) {
        super(i2);
        this.$sizeOf = function2;
        this.$create = function1;
        this.$onEntryRemoved = function4;
        this.$maxSize = i;
    }

    @Override // android.util.LruCache
    @org.jetbrains.annotations.Nullable
    public V create(@org.jetbrains.annotations.NotNull K key) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(key, "key");
        return (V) this.$create.invoke(key);
    }

    @Override // android.util.LruCache
    public void entryRemoved(boolean evicted, @org.jetbrains.annotations.NotNull K key, @org.jetbrains.annotations.NotNull V oldValue, @org.jetbrains.annotations.Nullable V newValue) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(key, "key");
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(oldValue, "oldValue");
        this.$onEntryRemoved.invoke(java.lang.Boolean.valueOf(evicted), key, oldValue, newValue);
    }

    @Override // android.util.LruCache
    public int sizeOf(@org.jetbrains.annotations.NotNull K key, @org.jetbrains.annotations.NotNull V value) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(key, "key");
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(value, "value");
        return ((java.lang.Number) this.$sizeOf.mo5invoke(key, value)).intValue();
    }
}
