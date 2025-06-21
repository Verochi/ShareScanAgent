package com.aliyun.svideo.editor.databinding;

/* loaded from: classes12.dex */
public final class AlivcEditorViewPasterTextBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final com.aliyun.svideo.editor.widget.AutoResizingTextView content;

    @androidx.annotation.NonNull
    public final com.aliyun.svideo.editor.widget.AliyunPasterWithTextView editOverlay;

    @androidx.annotation.NonNull
    public final android.widget.ImageView qupaiBtnEditOverlayCancel;

    @androidx.annotation.NonNull
    public final android.widget.ImageView qupaiBtnEditOverlayTransform;

    @androidx.annotation.NonNull
    private final com.aliyun.svideo.editor.widget.AliyunPasterWithTextView rootView;

    private AlivcEditorViewPasterTextBinding(@androidx.annotation.NonNull com.aliyun.svideo.editor.widget.AliyunPasterWithTextView aliyunPasterWithTextView, @androidx.annotation.NonNull com.aliyun.svideo.editor.widget.AutoResizingTextView autoResizingTextView, @androidx.annotation.NonNull com.aliyun.svideo.editor.widget.AliyunPasterWithTextView aliyunPasterWithTextView2, @androidx.annotation.NonNull android.widget.ImageView imageView, @androidx.annotation.NonNull android.widget.ImageView imageView2) {
        this.rootView = aliyunPasterWithTextView;
        this.content = autoResizingTextView;
        this.editOverlay = aliyunPasterWithTextView2;
        this.qupaiBtnEditOverlayCancel = imageView;
        this.qupaiBtnEditOverlayTransform = imageView2;
    }

    @androidx.annotation.NonNull
    public static com.aliyun.svideo.editor.databinding.AlivcEditorViewPasterTextBinding bind(@androidx.annotation.NonNull android.view.View view) {
        int i = android.R.id.content;
        com.aliyun.svideo.editor.widget.AutoResizingTextView autoResizingTextView = (com.aliyun.svideo.editor.widget.AutoResizingTextView) androidx.viewbinding.ViewBindings.findChildViewById(view, android.R.id.content);
        if (autoResizingTextView != null) {
            com.aliyun.svideo.editor.widget.AliyunPasterWithTextView aliyunPasterWithTextView = (com.aliyun.svideo.editor.widget.AliyunPasterWithTextView) view;
            i = com.aliyun.svideo.editor.R.id.qupai_btn_edit_overlay_cancel;
            android.widget.ImageView imageView = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
            if (imageView != null) {
                i = com.aliyun.svideo.editor.R.id.qupai_btn_edit_overlay_transform;
                android.widget.ImageView imageView2 = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                if (imageView2 != null) {
                    return new com.aliyun.svideo.editor.databinding.AlivcEditorViewPasterTextBinding(aliyunPasterWithTextView, autoResizingTextView, aliyunPasterWithTextView, imageView, imageView2);
                }
            }
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @androidx.annotation.NonNull
    public static com.aliyun.svideo.editor.databinding.AlivcEditorViewPasterTextBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static com.aliyun.svideo.editor.databinding.AlivcEditorViewPasterTextBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(com.aliyun.svideo.editor.R.layout.alivc_editor_view_paster_text, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @androidx.annotation.NonNull
    public com.aliyun.svideo.editor.widget.AliyunPasterWithTextView getRoot() {
        return this.rootView;
    }
}
