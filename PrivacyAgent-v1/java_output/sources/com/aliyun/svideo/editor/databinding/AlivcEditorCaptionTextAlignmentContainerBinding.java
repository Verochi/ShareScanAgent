package com.aliyun.svideo.editor.databinding;

/* loaded from: classes12.dex */
public final class AlivcEditorCaptionTextAlignmentContainerBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final android.widget.RadioButton btnAlignmentLeft;

    @androidx.annotation.NonNull
    public final android.widget.RadioButton btnAlignmentMiddle;

    @androidx.annotation.NonNull
    public final android.widget.RadioButton btnAlignmentRight;

    @androidx.annotation.NonNull
    private final android.widget.FrameLayout rootView;

    private AlivcEditorCaptionTextAlignmentContainerBinding(@androidx.annotation.NonNull android.widget.FrameLayout frameLayout, @androidx.annotation.NonNull android.widget.RadioButton radioButton, @androidx.annotation.NonNull android.widget.RadioButton radioButton2, @androidx.annotation.NonNull android.widget.RadioButton radioButton3) {
        this.rootView = frameLayout;
        this.btnAlignmentLeft = radioButton;
        this.btnAlignmentMiddle = radioButton2;
        this.btnAlignmentRight = radioButton3;
    }

    @androidx.annotation.NonNull
    public static com.aliyun.svideo.editor.databinding.AlivcEditorCaptionTextAlignmentContainerBinding bind(@androidx.annotation.NonNull android.view.View view) {
        int i = com.aliyun.svideo.editor.R.id.btn_alignment_left;
        android.widget.RadioButton radioButton = (android.widget.RadioButton) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (radioButton != null) {
            i = com.aliyun.svideo.editor.R.id.btn_alignment_middle;
            android.widget.RadioButton radioButton2 = (android.widget.RadioButton) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
            if (radioButton2 != null) {
                i = com.aliyun.svideo.editor.R.id.btn_alignment_right;
                android.widget.RadioButton radioButton3 = (android.widget.RadioButton) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                if (radioButton3 != null) {
                    return new com.aliyun.svideo.editor.databinding.AlivcEditorCaptionTextAlignmentContainerBinding((android.widget.FrameLayout) view, radioButton, radioButton2, radioButton3);
                }
            }
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @androidx.annotation.NonNull
    public static com.aliyun.svideo.editor.databinding.AlivcEditorCaptionTextAlignmentContainerBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static com.aliyun.svideo.editor.databinding.AlivcEditorCaptionTextAlignmentContainerBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(com.aliyun.svideo.editor.R.layout.alivc_editor_caption_text_alignment_container, viewGroup, false);
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
