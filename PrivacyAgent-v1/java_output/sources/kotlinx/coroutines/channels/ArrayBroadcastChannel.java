package kotlinx.coroutines.channels;

@kotlin.Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0012\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\b\u0012\u0004\u0012\u00028\u00000\u0003:\u0001NB\u000f\u0012\u0006\u0010+\u001a\u00020'¢\u0006\u0004\bM\u0010KJ\u0015\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\f\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0017¢\u0006\u0004\b\f\u0010\u000bJ\u001f\u0010\f\u001a\u00020\u000f2\u000e\u0010\b\u001a\n\u0018\u00010\rj\u0004\u0018\u0001`\u000eH\u0016¢\u0006\u0004\b\f\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00028\u0000H\u0014¢\u0006\u0004\b\u0013\u0010\u0014J#\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00028\u00002\n\u0010\u0016\u001a\u0006\u0012\u0002\b\u00030\u0015H\u0014¢\u0006\u0004\b\u0017\u0010\u0018J\u0019\u0010\u0019\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0004\b\u0019\u0010\u000bJ\u000f\u0010\u001a\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ4\u0010\u001f\u001a\u00020\u000f2\u0010\b\u0002\u0010\u001d\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u001c2\u0010\b\u0002\u0010\u001e\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u001cH\u0082\u0010¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010\"\u001a\u00020!H\u0002¢\u0006\u0004\b\"\u0010#J\u0017\u0010%\u001a\u00028\u00002\u0006\u0010$\u001a\u00020!H\u0002¢\u0006\u0004\b%\u0010&R\u0017\u0010+\u001a\u00020'8\u0006¢\u0006\f\n\u0004\b\u001f\u0010(\u001a\u0004\b)\u0010*R\u0018\u00100\u001a\u00060,j\u0002`-8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b.\u0010/R\u001c\u00104\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u0012018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b2\u00103R0\u00109\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u001c05j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u001c`68\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b7\u00108R\u0014\u0010:\u001a\u00020\t8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b:\u0010;R\u0014\u0010<\u001a\u00020\t8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b<\u0010;R\u0014\u0010@\u001a\u00020=8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b>\u0010?R$\u0010E\u001a\u00020!2\u0006\u0010A\u001a\u00020!8B@BX\u0082\u000e¢\u0006\f\u001a\u0004\bB\u0010#\"\u0004\bC\u0010DR$\u0010H\u001a\u00020!2\u0006\u0010A\u001a\u00020!8B@BX\u0082\u000e¢\u0006\f\u001a\u0004\bF\u0010#\"\u0004\bG\u0010DR$\u0010L\u001a\u00020'2\u0006\u0010A\u001a\u00020'8B@BX\u0082\u000e¢\u0006\f\u001a\u0004\bI\u0010*\"\u0004\bJ\u0010K¨\u0006O"}, d2 = {"Lkotlinx/coroutines/channels/ArrayBroadcastChannel;", androidx.exifinterface.media.ExifInterface.LONGITUDE_EAST, "Lkotlinx/coroutines/channels/AbstractSendChannel;", "Lkotlinx/coroutines/channels/BroadcastChannel;", "Lkotlinx/coroutines/channels/ReceiveChannel;", "openSubscription", "()Lkotlinx/coroutines/channels/ReceiveChannel;", "", "cause", "", "close", "(Ljava/lang/Throwable;)Z", com.anythink.expressad.d.a.b.dO, "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "", "(Ljava/util/concurrent/CancellationException;)V", "element", "", "offerInternal", "(Ljava/lang/Object;)Ljava/lang/Object;", "Lkotlinx/coroutines/selects/SelectInstance;", "select", "offerSelectInternal", "(Ljava/lang/Object;Lkotlinx/coroutines/selects/SelectInstance;)Ljava/lang/Object;", "k", "l", "()V", "Lkotlinx/coroutines/channels/ArrayBroadcastChannel$Subscriber;", "addSub", "removeSub", com.umeng.analytics.pro.bo.aN, "(Lkotlinx/coroutines/channels/ArrayBroadcastChannel$Subscriber;Lkotlinx/coroutines/channels/ArrayBroadcastChannel$Subscriber;)V", "", com.anythink.expressad.d.a.b.dH, "()J", "index", com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.AD_COUNT, "(J)Ljava/lang/Object;", "", "I", "getCapacity", "()I", "capacity", "Ljava/util/concurrent/locks/ReentrantLock;", "Lkotlinx/coroutines/internal/ReentrantLock;", "v", "Ljava/util/concurrent/locks/ReentrantLock;", "bufferLock", "", com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.WIDTH, "[Ljava/lang/Object;", "buffer", "", "Lkotlinx/coroutines/internal/SubscribersList;", "x", "Ljava/util/List;", "subscribers", "isBufferAlwaysFull", "()Z", "isBufferFull", "", "getBufferDebugString", "()Ljava/lang/String;", "bufferDebugString", "value", "o", "r", "(J)V", com.ss.android.socialbase.downloader.constants.MonitorConstants.CONNECT_TYPE_HEAD, "q", "t", "tail", "p", "s", "(I)V", com.anythink.core.api.ATAdConst.NETWORK_REQUEST_PARAMS_KEY.BANNER_SIZE, "<init>", "Subscriber", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes16.dex */
public final class ArrayBroadcastChannel<E> extends kotlinx.coroutines.channels.AbstractSendChannel<E> implements kotlinx.coroutines.channels.BroadcastChannel<E> {

