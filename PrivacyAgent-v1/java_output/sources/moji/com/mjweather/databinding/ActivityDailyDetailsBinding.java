package moji.com.mjweather.databinding;

/* loaded from: classes31.dex */
public final class ActivityDailyDetailsBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final com.moji.mjweather.dailydetails.view.DailyDetail360HourView daily360View;

    @androidx.annotation.NonNull
    public final androidx.viewpager.widget.ViewPager dailyDetailViewpager;

    @androidx.annotation.NonNull
    public final com.moji.mjweather.dailydetails.DailyTimeIndicator dailyTimeIndicator;

    @androidx.annotation.NonNull
    public final com.moji.mjweather.dailydetail.view.DailyHeaderLayout layoutHeader;

    @androidx.annotation.NonNull
    public final com.moji.mjweather.dailydetails.view.LinkageFrameLayout linkageLayout;

    @androidx.annotation.NonNull
    public final com.moji.titlebar.MJTitleBar mjTitleBar;

    @androidx.annotation.NonNull
    public final androidx.constraintlayout.widget.ConstraintLayout n;

    @androidx.annotation.NonNull
    public final com.moji.multiplestatuslayout.MJMultipleStatusLayout statusLayout;

    public ActivityDailyDetailsBinding(@androidx.annotation.NonNull androidx.constraintlayout.widget.ConstraintLayout constraintLayout, @androidx.annotation.NonNull com.moji.mjweather.dailydetails.view.DailyDetail360HourView dailyDetail360HourView, @androidx.annotation.NonNull androidx.viewpager.widget.ViewPager viewPager, @androidx.annotation.NonNull com.moji.mjweather.dailydetails.DailyTimeIndicator dailyTimeIndicator, @androidx.annotation.NonNull com.moji.mjweather.dailydetail.view.DailyHeaderLayout dailyHeaderLayout, @androidx.annotation.NonNull com.moji.mjweather.dailydetails.view.LinkageFrameLayout linkageFrameLayout, @androidx.annotation.NonNull com.moji.titlebar.MJTitleBar mJTitleBar, @androidx.annotation.NonNull com.moji.multiplestatuslayout.MJMultipleStatusLayout mJMultipleStatusLayout) {
        this.n = constraintLayout;
        this.daily360View = dailyDetail360HourView;
        this.dailyDetailViewpager = viewPager;
        this.dailyTimeIndicator = dailyTimeIndicator;
        this.layoutHeader = dailyHeaderLayout;
        this.linkageLayout = linkageFrameLayout;
        this.mjTitleBar = mJTitleBar;
        this.statusLayout = mJMultipleStatusLayout;
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.ActivityDailyDetailsBinding bind(@androidx.annotation.NonNull android.view.View view) {
        com.moji.mjweather.dailydetails.DailyTimeIndicator findChildViewById;
        com.moji.mjweather.dailydetail.view.DailyHeaderLayout findChildViewById2;
        com.moji.mjweather.dailydetails.view.LinkageFrameLayout findChildViewById3;
        com.moji.titlebar.MJTitleBar findChildViewById4;
        com.moji.multiplestatuslayout.MJMultipleStatusLayout findChildViewById5;
        int i = moji.com.mjweather.R.id.daily_360_view;
        com.moji.mjweather.dailydetails.view.DailyDetail360HourView findChildViewById6 = androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (findChildViewById6 != null) {
            i = moji.com.mjweather.R.id.daily_detail_viewpager;
            androidx.viewpager.widget.ViewPager viewPager = (androidx.viewpager.widget.ViewPager) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
            if (viewPager != null && (findChildViewById = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.daily_time_indicator))) != null && (findChildViewById2 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.layout_header))) != null && (findChildViewById3 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.linkage_layout))) != null && (findChildViewById4 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.mj_title_bar))) != null && (findChildViewById5 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.status_layout))) != null) {
                return new moji.com.mjweather.databinding.ActivityDailyDetailsBinding((androidx.constraintlayout.widget.ConstraintLayout) view, findChildViewById6, viewPager, findChildViewById, findChildViewById2, findChildViewById3, findChildViewById4, findChildViewById5);
            }
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.ActivityDailyDetailsBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.ActivityDailyDetailsBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(moji.com.mjweather.R.layout.activity_daily_details, viewGroup, false);
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
