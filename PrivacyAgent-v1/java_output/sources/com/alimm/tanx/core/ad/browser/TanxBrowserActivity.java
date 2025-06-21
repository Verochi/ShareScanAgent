package com.alimm.tanx.core.ad.browser;

/* loaded from: classes29.dex */
public class TanxBrowserActivity extends com.alimm.tanx.core.ad.browser.tanxc_do {
    private static com.alimm.tanx.core.bridge.JsBridgeBean tanxc_byte;
    private com.alimm.tanx.core.ad.browser.TanxBrowserContainer tanxc_try;

    public static void tanxc_do(android.content.Context context, java.lang.String str, com.alimm.tanx.core.bridge.JsBridgeBean jsBridgeBean) {
        tanxc_byte = jsBridgeBean;
        android.content.Intent intent = new android.content.Intent();
        intent.setClass(context, com.alimm.tanx.core.ad.browser.TanxBrowserActivity.class);
        intent.putExtra("url", str);
        intent.addFlags(268435456);
        context.startActivity(intent);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        com.alimm.tanx.core.ad.browser.TanxBrowserContainer tanxBrowserContainer = this.tanxc_try;
        if (tanxBrowserContainer == null || tanxBrowserContainer.tanxc_byte()) {
            return;
        }
        super.onBackPressed();
    }

    @Override // com.alimm.tanx.core.ad.browser.tanxc_do
    public void tanxc_byte() {
        com.alimm.tanx.core.ad.browser.TanxBrowserContainer tanxBrowserContainer = this.tanxc_try;
        if (tanxBrowserContainer != null) {
            tanxBrowserContainer.tanxc_int();
        }
    }

    @Override // com.alimm.tanx.core.ad.browser.tanxc_do
    public void tanxc_case() {
        com.alimm.tanx.core.ad.browser.TanxBrowserContainer tanxBrowserContainer = this.tanxc_try;
        if (tanxBrowserContainer != null) {
            tanxBrowserContainer.tanxc_try();
        }
    }

    @Override // com.alimm.tanx.core.ad.browser.tanxc_do
    public boolean tanxc_for() {
        try {
            com.alimm.tanx.core.ad.browser.TanxBrowserContainer tanxBrowserContainer = (com.alimm.tanx.core.ad.browser.TanxBrowserContainer) findViewById(com.alimm.tanx.core.R.id.xadclick_webview_container);
            this.tanxc_try = tanxBrowserContainer;
            tanxBrowserContainer.tanxc_do(this.tanxc_if, tanxc_byte, null, null);
            if (this.tanxc_try.tanxc_do()) {
                this.tanxc_try.tanxc_do(this.tanxc_int);
                this.tanxc_try.tanxc_do(this.tanxc_new);
                tanxc_do();
                return true;
            }
            com.alimm.tanx.core.utils.LogUtils.i("AdSystemWebViewActivity", "initView: failed to create WebView.");
            com.alimm.tanx.core.utils.AdClickUtAnalytics.recordActivityCreateFail(null, "AdSystemWebViewActivity", "webview_init_fail");
            finish();
            return false;
        } catch (java.lang.Exception e) {
            com.alimm.tanx.core.utils.LogUtils.e("AdSystemWebViewActivity", e);
            finish();
            com.alimm.tanx.core.ut.impl.TanxBaseUt.utError(1, "AdSystemWebViewActivity", e, "");
            return false;
        }
    }

    @Override // com.alimm.tanx.core.ad.browser.tanxc_do
    public int tanxc_if() {
        return com.alimm.tanx.core.R.layout.tanx_layout_activity_browser;
    }

    @Override // com.alimm.tanx.core.ad.browser.tanxc_do
    public java.lang.String tanxc_int() {
        com.alimm.tanx.core.ad.browser.TanxBrowserContainer tanxBrowserContainer = this.tanxc_try;
        return tanxBrowserContainer != null ? tanxBrowserContainer.tanxc_if() : "";
    }

    @Override // com.alimm.tanx.core.ad.browser.tanxc_do
    public void tanxc_new() {
        com.alimm.tanx.core.ad.browser.TanxBrowserContainer tanxBrowserContainer = this.tanxc_try;
        if (tanxBrowserContainer != null) {
            tanxBrowserContainer.tanxc_for();
        }
    }

    @Override // com.alimm.tanx.core.ad.browser.tanxc_do
    public void tanxc_try() {
        com.alimm.tanx.core.ad.browser.TanxBrowserContainer tanxBrowserContainer = this.tanxc_try;
        if (tanxBrowserContainer != null) {
            tanxBrowserContainer.tanxc_new();
        }
    }
}
