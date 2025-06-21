package kotlinx.coroutines.debug.internal;

/* JADX INFO: Add missing generic type declarations: [V, K] */
@kotlin.Metadata(d1 = {"\u0000\b\n\u0002\u0010\u0000\n\u0002\b\u0005\u0010\u0005\u001a\u00028\u0000\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0002*\u00020\u00002\u0006\u0010\u0003\u001a\u00028\u00002\u0006\u0010\u0004\u001a\u00028\u0001H\n"}, d2 = {"", "K", androidx.exifinterface.media.ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "k", "<anonymous parameter 1>", "<anonymous>"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes16.dex */
public final class ConcurrentWeakMap$keys$1<K, V> extends kotlin.jvm.internal.Lambda implements kotlin.jvm.functions.Function2<K, V, K> {
    public static final kotlinx.coroutines.debug.internal.ConcurrentWeakMap$keys$1 INSTANCE = new kotlinx.coroutines.debug.internal.ConcurrentWeakMap$keys$1();

    public ConcurrentWeakMap$keys$1() {
        super(2);
    }

    @Override // kotlin.jvm.functions.Function2
    @org.jetbrains.annotations.NotNull
    /* renamed from: invoke */
    public final K mo5invoke(@org.jetbrains.annotations.NotNull K k, @org.jetbrains.annotations.NotNull V v) {
        return k;
    }
}
