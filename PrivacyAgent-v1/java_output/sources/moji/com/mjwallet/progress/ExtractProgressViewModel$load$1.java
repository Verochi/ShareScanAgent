package moji.com.mjwallet.progress;

@kotlin.Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@kotlin.coroutines.jvm.internal.DebugMetadata(c = "moji.com.mjwallet.progress.ExtractProgressViewModel$load$1", f = "ExtractProgressViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes20.dex */
public final class ExtractProgressViewModel$load$1 extends kotlin.coroutines.jvm.internal.SuspendLambda implements kotlin.jvm.functions.Function2<kotlinx.coroutines.CoroutineScope, kotlin.coroutines.Continuation<? super kotlin.Unit>, java.lang.Object> {
    final /* synthetic */ boolean $append;
    int label;
    final /* synthetic */ moji.com.mjwallet.progress.ExtractProgressViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ExtractProgressViewModel$load$1(moji.com.mjwallet.progress.ExtractProgressViewModel extractProgressViewModel, boolean z, kotlin.coroutines.Continuation<? super moji.com.mjwallet.progress.ExtractProgressViewModel$load$1> continuation) {
        super(2, continuation);
        this.this$0 = extractProgressViewModel;
        this.$append = z;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @org.jetbrains.annotations.NotNull
    public final kotlin.coroutines.Continuation<kotlin.Unit> create(@org.jetbrains.annotations.Nullable java.lang.Object obj, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<?> continuation) {
        return new moji.com.mjwallet.progress.ExtractProgressViewModel$load$1(this.this$0, this.$append, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    @org.jetbrains.annotations.Nullable
    /* renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public final java.lang.Object mo5invoke(@org.jetbrains.annotations.NotNull kotlinx.coroutines.CoroutineScope coroutineScope, @org.jetbrains.annotations.Nullable kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return ((moji.com.mjwallet.progress.ExtractProgressViewModel$load$1) create(coroutineScope, continuation)).invokeSuspend(kotlin.Unit.INSTANCE);
    }

    /* JADX WARN: Finally extract failed */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object obj) {
        java.util.concurrent.atomic.AtomicBoolean atomicBoolean;
        java.util.concurrent.atomic.AtomicBoolean atomicBoolean2;
        java.util.concurrent.atomic.AtomicBoolean atomicBoolean3;
        java.util.concurrent.atomic.AtomicBoolean atomicBoolean4;
        java.util.concurrent.atomic.AtomicBoolean atomicBoolean5;
        java.util.concurrent.atomic.AtomicBoolean atomicBoolean6;
        kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new java.lang.IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        kotlin.ResultKt.throwOnFailure(obj);
        try {
            try {
                atomicBoolean4 = this.this$0.mIsLoading;
            } catch (com.moji.requestcore.MJException e) {
                if (e.getCode() != 604 || this.this$0.getMLoadRetryCount() >= 2) {
                    this.this$0.getListLiveData().postValue(new moji.com.mjwallet.progress.ExtractProgressViewModel.DataResult(null, e.getCode(), this.$append));
                } else {
                    moji.com.mjwallet.progress.ExtractProgressViewModel extractProgressViewModel = this.this$0;
                    extractProgressViewModel.setMLoadRetryCount(extractProgressViewModel.getMLoadRetryCount() + 1);
                    atomicBoolean2 = this.this$0.mIsLoading;
                    atomicBoolean2.set(false);
                    this.this$0.load(this.$append);
                }
                com.moji.tool.log.MJLogger.e(moji.com.mjwallet.progress.ExtractProgressViewModel.TAG, e);
            }
            if (atomicBoolean4.get()) {
                kotlin.Unit unit = kotlin.Unit.INSTANCE;
                atomicBoolean6 = this.this$0.mIsLoading;
                atomicBoolean6.set(false);
                return unit;
            }
            atomicBoolean5 = this.this$0.mIsLoading;
            atomicBoolean5.set(true);
            java.lang.Object executeSyncOrThrowException = new com.moji.http.pcd.ExtractDetailRequest(5, this.this$0.getPageCursor()).executeSyncOrThrowException();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(executeSyncOrThrowException, "ExtractDetailRequest(5, …uteSyncOrThrowException()");
            com.moji.http.pcd.ExtractDetailResp extractDetailResp = (com.moji.http.pcd.ExtractDetailResp) executeSyncOrThrowException;
            if (extractDetailResp.OK()) {
                this.this$0.setPageCursor(extractDetailResp.getPage_cursor());
                this.this$0.getListLiveData().postValue(new moji.com.mjwallet.progress.ExtractProgressViewModel.DataResult(extractDetailResp, 0, this.$append));
            } else {
                this.this$0.getListLiveData().postValue(new moji.com.mjwallet.progress.ExtractProgressViewModel.DataResult(null, 602, this.$append));
            }
            this.this$0.setMLoadRetryCount(0);
            atomicBoolean3 = this.this$0.mIsLoading;
            atomicBoolean3.set(false);
            return kotlin.Unit.INSTANCE;
        } catch (java.lang.Throwable th) {
            atomicBoolean = this.this$0.mIsLoading;
            atomicBoolean.set(false);
            throw th;
        }
    }
}
