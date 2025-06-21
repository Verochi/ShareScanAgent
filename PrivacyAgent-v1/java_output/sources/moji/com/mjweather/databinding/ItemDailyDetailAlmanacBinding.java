package moji.com.mjweather.databinding;

/* loaded from: classes20.dex */
public final class ItemDailyDetailAlmanacBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final android.widget.LinearLayout almanacLeftView;

    @androidx.annotation.NonNull
    public final com.moji.textview.MJTextView bigModeDailyDetailLunarCalendarSuitable;

    @androidx.annotation.NonNull
    public final com.moji.textview.MJTextView bigModeDailyDetailLunarCalendarUnsuitable;

    @androidx.annotation.NonNull
    public final android.view.View centerLine;

    @androidx.annotation.NonNull
    public final androidx.constraintlayout.widget.ConstraintLayout dailyDetailLunarCalendarContainer;

    @androidx.annotation.NonNull
    public final com.moji.AutoResizeTextView dailyDetailLunarCalendarSuitable;

    @androidx.annotation.NonNull
    public final com.moji.AutoResizeTextView dailyDetailLunarCalendarUnsuitable;

    @androidx.annotation.NonNull
    public final com.moji.imageview.MJImageView dailyDetailLunarJi;

    @androidx.annotation.NonNull
    public final com.moji.imageview.MJImageView dailyDetailLunarYi;

    @androidx.annotation.NonNull
    public final com.moji.FontAssetTextView day;

    @androidx.annotation.NonNull
    public final moji.com.mjweather.databinding.LayoutDailyItemHeaderBinding layoutHeader;

    @androidx.annotation.NonNull
    public final com.moji.FontAssetTextView month;

    @androidx.annotation.NonNull
    public final android.widget.LinearLayout n;

    @androidx.annotation.NonNull
    public final com.moji.textview.MJTextView tvSpecialDate;

    public ItemDailyDetailAlmanacBinding(@androidx.annotation.NonNull android.widget.LinearLayout linearLayout, @androidx.annotation.NonNull android.widget.LinearLayout linearLayout2, @androidx.annotation.NonNull com.moji.textview.MJTextView mJTextView, @androidx.annotation.NonNull com.moji.textview.MJTextView mJTextView2, @androidx.annotation.NonNull android.view.View view, @androidx.annotation.NonNull androidx.constraintlayout.widget.ConstraintLayout constraintLayout, @androidx.annotation.NonNull com.moji.AutoResizeTextView autoResizeTextView, @androidx.annotation.NonNull com.moji.AutoResizeTextView autoResizeTextView2, @androidx.annotation.NonNull com.moji.imageview.MJImageView mJImageView, @androidx.annotation.NonNull com.moji.imageview.MJImageView mJImageView2, @androidx.annotation.NonNull com.moji.FontAssetTextView fontAssetTextView, @androidx.annotation.NonNull moji.com.mjweather.databinding.LayoutDailyItemHeaderBinding layoutDailyItemHeaderBinding, @androidx.annotation.NonNull com.moji.FontAssetTextView fontAssetTextView2, @androidx.annotation.NonNull com.moji.textview.MJTextView mJTextView3) {
        this.n = linearLayout;
        this.almanacLeftView = linearLayout2;
        this.bigModeDailyDetailLunarCalendarSuitable = mJTextView;
        this.bigModeDailyDetailLunarCalendarUnsuitable = mJTextView2;
        this.centerLine = view;
        this.dailyDetailLunarCalendarContainer = constraintLayout;
        this.dailyDetailLunarCalendarSuitable = autoResizeTextView;
        this.dailyDetailLunarCalendarUnsuitable = autoResizeTextView2;
        this.dailyDetailLunarJi = mJImageView;
        this.dailyDetailLunarYi = mJImageView2;
        this.day = fontAssetTextView;
        this.layoutHeader = layoutDailyItemHeaderBinding;
        this.month = fontAssetTextView2;
        this.tvSpecialDate = mJTextView3;
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.ItemDailyDetailAlmanacBinding bind(@androidx.annotation.NonNull android.view.View view) {
        com.moji.textview.MJTextView findChildViewById;
        com.moji.textview.MJTextView findChildViewById2;
        android.view.View findChildViewById3;
        com.moji.AutoResizeTextView findChildViewById4;
        com.moji.AutoResizeTextView findChildViewById5;
        com.moji.imageview.MJImageView findChildViewById6;
        com.moji.imageview.MJImageView findChildViewById7;
        com.moji.FontAssetTextView findChildViewById8;
        android.view.View findChildViewById9;
        com.moji.textview.MJTextView findChildViewById10;
        int i = moji.com.mjweather.R.id.almanac_left_view;
        android.widget.LinearLayout linearLayout = (android.widget.LinearLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (linearLayout != null && (findChildViewById = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.big_mode_daily_detail_lunar_calendar_suitable))) != null && (findChildViewById2 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.big_mode_daily_detail_lunar_calendar_unsuitable))) != null && (findChildViewById3 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.center_line))) != null) {
            i = moji.com.mjweather.R.id.daily_detail_lunar_calendar_container;
            androidx.constraintlayout.widget.ConstraintLayout constraintLayout = (androidx.constraintlayout.widget.ConstraintLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
            if (constraintLayout != null && (findChildViewById4 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.daily_detail_lunar_calendar_suitable))) != null && (findChildViewById5 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.daily_detail_lunar_calendar_unsuitable))) != null && (findChildViewById6 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.daily_detail_lunar_ji))) != null && (findChildViewById7 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.daily_detail_lunar_yi))) != null && (findChildViewById8 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.day))) != null && (findChildViewById9 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.layout_header))) != null) {
                moji.com.mjweather.databinding.LayoutDailyItemHeaderBinding bind = moji.com.mjweather.databinding.LayoutDailyItemHeaderBinding.bind(findChildViewById9);
                i = moji.com.mjweather.R.id.month;
                com.moji.FontAssetTextView findChildViewById11 = androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                if (findChildViewById11 != null && (findChildViewById10 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.tv_special_date))) != null) {
                    return new moji.com.mjweather.databinding.ItemDailyDetailAlmanacBinding((android.widget.LinearLayout) view, linearLayout, findChildViewById, findChildViewById2, findChildViewById3, constraintLayout, findChildViewById4, findChildViewById5, findChildViewById6, findChildViewById7, findChildViewById8, bind, findChildViewById11, findChildViewById10);
                }
            }
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.ItemDailyDetailAlmanacBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.ItemDailyDetailAlmanacBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(moji.com.mjweather.R.layout.item_daily_detail_almanac, viewGroup, false);
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
