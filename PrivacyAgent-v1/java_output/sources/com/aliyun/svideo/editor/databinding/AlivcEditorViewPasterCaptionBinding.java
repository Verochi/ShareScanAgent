package com.aliyun.svideo.editor.databinding;

/* loaded from: classes31.dex */
public final class AlivcEditorViewPasterCaptionBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final android.widget.FrameLayout content;

    @androidx.annotation.NonNull
    public final com.aliyun.svideo.editor.widget.AliyunPasterWithImageView editOverlay;

    @androidx.annotation.NonNull
    public final android.widget.ImageView qupaiBtnEditOverlayCancel;

    @androidx.annotation.NonNull
    public final android.widget.ImageView qupaiBtnEditOverlayMirror;

    @androidx.annotation.NonNull
    public final android.widget.ImageView qupaiBtnEditOverlayTransform;

    @androidx.annotation.NonNull
    public final com.aliyun.svideo.editor.widget.AutoResizingTextView qupaiOverlayContentText;

    @androidx.annotation.NonNull
    private final com.aliyun.svideo.editor.widget.AliyunPasterWithImageView rootView;

    private AlivcEditorViewPasterCaptionBinding(@androidx.annotation.NonNull com.aliyun.svideo.editor.widget.AliyunPasterWithImageView aliyunPasterWithImageView, @androidx.annotation.NonNull android.widget.FrameLayout frameLayout, @androidx.annotation.NonNull com.aliyun.svideo.editor.widget.AliyunPasterWithImageView aliyunPasterWithImageView2, @androidx.annotation.NonNull android.widget.ImageView imageView, @androidx.annotation.NonNull android.widget.ImageView imageView2, @androidx.annotation.NonNull android.widget.ImageView imageView3, @androidx.annotation.NonNull com.aliyun.svideo.editor.widget.AutoResizingTextView autoResizingTextView) {
        this.rootView = aliyunPasterWithImageView;
        this.content = frameLayout;
        this.editOverlay = aliyunPasterWithImageView2;
        this.qupaiBtnEditOverlayCancel = imageView;
        this.qupaiBtnEditOverlayMirror = imageView2;
        this.qupaiBtnEditOverlayTransform = imageView3;
        this.qupaiOverlayContentText = autoResizingTextView;
    }

    @androidx.annotation.NonNull
    public static com.aliyun.svideo.editor.databinding.AlivcEditorViewPasterCaptionBinding bind(@androidx.annotation.NonNull android.view.View view) {
        int i = android.R.id.content;
        android.widget.FrameLayout frameLayout = (android.widget.FrameLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, android.R.id.content);
        if (frameLayout != null) {
            com.aliyun.svideo.editor.widget.AliyunPasterWithImageView aliyunPasterWithImageView = (com.aliyun.svideo.editor.widget.AliyunPasterWithImageView) view;
            i = com.aliyun.svideo.editor.R.id.qupai_btn_edit_overlay_cancel;
            android.widget.ImageView imageView = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
            if (imageView != null) {
                i = com.aliyun.svideo.editor.R.id.qupai_btn_edit_overlay_mirror;
                android.widget.ImageView imageView2 = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                if (imageView2 != null) {
                    i = com.aliyun.svideo.editor.R.id.qupai_btn_edit_overlay_transform;
                    android.widget.ImageView imageView3 = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                    if (imageView3 != null) {
                        i = com.aliyun.svideo.editor.R.id.qupai_overlay_content_text;
                        com.aliyun.svideo.editor.widget.AutoResizingTextView autoResizingTextView = (com.aliyun.svideo.editor.widget.AutoResizingTextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                        if (autoResizingTextView != null) {
                            return new com.aliyun.svideo.editor.databinding.AlivcEditorViewPasterCaptionBinding(aliyunPasterWithImageView, frameLayout, aliyunPasterWithImageView, imageView, imageView2, imageView3, autoResizingTextView);
                        }
                    }
                }
            }
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @androidx.annotation.NonNull
    public static com.aliyun.svideo.editor.databinding.AlivcEditorViewPasterCaptionBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static com.aliyun.svideo.editor.databinding.AlivcEditorViewPasterCaptionBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(com.aliyun.svideo.editor.R.layout.alivc_editor_view_paster_caption, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @androidx.annotation.NonNull
    public com.aliyun.svideo.editor.widget.AliyunPasterWithImageView getRoot() {
        return this.rootView;
    }
}
