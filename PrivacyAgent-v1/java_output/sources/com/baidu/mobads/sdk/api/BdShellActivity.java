package com.baidu.mobads.sdk.api;

/* loaded from: classes29.dex */
public class BdShellActivity extends android.app.Activity {
    private static boolean canShowWhenLock;
    private static com.baidu.mobads.sdk.api.BdShellActivity.ActionBarColorTheme mSActionBarColorTheme = com.baidu.mobads.sdk.api.BdShellActivity.ActionBarColorTheme.ACTION_BAR_WHITE_THEME;
    private com.baidu.mobads.sdk.internal.bt mAdLogger = com.baidu.mobads.sdk.internal.bt.a();
    private java.lang.ClassLoader mLoader;
    private com.baidu.mobads.sdk.api.IActivityImpl mProxyActivity;

    public static class ActionBarColorTheme implements java.io.Serializable {
        public int backgroundColor;
        public int closeColor;
        public int progressColor;
        public int titleColor;
        public static final com.baidu.mobads.sdk.api.BdShellActivity.ActionBarColorTheme ACTION_BAR_WHITE_THEME = new com.baidu.mobads.sdk.api.BdShellActivity.ActionBarColorTheme(-5987164, -6842473, -11113262, -328966);
        public static final com.baidu.mobads.sdk.api.BdShellActivity.ActionBarColorTheme ACTION_BAR_RED_THEME = new com.baidu.mobads.sdk.api.BdShellActivity.ActionBarColorTheme(-1, -1, -12510, -1294276);
        public static final com.baidu.mobads.sdk.api.BdShellActivity.ActionBarColorTheme ACTION_BAR_GREEN_THEME = new com.baidu.mobads.sdk.api.BdShellActivity.ActionBarColorTheme(-1, -1, -11113262, -14303071);
        public static final com.baidu.mobads.sdk.api.BdShellActivity.ActionBarColorTheme ACTION_BAR_NAVYBLUE_THEME = new com.baidu.mobads.sdk.api.BdShellActivity.ActionBarColorTheme(-1, -1, 16764706, -14210226);
        public static final com.baidu.mobads.sdk.api.BdShellActivity.ActionBarColorTheme ACTION_BAR_BLUE_THEME = new com.baidu.mobads.sdk.api.BdShellActivity.ActionBarColorTheme(-1, -1, -12510, -13870424);
        public static final com.baidu.mobads.sdk.api.BdShellActivity.ActionBarColorTheme ACTION_BAR_COFFEE_THEME = new com.baidu.mobads.sdk.api.BdShellActivity.ActionBarColorTheme(-1, -1, -12510, -11255230);
        public static final com.baidu.mobads.sdk.api.BdShellActivity.ActionBarColorTheme ACTION_BAR_BLACK_THEME = new com.baidu.mobads.sdk.api.BdShellActivity.ActionBarColorTheme(-1, -1, -12510, -13749450);

        public ActionBarColorTheme(int i, int i2, int i3, int i4) {
            this.closeColor = i;
            this.titleColor = i2;
            this.progressColor = i3;
            this.backgroundColor = i4;
        }

        public ActionBarColorTheme(com.baidu.mobads.sdk.api.BdShellActivity.ActionBarColorTheme actionBarColorTheme) {
            this.closeColor = actionBarColorTheme.closeColor;
            this.titleColor = actionBarColorTheme.titleColor;
            this.progressColor = actionBarColorTheme.progressColor;
            this.backgroundColor = actionBarColorTheme.backgroundColor;
        }

        public boolean equals(java.lang.Object obj) {
            com.baidu.mobads.sdk.api.BdShellActivity.ActionBarColorTheme actionBarColorTheme = (com.baidu.mobads.sdk.api.BdShellActivity.ActionBarColorTheme) obj;
            return this.backgroundColor == actionBarColorTheme.backgroundColor && this.titleColor == actionBarColorTheme.titleColor && this.closeColor == actionBarColorTheme.closeColor && this.progressColor == actionBarColorTheme.progressColor;
        }

        public int getBackgroundColor() {
            return this.backgroundColor;
        }

        public int getCloseColor() {
            return this.closeColor;
        }

        public int getProgressColor() {
            return this.progressColor;
        }

        public int getTitleColor() {
            return this.titleColor;
        }

        public void setBackgroundColor(int i) {
            this.backgroundColor = i;
        }

        public void setCloseColor(int i) {
            this.closeColor = i;
        }

