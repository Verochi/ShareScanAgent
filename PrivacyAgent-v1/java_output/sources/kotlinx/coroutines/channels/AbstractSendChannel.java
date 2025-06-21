package kotlinx.coroutines.channels;

@kotlin.Metadata(d1 = {"\u0000ª\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u000b\b \u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002:\u0004ghijB)\u0012 \u0010K\u001a\u001c\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u000b\u0018\u00010:j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`J¢\u0006\u0004\bf\u0010>J\u001b\u0010\u0006\u001a\u00020\u00052\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J#\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00028\u00002\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0003H\u0002¢\u0006\u0004\b\t\u0010\nJ\u001b\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00028\u0000H\u0082@ø\u0001\u0000¢\u0006\u0004\b\f\u0010\rJ+\u0010\u000f\u001a\u00020\u000b*\u0006\u0012\u0002\b\u00030\u000e2\u0006\u0010\b\u001a\u00028\u00002\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0003H\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0019\u0010\u0012\u001a\u00020\u000b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u001b\u0010\u0014\u001a\u00020\u000b2\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0003H\u0002¢\u0006\u0004\b\u0014\u0010\u0015JX\u0010\u001c\u001a\u00020\u000b\"\u0004\b\u0001\u0010\u00162\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00010\u00172\u0006\u0010\b\u001a\u00028\u00002(\u0010\u001b\u001a$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u0019H\u0002ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001f\u001a\u00020\u001eH\u0002¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010!\u001a\u00020\u001a2\u0006\u0010\b\u001a\u00028\u0000H\u0014¢\u0006\u0004\b!\u0010\"J#\u0010#\u001a\u00020\u001a2\u0006\u0010\b\u001a\u00028\u00002\n\u0010\u0018\u001a\u0006\u0012\u0002\b\u00030\u0017H\u0014¢\u0006\u0004\b#\u0010$J\u0011\u0010&\u001a\u0004\u0018\u00010%H\u0004¢\u0006\u0004\b&\u0010'J\u001d\u0010)\u001a\b\u0012\u0002\b\u0003\u0018\u00010(2\u0006\u0010\b\u001a\u00028\u0000H\u0004¢\u0006\u0004\b)\u0010*J#\u0010-\u001a\u000e\u0012\u0002\b\u00030+j\u0006\u0012\u0002\b\u0003`,2\u0006\u0010\b\u001a\u00028\u0000H\u0004¢\u0006\u0004\b-\u0010.J\u001b\u0010/\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00028\u0000H\u0086@ø\u0001\u0000¢\u0006\u0004\b/\u0010\rJ\u0017\u00101\u001a\u0002002\u0006\u0010\b\u001a\u00028\u0000H\u0016¢\u0006\u0004\b1\u00102J$\u00105\u001a\b\u0012\u0004\u0012\u00020\u000b032\u0006\u0010\b\u001a\u00028\u0000ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b4\u0010\"J\u0019\u00106\u001a\u0004\u0018\u00010\u001a2\u0006\u0010/\u001a\u00020%H\u0014¢\u0006\u0004\b6\u00107J\u0019\u00108\u001a\u0002002\b\u0010\u0011\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b8\u00109J)\u0010=\u001a\u00020\u000b2\u0018\u0010<\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0004\u0012\u00020\u000b0:j\u0002`;H\u0016¢\u0006\u0004\b=\u0010>J\u0017\u0010@\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020?H\u0014¢\u0006\u0004\b@\u0010AJ\u0017\u0010B\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010(H\u0014¢\u0006\u0004\bB\u0010CJ\u001d\u0010E\u001a\b\u0012\u0004\u0012\u00028\u00000D2\u0006\u0010\b\u001a\u00028\u0000H\u0004¢\u0006\u0004\bE\u0010FJ\u000f\u0010H\u001a\u00020GH\u0016¢\u0006\u0004\bH\u0010IR.\u0010K\u001a\u001c\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u000b\u0018\u00010:j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`J8\u0004X\u0085\u0004¢\u0006\u0006\n\u0004\bK\u0010LR\u001a\u0010R\u001a\u00020M8\u0004X\u0084\u0004¢\u0006\f\n\u0004\bN\u0010O\u001a\u0004\bP\u0010QR\u0014\u0010U\u001a\u0002008BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bS\u0010TR\u0014\u0010W\u001a\u00020G8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bV\u0010IR\u0014\u0010X\u001a\u0002008$X¤\u0004¢\u0006\u0006\u001a\u0004\bX\u0010TR\u0014\u0010Y\u001a\u0002008$X¤\u0004¢\u0006\u0006\u001a\u0004\bY\u0010TR\u001a\u0010\\\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00038DX\u0084\u0004¢\u0006\u0006\u001a\u0004\bZ\u0010[R\u001a\u0010^\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00038DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b]\u0010[R\u0011\u0010_\u001a\u0002008F¢\u0006\u0006\u001a\u0004\b_\u0010TR#\u0010c\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020`8F¢\u0006\u0006\u001a\u0004\ba\u0010bR\u0014\u0010e\u001a\u00020G8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\bd\u0010I\u0082\u0002\u000f\n\u0002\b\u0019\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006k"}, d2 = {"Lkotlinx/coroutines/channels/AbstractSendChannel;", androidx.exifinterface.media.ExifInterface.LONGITUDE_EAST, "Lkotlinx/coroutines/channels/SendChannel;", "Lkotlinx/coroutines/channels/Closed;", "closed", "", "e", "(Lkotlinx/coroutines/channels/Closed;)Ljava/lang/Throwable;", "element", "d", "(Ljava/lang/Object;Lkotlinx/coroutines/channels/Closed;)Ljava/lang/Throwable;", "", "j", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlin/coroutines/Continuation;", "f", "(Lkotlin/coroutines/Continuation;Ljava/lang/Object;Lkotlinx/coroutines/channels/Closed;)V", "cause", "g", "(Ljava/lang/Throwable;)V", "c", "(Lkotlinx/coroutines/channels/Closed;)V", "R", "Lkotlinx/coroutines/selects/SelectInstance;", "select", "Lkotlin/Function2;", "", "block", "i", "(Lkotlinx/coroutines/selects/SelectInstance;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", "", "a", "()I", "offerInternal", "(Ljava/lang/Object;)Ljava/lang/Object;", "offerSelectInternal", "(Ljava/lang/Object;Lkotlinx/coroutines/selects/SelectInstance;)Ljava/lang/Object;", "Lkotlinx/coroutines/channels/Send;", "takeFirstSendOrPeekClosed", "()Lkotlinx/coroutines/channels/Send;", "Lkotlinx/coroutines/channels/ReceiveOrClosed;", "sendBuffered", "(Ljava/lang/Object;)Lkotlinx/coroutines/channels/ReceiveOrClosed;", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$AddLastDesc;", "Lkotlinx/coroutines/internal/AddLastDesc;", "describeSendBuffered", "(Ljava/lang/Object;)Lkotlinx/coroutines/internal/LockFreeLinkedListNode$AddLastDesc;", "send", "", "offer", "(Ljava/lang/Object;)Z", "Lkotlinx/coroutines/channels/ChannelResult;", "trySend-JP2dKIU", "trySend", "enqueueSend", "(Lkotlinx/coroutines/channels/Send;)Ljava/lang/Object;", "close", "(Ljava/lang/Throwable;)Z", "Lkotlin/Function1;", "Lkotlinx/coroutines/channels/Handler;", "handler", "invokeOnClose", "(Lkotlin/jvm/functions/Function1;)V", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "onClosedIdempotent", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)V", "takeFirstReceiveOrPeekClosed", "()Lkotlinx/coroutines/channels/ReceiveOrClosed;", "Lkotlinx/coroutines/channels/AbstractSendChannel$TryOfferDesc;", "describeTryOffer", "(Ljava/lang/Object;)Lkotlinx/coroutines/channels/AbstractSendChannel$TryOfferDesc;", "", "toString", "()Ljava/lang/String;", "Lkotlinx/coroutines/internal/OnUndeliveredElement;", "onUndeliveredElement", "Lkotlin/jvm/functions/Function1;", "Lkotlinx/coroutines/internal/LockFreeLinkedListHead;", com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.AD_COUNT, "Lkotlinx/coroutines/internal/LockFreeLinkedListHead;", "getQueue", "()Lkotlinx/coroutines/internal/LockFreeLinkedListHead;", "queue", "h", "()Z", "isFullImpl", "b", "queueDebugStateString", "isBufferAlwaysFull", "isBufferFull", "getClosedForSend", "()Lkotlinx/coroutines/channels/Closed;", "closedForSend", "getClosedForReceive", "closedForReceive", "isClosedForSend", "Lkotlinx/coroutines/selects/SelectClause2;", "getOnSend", "()Lkotlinx/coroutines/selects/SelectClause2;", "onSend", "getBufferDebugString", "bufferDebugString", "<init>", "SendBuffered", "SendBufferedDesc", "SendSelect", "TryOfferDesc", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes16.dex */
public abstract class AbstractSendChannel<E> implements kotlinx.coroutines.channels.SendChannel<E> {
    public static final /* synthetic */ java.util.concurrent.atomic.AtomicReferenceFieldUpdater t = java.util.concurrent.atomic.AtomicReferenceFieldUpdater.newUpdater(kotlinx.coroutines.channels.AbstractSendChannel.class, java.lang.Object.class, "onCloseHandler");

    /* renamed from: n, reason: from kotlin metadata */
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.internal.LockFreeLinkedListHead queue = new kotlinx.coroutines.internal.LockFreeLinkedListHead();

    @org.jetbrains.annotations.NotNull
    private volatile /* synthetic */ java.lang.Object onCloseHandler = null;

    @kotlin.jvm.JvmField
    @org.jetbrains.annotations.Nullable
    protected final kotlin.jvm.functions.Function1<E, kotlin.Unit> onUndeliveredElement;

    @kotlin.Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u0000*\u0006\b\u0001\u0010\u0001 \u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00028\u0001¢\u0006\u0002\u0010\u0004J\b\u0010\n\u001a\u00020\u000bH\u0016J\u0014\u0010\f\u001a\u00020\u000b2\n\u0010\r\u001a\u0006\u0012\u0002\b\u00030\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u0014\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016R\u0012\u0010\u0003\u001a\u00028\u00018\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\u0005R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\u0015"}, d2 = {"Lkotlinx/coroutines/channels/AbstractSendChannel$SendBuffered;", androidx.exifinterface.media.ExifInterface.LONGITUDE_EAST, "Lkotlinx/coroutines/channels/Send;", "element", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "pollResult", "", "getPollResult", "()Ljava/lang/Object;", "completeResumeSend", "", "resumeSendClosed", "closed", "Lkotlinx/coroutines/channels/Closed;", "toString", "", "tryResumeSend", "Lkotlinx/coroutines/internal/Symbol;", "otherOp", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class SendBuffered<E> extends kotlinx.coroutines.channels.Send {

        @kotlin.jvm.JvmField
        public final E element;

        public SendBuffered(E e) {
            this.element = e;
        }

        @Override // kotlinx.coroutines.channels.Send
        public void completeResumeSend() {
        }

        @Override // kotlinx.coroutines.channels.Send
        @org.jetbrains.annotations.Nullable
        /* renamed from: getPollResult, reason: from getter */
        public java.lang.Object getElement() {
            return this.element;
        }

        @Override // kotlinx.coroutines.channels.Send
        public void resumeSendClosed(@org.jetbrains.annotations.NotNull kotlinx.coroutines.channels.Closed<?> closed) {
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode
        @org.jetbrains.annotations.NotNull
        public java.lang.String toString() {
            return "SendBuffered@" + kotlinx.coroutines.DebugStringsKt.getHexAddress(this) + '(' + this.element + ')';
        }

        @Override // kotlinx.coroutines.channels.Send
        @org.jetbrains.annotations.Nullable
        public kotlinx.coroutines.internal.Symbol tryResumeSend(@org.jetbrains.annotations.Nullable kotlinx.coroutines.internal.LockFreeLinkedListNode.PrepareOp otherOp) {
            kotlinx.coroutines.internal.Symbol symbol = kotlinx.coroutines.CancellableContinuationImplKt.RESUME_TOKEN;
            if (otherOp != null) {
                otherOp.finishPrepare();
            }
            return symbol;
        }
    }

    @kotlin.Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0012\u0018\u0000*\u0004\b\u0001\u0010\u00012\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u00030\u0002j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u0003`\u0004B\u0015\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00028\u0001¢\u0006\u0002\u0010\bJ\u0012\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\fH\u0014¨\u0006\r"}, d2 = {"Lkotlinx/coroutines/channels/AbstractSendChannel$SendBufferedDesc;", androidx.exifinterface.media.ExifInterface.LONGITUDE_EAST, "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$AddLastDesc;", "Lkotlinx/coroutines/channels/AbstractSendChannel$SendBuffered;", "Lkotlinx/coroutines/internal/AddLastDesc;", "queue", "Lkotlinx/coroutines/internal/LockFreeLinkedListHead;", "element", "(Lkotlinx/coroutines/internal/LockFreeLinkedListHead;Ljava/lang/Object;)V", "failure", "", "affected", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static class SendBufferedDesc<E> extends kotlinx.coroutines.internal.LockFreeLinkedListNode.AddLastDesc<kotlinx.coroutines.channels.AbstractSendChannel.SendBuffered<? extends E>> {
        public SendBufferedDesc(@org.jetbrains.annotations.NotNull kotlinx.coroutines.internal.LockFreeLinkedListHead lockFreeLinkedListHead, E e) {
            super(lockFreeLinkedListHead, new kotlinx.coroutines.channels.AbstractSendChannel.SendBuffered(e));
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        @org.jetbrains.annotations.Nullable
        public java.lang.Object failure(@org.jetbrains.annotations.NotNull kotlinx.coroutines.internal.LockFreeLinkedListNode affected) {
            if (affected instanceof kotlinx.coroutines.channels.Closed) {
                return affected;
            }
            if (affected instanceof kotlinx.coroutines.channels.ReceiveOrClosed) {
                return kotlinx.coroutines.channels.AbstractChannelKt.OFFER_FAILED;
            }
            return null;
        }
    }

    @kotlin.Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u0001*\u0004\b\u0002\u0010\u00022\u00020\u00032\u00020\u0004BX\u0012\u0006\u0010\u0016\u001a\u00028\u0001\u0012\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00010\u0017\u0012\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00020\u001b\u0012(\u0010%\u001a$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010 \u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020!\u0012\u0006\u0012\u0004\u0018\u00010\"0\u001fø\u0001\u0000¢\u0006\u0004\b&\u0010'J\u0014\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000b\u001a\u00020\tH\u0016J\u0014\u0010\u000e\u001a\u00020\t2\n\u0010\r\u001a\u0006\u0012\u0002\b\u00030\fH\u0016J\b\u0010\u000f\u001a\u00020\tH\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0016R\u001a\u0010\u0016\u001a\u00028\u00018\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00010\u00178\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00020\u001b8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR9\u0010%\u001a$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010 \u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020!\u0012\u0006\u0012\u0004\u0018\u00010\"0\u001f8\u0006X\u0087\u0004ø\u0001\u0000¢\u0006\u0006\n\u0004\b#\u0010$\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006("}, d2 = {"Lkotlinx/coroutines/channels/AbstractSendChannel$SendSelect;", androidx.exifinterface.media.ExifInterface.LONGITUDE_EAST, "R", "Lkotlinx/coroutines/channels/Send;", "Lkotlinx/coroutines/DisposableHandle;", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;", "otherOp", "Lkotlinx/coroutines/internal/Symbol;", "tryResumeSend", "", "completeResumeSend", "dispose", "Lkotlinx/coroutines/channels/Closed;", "closed", "resumeSendClosed", "undeliveredElement", "", "toString", "v", "Ljava/lang/Object;", "getPollResult", "()Ljava/lang/Object;", "pollResult", "Lkotlinx/coroutines/channels/AbstractSendChannel;", com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.WIDTH, "Lkotlinx/coroutines/channels/AbstractSendChannel;", "channel", "Lkotlinx/coroutines/selects/SelectInstance;", "x", "Lkotlinx/coroutines/selects/SelectInstance;", "select", "Lkotlin/Function2;", "Lkotlinx/coroutines/channels/SendChannel;", "Lkotlin/coroutines/Continuation;", "", "y", "Lkotlin/jvm/functions/Function2;", "block", "<init>", "(Ljava/lang/Object;Lkotlinx/coroutines/channels/AbstractSendChannel;Lkotlinx/coroutines/selects/SelectInstance;Lkotlin/jvm/functions/Function2;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1})
    public static final class SendSelect<E, R> extends kotlinx.coroutines.channels.Send implements kotlinx.coroutines.DisposableHandle {

        /* renamed from: v, reason: from kotlin metadata */
        public final E pollResult;

        /* renamed from: w, reason: from kotlin metadata */
        @kotlin.jvm.JvmField
        @org.jetbrains.annotations.NotNull
        public final kotlinx.coroutines.channels.AbstractSendChannel<E> channel;

        /* renamed from: x, reason: from kotlin metadata */
        @kotlin.jvm.JvmField
        @org.jetbrains.annotations.NotNull
        public final kotlinx.coroutines.selects.SelectInstance<R> select;

        /* renamed from: y, reason: from kotlin metadata */
        @kotlin.jvm.JvmField
        @org.jetbrains.annotations.NotNull
        public final kotlin.jvm.functions.Function2<kotlinx.coroutines.channels.SendChannel<? super E>, kotlin.coroutines.Continuation<? super R>, java.lang.Object> block;

        /* JADX WARN: Multi-variable type inference failed */
        public SendSelect(E e, @org.jetbrains.annotations.NotNull kotlinx.coroutines.channels.AbstractSendChannel<E> abstractSendChannel, @org.jetbrains.annotations.NotNull kotlinx.coroutines.selects.SelectInstance<? super R> selectInstance, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super kotlinx.coroutines.channels.SendChannel<? super E>, ? super kotlin.coroutines.Continuation<? super R>, ? extends java.lang.Object> function2) {
            this.pollResult = e;
            this.channel = abstractSendChannel;
            this.select = selectInstance;
            this.block = function2;
        }

        @Override // kotlinx.coroutines.channels.Send
        public void completeResumeSend() {
            kotlinx.coroutines.intrinsics.CancellableKt.startCoroutineCancellable$default(this.block, this.channel, this.select.getCompletion(), null, 4, null);
        }

        @Override // kotlinx.coroutines.DisposableHandle
        public void dispose() {
            if (remove()) {
                undeliveredElement();
            }
        }

        @Override // kotlinx.coroutines.channels.Send
        /* renamed from: getPollResult */
        public E getElement() {
            return this.pollResult;
        }

        @Override // kotlinx.coroutines.channels.Send
        public void resumeSendClosed(@org.jetbrains.annotations.NotNull kotlinx.coroutines.channels.Closed<?> closed) {
            if (this.select.trySelect()) {
                this.select.resumeSelectWithException(closed.getSendException());
            }
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode
        @org.jetbrains.annotations.NotNull
        public java.lang.String toString() {
            return "SendSelect@" + kotlinx.coroutines.DebugStringsKt.getHexAddress(this) + '(' + getElement() + ")[" + this.channel + ", " + this.select + ']';
        }

        @Override // kotlinx.coroutines.channels.Send
        @org.jetbrains.annotations.Nullable
        public kotlinx.coroutines.internal.Symbol tryResumeSend(@org.jetbrains.annotations.Nullable kotlinx.coroutines.internal.LockFreeLinkedListNode.PrepareOp otherOp) {
            return (kotlinx.coroutines.internal.Symbol) this.select.trySelectOther(otherOp);
        }

        @Override // kotlinx.coroutines.channels.Send
        public void undeliveredElement() {
            kotlin.jvm.functions.Function1<E, kotlin.Unit> function1 = this.channel.onUndeliveredElement;
            if (function1 == null) {
                return;
            }
            kotlinx.coroutines.internal.OnUndeliveredElementKt.callUndeliveredElement(function1, getElement(), this.select.getCompletion().getContext());
        }
    }

    @kotlin.Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u0000*\u0004\b\u0001\u0010\u00012\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u00030\u0002j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u0003`\u0004B\u0015\u0012\u0006\u0010\u0005\u001a\u00028\u0001\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0012\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\rH\u0014J\u0016\u0010\u000e\u001a\u0004\u0018\u00010\u000b2\n\u0010\u000f\u001a\u00060\u0010j\u0002`\u0011H\u0016R\u0012\u0010\u0005\u001a\u00028\u00018\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\t¨\u0006\u0012"}, d2 = {"Lkotlinx/coroutines/channels/AbstractSendChannel$TryOfferDesc;", androidx.exifinterface.media.ExifInterface.LONGITUDE_EAST, "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$RemoveFirstDesc;", "Lkotlinx/coroutines/channels/ReceiveOrClosed;", "Lkotlinx/coroutines/internal/RemoveFirstDesc;", "element", "queue", "Lkotlinx/coroutines/internal/LockFreeLinkedListHead;", "(Ljava/lang/Object;Lkotlinx/coroutines/internal/LockFreeLinkedListHead;)V", "Ljava/lang/Object;", "failure", "", "affected", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "onPrepare", "prepareOp", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;", "Lkotlinx/coroutines/internal/PrepareOp;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class TryOfferDesc<E> extends kotlinx.coroutines.internal.LockFreeLinkedListNode.RemoveFirstDesc<kotlinx.coroutines.channels.ReceiveOrClosed<? super E>> {

        @kotlin.jvm.JvmField
        public final E element;

        public TryOfferDesc(E e, @org.jetbrains.annotations.NotNull kotlinx.coroutines.internal.LockFreeLinkedListHead lockFreeLinkedListHead) {
            super(lockFreeLinkedListHead);
            this.element = e;
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode.RemoveFirstDesc, kotlinx.coroutines.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        @org.jetbrains.annotations.Nullable
        public java.lang.Object failure(@org.jetbrains.annotations.NotNull kotlinx.coroutines.internal.LockFreeLinkedListNode affected) {
            if (affected instanceof kotlinx.coroutines.channels.Closed) {
                return affected;
            }
            if (affected instanceof kotlinx.coroutines.channels.ReceiveOrClosed) {
                return null;
            }
            return kotlinx.coroutines.channels.AbstractChannelKt.OFFER_FAILED;
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        @org.jetbrains.annotations.Nullable
        public java.lang.Object onPrepare(@org.jetbrains.annotations.NotNull kotlinx.coroutines.internal.LockFreeLinkedListNode.PrepareOp prepareOp) {
            kotlinx.coroutines.internal.Symbol tryResumeReceive = ((kotlinx.coroutines.channels.ReceiveOrClosed) prepareOp.affected).tryResumeReceive(this.element, prepareOp);
            if (tryResumeReceive == null) {
                return kotlinx.coroutines.internal.LockFreeLinkedList_commonKt.REMOVE_PREPARED;
            }
            java.lang.Object obj = kotlinx.coroutines.internal.AtomicKt.RETRY_ATOMIC;
            if (tryResumeReceive == obj) {
                return obj;
            }
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AbstractSendChannel(@org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function1<? super E, kotlin.Unit> function1) {
        this.onUndeliveredElement = function1;
    }

    public final int a() {
        kotlinx.coroutines.internal.LockFreeLinkedListHead lockFreeLinkedListHead = this.queue;
        int i = 0;
        for (kotlinx.coroutines.internal.LockFreeLinkedListNode lockFreeLinkedListNode = (kotlinx.coroutines.internal.LockFreeLinkedListNode) lockFreeLinkedListHead.getNext(); !kotlin.jvm.internal.Intrinsics.areEqual(lockFreeLinkedListNode, lockFreeLinkedListHead); lockFreeLinkedListNode = lockFreeLinkedListNode.getNextNode()) {
            if (lockFreeLinkedListNode instanceof kotlinx.coroutines.internal.LockFreeLinkedListNode) {
                i++;
            }
        }
        return i;
    }

    public final java.lang.String b() {
        kotlinx.coroutines.internal.LockFreeLinkedListNode nextNode = this.queue.getNextNode();
        if (nextNode == this.queue) {
            return "EmptyQueue";
        }
        java.lang.String lockFreeLinkedListNode = nextNode instanceof kotlinx.coroutines.channels.Closed ? nextNode.toString() : nextNode instanceof kotlinx.coroutines.channels.Receive ? "ReceiveQueued" : nextNode instanceof kotlinx.coroutines.channels.Send ? "SendQueued" : kotlin.jvm.internal.Intrinsics.stringPlus("UNEXPECTED:", nextNode);
        kotlinx.coroutines.internal.LockFreeLinkedListNode prevNode = this.queue.getPrevNode();
        if (prevNode == nextNode) {
            return lockFreeLinkedListNode;
        }
        java.lang.String str = lockFreeLinkedListNode + ",queueSize=" + a();
        if (!(prevNode instanceof kotlinx.coroutines.channels.Closed)) {
            return str;
        }
        return str + ",closedForSend=" + prevNode;
    }

    public final void c(kotlinx.coroutines.channels.Closed<?> closed) {
        java.lang.Object m797constructorimpl$default = kotlinx.coroutines.internal.InlineList.m797constructorimpl$default(null, 1, null);
        while (true) {
            kotlinx.coroutines.internal.LockFreeLinkedListNode prevNode = closed.getPrevNode();
            kotlinx.coroutines.channels.Receive receive = prevNode instanceof kotlinx.coroutines.channels.Receive ? (kotlinx.coroutines.channels.Receive) prevNode : null;
            if (receive == null) {
                break;
            } else if (receive.remove()) {
                m797constructorimpl$default = kotlinx.coroutines.internal.InlineList.m802plusFjFbRPM(m797constructorimpl$default, receive);
            } else {
                receive.helpRemove();
            }
        }
        if (m797constructorimpl$default != null) {
            if (m797constructorimpl$default instanceof java.util.ArrayList) {
                java.util.ArrayList arrayList = (java.util.ArrayList) m797constructorimpl$default;
                int size = arrayList.size() - 1;
                if (size >= 0) {
                    while (true) {
                        int i = size - 1;
                        ((kotlinx.coroutines.channels.Receive) arrayList.get(size)).resumeReceiveClosed(closed);
                        if (i < 0) {
                            break;
                        } else {
                            size = i;
                        }
                    }
                }
            } else {
                ((kotlinx.coroutines.channels.Receive) m797constructorimpl$default).resumeReceiveClosed(closed);
            }
        }
        onClosedIdempotent(closed);
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    /* renamed from: close */
    public boolean cancel(@org.jetbrains.annotations.Nullable java.lang.Throwable cause) {
        boolean z;
        kotlinx.coroutines.channels.Closed<?> closed = new kotlinx.coroutines.channels.Closed<>(cause);
        kotlinx.coroutines.internal.LockFreeLinkedListNode lockFreeLinkedListNode = this.queue;
        while (true) {
            kotlinx.coroutines.internal.LockFreeLinkedListNode prevNode = lockFreeLinkedListNode.getPrevNode();
            z = true;
            if (!(!(prevNode instanceof kotlinx.coroutines.channels.Closed))) {
                z = false;
                break;
            }
            if (prevNode.addNext(closed, lockFreeLinkedListNode)) {
                break;
            }
        }
        if (!z) {
            closed = (kotlinx.coroutines.channels.Closed) this.queue.getPrevNode();
        }
        c(closed);
        if (z) {
            g(cause);
        }
        return z;
    }

    public final java.lang.Throwable d(E element, kotlinx.coroutines.channels.Closed<?> closed) {
        kotlinx.coroutines.internal.UndeliveredElementException callUndeliveredElementCatchingException$default;
        c(closed);
        kotlin.jvm.functions.Function1<E, kotlin.Unit> function1 = this.onUndeliveredElement;
        if (function1 == null || (callUndeliveredElementCatchingException$default = kotlinx.coroutines.internal.OnUndeliveredElementKt.callUndeliveredElementCatchingException$default(function1, element, null, 2, null)) == null) {
            return closed.getSendException();
        }
        kotlin.ExceptionsKt__ExceptionsKt.addSuppressed(callUndeliveredElementCatchingException$default, closed.getSendException());
        throw callUndeliveredElementCatchingException$default;
    }

    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.internal.LockFreeLinkedListNode.AddLastDesc<?> describeSendBuffered(E element) {
        return new kotlinx.coroutines.channels.AbstractSendChannel.SendBufferedDesc(this.queue, element);
    }

    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.channels.AbstractSendChannel.TryOfferDesc<E> describeTryOffer(E element) {
        return new kotlinx.coroutines.channels.AbstractSendChannel.TryOfferDesc<>(element, this.queue);
    }

    public final java.lang.Throwable e(kotlinx.coroutines.channels.Closed<?> closed) {
        c(closed);
        return closed.getSendException();
    }

    @org.jetbrains.annotations.Nullable
    public java.lang.Object enqueueSend(@org.jetbrains.annotations.NotNull kotlinx.coroutines.channels.Send send) {
        boolean z;
        kotlinx.coroutines.internal.LockFreeLinkedListNode prevNode;
        if (isBufferAlwaysFull()) {
            kotlinx.coroutines.internal.LockFreeLinkedListNode lockFreeLinkedListNode = this.queue;
            do {
                prevNode = lockFreeLinkedListNode.getPrevNode();
                if (prevNode instanceof kotlinx.coroutines.channels.ReceiveOrClosed) {
                    return prevNode;
                }
            } while (!prevNode.addNext(send, lockFreeLinkedListNode));
            return null;
        }
        kotlinx.coroutines.internal.LockFreeLinkedListNode lockFreeLinkedListNode2 = this.queue;
        kotlinx.coroutines.channels.AbstractSendChannel$enqueueSend$$inlined$addLastIfPrevAndIf$1 abstractSendChannel$enqueueSend$$inlined$addLastIfPrevAndIf$1 = new kotlinx.coroutines.channels.AbstractSendChannel$enqueueSend$$inlined$addLastIfPrevAndIf$1(send, this);
        while (true) {
            kotlinx.coroutines.internal.LockFreeLinkedListNode prevNode2 = lockFreeLinkedListNode2.getPrevNode();
            if (!(prevNode2 instanceof kotlinx.coroutines.channels.ReceiveOrClosed)) {
                int tryCondAddNext = prevNode2.tryCondAddNext(send, lockFreeLinkedListNode2, abstractSendChannel$enqueueSend$$inlined$addLastIfPrevAndIf$1);
                z = true;
                if (tryCondAddNext != 1) {
                    if (tryCondAddNext == 2) {
                        z = false;
                        break;
                    }
                } else {
                    break;
                }
            } else {
                return prevNode2;
            }
        }
        if (z) {
            return null;
        }
        return kotlinx.coroutines.channels.AbstractChannelKt.ENQUEUE_FAILED;
    }

    public final void f(kotlin.coroutines.Continuation<?> continuation, E e, kotlinx.coroutines.channels.Closed<?> closed) {
        kotlinx.coroutines.internal.UndeliveredElementException callUndeliveredElementCatchingException$default;
        c(closed);
        java.lang.Throwable sendException = closed.getSendException();
        kotlin.jvm.functions.Function1<E, kotlin.Unit> function1 = this.onUndeliveredElement;
        if (function1 == null || (callUndeliveredElementCatchingException$default = kotlinx.coroutines.internal.OnUndeliveredElementKt.callUndeliveredElementCatchingException$default(function1, e, null, 2, null)) == null) {
            kotlin.Result.Companion companion = kotlin.Result.INSTANCE;
            continuation.resumeWith(kotlin.Result.m156constructorimpl(kotlin.ResultKt.createFailure(sendException)));
        } else {
            kotlin.ExceptionsKt__ExceptionsKt.addSuppressed(callUndeliveredElementCatchingException$default, sendException);
            kotlin.Result.Companion companion2 = kotlin.Result.INSTANCE;
            continuation.resumeWith(kotlin.Result.m156constructorimpl(kotlin.ResultKt.createFailure(callUndeliveredElementCatchingException$default)));
        }
    }

    public final void g(java.lang.Throwable cause) {
        kotlinx.coroutines.internal.Symbol symbol;
        java.lang.Object obj = this.onCloseHandler;
        if (obj == null || obj == (symbol = kotlinx.coroutines.channels.AbstractChannelKt.HANDLER_INVOKED) || !defpackage.q1.a(t, this, obj, symbol)) {
            return;
        }
        ((kotlin.jvm.functions.Function1) kotlin.jvm.internal.TypeIntrinsics.beforeCheckcastToFunctionOfArity(obj, 1)).invoke(cause);
    }

    @org.jetbrains.annotations.NotNull
    public java.lang.String getBufferDebugString() {
        return "";
    }

    @org.jetbrains.annotations.Nullable
    public final kotlinx.coroutines.channels.Closed<?> getClosedForReceive() {
        kotlinx.coroutines.internal.LockFreeLinkedListNode nextNode = this.queue.getNextNode();
        kotlinx.coroutines.channels.Closed<?> closed = nextNode instanceof kotlinx.coroutines.channels.Closed ? (kotlinx.coroutines.channels.Closed) nextNode : null;
        if (closed == null) {
            return null;
        }
        c(closed);
        return closed;
    }

    @org.jetbrains.annotations.Nullable
    public final kotlinx.coroutines.channels.Closed<?> getClosedForSend() {
        kotlinx.coroutines.internal.LockFreeLinkedListNode prevNode = this.queue.getPrevNode();
        kotlinx.coroutines.channels.Closed<?> closed = prevNode instanceof kotlinx.coroutines.channels.Closed ? (kotlinx.coroutines.channels.Closed) prevNode : null;
        if (closed == null) {
            return null;
        }
        c(closed);
        return closed;
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.selects.SelectClause2<E, kotlinx.coroutines.channels.SendChannel<E>> getOnSend() {
        return new kotlinx.coroutines.channels.AbstractSendChannel$onSend$1(this);
    }

    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.internal.LockFreeLinkedListHead getQueue() {
        return this.queue;
    }

    public final boolean h() {
        return !(this.queue.getNextNode() instanceof kotlinx.coroutines.channels.ReceiveOrClosed) && isBufferFull();
    }

    public final <R> void i(kotlinx.coroutines.selects.SelectInstance<? super R> select, E element, kotlin.jvm.functions.Function2<? super kotlinx.coroutines.channels.SendChannel<? super E>, ? super kotlin.coroutines.Continuation<? super R>, ? extends java.lang.Object> block) {
        while (!select.isSelected()) {
            if (h()) {
                kotlinx.coroutines.channels.AbstractSendChannel.SendSelect sendSelect = new kotlinx.coroutines.channels.AbstractSendChannel.SendSelect(element, this, select, block);
                java.lang.Object enqueueSend = enqueueSend(sendSelect);
                if (enqueueSend == null) {
                    select.disposeOnSelect(sendSelect);
                    return;
                }
                if (enqueueSend instanceof kotlinx.coroutines.channels.Closed) {
                    throw kotlinx.coroutines.internal.StackTraceRecoveryKt.recoverStackTrace(d(element, (kotlinx.coroutines.channels.Closed) enqueueSend));
                }
                if (enqueueSend != kotlinx.coroutines.channels.AbstractChannelKt.ENQUEUE_FAILED && !(enqueueSend instanceof kotlinx.coroutines.channels.Receive)) {
                    throw new java.lang.IllegalStateException(("enqueueSend returned " + enqueueSend + ' ').toString());
                }
            }
            java.lang.Object offerSelectInternal = offerSelectInternal(element, select);
            if (offerSelectInternal == kotlinx.coroutines.selects.SelectKt.getALREADY_SELECTED()) {
                return;
            }
            if (offerSelectInternal != kotlinx.coroutines.channels.AbstractChannelKt.OFFER_FAILED && offerSelectInternal != kotlinx.coroutines.internal.AtomicKt.RETRY_ATOMIC) {
                if (offerSelectInternal == kotlinx.coroutines.channels.AbstractChannelKt.OFFER_SUCCESS) {
                    kotlinx.coroutines.intrinsics.UndispatchedKt.startCoroutineUnintercepted(block, this, select.getCompletion());
                    return;
                } else {
                    if (!(offerSelectInternal instanceof kotlinx.coroutines.channels.Closed)) {
                        throw new java.lang.IllegalStateException(kotlin.jvm.internal.Intrinsics.stringPlus("offerSelectInternal returned ", offerSelectInternal).toString());
                    }
                    throw kotlinx.coroutines.internal.StackTraceRecoveryKt.recoverStackTrace(d(element, (kotlinx.coroutines.channels.Closed) offerSelectInternal));
                }
            }
        }
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public void invokeOnClose(@org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super java.lang.Throwable, kotlin.Unit> handler) {
        java.util.concurrent.atomic.AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = t;
        if (!defpackage.q1.a(atomicReferenceFieldUpdater, this, null, handler)) {
            java.lang.Object obj = this.onCloseHandler;
            if (obj != kotlinx.coroutines.channels.AbstractChannelKt.HANDLER_INVOKED) {
                throw new java.lang.IllegalStateException(kotlin.jvm.internal.Intrinsics.stringPlus("Another handler was already registered: ", obj));
            }
            throw new java.lang.IllegalStateException("Another handler was already registered and successfully invoked");
        }
        kotlinx.coroutines.channels.Closed<?> closedForSend = getClosedForSend();
        if (closedForSend == null || !defpackage.q1.a(atomicReferenceFieldUpdater, this, handler, kotlinx.coroutines.channels.AbstractChannelKt.HANDLER_INVOKED)) {
            return;
        }
        handler.invoke(closedForSend.closeCause);
    }

    public abstract boolean isBufferAlwaysFull();

    public abstract boolean isBufferFull();

    @Override // kotlinx.coroutines.channels.SendChannel
    public final boolean isClosedForSend() {
        return getClosedForSend() != null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x006d, code lost:
    
        r4 = r0.getResult();
        r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0075, code lost:
    
        if (r4 != r0) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0077, code lost:
    
        kotlin.coroutines.jvm.internal.DebugProbesKt.probeCoroutineSuspended(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x007a, code lost:
    
        r5 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x007e, code lost:
    
        if (r4 != r5) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0080, code lost:
    
        return r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0083, code lost:
    
        return kotlin.Unit.INSTANCE;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final java.lang.Object j(E e, kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        kotlin.coroutines.Continuation intercepted;
        intercepted = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        kotlinx.coroutines.CancellableContinuationImpl orCreateCancellableContinuation = kotlinx.coroutines.CancellableContinuationKt.getOrCreateCancellableContinuation(intercepted);
        while (true) {
            if (h()) {
                kotlinx.coroutines.channels.Send sendElement = this.onUndeliveredElement == null ? new kotlinx.coroutines.channels.SendElement(e, orCreateCancellableContinuation) : new kotlinx.coroutines.channels.SendElementWithUndeliveredHandler(e, orCreateCancellableContinuation, this.onUndeliveredElement);
                java.lang.Object enqueueSend = enqueueSend(sendElement);
                if (enqueueSend == null) {
                    kotlinx.coroutines.CancellableContinuationKt.removeOnCancellation(orCreateCancellableContinuation, sendElement);
                    break;
                }
                if (enqueueSend instanceof kotlinx.coroutines.channels.Closed) {
                    f(orCreateCancellableContinuation, e, (kotlinx.coroutines.channels.Closed) enqueueSend);
                    break;
                }
                if (enqueueSend != kotlinx.coroutines.channels.AbstractChannelKt.ENQUEUE_FAILED && !(enqueueSend instanceof kotlinx.coroutines.channels.Receive)) {
                    throw new java.lang.IllegalStateException(kotlin.jvm.internal.Intrinsics.stringPlus("enqueueSend returned ", enqueueSend).toString());
                }
            }
            java.lang.Object offerInternal = offerInternal(e);
            if (offerInternal == kotlinx.coroutines.channels.AbstractChannelKt.OFFER_SUCCESS) {
                orCreateCancellableContinuation.resumeWith(kotlin.Result.m156constructorimpl(kotlin.Unit.INSTANCE));
                break;
            }
            if (offerInternal != kotlinx.coroutines.channels.AbstractChannelKt.OFFER_FAILED) {
                if (!(offerInternal instanceof kotlinx.coroutines.channels.Closed)) {
                    throw new java.lang.IllegalStateException(kotlin.jvm.internal.Intrinsics.stringPlus("offerInternal returned ", offerInternal).toString());
                }
                f(orCreateCancellableContinuation, e, (kotlinx.coroutines.channels.Closed) offerInternal);
            }
        }
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public boolean offer(E element) {
        kotlinx.coroutines.internal.UndeliveredElementException callUndeliveredElementCatchingException$default;
        try {
            return kotlinx.coroutines.channels.SendChannel.DefaultImpls.offer(this, element);
        } catch (java.lang.Throwable th) {
            kotlin.jvm.functions.Function1<E, kotlin.Unit> function1 = this.onUndeliveredElement;
            if (function1 == null || (callUndeliveredElementCatchingException$default = kotlinx.coroutines.internal.OnUndeliveredElementKt.callUndeliveredElementCatchingException$default(function1, element, null, 2, null)) == null) {
                throw th;
            }
            kotlin.ExceptionsKt__ExceptionsKt.addSuppressed(callUndeliveredElementCatchingException$default, th);
            throw callUndeliveredElementCatchingException$default;
        }
    }

    @org.jetbrains.annotations.NotNull
    public java.lang.Object offerInternal(E element) {
        kotlinx.coroutines.channels.ReceiveOrClosed<E> takeFirstReceiveOrPeekClosed;
        do {
            takeFirstReceiveOrPeekClosed = takeFirstReceiveOrPeekClosed();
            if (takeFirstReceiveOrPeekClosed == null) {
                return kotlinx.coroutines.channels.AbstractChannelKt.OFFER_FAILED;
            }
        } while (takeFirstReceiveOrPeekClosed.tryResumeReceive(element, null) == null);
        takeFirstReceiveOrPeekClosed.completeResumeReceive(element);
        return takeFirstReceiveOrPeekClosed.getOfferResult();
    }

    @org.jetbrains.annotations.NotNull
    public java.lang.Object offerSelectInternal(E element, @org.jetbrains.annotations.NotNull kotlinx.coroutines.selects.SelectInstance<?> select) {
        kotlinx.coroutines.channels.AbstractSendChannel.TryOfferDesc<E> describeTryOffer = describeTryOffer(element);
        java.lang.Object performAtomicTrySelect = select.performAtomicTrySelect(describeTryOffer);
        if (performAtomicTrySelect != null) {
            return performAtomicTrySelect;
        }
        kotlinx.coroutines.channels.ReceiveOrClosed<? super E> result = describeTryOffer.getResult();
        result.completeResumeReceive(element);
        return result.getOfferResult();
    }

    public void onClosedIdempotent(@org.jetbrains.annotations.NotNull kotlinx.coroutines.internal.LockFreeLinkedListNode closed) {
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object send(E e, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        java.lang.Object coroutine_suspended;
        if (offerInternal(e) == kotlinx.coroutines.channels.AbstractChannelKt.OFFER_SUCCESS) {
            return kotlin.Unit.INSTANCE;
        }
        java.lang.Object j = j(e, continuation);
        coroutine_suspended = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        return j == coroutine_suspended ? j : kotlin.Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @org.jetbrains.annotations.Nullable
    public final kotlinx.coroutines.channels.ReceiveOrClosed<?> sendBuffered(E element) {
        kotlinx.coroutines.internal.LockFreeLinkedListNode prevNode;
        kotlinx.coroutines.internal.LockFreeLinkedListHead lockFreeLinkedListHead = this.queue;
        kotlinx.coroutines.channels.AbstractSendChannel.SendBuffered sendBuffered = new kotlinx.coroutines.channels.AbstractSendChannel.SendBuffered(element);
        do {
            prevNode = lockFreeLinkedListHead.getPrevNode();
            if (prevNode instanceof kotlinx.coroutines.channels.ReceiveOrClosed) {
                return (kotlinx.coroutines.channels.ReceiveOrClosed) prevNode;
            }
        } while (!prevNode.addNext(sendBuffered, lockFreeLinkedListHead));
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [kotlinx.coroutines.internal.LockFreeLinkedListNode] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    @org.jetbrains.annotations.Nullable
    public kotlinx.coroutines.channels.ReceiveOrClosed<E> takeFirstReceiveOrPeekClosed() {
        ?? r1;
        kotlinx.coroutines.internal.LockFreeLinkedListNode removeOrNext;
        kotlinx.coroutines.internal.LockFreeLinkedListHead lockFreeLinkedListHead = this.queue;
        while (true) {
            r1 = (kotlinx.coroutines.internal.LockFreeLinkedListNode) lockFreeLinkedListHead.getNext();
            if (r1 != lockFreeLinkedListHead && (r1 instanceof kotlinx.coroutines.channels.ReceiveOrClosed)) {
                if (((((kotlinx.coroutines.channels.ReceiveOrClosed) r1) instanceof kotlinx.coroutines.channels.Closed) && !r1.isRemoved()) || (removeOrNext = r1.removeOrNext()) == null) {
                    break;
                }
                removeOrNext.helpRemovePrev();
            }
        }
        r1 = 0;
        return (kotlinx.coroutines.channels.ReceiveOrClosed) r1;
    }

    @org.jetbrains.annotations.Nullable
    public final kotlinx.coroutines.channels.Send takeFirstSendOrPeekClosed() {
        kotlinx.coroutines.internal.LockFreeLinkedListNode lockFreeLinkedListNode;
        kotlinx.coroutines.internal.LockFreeLinkedListNode removeOrNext;
        kotlinx.coroutines.internal.LockFreeLinkedListHead lockFreeLinkedListHead = this.queue;
        while (true) {
            lockFreeLinkedListNode = (kotlinx.coroutines.internal.LockFreeLinkedListNode) lockFreeLinkedListHead.getNext();
            if (lockFreeLinkedListNode != lockFreeLinkedListHead && (lockFreeLinkedListNode instanceof kotlinx.coroutines.channels.Send)) {
                if (((((kotlinx.coroutines.channels.Send) lockFreeLinkedListNode) instanceof kotlinx.coroutines.channels.Closed) && !lockFreeLinkedListNode.isRemoved()) || (removeOrNext = lockFreeLinkedListNode.removeOrNext()) == null) {
                    break;
                }
                removeOrNext.helpRemovePrev();
            }
        }
        lockFreeLinkedListNode = null;
        return (kotlinx.coroutines.channels.Send) lockFreeLinkedListNode;
    }

    @org.jetbrains.annotations.NotNull
    public java.lang.String toString() {
        return kotlinx.coroutines.DebugStringsKt.getClassSimpleName(this) + '@' + kotlinx.coroutines.DebugStringsKt.getHexAddress(this) + '{' + b() + '}' + getBufferDebugString();
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    @org.jetbrains.annotations.NotNull
    /* renamed from: trySend-JP2dKIU, reason: not valid java name */
    public final java.lang.Object mo766trySendJP2dKIU(E element) {
        java.lang.Object offerInternal = offerInternal(element);
        if (offerInternal == kotlinx.coroutines.channels.AbstractChannelKt.OFFER_SUCCESS) {
            return kotlinx.coroutines.channels.ChannelResult.INSTANCE.m786successJP2dKIU(kotlin.Unit.INSTANCE);
        }
        if (offerInternal == kotlinx.coroutines.channels.AbstractChannelKt.OFFER_FAILED) {
            kotlinx.coroutines.channels.Closed<?> closedForSend = getClosedForSend();
            return closedForSend == null ? kotlinx.coroutines.channels.ChannelResult.INSTANCE.m785failurePtdJZtk() : kotlinx.coroutines.channels.ChannelResult.INSTANCE.m784closedJP2dKIU(e(closedForSend));
        }
        if (offerInternal instanceof kotlinx.coroutines.channels.Closed) {
            return kotlinx.coroutines.channels.ChannelResult.INSTANCE.m784closedJP2dKIU(e((kotlinx.coroutines.channels.Closed) offerInternal));
        }
        throw new java.lang.IllegalStateException(kotlin.jvm.internal.Intrinsics.stringPlus("trySend returned ", offerInternal).toString());
    }
}
