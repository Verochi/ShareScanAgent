package moji.com.mjweather.databinding;

/* loaded from: classes20.dex */
public final class RvHeaderChannelSettingBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final android.widget.FrameLayout flEnterMjInfo;

    @androidx.annotation.NonNull
    public final android.widget.ImageView ivValue;

    @androidx.annotation.NonNull
    public final android.widget.LinearLayout n;

    @androidx.annotation.NonNull
    public final android.widget.TextView tvTitle;

    @androidx.annotation.NonNull
    public final android.view.View viewBottomLine;

    public RvHeaderChannelSettingBinding(@androidx.annotation.NonNull android.widget.LinearLayout linearLayout, @androidx.annotation.NonNull android.widget.FrameLayout frameLayout, @androidx.annotation.NonNull android.widget.ImageView imageView, @androidx.annotation.NonNull android.widget.TextView textView, @androidx.annotation.NonNull android.view.View view) {
        this.n = linearLayout;
        this.flEnterMjInfo = frameLayout;
        this.ivValue = imageView;
        this.tvTitle = textView;
        this.viewBottomLine = view;
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.RvHeaderChannelSettingBinding bind(@androidx.annotation.NonNull android.view.View view) {
        android.view.View findChildViewById;
        int i = moji.com.mjweather.R.id.fl_enter_mj_info;
        android.widget.FrameLayout frameLayout = (android.widget.FrameLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (frameLayout != null) {
            i = moji.com.mjweather.R.id.iv_value;
            android.widget.ImageView imageView = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
            if (imageView != null) {
                i = moji.com.mjweather.R.id.tv_title;
                android.widget.TextView textView = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                if (textView != null && (findChildViewById = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.view_bottom_line))) != null) {
                    return new moji.com.mjweather.databinding.RvHeaderChannelSettingBinding((android.widget.LinearLayout) view, frameLayout, imageView, textView, findChildViewById);
                }
            }
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.RvHeaderChannelSettingBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.RvHeaderChannelSettingBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(moji.com.mjweather.R.layout.rv_header_channel_setting, viewGroup, false);
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
