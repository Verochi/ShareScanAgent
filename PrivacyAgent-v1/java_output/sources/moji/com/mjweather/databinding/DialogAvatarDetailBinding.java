package moji.com.mjweather.databinding;

/* loaded from: classes20.dex */
public final class DialogAvatarDetailBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final com.moji.mjweather.assshop.view.AssistIndexControlView asDialogBannerIndexControl;

    @androidx.annotation.NonNull
    public final com.moji.mjweather.assshop.view.AssistSlipViewPager dialogBannerViewpager;

    @androidx.annotation.NonNull
    public final android.widget.ImageView ivDialogBannerBg;

    @androidx.annotation.NonNull
    public final android.widget.ImageView ivVoiceTrial;

    @androidx.annotation.NonNull
    public final android.widget.FrameLayout llAvatarDownlad;

    @androidx.annotation.NonNull
    public final android.widget.TextView loadFail;

    @androidx.annotation.NonNull
    public final com.moji.multiplestatuslayout.MJMultipleStatusLayout mslAvatarShop;

    @androidx.annotation.NonNull
    public final android.widget.LinearLayout n;

    @androidx.annotation.NonNull
    public final android.widget.RelativeLayout rlDialogBanner;

    @androidx.annotation.NonNull
    public final com.moji.mjweather.assshop.view.RoundProgressBar rpbRoundProgress;

    @androidx.annotation.NonNull
    public final android.widget.TextView tvAvatarDialogContent;

    @androidx.annotation.NonNull
    public final android.widget.TextView tvAvatarDialogLife;

    @androidx.annotation.NonNull
    public final android.widget.TextView tvAvatarDialogName;

    @androidx.annotation.NonNull
    public final android.widget.TextView tvAvatarDownload;

    public DialogAvatarDetailBinding(@androidx.annotation.NonNull android.widget.LinearLayout linearLayout, @androidx.annotation.NonNull com.moji.mjweather.assshop.view.AssistIndexControlView assistIndexControlView, @androidx.annotation.NonNull com.moji.mjweather.assshop.view.AssistSlipViewPager assistSlipViewPager, @androidx.annotation.NonNull android.widget.ImageView imageView, @androidx.annotation.NonNull android.widget.ImageView imageView2, @androidx.annotation.NonNull android.widget.FrameLayout frameLayout, @androidx.annotation.NonNull android.widget.TextView textView, @androidx.annotation.NonNull com.moji.multiplestatuslayout.MJMultipleStatusLayout mJMultipleStatusLayout, @androidx.annotation.NonNull android.widget.RelativeLayout relativeLayout, @androidx.annotation.NonNull com.moji.mjweather.assshop.view.RoundProgressBar roundProgressBar, @androidx.annotation.NonNull android.widget.TextView textView2, @androidx.annotation.NonNull android.widget.TextView textView3, @androidx.annotation.NonNull android.widget.TextView textView4, @androidx.annotation.NonNull android.widget.TextView textView5) {
        this.n = linearLayout;
        this.asDialogBannerIndexControl = assistIndexControlView;
        this.dialogBannerViewpager = assistSlipViewPager;
        this.ivDialogBannerBg = imageView;
        this.ivVoiceTrial = imageView2;
        this.llAvatarDownlad = frameLayout;
        this.loadFail = textView;
        this.mslAvatarShop = mJMultipleStatusLayout;
        this.rlDialogBanner = relativeLayout;
        this.rpbRoundProgress = roundProgressBar;
        this.tvAvatarDialogContent = textView2;
        this.tvAvatarDialogLife = textView3;
        this.tvAvatarDialogName = textView4;
        this.tvAvatarDownload = textView5;
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.DialogAvatarDetailBinding bind(@androidx.annotation.NonNull android.view.View view) {
        com.moji.mjweather.assshop.view.AssistSlipViewPager findChildViewById;
        com.moji.multiplestatuslayout.MJMultipleStatusLayout findChildViewById2;
        com.moji.mjweather.assshop.view.RoundProgressBar findChildViewById3;
        int i = moji.com.mjweather.R.id.as_dialog_banner_index_control;
        com.moji.mjweather.assshop.view.AssistIndexControlView findChildViewById4 = androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (findChildViewById4 != null && (findChildViewById = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.dialog_banner_viewpager))) != null) {
            i = moji.com.mjweather.R.id.iv_dialog_banner_bg;
            android.widget.ImageView imageView = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
            if (imageView != null) {
                i = moji.com.mjweather.R.id.iv_voice_trial;
                android.widget.ImageView imageView2 = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                if (imageView2 != null) {
                    i = moji.com.mjweather.R.id.ll_avatar_downlad;
                    android.widget.FrameLayout frameLayout = (android.widget.FrameLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                    if (frameLayout != null) {
                        i = moji.com.mjweather.R.id.load_fail;
                        android.widget.TextView textView = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                        if (textView != null && (findChildViewById2 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.msl_avatar_shop))) != null) {
                            i = moji.com.mjweather.R.id.rl_dialog_banner;
                            android.widget.RelativeLayout relativeLayout = (android.widget.RelativeLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                            if (relativeLayout != null && (findChildViewById3 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.rpb_round_progress))) != null) {
                                i = moji.com.mjweather.R.id.tv_avatar_dialog_content;
                                android.widget.TextView textView2 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                if (textView2 != null) {
                                    i = moji.com.mjweather.R.id.tv_avatar_dialog_life;
                                    android.widget.TextView textView3 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                    if (textView3 != null) {
                                        i = moji.com.mjweather.R.id.tv_avatar_dialog_name;
                                        android.widget.TextView textView4 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                        if (textView4 != null) {
                                            i = moji.com.mjweather.R.id.tv_avatar_download;
                                            android.widget.TextView textView5 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                            if (textView5 != null) {
                                                return new moji.com.mjweather.databinding.DialogAvatarDetailBinding((android.widget.LinearLayout) view, findChildViewById4, findChildViewById, imageView, imageView2, frameLayout, textView, findChildViewById2, relativeLayout, findChildViewById3, textView2, textView3, textView4, textView5);
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
    public static moji.com.mjweather.databinding.DialogAvatarDetailBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.DialogAvatarDetailBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(moji.com.mjweather.R.layout.dialog_avatar_detail, viewGroup, false);
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
