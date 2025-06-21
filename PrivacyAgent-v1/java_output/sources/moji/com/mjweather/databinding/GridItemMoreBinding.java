package moji.com.mjweather.databinding;

/* loaded from: classes20.dex */
public final class GridItemMoreBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final android.widget.FrameLayout itemMore;

    @androidx.annotation.NonNull
    public final android.widget.ImageView mTitleRoot;

    @androidx.annotation.NonNull
    public final android.widget.FrameLayout n;

    @androidx.annotation.NonNull
    public final com.moji.textview.MJTextView tvText;

    public GridItemMoreBinding(@androidx.annotation.NonNull android.widget.FrameLayout frameLayout, @androidx.annotation.NonNull android.widget.FrameLayout frameLayout2, @androidx.annotation.NonNull android.widget.ImageView imageView, @androidx.annotation.NonNull com.moji.textview.MJTextView mJTextView) {
        this.n = frameLayout;
        this.itemMore = frameLayout2;
        this.mTitleRoot = imageView;
        this.tvText = mJTextView;
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.GridItemMoreBinding bind(@androidx.annotation.NonNull android.view.View view) {
        com.moji.textview.MJTextView findChildViewById;
        android.widget.FrameLayout frameLayout = (android.widget.FrameLayout) view;
        int i = moji.com.mjweather.R.id.mTitleRoot;
        android.widget.ImageView imageView = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (imageView == null || (findChildViewById = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.tv_text))) == null) {
            throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }
        return new moji.com.mjweather.databinding.GridItemMoreBinding(frameLayout, frameLayout, imageView, findChildViewById);
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.GridItemMoreBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.GridItemMoreBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(moji.com.mjweather.R.layout.grid_item_more, viewGroup, false);
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