    @org.jetbrains.annotations.NotNull
    private volatile /* synthetic */ long _head;

    @org.jetbrains.annotations.NotNull
    private volatile /* synthetic */ int _size;

    @org.jetbrains.annotations.NotNull
    private volatile /* synthetic */ long _tail;

    /* renamed from: u, reason: from kotlin metadata */
    public final int capacity;

    /* renamed from: v, reason: from kotlin metadata */
    @org.jetbrains.annotations.NotNull
    public final java.util.concurrent.locks.ReentrantLock bufferLock;

    /* renamed from: w, reason: from kotlin metadata */
    @org.jetbrains.annotations.NotNull
    public final java.lang.Object[] buffer;

    /* renamed from: x, reason: from kotlin metadata */
    @org.jetbrains.annotations.NotNull
    public final java.util.List<kotlinx.coroutines.channels.ArrayBroadcastChannel.Subscriber<E>> subscribers;

    @kotlin.Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\f\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u00028\u00010\u00022\b\u0012\u0004\u0012\u00028\u00010\u0003B\u0015\u0012\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00010\u0014¢\u0006\u0004\b'\u0010(J\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u0011\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0014¢\u0006\u0004\b\f\u0010\rJ\u001d\u0010\u0010\u001a\u0004\u0018\u00010\u000b2\n\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\u000eH\u0014¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0012\u0010\nJ\u0011\u0010\u0013\u001a\u0004\u0018\u00010\u000bH\u0002¢\u0006\u0004\b\u0013\u0010\rR\u001a\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00010\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0018\u0010\u001c\u001a\u00060\u0018j\u0002`\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR$\u0010\"\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001d8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001f\u0010 \"\u0004\b\u0015\u0010!R\u0014\u0010#\u001a\u00020\u00068TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b#\u0010\nR\u0014\u0010$\u001a\u00020\u00068TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b$\u0010\nR\u0014\u0010%\u001a\u00020\u00068TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b%\u0010\nR\u0014\u0010&\u001a\u00020\u00068TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b&\u0010\n¨\u0006)"}, d2 = {"Lkotlinx/coroutines/channels/ArrayBroadcastChannel$Subscriber;", androidx.exifinterface.media.ExifInterface.LONGITUDE_EAST, "Lkotlinx/coroutines/channels/AbstractChannel;", "Lkotlinx/coroutines/channels/ReceiveChannel;", "", "cause", "", "close", "(Ljava/lang/Throwable;)Z", "q", "()Z", "", "pollInternal", "()Ljava/lang/Object;", "Lkotlinx/coroutines/selects/SelectInstance;", "select", "pollSelectInternal", "(Lkotlinx/coroutines/selects/SelectInstance;)Ljava/lang/Object;", "s", "t", "Lkotlinx/coroutines/channels/ArrayBroadcastChannel;", com.umeng.analytics.pro.bo.aN, "Lkotlinx/coroutines/channels/ArrayBroadcastChannel;", "broadcastChannel", "Ljava/util/concurrent/locks/ReentrantLock;", "Lkotlinx/coroutines/internal/ReentrantLock;", "v", "Ljava/util/concurrent/locks/ReentrantLock;", "subLock", "", "value", "r", "()J", "(J)V", "subHead", "isBufferAlwaysEmpty", "isBufferEmpty", "isBufferAlwaysFull", "isBufferFull", "<init>", "(Lkotlinx/coroutines/channels/ArrayBroadcastChannel;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1})
    public static final class Subscriber<E> extends kotlinx.coroutines.channels.AbstractChannel<E> implements kotlinx.coroutines.channels.ReceiveChannel<E> {

