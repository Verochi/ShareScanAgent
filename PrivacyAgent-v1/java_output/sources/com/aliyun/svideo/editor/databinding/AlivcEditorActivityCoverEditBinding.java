package com.aliyun.svideo.editor.databinding;

/* loaded from: classes12.dex */
public final class AlivcEditorActivityCoverEditBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final com.aliyun.svideo.editor.databinding.AlivcEditorIncludeActionBarProfileBinding actionBar;

    @androidx.annotation.NonNull
    public final android.widget.LinearLayout coverThumbnailList;

    @androidx.annotation.NonNull
    public final android.widget.ImageView indiator;

    @androidx.annotation.NonNull
    private final android.widget.LinearLayout rootView;

    @androidx.annotation.NonNull
    public final android.view.TextureView ttvEditorCover;

    private AlivcEditorActivityCoverEditBinding(@androidx.annotation.NonNull android.widget.LinearLayout linearLayout, @androidx.annotation.NonNull com.aliyun.svideo.editor.databinding.AlivcEditorIncludeActionBarProfileBinding alivcEditorIncludeActionBarProfileBinding, @androidx.annotation.NonNull android.widget.LinearLayout linearLayout2, @androidx.annotation.NonNull android.widget.ImageView imageView, @androidx.annotation.NonNull android.view.TextureView textureView) {
        this.rootView = linearLayout;
        this.actionBar = alivcEditorIncludeActionBarProfileBinding;
        this.coverThumbnailList = linearLayout2;
        this.indiator = imageView;
        this.ttvEditorCover = textureView;
    }

    @androidx.annotation.NonNull
    public static com.aliyun.svideo.editor.databinding.AlivcEditorActivityCoverEditBinding bind(@androidx.annotation.NonNull android.view.View view) {
        int i = com.aliyun.svideo.editor.R.id.action_bar;
        android.view.View findChildViewById = androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (findChildViewById != null) {
            com.aliyun.svideo.editor.databinding.AlivcEditorIncludeActionBarProfileBinding bind = com.aliyun.svideo.editor.databinding.AlivcEditorIncludeActionBarProfileBinding.bind(findChildViewById);
            i = com.aliyun.svideo.editor.R.id.cover_thumbnail_list;
            android.widget.LinearLayout linearLayout = (android.widget.LinearLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
            if (linearLayout != null) {
                i = com.aliyun.svideo.editor.R.id.indiator;
                android.widget.ImageView imageView = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                if (imageView != null) {
                    i = com.aliyun.svideo.editor.R.id.ttv_editor_cover;
                    android.view.TextureView textureView = (android.view.TextureView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                    if (textureView != null) {
                        return new com.aliyun.svideo.editor.databinding.AlivcEditorActivityCoverEditBinding((android.widget.LinearLayout) view, bind, linearLayout, imageView, textureView);
                    }
                }
            }
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @androidx.annotation.NonNull
    public static com.aliyun.svideo.editor.databinding.AlivcEditorActivityCoverEditBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static com.aliyun.svideo.editor.databinding.AlivcEditorActivityCoverEditBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(com.aliyun.svideo.editor.R.layout.alivc_editor_activity_cover_edit, viewGroup, false);
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
