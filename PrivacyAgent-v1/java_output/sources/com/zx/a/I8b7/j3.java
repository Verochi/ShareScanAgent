package com.zx.a.I8b7;

/* loaded from: classes19.dex */
public class j3 implements java.lang.Runnable {
    public final /* synthetic */ android.app.Activity a;
    public final /* synthetic */ com.zx.sdk.api.PermissionCallback b;

    public class a implements android.view.View.OnClickListener {
        public final /* synthetic */ com.zx.a.I8b7.l3 a;

        public a(com.zx.a.I8b7.l3 l3Var) {
            this.a = l3Var;
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public void onClick(android.view.View view) {
            this.a.dismiss();
            com.zx.a.I8b7.j3.this.b.onAuthorized();
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public class b implements android.view.View.OnClickListener {
        public final /* synthetic */ com.zx.a.I8b7.l3 a;

        public b(com.zx.a.I8b7.l3 l3Var) {
            this.a = l3Var;
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public void onClick(android.view.View view) {
            this.a.dismiss();
            com.zx.a.I8b7.j3.this.b.onUnauthorized();
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public class c implements android.view.View.OnClickListener {
        public final /* synthetic */ com.zx.a.I8b7.l3 a;

        public c(com.zx.a.I8b7.l3 l3Var) {
            this.a = l3Var;
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public void onClick(android.view.View view) {
            this.a.dismiss();
            com.zx.a.I8b7.r2.a("用户点击了解更多");
            com.zx.a.I8b7.j3.this.a.startActivity(new android.content.Intent("android.intent.action.VIEW", android.net.Uri.parse("https://aid.mobileservice.cn/")));
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public j3(com.zx.a.I8b7.k3 k3Var, android.app.Activity activity, com.zx.sdk.api.PermissionCallback permissionCallback) {
        this.a = activity;
        this.b = permissionCallback;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            com.zx.a.I8b7.l3 l3Var = new com.zx.a.I8b7.l3(this.a);
            l3Var.b = new com.zx.a.I8b7.j3.a(l3Var);
            l3Var.a = new com.zx.a.I8b7.j3.b(l3Var);
            l3Var.c = new com.zx.a.I8b7.j3.c(l3Var);
            l3Var.show();
        } catch (java.lang.Throwable th) {
            com.zx.a.I8b7.g3.a(th, com.zx.a.I8b7.f3.a("卓信ID授权弹窗异常: "));
        }
    }
}
