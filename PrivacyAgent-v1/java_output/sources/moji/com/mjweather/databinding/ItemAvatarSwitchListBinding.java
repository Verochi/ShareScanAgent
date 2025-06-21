package moji.com.mjweather.databinding;

/* loaded from: classes20.dex */
public final class ItemAvatarSwitchListBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final com.moji.imageview.RoundCornerImageView ivAvatar;

    @androidx.annotation.NonNull
    public final android.widget.ImageView ivChoiced;

    @androidx.annotation.NonNull
    public final android.widget.ImageView ivNew;

    @androidx.annotation.NonNull
    public final android.widget.LinearLayout n;

    @androidx.annotation.NonNull
    public final com.moji.circleprogress.SectorProgressView spvRoundProgress;

    @androidx.annotation.NonNull
    public final android.widget.TextView tvAvatarName;

    public ItemAvatarSwitchListBinding(@androidx.annotation.NonNull android.widget.LinearLayout linearLayout, @androidx.annotation.NonNull com.moji.imageview.RoundCornerImageView roundCornerImageView, @androidx.annotation.NonNull android.widget.ImageView imageView, @androidx.annotation.NonNull android.widget.ImageView imageView2, @androidx.annotation.NonNull com.moji.circleprogress.SectorProgressView sectorProgressView, @androidx.annotation.NonNull android.widget.TextView textView) {
        this.n = linearLayout;
        this.ivAvatar = roundCornerImageView;
        this.ivChoiced = imageView;
        this.ivNew = imageView2;
        this.spvRoundProgress = sectorProgressView;
        this.tvAvatarName = textView;
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.ItemAvatarSwitchListBinding bind(@androidx.annotation.NonNull android.view.View view) {
        com.moji.circleprogress.SectorProgressView findChildViewById;
        int i = moji.com.mjweather.R.id.iv_avatar;
        com.moji.imageview.RoundCornerImageView findChildViewById2 = androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (findChildViewById2 != null) {
            i = moji.com.mjweather.R.id.iv_choiced;
            android.widget.ImageView imageView = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
            if (imageView != null) {
                i = moji.com.mjweather.R.id.iv_new;
                android.widget.ImageView imageView2 = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                if (imageView2 != null && (findChildViewById = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.spv_round_progress))) != null) {
                    i = moji.com.mjweather.R.id.tv_avatar_name;
                    android.widget.TextView textView = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                    if (textView != null) {
                        return new moji.com.mjweather.databinding.ItemAvatarSwitchListBinding((android.widget.LinearLayout) view, findChildViewById2, imageView, imageView2, findChildViewById, textView);
                    }
                }
            }
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.ItemAvatarSwitchListBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.ItemAvatarSwitchListBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(moji.com.mjweather.R.layout.item_avatar_switch_list, viewGroup, false);
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
