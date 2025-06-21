package moji.com.mjweather.databinding;

/* loaded from: classes20.dex */
public final class FragmentTabLiveviewBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final com.moji.mjad.view.DragFloatButton dfbLiveButton;

    @androidx.annotation.NonNull
    public final android.widget.ImageView ivBg;

    @androidx.annotation.NonNull
    public final android.widget.ImageView ivNetCamera;

    @androidx.annotation.NonNull
    public final com.moji.titlebar.MJTitleBar mjTitleBar;

    @androidx.annotation.NonNull
    public final android.widget.RelativeLayout n;

    @androidx.annotation.NonNull
    public final com.moji.tablayout.TabLayout tabLayout;

    @androidx.annotation.NonNull
    public final android.widget.FrameLayout vLine;

    @androidx.annotation.NonNull
    public final android.widget.ImageView vSearch;

    @androidx.annotation.NonNull
    public final com.moji.newliveview.base.view.TakePhotoAnimationView vTakePhoto;

    @androidx.annotation.NonNull
    public final android.widget.FrameLayout vTakePhotoParent;

    @androidx.annotation.NonNull
    public final com.moji.newliveview.base.view.TakePhotoAnimationView vTakePhotoScale;

    @androidx.annotation.NonNull
    public final android.widget.ImageView vUserCenter;

    @androidx.annotation.NonNull
    public final com.moji.newliveview.rank.view.NoScrollerViewPage viewPager;

    @androidx.annotation.NonNull
    public final android.widget.FrameLayout viewTitle;

    public FragmentTabLiveviewBinding(@androidx.annotation.NonNull android.widget.RelativeLayout relativeLayout, @androidx.annotation.NonNull com.moji.mjad.view.DragFloatButton dragFloatButton, @androidx.annotation.NonNull android.widget.ImageView imageView, @androidx.annotation.NonNull android.widget.ImageView imageView2, @androidx.annotation.NonNull com.moji.titlebar.MJTitleBar mJTitleBar, @androidx.annotation.NonNull com.moji.tablayout.TabLayout tabLayout, @androidx.annotation.NonNull android.widget.FrameLayout frameLayout, @androidx.annotation.NonNull android.widget.ImageView imageView3, @androidx.annotation.NonNull com.moji.newliveview.base.view.TakePhotoAnimationView takePhotoAnimationView, @androidx.annotation.NonNull android.widget.FrameLayout frameLayout2, @androidx.annotation.NonNull com.moji.newliveview.base.view.TakePhotoAnimationView takePhotoAnimationView2, @androidx.annotation.NonNull android.widget.ImageView imageView4, @androidx.annotation.NonNull com.moji.newliveview.rank.view.NoScrollerViewPage noScrollerViewPage, @androidx.annotation.NonNull android.widget.FrameLayout frameLayout3) {
        this.n = relativeLayout;
        this.dfbLiveButton = dragFloatButton;
        this.ivBg = imageView;
        this.ivNetCamera = imageView2;
        this.mjTitleBar = mJTitleBar;
        this.tabLayout = tabLayout;
        this.vLine = frameLayout;
        this.vSearch = imageView3;
        this.vTakePhoto = takePhotoAnimationView;
        this.vTakePhotoParent = frameLayout2;
        this.vTakePhotoScale = takePhotoAnimationView2;
        this.vUserCenter = imageView4;
        this.viewPager = noScrollerViewPage;
        this.viewTitle = frameLayout3;
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.FragmentTabLiveviewBinding bind(@androidx.annotation.NonNull android.view.View view) {
        com.moji.titlebar.MJTitleBar findChildViewById;
        com.moji.tablayout.TabLayout findChildViewById2;
        com.moji.newliveview.base.view.TakePhotoAnimationView findChildViewById3;
        com.moji.newliveview.base.view.TakePhotoAnimationView findChildViewById4;
        com.moji.newliveview.rank.view.NoScrollerViewPage findChildViewById5;
        int i = moji.com.mjweather.R.id.dfb_live_button;
        com.moji.mjad.view.DragFloatButton findChildViewById6 = androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (findChildViewById6 != null) {
            i = moji.com.mjweather.R.id.ivBg;
            android.widget.ImageView imageView = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
            if (imageView != null) {
                i = moji.com.mjweather.R.id.ivNetCamera;
                android.widget.ImageView imageView2 = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                if (imageView2 != null && (findChildViewById = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.mjTitleBar))) != null && (findChildViewById2 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.tabLayout))) != null) {
                    i = moji.com.mjweather.R.id.vLine;
                    android.widget.FrameLayout frameLayout = (android.widget.FrameLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                    if (frameLayout != null) {
                        i = moji.com.mjweather.R.id.vSearch;
                        android.widget.ImageView imageView3 = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                        if (imageView3 != null && (findChildViewById3 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.vTakePhoto))) != null) {
                            i = moji.com.mjweather.R.id.vTakePhotoParent;
                            android.widget.FrameLayout frameLayout2 = (android.widget.FrameLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                            if (frameLayout2 != null && (findChildViewById4 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.vTakePhotoScale))) != null) {
                                i = moji.com.mjweather.R.id.vUserCenter;
                                android.widget.ImageView imageView4 = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                if (imageView4 != null && (findChildViewById5 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.viewPager))) != null) {
                                    i = moji.com.mjweather.R.id.view_title;
                                    android.widget.FrameLayout frameLayout3 = (android.widget.FrameLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                    if (frameLayout3 != null) {
                                        return new moji.com.mjweather.databinding.FragmentTabLiveviewBinding((android.widget.RelativeLayout) view, findChildViewById6, imageView, imageView2, findChildViewById, findChildViewById2, frameLayout, imageView3, findChildViewById3, frameLayout2, findChildViewById4, imageView4, findChildViewById5, frameLayout3);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.FragmentTabLiveviewBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.FragmentTabLiveviewBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(moji.com.mjweather.R.layout.fragment_tab_liveview, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @androidx.annotation.NonNull
    public android.widget.RelativeLayout getRoot() {
        return this.n;
    }
}
