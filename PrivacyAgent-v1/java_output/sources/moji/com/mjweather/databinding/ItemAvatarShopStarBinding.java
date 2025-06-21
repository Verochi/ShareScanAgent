package moji.com.mjweather.databinding;

/* loaded from: classes20.dex */
public final class ItemAvatarShopStarBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final android.widget.ImageView ivAvatarLine;

    @androidx.annotation.NonNull
    public final com.moji.imageview.RoundCornerImageView ivAvsIcon;

    @androidx.annotation.NonNull
    public final android.widget.ImageView ivRankArrow;

    @androidx.annotation.NonNull
    public final com.moji.mjweather.assshop.view.AvatarItemVoiceView ivVoiceTrial;

    @androidx.annotation.NonNull
    public final android.widget.FrameLayout llAvatarDownlad;

    @androidx.annotation.NonNull
    public final android.widget.LinearLayout n;

    @androidx.annotation.NonNull
    public final com.moji.mjweather.assshop.view.RoundProgressBar rpbRoundProgress;

    @androidx.annotation.NonNull
    public final android.widget.TextView starVoice;

    @androidx.annotation.NonNull
    public final android.widget.TextView tvAvatarDownload;

    @androidx.annotation.NonNull
    public final com.moji.mjweather.assshop.view.TopRightTextView tvAvatarName;

    @androidx.annotation.NonNull
    public final android.widget.TextView tvAvatarUseNum;

    @androidx.annotation.NonNull
    public final android.widget.TextView tvRankNum;

    public ItemAvatarShopStarBinding(@androidx.annotation.NonNull android.widget.LinearLayout linearLayout, @androidx.annotation.NonNull android.widget.ImageView imageView, @androidx.annotation.NonNull com.moji.imageview.RoundCornerImageView roundCornerImageView, @androidx.annotation.NonNull android.widget.ImageView imageView2, @androidx.annotation.NonNull com.moji.mjweather.assshop.view.AvatarItemVoiceView avatarItemVoiceView, @androidx.annotation.NonNull android.widget.FrameLayout frameLayout, @androidx.annotation.NonNull com.moji.mjweather.assshop.view.RoundProgressBar roundProgressBar, @androidx.annotation.NonNull android.widget.TextView textView, @androidx.annotation.NonNull android.widget.TextView textView2, @androidx.annotation.NonNull com.moji.mjweather.assshop.view.TopRightTextView topRightTextView, @androidx.annotation.NonNull android.widget.TextView textView3, @androidx.annotation.NonNull android.widget.TextView textView4) {
        this.n = linearLayout;
        this.ivAvatarLine = imageView;
        this.ivAvsIcon = roundCornerImageView;
        this.ivRankArrow = imageView2;
        this.ivVoiceTrial = avatarItemVoiceView;
        this.llAvatarDownlad = frameLayout;
        this.rpbRoundProgress = roundProgressBar;
        this.starVoice = textView;
        this.tvAvatarDownload = textView2;
        this.tvAvatarName = topRightTextView;
        this.tvAvatarUseNum = textView3;
        this.tvRankNum = textView4;
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.ItemAvatarShopStarBinding bind(@androidx.annotation.NonNull android.view.View view) {
        com.moji.imageview.RoundCornerImageView findChildViewById;
        com.moji.mjweather.assshop.view.AvatarItemVoiceView findChildViewById2;
        com.moji.mjweather.assshop.view.RoundProgressBar findChildViewById3;
        com.moji.mjweather.assshop.view.TopRightTextView findChildViewById4;
        int i = moji.com.mjweather.R.id.iv_avatar_line;
        android.widget.ImageView imageView = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (imageView != null && (findChildViewById = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.iv_avs_icon))) != null) {
            i = moji.com.mjweather.R.id.iv_rank_arrow;
            android.widget.ImageView imageView2 = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
            if (imageView2 != null && (findChildViewById2 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.iv_voice_trial))) != null) {
                i = moji.com.mjweather.R.id.ll_avatar_downlad;
                android.widget.FrameLayout frameLayout = (android.widget.FrameLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                if (frameLayout != null && (findChildViewById3 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.rpb_round_progress))) != null) {
                    i = moji.com.mjweather.R.id.star_voice;
                    android.widget.TextView textView = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                    if (textView != null) {
                        i = moji.com.mjweather.R.id.tv_avatar_download;
                        android.widget.TextView textView2 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                        if (textView2 != null && (findChildViewById4 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.tv_avatar_name))) != null) {
                            i = moji.com.mjweather.R.id.tv_avatar_use_num;
                            android.widget.TextView textView3 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                            if (textView3 != null) {
                                i = moji.com.mjweather.R.id.tv_rank_num;
                                android.widget.TextView textView4 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                if (textView4 != null) {
                                    return new moji.com.mjweather.databinding.ItemAvatarShopStarBinding((android.widget.LinearLayout) view, imageView, findChildViewById, imageView2, findChildViewById2, frameLayout, findChildViewById3, textView, textView2, findChildViewById4, textView3, textView4);
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
    public static moji.com.mjweather.databinding.ItemAvatarShopStarBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.ItemAvatarShopStarBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(moji.com.mjweather.R.layout.item_avatar_shop_star, viewGroup, false);
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
