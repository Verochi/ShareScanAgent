package moji.com.mjweather.databinding;

/* loaded from: classes20.dex */
public final class MeLayoutBannerBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final com.moji.scrollview.HorizontalScrollViewMonitor horizontalScrollView;

    @androidx.annotation.NonNull
    public final com.moji.scrollview.HorizontalScrollViewMonitor n;

    @androidx.annotation.NonNull
    public final android.widget.LinearLayout tabMeWelfareScroll;

    public MeLayoutBannerBinding(@androidx.annotation.NonNull com.moji.scrollview.HorizontalScrollViewMonitor horizontalScrollViewMonitor, @androidx.annotation.NonNull com.moji.scrollview.HorizontalScrollViewMonitor horizontalScrollViewMonitor2, @androidx.annotation.NonNull android.widget.LinearLayout linearLayout) {
        this.n = horizontalScrollViewMonitor;
        this.horizontalScrollView = horizontalScrollViewMonitor2;
        this.tabMeWelfareScroll = linearLayout;
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.MeLayoutBannerBinding bind(@androidx.annotation.NonNull android.view.View view) {
        com.moji.scrollview.HorizontalScrollViewMonitor horizontalScrollViewMonitor = (com.moji.scrollview.HorizontalScrollViewMonitor) view;
        int i = moji.com.mjweather.R.id.tab_me_welfare_scroll;
        android.widget.LinearLayout linearLayout = (android.widget.LinearLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (linearLayout != null) {
            return new moji.com.mjweather.databinding.MeLayoutBannerBinding(horizontalScrollViewMonitor, horizontalScrollViewMonitor, linearLayout);
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.MeLayoutBannerBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.MeLayoutBannerBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(moji.com.mjweather.R.layout.me_layout_banner, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @androidx.annotation.NonNull
    public com.moji.scrollview.HorizontalScrollViewMonitor getRoot() {
        return this.n;
    }
}
