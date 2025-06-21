package moji.com.mjweather.databinding;

/* loaded from: classes20.dex */
public final class HomepageWeatherItemAdBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final android.widget.FrameLayout adRootView;

    @androidx.annotation.NonNull
    public final android.widget.FrameLayout flAdView;

    @androidx.annotation.NonNull
    public final android.widget.FrameLayout n;

    @androidx.annotation.NonNull
    public final com.moji.TickConstraintLayout tickLayout1;

    @androidx.annotation.NonNull
    public final com.moji.TickConstraintLayout tickLayout2;

    public HomepageWeatherItemAdBinding(@androidx.annotation.NonNull android.widget.FrameLayout frameLayout, @androidx.annotation.NonNull android.widget.FrameLayout frameLayout2, @androidx.annotation.NonNull android.widget.FrameLayout frameLayout3, @androidx.annotation.NonNull com.moji.TickConstraintLayout tickConstraintLayout, @androidx.annotation.NonNull com.moji.TickConstraintLayout tickConstraintLayout2) {
        this.n = frameLayout;
        this.adRootView = frameLayout2;
        this.flAdView = frameLayout3;
        this.tickLayout1 = tickConstraintLayout;
        this.tickLayout2 = tickConstraintLayout2;
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.HomepageWeatherItemAdBinding bind(@androidx.annotation.NonNull android.view.View view) {
        com.moji.TickConstraintLayout findChildViewById;
        com.moji.TickConstraintLayout findChildViewById2;
        android.widget.FrameLayout frameLayout = (android.widget.FrameLayout) view;
        int i = moji.com.mjweather.R.id.fl_ad_view;
        android.widget.FrameLayout frameLayout2 = (android.widget.FrameLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (frameLayout2 == null || (findChildViewById = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.tick_layout_1))) == null || (findChildViewById2 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.tick_layout_2))) == null) {
            throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }
        return new moji.com.mjweather.databinding.HomepageWeatherItemAdBinding(frameLayout, frameLayout, frameLayout2, findChildViewById, findChildViewById2);
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.HomepageWeatherItemAdBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.HomepageWeatherItemAdBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(moji.com.mjweather.R.layout.homepage_weather_item_ad, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @androidx.annotation.NonNull
    public android.widget.FrameLayout getRoot() {
        return this.n;
    }
}
