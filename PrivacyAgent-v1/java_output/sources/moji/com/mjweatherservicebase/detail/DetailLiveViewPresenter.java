package moji.com.mjweatherservicebase.detail;

@kotlin.Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u0000 \u000e2\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00040\u0003:\u0002\u000e\u000fB\u000f\u0012\u0006\u0010\u000b\u001a\u00020\u0002¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0006\u0010\b\u001a\u00020\u0006J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¨\u0006\u0010"}, d2 = {"Lmoji/com/mjweatherservicebase/detail/DetailLiveViewPresenter;", "Lcom/moji/base/MJPresenter;", "Lmoji/com/mjweatherservicebase/detail/DetailLiveViewPresenter$SakuraDetailLiveView;", "Landroidx/lifecycle/Observer;", "Lmoji/com/mjweatherservicebase/detail/DetailData;", "data", "", "onChanged", "load", "", "a", "callback", "<init>", "(Lmoji/com/mjweatherservicebase/detail/DetailLiveViewPresenter$SakuraDetailLiveView;)V", "Companion", "SakuraDetailLiveView", "MJWeatherServiceBase_release"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes20.dex */
public final class DetailLiveViewPresenter extends com.moji.base.MJPresenter<moji.com.mjweatherservicebase.detail.DetailLiveViewPresenter.SakuraDetailLiveView> implements androidx.lifecycle.Observer<moji.com.mjweatherservicebase.detail.DetailData> {
    public static final int MIN_PIC_LIST_SIZE = 3;

    @kotlin.Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0016\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H&J\b\u0010\t\u001a\u00020\u0005H&¨\u0006\n"}, d2 = {"Lmoji/com/mjweatherservicebase/detail/DetailLiveViewPresenter$SakuraDetailLiveView;", "Lcom/moji/base/MJPresenter$ICallback;", "getActivity", "Landroidx/fragment/app/FragmentActivity;", "loadPicture", "", "result", "", "", "showEmpty", "MJWeatherServiceBase_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface SakuraDetailLiveView extends com.moji.base.MJPresenter.ICallback {
        @org.jetbrains.annotations.NotNull
        androidx.fragment.app.FragmentActivity getActivity();

        void loadPicture(@org.jetbrains.annotations.NotNull java.util.List<java.lang.String> result);

        void showEmpty();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DetailLiveViewPresenter(@org.jetbrains.annotations.NotNull moji.com.mjweatherservicebase.detail.DetailLiveViewPresenter.SakuraDetailLiveView callback) {
        super(callback);
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(callback, "callback");
    }

    public final boolean a(moji.com.mjweatherservicebase.detail.DetailData data) {
        if (data.getSuccess() && data.getResult() != null) {
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(data.getResult().pic_list, "data.result.pic_list");
            if ((!r0.isEmpty()) && data.getResult().pic_list.size() >= 3) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [androidx.fragment.app.FragmentActivity, moji.com.mjweatherservicebase.detail.BaseFlowersDetailActivity] */
    public final void load() {
        ?? r0 = (moji.com.mjweatherservicebase.detail.BaseFlowersDetailActivity) ((moji.com.mjweatherservicebase.detail.DetailLiveViewPresenter.SakuraDetailLiveView) ((com.moji.base.MJPresenter) this).mCallback).getActivity();
        ((moji.com.mjweatherservicebase.detail.BaseFlowersDetailViewModel) androidx.lifecycle.ViewModelProviders.of((androidx.fragment.app.FragmentActivity) r0).get(r0.getDetailViewModelClass())).getMFlowersDetailLiveDate().observe(((moji.com.mjweatherservicebase.detail.DetailLiveViewPresenter.SakuraDetailLiveView) ((com.moji.base.MJPresenter) this).mCallback).getActivity(), this);
    }

    @Override // androidx.lifecycle.Observer
    public void onChanged(@org.jetbrains.annotations.NotNull moji.com.mjweatherservicebase.detail.DetailData data) {
        java.util.List<java.lang.String> list;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(data, "data");
        if (!a(data)) {
            ((moji.com.mjweatherservicebase.detail.DetailLiveViewPresenter.SakuraDetailLiveView) ((com.moji.base.MJPresenter) this).mCallback).showEmpty();
            return;
        }
        com.moji.http.rapeflowers.RapeFlowersDetailResp result = data.getResult();
        if (result == null || (list = result.pic_list) == null) {
            return;
        }
        ((moji.com.mjweatherservicebase.detail.DetailLiveViewPresenter.SakuraDetailLiveView) ((com.moji.base.MJPresenter) this).mCallback).loadPicture(list);
    }
}
