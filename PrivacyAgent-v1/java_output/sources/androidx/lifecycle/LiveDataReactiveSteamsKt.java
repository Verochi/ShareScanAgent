package androidx.lifecycle;

@kotlin.Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u001f\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0086\b\u001a'\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0003\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0006H\u0086\b¨\u0006\u0007"}, d2 = {"toLiveData", "Landroidx/lifecycle/LiveData;", androidx.exifinterface.media.ExifInterface.GPS_DIRECTION_TRUE, "Lorg/reactivestreams/Publisher;", "toPublisher", com.alibaba.sdk.android.oss.common.RequestParameters.SUBRESOURCE_LIFECYCLE, "Landroidx/lifecycle/LifecycleOwner;", "lifecycle-reactivestreams-ktx_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final class LiveDataReactiveSteamsKt {
    @org.jetbrains.annotations.NotNull
    public static final <T> androidx.lifecycle.LiveData<T> toLiveData(@org.jetbrains.annotations.NotNull org.reactivestreams.Publisher<T> publisher) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(publisher, "<this>");
        androidx.lifecycle.LiveData<T> fromPublisher = androidx.lifecycle.LiveDataReactiveStreams.fromPublisher(publisher);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(fromPublisher, "fromPublisher(this)");
        return fromPublisher;
    }

    @org.jetbrains.annotations.NotNull
    public static final <T> org.reactivestreams.Publisher<T> toPublisher(@org.jetbrains.annotations.NotNull androidx.lifecycle.LiveData<T> liveData, @org.jetbrains.annotations.NotNull androidx.lifecycle.LifecycleOwner lifecycle) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(liveData, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(lifecycle, "lifecycle");
        org.reactivestreams.Publisher<T> publisher = androidx.lifecycle.LiveDataReactiveStreams.toPublisher(lifecycle, liveData);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(publisher, "toPublisher(lifecycle, this)");
        return publisher;
    }
}
