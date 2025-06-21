package kotlinx.coroutines.channels;

@kotlinx.coroutines.ObsoleteCoroutinesApi
@kotlin.Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0007\u0018\u0000 C*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002:\u0004DEFGB\u0007¢\u0006\u0004\bA\u00107B\u0011\b\u0016\u0012\u0006\u00108\u001a\u00028\u0000¢\u0006\u0004\bA\u0010BJ\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0019\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ)\u0010\u000f\u001a\u00020\f2\u0018\u0010\u000e\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0004\u0012\u00020\f0\u000bj\u0002`\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0019\u0010\u0011\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0017¢\u0006\u0004\b\u0011\u0010\nJ\u001f\u0010\u0011\u001a\u00020\f2\u000e\u0010\u0007\u001a\n\u0018\u00010\u0012j\u0004\u0018\u0001`\u0013H\u0016¢\u0006\u0004\b\u0011\u0010\u0014J\u001b\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00028\u0000H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017J&\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\f0\u00182\u0006\u0010\u0015\u001a\u00028\u0000H\u0016ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u001d\u0010\u001e\u001a\u00020\f2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00028\u00000\u001cH\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ?\u0010\"\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u001c0 2\u0014\u0010!\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u001c\u0018\u00010 2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00028\u00000\u001cH\u0002¢\u0006\u0004\b\"\u0010#J?\u0010$\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u001c\u0018\u00010 2\u0012\u0010!\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u001c0 2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00028\u00000\u001cH\u0002¢\u0006\u0004\b$\u0010#J\u0019\u0010%\u001a\u00020\f2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b%\u0010&J\u0019\u0010(\u001a\u0004\u0018\u00010'2\u0006\u0010\u0015\u001a\u00028\u0000H\u0002¢\u0006\u0004\b(\u0010)JX\u00102\u001a\u00020\f\"\u0004\b\u0001\u0010*2\f\u0010,\u001a\b\u0012\u0004\u0012\u00028\u00010+2\u0006\u0010\u0015\u001a\u00028\u00002(\u00101\u001a$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000.\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010/\u0012\u0006\u0012\u0004\u0018\u0001000-H\u0002ø\u0001\u0000¢\u0006\u0004\b2\u00103R\u0017\u00108\u001a\u00028\u00008F¢\u0006\f\u0012\u0004\b6\u00107\u001a\u0004\b4\u00105R\u0013\u0010:\u001a\u0004\u0018\u00018\u00008F¢\u0006\u0006\u001a\u0004\b9\u00105R\u0014\u0010;\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b;\u0010<R&\u0010@\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000.0=8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b>\u0010?\u0082\u0002\u000f\n\u0002\b\u0019\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006H"}, d2 = {"Lkotlinx/coroutines/channels/ConflatedBroadcastChannel;", androidx.exifinterface.media.ExifInterface.LONGITUDE_EAST, "Lkotlinx/coroutines/channels/BroadcastChannel;", "Lkotlinx/coroutines/channels/ReceiveChannel;", "openSubscription", "()Lkotlinx/coroutines/channels/ReceiveChannel;", "", "cause", "", "close", "(Ljava/lang/Throwable;)Z", "Lkotlin/Function1;", "", "Lkotlinx/coroutines/channels/Handler;", "handler", "invokeOnClose", "(Lkotlin/jvm/functions/Function1;)V", com.anythink.expressad.d.a.b.dO, "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "(Ljava/util/concurrent/CancellationException;)V", "element", "send", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/channels/ChannelResult;", "trySend-JP2dKIU", "(Ljava/lang/Object;)Ljava/lang/Object;", "trySend", "Lkotlinx/coroutines/channels/ConflatedBroadcastChannel$Subscriber;", "subscriber", "b", "(Lkotlinx/coroutines/channels/ConflatedBroadcastChannel$Subscriber;)V", "", org.apache.tools.ant.taskdefs.optional.j2ee.HotDeploymentTool.ACTION_LIST, "a", "([Lkotlinx/coroutines/channels/ConflatedBroadcastChannel$Subscriber;Lkotlinx/coroutines/channels/ConflatedBroadcastChannel$Subscriber;)[Lkotlinx/coroutines/channels/ConflatedBroadcastChannel$Subscriber;", "f", "c", "(Ljava/lang/Throwable;)V", "Lkotlinx/coroutines/channels/ConflatedBroadcastChannel$Closed;", "d", "(Ljava/lang/Object;)Lkotlinx/coroutines/channels/ConflatedBroadcastChannel$Closed;", "R", "Lkotlinx/coroutines/selects/SelectInstance;", "select", "Lkotlin/Function2;", "Lkotlinx/coroutines/channels/SendChannel;", "Lkotlin/coroutines/Continuation;", "", "block", "e", "(Lkotlinx/coroutines/selects/SelectInstance;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", "getValue", "()Ljava/lang/Object;", "getValue$annotations", "()V", "value", "getValueOrNull", "valueOrNull", "isClosedForSend", "()Z", "Lkotlinx/coroutines/selects/SelectClause2;", "getOnSend", "()Lkotlinx/coroutines/selects/SelectClause2;", "onSend", "<init>", "(Ljava/lang/Object;)V", com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.AD_COUNT, "Closed", "Companion", "State", "Subscriber", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes16.dex */
public final class ConflatedBroadcastChannel<E> implements kotlinx.coroutines.channels.BroadcastChannel<E> {
    public static final /* synthetic */ java.util.concurrent.atomic.AtomicReferenceFieldUpdater t;
    public static final /* synthetic */ java.util.concurrent.atomic.AtomicIntegerFieldUpdater u;
    public static final /* synthetic */ java.util.concurrent.atomic.AtomicReferenceFieldUpdater v;

    @java.lang.Deprecated
    @org.jetbrains.annotations.NotNull
    public static final kotlinx.coroutines.internal.Symbol x;

    @java.lang.Deprecated
    @org.jetbrains.annotations.NotNull
    public static final kotlinx.coroutines.channels.ConflatedBroadcastChannel.State<java.lang.Object> y;

    @org.jetbrains.annotations.NotNull
    private volatile /* synthetic */ java.lang.Object _state;

    @org.jetbrains.annotations.NotNull
    private volatile /* synthetic */ int _updating;

    @org.jetbrains.annotations.NotNull
    private volatile /* synthetic */ java.lang.Object onCloseHandler;

    @java.lang.Deprecated
    @org.jetbrains.annotations.NotNull
    public static final kotlinx.coroutines.channels.ConflatedBroadcastChannel.Closed w = new kotlinx.coroutines.channels.ConflatedBroadcastChannel.Closed(null);

    @kotlin.Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0003\n\u0002\b\n\b\u0002\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0011\u0010\u0007\u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0006R\u0011\u0010\t\u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\b\u0010\u0006¨\u0006\f"}, d2 = {"Lkotlinx/coroutines/channels/ConflatedBroadcastChannel$Closed;", "", "", "a", "Ljava/lang/Throwable;", "closeCause", "()Ljava/lang/Throwable;", "sendException", "b", "valueException", "<init>", "(Ljava/lang/Throwable;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1})
    public static final class Closed {

        /* renamed from: a, reason: from kotlin metadata */
        @kotlin.jvm.JvmField
        @org.jetbrains.annotations.Nullable
        public final java.lang.Throwable closeCause;

        public Closed(@org.jetbrains.annotations.Nullable java.lang.Throwable th) {
            this.closeCause = th;
        }

        @org.jetbrains.annotations.NotNull
        public final java.lang.Throwable a() {
            java.lang.Throwable th = this.closeCause;
            return th == null ? new kotlinx.coroutines.channels.ClosedSendChannelException(kotlinx.coroutines.channels.ChannelsKt.DEFAULT_CLOSE_MESSAGE) : th;
        }

        @org.jetbrains.annotations.NotNull
        public final java.lang.Throwable b() {
            java.lang.Throwable th = this.closeCause;
            return th == null ? new java.lang.IllegalStateException(kotlinx.coroutines.channels.ChannelsKt.DEFAULT_CLOSE_MESSAGE) : th;
        }
    }

    @kotlin.Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u00012\u00020\u0002B'\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\u0014\u0010\n\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0007\u0018\u00010\u0006¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\"\u0010\n\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0007\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lkotlinx/coroutines/channels/ConflatedBroadcastChannel$State;", androidx.exifinterface.media.ExifInterface.LONGITUDE_EAST, "", "a", "Ljava/lang/Object;", "value", "", "Lkotlinx/coroutines/channels/ConflatedBroadcastChannel$Subscriber;", "b", "[Lkotlinx/coroutines/channels/ConflatedBroadcastChannel$Subscriber;", "subscribers", "<init>", "(Ljava/lang/Object;[Lkotlinx/coroutines/channels/ConflatedBroadcastChannel$Subscriber;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1})
    public static final class State<E> {

        /* renamed from: a, reason: from kotlin metadata */
        @kotlin.jvm.JvmField
        @org.jetbrains.annotations.Nullable
        public final java.lang.Object value;

        /* renamed from: b, reason: from kotlin metadata */
        @kotlin.jvm.JvmField
        @org.jetbrains.annotations.Nullable
        public final kotlinx.coroutines.channels.ConflatedBroadcastChannel.Subscriber<E>[] subscribers;

        public State(@org.jetbrains.annotations.Nullable java.lang.Object obj, @org.jetbrains.annotations.Nullable kotlinx.coroutines.channels.ConflatedBroadcastChannel.Subscriber<E>[] subscriberArr) {
            this.value = obj;
            this.subscribers = subscriberArr;
        }
    }

    @kotlin.Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u00028\u00010\u00022\b\u0012\u0004\u0012\u00028\u00010\u0003B\u0015\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00010\f¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0014J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00028\u0001H\u0016¢\u0006\u0004\b\n\u0010\u000bR\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00010\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lkotlinx/coroutines/channels/ConflatedBroadcastChannel$Subscriber;", androidx.exifinterface.media.ExifInterface.LONGITUDE_EAST, "Lkotlinx/coroutines/channels/ConflatedChannel;", "Lkotlinx/coroutines/channels/ReceiveChannel;", "", "wasClosed", "", "onCancelIdempotent", "element", "", "offerInternal", "(Ljava/lang/Object;)Ljava/lang/Object;", "Lkotlinx/coroutines/channels/ConflatedBroadcastChannel;", com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.WIDTH, "Lkotlinx/coroutines/channels/ConflatedBroadcastChannel;", "broadcastChannel", "<init>", "(Lkotlinx/coroutines/channels/ConflatedBroadcastChannel;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1})
    public static final class Subscriber<E> extends kotlinx.coroutines.channels.ConflatedChannel<E> implements kotlinx.coroutines.channels.ReceiveChannel<E> {

        /* renamed from: w, reason: from kotlin metadata */
        @org.jetbrains.annotations.NotNull
        public final kotlinx.coroutines.channels.ConflatedBroadcastChannel<E> broadcastChannel;

        public Subscriber(@org.jetbrains.annotations.NotNull kotlinx.coroutines.channels.ConflatedBroadcastChannel<E> conflatedBroadcastChannel) {
            super(null);
            this.broadcastChannel = conflatedBroadcastChannel;
        }

        @Override // kotlinx.coroutines.channels.ConflatedChannel, kotlinx.coroutines.channels.AbstractSendChannel
        @org.jetbrains.annotations.NotNull
        public java.lang.Object offerInternal(E element) {
            return super.offerInternal(element);
        }

        @Override // kotlinx.coroutines.channels.ConflatedChannel, kotlinx.coroutines.channels.AbstractChannel
        public void onCancelIdempotent(boolean wasClosed) {
            if (wasClosed) {
                this.broadcastChannel.b(this);
            }
        }
    }

    static {
        kotlinx.coroutines.internal.Symbol symbol = new kotlinx.coroutines.internal.Symbol("UNDEFINED");
        x = symbol;
        y = new kotlinx.coroutines.channels.ConflatedBroadcastChannel.State<>(symbol, null);
        t = java.util.concurrent.atomic.AtomicReferenceFieldUpdater.newUpdater(kotlinx.coroutines.channels.ConflatedBroadcastChannel.class, java.lang.Object.class, "_state");
        u = java.util.concurrent.atomic.AtomicIntegerFieldUpdater.newUpdater(kotlinx.coroutines.channels.ConflatedBroadcastChannel.class, "_updating");
        v = java.util.concurrent.atomic.AtomicReferenceFieldUpdater.newUpdater(kotlinx.coroutines.channels.ConflatedBroadcastChannel.class, java.lang.Object.class, "onCloseHandler");
    }

    public ConflatedBroadcastChannel() {
        this._state = y;
        this._updating = 0;
        this.onCloseHandler = null;
    }

    public ConflatedBroadcastChannel(E e) {
        this();
        t.lazySet(this, new kotlinx.coroutines.channels.ConflatedBroadcastChannel.State(e, null));
    }

    public static /* synthetic */ void getValue$annotations() {
    }

    public final kotlinx.coroutines.channels.ConflatedBroadcastChannel.Subscriber<E>[] a(kotlinx.coroutines.channels.ConflatedBroadcastChannel.Subscriber<E>[] list, kotlinx.coroutines.channels.ConflatedBroadcastChannel.Subscriber<E> subscriber) {
        java.lang.Object[] plus;
        if (list == null) {
            return new kotlinx.coroutines.channels.ConflatedBroadcastChannel.Subscriber[]{subscriber};
        }
        plus = kotlin.collections.ArraysKt___ArraysJvmKt.plus(list, subscriber);
        return (kotlinx.coroutines.channels.ConflatedBroadcastChannel.Subscriber[]) plus;
    }

    public final void b(kotlinx.coroutines.channels.ConflatedBroadcastChannel.Subscriber<E> subscriber) {
        java.lang.Object obj;
        java.lang.Object obj2;
        kotlinx.coroutines.channels.ConflatedBroadcastChannel.Subscriber<E>[] subscriberArr;
        do {
            obj = this._state;
            if (obj instanceof kotlinx.coroutines.channels.ConflatedBroadcastChannel.Closed) {
                return;
            }
            if (!(obj instanceof kotlinx.coroutines.channels.ConflatedBroadcastChannel.State)) {
                throw new java.lang.IllegalStateException(kotlin.jvm.internal.Intrinsics.stringPlus("Invalid state ", obj).toString());
            }
            kotlinx.coroutines.channels.ConflatedBroadcastChannel.State state = (kotlinx.coroutines.channels.ConflatedBroadcastChannel.State) obj;
            obj2 = state.value;
            subscriberArr = state.subscribers;
            kotlin.jvm.internal.Intrinsics.checkNotNull(subscriberArr);
        } while (!defpackage.q1.a(t, this, obj, new kotlinx.coroutines.channels.ConflatedBroadcastChannel.State(obj2, f(subscriberArr, subscriber))));
    }

    public final void c(java.lang.Throwable cause) {
        kotlinx.coroutines.internal.Symbol symbol;
        java.lang.Object obj = this.onCloseHandler;
        if (obj == null || obj == (symbol = kotlinx.coroutines.channels.AbstractChannelKt.HANDLER_INVOKED) || !defpackage.q1.a(v, this, obj, symbol)) {
            return;
        }
        ((kotlin.jvm.functions.Function1) kotlin.jvm.internal.TypeIntrinsics.beforeCheckcastToFunctionOfArity(obj, 1)).invoke(cause);
    }

    @Override // kotlinx.coroutines.channels.BroadcastChannel
    public void cancel(@org.jetbrains.annotations.Nullable java.util.concurrent.CancellationException cause) {
        cancel(cause);
    }

    @Override // kotlinx.coroutines.channels.BroadcastChannel
    /* renamed from: close, reason: merged with bridge method [inline-methods] */
    public boolean cancel(@org.jetbrains.annotations.Nullable java.lang.Throwable cause) {
        java.lang.Object obj;
        int i;
        do {
            obj = this._state;
            if (obj instanceof kotlinx.coroutines.channels.ConflatedBroadcastChannel.Closed) {
                return false;
            }
            if (!(obj instanceof kotlinx.coroutines.channels.ConflatedBroadcastChannel.State)) {
                throw new java.lang.IllegalStateException(kotlin.jvm.internal.Intrinsics.stringPlus("Invalid state ", obj).toString());
            }
        } while (!defpackage.q1.a(t, this, obj, cause == null ? w : new kotlinx.coroutines.channels.ConflatedBroadcastChannel.Closed(cause)));
        kotlinx.coroutines.channels.ConflatedBroadcastChannel.Subscriber<E>[] subscriberArr = ((kotlinx.coroutines.channels.ConflatedBroadcastChannel.State) obj).subscribers;
        if (subscriberArr != null) {
            for (kotlinx.coroutines.channels.ConflatedBroadcastChannel.Subscriber<E> subscriber : subscriberArr) {
                subscriber.cancel(cause);
            }
        }
        c(cause);
        return true;
    }

    public final kotlinx.coroutines.channels.ConflatedBroadcastChannel.Closed d(E element) {
        java.lang.Object obj;
        if (!u.compareAndSet(this, 0, 1)) {
            return null;
        }
        do {
            try {
                obj = this._state;
                if (obj instanceof kotlinx.coroutines.channels.ConflatedBroadcastChannel.Closed) {
                    return (kotlinx.coroutines.channels.ConflatedBroadcastChannel.Closed) obj;
                }
                if (!(obj instanceof kotlinx.coroutines.channels.ConflatedBroadcastChannel.State)) {
                    throw new java.lang.IllegalStateException(kotlin.jvm.internal.Intrinsics.stringPlus("Invalid state ", obj).toString());
                }
            } finally {
                this._updating = 0;
            }
        } while (!defpackage.q1.a(t, this, obj, new kotlinx.coroutines.channels.ConflatedBroadcastChannel.State(element, ((kotlinx.coroutines.channels.ConflatedBroadcastChannel.State) obj).subscribers)));
        kotlinx.coroutines.channels.ConflatedBroadcastChannel.Subscriber<E>[] subscriberArr = ((kotlinx.coroutines.channels.ConflatedBroadcastChannel.State) obj).subscribers;
        if (subscriberArr != null) {
            for (kotlinx.coroutines.channels.ConflatedBroadcastChannel.Subscriber<E> subscriber : subscriberArr) {
                subscriber.offerInternal(element);
            }
        }
        return null;
    }

    public final <R> void e(kotlinx.coroutines.selects.SelectInstance<? super R> select, E element, kotlin.jvm.functions.Function2<? super kotlinx.coroutines.channels.SendChannel<? super E>, ? super kotlin.coroutines.Continuation<? super R>, ? extends java.lang.Object> block) {
        if (select.trySelect()) {
            kotlinx.coroutines.channels.ConflatedBroadcastChannel.Closed d = d(element);
            if (d == null) {
                kotlinx.coroutines.intrinsics.UndispatchedKt.startCoroutineUnintercepted(block, this, select.getCompletion());
            } else {
                select.resumeSelectWithException(d.a());
            }
        }
    }

    public final kotlinx.coroutines.channels.ConflatedBroadcastChannel.Subscriber<E>[] f(kotlinx.coroutines.channels.ConflatedBroadcastChannel.Subscriber<E>[] list, kotlinx.coroutines.channels.ConflatedBroadcastChannel.Subscriber<E> subscriber) {
        int length = list.length;
        int indexOf = kotlin.collections.ArraysKt___ArraysKt.indexOf(list, subscriber);
        if (length == 1) {
            return null;
        }
        kotlinx.coroutines.channels.ConflatedBroadcastChannel.Subscriber<E>[] subscriberArr = new kotlinx.coroutines.channels.ConflatedBroadcastChannel.Subscriber[length - 1];
        kotlin.collections.ArraysKt___ArraysJvmKt.copyInto$default(list, subscriberArr, 0, 0, indexOf, 6, (java.lang.Object) null);
        kotlin.collections.ArraysKt___ArraysJvmKt.copyInto$default(list, subscriberArr, indexOf, indexOf + 1, 0, 8, (java.lang.Object) null);
        return subscriberArr;
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    @org.jetbrains.annotations.NotNull
    public kotlinx.coroutines.selects.SelectClause2<E, kotlinx.coroutines.channels.SendChannel<E>> getOnSend() {
        return new kotlinx.coroutines.channels.ConflatedBroadcastChannel$onSend$1(this);
    }

    public final E getValue() {
        java.lang.Object obj = this._state;
        if (obj instanceof kotlinx.coroutines.channels.ConflatedBroadcastChannel.Closed) {
            throw ((kotlinx.coroutines.channels.ConflatedBroadcastChannel.Closed) obj).b();
        }
        if (!(obj instanceof kotlinx.coroutines.channels.ConflatedBroadcastChannel.State)) {
            throw new java.lang.IllegalStateException(kotlin.jvm.internal.Intrinsics.stringPlus("Invalid state ", obj).toString());
        }
        E e = (E) ((kotlinx.coroutines.channels.ConflatedBroadcastChannel.State) obj).value;
        if (e != x) {
            return e;
        }
        throw new java.lang.IllegalStateException("No value");
    }

    @org.jetbrains.annotations.Nullable
    public final E getValueOrNull() {
        java.lang.Object obj = this._state;
        if (obj instanceof kotlinx.coroutines.channels.ConflatedBroadcastChannel.Closed) {
            return null;
        }
        if (!(obj instanceof kotlinx.coroutines.channels.ConflatedBroadcastChannel.State)) {
            throw new java.lang.IllegalStateException(kotlin.jvm.internal.Intrinsics.stringPlus("Invalid state ", obj).toString());
        }
        kotlinx.coroutines.internal.Symbol symbol = x;
        E e = (E) ((kotlinx.coroutines.channels.ConflatedBroadcastChannel.State) obj).value;
        if (e == symbol) {
            return null;
        }
        return e;
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public void invokeOnClose(@org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super java.lang.Throwable, kotlin.Unit> handler) {
        java.util.concurrent.atomic.AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = v;
        if (!defpackage.q1.a(atomicReferenceFieldUpdater, this, null, handler)) {
            java.lang.Object obj = this.onCloseHandler;
            if (obj != kotlinx.coroutines.channels.AbstractChannelKt.HANDLER_INVOKED) {
                throw new java.lang.IllegalStateException(kotlin.jvm.internal.Intrinsics.stringPlus("Another handler was already registered: ", obj));
            }
            throw new java.lang.IllegalStateException("Another handler was already registered and successfully invoked");
        }
        java.lang.Object obj2 = this._state;
        if ((obj2 instanceof kotlinx.coroutines.channels.ConflatedBroadcastChannel.Closed) && defpackage.q1.a(atomicReferenceFieldUpdater, this, handler, kotlinx.coroutines.channels.AbstractChannelKt.HANDLER_INVOKED)) {
            handler.invoke(((kotlinx.coroutines.channels.ConflatedBroadcastChannel.Closed) obj2).closeCause);
        }
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public boolean isClosedForSend() {
        return this._state instanceof kotlinx.coroutines.channels.ConflatedBroadcastChannel.Closed;
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.WARNING, message = "Deprecated in the favour of 'trySend' method", replaceWith = @kotlin.ReplaceWith(expression = "trySend(element).isSuccess", imports = {}))
    public boolean offer(E e) {
        return kotlinx.coroutines.channels.BroadcastChannel.DefaultImpls.offer(this, e);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.channels.BroadcastChannel
    @org.jetbrains.annotations.NotNull
    public kotlinx.coroutines.channels.ReceiveChannel<E> openSubscription() {
        java.lang.Object obj;
        kotlinx.coroutines.channels.ConflatedBroadcastChannel.State state;
        kotlinx.coroutines.channels.ConflatedBroadcastChannel.Subscriber subscriber = new kotlinx.coroutines.channels.ConflatedBroadcastChannel.Subscriber(this);
        do {
            obj = this._state;
            if (obj instanceof kotlinx.coroutines.channels.ConflatedBroadcastChannel.Closed) {
                subscriber.cancel(((kotlinx.coroutines.channels.ConflatedBroadcastChannel.Closed) obj).closeCause);
                return subscriber;
            }
            if (!(obj instanceof kotlinx.coroutines.channels.ConflatedBroadcastChannel.State)) {
                throw new java.lang.IllegalStateException(kotlin.jvm.internal.Intrinsics.stringPlus("Invalid state ", obj).toString());
            }
            state = (kotlinx.coroutines.channels.ConflatedBroadcastChannel.State) obj;
            java.lang.Object obj2 = state.value;
            if (obj2 != x) {
                subscriber.offerInternal(obj2);
            }
        } while (!defpackage.q1.a(t, this, obj, new kotlinx.coroutines.channels.ConflatedBroadcastChannel.State(state.value, a(state.subscribers, subscriber))));
        return subscriber;
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    @org.jetbrains.annotations.Nullable
    public java.lang.Object send(E e, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        java.lang.Object coroutine_suspended;
        kotlinx.coroutines.channels.ConflatedBroadcastChannel.Closed d = d(e);
        if (d != null) {
            throw d.a();
        }
        coroutine_suspended = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (coroutine_suspended == null) {
            return null;
        }
        return kotlin.Unit.INSTANCE;
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    @org.jetbrains.annotations.NotNull
    /* renamed from: trySend-JP2dKIU */
    public java.lang.Object mo766trySendJP2dKIU(E element) {
        kotlinx.coroutines.channels.ConflatedBroadcastChannel.Closed d = d(element);
        return d == null ? kotlinx.coroutines.channels.ChannelResult.INSTANCE.m786successJP2dKIU(kotlin.Unit.INSTANCE) : kotlinx.coroutines.channels.ChannelResult.INSTANCE.m784closedJP2dKIU(d.a());
    }
}
