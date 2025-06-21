package com.aliyun.svideo.editor.databinding;

/* loaded from: classes12.dex */
public final class AlivcEditorItemTimelineThumbnailBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final android.widget.ImageView ivThumbnail;

    @androidx.annotation.NonNull
    private final com.aliyun.svideo.base.widget.SquareFrameLayout rootView;

    private AlivcEditorItemTimelineThumbnailBinding(@androidx.annotation.NonNull com.aliyun.svideo.base.widget.SquareFrameLayout squareFrameLayout, @androidx.annotation.NonNull android.widget.ImageView imageView) {
        this.rootView = squareFrameLayout;
        this.ivThumbnail = imageView;
    }

    @androidx.annotation.NonNull
    public static com.aliyun.svideo.editor.databinding.AlivcEditorItemTimelineThumbnailBinding bind(@androidx.annotation.NonNull android.view.View view) {
        int i = com.aliyun.svideo.editor.R.id.iv_thumbnail;
        android.widget.ImageView imageView = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            return new com.aliyun.svideo.editor.databinding.AlivcEditorItemTimelineThumbnailBinding((com.aliyun.svideo.base.widget.SquareFrameLayout) view, imageView);
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @androidx.annotation.NonNull
    public static com.aliyun.svideo.editor.databinding.AlivcEditorItemTimelineThumbnailBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static com.aliyun.svideo.editor.databinding.AlivcEditorItemTimelineThumbnailBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(com.aliyun.svideo.editor.R.layout.alivc_editor_item_timeline_thumbnail, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @androidx.annotation.NonNull
    public com.aliyun.svideo.base.widget.SquareFrameLayout getRoot() {
        return this.rootView;
    }
}
