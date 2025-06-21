package com.umeng.analytics.pro;

/* loaded from: classes19.dex */
public class cf {
    private final com.umeng.analytics.pro.db a;
    private final com.umeng.analytics.pro.Cdo b;

    public cf() {
        this(new com.umeng.analytics.pro.cv.a());
    }

    public cf(com.umeng.analytics.pro.dd ddVar) {
        com.umeng.analytics.pro.Cdo cdo = new com.umeng.analytics.pro.Cdo();
        this.b = cdo;
        this.a = ddVar.a(cdo);
    }

    private java.lang.Object a(byte b, byte[] bArr, com.umeng.analytics.pro.cj cjVar, com.umeng.analytics.pro.cj... cjVarArr) throws com.umeng.analytics.pro.ci {
        try {
            try {
                com.umeng.analytics.pro.cw j = j(bArr, cjVar, cjVarArr);
                if (j != null) {
                    if (b != 2) {
                        if (b != 3) {
                            if (b != 4) {
                                if (b != 6) {
                                    if (b != 8) {
                                        if (b != 100) {
                                            if (b != 10) {
                                                if (b == 11 && j.b == 11) {
                                                    return this.a.z();
                                                }
                                            } else if (j.b == 10) {
                                                return java.lang.Long.valueOf(this.a.x());
                                            }
                                        } else if (j.b == 11) {
                                            return this.a.A();
                                        }
                                    } else if (j.b == 8) {
                                        return java.lang.Integer.valueOf(this.a.w());
                                    }
                                } else if (j.b == 6) {
                                    return java.lang.Short.valueOf(this.a.v());
                                }
                            } else if (j.b == 4) {
                                return java.lang.Double.valueOf(this.a.y());
                            }
                        } else if (j.b == 3) {
                            return java.lang.Byte.valueOf(this.a.u());
                        }
                    } else if (j.b == 2) {
                        return java.lang.Boolean.valueOf(this.a.t());
                    }
                }
                this.b.e();
                this.a.B();
                return null;
            } catch (java.lang.Exception e) {
                throw new com.umeng.analytics.pro.ci(e);
            }
        } finally {
            this.b.e();
            this.a.B();
        }
    }

    private com.umeng.analytics.pro.cw j(byte[] bArr, com.umeng.analytics.pro.cj cjVar, com.umeng.analytics.pro.cj... cjVarArr) throws com.umeng.analytics.pro.ci {
        this.b.a(bArr);
        int length = cjVarArr.length + 1;
        com.umeng.analytics.pro.cj[] cjVarArr2 = new com.umeng.analytics.pro.cj[length];
        int i = 0;
        cjVarArr2[0] = cjVar;
        int i2 = 0;
        while (i2 < cjVarArr.length) {
            int i3 = i2 + 1;
            cjVarArr2[i3] = cjVarArr[i2];
            i2 = i3;
        }
        this.a.j();
        com.umeng.analytics.pro.cw cwVar = null;
        while (i < length) {
            cwVar = this.a.l();
            if (cwVar.b == 0 || cwVar.c > cjVarArr2[i].a()) {
                return null;
            }
            if (cwVar.c != cjVarArr2[i].a()) {
                com.umeng.analytics.pro.de.a(this.a, cwVar.b);
                this.a.m();
            } else {
                i++;
                if (i < length) {
                    this.a.j();
                }
            }
        }
        return cwVar;
    }

    public java.lang.Boolean a(byte[] bArr, com.umeng.analytics.pro.cj cjVar, com.umeng.analytics.pro.cj... cjVarArr) throws com.umeng.analytics.pro.ci {
        return (java.lang.Boolean) a((byte) 2, bArr, cjVar, cjVarArr);
    }

    public void a(com.umeng.analytics.pro.cc ccVar, java.lang.String str) throws com.umeng.analytics.pro.ci {
        a(ccVar, str.getBytes());
    }

