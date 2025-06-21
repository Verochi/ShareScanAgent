package com.alimm.tanx.core.ad.browser;

/* loaded from: classes.dex */
public abstract class tanxc_do extends androidx.appcompat.app.AppCompatActivity {
    private long tanxc_char;
    protected java.lang.String tanxc_do;
    private android.view.OrientationEventListener tanxc_else;
    protected android.widget.TextView tanxc_for;
    protected java.lang.String tanxc_if;
    protected android.widget.ProgressBar tanxc_int;
    private com.alimm.tanx.core.ad.view.WebMenuDialog tanxc_try;
    private final boolean tanxc_byte = true;
    protected final com.alimm.tanx.core.ad.browser.IAdWebViewCallback tanxc_new = new com.alimm.tanx.core.ad.browser.tanxc_do.AnonymousClass1();
    private boolean tanxc_case = false;
    private int tanxc_goto = -2;

    /* renamed from: com.alimm.tanx.core.ad.browser.tanxc_do$1, reason: invalid class name */
    public class AnonymousClass1 implements com.alimm.tanx.core.ad.browser.IAdWebViewCallback {
        public AnonymousClass1() {
        }

        @Override // com.alimm.tanx.core.ad.browser.IAdWebViewCallback
        public void onHideCustomView() {
            com.alimm.tanx.core.ad.browser.tanxc_do.this.tanxc_do(false);
            androidx.appcompat.app.ActionBar supportActionBar = com.alimm.tanx.core.ad.browser.tanxc_do.this.getSupportActionBar();
            if (supportActionBar != null) {
                supportActionBar.show();
            }
            com.alimm.tanx.core.ad.browser.tanxc_do tanxc_doVar = com.alimm.tanx.core.ad.browser.tanxc_do.this;
            if (tanxc_doVar != null) {
                tanxc_doVar.setRequestedOrientation(1);
            }
        }

        @Override // com.alimm.tanx.core.ad.browser.IAdWebViewCallback
        public void onShowCustomView(android.view.View view) {
            com.alimm.tanx.core.ad.browser.tanxc_do.this.tanxc_do(true);
            androidx.appcompat.app.ActionBar supportActionBar = com.alimm.tanx.core.ad.browser.tanxc_do.this.getSupportActionBar();
            if (supportActionBar != null) {
                supportActionBar.hide();
            }
            com.alimm.tanx.core.ad.browser.tanxc_do tanxc_doVar = com.alimm.tanx.core.ad.browser.tanxc_do.this;
            if (tanxc_doVar != null) {
                tanxc_doVar.setRequestedOrientation(10);
            }
        }

        @Override // com.alimm.tanx.core.ad.browser.IAdWebViewCallback
        public void onTitleLoaded(java.lang.String str) {
            android.widget.TextView textView = com.alimm.tanx.core.ad.browser.tanxc_do.this.tanxc_for;
            if (textView != null) {
                textView.setText(str);
            }
        }
    }

    /* renamed from: com.alimm.tanx.core.ad.browser.tanxc_do$2, reason: invalid class name */
    public class AnonymousClass2 implements com.alimm.tanx.core.ad.view.WebMenuDialog.MenuClick {
        public AnonymousClass2() {
        }

        @Override // com.alimm.tanx.core.ad.view.WebMenuDialog.MenuClick
        public void click(int i) {
            if (i == 1012) {
                com.alimm.tanx.core.ad.browser.tanxc_do.this.tanxc_new();
                return;
            }
            if (i != 1013) {
                if (i != 1016) {
                    return;
                }
                java.lang.String tanxc_int = com.alimm.tanx.core.ad.browser.tanxc_do.this.tanxc_int();
                if (android.text.TextUtils.isEmpty(tanxc_int)) {
                    return;
                }
                ((android.content.ClipboardManager) com.alimm.tanx.core.ad.browser.tanxc_do.this.getSystemService("clipboard")).setText(tanxc_int);
                return;
            }
            java.lang.String tanxc_int2 = com.alimm.tanx.core.ad.browser.tanxc_do.this.tanxc_int();
            if (android.text.TextUtils.isEmpty(tanxc_int2)) {
                return;
            }
            try {
                android.content.Intent intent = new android.content.Intent("android.intent.action.VIEW");
                intent.setData(android.net.Uri.parse(tanxc_int2));
                intent.setFlags(1610612740);
                com.alimm.tanx.core.ad.browser.tanxc_do.this.startActivity(intent);
            } catch (java.lang.Throwable th) {
                com.alimm.tanx.core.utils.LogUtils.d("BaseAdWebViewActivity", "showMenuDialog exception.", th);
            }
        }
    }

    /* renamed from: com.alimm.tanx.core.ad.browser.tanxc_do$3, reason: invalid class name */
    public class AnonymousClass3 extends android.view.OrientationEventListener {
        public AnonymousClass3(android.content.Context context) {
            super(context);
        }

