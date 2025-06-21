package moji.com.mjweather.databinding;

/* loaded from: classes20.dex */
public final class ActivityTabMemberBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final android.widget.ImageView mBackView;

    @androidx.annotation.NonNull
    public final androidx.constraintlayout.widget.ConstraintLayout mVipContentTitleBar;

    @androidx.annotation.NonNull
    public final androidx.constraintlayout.widget.ConstraintLayout mVipLayout;

    @androidx.annotation.NonNull
    public final android.widget.ImageView mVipService;

    @androidx.annotation.NonNull
    public final android.widget.ImageView mVipSetting;

    @androidx.annotation.NonNull
    public final com.moji.multiplestatuslayout.MJMultipleStatusLayout mVipStatusLayout;

    @androidx.annotation.NonNull
    public final com.moji.mjweather.weather.view.HomeTitleBarLayout mVipTitlebar;

    @androidx.annotation.NonNull
    public final androidx.constraintlayout.widget.ConstraintLayout n;

    @androidx.annotation.NonNull
    public final androidx.recyclerview.widget.RecyclerView vipRecyclerView;

    public ActivityTabMemberBinding(@androidx.annotation.NonNull androidx.constraintlayout.widget.ConstraintLayout constraintLayout, @androidx.annotation.NonNull android.widget.ImageView imageView, @androidx.annotation.NonNull androidx.constraintlayout.widget.ConstraintLayout constraintLayout2, @androidx.annotation.NonNull androidx.constraintlayout.widget.ConstraintLayout constraintLayout3, @androidx.annotation.NonNull android.widget.ImageView imageView2, @androidx.annotation.NonNull android.widget.ImageView imageView3, @androidx.annotation.NonNull com.moji.multiplestatuslayout.MJMultipleStatusLayout mJMultipleStatusLayout, @androidx.annotation.NonNull com.moji.mjweather.weather.view.HomeTitleBarLayout homeTitleBarLayout, @androidx.annotation.NonNull androidx.recyclerview.widget.RecyclerView recyclerView) {
        this.n = constraintLayout;
        this.mBackView = imageView;
        this.mVipContentTitleBar = constraintLayout2;
        this.mVipLayout = constraintLayout3;
        this.mVipService = imageView2;
        this.mVipSetting = imageView3;
        this.mVipStatusLayout = mJMultipleStatusLayout;
        this.mVipTitlebar = homeTitleBarLayout;
        this.vipRecyclerView = recyclerView;
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.ActivityTabMemberBinding bind(@androidx.annotation.NonNull android.view.View view) {
        com.moji.multiplestatuslayout.MJMultipleStatusLayout findChildViewById;
        com.moji.mjweather.weather.view.HomeTitleBarLayout findChildViewById2;
        int i = moji.com.mjweather.R.id.mBackView;
        android.widget.ImageView imageView = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = moji.com.mjweather.R.id.mVipContentTitleBar;
            androidx.constraintlayout.widget.ConstraintLayout constraintLayout = (androidx.constraintlayout.widget.ConstraintLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
            if (constraintLayout != null) {
                i = moji.com.mjweather.R.id.mVipLayout;
                androidx.constraintlayout.widget.ConstraintLayout constraintLayout2 = (androidx.constraintlayout.widget.ConstraintLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                if (constraintLayout2 != null) {
                    i = moji.com.mjweather.R.id.mVipService;
                    android.widget.ImageView imageView2 = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                    if (imageView2 != null) {
                        i = moji.com.mjweather.R.id.mVipSetting;
                        android.widget.ImageView imageView3 = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                        if (imageView3 != null && (findChildViewById = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.mVipStatusLayout))) != null && (findChildViewById2 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.mVipTitlebar))) != null) {
                            i = moji.com.mjweather.R.id.vipRecyclerView;
                            androidx.recyclerview.widget.RecyclerView recyclerView = (androidx.recyclerview.widget.RecyclerView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                            if (recyclerView != null) {
                                return new moji.com.mjweather.databinding.ActivityTabMemberBinding((androidx.constraintlayout.widget.ConstraintLayout) view, imageView, constraintLayout, constraintLayout2, imageView2, imageView3, findChildViewById, findChildViewById2, recyclerView);
                            }
                        }
                    }
                }
            }
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.ActivityTabMemberBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.ActivityTabMemberBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(moji.com.mjweather.R.layout.activity_tab_member, viewGroup, false);
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
