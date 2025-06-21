package moji.com.mjweather.databinding;

/* loaded from: classes20.dex */
public final class LayoutAutoLineHorizontalBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final android.view.View n;

    @androidx.annotation.NonNull
    public final com.moji.textview.MJTextView tvWeatherDes;

    @androidx.annotation.NonNull
    public final com.moji.textview.MJTextView tvWindDes;

    @androidx.annotation.NonNull
    public final android.view.View vDividerLine;

    public LayoutAutoLineHorizontalBinding(@androidx.annotation.NonNull android.view.View view, @androidx.annotation.NonNull com.moji.textview.MJTextView mJTextView, @androidx.annotation.NonNull com.moji.textview.MJTextView mJTextView2, @androidx.annotation.NonNull android.view.View view2) {
        this.n = view;
        this.tvWeatherDes = mJTextView;
        this.tvWindDes = mJTextView2;
        this.vDividerLine = view2;
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.LayoutAutoLineHorizontalBinding bind(@androidx.annotation.NonNull android.view.View view) {
        com.moji.textview.MJTextView findChildViewById;
        android.view.View findChildViewById2;
        int i = moji.com.mjweather.R.id.tv_weather_des;
        com.moji.textview.MJTextView findChildViewById3 = androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (findChildViewById3 == null || (findChildViewById = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.tv_wind_des))) == null || (findChildViewById2 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.v_divider_line))) == null) {
            throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }
        return new moji.com.mjweather.databinding.LayoutAutoLineHorizontalBinding(view, findChildViewById3, findChildViewById, findChildViewById2);
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.LayoutAutoLineHorizontalBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.NonNull android.view.ViewGroup viewGroup) {
        if (viewGroup == null) {
            throw new java.lang.NullPointerException("parent");
        }
        layoutInflater.inflate(moji.com.mjweather.R.layout.layout_auto_line_horizontal, viewGroup);
        return bind(viewGroup);
    }

    @Override // androidx.viewbinding.ViewBinding
    @androidx.annotation.NonNull
    public android.view.View getRoot() {
        return this.n;
    }
}
