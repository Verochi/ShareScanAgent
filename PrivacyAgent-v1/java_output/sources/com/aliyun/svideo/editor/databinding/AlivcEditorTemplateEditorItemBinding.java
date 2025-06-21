package com.aliyun.svideo.editor.databinding;

/* loaded from: classes31.dex */
public final class AlivcEditorTemplateEditorItemBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final android.widget.ImageView ivCover;

    @androidx.annotation.NonNull
    public final android.widget.TextView ivIndex;

    @androidx.annotation.NonNull
    public final android.widget.ImageButton ivLock;

    @androidx.annotation.NonNull
    public final android.widget.FrameLayout layoutItem;

    @androidx.annotation.NonNull
    private final android.widget.FrameLayout rootView;

    @androidx.annotation.NonNull
    public final android.widget.TextView tvDuration;

    @androidx.annotation.NonNull
    public final android.widget.TextView tvEdit;

    private AlivcEditorTemplateEditorItemBinding(@androidx.annotation.NonNull android.widget.FrameLayout frameLayout, @androidx.annotation.NonNull android.widget.ImageView imageView, @androidx.annotation.NonNull android.widget.TextView textView, @androidx.annotation.NonNull android.widget.ImageButton imageButton, @androidx.annotation.NonNull android.widget.FrameLayout frameLayout2, @androidx.annotation.NonNull android.widget.TextView textView2, @androidx.annotation.NonNull android.widget.TextView textView3) {
        this.rootView = frameLayout;
        this.ivCover = imageView;
        this.ivIndex = textView;
        this.ivLock = imageButton;
        this.layoutItem = frameLayout2;
        this.tvDuration = textView2;
        this.tvEdit = textView3;
    }

    @androidx.annotation.NonNull
    public static com.aliyun.svideo.editor.databinding.AlivcEditorTemplateEditorItemBinding bind(@androidx.annotation.NonNull android.view.View view) {
        int i = com.aliyun.svideo.editor.R.id.iv_cover;
        android.widget.ImageView imageView = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = com.aliyun.svideo.editor.R.id.iv_index;
            android.widget.TextView textView = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                i = com.aliyun.svideo.editor.R.id.iv_lock;
                android.widget.ImageButton imageButton = (android.widget.ImageButton) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                if (imageButton != null) {
                    i = com.aliyun.svideo.editor.R.id.layout_item;
                    android.widget.FrameLayout frameLayout = (android.widget.FrameLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                    if (frameLayout != null) {
                        i = com.aliyun.svideo.editor.R.id.tv_duration;
                        android.widget.TextView textView2 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                        if (textView2 != null) {
                            i = com.aliyun.svideo.editor.R.id.tv_edit;
                            android.widget.TextView textView3 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                            if (textView3 != null) {
                                return new com.aliyun.svideo.editor.databinding.AlivcEditorTemplateEditorItemBinding((android.widget.FrameLayout) view, imageView, textView, imageButton, frameLayout, textView2, textView3);
                            }
                        }
                    }
                }
            }
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @androidx.annotation.NonNull
    public static com.aliyun.svideo.editor.databinding.AlivcEditorTemplateEditorItemBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static com.aliyun.svideo.editor.databinding.AlivcEditorTemplateEditorItemBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(com.aliyun.svideo.editor.R.layout.alivc_editor_template_editor_item, viewGroup, false);
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
