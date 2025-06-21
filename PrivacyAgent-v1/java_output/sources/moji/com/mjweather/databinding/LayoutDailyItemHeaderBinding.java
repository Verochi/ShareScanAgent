package moji.com.mjweather.databinding;

/* loaded from: classes20.dex */
public final class LayoutDailyItemHeaderBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final com.moji.imageview.MJImageView ivNext;

    @androidx.annotation.NonNull
    public final android.widget.FrameLayout n;

    @androidx.annotation.NonNull
    public final com.moji.textview.MJTextView tvTitle;

    public LayoutDailyItemHeaderBinding(@androidx.annotation.NonNull android.widget.FrameLayout frameLayout, @androidx.annotation.NonNull com.moji.imageview.MJImageView mJImageView, @androidx.annotation.NonNull com.moji.textview.MJTextView mJTextView) {
        this.n = frameLayout;
        this.ivNext = mJImageView;
        this.tvTitle = mJTextView;
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.LayoutDailyItemHeaderBinding bind(@androidx.annotation.NonNull android.view.View view) {
        com.moji.textview.MJTextView findChildViewById;
        int i = moji.com.mjweather.R.id.iv_next;
        com.moji.imageview.MJImageView findChildViewById2 = androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (findChildViewById2 == null || (findChildViewById = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.tv_title))) == null) {
            throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }
        return new moji.com.mjweather.databinding.LayoutDailyItemHeaderBinding((android.widget.FrameLayout) view, findChildViewById2, findChildViewById);
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.LayoutDailyItemHeaderBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.LayoutDailyItemHeaderBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(moji.com.mjweather.R.layout.layout_daily_item_header, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @androidx.annotation.NonNull
    public android.widget.FrameLayout getRoot() {
        return this.n;
    }
}
