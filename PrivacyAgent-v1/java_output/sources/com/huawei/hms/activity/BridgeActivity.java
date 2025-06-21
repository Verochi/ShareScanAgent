package com.huawei.hms.activity;

/* loaded from: classes30.dex */
public class BridgeActivity extends android.app.Activity {
    public static final java.lang.String EXTRA_DELEGATE_CLASS_NAME = "intent.extra.DELEGATE_CLASS_OBJECT";
    public static final java.lang.String EXTRA_DELEGATE_UPDATE_INFO = "intent.extra.update.info";
    public static final java.lang.String EXTRA_INTENT = "intent.extra.intent";
    public static final java.lang.String EXTRA_IS_FULLSCREEN = "intent.extra.isfullscreen";
    public static final java.lang.String EXTRA_RESULT = "intent.extra.RESULT";
    public static final int b = a("ro.build.hw_emui_api_level", 0);
    public com.huawei.hms.activity.IBridgeActivityDelegate a;

    public class a implements android.view.View.OnApplyWindowInsetsListener {
        public final /* synthetic */ android.view.ViewGroup a;

        public a(com.huawei.hms.activity.BridgeActivity bridgeActivity, android.view.ViewGroup viewGroup) {
            this.a = viewGroup;
        }

        @Override // android.view.View.OnApplyWindowInsetsListener
        public android.view.WindowInsets onApplyWindowInsets(android.view.View view, android.view.WindowInsets windowInsets) {
            try {
                java.lang.Object invoke = java.lang.Class.forName("com.huawei.android.view.WindowManagerEx$LayoutParamsEx").getMethod("getDisplaySideRegion", android.view.WindowInsets.class).invoke(null, windowInsets);
                if (invoke == null) {
                    com.huawei.hms.support.log.HMSLog.i("BridgeActivity", "sideRegion is null");
                } else {
                    android.graphics.Rect rect = (android.graphics.Rect) java.lang.Class.forName("com.huawei.android.view.DisplaySideRegionEx").getMethod("getSafeInsets", new java.lang.Class[0]).invoke(invoke, new java.lang.Object[0]);
                    android.view.ViewGroup viewGroup = this.a;
                    if (viewGroup != null) {
                        viewGroup.setPadding(rect.left, 0, rect.right, 0);
                    }
                }
            } catch (java.lang.ClassNotFoundException | java.lang.IllegalAccessException | java.lang.NoSuchMethodException | java.lang.reflect.InvocationTargetException e) {
                com.huawei.hms.support.log.HMSLog.e("BridgeActivity", "An exception occurred while reading: onApplyWindowInsets" + e.getMessage());
            }
            return view.onApplyWindowInsets(windowInsets);
        }
    }

    public static int a(java.lang.String str, int i) {
        try {
            java.lang.Class<?> cls = java.lang.Class.forName("android.os.SystemProperties");
            return ((java.lang.Integer) cls.getDeclaredMethod("getInt", java.lang.String.class, java.lang.Integer.TYPE).invoke(cls, str, java.lang.Integer.valueOf(i))).intValue();
        } catch (java.lang.ClassCastException | java.lang.ClassNotFoundException | java.lang.IllegalAccessException | java.lang.IllegalArgumentException | java.lang.NoSuchMethodException | java.lang.reflect.InvocationTargetException unused) {
            com.huawei.hms.support.log.HMSLog.e("BridgeActivity", "An exception occurred while reading: EMUI_SDK_INT");
            return i;
        }
    }

    public static void a(android.view.Window window, boolean z) {
        try {
            window.getClass().getMethod("setHwFloating", java.lang.Boolean.TYPE).invoke(window, java.lang.Boolean.valueOf(z));
        } catch (java.lang.IllegalAccessException | java.lang.IllegalArgumentException | java.lang.NoSuchMethodException | java.lang.reflect.InvocationTargetException e) {
            com.huawei.hms.support.log.HMSLog.e("BridgeActivity", "In setHwFloating, Failed to call Window.setHwFloating()." + e.getMessage());
        }
    }

