package com.aliyun.svideo.editor.effects.overlay;

/* loaded from: classes12.dex */
public class PasterPreviewDialog extends androidx.fragment.app.DialogFragment {
    private static final java.lang.String KEY_ID = "id";
    private static final java.lang.String KEY_NAME = "name";
    private static final java.lang.String KEY_URL = "url";
    private static boolean isShow;

    /* renamed from: com.aliyun.svideo.editor.effects.overlay.PasterPreviewDialog$1, reason: invalid class name */
    public class AnonymousClass1 implements android.view.View.OnClickListener {
        public AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public void onClick(android.view.View view) {
            com.aliyun.svideo.editor.effects.overlay.PasterPreviewDialog.this.dismiss();
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static com.aliyun.svideo.editor.effects.overlay.PasterPreviewDialog newInstance(java.lang.String str, java.lang.String str2, int i) {
        if (isShow) {
            return null;
        }
        isShow = true;
        com.aliyun.svideo.editor.effects.overlay.PasterPreviewDialog pasterPreviewDialog = new com.aliyun.svideo.editor.effects.overlay.PasterPreviewDialog();
        android.os.Bundle bundle = new android.os.Bundle();
        bundle.putString("url", str);
        bundle.putString("name", str2);
        bundle.putInt("id", i);
        pasterPreviewDialog.setArguments(bundle);
        return pasterPreviewDialog;
    }

    @Override // androidx.fragment.app.DialogFragment
    public void dismiss() {
        super.dismiss();
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(android.os.Bundle bundle) {
        super.onActivityCreated(bundle);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(android.os.Bundle bundle) {
        super.onCreate(bundle);
        setStyle(2, com.aliyun.svideo.editor.R.style.ResourcePreviewStyle);
    }

    @Override // androidx.fragment.app.DialogFragment
    public android.app.Dialog onCreateDialog(android.os.Bundle bundle) {
        android.app.Dialog onCreateDialog = super.onCreateDialog(bundle);
        onCreateDialog.setCanceledOnTouchOutside(true);
        onCreateDialog.setCancelable(true);
        return onCreateDialog;
    }

    @Override // androidx.fragment.app.Fragment
    public android.view.View onCreateView(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, android.os.Bundle bundle) {
        android.view.View inflate = android.view.LayoutInflater.from(getActivity()).inflate(com.aliyun.svideo.editor.R.layout.alivc_editor_dialog_paster_preview, viewGroup);
        android.webkit.WebView webView = (android.webkit.WebView) inflate.findViewById(com.aliyun.svideo.editor.R.id.webview);
        android.view.View findViewById = inflate.findViewById(com.aliyun.svideo.editor.R.id.close);
        webView.setBackgroundColor(getResources().getColor(android.R.color.black));
        webView.getSettings().setLayoutAlgorithm(android.webkit.WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
        if (android.os.Build.VERSION.SDK_INT > 21) {
            webView.getSettings().setMixedContentMode(2);
        }
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setBlockNetworkImage(false);
        java.lang.String string = getArguments().getString("url");
        com.sensorsdata.analytics.android.sdk.jsbridge.JSHookAop.loadUrl(webView, string);
        webView.loadUrl(string);
        findViewById.setOnClickListener(new com.aliyun.svideo.editor.effects.overlay.PasterPreviewDialog.AnonymousClass1());
        setCancelable(true);
        return inflate;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(android.content.DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        isShow = false;
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
        getDialog().getWindow().setLayout(-1, -1);
        super.onResume();
        com.sensorsdata.analytics.android.autotrack.aop.FragmentTrackHelper.trackFragmentResume(this);
    }

    @Override // androidx.fragment.app.Fragment
    @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
    public void onViewCreated(android.view.View view, android.os.Bundle bundle) {
        super.onViewCreated(view, bundle);
        com.sensorsdata.analytics.android.autotrack.aop.FragmentTrackHelper.onFragmentViewCreated(this, view, bundle);
    }

    @Override // androidx.fragment.app.Fragment
    @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        com.sensorsdata.analytics.android.autotrack.aop.FragmentTrackHelper.trackFragmentSetUserVisibleHint(this, z);
    }
}
