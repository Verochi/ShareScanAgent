package moji.com.mjweather.databinding;

/* loaded from: classes20.dex */
public final class ItemDailyDetailStargazingBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final com.moji.imageview.MJImageView ivNext;

    @androidx.annotation.NonNull
    public final android.widget.RelativeLayout n;

    @androidx.annotation.NonNull
    public final com.moji.textview.MJTextView tvContent;

    public ItemDailyDetailStargazingBinding(@androidx.annotation.NonNull android.widget.RelativeLayout relativeLayout, @androidx.annotation.NonNull com.moji.imageview.MJImageView mJImageView, @androidx.annotation.NonNull com.moji.textview.MJTextView mJTextView) {
        this.n = relativeLayout;
        this.ivNext = mJImageView;
        this.tvContent = mJTextView;
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.ItemDailyDetailStargazingBinding bind(@androidx.annotation.NonNull android.view.View view) {
        com.moji.textview.MJTextView findChildViewById;
        int i = moji.com.mjweather.R.id.iv_next;
        com.moji.imageview.MJImageView findChildViewById2 = androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (findChildViewById2 == null || (findChildViewById = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.tv_content))) == null) {
            throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }
        return new moji.com.mjweather.databinding.ItemDailyDetailStargazingBinding((android.widget.RelativeLayout) view, findChildViewById2, findChildViewById);
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.ItemDailyDetailStargazingBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.ItemDailyDetailStargazingBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(moji.com.mjweather.R.layout.item_daily_detail_stargazing, viewGroup, false);
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
