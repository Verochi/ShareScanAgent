package moji.com.mjweather.databinding;

/* loaded from: classes20.dex */
public final class FragmentTabNewLiveviewBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final androidx.constraintlayout.widget.ConstraintLayout clDiscoverV2Location;

    @androidx.annotation.NonNull
    public final com.moji.mjad.view.DragFloatButton dfbLiveButton;

    @androidx.annotation.NonNull
    public final com.moji.imageview.MJImageView ivDiscoverLocation;

    @androidx.annotation.NonNull
    public final androidx.constraintlayout.widget.ConstraintLayout n;

    @androidx.annotation.NonNull
    public final com.moji.textview.MJTextView tvDiscoverLocation;

    @androidx.annotation.NonNull
    public final com.moji.newliveview.rank.view.NoScrollerViewPage vHomePager;

    @androidx.annotation.NonNull
    public final com.moji.imageview.MJImageView vSearch;

    @androidx.annotation.NonNull
    public final com.moji.liveview.home.view.LiveHomeTabView vTabLayout;

    @androidx.annotation.NonNull
    public final android.widget.ImageView vTabShadowBg;

    public FragmentTabNewLiveviewBinding(@androidx.annotation.NonNull androidx.constraintlayout.widget.ConstraintLayout constraintLayout, @androidx.annotation.NonNull androidx.constraintlayout.widget.ConstraintLayout constraintLayout2, @androidx.annotation.NonNull com.moji.mjad.view.DragFloatButton dragFloatButton, @androidx.annotation.NonNull com.moji.imageview.MJImageView mJImageView, @androidx.annotation.NonNull com.moji.textview.MJTextView mJTextView, @androidx.annotation.NonNull com.moji.newliveview.rank.view.NoScrollerViewPage noScrollerViewPage, @androidx.annotation.NonNull com.moji.imageview.MJImageView mJImageView2, @androidx.annotation.NonNull com.moji.liveview.home.view.LiveHomeTabView liveHomeTabView, @androidx.annotation.NonNull android.widget.ImageView imageView) {
        this.n = constraintLayout;
        this.clDiscoverV2Location = constraintLayout2;
        this.dfbLiveButton = dragFloatButton;
        this.ivDiscoverLocation = mJImageView;
        this.tvDiscoverLocation = mJTextView;
        this.vHomePager = noScrollerViewPage;
        this.vSearch = mJImageView2;
        this.vTabLayout = liveHomeTabView;
        this.vTabShadowBg = imageView;
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.FragmentTabNewLiveviewBinding bind(@androidx.annotation.NonNull android.view.View view) {
        com.moji.mjad.view.DragFloatButton findChildViewById;
        com.moji.imageview.MJImageView findChildViewById2;
        com.moji.textview.MJTextView findChildViewById3;
        com.moji.newliveview.rank.view.NoScrollerViewPage findChildViewById4;
        com.moji.imageview.MJImageView findChildViewById5;
        com.moji.liveview.home.view.LiveHomeTabView findChildViewById6;
        int i = moji.com.mjweather.R.id.cl_discover_v2_location;
        androidx.constraintlayout.widget.ConstraintLayout constraintLayout = (androidx.constraintlayout.widget.ConstraintLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (constraintLayout != null && (findChildViewById = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.dfb_live_button))) != null && (findChildViewById2 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.iv_discover_location))) != null && (findChildViewById3 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.tv_discover_location))) != null && (findChildViewById4 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.vHomePager))) != null && (findChildViewById5 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.vSearch))) != null && (findChildViewById6 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.vTabLayout))) != null) {
            i = moji.com.mjweather.R.id.vTabShadowBg;
            android.widget.ImageView imageView = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
            if (imageView != null) {
                return new moji.com.mjweather.databinding.FragmentTabNewLiveviewBinding((androidx.constraintlayout.widget.ConstraintLayout) view, constraintLayout, findChildViewById, findChildViewById2, findChildViewById3, findChildViewById4, findChildViewById5, findChildViewById6, imageView);
            }
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.FragmentTabNewLiveviewBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.FragmentTabNewLiveviewBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(moji.com.mjweather.R.layout.fragment_tab_new_liveview, viewGroup, false);
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
