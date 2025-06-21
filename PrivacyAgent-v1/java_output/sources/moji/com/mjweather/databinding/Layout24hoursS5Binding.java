package moji.com.mjweather.databinding;

/* loaded from: classes20.dex */
public final class Layout24hoursS5Binding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final androidx.constraintlayout.widget.ConstraintLayout clLeftTitle;

    @androidx.annotation.NonNull
    public final androidx.constraintlayout.widget.Guideline glNowBtnBottom;

    @androidx.annotation.NonNull
    public final androidx.constraintlayout.widget.Guideline glNowBtnLeft;

    @androidx.annotation.NonNull
    public final com.moji.base.curve.Hour24HorizontalScrollView hour24ScrollView;

    @androidx.annotation.NonNull
    public final android.view.View n;

    @androidx.annotation.NonNull
    public final android.widget.FrameLayout slNow;

    @androidx.annotation.NonNull
    public final com.moji.textview.MJTextView tv24AqiText;

    @androidx.annotation.NonNull
    public final com.moji.textview.MJTextView tv24HiTemp;

    @androidx.annotation.NonNull
    public final com.moji.textview.MJTextView tv24LowTemp;

    @androidx.annotation.NonNull
    public final com.moji.textview.MJTextView tv24WindText;

    @androidx.annotation.NonNull
    public final com.moji.textview.MJTextView tvNow;

    @androidx.annotation.NonNull
    public final com.moji.mjweather.weather.beta.hour24_s5.Hour24S5BaseView weatherHour24;

    @androidx.annotation.NonNull
    public final com.moji.mjweather.weather.beta.hour24_s5.Hour24S5PlaceHolderView weatherHour24Placeholder;

    public Layout24hoursS5Binding(@androidx.annotation.NonNull android.view.View view, @androidx.annotation.NonNull androidx.constraintlayout.widget.ConstraintLayout constraintLayout, @androidx.annotation.NonNull androidx.constraintlayout.widget.Guideline guideline, @androidx.annotation.NonNull androidx.constraintlayout.widget.Guideline guideline2, @androidx.annotation.NonNull com.moji.base.curve.Hour24HorizontalScrollView hour24HorizontalScrollView, @androidx.annotation.NonNull android.widget.FrameLayout frameLayout, @androidx.annotation.NonNull com.moji.textview.MJTextView mJTextView, @androidx.annotation.NonNull com.moji.textview.MJTextView mJTextView2, @androidx.annotation.NonNull com.moji.textview.MJTextView mJTextView3, @androidx.annotation.NonNull com.moji.textview.MJTextView mJTextView4, @androidx.annotation.NonNull com.moji.textview.MJTextView mJTextView5, @androidx.annotation.NonNull com.moji.mjweather.weather.beta.hour24_s5.Hour24S5BaseView hour24S5BaseView, @androidx.annotation.NonNull com.moji.mjweather.weather.beta.hour24_s5.Hour24S5PlaceHolderView hour24S5PlaceHolderView) {
        this.n = view;
        this.clLeftTitle = constraintLayout;
        this.glNowBtnBottom = guideline;
        this.glNowBtnLeft = guideline2;
        this.hour24ScrollView = hour24HorizontalScrollView;
        this.slNow = frameLayout;
        this.tv24AqiText = mJTextView;
        this.tv24HiTemp = mJTextView2;
        this.tv24LowTemp = mJTextView3;
        this.tv24WindText = mJTextView4;
        this.tvNow = mJTextView5;
        this.weatherHour24 = hour24S5BaseView;
        this.weatherHour24Placeholder = hour24S5PlaceHolderView;
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.Layout24hoursS5Binding bind(@androidx.annotation.NonNull android.view.View view) {
        com.moji.base.curve.Hour24HorizontalScrollView findChildViewById;
        com.moji.textview.MJTextView findChildViewById2;
        com.moji.textview.MJTextView findChildViewById3;
        com.moji.textview.MJTextView findChildViewById4;
        com.moji.textview.MJTextView findChildViewById5;
        com.moji.textview.MJTextView findChildViewById6;
        com.moji.mjweather.weather.beta.hour24_s5.Hour24S5BaseView findChildViewById7;
        com.moji.mjweather.weather.beta.hour24_s5.Hour24S5PlaceHolderView findChildViewById8;
        int i = moji.com.mjweather.R.id.cl_left_title;
        androidx.constraintlayout.widget.ConstraintLayout constraintLayout = (androidx.constraintlayout.widget.ConstraintLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (constraintLayout != null) {
            i = moji.com.mjweather.R.id.gl_now_btn_bottom;
            androidx.constraintlayout.widget.Guideline guideline = (androidx.constraintlayout.widget.Guideline) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
            if (guideline != null) {
                i = moji.com.mjweather.R.id.gl_now_btn_left;
                androidx.constraintlayout.widget.Guideline guideline2 = (androidx.constraintlayout.widget.Guideline) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                if (guideline2 != null && (findChildViewById = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.hour24_scroll_view))) != null) {
                    i = moji.com.mjweather.R.id.sl_now;
                    android.widget.FrameLayout frameLayout = (android.widget.FrameLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                    if (frameLayout != null && (findChildViewById2 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.tv_24_aqi_text))) != null && (findChildViewById3 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.tv_24_hi_temp))) != null && (findChildViewById4 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.tv_24_low_temp))) != null && (findChildViewById5 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.tv_24_wind_text))) != null && (findChildViewById6 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.tv_now))) != null && (findChildViewById7 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.weather_hour24))) != null && (findChildViewById8 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.weather_hour24_placeholder))) != null) {
                        return new moji.com.mjweather.databinding.Layout24hoursS5Binding(view, constraintLayout, guideline, guideline2, findChildViewById, frameLayout, findChildViewById2, findChildViewById3, findChildViewById4, findChildViewById5, findChildViewById6, findChildViewById7, findChildViewById8);
                    }
                }
            }
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.Layout24hoursS5Binding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.NonNull android.view.ViewGroup viewGroup) {
        if (viewGroup == null) {
            throw new java.lang.NullPointerException("parent");
        }
        layoutInflater.inflate(moji.com.mjweather.R.layout.layout_24hours_s5, viewGroup);
        return bind(viewGroup);
    }

    @Override // androidx.viewbinding.ViewBinding
    @androidx.annotation.NonNull
    public android.view.View getRoot() {
        return this.n;
    }
}
