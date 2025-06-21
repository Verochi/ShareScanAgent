package moji.com.mjweather.databinding;

/* loaded from: classes20.dex */
public final class FragmentMeTabBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final android.view.View bottomLineMeActivityCenter;

    @androidx.annotation.NonNull
    public final android.view.View bottomLineMeCircle;

    @androidx.annotation.NonNull
    public final android.widget.LinearLayout clearContainer;

    @androidx.annotation.NonNull
    public final com.moji.mjweather.assshop.view.DragTopLayout dragtoplayout;

    @androidx.annotation.NonNull
    public final com.moji.mjweather.tabme.widget.GapView gapView;

    @androidx.annotation.NonNull
    public final android.widget.LinearLayout llContainerAction;

    @androidx.annotation.NonNull
    public final android.widget.LinearLayout llContainerHead;

    @androidx.annotation.NonNull
    public final android.view.View meHeaderBottom;

    @androidx.annotation.NonNull
    public final android.widget.RelativeLayout n;

    @androidx.annotation.NonNull
    public final com.moji.scrollview.ScrollViewWithListener scrollview;

    @androidx.annotation.NonNull
    public final android.widget.TextView tvMeActivityCenter;

    @androidx.annotation.NonNull
    public final android.widget.TextView tvMeAssistShop;

    @androidx.annotation.NonNull
    public final android.widget.TextView tvMeCircle;

    @androidx.annotation.NonNull
    public final android.widget.TextView tvMeLifeService;

    @androidx.annotation.NonNull
    public final android.widget.TextView tvMeSetting;

    @androidx.annotation.NonNull
    public final android.widget.TextView tvMeSkinShop;

    @androidx.annotation.NonNull
    public final android.widget.TextView tvWebTest;

    @androidx.annotation.NonNull
    public final android.view.View viewSettingGroupGap;

    public FragmentMeTabBinding(@androidx.annotation.NonNull android.widget.RelativeLayout relativeLayout, @androidx.annotation.NonNull android.view.View view, @androidx.annotation.NonNull android.view.View view2, @androidx.annotation.NonNull android.widget.LinearLayout linearLayout, @androidx.annotation.NonNull com.moji.mjweather.assshop.view.DragTopLayout dragTopLayout, @androidx.annotation.NonNull com.moji.mjweather.tabme.widget.GapView gapView, @androidx.annotation.NonNull android.widget.LinearLayout linearLayout2, @androidx.annotation.NonNull android.widget.LinearLayout linearLayout3, @androidx.annotation.NonNull android.view.View view3, @androidx.annotation.NonNull com.moji.scrollview.ScrollViewWithListener scrollViewWithListener, @androidx.annotation.NonNull android.widget.TextView textView, @androidx.annotation.NonNull android.widget.TextView textView2, @androidx.annotation.NonNull android.widget.TextView textView3, @androidx.annotation.NonNull android.widget.TextView textView4, @androidx.annotation.NonNull android.widget.TextView textView5, @androidx.annotation.NonNull android.widget.TextView textView6, @androidx.annotation.NonNull android.widget.TextView textView7, @androidx.annotation.NonNull android.view.View view4) {
        this.n = relativeLayout;
        this.bottomLineMeActivityCenter = view;
        this.bottomLineMeCircle = view2;
        this.clearContainer = linearLayout;
        this.dragtoplayout = dragTopLayout;
        this.gapView = gapView;
        this.llContainerAction = linearLayout2;
        this.llContainerHead = linearLayout3;
        this.meHeaderBottom = view3;
        this.scrollview = scrollViewWithListener;
        this.tvMeActivityCenter = textView;
        this.tvMeAssistShop = textView2;
        this.tvMeCircle = textView3;
        this.tvMeLifeService = textView4;
        this.tvMeSetting = textView5;
        this.tvMeSkinShop = textView6;
        this.tvWebTest = textView7;
        this.viewSettingGroupGap = view4;
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.FragmentMeTabBinding bind(@androidx.annotation.NonNull android.view.View view) {
        android.view.View findChildViewById;
        com.moji.mjweather.assshop.view.DragTopLayout findChildViewById2;
        com.moji.mjweather.tabme.widget.GapView findChildViewById3;
        android.view.View findChildViewById4;
        com.moji.scrollview.ScrollViewWithListener findChildViewById5;
        android.view.View findChildViewById6;
        int i = moji.com.mjweather.R.id.bottom_line_me_activity_center;
        android.view.View findChildViewById7 = androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (findChildViewById7 != null && (findChildViewById = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.bottom_line_me_circle))) != null) {
            i = moji.com.mjweather.R.id.clear_container;
            android.widget.LinearLayout linearLayout = (android.widget.LinearLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
            if (linearLayout != null && (findChildViewById2 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.dragtoplayout))) != null && (findChildViewById3 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.gap_view))) != null) {
                i = moji.com.mjweather.R.id.ll_container_action;
                android.widget.LinearLayout linearLayout2 = (android.widget.LinearLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                if (linearLayout2 != null) {
                    i = moji.com.mjweather.R.id.ll_container_head;
                    android.widget.LinearLayout linearLayout3 = (android.widget.LinearLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                    if (linearLayout3 != null && (findChildViewById4 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.me_header_bottom))) != null && (findChildViewById5 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.scrollview))) != null) {
                        i = moji.com.mjweather.R.id.tv_me_activity_center;
                        android.widget.TextView textView = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                        if (textView != null) {
                            i = moji.com.mjweather.R.id.tv_me_assist_shop;
                            android.widget.TextView textView2 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                            if (textView2 != null) {
                                i = moji.com.mjweather.R.id.tv_me_circle;
                                android.widget.TextView textView3 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                if (textView3 != null) {
                                    i = moji.com.mjweather.R.id.tv_me_life_service;
                                    android.widget.TextView textView4 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                    if (textView4 != null) {
                                        i = moji.com.mjweather.R.id.tv_me_setting;
                                        android.widget.TextView textView5 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                        if (textView5 != null) {
                                            i = moji.com.mjweather.R.id.tv_me_skin_shop;
                                            android.widget.TextView textView6 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                            if (textView6 != null) {
                                                i = moji.com.mjweather.R.id.tv_web_test;
                                                android.widget.TextView textView7 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                                if (textView7 != null && (findChildViewById6 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.view_SettingGroupGap))) != null) {
                                                    return new moji.com.mjweather.databinding.FragmentMeTabBinding((android.widget.RelativeLayout) view, findChildViewById7, findChildViewById, linearLayout, findChildViewById2, findChildViewById3, linearLayout2, linearLayout3, findChildViewById4, findChildViewById5, textView, textView2, textView3, textView4, textView5, textView6, textView7, findChildViewById6);
                                                }
                                            }
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
    public static moji.com.mjweather.databinding.FragmentMeTabBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.FragmentMeTabBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(moji.com.mjweather.R.layout.fragment_me_tab, viewGroup, false);
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
