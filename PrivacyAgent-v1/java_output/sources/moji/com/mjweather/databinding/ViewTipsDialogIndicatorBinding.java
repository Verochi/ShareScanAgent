package moji.com.mjweather.databinding;

/* loaded from: classes20.dex */
public final class ViewTipsDialogIndicatorBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final android.widget.ImageView ivItem0;

    @androidx.annotation.NonNull
    public final android.widget.ImageView ivItem1;

    @androidx.annotation.NonNull
    public final android.widget.ImageView ivItem2;

    @androidx.annotation.NonNull
    public final android.widget.LinearLayout n;

    public ViewTipsDialogIndicatorBinding(@androidx.annotation.NonNull android.widget.LinearLayout linearLayout, @androidx.annotation.NonNull android.widget.ImageView imageView, @androidx.annotation.NonNull android.widget.ImageView imageView2, @androidx.annotation.NonNull android.widget.ImageView imageView3) {
        this.n = linearLayout;
        this.ivItem0 = imageView;
        this.ivItem1 = imageView2;
        this.ivItem2 = imageView3;
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.ViewTipsDialogIndicatorBinding bind(@androidx.annotation.NonNull android.view.View view) {
        int i = moji.com.mjweather.R.id.ivItem0;
        android.widget.ImageView imageView = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = moji.com.mjweather.R.id.ivItem1;
            android.widget.ImageView imageView2 = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
            if (imageView2 != null) {
                i = moji.com.mjweather.R.id.ivItem2;
                android.widget.ImageView imageView3 = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                if (imageView3 != null) {
                    return new moji.com.mjweather.databinding.ViewTipsDialogIndicatorBinding((android.widget.LinearLayout) view, imageView, imageView2, imageView3);
                }
            }
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.ViewTipsDialogIndicatorBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.ViewTipsDialogIndicatorBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(moji.com.mjweather.R.layout.view_tips_dialog_indicator, viewGroup, false);
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
