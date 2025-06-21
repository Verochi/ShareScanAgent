package kotlinx.coroutines.flow;

@kotlin.Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0005\u001a\u00020\u0004*\b\u0012\u0004\u0012\u00020\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u008a@"}, d2 = {"Lkotlinx/coroutines/flow/FlowCollector;", "Lkotlinx/coroutines/flow/SharingCommand;", "", me.leolin.shortcutbadger.impl.NewHtcHomeBadger.COUNT, "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
@kotlin.coroutines.jvm.internal.DebugMetadata(c = "kotlinx.coroutines.flow.StartedWhileSubscribed$command$1", f = "SharingStarted.kt", i = {1, 2, 3}, l = {179, 181, 183, 184, 186}, m = "invokeSuspend", n = {"$this$transformLatest", "$this$transformLatest", "$this$transformLatest"}, s = {"L$0", "L$0", "L$0"})
/* loaded from: classes16.dex */
public final class StartedWhileSubscribed$command$1 extends kotlin.coroutines.jvm.internal.SuspendLambda implements kotlin.jvm.functions.Function3<kotlinx.coroutines.flow.FlowCollector<? super kotlinx.coroutines.flow.SharingCommand>, java.lang.Integer, kotlin.coroutines.Continuation<? super kotlin.Unit>, java.lang.Object> {
    /* synthetic */ int I$0;
    private /* synthetic */ java.lang.Object L$0;
    int label;
    final /* synthetic */ kotlinx.coroutines.flow.StartedWhileSubscribed this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StartedWhileSubscribed$command$1(kotlinx.coroutines.flow.StartedWhileSubscribed startedWhileSubscribed, kotlin.coroutines.Continuation<? super kotlinx.coroutines.flow.StartedWhileSubscribed$command$1> continuation) {
        super(3, continuation);
        this.this$0 = startedWhileSubscribed;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ java.lang.Object invoke(kotlinx.coroutines.flow.FlowCollector<? super kotlinx.coroutines.flow.SharingCommand> flowCollector, java.lang.Integer num, kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return invoke(flowCollector, num.intValue(), continuation);
    }

    @org.jetbrains.annotations.Nullable
    public final java.lang.Object invoke(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.FlowCollector<? super kotlinx.coroutines.flow.SharingCommand> flowCollector, int i, @org.jetbrains.annotations.Nullable kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        kotlinx.coroutines.flow.StartedWhileSubscribed$command$1 startedWhileSubscribed$command$1 = new kotlinx.coroutines.flow.StartedWhileSubscribed$command$1(this.this$0, continuation);
        startedWhileSubscribed$command$1.L$0 = flowCollector;
        startedWhileSubscribed$command$1.I$0 = i;
        return startedWhileSubscribed$command$1.invokeSuspend(kotlin.Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x009b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x008d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0070  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object obj) {
        java.lang.Object coroutine_suspended;
        kotlinx.coroutines.flow.FlowCollector flowCollector;
        long j;
        long j2;
        long j3;
        kotlinx.coroutines.flow.SharingCommand sharingCommand;
        coroutine_suspended = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            kotlin.ResultKt.throwOnFailure(obj);
            flowCollector = (kotlinx.coroutines.flow.FlowCollector) this.L$0;
            if (this.I$0 > 0) {
                kotlinx.coroutines.flow.SharingCommand sharingCommand2 = kotlinx.coroutines.flow.SharingCommand.START;
                this.label = 1;
                if (flowCollector.emit(sharingCommand2, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return kotlin.Unit.INSTANCE;
            }
            j = this.this$0.stopTimeout;
            this.L$0 = flowCollector;
            this.label = 2;
            if (kotlinx.coroutines.DelayKt.delay(j, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            j2 = this.this$0.replayExpiration;
            if (j2 > 0) {
            }
            sharingCommand = kotlinx.coroutines.flow.SharingCommand.STOP_AND_RESET_REPLAY_CACHE;
            this.L$0 = null;
            this.label = 5;
            if (flowCollector.emit(sharingCommand, this) == coroutine_suspended) {
            }
            return kotlin.Unit.INSTANCE;
        }
        if (i != 1) {
            if (i == 2) {
                flowCollector = (kotlinx.coroutines.flow.FlowCollector) this.L$0;
                kotlin.ResultKt.throwOnFailure(obj);
                j2 = this.this$0.replayExpiration;
                if (j2 > 0) {
                    kotlinx.coroutines.flow.SharingCommand sharingCommand3 = kotlinx.coroutines.flow.SharingCommand.STOP;
                    this.L$0 = flowCollector;
                    this.label = 3;
                    if (flowCollector.emit(sharingCommand3, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    j3 = this.this$0.replayExpiration;
                    this.L$0 = flowCollector;
                    this.label = 4;
                    if (kotlinx.coroutines.DelayKt.delay(j3, this) == coroutine_suspended) {
                    }
                }
                sharingCommand = kotlinx.coroutines.flow.SharingCommand.STOP_AND_RESET_REPLAY_CACHE;
                this.L$0 = null;
                this.label = 5;
                if (flowCollector.emit(sharingCommand, this) == coroutine_suspended) {
                }
                return kotlin.Unit.INSTANCE;
            }
            if (i == 3) {
                flowCollector = (kotlinx.coroutines.flow.FlowCollector) this.L$0;
                kotlin.ResultKt.throwOnFailure(obj);
                j3 = this.this$0.replayExpiration;
                this.L$0 = flowCollector;
                this.label = 4;
                if (kotlinx.coroutines.DelayKt.delay(j3, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                sharingCommand = kotlinx.coroutines.flow.SharingCommand.STOP_AND_RESET_REPLAY_CACHE;
                this.L$0 = null;
                this.label = 5;
                if (flowCollector.emit(sharingCommand, this) == coroutine_suspended) {
                }
                return kotlin.Unit.INSTANCE;
            }
            if (i == 4) {
                flowCollector = (kotlinx.coroutines.flow.FlowCollector) this.L$0;
                kotlin.ResultKt.throwOnFailure(obj);
                sharingCommand = kotlinx.coroutines.flow.SharingCommand.STOP_AND_RESET_REPLAY_CACHE;
                this.L$0 = null;
                this.label = 5;
                if (flowCollector.emit(sharingCommand, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return kotlin.Unit.INSTANCE;
            }
            if (i != 5) {
                throw new java.lang.IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
        kotlin.ResultKt.throwOnFailure(obj);
        return kotlin.Unit.INSTANCE;
    }
}
