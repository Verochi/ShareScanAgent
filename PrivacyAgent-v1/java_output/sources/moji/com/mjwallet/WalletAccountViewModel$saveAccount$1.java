package moji.com.mjwallet;

@kotlin.Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@kotlin.coroutines.jvm.internal.DebugMetadata(c = "moji.com.mjwallet.WalletAccountViewModel$saveAccount$1", f = "WalletAccountViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes20.dex */
public final class WalletAccountViewModel$saveAccount$1 extends kotlin.coroutines.jvm.internal.SuspendLambda implements kotlin.jvm.functions.Function2<kotlinx.coroutines.CoroutineScope, kotlin.coroutines.Continuation<? super kotlin.Unit>, java.lang.Object> {
    final /* synthetic */ java.lang.Long $accountId;
    final /* synthetic */ java.lang.String $account_number;
    final /* synthetic */ java.lang.String $real_name;
    int label;
    final /* synthetic */ moji.com.mjwallet.WalletAccountViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WalletAccountViewModel$saveAccount$1(java.lang.Long l, java.lang.String str, java.lang.String str2, moji.com.mjwallet.WalletAccountViewModel walletAccountViewModel, kotlin.coroutines.Continuation<? super moji.com.mjwallet.WalletAccountViewModel$saveAccount$1> continuation) {
        super(2, continuation);
        this.$accountId = l;
        this.$real_name = str;
        this.$account_number = str2;
        this.this$0 = walletAccountViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @org.jetbrains.annotations.NotNull
    public final kotlin.coroutines.Continuation<kotlin.Unit> create(@org.jetbrains.annotations.Nullable java.lang.Object obj, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<?> continuation) {
        return new moji.com.mjwallet.WalletAccountViewModel$saveAccount$1(this.$accountId, this.$real_name, this.$account_number, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    @org.jetbrains.annotations.Nullable
    /* renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public final java.lang.Object mo5invoke(@org.jetbrains.annotations.NotNull kotlinx.coroutines.CoroutineScope coroutineScope, @org.jetbrains.annotations.Nullable kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return ((moji.com.mjwallet.WalletAccountViewModel$saveAccount$1) create(coroutineScope, continuation)).invokeSuspend(kotlin.Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object obj) {
        kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new java.lang.IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        kotlin.ResultKt.throwOnFailure(obj);
        try {
            java.lang.Object executeSyncOrThrowException = new com.moji.http.pcd.AddReceiptAccountRequest(this.$accountId, this.$real_name, this.$account_number).executeSyncOrThrowException();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(executeSyncOrThrowException, "AddReceiptAccountRequest…uteSyncOrThrowException()");
            if (((com.moji.requestcore.entity.MJBaseRespRc) executeSyncOrThrowException).OK()) {
                this.this$0.getStatusLiveData().postValue(kotlin.coroutines.jvm.internal.Boxing.boxBoolean(true));
            } else {
                this.this$0.getStatusLiveData().postValue(kotlin.coroutines.jvm.internal.Boxing.boxBoolean(false));
            }
            this.this$0.setMSaveAccountRequestRetryCount(0);
        } catch (java.lang.Exception e) {
            if ((e instanceof com.moji.requestcore.MJException) && e.getCode() == 604 && this.this$0.getMSaveAccountRequestRetryCount() < 2) {
                moji.com.mjwallet.WalletAccountViewModel walletAccountViewModel = this.this$0;
                walletAccountViewModel.setMSaveAccountRequestRetryCount(walletAccountViewModel.getMSaveAccountRequestRetryCount() + 1);
                this.this$0.saveAccount(this.$accountId, this.$real_name, this.$account_number);
            } else {
                this.this$0.getStatusLiveData().postValue(kotlin.coroutines.jvm.internal.Boxing.boxBoolean(false));
            }
            com.moji.tool.log.MJLogger.e(moji.com.mjwallet.WalletAccountViewModel.TAG, e);
        }
        return kotlin.Unit.INSTANCE;
    }
}
