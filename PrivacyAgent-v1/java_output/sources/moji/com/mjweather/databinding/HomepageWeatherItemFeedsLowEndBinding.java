package moji.com.mjweather.databinding;

/* loaded from: classes20.dex */
public final class HomepageWeatherItemFeedsLowEndBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final com.moji.mjweather.weather.view.FeedRootView n;

    @androidx.annotation.NonNull
    public final androidx.recyclerview.widget.RecyclerView rcFeedLayout;

    @androidx.annotation.NonNull
    public final android.widget.RelativeLayout tabView;

    @androidx.annotation.NonNull
    public final android.widget.TextView tvChange;

    @androidx.annotation.NonNull
    public final android.widget.TextView tvTitle;

    public HomepageWeatherItemFeedsLowEndBinding(@androidx.annotation.NonNull com.moji.mjweather.weather.view.FeedRootView feedRootView, @androidx.annotation.NonNull androidx.recyclerview.widget.RecyclerView recyclerView, @androidx.annotation.NonNull android.widget.RelativeLayout relativeLayout, @androidx.annotation.NonNull android.widget.TextView textView, @androidx.annotation.NonNull android.widget.TextView textView2) {
        this.n = feedRootView;
        this.rcFeedLayout = recyclerView;
        this.tabView = relativeLayout;
        this.tvChange = textView;
        this.tvTitle = textView2;
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.HomepageWeatherItemFeedsLowEndBinding bind(@androidx.annotation.NonNull android.view.View view) {
        int i = moji.com.mjweather.R.id.rc_feed_layout;
        androidx.recyclerview.widget.RecyclerView recyclerView = (androidx.recyclerview.widget.RecyclerView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (recyclerView != null) {
            i = moji.com.mjweather.R.id.tabView;
            android.widget.RelativeLayout relativeLayout = (android.widget.RelativeLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
            if (relativeLayout != null) {
                i = moji.com.mjweather.R.id.tv_change;
                android.widget.TextView textView = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                if (textView != null) {
                    i = moji.com.mjweather.R.id.tv_title;
                    android.widget.TextView textView2 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                    if (textView2 != null) {
                        return new moji.com.mjweather.databinding.HomepageWeatherItemFeedsLowEndBinding((com.moji.mjweather.weather.view.FeedRootView) view, recyclerView, relativeLayout, textView, textView2);
                    }
                }
            }
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.HomepageWeatherItemFeedsLowEndBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.HomepageWeatherItemFeedsLowEndBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(moji.com.mjweather.R.layout.homepage_weather_item_feeds_low_end, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @androidx.annotation.NonNull
    public com.moji.mjweather.weather.view.FeedRootView getRoot() {
        return this.n;
    }
}
