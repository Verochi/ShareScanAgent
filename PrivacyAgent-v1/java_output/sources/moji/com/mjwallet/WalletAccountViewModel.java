package moji.com.mjwallet;

@kotlin.Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000b\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u0007¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002J'\u0010\r\u001a\u00020\f2\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0002¢\u0006\u0004\b\r\u0010\u000eR\u001d\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00040\u000f8\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\"\u0010\u001c\u001a\u00020\u00158\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006 "}, d2 = {"Lmoji/com/mjwallet/WalletAccountViewModel;", "Landroidx/lifecycle/ViewModel;", "", "name", "", "checkName", "account", "checkAccount", "", "accountId", "real_name", "account_number", "", "saveAccount", "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;)V", "Landroidx/lifecycle/MutableLiveData;", com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.AD_COUNT, "Landroidx/lifecycle/MutableLiveData;", "getStatusLiveData", "()Landroidx/lifecycle/MutableLiveData;", "statusLiveData", "", "t", "I", "getMSaveAccountRequestRetryCount", "()I", "setMSaveAccountRequestRetryCount", "(I)V", "mSaveAccountRequestRetryCount", "<init>", "()V", "Companion", "MJWallet_release"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes20.dex */
public final class WalletAccountViewModel extends androidx.lifecycle.ViewModel {

    @org.jetbrains.annotations.NotNull
    public static final java.lang.String TAG = "WalletAccountViewModel";

    /* renamed from: n, reason: from kotlin metadata */
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.MutableLiveData<java.lang.Boolean> statusLiveData = new androidx.lifecycle.MutableLiveData<>();

    /* renamed from: t, reason: from kotlin metadata */
    public int mSaveAccountRequestRetryCount;

    public final boolean checkAccount(@org.jetbrains.annotations.Nullable java.lang.String account) {
        boolean contains$default;
        if (account == null) {
            return false;
        }
        contains$default = kotlin.text.StringsKt__StringsKt.contains$default((java.lang.CharSequence) account, (java.lang.CharSequence) "@", false, 2, (java.lang.Object) null);
        return contains$default ? com.moji.tool.RegexUtil.isEmail(account) : com.moji.tool.RegexUtil.isPhoneNumber(account);
    }

    public final boolean checkName(@org.jetbrains.annotations.Nullable java.lang.String name) {
        int length;
        return name != null && 1 <= (length = name.length()) && length < 101;
    }

    public final int getMSaveAccountRequestRetryCount() {
        return this.mSaveAccountRequestRetryCount;
    }

    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.MutableLiveData<java.lang.Boolean> getStatusLiveData() {
        return this.statusLiveData;
    }

    public final void saveAccount(@org.jetbrains.annotations.Nullable java.lang.Long accountId, @org.jetbrains.annotations.NotNull java.lang.String real_name, @org.jetbrains.annotations.NotNull java.lang.String account_number) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(real_name, "real_name");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(account_number, "account_number");
        kotlinx.coroutines.BuildersKt__Builders_commonKt.e(androidx.lifecycle.ViewModelKt.getViewModelScope(this), kotlinx.coroutines.Dispatchers.getIO(), null, new moji.com.mjwallet.WalletAccountViewModel$saveAccount$1(accountId, real_name, account_number, this, null), 2, null);
    }

    public final void setMSaveAccountRequestRetryCount(int i) {
        this.mSaveAccountRequestRetryCount = i;
    }
}
