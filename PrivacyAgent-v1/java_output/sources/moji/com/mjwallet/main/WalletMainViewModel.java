package moji.com.mjwallet.main;

@kotlin.Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000f\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u0007¢\u0006\u0004\b\u001d\u0010\u001eJ\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002R\u001d\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR#\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u00058\u0006¢\u0006\f\n\u0004\b\u000e\u0010\b\u001a\u0004\b\u000f\u0010\nR\"\u0010\u0018\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\"\u0010\u001c\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u0013\u001a\u0004\b\u001a\u0010\u0015\"\u0004\b\u001b\u0010\u0017¨\u0006 "}, d2 = {"Lmoji/com/mjwallet/main/WalletMainViewModel;", "Landroidx/lifecycle/ViewModel;", "", "requestData", "requestTickets", "Landroidx/lifecycle/MutableLiveData;", "Lmoji/com/mjwallet/main/WalletBean;", com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.AD_COUNT, "Landroidx/lifecycle/MutableLiveData;", "getWalletBeanLiveData", "()Landroidx/lifecycle/MutableLiveData;", "walletBeanLiveData", "", "Lcom/moji/http/member/entity/MemberTicket;", "t", "getTicketLiveData", "ticketLiveData", "", com.umeng.analytics.pro.bo.aN, "I", "getMGetBalanceRequestRetryCount", "()I", "setMGetBalanceRequestRetryCount", "(I)V", "mGetBalanceRequestRetryCount", "v", "getMRequestTicketsRetryCount", "setMRequestTicketsRetryCount", "mRequestTicketsRetryCount", "<init>", "()V", "Companion", "MJWallet_release"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes31.dex */
public final class WalletMainViewModel extends androidx.lifecycle.ViewModel {

    @org.jetbrains.annotations.NotNull
    public static final java.lang.String TAG = "WalletMainViewModel";

    /* renamed from: n, reason: from kotlin metadata */
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.MutableLiveData<moji.com.mjwallet.main.WalletBean> walletBeanLiveData = new androidx.lifecycle.MutableLiveData<>();

    /* renamed from: t, reason: from kotlin metadata */
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.MutableLiveData<java.util.List<com.moji.http.member.entity.MemberTicket>> ticketLiveData = new androidx.lifecycle.MutableLiveData<>();

    /* renamed from: u, reason: from kotlin metadata */
    public int mGetBalanceRequestRetryCount;

    /* renamed from: v, reason: from kotlin metadata */
    public int mRequestTicketsRetryCount;

    public final int getMGetBalanceRequestRetryCount() {
        return this.mGetBalanceRequestRetryCount;
    }

    public final int getMRequestTicketsRetryCount() {
        return this.mRequestTicketsRetryCount;
    }

    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.MutableLiveData<java.util.List<com.moji.http.member.entity.MemberTicket>> getTicketLiveData() {
        return this.ticketLiveData;
    }

    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.MutableLiveData<moji.com.mjwallet.main.WalletBean> getWalletBeanLiveData() {
        return this.walletBeanLiveData;
    }

    public final void requestData() {
        kotlinx.coroutines.BuildersKt__Builders_commonKt.e(androidx.lifecycle.ViewModelKt.getViewModelScope(this), kotlinx.coroutines.Dispatchers.getIO(), null, new moji.com.mjwallet.main.WalletMainViewModel$requestData$1(this, null), 2, null);
    }

    public final void requestTickets() {
        if (com.moji.account.data.AccountProvider.getInstance().isLogin()) {
            kotlinx.coroutines.BuildersKt__Builders_commonKt.e(androidx.lifecycle.ViewModelKt.getViewModelScope(this), kotlinx.coroutines.Dispatchers.getIO(), null, new moji.com.mjwallet.main.WalletMainViewModel$requestTickets$1(this, null), 2, null);
        }
    }

    public final void setMGetBalanceRequestRetryCount(int i) {
        this.mGetBalanceRequestRetryCount = i;
    }

    public final void setMRequestTicketsRetryCount(int i) {
        this.mRequestTicketsRetryCount = i;
    }
}
