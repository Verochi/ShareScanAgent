package com.amap.api.col.s;

/* loaded from: classes12.dex */
public final class dg {
    /* JADX WARN: Code restructure failed: missing block: B:36:0x007d, code lost:
    
        r3.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0081, code lost:
    
        r10 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0082, code lost:
    
        r10.printStackTrace();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int a(com.amap.api.col.s.df dfVar) {
        com.amap.api.col.s.cu cuVar = null;
        try {
            try {
                if (dfVar.f.c()) {
                    dfVar.f.a(true);
                    com.amap.api.col.s.cu a = com.amap.api.col.s.cu.a(new java.io.File(dfVar.a), dfVar.b);
                    try {
                        java.util.ArrayList arrayList = new java.util.ArrayList();
                        byte[] d = d(a, dfVar, arrayList);
                        if (d != null && d.length != 0) {
                            com.amap.api.col.s.ci ciVar = new com.amap.api.col.s.ci(d, dfVar.c);
                            com.amap.api.col.s.cx.a();
                            org.json.JSONObject jSONObject = new org.json.JSONObject(new java.lang.String(com.amap.api.col.s.cx.a(ciVar).a));
                            if (jSONObject.has("code") && jSONObject.getInt("code") == 1) {
                                com.amap.api.col.s.dy dyVar = dfVar.f;
                                if (dyVar != null) {
                                    dyVar.a(d.length);
                                }
                                if (dfVar.f.b() < Integer.MAX_VALUE) {
                                    b(a, arrayList);
                                } else {
                                    try {
                                        a.c();
                                    } catch (java.lang.Throwable th) {
                                        com.amap.api.col.s.cj.c(th, "ofm", "dlo");
                                    }
                                }
                                return d.length;
                            }
                            cuVar = a;
                        }
                        return -1;
                    } catch (java.lang.Throwable th2) {
                        th = th2;
                        cuVar = a;
                        try {
                            com.amap.api.col.s.cj.c(th, "leg", "uts");
                            if (cuVar != null) {
                                cuVar.close();
                            }
                            return -1;
                        } catch (java.lang.Throwable th3) {
                            if (cuVar != null) {
                                try {
                                    cuVar.close();
                                } catch (java.lang.Throwable th4) {
                                    th4.printStackTrace();
                                }
                            }
                            throw th3;
                        }
                    }
                }
            } catch (java.lang.Throwable th5) {
                th = th5;
            }
            if (cuVar != null) {
                cuVar.close();
            }
        } catch (java.lang.Throwable th6) {
            th6.printStackTrace();
        }
        return -1;
    }

    public static void a(java.lang.String str, byte[] bArr, com.amap.api.col.s.df dfVar) throws java.io.IOException, java.security.cert.CertificateException, java.security.NoSuchAlgorithmException, javax.crypto.IllegalBlockSizeException, javax.crypto.BadPaddingException, javax.crypto.NoSuchPaddingException, java.security.InvalidKeyException, java.security.spec.InvalidKeySpecException {
        com.amap.api.col.s.cu cuVar;
        java.io.OutputStream outputStream = null;
        try {
            if (c(dfVar.a, str)) {
                return;
            }
            java.io.File file = new java.io.File(dfVar.a);
            if (!file.exists()) {
                file.mkdirs();
            }
            cuVar = com.amap.api.col.s.cu.a(file, dfVar.b);
            try {
                cuVar.a(dfVar.d);
                byte[] b = dfVar.e.b(bArr);
                com.amap.api.col.s.cu.a b2 = cuVar.b(str);
                outputStream = b2.a();
                outputStream.write(b);
                b2.b();
                cuVar.b();
                try {
                    outputStream.close();
                } catch (java.lang.Throwable th) {
                    th.printStackTrace();
                }
                try {
                    cuVar.close();
                } catch (java.lang.Throwable th2) {
                    th2.printStackTrace();
                }
            } catch (java.lang.Throwable th3) {
                th = th3;
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (java.lang.Throwable th4) {
                        th4.printStackTrace();
                    }
                }
                if (cuVar == null) {
                    throw th;
                }
                try {
                    cuVar.close();
                    throw th;
                } catch (java.lang.Throwable th5) {
                    th5.printStackTrace();
                    throw th;
                }
            }
        } catch (java.lang.Throwable th6) {
            th = th6;
            cuVar = null;
        }
    }

    public static void b(com.amap.api.col.s.cu cuVar, java.util.List<java.lang.String> list) {
        if (cuVar != null) {
            try {
                java.util.Iterator<java.lang.String> it = list.iterator();
                while (it.hasNext()) {
                    cuVar.c(it.next());
                }
                cuVar.close();
            } catch (java.lang.Throwable th) {
                com.amap.api.col.s.cj.c(th, "ofm", "dlo");
            }
        }
    }

    public static boolean c(java.lang.String str, java.lang.String str2) {
        try {
            return new java.io.File(str, str2 + ".0").exists();
        } catch (java.lang.Throwable th) {
            com.amap.api.col.s.cj.c(th, "leg", com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.FET);
            return false;
        }
    }

    public static byte[] d(com.amap.api.col.s.cu cuVar, com.amap.api.col.s.df dfVar, java.util.List<java.lang.String> list) {
        try {
            java.io.File a = cuVar.a();
            if (a != null && a.exists()) {
                int i = 0;
                for (java.lang.String str : a.list()) {
                    if (str.contains(".0")) {
                        java.lang.String str2 = str.split("\\.")[0];
                        byte[] b = com.amap.api.col.s.dl.b(cuVar, str2);
                        i += b.length;
                        list.add(str2);
                        if (i > dfVar.f.b()) {
                            break;
                        }
                        dfVar.g.b(b);
                    }
                }
                if (i <= 0) {
                    return null;
                }
                return dfVar.g.a();
            }
        } catch (java.lang.Throwable th) {
            com.amap.api.col.s.cj.c(th, "leg", "gCo");
        }
        return new byte[0];
    }
}
