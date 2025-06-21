package androidx.core.util;

@kotlin.Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\b\b\u0001\u0010\u0004*\u00020\u00032\u0006\u0010\u0005\u001a\u0002H\u00022\u0006\u0010\u0006\u001a\u0002H\u0004H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"<anonymous>", "", "K", "", androidx.exifinterface.media.ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "<anonymous parameter 0>", "<anonymous parameter 1>", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)I"}, k = 3, mv = {1, 1, 16})
/* loaded from: classes.dex */
public final class LruCacheKt$lruCache$1 extends kotlin.jvm.internal.Lambda implements kotlin.jvm.functions.Function2 {
    public static final androidx.core.util.LruCacheKt$lruCache$1 INSTANCE = new androidx.core.util.LruCacheKt$lruCache$1();

    public LruCacheKt$lruCache$1() {
        super(2);
    }

    public final int invoke(@org.jetbrains.annotations.NotNull java.lang.Object obj, @org.jetbrains.annotations.NotNull java.lang.Object obj2) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(obj, "<anonymous parameter 0>");
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(obj2, "<anonymous parameter 1>");
        return 1;
    }

    @Override // kotlin.jvm.functions.Function2
    /* renamed from: invoke, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ java.lang.Object mo5invoke(java.lang.Object obj, java.lang.Object obj2) {
        return java.lang.Integer.valueOf(invoke(obj, obj2));
    }
}
