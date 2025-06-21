package moji.com.mjweatherservicebase.view.sliderbanner;

@kotlin.Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"moji/com/mjweatherservicebase/view/sliderbanner/MJAutoSlideBannerView$mOnPageChangeCallback$1", "Landroidx/viewpager2/widget/ViewPager2$OnPageChangeCallback;", "onPageSelected", "", com.alibaba.sdk.android.oss.common.RequestParameters.POSITION, "", "MJWeatherServiceBase_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes20.dex */
public final class MJAutoSlideBannerView$mOnPageChangeCallback$1 extends androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback {
    public final /* synthetic */ moji.com.mjweatherservicebase.view.sliderbanner.MJAutoSlideBannerView a;

    public MJAutoSlideBannerView$mOnPageChangeCallback$1(moji.com.mjweatherservicebase.view.sliderbanner.MJAutoSlideBannerView mJAutoSlideBannerView) {
        this.a = mJAutoSlideBannerView;
    }

    @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
    public void onPageSelected(int position) {
        moji.com.mjweatherservicebase.view.sliderbanner.BannerAdapter mAdapter;
        moji.com.mjweatherservicebase.view.sliderbanner.MJAutoSlideBannerView.OnBannerSelectedListener onBannerSelectedListener;
        moji.com.mjweatherservicebase.view.sliderbanner.BannerAdapter mAdapter2;
        mAdapter = this.a.getMAdapter();
        int dataSize = mAdapter.dataSize();
        this.a.d(dataSize, position % dataSize);
        onBannerSelectedListener = this.a.mOnSelectListener;
        if (onBannerSelectedListener != null) {
            mAdapter2 = this.a.getMAdapter();
            onBannerSelectedListener.onBannerSelected(position, mAdapter2.getData(position));
        }
    }
}