        @Override // android.view.OrientationEventListener
        public void onOrientationChanged(int i) {
            com.alimm.tanx.core.ad.browser.tanxc_do tanxc_doVar;
            if (com.alimm.tanx.core.ad.browser.tanxc_do.this.tanxc_goto == -2) {
                com.alimm.tanx.core.ad.browser.tanxc_do.this.tanxc_goto = i;
            }
            int abs = java.lang.Math.abs(com.alimm.tanx.core.ad.browser.tanxc_do.this.tanxc_goto - i);
            if (abs > 180) {
                abs = 360 - abs;
            }
            if (abs <= 60 || (tanxc_doVar = com.alimm.tanx.core.ad.browser.tanxc_do.this) == null) {
                return;
            }
            tanxc_doVar.setRequestedOrientation(10);
            disable();
        }
    }

    /* renamed from: com.alimm.tanx.core.ad.browser.tanxc_do$4, reason: invalid class name */
    public class AnonymousClass4 implements java.lang.Runnable {
        public AnonymousClass4() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (com.alimm.tanx.core.ad.browser.tanxc_do.this.tanxc_else != null) {
                com.alimm.tanx.core.ad.browser.tanxc_do.this.tanxc_else.enable();
            }
        }
    }

    @android.annotation.TargetApi(19)
    private void tanxc_char() {
        android.view.Window window = getWindow();
        window.clearFlags(67108864);
        window.addFlags(Integer.MIN_VALUE);
        window.setStatusBarColor(androidx.core.view.ViewCompat.MEASURED_STATE_MASK);
    }

    private void tanxc_else() {
        if (this.tanxc_try == null) {
            java.util.ArrayList arrayList = new java.util.ArrayList();
            arrayList.add(com.alimm.tanx.core.ad.view.ActionMenu.refresh);
            arrayList.add(com.alimm.tanx.core.ad.view.ActionMenu.copy);
            arrayList.add(com.alimm.tanx.core.ad.view.ActionMenu.gotoweb);
            this.tanxc_try = new com.alimm.tanx.core.ad.view.WebMenuDialog(this, arrayList, new com.alimm.tanx.core.ad.browser.tanxc_do.AnonymousClass2());
        }
        try {
            this.tanxc_try.show();
        } catch (java.lang.Throwable th) {
            com.alimm.tanx.core.utils.LogUtils.d("BaseAdWebViewActivity", "showMenuDialog exception.", th);
        }
    }

    @Override // android.app.Activity
    public void finish() {
        if (isFinishing()) {
            return;
        }
        setResult(-1);
        super.finish();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(android.os.Bundle bundle) {
        int i;
        super.onCreate(bundle);
        setTheme(com.alimm.tanx.core.R.style.Theme_AdClick_NoActionBar);
        if (getIntent() == null) {
            com.alimm.tanx.core.utils.LogUtils.d("BaseAdWebViewActivity", "onCreate: intent is null.");
            com.alimm.tanx.core.utils.AdClickUtAnalytics.recordActivityCreateFail(null, "BaseAdWebViewActivity", "null_intent");
            finish();
            return;
        }
        android.os.Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.tanxc_if = extras.getString("url");
            com.alimm.tanx.core.utils.LogUtils.d("BaseAdWebViewActivity", "onCreate: mUrl == " + this.tanxc_if);
            i = extras.getInt(com.alimm.tanx.core.constant.AdClickConstants.FORCE_ORIENTATION, 1);
            this.tanxc_char = extras.getLong(com.alimm.tanx.core.constant.AdClickConstants.ACTIVITY_LAUNCH_TIME, 0L);
        } else {
            this.tanxc_if = getIntent().getDataString();
            com.alimm.tanx.core.utils.LogUtils.d("BaseAdWebViewActivity", "onCreate:getDataString  mUrl == " + this.tanxc_if);
            i = 1;
        }
        if (android.text.TextUtils.isEmpty(this.tanxc_if)) {
            com.alimm.tanx.core.utils.AdClickUtAnalytics.recordActivityCreateFail(null, "BaseAdWebViewActivity", "no_url");
            finish();
            return;
        }
        try {
            if (android.text.TextUtils.equals("1", android.net.Uri.parse(this.tanxc_if).getQueryParameter("hideRightMenu"))) {
                this.tanxc_case = true;
            }
        } catch (java.lang.Exception e) {
            com.alimm.tanx.core.utils.LogUtils.d("BaseAdWebViewActivity", "onCreate: parse url exception.", e);
        }
        this.tanxc_do = com.alimm.tanx.core.ad.interaction.tanxc_do.tanxc_do().tanxc_do(this.tanxc_if);
        com.alimm.tanx.core.utils.LogUtils.d("BaseAdWebViewActivity", "onCreate: mUrl = " + this.tanxc_if + ", lastUrl = " + this.tanxc_do + ", mHideRightMenu = " + this.tanxc_case);
        setContentView(tanxc_if());
        if (!tanxc_for()) {
            com.alimm.tanx.core.utils.LogUtils.d("BaseAdWebViewActivity", "onCreate: init view failed.");
        } else {
            tanxc_do(i);
            tanxc_char();
        }
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(android.view.Menu menu) {
        super.onCreateOptionsMenu(menu);
        androidx.appcompat.app.ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.show();
            supportActionBar.setDisplayShowHomeEnabled(false);
            supportActionBar.setDisplayHomeAsUpEnabled(true);
            supportActionBar.setHomeAsUpIndicator(com.alimm.tanx.core.R.drawable.tanx_browser_close_selector);
        }
        if (!this.tanxc_case) {
            com.alimm.tanx.core.utils.AdWebViewUtils.setShowAsAction(menu, com.alimm.tanx.core.ad.view.ActionMenu.more);
        }
        return true;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        com.alimm.tanx.core.utils.LogUtils.d("BaseAdWebViewActivity", "onDestroy: mUrl = " + this.tanxc_if);
        android.view.OrientationEventListener orientationEventListener = this.tanxc_else;
        if (orientationEventListener != null) {
            orientationEventListener.disable();
        }
        tanxc_case();
    }

    @Override // android.app.Activity
    @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
    public boolean onOptionsItemSelected(android.view.MenuItem menuItem) {
        if (menuItem.getItemId() == com.alimm.tanx.core.ad.view.ActionMenu.more.id) {
            tanxc_else();
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackMenuItem(this, menuItem);
            return true;
        }
        if (menuItem.getItemId() != 16908332) {
            boolean onOptionsItemSelected = super.onOptionsItemSelected(menuItem);
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackMenuItem(this, menuItem);
            return onOptionsItemSelected;
        }
        tanxc_case();
        finish();
        com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackMenuItem(this, menuItem);
        return true;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        com.alimm.tanx.core.utils.LogUtils.d("BaseAdWebViewActivity", "onResume: mUrl = " + this.tanxc_if);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        com.alimm.tanx.core.utils.LogUtils.d("BaseAdWebViewActivity", "onStart: mUrl = " + this.tanxc_if);
        tanxc_try();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        com.alimm.tanx.core.utils.LogUtils.d("BaseAdWebViewActivity", "onStop: mUrl = " + this.tanxc_if + ", mWebMenuDialog = " + this.tanxc_try);
        tanxc_byte();
        com.alimm.tanx.core.ad.view.WebMenuDialog webMenuDialog = this.tanxc_try;
        if (webMenuDialog == null || !webMenuDialog.isShowing()) {
            return;
        }
        com.alimm.tanx.core.utils.LogUtils.d("BaseAdWebViewActivity", "onStop: destroy dialog.");
        this.tanxc_try.dismiss();
        this.tanxc_try = null;
    }

    public abstract void tanxc_byte();

    public abstract void tanxc_case();

    public void tanxc_do() {
        android.widget.ProgressBar progressBar = (android.widget.ProgressBar) findViewById(com.alimm.tanx.core.R.id.tanx_browser_progress);
        this.tanxc_int = progressBar;
        progressBar.setVisibility(8);
        try {
            setSupportActionBar((androidx.appcompat.widget.Toolbar) findViewById(com.alimm.tanx.core.R.id.tanx_browser_toolbar));
            androidx.appcompat.app.ActionBar supportActionBar = getSupportActionBar();
            if (supportActionBar != null) {
                supportActionBar.setBackgroundDrawable(getResources().getDrawable(com.alimm.tanx.core.R.drawable.tanx_browser_actionbar_bg));
                supportActionBar.setDisplayShowCustomEnabled(true);
                supportActionBar.setCustomView(android.view.View.inflate(this, com.alimm.tanx.core.R.layout.tanx_layout_browser_title, null));
                this.tanxc_for = (android.widget.TextView) findViewById(com.alimm.tanx.core.R.id.tanx_browser_custom_title);
            }
        } catch (java.lang.Exception e) {
            com.alimm.tanx.core.utils.LogUtils.d("BaseAdWebViewActivity", "setToolbar exception.", e);
        }
    }

    public void tanxc_do(int i) {
        if (i != 1) {
            setRequestedOrientation(i);
            this.tanxc_else = new com.alimm.tanx.core.ad.browser.tanxc_do.AnonymousClass3(this);
            new android.os.Handler().postDelayed(new com.alimm.tanx.core.ad.browser.tanxc_do.AnonymousClass4(), 2000L);
        }
    }

    public void tanxc_do(boolean z) {
        getWindow().setFlags(z ? 1024 : 0, 1024);
    }

    public abstract boolean tanxc_for();

    public abstract int tanxc_if();

    public abstract java.lang.String tanxc_int();

    public abstract void tanxc_new();

    public abstract void tanxc_try();
}
