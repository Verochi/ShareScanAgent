package kotlinx.coroutines.channels;

@kotlin.Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0010\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B)\u0012 \u0010*\u001a\u001c\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u000f\u0018\u00010(j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`)¢\u0006\u0004\b+\u0010,J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00028\u0000H\u0014¢\u0006\u0004\b\u0005\u0010\u0006J#\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00028\u00002\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\u0007H\u0014¢\u0006\u0004\b\t\u0010\nJ\n\u0010\u000b\u001a\u0004\u0018\u00010\u0004H\u0014J\u0016\u0010\f\u001a\u0004\u0018\u00010\u00042\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\u0007H\u0014J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\rH\u0014J\u0016\u0010\u0013\u001a\u00020\r2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0011H\u0014J\u0014\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0002R\u0018\u0010\u001a\u001a\u00060\u0016j\u0002`\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001e\u001a\u00020\r8DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u0014\u0010 \u001a\u00020\r8DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b \u0010\u001fR\u0014\u0010!\u001a\u00020\r8DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\u001fR\u0014\u0010\"\u001a\u00020\r8DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010\u001fR\u0014\u0010#\u001a\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b#\u0010\u001fR\u0014\u0010'\u001a\u00020$8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b%\u0010&¨\u0006-"}, d2 = {"Lkotlinx/coroutines/channels/ConflatedChannel;", androidx.exifinterface.media.ExifInterface.LONGITUDE_EAST, "Lkotlinx/coroutines/channels/AbstractChannel;", "element", "", "offerInternal", "(Ljava/lang/Object;)Ljava/lang/Object;", "Lkotlinx/coroutines/selects/SelectInstance;", "select", "offerSelectInternal", "(Ljava/lang/Object;Lkotlinx/coroutines/selects/SelectInstance;)Ljava/lang/Object;", "pollInternal", "pollSelectInternal", "", "wasClosed", "", "onCancelIdempotent", "Lkotlinx/coroutines/channels/Receive;", "receive", "enqueueReceiveInternal", "Lkotlinx/coroutines/internal/UndeliveredElementException;", "q", "Ljava/util/concurrent/locks/ReentrantLock;", "Lkotlinx/coroutines/internal/ReentrantLock;", com.umeng.analytics.pro.bo.aN, "Ljava/util/concurrent/locks/ReentrantLock;", org.apache.tools.ant.taskdefs.optional.clearcase.ClearCase.COMMAND_LOCK, "v", "Ljava/lang/Object;", "value", "isBufferAlwaysEmpty", "()Z", "isBufferEmpty", "isBufferAlwaysFull", "isBufferFull", "isEmpty", "", "getBufferDebugString", "()Ljava/lang/String;", "bufferDebugString", "Lkotlin/Function1;", "Lkotlinx/coroutines/internal/OnUndeliveredElement;", "onUndeliveredElement", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes16.dex */
public class ConflatedChannel<E> extends kotlinx.coroutines.channels.AbstractChannel<E> {

    /* renamed from: u, reason: from kotlin metadata */
    @org.jetbrains.annotations.NotNull
    public final java.util.concurrent.locks.ReentrantLock lock;

    /* renamed from: v, reason: from kotlin metadata */
    @org.jetbrains.annotations.Nullable
    public java.lang.Object value;

    public ConflatedChannel(@org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function1<? super E, kotlin.Unit> function1) {
        super(function1);
        this.lock = new java.util.concurrent.locks.ReentrantLock();
        this.value = kotlinx.coroutines.channels.AbstractChannelKt.EMPTY;
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
    @org.jetbrains.annotations.NotNull
    public java.lang.String getBufferDebugString() {
        return "(value=" + this.value + ')';
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
        return this.value == kotlinx.coroutines.channels.AbstractChannelKt.EMPTY;
    }

    @Override // kotlinx.coroutines.channels.AbstractSendChannel
    public final boolean isBufferFull() {
        return false;
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
            kotlinx.coroutines.channels.Closed<?> closedForSend = getClosedForSend();
            if (closedForSend != null) {
                return closedForSend;
            }
            if (this.value == kotlinx.coroutines.channels.AbstractChannelKt.EMPTY) {
                do {
                    takeFirstReceiveOrPeekClosed = takeFirstReceiveOrPeekClosed();
                    if (takeFirstReceiveOrPeekClosed != null) {
                        if (takeFirstReceiveOrPeekClosed instanceof kotlinx.coroutines.channels.Closed) {
                            return takeFirstReceiveOrPeekClosed;
                        }
                    }
                } while (takeFirstReceiveOrPeekClosed.tryResumeReceive(element, null) == null);
                kotlin.Unit unit = kotlin.Unit.INSTANCE;
                reentrantLock.unlock();
                takeFirstReceiveOrPeekClosed.completeResumeReceive(element);
                return takeFirstReceiveOrPeekClosed.getOfferResult();
            }
            kotlinx.coroutines.internal.UndeliveredElementException q = q(element);
            if (q == null) {
                return kotlinx.coroutines.channels.AbstractChannelKt.OFFER_SUCCESS;
            }
            throw q;
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
            kotlinx.coroutines.channels.Closed<?> closedForSend = getClosedForSend();
            if (closedForSend != null) {
                return closedForSend;
            }
            if (this.value == kotlinx.coroutines.channels.AbstractChannelKt.EMPTY) {
                do {
                    kotlinx.coroutines.channels.AbstractSendChannel.TryOfferDesc<E> describeTryOffer = describeTryOffer(element);
                    performAtomicTrySelect = select.performAtomicTrySelect(describeTryOffer);
                    if (performAtomicTrySelect == null) {
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
                return performAtomicTrySelect;
            }
            if (!select.trySelect()) {
                return kotlinx.coroutines.selects.SelectKt.getALREADY_SELECTED();
            }
            kotlinx.coroutines.internal.UndeliveredElementException q = q(element);
            if (q == null) {
                return kotlinx.coroutines.channels.AbstractChannelKt.OFFER_SUCCESS;
            }
            throw q;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // kotlinx.coroutines.channels.AbstractChannel
    public void onCancelIdempotent(boolean wasClosed) {
        java.util.concurrent.locks.ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            kotlinx.coroutines.internal.UndeliveredElementException q = q(kotlinx.coroutines.channels.AbstractChannelKt.EMPTY);
            kotlin.Unit unit = kotlin.Unit.INSTANCE;
            reentrantLock.unlock();
            super.onCancelIdempotent(wasClosed);
            if (q != null) {
                throw q;
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
            java.lang.Object obj = this.value;
            kotlinx.coroutines.internal.Symbol symbol = kotlinx.coroutines.channels.AbstractChannelKt.EMPTY;
            if (obj != symbol) {
                this.value = symbol;
                kotlin.Unit unit = kotlin.Unit.INSTANCE;
                return obj;
            }
            java.lang.Object closedForSend = getClosedForSend();
            if (closedForSend == null) {
                closedForSend = kotlinx.coroutines.channels.AbstractChannelKt.POLL_FAILED;
            }
            return closedForSend;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // kotlinx.coroutines.channels.AbstractChannel
    @org.jetbrains.annotations.Nullable
    public java.lang.Object pollSelectInternal(@org.jetbrains.annotations.NotNull kotlinx.coroutines.selects.SelectInstance<?> select) {
        java.util.concurrent.locks.ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            java.lang.Object obj = this.value;
            kotlinx.coroutines.internal.Symbol symbol = kotlinx.coroutines.channels.AbstractChannelKt.EMPTY;
            if (obj == symbol) {
                java.lang.Object closedForSend = getClosedForSend();
                if (closedForSend == null) {
                    closedForSend = kotlinx.coroutines.channels.AbstractChannelKt.POLL_FAILED;
                }
                return closedForSend;
            }
            if (!select.trySelect()) {
                return kotlinx.coroutines.selects.SelectKt.getALREADY_SELECTED();
            }
            java.lang.Object obj2 = this.value;
            this.value = symbol;
            kotlin.Unit unit = kotlin.Unit.INSTANCE;
            return obj2;
        } finally {
            reentrantLock.unlock();
        }
    }

    public final kotlinx.coroutines.internal.UndeliveredElementException q(java.lang.Object element) {
        kotlin.jvm.functions.Function1<E, kotlin.Unit> function1;
        java.lang.Object obj = this.value;
        kotlinx.coroutines.internal.UndeliveredElementException undeliveredElementException = null;
        if (obj != kotlinx.coroutines.channels.AbstractChannelKt.EMPTY && (function1 = this.onUndeliveredElement) != null) {
            undeliveredElementException = kotlinx.coroutines.internal.OnUndeliveredElementKt.callUndeliveredElementCatchingException$default(function1, obj, null, 2, null);
        }
        this.value = element;
        return undeliveredElementException;
    }
}
