package com.ss.android.downloadlib.vw.vw;

/* loaded from: classes19.dex */
public class vw {
    private static volatile com.ss.android.downloadlib.vw.vw.vw bt = null;
    private static java.lang.String kz = "";
    private static java.lang.String v = "";
    private static java.lang.String yl = "";
    public com.ss.android.downloadlib.vw.vw.t vw;
    private android.content.Context z;
    private boolean o = true;
    private boolean x = false;
    private volatile boolean es = false;
    private final java.util.List<android.util.Pair<com.ss.android.downloadlib.vw.vw.wg, com.ss.android.downloadlib.vw.vw.v>> vl = new java.util.ArrayList();
    public final java.util.List<java.lang.Object> wg = new java.util.ArrayList();
    private final android.content.ServiceConnection u = new com.ss.android.downloadlib.vw.vw.vw.AnonymousClass1();
    private java.lang.String cp = "";
    public final java.lang.Object t = new java.lang.Object();

    /* renamed from: com.ss.android.downloadlib.vw.vw.vw$1, reason: invalid class name */
    public class AnonymousClass1 implements android.content.ServiceConnection {
        public AnonymousClass1() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(android.content.ComponentName componentName, android.os.IBinder iBinder) {
            synchronized (com.ss.android.downloadlib.vw.vw.vw.this.t) {
                com.ss.android.downloadlib.vw.vw.vw.this.vw(false);
                com.ss.android.downloadlib.vw.vw.vw.this.vw = com.ss.android.downloadlib.vw.vw.t.vw.vw(iBinder);
                com.ss.android.downloadlib.vw.vw.vw.this.t();
                java.util.Iterator<java.lang.Object> it = com.ss.android.downloadlib.vw.vw.vw.this.wg.iterator();
                while (it.hasNext()) {
                    it.next();
                }
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(android.content.ComponentName componentName) {
            synchronized (com.ss.android.downloadlib.vw.vw.vw.this.t) {
                com.ss.android.downloadlib.vw.vw.vw.this.vw(false);
                com.ss.android.downloadlib.vw.vw.vw vwVar = com.ss.android.downloadlib.vw.vw.vw.this;
                vwVar.vw = null;
                java.util.Iterator<java.lang.Object> it = vwVar.wg.iterator();
                while (it.hasNext()) {
                    it.next();
                }
            }
        }
    }

    private vw() {
    }

    public static com.ss.android.downloadlib.vw.vw.vw vw() {
        if (bt == null) {
            synchronized (com.ss.android.downloadlib.vw.vw.vw.class) {
                if (bt == null) {
                    bt = new com.ss.android.downloadlib.vw.vw.vw();
                }
            }
        }
        return bt;
    }

    public void t() {
        for (android.util.Pair<com.ss.android.downloadlib.vw.vw.wg, com.ss.android.downloadlib.vw.vw.v> pair : this.vl) {
            try {
                this.vw.vw((com.ss.android.downloadlib.vw.vw.wg) pair.first, (com.ss.android.downloadlib.vw.vw.v) pair.second);
            } catch (android.os.RemoteException e) {
                e.printStackTrace();
            }
        }
        this.vl.clear();
    }

    public boolean v() {
        return this.es;
    }

    public android.content.Intent vw(android.content.Context context) {
        android.content.Intent intent = new android.content.Intent();
        intent.setAction(v);
        java.util.List<android.content.pm.ResolveInfo> queryIntentServices = context.getPackageManager().queryIntentServices(intent, 0);
        if (queryIntentServices == null || queryIntentServices.size() != 1) {
            return null;
        }
        java.util.Iterator<android.content.pm.ResolveInfo> it = queryIntentServices.iterator();
        while (it.hasNext()) {
            android.content.pm.ServiceInfo serviceInfo = it.next().serviceInfo;
            java.lang.String str = serviceInfo.packageName;
            java.lang.String str2 = serviceInfo.name;
            if (yl.equals(str)) {
                android.content.ComponentName componentName = new android.content.ComponentName(str, str2);
                android.content.Intent intent2 = new android.content.Intent(intent);
                intent2.setComponent(componentName);
                return intent2;
            }
        }
        return null;
    }

    public void vw(com.ss.android.downloadlib.vw.vw.wg wgVar, com.ss.android.downloadlib.vw.vw.v vVar) {
        synchronized (this.t) {
            wgVar.yl = kz;
            if (android.text.TextUtils.isEmpty(wgVar.kz)) {
                wgVar.kz = this.cp;
            }
            com.ss.android.downloadlib.vw.vw.t tVar = this.vw;
            if (tVar != null) {
                try {
                    tVar.vw(wgVar, vVar);
                } catch (android.os.RemoteException e) {
                    e.printStackTrace();
                }
            } else if (v() || vw(this.z, this.x)) {
                this.vl.add(android.util.Pair.create(wgVar, vVar));
            }
        }
    }

    public void vw(boolean z) {
        this.es = z;
    }

    public boolean vw(android.content.Context context, boolean z) {
        if (android.text.TextUtils.isEmpty(v)) {
            org.json.JSONObject x = com.ss.android.downloadlib.addownload.z.x();
            java.lang.String optString = x.optString("s");
            v = com.ss.android.socialbase.appdownloader.kz.t.vw(x.optString("q"), optString);
            yl = com.ss.android.socialbase.appdownloader.kz.t.vw(x.optString(com.umeng.analytics.pro.bo.aN), optString);
            kz = com.ss.android.socialbase.appdownloader.kz.t.vw(x.optString(com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.WIDTH), optString);
        }
        this.x = z;
        if (context == null) {
            return true;
        }
        this.z = context.getApplicationContext();
        if (android.text.TextUtils.isEmpty(kz)) {
            kz = this.z.getPackageName();
        }
        if (this.vw != null || v()) {
            return true;
        }
        return this.z.bindService(vw(context), this.u, 33);
    }

    public void wg() {
        if (this.vw != null) {
            this.z.unbindService(this.u);
            this.vw = null;
        }
        this.wg.clear();
        this.vl.clear();
    }
}
