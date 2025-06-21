package kotlinx.coroutines.channels;

@kotlin.Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0012\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B#\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0010\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\rH\u0014J\u0012\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\rH\u0014¨\u0006\u0011"}, d2 = {"Lkotlinx/coroutines/channels/ActorCoroutine;", androidx.exifinterface.media.ExifInterface.LONGITUDE_EAST, "Lkotlinx/coroutines/channels/ChannelCoroutine;", "Lkotlinx/coroutines/channels/ActorScope;", "parentContext", "Lkotlin/coroutines/CoroutineContext;", "channel", "Lkotlinx/coroutines/channels/Channel;", "active", "", "(Lkotlin/coroutines/CoroutineContext;Lkotlinx/coroutines/channels/Channel;Z)V", "handleJobException", "exception", "", "onCancelling", "", "cause", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes16.dex */
class ActorCoroutine<E> extends kotlinx.coroutines.channels.ChannelCoroutine<E> implements kotlinx.coroutines.channels.ActorScope<E> {
    public ActorCoroutine(@org.jetbrains.annotations.NotNull kotlin.coroutines.CoroutineContext coroutineContext, @org.jetbrains.annotations.NotNull kotlinx.coroutines.channels.Channel<E> channel, boolean z) {
        super(coroutineContext, channel, false, z);
        initParentJob((kotlinx.coroutines.Job) coroutineContext.get(kotlinx.coroutines.Job.INSTANCE));
    }

    @Override // kotlinx.coroutines.JobSupport
    public boolean handleJobException(@org.jetbrains.annotations.NotNull java.lang.Throwable exception) {
        kotlinx.coroutines.CoroutineExceptionHandlerKt.handleCoroutineException(getContext(), exception);
        return true;
    }

    @Override // kotlinx.coroutines.JobSupport
    public void onCancelling(@org.jetbrains.annotations.Nullable java.lang.Throwable cause) {
        kotlinx.coroutines.channels.Channel<E> channel = get_channel();
        if (cause != null) {
            r1 = cause instanceof java.util.concurrent.CancellationException ? (java.util.concurrent.CancellationException) cause : null;
            if (r1 == null) {
                r1 = kotlinx.coroutines.ExceptionsKt.CancellationException(kotlin.jvm.internal.Intrinsics.stringPlus(kotlinx.coroutines.DebugStringsKt.getClassSimpleName(this), " was cancelled"), cause);
            }
        }
        channel.cancel(r1);
    }
}
