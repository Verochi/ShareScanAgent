package com.aliyun.svideo.crop.databinding;

/* loaded from: classes.dex */
public final class AlivcCropIncludeActionBarBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final android.widget.TextView aliyunActionbarTitle;

    @androidx.annotation.NonNull
    public final android.widget.ImageView aliyunBack;

    @androidx.annotation.NonNull
    private final android.widget.FrameLayout rootView;

    private AlivcCropIncludeActionBarBinding(@androidx.annotation.NonNull android.widget.FrameLayout frameLayout, @androidx.annotation.NonNull android.widget.TextView textView, @androidx.annotation.NonNull android.widget.ImageView imageView) {
        this.rootView = frameLayout;
        this.aliyunActionbarTitle = textView;
        this.aliyunBack = imageView;
    }

    @androidx.annotation.NonNull
    public static com.aliyun.svideo.crop.databinding.AlivcCropIncludeActionBarBinding bind(@androidx.annotation.NonNull android.view.View view) {
        int i = com.aliyun.svideo.crop.R.id.aliyun_actionbar_title;
        android.widget.TextView textView = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = com.aliyun.svideo.crop.R.id.aliyun_back;
            android.widget.ImageView imageView = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
            if (imageView != null) {
                return new com.aliyun.svideo.crop.databinding.AlivcCropIncludeActionBarBinding((android.widget.FrameLayout) view, textView, imageView);
            }
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @androidx.annotation.NonNull
    public static com.aliyun.svideo.crop.databinding.AlivcCropIncludeActionBarBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static com.aliyun.svideo.crop.databinding.AlivcCropIncludeActionBarBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(com.aliyun.svideo.crop.R.layout.alivc_crop_include_action_bar, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @androidx.annotation.NonNull
    public android.widget.FrameLayout getRoot() {
        return this.rootView;
    }
}