    public static android.content.Intent getIntentStartBridgeActivity(android.app.Activity activity, java.lang.String str) {
        android.content.Intent intent = new android.content.Intent(activity, (java.lang.Class<?>) com.huawei.hms.activity.BridgeActivity.class);
        intent.putExtra(EXTRA_DELEGATE_CLASS_NAME, str);
        intent.putExtra(EXTRA_IS_FULLSCREEN, com.huawei.hms.utils.UIUtil.isActivityFullscreen(activity));
        return intent;
    }

    public static android.content.Intent getIntentStartBridgeActivity(android.content.Context context, java.lang.String str) {
        android.content.Intent intent = new android.content.Intent(context, (java.lang.Class<?>) com.huawei.hms.activity.BridgeActivity.class);
        intent.putExtra(EXTRA_DELEGATE_CLASS_NAME, str);
        intent.putExtra(EXTRA_IS_FULLSCREEN, false);
        return intent;
    }

    public static void setFullScreenWindowLayoutInDisplayCutout(android.view.Window window) {
        if (window == null) {
            return;
        }
        if (android.os.Build.VERSION.SDK_INT >= 28) {
            android.view.WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.layoutInDisplayCutoutMode = 1;
            window.setAttributes(attributes);
            window.getDecorView().setSystemUiVisibility(1280);
            return;
        }
        android.view.WindowManager.LayoutParams attributes2 = window.getAttributes();
        try {
            java.lang.Class<?> cls = java.lang.Class.forName("com.huawei.android.view.LayoutParamsEx");
            cls.getMethod("addHwFlags", java.lang.Integer.TYPE).invoke(cls.getConstructor(android.view.WindowManager.LayoutParams.class).newInstance(attributes2), 65536);
        } catch (java.lang.ClassCastException | java.lang.ClassNotFoundException | java.lang.IllegalAccessException | java.lang.IllegalArgumentException | java.lang.InstantiationException | java.lang.NoSuchMethodException | java.lang.reflect.InvocationTargetException unused) {
            com.huawei.hms.support.log.HMSLog.e("BridgeActivity", "com.huawei.android.view.LayoutParamsEx fail");
        }
    }

    public final void a() {
        android.view.View findViewById = getWindow().findViewById(android.R.id.content);
        if (findViewById == null || !(findViewById instanceof android.view.ViewGroup)) {
            com.huawei.hms.support.log.HMSLog.e("BridgeActivity", "rootView is null or not ViewGroup");
            return;
        }
        android.view.ViewGroup viewGroup = (android.view.ViewGroup) findViewById;
        android.view.WindowManager.LayoutParams attributes = getWindow().getAttributes();
        try {
            java.lang.Class<?> cls = java.lang.Class.forName("com.huawei.android.view.WindowManagerEx$LayoutParamsEx");
            cls.getMethod("setDisplaySideMode", java.lang.Integer.TYPE).invoke(cls.getDeclaredConstructor(android.view.WindowManager.LayoutParams.class).newInstance(attributes), 1);
        } catch (java.lang.ClassCastException | java.lang.ClassNotFoundException | java.lang.IllegalAccessException | java.lang.InstantiationException | java.lang.NoSuchMethodException | java.lang.reflect.InvocationTargetException e) {
            com.huawei.hms.support.log.HMSLog.e("BridgeActivity", "An exception occurred while reading: setDisplaySideMode" + e.getMessage());
        }
        getWindow().getDecorView().setOnApplyWindowInsetsListener(new com.huawei.hms.activity.BridgeActivity.a(this, viewGroup));
    }

