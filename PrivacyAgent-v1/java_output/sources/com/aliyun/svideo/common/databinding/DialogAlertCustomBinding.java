package com.aliyun.svideo.common.databinding;

/* loaded from: classes.dex */
public final class DialogAlertCustomBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final android.widget.LinearLayout contentWrap;

    @androidx.annotation.NonNull
    public final android.widget.ImageView ivDialogIcon;

    @androidx.annotation.NonNull
    private final android.view.View rootView;

    @androidx.annotation.NonNull
    public final android.widget.TextView tvCancel;

    @androidx.annotation.NonNull
    public final android.widget.TextView tvConfirm;

    @androidx.annotation.NonNull
    public final android.widget.TextView tvDialogMessage;

    private DialogAlertCustomBinding(@androidx.annotation.NonNull android.view.View view, @androidx.annotation.NonNull android.widget.LinearLayout linearLayout, @androidx.annotation.NonNull android.widget.ImageView imageView, @androidx.annotation.NonNull android.widget.TextView textView, @androidx.annotation.NonNull android.widget.TextView textView2, @androidx.annotation.NonNull android.widget.TextView textView3) {
        this.rootView = view;
        this.contentWrap = linearLayout;
        this.ivDialogIcon = imageView;
        this.tvCancel = textView;
        this.tvConfirm = textView2;
        this.tvDialogMessage = textView3;
    }

    @androidx.annotation.NonNull
    public static com.aliyun.svideo.common.databinding.DialogAlertCustomBinding bind(@androidx.annotation.NonNull android.view.View view) {
        int i = com.aliyun.svideo.common.R.id.contentWrap;
        android.widget.LinearLayout linearLayout = (android.widget.LinearLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (linearLayout != null) {
            i = com.aliyun.svideo.common.R.id.iv_dialog_icon;
            android.widget.ImageView imageView = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
            if (imageView != null) {
                i = com.aliyun.svideo.common.R.id.tv_cancel;
                android.widget.TextView textView = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                if (textView != null) {
                    i = com.aliyun.svideo.common.R.id.tv_confirm;
                    android.widget.TextView textView2 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                    if (textView2 != null) {
                        i = com.aliyun.svideo.common.R.id.tv_dialog_message;
                        android.widget.TextView textView3 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                        if (textView3 != null) {
                            return new com.aliyun.svideo.common.databinding.DialogAlertCustomBinding(view, linearLayout, imageView, textView, textView2, textView3);
                        }
                    }
                }
            }
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @androidx.annotation.NonNull
    public static com.aliyun.svideo.common.databinding.DialogAlertCustomBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.NonNull android.view.ViewGroup viewGroup) {
        if (viewGroup == null) {
            throw new java.lang.NullPointerException("parent");
        }
        layoutInflater.inflate(com.aliyun.svideo.common.R.layout.dialog_alert_custom, viewGroup);
        return bind(viewGroup);
    }

    @Override // androidx.viewbinding.ViewBinding
    @androidx.annotation.NonNull
    public android.view.View getRoot() {
        return this.rootView;
    }
}
