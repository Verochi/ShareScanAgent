package com.alipay.sdk.m.p;

/* loaded from: classes.dex */
public final class c {
    public boolean a;
    public java.lang.String b = com.alipay.sdk.m.u.n.a(24);

    public c(boolean z) {
        this.a = z;
    }

    public static int a(java.lang.String str) {
        return java.lang.Integer.parseInt(str);
    }

    public static java.lang.String a(int i) {
        return java.lang.String.format(java.util.Locale.getDefault(), "%05d", java.lang.Integer.valueOf(i));
    }

    public static byte[] a(java.lang.String str, java.lang.String str2) {
        return com.alipay.sdk.m.n.d.a(str, str2);
    }

    public static byte[] a(java.lang.String str, byte[] bArr, java.lang.String str2) {
        return com.alipay.sdk.m.n.e.a(str, bArr, str2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x004f, code lost:
    
        if (r2 == null) goto L33;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0060 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:50:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0059 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r1v0, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.io.ByteArrayOutputStream] */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.io.ByteArrayOutputStream, java.io.OutputStream] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static byte[] a(byte[]... bArr) {
        java.io.OutputStream outputStream;
        java.io.DataOutputStream dataOutputStream;
        java.io.ByteArrayOutputStream byteArrayOutputStream = null;
        r0 = null;
        byte[] bArr2 = null;
        if (bArr != null) {
            ?? length = bArr.length;
            try {
                if (length != 0) {
                    try {
                        length = new java.io.ByteArrayOutputStream();
                        try {
                            dataOutputStream = new java.io.DataOutputStream(length);
                            try {
                                for (byte[] bArr3 : bArr) {
                                    dataOutputStream.write(a(bArr3.length).getBytes());
                                    dataOutputStream.write(bArr3);
                                }
                                dataOutputStream.flush();
                                byte[] byteArray = length.toByteArray();
                                try {
                                    length.close();
                                } catch (java.lang.Exception unused) {
                                }
                                bArr2 = byteArray;
                            } catch (java.lang.Exception e) {
                                e = e;
                                com.alipay.sdk.m.u.e.a(e);
                                if (length != 0) {
                                    try {
                                        length.close();
                                    } catch (java.lang.Exception unused2) {
                                    }
                                }
                            }
                        } catch (java.lang.Exception e2) {
                            e = e2;
                            dataOutputStream = null;
                        } catch (java.lang.Throwable th) {
                            th = th;
                            outputStream = null;
                            byteArrayOutputStream = length;
                            if (byteArrayOutputStream != null) {
                                try {
                                    byteArrayOutputStream.close();
                                } catch (java.lang.Exception unused3) {
                                }
                            }
                            if (outputStream != null) {
                                throw th;
                            }
                            try {
                                outputStream.close();
                                throw th;
                            } catch (java.lang.Exception unused4) {
                                throw th;
                            }
                        }
                    } catch (java.lang.Exception e3) {
                        e = e3;
                        length = 0;
                        dataOutputStream = null;
                    } catch (java.lang.Throwable th2) {
                        th = th2;
                        outputStream = null;
                        if (byteArrayOutputStream != null) {
                        }
                        if (outputStream != null) {
                        }
                    }
                    try {
                        dataOutputStream.close();
                    } catch (java.lang.Exception unused5) {
                    }
                    return bArr2;
                }
            } catch (java.lang.Throwable th3) {
                th = th3;
            }
        }
        return null;
    }

    public static byte[] b(java.lang.String str, byte[] bArr, java.lang.String str2) {
        return com.alipay.sdk.m.n.e.b(str, bArr, str2);
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x007d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public com.alipay.sdk.m.p.b a(com.alipay.sdk.m.p.d dVar, java.lang.String str) {
        java.io.ByteArrayInputStream byteArrayInputStream;
        java.lang.String str2;
        java.lang.String str3;
        java.io.ByteArrayInputStream byteArrayInputStream2 = null;
        try {
            byteArrayInputStream = new java.io.ByteArrayInputStream(dVar.a());
            try {
                try {
                    byte[] bArr = new byte[5];
                    byteArrayInputStream.read(bArr);
                    byte[] bArr2 = new byte[a(new java.lang.String(bArr))];
                    byteArrayInputStream.read(bArr2);
                    str2 = new java.lang.String(bArr2);
                } catch (java.lang.Exception e) {
                    e = e;
                    str2 = null;
                }
                try {
                    byte[] bArr3 = new byte[5];
                    byteArrayInputStream.read(bArr3);
                    int a = a(new java.lang.String(bArr3));
                    if (a > 0) {
                        byte[] bArr4 = new byte[a];
                        byteArrayInputStream.read(bArr4);
                        if (this.a) {
                            bArr4 = a(this.b, bArr4, str);
                        }
                        if (dVar.b()) {
                            bArr4 = com.alipay.sdk.m.n.b.b(bArr4);
                        }
                        str3 = new java.lang.String(bArr4);
                    } else {
                        str3 = null;
                    }
                    try {
                        byteArrayInputStream.close();
                    } catch (java.lang.Exception unused) {
                    }
                } catch (java.lang.Exception e2) {
                    e = e2;
                    com.alipay.sdk.m.u.e.a(e);
                    if (byteArrayInputStream != null) {
                        try {
                            byteArrayInputStream.close();
                        } catch (java.lang.Exception unused2) {
                        }
                    }
                    str3 = null;
                    if (str2 == null) {
                    }
                    return new com.alipay.sdk.m.p.b(str2, str3);
                }
            } catch (java.lang.Throwable th) {
                th = th;
                byteArrayInputStream2 = byteArrayInputStream;
                if (byteArrayInputStream2 != null) {
                    try {
                        byteArrayInputStream2.close();
                    } catch (java.lang.Exception unused3) {
                    }
                }
                throw th;
            }
        } catch (java.lang.Exception e3) {
            e = e3;
            byteArrayInputStream = null;
            str2 = null;
        } catch (java.lang.Throwable th2) {
            th = th2;
            if (byteArrayInputStream2 != null) {
            }
            throw th;
        }
        if (str2 == null || str3 != null) {
            return new com.alipay.sdk.m.p.b(str2, str3);
        }
        return null;
    }

    public com.alipay.sdk.m.p.d a(com.alipay.sdk.m.p.b bVar, boolean z, java.lang.String str) {
        if (bVar == null) {
            return null;
        }
        byte[] bytes = bVar.b().getBytes();
        byte[] bytes2 = bVar.a().getBytes();
        if (z) {
            try {
                bytes2 = com.alipay.sdk.m.n.b.a(bytes2);
            } catch (java.lang.Exception unused) {
                z = false;
            }
        }
        return new com.alipay.sdk.m.p.d(z, this.a ? a(bytes, a(this.b, com.alipay.sdk.m.l.a.e), b(this.b, bytes2, str)) : a(bytes, bytes2));
    }
}
