package moji.com.mjweather.databinding;

/* loaded from: classes20.dex */
public final class LayoutForecastTwoDayItemBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final com.moji.textview.MJTextView aqiView;

    @androidx.annotation.NonNull
    public final com.moji.textview.MJTextView dateView;

    @androidx.annotation.NonNull
    public final com.moji.textview.MJTextView descView;

    @androidx.annotation.NonNull
    public final android.view.View n;

    @androidx.annotation.NonNull
    public final com.moji.textview.MJTextView tempView;

    public LayoutForecastTwoDayItemBinding(@androidx.annotation.NonNull android.view.View view, @androidx.annotation.NonNull com.moji.textview.MJTextView mJTextView, @androidx.annotation.NonNull com.moji.textview.MJTextView mJTextView2, @androidx.annotation.NonNull com.moji.textview.MJTextView mJTextView3, @androidx.annotation.NonNull com.moji.textview.MJTextView mJTextView4) {
        this.n = view;
        this.aqiView = mJTextView;
        this.dateView = mJTextView2;
        this.descView = mJTextView3;
        this.tempView = mJTextView4;
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.LayoutForecastTwoDayItemBinding bind(@androidx.annotation.NonNull android.view.View view) {
        com.moji.textview.MJTextView findChildViewById;
        com.moji.textview.MJTextView findChildViewById2;
        com.moji.textview.MJTextView findChildViewById3;
        int i = moji.com.mjweather.R.id.aqiView;
        com.moji.textview.MJTextView findChildViewById4 = androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (findChildViewById4 == null || (findChildViewById = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.dateView))) == null || (findChildViewById2 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.descView))) == null || (findChildViewById3 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.tempView))) == null) {
            throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }
        return new moji.com.mjweather.databinding.LayoutForecastTwoDayItemBinding(view, findChildViewById4, findChildViewById, findChildViewById2, findChildViewById3);
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.LayoutForecastTwoDayItemBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.NonNull android.view.ViewGroup viewGroup) {
        if (viewGroup == null) {
            throw new java.lang.NullPointerException("parent");
        }
        layoutInflater.inflate(moji.com.mjweather.R.layout.layout_forecast_two_day_item, viewGroup);
        return bind(viewGroup);
    }

    @Override // androidx.viewbinding.ViewBinding
    @androidx.annotation.NonNull
    public android.view.View getRoot() {
        return this.n;
    }
}
