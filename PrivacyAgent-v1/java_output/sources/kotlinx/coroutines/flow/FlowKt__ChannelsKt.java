package kotlinx.coroutines.flow;

@kotlin.Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a1\u0010\u0005\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a9\u0010\t\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0082@ø\u0001\u0000¢\u0006\u0004\b\t\u0010\n\u001a\u001c\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000b\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0002\u001a\u001c\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u000b\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0002\u001a\u001e\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000b\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u000eH\u0007\u001a0\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u000b2\u0006\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0013\u001a\u00020\u0012H\u0007\u001a&\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u000b2\u0006\u0010\u0011\u001a\u00020\u0010H\u0007\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0016"}, d2 = {androidx.exifinterface.media.ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/FlowCollector;", "Lkotlinx/coroutines/channels/ReceiveChannel;", "channel", "", "f", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlinx/coroutines/channels/ReceiveChannel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "consume", "g", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlinx/coroutines/channels/ReceiveChannel;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/flow/Flow;", "i", "e", "Lkotlinx/coroutines/channels/BroadcastChannel;", "b", "Lkotlinx/coroutines/CoroutineScope;", com.tencent.connect.common.Constants.PARAM_SCOPE, "Lkotlinx/coroutines/CoroutineStart;", com.anythink.expressad.foundation.d.c.bT, "c", "h", "kotlinx-coroutines-core"}, k = 5, mv = {1, 5, 1}, xs = "kotlinx/coroutines/flow/FlowKt")
/* loaded from: classes16.dex */
final /* synthetic */ class FlowKt__ChannelsKt {

    @kotlin.Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[kotlinx.coroutines.channels.BufferOverflow.valuesCustom().length];
            iArr[kotlinx.coroutines.channels.BufferOverflow.SUSPEND.ordinal()] = 1;
            iArr[kotlinx.coroutines.channels.BufferOverflow.DROP_OLDEST.ordinal()] = 2;
            iArr[kotlinx.coroutines.channels.BufferOverflow.DROP_LATEST.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @kotlin.Deprecated(level = kotlin.DeprecationLevel.WARNING, message = "'BroadcastChannel' is obsolete and all coreresponding operators are deprecated in the favour of StateFlow and SharedFlow")
    @org.jetbrains.annotations.NotNull
    public static final <T> kotlinx.coroutines.flow.Flow<T> b(@org.jetbrains.annotations.NotNull kotlinx.coroutines.channels.BroadcastChannel<T> broadcastChannel) {
        return new kotlinx.coroutines.flow.FlowKt__ChannelsKt$asFlow$$inlined$unsafeFlow$1(broadcastChannel);
    }

    @kotlin.Deprecated(level = kotlin.DeprecationLevel.ERROR, message = "Use shareIn operator and the resulting SharedFlow as a replacement for BroadcastChannel", replaceWith = @kotlin.ReplaceWith(expression = "this.shareIn(scope, SharingStarted.Lazily, 0)", imports = {}))
    @org.jetbrains.annotations.NotNull
    public static final <T> kotlinx.coroutines.channels.BroadcastChannel<T> c(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.Flow<? extends T> flow, @org.jetbrains.annotations.NotNull kotlinx.coroutines.CoroutineScope coroutineScope, @org.jetbrains.annotations.NotNull kotlinx.coroutines.CoroutineStart coroutineStart) {
        int produceCapacity$kotlinx_coroutines_core;
        kotlinx.coroutines.flow.internal.ChannelFlow asChannelFlow = kotlinx.coroutines.flow.internal.ChannelFlowKt.asChannelFlow(flow);
        int i = kotlinx.coroutines.flow.FlowKt__ChannelsKt.WhenMappings.$EnumSwitchMapping$0[asChannelFlow.onBufferOverflow.ordinal()];
        if (i == 1) {
            produceCapacity$kotlinx_coroutines_core = asChannelFlow.getProduceCapacity$kotlinx_coroutines_core();
        } else {
            if (i != 2) {
                if (i != 3) {
                    throw new kotlin.NoWhenBranchMatchedException();
                }
                throw new java.lang.IllegalArgumentException("Broadcast channel does not support BufferOverflow.DROP_LATEST");
            }
            produceCapacity$kotlinx_coroutines_core = -1;
        }
        return kotlinx.coroutines.channels.BroadcastKt.broadcast$default(coroutineScope, asChannelFlow.context, produceCapacity$kotlinx_coroutines_core, coroutineStart, null, new kotlinx.coroutines.flow.FlowKt__ChannelsKt$broadcastIn$1(flow, null), 8, null);
    }

    public static /* synthetic */ kotlinx.coroutines.channels.BroadcastChannel d(kotlinx.coroutines.flow.Flow flow, kotlinx.coroutines.CoroutineScope coroutineScope, kotlinx.coroutines.CoroutineStart coroutineStart, int i, java.lang.Object obj) {
        if ((i & 2) != 0) {
            coroutineStart = kotlinx.coroutines.CoroutineStart.LAZY;
        }
        return kotlinx.coroutines.flow.FlowKt.broadcastIn(flow, coroutineScope, coroutineStart);
    }

    @org.jetbrains.annotations.NotNull
    public static final <T> kotlinx.coroutines.flow.Flow<T> e(@org.jetbrains.annotations.NotNull kotlinx.coroutines.channels.ReceiveChannel<? extends T> receiveChannel) {
        return new kotlinx.coroutines.flow.ChannelAsFlow(receiveChannel, true, null, 0, null, 28, null);
    }

    @org.jetbrains.annotations.Nullable
    public static final <T> java.lang.Object f(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.FlowCollector<? super T> flowCollector, @org.jetbrains.annotations.NotNull kotlinx.coroutines.channels.ReceiveChannel<? extends T> receiveChannel, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        java.lang.Object coroutine_suspended;
        java.lang.Object g = g(flowCollector, receiveChannel, true, continuation);
        coroutine_suspended = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        return g == coroutine_suspended ? g : kotlin.Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:17:0x006b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0075 A[Catch: all -> 0x0055, TRY_LEAVE, TryCatch #0 {all -> 0x0055, blocks: (B:12:0x0032, B:20:0x006f, B:22:0x0075, B:28:0x0084, B:30:0x0085, B:46:0x004b), top: B:7:0x0022 }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0085 A[Catch: all -> 0x0055, TRY_LEAVE, TryCatch #0 {all -> 0x0055, blocks: (B:12:0x0032, B:20:0x006f, B:22:0x0075, B:28:0x0084, B:30:0x0085, B:46:0x004b), top: B:7:0x0022 }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0024  */
    /* JADX WARN: Type inference failed for: r6v0, types: [kotlinx.coroutines.flow.FlowCollector, kotlinx.coroutines.flow.FlowCollector<? super T>] */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v18, types: [boolean] */
    /* JADX WARN: Type inference failed for: r6v19, types: [boolean] */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v25 */
    /* JADX WARN: Type inference failed for: r6v26 */
    /* JADX WARN: Type inference failed for: r6v3, types: [boolean] */
    /* JADX WARN: Type inference failed for: r6v8 */
    /* JADX WARN: Type inference failed for: r8v16 */
    /* JADX WARN: Type inference failed for: r8v3, types: [java.lang.Object, kotlinx.coroutines.flow.FlowCollector] */
    /* JADX WARN: Type inference failed for: r8v7 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x0095 -> B:13:0x0035). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <T> java.lang.Object g(kotlinx.coroutines.flow.FlowCollector<? super T> flowCollector, kotlinx.coroutines.channels.ReceiveChannel<? extends T> receiveChannel, boolean z, kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        kotlinx.coroutines.flow.FlowKt__ChannelsKt$emitAllImpl$1 flowKt__ChannelsKt$emitAllImpl$1;
        java.lang.Object coroutine_suspended;
        int i;
        java.lang.Object obj;
        ?? r8;
        java.lang.Object obj2;
        try {
            if (continuation instanceof kotlinx.coroutines.flow.FlowKt__ChannelsKt$emitAllImpl$1) {
                flowKt__ChannelsKt$emitAllImpl$1 = (kotlinx.coroutines.flow.FlowKt__ChannelsKt$emitAllImpl$1) continuation;
                int i2 = flowKt__ChannelsKt$emitAllImpl$1.label;
                if ((i2 & Integer.MIN_VALUE) != 0) {
                    flowKt__ChannelsKt$emitAllImpl$1.label = i2 - Integer.MIN_VALUE;
                    java.lang.Object obj3 = flowKt__ChannelsKt$emitAllImpl$1.result;
                    coroutine_suspended = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = flowKt__ChannelsKt$emitAllImpl$1.label;
                    if (i != 0) {
                        kotlin.ResultKt.throwOnFailure(obj3);
                        kotlinx.coroutines.flow.FlowKt.ensureActive(flowCollector);
                        obj2 = flowCollector;
                        flowKt__ChannelsKt$emitAllImpl$1.L$0 = obj2;
                        flowKt__ChannelsKt$emitAllImpl$1.L$1 = receiveChannel;
                        flowKt__ChannelsKt$emitAllImpl$1.Z$0 = z;
                        flowKt__ChannelsKt$emitAllImpl$1.label = 1;
                        obj = receiveChannel.mo764receiveCatchingJP2dKIU(flowKt__ChannelsKt$emitAllImpl$1);
                        if (obj == coroutine_suspended) {
                        }
                    } else if (i == 1) {
                        boolean z2 = (kotlinx.coroutines.flow.FlowCollector<? super T>) flowKt__ChannelsKt$emitAllImpl$1.Z$0;
                        receiveChannel = (kotlinx.coroutines.channels.ReceiveChannel) flowKt__ChannelsKt$emitAllImpl$1.L$1;
                        kotlinx.coroutines.flow.FlowCollector flowCollector2 = (kotlinx.coroutines.flow.FlowCollector) flowKt__ChannelsKt$emitAllImpl$1.L$0;
                        kotlin.ResultKt.throwOnFailure(obj3);
                        obj = ((kotlinx.coroutines.channels.ChannelResult) obj3).getHolder();
                        flowCollector = z2;
                        r8 = flowCollector2;
                        if (!kotlinx.coroutines.channels.ChannelResult.m779isClosedimpl(obj)) {
                        }
                    } else {
                        if (i != 2) {
                            throw new java.lang.IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        boolean z3 = (kotlinx.coroutines.flow.FlowCollector<? super T>) flowKt__ChannelsKt$emitAllImpl$1.Z$0;
                        receiveChannel = (kotlinx.coroutines.channels.ReceiveChannel) flowKt__ChannelsKt$emitAllImpl$1.L$1;
                        kotlinx.coroutines.flow.FlowCollector flowCollector3 = (kotlinx.coroutines.flow.FlowCollector) flowKt__ChannelsKt$emitAllImpl$1.L$0;
                        kotlin.ResultKt.throwOnFailure(obj3);
                        boolean z4 = z3;
                        kotlinx.coroutines.flow.FlowCollector flowCollector4 = flowCollector3;
                        kotlinx.coroutines.flow.FlowCollector flowCollector5 = flowCollector4;
                        z = z4;
                        obj2 = (kotlinx.coroutines.flow.FlowCollector<? super T>) flowCollector5;
                        try {
                            flowKt__ChannelsKt$emitAllImpl$1.L$0 = obj2;
                            flowKt__ChannelsKt$emitAllImpl$1.L$1 = receiveChannel;
                            flowKt__ChannelsKt$emitAllImpl$1.Z$0 = z;
                            flowKt__ChannelsKt$emitAllImpl$1.label = 1;
                            obj = receiveChannel.mo764receiveCatchingJP2dKIU(flowKt__ChannelsKt$emitAllImpl$1);
                            if (obj == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            boolean z5 = z;
                            r8 = obj2;
                            flowCollector = (kotlinx.coroutines.flow.FlowCollector<? super T>) (z5 ? 1 : 0);
                            if (!kotlinx.coroutines.channels.ChannelResult.m779isClosedimpl(obj)) {
                                java.lang.Throwable m775exceptionOrNullimpl = kotlinx.coroutines.channels.ChannelResult.m775exceptionOrNullimpl(obj);
                                if (m775exceptionOrNullimpl != null) {
                                    throw m775exceptionOrNullimpl;
                                }
                                if (flowCollector != 0) {
                                    kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(receiveChannel, null);
                                }
                                return kotlin.Unit.INSTANCE;
                            }
                            java.lang.Object m777getOrThrowimpl = kotlinx.coroutines.channels.ChannelResult.m777getOrThrowimpl(obj);
                            flowKt__ChannelsKt$emitAllImpl$1.L$0 = r8;
                            flowKt__ChannelsKt$emitAllImpl$1.L$1 = receiveChannel;
                            flowKt__ChannelsKt$emitAllImpl$1.Z$0 = (boolean) flowCollector;
                            flowKt__ChannelsKt$emitAllImpl$1.label = 2;
                            java.lang.Object emit = r8.emit(m777getOrThrowimpl, flowKt__ChannelsKt$emitAllImpl$1);
                            z4 = flowCollector;
                            flowCollector4 = r8;
                            if (emit == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            kotlinx.coroutines.flow.FlowCollector flowCollector52 = flowCollector4;
                            z = z4;
                            obj2 = (kotlinx.coroutines.flow.FlowCollector<? super T>) flowCollector52;
                            flowKt__ChannelsKt$emitAllImpl$1.L$0 = obj2;
                            flowKt__ChannelsKt$emitAllImpl$1.L$1 = receiveChannel;
                            flowKt__ChannelsKt$emitAllImpl$1.Z$0 = z;
                            flowKt__ChannelsKt$emitAllImpl$1.label = 1;
                            obj = receiveChannel.mo764receiveCatchingJP2dKIU(flowKt__ChannelsKt$emitAllImpl$1);
                            if (obj == coroutine_suspended) {
                            }
                        } catch (java.lang.Throwable th) {
                            boolean z6 = z;
                            th = th;
                            flowCollector = z6;
                            try {
                                throw th;
                            } catch (java.lang.Throwable th2) {
                                if (flowCollector != 0) {
                                    kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(receiveChannel, th);
                                }
                                throw th2;
                            }
                        }
                    }
                }
            }
            if (i != 0) {
            }
        } catch (java.lang.Throwable th3) {
            th = th3;
        }
        flowKt__ChannelsKt$emitAllImpl$1 = new kotlinx.coroutines.flow.FlowKt__ChannelsKt$emitAllImpl$1(continuation);
        java.lang.Object obj32 = flowKt__ChannelsKt$emitAllImpl$1.result;
        coroutine_suspended = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = flowKt__ChannelsKt$emitAllImpl$1.label;
    }

    @kotlinx.coroutines.FlowPreview
    @org.jetbrains.annotations.NotNull
    public static final <T> kotlinx.coroutines.channels.ReceiveChannel<T> h(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.Flow<? extends T> flow, @org.jetbrains.annotations.NotNull kotlinx.coroutines.CoroutineScope coroutineScope) {
        return kotlinx.coroutines.flow.internal.ChannelFlowKt.asChannelFlow(flow).produceImpl(coroutineScope);
    }

    @org.jetbrains.annotations.NotNull
    public static final <T> kotlinx.coroutines.flow.Flow<T> i(@org.jetbrains.annotations.NotNull kotlinx.coroutines.channels.ReceiveChannel<? extends T> receiveChannel) {
        return new kotlinx.coroutines.flow.ChannelAsFlow(receiveChannel, false, null, 0, null, 28, null);
    }
}
