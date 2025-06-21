package moji.com.mjweather.databinding;

/* loaded from: classes20.dex */
public final class ActivityMoreDaysBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final moji.com.mjweather.databinding.ActivityMoreDaysCoverLayoutBinding includeCoverLayout;

    @androidx.annotation.NonNull
    public final android.widget.ImageView ivBg;

    @androidx.annotation.NonNull
    public final androidx.constraintlayout.widget.ConstraintLayout n;

    @androidx.annotation.NonNull
    public final com.moji.multiplestatuslayout.MJMultipleStatusLayout statusLayout;

    @androidx.annotation.NonNull
    public final com.moji.titlebar.MJTitleBar titleBar;

    @androidx.annotation.NonNull
    public final com.moji.titlebar.MJTitleBar titleBarLoading;

    @androidx.annotation.NonNull
    public final android.view.View transparentHeight;

    @androidx.annotation.NonNull
    public final androidx.viewpager2.widget.ViewPager2 viewPager;

    public ActivityMoreDaysBinding(@androidx.annotation.NonNull androidx.constraintlayout.widget.ConstraintLayout constraintLayout, @androidx.annotation.NonNull moji.com.mjweather.databinding.ActivityMoreDaysCoverLayoutBinding activityMoreDaysCoverLayoutBinding, @androidx.annotation.NonNull android.widget.ImageView imageView, @androidx.annotation.NonNull com.moji.multiplestatuslayout.MJMultipleStatusLayout mJMultipleStatusLayout, @androidx.annotation.NonNull com.moji.titlebar.MJTitleBar mJTitleBar, @androidx.annotation.NonNull com.moji.titlebar.MJTitleBar mJTitleBar2, @androidx.annotation.NonNull android.view.View view, @androidx.annotation.NonNull androidx.viewpager2.widget.ViewPager2 viewPager2) {
        this.n = constraintLayout;
        this.includeCoverLayout = activityMoreDaysCoverLayoutBinding;
        this.ivBg = imageView;
        this.statusLayout = mJMultipleStatusLayout;
        this.titleBar = mJTitleBar;
        this.titleBarLoading = mJTitleBar2;
        this.transparentHeight = view;
        this.viewPager = viewPager2;
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.ActivityMoreDaysBinding bind(@androidx.annotation.NonNull android.view.View view) {
        com.moji.multiplestatuslayout.MJMultipleStatusLayout findChildViewById;
        com.moji.titlebar.MJTitleBar findChildViewById2;
        com.moji.titlebar.MJTitleBar findChildViewById3;
        android.view.View findChildViewById4;
        int i = moji.com.mjweather.R.id.include_cover_layout;
        android.view.View findChildViewById5 = androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (findChildViewById5 != null) {
            moji.com.mjweather.databinding.ActivityMoreDaysCoverLayoutBinding bind = moji.com.mjweather.databinding.ActivityMoreDaysCoverLayoutBinding.bind(findChildViewById5);
            i = moji.com.mjweather.R.id.iv_bg;
            android.widget.ImageView imageView = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
            if (imageView != null && (findChildViewById = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.status_layout))) != null && (findChildViewById2 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.title_bar))) != null && (findChildViewById3 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.title_bar_loading))) != null && (findChildViewById4 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.transparent_height))) != null) {
                i = moji.com.mjweather.R.id.view_pager;
                androidx.viewpager2.widget.ViewPager2 viewPager2 = (androidx.viewpager2.widget.ViewPager2) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                if (viewPager2 != null) {
                    return new moji.com.mjweather.databinding.ActivityMoreDaysBinding((androidx.constraintlayout.widget.ConstraintLayout) view, bind, imageView, findChildViewById, findChildViewById2, findChildViewById3, findChildViewById4, viewPager2);
                }
            }
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.ActivityMoreDaysBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.ActivityMoreDaysBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(moji.com.mjweather.R.layout.activity_more_days, viewGroup, false);
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
