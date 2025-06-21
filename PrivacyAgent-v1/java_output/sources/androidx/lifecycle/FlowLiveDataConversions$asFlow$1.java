package androidx.lifecycle;

/* JADX INFO: Add missing generic type declarations: [T] */
@kotlin.Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u008a@"}, d2 = {androidx.exifinterface.media.ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/FlowCollector;", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
@kotlin.coroutines.jvm.internal.DebugMetadata(c = "androidx.lifecycle.FlowLiveDataConversions$asFlow$1", f = "FlowLiveData.kt", i = {0, 0, 0, 1, 1, 2, 2}, l = {98, 102, 103}, m = "invokeSuspend", n = {"$this$flow", "channel", "observer", "$this$flow", "observer", "$this$flow", "observer"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$0", "L$1"})
/* loaded from: classes.dex */
public final class FlowLiveDataConversions$asFlow$1<T> extends kotlin.coroutines.jvm.internal.SuspendLambda implements kotlin.jvm.functions.Function2<kotlinx.coroutines.flow.FlowCollector<? super T>, kotlin.coroutines.Continuation<? super kotlin.Unit>, java.lang.Object> {
    final /* synthetic */ androidx.lifecycle.LiveData<T> $this_asFlow;
    private /* synthetic */ java.lang.Object L$0;
    java.lang.Object L$1;
    java.lang.Object L$2;
    int label;

    @kotlin.Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H\u008a@"}, d2 = {androidx.exifinterface.media.ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    @kotlin.coroutines.jvm.internal.DebugMetadata(c = "androidx.lifecycle.FlowLiveDataConversions$asFlow$1$1", f = "FlowLiveData.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: androidx.lifecycle.FlowLiveDataConversions$asFlow$1$1, reason: invalid class name */
    public static final class AnonymousClass1 extends kotlin.coroutines.jvm.internal.SuspendLambda implements kotlin.jvm.functions.Function2<kotlinx.coroutines.CoroutineScope, kotlin.coroutines.Continuation<? super kotlin.Unit>, java.lang.Object> {
        final /* synthetic */ androidx.lifecycle.Observer<T> $observer;
        final /* synthetic */ androidx.lifecycle.LiveData<T> $this_asFlow;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(androidx.lifecycle.LiveData<T> liveData, androidx.lifecycle.Observer<T> observer, kotlin.coroutines.Continuation<? super androidx.lifecycle.FlowLiveDataConversions$asFlow$1.AnonymousClass1> continuation) {
            super(2, continuation);
            this.$this_asFlow = liveData;
            this.$observer = observer;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @org.jetbrains.annotations.NotNull
        public final kotlin.coroutines.Continuation<kotlin.Unit> create(@org.jetbrains.annotations.Nullable java.lang.Object obj, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<?> continuation) {
            return new androidx.lifecycle.FlowLiveDataConversions$asFlow$1.AnonymousClass1(this.$this_asFlow, this.$observer, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        @org.jetbrains.annotations.Nullable
        /* renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public final java.lang.Object mo5invoke(@org.jetbrains.annotations.NotNull kotlinx.coroutines.CoroutineScope coroutineScope, @org.jetbrains.annotations.Nullable kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
            return ((androidx.lifecycle.FlowLiveDataConversions$asFlow$1.AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(kotlin.Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @org.jetbrains.annotations.Nullable
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object obj) {
            kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new java.lang.IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.ResultKt.throwOnFailure(obj);
            this.$this_asFlow.observeForever(this.$observer);
            return kotlin.Unit.INSTANCE;
        }
    }

    @kotlin.Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H\u008a@"}, d2 = {androidx.exifinterface.media.ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    @kotlin.coroutines.jvm.internal.DebugMetadata(c = "androidx.lifecycle.FlowLiveDataConversions$asFlow$1$2", f = "FlowLiveData.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: androidx.lifecycle.FlowLiveDataConversions$asFlow$1$2, reason: invalid class name */
    public static final class AnonymousClass2 extends kotlin.coroutines.jvm.internal.SuspendLambda implements kotlin.jvm.functions.Function2<kotlinx.coroutines.CoroutineScope, kotlin.coroutines.Continuation<? super kotlin.Unit>, java.lang.Object> {
        final /* synthetic */ androidx.lifecycle.Observer<T> $observer;
        final /* synthetic */ androidx.lifecycle.LiveData<T> $this_asFlow;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(androidx.lifecycle.LiveData<T> liveData, androidx.lifecycle.Observer<T> observer, kotlin.coroutines.Continuation<? super androidx.lifecycle.FlowLiveDataConversions$asFlow$1.AnonymousClass2> continuation) {
            super(2, continuation);
            this.$this_asFlow = liveData;
            this.$observer = observer;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @org.jetbrains.annotations.NotNull
        public final kotlin.coroutines.Continuation<kotlin.Unit> create(@org.jetbrains.annotations.Nullable java.lang.Object obj, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<?> continuation) {
            return new androidx.lifecycle.FlowLiveDataConversions$asFlow$1.AnonymousClass2(this.$this_asFlow, this.$observer, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        @org.jetbrains.annotations.Nullable
        /* renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public final java.lang.Object mo5invoke(@org.jetbrains.annotations.NotNull kotlinx.coroutines.CoroutineScope coroutineScope, @org.jetbrains.annotations.Nullable kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
            return ((androidx.lifecycle.FlowLiveDataConversions$asFlow$1.AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(kotlin.Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @org.jetbrains.annotations.Nullable
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object obj) {
            kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new java.lang.IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.ResultKt.throwOnFailure(obj);
            this.$this_asFlow.removeObserver(this.$observer);
            return kotlin.Unit.INSTANCE;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlowLiveDataConversions$asFlow$1(androidx.lifecycle.LiveData<T> liveData, kotlin.coroutines.Continuation<? super androidx.lifecycle.FlowLiveDataConversions$asFlow$1> continuation) {
        super(2, continuation);
        this.$this_asFlow = liveData;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @org.jetbrains.annotations.NotNull
    public final kotlin.coroutines.Continuation<kotlin.Unit> create(@org.jetbrains.annotations.Nullable java.lang.Object obj, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<?> continuation) {
        androidx.lifecycle.FlowLiveDataConversions$asFlow$1 flowLiveDataConversions$asFlow$1 = new androidx.lifecycle.FlowLiveDataConversions$asFlow$1(this.$this_asFlow, continuation);
        flowLiveDataConversions$asFlow$1.L$0 = obj;
        return flowLiveDataConversions$asFlow$1;
    }

    @Override // kotlin.jvm.functions.Function2
    @org.jetbrains.annotations.Nullable
    /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
    public final java.lang.Object mo5invoke(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.FlowCollector<? super T> flowCollector, @org.jetbrains.annotations.Nullable kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return ((androidx.lifecycle.FlowLiveDataConversions$asFlow$1) create(flowCollector, continuation)).invokeSuspend(kotlin.Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0099 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00a7 A[Catch: all -> 0x00d8, TRY_LEAVE, TryCatch #0 {all -> 0x00d8, blocks: (B:16:0x009f, B:18:0x00a7), top: B:15:0x009f }] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00be  */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v22 */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v4, types: [androidx.lifecycle.Observer] */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v8, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v3, types: [java.lang.Object, kotlinx.coroutines.flow.FlowCollector] */
    /* JADX WARN: Type inference failed for: r7v6 */
    /* JADX WARN: Type inference failed for: r7v7 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x00ba -> B:9:0x008b). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object obj) {
        java.lang.Object coroutine_suspended;
        kotlinx.coroutines.flow.FlowCollector flowCollector;
        androidx.lifecycle.Observer flowLiveDataConversions$asFlow$1$observer$1;
        kotlinx.coroutines.channels.Channel channel;
        java.lang.Throwable th;
        androidx.lifecycle.FlowLiveDataConversions$asFlow$1<T> flowLiveDataConversions$asFlow$1;
        ?? r7;
        androidx.lifecycle.Observer observer;
        kotlinx.coroutines.channels.ChannelIterator channelIterator;
        kotlinx.coroutines.channels.ChannelIterator channelIterator2;
        java.lang.Object hasNext;
        androidx.lifecycle.Observer observer2;
        coroutine_suspended = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        ?? r4 = 1;
        try {
            try {
                if (i == 0) {
                    kotlin.ResultKt.throwOnFailure(obj);
                    flowCollector = (kotlinx.coroutines.flow.FlowCollector) this.L$0;
                    kotlinx.coroutines.channels.Channel Channel$default = kotlinx.coroutines.channels.ChannelKt.Channel$default(-1, null, null, 6, null);
                    flowLiveDataConversions$asFlow$1$observer$1 = new androidx.lifecycle.FlowLiveDataConversions$asFlow$1$observer$1(Channel$default);
                    kotlinx.coroutines.MainCoroutineDispatcher immediate = kotlinx.coroutines.Dispatchers.getMain().getImmediate();
                    androidx.lifecycle.FlowLiveDataConversions$asFlow$1.AnonymousClass1 anonymousClass1 = new androidx.lifecycle.FlowLiveDataConversions$asFlow$1.AnonymousClass1(this.$this_asFlow, flowLiveDataConversions$asFlow$1$observer$1, null);
                    this.L$0 = flowCollector;
                    this.L$1 = Channel$default;
                    this.L$2 = flowLiveDataConversions$asFlow$1$observer$1;
                    this.label = 1;
                    if (kotlinx.coroutines.BuildersKt.withContext(immediate, anonymousClass1, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    channel = Channel$default;
                } else if (i != 1) {
                    try {
                        if (i == 2) {
                            kotlinx.coroutines.channels.ChannelIterator channelIterator3 = (kotlinx.coroutines.channels.ChannelIterator) this.L$2;
                            androidx.lifecycle.Observer observer3 = (androidx.lifecycle.Observer) this.L$1;
                            kotlinx.coroutines.flow.FlowCollector flowCollector2 = (kotlinx.coroutines.flow.FlowCollector) this.L$0;
                            kotlin.ResultKt.throwOnFailure(obj);
                            r7 = flowCollector2;
                            observer = observer3;
                            channelIterator = channelIterator3;
                            flowLiveDataConversions$asFlow$1 = this;
                            if (((java.lang.Boolean) obj).booleanValue()) {
                            }
                        } else {
                            if (i != 3) {
                                throw new java.lang.IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            kotlinx.coroutines.channels.ChannelIterator channelIterator4 = (kotlinx.coroutines.channels.ChannelIterator) this.L$2;
                            androidx.lifecycle.Observer observer4 = (androidx.lifecycle.Observer) this.L$1;
                            flowCollector = (kotlinx.coroutines.flow.FlowCollector) this.L$0;
                            kotlin.ResultKt.throwOnFailure(obj);
                            channelIterator2 = channelIterator4;
                            observer2 = observer4;
                            flowLiveDataConversions$asFlow$1 = this;
                            r4 = observer2;
                            flowLiveDataConversions$asFlow$1.L$0 = flowCollector;
                            flowLiveDataConversions$asFlow$1.L$1 = r4;
                            flowLiveDataConversions$asFlow$1.L$2 = channelIterator2;
                            flowLiveDataConversions$asFlow$1.label = 2;
                            hasNext = channelIterator2.hasNext(flowLiveDataConversions$asFlow$1);
                            if (hasNext == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            androidx.lifecycle.Observer observer5 = r4;
                            channelIterator = channelIterator2;
                            obj = hasNext;
                            r7 = flowCollector;
                            observer = observer5;
                            try {
                                if (((java.lang.Boolean) obj).booleanValue()) {
                                    kotlinx.coroutines.BuildersKt__Builders_commonKt.e(kotlinx.coroutines.GlobalScope.INSTANCE, kotlinx.coroutines.Dispatchers.getMain().getImmediate(), null, new androidx.lifecycle.FlowLiveDataConversions$asFlow$1.AnonymousClass2(flowLiveDataConversions$asFlow$1.$this_asFlow, observer, null), 2, null);
                                    return kotlin.Unit.INSTANCE;
                                }
                                java.lang.Object next = channelIterator.next();
                                flowLiveDataConversions$asFlow$1.L$0 = r7;
                                flowLiveDataConversions$asFlow$1.L$1 = observer;
                                flowLiveDataConversions$asFlow$1.L$2 = channelIterator;
                                flowLiveDataConversions$asFlow$1.label = 3;
                                if (r7.emit(next, flowLiveDataConversions$asFlow$1) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                channelIterator2 = channelIterator;
                                r4 = observer;
                                flowCollector = r7;
                                flowLiveDataConversions$asFlow$1.L$0 = flowCollector;
                                flowLiveDataConversions$asFlow$1.L$1 = r4;
                                flowLiveDataConversions$asFlow$1.L$2 = channelIterator2;
                                flowLiveDataConversions$asFlow$1.label = 2;
                                hasNext = channelIterator2.hasNext(flowLiveDataConversions$asFlow$1);
                                if (hasNext == coroutine_suspended) {
                                }
                            } catch (java.lang.Throwable th2) {
                                th = th2;
                                r4 = observer;
                                kotlinx.coroutines.BuildersKt__Builders_commonKt.e(kotlinx.coroutines.GlobalScope.INSTANCE, kotlinx.coroutines.Dispatchers.getMain().getImmediate(), null, new androidx.lifecycle.FlowLiveDataConversions$asFlow$1.AnonymousClass2(flowLiveDataConversions$asFlow$1.$this_asFlow, r4, null), 2, null);
                                throw th;
                            }
                        }
                    } catch (java.lang.Throwable th3) {
                        th = th3;
                        flowLiveDataConversions$asFlow$1 = this;
                        kotlinx.coroutines.BuildersKt__Builders_commonKt.e(kotlinx.coroutines.GlobalScope.INSTANCE, kotlinx.coroutines.Dispatchers.getMain().getImmediate(), null, new androidx.lifecycle.FlowLiveDataConversions$asFlow$1.AnonymousClass2(flowLiveDataConversions$asFlow$1.$this_asFlow, r4, null), 2, null);
                        throw th;
                    }
                } else {
                    flowLiveDataConversions$asFlow$1$observer$1 = (androidx.lifecycle.Observer) this.L$2;
                    channel = (kotlinx.coroutines.channels.Channel) this.L$1;
                    flowCollector = (kotlinx.coroutines.flow.FlowCollector) this.L$0;
                    kotlin.ResultKt.throwOnFailure(obj);
                }
                flowLiveDataConversions$asFlow$1.L$0 = flowCollector;
                flowLiveDataConversions$asFlow$1.L$1 = r4;
                flowLiveDataConversions$asFlow$1.L$2 = channelIterator2;
                flowLiveDataConversions$asFlow$1.label = 2;
                hasNext = channelIterator2.hasNext(flowLiveDataConversions$asFlow$1);
                if (hasNext == coroutine_suspended) {
                }
            } catch (java.lang.Throwable th4) {
                th = th4;
                kotlinx.coroutines.BuildersKt__Builders_commonKt.e(kotlinx.coroutines.GlobalScope.INSTANCE, kotlinx.coroutines.Dispatchers.getMain().getImmediate(), null, new androidx.lifecycle.FlowLiveDataConversions$asFlow$1.AnonymousClass2(flowLiveDataConversions$asFlow$1.$this_asFlow, r4, null), 2, null);
                throw th;
            }
            channelIterator2 = channel.iterator();
            observer2 = flowLiveDataConversions$asFlow$1$observer$1;
            flowLiveDataConversions$asFlow$1 = this;
            r4 = observer2;
        } catch (java.lang.Throwable th5) {
            th = th5;
            r4 = flowLiveDataConversions$asFlow$1$observer$1;
            flowLiveDataConversions$asFlow$1 = this;
            kotlinx.coroutines.BuildersKt__Builders_commonKt.e(kotlinx.coroutines.GlobalScope.INSTANCE, kotlinx.coroutines.Dispatchers.getMain().getImmediate(), null, new androidx.lifecycle.FlowLiveDataConversions$asFlow$1.AnonymousClass2(flowLiveDataConversions$asFlow$1.$this_asFlow, r4, null), 2, null);
            throw th;
        }
    }
}
