package moji.com.mjwallet;

@kotlin.Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@kotlin.coroutines.jvm.internal.DebugMetadata(c = "moji.com.mjwallet.CashExtractInfoViewModel$checkVerificationCode$1", f = "CashExtractInfoViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes30.dex */
public final class CashExtractInfoViewModel$checkVerificationCode$1 extends kotlin.coroutines.jvm.internal.SuspendLambda implements kotlin.jvm.functions.Function2<kotlinx.coroutines.CoroutineScope, kotlin.coroutines.Continuation<? super kotlin.Unit>, java.lang.Object> {
    final /* synthetic */ int $code;
    final /* synthetic */ int $extractFee;
    int label;
    final /* synthetic */ moji.com.mjwallet.CashExtractInfoViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CashExtractInfoViewModel$checkVerificationCode$1(moji.com.mjwallet.CashExtractInfoViewModel cashExtractInfoViewModel, int i, int i2, kotlin.coroutines.Continuation<? super moji.com.mjwallet.CashExtractInfoViewModel$checkVerificationCode$1> continuation) {
        super(2, continuation);
        this.this$0 = cashExtractInfoViewModel;
        this.$extractFee = i;
        this.$code = i2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @org.jetbrains.annotations.NotNull
    public final kotlin.coroutines.Continuation<kotlin.Unit> create(@org.jetbrains.annotations.Nullable java.lang.Object obj, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<?> continuation) {
        return new moji.com.mjwallet.CashExtractInfoViewModel$checkVerificationCode$1(this.this$0, this.$extractFee, this.$code, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    @org.jetbrains.annotations.Nullable
    /* renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public final java.lang.Object mo5invoke(@org.jetbrains.annotations.NotNull kotlinx.coroutines.CoroutineScope coroutineScope, @org.jetbrains.annotations.Nullable kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return ((moji.com.mjwallet.CashExtractInfoViewModel$checkVerificationCode$1) create(coroutineScope, continuation)).invokeSuspend(kotlin.Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object obj) {
        int i;
        int i2;
        int i3;
        com.moji.http.pcd.CashExtractInfoResp cashExtractInfoResp;
        kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new java.lang.IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        kotlin.ResultKt.throwOnFailure(obj);
        try {
            moji.com.mjwallet.CashExtractInfoViewModel.RequestResult value = this.this$0.getMCashLiveData().getValue();
            com.moji.http.pcd.AccountInfo account_info = (value == null || (cashExtractInfoResp = value.getCashExtractInfoResp()) == null) ? null : cashExtractInfoResp.getAccount_info();
            if (account_info != null) {
                java.lang.Object executeSyncOrThrowException = new com.moji.http.pcd.CheckVerificationCodeRequest(account_info.getAccount_id(), this.$extractFee, this.$code).executeSyncOrThrowException();
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(executeSyncOrThrowException, "CheckVerificationCodeReq…uteSyncOrThrowException()");
                com.moji.requestcore.entity.MJBaseRespRc mJBaseRespRc = (com.moji.requestcore.entity.MJBaseRespRc) executeSyncOrThrowException;
                if (mJBaseRespRc.OK()) {
                    this.this$0.getMCheckVerificationViewModel().postValue(new moji.com.mjwallet.CheckCodeResult(true, ""));
                } else {
                    java.lang.String errorDesc = mJBaseRespRc.getDesc();
                    if (android.text.TextUtils.isEmpty(errorDesc)) {
                        errorDesc = com.moji.tool.AppDelegate.getAppContext().getString(moji.com.mjwallet.R.string.server_error);
                    }
                    androidx.lifecycle.MutableLiveData<moji.com.mjwallet.CheckCodeResult> mCheckVerificationViewModel = this.this$0.getMCheckVerificationViewModel();
                    kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(errorDesc, "errorDesc");
                    mCheckVerificationViewModel.postValue(new moji.com.mjwallet.CheckCodeResult(false, errorDesc));
                }
                this.this$0.mCheckVerificationCodeRequestRetryCount = 0;
            }
        } catch (com.moji.requestcore.MJException e) {
            com.moji.tool.log.MJLogger.e(moji.com.mjwallet.CashExtractInfoViewModel.TAG, e);
            if (e.getCode() == 604) {
                i2 = this.this$0.mCheckVerificationCodeRequestRetryCount;
                if (i2 < 2) {
                    moji.com.mjwallet.CashExtractInfoViewModel cashExtractInfoViewModel = this.this$0;
                    i3 = cashExtractInfoViewModel.mCheckVerificationCodeRequestRetryCount;
                    cashExtractInfoViewModel.mCheckVerificationCodeRequestRetryCount = i3 + 1;
                    this.this$0.checkVerificationCode(this.$extractFee, this.$code);
                }
            }
            int code = e.getCode();
            if (code != 1001 && code != 1002) {
                switch (code) {
                    case 600:
                    case 601:
                    case 602:
                        i = moji.com.mjwallet.R.string.server_error;
                        break;
                    default:
                        i = moji.com.mjwallet.R.string.submit_error;
                        break;
                }
            } else {
                i = moji.com.mjwallet.R.string.error_net;
            }
            java.lang.String string = com.moji.tool.AppDelegate.getAppContext().getString(i);
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(string, "getAppContext().getString(errorString)");
            this.this$0.getMCheckVerificationViewModel().postValue(new moji.com.mjwallet.CheckCodeResult(false, string));
        }
        return kotlin.Unit.INSTANCE;
    }
}
