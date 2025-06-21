package kotlinx.coroutines.flow;

@kotlin.Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0010 \n\u0002\b\u000f\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0012\u0004\u0012\u00028\u00000\u00042\b\u0012\u0004\u0012\u00028\u00000\u00052\b\u0012\u0004\u0012\u00028\u00000\u0006:\u0001dB\u001f\u0012\u0006\u0010I\u001a\u00020\u001b\u0012\u0006\u0010K\u001a\u00020\u001b\u0012\u0006\u0010$\u001a\u00020#¢\u0006\u0004\bb\u0010cJ!\u0010\n\u001a\u00020\t2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007H\u0096@ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u001b\u0010\u0010\u001a\u00020\t2\u0006\u0010\f\u001a\u00028\u0000H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\u0012H\u0000¢\u0006\u0004\b\u0013\u0010\u0014J%\u0010\u0018\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u00170\u00162\u0006\u0010\u0015\u001a\u00020\u0012H\u0000¢\u0006\u0004\b\u0018\u0010\u0019J\b\u0010\u001a\u001a\u00020\u0003H\u0014J\u001f\u0010\u001d\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00162\u0006\u0010\u001c\u001a\u00020\u001bH\u0014¢\u0006\u0004\b\u001d\u0010\u001eJ\b\u0010\u001f\u001a\u00020\tH\u0016J&\u0010&\u001a\b\u0012\u0004\u0012\u00028\u00000%2\u0006\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020\u001b2\u0006\u0010$\u001a\u00020#H\u0016J\u0017\u0010'\u001a\u00020\r2\u0006\u0010\f\u001a\u00028\u0000H\u0002¢\u0006\u0004\b'\u0010\u000fJ\u0017\u0010(\u001a\u00020\r2\u0006\u0010\f\u001a\u00028\u0000H\u0002¢\u0006\u0004\b(\u0010\u000fJ\b\u0010)\u001a\u00020\tH\u0002J\u0010\u0010+\u001a\u00020\t2\u0006\u0010*\u001a\u00020\u0012H\u0002J\u0012\u0010.\u001a\u00020\t2\b\u0010-\u001a\u0004\u0018\u00010,H\u0002J9\u00102\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010,0\u00162\u0010\u0010/\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010,\u0018\u00010\u00162\u0006\u00100\u001a\u00020\u001b2\u0006\u00101\u001a\u00020\u001bH\u0002¢\u0006\u0004\b2\u00103J\u001b\u00104\u001a\u00020\t2\u0006\u0010\f\u001a\u00028\u0000H\u0082@ø\u0001\u0000¢\u0006\u0004\b4\u0010\u0011J\u0010\u00107\u001a\u00020\t2\u0006\u00106\u001a\u000205H\u0002J(\u0010<\u001a\u00020\t2\u0006\u00108\u001a\u00020\u00122\u0006\u00109\u001a\u00020\u00122\u0006\u0010:\u001a\u00020\u00122\u0006\u0010;\u001a\u00020\u0012H\u0002J\b\u0010=\u001a\u00020\tH\u0002J\u0012\u0010?\u001a\u0004\u0018\u00010,2\u0006\u0010>\u001a\u00020\u0003H\u0002J\u0010\u0010@\u001a\u00020\u00122\u0006\u0010>\u001a\u00020\u0003H\u0002J\u0012\u0010B\u001a\u0004\u0018\u00010,2\u0006\u0010A\u001a\u00020\u0012H\u0002J\u001b\u0010C\u001a\u00020\t2\u0006\u0010>\u001a\u00020\u0003H\u0082@ø\u0001\u0000¢\u0006\u0004\bC\u0010DJ3\u0010F\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u00170\u00162\u0014\u0010E\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u00170\u0016H\u0002¢\u0006\u0004\bF\u0010GR\u0014\u0010I\u001a\u00020\u001b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bB\u0010HR\u0014\u0010K\u001a\u00020\u001b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bJ\u0010HR\u0014\u0010$\u001a\u00020#8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bL\u0010MR \u0010P\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010,\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bN\u0010OR\u0016\u0010R\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u0010QR\u0016\u0010S\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010QR\u0016\u0010T\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010HR\u0016\u0010U\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b@\u0010HR\u001a\u0010Y\u001a\b\u0012\u0004\u0012\u00028\u00000V8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bW\u0010XR\u0014\u0010[\u001a\u00020\u00128BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bZ\u0010\u0014R\u0014\u0010]\u001a\u00020\u001b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bL\u0010\\R\u0014\u0010^\u001a\u00020\u001b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bN\u0010\\R\u0014\u0010`\u001a\u00020\u00128BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b_\u0010\u0014R\u0014\u0010a\u001a\u00020\u00128BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bJ\u0010\u0014\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006e"}, d2 = {"Lkotlinx/coroutines/flow/SharedFlowImpl;", androidx.exifinterface.media.ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/internal/AbstractSharedFlow;", "Lkotlinx/coroutines/flow/SharedFlowSlot;", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lkotlinx/coroutines/flow/CancellableFlow;", "Lkotlinx/coroutines/flow/internal/FusibleFlow;", "Lkotlinx/coroutines/flow/FlowCollector;", "collector", "", "collect", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "value", "", "tryEmit", "(Ljava/lang/Object;)Z", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "H", "()J", "oldIndex", "", "Lkotlin/coroutines/Continuation;", "G", "(J)[Lkotlin/coroutines/Continuation;", "o", "", com.anythink.core.api.ATAdConst.NETWORK_REQUEST_PARAMS_KEY.BANNER_SIZE, "p", "(I)[Lkotlinx/coroutines/flow/SharedFlowSlot;", "resetReplayCache", "Lkotlin/coroutines/CoroutineContext;", "context", "capacity", "Lkotlinx/coroutines/channels/BufferOverflow;", "onBufferOverflow", "Lkotlinx/coroutines/flow/Flow;", "fuse", "B", "C", "q", "newHead", com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.AD_COUNT, "", "item", "s", "curBuffer", "curSize", "newSize", androidx.exifinterface.media.ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "([Ljava/lang/Object;II)[Ljava/lang/Object;", "r", "Lkotlinx/coroutines/flow/SharedFlowImpl$Emitter;", "emitter", "l", "newReplayIndex", "newMinCollectorIndex", "newBufferEndIndex", "newQueueEndIndex", "F", com.anythink.expressad.d.a.b.dH, "slot", androidx.exifinterface.media.ExifInterface.LONGITUDE_EAST, "D", "index", com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.WIDTH, "k", "(Lkotlinx/coroutines/flow/SharedFlowSlot;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resumesIn", "t", "([Lkotlin/coroutines/Continuation;)[Lkotlin/coroutines/Continuation;", "I", "replay", "x", "bufferCapacity", "y", "Lkotlinx/coroutines/channels/BufferOverflow;", com.umeng.analytics.pro.bo.aJ, "[Ljava/lang/Object;", "buffer", "J", "replayIndex", "minCollectorIndex", "bufferSize", "queueSize", "", "getReplayCache", "()Ljava/util/List;", "replayCache", "v", com.ss.android.socialbase.downloader.constants.MonitorConstants.CONNECT_TYPE_HEAD, "()I", "replaySize", "totalSize", com.umeng.analytics.pro.bo.aN, "bufferEndIndex", "queueEndIndex", "<init>", "(IILkotlinx/coroutines/channels/BufferOverflow;)V", "Emitter", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes16.dex */
final class SharedFlowImpl<T> extends kotlinx.coroutines.flow.internal.AbstractSharedFlow<kotlinx.coroutines.flow.SharedFlowSlot> implements kotlinx.coroutines.flow.MutableSharedFlow<T>, kotlinx.coroutines.flow.CancellableFlow<T>, kotlinx.coroutines.flow.internal.FusibleFlow<T> {

