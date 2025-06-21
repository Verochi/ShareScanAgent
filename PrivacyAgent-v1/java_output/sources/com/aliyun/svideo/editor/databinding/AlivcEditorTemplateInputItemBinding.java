package com.aliyun.svideo.editor.databinding;

/* loaded from: classes12.dex */
public final class AlivcEditorTemplateInputItemBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final android.widget.CheckBox cbItem;

    @androidx.annotation.NonNull
    public final android.widget.ImageView ivCover;

    @androidx.annotation.NonNull
    public final android.widget.TextView ivIndex;

    @androidx.annotation.NonNull
    private final android.widget.FrameLayout rootView;

    @androidx.annotation.NonNull
    public final android.widget.TextView tvDuration;

    private AlivcEditorTemplateInputItemBinding(@androidx.annotation.NonNull android.widget.FrameLayout frameLayout, @androidx.annotation.NonNull android.widget.CheckBox checkBox, @androidx.annotation.NonNull android.widget.ImageView imageView, @androidx.annotation.NonNull android.widget.TextView textView, @androidx.annotation.NonNull android.widget.TextView textView2) {
        this.rootView = frameLayout;
        this.cbItem = checkBox;
        this.ivCover = imageView;
        this.ivIndex = textView;
        this.tvDuration = textView2;
    }

    @androidx.annotation.NonNull
    public static com.aliyun.svideo.editor.databinding.AlivcEditorTemplateInputItemBinding bind(@androidx.annotation.NonNull android.view.View view) {
        int i = com.aliyun.svideo.editor.R.id.cb_item;
        android.widget.CheckBox checkBox = (android.widget.CheckBox) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (checkBox != null) {
            i = com.aliyun.svideo.editor.R.id.iv_cover;
            android.widget.ImageView imageView = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
            if (imageView != null) {
                i = com.aliyun.svideo.editor.R.id.iv_index;
                android.widget.TextView textView = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                if (textView != null) {
                    i = com.aliyun.svideo.editor.R.id.tv_duration;
                    android.widget.TextView textView2 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                    if (textView2 != null) {
                        return new com.aliyun.svideo.editor.databinding.AlivcEditorTemplateInputItemBinding((android.widget.FrameLayout) view, checkBox, imageView, textView, textView2);
                    }
                }
            }
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @androidx.annotation.NonNull
    public static com.aliyun.svideo.editor.databinding.AlivcEditorTemplateInputItemBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static com.aliyun.svideo.editor.databinding.AlivcEditorTemplateInputItemBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(com.aliyun.svideo.editor.R.layout.alivc_editor_template_input_item, viewGroup, false);
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