        @org.jetbrains.annotations.NotNull
        private volatile /* synthetic */ long _subHead;

        /* renamed from: u, reason: from kotlin metadata */
        @org.jetbrains.annotations.NotNull
        public final kotlinx.coroutines.channels.ArrayBroadcastChannel<E> broadcastChannel;

        /* renamed from: v, reason: from kotlin metadata */
        @org.jetbrains.annotations.NotNull
        public final java.util.concurrent.locks.ReentrantLock subLock;

        public Subscriber(@org.jetbrains.annotations.NotNull kotlinx.coroutines.channels.ArrayBroadcastChannel<E> arrayBroadcastChannel) {
            super(null);
            this.broadcastChannel = arrayBroadcastChannel;
            this.subLock = new java.util.concurrent.locks.ReentrantLock();
            this._subHead = 0L;
        }

        @Override // kotlinx.coroutines.channels.AbstractSendChannel, kotlinx.coroutines.channels.SendChannel
        /* renamed from: close */
        public boolean cancel(@org.jetbrains.annotations.Nullable java.lang.Throwable cause) {
            boolean cancel = super.cancel(cause);
            if (cancel) {
                kotlinx.coroutines.channels.ArrayBroadcastChannel.v(this.broadcastChannel, null, this, 1, null);
                java.util.concurrent.locks.ReentrantLock reentrantLock = this.subLock;
                reentrantLock.lock();
                try {
                    u(this.broadcastChannel.get_tail());
                    kotlin.Unit unit = kotlin.Unit.INSTANCE;
                } finally {
                    reentrantLock.unlock();
                }
            }
            return cancel;
        }

        @Override // kotlinx.coroutines.channels.AbstractChannel
        public boolean isBufferAlwaysEmpty() {
            return false;
        }

        @Override // kotlinx.coroutines.channels.AbstractSendChannel
        public boolean isBufferAlwaysFull() {
            throw new java.lang.IllegalStateException("Should not be used".toString());
        }

        @Override // kotlinx.coroutines.channels.AbstractChannel
        public boolean isBufferEmpty() {
            return get_subHead() >= this.broadcastChannel.get_tail();
        }

