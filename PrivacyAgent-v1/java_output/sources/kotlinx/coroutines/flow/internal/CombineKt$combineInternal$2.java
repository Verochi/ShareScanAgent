package kotlinx.coroutines.flow.internal;

@kotlin.Metadata(d1 = {"\u0000\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0004\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u00020\u0002H\u008a@"}, d2 = {"R", androidx.exifinterface.media.ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
@kotlin.coroutines.jvm.internal.DebugMetadata(c = "kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2", f = "Combine.kt", i = {0, 0, 0, 0}, l = {57, 79, 82}, m = "invokeSuspend", n = {"latestValues", "resultChannel", "lastReceivedEpoch", "remainingAbsentValues"}, s = {"L$0", "L$1", "L$2", "I$0"})
/* loaded from: classes16.dex */
public final class CombineKt$combineInternal$2 extends kotlin.coroutines.jvm.internal.SuspendLambda implements kotlin.jvm.functions.Function2<kotlinx.coroutines.CoroutineScope, kotlin.coroutines.Continuation<? super kotlin.Unit>, java.lang.Object> {
    final /* synthetic */ kotlin.jvm.functions.Function0<T[]> $arrayFactory;
    final /* synthetic */ kotlinx.coroutines.flow.Flow<T>[] $flows;
    final /* synthetic */ kotlinx.coroutines.flow.FlowCollector<R> $this_combineInternal;
    final /* synthetic */ kotlin.jvm.functions.Function3<kotlinx.coroutines.flow.FlowCollector<? super R>, T[], kotlin.coroutines.Continuation<? super kotlin.Unit>, java.lang.Object> $transform;
    int I$0;
    int I$1;
    private /* synthetic */ java.lang.Object L$0;
    java.lang.Object L$1;
    java.lang.Object L$2;
    int label;

    @kotlin.Metadata(d1 = {"\u0000\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0004\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u00020\u0002H\u008a@"}, d2 = {"R", androidx.exifinterface.media.ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    @kotlin.coroutines.jvm.internal.DebugMetadata(c = "kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2$1", f = "Combine.kt", i = {}, l = {com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.CALL_DOWNLOAD_MODEL_SET_FILE_NAME}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2$1, reason: invalid class name */
    public static final class AnonymousClass1 extends kotlin.coroutines.jvm.internal.SuspendLambda implements kotlin.jvm.functions.Function2<kotlinx.coroutines.CoroutineScope, kotlin.coroutines.Continuation<? super kotlin.Unit>, java.lang.Object> {
        final /* synthetic */ kotlinx.coroutines.flow.Flow<T>[] $flows;
        final /* synthetic */ int $i;
        final /* synthetic */ java.util.concurrent.atomic.AtomicInteger $nonClosed;
        final /* synthetic */ kotlinx.coroutines.channels.Channel<kotlin.collections.IndexedValue<java.lang.Object>> $resultChannel;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(kotlinx.coroutines.flow.Flow<? extends T>[] flowArr, int i, java.util.concurrent.atomic.AtomicInteger atomicInteger, kotlinx.coroutines.channels.Channel<kotlin.collections.IndexedValue<java.lang.Object>> channel, kotlin.coroutines.Continuation<? super kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2.AnonymousClass1> continuation) {
            super(2, continuation);
            this.$flows = flowArr;
            this.$i = i;
            this.$nonClosed = atomicInteger;
            this.$resultChannel = channel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @org.jetbrains.annotations.NotNull
        public final kotlin.coroutines.Continuation<kotlin.Unit> create(@org.jetbrains.annotations.Nullable java.lang.Object obj, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<?> continuation) {
            return new kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2.AnonymousClass1(this.$flows, this.$i, this.$nonClosed, this.$resultChannel, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        @org.jetbrains.annotations.Nullable
        /* renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public final java.lang.Object mo5invoke(@org.jetbrains.annotations.NotNull kotlinx.coroutines.CoroutineScope coroutineScope, @org.jetbrains.annotations.Nullable kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
            return ((kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2.AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(kotlin.Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @org.jetbrains.annotations.Nullable
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object obj) {
            java.lang.Object coroutine_suspended;
            java.util.concurrent.atomic.AtomicInteger atomicInteger;
            coroutine_suspended = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    kotlin.ResultKt.throwOnFailure(obj);
                    kotlinx.coroutines.flow.Flow[] flowArr = this.$flows;
                    int i2 = this.$i;
                    kotlinx.coroutines.flow.Flow flow = flowArr[i2];
                    kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2$1$invokeSuspend$$inlined$collect$1 combineKt$combineInternal$2$1$invokeSuspend$$inlined$collect$1 = new kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2$1$invokeSuspend$$inlined$collect$1(this.$resultChannel, i2);
                    this.label = 1;
                    if (flow.collect(combineKt$combineInternal$2$1$invokeSuspend$$inlined$collect$1, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new java.lang.IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    kotlin.ResultKt.throwOnFailure(obj);
                }
                if (atomicInteger.decrementAndGet() == 0) {
                    kotlinx.coroutines.channels.SendChannel.DefaultImpls.close$default(this.$resultChannel, null, 1, null);
                }
                return kotlin.Unit.INSTANCE;
            } finally {
                if (this.$nonClosed.decrementAndGet() == 0) {
                    kotlinx.coroutines.channels.SendChannel.DefaultImpls.close$default(this.$resultChannel, null, 1, null);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public CombineKt$combineInternal$2(kotlinx.coroutines.flow.Flow<? extends T>[] flowArr, kotlin.jvm.functions.Function0<T[]> function0, kotlin.jvm.functions.Function3<? super kotlinx.coroutines.flow.FlowCollector<? super R>, ? super T[], ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object> function3, kotlinx.coroutines.flow.FlowCollector<? super R> flowCollector, kotlin.coroutines.Continuation<? super kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2> continuation) {
        super(2, continuation);
        this.$flows = flowArr;
        this.$arrayFactory = function0;
        this.$transform = function3;
        this.$this_combineInternal = flowCollector;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @org.jetbrains.annotations.NotNull
    public final kotlin.coroutines.Continuation<kotlin.Unit> create(@org.jetbrains.annotations.Nullable java.lang.Object obj, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<?> continuation) {
        kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2 combineKt$combineInternal$2 = new kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2(this.$flows, this.$arrayFactory, this.$transform, this.$this_combineInternal, continuation);
        combineKt$combineInternal$2.L$0 = obj;
        return combineKt$combineInternal$2;
    }

    @Override // kotlin.jvm.functions.Function2
    @org.jetbrains.annotations.Nullable
    /* renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public final java.lang.Object mo5invoke(@org.jetbrains.annotations.NotNull kotlinx.coroutines.CoroutineScope coroutineScope, @org.jetbrains.annotations.Nullable kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return ((kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2) create(coroutineScope, continuation)).invokeSuspend(kotlin.Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:14:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x00e9 A[LOOP:0: B:16:0x00e9->B:34:?, LOOP_START, PHI: r6 r9
  0x00e9: PHI (r6v6 int) = (r6v5 int), (r6v7 int) binds: [B:13:0x00e4, B:34:?] A[DONT_GENERATE, DONT_INLINE]
  0x00e9: PHI (r9v4 kotlin.collections.IndexedValue) = (r9v3 kotlin.collections.IndexedValue), (r9v17 kotlin.collections.IndexedValue) binds: [B:13:0x00e4, B:34:?] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Type inference failed for: r15v0, types: [kotlinx.coroutines.flow.Flow<T>[], kotlinx.coroutines.flow.Flow[]] */
    /* JADX WARN: Type inference failed for: r2v12, types: [int] */
    /* JADX WARN: Type inference failed for: r2v6, types: [int] */
    /* JADX WARN: Type inference failed for: r2v8, types: [int] */
    /* JADX WARN: Type inference failed for: r6v0, types: [kotlinx.coroutines.flow.Flow<T>[]] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:32:0x015b -> B:8:0x00c8). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object obj) {
        java.lang.Object coroutine_suspended;
        java.lang.Object[] objArr;
        byte b;
        byte[] bArr;
        kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2 combineKt$combineInternal$2;
        int i;
        kotlinx.coroutines.channels.Channel channel;
        java.lang.Object obj2;
        byte b2;
        kotlin.collections.IndexedValue indexedValue;
        coroutine_suspended = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = this.label;
        if (i2 == 0) {
            kotlin.ResultKt.throwOnFailure(obj);
            kotlinx.coroutines.CoroutineScope coroutineScope = (kotlinx.coroutines.CoroutineScope) this.L$0;
            int length = this.$flows.length;
            if (length == 0) {
                return kotlin.Unit.INSTANCE;
            }
            objArr = new java.lang.Object[length];
            kotlin.collections.ArraysKt___ArraysJvmKt.fill$default(objArr, kotlinx.coroutines.flow.internal.NullSurrogateKt.UNINITIALIZED, 0, 0, 6, (java.lang.Object) null);
            kotlinx.coroutines.channels.Channel Channel$default = kotlinx.coroutines.channels.ChannelKt.Channel$default(length, null, null, 6, null);
            java.util.concurrent.atomic.AtomicInteger atomicInteger = new java.util.concurrent.atomic.AtomicInteger(length);
            b = 0;
            if (length > 0) {
                int i3 = 0;
                while (true) {
                    int i4 = i3 + 1;
                    java.util.concurrent.atomic.AtomicInteger atomicInteger2 = atomicInteger;
                    kotlinx.coroutines.BuildersKt__Builders_commonKt.e(coroutineScope, null, null, new kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2.AnonymousClass1(this.$flows, i3, atomicInteger, Channel$default, null), 3, null);
                    if (i4 >= length) {
                        break;
                    }
                    i3 = i4;
                    atomicInteger = atomicInteger2;
                }
            }
            bArr = new byte[length];
            combineKt$combineInternal$2 = this;
            i = length;
            channel = Channel$default;
        } else if (i2 != 1) {
            if (i2 == 2) {
                ?? r2 = this.I$1;
                i = this.I$0;
                byte[] bArr2 = (byte[]) this.L$2;
                kotlinx.coroutines.channels.Channel channel2 = (kotlinx.coroutines.channels.Channel) this.L$1;
                java.lang.Object[] objArr2 = (java.lang.Object[]) this.L$0;
                kotlin.ResultKt.throwOnFailure(obj);
                b = r2;
                bArr = bArr2;
                channel = channel2;
                objArr = objArr2;
            } else {
                if (i2 != 3) {
                    throw new java.lang.IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ?? r22 = this.I$1;
                i = this.I$0;
                byte[] bArr3 = (byte[]) this.L$2;
                kotlinx.coroutines.channels.Channel channel3 = (kotlinx.coroutines.channels.Channel) this.L$1;
                java.lang.Object[] objArr3 = (java.lang.Object[]) this.L$0;
                kotlin.ResultKt.throwOnFailure(obj);
                b = r22;
                bArr = bArr3;
                channel = channel3;
                objArr = objArr3;
            }
            combineKt$combineInternal$2 = this;
        } else {
            ?? r23 = this.I$1;
            i = this.I$0;
            byte[] bArr4 = (byte[]) this.L$2;
            kotlinx.coroutines.channels.Channel channel4 = (kotlinx.coroutines.channels.Channel) this.L$1;
            java.lang.Object[] objArr4 = (java.lang.Object[]) this.L$0;
            kotlin.ResultKt.throwOnFailure(obj);
            obj2 = ((kotlinx.coroutines.channels.ChannelResult) obj).getHolder();
            channel = channel4;
            objArr = objArr4;
            b2 = r23;
            bArr = bArr4;
            combineKt$combineInternal$2 = this;
            indexedValue = (kotlin.collections.IndexedValue) kotlinx.coroutines.channels.ChannelResult.m776getOrNullimpl(obj2);
            if (indexedValue != null) {
                return kotlin.Unit.INSTANCE;
            }
            do {
                int index = indexedValue.getIndex();
                java.lang.Object obj3 = objArr[index];
                objArr[index] = indexedValue.getValue();
                if (obj3 == kotlinx.coroutines.flow.internal.NullSurrogateKt.UNINITIALIZED) {
                    i--;
                }
                if (bArr[index] == b2) {
                    break;
                }
                bArr[index] = b2;
                indexedValue = (kotlin.collections.IndexedValue) kotlinx.coroutines.channels.ChannelResult.m776getOrNullimpl(channel.mo765tryReceivePtdJZtk());
            } while (indexedValue != null);
            if (i == 0) {
                java.lang.Object[] objArr5 = (java.lang.Object[]) combineKt$combineInternal$2.$arrayFactory.invoke();
                if (objArr5 == null) {
                    kotlin.jvm.functions.Function3 function3 = combineKt$combineInternal$2.$transform;
                    java.lang.Object obj4 = combineKt$combineInternal$2.$this_combineInternal;
                    combineKt$combineInternal$2.L$0 = objArr;
                    combineKt$combineInternal$2.L$1 = channel;
                    combineKt$combineInternal$2.L$2 = bArr;
                    combineKt$combineInternal$2.I$0 = i;
                    combineKt$combineInternal$2.I$1 = b2;
                    combineKt$combineInternal$2.label = 2;
                    if (function3.invoke(obj4, objArr, combineKt$combineInternal$2) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    kotlin.collections.ArraysKt___ArraysJvmKt.copyInto$default(objArr, objArr5, 0, 0, 0, 14, (java.lang.Object) null);
                    kotlin.jvm.functions.Function3 function32 = combineKt$combineInternal$2.$transform;
                    java.lang.Object obj5 = combineKt$combineInternal$2.$this_combineInternal;
                    combineKt$combineInternal$2.L$0 = objArr;
                    combineKt$combineInternal$2.L$1 = channel;
                    combineKt$combineInternal$2.L$2 = bArr;
                    combineKt$combineInternal$2.I$0 = i;
                    combineKt$combineInternal$2.I$1 = b2;
                    combineKt$combineInternal$2.label = 3;
                    if (function32.invoke(obj5, objArr5, combineKt$combineInternal$2) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
            }
            b = b2;
        }
        b2 = (byte) (b + 1);
        combineKt$combineInternal$2.L$0 = objArr;
        combineKt$combineInternal$2.L$1 = channel;
        combineKt$combineInternal$2.L$2 = bArr;
        combineKt$combineInternal$2.I$0 = i;
        combineKt$combineInternal$2.I$1 = b2;
        combineKt$combineInternal$2.label = 1;
        obj2 = channel.mo764receiveCatchingJP2dKIU(combineKt$combineInternal$2);
        if (obj2 == coroutine_suspended) {
            return coroutine_suspended;
        }
        indexedValue = (kotlin.collections.IndexedValue) kotlinx.coroutines.channels.ChannelResult.m776getOrNullimpl(obj2);
        if (indexedValue != null) {
        }
    }
}
