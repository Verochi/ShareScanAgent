package com.igexin.sdk;

/* loaded from: classes30.dex */
public class GetuiActivity extends android.app.Activity {
    private com.igexin.push.a.b activityAction;

    @Override // android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(android.content.res.Configuration configuration) {
        super.onConfigurationChanged(configuration);
        com.igexin.push.a.b bVar = this.activityAction;
        if (bVar != null) {
            bVar.a(this);
        }
    }

    @Override // android.app.Activity
    public void onCreate(android.os.Bundle bundle) {
        super.onCreate(bundle);
        com.igexin.push.a.a.a();
        com.igexin.push.a.b a = com.igexin.push.a.a.a(this);
        this.activityAction = a;
        if (a != null) {
            a.b(this);
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        com.igexin.push.a.b bVar = this.activityAction;
        if (bVar != null) {
            bVar.i();
        }
        super.onDestroy();
    }

    @Override // android.app.Activity
    public void onNewIntent(android.content.Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
    }
}
