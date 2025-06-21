package com.amap.api.mapcore.util;

/* loaded from: classes12.dex */
public final class ci extends com.amap.api.mapcore.util.ij {
    private android.content.Context a;
    private com.amap.api.mapcore.util.ch b;
    private com.amap.api.mapcore.util.co c;
    private com.amap.api.mapcore.util.ci.a d;

    public interface a {
        void a(java.lang.String str, com.amap.api.mapcore.util.co coVar);
    }

    public ci(android.content.Context context) {
        this.a = context;
        if (this.b == null) {
            this.b = new com.amap.api.mapcore.util.ch(context, "");
        }
    }

    private static java.lang.String a(android.content.Context context) {
        return com.autonavi.base.amap.mapcore.FileUtil.getMapBaseStorage(context);
    }

    private static void a(java.lang.String str, byte[] bArr) {
        com.autonavi.base.amap.mapcore.FileUtil.writeDatasToFile(str, bArr);
    }

    public final void a() {
        this.a = null;
        if (this.b != null) {
            this.b = null;
        }
    }

    public final void a(com.amap.api.mapcore.util.ci.a aVar) {
        this.d = aVar;
    }

    public final void a(com.amap.api.mapcore.util.co coVar) {
        this.c = coVar;
    }

    public final void a(java.lang.String str) {
        com.amap.api.mapcore.util.ch chVar = this.b;
        if (chVar != null) {
            chVar.b(str);
        }
    }

    public final void b() {
        com.amap.api.mapcore.util.dj.a().a(this);
    }

    @Override // com.amap.api.mapcore.util.ij
    public final void runTask() {
        java.lang.String str;
        try {
            if (com.amap.api.maps.MapsInitializer.getNetWorkEnable()) {
                com.amap.api.mapcore.util.ch chVar = this.b;
                if (chVar != null) {
                    com.amap.api.mapcore.util.ch.a d = chVar.d();
                    if (d == null || d.a == null) {
                        str = null;
                    } else {
                        str = a(this.a) + "/custom_texture_data";
                        a(str, d.a);
                    }
                    com.amap.api.mapcore.util.ci.a aVar = this.d;
                    if (aVar != null) {
                        aVar.a(str, this.c);
                    }
                }
                com.amap.api.mapcore.util.gd.a(this.a, com.amap.api.mapcore.util.dl.a());
            }
        } catch (java.lang.Throwable th) {
            com.amap.api.mapcore.util.gd.c(th, "CustomStyleTask", "download customStyle");
            th.printStackTrace();
        }
    }
}
