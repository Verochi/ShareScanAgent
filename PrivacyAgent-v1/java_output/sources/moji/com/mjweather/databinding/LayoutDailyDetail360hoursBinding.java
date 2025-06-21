package moji.com.mjweather.databinding;

/* loaded from: classes20.dex */
public final class LayoutDailyDetail360hoursBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final androidx.constraintlayout.widget.ConstraintLayout hour360Parent;

    @androidx.annotation.NonNull
    public final androidx.constraintlayout.widget.ConstraintLayout n;

    @androidx.annotation.NonNull
    public final com.moji.textview.MJTextView tv360AqiText;

    @androidx.annotation.NonNull
    public final com.moji.textview.MJTextView tv360HiTemp;

    @androidx.annotation.NonNull
    public final com.moji.textview.MJTextView tv360LowTemp;

    @androidx.annotation.NonNull
    public final com.moji.textview.MJTextView tv360WindText;

    @androidx.annotation.NonNull
    public final com.moji.textview.MJTextView tvTitle;

    @androidx.annotation.NonNull
    public final com.moji.base.curve.hour360.Hour360View weatherHour360;

    public LayoutDailyDetail360hoursBinding(@androidx.annotation.NonNull androidx.constraintlayout.widget.ConstraintLayout constraintLayout, @androidx.annotation.NonNull androidx.constraintlayout.widget.ConstraintLayout constraintLayout2, @androidx.annotation.NonNull com.moji.textview.MJTextView mJTextView, @androidx.annotation.NonNull com.moji.textview.MJTextView mJTextView2, @androidx.annotation.NonNull com.moji.textview.MJTextView mJTextView3, @androidx.annotation.NonNull com.moji.textview.MJTextView mJTextView4, @androidx.annotation.NonNull com.moji.textview.MJTextView mJTextView5, @androidx.annotation.NonNull com.moji.base.curve.hour360.Hour360View hour360View) {
        this.n = constraintLayout;
        this.hour360Parent = constraintLayout2;
        this.tv360AqiText = mJTextView;
        this.tv360HiTemp = mJTextView2;
        this.tv360LowTemp = mJTextView3;
        this.tv360WindText = mJTextView4;
        this.tvTitle = mJTextView5;
        this.weatherHour360 = hour360View;
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.LayoutDailyDetail360hoursBinding bind(@androidx.annotation.NonNull android.view.View view) {
        com.moji.textview.MJTextView findChildViewById;
        com.moji.textview.MJTextView findChildViewById2;
        com.moji.textview.MJTextView findChildViewById3;
        com.moji.textview.MJTextView findChildViewById4;
        com.moji.base.curve.hour360.Hour360View findChildViewById5;
        androidx.constraintlayout.widget.ConstraintLayout constraintLayout = (androidx.constraintlayout.widget.ConstraintLayout) view;
        int i = moji.com.mjweather.R.id.tv_360_aqi_text;
        com.moji.textview.MJTextView findChildViewById6 = androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (findChildViewById6 == null || (findChildViewById = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.tv_360_hi_temp))) == null || (findChildViewById2 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.tv_360_low_temp))) == null || (findChildViewById3 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.tv_360_wind_text))) == null || (findChildViewById4 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.tv_title))) == null || (findChildViewById5 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.weather_hour360))) == null) {
            throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }
        return new moji.com.mjweather.databinding.LayoutDailyDetail360hoursBinding(constraintLayout, constraintLayout, findChildViewById6, findChildViewById, findChildViewById2, findChildViewById3, findChildViewById4, findChildViewById5);
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.LayoutDailyDetail360hoursBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.LayoutDailyDetail360hoursBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(moji.com.mjweather.R.layout.layout_daily_detail_360hours, viewGroup, false);
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
