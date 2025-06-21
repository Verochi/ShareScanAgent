package moji.com.mjweather.databinding;

/* loaded from: classes20.dex */
public final class HomeWeatherExpressItemAdBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final com.moji.mjad.view.AdTagView adTagView;

    @androidx.annotation.NonNull
    public final com.moji.mjad.common.view.CommonAdView commonAdView;

    @androidx.annotation.NonNull
    public final com.moji.cardView.CardView n;

    @androidx.annotation.NonNull
    public final com.moji.TickConstraintLayout tickLayout;

    public HomeWeatherExpressItemAdBinding(@androidx.annotation.NonNull com.moji.cardView.CardView cardView, @androidx.annotation.NonNull com.moji.mjad.view.AdTagView adTagView, @androidx.annotation.NonNull com.moji.mjad.common.view.CommonAdView commonAdView, @androidx.annotation.NonNull com.moji.TickConstraintLayout tickConstraintLayout) {
        this.n = cardView;
        this.adTagView = adTagView;
        this.commonAdView = commonAdView;
        this.tickLayout = tickConstraintLayout;
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.HomeWeatherExpressItemAdBinding bind(@androidx.annotation.NonNull android.view.View view) {
        com.moji.mjad.common.view.CommonAdView findChildViewById;
        com.moji.TickConstraintLayout findChildViewById2;
        int i = moji.com.mjweather.R.id.adTagView;
        com.moji.mjad.view.AdTagView findChildViewById3 = androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (findChildViewById3 == null || (findChildViewById = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.common_ad_view))) == null || (findChildViewById2 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.tickLayout))) == null) {
            throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }
        return new moji.com.mjweather.databinding.HomeWeatherExpressItemAdBinding((com.moji.cardView.CardView) view, findChildViewById3, findChildViewById, findChildViewById2);
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.HomeWeatherExpressItemAdBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.HomeWeatherExpressItemAdBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(moji.com.mjweather.R.layout.home_weather_express_item_ad, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @androidx.annotation.NonNull
    public com.moji.cardView.CardView getRoot() {
        return this.n;
    }
}
