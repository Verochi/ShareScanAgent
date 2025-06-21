package moji.com.mjweatherservicebase.databinding;

/* loaded from: classes20.dex */
public final class ActivityHomepageBaseBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final android.view.View mFlowersHolder;

    @androidx.annotation.NonNull
    public final androidx.recyclerview.widget.RecyclerView mFlowersRecyclerView;

    @androidx.annotation.NonNull
    public final com.moji.multiplestatuslayout.MJMultipleStatusLayout mFlowersStateView;

    @androidx.annotation.NonNull
    public final com.moji.titlebar.MJTitleBar mFlowersTitleBar;

    @androidx.annotation.NonNull
    public final androidx.constraintlayout.widget.ConstraintLayout n;

    public ActivityHomepageBaseBinding(@androidx.annotation.NonNull androidx.constraintlayout.widget.ConstraintLayout constraintLayout, @androidx.annotation.NonNull android.view.View view, @androidx.annotation.NonNull androidx.recyclerview.widget.RecyclerView recyclerView, @androidx.annotation.NonNull com.moji.multiplestatuslayout.MJMultipleStatusLayout mJMultipleStatusLayout, @androidx.annotation.NonNull com.moji.titlebar.MJTitleBar mJTitleBar) {
        this.n = constraintLayout;
        this.mFlowersHolder = view;
        this.mFlowersRecyclerView = recyclerView;
        this.mFlowersStateView = mJMultipleStatusLayout;
        this.mFlowersTitleBar = mJTitleBar;
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweatherservicebase.databinding.ActivityHomepageBaseBinding bind(@androidx.annotation.NonNull android.view.View view) {
        com.moji.multiplestatuslayout.MJMultipleStatusLayout findChildViewById;
        com.moji.titlebar.MJTitleBar findChildViewById2;
        int i = moji.com.mjweatherservicebase.R.id.mFlowersHolder;
        android.view.View findChildViewById3 = androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (findChildViewById3 != null) {
            i = moji.com.mjweatherservicebase.R.id.mFlowersRecyclerView;
            androidx.recyclerview.widget.RecyclerView recyclerView = (androidx.recyclerview.widget.RecyclerView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
            if (recyclerView != null && (findChildViewById = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweatherservicebase.R.id.mFlowersStateView))) != null && (findChildViewById2 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweatherservicebase.R.id.mFlowersTitleBar))) != null) {
                return new moji.com.mjweatherservicebase.databinding.ActivityHomepageBaseBinding((androidx.constraintlayout.widget.ConstraintLayout) view, findChildViewById3, recyclerView, findChildViewById, findChildViewById2);
            }
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweatherservicebase.databinding.ActivityHomepageBaseBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweatherservicebase.databinding.ActivityHomepageBaseBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(moji.com.mjweatherservicebase.R.layout.activity_homepage_base, viewGroup, false);
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
