package moji.com.mjweather.databinding;

/* loaded from: classes20.dex */
public final class TitleBarBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final android.widget.ImageView ivShare;

    @androidx.annotation.NonNull
    public final android.widget.ImageView ivTitleBack;

    @androidx.annotation.NonNull
    public final com.mojiweather.area.view.TitleBarLayout n;

    @androidx.annotation.NonNull
    public final android.widget.RelativeLayout rlTitleBack;

    @androidx.annotation.NonNull
    public final com.mojiweather.area.view.TitleBarLayout rlTitleBar;

    @androidx.annotation.NonNull
    public final android.widget.TextView tvTitleName;

    public TitleBarBinding(@androidx.annotation.NonNull com.mojiweather.area.view.TitleBarLayout titleBarLayout, @androidx.annotation.NonNull android.widget.ImageView imageView, @androidx.annotation.NonNull android.widget.ImageView imageView2, @androidx.annotation.NonNull android.widget.RelativeLayout relativeLayout, @androidx.annotation.NonNull com.mojiweather.area.view.TitleBarLayout titleBarLayout2, @androidx.annotation.NonNull android.widget.TextView textView) {
        this.n = titleBarLayout;
        this.ivShare = imageView;
        this.ivTitleBack = imageView2;
        this.rlTitleBack = relativeLayout;
        this.rlTitleBar = titleBarLayout2;
        this.tvTitleName = textView;
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.TitleBarBinding bind(@androidx.annotation.NonNull android.view.View view) {
        int i = moji.com.mjweather.R.id.iv_share;
        android.widget.ImageView imageView = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = moji.com.mjweather.R.id.iv_title_back;
            android.widget.ImageView imageView2 = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
            if (imageView2 != null) {
                i = moji.com.mjweather.R.id.rl_title_back;
                android.widget.RelativeLayout relativeLayout = (android.widget.RelativeLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                if (relativeLayout != null) {
                    com.mojiweather.area.view.TitleBarLayout titleBarLayout = (com.mojiweather.area.view.TitleBarLayout) view;
                    i = moji.com.mjweather.R.id.tv_title_name;
                    android.widget.TextView textView = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                    if (textView != null) {
                        return new moji.com.mjweather.databinding.TitleBarBinding(titleBarLayout, imageView, imageView2, relativeLayout, titleBarLayout, textView);
                    }
                }
            }
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.TitleBarBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.TitleBarBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(moji.com.mjweather.R.layout.title_bar, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @androidx.annotation.NonNull
    public com.mojiweather.area.view.TitleBarLayout getRoot() {
        return this.n;
    }
}
