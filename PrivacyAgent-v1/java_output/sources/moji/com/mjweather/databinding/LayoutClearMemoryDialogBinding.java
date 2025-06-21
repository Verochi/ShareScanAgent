package moji.com.mjweather.databinding;

/* loaded from: classes20.dex */
public final class LayoutClearMemoryDialogBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final android.widget.TextView btnClearCancle;

    @androidx.annotation.NonNull
    public final android.widget.TextView btnClearClear;

    @androidx.annotation.NonNull
    public final android.widget.ImageView ivDivider;

    @androidx.annotation.NonNull
    public final android.widget.ImageView ivIconBackground;

    @androidx.annotation.NonNull
    public final android.widget.ImageView ivIconCircle;

    @androidx.annotation.NonNull
    public final android.widget.LinearLayout llDialogTop;

    @androidx.annotation.NonNull
    public final android.widget.RelativeLayout n;

    @androidx.annotation.NonNull
    public final android.widget.TextView tvDescribe;

    @androidx.annotation.NonNull
    public final android.widget.TextView tvIconMemoryPercent;

    @androidx.annotation.NonNull
    public final android.widget.TextView tvTitle;

    public LayoutClearMemoryDialogBinding(@androidx.annotation.NonNull android.widget.RelativeLayout relativeLayout, @androidx.annotation.NonNull android.widget.TextView textView, @androidx.annotation.NonNull android.widget.TextView textView2, @androidx.annotation.NonNull android.widget.ImageView imageView, @androidx.annotation.NonNull android.widget.ImageView imageView2, @androidx.annotation.NonNull android.widget.ImageView imageView3, @androidx.annotation.NonNull android.widget.LinearLayout linearLayout, @androidx.annotation.NonNull android.widget.TextView textView3, @androidx.annotation.NonNull android.widget.TextView textView4, @androidx.annotation.NonNull android.widget.TextView textView5) {
        this.n = relativeLayout;
        this.btnClearCancle = textView;
        this.btnClearClear = textView2;
        this.ivDivider = imageView;
        this.ivIconBackground = imageView2;
        this.ivIconCircle = imageView3;
        this.llDialogTop = linearLayout;
        this.tvDescribe = textView3;
        this.tvIconMemoryPercent = textView4;
        this.tvTitle = textView5;
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.LayoutClearMemoryDialogBinding bind(@androidx.annotation.NonNull android.view.View view) {
        int i = moji.com.mjweather.R.id.btn_clear_cancle;
        android.widget.TextView textView = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = moji.com.mjweather.R.id.btn_clear_clear;
            android.widget.TextView textView2 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
            if (textView2 != null) {
                i = moji.com.mjweather.R.id.iv_divider;
                android.widget.ImageView imageView = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                if (imageView != null) {
                    i = moji.com.mjweather.R.id.iv_icon_background;
                    android.widget.ImageView imageView2 = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                    if (imageView2 != null) {
                        i = moji.com.mjweather.R.id.iv_icon_circle;
                        android.widget.ImageView imageView3 = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                        if (imageView3 != null) {
                            i = moji.com.mjweather.R.id.ll_dialog_top;
                            android.widget.LinearLayout linearLayout = (android.widget.LinearLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                            if (linearLayout != null) {
                                i = moji.com.mjweather.R.id.tv_describe;
                                android.widget.TextView textView3 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                if (textView3 != null) {
                                    i = moji.com.mjweather.R.id.tv_icon_memory_percent;
                                    android.widget.TextView textView4 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                    if (textView4 != null) {
                                        i = moji.com.mjweather.R.id.tv_title;
                                        android.widget.TextView textView5 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                        if (textView5 != null) {
                                            return new moji.com.mjweather.databinding.LayoutClearMemoryDialogBinding((android.widget.RelativeLayout) view, textView, textView2, imageView, imageView2, imageView3, linearLayout, textView3, textView4, textView5);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.LayoutClearMemoryDialogBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.LayoutClearMemoryDialogBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(moji.com.mjweather.R.layout.layout_clear_memory_dialog, viewGroup, false);
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
