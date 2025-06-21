package moji.com.mjweather.databinding;

/* loaded from: classes20.dex */
public final class LayoutMainShortCurveFor10Binding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final com.moji.mjweather.weather.view.MainShortBgViewFor10 bgView;

    @androidx.annotation.NonNull
    public final androidx.constraintlayout.widget.ConstraintLayout clContent;

    @androidx.annotation.NonNull
    public final android.view.View n;

    @androidx.annotation.NonNull
    public final com.moji.mjweather.shorttime.view.ShortTimeRainDropDrawView rainDropView;

    @androidx.annotation.NonNull
    public final com.moji.mjweather.shorttime.view.ShortTimeCurveView shortTimeView;

    @androidx.annotation.NonNull
    public final android.widget.TextView textView;

    public LayoutMainShortCurveFor10Binding(@androidx.annotation.NonNull android.view.View view, @androidx.annotation.NonNull com.moji.mjweather.weather.view.MainShortBgViewFor10 mainShortBgViewFor10, @androidx.annotation.NonNull androidx.constraintlayout.widget.ConstraintLayout constraintLayout, @androidx.annotation.NonNull com.moji.mjweather.shorttime.view.ShortTimeRainDropDrawView shortTimeRainDropDrawView, @androidx.annotation.NonNull com.moji.mjweather.shorttime.view.ShortTimeCurveView shortTimeCurveView, @androidx.annotation.NonNull android.widget.TextView textView) {
        this.n = view;
        this.bgView = mainShortBgViewFor10;
        this.clContent = constraintLayout;
        this.rainDropView = shortTimeRainDropDrawView;
        this.shortTimeView = shortTimeCurveView;
        this.textView = textView;
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.LayoutMainShortCurveFor10Binding bind(@androidx.annotation.NonNull android.view.View view) {
        com.moji.mjweather.shorttime.view.ShortTimeRainDropDrawView findChildViewById;
        com.moji.mjweather.shorttime.view.ShortTimeCurveView findChildViewById2;
        int i = moji.com.mjweather.R.id.bgView;
        com.moji.mjweather.weather.view.MainShortBgViewFor10 findChildViewById3 = androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (findChildViewById3 != null) {
            i = moji.com.mjweather.R.id.cl_content;
            androidx.constraintlayout.widget.ConstraintLayout constraintLayout = (androidx.constraintlayout.widget.ConstraintLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
            if (constraintLayout != null && (findChildViewById = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.rain_drop_view))) != null && (findChildViewById2 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.short_time_view))) != null) {
                i = moji.com.mjweather.R.id.textView;
                android.widget.TextView textView = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                if (textView != null) {
                    return new moji.com.mjweather.databinding.LayoutMainShortCurveFor10Binding(view, findChildViewById3, constraintLayout, findChildViewById, findChildViewById2, textView);
                }
            }
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.LayoutMainShortCurveFor10Binding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.NonNull android.view.ViewGroup viewGroup) {
        if (viewGroup == null) {
            throw new java.lang.NullPointerException("parent");
        }
        layoutInflater.inflate(moji.com.mjweather.R.layout.layout_main_short_curve_for10, viewGroup);
        return bind(viewGroup);
    }

    @Override // androidx.viewbinding.ViewBinding
    @androidx.annotation.NonNull
    public android.view.View getRoot() {
        return this.n;
    }
}
