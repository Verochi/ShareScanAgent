package moji.com.mjweather.databinding;

/* loaded from: classes20.dex */
public final class MjCoreBetaItemDay2S5Binding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final com.moji.textview.MJTextView aqiView;

    @androidx.annotation.NonNull
    public final com.moji.textview.MJTextView dateView;

    @androidx.annotation.NonNull
    public final com.moji.mjweather.weather.view.MarqueeView descView;

    @androidx.annotation.NonNull
    public final com.moji.imageview.MJImageView ivTempTrend;

    @androidx.annotation.NonNull
    public final com.moji.imageview.MJImageView ivWeatherIcon;

    @androidx.annotation.NonNull
    public final androidx.constraintlayout.widget.ConstraintLayout n;

    @androidx.annotation.NonNull
    public final com.moji.textview.MJTextView tempView;

    @androidx.annotation.NonNull
    public final com.moji.textview.MJTextView tvTempTrend;

    @androidx.annotation.NonNull
    public final android.view.View viewDividerLine;

    public MjCoreBetaItemDay2S5Binding(@androidx.annotation.NonNull androidx.constraintlayout.widget.ConstraintLayout constraintLayout, @androidx.annotation.NonNull com.moji.textview.MJTextView mJTextView, @androidx.annotation.NonNull com.moji.textview.MJTextView mJTextView2, @androidx.annotation.NonNull com.moji.mjweather.weather.view.MarqueeView marqueeView, @androidx.annotation.NonNull com.moji.imageview.MJImageView mJImageView, @androidx.annotation.NonNull com.moji.imageview.MJImageView mJImageView2, @androidx.annotation.NonNull com.moji.textview.MJTextView mJTextView3, @androidx.annotation.NonNull com.moji.textview.MJTextView mJTextView4, @androidx.annotation.NonNull android.view.View view) {
        this.n = constraintLayout;
        this.aqiView = mJTextView;
        this.dateView = mJTextView2;
        this.descView = marqueeView;
        this.ivTempTrend = mJImageView;
        this.ivWeatherIcon = mJImageView2;
        this.tempView = mJTextView3;
        this.tvTempTrend = mJTextView4;
        this.viewDividerLine = view;
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.MjCoreBetaItemDay2S5Binding bind(@androidx.annotation.NonNull android.view.View view) {
        com.moji.textview.MJTextView findChildViewById;
        com.moji.mjweather.weather.view.MarqueeView findChildViewById2;
        com.moji.imageview.MJImageView findChildViewById3;
        com.moji.imageview.MJImageView findChildViewById4;
        com.moji.textview.MJTextView findChildViewById5;
        com.moji.textview.MJTextView findChildViewById6;
        android.view.View findChildViewById7;
        int i = moji.com.mjweather.R.id.aqiView;
        com.moji.textview.MJTextView findChildViewById8 = androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (findChildViewById8 == null || (findChildViewById = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.dateView))) == null || (findChildViewById2 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.descView))) == null || (findChildViewById3 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.ivTempTrend))) == null || (findChildViewById4 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.iv_weather_icon))) == null || (findChildViewById5 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.tempView))) == null || (findChildViewById6 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.tvTempTrend))) == null || (findChildViewById7 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.view_divider_line))) == null) {
            throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }
        return new moji.com.mjweather.databinding.MjCoreBetaItemDay2S5Binding((androidx.constraintlayout.widget.ConstraintLayout) view, findChildViewById8, findChildViewById, findChildViewById2, findChildViewById3, findChildViewById4, findChildViewById5, findChildViewById6, findChildViewById7);
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.MjCoreBetaItemDay2S5Binding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.MjCoreBetaItemDay2S5Binding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(moji.com.mjweather.R.layout.mj_core_beta_item_day2_s5, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @androidx.annotation.NonNull
    public androidx.constraintlayout.widget.ConstraintLayout getRoot() {
        return this.n;
    }
}
