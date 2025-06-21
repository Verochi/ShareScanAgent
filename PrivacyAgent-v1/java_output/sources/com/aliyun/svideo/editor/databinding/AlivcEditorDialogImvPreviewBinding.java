package com.aliyun.svideo.editor.databinding;

/* loaded from: classes12.dex */
public final class AlivcEditorDialogImvPreviewBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final com.aliyun.svideo.base.widget.SquareFrameLayout imvVideoView;

    @androidx.annotation.NonNull
    public final android.widget.ImageView ivImvCloseBtn;

    @androidx.annotation.NonNull
    private final android.widget.LinearLayout rootView;

    private AlivcEditorDialogImvPreviewBinding(@androidx.annotation.NonNull android.widget.LinearLayout linearLayout, @androidx.annotation.NonNull com.aliyun.svideo.base.widget.SquareFrameLayout squareFrameLayout, @androidx.annotation.NonNull android.widget.ImageView imageView) {
        this.rootView = linearLayout;
        this.imvVideoView = squareFrameLayout;
        this.ivImvCloseBtn = imageView;
    }

    @androidx.annotation.NonNull
    public static com.aliyun.svideo.editor.databinding.AlivcEditorDialogImvPreviewBinding bind(@androidx.annotation.NonNull android.view.View view) {
        int i = com.aliyun.svideo.editor.R.id.imv_video_view;
        com.aliyun.svideo.base.widget.SquareFrameLayout squareFrameLayout = (com.aliyun.svideo.base.widget.SquareFrameLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (squareFrameLayout != null) {
            i = com.aliyun.svideo.editor.R.id.iv_imv_close_btn;
            android.widget.ImageView imageView = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
            if (imageView != null) {
                return new com.aliyun.svideo.editor.databinding.AlivcEditorDialogImvPreviewBinding((android.widget.LinearLayout) view, squareFrameLayout, imageView);
            }
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @androidx.annotation.NonNull
    public static com.aliyun.svideo.editor.databinding.AlivcEditorDialogImvPreviewBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static com.aliyun.svideo.editor.databinding.AlivcEditorDialogImvPreviewBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(com.aliyun.svideo.editor.R.layout.alivc_editor_dialog_imv_preview, viewGroup, false);
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
