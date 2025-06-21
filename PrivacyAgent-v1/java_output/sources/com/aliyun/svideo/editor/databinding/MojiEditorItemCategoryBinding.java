package com.aliyun.svideo.editor.databinding;

/* loaded from: classes12.dex */
public final class MojiEditorItemCategoryBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final com.aliyun.svideo.base.widget.CircularImageView categoryImageSource;

    @androidx.annotation.NonNull
    private final android.widget.FrameLayout rootView;

    @androidx.annotation.NonNull
    public final android.widget.TextView tvCategoryNameSource;

    private MojiEditorItemCategoryBinding(@androidx.annotation.NonNull android.widget.FrameLayout frameLayout, @androidx.annotation.NonNull com.aliyun.svideo.base.widget.CircularImageView circularImageView, @androidx.annotation.NonNull android.widget.TextView textView) {
        this.rootView = frameLayout;
        this.categoryImageSource = circularImageView;
        this.tvCategoryNameSource = textView;
    }

    @androidx.annotation.NonNull
    public static com.aliyun.svideo.editor.databinding.MojiEditorItemCategoryBinding bind(@androidx.annotation.NonNull android.view.View view) {
        int i = com.aliyun.svideo.editor.R.id.category_image_source;
        com.aliyun.svideo.base.widget.CircularImageView circularImageView = (com.aliyun.svideo.base.widget.CircularImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (circularImageView != null) {
            i = com.aliyun.svideo.editor.R.id.tv_category_name_source;
            android.widget.TextView textView = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                return new com.aliyun.svideo.editor.databinding.MojiEditorItemCategoryBinding((android.widget.FrameLayout) view, circularImageView, textView);
            }
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @androidx.annotation.NonNull
    public static com.aliyun.svideo.editor.databinding.MojiEditorItemCategoryBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static com.aliyun.svideo.editor.databinding.MojiEditorItemCategoryBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(com.aliyun.svideo.editor.R.layout.moji_editor_item_category, viewGroup, false);
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
