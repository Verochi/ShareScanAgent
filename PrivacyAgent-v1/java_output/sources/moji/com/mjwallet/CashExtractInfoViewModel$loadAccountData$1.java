package moji.com.mjwallet;

@kotlin.Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@kotlin.coroutines.jvm.internal.DebugMetadata(c = "moji.com.mjwallet.CashExtractInfoViewModel$loadAccountData$1", f = "CashExtractInfoViewModel.kt", i = {}, l = {55, 55}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes20.dex */
public final class CashExtractInfoViewModel$loadAccountData$1 extends kotlin.coroutines.jvm.internal.SuspendLambda implements kotlin.jvm.functions.Function2<kotlinx.coroutines.CoroutineScope, kotlin.coroutines.Continuation<? super kotlin.Unit>, java.lang.Object> {
    java.lang.Object L$0;
    java.lang.Object L$1;
    int label;
    final /* synthetic */ moji.com.mjwallet.CashExtractInfoViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CashExtractInfoViewModel$loadAccountData$1(moji.com.mjwallet.CashExtractInfoViewModel cashExtractInfoViewModel, kotlin.coroutines.Continuation<? super moji.com.mjwallet.CashExtractInfoViewModel$loadAccountData$1> continuation) {
        super(2, continuation);
        this.this$0 = cashExtractInfoViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @org.jetbrains.annotations.NotNull
    public final kotlin.coroutines.Continuation<kotlin.Unit> create(@org.jetbrains.annotations.Nullable java.lang.Object obj, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<?> continuation) {
        return new moji.com.mjwallet.CashExtractInfoViewModel$loadAccountData$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    @org.jetbrains.annotations.Nullable
    /* renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public final java.lang.Object mo5invoke(@org.jetbrains.annotations.NotNull kotlinx.coroutines.CoroutineScope coroutineScope, @org.jetbrains.annotations.Nullable kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return ((moji.com.mjwallet.CashExtractInfoViewModel$loadAccountData$1) create(coroutineScope, continuation)).invokeSuspend(kotlin.Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object obj) {
        java.lang.Object coroutine_suspended;
        int i;
        int i2;
        java.lang.Object b;
        moji.com.mjwallet.CashExtractInfoViewModel cashExtractInfoViewModel;
        java.lang.Object a;
        com.moji.http.pcd.BalanceResp balanceResp;
        moji.com.mjwallet.CashExtractInfoViewModel.RequestResult c;
        coroutine_suspended = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        try {
        } catch (com.moji.requestcore.MJException e) {
            com.moji.tool.log.MJLogger.e(moji.com.mjwallet.CashExtractInfoViewModel.TAG, e);
            if (e.getCode() == 604) {
                i = this.this$0.mLoadAccountDataRetryCount;
                if (i < 2) {
                    moji.com.mjwallet.CashExtractInfoViewModel cashExtractInfoViewModel2 = this.this$0;
                    i2 = cashExtractInfoViewModel2.mLoadAccountDataRetryCount;
                    cashExtractInfoViewModel2.mLoadAccountDataRetryCount = i2 + 1;
                    this.this$0.loadAccountData();
                }
            }
            this.this$0.getMCashLiveData().postValue(new moji.com.mjwallet.CashExtractInfoViewModel.RequestResult(null, null, e.getCode()));
        }
        if (i3 == 0) {
            kotlin.ResultKt.throwOnFailure(obj);
            moji.com.mjwallet.CashExtractInfoViewModel cashExtractInfoViewModel3 = this.this$0;
            this.L$0 = cashExtractInfoViewModel3;
            this.label = 1;
            b = cashExtractInfoViewModel3.b(this);
            if (b == coroutine_suspended) {
                return coroutine_suspended;
            }
            cashExtractInfoViewModel = cashExtractInfoViewModel3;
            obj = b;
        } else {
            if (i3 != 1) {
                if (i3 != 2) {
                    throw new java.lang.IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                balanceResp = (com.moji.http.pcd.BalanceResp) this.L$1;
                cashExtractInfoViewModel = (moji.com.mjwallet.CashExtractInfoViewModel) this.L$0;
                kotlin.ResultKt.throwOnFailure(obj);
                c = cashExtractInfoViewModel.c(balanceResp, (com.moji.http.pcd.CashExtractInfoResp) obj);
                this.this$0.getMCashLiveData().postValue(c);
                this.this$0.mLoadAccountDataRetryCount = 0;
                return kotlin.Unit.INSTANCE;
            }
            cashExtractInfoViewModel = (moji.com.mjwallet.CashExtractInfoViewModel) this.L$0;
            kotlin.ResultKt.throwOnFailure(obj);
        }
        com.moji.http.pcd.BalanceResp balanceResp2 = (com.moji.http.pcd.BalanceResp) obj;
        moji.com.mjwallet.CashExtractInfoViewModel cashExtractInfoViewModel4 = this.this$0;
        this.L$0 = cashExtractInfoViewModel;
        this.L$1 = balanceResp2;
        this.label = 2;
        a = cashExtractInfoViewModel4.a(this);
        if (a == coroutine_suspended) {
            return coroutine_suspended;
        }
        balanceResp = balanceResp2;
        obj = a;
        c = cashExtractInfoViewModel.c(balanceResp, (com.moji.http.pcd.CashExtractInfoResp) obj);
        this.this$0.getMCashLiveData().postValue(c);
        this.this$0.mLoadAccountDataRetryCount = 0;
        return kotlin.Unit.INSTANCE;
    }
}
