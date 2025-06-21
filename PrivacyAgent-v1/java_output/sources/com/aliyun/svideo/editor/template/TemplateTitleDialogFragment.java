package com.aliyun.svideo.editor.template;

/* loaded from: classes12.dex */
public class TemplateTitleDialogFragment extends androidx.fragment.app.DialogFragment {
    private com.aliyun.svideo.editor.template.TemplateTitleDialogFragment.OnTitleListener mOnTitleListener;

    /* renamed from: com.aliyun.svideo.editor.template.TemplateTitleDialogFragment$1, reason: invalid class name */
    public class AnonymousClass1 implements android.content.DialogInterface.OnClickListener {
        final /* synthetic */ android.widget.EditText val$titleEdt;

        public AnonymousClass1(android.widget.EditText editText) {
            this.val$titleEdt = editText;
        }

        @Override // android.content.DialogInterface.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public void onClick(android.content.DialogInterface dialogInterface, int i) {
            if (com.aliyun.svideo.editor.template.TemplateTitleDialogFragment.this.mOnTitleListener != null) {
                com.aliyun.svideo.editor.template.TemplateTitleDialogFragment.this.mOnTitleListener.onTitle(this.val$titleEdt.getText().toString());
            }
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackDialog(dialogInterface, i);
        }
    }

    public interface OnTitleListener {
        void onTitle(java.lang.String str);
    }

    @Override // androidx.fragment.app.DialogFragment
    @androidx.annotation.NonNull
    public android.app.Dialog onCreateDialog(android.os.Bundle bundle) {
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(getActivity());
        android.view.View inflate = getActivity().getLayoutInflater().inflate(com.aliyun.svideo.editor.R.layout.alivc_editor_template_title_config, (android.view.ViewGroup) null);
        builder.setView(inflate).setPositiveButton(com.aliyun.svideo.editor.R.string.alivc_svideo_menu_positive, new com.aliyun.svideo.editor.template.TemplateTitleDialogFragment.AnonymousClass1((android.widget.EditText) inflate.findViewById(com.aliyun.svideo.editor.R.id.alivc_template_title_edt))).setNegativeButton(com.aliyun.svideo.editor.R.string.alivc_svideo_menu_cancel, (android.content.DialogInterface.OnClickListener) null);
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

    public void setOnTitleListener(com.aliyun.svideo.editor.template.TemplateTitleDialogFragment.OnTitleListener onTitleListener) {
        this.mOnTitleListener = onTitleListener;
    }

    @Override // androidx.fragment.app.Fragment
    @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        com.sensorsdata.analytics.android.autotrack.aop.FragmentTrackHelper.trackFragmentSetUserVisibleHint(this, z);
    }
}
