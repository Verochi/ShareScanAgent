package com.aliyun.svideo.editor.databinding;

/* loaded from: classes12.dex */
public final class AlivcEditorCloudDraftConfigBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final android.widget.EditText alivcDraftServerUrlEdit;

    @androidx.annotation.NonNull
    public final android.widget.EditText alivcDraftUserNameEdit;

    @androidx.annotation.NonNull
    private final android.widget.LinearLayout rootView;

    private AlivcEditorCloudDraftConfigBinding(@androidx.annotation.NonNull android.widget.LinearLayout linearLayout, @androidx.annotation.NonNull android.widget.EditText editText, @androidx.annotation.NonNull android.widget.EditText editText2) {
        this.rootView = linearLayout;
        this.alivcDraftServerUrlEdit = editText;
        this.alivcDraftUserNameEdit = editText2;
    }

    @androidx.annotation.NonNull
    public static com.aliyun.svideo.editor.databinding.AlivcEditorCloudDraftConfigBinding bind(@androidx.annotation.NonNull android.view.View view) {
        int i = com.aliyun.svideo.editor.R.id.alivc_draft_server_url_edit;
        android.widget.EditText editText = (android.widget.EditText) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (editText != null) {
            i = com.aliyun.svideo.editor.R.id.alivc_draft_user_name_edit;
            android.widget.EditText editText2 = (android.widget.EditText) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
            if (editText2 != null) {
                return new com.aliyun.svideo.editor.databinding.AlivcEditorCloudDraftConfigBinding((android.widget.LinearLayout) view, editText, editText2);
            }
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @androidx.annotation.NonNull
    public static com.aliyun.svideo.editor.databinding.AlivcEditorCloudDraftConfigBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static com.aliyun.svideo.editor.databinding.AlivcEditorCloudDraftConfigBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(com.aliyun.svideo.editor.R.layout.alivc_editor_cloud_draft_config, viewGroup, false);
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
