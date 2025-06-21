package com.aliyun.svideo.editor.databinding;

/* loaded from: classes12.dex */
public final class AlivcEditorTemplateItemBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final android.widget.ImageView ivCover;

    @androidx.annotation.NonNull
    public final android.widget.ImageView ivMore;

    @androidx.annotation.NonNull
    private final android.widget.LinearLayout rootView;

    @androidx.annotation.NonNull
    public final android.widget.TextView tvTitle;

    private AlivcEditorTemplateItemBinding(@androidx.annotation.NonNull android.widget.LinearLayout linearLayout, @androidx.annotation.NonNull android.widget.ImageView imageView, @androidx.annotation.NonNull android.widget.ImageView imageView2, @androidx.annotation.NonNull android.widget.TextView textView) {
        this.rootView = linearLayout;
        this.ivCover = imageView;
        this.ivMore = imageView2;
        this.tvTitle = textView;
    }

    @androidx.annotation.NonNull
    public static com.aliyun.svideo.editor.databinding.AlivcEditorTemplateItemBinding bind(@androidx.annotation.NonNull android.view.View view) {
        int i = com.aliyun.svideo.editor.R.id.iv_cover;
        android.widget.ImageView imageView = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = com.aliyun.svideo.editor.R.id.iv_more;
            android.widget.ImageView imageView2 = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
            if (imageView2 != null) {
                i = com.aliyun.svideo.editor.R.id.tv_title;
                android.widget.TextView textView = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                if (textView != null) {
                    return new com.aliyun.svideo.editor.databinding.AlivcEditorTemplateItemBinding((android.widget.LinearLayout) view, imageView, imageView2, textView);
                }
            }
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @androidx.annotation.NonNull
    public static com.aliyun.svideo.editor.databinding.AlivcEditorTemplateItemBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static com.aliyun.svideo.editor.databinding.AlivcEditorTemplateItemBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(com.aliyun.svideo.editor.R.layout.alivc_editor_template_item, viewGroup, false);
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
