package com.aliyun.svideo.editor.databinding;

/* loaded from: classes12.dex */
public final class AlivcEditorIncludeEffectTitleBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final android.widget.ImageView cancel;

    @androidx.annotation.NonNull
    public final android.widget.ImageView complete;

    @androidx.annotation.NonNull
    public final android.widget.ImageView ivEffectIcon;

    @androidx.annotation.NonNull
    private final android.view.View rootView;

    @androidx.annotation.NonNull
    public final android.widget.TextView tvEffectTitle;

    private AlivcEditorIncludeEffectTitleBinding(@androidx.annotation.NonNull android.view.View view, @androidx.annotation.NonNull android.widget.ImageView imageView, @androidx.annotation.NonNull android.widget.ImageView imageView2, @androidx.annotation.NonNull android.widget.ImageView imageView3, @androidx.annotation.NonNull android.widget.TextView textView) {
        this.rootView = view;
        this.cancel = imageView;
        this.complete = imageView2;
        this.ivEffectIcon = imageView3;
        this.tvEffectTitle = textView;
    }

    @androidx.annotation.NonNull
    public static com.aliyun.svideo.editor.databinding.AlivcEditorIncludeEffectTitleBinding bind(@androidx.annotation.NonNull android.view.View view) {
        int i = com.aliyun.svideo.editor.R.id.cancel;
        android.widget.ImageView imageView = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = com.aliyun.svideo.editor.R.id.complete;
            android.widget.ImageView imageView2 = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
            if (imageView2 != null) {
                i = com.aliyun.svideo.editor.R.id.iv_effect_icon;
                android.widget.ImageView imageView3 = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                if (imageView3 != null) {
                    i = com.aliyun.svideo.editor.R.id.tv_effect_title;
                    android.widget.TextView textView = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                    if (textView != null) {
                        return new com.aliyun.svideo.editor.databinding.AlivcEditorIncludeEffectTitleBinding(view, imageView, imageView2, imageView3, textView);
                    }
                }
            }
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @androidx.annotation.NonNull
    public static com.aliyun.svideo.editor.databinding.AlivcEditorIncludeEffectTitleBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.NonNull android.view.ViewGroup viewGroup) {
        if (viewGroup == null) {
            throw new java.lang.NullPointerException("parent");
        }
        layoutInflater.inflate(com.aliyun.svideo.editor.R.layout.alivc_editor_include_effect_title, viewGroup);
        return bind(viewGroup);
    }

    @Override // androidx.viewbinding.ViewBinding
    @androidx.annotation.NonNull
    public android.view.View getRoot() {
        return this.rootView;
    }
}
