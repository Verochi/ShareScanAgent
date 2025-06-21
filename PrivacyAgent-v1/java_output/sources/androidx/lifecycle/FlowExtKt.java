package androidx.lifecycle;

@kotlin.Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a.\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"flowWithLifecycle", "Lkotlinx/coroutines/flow/Flow;", androidx.exifinterface.media.ExifInterface.GPS_DIRECTION_TRUE, com.alibaba.sdk.android.oss.common.RequestParameters.SUBRESOURCE_LIFECYCLE, "Landroidx/lifecycle/Lifecycle;", "minActiveState", "Landroidx/lifecycle/Lifecycle$State;", "lifecycle-runtime-ktx_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final class FlowExtKt {
    @org.jetbrains.annotations.NotNull
    public static final <T> kotlinx.coroutines.flow.Flow<T> flowWithLifecycle(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.Flow<? extends T> flow, @org.jetbrains.annotations.NotNull androidx.lifecycle.Lifecycle lifecycle, @org.jetbrains.annotations.NotNull androidx.lifecycle.Lifecycle.State minActiveState) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(flow, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(lifecycle, "lifecycle");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(minActiveState, "minActiveState");
        return kotlinx.coroutines.flow.FlowKt.callbackFlow(new androidx.lifecycle.FlowExtKt$flowWithLifecycle$1(lifecycle, minActiveState, flow, null));
    }

    public static /* synthetic */ kotlinx.coroutines.flow.Flow flowWithLifecycle$default(kotlinx.coroutines.flow.Flow flow, androidx.lifecycle.Lifecycle lifecycle, androidx.lifecycle.Lifecycle.State state, int i, java.lang.Object obj) {
        if ((i & 2) != 0) {
            state = androidx.lifecycle.Lifecycle.State.STARTED;
        }
        return flowWithLifecycle(flow, lifecycle, state);
    }
}
