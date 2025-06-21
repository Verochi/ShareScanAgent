package kotlinx.coroutines.channels;

@kotlin.Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0010\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B9\u0012\u0006\u0010'\u001a\u00020\u001c\u0012\u0006\u0010+\u001a\u00020(\u0012 \u0010D\u001a\u001c\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0019\u0018\u00010Bj\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`C¢\u0006\u0004\bE\u0010FJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00028\u0000H\u0014¢\u0006\u0004\b\u0005\u0010\u0006J#\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00028\u00002\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\u0007H\u0014¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\r\u001a\u0004\u0018\u00010\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0014¢\u0006\u0004\b\r\u0010\u000eJ\u0011\u0010\u000f\u001a\u0004\u0018\u00010\u0004H\u0014¢\u0006\u0004\b\u000f\u0010\u0010J\u001d\u0010\u0011\u001a\u0004\u0018\u00010\u00042\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\u0007H\u0014¢\u0006\u0004\b\u0011\u0010\u0012J\u001d\u0010\u0016\u001a\u00020\u00152\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0013H\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\u0015H\u0014¢\u0006\u0004\b\u001a\u0010\u001bJ\u0019\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001d\u001a\u00020\u001cH\u0002¢\u0006\u0004\b\u001f\u0010 J\u001f\u0010!\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u0003\u001a\u00028\u0000H\u0002¢\u0006\u0004\b!\u0010\"J\u0017\u0010#\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u001cH\u0002¢\u0006\u0004\b#\u0010$R\u0014\u0010'\u001a\u00020\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u0014\u0010+\u001a\u00020(8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u0018\u00100\u001a\u00060,j\u0002`-8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b.\u0010/R\u001e\u00104\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u0004018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u00103R\u0016\u00106\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b5\u0010&R\u0014\u00107\u001a\u00020\u00158DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b7\u00108R\u0014\u00109\u001a\u00020\u00158DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b9\u00108R\u0014\u0010:\u001a\u00020\u00158DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b:\u00108R\u0014\u0010;\u001a\u00020\u00158DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b;\u00108R\u0014\u0010<\u001a\u00020\u00158VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b<\u00108R\u0014\u0010=\u001a\u00020\u00158VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b=\u00108R\u0014\u0010A\u001a\u00020>8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b?\u0010@¨\u0006G"}, d2 = {"Lkotlinx/coroutines/channels/ArrayChannel;", androidx.exifinterface.media.ExifInterface.LONGITUDE_EAST, "Lkotlinx/coroutines/channels/AbstractChannel;", "element", "", "offerInternal", "(Ljava/lang/Object;)Ljava/lang/Object;", "Lkotlinx/coroutines/selects/SelectInstance;", "select", "offerSelectInternal", "(Ljava/lang/Object;Lkotlinx/coroutines/selects/SelectInstance;)Ljava/lang/Object;", "Lkotlinx/coroutines/channels/Send;", "send", "enqueueSend", "(Lkotlinx/coroutines/channels/Send;)Ljava/lang/Object;", "pollInternal", "()Ljava/lang/Object;", "pollSelectInternal", "(Lkotlinx/coroutines/selects/SelectInstance;)Ljava/lang/Object;", "Lkotlinx/coroutines/channels/Receive;", "receive", "", "enqueueReceiveInternal", "(Lkotlinx/coroutines/channels/Receive;)Z", "wasClosed", "", "onCancelIdempotent", "(Z)V", "", "currentSize", "Lkotlinx/coroutines/internal/Symbol;", "s", "(I)Lkotlinx/coroutines/internal/Symbol;", "q", "(ILjava/lang/Object;)V", "r", "(I)V", com.umeng.analytics.pro.bo.aN, "I", "capacity", "Lkotlinx/coroutines/channels/BufferOverflow;", "v", "Lkotlinx/coroutines/channels/BufferOverflow;", "onBufferOverflow", "Ljava/util/concurrent/locks/ReentrantLock;", "Lkotlinx/coroutines/internal/ReentrantLock;", com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.WIDTH, "Ljava/util/concurrent/locks/ReentrantLock;", org.apache.tools.ant.taskdefs.optional.clearcase.ClearCase.COMMAND_LOCK, "", "x", "[Ljava/lang/Object;", "buffer", "y", com.ss.android.socialbase.downloader.constants.MonitorConstants.CONNECT_TYPE_HEAD, "isBufferAlwaysEmpty", "()Z", "isBufferEmpty", "isBufferAlwaysFull", "isBufferFull", "isEmpty", "isClosedForReceive", "", "getBufferDebugString", "()Ljava/lang/String;", "bufferDebugString", "Lkotlin/Function1;", "Lkotlinx/coroutines/internal/OnUndeliveredElement;", "onUndeliveredElement", "<init>", "(ILkotlinx/coroutines/channels/BufferOverflow;Lkotlin/jvm/functions/Function1;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes16.dex */
public class ArrayChannel<E> extends kotlinx.coroutines.channels.AbstractChannel<E> {

    @org.jetbrains.annotations.NotNull
    private volatile /* synthetic */ int size;

    /* renamed from: u, reason: from kotlin metadata */
    public final int capacity;

    /* renamed from: v, reason: from kotlin metadata */
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.channels.BufferOverflow onBufferOverflow;

    /* renamed from: w, reason: from kotlin metadata */
    @org.jetbrains.annotations.NotNull
    public final java.util.concurrent.locks.ReentrantLock lock;

    /* renamed from: x, reason: from kotlin metadata */
    @org.jetbrains.annotations.NotNull
    public java.lang.Object[] buffer;

    /* renamed from: y, reason: from kotlin metadata */
    public int head;

    @kotlin.Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[kotlinx.coroutines.channels.BufferOverflow.valuesCustom().length];
            iArr[kotlinx.coroutines.channels.BufferOverflow.SUSPEND.ordinal()] = 1;
            iArr[kotlinx.coroutines.channels.BufferOverflow.DROP_LATEST.ordinal()] = 2;
            iArr[kotlinx.coroutines.channels.BufferOverflow.DROP_OLDEST.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public ArrayChannel(int i, @org.jetbrains.annotations.NotNull kotlinx.coroutines.channels.BufferOverflow bufferOverflow, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function1<? super E, kotlin.Unit> function1) {
        super(function1);
        this.capacity = i;
        this.onBufferOverflow = bufferOverflow;
        if (!(i >= 1)) {
            throw new java.lang.IllegalArgumentException(("ArrayChannel capacity must be at least 1, but " + i + " was specified").toString());
        }
        this.lock = new java.util.concurrent.locks.ReentrantLock();
        java.lang.Object[] objArr = new java.lang.Object[java.lang.Math.min(i, 8)];
        kotlin.collections.ArraysKt___ArraysJvmKt.fill$default(objArr, kotlinx.coroutines.channels.AbstractChannelKt.EMPTY, 0, 0, 6, (java.lang.Object) null);
        kotlin.Unit unit = kotlin.Unit.INSTANCE;
        this.buffer = objArr;
        this.size = 0;
    }

    @Override // kotlinx.coroutines.channels.AbstractChannel
    public boolean enqueueReceiveInternal(@org.jetbrains.annotations.NotNull kotlinx.coroutines.channels.Receive<? super E> receive) {
        java.util.concurrent.locks.ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            return super.enqueueReceiveInternal(receive);
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // kotlinx.coroutines.channels.AbstractSendChannel
    @org.jetbrains.annotations.Nullable
    public java.lang.Object enqueueSend(@org.jetbrains.annotations.NotNull kotlinx.coroutines.channels.Send send) {
        java.util.concurrent.locks.ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            return super.enqueueSend(send);
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // kotlinx.coroutines.channels.AbstractSendChannel
    @org.jetbrains.annotations.NotNull
    public java.lang.String getBufferDebugString() {
        return "(buffer:capacity=" + this.capacity + ",size=" + this.size + ')';
    }

    @Override // kotlinx.coroutines.channels.AbstractChannel
    public final boolean isBufferAlwaysEmpty() {
        return false;
    }

    @Override // kotlinx.coroutines.channels.AbstractSendChannel
    public final boolean isBufferAlwaysFull() {
        return false;
    }

    @Override // kotlinx.coroutines.channels.AbstractChannel
    public final boolean isBufferEmpty() {
        return this.size == 0;
    }

    @Override // kotlinx.coroutines.channels.AbstractSendChannel
    public final boolean isBufferFull() {
        return this.size == this.capacity && this.onBufferOverflow == kotlinx.coroutines.channels.BufferOverflow.SUSPEND;
    }

    @Override // kotlinx.coroutines.channels.AbstractChannel, kotlinx.coroutines.channels.ReceiveChannel
    public boolean isClosedForReceive() {
        java.util.concurrent.locks.ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            return super.isClosedForReceive();
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // kotlinx.coroutines.channels.AbstractChannel, kotlinx.coroutines.channels.ReceiveChannel
    public boolean isEmpty() {
        java.util.concurrent.locks.ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            return isEmptyImpl();
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // kotlinx.coroutines.channels.AbstractSendChannel
    @org.jetbrains.annotations.NotNull
    public java.lang.Object offerInternal(E element) {
        kotlinx.coroutines.channels.ReceiveOrClosed<E> takeFirstReceiveOrPeekClosed;
        java.util.concurrent.locks.ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            int i = this.size;
            kotlinx.coroutines.channels.Closed<?> closedForSend = getClosedForSend();
            if (closedForSend != null) {
                return closedForSend;
            }
            kotlinx.coroutines.internal.Symbol s2 = s(i);
            if (s2 != null) {
                return s2;
            }
            if (i == 0) {
                do {
                    takeFirstReceiveOrPeekClosed = takeFirstReceiveOrPeekClosed();
                    if (takeFirstReceiveOrPeekClosed != null) {
                        if (takeFirstReceiveOrPeekClosed instanceof kotlinx.coroutines.channels.Closed) {
                            this.size = i;
                            return takeFirstReceiveOrPeekClosed;
                        }
                    }
                } while (takeFirstReceiveOrPeekClosed.tryResumeReceive(element, null) == null);
                this.size = i;
                kotlin.Unit unit = kotlin.Unit.INSTANCE;
                reentrantLock.unlock();
                takeFirstReceiveOrPeekClosed.completeResumeReceive(element);
                return takeFirstReceiveOrPeekClosed.getOfferResult();
            }
            q(i, element);
            return kotlinx.coroutines.channels.AbstractChannelKt.OFFER_SUCCESS;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // kotlinx.coroutines.channels.AbstractSendChannel
    @org.jetbrains.annotations.NotNull
    public java.lang.Object offerSelectInternal(E element, @org.jetbrains.annotations.NotNull kotlinx.coroutines.selects.SelectInstance<?> select) {
        java.lang.Object performAtomicTrySelect;
        java.util.concurrent.locks.ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            int i = this.size;
            kotlinx.coroutines.channels.Closed<?> closedForSend = getClosedForSend();
            if (closedForSend != null) {
                return closedForSend;
            }
            kotlinx.coroutines.internal.Symbol s2 = s(i);
            if (s2 != null) {
                return s2;
            }
            if (i == 0) {
                do {
                    kotlinx.coroutines.channels.AbstractSendChannel.TryOfferDesc<E> describeTryOffer = describeTryOffer(element);
                    performAtomicTrySelect = select.performAtomicTrySelect(describeTryOffer);
                    if (performAtomicTrySelect == null) {
                        this.size = i;
                        kotlinx.coroutines.channels.ReceiveOrClosed<? super E> result = describeTryOffer.getResult();
                        kotlin.Unit unit = kotlin.Unit.INSTANCE;
                        reentrantLock.unlock();
                        kotlin.jvm.internal.Intrinsics.checkNotNull(result);
                        kotlinx.coroutines.channels.ReceiveOrClosed<? super E> receiveOrClosed = result;
                        receiveOrClosed.completeResumeReceive(element);
                        return receiveOrClosed.getOfferResult();
                    }
                    if (performAtomicTrySelect == kotlinx.coroutines.channels.AbstractChannelKt.OFFER_FAILED) {
                    }
                } while (performAtomicTrySelect == kotlinx.coroutines.internal.AtomicKt.RETRY_ATOMIC);
                if (performAtomicTrySelect != kotlinx.coroutines.selects.SelectKt.getALREADY_SELECTED() && !(performAtomicTrySelect instanceof kotlinx.coroutines.channels.Closed)) {
                    throw new java.lang.IllegalStateException(kotlin.jvm.internal.Intrinsics.stringPlus("performAtomicTrySelect(describeTryOffer) returned ", performAtomicTrySelect).toString());
                }
                this.size = i;
                return performAtomicTrySelect;
            }
            if (select.trySelect()) {
                q(i, element);
                return kotlinx.coroutines.channels.AbstractChannelKt.OFFER_SUCCESS;
            }
            this.size = i;
            return kotlinx.coroutines.selects.SelectKt.getALREADY_SELECTED();
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // kotlinx.coroutines.channels.AbstractChannel
    public void onCancelIdempotent(boolean wasClosed) {
        kotlin.jvm.functions.Function1<E, kotlin.Unit> function1 = this.onUndeliveredElement;
        java.util.concurrent.locks.ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            int i = this.size;
            kotlinx.coroutines.internal.UndeliveredElementException undeliveredElementException = null;
            for (int i2 = 0; i2 < i; i2++) {
                java.lang.Object obj = this.buffer[this.head];
                if (function1 != null && obj != kotlinx.coroutines.channels.AbstractChannelKt.EMPTY) {
                    undeliveredElementException = kotlinx.coroutines.internal.OnUndeliveredElementKt.callUndeliveredElementCatchingException(function1, obj, undeliveredElementException);
                }
                java.lang.Object[] objArr = this.buffer;
                int i3 = this.head;
                objArr[i3] = kotlinx.coroutines.channels.AbstractChannelKt.EMPTY;
                this.head = (i3 + 1) % objArr.length;
            }
            this.size = 0;
            kotlin.Unit unit = kotlin.Unit.INSTANCE;
            reentrantLock.unlock();
            super.onCancelIdempotent(wasClosed);
            if (undeliveredElementException != null) {
                throw undeliveredElementException;
            }
        } catch (java.lang.Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    @Override // kotlinx.coroutines.channels.AbstractChannel
    @org.jetbrains.annotations.Nullable
    public java.lang.Object pollInternal() {
        java.util.concurrent.locks.ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            int i = this.size;
            if (i == 0) {
                java.lang.Object closedForSend = getClosedForSend();
                if (closedForSend == null) {
                    closedForSend = kotlinx.coroutines.channels.AbstractChannelKt.POLL_FAILED;
                }
                return closedForSend;
            }
            java.lang.Object[] objArr = this.buffer;
            int i2 = this.head;
            java.lang.Object obj = objArr[i2];
            kotlinx.coroutines.channels.Send send = null;
            objArr[i2] = null;
            this.size = i - 1;
            java.lang.Object obj2 = kotlinx.coroutines.channels.AbstractChannelKt.POLL_FAILED;
            boolean z = false;
            if (i == this.capacity) {
                kotlinx.coroutines.channels.Send send2 = null;
                while (true) {
                    kotlinx.coroutines.channels.Send takeFirstSendOrPeekClosed = takeFirstSendOrPeekClosed();
                    if (takeFirstSendOrPeekClosed == null) {
                        send = send2;
                        break;
                    }
                    if (takeFirstSendOrPeekClosed.tryResumeSend(null) != null) {
                        obj2 = takeFirstSendOrPeekClosed.getElement();
                        send = takeFirstSendOrPeekClosed;
                        z = true;
                        break;
                    }
                    takeFirstSendOrPeekClosed.undeliveredElement();
                    send2 = takeFirstSendOrPeekClosed;
                }
            }
            if (obj2 != kotlinx.coroutines.channels.AbstractChannelKt.POLL_FAILED && !(obj2 instanceof kotlinx.coroutines.channels.Closed)) {
                this.size = i;
                java.lang.Object[] objArr2 = this.buffer;
                objArr2[(this.head + i) % objArr2.length] = obj2;
            }
            this.head = (this.head + 1) % this.buffer.length;
            kotlin.Unit unit = kotlin.Unit.INSTANCE;
            if (z) {
                kotlin.jvm.internal.Intrinsics.checkNotNull(send);
                send.completeResumeSend();
            }
            return obj;
        } finally {
            reentrantLock.unlock();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0091 A[Catch: all -> 0x00ba, TRY_LEAVE, TryCatch #0 {all -> 0x00ba, blocks: (B:3:0x0005, B:5:0x0009, B:7:0x000f, B:11:0x0015, B:13:0x0029, B:50:0x0033, B:30:0x0077, B:32:0x007b, B:34:0x007f, B:35:0x00a1, B:40:0x008b, B:42:0x0091, B:15:0x0043, B:17:0x0048, B:21:0x004d, B:23:0x0053, B:26:0x005f, B:45:0x0066, B:46:0x0075), top: B:2:0x0005 }] */
    @Override // kotlinx.coroutines.channels.AbstractChannel
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public java.lang.Object pollSelectInternal(@org.jetbrains.annotations.NotNull kotlinx.coroutines.selects.SelectInstance<?> select) {
        boolean z;
        java.util.concurrent.locks.ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            int i = this.size;
            if (i == 0) {
                java.lang.Object closedForSend = getClosedForSend();
                if (closedForSend == null) {
                    closedForSend = kotlinx.coroutines.channels.AbstractChannelKt.POLL_FAILED;
                }
                return closedForSend;
            }
            java.lang.Object[] objArr = this.buffer;
            int i2 = this.head;
            java.lang.Object obj = objArr[i2];
            java.lang.Object obj2 = null;
            objArr[i2] = null;
            this.size = i - 1;
            java.lang.Object obj3 = kotlinx.coroutines.channels.AbstractChannelKt.POLL_FAILED;
            if (i == this.capacity) {
                while (true) {
                    kotlinx.coroutines.channels.AbstractChannel.TryPollDesc<E> describeTryPoll = describeTryPoll();
                    java.lang.Object performAtomicTrySelect = select.performAtomicTrySelect(describeTryPoll);
                    if (performAtomicTrySelect == null) {
                        obj2 = describeTryPoll.getResult();
                        kotlin.jvm.internal.Intrinsics.checkNotNull(obj2);
                        obj3 = ((kotlinx.coroutines.channels.Send) obj2).getElement();
                        break;
                    }
                    if (performAtomicTrySelect == kotlinx.coroutines.channels.AbstractChannelKt.POLL_FAILED) {
                        break;
                    }
                    if (performAtomicTrySelect != kotlinx.coroutines.internal.AtomicKt.RETRY_ATOMIC) {
                        if (performAtomicTrySelect == kotlinx.coroutines.selects.SelectKt.getALREADY_SELECTED()) {
                            this.size = i;
                            this.buffer[this.head] = obj;
                            return performAtomicTrySelect;
                        }
                        if (!(performAtomicTrySelect instanceof kotlinx.coroutines.channels.Closed)) {
                            throw new java.lang.IllegalStateException(kotlin.jvm.internal.Intrinsics.stringPlus("performAtomicTrySelect(describeTryOffer) returned ", performAtomicTrySelect).toString());
                        }
                        obj3 = performAtomicTrySelect;
                        obj2 = obj3;
                    }
                }
                z = true;
                if (obj3 == kotlinx.coroutines.channels.AbstractChannelKt.POLL_FAILED && !(obj3 instanceof kotlinx.coroutines.channels.Closed)) {
                    this.size = i;
                    java.lang.Object[] objArr2 = this.buffer;
                    objArr2[(this.head + i) % objArr2.length] = obj3;
                } else if (!select.trySelect()) {
                    this.size = i;
                    this.buffer[this.head] = obj;
                    return kotlinx.coroutines.selects.SelectKt.getALREADY_SELECTED();
                }
                this.head = (this.head + 1) % this.buffer.length;
                kotlin.Unit unit = kotlin.Unit.INSTANCE;
                if (z) {
                    kotlin.jvm.internal.Intrinsics.checkNotNull(obj2);
                    ((kotlinx.coroutines.channels.Send) obj2).completeResumeSend();
                }
                return obj;
            }
            z = false;
            if (obj3 == kotlinx.coroutines.channels.AbstractChannelKt.POLL_FAILED) {
            }
            if (!select.trySelect()) {
            }
            this.head = (this.head + 1) % this.buffer.length;
            kotlin.Unit unit2 = kotlin.Unit.INSTANCE;
            if (z) {
            }
            return obj;
        } finally {
            reentrantLock.unlock();
        }
    }

    public final void q(int currentSize, E element) {
        if (currentSize < this.capacity) {
            r(currentSize);
            java.lang.Object[] objArr = this.buffer;
            objArr[(this.head + currentSize) % objArr.length] = element;
        } else {
            java.lang.Object[] objArr2 = this.buffer;
            int i = this.head;
            objArr2[i % objArr2.length] = null;
            objArr2[(currentSize + i) % objArr2.length] = element;
            this.head = (i + 1) % objArr2.length;
        }
    }

    public final void r(int currentSize) {
        java.lang.Object[] objArr = this.buffer;
        if (currentSize >= objArr.length) {
            int min = java.lang.Math.min(objArr.length * 2, this.capacity);
            java.lang.Object[] objArr2 = new java.lang.Object[min];
            if (currentSize > 0) {
                int i = 0;
                while (true) {
                    int i2 = i + 1;
                    java.lang.Object[] objArr3 = this.buffer;
                    objArr2[i] = objArr3[(this.head + i) % objArr3.length];
                    if (i2 >= currentSize) {
                        break;
                    } else {
                        i = i2;
                    }
                }
            }
            kotlin.collections.ArraysKt___ArraysJvmKt.fill((kotlinx.coroutines.internal.Symbol[]) objArr2, kotlinx.coroutines.channels.AbstractChannelKt.EMPTY, currentSize, min);
            this.buffer = objArr2;
            this.head = 0;
        }
    }

    public final kotlinx.coroutines.internal.Symbol s(int currentSize) {
        if (currentSize < this.capacity) {
            this.size = currentSize + 1;
            return null;
        }
        int i = kotlinx.coroutines.channels.ArrayChannel.WhenMappings.$EnumSwitchMapping$0[this.onBufferOverflow.ordinal()];
        if (i == 1) {
            return kotlinx.coroutines.channels.AbstractChannelKt.OFFER_FAILED;
        }
        if (i == 2) {
            return kotlinx.coroutines.channels.AbstractChannelKt.OFFER_SUCCESS;
        }
        if (i == 3) {
            return null;
        }
        throw new kotlin.NoWhenBranchMatchedException();
    }
}
