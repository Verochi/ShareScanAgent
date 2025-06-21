package moji.com.mjweather.databinding;

/* loaded from: classes20.dex */
public final class ViewWidgetFoldtextviewBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final android.widget.ImageView ivFold;

    @androidx.annotation.NonNull
    public final android.widget.LinearLayout llFold;

    @androidx.annotation.NonNull
    public final android.widget.LinearLayout n;

    @androidx.annotation.NonNull
    public final android.widget.TextView tvFold;

    public ViewWidgetFoldtextviewBinding(@androidx.annotation.NonNull android.widget.LinearLayout linearLayout, @androidx.annotation.NonNull android.widget.ImageView imageView, @androidx.annotation.NonNull android.widget.LinearLayout linearLayout2, @androidx.annotation.NonNull android.widget.TextView textView) {
        this.n = linearLayout;
        this.ivFold = imageView;
        this.llFold = linearLayout2;
        this.tvFold = textView;
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.ViewWidgetFoldtextviewBinding bind(@androidx.annotation.NonNull android.view.View view) {
        int i = moji.com.mjweather.R.id.ivFold;
        android.widget.ImageView imageView = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = moji.com.mjweather.R.id.llFold;
            android.widget.LinearLayout linearLayout = (android.widget.LinearLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
            if (linearLayout != null) {
                i = moji.com.mjweather.R.id.tvFold;
                android.widget.TextView textView = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                if (textView != null) {
                    return new moji.com.mjweather.databinding.ViewWidgetFoldtextviewBinding((android.widget.LinearLayout) view, imageView, linearLayout, textView);
                }
            }
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.ViewWidgetFoldtextviewBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.ViewWidgetFoldtextviewBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(moji.com.mjweather.R.layout.view_widget_foldtextview, viewGroup, false);
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
