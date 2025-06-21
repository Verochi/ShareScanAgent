package kotlin.collections;

@kotlin.Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010#\n\u0002\b\u0003\n\u0002\u0010\u001f\n\u0002\b\u0003\n\u0002\u0010'\n\u0002\b\u0005\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0003B>\u0012\u0012\u0010\"\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u001d\u0012!\u0010(\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00028\u00010#¢\u0006\u0004\b7\u00108J\u0013\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0096\u0002J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\f\u001a\u00020\u0006H\u0016J\u0017\u0010\u000e\u001a\u00020\u00062\u0006\u0010\r\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00028\u0001H\u0016¢\u0006\u0004\b\u0011\u0010\u000fJ\u001a\u0010\u0012\u001a\u0004\u0018\u00018\u00012\u0006\u0010\r\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0004\b\u0012\u0010\u0013J!\u0010\u0014\u001a\u0004\u0018\u00018\u00012\u0006\u0010\r\u001a\u00028\u00002\u0006\u0010\u0010\u001a\u00028\u0001H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u0019\u0010\u0016\u001a\u0004\u0018\u00018\u00012\u0006\u0010\r\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0016\u0010\u0013J\u001e\u0010\u001a\u001a\u00020\u00192\u0014\u0010\u0018\u001a\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0017H\u0016J\b\u0010\u001b\u001a\u00020\u0019H\u0016J\u0017\u0010\u001c\u001a\u00028\u00012\u0006\u0010\r\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u001c\u0010\u0013R&\u0010\"\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u001d8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R/\u0010(\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00028\u00010#8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\u0014\u0010+\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b)\u0010*R\u001a\u0010/\u001a\b\u0012\u0004\u0012\u00028\u00000,8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b-\u0010.R\u001a\u00103\u001a\b\u0012\u0004\u0012\u00028\u0001008VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b1\u00102R&\u00106\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001040,8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b5\u0010.¨\u00069"}, d2 = {"Lkotlin/collections/MutableMapWithDefaultImpl;", "K", androidx.exifinterface.media.ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lkotlin/collections/MutableMapWithDefault;", "", "other", "", "equals", "", com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_HASHCODE, "", "toString", "isEmpty", "key", "containsKey", "(Ljava/lang/Object;)Z", "value", "containsValue", com.ss.android.socialbase.downloader.constants.MonitorConstants.CONNECT_TYPE_GET, "(Ljava/lang/Object;)Ljava/lang/Object;", "put", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "remove", "", "from", "", "putAll", "clear", "c", "", com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.AD_COUNT, "Ljava/util/Map;", "getMap", "()Ljava/util/Map;", "map", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "t", "Lkotlin/jvm/functions/Function1;", "default", "d", "()I", com.anythink.core.api.ATAdConst.NETWORK_REQUEST_PARAMS_KEY.BANNER_SIZE, "", "b", "()Ljava/util/Set;", "keys", "", "e", "()Ljava/util/Collection;", "values", "", "a", "entries", "<init>", "(Ljava/util/Map;Lkotlin/jvm/functions/Function1;)V", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
final class MutableMapWithDefaultImpl<K, V> implements kotlin.collections.MutableMapWithDefault<K, V> {

    /* renamed from: n, reason: from kotlin metadata */
    @org.jetbrains.annotations.NotNull
    public final java.util.Map<K, V> map;

    /* renamed from: t, reason: from kotlin metadata */
    @org.jetbrains.annotations.NotNull
    public final kotlin.jvm.functions.Function1<K, V> default;

    /* JADX WARN: Multi-variable type inference failed */
    public MutableMapWithDefaultImpl(@org.jetbrains.annotations.NotNull java.util.Map<K, V> map, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super K, ? extends V> function1) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(map, "map");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(function1, "default");
        this.map = map;
        this.default = function1;
    }

    @org.jetbrains.annotations.NotNull
    public java.util.Set<java.util.Map.Entry<K, V>> a() {
        return getMap().entrySet();
    }

    @org.jetbrains.annotations.NotNull
    public java.util.Set<K> b() {
        return getMap().keySet();
    }

    @Override // kotlin.collections.MapWithDefault
    public V c(K key) {
        java.util.Map<K, V> map = getMap();
        V v = map.get(key);
        return (v != null || map.containsKey(key)) ? v : this.default.invoke(key);
    }

    @Override // java.util.Map
    public void clear() {
        getMap().clear();
    }

    @Override // java.util.Map
    public boolean containsKey(java.lang.Object key) {
        return getMap().containsKey(key);
    }

    @Override // java.util.Map
    public boolean containsValue(java.lang.Object value) {
        return getMap().containsValue(value);
    }

    public int d() {
        return getMap().size();
    }

    @org.jetbrains.annotations.NotNull
    public java.util.Collection<V> e() {
        return getMap().values();
    }

    @Override // java.util.Map
    public final /* bridge */ java.util.Set<java.util.Map.Entry<K, V>> entrySet() {
        return a();
    }

    @Override // java.util.Map
    public boolean equals(@org.jetbrains.annotations.Nullable java.lang.Object other) {
        return getMap().equals(other);
    }

    @Override // java.util.Map
    @org.jetbrains.annotations.Nullable
    public V get(java.lang.Object key) {
        return getMap().get(key);
    }

    @Override // kotlin.collections.MutableMapWithDefault, kotlin.collections.MapWithDefault
    @org.jetbrains.annotations.NotNull
    public java.util.Map<K, V> getMap() {
        return this.map;
    }

    @Override // java.util.Map
    public int hashCode() {
        return getMap().hashCode();
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return getMap().isEmpty();
    }

    @Override // java.util.Map
    public final /* bridge */ java.util.Set<K> keySet() {
        return b();
    }

    @Override // java.util.Map
    @org.jetbrains.annotations.Nullable
    public V put(K key, V value) {
        return getMap().put(key, value);
    }

    @Override // java.util.Map
    public void putAll(@org.jetbrains.annotations.NotNull java.util.Map<? extends K, ? extends V> from) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(from, "from");
        getMap().putAll(from);
    }

    @Override // java.util.Map
    @org.jetbrains.annotations.Nullable
    public V remove(java.lang.Object key) {
        return getMap().remove(key);
    }

    @Override // java.util.Map
    public final /* bridge */ int size() {
        return d();
    }

    @org.jetbrains.annotations.NotNull
    public java.lang.String toString() {
        return getMap().toString();
    }

    @Override // java.util.Map
    public final /* bridge */ java.util.Collection<V> values() {
        return e();
    }
}
