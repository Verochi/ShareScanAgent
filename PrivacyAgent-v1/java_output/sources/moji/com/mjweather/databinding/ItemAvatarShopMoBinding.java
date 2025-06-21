package moji.com.mjweather.databinding;

/* loaded from: classes20.dex */
public final class ItemAvatarShopMoBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final com.moji.imageview.RoundCornerImageView ivAvsIcon;

    @androidx.annotation.NonNull
    public final com.moji.mjweather.assshop.view.AvatarItemVoiceView ivVoiceTrial;

    @androidx.annotation.NonNull
    public final android.widget.FrameLayout llAvatarDownlad;

    @androidx.annotation.NonNull
    public final android.widget.RelativeLayout n;

    @androidx.annotation.NonNull
    public final com.moji.mjweather.assshop.view.RoundProgressBar rpbRoundProgress;

    @androidx.annotation.NonNull
    public final android.widget.TextView tvAvatarDownload;

    @androidx.annotation.NonNull
    public final com.moji.mjweather.assshop.view.TopRightTextView tvAvatarName;

    @androidx.annotation.NonNull
    public final android.widget.TextView tvAvatarRecommend;

    @androidx.annotation.NonNull
    public final android.widget.TextView tvAvatarUseNum;

    public ItemAvatarShopMoBinding(@androidx.annotation.NonNull android.widget.RelativeLayout relativeLayout, @androidx.annotation.NonNull com.moji.imageview.RoundCornerImageView roundCornerImageView, @androidx.annotation.NonNull com.moji.mjweather.assshop.view.AvatarItemVoiceView avatarItemVoiceView, @androidx.annotation.NonNull android.widget.FrameLayout frameLayout, @androidx.annotation.NonNull com.moji.mjweather.assshop.view.RoundProgressBar roundProgressBar, @androidx.annotation.NonNull android.widget.TextView textView, @androidx.annotation.NonNull com.moji.mjweather.assshop.view.TopRightTextView topRightTextView, @androidx.annotation.NonNull android.widget.TextView textView2, @androidx.annotation.NonNull android.widget.TextView textView3) {
        this.n = relativeLayout;
        this.ivAvsIcon = roundCornerImageView;
        this.ivVoiceTrial = avatarItemVoiceView;
        this.llAvatarDownlad = frameLayout;
        this.rpbRoundProgress = roundProgressBar;
        this.tvAvatarDownload = textView;
        this.tvAvatarName = topRightTextView;
        this.tvAvatarRecommend = textView2;
        this.tvAvatarUseNum = textView3;
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.ItemAvatarShopMoBinding bind(@androidx.annotation.NonNull android.view.View view) {
        com.moji.mjweather.assshop.view.AvatarItemVoiceView findChildViewById;
        com.moji.mjweather.assshop.view.RoundProgressBar findChildViewById2;
        com.moji.mjweather.assshop.view.TopRightTextView findChildViewById3;
        int i = moji.com.mjweather.R.id.iv_avs_icon;
        com.moji.imageview.RoundCornerImageView findChildViewById4 = androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (findChildViewById4 != null && (findChildViewById = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.iv_voice_trial))) != null) {
            i = moji.com.mjweather.R.id.ll_avatar_downlad;
            android.widget.FrameLayout frameLayout = (android.widget.FrameLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
            if (frameLayout != null && (findChildViewById2 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.rpb_round_progress))) != null) {
                i = moji.com.mjweather.R.id.tv_avatar_download;
                android.widget.TextView textView = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                if (textView != null && (findChildViewById3 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.tv_avatar_name))) != null) {
                    i = moji.com.mjweather.R.id.tv_avatar_recommend;
                    android.widget.TextView textView2 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                    if (textView2 != null) {
                        i = moji.com.mjweather.R.id.tv_avatar_use_num;
                        android.widget.TextView textView3 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                        if (textView3 != null) {
                            return new moji.com.mjweather.databinding.ItemAvatarShopMoBinding((android.widget.RelativeLayout) view, findChildViewById4, findChildViewById, frameLayout, findChildViewById2, textView, findChildViewById3, textView2, textView3);
                        }
                    }
                }
            }
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.ItemAvatarShopMoBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.ItemAvatarShopMoBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(moji.com.mjweather.R.layout.item_avatar_shop_mo, viewGroup, false);
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
