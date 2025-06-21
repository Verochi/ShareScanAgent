package com.sijla.mla;

/* loaded from: classes19.dex */
public final class c {
    private static long c;
    private com.sijla.mla.a.b a;
    private java.lang.String b = com.sijla.mla.L2.s110640747();

    public c(android.content.Context context) {
        com.sijla.mla.a.b bVar = new com.sijla.mla.a.b();
        this.a = bVar;
        bVar.w(new com.sijla.mla.a.b.a());
        this.a.w(new com.sijla.mla.a.b.o());
        this.a.w(new com.sijla.mla.a.b.b());
        this.a.w(new com.sijla.mla.a.b.r());
        this.a.w(new com.sijla.mla.a.b.q());
        this.a.w(new com.sijla.mla.a.b.c());
        this.a.w(new com.sijla.mla.e());
        this.a.w(new com.sijla.mla.a.b.m());
        this.a.w(new com.sijla.mla.a.b.k());
        this.a.w(new com.sijla.mla.a.b.f());
        this.a.w(new com.sijla.mla.a.b.e());
        this.a.w(new com.sijla.mla.a.b.h());
        this.a.w(new com.sijla.mla.a.b.i(context));
        com.sijla.mla.a.c.a(this.a);
        com.sijla.mla.a.a.g.a(this.a);
    }

    private static byte[] a() {
        java.io.File file = new java.io.File(b() + com.sijla.mla.L2.s110640747());
        if (!file.exists()) {
            return null;
        }
        try {
            return com.sijla.h.c.a(file);
        } catch (java.io.IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x012f A[Catch: IOException -> 0x013e, TRY_ENTER, TRY_LEAVE, TryCatch #6 {IOException -> 0x013e, blocks: (B:43:0x012f, B:51:0x013a), top: B:5:0x0018 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static byte[] a(android.content.Context context, java.lang.String str) {
        boolean z;
        byte[] a;
        java.io.InputStream inputStream;
        java.lang.String optString;
        java.io.InputStream inputStream2;
        if (java.lang.System.currentTimeMillis() - c > 600000) {
            c = java.lang.System.currentTimeMillis();
            z = true;
        } else {
            z = false;
        }
        try {
            if (z) {
                try {
                    optString = com.sijla.c.d.a.optString("jmla", com.sijla.mla.L2.jmla());
                } catch (java.lang.Throwable th) {
                    th = th;
                    inputStream = null;
                }
                if (!android.text.TextUtils.isEmpty(optString)) {
                    java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer(optString);
                    stringBuffer.append("?sn=");
                    stringBuffer.append(str);
                    stringBuffer.append("&pkg=");
                    stringBuffer.append(context.getPackageName());
                    stringBuffer.append("&uid=");
                    stringBuffer.append(com.sijla.h.i.b(context));
                    stringBuffer.append("&abi=");
                    stringBuffer.append(com.sijla.h.c.b());
                    stringBuffer.append("&sot=");
                    stringBuffer.append(com.sijla.mla.L2.sot());
                    stringBuffer.append("&sov=");
                    stringBuffer.append(com.sijla.mla.L2.sov());
                    stringBuffer.append("&sdkver=20230823");
                    java.io.File file = new java.io.File(b() + com.sijla.mla.L2.s110640747());
                    java.lang.String a2 = file.exists() ? com.sijla.h.a.g.a(com.sijla.h.c.a(file)) : "";
                    stringBuffer.append("&lv=");
                    stringBuffer.append(a2);
                    java.lang.String stringBuffer2 = stringBuffer.toString();
                    com.sijla.h.c.a.a();
                    java.net.HttpURLConnection a3 = com.sijla.h.c.a.a(stringBuffer2);
                    a3.setConnectTimeout(3000);
                    a3.setRequestMethod(com.sijla.mla.L2.s33583822());
                    if (a3.getResponseCode() == 200) {
                        inputStream2 = a3.getInputStream();
                        try {
                            byte[] a4 = com.sijla.c.a.a(inputStream2);
                            inputStream2.close();
                            if (a4 != null && a4.length > 0) {
                                try {
                                    java.lang.String b = b();
                                    com.sijla.h.a.e.a(new java.io.File(b));
                                    com.sijla.h.a.e.a(b);
                                    java.lang.String str2 = b + com.sijla.mla.L2.s110640747();
                                    java.io.File file2 = new java.io.File(str2);
                                    if (file2.exists()) {
                                        file2.delete();
                                    }
                                    com.sijla.h.a.e.a(str2, a4);
                                } catch (java.lang.Throwable th2) {
                                    th2.printStackTrace();
                                }
                                byte[] a5 = a(a4, str);
                                if (a5 != null) {
                                    if (a5.length > 0) {
                                        try {
                                            inputStream2.close();
                                        } catch (java.io.IOException e) {
                                            e.printStackTrace();
                                        }
                                        return a5;
                                    }
                                }
                            }
                        } catch (java.lang.Throwable th3) {
                            inputStream = inputStream2;
                            th = th3;
                            try {
                                th.printStackTrace();
                                if (inputStream != null) {
                                    inputStream.close();
                                }
                                a = a(a(), str);
                                if (a != null) {
                                }
                                return null;
                            } catch (java.lang.Throwable th4) {
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (java.io.IOException e2) {
                                        e2.printStackTrace();
                                    }
                                }
                                throw th4;
                            }
                        }
                        if (inputStream2 != null) {
                            inputStream2.close();
                        }
                    }
                }
                inputStream2 = null;
                if (inputStream2 != null) {
                }
            }
        } catch (java.io.IOException e3) {
            e3.printStackTrace();
        }
        a = a(a(), str);
        if (a != null || a.length <= 0) {
            return null;
        }
        return a;
    }

    private static byte[] a(byte[] bArr, java.lang.String str) {
        if (bArr == null) {
            return null;
        }
        try {
            return com.sijla.mla.L2.xx2(bArr, str.getBytes());
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    private static java.lang.String b() {
        return com.sijla.h.c.i().getCacheDir() + "/.mla/";
    }

    public final void a(android.content.Context context) {
        this.a.c = new com.sijla.mla.d(this, context);
    }

    public final void a(java.lang.Object... objArr) {
        try {
            this.a.a(this.b).b(com.sijla.mla.e.a(objArr));
        } catch (java.lang.Throwable unused) {
            java.lang.System.out.println("catch qmt error ");
        }
    }
}
