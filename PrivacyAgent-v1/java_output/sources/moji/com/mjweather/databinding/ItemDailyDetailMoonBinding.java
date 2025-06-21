package moji.com.mjweather.databinding;

/* loaded from: classes20.dex */
public final class ItemDailyDetailMoonBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final com.moji.textview.MJTextView dailyMoonPhaseRiseDurationValue;

    @androidx.annotation.NonNull
    public final com.moji.textview.MJTextView dailyMoonPhaseSetDurationValue;

    @androidx.annotation.NonNull
    public final com.moji.imageview.MJImageView ivShadow;

    @androidx.annotation.NonNull
    public final com.moji.textview.MJTextView labelRise;

    @androidx.annotation.NonNull
    public final com.moji.textview.MJTextView labelSet;

    @androidx.annotation.NonNull
    public final moji.com.mjweather.databinding.LayoutDailyItemHeaderBinding layoutHeader;

    @androidx.annotation.NonNull
    public final android.widget.LinearLayout layoutMoonRise;

    @androidx.annotation.NonNull
    public final com.moji.imageview.MJImageView moonBg;

    @androidx.annotation.NonNull
    public final com.moji.textview.MJTextView moonPer;

    @androidx.annotation.NonNull
    public final com.moji.mjweather.dailydetails.view.DailyMoonPhaseView moonPhaseView;

    @androidx.annotation.NonNull
    public final com.moji.mjweather.dailydetails.view.RiseView moonRiseView;

    @androidx.annotation.NonNull
    public final com.moji.textview.MJTextView moonType;

    @androidx.annotation.NonNull
    public final android.widget.LinearLayout n;

    @androidx.annotation.NonNull
    public final android.view.View riseLine;

    @androidx.annotation.NonNull
    public final android.view.View setLine;

    @androidx.annotation.NonNull
    public final com.moji.textview.MJTextView tvMoonRise;

    @androidx.annotation.NonNull
    public final com.moji.textview.MJTextView tvMoonSet;

    public ItemDailyDetailMoonBinding(@androidx.annotation.NonNull android.widget.LinearLayout linearLayout, @androidx.annotation.NonNull com.moji.textview.MJTextView mJTextView, @androidx.annotation.NonNull com.moji.textview.MJTextView mJTextView2, @androidx.annotation.NonNull com.moji.imageview.MJImageView mJImageView, @androidx.annotation.NonNull com.moji.textview.MJTextView mJTextView3, @androidx.annotation.NonNull com.moji.textview.MJTextView mJTextView4, @androidx.annotation.NonNull moji.com.mjweather.databinding.LayoutDailyItemHeaderBinding layoutDailyItemHeaderBinding, @androidx.annotation.NonNull android.widget.LinearLayout linearLayout2, @androidx.annotation.NonNull com.moji.imageview.MJImageView mJImageView2, @androidx.annotation.NonNull com.moji.textview.MJTextView mJTextView5, @androidx.annotation.NonNull com.moji.mjweather.dailydetails.view.DailyMoonPhaseView dailyMoonPhaseView, @androidx.annotation.NonNull com.moji.mjweather.dailydetails.view.RiseView riseView, @androidx.annotation.NonNull com.moji.textview.MJTextView mJTextView6, @androidx.annotation.NonNull android.view.View view, @androidx.annotation.NonNull android.view.View view2, @androidx.annotation.NonNull com.moji.textview.MJTextView mJTextView7, @androidx.annotation.NonNull com.moji.textview.MJTextView mJTextView8) {
        this.n = linearLayout;
        this.dailyMoonPhaseRiseDurationValue = mJTextView;
        this.dailyMoonPhaseSetDurationValue = mJTextView2;
        this.ivShadow = mJImageView;
        this.labelRise = mJTextView3;
        this.labelSet = mJTextView4;
        this.layoutHeader = layoutDailyItemHeaderBinding;
        this.layoutMoonRise = linearLayout2;
        this.moonBg = mJImageView2;
        this.moonPer = mJTextView5;
        this.moonPhaseView = dailyMoonPhaseView;
        this.moonRiseView = riseView;
        this.moonType = mJTextView6;
        this.riseLine = view;
        this.setLine = view2;
        this.tvMoonRise = mJTextView7;
        this.tvMoonSet = mJTextView8;
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.ItemDailyDetailMoonBinding bind(@androidx.annotation.NonNull android.view.View view) {
        com.moji.textview.MJTextView findChildViewById;
        com.moji.imageview.MJImageView findChildViewById2;
        com.moji.textview.MJTextView findChildViewById3;
        com.moji.textview.MJTextView findChildViewById4;
        android.view.View findChildViewById5;
        com.moji.imageview.MJImageView findChildViewById6;
        com.moji.textview.MJTextView findChildViewById7;
        com.moji.mjweather.dailydetails.view.DailyMoonPhaseView findChildViewById8;
        com.moji.mjweather.dailydetails.view.RiseView findChildViewById9;
        com.moji.textview.MJTextView findChildViewById10;
        android.view.View findChildViewById11;
        android.view.View findChildViewById12;
        com.moji.textview.MJTextView findChildViewById13;
        com.moji.textview.MJTextView findChildViewById14;
        int i = moji.com.mjweather.R.id.daily_moon_phase_rise_duration_value;
        com.moji.textview.MJTextView findChildViewById15 = androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (findChildViewById15 != null && (findChildViewById = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.daily_moon_phase_set_duration_value))) != null && (findChildViewById2 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.iv_shadow))) != null && (findChildViewById3 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.label_rise))) != null && (findChildViewById4 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.label_set))) != null && (findChildViewById5 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.layout_header))) != null) {
            moji.com.mjweather.databinding.LayoutDailyItemHeaderBinding bind = moji.com.mjweather.databinding.LayoutDailyItemHeaderBinding.bind(findChildViewById5);
            i = moji.com.mjweather.R.id.layout_moon_rise;
            android.widget.LinearLayout linearLayout = (android.widget.LinearLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
            if (linearLayout != null && (findChildViewById6 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.moon_bg))) != null && (findChildViewById7 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.moon_per))) != null && (findChildViewById8 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.moonPhaseView))) != null && (findChildViewById9 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.moonRiseView))) != null && (findChildViewById10 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.moon_type))) != null && (findChildViewById11 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.rise_line))) != null && (findChildViewById12 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.set_line))) != null && (findChildViewById13 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.tv_moon_rise))) != null && (findChildViewById14 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.tv_moon_set))) != null) {
                return new moji.com.mjweather.databinding.ItemDailyDetailMoonBinding((android.widget.LinearLayout) view, findChildViewById15, findChildViewById, findChildViewById2, findChildViewById3, findChildViewById4, bind, linearLayout, findChildViewById6, findChildViewById7, findChildViewById8, findChildViewById9, findChildViewById10, findChildViewById11, findChildViewById12, findChildViewById13, findChildViewById14);
            }
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.ItemDailyDetailMoonBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.ItemDailyDetailMoonBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(moji.com.mjweather.R.layout.item_daily_detail_moon, viewGroup, false);
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
