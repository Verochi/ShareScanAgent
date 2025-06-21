package com.amap.api.mapcore.util;

/* loaded from: classes12.dex */
public final class cg extends com.amap.api.mapcore.util.ij {
    private android.content.Context a;
    private com.autonavi.base.amap.api.mapcore.IAMapDelegate b;
    private com.amap.api.mapcore.util.cf c;
    private java.lang.String d;
    private java.lang.String e;
    private java.lang.String g;
    private com.amap.api.mapcore.util.cg.a h;
    private int i;

    public interface a {
        void a(byte[] bArr, int i);

        void b(byte[] bArr, int i);
    }

    public cg(android.content.Context context, com.amap.api.mapcore.util.cg.a aVar, int i, java.lang.String str) {
        this.d = null;
        this.e = null;
        this.g = null;
        this.a = context;
        this.h = aVar;
        this.i = i;
        if (this.c == null) {
            this.c = new com.amap.api.mapcore.util.cf(context, "", i != 0);
        }
        this.c.b(str);
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(i);
        sb.append(str == null ? "" : str);
        sb.append(".amapstyle");
        this.d = sb.toString();
        this.e = context.getCacheDir().getPath();
    }

    public cg(android.content.Context context, com.autonavi.base.amap.api.mapcore.IAMapDelegate iAMapDelegate) {
        this.d = null;
        this.e = null;
        this.g = null;
        this.i = 0;
        this.a = context;
        this.b = iAMapDelegate;
        if (this.c == null) {
            this.c = new com.amap.api.mapcore.util.cf(context, "");
        }
    }

    private void a(java.lang.String str, java.lang.String str2) {
        if (str == null || str2 == null) {
            return;
        }
        com.amap.api.mapcore.util.dh.a(this.a, "amap_style_config", "lastModified".concat(str), str2);
    }

    private void a(java.lang.String str, byte[] bArr) {
        if (str == null || bArr == null || this.e == null) {
            return;
        }
        com.autonavi.base.amap.mapcore.FileUtil.saveFileContents(this.e + java.io.File.separator + str, bArr);
    }

    private byte[] b(java.lang.String str) {
        if (str == null || this.e == null) {
            return null;
        }
        return com.autonavi.base.amap.mapcore.FileUtil.readFileContents(this.e + java.io.File.separator + str);
    }

    private java.lang.String c(java.lang.String str) {
        if (str == null) {
            return null;
        }
        java.lang.Object b = com.amap.api.mapcore.util.dh.b(this.a, "amap_style_config", "lastModified".concat(str), "");
        if (!(b instanceof java.lang.String) || b == "") {
            return null;
        }
        return (java.lang.String) b;
    }

    public final void a() {
        this.a = null;
        if (this.c != null) {
            this.c = null;
        }
    }

    public final void a(java.lang.String str) {
        com.amap.api.mapcore.util.cf cfVar = this.c;
        if (cfVar != null) {
            cfVar.c(str);
        }
        this.g = str;
    }

    public final void b() {
        com.amap.api.mapcore.util.dj.a().a(this);
    }

    @Override // com.amap.api.mapcore.util.ij
    public final void runTask() {
        byte[] bArr;
        try {
            if (com.amap.api.maps.MapsInitializer.getNetWorkEnable()) {
                if (this.c != null) {
                    java.lang.String str = this.g + this.d;
                    java.lang.String c = c(str);
                    if (c != null) {
                        this.c.d(c);
                    }
                    byte[] b = b(str);
                    com.amap.api.mapcore.util.cg.a aVar = this.h;
                    if (aVar != null && b != null) {
                        aVar.a(b, this.i);
                    }
                    com.amap.api.mapcore.util.cf.a d = this.c.d();
                    if (d != null && (bArr = d.a) != null) {
                        if (this.h == null) {
                            com.autonavi.base.amap.api.mapcore.IAMapDelegate iAMapDelegate = this.b;
                            if (iAMapDelegate != null) {
                                iAMapDelegate.setCustomMapStyle(iAMapDelegate.getMapConfig().isCustomStyleEnable(), d.a);
                            }
                        } else if (!java.util.Arrays.equals(bArr, b)) {
                            this.h.b(d.a, this.i);
                        }
                        a(str, d.a);
                        a(str, d.c);
                    }
                }
                com.amap.api.mapcore.util.gd.a(this.a, com.amap.api.mapcore.util.dl.a());
                com.autonavi.base.amap.api.mapcore.IAMapDelegate iAMapDelegate2 = this.b;
                if (iAMapDelegate2 != null) {
                    iAMapDelegate2.setRunLowFrame(false);
                }
            }
        } catch (java.lang.Throwable th) {
            com.amap.api.mapcore.util.gd.c(th, "CustomStyleTask", "download customStyle");
            th.printStackTrace();
        }
    }
}
