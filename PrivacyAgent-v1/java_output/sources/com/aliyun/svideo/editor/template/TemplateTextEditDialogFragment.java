package com.aliyun.svideo.editor.template;

/* loaded from: classes12.dex */
public class TemplateTextEditDialogFragment extends androidx.fragment.app.DialogFragment {
    private com.aliyun.svideo.editor.template.BackEditText mEdtInput;
    private com.aliyun.svideo.editor.template.TemplateTextEditDialogFragment.OnResultListener mOnResultListener;
    private android.view.View mRootView;
    private java.lang.String mText;
    private android.widget.TextView mTvFinish;
    private android.widget.TextView mTvShow;

    /* renamed from: com.aliyun.svideo.editor.template.TemplateTextEditDialogFragment$1, reason: invalid class name */
    public class AnonymousClass1 implements android.view.View.OnClickListener {
        public AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public void onClick(android.view.View view) {
            com.aliyun.svideo.editor.template.TemplateTextEditDialogFragment.this.dismiss();
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* renamed from: com.aliyun.svideo.editor.template.TemplateTextEditDialogFragment$2, reason: invalid class name */
    public class AnonymousClass2 implements android.text.TextWatcher {
        public AnonymousClass2() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(android.text.Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(java.lang.CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(java.lang.CharSequence charSequence, int i, int i2, int i3) {
            com.aliyun.svideo.editor.template.TemplateTextEditDialogFragment.this.mText = charSequence.toString();
            com.aliyun.svideo.editor.template.TemplateTextEditDialogFragment.this.mTvShow.setText(com.aliyun.svideo.editor.template.TemplateTextEditDialogFragment.this.mText);
        }
    }

    /* renamed from: com.aliyun.svideo.editor.template.TemplateTextEditDialogFragment$3, reason: invalid class name */
    public class AnonymousClass3 implements com.aliyun.svideo.editor.template.BackEditText.OnKeyBoardHideListener {
        public AnonymousClass3() {
        }

        @Override // com.aliyun.svideo.editor.template.BackEditText.OnKeyBoardHideListener
        public void onKeyHide() {
            com.aliyun.svideo.editor.template.TemplateTextEditDialogFragment.this.dismiss();
        }
    }

    /* renamed from: com.aliyun.svideo.editor.template.TemplateTextEditDialogFragment$4, reason: invalid class name */
    public class AnonymousClass4 implements android.view.View.OnClickListener {
        public AnonymousClass4() {
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public void onClick(android.view.View view) {
            if (com.aliyun.svideo.editor.template.TemplateTextEditDialogFragment.this.mOnResultListener != null) {
                com.aliyun.svideo.editor.template.TemplateTextEditDialogFragment.this.mOnResultListener.onResult(com.aliyun.svideo.editor.template.TemplateTextEditDialogFragment.this.mText);
            }
            com.aliyun.svideo.editor.template.TemplateTextEditDialogFragment.this.dismiss();
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public interface OnResultListener {
        void onResult(java.lang.String str);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(@androidx.annotation.Nullable android.os.Bundle bundle) {
        super.onCreate(bundle);
        setStyle(1, com.aliyun.svideo.editor.R.style.DialogFullScreen);
    }

    @Override // androidx.fragment.app.DialogFragment
    @androidx.annotation.NonNull
    public android.app.Dialog onCreateDialog(android.os.Bundle bundle) {
        android.app.Dialog onCreateDialog = super.onCreateDialog(bundle);
        onCreateDialog.getWindow().setSoftInputMode(21);
        return onCreateDialog;
    }

    @Override // androidx.fragment.app.Fragment
    @androidx.annotation.Nullable
    public android.view.View onCreateView(android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, @androidx.annotation.Nullable android.os.Bundle bundle) {
        android.view.View inflate = layoutInflater.inflate(com.aliyun.svideo.editor.R.layout.alivc_editor_template_text_edit, (android.view.ViewGroup) null);
        this.mRootView = inflate;
        android.widget.TextView textView = (android.widget.TextView) inflate.findViewById(com.aliyun.svideo.editor.R.id.tv_text_show);
        this.mTvShow = textView;
        textView.setText(this.mText);
        this.mTvShow.setOnClickListener(new com.aliyun.svideo.editor.template.TemplateTextEditDialogFragment.AnonymousClass1());
        com.aliyun.svideo.editor.template.BackEditText backEditText = (com.aliyun.svideo.editor.template.BackEditText) this.mRootView.findViewById(com.aliyun.svideo.editor.R.id.edt_text_input);
        this.mEdtInput = backEditText;
        backEditText.setText(this.mText);
        this.mEdtInput.addTextChangedListener(new com.aliyun.svideo.editor.template.TemplateTextEditDialogFragment.AnonymousClass2());
        this.mEdtInput.setOnKeyBoardHideListener(new com.aliyun.svideo.editor.template.TemplateTextEditDialogFragment.AnonymousClass3());
        this.mEdtInput.requestFocus();
        android.widget.TextView textView2 = (android.widget.TextView) this.mRootView.findViewById(com.aliyun.svideo.editor.R.id.tv_finish);
        this.mTvFinish = textView2;
        textView2.setOnClickListener(new com.aliyun.svideo.editor.template.TemplateTextEditDialogFragment.AnonymousClass4());
        return this.mRootView;
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

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        getDialog().getWindow().setLayout(-1, -1);
    }

    @Override // androidx.fragment.app.Fragment
    @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
    public void onViewCreated(android.view.View view, android.os.Bundle bundle) {
        super.onViewCreated(view, bundle);
        com.sensorsdata.analytics.android.autotrack.aop.FragmentTrackHelper.onFragmentViewCreated(this, view, bundle);
    }

    public void setOnResultListener(com.aliyun.svideo.editor.template.TemplateTextEditDialogFragment.OnResultListener onResultListener) {
        this.mOnResultListener = onResultListener;
    }

    public void setText(java.lang.String str) {
        this.mText = str;
    }

    @Override // androidx.fragment.app.Fragment
    @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        com.sensorsdata.analytics.android.autotrack.aop.FragmentTrackHelper.trackFragmentSetUserVisibleHint(this, z);
    }
}
