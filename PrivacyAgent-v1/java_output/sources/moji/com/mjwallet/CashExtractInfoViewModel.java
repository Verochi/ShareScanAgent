package moji.com.mjwallet;

@kotlin.Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 -2\u00020\u0001:\u0002-.B\u0007¢\u0006\u0004\b+\u0010,J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\u0016\u0010\b\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005J\u0006\u0010\t\u001a\u00020\u0002J\u0018\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0002J\u0013\u0010\u0010\u001a\u00020\fH\u0082@ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011J\u0013\u0010\u0012\u001a\u00020\nH\u0082@ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0011R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u001d\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00178\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001d\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00050\u00178\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u0019\u001a\u0004\b\u001e\u0010\u001bR\u001d\u0010#\u001a\b\u0012\u0004\u0012\u00020 0\u00178\u0006¢\u0006\f\n\u0004\b!\u0010\u0019\u001a\u0004\b\"\u0010\u001bR\u0016\u0010&\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010(\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010%R\u0016\u0010*\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010%\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006/"}, d2 = {"Lmoji/com/mjwallet/CashExtractInfoViewModel;", "Landroidx/lifecycle/ViewModel;", "", "loadAccountData", "requestVerificationCode", "", "extractFee", "code", "checkVerificationCode", "startTimer", "Lcom/moji/http/pcd/BalanceResp;", "balance", "Lcom/moji/http/pcd/CashExtractInfoResp;", "account", "Lmoji/com/mjwallet/CashExtractInfoViewModel$RequestResult;", "c", "a", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "b", "Lkotlinx/coroutines/Job;", com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.AD_COUNT, "Lkotlinx/coroutines/Job;", "mLastJob", "Landroidx/lifecycle/MutableLiveData;", "t", "Landroidx/lifecycle/MutableLiveData;", "getMCashLiveData", "()Landroidx/lifecycle/MutableLiveData;", "mCashLiveData", com.umeng.analytics.pro.bo.aN, "getMTimeCountLiveData", "mTimeCountLiveData", "Lmoji/com/mjwallet/CheckCodeResult;", "v", "getMCheckVerificationViewModel", "mCheckVerificationViewModel", com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.WIDTH, "I", "mLoadAccountDataRetryCount", "x", "mCheckVerificationCodeRequestRetryCount", "y", "mSendVerificationCodeRequestRetryCount", "<init>", "()V", "Companion", "RequestResult", "MJWallet_release"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes31.dex */
public final class CashExtractInfoViewModel extends androidx.lifecycle.ViewModel {

    @org.jetbrains.annotations.NotNull
    public static final java.lang.String TAG = "CashExtractInfoViewModel";

    /* renamed from: n, reason: from kotlin metadata */
    @org.jetbrains.annotations.Nullable
    public kotlinx.coroutines.Job mLastJob;

    /* renamed from: t, reason: from kotlin metadata */
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.MutableLiveData<moji.com.mjwallet.CashExtractInfoViewModel.RequestResult> mCashLiveData = new androidx.lifecycle.MutableLiveData<>();

    /* renamed from: u, reason: from kotlin metadata */
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.MutableLiveData<java.lang.Integer> mTimeCountLiveData = new androidx.lifecycle.MutableLiveData<>();

    /* renamed from: v, reason: from kotlin metadata */
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.MutableLiveData<moji.com.mjwallet.CheckCodeResult> mCheckVerificationViewModel = new androidx.lifecycle.MutableLiveData<>();

    /* renamed from: w, reason: from kotlin metadata */
    public int mLoadAccountDataRetryCount;

    /* renamed from: x, reason: from kotlin metadata */
    public int mCheckVerificationCodeRequestRetryCount;

    /* renamed from: y, reason: from kotlin metadata */
    public int mSendVerificationCodeRequestRetryCount;

    @kotlin.Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B#\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\u0015\u001a\u00020\u0010¢\u0006\u0004\b\u0016\u0010\u0017J\u0006\u0010\u0003\u001a\u00020\u0002R\u0019\u0010\t\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0019\u0010\u000f\u001a\u0004\u0018\u00010\n8\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0015\u001a\u00020\u00108\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0018"}, d2 = {"Lmoji/com/mjwallet/CashExtractInfoViewModel$RequestResult;", "", "", "success", "Lcom/moji/http/pcd/CashExtractInfoResp;", "a", "Lcom/moji/http/pcd/CashExtractInfoResp;", "getCashExtractInfoResp", "()Lcom/moji/http/pcd/CashExtractInfoResp;", "cashExtractInfoResp", "", "b", "Ljava/lang/Long;", "getBalance", "()Ljava/lang/Long;", "balance", "", "c", "I", "getErrorCode", "()I", "errorCode", "<init>", "(Lcom/moji/http/pcd/CashExtractInfoResp;Ljava/lang/Long;I)V", "MJWallet_release"}, k = 1, mv = {1, 6, 0})
    /* loaded from: classes30.dex */
    public static final class RequestResult {

