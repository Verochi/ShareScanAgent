package moji.com.mjwallet.list;

@kotlin.Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u0007¢\u0006\u0004\b\u001b\u0010\u001cJ\u0018\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004R%\u0010\u0010\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\n0\t8\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0014\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001a\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019¨\u0006\u001e"}, d2 = {"Lmoji/com/mjwallet/list/RecordListViewModel;", "Landroidx/lifecycle/ViewModel;", "", "pageCursor", "", "type", "", "requestData", "loadMore", "Landroidx/lifecycle/MutableLiveData;", "Lmoji/com/mjwallet/list/ResponsWraper;", "Lcom/moji/http/pcd/BillListResp;", com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.AD_COUNT, "Landroidx/lifecycle/MutableLiveData;", "getListLiveData", "()Landroidx/lifecycle/MutableLiveData;", "listLiveData", "Ljava/util/concurrent/atomic/AtomicBoolean;", "t", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isLoading", com.umeng.analytics.pro.bo.aN, "Ljava/lang/String;", "mLastCursor", "v", "I", "mRequestDataRetryCount", "<init>", "()V", "Companion", "MJWallet_release"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes31.dex */
public final class RecordListViewModel extends androidx.lifecycle.ViewModel {

    @org.jetbrains.annotations.NotNull
    public static final java.lang.String TAG = "RecordListViewModel";

    /* renamed from: n, reason: from kotlin metadata */
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.MutableLiveData<moji.com.mjwallet.list.ResponsWraper<com.moji.http.pcd.BillListResp>> listLiveData = new androidx.lifecycle.MutableLiveData<>();

    /* renamed from: t, reason: from kotlin metadata */
    @org.jetbrains.annotations.NotNull
    public final java.util.concurrent.atomic.AtomicBoolean isLoading = new java.util.concurrent.atomic.AtomicBoolean(false);

    /* renamed from: u, reason: from kotlin metadata */
    @org.jetbrains.annotations.Nullable
    public java.lang.String mLastCursor;

    /* renamed from: v, reason: from kotlin metadata */
    public int mRequestDataRetryCount;

    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.MutableLiveData<moji.com.mjwallet.list.ResponsWraper<com.moji.http.pcd.BillListResp>> getListLiveData() {
        return this.listLiveData;
    }

    public final void loadMore(int type) {
        requestData(this.mLastCursor, type);
    }

    public final void requestData(@org.jetbrains.annotations.Nullable java.lang.String pageCursor, int type) {
        kotlinx.coroutines.BuildersKt__Builders_commonKt.e(androidx.lifecycle.ViewModelKt.getViewModelScope(this), kotlinx.coroutines.Dispatchers.getIO(), null, new moji.com.mjwallet.list.RecordListViewModel$requestData$1(this, pageCursor, type, null), 2, null);
    }
}
