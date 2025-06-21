package moji.com.mjweather.databinding;

/* loaded from: classes20.dex */
public final class FragmentTabMemberBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final com.moji.mjweather.weather.view.HomeTitleBarLayout mPlaceHolderTitle;

    @androidx.annotation.NonNull
    public final androidx.constraintlayout.widget.ConstraintLayout mVipContentTitleBar;

    @androidx.annotation.NonNull
    public final com.moji.textview.MJTextView mVipDate;

    @androidx.annotation.NonNull
    public final com.moji.imageview.FourCornerImageView mVipIvHead;

    @androidx.annotation.NonNull
    public final androidx.constraintlayout.widget.ConstraintLayout mVipLayout;

    @androidx.annotation.NonNull
    public final com.moji.textview.MJTextView mVipName;

    @androidx.annotation.NonNull
    public final com.moji.imageview.MJImageView mVipService;

    @androidx.annotation.NonNull
    public final com.moji.imageview.MJImageView mVipSetting;

    @androidx.annotation.NonNull
    public final com.moji.multiplestatuslayout.MJMultipleStatusLayout mVipStatusLayout;

    @androidx.annotation.NonNull
    public final com.moji.mjweather.weather.view.HomeTitleBarLayout mVipTitlebar;

    @androidx.annotation.NonNull
    public final android.widget.LinearLayout mVipUserInfo;

    @androidx.annotation.NonNull
    public final androidx.constraintlayout.widget.ConstraintLayout n;

    @androidx.annotation.NonNull
    public final androidx.recyclerview.widget.RecyclerView vipRecyclerView;

    public FragmentTabMemberBinding(@androidx.annotation.NonNull androidx.constraintlayout.widget.ConstraintLayout constraintLayout, @androidx.annotation.NonNull com.moji.mjweather.weather.view.HomeTitleBarLayout homeTitleBarLayout, @androidx.annotation.NonNull androidx.constraintlayout.widget.ConstraintLayout constraintLayout2, @androidx.annotation.NonNull com.moji.textview.MJTextView mJTextView, @androidx.annotation.NonNull com.moji.imageview.FourCornerImageView fourCornerImageView, @androidx.annotation.NonNull androidx.constraintlayout.widget.ConstraintLayout constraintLayout3, @androidx.annotation.NonNull com.moji.textview.MJTextView mJTextView2, @androidx.annotation.NonNull com.moji.imageview.MJImageView mJImageView, @androidx.annotation.NonNull com.moji.imageview.MJImageView mJImageView2, @androidx.annotation.NonNull com.moji.multiplestatuslayout.MJMultipleStatusLayout mJMultipleStatusLayout, @androidx.annotation.NonNull com.moji.mjweather.weather.view.HomeTitleBarLayout homeTitleBarLayout2, @androidx.annotation.NonNull android.widget.LinearLayout linearLayout, @androidx.annotation.NonNull androidx.recyclerview.widget.RecyclerView recyclerView) {
        this.n = constraintLayout;
        this.mPlaceHolderTitle = homeTitleBarLayout;
        this.mVipContentTitleBar = constraintLayout2;
        this.mVipDate = mJTextView;
        this.mVipIvHead = fourCornerImageView;
        this.mVipLayout = constraintLayout3;
        this.mVipName = mJTextView2;
        this.mVipService = mJImageView;
        this.mVipSetting = mJImageView2;
        this.mVipStatusLayout = mJMultipleStatusLayout;
        this.mVipTitlebar = homeTitleBarLayout2;
        this.mVipUserInfo = linearLayout;
        this.vipRecyclerView = recyclerView;
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.FragmentTabMemberBinding bind(@androidx.annotation.NonNull android.view.View view) {
        com.moji.textview.MJTextView findChildViewById;
        com.moji.imageview.FourCornerImageView findChildViewById2;
        com.moji.textview.MJTextView findChildViewById3;
        com.moji.imageview.MJImageView findChildViewById4;
        com.moji.imageview.MJImageView findChildViewById5;
        com.moji.multiplestatuslayout.MJMultipleStatusLayout findChildViewById6;
        com.moji.mjweather.weather.view.HomeTitleBarLayout findChildViewById7;
        int i = moji.com.mjweather.R.id.mPlaceHolderTitle;
        com.moji.mjweather.weather.view.HomeTitleBarLayout findChildViewById8 = androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (findChildViewById8 != null) {
            i = moji.com.mjweather.R.id.mVipContentTitleBar;
            androidx.constraintlayout.widget.ConstraintLayout constraintLayout = (androidx.constraintlayout.widget.ConstraintLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
            if (constraintLayout != null && (findChildViewById = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.mVipDate))) != null && (findChildViewById2 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.mVipIvHead))) != null) {
                i = moji.com.mjweather.R.id.mVipLayout;
                androidx.constraintlayout.widget.ConstraintLayout constraintLayout2 = (androidx.constraintlayout.widget.ConstraintLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                if (constraintLayout2 != null && (findChildViewById3 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.mVipName))) != null && (findChildViewById4 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.mVipService))) != null && (findChildViewById5 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.mVipSetting))) != null && (findChildViewById6 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.mVipStatusLayout))) != null && (findChildViewById7 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.mVipTitlebar))) != null) {
                    i = moji.com.mjweather.R.id.mVipUserInfo;
                    android.widget.LinearLayout linearLayout = (android.widget.LinearLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                    if (linearLayout != null) {
                        i = moji.com.mjweather.R.id.vipRecyclerView;
                        androidx.recyclerview.widget.RecyclerView recyclerView = (androidx.recyclerview.widget.RecyclerView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                        if (recyclerView != null) {
                            return new moji.com.mjweather.databinding.FragmentTabMemberBinding((androidx.constraintlayout.widget.ConstraintLayout) view, findChildViewById8, constraintLayout, findChildViewById, findChildViewById2, constraintLayout2, findChildViewById3, findChildViewById4, findChildViewById5, findChildViewById6, findChildViewById7, linearLayout, recyclerView);
                        }
                    }
                }
            }
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.FragmentTabMemberBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.FragmentTabMemberBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(moji.com.mjweather.R.layout.fragment_tab_member, viewGroup, false);
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
