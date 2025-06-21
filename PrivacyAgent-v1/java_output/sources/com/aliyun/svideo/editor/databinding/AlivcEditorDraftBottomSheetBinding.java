package com.aliyun.svideo.editor.databinding;

/* loaded from: classes31.dex */
public final class AlivcEditorDraftBottomSheetBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final android.widget.TextView alivcBackupBtn;

    @androidx.annotation.NonNull
    public final android.widget.TextView alivcCopyBtn;

    @androidx.annotation.NonNull
    public final android.widget.TextView alivcDeleteBtn;

    @androidx.annotation.NonNull
    public final android.widget.TextView alivcRenameBtn;

    @androidx.annotation.NonNull
    public final android.widget.TextView alivcUpdateCoverBtn;

    @androidx.annotation.NonNull
    private final android.widget.LinearLayout rootView;

    private AlivcEditorDraftBottomSheetBinding(@androidx.annotation.NonNull android.widget.LinearLayout linearLayout, @androidx.annotation.NonNull android.widget.TextView textView, @androidx.annotation.NonNull android.widget.TextView textView2, @androidx.annotation.NonNull android.widget.TextView textView3, @androidx.annotation.NonNull android.widget.TextView textView4, @androidx.annotation.NonNull android.widget.TextView textView5) {
        this.rootView = linearLayout;
        this.alivcBackupBtn = textView;
        this.alivcCopyBtn = textView2;
        this.alivcDeleteBtn = textView3;
        this.alivcRenameBtn = textView4;
        this.alivcUpdateCoverBtn = textView5;
    }

    @androidx.annotation.NonNull
    public static com.aliyun.svideo.editor.databinding.AlivcEditorDraftBottomSheetBinding bind(@androidx.annotation.NonNull android.view.View view) {
        int i = com.aliyun.svideo.editor.R.id.alivc_backup_btn;
        android.widget.TextView textView = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = com.aliyun.svideo.editor.R.id.alivc_copy_btn;
            android.widget.TextView textView2 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
            if (textView2 != null) {
                i = com.aliyun.svideo.editor.R.id.alivc_delete_btn;
                android.widget.TextView textView3 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                if (textView3 != null) {
                    i = com.aliyun.svideo.editor.R.id.alivc_rename_btn;
                    android.widget.TextView textView4 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                    if (textView4 != null) {
                        i = com.aliyun.svideo.editor.R.id.alivc_update_cover_btn;
                        android.widget.TextView textView5 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                        if (textView5 != null) {
                            return new com.aliyun.svideo.editor.databinding.AlivcEditorDraftBottomSheetBinding((android.widget.LinearLayout) view, textView, textView2, textView3, textView4, textView5);
                        }
                    }
                }
            }
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @androidx.annotation.NonNull
    public static com.aliyun.svideo.editor.databinding.AlivcEditorDraftBottomSheetBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static com.aliyun.svideo.editor.databinding.AlivcEditorDraftBottomSheetBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(com.aliyun.svideo.editor.R.layout.alivc_editor_draft_bottom_sheet, viewGroup, false);
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
