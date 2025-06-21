package com.amap.api.mapcore.util;

/* loaded from: classes12.dex */
public abstract class ij implements java.lang.Runnable {
    com.amap.api.mapcore.util.ij.a f;

    public interface a {
        void a(com.amap.api.mapcore.util.ij ijVar);

        void b(com.amap.api.mapcore.util.ij ijVar);
    }

    public final void cancelTask() {
        try {
            com.amap.api.mapcore.util.ij.a aVar = this.f;
            if (aVar != null) {
                aVar.b(this);
            }
        } catch (java.lang.Throwable th) {
            com.amap.api.mapcore.util.gd.c(th, "ThreadTask", "cancelTask");
            th.printStackTrace();
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.amap.api.mapcore.util.ij.a aVar;
        try {
            if (java.lang.Thread.interrupted()) {
                return;
            }
            runTask();
            if (java.lang.Thread.interrupted() || (aVar = this.f) == null) {
                return;
            }
            aVar.a(this);
        } catch (java.lang.Throwable th) {
            com.amap.api.mapcore.util.gd.c(th, "ThreadTask", "run");
            th.printStackTrace();
        }
    }

    public abstract void runTask();
}
