package moji.com.mjweather.databinding;

/* loaded from: classes20.dex */
public final class ViewHour24s5PlaceholderBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final android.widget.LinearLayout llAqi;

    @androidx.annotation.NonNull
    public final android.widget.LinearLayout llTime;

    @androidx.annotation.NonNull
    public final android.widget.LinearLayout llWind;

    @androidx.annotation.NonNull
    public final android.view.View n;

    @androidx.annotation.NonNull
    public final android.view.View viewTempGradient;

    @androidx.annotation.NonNull
    public final android.view.View viewTempLine;

    public ViewHour24s5PlaceholderBinding(@androidx.annotation.NonNull android.view.View view, @androidx.annotation.NonNull android.widget.LinearLayout linearLayout, @androidx.annotation.NonNull android.widget.LinearLayout linearLayout2, @androidx.annotation.NonNull android.widget.LinearLayout linearLayout3, @androidx.annotation.NonNull android.view.View view2, @androidx.annotation.NonNull android.view.View view3) {
        this.n = view;
        this.llAqi = linearLayout;
        this.llTime = linearLayout2;
        this.llWind = linearLayout3;
        this.viewTempGradient = view2;
        this.viewTempLine = view3;
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.ViewHour24s5PlaceholderBinding bind(@androidx.annotation.NonNull android.view.View view) {
        android.view.View findChildViewById;
        android.view.View findChildViewById2;
        int i = moji.com.mjweather.R.id.ll_aqi;
        android.widget.LinearLayout linearLayout = (android.widget.LinearLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (linearLayout != null) {
            i = moji.com.mjweather.R.id.ll_time;
            android.widget.LinearLayout linearLayout2 = (android.widget.LinearLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
            if (linearLayout2 != null) {
                i = moji.com.mjweather.R.id.ll_wind;
                android.widget.LinearLayout linearLayout3 = (android.widget.LinearLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                if (linearLayout3 != null && (findChildViewById = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.view_temp_gradient))) != null && (findChildViewById2 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.view_temp_line))) != null) {
                    return new moji.com.mjweather.databinding.ViewHour24s5PlaceholderBinding(view, linearLayout, linearLayout2, linearLayout3, findChildViewById, findChildViewById2);
                }
            }
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.ViewHour24s5PlaceholderBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.NonNull android.view.ViewGroup viewGroup) {
        if (viewGroup == null) {
            throw new java.lang.NullPointerException("parent");
        }
        layoutInflater.inflate(moji.com.mjweather.R.layout.view_hour24s5_placeholder, viewGroup);
        return bind(viewGroup);
    }

    @Override // androidx.viewbinding.ViewBinding
    @androidx.annotation.NonNull
    public android.view.View getRoot() {
        return this.n;
    }
}
