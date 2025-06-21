package com.amap.api.mapcore.util;

/* loaded from: classes12.dex */
public final class jd extends android.os.Handler {
    com.amap.api.mapcore.util.jb a;

    public jd(android.os.Looper looper, com.amap.api.mapcore.util.jb jbVar) {
        super(looper);
        this.a = jbVar;
    }

    public jd(com.amap.api.mapcore.util.jb jbVar) {
        this.a = jbVar;
    }

    @Override // android.os.Handler
    public final void handleMessage(android.os.Message message) {
        if (message.what != 1) {
            return;
        }
        try {
            com.amap.api.mapcore.util.jb jbVar = this.a;
            if (jbVar != null) {
                jbVar.a((com.autonavi.amap.mapcore.Inner_3dMap_location) message.obj);
            }
        } catch (java.lang.Throwable th) {
            com.amap.api.mapcore.util.it.a(th, "ClientResultHandler", "RESULT_LOCATION_FINISH");
        }
    }
}
