package kotlin.collections;

/* JADX INFO: Add missing generic type declarations: [V, K] */
@kotlin.Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010&\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0006\b\u0001\u0010\u0003 \u00012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "K", androidx.exifinterface.media.ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "it", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes14.dex */
public final class AbstractMap$toString$1<K, V> extends kotlin.jvm.internal.Lambda implements kotlin.jvm.functions.Function1<java.util.Map.Entry<? extends K, ? extends V>, java.lang.CharSequence> {
    final /* synthetic */ kotlin.collections.AbstractMap<K, V> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public AbstractMap$toString$1(kotlin.collections.AbstractMap<K, ? extends V> abstractMap) {
        super(1);
        this.this$0 = abstractMap;
    }

    @Override // kotlin.jvm.functions.Function1
    @org.jetbrains.annotations.NotNull
    public final java.lang.CharSequence invoke(@org.jetbrains.annotations.NotNull java.util.Map.Entry<? extends K, ? extends V> it) {
        java.lang.String d;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(it, "it");
        d = this.this$0.d(it);
        return d;
    }
}
