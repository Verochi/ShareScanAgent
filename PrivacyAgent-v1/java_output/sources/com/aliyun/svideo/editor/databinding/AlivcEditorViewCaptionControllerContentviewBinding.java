package com.aliyun.svideo.editor.databinding;

/* loaded from: classes12.dex */
public final class AlivcEditorViewCaptionControllerContentviewBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final android.widget.FrameLayout aliyunEditOverlay;

    @androidx.annotation.NonNull
    public final com.aliyun.svideo.editor.widget.AliyunPasterBorderControllerView content;

    @androidx.annotation.NonNull
    public final android.widget.ImageView qupaiBtnEditOverlayCancel;

    @androidx.annotation.NonNull
    public final android.widget.ImageView qupaiBtnEditOverlayTransform;

    @androidx.annotation.NonNull
    private final android.widget.FrameLayout rootView;

    private AlivcEditorViewCaptionControllerContentviewBinding(@androidx.annotation.NonNull android.widget.FrameLayout frameLayout, @androidx.annotation.NonNull android.widget.FrameLayout frameLayout2, @androidx.annotation.NonNull com.aliyun.svideo.editor.widget.AliyunPasterBorderControllerView aliyunPasterBorderControllerView, @androidx.annotation.NonNull android.widget.ImageView imageView, @androidx.annotation.NonNull android.widget.ImageView imageView2) {
        this.rootView = frameLayout;
        this.aliyunEditOverlay = frameLayout2;
        this.content = aliyunPasterBorderControllerView;
        this.qupaiBtnEditOverlayCancel = imageView;
        this.qupaiBtnEditOverlayTransform = imageView2;
    }

    @androidx.annotation.NonNull
    public static com.aliyun.svideo.editor.databinding.AlivcEditorViewCaptionControllerContentviewBinding bind(@androidx.annotation.NonNull android.view.View view) {
        android.widget.FrameLayout frameLayout = (android.widget.FrameLayout) view;
        int i = android.R.id.content;
        com.aliyun.svideo.editor.widget.AliyunPasterBorderControllerView aliyunPasterBorderControllerView = (com.aliyun.svideo.editor.widget.AliyunPasterBorderControllerView) androidx.viewbinding.ViewBindings.findChildViewById(view, android.R.id.content);
        if (aliyunPasterBorderControllerView != null) {
            i = com.aliyun.svideo.editor.R.id.qupai_btn_edit_overlay_cancel;
            android.widget.ImageView imageView = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
            if (imageView != null) {
                i = com.aliyun.svideo.editor.R.id.qupai_btn_edit_overlay_transform;
                android.widget.ImageView imageView2 = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                if (imageView2 != null) {
                    return new com.aliyun.svideo.editor.databinding.AlivcEditorViewCaptionControllerContentviewBinding(frameLayout, frameLayout, aliyunPasterBorderControllerView, imageView, imageView2);
                }
            }
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @androidx.annotation.NonNull
    public static com.aliyun.svideo.editor.databinding.AlivcEditorViewCaptionControllerContentviewBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static com.aliyun.svideo.editor.databinding.AlivcEditorViewCaptionControllerContentviewBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(com.aliyun.svideo.editor.R.layout.alivc_editor_view_caption_controller_contentview, viewGroup, false);
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
