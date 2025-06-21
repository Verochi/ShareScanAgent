package com.baidu.mobads.sdk.api;

/* loaded from: classes29.dex */
public class AppActivity extends android.app.Activity {
    private static android.app.Activity activity;
    public static java.lang.String activityName;
    private static boolean canShowWhenLock;
    private java.lang.ClassLoader mLoader;
    private com.baidu.mobads.sdk.api.IActivityImpl mProxyActivity;
    private static com.baidu.mobads.sdk.api.ActionBarColorTheme mSActionBarColorTheme = com.baidu.mobads.sdk.api.ActionBarColorTheme.ACTION_BAR_WHITE_THEME;
    private static boolean mIsShowActionBarTitle = true;

    public static void canLpShowWhenLocked(boolean z) {
        canShowWhenLock = z;
    }

    public static android.app.Activity getActivity() {
        return activity;
    }

    public static java.lang.Class<?> getActivityClass() {
        if (!android.text.TextUtils.isEmpty(activityName)) {
            try {
                return java.lang.Class.forName(activityName);
            } catch (java.lang.Exception e) {
                com.baidu.mobads.sdk.internal.bt.a().c(e);
            }
        }
        return com.baidu.mobads.sdk.api.AppActivity.class;
    }

    public static boolean getLpShowWhenLocked() {
        return canShowWhenLock;
    }

    public static boolean isAnti() {
        return !android.text.TextUtils.isEmpty(activityName);
    }

    public static void setActionBarColorTheme(com.baidu.mobads.sdk.api.ActionBarColorTheme actionBarColorTheme) {
        if (actionBarColorTheme != null) {
            mSActionBarColorTheme = actionBarColorTheme;
        }
    }

    public static void setActivityName(java.lang.String str) {
        activityName = str;
    }

    public static void setIsShowActionBarTitle(boolean z) {
        mIsShowActionBarTitle = z;
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
        activity = this;
        super.onCreate(bundle);
        android.content.Intent intent = getIntent();
        try {
            java.lang.ClassLoader a2 = com.baidu.mobads.sdk.internal.bs.a(this);
            this.mLoader = a2;
            if (intent != null) {
                intent.setExtrasClassLoader(a2);
            }
            java.lang.String stringExtra = intent != null ? intent.getStringExtra("activityImplName") : "";
            java.lang.Object obj = null;
            if (!android.text.TextUtils.isEmpty(stringExtra) && (a = com.baidu.mobads.sdk.internal.au.a(stringExtra, this.mLoader)) != null) {
                try {
                    obj = a.getConstructor(new java.lang.Class[0]).newInstance(new java.lang.Object[0]);
                } catch (java.lang.Throwable th) {
                    th.printStackTrace();
                }
            }
            if (obj != null) {
                this.mProxyActivity = (com.baidu.mobads.sdk.api.IActivityImpl) obj;
            }
            if (this.mProxyActivity != null) {
                org.json.JSONObject jSONObject = new org.json.JSONObject();
                try {
                    jSONObject.put("bar_close_color", mSActionBarColorTheme.mCloseColor);
                    jSONObject.put("bar_pro_color", mSActionBarColorTheme.mProgressColor);
                    jSONObject.put("bar_title_color", mSActionBarColorTheme.mTitleColor);
                    jSONObject.put("bar_bg_color", mSActionBarColorTheme.mBackgroundColor);
                    jSONObject.put("showWhenLocked", canShowWhenLock);
                    jSONObject.put("isShowActionBarTit", mIsShowActionBarTitle);
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
        activity = null;
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
