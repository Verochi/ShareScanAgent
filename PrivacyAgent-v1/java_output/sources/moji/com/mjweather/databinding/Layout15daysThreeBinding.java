package moji.com.mjweather.databinding;

/* loaded from: classes20.dex */
public final class Layout15daysThreeBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final com.moji.mjad.common.view.CommonAdView adDay15;

    @androidx.annotation.NonNull
    public final com.moji.mjweather.weather.view.Forecast15DaysThreeCurveView curve15Days;

    @androidx.annotation.NonNull
    public final android.widget.TextView day15Switch;

    @androidx.annotation.NonNull
    public final android.view.ViewStub day15SwitchPop;

    @androidx.annotation.NonNull
    public final android.widget.TextView day15Text;

    @androidx.annotation.NonNull
    public final com.moji.base.curve.Day15Hour24HorizontalScrollView horizontalScrollView;

    @androidx.annotation.NonNull
    public final android.widget.LinearLayout llIcon;

    @androidx.annotation.NonNull
    public final android.widget.LinearLayout llNight;

    @androidx.annotation.NonNull
    public final android.view.View n;

    @androidx.annotation.NonNull
    public final android.view.View titleDividerView;

    @androidx.annotation.NonNull
    public final android.widget.LinearLayout zhuLlIcon;

    @androidx.annotation.NonNull
    public final android.widget.LinearLayout zhuLlNight;

    public Layout15daysThreeBinding(@androidx.annotation.NonNull android.view.View view, @androidx.annotation.NonNull com.moji.mjad.common.view.CommonAdView commonAdView, @androidx.annotation.NonNull com.moji.mjweather.weather.view.Forecast15DaysThreeCurveView forecast15DaysThreeCurveView, @androidx.annotation.NonNull android.widget.TextView textView, @androidx.annotation.NonNull android.view.ViewStub viewStub, @androidx.annotation.NonNull android.widget.TextView textView2, @androidx.annotation.NonNull com.moji.base.curve.Day15Hour24HorizontalScrollView day15Hour24HorizontalScrollView, @androidx.annotation.NonNull android.widget.LinearLayout linearLayout, @androidx.annotation.NonNull android.widget.LinearLayout linearLayout2, @androidx.annotation.NonNull android.view.View view2, @androidx.annotation.NonNull android.widget.LinearLayout linearLayout3, @androidx.annotation.NonNull android.widget.LinearLayout linearLayout4) {
        this.n = view;
        this.adDay15 = commonAdView;
        this.curve15Days = forecast15DaysThreeCurveView;
        this.day15Switch = textView;
        this.day15SwitchPop = viewStub;
        this.day15Text = textView2;
        this.horizontalScrollView = day15Hour24HorizontalScrollView;
        this.llIcon = linearLayout;
        this.llNight = linearLayout2;
        this.titleDividerView = view2;
        this.zhuLlIcon = linearLayout3;
        this.zhuLlNight = linearLayout4;
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.Layout15daysThreeBinding bind(@androidx.annotation.NonNull android.view.View view) {
        com.moji.mjweather.weather.view.Forecast15DaysThreeCurveView findChildViewById;
        com.moji.base.curve.Day15Hour24HorizontalScrollView findChildViewById2;
        android.view.View findChildViewById3;
        int i = moji.com.mjweather.R.id.ad_day15;
        com.moji.mjad.common.view.CommonAdView findChildViewById4 = androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (findChildViewById4 != null && (findChildViewById = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.curve_15_days))) != null) {
            i = moji.com.mjweather.R.id.day15_switch;
            android.widget.TextView textView = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                i = moji.com.mjweather.R.id.day15_switch_pop;
                android.view.ViewStub viewStub = (android.view.ViewStub) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                if (viewStub != null) {
                    i = moji.com.mjweather.R.id.day15_text;
                    android.widget.TextView textView2 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                    if (textView2 != null && (findChildViewById2 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.horizontal_scroll_view))) != null) {
                        i = moji.com.mjweather.R.id.ll_icon;
                        android.widget.LinearLayout linearLayout = (android.widget.LinearLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                        if (linearLayout != null) {
                            i = moji.com.mjweather.R.id.ll_night;
                            android.widget.LinearLayout linearLayout2 = (android.widget.LinearLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                            if (linearLayout2 != null && (findChildViewById3 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.titleDividerView))) != null) {
                                i = moji.com.mjweather.R.id.zhu_ll_icon;
                                android.widget.LinearLayout linearLayout3 = (android.widget.LinearLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                if (linearLayout3 != null) {
                                    i = moji.com.mjweather.R.id.zhu_ll_night;
                                    android.widget.LinearLayout linearLayout4 = (android.widget.LinearLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                    if (linearLayout4 != null) {
                                        return new moji.com.mjweather.databinding.Layout15daysThreeBinding(view, findChildViewById4, findChildViewById, textView, viewStub, textView2, findChildViewById2, linearLayout, linearLayout2, findChildViewById3, linearLayout3, linearLayout4);
                                    }
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
    public static moji.com.mjweather.databinding.Layout15daysThreeBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.NonNull android.view.ViewGroup viewGroup) {
        if (viewGroup == null) {
            throw new java.lang.NullPointerException("parent");
        }
        layoutInflater.inflate(moji.com.mjweather.R.layout.layout_15days_three, viewGroup);
        return bind(viewGroup);
    }

    @Override // androidx.viewbinding.ViewBinding
    @androidx.annotation.NonNull
    public android.view.View getRoot() {
        return this.n;
    }
}
