package com.aliyun.svideo.editor.databinding;

/* loaded from: classes12.dex */
public final class AlivcEditorIncludeSplitLineBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    private final android.view.View rootView;

    private AlivcEditorIncludeSplitLineBinding(@androidx.annotation.NonNull android.view.View view) {
        this.rootView = view;
    }

    @androidx.annotation.NonNull
    public static com.aliyun.svideo.editor.databinding.AlivcEditorIncludeSplitLineBinding bind(@androidx.annotation.NonNull android.view.View view) {
        if (view != null) {
            return new com.aliyun.svideo.editor.databinding.AlivcEditorIncludeSplitLineBinding(view);
        }
        throw new java.lang.NullPointerException("rootView");
    }

    @androidx.annotation.NonNull
    public static com.aliyun.svideo.editor.databinding.AlivcEditorIncludeSplitLineBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static com.aliyun.svideo.editor.databinding.AlivcEditorIncludeSplitLineBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(com.aliyun.svideo.editor.R.layout.alivc_editor_include_split_line, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @androidx.annotation.NonNull
    public android.view.View getRoot() {
        return this.rootView;
    }
}
