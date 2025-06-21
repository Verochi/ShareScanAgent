package moji.com.mjweather.databinding;

/* loaded from: classes20.dex */
public final class ItemVoiceShopSetBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final com.moji.imageview.RoundCornerImageView ivAvsIcon;

    @androidx.annotation.NonNull
    public final android.widget.LinearLayout n;

    @androidx.annotation.NonNull
    public final com.moji.mjweather.assshop.view.TopRightTextView tvVoiceName;

    @androidx.annotation.NonNull
    public final android.widget.TextView tvVoiceStatus;

    public ItemVoiceShopSetBinding(@androidx.annotation.NonNull android.widget.LinearLayout linearLayout, @androidx.annotation.NonNull com.moji.imageview.RoundCornerImageView roundCornerImageView, @androidx.annotation.NonNull com.moji.mjweather.assshop.view.TopRightTextView topRightTextView, @androidx.annotation.NonNull android.widget.TextView textView) {
        this.n = linearLayout;
        this.ivAvsIcon = roundCornerImageView;
        this.tvVoiceName = topRightTextView;
        this.tvVoiceStatus = textView;
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.ItemVoiceShopSetBinding bind(@androidx.annotation.NonNull android.view.View view) {
        com.moji.mjweather.assshop.view.TopRightTextView findChildViewById;
        int i = moji.com.mjweather.R.id.iv_avs_icon;
        com.moji.imageview.RoundCornerImageView findChildViewById2 = androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (findChildViewById2 != null && (findChildViewById = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.tv_voice_name))) != null) {
            i = moji.com.mjweather.R.id.tv_voice_status;
            android.widget.TextView textView = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                return new moji.com.mjweather.databinding.ItemVoiceShopSetBinding((android.widget.LinearLayout) view, findChildViewById2, findChildViewById, textView);
            }
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.ItemVoiceShopSetBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.ItemVoiceShopSetBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(moji.com.mjweather.R.layout.item_voice_shop_set, viewGroup, false);
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
