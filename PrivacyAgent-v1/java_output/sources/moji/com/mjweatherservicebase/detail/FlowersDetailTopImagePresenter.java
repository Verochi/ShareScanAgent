package moji.com.mjweatherservicebase.detail;

@kotlin.Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0006H\u0002R\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u0011\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u000e¨\u0006\u0016"}, d2 = {"Lmoji/com/mjweatherservicebase/detail/FlowersDetailTopImagePresenter;", "Landroidx/lifecycle/Observer;", "Lmoji/com/mjweatherservicebase/detail/DetailData;", "result", "", "onChanged", "Lcom/moji/http/rapeflowers/RapeFlowersDetailResp;", "a", "Landroid/widget/ImageView;", com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.AD_COUNT, "Landroid/widget/ImageView;", "mSpotImage", "Landroid/widget/TextView;", "t", "Landroid/widget/TextView;", "mSpotName", com.umeng.analytics.pro.bo.aN, "mSpotAddress", "Landroid/view/View;", "rootView", "<init>", "(Landroid/view/View;)V", "MJWeatherServiceBase_release"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes20.dex */
public final class FlowersDetailTopImagePresenter implements androidx.lifecycle.Observer<moji.com.mjweatherservicebase.detail.DetailData> {

    /* renamed from: n, reason: from kotlin metadata */
    @org.jetbrains.annotations.NotNull
    public final android.widget.ImageView mSpotImage;

    /* renamed from: t, reason: from kotlin metadata */
    @org.jetbrains.annotations.NotNull
    public final android.widget.TextView mSpotName;

    /* renamed from: u, reason: from kotlin metadata */
    @org.jetbrains.annotations.NotNull
    public final android.widget.TextView mSpotAddress;

    /* JADX WARN: Type inference failed for: r0v12, types: [androidx.fragment.app.FragmentActivity, moji.com.mjweatherservicebase.detail.BaseFlowersDetailActivity] */
    public FlowersDetailTopImagePresenter(@org.jetbrains.annotations.NotNull android.view.View rootView) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(rootView, "rootView");
        android.view.View findViewById = rootView.findViewById(moji.com.mjweatherservicebase.R.id.view_spot_img);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.view_spot_img)");
        this.mSpotImage = (android.widget.ImageView) findViewById;
        android.view.View findViewById2 = rootView.findViewById(moji.com.mjweatherservicebase.R.id.view_spot_name);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.id.view_spot_name)");
        this.mSpotName = (android.widget.TextView) findViewById2;
        android.view.View findViewById3 = rootView.findViewById(moji.com.mjweatherservicebase.R.id.view_spot_address);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById(R.id.view_spot_address)");
        this.mSpotAddress = (android.widget.TextView) findViewById3;
        java.lang.Object context = rootView.getContext();
        if (context == null) {
            throw new java.lang.NullPointerException("null cannot be cast to non-null type moji.com.mjweatherservicebase.detail.BaseFlowersDetailActivity");
        }
        ?? r0 = (moji.com.mjweatherservicebase.detail.BaseFlowersDetailActivity) context;
        androidx.lifecycle.MutableLiveData<moji.com.mjweatherservicebase.detail.DetailData> mFlowersDetailLiveDate = ((moji.com.mjweatherservicebase.detail.BaseFlowersDetailViewModel) androidx.lifecycle.ViewModelProviders.of((androidx.fragment.app.FragmentActivity) r0).get(r0.getDetailViewModelClass())).getMFlowersDetailLiveDate();
        java.lang.Object context2 = rootView.getContext();
        if (context2 == null) {
            throw new java.lang.NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
        }
        mFlowersDetailLiveDate.observe((androidx.lifecycle.LifecycleOwner) context2, this);
    }

    public final void a(com.moji.http.rapeflowers.RapeFlowersDetailResp result) {
        if (!android.text.TextUtils.isEmpty(result.spot_pic)) {
            com.bumptech.glide.Glide.with(this.mSpotImage).load(result.spot_pic).placeholder(moji.com.mjweatherservicebase.R.drawable.rflowers_details_placeholder).into(this.mSpotImage);
        }
        this.mSpotName.setText(result.spot_name);
        if (result.spot_name.length() > 18) {
            this.mSpotName.setTextSize(1, 14.0f);
        } else if (result.spot_name.length() > 16) {
            this.mSpotName.setTextSize(1, 15.0f);
        } else if (result.spot_name.length() > 14) {
            this.mSpotName.setTextSize(1, 18.0f);
        }
        if (kotlin.jvm.internal.Intrinsics.areEqual(result.province_name, result.city_name)) {
            this.mSpotAddress.setText(result.province_name);
        } else {
            this.mSpotAddress.setText(com.moji.tool.AppDelegate.getAppContext().getString(moji.com.mjweatherservicebase.R.string.spot_sub_title, result.province_name, result.city_name));
        }
    }

    @Override // androidx.lifecycle.Observer
    public void onChanged(@org.jetbrains.annotations.NotNull moji.com.mjweatherservicebase.detail.DetailData result) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(result, "result");
        if (!result.getSuccess() || result.getResult() == null) {
            return;
        }
        a(result.getResult());
    }
}
