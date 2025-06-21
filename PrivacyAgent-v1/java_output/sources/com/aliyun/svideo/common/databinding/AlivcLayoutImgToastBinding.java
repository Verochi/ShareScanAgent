package com.aliyun.svideo.common.databinding;

/* loaded from: classes.dex */
public final class AlivcLayoutImgToastBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final android.widget.TextView content;

    @androidx.annotation.NonNull
    private final android.widget.LinearLayout rootView;

    @androidx.annotation.NonNull
    public final android.widget.ImageView toastImage;

    private AlivcLayoutImgToastBinding(@androidx.annotation.NonNull android.widget.LinearLayout linearLayout, @androidx.annotation.NonNull android.widget.TextView textView, @androidx.annotation.NonNull android.widget.ImageView imageView) {
        this.rootView = linearLayout;
        this.content = textView;
        this.toastImage = imageView;
    }

    @androidx.annotation.NonNull
    public static com.aliyun.svideo.common.databinding.AlivcLayoutImgToastBinding bind(@androidx.annotation.NonNull android.view.View view) {
        int i = com.aliyun.svideo.common.R.id.content;
        android.widget.TextView textView = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = com.aliyun.svideo.common.R.id.toast_image;
            android.widget.ImageView imageView = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
            if (imageView != null) {
                return new com.aliyun.svideo.common.databinding.AlivcLayoutImgToastBinding((android.widget.LinearLayout) view, textView, imageView);
            }
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @androidx.annotation.NonNull
    public static com.aliyun.svideo.common.databinding.AlivcLayoutImgToastBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static com.aliyun.svideo.common.databinding.AlivcLayoutImgToastBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(com.aliyun.svideo.common.R.layout.alivc_layout_img_toast, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @androidx.annotation.NonNull
    public android.widget.LinearLayout getRoot() {
        return this.rootView;
    }
}
