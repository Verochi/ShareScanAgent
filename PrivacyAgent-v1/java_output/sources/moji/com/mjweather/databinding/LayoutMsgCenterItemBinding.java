package moji.com.mjweather.databinding;

/* loaded from: classes20.dex */
public final class LayoutMsgCenterItemBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final android.widget.ImageView ivMsgBottomLine;

    @androidx.annotation.NonNull
    public final android.widget.ImageView ivMsgIcon;

    @androidx.annotation.NonNull
    public final android.widget.ImageView ivMsgTopLine;

    @androidx.annotation.NonNull
    public final android.widget.LinearLayout n;

    @androidx.annotation.NonNull
    public final android.widget.RelativeLayout rlMessage;

    @androidx.annotation.NonNull
    public final android.widget.TextView tvMsgContent;

    @androidx.annotation.NonNull
    public final android.widget.TextView tvMsgTitle;

    public LayoutMsgCenterItemBinding(@androidx.annotation.NonNull android.widget.LinearLayout linearLayout, @androidx.annotation.NonNull android.widget.ImageView imageView, @androidx.annotation.NonNull android.widget.ImageView imageView2, @androidx.annotation.NonNull android.widget.ImageView imageView3, @androidx.annotation.NonNull android.widget.RelativeLayout relativeLayout, @androidx.annotation.NonNull android.widget.TextView textView, @androidx.annotation.NonNull android.widget.TextView textView2) {
        this.n = linearLayout;
        this.ivMsgBottomLine = imageView;
        this.ivMsgIcon = imageView2;
        this.ivMsgTopLine = imageView3;
        this.rlMessage = relativeLayout;
        this.tvMsgContent = textView;
        this.tvMsgTitle = textView2;
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.LayoutMsgCenterItemBinding bind(@androidx.annotation.NonNull android.view.View view) {
        int i = moji.com.mjweather.R.id.iv_msg_bottom_line;
        android.widget.ImageView imageView = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = moji.com.mjweather.R.id.iv_msg_icon;
            android.widget.ImageView imageView2 = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
            if (imageView2 != null) {
                i = moji.com.mjweather.R.id.iv_msg_top_line;
                android.widget.ImageView imageView3 = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                if (imageView3 != null) {
                    i = moji.com.mjweather.R.id.rl_message;
                    android.widget.RelativeLayout relativeLayout = (android.widget.RelativeLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                    if (relativeLayout != null) {
                        i = moji.com.mjweather.R.id.tv_msg_content;
                        android.widget.TextView textView = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                        if (textView != null) {
                            i = moji.com.mjweather.R.id.tv_msg_title;
                            android.widget.TextView textView2 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                            if (textView2 != null) {
                                return new moji.com.mjweather.databinding.LayoutMsgCenterItemBinding((android.widget.LinearLayout) view, imageView, imageView2, imageView3, relativeLayout, textView, textView2);
                            }
                        }
                    }
                }
            }
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.LayoutMsgCenterItemBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.LayoutMsgCenterItemBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(moji.com.mjweather.R.layout.layout_msg_center_item, viewGroup, false);
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
