package com.amap.api.col.s;

/* loaded from: classes12.dex */
public abstract class cy extends com.amap.api.col.s.bp {
    protected android.content.Context a;
    protected com.amap.api.col.s.bt b;

    public cy(android.content.Context context, com.amap.api.col.s.bt btVar) {
        if (context != null) {
            this.a = context.getApplicationContext();
        }
        this.b = btVar;
        q();
    }

    public static byte[] A() {
        java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
        try {
            byteArrayOutputStream.write(new byte[]{0});
            return byteArrayOutputStream.toByteArray();
        } catch (java.lang.Throwable th) {
            try {
                com.amap.api.col.s.cg.a(th, "bre", "grrd");
                try {
                    byteArrayOutputStream.close();
                } catch (java.lang.Throwable th2) {
                    com.amap.api.col.s.cg.a(th2, "bre", "grrd");
                }
                return new byte[]{0};
            } finally {
                try {
                    byteArrayOutputStream.close();
                } catch (java.lang.Throwable th3) {
                    com.amap.api.col.s.cg.a(th3, "bre", "grrd");
                }
            }
        }
    }

    public static byte[] C(byte[] bArr) {
        return com.amap.api.col.s.bu.a(bArr.length);
    }

    public static byte[] D() {
        java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
        try {
            byteArrayOutputStream.write(com.amap.api.col.s.bu.a("PANDORA$"));
            byteArrayOutputStream.write(new byte[]{1});
            byteArrayOutputStream.write(new byte[]{0});
            return byteArrayOutputStream.toByteArray();
        } catch (java.lang.Throwable th) {
            try {
                com.amap.api.col.s.cg.a(th, "bre", "gbh");
                try {
                    byteArrayOutputStream.close();
                    return null;
                } catch (java.lang.Throwable th2) {
                    com.amap.api.col.s.cg.a(th2, "bre", "gbh");
                    return null;
                }
            } finally {
                try {
                    byteArrayOutputStream.close();
                } catch (java.lang.Throwable th3) {
                    com.amap.api.col.s.cg.a(th3, "bre", "gbh");
                }
            }
        }
    }

    public final byte[] B() {
        java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
        try {
            byte[] b = b();
            if (b != null && b.length != 0) {
                byteArrayOutputStream.write(new byte[]{1});
                byte[] a = com.amap.api.col.s.bl.a(b);
                byteArrayOutputStream.write(C(a));
                byteArrayOutputStream.write(a);
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(new byte[]{0});
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            try {
                byteArrayOutputStream.close();
            } catch (java.lang.Throwable th) {
                com.amap.api.col.s.cg.a(th, "bre", "gred");
            }
            return byteArray;
        } catch (java.lang.Throwable th2) {
            try {
                com.amap.api.col.s.cg.a(th2, "bre", "gred");
                try {
                    byteArrayOutputStream.close();
                } catch (java.lang.Throwable th3) {
                    com.amap.api.col.s.cg.a(th3, "bre", "gred");
                }
                return new byte[]{0};
            } finally {
                try {
                    byteArrayOutputStream.close();
                } catch (java.lang.Throwable th4) {
                    com.amap.api.col.s.cg.a(th4, "bre", "gred");
                }
            }
        }
    }

    public abstract byte[] b();

    public java.lang.String d() {
        return "2.1";
    }

    @Override // com.amap.api.col.s.dd
    public final java.util.Map<java.lang.String, java.lang.String> e() {
        java.lang.String f = com.amap.api.col.s.bi.f(this.a);
        java.lang.String a = com.amap.api.col.s.bl.a();
        java.lang.String a2 = com.amap.api.col.s.bl.a(this.a, a, "key=".concat(java.lang.String.valueOf(f)));
        java.util.HashMap hashMap = new java.util.HashMap();
        hashMap.put("ts", a);
        hashMap.put("key", f);
        hashMap.put("scode", a2);
        return hashMap;
    }

    @Override // com.amap.api.col.s.dd
    public final byte[] g() {
        java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
        try {
            byteArrayOutputStream.write(D());
            byteArrayOutputStream.write(z());
            byteArrayOutputStream.write(A());
            byteArrayOutputStream.write(B());
            return byteArrayOutputStream.toByteArray();
        } catch (java.lang.Throwable th) {
            try {
                com.amap.api.col.s.cg.a(th, "bre", "geb");
                try {
                    byteArrayOutputStream.close();
                    return null;
                } catch (java.lang.Throwable th2) {
                    com.amap.api.col.s.cg.a(th2, "bre", "geb");
                    return null;
                }
            } finally {
                try {
                    byteArrayOutputStream.close();
                } catch (java.lang.Throwable th3) {
                    com.amap.api.col.s.cg.a(th3, "bre", "geb");
                }
            }
        }
    }

    public final java.lang.String j() {
        return java.lang.String.format("platform=Android&sdkversion=%s&product=%s", this.b.d(), this.b.b());
    }

    public final byte[] z() {
        java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
        try {
            byteArrayOutputStream.write(new byte[]{3});
            android.content.Context context = this.a;
            com.amap.api.col.s.bt btVar = this.b;
            byte[] a = com.amap.api.col.s.bl.a(context, btVar != null && "navi".equals(btVar.b()));
            byteArrayOutputStream.write(C(a));
            byteArrayOutputStream.write(a);
            byte[] a2 = com.amap.api.col.s.bu.a(d());
            if (a2 == null || a2.length <= 0) {
                byteArrayOutputStream.write(new byte[]{0, 0});
            } else {
                byteArrayOutputStream.write(C(a2));
                byteArrayOutputStream.write(a2);
            }
            byte[] a3 = com.amap.api.col.s.bu.a(j());
            if (a3 == null || a3.length <= 0) {
                byteArrayOutputStream.write(new byte[]{0, 0});
            } else {
                byteArrayOutputStream.write(C(a3));
                byteArrayOutputStream.write(a3);
            }
            return byteArrayOutputStream.toByteArray();
        } catch (java.lang.Throwable th) {
            try {
                com.amap.api.col.s.cg.a(th, "bre", "gpd");
                try {
                    byteArrayOutputStream.close();
                } catch (java.lang.Throwable th2) {
                    com.amap.api.col.s.cg.a(th2, "bre", "gred");
                }
                return new byte[]{0};
            } finally {
                try {
                    byteArrayOutputStream.close();
                } catch (java.lang.Throwable th3) {
                    com.amap.api.col.s.cg.a(th3, "bre", "gred");
                }
            }
        }
    }
}
