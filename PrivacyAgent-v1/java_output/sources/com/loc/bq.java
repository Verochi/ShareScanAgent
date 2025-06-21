package com.loc;

/* loaded from: classes23.dex */
public abstract class bq extends com.loc.s {
    protected android.content.Context a;
    protected com.loc.x b;
    protected byte[] c;

    public bq(android.content.Context context, com.loc.x xVar) {
        if (context != null) {
            this.a = context.getApplicationContext();
        }
        this.b = xVar;
        r();
    }

    private static byte[] A() {
        java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
        try {
            byteArrayOutputStream.write(com.loc.y.a("PANDORA$"));
            byteArrayOutputStream.write(new byte[]{1});
            byteArrayOutputStream.write(new byte[]{0});
            return byteArrayOutputStream.toByteArray();
        } catch (java.lang.Throwable th) {
            try {
                com.loc.at.a(th, "bre", "gbh");
                try {
                    byteArrayOutputStream.close();
                    return null;
                } catch (java.lang.Throwable th2) {
                    com.loc.at.a(th2, "bre", "gbh");
                    return null;
                }
            } finally {
                try {
                    byteArrayOutputStream.close();
                } catch (java.lang.Throwable th3) {
                    com.loc.at.a(th3, "bre", "gbh");
                }
            }
        }
    }

    private byte[] B() {
        java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
        try {
            byteArrayOutputStream.write(new byte[]{3});
            if (i()) {
                android.content.Context context = this.a;
                boolean k = k();
                com.loc.x xVar = this.b;
                byte[] a = com.loc.o.a(context, k, xVar != null && "navi".equals(xVar.a()));
                byteArrayOutputStream.write(a(a));
                byteArrayOutputStream.write(a);
            } else {
                byteArrayOutputStream.write(new byte[]{0, 0});
            }
            byte[] a2 = com.loc.y.a(f());
            if (a2 == null || a2.length <= 0) {
                byteArrayOutputStream.write(new byte[]{0, 0});
            } else {
                byteArrayOutputStream.write(a(a2));
                byteArrayOutputStream.write(a2);
            }
            byte[] a3 = com.loc.y.a(j());
            if (a3 == null || a3.length <= 0) {
                byteArrayOutputStream.write(new byte[]{0, 0});
            } else {
                byteArrayOutputStream.write(a(a3));
                byteArrayOutputStream.write(a3);
            }
            return byteArrayOutputStream.toByteArray();
        } catch (java.lang.Throwable th) {
            try {
                com.loc.at.a(th, "bre", "gpd");
                try {
                    byteArrayOutputStream.close();
                } catch (java.lang.Throwable th2) {
                    com.loc.at.a(th2, "bre", "gred");
                }
                return new byte[]{0};
            } finally {
                try {
                    byteArrayOutputStream.close();
                } catch (java.lang.Throwable th3) {
                    com.loc.at.a(th3, "bre", "gred");
                }
            }
        }
    }

    private byte[] C() {
        java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
        try {
            byte[] a_ = a_();
            if (a_ != null && a_.length != 0) {
                byteArrayOutputStream.write(new byte[]{1});
                byteArrayOutputStream.write(a(a_));
                byteArrayOutputStream.write(a_);
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(new byte[]{0});
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            try {
                byteArrayOutputStream.close();
            } catch (java.lang.Throwable th) {
                com.loc.at.a(th, "bre", "grrd");
            }
            return byteArray;
        } catch (java.lang.Throwable th2) {
            try {
                com.loc.at.a(th2, "bre", "grrd");
                try {
                    byteArrayOutputStream.close();
                } catch (java.lang.Throwable th3) {
                    com.loc.at.a(th3, "bre", "grrd");
                }
                return new byte[]{0};
            } finally {
                try {
                    byteArrayOutputStream.close();
                } catch (java.lang.Throwable th4) {
                    com.loc.at.a(th4, "bre", "grrd");
                }
            }
        }
    }

    private byte[] D() {
        java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
        try {
            byte[] b_ = b_();
            if (b_ != null && b_.length != 0) {
                byteArrayOutputStream.write(new byte[]{1});
                byte[] a = com.loc.o.a(b_);
                byteArrayOutputStream.write(a(a));
                byteArrayOutputStream.write(a);
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(new byte[]{0});
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            try {
                byteArrayOutputStream.close();
            } catch (java.lang.Throwable th) {
                com.loc.at.a(th, "bre", "gred");
            }
            return byteArray;
        } catch (java.lang.Throwable th2) {
            try {
                com.loc.at.a(th2, "bre", "gred");
                try {
                    byteArrayOutputStream.close();
                } catch (java.lang.Throwable th3) {
                    com.loc.at.a(th3, "bre", "gred");
                }
                return new byte[]{0};
            } finally {
                try {
                    byteArrayOutputStream.close();
                } catch (java.lang.Throwable th4) {
                    com.loc.at.a(th4, "bre", "gred");
                }
            }
        }
    }

    public static byte[] a(byte[] bArr) {
        return com.loc.y.a(bArr.length);
    }

    public abstract byte[] a_();

    public abstract byte[] b_();

    @Override // com.loc.bu
    public final byte[] d() {
        byte[] bArr = this.c;
        if (bArr != null) {
            return bArr;
        }
        java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
        try {
            byteArrayOutputStream.write(A());
            byteArrayOutputStream.write(B());
            byteArrayOutputStream.write(C());
            byteArrayOutputStream.write(D());
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            this.c = byteArray;
            return byteArray;
        } catch (java.lang.Throwable th) {
            try {
                com.loc.at.a(th, "bre", "geb");
                try {
                    byteArrayOutputStream.close();
                    return null;
                } catch (java.lang.Throwable th2) {
                    com.loc.at.a(th2, "bre", "geb");
                    return null;
                }
            } finally {
                try {
                    byteArrayOutputStream.close();
                } catch (java.lang.Throwable th3) {
                    com.loc.at.a(th3, "bre", "geb");
                }
            }
        }
    }

    @Override // com.loc.bu
    public java.util.Map<java.lang.String, java.lang.String> e() {
        java.lang.String f = com.loc.m.f(this.a);
        java.lang.String a = com.loc.o.a();
        java.lang.String a2 = com.loc.o.a(this.a, a, "key=".concat(java.lang.String.valueOf(f)));
        java.util.HashMap hashMap = new java.util.HashMap();
        hashMap.put("ts", a);
        hashMap.put("key", f);
        hashMap.put("scode", a2);
        return hashMap;
    }

    public java.lang.String f() {
        return "2.1";
    }

    public boolean i() {
        return true;
    }

    public java.lang.String j() {
        return java.lang.String.format("platform=Android&sdkversion=%s&product=%s", this.b.c(), this.b.a());
    }

    public boolean k() {
        return false;
    }
}