    /* renamed from: A, reason: from kotlin metadata */
    public long replayIndex;

    /* renamed from: B, reason: from kotlin metadata */
    public long minCollectorIndex;

    /* renamed from: C, reason: from kotlin metadata */
    public int bufferSize;

    /* renamed from: D, reason: from kotlin metadata */
    public int queueSize;

    /* renamed from: w, reason: from kotlin metadata */
    public final int replay;

    /* renamed from: x, reason: from kotlin metadata */
    public final int bufferCapacity;

    /* renamed from: y, reason: from kotlin metadata */
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.channels.BufferOverflow onBufferOverflow;

    /* renamed from: z, reason: from kotlin metadata */
    @org.jetbrains.annotations.Nullable
    public java.lang.Object[] buffer;

    @kotlin.Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B3\u0012\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u0004\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\f\u0012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00020\u0010¢\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0018\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u00048\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0016\u0010\u000b\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u000f\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00020\u00108\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, d2 = {"Lkotlinx/coroutines/flow/SharedFlowImpl$Emitter;", "Lkotlinx/coroutines/DisposableHandle;", "", "dispose", "Lkotlinx/coroutines/flow/SharedFlowImpl;", com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.AD_COUNT, "Lkotlinx/coroutines/flow/SharedFlowImpl;", com.alimm.tanx.core.constant.TanxAdType.FEED_STRING, "", "t", "J", "index", "", com.umeng.analytics.pro.bo.aN, "Ljava/lang/Object;", "value", "Lkotlin/coroutines/Continuation;", "v", "Lkotlin/coroutines/Continuation;", "cont", "<init>", "(Lkotlinx/coroutines/flow/SharedFlowImpl;JLjava/lang/Object;Lkotlin/coroutines/Continuation;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1})
    public static final class Emitter implements kotlinx.coroutines.DisposableHandle {

        /* renamed from: n, reason: from kotlin metadata */
        @kotlin.jvm.JvmField
        @org.jetbrains.annotations.NotNull
        public final kotlinx.coroutines.flow.SharedFlowImpl<?> flow;

        /* renamed from: t, reason: from kotlin metadata */
        @kotlin.jvm.JvmField
        public long index;

        /* renamed from: u, reason: from kotlin metadata */
        @kotlin.jvm.JvmField
        @org.jetbrains.annotations.Nullable
        public final java.lang.Object value;

        /* renamed from: v, reason: from kotlin metadata */
        @kotlin.jvm.JvmField
        @org.jetbrains.annotations.NotNull
        public final kotlin.coroutines.Continuation<kotlin.Unit> cont;

        /* JADX WARN: Multi-variable type inference failed */
        public Emitter(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.SharedFlowImpl<?> sharedFlowImpl, long j, @org.jetbrains.annotations.Nullable java.lang.Object obj, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
            this.flow = sharedFlowImpl;
            this.index = j;
            this.value = obj;
            this.cont = continuation;
        }

        @Override // kotlinx.coroutines.DisposableHandle
        public void dispose() {
            this.flow.l(this);
        }
    }

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

    public SharedFlowImpl(int i, int i2, @org.jetbrains.annotations.NotNull kotlinx.coroutines.channels.BufferOverflow bufferOverflow) {
        this.replay = i;
        this.bufferCapacity = i2;
        this.onBufferOverflow = bufferOverflow;
    }

    public final java.lang.Object[] A(java.lang.Object[] curBuffer, int curSize, int newSize) {
        java.lang.Object a;
        int i = 0;
        if (!(newSize > 0)) {
            throw new java.lang.IllegalStateException("Buffer size overflow".toString());
        }
        java.lang.Object[] objArr = new java.lang.Object[newSize];
        this.buffer = objArr;
        if (curBuffer == null) {
            return objArr;
        }
        long v = v();
        if (curSize > 0) {
            while (true) {
                int i2 = i + 1;
                long j = i + v;
                a = kotlinx.coroutines.flow.SharedFlowKt.a(curBuffer, j);
                kotlinx.coroutines.flow.SharedFlowKt.b(objArr, j, a);
                if (i2 >= curSize) {
                    break;
                }
                i = i2;
            }
        }
        return objArr;
    }

    public final boolean B(T value) {
        if (getNCollectors() == 0) {
            return C(value);
        }
        if (this.bufferSize >= this.bufferCapacity && this.minCollectorIndex <= this.replayIndex) {
            int i = kotlinx.coroutines.flow.SharedFlowImpl.WhenMappings.$EnumSwitchMapping$0[this.onBufferOverflow.ordinal()];
            if (i == 1) {
                return false;
            }
            if (i == 2) {
                return true;
            }
        }
        s(value);
        int i2 = this.bufferSize + 1;
        this.bufferSize = i2;
        if (i2 > this.bufferCapacity) {
            q();
        }
        if (y() > this.replay) {
            F(this.replayIndex + 1, this.minCollectorIndex, u(), x());
        }
        return true;
    }

    public final boolean C(T value) {
        if (this.replay == 0) {
            return true;
        }
        s(value);
        int i = this.bufferSize + 1;
        this.bufferSize = i;
        if (i > this.replay) {
            q();
        }
        this.minCollectorIndex = v() + this.bufferSize;
        return true;
    }

    public final long D(kotlinx.coroutines.flow.SharedFlowSlot slot) {
        long j = slot.index;
        if (j < u()) {
            return j;
        }
        if (this.bufferCapacity <= 0 && j <= v() && this.queueSize != 0) {
            return j;
        }
        return -1L;
    }

    public final java.lang.Object E(kotlinx.coroutines.flow.SharedFlowSlot slot) {
        java.lang.Object obj;
        kotlin.coroutines.Continuation<kotlin.Unit>[] continuationArr = kotlinx.coroutines.flow.internal.AbstractSharedFlowKt.EMPTY_RESUMES;
        synchronized (this) {
            long D = D(slot);
            if (D < 0) {
                obj = kotlinx.coroutines.flow.SharedFlowKt.NO_VALUE;
            } else {
                long j = slot.index;
                java.lang.Object w = w(D);
                slot.index = D + 1;
                continuationArr = G(j);
                obj = w;
            }
        }
        int length = continuationArr.length;
        int i = 0;
        while (i < length) {
            kotlin.coroutines.Continuation<kotlin.Unit> continuation = continuationArr[i];
            i++;
            if (continuation != null) {
                continuation.resumeWith(kotlin.Result.m156constructorimpl(kotlin.Unit.INSTANCE));
            }
        }
        return obj;
    }

    public final void F(long newReplayIndex, long newMinCollectorIndex, long newBufferEndIndex, long newQueueEndIndex) {
        long min = java.lang.Math.min(newMinCollectorIndex, newReplayIndex);
        long v = v();
        if (v < min) {
            while (true) {
                long j = 1 + v;
                java.lang.Object[] objArr = this.buffer;
                kotlin.jvm.internal.Intrinsics.checkNotNull(objArr);
                kotlinx.coroutines.flow.SharedFlowKt.b(objArr, v, null);
                if (j >= min) {
                    break;
                } else {
                    v = j;
                }
            }
        }
        this.replayIndex = newReplayIndex;
        this.minCollectorIndex = newMinCollectorIndex;
        this.bufferSize = (int) (newBufferEndIndex - min);
        this.queueSize = (int) (newQueueEndIndex - newBufferEndIndex);
    }

    @org.jetbrains.annotations.NotNull
    public final kotlin.coroutines.Continuation<kotlin.Unit>[] G(long oldIndex) {
        long j;
        java.lang.Object a;
        java.lang.Object a2;
        kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot[] abstractSharedFlowSlotArr;
        if (oldIndex > this.minCollectorIndex) {
            return kotlinx.coroutines.flow.internal.AbstractSharedFlowKt.EMPTY_RESUMES;
        }
        long v = v();
        long j2 = this.bufferSize + v;
        long j3 = 1;
        if (this.bufferCapacity == 0 && this.queueSize > 0) {
            j2++;
        }
        if (this.nCollectors != 0 && (abstractSharedFlowSlotArr = this.slots) != null) {
            for (kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot abstractSharedFlowSlot : abstractSharedFlowSlotArr) {
                if (abstractSharedFlowSlot != null) {
                    long j4 = ((kotlinx.coroutines.flow.SharedFlowSlot) abstractSharedFlowSlot).index;
                    if (j4 >= 0 && j4 < j2) {
                        j2 = j4;
                    }
                }
            }
        }
        if (j2 <= this.minCollectorIndex) {
            return kotlinx.coroutines.flow.internal.AbstractSharedFlowKt.EMPTY_RESUMES;
        }
        long u = u();
        int min = getNCollectors() > 0 ? java.lang.Math.min(this.queueSize, this.bufferCapacity - ((int) (u - j2))) : this.queueSize;
        kotlin.coroutines.Continuation<kotlin.Unit>[] continuationArr = kotlinx.coroutines.flow.internal.AbstractSharedFlowKt.EMPTY_RESUMES;
        long j5 = this.queueSize + u;
        if (min > 0) {
            continuationArr = new kotlin.coroutines.Continuation[min];
            java.lang.Object[] objArr = this.buffer;
            kotlin.jvm.internal.Intrinsics.checkNotNull(objArr);
            if (u < j5) {
                long j6 = u;
                int i = 0;
                while (true) {
                    long j7 = u + j3;
                    a2 = kotlinx.coroutines.flow.SharedFlowKt.a(objArr, u);
                    kotlinx.coroutines.internal.Symbol symbol = kotlinx.coroutines.flow.SharedFlowKt.NO_VALUE;
                    if (a2 == symbol) {
                        j = j2;
                    } else {
                        if (a2 == null) {
                            throw new java.lang.NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.flow.SharedFlowImpl.Emitter");
                        }
                        kotlinx.coroutines.flow.SharedFlowImpl.Emitter emitter = (kotlinx.coroutines.flow.SharedFlowImpl.Emitter) a2;
                        int i2 = i + 1;
                        j = j2;
                        continuationArr[i] = emitter.cont;
                        kotlinx.coroutines.flow.SharedFlowKt.b(objArr, u, symbol);
                        long j8 = j6;
                        kotlinx.coroutines.flow.SharedFlowKt.b(objArr, j8, emitter.value);
                        u = j8 + 1;
                        if (i2 >= min) {
                            break;
                        }
                        i = i2;
                        j6 = u;
                    }
                    if (j7 >= j5) {
                        u = j6;
                        break;
                    }
                    u = j7;
                    j2 = j;
                    j3 = 1;
                }
            }
        }
        j = j2;
        int i3 = (int) (u - v);
        long j9 = getNCollectors() == 0 ? u : j;
        long max = java.lang.Math.max(this.replayIndex, u - java.lang.Math.min(this.replay, i3));
        if (this.bufferCapacity == 0 && max < j5) {
            java.lang.Object[] objArr2 = this.buffer;
            kotlin.jvm.internal.Intrinsics.checkNotNull(objArr2);
            a = kotlinx.coroutines.flow.SharedFlowKt.a(objArr2, max);
            if (kotlin.jvm.internal.Intrinsics.areEqual(a, kotlinx.coroutines.flow.SharedFlowKt.NO_VALUE)) {
                u++;
                max++;
            }
        }
        F(max, j9, u, j5);
        m();
        return (continuationArr.length == 0) ^ true ? t(continuationArr) : continuationArr;
    }

    public final long H() {
        long j = this.replayIndex;
        if (j < this.minCollectorIndex) {
            this.minCollectorIndex = j;
        }
        return j;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00bf A[Catch: all -> 0x006f, TRY_LEAVE, TryCatch #1 {all -> 0x006f, blocks: (B:13:0x003b, B:17:0x00a0, B:28:0x00ae, B:31:0x00ab, B:19:0x00bf, B:36:0x0059, B:38:0x006b, B:39:0x0092), top: B:7:0x0023 }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00a8 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0025  */
    /* JADX WARN: Type inference failed for: r2v0, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v2, types: [kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot] */
    /* JADX WARN: Type inference failed for: r2v20 */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.lang.Object, kotlinx.coroutines.flow.SharedFlowSlot] */
    /* JADX WARN: Type inference failed for: r2v6, types: [java.lang.Object, kotlinx.coroutines.flow.SharedFlowSlot] */
    /* JADX WARN: Type inference failed for: r5v12 */
    /* JADX WARN: Type inference failed for: r5v2, types: [java.lang.Object, kotlinx.coroutines.flow.FlowCollector] */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r6v1, types: [kotlinx.coroutines.flow.internal.AbstractSharedFlow] */
    /* JADX WARN: Type inference failed for: r6v18 */
    /* JADX WARN: Type inference failed for: r6v19 */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v5, types: [java.lang.Object, kotlinx.coroutines.flow.SharedFlowImpl] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x00bc -> B:14:0x003e). Please report as a decompilation issue!!! */
    @Override // kotlinx.coroutines.flow.Flow
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public java.lang.Object collect(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.FlowCollector<? super T> flowCollector, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        kotlinx.coroutines.flow.SharedFlowImpl$collect$1 sharedFlowImpl$collect$1;
        java.lang.Object coroutine_suspended;
        kotlinx.coroutines.flow.SharedFlowSlot sharedFlowSlot;
        ?? r6;
        kotlinx.coroutines.flow.SharedFlowImpl<T> sharedFlowImpl;
        kotlinx.coroutines.flow.SharedFlowSlot sharedFlowSlot2;
        kotlinx.coroutines.Job job;
        kotlinx.coroutines.Job job2;
        ?? r5;
        java.lang.Object E;
        kotlinx.coroutines.flow.SharedFlowImpl<T> sharedFlowImpl2;
        kotlinx.coroutines.flow.SharedFlowSlot sharedFlowSlot3;
        try {
            if (continuation instanceof kotlinx.coroutines.flow.SharedFlowImpl$collect$1) {
                sharedFlowImpl$collect$1 = (kotlinx.coroutines.flow.SharedFlowImpl$collect$1) continuation;
                int i = sharedFlowImpl$collect$1.label;
                if ((i & Integer.MIN_VALUE) != 0) {
                    sharedFlowImpl$collect$1.label = i - Integer.MIN_VALUE;
                    java.lang.Object obj = sharedFlowImpl$collect$1.result;
                    coroutine_suspended = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    sharedFlowSlot = sharedFlowImpl$collect$1.label;
                    if (sharedFlowSlot != 0) {
                        kotlin.ResultKt.throwOnFailure(obj);
                        sharedFlowSlot = allocateSlot();
                        try {
                            if (flowCollector instanceof kotlinx.coroutines.flow.SubscribedFlowCollector) {
                                sharedFlowImpl$collect$1.L$0 = this;
                                sharedFlowImpl$collect$1.L$1 = flowCollector;
                                sharedFlowImpl$collect$1.L$2 = sharedFlowSlot;
                                sharedFlowImpl$collect$1.label = 1;
                                if (((kotlinx.coroutines.flow.SubscribedFlowCollector) flowCollector).onSubscription(sharedFlowImpl$collect$1) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                            }
                            sharedFlowImpl = this;
                            sharedFlowSlot2 = sharedFlowSlot;
                        } catch (java.lang.Throwable th) {
                            th = th;
                            r6 = this;
                            r6.freeSlot(sharedFlowSlot);
                            throw th;
                        }
                    } else {
                        if (sharedFlowSlot != 1) {
                            if (sharedFlowSlot == 2) {
                                job2 = (kotlinx.coroutines.Job) sharedFlowImpl$collect$1.L$3;
                                kotlinx.coroutines.flow.SharedFlowSlot sharedFlowSlot4 = (kotlinx.coroutines.flow.SharedFlowSlot) sharedFlowImpl$collect$1.L$2;
                                kotlinx.coroutines.flow.FlowCollector flowCollector2 = (kotlinx.coroutines.flow.FlowCollector) sharedFlowImpl$collect$1.L$1;
                                kotlinx.coroutines.flow.SharedFlowImpl sharedFlowImpl3 = (kotlinx.coroutines.flow.SharedFlowImpl) sharedFlowImpl$collect$1.L$0;
                                kotlin.ResultKt.throwOnFailure(obj);
                                sharedFlowSlot = sharedFlowSlot4;
                                r5 = flowCollector2;
                                r6 = sharedFlowImpl3;
                                do {
                                    E = r6.E(sharedFlowSlot);
                                    if (E == kotlinx.coroutines.flow.SharedFlowKt.NO_VALUE) {
                                    }
                                } while (r6.k(sharedFlowSlot, sharedFlowImpl$collect$1) != coroutine_suspended);
                                return coroutine_suspended;
                            }
                            if (sharedFlowSlot != 3) {
                                throw new java.lang.IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            job2 = (kotlinx.coroutines.Job) sharedFlowImpl$collect$1.L$3;
                            kotlinx.coroutines.flow.SharedFlowSlot sharedFlowSlot5 = (kotlinx.coroutines.flow.SharedFlowSlot) sharedFlowImpl$collect$1.L$2;
                            kotlinx.coroutines.flow.FlowCollector<? super T> flowCollector3 = (kotlinx.coroutines.flow.FlowCollector) sharedFlowImpl$collect$1.L$1;
                            kotlinx.coroutines.flow.SharedFlowImpl<T> sharedFlowImpl4 = (kotlinx.coroutines.flow.SharedFlowImpl) sharedFlowImpl$collect$1.L$0;
                            kotlin.ResultKt.throwOnFailure(obj);
                            kotlinx.coroutines.flow.SharedFlowSlot sharedFlowSlot6 = sharedFlowSlot5;
                            kotlinx.coroutines.flow.FlowCollector<? super T> flowCollector4 = flowCollector3;
                            kotlinx.coroutines.flow.SharedFlowImpl<T> sharedFlowImpl5 = sharedFlowImpl4;
                            job = job2;
                            flowCollector = flowCollector4;
                            sharedFlowSlot3 = sharedFlowSlot6;
                            sharedFlowImpl2 = sharedFlowImpl5;
                            r5 = flowCollector;
                            job2 = job;
                            sharedFlowSlot = sharedFlowSlot3;
                            r6 = sharedFlowImpl2;
                            do {
                                E = r6.E(sharedFlowSlot);
                                if (E == kotlinx.coroutines.flow.SharedFlowKt.NO_VALUE) {
                                    sharedFlowImpl$collect$1.L$0 = r6;
                                    sharedFlowImpl$collect$1.L$1 = r5;
                                    sharedFlowImpl$collect$1.L$2 = sharedFlowSlot;
                                    sharedFlowImpl$collect$1.L$3 = job2;
                                    sharedFlowImpl$collect$1.label = 2;
                                } else {
                                    if (job2 != null) {
                                        kotlinx.coroutines.JobKt.ensureActive(job2);
                                    }
                                    sharedFlowImpl$collect$1.L$0 = r6;
                                    sharedFlowImpl$collect$1.L$1 = r5;
                                    sharedFlowImpl$collect$1.L$2 = sharedFlowSlot;
                                    sharedFlowImpl$collect$1.L$3 = job2;
                                    sharedFlowImpl$collect$1.label = 3;
                                    java.lang.Object emit = r5.emit(E, sharedFlowImpl$collect$1);
                                    sharedFlowSlot6 = sharedFlowSlot;
                                    flowCollector4 = r5;
                                    sharedFlowImpl5 = r6;
                                    if (emit == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    job = job2;
                                    flowCollector = flowCollector4;
                                    sharedFlowSlot3 = sharedFlowSlot6;
                                    sharedFlowImpl2 = sharedFlowImpl5;
                                    r5 = flowCollector;
                                    job2 = job;
                                    sharedFlowSlot = sharedFlowSlot3;
                                    r6 = sharedFlowImpl2;
                                    E = r6.E(sharedFlowSlot);
                                    if (E == kotlinx.coroutines.flow.SharedFlowKt.NO_VALUE) {
                                    }
                                }
                            } while (r6.k(sharedFlowSlot, sharedFlowImpl$collect$1) != coroutine_suspended);
                            return coroutine_suspended;
                        }
                        kotlinx.coroutines.flow.SharedFlowSlot sharedFlowSlot7 = (kotlinx.coroutines.flow.SharedFlowSlot) sharedFlowImpl$collect$1.L$2;
                        flowCollector = (kotlinx.coroutines.flow.FlowCollector) sharedFlowImpl$collect$1.L$1;
                        kotlinx.coroutines.flow.SharedFlowImpl<T> sharedFlowImpl6 = (kotlinx.coroutines.flow.SharedFlowImpl) sharedFlowImpl$collect$1.L$0;
                        kotlin.ResultKt.throwOnFailure(obj);
                        sharedFlowSlot2 = sharedFlowSlot7;
                        sharedFlowImpl = sharedFlowImpl6;
                    }
                    job = (kotlinx.coroutines.Job) sharedFlowImpl$collect$1.getContext().get(kotlinx.coroutines.Job.INSTANCE);
                    sharedFlowSlot3 = sharedFlowSlot2;
                    sharedFlowImpl2 = sharedFlowImpl;
                    r5 = flowCollector;
                    job2 = job;
                    sharedFlowSlot = sharedFlowSlot3;
                    r6 = sharedFlowImpl2;
                    do {
                        E = r6.E(sharedFlowSlot);
                        if (E == kotlinx.coroutines.flow.SharedFlowKt.NO_VALUE) {
                        }
                    } while (r6.k(sharedFlowSlot, sharedFlowImpl$collect$1) != coroutine_suspended);
                    return coroutine_suspended;
                }
            }
            if (sharedFlowSlot != 0) {
            }
            job = (kotlinx.coroutines.Job) sharedFlowImpl$collect$1.getContext().get(kotlinx.coroutines.Job.INSTANCE);
            sharedFlowSlot3 = sharedFlowSlot2;
            sharedFlowImpl2 = sharedFlowImpl;
            r5 = flowCollector;
            job2 = job;
            sharedFlowSlot = sharedFlowSlot3;
            r6 = sharedFlowImpl2;
            do {
                E = r6.E(sharedFlowSlot);
                if (E == kotlinx.coroutines.flow.SharedFlowKt.NO_VALUE) {
                }
            } while (r6.k(sharedFlowSlot, sharedFlowImpl$collect$1) != coroutine_suspended);
            return coroutine_suspended;
        } catch (java.lang.Throwable th2) {
            th = th2;
        }
        sharedFlowImpl$collect$1 = new kotlinx.coroutines.flow.SharedFlowImpl$collect$1(this, continuation);
        java.lang.Object obj2 = sharedFlowImpl$collect$1.result;
        coroutine_suspended = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        sharedFlowSlot = sharedFlowImpl$collect$1.label;
    }

    @Override // kotlinx.coroutines.flow.MutableSharedFlow, kotlinx.coroutines.flow.FlowCollector
    @org.jetbrains.annotations.Nullable
    public java.lang.Object emit(T t, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        java.lang.Object coroutine_suspended;
        if (tryEmit(t)) {
            return kotlin.Unit.INSTANCE;
        }
        java.lang.Object r = r(t, continuation);
        coroutine_suspended = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        return r == coroutine_suspended ? r : kotlin.Unit.INSTANCE;
    }

    @Override // kotlinx.coroutines.flow.internal.FusibleFlow
    @org.jetbrains.annotations.NotNull
    public kotlinx.coroutines.flow.Flow<T> fuse(@org.jetbrains.annotations.NotNull kotlin.coroutines.CoroutineContext context, int capacity, @org.jetbrains.annotations.NotNull kotlinx.coroutines.channels.BufferOverflow onBufferOverflow) {
        return kotlinx.coroutines.flow.SharedFlowKt.fuseSharedFlow(this, context, capacity, onBufferOverflow);
    }

    @Override // kotlinx.coroutines.flow.SharedFlow
    @org.jetbrains.annotations.NotNull
    public java.util.List<T> getReplayCache() {
        java.lang.Object a;
        synchronized (this) {
            int y = y();
            if (y == 0) {
                return kotlin.collections.CollectionsKt__CollectionsKt.emptyList();
            }
            java.util.ArrayList arrayList = new java.util.ArrayList(y);
            java.lang.Object[] objArr = this.buffer;
            kotlin.jvm.internal.Intrinsics.checkNotNull(objArr);
            if (y > 0) {
                int i = 0;
                while (true) {
                    int i2 = i + 1;
                    a = kotlinx.coroutines.flow.SharedFlowKt.a(objArr, this.replayIndex + i);
                    arrayList.add(a);
                    if (i2 >= y) {
                        break;
                    }
                    i = i2;
                }
            }
            return arrayList;
        }
    }

    public final java.lang.Object k(kotlinx.coroutines.flow.SharedFlowSlot sharedFlowSlot, kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        kotlin.coroutines.Continuation intercepted;
        java.lang.Object coroutine_suspended;
        java.lang.Object coroutine_suspended2;
        intercepted = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        kotlinx.coroutines.CancellableContinuationImpl cancellableContinuationImpl = new kotlinx.coroutines.CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        synchronized (this) {
            if (D(sharedFlowSlot) < 0) {
                sharedFlowSlot.cont = cancellableContinuationImpl;
            } else {
                cancellableContinuationImpl.resumeWith(kotlin.Result.m156constructorimpl(kotlin.Unit.INSTANCE));
            }
            kotlin.Unit unit = kotlin.Unit.INSTANCE;
        }
        java.lang.Object result = cancellableContinuationImpl.getResult();
        coroutine_suspended = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
            kotlin.coroutines.jvm.internal.DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        coroutine_suspended2 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        return result == coroutine_suspended2 ? result : kotlin.Unit.INSTANCE;
    }

    public final void l(kotlinx.coroutines.flow.SharedFlowImpl.Emitter emitter) {
        java.lang.Object a;
        synchronized (this) {
            if (emitter.index < v()) {
                return;
            }
            java.lang.Object[] objArr = this.buffer;
            kotlin.jvm.internal.Intrinsics.checkNotNull(objArr);
            a = kotlinx.coroutines.flow.SharedFlowKt.a(objArr, emitter.index);
            if (a != emitter) {
                return;
            }
            kotlinx.coroutines.flow.SharedFlowKt.b(objArr, emitter.index, kotlinx.coroutines.flow.SharedFlowKt.NO_VALUE);
            m();
            kotlin.Unit unit = kotlin.Unit.INSTANCE;
        }
    }

    public final void m() {
        java.lang.Object a;
        if (this.bufferCapacity != 0 || this.queueSize > 1) {
            java.lang.Object[] objArr = this.buffer;
            kotlin.jvm.internal.Intrinsics.checkNotNull(objArr);
            while (this.queueSize > 0) {
                a = kotlinx.coroutines.flow.SharedFlowKt.a(objArr, (v() + z()) - 1);
                if (a != kotlinx.coroutines.flow.SharedFlowKt.NO_VALUE) {
                    return;
                }
                this.queueSize--;
                kotlinx.coroutines.flow.SharedFlowKt.b(objArr, v() + z(), null);
            }
        }
    }

    public final void n(long newHead) {
        kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot[] abstractSharedFlowSlotArr;
        if (this.nCollectors != 0 && (abstractSharedFlowSlotArr = this.slots) != null) {
            for (kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot abstractSharedFlowSlot : abstractSharedFlowSlotArr) {
                if (abstractSharedFlowSlot != null) {
                    kotlinx.coroutines.flow.SharedFlowSlot sharedFlowSlot = (kotlinx.coroutines.flow.SharedFlowSlot) abstractSharedFlowSlot;
                    long j = sharedFlowSlot.index;
                    if (j >= 0 && j < newHead) {
                        sharedFlowSlot.index = newHead;
                    }
                }
            }
        }
        this.minCollectorIndex = newHead;
    }

    @Override // kotlinx.coroutines.flow.internal.AbstractSharedFlow
    @org.jetbrains.annotations.NotNull
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public kotlinx.coroutines.flow.SharedFlowSlot createSlot() {
        return new kotlinx.coroutines.flow.SharedFlowSlot();
    }

    @Override // kotlinx.coroutines.flow.internal.AbstractSharedFlow
    @org.jetbrains.annotations.NotNull
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public kotlinx.coroutines.flow.SharedFlowSlot[] createSlotArray(int size) {
        return new kotlinx.coroutines.flow.SharedFlowSlot[size];
    }

    public final void q() {
        java.lang.Object[] objArr = this.buffer;
        kotlin.jvm.internal.Intrinsics.checkNotNull(objArr);
        kotlinx.coroutines.flow.SharedFlowKt.b(objArr, v(), null);
        this.bufferSize--;
        long v = v() + 1;
        if (this.replayIndex < v) {
            this.replayIndex = v;
        }
        if (this.minCollectorIndex < v) {
            n(v);
        }
    }

    public final java.lang.Object r(T t, kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        kotlin.coroutines.Continuation intercepted;
        kotlin.coroutines.Continuation<kotlin.Unit>[] continuationArr;
        kotlinx.coroutines.flow.SharedFlowImpl.Emitter emitter;
        java.lang.Object coroutine_suspended;
        java.lang.Object coroutine_suspended2;
        intercepted = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        kotlinx.coroutines.CancellableContinuationImpl cancellableContinuationImpl = new kotlinx.coroutines.CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        kotlin.coroutines.Continuation<kotlin.Unit>[] continuationArr2 = kotlinx.coroutines.flow.internal.AbstractSharedFlowKt.EMPTY_RESUMES;
        synchronized (this) {
            if (B(t)) {
                cancellableContinuationImpl.resumeWith(kotlin.Result.m156constructorimpl(kotlin.Unit.INSTANCE));
                continuationArr = t(continuationArr2);
                emitter = null;
            } else {
                kotlinx.coroutines.flow.SharedFlowImpl.Emitter emitter2 = new kotlinx.coroutines.flow.SharedFlowImpl.Emitter(this, z() + v(), t, cancellableContinuationImpl);
                s(emitter2);
                this.queueSize++;
                if (this.bufferCapacity == 0) {
                    continuationArr2 = t(continuationArr2);
                }
                continuationArr = continuationArr2;
                emitter = emitter2;
            }
        }
        if (emitter != null) {
            kotlinx.coroutines.CancellableContinuationKt.disposeOnCancellation(cancellableContinuationImpl, emitter);
        }
        int length = continuationArr.length;
        int i = 0;
        while (i < length) {
            kotlin.coroutines.Continuation<kotlin.Unit> continuation2 = continuationArr[i];
            i++;
            if (continuation2 != null) {
                continuation2.resumeWith(kotlin.Result.m156constructorimpl(kotlin.Unit.INSTANCE));
            }
        }
        java.lang.Object result = cancellableContinuationImpl.getResult();
        coroutine_suspended = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
            kotlin.coroutines.jvm.internal.DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        coroutine_suspended2 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        return result == coroutine_suspended2 ? result : kotlin.Unit.INSTANCE;
    }

    @Override // kotlinx.coroutines.flow.MutableSharedFlow
    public void resetReplayCache() {
        synchronized (this) {
            F(u(), this.minCollectorIndex, u(), x());
            kotlin.Unit unit = kotlin.Unit.INSTANCE;
        }
    }

    public final void s(java.lang.Object item) {
        int z = z();
        java.lang.Object[] objArr = this.buffer;
        if (objArr == null) {
            objArr = A(null, 0, 2);
        } else if (z >= objArr.length) {
            objArr = A(objArr, z, objArr.length * 2);
        }
        kotlinx.coroutines.flow.SharedFlowKt.b(objArr, v() + z, item);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v6, types: [java.lang.Object, java.lang.Object[]] */
    public final kotlin.coroutines.Continuation<kotlin.Unit>[] t(kotlin.coroutines.Continuation<kotlin.Unit>[] resumesIn) {
        kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot[] abstractSharedFlowSlotArr;
        kotlinx.coroutines.flow.SharedFlowSlot sharedFlowSlot;
        kotlin.coroutines.Continuation<? super kotlin.Unit> continuation;
        int length = resumesIn.length;
        if (this.nCollectors != 0 && (abstractSharedFlowSlotArr = this.slots) != null) {
            int length2 = abstractSharedFlowSlotArr.length;
            int i = 0;
            resumesIn = resumesIn;
            while (i < length2) {
                kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot abstractSharedFlowSlot = abstractSharedFlowSlotArr[i];
                if (abstractSharedFlowSlot != null && (continuation = (sharedFlowSlot = (kotlinx.coroutines.flow.SharedFlowSlot) abstractSharedFlowSlot).cont) != null && D(sharedFlowSlot) >= 0) {
                    int length3 = resumesIn.length;
                    resumesIn = resumesIn;
                    if (length >= length3) {
                        ?? copyOf = java.util.Arrays.copyOf(resumesIn, java.lang.Math.max(2, resumesIn.length * 2));
                        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(copyOf, "java.util.Arrays.copyOf(this, newSize)");
                        resumesIn = copyOf;
                    }
                    resumesIn[length] = continuation;
                    sharedFlowSlot.cont = null;
                    length++;
                }
                i++;
                resumesIn = resumesIn;
            }
        }
        return resumesIn;
    }

    @Override // kotlinx.coroutines.flow.MutableSharedFlow
    public boolean tryEmit(T value) {
        int i;
        boolean z;
        kotlin.coroutines.Continuation<kotlin.Unit>[] continuationArr = kotlinx.coroutines.flow.internal.AbstractSharedFlowKt.EMPTY_RESUMES;
        synchronized (this) {
            i = 0;
            if (B(value)) {
                continuationArr = t(continuationArr);
                z = true;
            } else {
                z = false;
            }
        }
        int length = continuationArr.length;
        while (i < length) {
            kotlin.coroutines.Continuation<kotlin.Unit> continuation = continuationArr[i];
            i++;
            if (continuation != null) {
                continuation.resumeWith(kotlin.Result.m156constructorimpl(kotlin.Unit.INSTANCE));
            }
        }
        return z;
    }

    public final long u() {
        return v() + this.bufferSize;
    }

    public final long v() {
        return java.lang.Math.min(this.minCollectorIndex, this.replayIndex);
    }

    public final java.lang.Object w(long index) {
        java.lang.Object a;
        java.lang.Object[] objArr = this.buffer;
        kotlin.jvm.internal.Intrinsics.checkNotNull(objArr);
        a = kotlinx.coroutines.flow.SharedFlowKt.a(objArr, index);
        return a instanceof kotlinx.coroutines.flow.SharedFlowImpl.Emitter ? ((kotlinx.coroutines.flow.SharedFlowImpl.Emitter) a).value : a;
    }

    public final long x() {
        return v() + this.bufferSize + this.queueSize;
    }

    public final int y() {
        return (int) ((v() + this.bufferSize) - this.replayIndex);
    }

    public final int z() {
        return this.bufferSize + this.queueSize;
    }
}
