package moji.com.mjweather.databinding;

/* loaded from: classes20.dex */
public final class LayoutAutoLineVerticalBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final android.view.View n;

    @androidx.annotation.NonNull
    public final com.moji.textview.MJTextView tvWeatherDes;

    @androidx.annotation.NonNull
    public final com.moji.textview.MJTextView tvWindDes;

    public LayoutAutoLineVerticalBinding(@androidx.annotation.NonNull android.view.View view, @androidx.annotation.NonNull com.moji.textview.MJTextView mJTextView, @androidx.annotation.NonNull com.moji.textview.MJTextView mJTextView2) {
        this.n = view;
        this.tvWeatherDes = mJTextView;
        this.tvWindDes = mJTextView2;
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.LayoutAutoLineVerticalBinding bind(@androidx.annotation.NonNull android.view.View view) {
        com.moji.textview.MJTextView findChildViewById;
        int i = moji.com.mjweather.R.id.tv_weather_des;
        com.moji.textview.MJTextView findChildViewById2 = androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (findChildViewById2 == null || (findChildViewById = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.tv_wind_des))) == null) {
            throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }
        return new moji.com.mjweather.databinding.LayoutAutoLineVerticalBinding(view, findChildViewById2, findChildViewById);
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.LayoutAutoLineVerticalBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.NonNull android.view.ViewGroup viewGroup) {
        if (viewGroup == null) {
            throw new java.lang.NullPointerException("parent");
        }
        layoutInflater.inflate(moji.com.mjweather.R.layout.layout_auto_line_vertical, viewGroup);
        return bind(viewGroup);
    }

    @Override // androidx.viewbinding.ViewBinding
    @androidx.annotation.NonNull
    public android.view.View getRoot() {
        return this.n;
    }
}
