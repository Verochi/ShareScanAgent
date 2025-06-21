package com.amap.api.mapcore.util;

/* loaded from: classes12.dex */
public final class jc extends android.os.Handler {
    com.amap.api.mapcore.util.jb a;

    public jc() {
        this.a = null;
    }

    public jc(android.os.Looper looper, com.amap.api.mapcore.util.jb jbVar) {
        super(looper);
        this.a = jbVar;
    }

    @Override // android.os.Handler
    public final void handleMessage(android.os.Message message) {
        java.lang.String str;
        switch (message.what) {
            case 1001:
                try {
                    this.a.a((com.autonavi.amap.mapcore.Inner_3dMap_locationOption) message.obj);
                    return;
                } catch (java.lang.Throwable th) {
                    th = th;
                    str = "ACTION_SET_OPTION";
                    break;
                }
            case 1002:
                try {
                    this.a.a((com.autonavi.amap.mapcore.Inner_3dMap_locationListener) message.obj);
                    return;
                } catch (java.lang.Throwable th2) {
                    th = th2;
                    str = "ACTION_SET_LISTENER";
                    break;
                }
            case 1003:
                try {
                    this.a.b((com.autonavi.amap.mapcore.Inner_3dMap_locationListener) message.obj);
                    return;
                } catch (java.lang.Throwable th3) {
                    th = th3;
                    str = "ACTION_REMOVE_LISTENER";
                    break;
                }
            case 1004:
                try {
                    this.a.a();
                    return;
                } catch (java.lang.Throwable th4) {
                    th = th4;
                    str = "ACTION_START_LOCATION";
                    break;
                }
            case 1005:
                try {
                    this.a.b();
                    return;
                } catch (java.lang.Throwable th5) {
                    th = th5;
                    str = "ACTION_GET_LOCATION";
                    break;
                }
            case 1006:
                try {
                    this.a.c();
                    return;
                } catch (java.lang.Throwable th6) {
                    th = th6;
                    str = "ACTION_STOP_LOCATION";
                    break;
                }
            case 1007:
                try {
                    this.a.d();
                    return;
                } catch (java.lang.Throwable th7) {
                    com.amap.api.mapcore.util.it.a(th7, "ClientActionHandler", "ACTION_DESTROY");
                    return;
                }
            default:
                return;
        }
        com.amap.api.mapcore.util.it.a(th, "ClientActionHandler", str);
    }
}
