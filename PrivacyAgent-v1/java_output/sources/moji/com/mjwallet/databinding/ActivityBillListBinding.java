package moji.com.mjwallet.databinding;

/* loaded from: classes20.dex */
public final class ActivityBillListBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final androidx.constraintlayout.widget.ConstraintLayout n;

    @androidx.annotation.NonNull
    public final com.moji.titlebar.MJTitleBar titleBar;

    @androidx.annotation.NonNull
    public final androidx.viewpager.widget.ViewPager viewPager;

    @androidx.annotation.NonNull
    public final com.moji.tablayout.TabLayout viewTab;

    public ActivityBillListBinding(@androidx.annotation.NonNull androidx.constraintlayout.widget.ConstraintLayout constraintLayout, @androidx.annotation.NonNull com.moji.titlebar.MJTitleBar mJTitleBar, @androidx.annotation.NonNull androidx.viewpager.widget.ViewPager viewPager, @androidx.annotation.NonNull com.moji.tablayout.TabLayout tabLayout) {
        this.n = constraintLayout;
        this.titleBar = mJTitleBar;
        this.viewPager = viewPager;
        this.viewTab = tabLayout;
    }

    @androidx.annotation.NonNull
    public static moji.com.mjwallet.databinding.ActivityBillListBinding bind(@androidx.annotation.NonNull android.view.View view) {
        com.moji.tablayout.TabLayout findChildViewById;
        int i = moji.com.mjwallet.R.id.title_bar;
        com.moji.titlebar.MJTitleBar findChildViewById2 = androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (findChildViewById2 != null) {
            i = moji.com.mjwallet.R.id.view_pager;
            androidx.viewpager.widget.ViewPager viewPager = (androidx.viewpager.widget.ViewPager) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
            if (viewPager != null && (findChildViewById = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjwallet.R.id.view_tab))) != null) {
                return new moji.com.mjwallet.databinding.ActivityBillListBinding((androidx.constraintlayout.widget.ConstraintLayout) view, findChildViewById2, viewPager, findChildViewById);
            }
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @androidx.annotation.NonNull
    public static moji.com.mjwallet.databinding.ActivityBillListBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static moji.com.mjwallet.databinding.ActivityBillListBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(moji.com.mjwallet.R.layout.activity_bill_list, viewGroup, false);
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
