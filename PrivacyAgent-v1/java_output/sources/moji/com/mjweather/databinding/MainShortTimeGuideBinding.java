package moji.com.mjweather.databinding;

/* loaded from: classes20.dex */
public final class MainShortTimeGuideBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final android.widget.ImageView ivGuideRight;

    @androidx.annotation.NonNull
    public final android.widget.ImageView ivGuideTop;

    @androidx.annotation.NonNull
    public final android.view.View n;

    @androidx.annotation.NonNull
    public final android.widget.TextView tvGuideBottom;

    public MainShortTimeGuideBinding(@androidx.annotation.NonNull android.view.View view, @androidx.annotation.NonNull android.widget.ImageView imageView, @androidx.annotation.NonNull android.widget.ImageView imageView2, @androidx.annotation.NonNull android.widget.TextView textView) {
        this.n = view;
        this.ivGuideRight = imageView;
        this.ivGuideTop = imageView2;
        this.tvGuideBottom = textView;
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.MainShortTimeGuideBinding bind(@androidx.annotation.NonNull android.view.View view) {
        int i = moji.com.mjweather.R.id.iv_guide_right;
        android.widget.ImageView imageView = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = moji.com.mjweather.R.id.iv_guide_top;
            android.widget.ImageView imageView2 = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
            if (imageView2 != null) {
                i = moji.com.mjweather.R.id.tv_guide_bottom;
                android.widget.TextView textView = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                if (textView != null) {
                    return new moji.com.mjweather.databinding.MainShortTimeGuideBinding(view, imageView, imageView2, textView);
                }
            }
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.MainShortTimeGuideBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.NonNull android.view.ViewGroup viewGroup) {
        if (viewGroup == null) {
            throw new java.lang.NullPointerException("parent");
        }
        layoutInflater.inflate(moji.com.mjweather.R.layout.main_short_time_guide, viewGroup);
        return bind(viewGroup);
    }

    @Override // androidx.viewbinding.ViewBinding
    @androidx.annotation.NonNull
    public android.view.View getRoot() {
        return this.n;
    }
}