        /* renamed from: a, reason: from kotlin metadata */
        @org.jetbrains.annotations.Nullable
        public final com.moji.http.pcd.CashExtractInfoResp cashExtractInfoResp;

        /* renamed from: b, reason: from kotlin metadata */
        @org.jetbrains.annotations.Nullable
        public final java.lang.Long balance;

        /* renamed from: c, reason: from kotlin metadata */
        public final int errorCode;

        public RequestResult(@org.jetbrains.annotations.Nullable com.moji.http.pcd.CashExtractInfoResp cashExtractInfoResp, @org.jetbrains.annotations.Nullable java.lang.Long l, int i) {
            this.cashExtractInfoResp = cashExtractInfoResp;
            this.balance = l;
            this.errorCode = i;
        }

        @org.jetbrains.annotations.Nullable
        public final java.lang.Long getBalance() {
            return this.balance;
        }

        @org.jetbrains.annotations.Nullable
        public final com.moji.http.pcd.CashExtractInfoResp getCashExtractInfoResp() {
            return this.cashExtractInfoResp;
        }

        public final int getErrorCode() {
            return this.errorCode;
        }

        public final boolean success() {
            return this.errorCode == 0;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final java.lang.Object a(kotlin.coroutines.Continuation<? super com.moji.http.pcd.CashExtractInfoResp> continuation) {
        moji.com.mjwallet.CashExtractInfoViewModel$loadAccount$1 cashExtractInfoViewModel$loadAccount$1;
        java.lang.Object coroutine_suspended;
        int i;
        if (continuation instanceof moji.com.mjwallet.CashExtractInfoViewModel$loadAccount$1) {
            cashExtractInfoViewModel$loadAccount$1 = (moji.com.mjwallet.CashExtractInfoViewModel$loadAccount$1) continuation;
            int i2 = cashExtractInfoViewModel$loadAccount$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                cashExtractInfoViewModel$loadAccount$1.label = i2 - Integer.MIN_VALUE;
                java.lang.Object obj = cashExtractInfoViewModel$loadAccount$1.result;
                coroutine_suspended = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = cashExtractInfoViewModel$loadAccount$1.label;
                if (i != 0) {
                    kotlin.ResultKt.throwOnFailure(obj);
                    kotlinx.coroutines.CoroutineDispatcher io2 = kotlinx.coroutines.Dispatchers.getIO();
                    moji.com.mjwallet.CashExtractInfoViewModel$loadAccount$2 cashExtractInfoViewModel$loadAccount$2 = new moji.com.mjwallet.CashExtractInfoViewModel$loadAccount$2(null);
                    cashExtractInfoViewModel$loadAccount$1.label = 1;
                    obj = kotlinx.coroutines.BuildersKt.withContext(io2, cashExtractInfoViewModel$loadAccount$2, cashExtractInfoViewModel$loadAccount$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new java.lang.IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    kotlin.ResultKt.throwOnFailure(obj);
                }
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(obj, "withContext(Dispatchers.…eSyncOrThrowException() }");
                return obj;
            }
        }
        cashExtractInfoViewModel$loadAccount$1 = new moji.com.mjwallet.CashExtractInfoViewModel$loadAccount$1(this, continuation);
        java.lang.Object obj2 = cashExtractInfoViewModel$loadAccount$1.result;
        coroutine_suspended = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = cashExtractInfoViewModel$loadAccount$1.label;
        if (i != 0) {
        }
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(obj2, "withContext(Dispatchers.…eSyncOrThrowException() }");
        return obj2;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final java.lang.Object b(kotlin.coroutines.Continuation<? super com.moji.http.pcd.BalanceResp> continuation) {
        moji.com.mjwallet.CashExtractInfoViewModel$loadBalance$1 cashExtractInfoViewModel$loadBalance$1;
        java.lang.Object coroutine_suspended;
        int i;
        if (continuation instanceof moji.com.mjwallet.CashExtractInfoViewModel$loadBalance$1) {
            cashExtractInfoViewModel$loadBalance$1 = (moji.com.mjwallet.CashExtractInfoViewModel$loadBalance$1) continuation;
            int i2 = cashExtractInfoViewModel$loadBalance$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                cashExtractInfoViewModel$loadBalance$1.label = i2 - Integer.MIN_VALUE;
                java.lang.Object obj = cashExtractInfoViewModel$loadBalance$1.result;
                coroutine_suspended = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = cashExtractInfoViewModel$loadBalance$1.label;
                if (i != 0) {
                    kotlin.ResultKt.throwOnFailure(obj);
                    kotlinx.coroutines.CoroutineDispatcher io2 = kotlinx.coroutines.Dispatchers.getIO();
                    moji.com.mjwallet.CashExtractInfoViewModel$loadBalance$2 cashExtractInfoViewModel$loadBalance$2 = new moji.com.mjwallet.CashExtractInfoViewModel$loadBalance$2(null);
                    cashExtractInfoViewModel$loadBalance$1.label = 1;
                    obj = kotlinx.coroutines.BuildersKt.withContext(io2, cashExtractInfoViewModel$loadBalance$2, cashExtractInfoViewModel$loadBalance$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new java.lang.IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    kotlin.ResultKt.throwOnFailure(obj);
                }
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(obj, "withContext(Dispatchers.…eSyncOrThrowException() }");
                return obj;
            }
        }
        cashExtractInfoViewModel$loadBalance$1 = new moji.com.mjwallet.CashExtractInfoViewModel$loadBalance$1(this, continuation);
        java.lang.Object obj2 = cashExtractInfoViewModel$loadBalance$1.result;
        coroutine_suspended = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = cashExtractInfoViewModel$loadBalance$1.label;
        if (i != 0) {
        }
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(obj2, "withContext(Dispatchers.…eSyncOrThrowException() }");
        return obj2;
    }

    public final moji.com.mjwallet.CashExtractInfoViewModel.RequestResult c(com.moji.http.pcd.BalanceResp balance, com.moji.http.pcd.CashExtractInfoResp account) {
        return (balance.OK() && account.OK()) ? new moji.com.mjwallet.CashExtractInfoViewModel.RequestResult(account, java.lang.Long.valueOf(balance.getBalance()), 0) : new moji.com.mjwallet.CashExtractInfoViewModel.RequestResult(null, null, 602);
    }

    public final void checkVerificationCode(int extractFee, int code) {
        kotlinx.coroutines.BuildersKt__Builders_commonKt.e(androidx.lifecycle.ViewModelKt.getViewModelScope(this), kotlinx.coroutines.Dispatchers.getIO(), null, new moji.com.mjwallet.CashExtractInfoViewModel$checkVerificationCode$1(this, extractFee, code, null), 2, null);
    }

    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.MutableLiveData<moji.com.mjwallet.CashExtractInfoViewModel.RequestResult> getMCashLiveData() {
        return this.mCashLiveData;
    }

    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.MutableLiveData<moji.com.mjwallet.CheckCodeResult> getMCheckVerificationViewModel() {
        return this.mCheckVerificationViewModel;
    }

    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.MutableLiveData<java.lang.Integer> getMTimeCountLiveData() {
        return this.mTimeCountLiveData;
    }

    public final void loadAccountData() {
        kotlinx.coroutines.BuildersKt__Builders_commonKt.e(androidx.lifecycle.ViewModelKt.getViewModelScope(this), kotlinx.coroutines.Dispatchers.getIO(), null, new moji.com.mjwallet.CashExtractInfoViewModel$loadAccountData$1(this, null), 2, null);
    }

    public final void requestVerificationCode() {
        kotlinx.coroutines.BuildersKt__Builders_commonKt.e(androidx.lifecycle.ViewModelKt.getViewModelScope(this), kotlinx.coroutines.Dispatchers.getIO(), null, new moji.com.mjwallet.CashExtractInfoViewModel$requestVerificationCode$1(this, null), 2, null);
    }

    public final void startTimer() {
        kotlinx.coroutines.Job e;
        kotlinx.coroutines.Job job = this.mLastJob;
        if (job != null) {
            kotlinx.coroutines.Job.DefaultImpls.cancel$default(job, (java.util.concurrent.CancellationException) null, 1, (java.lang.Object) null);
        }
        e = kotlinx.coroutines.BuildersKt__Builders_commonKt.e(androidx.lifecycle.ViewModelKt.getViewModelScope(this), null, null, new moji.com.mjwallet.CashExtractInfoViewModel$startTimer$1(this, null), 3, null);
        this.mLastJob = e;
    }
}
