package moji.com.mjweather.databinding;

/* loaded from: classes31.dex */
public final class ActivityAssistShopBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final com.moji.mjweather.assshop.view.AssistIndexControlView asBannerIndexControl;

    @androidx.annotation.NonNull
    public final com.moji.titlebar.MJTitleBar assistTitleBar;

    @androidx.annotation.NonNull
    public final com.moji.mjweather.assshop.view.AspectAssistSlipViewPager bannerViewpager;

    @androidx.annotation.NonNull
    public final com.moji.mjweather.assshop.view.DragTopLayout dragLayout;

    @androidx.annotation.NonNull
    public final android.widget.LinearLayout n;

    @androidx.annotation.NonNull
    public final android.widget.RadioButton rbMoRecommendMove;

    @androidx.annotation.NonNull
    public final android.widget.RadioButton rbStarFigureMove;

    @androidx.annotation.NonNull
    public final android.widget.RadioGroup rgMove;

    @androidx.annotation.NonNull
    public final android.widget.RelativeLayout rlBannerHeader;

    @androidx.annotation.NonNull
    public final com.moji.mjweather.assshop.view.AssistScrollerControl scScrollercontrolMove;

    @androidx.annotation.NonNull
    public final com.moji.multiplestatuslayout.MJMultipleStatusLayout statusLayout;

    @androidx.annotation.NonNull
    public final android.widget.FrameLayout tabcontent;

    @androidx.annotation.NonNull
    public final android.widget.TabHost tabhostMove;

    @androidx.annotation.NonNull
    public final android.widget.TabWidget tabs;

    @androidx.annotation.NonNull
    public final androidx.viewpager.widget.ViewPager vpAvatarShop;

    public ActivityAssistShopBinding(@androidx.annotation.NonNull android.widget.LinearLayout linearLayout, @androidx.annotation.NonNull com.moji.mjweather.assshop.view.AssistIndexControlView assistIndexControlView, @androidx.annotation.NonNull com.moji.titlebar.MJTitleBar mJTitleBar, @androidx.annotation.NonNull com.moji.mjweather.assshop.view.AspectAssistSlipViewPager aspectAssistSlipViewPager, @androidx.annotation.NonNull com.moji.mjweather.assshop.view.DragTopLayout dragTopLayout, @androidx.annotation.NonNull android.widget.RadioButton radioButton, @androidx.annotation.NonNull android.widget.RadioButton radioButton2, @androidx.annotation.NonNull android.widget.RadioGroup radioGroup, @androidx.annotation.NonNull android.widget.RelativeLayout relativeLayout, @androidx.annotation.NonNull com.moji.mjweather.assshop.view.AssistScrollerControl assistScrollerControl, @androidx.annotation.NonNull com.moji.multiplestatuslayout.MJMultipleStatusLayout mJMultipleStatusLayout, @androidx.annotation.NonNull android.widget.FrameLayout frameLayout, @androidx.annotation.NonNull android.widget.TabHost tabHost, @androidx.annotation.NonNull android.widget.TabWidget tabWidget, @androidx.annotation.NonNull androidx.viewpager.widget.ViewPager viewPager) {
        this.n = linearLayout;
        this.asBannerIndexControl = assistIndexControlView;
        this.assistTitleBar = mJTitleBar;
        this.bannerViewpager = aspectAssistSlipViewPager;
        this.dragLayout = dragTopLayout;
        this.rbMoRecommendMove = radioButton;
        this.rbStarFigureMove = radioButton2;
        this.rgMove = radioGroup;
        this.rlBannerHeader = relativeLayout;
        this.scScrollercontrolMove = assistScrollerControl;
        this.statusLayout = mJMultipleStatusLayout;
        this.tabcontent = frameLayout;
        this.tabhostMove = tabHost;
        this.tabs = tabWidget;
        this.vpAvatarShop = viewPager;
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.ActivityAssistShopBinding bind(@androidx.annotation.NonNull android.view.View view) {
        com.moji.titlebar.MJTitleBar findChildViewById;
        com.moji.mjweather.assshop.view.AspectAssistSlipViewPager findChildViewById2;
        com.moji.mjweather.assshop.view.DragTopLayout findChildViewById3;
        com.moji.mjweather.assshop.view.AssistScrollerControl findChildViewById4;
        com.moji.multiplestatuslayout.MJMultipleStatusLayout findChildViewById5;
        int i = moji.com.mjweather.R.id.as_banner_index_control;
        com.moji.mjweather.assshop.view.AssistIndexControlView findChildViewById6 = androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (findChildViewById6 != null && (findChildViewById = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.assist_title_bar))) != null && (findChildViewById2 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.banner_viewpager))) != null && (findChildViewById3 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.drag_layout))) != null) {
            i = moji.com.mjweather.R.id.rb_mo_recommend_move;
            android.widget.RadioButton radioButton = (android.widget.RadioButton) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
            if (radioButton != null) {
                i = moji.com.mjweather.R.id.rb_star_figure_move;
                android.widget.RadioButton radioButton2 = (android.widget.RadioButton) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                if (radioButton2 != null) {
                    i = moji.com.mjweather.R.id.rg_move;
                    android.widget.RadioGroup radioGroup = (android.widget.RadioGroup) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                    if (radioGroup != null) {
                        i = moji.com.mjweather.R.id.rl_banner_header;
                        android.widget.RelativeLayout relativeLayout = (android.widget.RelativeLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                        if (relativeLayout != null && (findChildViewById4 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.sc_scrollercontrol_move))) != null && (findChildViewById5 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.status_layout))) != null) {
                            i = android.R.id.tabcontent;
                            android.widget.FrameLayout frameLayout = (android.widget.FrameLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, android.R.id.tabcontent);
                            if (frameLayout != null) {
                                i = moji.com.mjweather.R.id.tabhost_move;
                                android.widget.TabHost tabHost = (android.widget.TabHost) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                if (tabHost != null) {
                                    i = android.R.id.tabs;
                                    android.widget.TabWidget tabWidget = (android.widget.TabWidget) androidx.viewbinding.ViewBindings.findChildViewById(view, android.R.id.tabs);
                                    if (tabWidget != null) {
                                        i = moji.com.mjweather.R.id.vp_avatar_shop;
                                        androidx.viewpager.widget.ViewPager viewPager = (androidx.viewpager.widget.ViewPager) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                        if (viewPager != null) {
                                            return new moji.com.mjweather.databinding.ActivityAssistShopBinding((android.widget.LinearLayout) view, findChildViewById6, findChildViewById, findChildViewById2, findChildViewById3, radioButton, radioButton2, radioGroup, relativeLayout, findChildViewById4, findChildViewById5, frameLayout, tabHost, tabWidget, viewPager);
                                        }
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
    public static moji.com.mjweather.databinding.ActivityAssistShopBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.ActivityAssistShopBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(moji.com.mjweather.R.layout.activity_assist_shop, viewGroup, false);
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