    public void a(com.umeng.analytics.pro.cc ccVar, java.lang.String str, java.lang.String str2) throws com.umeng.analytics.pro.ci {
        try {
            try {
                a(ccVar, str.getBytes(str2));
            } catch (java.io.UnsupportedEncodingException unused) {
                throw new com.umeng.analytics.pro.ci("JVM DOES NOT SUPPORT ENCODING: " + str2);
            }
        } finally {
            this.a.B();
        }
    }

    public void a(com.umeng.analytics.pro.cc ccVar, byte[] bArr) throws com.umeng.analytics.pro.ci {
        try {
            this.b.a(bArr);
            ccVar.read(this.a);
        } finally {
            this.b.e();
            this.a.B();
        }
    }

    public void a(com.umeng.analytics.pro.cc ccVar, byte[] bArr, com.umeng.analytics.pro.cj cjVar, com.umeng.analytics.pro.cj... cjVarArr) throws com.umeng.analytics.pro.ci {
        try {
            try {
                if (j(bArr, cjVar, cjVarArr) != null) {
                    ccVar.read(this.a);
                }
            } catch (java.lang.Exception e) {
                throw new com.umeng.analytics.pro.ci(e);
            }
        } finally {
            this.b.e();
            this.a.B();
        }
    }

    public java.lang.Byte b(byte[] bArr, com.umeng.analytics.pro.cj cjVar, com.umeng.analytics.pro.cj... cjVarArr) throws com.umeng.analytics.pro.ci {
        return (java.lang.Byte) a((byte) 3, bArr, cjVar, cjVarArr);
    }

    public java.lang.Double c(byte[] bArr, com.umeng.analytics.pro.cj cjVar, com.umeng.analytics.pro.cj... cjVarArr) throws com.umeng.analytics.pro.ci {
        return (java.lang.Double) a((byte) 4, bArr, cjVar, cjVarArr);
    }

    public java.lang.Short d(byte[] bArr, com.umeng.analytics.pro.cj cjVar, com.umeng.analytics.pro.cj... cjVarArr) throws com.umeng.analytics.pro.ci {
        return (java.lang.Short) a((byte) 6, bArr, cjVar, cjVarArr);
    }

    public java.lang.Integer e(byte[] bArr, com.umeng.analytics.pro.cj cjVar, com.umeng.analytics.pro.cj... cjVarArr) throws com.umeng.analytics.pro.ci {
        return (java.lang.Integer) a((byte) 8, bArr, cjVar, cjVarArr);
    }

    public java.lang.Long f(byte[] bArr, com.umeng.analytics.pro.cj cjVar, com.umeng.analytics.pro.cj... cjVarArr) throws com.umeng.analytics.pro.ci {
        return (java.lang.Long) a((byte) 10, bArr, cjVar, cjVarArr);
    }

    public java.lang.String g(byte[] bArr, com.umeng.analytics.pro.cj cjVar, com.umeng.analytics.pro.cj... cjVarArr) throws com.umeng.analytics.pro.ci {
        return (java.lang.String) a((byte) 11, bArr, cjVar, cjVarArr);
    }

    public java.nio.ByteBuffer h(byte[] bArr, com.umeng.analytics.pro.cj cjVar, com.umeng.analytics.pro.cj... cjVarArr) throws com.umeng.analytics.pro.ci {
        return (java.nio.ByteBuffer) a((byte) 100, bArr, cjVar, cjVarArr);
    }

    public java.lang.Short i(byte[] bArr, com.umeng.analytics.pro.cj cjVar, com.umeng.analytics.pro.cj... cjVarArr) throws com.umeng.analytics.pro.ci {
        try {
            try {
                if (j(bArr, cjVar, cjVarArr) != null) {
                    this.a.j();
                    return java.lang.Short.valueOf(this.a.l().c);
                }
                this.b.e();
                this.a.B();
                return null;
            } catch (java.lang.Exception e) {
                throw new com.umeng.analytics.pro.ci(e);
            }
        } finally {
            this.b.e();
            this.a.B();
        }
    }
}
