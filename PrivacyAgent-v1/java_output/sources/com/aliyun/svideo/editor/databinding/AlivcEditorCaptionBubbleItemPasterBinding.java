package com.aliyun.svideo.editor.databinding;

/* loaded from: classes12.dex */
public final class AlivcEditorCaptionBubbleItemPasterBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final android.widget.ImageView resourceImageView;

    @androidx.annotation.NonNull
    private final android.widget.FrameLayout rootView;

    @androidx.annotation.NonNull
    public final android.view.View selectedView;

    private AlivcEditorCaptionBubbleItemPasterBinding(@androidx.annotation.NonNull android.widget.FrameLayout frameLayout, @androidx.annotation.NonNull android.widget.ImageView imageView, @androidx.annotation.NonNull android.view.View view) {
        this.rootView = frameLayout;
        this.resourceImageView = imageView;
        this.selectedView = view;
    }

    @androidx.annotation.NonNull
    public static com.aliyun.svideo.editor.databinding.AlivcEditorCaptionBubbleItemPasterBinding bind(@androidx.annotation.NonNull android.view.View view) {
        android.view.View findChildViewById;
        int i = com.aliyun.svideo.editor.R.id.resource_image_view;
        android.widget.ImageView imageView = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (imageView == null || (findChildViewById = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = com.aliyun.svideo.editor.R.id.selected_view))) == null) {
            throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }
        return new com.aliyun.svideo.editor.databinding.AlivcEditorCaptionBubbleItemPasterBinding((android.widget.FrameLayout) view, imageView, findChildViewById);
    }

    @androidx.annotation.NonNull
    public static com.aliyun.svideo.editor.databinding.AlivcEditorCaptionBubbleItemPasterBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static com.aliyun.svideo.editor.databinding.AlivcEditorCaptionBubbleItemPasterBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(com.aliyun.svideo.editor.R.layout.alivc_editor_caption_bubble_item_paster, viewGroup, false);
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
