package com.amap.api.mapcore.util;

/* loaded from: classes12.dex */
public final class ce {
    private com.amap.api.mapcore.util.ce.a a;
    private com.amap.api.mapcore.util.ce.b b;
    private com.amap.api.mapcore.util.ce.b c;

    public static class a extends com.amap.api.mapcore.util.cd {
    }

    public static class b extends com.amap.api.mapcore.util.cd {
    }

    public final synchronized void a() {
        com.amap.api.mapcore.util.ce.a aVar = this.a;
        if (aVar != null) {
            aVar.a();
            this.a = null;
        }
        com.amap.api.mapcore.util.ce.b bVar = this.b;
        if (bVar != null) {
            bVar.a();
            this.b = null;
        }
        com.amap.api.mapcore.util.ce.b bVar2 = this.c;
        if (bVar2 != null) {
            bVar2.a();
            this.c = null;
        }
    }
}
