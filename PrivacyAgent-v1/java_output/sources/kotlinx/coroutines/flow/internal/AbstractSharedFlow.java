package kotlinx.coroutines.flow.internal;

@kotlin.Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b \u0018\u0000*\f\b\u0000\u0010\u0002*\u0006\u0012\u0002\b\u00030\u00012\u00060\u0003j\u0002`\u0004B\u0007¢\u0006\u0004\b+\u0010\u001aJ\u000f\u0010\u0005\u001a\u00028\u0000H$¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\t2\u0006\u0010\b\u001a\u00020\u0007H$¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00028\u0000H\u0004¢\u0006\u0004\b\f\u0010\u0006J\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00028\u0000H\u0004¢\u0006\u0004\b\u000f\u0010\u0010J\u001d\u0010\u0013\u001a\u00020\u000e2\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u000e0\u0011H\u0084\bR>\u0010\u001b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0018\u00010\t2\u0010\u0010\u0014\u001a\f\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0018\u00010\t8\u0004@BX\u0084\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u0012\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0017\u0010\u0018R$\u0010 \u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00078\u0004@BX\u0084\u000e¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0016\u0010\"\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\u001dR\u001e\u0010&\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010#8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010%R\u0017\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00070'8F¢\u0006\u0006\u001a\u0004\b(\u0010)¨\u0006,"}, d2 = {"Lkotlinx/coroutines/flow/internal/AbstractSharedFlow;", "Lkotlinx/coroutines/flow/internal/AbstractSharedFlowSlot;", androidx.exifinterface.media.ExifInterface.LATITUDE_SOUTH, "", "Lkotlinx/coroutines/internal/SynchronizedObject;", "createSlot", "()Lkotlinx/coroutines/flow/internal/AbstractSharedFlowSlot;", "", com.anythink.core.api.ATAdConst.NETWORK_REQUEST_PARAMS_KEY.BANNER_SIZE, "", "createSlotArray", "(I)[Lkotlinx/coroutines/flow/internal/AbstractSharedFlowSlot;", "allocateSlot", "slot", "", "freeSlot", "(Lkotlinx/coroutines/flow/internal/AbstractSharedFlowSlot;)V", "Lkotlin/Function1;", "block", "forEachSlotLocked", "<set-?>", com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.AD_COUNT, "[Lkotlinx/coroutines/flow/internal/AbstractSharedFlowSlot;", "getSlots", "()[Lkotlinx/coroutines/flow/internal/AbstractSharedFlowSlot;", "getSlots$annotations", "()V", "slots", "t", "I", "getNCollectors", "()I", "nCollectors", com.umeng.analytics.pro.bo.aN, "nextIndex", "Lkotlinx/coroutines/flow/MutableStateFlow;", "v", "Lkotlinx/coroutines/flow/MutableStateFlow;", "_subscriptionCount", "Lkotlinx/coroutines/flow/StateFlow;", "getSubscriptionCount", "()Lkotlinx/coroutines/flow/StateFlow;", "subscriptionCount", "<init>", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes16.dex */
public abstract class AbstractSharedFlow<S extends kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot<?>> {

    /* renamed from: n, reason: from kotlin metadata */
    @org.jetbrains.annotations.Nullable
    public S[] slots;

    /* renamed from: t, reason: from kotlin metadata */
    public int nCollectors;

    /* renamed from: u, reason: from kotlin metadata */
    public int nextIndex;

    /* renamed from: v, reason: from kotlin metadata */
    @org.jetbrains.annotations.Nullable
    public kotlinx.coroutines.flow.MutableStateFlow<java.lang.Integer> _subscriptionCount;

    public static /* synthetic */ void getSlots$annotations() {
    }

    @org.jetbrains.annotations.NotNull
    public final S allocateSlot() {
        S s2;
        kotlinx.coroutines.flow.MutableStateFlow<java.lang.Integer> mutableStateFlow;
        synchronized (this) {
            S[] slots = getSlots();
            if (slots == null) {
                slots = createSlotArray(2);
                this.slots = slots;
            } else if (getNCollectors() >= slots.length) {
                java.lang.Object[] copyOf = java.util.Arrays.copyOf(slots, slots.length * 2);
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(copyOf, "java.util.Arrays.copyOf(this, newSize)");
                this.slots = (S[]) ((kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot[]) copyOf);
                slots = (S[]) ((kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot[]) copyOf);
            }
            int i = this.nextIndex;
            do {
                s2 = slots[i];
                if (s2 == null) {
                    s2 = createSlot();
                    slots[i] = s2;
                }
                i++;
                if (i >= slots.length) {
                    i = 0;
                }
            } while (!s2.allocateLocked(this));
            this.nextIndex = i;
            this.nCollectors = getNCollectors() + 1;
            mutableStateFlow = this._subscriptionCount;
        }
        if (mutableStateFlow != null) {
            kotlinx.coroutines.flow.StateFlowKt.increment(mutableStateFlow, 1);
        }
        return s2;
    }

    @org.jetbrains.annotations.NotNull
    public abstract S createSlot();

    @org.jetbrains.annotations.NotNull
    public abstract S[] createSlotArray(int size);

    public final void forEachSlotLocked(@org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super S, kotlin.Unit> block) {
        kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot[] abstractSharedFlowSlotArr;
        if (this.nCollectors == 0 || (abstractSharedFlowSlotArr = this.slots) == null) {
            return;
        }
        for (kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot abstractSharedFlowSlot : abstractSharedFlowSlotArr) {
            if (abstractSharedFlowSlot != null) {
                block.invoke(abstractSharedFlowSlot);
            }
        }
    }

    public final void freeSlot(@org.jetbrains.annotations.NotNull S slot) {
        kotlinx.coroutines.flow.MutableStateFlow<java.lang.Integer> mutableStateFlow;
        int i;
        kotlin.coroutines.Continuation<kotlin.Unit>[] freeLocked;
        synchronized (this) {
            this.nCollectors = getNCollectors() - 1;
            mutableStateFlow = this._subscriptionCount;
            i = 0;
            if (getNCollectors() == 0) {
                this.nextIndex = 0;
            }
            freeLocked = slot.freeLocked(this);
        }
        int length = freeLocked.length;
        while (i < length) {
            kotlin.coroutines.Continuation<kotlin.Unit> continuation = freeLocked[i];
            i++;
            if (continuation != null) {
                continuation.resumeWith(kotlin.Result.m156constructorimpl(kotlin.Unit.INSTANCE));
            }
        }
        if (mutableStateFlow == null) {
            return;
        }
        kotlinx.coroutines.flow.StateFlowKt.increment(mutableStateFlow, -1);
    }

    public final int getNCollectors() {
        return this.nCollectors;
    }

    @org.jetbrains.annotations.Nullable
    public final S[] getSlots() {
        return this.slots;
    }

    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Integer> getSubscriptionCount() {
        kotlinx.coroutines.flow.MutableStateFlow<java.lang.Integer> mutableStateFlow;
        synchronized (this) {
            mutableStateFlow = this._subscriptionCount;
            if (mutableStateFlow == null) {
                mutableStateFlow = kotlinx.coroutines.flow.StateFlowKt.MutableStateFlow(java.lang.Integer.valueOf(getNCollectors()));
                this._subscriptionCount = mutableStateFlow;
            }
        }
        return mutableStateFlow;
    }
}
