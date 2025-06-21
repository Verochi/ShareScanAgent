package com.aliyun.svideo.editor.draft;

/* loaded from: classes12.dex */
public class CloudDraftConfigDialogFragment extends androidx.fragment.app.DialogFragment {
    private com.aliyun.svideo.editor.draft.CloudDraftConfigDialogFragment.OnCloudDraftConfigListener mOnCloudDraftConfigListener;
    private java.lang.String mServerUrl;
    private java.lang.String mUserName;

    /* renamed from: com.aliyun.svideo.editor.draft.CloudDraftConfigDialogFragment$1, reason: invalid class name */
    public class AnonymousClass1 implements android.content.DialogInterface.OnClickListener {
        final /* synthetic */ android.widget.EditText val$editServerUrlText;
        final /* synthetic */ android.widget.EditText val$editServerUserNameText;

        public AnonymousClass1(android.widget.EditText editText, android.widget.EditText editText2) {
            this.val$editServerUrlText = editText;
            this.val$editServerUserNameText = editText2;
        }

        @Override // android.content.DialogInterface.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public void onClick(android.content.DialogInterface dialogInterface, int i) {
            if (com.aliyun.svideo.editor.draft.CloudDraftConfigDialogFragment.this.mOnCloudDraftConfigListener != null) {
                com.aliyun.svideo.editor.draft.CloudDraftConfigDialogFragment.this.mOnCloudDraftConfigListener.onConfig(this.val$editServerUrlText.getText().toString(), this.val$editServerUserNameText.getText().toString());
            }
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackDialog(dialogInterface, i);
        }
    }

    public interface OnCloudDraftConfigListener {
        void onConfig(java.lang.String str, java.lang.String str2);
    }

    @Override // androidx.fragment.app.DialogFragment
    @androidx.annotation.NonNull
    public android.app.Dialog onCreateDialog(android.os.Bundle bundle) {
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(getActivity());
        android.view.View inflate = getActivity().getLayoutInflater().inflate(com.aliyun.svideo.editor.R.layout.alivc_editor_cloud_draft_config, (android.view.ViewGroup) null);
        android.widget.EditText editText = (android.widget.EditText) inflate.findViewById(com.aliyun.svideo.editor.R.id.alivc_draft_server_url_edit);
        editText.setText(this.mServerUrl);
        android.widget.EditText editText2 = (android.widget.EditText) inflate.findViewById(com.aliyun.svideo.editor.R.id.alivc_draft_user_name_edit);
        editText2.setText(this.mUserName);
        builder.setView(inflate).setPositiveButton("确定", new com.aliyun.svideo.editor.draft.CloudDraftConfigDialogFragment.AnonymousClass1(editText, editText2)).setNegativeButton("取消", (android.content.DialogInterface.OnClickListener) null);
        return builder.create();
    }

    @Override // androidx.fragment.app.Fragment
    @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        com.sensorsdata.analytics.android.autotrack.aop.FragmentTrackHelper.trackOnHiddenChanged(this, z);
    }

    @Override // androidx.fragment.app.Fragment
    @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
    public void onPause() {
        super.onPause();
        com.sensorsdata.analytics.android.autotrack.aop.FragmentTrackHelper.trackFragmentPause(this);
    }

    @Override // androidx.fragment.app.Fragment
    @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
    public void onResume() {
        super.onResume();
        com.sensorsdata.analytics.android.autotrack.aop.FragmentTrackHelper.trackFragmentResume(this);
    }

    @Override // androidx.fragment.app.Fragment
    @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
    public void onViewCreated(android.view.View view, android.os.Bundle bundle) {
        super.onViewCreated(view, bundle);
        com.sensorsdata.analytics.android.autotrack.aop.FragmentTrackHelper.onFragmentViewCreated(this, view, bundle);
    }

    public void setOnCloudDraftConfigListener(com.aliyun.svideo.editor.draft.CloudDraftConfigDialogFragment.OnCloudDraftConfigListener onCloudDraftConfigListener) {
        this.mOnCloudDraftConfigListener = onCloudDraftConfigListener;
    }

    public void setServerUrl(java.lang.String str) {
        this.mServerUrl = str;
    }

    public void setUserName(java.lang.String str) {
        this.mUserName = str;
    }

    @Override // androidx.fragment.app.Fragment
    @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        com.sensorsdata.analytics.android.autotrack.aop.FragmentTrackHelper.trackFragmentSetUserVisibleHint(this, z);
    }
}
