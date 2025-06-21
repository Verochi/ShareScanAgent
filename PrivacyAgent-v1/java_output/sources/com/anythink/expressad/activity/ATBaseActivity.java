package com.anythink.expressad.activity;

/* loaded from: classes12.dex */
public abstract class ATBaseActivity extends android.app.Activity {
    private static final java.lang.String a = "ATBaseActivity";
    private android.view.OrientationEventListener b;
    private android.view.Display c;
    private int d = -1;

    /* renamed from: com.anythink.expressad.activity.ATBaseActivity$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        public AnonymousClass1() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:8:0x001c, code lost:
        
            r0 = r1.getDisplayCutout();
         */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void run() {
            android.view.WindowInsets rootWindowInsets;
            int i;
            int i2;
            int i3;
            android.view.DisplayCutout displayCutout;
            int safeInsetLeft;
            int safeInsetBottom;
            try {
                int i4 = android.os.Build.VERSION.SDK_INT;
                if (i4 >= 23) {
                    rootWindowInsets = com.anythink.expressad.activity.ATBaseActivity.this.getWindow().getDecorView().getRootWindowInsets();
                    int i5 = -1;
                    int i6 = 0;
                    if (rootWindowInsets == null || i4 < 28 || displayCutout == null) {
                        i = 0;
                        i2 = 0;
                        i3 = 0;
                    } else {
                        safeInsetLeft = displayCutout.getSafeInsetLeft();
                        i = displayCutout.getSafeInsetRight();
                        i2 = displayCutout.getSafeInsetTop();
                        safeInsetBottom = displayCutout.getSafeInsetBottom();
                        int d = com.anythink.expressad.activity.ATBaseActivity.this.d();
                        if (com.anythink.expressad.activity.ATBaseActivity.this.d == -1) {
                            com.anythink.expressad.activity.ATBaseActivity.this.d = d == 0 ? 3 : d == 1 ? 1 : d == 2 ? 4 : d == 3 ? 2 : -1;
                            int unused = com.anythink.expressad.activity.ATBaseActivity.this.d;
                        }
                        if (d != 0) {
                            if (d == 1) {
                                i5 = 90;
                            } else if (d == 2) {
                                i5 = 180;
                            } else if (d == 3) {
                                i5 = 270;
                            }
                            i3 = safeInsetBottom;
                            i6 = safeInsetLeft;
                        } else {
                            i3 = safeInsetBottom;
                            i6 = safeInsetLeft;
                            i5 = 0;
                        }
                    }
                    com.anythink.expressad.activity.ATBaseActivity.this.a(i5, i6, i, i2, i3);
                    if (com.anythink.expressad.activity.ATBaseActivity.this.b == null) {
                        com.anythink.expressad.activity.ATBaseActivity.d(com.anythink.expressad.activity.ATBaseActivity.this);
                    }
                }
            } catch (java.lang.Throwable th) {
                th.getMessage();
            }
        }
    }

    /* renamed from: com.anythink.expressad.activity.ATBaseActivity$2, reason: invalid class name */
    public class AnonymousClass2 extends android.view.OrientationEventListener {
        public AnonymousClass2(android.content.Context context) {
            super(context, 1);
        }

        @Override // android.view.OrientationEventListener
        public final void onOrientationChanged(int i) {
            int d = com.anythink.expressad.activity.ATBaseActivity.this.d();
            if (d < 0) {
                d = 0;
            }
            if (d == 1 && com.anythink.expressad.activity.ATBaseActivity.this.d != 1) {
                com.anythink.expressad.activity.ATBaseActivity.this.d = 1;
                com.anythink.expressad.activity.ATBaseActivity.this.a();
                return;
            }
            if (d == 3 && com.anythink.expressad.activity.ATBaseActivity.this.d != 2) {
                com.anythink.expressad.activity.ATBaseActivity.this.d = 2;
                com.anythink.expressad.activity.ATBaseActivity.this.a();
            } else if (d == 0 && com.anythink.expressad.activity.ATBaseActivity.this.d != 3) {
                com.anythink.expressad.activity.ATBaseActivity.this.d = 3;
                com.anythink.expressad.activity.ATBaseActivity.this.a();
            } else {
                if (d != 2 || com.anythink.expressad.activity.ATBaseActivity.this.d == 4) {
                    return;
                }
                com.anythink.expressad.activity.ATBaseActivity.this.d = 4;
                com.anythink.expressad.activity.ATBaseActivity.this.a();
            }
        }
    }

    private void b() {
        try {
            java.lang.reflect.Field declaredField = android.app.Activity.class.getDeclaredField("mCalled");
            declaredField.setAccessible(true);
            declaredField.setBoolean(this, true);
        } catch (java.lang.Throwable unused) {
            finish();
        }
    }

    private void c() {
        com.anythink.expressad.activity.ATBaseActivity.AnonymousClass2 anonymousClass2 = new com.anythink.expressad.activity.ATBaseActivity.AnonymousClass2(this);
        this.b = anonymousClass2;
        if (anonymousClass2.canDetectOrientation()) {
            this.b.enable();
        } else {
            this.b.disable();
            this.b = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int d() {
        if (this.c == null) {
            if (android.os.Build.VERSION.SDK_INT >= 30) {
                this.c = getDisplay();
            } else {
                this.c = ((android.view.WindowManager) getSystemService("window")).getDefaultDisplay();
            }
        }
        android.view.Display display = this.c;
        if (display == null) {
            return -1;
        }
        try {
            return display.getRotation();
        } catch (java.lang.Throwable unused) {
            return -1;
        }
    }

    public static /* synthetic */ void d(com.anythink.expressad.activity.ATBaseActivity aTBaseActivity) {
        com.anythink.expressad.activity.ATBaseActivity.AnonymousClass2 anonymousClass2 = aTBaseActivity.new AnonymousClass2(aTBaseActivity);
        aTBaseActivity.b = anonymousClass2;
        if (anonymousClass2.canDetectOrientation()) {
            aTBaseActivity.b.enable();
        } else {
            aTBaseActivity.b.disable();
            aTBaseActivity.b = null;
        }
    }

    private void e() {
        try {
            getWindow().addFlags(67108864);
            getWindow().getDecorView().setSystemUiVisibility(4098);
        } catch (java.lang.Throwable th) {
            th.getMessage();
        }
    }

    public final void a() {
        getWindow().getDecorView().postDelayed(new com.anythink.expressad.activity.ATBaseActivity.AnonymousClass1(), 500L);
    }

    public abstract void a(int i, int i2, int i3, int i4, int i5);

    @Override // android.app.Activity
    public void onCreate(android.os.Bundle bundle) {
        super.onCreate(bundle);
        try {
            requestWindowFeature(1);
            getWindow().setFlags(1024, 1024);
            getWindow().addFlags(512);
            e();
            d();
            if (android.os.Build.VERSION.SDK_INT >= 28) {
                android.view.WindowManager.LayoutParams attributes = getWindow().getAttributes();
                attributes.layoutInDisplayCutoutMode = 1;
                getWindow().setAttributes(attributes);
            }
        } catch (java.lang.Exception e) {
            e.getMessage();
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        android.view.OrientationEventListener orientationEventListener = this.b;
        if (orientationEventListener != null) {
            orientationEventListener.disable();
            this.b = null;
        }
    }

    @Override // android.app.Activity
    @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
    public void onNewIntent(android.content.Intent intent) {
        super.onNewIntent(intent);
        com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper.onNewIntent(this, intent);
    }

    @Override // android.app.Activity
    public void onResume() {
        if (android.os.Build.VERSION.SDK_INT < 29) {
            try {
                try {
                    super.onResume();
                } catch (java.lang.Throwable unused) {
                    finish();
                }
            } catch (java.lang.Throwable unused2) {
                java.lang.reflect.Field declaredField = android.app.Activity.class.getDeclaredField("mCalled");
                declaredField.setAccessible(true);
                declaredField.setBoolean(this, true);
            }
        } else {
            super.onResume();
        }
        if (com.anythink.expressad.foundation.f.b.c) {
            return;
        }
        a();
        e();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        e();
    }
}
