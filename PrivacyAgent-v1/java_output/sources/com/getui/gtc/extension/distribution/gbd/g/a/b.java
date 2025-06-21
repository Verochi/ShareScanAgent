package com.getui.gtc.extension.distribution.gbd.g.a;

/* loaded from: classes22.dex */
public final class b extends com.getui.gtc.extension.distribution.gbd.g.d {
    private static final java.lang.String y = "GBD_GALHP";
    private final java.lang.String A;
    private final int B;
    private final java.lang.String z;

    public b(com.getui.gtc.extension.distribution.gbd.g.c cVar, int i, java.lang.String str) {
        this.m = cVar;
        this.B = i;
        if (i == 24) {
            this.A = com.getui.gtc.extension.distribution.gbd.n.b.j();
            this.z = "303wlp";
            return;
        }
        if (i == 124) {
            this.A = com.getui.gtc.extension.distribution.gbd.n.b.d();
            this.z = "24al";
            this.w = str;
            this.x = "24al";
            return;
        }
        if (i == 28) {
            this.A = com.getui.gtc.extension.distribution.gbd.n.b.f();
            this.z = "28al";
        } else if (i != 29) {
            this.A = "unknown";
            this.z = "error";
        } else {
            this.A = com.getui.gtc.extension.distribution.gbd.n.b.h();
            this.z = "28 niche al";
            this.w = str;
            this.x = "28 niche al";
        }
    }

    @Override // com.getui.gtc.extension.distribution.gbd.g.d
    public final void a(int i) {
        int i2 = this.B;
        if (i2 != 29 && i2 != 124) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(y, this.z + " dl failed. " + i);
        }
        com.getui.gtc.extension.distribution.gbd.g.c cVar = this.m;
        if (cVar != null) {
            try {
                cVar.a(null);
            } catch (java.lang.Throwable th) {
                com.getui.gtc.extension.distribution.gbd.n.j.a(th);
            }
            int i3 = this.B;
            if (i3 == 29 || i3 == 124) {
                try {
                    if (i != 304) {
                        com.getui.gtc.extension.distribution.gbd.n.j.a(y, this.z + " dl failed. " + i);
                        return;
                    }
                    com.getui.gtc.extension.distribution.gbd.n.j.a(y, this.z + " file exists not need down, code = " + i);
                    if (new java.io.File(this.A).exists()) {
                        return;
                    }
                    int i4 = this.B;
                    if (i4 == 29) {
                        com.getui.gtc.extension.distribution.gbd.f.a.b.a();
                        com.getui.gtc.extension.distribution.gbd.f.a.b.c("");
                    } else if (i4 == 124) {
                        com.getui.gtc.extension.distribution.gbd.f.a.b.a();
                        com.getui.gtc.extension.distribution.gbd.f.a.b.b("");
                    }
                } catch (java.lang.Throwable th2) {
                    com.getui.gtc.extension.distribution.gbd.n.j.a(th2);
                }
            }
        }
    }

    @Override // com.getui.gtc.extension.distribution.gbd.g.d
    public final void a(java.lang.Throwable th) {
        com.getui.gtc.extension.distribution.gbd.n.j.a(y, this.z + " dl failed.");
        com.getui.gtc.extension.distribution.gbd.g.c cVar = this.m;
        if (cVar != null) {
            try {
                cVar.a(null);
            } catch (java.lang.Throwable th2) {
                com.getui.gtc.extension.distribution.gbd.n.j.a(th2);
            }
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x0099 -> B:28:0x00b4). Please report as a decompilation issue!!! */
    @Override // com.getui.gtc.extension.distribution.gbd.g.d
    public final void a(java.util.Map<java.lang.String, java.util.List<java.lang.String>> map, byte[] bArr) {
        java.util.List<java.lang.String> list;
        com.getui.gtc.extension.distribution.gbd.n.j.a(y, this.z + " dl success");
        try {
            com.getui.gtc.extension.distribution.gbd.g.c cVar = this.m;
            if (cVar != null) {
                if (bArr == null) {
                    cVar.a(null);
                    return;
                }
                com.getui.gtc.extension.distribution.gbd.n.i.a(bArr, this.A);
                com.getui.gtc.extension.distribution.gbd.n.j.a(y, this.z + " dl s, save to file with code = 200");
                int i = this.B;
                if (i == 29 || i == 124) {
                    try {
                        if (map.size() > 0 && (list = map.get("ETag")) != null && list.size() > 0) {
                            java.lang.String str = list.get(0);
                            if (!android.text.TextUtils.isEmpty(str)) {
                                com.getui.gtc.extension.distribution.gbd.n.j.a(y, this.z + " file etag save new = " + str);
                                int i2 = this.B;
                                if (i2 == 29) {
                                    com.getui.gtc.extension.distribution.gbd.f.a.b.a();
                                    com.getui.gtc.extension.distribution.gbd.f.a.b.c(str);
                                } else if (i2 == 124) {
                                    com.getui.gtc.extension.distribution.gbd.f.a.b.a();
                                    com.getui.gtc.extension.distribution.gbd.f.a.b.b(str);
                                }
                            }
                        }
                    } catch (java.lang.Throwable th) {
                        com.getui.gtc.extension.distribution.gbd.n.j.a.a.a.e("deal heads e = " + th.toString());
                    }
                }
                this.m.a(bArr);
            }
        } catch (java.lang.Throwable th2) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(th2);
        }
    }
}
