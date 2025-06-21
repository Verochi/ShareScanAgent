package com.amap.api.maps.offlinemap;

/* loaded from: classes12.dex */
public class OfflineMapActivity extends com.amap.api.offlineservice.AMapPermissionActivity implements android.view.View.OnClickListener {
    private static int a;
    private com.amap.api.offlineservice.a b;
    private com.amap.api.mapcore.util.ei c;
    private com.amap.api.mapcore.util.ei[] d = new com.amap.api.mapcore.util.ei[32];
    private int e = -1;
    private com.amap.api.mapcore.util.ej f;

    private void a(com.amap.api.mapcore.util.ei eiVar) {
        try {
            com.amap.api.offlineservice.a aVar = this.b;
            if (aVar != null) {
                aVar.e();
                this.b = null;
            }
            com.amap.api.offlineservice.a c = c(eiVar);
            this.b = c;
            if (c != null) {
                this.c = eiVar;
                c.a(this);
                this.b.a();
                this.b.b();
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    private boolean a(android.os.Bundle bundle) {
        try {
            int i = a;
            if ((i != 1 || this.b == null) && i > 1) {
                a = i - 1;
                int i2 = ((this.e - 1) + 32) % 32;
                this.e = i2;
                com.amap.api.mapcore.util.ei eiVar = this.d[i2];
                eiVar.b = bundle;
                a(eiVar);
                return true;
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
        return false;
    }

    private void b(com.amap.api.mapcore.util.ei eiVar) {
        try {
            a++;
            a(eiVar);
            int i = (this.e + 1) % 32;
            this.e = i;
            this.d[i] = eiVar;
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    private com.amap.api.offlineservice.a c(com.amap.api.mapcore.util.ei eiVar) {
        try {
            if (eiVar.a != 1) {
                return null;
            }
            if (this.f == null) {
                this.f = new com.amap.api.mapcore.util.ej();
            }
            return this.f;
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public void closeScr() {
        try {
            if (a((android.os.Bundle) null)) {
                return;
            }
            com.amap.api.offlineservice.a aVar = this.b;
            if (aVar != null) {
                aVar.e();
            }
            finish();
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public void closeScr(android.os.Bundle bundle) {
        try {
            if (a(bundle)) {
                return;
            }
            com.amap.api.offlineservice.a aVar = this.b;
            if (aVar != null) {
                aVar.e();
            }
            finish();
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // android.view.View.OnClickListener
    @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
    public void onClick(android.view.View view) {
        try {
            com.amap.api.offlineservice.a aVar = this.b;
            if (aVar != null) {
                aVar.a(view);
            }
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(android.content.res.Configuration configuration) {
        try {
            super.onConfigurationChanged(configuration);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // android.app.Activity
    public void onCreate(android.os.Bundle bundle) {
        try {
            super.onCreate(bundle);
            getWindow().setSoftInputMode(32);
            getWindow().setFormat(-3);
            requestWindowFeature(1);
            com.amap.api.mapcore.util.el.a(getApplicationContext());
            this.e = -1;
            a = 0;
            b(new com.amap.api.mapcore.util.ei());
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        try {
            super.onDestroy();
            com.amap.api.offlineservice.a aVar = this.b;
            if (aVar != null) {
                aVar.e();
                this.b = null;
            }
            this.c = null;
            this.d = null;
            com.amap.api.mapcore.util.ej ejVar = this.f;
            if (ejVar != null) {
                ejVar.e();
                this.f = null;
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, android.view.KeyEvent keyEvent) {
        if (i == 4) {
            try {
                com.amap.api.offlineservice.a aVar = this.b;
                if (aVar != null && !aVar.c()) {
                    return true;
                }
                if (a((android.os.Bundle) null)) {
                    return false;
                }
                if (keyEvent == null) {
                    if (a == 1) {
                        finish();
                    }
                    return false;
                }
                this.e = -1;
                a = 0;
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.app.Activity
    public void onPause() {
        try {
            super.onPause();
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.offlineservice.AMapPermissionActivity, android.app.Activity
    public void onResume() {
        try {
            super.onResume();
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // android.app.Activity
    public void onStart() {
        try {
            super.onStart();
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // android.app.Activity
    public void onStop() {
        try {
            super.onStop();
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public void showScr() {
        try {
            setContentView(this.b.d());
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }
}
