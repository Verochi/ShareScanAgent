package kotlinx.coroutines.flow;

@kotlin.Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0004\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\n"}, d2 = {androidx.exifinterface.media.ExifInterface.GPS_DIRECTION_TRUE, "", "it", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes16.dex */
public final class FlowKt__ErrorsKt$onErrorCollect$1 extends kotlin.jvm.internal.Lambda implements kotlin.jvm.functions.Function1<java.lang.Throwable, java.lang.Boolean> {
    public static final kotlinx.coroutines.flow.FlowKt__ErrorsKt$onErrorCollect$1 INSTANCE = new kotlinx.coroutines.flow.FlowKt__ErrorsKt$onErrorCollect$1();

    public FlowKt__ErrorsKt$onErrorCollect$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ java.lang.Boolean invoke(java.lang.Throwable th) {
        return java.lang.Boolean.valueOf(invoke2(th));
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(@org.jetbrains.annotations.NotNull java.lang.Throwable th) {
        return true;
    }
}
