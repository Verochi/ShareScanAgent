package moji.com.mjweather.databinding;

/* loaded from: classes20.dex */
public final class HomepageWeatherItemFeedsBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final androidx.constraintlayout.widget.ConstraintLayout bottomTabLayout;

    @androidx.annotation.NonNull
    public final android.widget.FrameLayout feedContentLayout;

    @androidx.annotation.NonNull
    public final com.moji.mjweather.weather.view.FeedRootView feedPagerLayout;

    @androidx.annotation.NonNull
    public final android.view.View guideLine;

    @androidx.annotation.NonNull
    public final com.moji.mjweather.weather.view.FeedRootView n;

    @androidx.annotation.NonNull
    public final android.widget.ImageView tabImgFeed;

    @androidx.annotation.NonNull
    public final android.widget.ImageView tabImgVideo;

    @androidx.annotation.NonNull
    public final android.widget.TextView tabTextFeed;

    @androidx.annotation.NonNull
    public final android.widget.TextView tabTextVideo;

    public HomepageWeatherItemFeedsBinding(@androidx.annotation.NonNull com.moji.mjweather.weather.view.FeedRootView feedRootView, @androidx.annotation.NonNull androidx.constraintlayout.widget.ConstraintLayout constraintLayout, @androidx.annotation.NonNull android.widget.FrameLayout frameLayout, @androidx.annotation.NonNull com.moji.mjweather.weather.view.FeedRootView feedRootView2, @androidx.annotation.NonNull android.view.View view, @androidx.annotation.NonNull android.widget.ImageView imageView, @androidx.annotation.NonNull android.widget.ImageView imageView2, @androidx.annotation.NonNull android.widget.TextView textView, @androidx.annotation.NonNull android.widget.TextView textView2) {
        this.n = feedRootView;
        this.bottomTabLayout = constraintLayout;
        this.feedContentLayout = frameLayout;
        this.feedPagerLayout = feedRootView2;
        this.guideLine = view;
        this.tabImgFeed = imageView;
        this.tabImgVideo = imageView2;
        this.tabTextFeed = textView;
        this.tabTextVideo = textView2;
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.HomepageWeatherItemFeedsBinding bind(@androidx.annotation.NonNull android.view.View view) {
        int i = moji.com.mjweather.R.id.bottom_tab_layout;
        androidx.constraintlayout.widget.ConstraintLayout constraintLayout = (androidx.constraintlayout.widget.ConstraintLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (constraintLayout != null) {
            i = moji.com.mjweather.R.id.feed_content_layout;
            android.widget.FrameLayout frameLayout = (android.widget.FrameLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
            if (frameLayout != null) {
                com.moji.mjweather.weather.view.FeedRootView feedRootView = (com.moji.mjweather.weather.view.FeedRootView) view;
                i = moji.com.mjweather.R.id.guide_line;
                android.view.View findChildViewById = androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                if (findChildViewById != null) {
                    i = moji.com.mjweather.R.id.tab_img_feed;
                    android.widget.ImageView imageView = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                    if (imageView != null) {
                        i = moji.com.mjweather.R.id.tab_img_video;
                        android.widget.ImageView imageView2 = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                        if (imageView2 != null) {
                            i = moji.com.mjweather.R.id.tab_text_feed;
                            android.widget.TextView textView = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                            if (textView != null) {
                                i = moji.com.mjweather.R.id.tab_text_video;
                                android.widget.TextView textView2 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                if (textView2 != null) {
                                    return new moji.com.mjweather.databinding.HomepageWeatherItemFeedsBinding(feedRootView, constraintLayout, frameLayout, feedRootView, findChildViewById, imageView, imageView2, textView, textView2);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.HomepageWeatherItemFeedsBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.HomepageWeatherItemFeedsBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(moji.com.mjweather.R.layout.homepage_weather_item_feeds, viewGroup, false);
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
