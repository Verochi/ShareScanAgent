package com.qq.e.ads;

/* loaded from: classes19.dex */
public class ADActivity extends android.app.Activity {
    public static final java.lang.String NOTCH_CONTAINER_TAG = "NOTCH_CONTAINER";
    protected com.qq.e.comm.pi.ACTD a;
    private android.widget.FrameLayout b;

    private void a() {
        android.widget.LinearLayout linearLayout = new android.widget.LinearLayout(this);
        linearLayout.setLayoutParams(new android.view.ViewGroup.LayoutParams(-1, -1));
        linearLayout.setOrientation(1);
        super.setContentView(linearLayout);
        android.widget.FrameLayout frameLayout = new android.widget.FrameLayout(this);
        frameLayout.setTag(NOTCH_CONTAINER_TAG);
        frameLayout.setLayoutParams(new android.widget.LinearLayout.LayoutParams(-1, -2));
        linearLayout.addView(frameLayout);
        this.b = new android.widget.FrameLayout(this);
        this.b.setLayoutParams(new android.widget.LinearLayout.LayoutParams(-1, -1));
        linearLayout.addView(this.b);
    }

    @Override // android.app.Activity
    public void onActivityResult(int i, int i2, android.content.Intent intent) {
        super.onActivityResult(i, i2, intent);
        com.qq.e.comm.pi.ACTD actd = this.a;
        if (actd != null) {
            actd.onActivityResult(i, i2, intent);
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        com.qq.e.comm.pi.ACTD actd = this.a;
        if (actd != null) {
            actd.onBackPressed();
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(android.content.res.Configuration configuration) {
        super.onConfigurationChanged(configuration);
        com.qq.e.comm.pi.ACTD actd = this.a;
        if (actd != null) {
            actd.onConfigurationChanged(configuration);
        }
    }

    @Override // android.app.Activity
    public void onCreate(android.os.Bundle bundle) {
        java.lang.String str = null;
        try {
            com.qq.e.comm.pi.POFactory pOFactory = com.qq.e.comm.managers.a.b().c().getPOFactory();
            if (pOFactory != null) {
                android.content.Intent intent = getIntent();
                intent.setExtrasClassLoader(pOFactory.getClass().getClassLoader());
                android.os.Bundle extras = intent.getExtras();
                if (extras != null) {
                    str = extras.getString(com.qq.e.comm.pi.ACTD.DELEGATE_NAME_KEY);
                    java.lang.String string = extras.getString("appid");
                    if (!android.text.TextUtils.isEmpty(str) && !android.text.TextUtils.isEmpty(string) && com.qq.e.comm.managers.a.b().d()) {
                        com.qq.e.comm.pi.ACTD activityDelegate = pOFactory.getActivityDelegate(str, this);
                        this.a = activityDelegate;
                        if (activityDelegate == null) {
                            com.qq.e.comm.util.GDTLogger.e("创建 ADActivity Delegate " + str + " 失败");
                        }
                    }
                }
            }
        } catch (java.lang.Throwable th) {
            com.qq.e.comm.util.GDTLogger.e("创建ADActivity Delegate" + str + "发生异常", th);
        }
        com.qq.e.comm.pi.ACTD actd = this.a;
        if (actd != null) {
            actd.onBeforeCreate(bundle);
        } else {
            try {
                finish();
            } catch (java.lang.Throwable th2) {
                com.qq.e.comm.util.GDTLogger.e("ADActivity onCreate 发生异常", th2);
            }
        }
        try {
            super.onCreate(bundle);
        } catch (java.lang.Throwable th3) {
            com.qq.e.comm.managers.plugin.a.a(th3, "ADActivity onCreate 发生异常");
            com.qq.e.comm.util.GDTLogger.e("ADActivity onCreate 发生异常", th3);
        }
        com.qq.e.comm.pi.ACTD actd2 = this.a;
        if (actd2 != null) {
            actd2.onAfterCreate(bundle);
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        com.qq.e.comm.pi.ACTD actd = this.a;
        if (actd != null) {
            actd.onDestroy();
        }
    }

    @Override // android.app.Activity
    @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
    public void onNewIntent(android.content.Intent intent) {
        super.onNewIntent(intent);
        com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper.onNewIntent(this, intent);
    }

    @Override // android.app.Activity
    public void onPause() {
        com.qq.e.comm.pi.ACTD actd = this.a;
        if (actd != null) {
            actd.onPause();
        }
        super.onPause();
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        com.qq.e.comm.pi.ACTD actd = this.a;
        if (actd != null) {
            actd.onResume();
        }
    }

    @Override // android.app.Activity
    public void onStop() {
        com.qq.e.comm.pi.ACTD actd = this.a;
        if (actd != null) {
            actd.onStop();
        }
        super.onStop();
    }

    @Override // android.app.Activity
    public void setContentView(int i) {
        a();
        android.view.LayoutInflater.from(this).inflate(i, (android.view.ViewGroup) this.b, true);
    }

    @Override // android.app.Activity
    public void setContentView(android.view.View view) {
        a();
        this.b.addView(view);
    }

    @Override // android.app.Activity
    public void setContentView(android.view.View view, android.view.ViewGroup.LayoutParams layoutParams) {
        a();
        this.b.addView(view, layoutParams);
    }
}
