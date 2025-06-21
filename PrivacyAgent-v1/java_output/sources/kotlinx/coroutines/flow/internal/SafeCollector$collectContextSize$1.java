package kotlinx.coroutines.flow.internal;

@kotlin.Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0003H\n"}, d2 = {androidx.exifinterface.media.ExifInterface.GPS_DIRECTION_TRUE, "", me.leolin.shortcutbadger.impl.NewHtcHomeBadger.COUNT, "Lkotlin/coroutines/CoroutineContext$Element;", "<anonymous parameter 1>", "<anonymous>"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes16.dex */
public final class SafeCollector$collectContextSize$1 extends kotlin.jvm.internal.Lambda implements kotlin.jvm.functions.Function2<java.lang.Integer, kotlin.coroutines.CoroutineContext.Element, java.lang.Integer> {
    public static final kotlinx.coroutines.flow.internal.SafeCollector$collectContextSize$1 INSTANCE = new kotlinx.coroutines.flow.internal.SafeCollector$collectContextSize$1();

    public SafeCollector$collectContextSize$1() {
        super(2);
    }

    public final int invoke(int i, @org.jetbrains.annotations.NotNull kotlin.coroutines.CoroutineContext.Element element) {
        return i + 1;
    }

    @Override // kotlin.jvm.functions.Function2
    /* renamed from: invoke */
    public /* bridge */ /* synthetic */ java.lang.Integer mo5invoke(java.lang.Integer num, kotlin.coroutines.CoroutineContext.Element element) {
        return java.lang.Integer.valueOf(invoke(num.intValue(), element));
    }
}