        public void setProgressColor(int i) {
            this.progressColor = i;
        }

        public void setTitleColor(int i) {
            this.titleColor = i;
        }
    }

    public static void canLpShowWhenLocked(boolean z) {
        canShowWhenLock = z;
    }

    public static com.baidu.mobads.sdk.api.BdShellActivity.ActionBarColorTheme getActionBarColorTheme() {
        return mSActionBarColorTheme;
    }

    public static java.lang.Class<?> getActivityClass() {
        return com.baidu.mobads.sdk.api.BdShellActivity.class;
    }

    public static boolean getLpShowWhenLocked() {
        return canShowWhenLock;
    }

    public static void setActionBarColor(int i, int i2, int i3, int i4) {
        mSActionBarColorTheme = new com.baidu.mobads.sdk.api.BdShellActivity.ActionBarColorTheme(i, i2, i3, i4);
    }

    public static void setActionBarColorTheme(com.baidu.mobads.sdk.api.BdShellActivity.ActionBarColorTheme actionBarColorTheme) {
        if (actionBarColorTheme != null) {
            mSActionBarColorTheme = new com.baidu.mobads.sdk.api.BdShellActivity.ActionBarColorTheme(actionBarColorTheme);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(android.view.KeyEvent keyEvent) {
        com.baidu.mobads.sdk.api.IActivityImpl iActivityImpl = this.mProxyActivity;
        if (iActivityImpl != null ? iActivityImpl.dispatchKeyEvent(keyEvent) : false) {
            return true;
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(android.view.MotionEvent motionEvent) {
        com.baidu.mobads.sdk.api.IActivityImpl iActivityImpl = this.mProxyActivity;
        if (iActivityImpl != null ? iActivityImpl.dispatchTouchEvent(motionEvent) : false) {
            return true;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.app.Activity
    public void onActivityResult(int i, int i2, android.content.Intent intent) {
        com.baidu.mobads.sdk.api.IActivityImpl iActivityImpl = this.mProxyActivity;
        if (iActivityImpl != null) {
            iActivityImpl.onActivityResult(i, i2, intent);
        }
        super.onActivityResult(i, i2, intent);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.baidu.mobads.sdk.api.IActivityImpl iActivityImpl = this.mProxyActivity;
        if (iActivityImpl != null) {
            iActivityImpl.onAttachedToWindow();
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        com.baidu.mobads.sdk.api.IActivityImpl iActivityImpl = this.mProxyActivity;
        if (iActivityImpl != null) {
            iActivityImpl.onBackPressed();
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(android.content.res.Configuration configuration) {
        com.baidu.mobads.sdk.api.IActivityImpl iActivityImpl = this.mProxyActivity;
        if (iActivityImpl != null) {
            iActivityImpl.onConfigurationChanged(configuration);
        }
        super.onConfigurationChanged(configuration);
    }

    @Override // android.app.Activity
    public void onCreate(android.os.Bundle bundle) {
        java.lang.Class<?> a;
        super.onCreate(bundle);
        android.content.Intent intent = getIntent();
        try {
            java.lang.ClassLoader a2 = com.baidu.mobads.sdk.internal.bs.a(this);
            this.mLoader = a2;
            if (intent != null) {
                intent.setExtrasClassLoader(a2);
            }
            java.lang.String str = "";
            if (intent != null) {
                str = intent.getStringExtra("activityImplName");
                if ("Dialog".equals(intent.getStringExtra("theme"))) {
                    setTheme(com.baidu.mobads.proxy.R.style.bd_activity_dialog_theme);
                }
            }
            java.lang.Object obj = null;
            if (!android.text.TextUtils.isEmpty(str) && (a = com.baidu.mobads.sdk.internal.au.a(str, this.mLoader)) != null) {
                try {
                    obj = a.getConstructor(new java.lang.Class[0]).newInstance(new java.lang.Object[0]);
                } catch (java.lang.Throwable th) {
                    com.baidu.mobads.sdk.internal.bt.a().d(th);
                }
            }
            if (obj != null) {
                this.mProxyActivity = (com.baidu.mobads.sdk.api.IActivityImpl) obj;
            }
            if (this.mProxyActivity != null) {
                org.json.JSONObject jSONObject = new org.json.JSONObject();
                try {
                    jSONObject.put("bar_close_color", mSActionBarColorTheme.closeColor);
                    jSONObject.put("bar_pro_color", mSActionBarColorTheme.progressColor);
                    jSONObject.put("bar_title_color", mSActionBarColorTheme.titleColor);
                    jSONObject.put("bar_bg_color", mSActionBarColorTheme.backgroundColor);
                } catch (org.json.JSONException e) {
                    e.printStackTrace();
                }
                this.mProxyActivity.setLpBussParam(jSONObject);
                this.mProxyActivity.setActivity(this);
                if (intent != null) {
                    this.mProxyActivity.onCreate(bundle);
                }
            }
        } catch (java.lang.Exception e2) {
            com.baidu.mobads.sdk.internal.bt.a().c(e2);
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        com.baidu.mobads.sdk.api.IActivityImpl iActivityImpl = this.mProxyActivity;
        if (iActivityImpl != null) {
            iActivityImpl.onDestroy();
        }
        super.onDestroy();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.baidu.mobads.sdk.api.IActivityImpl iActivityImpl = this.mProxyActivity;
        if (iActivityImpl != null) {
            iActivityImpl.onDetachedFromWindow();
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, android.view.KeyEvent keyEvent) {
        com.baidu.mobads.sdk.api.IActivityImpl iActivityImpl = this.mProxyActivity;
        if (iActivityImpl != null ? iActivityImpl.onKeyDown(i, keyEvent) : false) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, android.view.KeyEvent keyEvent) {
        com.baidu.mobads.sdk.api.IActivityImpl iActivityImpl = this.mProxyActivity;
        if (iActivityImpl != null ? iActivityImpl.onKeyUp(i, keyEvent) : false) {
            return true;
        }
        return super.onKeyUp(i, keyEvent);
    }

    @Override // android.app.Activity
    public void onNewIntent(android.content.Intent intent) {
        com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper.onNewIntent(this, intent);
        com.baidu.mobads.sdk.api.IActivityImpl iActivityImpl = this.mProxyActivity;
        if (iActivityImpl != null) {
            iActivityImpl.onNewIntent(intent);
        }
        super.onNewIntent(intent);
    }

    @Override // android.app.Activity
    public void onPause() {
        com.baidu.mobads.sdk.api.IActivityImpl iActivityImpl = this.mProxyActivity;
        if (iActivityImpl != null) {
            iActivityImpl.onPause();
        }
        super.onPause();
    }

    @Override // android.app.Activity
    public void onRestoreInstanceState(android.os.Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        com.baidu.mobads.sdk.api.IActivityImpl iActivityImpl = this.mProxyActivity;
        if (iActivityImpl != null) {
            iActivityImpl.onRestoreInstanceState(bundle);
        }
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        com.baidu.mobads.sdk.api.IActivityImpl iActivityImpl = this.mProxyActivity;
        if (iActivityImpl != null) {
            iActivityImpl.onResume();
        }
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(android.os.Bundle bundle) {
        super.onSaveInstanceState(bundle);
        com.baidu.mobads.sdk.api.IActivityImpl iActivityImpl = this.mProxyActivity;
        if (iActivityImpl != null) {
            iActivityImpl.onSaveInstanceState(bundle);
        }
    }

    @Override // android.app.Activity
    public void onStart() {
        super.onStart();
        com.baidu.mobads.sdk.api.IActivityImpl iActivityImpl = this.mProxyActivity;
        if (iActivityImpl != null) {
            iActivityImpl.onStart();
        }
    }

    @Override // android.app.Activity
    public void onStop() {
        super.onStop();
        com.baidu.mobads.sdk.api.IActivityImpl iActivityImpl = this.mProxyActivity;
        if (iActivityImpl != null) {
            iActivityImpl.onStop();
        }
    }

    @Override // android.app.Activity
    public boolean onTouchEvent(android.view.MotionEvent motionEvent) {
        com.baidu.mobads.sdk.api.IActivityImpl iActivityImpl = this.mProxyActivity;
        if (iActivityImpl != null ? iActivityImpl.onTouchEvent(motionEvent) : false) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        com.baidu.mobads.sdk.api.IActivityImpl iActivityImpl = this.mProxyActivity;
        if (iActivityImpl != null) {
            iActivityImpl.onWindowFocusChanged(z);
        }
    }

    @Override // android.app.Activity
    public void overridePendingTransition(int i, int i2) {
        super.overridePendingTransition(i, i2);
        com.baidu.mobads.sdk.api.IActivityImpl iActivityImpl = this.mProxyActivity;
        if (iActivityImpl != null) {
            iActivityImpl.overridePendingTransition(i, i2);
        }
    }
}
