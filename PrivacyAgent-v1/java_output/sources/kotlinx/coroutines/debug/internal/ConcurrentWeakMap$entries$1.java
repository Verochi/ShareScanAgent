package kotlinx.coroutines.debug.internal;

/* JADX INFO: Add missing generic type declarations: [V, K] */
@kotlin.Metadata(d1 = {"\u0000\u000e\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010'\n\u0000\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0002*\u00020\u00002\u0006\u0010\u0003\u001a\u00028\u00002\u0006\u0010\u0004\u001a\u00028\u0001H\n"}, d2 = {"", "K", androidx.exifinterface.media.ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "k", "v", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes16.dex */
public final class ConcurrentWeakMap$entries$1<K, V> extends kotlin.jvm.internal.Lambda implements kotlin.jvm.functions.Function2<K, V, java.util.Map.Entry<K, V>> {
    public static final kotlinx.coroutines.debug.internal.ConcurrentWeakMap$entries$1 INSTANCE = new kotlinx.coroutines.debug.internal.ConcurrentWeakMap$entries$1();

    public ConcurrentWeakMap$entries$1() {
        super(2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.jvm.functions.Function2
    /* renamed from: invoke */
    public /* bridge */ /* synthetic */ java.lang.Object mo5invoke(java.lang.Object obj, java.lang.Object obj2) {
        return mo5invoke((kotlinx.coroutines.debug.internal.ConcurrentWeakMap$entries$1<K, V>) obj, obj2);
    }

    @Override // kotlin.jvm.functions.Function2
    @org.jetbrains.annotations.NotNull
    /* renamed from: invoke */
    public final java.util.Map.Entry<K, V> mo5invoke(@org.jetbrains.annotations.NotNull K k, @org.jetbrains.annotations.NotNull V v) {
        return new kotlinx.coroutines.debug.internal.ConcurrentWeakMap.Entry(k, v);
    }
}
