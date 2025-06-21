package androidx.lifecycle;

@kotlin.Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\u001a\u001c\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003\u001a0\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0003\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007\u001a2\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0003\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\nH\u0007¨\u0006\u000b"}, d2 = {"asFlow", "Lkotlinx/coroutines/flow/Flow;", androidx.exifinterface.media.ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/lifecycle/LiveData;", "asLiveData", "context", "Lkotlin/coroutines/CoroutineContext;", "timeout", "Ljava/time/Duration;", "timeoutInMs", "", "lifecycle-livedata-ktx_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
@kotlin.jvm.JvmName(name = "FlowLiveDataConversions")
/* loaded from: classes.dex */
public final class FlowLiveDataConversions {
    @org.jetbrains.annotations.NotNull
    public static final <T> kotlinx.coroutines.flow.Flow<T> asFlow(@org.jetbrains.annotations.NotNull androidx.lifecycle.LiveData<T> liveData) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(liveData, "<this>");
        return kotlinx.coroutines.flow.FlowKt.flow(new androidx.lifecycle.FlowLiveDataConversions$asFlow$1(liveData, null));
    }

    @kotlin.jvm.JvmOverloads
    @org.jetbrains.annotations.NotNull
    public static final <T> androidx.lifecycle.LiveData<T> asLiveData(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.Flow<? extends T> flow) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(flow, "<this>");
        return asLiveData$default(flow, (kotlin.coroutines.CoroutineContext) null, 0L, 3, (java.lang.Object) null);
    }

    @kotlin.jvm.JvmOverloads
    @org.jetbrains.annotations.NotNull
    public static final <T> androidx.lifecycle.LiveData<T> asLiveData(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.Flow<? extends T> flow, @org.jetbrains.annotations.NotNull kotlin.coroutines.CoroutineContext context) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(flow, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(context, "context");
        return asLiveData$default(flow, context, 0L, 2, (java.lang.Object) null);
    }

    @kotlin.jvm.JvmOverloads
    @org.jetbrains.annotations.NotNull
    public static final <T> androidx.lifecycle.LiveData<T> asLiveData(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.Flow<? extends T> flow, @org.jetbrains.annotations.NotNull kotlin.coroutines.CoroutineContext context, long j) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(flow, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(context, "context");
        return androidx.lifecycle.CoroutineLiveDataKt.liveData(context, j, new androidx.lifecycle.FlowLiveDataConversions$asLiveData$1(flow, null));
    }

    @androidx.annotation.RequiresApi(26)
    @org.jetbrains.annotations.NotNull
    public static final <T> androidx.lifecycle.LiveData<T> asLiveData(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.Flow<? extends T> flow, @org.jetbrains.annotations.NotNull kotlin.coroutines.CoroutineContext context, @org.jetbrains.annotations.NotNull java.time.Duration timeout) {
        long millis;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(flow, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(context, "context");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(timeout, "timeout");
        millis = timeout.toMillis();
        return asLiveData(flow, context, millis);
    }

    public static /* synthetic */ androidx.lifecycle.LiveData asLiveData$default(kotlinx.coroutines.flow.Flow flow, kotlin.coroutines.CoroutineContext coroutineContext, long j, int i, java.lang.Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = kotlin.coroutines.EmptyCoroutineContext.INSTANCE;
        }
        if ((i & 2) != 0) {
            j = 5000;
        }
        return asLiveData(flow, coroutineContext, j);
    }

    public static /* synthetic */ androidx.lifecycle.LiveData asLiveData$default(kotlinx.coroutines.flow.Flow flow, kotlin.coroutines.CoroutineContext coroutineContext, java.time.Duration duration, int i, java.lang.Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = kotlin.coroutines.EmptyCoroutineContext.INSTANCE;
        }
        return asLiveData(flow, coroutineContext, duration);
    }
}
