package moji.com.mjweatherservicebase.detail;

@kotlin.Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&R(\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR$\u0010\u0017\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u001c"}, d2 = {"Lmoji/com/mjweatherservicebase/detail/BaseFlowersDetailViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "", "spotId", "", "loadDetailData", "reloadSubStatus", "Landroidx/lifecycle/MutableLiveData;", "Lmoji/com/mjweatherservicebase/detail/DetailData;", com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.AD_COUNT, "Landroidx/lifecycle/MutableLiveData;", "getMFlowersDetailLiveDate", "()Landroidx/lifecycle/MutableLiveData;", "setMFlowersDetailLiveDate", "(Landroidx/lifecycle/MutableLiveData;)V", "mFlowersDetailLiveDate", "Lcom/moji/http/rapeflowers/RapeFlowersDetailResp;", "t", "Lcom/moji/http/rapeflowers/RapeFlowersDetailResp;", "getMLastResults", "()Lcom/moji/http/rapeflowers/RapeFlowersDetailResp;", "setMLastResults", "(Lcom/moji/http/rapeflowers/RapeFlowersDetailResp;)V", "mLastResults", "Landroid/app/Application;", "application", "<init>", "(Landroid/app/Application;)V", "MJWeatherServiceBase_release"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes20.dex */
public abstract class BaseFlowersDetailViewModel extends androidx.lifecycle.AndroidViewModel {

    /* renamed from: n, reason: from kotlin metadata */
    @org.jetbrains.annotations.NotNull
    public androidx.lifecycle.MutableLiveData<moji.com.mjweatherservicebase.detail.DetailData> mFlowersDetailLiveDate;

    /* renamed from: t, reason: from kotlin metadata */
    @org.jetbrains.annotations.Nullable
    public com.moji.http.rapeflowers.RapeFlowersDetailResp mLastResults;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseFlowersDetailViewModel(@org.jetbrains.annotations.NotNull android.app.Application application) {
        super(application);
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(application, "application");
        this.mFlowersDetailLiveDate = new androidx.lifecycle.MutableLiveData<>();
    }

    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.MutableLiveData<moji.com.mjweatherservicebase.detail.DetailData> getMFlowersDetailLiveDate() {
        return this.mFlowersDetailLiveDate;
    }

    @org.jetbrains.annotations.Nullable
    public final com.moji.http.rapeflowers.RapeFlowersDetailResp getMLastResults() {
        return this.mLastResults;
    }

    public abstract void loadDetailData(long spotId);

    public abstract void reloadSubStatus(long spotId);

    public final void setMFlowersDetailLiveDate(@org.jetbrains.annotations.NotNull androidx.lifecycle.MutableLiveData<moji.com.mjweatherservicebase.detail.DetailData> mutableLiveData) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.mFlowersDetailLiveDate = mutableLiveData;
    }

    public final void setMLastResults(@org.jetbrains.annotations.Nullable com.moji.http.rapeflowers.RapeFlowersDetailResp rapeFlowersDetailResp) {
        this.mLastResults = rapeFlowersDetailResp;
    }
}
