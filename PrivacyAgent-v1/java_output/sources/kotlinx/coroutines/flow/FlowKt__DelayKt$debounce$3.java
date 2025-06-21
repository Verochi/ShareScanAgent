package kotlinx.coroutines.flow;

/* JADX INFO: Add missing generic type declarations: [T] */
@kotlin.Metadata(d1 = {"\u0000\n\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\u0010\u0003\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0001\u001a\u00028\u0000H\n"}, d2 = {androidx.exifinterface.media.ExifInterface.GPS_DIRECTION_TRUE, "emittedItem", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes16.dex */
public final class FlowKt__DelayKt$debounce$3<T> extends kotlin.jvm.internal.Lambda implements kotlin.jvm.functions.Function1<T, java.lang.Long> {
    final /* synthetic */ kotlin.jvm.functions.Function1<T, kotlin.time.Duration> $timeout;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FlowKt__DelayKt$debounce$3(kotlin.jvm.functions.Function1<? super T, kotlin.time.Duration> function1) {
        super(1);
        this.$timeout = function1;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final long invoke2(T t) {
        return kotlinx.coroutines.DelayKt.m756toDelayMillisLRDsOJo(this.$timeout.invoke(t).getRawValue());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ java.lang.Long invoke(java.lang.Object obj) {
        return java.lang.Long.valueOf(invoke2((kotlinx.coroutines.flow.FlowKt__DelayKt$debounce$3<T>) obj));
    }
}