        @Override // kotlinx.coroutines.channels.AbstractSendChannel
        public boolean isBufferFull() {
            throw new java.lang.IllegalStateException("Should not be used".toString());
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x0030  */
        /* JADX WARN: Removed duplicated region for block: B:14:0x003c  */
        /* JADX WARN: Removed duplicated region for block: B:16:0x003f  */
        /* JADX WARN: Removed duplicated region for block: B:19:0x002c  */
        /* JADX WARN: Removed duplicated region for block: B:9:0x0028  */
        @Override // kotlinx.coroutines.channels.AbstractChannel
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public java.lang.Object pollInternal() {
            boolean z;
            kotlinx.coroutines.channels.Closed closed;
            java.util.concurrent.locks.ReentrantLock reentrantLock = this.subLock;
            reentrantLock.lock();
            try {
                java.lang.Object t = t();
                if (!(t instanceof kotlinx.coroutines.channels.Closed) && t != kotlinx.coroutines.channels.AbstractChannelKt.POLL_FAILED) {
                    u(get_subHead() + 1);
                    z = true;
                    reentrantLock.unlock();
                    closed = !(t instanceof kotlinx.coroutines.channels.Closed) ? (kotlinx.coroutines.channels.Closed) t : null;
                    if (closed != null) {
                        cancel(closed.closeCause);
                    }
                    if (q() ? true : z) {
                        kotlinx.coroutines.channels.ArrayBroadcastChannel.v(this.broadcastChannel, null, null, 3, null);
                    }
                    return t;
                }
                z = false;
                reentrantLock.unlock();
                if (!(t instanceof kotlinx.coroutines.channels.Closed)) {
                }
                if (closed != null) {
                }
                if (q() ? true : z) {
                }
                return t;
            } catch (java.lang.Throwable th) {
                reentrantLock.unlock();
                throw th;
            }
        }

        @Override // kotlinx.coroutines.channels.AbstractChannel
        @org.jetbrains.annotations.Nullable
        public java.lang.Object pollSelectInternal(@org.jetbrains.annotations.NotNull kotlinx.coroutines.selects.SelectInstance<?> select) {
            java.util.concurrent.locks.ReentrantLock reentrantLock = this.subLock;
            reentrantLock.lock();
            try {
                java.lang.Object t = t();
                boolean z = false;
                if (!(t instanceof kotlinx.coroutines.channels.Closed) && t != kotlinx.coroutines.channels.AbstractChannelKt.POLL_FAILED) {
                    if (select.trySelect()) {
                        u(get_subHead() + 1);
                        z = true;
                    } else {
                        t = kotlinx.coroutines.selects.SelectKt.getALREADY_SELECTED();
                    }
                }
                reentrantLock.unlock();
                kotlinx.coroutines.channels.Closed closed = t instanceof kotlinx.coroutines.channels.Closed ? (kotlinx.coroutines.channels.Closed) t : null;
                if (closed != null) {
                    cancel(closed.closeCause);
                }
                if (q() ? true : z) {
                    kotlinx.coroutines.channels.ArrayBroadcastChannel.v(this.broadcastChannel, null, null, 3, null);
                }
                return t;
            } catch (java.lang.Throwable th) {
                reentrantLock.unlock();
                throw th;
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:36:0x0023, code lost:
        
            r2 = (kotlinx.coroutines.channels.Closed) r1;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final boolean q() {
            kotlinx.coroutines.channels.Closed closed;
            boolean z = false;
            while (true) {
                closed = null;
                if (!s() || !this.subLock.tryLock()) {
                    break;
                }
                try {
                    java.lang.Object t = t();
                    if (t != kotlinx.coroutines.channels.AbstractChannelKt.POLL_FAILED) {
                        if (t instanceof kotlinx.coroutines.channels.Closed) {
                            break;
                        }
                        kotlinx.coroutines.channels.ReceiveOrClosed<E> takeFirstReceiveOrPeekClosed = takeFirstReceiveOrPeekClosed();
                        if (takeFirstReceiveOrPeekClosed != 0 && !(takeFirstReceiveOrPeekClosed instanceof kotlinx.coroutines.channels.Closed)) {
                            if (takeFirstReceiveOrPeekClosed.tryResumeReceive(t, null) != null) {
                                u(get_subHead() + 1);
                                this.subLock.unlock();
                                takeFirstReceiveOrPeekClosed.completeResumeReceive(t);
                                z = true;
                            }
                        }
                    }
                } finally {
                    this.subLock.unlock();
                }
            }
            if (closed != null) {
                cancel(closed.closeCause);
            }
            return z;
        }

        /* renamed from: r, reason: from getter */
        public final long get_subHead() {
            return this._subHead;
        }

        public final boolean s() {
            if (getClosedForReceive() != null) {
                return false;
            }
            return (isBufferEmpty() && this.broadcastChannel.getClosedForReceive() == null) ? false : true;
        }

        public final java.lang.Object t() {
            long j = get_subHead();
            kotlinx.coroutines.channels.Closed<?> closedForReceive = this.broadcastChannel.getClosedForReceive();
            if (j < this.broadcastChannel.get_tail()) {
                java.lang.Object n = this.broadcastChannel.n(j);
                kotlinx.coroutines.channels.Closed<?> closedForReceive2 = getClosedForReceive();
                return closedForReceive2 != null ? closedForReceive2 : n;
            }
            if (closedForReceive != null) {
                return closedForReceive;
            }
            kotlinx.coroutines.channels.Closed<?> closedForReceive3 = getClosedForReceive();
            return closedForReceive3 == null ? kotlinx.coroutines.channels.AbstractChannelKt.POLL_FAILED : closedForReceive3;
        }

        public final void u(long j) {
            this._subHead = j;
        }
    }

    public ArrayBroadcastChannel(int i) {
        super(null);
        this.capacity = i;
        if (!(i >= 1)) {
            throw new java.lang.IllegalArgumentException(("ArrayBroadcastChannel capacity must be at least 1, but " + getCapacity() + " was specified").toString());
        }
        this.bufferLock = new java.util.concurrent.locks.ReentrantLock();
        this.buffer = new java.lang.Object[i];
        this._head = 0L;
        this._tail = 0L;
        this._size = 0;
        this.subscribers = kotlinx.coroutines.internal.ConcurrentKt.subscriberList();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void v(kotlinx.coroutines.channels.ArrayBroadcastChannel arrayBroadcastChannel, kotlinx.coroutines.channels.ArrayBroadcastChannel.Subscriber subscriber, kotlinx.coroutines.channels.ArrayBroadcastChannel.Subscriber subscriber2, int i, java.lang.Object obj) {
        if ((i & 1) != 0) {
            subscriber = null;
        }
        if ((i & 2) != 0) {
            subscriber2 = null;
        }
        arrayBroadcastChannel.u(subscriber, subscriber2);
    }

    @Override // kotlinx.coroutines.channels.BroadcastChannel
    public void cancel(@org.jetbrains.annotations.Nullable java.util.concurrent.CancellationException cause) {
        cancel(cause);
    }

    @Override // kotlinx.coroutines.channels.AbstractSendChannel, kotlinx.coroutines.channels.SendChannel
    /* renamed from: close */
    public boolean cancel(@org.jetbrains.annotations.Nullable java.lang.Throwable cause) {
        if (!super.cancel(cause)) {
            return false;
        }
        l();
        return true;
    }

    @Override // kotlinx.coroutines.channels.AbstractSendChannel
    @org.jetbrains.annotations.NotNull
    public java.lang.String getBufferDebugString() {
        return "(buffer:capacity=" + this.buffer.length + ",size=" + get_size() + ')';
    }

    public final int getCapacity() {
        return this.capacity;
    }

    @Override // kotlinx.coroutines.channels.AbstractSendChannel
    public boolean isBufferAlwaysFull() {
        return false;
    }

    @Override // kotlinx.coroutines.channels.AbstractSendChannel
    public boolean isBufferFull() {
        return get_size() >= this.capacity;
    }

    @Override // kotlinx.coroutines.channels.BroadcastChannel
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public final boolean cancel(java.lang.Throwable cause) {
        boolean cancel = cancel(cause);
        java.util.Iterator<kotlinx.coroutines.channels.ArrayBroadcastChannel.Subscriber<E>> it = this.subscribers.iterator();
        while (it.hasNext()) {
            it.next().cancel(cause);
        }
        return cancel;
    }

    public final void l() {
        java.util.Iterator<kotlinx.coroutines.channels.ArrayBroadcastChannel.Subscriber<E>> it = this.subscribers.iterator();
        boolean z = false;
        boolean z2 = false;
        while (it.hasNext()) {
            if (it.next().q()) {
                z = true;
            }
            z2 = true;
        }
        if (z || !z2) {
            v(this, null, null, 3, null);
        }
    }

    public final long m() {
        java.util.Iterator<kotlinx.coroutines.channels.ArrayBroadcastChannel.Subscriber<E>> it = this.subscribers.iterator();
        long j = Long.MAX_VALUE;
        while (it.hasNext()) {
            j = kotlin.ranges.RangesKt___RangesKt.coerceAtMost(j, it.next().get_subHead());
        }
        return j;
    }

    public final E n(long index) {
        return (E) this.buffer[(int) (index % this.capacity)];
    }

    /* renamed from: o, reason: from getter */
    public final long get_head() {
        return this._head;
    }

    @Override // kotlinx.coroutines.channels.AbstractSendChannel
    @org.jetbrains.annotations.NotNull
    public java.lang.Object offerInternal(E element) {
        java.util.concurrent.locks.ReentrantLock reentrantLock = this.bufferLock;
        reentrantLock.lock();
        try {
            kotlinx.coroutines.channels.Closed<?> closedForSend = getClosedForSend();
            if (closedForSend != null) {
                return closedForSend;
            }
            int i = get_size();
            if (i >= getCapacity()) {
                return kotlinx.coroutines.channels.AbstractChannelKt.OFFER_FAILED;
            }
            long j = get_tail();
            this.buffer[(int) (j % getCapacity())] = element;
            s(i + 1);
            t(j + 1);
            kotlin.Unit unit = kotlin.Unit.INSTANCE;
            reentrantLock.unlock();
            l();
            return kotlinx.coroutines.channels.AbstractChannelKt.OFFER_SUCCESS;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // kotlinx.coroutines.channels.AbstractSendChannel
    @org.jetbrains.annotations.NotNull
    public java.lang.Object offerSelectInternal(E element, @org.jetbrains.annotations.NotNull kotlinx.coroutines.selects.SelectInstance<?> select) {
        java.util.concurrent.locks.ReentrantLock reentrantLock = this.bufferLock;
        reentrantLock.lock();
        try {
            kotlinx.coroutines.channels.Closed<?> closedForSend = getClosedForSend();
            if (closedForSend != null) {
                return closedForSend;
            }
            int i = get_size();
            if (i >= getCapacity()) {
                return kotlinx.coroutines.channels.AbstractChannelKt.OFFER_FAILED;
            }
            if (!select.trySelect()) {
                return kotlinx.coroutines.selects.SelectKt.getALREADY_SELECTED();
            }
            long j = get_tail();
            this.buffer[(int) (j % getCapacity())] = element;
            s(i + 1);
            t(j + 1);
            kotlin.Unit unit = kotlin.Unit.INSTANCE;
            reentrantLock.unlock();
            l();
            return kotlinx.coroutines.channels.AbstractChannelKt.OFFER_SUCCESS;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // kotlinx.coroutines.channels.BroadcastChannel
    @org.jetbrains.annotations.NotNull
    public kotlinx.coroutines.channels.ReceiveChannel<E> openSubscription() {
        kotlinx.coroutines.channels.ArrayBroadcastChannel.Subscriber subscriber = new kotlinx.coroutines.channels.ArrayBroadcastChannel.Subscriber(this);
        v(this, subscriber, null, 2, null);
        return subscriber;
    }

    /* renamed from: p, reason: from getter */
    public final int get_size() {
        return this._size;
    }

    /* renamed from: q, reason: from getter */
    public final long get_tail() {
        return this._tail;
    }

    public final void r(long j) {
        this._head = j;
    }

    public final void s(int i) {
        this._size = i;
    }

    public final void t(long j) {
        this._tail = j;
    }

    public final void u(kotlinx.coroutines.channels.ArrayBroadcastChannel.Subscriber<E> addSub, kotlinx.coroutines.channels.ArrayBroadcastChannel.Subscriber<E> removeSub) {
        long coerceAtMost;
        kotlinx.coroutines.channels.Send takeFirstSendOrPeekClosed;
        while (true) {
            java.util.concurrent.locks.ReentrantLock reentrantLock = this.bufferLock;
            reentrantLock.lock();
            if (addSub != null) {
                try {
                    addSub.u(get_tail());
                    boolean isEmpty = this.subscribers.isEmpty();
                    this.subscribers.add(addSub);
                    if (!isEmpty) {
                        return;
                    }
                } finally {
                    reentrantLock.unlock();
                }
            }
            if (removeSub != null) {
                this.subscribers.remove(removeSub);
                if (get_head() != removeSub.get_subHead()) {
                    return;
                }
            }
            long m = m();
            long j = get_tail();
            long j2 = get_head();
            coerceAtMost = kotlin.ranges.RangesKt___RangesKt.coerceAtMost(m, j);
            if (coerceAtMost <= j2) {
                return;
            }
            int i = get_size();
            while (j2 < coerceAtMost) {
                this.buffer[(int) (j2 % getCapacity())] = null;
                boolean z = i >= getCapacity();
                j2++;
                r(j2);
                i--;
                s(i);
                if (z) {
                    do {
                        takeFirstSendOrPeekClosed = takeFirstSendOrPeekClosed();
                        if (takeFirstSendOrPeekClosed != null && !(takeFirstSendOrPeekClosed instanceof kotlinx.coroutines.channels.Closed)) {
                        }
                    } while (takeFirstSendOrPeekClosed.tryResumeSend(null) == null);
                    this.buffer[(int) (j % getCapacity())] = takeFirstSendOrPeekClosed.getElement();
                    s(i + 1);
                    t(j + 1);
                    kotlin.Unit unit = kotlin.Unit.INSTANCE;
                    reentrantLock.unlock();
                    takeFirstSendOrPeekClosed.completeResumeSend();
                    l();
                    addSub = null;
                    removeSub = null;
                }
            }
            return;
        }
    }
}
