package com.aliyun.svideo.editor.databinding;

/* loaded from: classes12.dex */
public final class AlivcEditorCaptionFontStyleContainerBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final android.widget.CheckBox btnFontItalic;

    @androidx.annotation.NonNull
    public final android.widget.CheckBox btnFontWeight;

    @androidx.annotation.NonNull
    private final android.widget.FrameLayout rootView;

    private AlivcEditorCaptionFontStyleContainerBinding(@androidx.annotation.NonNull android.widget.FrameLayout frameLayout, @androidx.annotation.NonNull android.widget.CheckBox checkBox, @androidx.annotation.NonNull android.widget.CheckBox checkBox2) {
        this.rootView = frameLayout;
        this.btnFontItalic = checkBox;
        this.btnFontWeight = checkBox2;
    }

    @androidx.annotation.NonNull
    public static com.aliyun.svideo.editor.databinding.AlivcEditorCaptionFontStyleContainerBinding bind(@androidx.annotation.NonNull android.view.View view) {
        int i = com.aliyun.svideo.editor.R.id.btn_font_italic;
        android.widget.CheckBox checkBox = (android.widget.CheckBox) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (checkBox != null) {
            i = com.aliyun.svideo.editor.R.id.btn_font_weight;
            android.widget.CheckBox checkBox2 = (android.widget.CheckBox) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
            if (checkBox2 != null) {
                return new com.aliyun.svideo.editor.databinding.AlivcEditorCaptionFontStyleContainerBinding((android.widget.FrameLayout) view, checkBox, checkBox2);
            }
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @androidx.annotation.NonNull
    public static com.aliyun.svideo.editor.databinding.AlivcEditorCaptionFontStyleContainerBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static com.aliyun.svideo.editor.databinding.AlivcEditorCaptionFontStyleContainerBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(com.aliyun.svideo.editor.R.layout.alivc_editor_caption_font_style_container, viewGroup, false);
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
