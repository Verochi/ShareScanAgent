package moji.com.mjwallet.list;

@kotlin.Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@kotlin.coroutines.jvm.internal.DebugMetadata(c = "moji.com.mjwallet.list.RecordListViewModel$requestData$1", f = "RecordListViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes20.dex */
public final class RecordListViewModel$requestData$1 extends kotlin.coroutines.jvm.internal.SuspendLambda implements kotlin.jvm.functions.Function2<kotlinx.coroutines.CoroutineScope, kotlin.coroutines.Continuation<? super kotlin.Unit>, java.lang.Object> {
    final /* synthetic */ java.lang.String $pageCursor;
    final /* synthetic */ int $type;
    int label;
    final /* synthetic */ moji.com.mjwallet.list.RecordListViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RecordListViewModel$requestData$1(moji.com.mjwallet.list.RecordListViewModel recordListViewModel, java.lang.String str, int i, kotlin.coroutines.Continuation<? super moji.com.mjwallet.list.RecordListViewModel$requestData$1> continuation) {
        super(2, continuation);
        this.this$0 = recordListViewModel;
        this.$pageCursor = str;
        this.$type = i;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @org.jetbrains.annotations.NotNull
    public final kotlin.coroutines.Continuation<kotlin.Unit> create(@org.jetbrains.annotations.Nullable java.lang.Object obj, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<?> continuation) {
        return new moji.com.mjwallet.list.RecordListViewModel$requestData$1(this.this$0, this.$pageCursor, this.$type, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    @org.jetbrains.annotations.Nullable
    /* renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public final java.lang.Object mo5invoke(@org.jetbrains.annotations.NotNull kotlinx.coroutines.CoroutineScope coroutineScope, @org.jetbrains.annotations.Nullable kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return ((moji.com.mjwallet.list.RecordListViewModel$requestData$1) create(coroutineScope, continuation)).invokeSuspend(kotlin.Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object obj) {
        java.util.concurrent.atomic.AtomicBoolean atomicBoolean;
        int i;
        java.util.concurrent.atomic.AtomicBoolean atomicBoolean2;
        int i2;
        java.util.concurrent.atomic.AtomicBoolean atomicBoolean3;
        java.util.concurrent.atomic.AtomicBoolean atomicBoolean4;
        java.util.concurrent.atomic.AtomicBoolean atomicBoolean5;
        kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new java.lang.IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        kotlin.ResultKt.throwOnFailure(obj);
        try {
            try {
                atomicBoolean4 = this.this$0.isLoading;
            } catch (com.moji.requestcore.MJException e) {
                if (e.getCode() == 604) {
                    i = this.this$0.mRequestDataRetryCount;
                    if (i < 2) {
                        atomicBoolean2 = this.this$0.isLoading;
                        atomicBoolean2.set(false);
                        moji.com.mjwallet.list.RecordListViewModel recordListViewModel = this.this$0;
                        i2 = recordListViewModel.mRequestDataRetryCount;
                        recordListViewModel.mRequestDataRetryCount = i2 + 1;
                        this.this$0.requestData(this.$pageCursor, this.$type);
                        com.moji.tool.log.MJLogger.e(moji.com.mjwallet.list.RecordListViewModel.TAG, e);
                    }
                }
                this.this$0.getListLiveData().postValue(new moji.com.mjwallet.list.ResponsWraper<>(null, e));
                com.moji.tool.log.MJLogger.e(moji.com.mjwallet.list.RecordListViewModel.TAG, e);
            }
            if (atomicBoolean4.get()) {
                return kotlin.Unit.INSTANCE;
            }
            atomicBoolean5 = this.this$0.isLoading;
            atomicBoolean5.set(true);
            java.lang.Object executeSyncOrThrowException = new com.moji.http.pcd.BillListRequest(10, this.$pageCursor, this.$type).executeSyncOrThrowException();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(executeSyncOrThrowException, "BillListRequest(10, page…uteSyncOrThrowException()");
            com.moji.http.pcd.BillListResp billListResp = (com.moji.http.pcd.BillListResp) executeSyncOrThrowException;
            if (billListResp.OK()) {
                this.this$0.getListLiveData().postValue(new moji.com.mjwallet.list.ResponsWraper<>(billListResp, null));
                this.this$0.mLastCursor = billListResp.getPage_cursor();
            } else {
                this.this$0.getListLiveData().postValue(new moji.com.mjwallet.list.ResponsWraper<>(billListResp, new com.moji.requestcore.MJException(199, "")));
            }
            this.this$0.mRequestDataRetryCount = 0;
            atomicBoolean3 = this.this$0.isLoading;
            atomicBoolean3.set(false);
            return kotlin.Unit.INSTANCE;
        } finally {
            atomicBoolean = this.this$0.isLoading;
            atomicBoolean.set(false);
        }
    }
}
