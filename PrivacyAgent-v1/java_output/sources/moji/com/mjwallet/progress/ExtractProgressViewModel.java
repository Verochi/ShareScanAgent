package moji.com.mjwallet.progress;

@kotlin.Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 $2\u00020\u0001:\u0002$%B\u0007¢\u0006\u0004\b\"\u0010#J\u0010\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0006\u001a\u00020\u0004R\u001d\u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR$\u0010\u0015\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\"\u0010\u001d\u001a\u00020\u00168\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u0014\u0010!\u001a\u00020\u001e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 ¨\u0006&"}, d2 = {"Lmoji/com/mjwallet/progress/ExtractProgressViewModel;", "Landroidx/lifecycle/ViewModel;", "", com.alibaba.sdk.android.oss.common.RequestParameters.SUBRESOURCE_APPEND, "", "load", "loadMore", "Landroidx/lifecycle/MutableLiveData;", "Lmoji/com/mjwallet/progress/ExtractProgressViewModel$DataResult;", com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.AD_COUNT, "Landroidx/lifecycle/MutableLiveData;", "getListLiveData", "()Landroidx/lifecycle/MutableLiveData;", "listLiveData", "", "t", "Ljava/lang/String;", "getPageCursor", "()Ljava/lang/String;", "setPageCursor", "(Ljava/lang/String;)V", "pageCursor", "", com.umeng.analytics.pro.bo.aN, "I", "getMLoadRetryCount", "()I", "setMLoadRetryCount", "(I)V", "mLoadRetryCount", "Ljava/util/concurrent/atomic/AtomicBoolean;", "v", "Ljava/util/concurrent/atomic/AtomicBoolean;", "mIsLoading", "<init>", "()V", "Companion", "DataResult", "MJWallet_release"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes31.dex */
public final class ExtractProgressViewModel extends androidx.lifecycle.ViewModel {

    @org.jetbrains.annotations.NotNull
    public static final java.lang.String TAG = "ExtractProgressViewModel";

    /* renamed from: t, reason: from kotlin metadata */
    @org.jetbrains.annotations.Nullable
    public java.lang.String pageCursor;

    /* renamed from: u, reason: from kotlin metadata */
    public int mLoadRetryCount;

    /* renamed from: n, reason: from kotlin metadata */
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.MutableLiveData<moji.com.mjwallet.progress.ExtractProgressViewModel.DataResult> listLiveData = new androidx.lifecycle.MutableLiveData<>();

    /* renamed from: v, reason: from kotlin metadata */
    @org.jetbrains.annotations.NotNull
    public final java.util.concurrent.atomic.AtomicBoolean mIsLoading = new java.util.concurrent.atomic.AtomicBoolean(false);

    @kotlin.Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\r\u0018\u00002\u00020\u0001B!\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u000f\u001a\u00020\n\u0012\u0006\u0010\u0014\u001a\u00020\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0006\u0010\u0003\u001a\u00020\u0002R\u0019\u0010\t\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\u000f\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0014\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0017"}, d2 = {"Lmoji/com/mjwallet/progress/ExtractProgressViewModel$DataResult;", "", "", "success", "Lcom/moji/http/pcd/ExtractDetailResp;", "a", "Lcom/moji/http/pcd/ExtractDetailResp;", "getCashExtractInfoResp", "()Lcom/moji/http/pcd/ExtractDetailResp;", "cashExtractInfoResp", "", "b", "I", "getErrorCode", "()I", "errorCode", "c", "Z", "getAppend", "()Z", com.alibaba.sdk.android.oss.common.RequestParameters.SUBRESOURCE_APPEND, "<init>", "(Lcom/moji/http/pcd/ExtractDetailResp;IZ)V", "MJWallet_release"}, k = 1, mv = {1, 6, 0})
    /* loaded from: classes20.dex */
    public static final class DataResult {

        /* renamed from: a, reason: from kotlin metadata */
        @org.jetbrains.annotations.Nullable
        public final com.moji.http.pcd.ExtractDetailResp cashExtractInfoResp;

        /* renamed from: b, reason: from kotlin metadata */
        public final int errorCode;

        /* renamed from: c, reason: from kotlin metadata */
        public final boolean append;

        public DataResult(@org.jetbrains.annotations.Nullable com.moji.http.pcd.ExtractDetailResp extractDetailResp, int i, boolean z) {
            this.cashExtractInfoResp = extractDetailResp;
            this.errorCode = i;
            this.append = z;
        }

        public final boolean getAppend() {
            return this.append;
        }

        @org.jetbrains.annotations.Nullable
        public final com.moji.http.pcd.ExtractDetailResp getCashExtractInfoResp() {
            return this.cashExtractInfoResp;
        }

        public final int getErrorCode() {
            return this.errorCode;
        }

        public final boolean success() {
            return this.errorCode == 0;
        }
    }

    public static /* synthetic */ void load$default(moji.com.mjwallet.progress.ExtractProgressViewModel extractProgressViewModel, boolean z, int i, java.lang.Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        extractProgressViewModel.load(z);
    }

    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.MutableLiveData<moji.com.mjwallet.progress.ExtractProgressViewModel.DataResult> getListLiveData() {
        return this.listLiveData;
    }

    public final int getMLoadRetryCount() {
        return this.mLoadRetryCount;
    }

    @org.jetbrains.annotations.Nullable
    public final java.lang.String getPageCursor() {
        return this.pageCursor;
    }

    public final void load(boolean append) {
        kotlinx.coroutines.BuildersKt__Builders_commonKt.e(androidx.lifecycle.ViewModelKt.getViewModelScope(this), kotlinx.coroutines.Dispatchers.getIO(), null, new moji.com.mjwallet.progress.ExtractProgressViewModel$load$1(this, append, null), 2, null);
    }

    public final void loadMore() {
        load(true);
    }

    public final void setMLoadRetryCount(int i) {
        this.mLoadRetryCount = i;
    }

    public final void setPageCursor(@org.jetbrains.annotations.Nullable java.lang.String str) {
        this.pageCursor = str;
    }
}
