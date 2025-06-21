package moji.com.mjweather.databinding;

/* loaded from: classes20.dex */
public final class MsgDialogMenuBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final android.widget.ImageView ivMsgCheck;

    @androidx.annotation.NonNull
    public final android.widget.ImageView ivMsgDelete;

    @androidx.annotation.NonNull
    public final android.widget.ImageView ivMsgReply;

    @androidx.annotation.NonNull
    public final android.widget.LinearLayout n;

    @androidx.annotation.NonNull
    public final android.widget.TextView tvMsgCheck;

    @androidx.annotation.NonNull
    public final android.widget.TextView tvMsgDelete;

    @androidx.annotation.NonNull
    public final android.widget.TextView tvMsgReply;

    @androidx.annotation.NonNull
    public final android.widget.TextView tvMsgReport;

    public MsgDialogMenuBinding(@androidx.annotation.NonNull android.widget.LinearLayout linearLayout, @androidx.annotation.NonNull android.widget.ImageView imageView, @androidx.annotation.NonNull android.widget.ImageView imageView2, @androidx.annotation.NonNull android.widget.ImageView imageView3, @androidx.annotation.NonNull android.widget.TextView textView, @androidx.annotation.NonNull android.widget.TextView textView2, @androidx.annotation.NonNull android.widget.TextView textView3, @androidx.annotation.NonNull android.widget.TextView textView4) {
        this.n = linearLayout;
        this.ivMsgCheck = imageView;
        this.ivMsgDelete = imageView2;
        this.ivMsgReply = imageView3;
        this.tvMsgCheck = textView;
        this.tvMsgDelete = textView2;
        this.tvMsgReply = textView3;
        this.tvMsgReport = textView4;
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.MsgDialogMenuBinding bind(@androidx.annotation.NonNull android.view.View view) {
        int i = moji.com.mjweather.R.id.iv_msg_check;
        android.widget.ImageView imageView = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = moji.com.mjweather.R.id.iv_msg_delete;
            android.widget.ImageView imageView2 = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
            if (imageView2 != null) {
                i = moji.com.mjweather.R.id.iv_msg_reply;
                android.widget.ImageView imageView3 = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                if (imageView3 != null) {
                    i = moji.com.mjweather.R.id.tv_msg_check;
                    android.widget.TextView textView = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                    if (textView != null) {
                        i = moji.com.mjweather.R.id.tv_msg_delete;
                        android.widget.TextView textView2 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                        if (textView2 != null) {
                            i = moji.com.mjweather.R.id.tv_msg_reply;
                            android.widget.TextView textView3 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                            if (textView3 != null) {
                                i = moji.com.mjweather.R.id.tv_msg_report;
                                android.widget.TextView textView4 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                if (textView4 != null) {
                                    return new moji.com.mjweather.databinding.MsgDialogMenuBinding((android.widget.LinearLayout) view, imageView, imageView2, imageView3, textView, textView2, textView3, textView4);
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
    public static moji.com.mjweather.databinding.MsgDialogMenuBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.MsgDialogMenuBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(moji.com.mjweather.R.layout.msg_dialog_menu, viewGroup, false);
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
