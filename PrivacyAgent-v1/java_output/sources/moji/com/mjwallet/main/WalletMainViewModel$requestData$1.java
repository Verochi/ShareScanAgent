package moji.com.mjwallet.main;

@kotlin.Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@kotlin.coroutines.jvm.internal.DebugMetadata(c = "moji.com.mjwallet.main.WalletMainViewModel$requestData$1", f = "WalletMainViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes20.dex */
public final class WalletMainViewModel$requestData$1 extends kotlin.coroutines.jvm.internal.SuspendLambda implements kotlin.jvm.functions.Function2<kotlinx.coroutines.CoroutineScope, kotlin.coroutines.Continuation<? super kotlin.Unit>, java.lang.Object> {
    int label;
    final /* synthetic */ moji.com.mjwallet.main.WalletMainViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WalletMainViewModel$requestData$1(moji.com.mjwallet.main.WalletMainViewModel walletMainViewModel, kotlin.coroutines.Continuation<? super moji.com.mjwallet.main.WalletMainViewModel$requestData$1> continuation) {
        super(2, continuation);
        this.this$0 = walletMainViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @org.jetbrains.annotations.NotNull
    public final kotlin.coroutines.Continuation<kotlin.Unit> create(@org.jetbrains.annotations.Nullable java.lang.Object obj, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<?> continuation) {
        return new moji.com.mjwallet.main.WalletMainViewModel$requestData$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    @org.jetbrains.annotations.Nullable
    /* renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public final java.lang.Object mo5invoke(@org.jetbrains.annotations.NotNull kotlinx.coroutines.CoroutineScope coroutineScope, @org.jetbrains.annotations.Nullable kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return ((moji.com.mjwallet.main.WalletMainViewModel$requestData$1) create(coroutineScope, continuation)).invokeSuspend(kotlin.Unit.INSTANCE);
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
            java.lang.Object executeSyncOrThrowException = new com.moji.http.pcd.GetBalanceRequest().executeSyncOrThrowException();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(executeSyncOrThrowException, "GetBalanceRequest().executeSyncOrThrowException()");
            com.moji.http.pcd.BalanceResp balanceResp = (com.moji.http.pcd.BalanceResp) executeSyncOrThrowException;
            if (balanceResp.OK()) {
                this.this$0.getWalletBeanLiveData().postValue(new moji.com.mjwallet.main.WalletBean(true, balanceResp.getBalance(), 0, 4, null));
            } else {
                this.this$0.getWalletBeanLiveData().postValue(new moji.com.mjwallet.main.WalletBean(false, -1L, 602));
            }
            this.this$0.setMGetBalanceRequestRetryCount(0);
        } catch (com.moji.requestcore.MJException e) {
            if (e.getCode() != 604 || this.this$0.getMGetBalanceRequestRetryCount() >= 2) {
                this.this$0.getWalletBeanLiveData().postValue(new moji.com.mjwallet.main.WalletBean(false, -1L, e.getCode()));
            } else {
                moji.com.mjwallet.main.WalletMainViewModel walletMainViewModel = this.this$0;
                walletMainViewModel.setMGetBalanceRequestRetryCount(walletMainViewModel.getMGetBalanceRequestRetryCount() + 1);
                this.this$0.requestData();
            }
            com.moji.tool.log.MJLogger.e(moji.com.mjwallet.main.WalletMainViewModel.TAG, e);
        }
        return kotlin.Unit.INSTANCE;
    }
}
