package com.aliyun.svideo.media.databinding;

/* loaded from: classes12.dex */
public final class AlivcMediaItemVideoTemplateImportBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final android.widget.ImageView ivCover;

    @androidx.annotation.NonNull
    public final android.widget.ImageView ivDelete;

    @androidx.annotation.NonNull
    public final android.widget.TextView ivIndex;

    @androidx.annotation.NonNull
    public final android.view.View ivSelect;

    @androidx.annotation.NonNull
    private final android.widget.FrameLayout rootView;

    @androidx.annotation.NonNull
    public final android.widget.TextView tvDuration;

    private AlivcMediaItemVideoTemplateImportBinding(@androidx.annotation.NonNull android.widget.FrameLayout frameLayout, @androidx.annotation.NonNull android.widget.ImageView imageView, @androidx.annotation.NonNull android.widget.ImageView imageView2, @androidx.annotation.NonNull android.widget.TextView textView, @androidx.annotation.NonNull android.view.View view, @androidx.annotation.NonNull android.widget.TextView textView2) {
        this.rootView = frameLayout;
        this.ivCover = imageView;
        this.ivDelete = imageView2;
        this.ivIndex = textView;
        this.ivSelect = view;
        this.tvDuration = textView2;
    }

    @androidx.annotation.NonNull
    public static com.aliyun.svideo.media.databinding.AlivcMediaItemVideoTemplateImportBinding bind(@androidx.annotation.NonNull android.view.View view) {
        android.view.View findChildViewById;
        int i = com.aliyun.svideo.media.R.id.iv_cover;
        android.widget.ImageView imageView = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = com.aliyun.svideo.media.R.id.iv_delete;
            android.widget.ImageView imageView2 = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
            if (imageView2 != null) {
                i = com.aliyun.svideo.media.R.id.iv_index;
                android.widget.TextView textView = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                if (textView != null && (findChildViewById = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = com.aliyun.svideo.media.R.id.iv_select))) != null) {
                    i = com.aliyun.svideo.media.R.id.tv_duration;
                    android.widget.TextView textView2 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                    if (textView2 != null) {
                        return new com.aliyun.svideo.media.databinding.AlivcMediaItemVideoTemplateImportBinding((android.widget.FrameLayout) view, imageView, imageView2, textView, findChildViewById, textView2);
                    }
                }
            }
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @androidx.annotation.NonNull
    public static com.aliyun.svideo.media.databinding.AlivcMediaItemVideoTemplateImportBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static com.aliyun.svideo.media.databinding.AlivcMediaItemVideoTemplateImportBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(com.aliyun.svideo.media.R.layout.alivc_media_item_video_template_import, viewGroup, false);
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