    public final boolean b() {
        android.content.Intent intent = getIntent();
        if (intent == null) {
            com.huawei.hms.support.log.HMSLog.e("BridgeActivity", "In initialize, Must not pass in a null intent.");
            return false;
        }
        if (intent.getBooleanExtra(EXTRA_IS_FULLSCREEN, false)) {
            getWindow().setFlags(1024, 1024);
        }
        java.lang.String stringExtra = intent.getStringExtra(EXTRA_DELEGATE_CLASS_NAME);
        if (stringExtra == null) {
            com.huawei.hms.support.log.HMSLog.e("BridgeActivity", "In initialize, Must not pass in a null or non class object.");
            return false;
        }
        try {
            com.huawei.hms.activity.IBridgeActivityDelegate iBridgeActivityDelegate = (com.huawei.hms.activity.IBridgeActivityDelegate) java.lang.Class.forName(stringExtra).asSubclass(com.huawei.hms.activity.IBridgeActivityDelegate.class).newInstance();
            this.a = iBridgeActivityDelegate;
            try {
                iBridgeActivityDelegate.onBridgeActivityCreate(this);
                return true;
            } catch (java.lang.RuntimeException e) {
                com.huawei.hms.support.log.HMSLog.e("BridgeActivity", "Run time Exception." + e.getMessage());
                return false;
            }
        } catch (java.lang.ClassCastException | java.lang.ClassNotFoundException | java.lang.IllegalAccessException | java.lang.InstantiationException e2) {
            com.huawei.hms.support.log.HMSLog.e("BridgeActivity", "In initialize, Failed to create 'IUpdateWizard' instance." + e2.getMessage());
            return false;
        }
    }

    public final void c() {
        try {
            requestWindowFeature(1);
        } catch (java.lang.Exception e) {
            com.huawei.hms.support.log.HMSLog.w("BridgeActivity", "requestWindowFeature " + e.getMessage());
        }
        android.view.Window window = getWindow();
        if (b >= 9) {
            window.addFlags(67108864);
            a(window, true);
        }
        window.getDecorView().setSystemUiVisibility(0);
    }

    @Override // android.app.Activity
    public void finish() {
        com.huawei.hms.support.log.HMSLog.i("BridgeActivity", "Enter finish.");
        super.finish();
    }

    @Override // android.app.Activity
    public android.content.Intent getIntent() {
        android.content.Intent intent = super.getIntent();
        return intent != null ? new com.huawei.hms.ui.SafeIntent(intent) : intent;
    }

    @Override // android.app.Activity
    public void onActivityResult(int i, int i2, android.content.Intent intent) {
        com.huawei.hms.ui.SafeIntent safeIntent = new com.huawei.hms.ui.SafeIntent(intent);
        super.onActivityResult(i, i2, safeIntent);
        com.huawei.hms.activity.IBridgeActivityDelegate iBridgeActivityDelegate = this.a;
        if (iBridgeActivityDelegate == null || iBridgeActivityDelegate.onBridgeActivityResult(i, i2, safeIntent) || isFinishing()) {
            return;
        }
        setResult(i2, safeIntent);
        finish();
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(android.content.res.Configuration configuration) {
        super.onConfigurationChanged(configuration);
        com.huawei.hms.activity.IBridgeActivityDelegate iBridgeActivityDelegate = this.a;
        if (iBridgeActivityDelegate != null) {
            iBridgeActivityDelegate.onBridgeConfigurationChanged();
        }
    }

    @Override // android.app.Activity
    public void onCreate(android.os.Bundle bundle) {
        super.onCreate(bundle);
        com.huawei.hms.support.log.HMSLog.i("BridgeActivity", "BridgeActivity onCreate");
        if (getIntent() == null) {
            return;
        }
        getWindow().addFlags(Integer.MIN_VALUE);
        getWindow().setStatusBarColor(0);
        c();
        a();
        if (com.huawei.hms.utils.ResourceLoaderUtil.getmContext() == null) {
            com.huawei.hms.utils.ResourceLoaderUtil.setmContext(getApplicationContext());
        }
        setFullScreenWindowLayoutInDisplayCutout(getWindow());
        if (b()) {
            return;
        }
        setResult(1, null);
        finish();
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        com.huawei.hms.activity.IBridgeActivityDelegate iBridgeActivityDelegate = this.a;
        if (iBridgeActivityDelegate != null) {
            iBridgeActivityDelegate.onBridgeActivityDestroy();
        }
        com.huawei.hms.support.log.HMSLog.i("BridgeActivity", "BridgeActivity onDestroy");
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, android.view.KeyEvent keyEvent) {
        com.huawei.hms.activity.IBridgeActivityDelegate iBridgeActivityDelegate = this.a;
        if (iBridgeActivityDelegate != null) {
            iBridgeActivityDelegate.onKeyUp(i, keyEvent);
        }
        return super.onKeyUp(i, keyEvent);
    }
}
