package moji.com.mjweather.databinding;

/* loaded from: classes20.dex */
public final class FragmentMainBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final android.widget.ImageView ivTab;

    @androidx.annotation.NonNull
    public final android.widget.RelativeLayout lottieRootLayout;

    @androidx.annotation.NonNull
    public final android.widget.FrameLayout mainRootLayout;

    @androidx.annotation.NonNull
    public final android.widget.FrameLayout maincontent;

    @androidx.annotation.NonNull
    public final android.widget.FrameLayout n;

    @androidx.annotation.NonNull
    public final android.widget.RelativeLayout plusIconBG;

    @androidx.annotation.NonNull
    public final android.widget.ImageView plusIconShade;

    @androidx.annotation.NonNull
    public final android.view.View tabBgView;

    @androidx.annotation.NonNull
    public final androidx.constraintlayout.widget.ConstraintLayout tabHostContainer;

    @androidx.annotation.NonNull
    public final android.widget.FrameLayout tabcontent;

    @androidx.annotation.NonNull
    public final com.moji.base.MJFragmentTabHost tabhost;

    public FragmentMainBinding(@androidx.annotation.NonNull android.widget.FrameLayout frameLayout, @androidx.annotation.NonNull android.widget.ImageView imageView, @androidx.annotation.NonNull android.widget.RelativeLayout relativeLayout, @androidx.annotation.NonNull android.widget.FrameLayout frameLayout2, @androidx.annotation.NonNull android.widget.FrameLayout frameLayout3, @androidx.annotation.NonNull android.widget.RelativeLayout relativeLayout2, @androidx.annotation.NonNull android.widget.ImageView imageView2, @androidx.annotation.NonNull android.view.View view, @androidx.annotation.NonNull androidx.constraintlayout.widget.ConstraintLayout constraintLayout, @androidx.annotation.NonNull android.widget.FrameLayout frameLayout4, @androidx.annotation.NonNull com.moji.base.MJFragmentTabHost mJFragmentTabHost) {
        this.n = frameLayout;
        this.ivTab = imageView;
        this.lottieRootLayout = relativeLayout;
        this.mainRootLayout = frameLayout2;
        this.maincontent = frameLayout3;
        this.plusIconBG = relativeLayout2;
        this.plusIconShade = imageView2;
        this.tabBgView = view;
        this.tabHostContainer = constraintLayout;
        this.tabcontent = frameLayout4;
        this.tabhost = mJFragmentTabHost;
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.FragmentMainBinding bind(@androidx.annotation.NonNull android.view.View view) {
        android.view.View findChildViewById;
        int i = moji.com.mjweather.R.id.iv_tab;
        android.widget.ImageView imageView = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = moji.com.mjweather.R.id.lottieRootLayout;
            android.widget.RelativeLayout relativeLayout = (android.widget.RelativeLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
            if (relativeLayout != null) {
                android.widget.FrameLayout frameLayout = (android.widget.FrameLayout) view;
                i = moji.com.mjweather.R.id.maincontent;
                android.widget.FrameLayout frameLayout2 = (android.widget.FrameLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                if (frameLayout2 != null) {
                    i = moji.com.mjweather.R.id.plusIconBG;
                    android.widget.RelativeLayout relativeLayout2 = (android.widget.RelativeLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                    if (relativeLayout2 != null) {
                        i = moji.com.mjweather.R.id.plusIconShade;
                        android.widget.ImageView imageView2 = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                        if (imageView2 != null && (findChildViewById = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.tabBgView))) != null) {
                            i = moji.com.mjweather.R.id.tab_host_container;
                            androidx.constraintlayout.widget.ConstraintLayout constraintLayout = (androidx.constraintlayout.widget.ConstraintLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                            if (constraintLayout != null) {
                                i = android.R.id.tabcontent;
                                android.widget.FrameLayout frameLayout3 = (android.widget.FrameLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, android.R.id.tabcontent);
                                if (frameLayout3 != null) {
                                    i = android.R.id.tabhost;
                                    com.moji.base.MJFragmentTabHost findChildViewById2 = androidx.viewbinding.ViewBindings.findChildViewById(view, android.R.id.tabhost);
                                    if (findChildViewById2 != null) {
                                        return new moji.com.mjweather.databinding.FragmentMainBinding(frameLayout, imageView, relativeLayout, frameLayout, frameLayout2, relativeLayout2, imageView2, findChildViewById, constraintLayout, frameLayout3, findChildViewById2);
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
    public static moji.com.mjweather.databinding.FragmentMainBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.FragmentMainBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(moji.com.mjweather.R.layout.fragment_main, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @androidx.annotation.NonNull
    public android.widget.FrameLayout getRoot() {
        return this.n;
    }
}
