package com.aliyun.svideo.editor.draft;

/* loaded from: classes12.dex */
public class DraftRenameDialogFragment extends androidx.fragment.app.DialogFragment {
    private java.lang.String mDraftName;
    private com.aliyun.svideo.editor.draft.DraftRenameDialogFragment.OnRenameListener mOnRenameListener;

    /* renamed from: com.aliyun.svideo.editor.draft.DraftRenameDialogFragment$1, reason: invalid class name */
    public class AnonymousClass1 implements android.content.DialogInterface.OnClickListener {
        final /* synthetic */ android.widget.EditText val$editText;

        public AnonymousClass1(android.widget.EditText editText) {
            this.val$editText = editText;
        }

        @Override // android.content.DialogInterface.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public void onClick(android.content.DialogInterface dialogInterface, int i) {
            if (com.aliyun.svideo.editor.draft.DraftRenameDialogFragment.this.mOnRenameListener != null) {
                com.aliyun.svideo.editor.draft.DraftRenameDialogFragment.this.mOnRenameListener.onRename(this.val$editText.getText().toString());
            }
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackDialog(dialogInterface, i);
        }
    }

    public interface OnRenameListener {
        void onRename(java.lang.String str);
    }

    @Override // androidx.fragment.app.DialogFragment
    @androidx.annotation.NonNull
    public android.app.Dialog onCreateDialog(android.os.Bundle bundle) {
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(getActivity());
        android.view.View inflate = getActivity().getLayoutInflater().inflate(com.aliyun.svideo.editor.R.layout.alivc_editor_draft_rename_dialog, (android.view.ViewGroup) null);
        android.widget.EditText editText = (android.widget.EditText) inflate.findViewById(com.aliyun.svideo.editor.R.id.alivc_draft_rename_edit);
        editText.setText(this.mDraftName);
        builder.setView(inflate).setPositiveButton("确定", new com.aliyun.svideo.editor.draft.DraftRenameDialogFragment.AnonymousClass1(editText)).setNegativeButton("取消", (android.content.DialogInterface.OnClickListener) null);
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

    public void setDraftName(java.lang.String str) {
        this.mDraftName = str;
    }

    public void setOnRenameListener(com.aliyun.svideo.editor.draft.DraftRenameDialogFragment.OnRenameListener onRenameListener) {
        this.mOnRenameListener = onRenameListener;
    }

    @Override // androidx.fragment.app.Fragment
    @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        com.sensorsdata.analytics.android.autotrack.aop.FragmentTrackHelper.trackFragmentSetUserVisibleHint(this, z);
    }
}
