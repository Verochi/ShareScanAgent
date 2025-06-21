package moji.com.mjweather.databinding;

/* loaded from: classes20.dex */
public final class ItemAvatarShopSetBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final android.widget.TextView itemDeleteButton;

    @androidx.annotation.NonNull
    public final com.moji.imageview.RoundCornerImageView ivAvsIcon;

    @androidx.annotation.NonNull
    public final android.widget.ImageView ivDeleteHandle;

    @androidx.annotation.NonNull
    public final com.moji.mjweather.assshop.view.AvatarItemVoiceView ivVoiceTrial;

    @androidx.annotation.NonNull
    public final android.widget.FrameLayout llAvatarDownlad;

    @androidx.annotation.NonNull
    public final android.widget.LinearLayout n;

    @androidx.annotation.NonNull
    public final android.widget.RelativeLayout rlDeleteBotom;

    @androidx.annotation.NonNull
    public final com.moji.mjweather.assshop.view.RoundProgressBar rpbRoundProgress;

    @androidx.annotation.NonNull
    public final android.widget.TextView tvAvatarDownload;

    @androidx.annotation.NonNull
    public final com.moji.mjweather.assshop.view.TopRightTextView tvAvatarName;

    @androidx.annotation.NonNull
    public final android.widget.TextView tvAvatarUseNum;

    public ItemAvatarShopSetBinding(@androidx.annotation.NonNull android.widget.LinearLayout linearLayout, @androidx.annotation.NonNull android.widget.TextView textView, @androidx.annotation.NonNull com.moji.imageview.RoundCornerImageView roundCornerImageView, @androidx.annotation.NonNull android.widget.ImageView imageView, @androidx.annotation.NonNull com.moji.mjweather.assshop.view.AvatarItemVoiceView avatarItemVoiceView, @androidx.annotation.NonNull android.widget.FrameLayout frameLayout, @androidx.annotation.NonNull android.widget.RelativeLayout relativeLayout, @androidx.annotation.NonNull com.moji.mjweather.assshop.view.RoundProgressBar roundProgressBar, @androidx.annotation.NonNull android.widget.TextView textView2, @androidx.annotation.NonNull com.moji.mjweather.assshop.view.TopRightTextView topRightTextView, @androidx.annotation.NonNull android.widget.TextView textView3) {
        this.n = linearLayout;
        this.itemDeleteButton = textView;
        this.ivAvsIcon = roundCornerImageView;
        this.ivDeleteHandle = imageView;
        this.ivVoiceTrial = avatarItemVoiceView;
        this.llAvatarDownlad = frameLayout;
        this.rlDeleteBotom = relativeLayout;
        this.rpbRoundProgress = roundProgressBar;
        this.tvAvatarDownload = textView2;
        this.tvAvatarName = topRightTextView;
        this.tvAvatarUseNum = textView3;
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.ItemAvatarShopSetBinding bind(@androidx.annotation.NonNull android.view.View view) {
        com.moji.imageview.RoundCornerImageView findChildViewById;
        com.moji.mjweather.assshop.view.AvatarItemVoiceView findChildViewById2;
        com.moji.mjweather.assshop.view.RoundProgressBar findChildViewById3;
        com.moji.mjweather.assshop.view.TopRightTextView findChildViewById4;
        int i = moji.com.mjweather.R.id.item_delete_button;
        android.widget.TextView textView = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (textView != null && (findChildViewById = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.iv_avs_icon))) != null) {
            i = moji.com.mjweather.R.id.iv_delete_handle;
            android.widget.ImageView imageView = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
            if (imageView != null && (findChildViewById2 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.iv_voice_trial))) != null) {
                i = moji.com.mjweather.R.id.ll_avatar_downlad;
                android.widget.FrameLayout frameLayout = (android.widget.FrameLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                if (frameLayout != null) {
                    i = moji.com.mjweather.R.id.rl_delete_botom;
                    android.widget.RelativeLayout relativeLayout = (android.widget.RelativeLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                    if (relativeLayout != null && (findChildViewById3 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.rpb_round_progress))) != null) {
                        i = moji.com.mjweather.R.id.tv_avatar_download;
                        android.widget.TextView textView2 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                        if (textView2 != null && (findChildViewById4 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.tv_avatar_name))) != null) {
                            i = moji.com.mjweather.R.id.tv_avatar_use_num;
                            android.widget.TextView textView3 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                            if (textView3 != null) {
                                return new moji.com.mjweather.databinding.ItemAvatarShopSetBinding((android.widget.LinearLayout) view, textView, findChildViewById, imageView, findChildViewById2, frameLayout, relativeLayout, findChildViewById3, textView2, findChildViewById4, textView3);
                            }
                        }
                    }
                }
            }
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.ItemAvatarShopSetBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.ItemAvatarShopSetBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(moji.com.mjweather.R.layout.item_avatar_shop_set, viewGroup, false);
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
