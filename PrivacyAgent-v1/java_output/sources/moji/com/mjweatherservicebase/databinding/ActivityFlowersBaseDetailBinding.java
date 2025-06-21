package moji.com.mjweatherservicebase.databinding;

/* loaded from: classes20.dex */
public final class ActivityFlowersBaseDetailBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final android.widget.RelativeLayout contentLayout;

    @androidx.annotation.NonNull
    public final moji.com.mjweatherservicebase.detail.FDetailLiveHorizontalLayout detailHorizontalLiveView;

    @androidx.annotation.NonNull
    public final moji.com.mjweatherservicebase.detail.FDetailLiveVerticalLayout detailVerticalLiveView;

    @androidx.annotation.NonNull
    public final moji.com.mjweatherservicebase.detail.RFlowerViewDivider dividerIntroduce;

    @androidx.annotation.NonNull
    public final moji.com.mjweatherservicebase.detail.RFlowerViewDivider dividerSpotImage;

    @androidx.annotation.NonNull
    public final moji.com.mjweatherservicebase.detail.RFlowerViewDivider dividerTraffic;

    @androidx.annotation.NonNull
    public final android.widget.FrameLayout feedbackLayout;

    @androidx.annotation.NonNull
    public final android.widget.LinearLayout llDetailIntroduceLayout;

    @androidx.annotation.NonNull
    public final android.widget.LinearLayout llDetailLiveviewLayout;

    @androidx.annotation.NonNull
    public final android.widget.LinearLayout llDetailMapLayout;

    @androidx.annotation.NonNull
    public final android.widget.LinearLayout llDetailTrafficLayout;

    @androidx.annotation.NonNull
    public final android.widget.LinearLayout n;

    @androidx.annotation.NonNull
    public final android.widget.TextView rfFeedBack;

    @androidx.annotation.NonNull
    public final android.widget.LinearLayout rootview;

    @androidx.annotation.NonNull
    public final android.widget.LinearLayout sakuraContentLayout;

    @androidx.annotation.NonNull
    public final moji.com.mjweatherservicebase.detail.DetailCardLayout sakuraDetailCard;

    @androidx.annotation.NonNull
    public final com.moji.multiplestatuslayout.MJMultipleStatusLayout sakuraDetailStatusLayout;

    @androidx.annotation.NonNull
    public final com.moji.titlebar.MJTitleBar sakuraDetailTitle;

    @androidx.annotation.NonNull
    public final moji.com.mjweatherservicebase.detail.DetailTopLayout sakuraDetailTop;

    @androidx.annotation.NonNull
    public final android.widget.TextView sakuraSpotBus;

    @androidx.annotation.NonNull
    public final com.moji.scrollview.ScrollViewMonitor slSakuraDetail;

    @androidx.annotation.NonNull
    public final android.widget.TextView spotIntroduce;

    @androidx.annotation.NonNull
    public final android.widget.TextView tvExplainText;

    public ActivityFlowersBaseDetailBinding(@androidx.annotation.NonNull android.widget.LinearLayout linearLayout, @androidx.annotation.NonNull android.widget.RelativeLayout relativeLayout, @androidx.annotation.NonNull moji.com.mjweatherservicebase.detail.FDetailLiveHorizontalLayout fDetailLiveHorizontalLayout, @androidx.annotation.NonNull moji.com.mjweatherservicebase.detail.FDetailLiveVerticalLayout fDetailLiveVerticalLayout, @androidx.annotation.NonNull moji.com.mjweatherservicebase.detail.RFlowerViewDivider rFlowerViewDivider, @androidx.annotation.NonNull moji.com.mjweatherservicebase.detail.RFlowerViewDivider rFlowerViewDivider2, @androidx.annotation.NonNull moji.com.mjweatherservicebase.detail.RFlowerViewDivider rFlowerViewDivider3, @androidx.annotation.NonNull android.widget.FrameLayout frameLayout, @androidx.annotation.NonNull android.widget.LinearLayout linearLayout2, @androidx.annotation.NonNull android.widget.LinearLayout linearLayout3, @androidx.annotation.NonNull android.widget.LinearLayout linearLayout4, @androidx.annotation.NonNull android.widget.LinearLayout linearLayout5, @androidx.annotation.NonNull android.widget.TextView textView, @androidx.annotation.NonNull android.widget.LinearLayout linearLayout6, @androidx.annotation.NonNull android.widget.LinearLayout linearLayout7, @androidx.annotation.NonNull moji.com.mjweatherservicebase.detail.DetailCardLayout detailCardLayout, @androidx.annotation.NonNull com.moji.multiplestatuslayout.MJMultipleStatusLayout mJMultipleStatusLayout, @androidx.annotation.NonNull com.moji.titlebar.MJTitleBar mJTitleBar, @androidx.annotation.NonNull moji.com.mjweatherservicebase.detail.DetailTopLayout detailTopLayout, @androidx.annotation.NonNull android.widget.TextView textView2, @androidx.annotation.NonNull com.moji.scrollview.ScrollViewMonitor scrollViewMonitor, @androidx.annotation.NonNull android.widget.TextView textView3, @androidx.annotation.NonNull android.widget.TextView textView4) {
        this.n = linearLayout;
        this.contentLayout = relativeLayout;
        this.detailHorizontalLiveView = fDetailLiveHorizontalLayout;
        this.detailVerticalLiveView = fDetailLiveVerticalLayout;
        this.dividerIntroduce = rFlowerViewDivider;
        this.dividerSpotImage = rFlowerViewDivider2;
        this.dividerTraffic = rFlowerViewDivider3;
        this.feedbackLayout = frameLayout;
        this.llDetailIntroduceLayout = linearLayout2;
        this.llDetailLiveviewLayout = linearLayout3;
        this.llDetailMapLayout = linearLayout4;
        this.llDetailTrafficLayout = linearLayout5;
        this.rfFeedBack = textView;
        this.rootview = linearLayout6;
        this.sakuraContentLayout = linearLayout7;
        this.sakuraDetailCard = detailCardLayout;
        this.sakuraDetailStatusLayout = mJMultipleStatusLayout;
        this.sakuraDetailTitle = mJTitleBar;
        this.sakuraDetailTop = detailTopLayout;
        this.sakuraSpotBus = textView2;
        this.slSakuraDetail = scrollViewMonitor;
        this.spotIntroduce = textView3;
        this.tvExplainText = textView4;
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweatherservicebase.databinding.ActivityFlowersBaseDetailBinding bind(@androidx.annotation.NonNull android.view.View view) {
        com.moji.multiplestatuslayout.MJMultipleStatusLayout findChildViewById;
        com.moji.titlebar.MJTitleBar findChildViewById2;
        com.moji.scrollview.ScrollViewMonitor findChildViewById3;
        int i = moji.com.mjweatherservicebase.R.id.content_layout;
        android.widget.RelativeLayout relativeLayout = (android.widget.RelativeLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (relativeLayout != null) {
            i = moji.com.mjweatherservicebase.R.id.detail_horizontal_live_view;
            moji.com.mjweatherservicebase.detail.FDetailLiveHorizontalLayout fDetailLiveHorizontalLayout = (moji.com.mjweatherservicebase.detail.FDetailLiveHorizontalLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
            if (fDetailLiveHorizontalLayout != null) {
                i = moji.com.mjweatherservicebase.R.id.detail_vertical_live_view;
                moji.com.mjweatherservicebase.detail.FDetailLiveVerticalLayout fDetailLiveVerticalLayout = (moji.com.mjweatherservicebase.detail.FDetailLiveVerticalLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                if (fDetailLiveVerticalLayout != null) {
                    i = moji.com.mjweatherservicebase.R.id.divider_introduce;
                    moji.com.mjweatherservicebase.detail.RFlowerViewDivider rFlowerViewDivider = (moji.com.mjweatherservicebase.detail.RFlowerViewDivider) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                    if (rFlowerViewDivider != null) {
                        i = moji.com.mjweatherservicebase.R.id.divider_spot_image;
                        moji.com.mjweatherservicebase.detail.RFlowerViewDivider rFlowerViewDivider2 = (moji.com.mjweatherservicebase.detail.RFlowerViewDivider) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                        if (rFlowerViewDivider2 != null) {
                            i = moji.com.mjweatherservicebase.R.id.divider_traffic;
                            moji.com.mjweatherservicebase.detail.RFlowerViewDivider rFlowerViewDivider3 = (moji.com.mjweatherservicebase.detail.RFlowerViewDivider) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                            if (rFlowerViewDivider3 != null) {
                                i = moji.com.mjweatherservicebase.R.id.feedback_layout;
                                android.widget.FrameLayout frameLayout = (android.widget.FrameLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                if (frameLayout != null) {
                                    i = moji.com.mjweatherservicebase.R.id.ll_detail_introduce_layout;
                                    android.widget.LinearLayout linearLayout = (android.widget.LinearLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                    if (linearLayout != null) {
                                        i = moji.com.mjweatherservicebase.R.id.ll_detail_liveview_layout;
                                        android.widget.LinearLayout linearLayout2 = (android.widget.LinearLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                        if (linearLayout2 != null) {
                                            i = moji.com.mjweatherservicebase.R.id.ll_detail_map_layout;
                                            android.widget.LinearLayout linearLayout3 = (android.widget.LinearLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                            if (linearLayout3 != null) {
                                                i = moji.com.mjweatherservicebase.R.id.ll_detail_traffic_layout;
                                                android.widget.LinearLayout linearLayout4 = (android.widget.LinearLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                                if (linearLayout4 != null) {
                                                    i = moji.com.mjweatherservicebase.R.id.rf_feed_back;
                                                    android.widget.TextView textView = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                                    if (textView != null) {
                                                        android.widget.LinearLayout linearLayout5 = (android.widget.LinearLayout) view;
                                                        i = moji.com.mjweatherservicebase.R.id.sakura_content_layout;
                                                        android.widget.LinearLayout linearLayout6 = (android.widget.LinearLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                                        if (linearLayout6 != null) {
                                                            i = moji.com.mjweatherservicebase.R.id.sakura_detail_card;
                                                            moji.com.mjweatherservicebase.detail.DetailCardLayout detailCardLayout = (moji.com.mjweatherservicebase.detail.DetailCardLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                                            if (detailCardLayout != null && (findChildViewById = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweatherservicebase.R.id.sakura_detail_status_layout))) != null && (findChildViewById2 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweatherservicebase.R.id.sakura_detail_title))) != null) {
                                                                i = moji.com.mjweatherservicebase.R.id.sakura_detail_top;
                                                                moji.com.mjweatherservicebase.detail.DetailTopLayout detailTopLayout = (moji.com.mjweatherservicebase.detail.DetailTopLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                                                if (detailTopLayout != null) {
                                                                    i = moji.com.mjweatherservicebase.R.id.sakura_spot_bus;
                                                                    android.widget.TextView textView2 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                                                    if (textView2 != null && (findChildViewById3 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweatherservicebase.R.id.sl_sakura_detail))) != null) {
                                                                        i = moji.com.mjweatherservicebase.R.id.spot_introduce;
                                                                        android.widget.TextView textView3 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                                                        if (textView3 != null) {
                                                                            i = moji.com.mjweatherservicebase.R.id.tv_explain_text;
                                                                            android.widget.TextView textView4 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                                                            if (textView4 != null) {
                                                                                return new moji.com.mjweatherservicebase.databinding.ActivityFlowersBaseDetailBinding(linearLayout5, relativeLayout, fDetailLiveHorizontalLayout, fDetailLiveVerticalLayout, rFlowerViewDivider, rFlowerViewDivider2, rFlowerViewDivider3, frameLayout, linearLayout, linearLayout2, linearLayout3, linearLayout4, textView, linearLayout5, linearLayout6, detailCardLayout, findChildViewById, findChildViewById2, detailTopLayout, textView2, findChildViewById3, textView3, textView4);
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
    public static moji.com.mjweatherservicebase.databinding.ActivityFlowersBaseDetailBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweatherservicebase.databinding.ActivityFlowersBaseDetailBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(moji.com.mjweatherservicebase.R.layout.activity_flowers_base_detail, viewGroup, false);
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
