package kotlinx.coroutines.flow;

@kotlin.Metadata(d1 = {"\u0000\n\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0000\u0010\u0003\u001a\f\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0018\u00010\u0002\"\u0006\b\u0000\u0010\u0000\u0018\u0001\"\u0004\b\u0001\u0010\u0001H\n"}, d2 = {androidx.exifinterface.media.ExifInterface.GPS_DIRECTION_TRUE, "R", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes16.dex */
public final class FlowKt__ZipKt$combine$5$1 extends kotlin.jvm.internal.Lambda implements kotlin.jvm.functions.Function0 {
    final /* synthetic */ kotlinx.coroutines.flow.Flow[] $flows;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlowKt__ZipKt$combine$5$1(kotlinx.coroutines.flow.Flow[] flowArr) {
        super(0);
        this.$flows = flowArr;
    }

    @Override // kotlin.jvm.functions.Function0
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object[] invoke() {
        int length = this.$flows.length;
        kotlin.jvm.internal.Intrinsics.reifiedOperationMarker(0, "T?");
        return new java.lang.Object[length];
    }
}
