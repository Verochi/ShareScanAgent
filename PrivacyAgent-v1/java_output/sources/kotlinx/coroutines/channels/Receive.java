package kotlinx.coroutines.channels;

@kotlin.Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b \u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0005¢\u0006\u0002\u0010\u0004J#\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\n2\u0006\u0010\r\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u000eJ\u0014\u0010\u000f\u001a\u00020\f2\n\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030\u0011H&R\u0014\u0010\u0005\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lkotlinx/coroutines/channels/Receive;", androidx.exifinterface.media.ExifInterface.LONGITUDE_EAST, "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "Lkotlinx/coroutines/channels/ReceiveOrClosed;", "()V", "offerResult", "Lkotlinx/coroutines/internal/Symbol;", "getOfferResult", "()Lkotlinx/coroutines/internal/Symbol;", "resumeOnCancellationFun", "Lkotlin/Function1;", "", "", "value", "(Ljava/lang/Object;)Lkotlin/jvm/functions/Function1;", "resumeReceiveClosed", "closed", "Lkotlinx/coroutines/channels/Closed;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes16.dex */
public abstract class Receive<E> extends kotlinx.coroutines.internal.LockFreeLinkedListNode implements kotlinx.coroutines.channels.ReceiveOrClosed<E> {
    @Override // kotlinx.coroutines.channels.ReceiveOrClosed
    @org.jetbrains.annotations.NotNull
    public kotlinx.coroutines.internal.Symbol getOfferResult() {
        return kotlinx.coroutines.channels.AbstractChannelKt.OFFER_SUCCESS;
    }

    @org.jetbrains.annotations.Nullable
    public kotlin.jvm.functions.Function1<java.lang.Throwable, kotlin.Unit> resumeOnCancellationFun(E value) {
        return null;
    }

    public abstract void resumeReceiveClosed(@org.jetbrains.annotations.NotNull kotlinx.coroutines.channels.Closed<?> closed);
}
