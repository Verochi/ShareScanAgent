package moji.com.mjweather.databinding;

/* loaded from: classes20.dex */
public final class ViewDailyTopWeatherInfoBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final android.view.View infoSplitLine;

    @androidx.annotation.NonNull
    public final android.widget.LinearLayout n;

    @androidx.annotation.NonNull
    public final android.widget.TextView tvInfo;

    public ViewDailyTopWeatherInfoBinding(@androidx.annotation.NonNull android.widget.LinearLayout linearLayout, @androidx.annotation.NonNull android.view.View view, @androidx.annotation.NonNull android.widget.TextView textView) {
        this.n = linearLayout;
        this.infoSplitLine = view;
        this.tvInfo = textView;
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.ViewDailyTopWeatherInfoBinding bind(@androidx.annotation.NonNull android.view.View view) {
        int i = moji.com.mjweather.R.id.infoSplitLine;
        android.view.View findChildViewById = androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (findChildViewById != null) {
            i = moji.com.mjweather.R.id.tvInfo;
            android.widget.TextView textView = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                return new moji.com.mjweather.databinding.ViewDailyTopWeatherInfoBinding((android.widget.LinearLayout) view, findChildViewById, textView);
            }
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.ViewDailyTopWeatherInfoBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.ViewDailyTopWeatherInfoBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(moji.com.mjweather.R.layout.view_daily_top_weather_info, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @androidx.annotation.NonNull
    public android.widget.LinearLayout getRoot() {
        return this.n;
    }
}
