package com.amap.api.mapcore.util;

/* loaded from: classes12.dex */
public final class hm {
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
    public static int a(com.amap.api.mapcore.util.hl hlVar) {
        com.amap.api.mapcore.util.gy gyVar = null;
        try {
            try {
                if (hlVar.f.d()) {
                    hlVar.f.a_(true);
                    com.amap.api.mapcore.util.gy a = com.amap.api.mapcore.util.gy.a(new java.io.File(hlVar.a), hlVar.b);
                    try {
                        java.util.ArrayList arrayList = new java.util.ArrayList();
                        byte[] a2 = a(a, hlVar, arrayList);
                        if (a2 != null && a2.length != 0) {
                            com.amap.api.mapcore.util.gc gcVar = new com.amap.api.mapcore.util.gc(a2, hlVar.c);
                            com.amap.api.mapcore.util.hb.a();
                            org.json.JSONObject jSONObject = new org.json.JSONObject(new java.lang.String(com.amap.api.mapcore.util.hb.b(gcVar).a));
                            if (jSONObject.has("code") && jSONObject.getInt("code") == 1) {
                                com.amap.api.mapcore.util.Cif cif = hlVar.f;
                                if (cif != null) {
                                    cif.a_(a2.length);
                                }
                                if (hlVar.f.a() < Integer.MAX_VALUE) {
                                    a(a, arrayList);
                                } else {
                                    try {
                                        a.d();
                                    } catch (java.lang.Throwable th) {
                                        com.amap.api.mapcore.util.gd.c(th, "ofm", "dlo");
                                    }
                                }
                                return a2.length;
                            }
                            gyVar = a;
                        }
                        return -1;
                    } catch (java.lang.Throwable th2) {
                        th = th2;
                        gyVar = a;
                        try {
                            com.amap.api.mapcore.util.gd.c(th, "leg", "uts");
                            if (gyVar != null) {
                                gyVar.close();
                            }
                            return -1;
                        } catch (java.lang.Throwable th3) {
                            if (gyVar != null) {
                                try {
                                    gyVar.close();
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
            if (gyVar != null) {
                gyVar.close();
            }
        } catch (java.lang.Throwable th6) {
            th6.printStackTrace();
        }
        return -1;
    }

    private static void a(com.amap.api.mapcore.util.gy gyVar, java.util.List<java.lang.String> list) {
        if (gyVar != null) {
            try {
                java.util.Iterator<java.lang.String> it = list.iterator();
                while (it.hasNext()) {
                    gyVar.c(it.next());
                }
                gyVar.close();
            } catch (java.lang.Throwable th) {
                com.amap.api.mapcore.util.gd.c(th, "ofm", "dlo");
            }
        }
    }

    public static void a(java.lang.String str, byte[] bArr, com.amap.api.mapcore.util.hl hlVar) throws java.io.IOException, java.security.cert.CertificateException, java.security.NoSuchAlgorithmException, javax.crypto.IllegalBlockSizeException, javax.crypto.BadPaddingException, javax.crypto.NoSuchPaddingException, java.security.InvalidKeyException, java.security.spec.InvalidKeySpecException {
        com.amap.api.mapcore.util.gy gyVar;
        java.io.OutputStream outputStream = null;
        try {
            if (a(hlVar.a, str)) {
                return;
            }
            java.io.File file = new java.io.File(hlVar.a);
            if (!file.exists()) {
                file.mkdirs();
            }
            gyVar = com.amap.api.mapcore.util.gy.a(file, hlVar.b);
            try {
                gyVar.a(hlVar.d);
                byte[] b = hlVar.e.b(bArr);
                com.amap.api.mapcore.util.gy.a b2 = gyVar.b(str);
                outputStream = b2.a();
                outputStream.write(b);
                b2.b();
                gyVar.c();
                try {
                    outputStream.close();
                } catch (java.lang.Throwable th) {
                    th.printStackTrace();
                }
                try {
                    gyVar.close();
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
                if (gyVar == null) {
                    throw th;
                }
                try {
                    gyVar.close();
                    throw th;
                } catch (java.lang.Throwable th5) {
                    th5.printStackTrace();
                    throw th;
                }
            }
        } catch (java.lang.Throwable th6) {
            th = th6;
            gyVar = null;
        }
    }

    private static boolean a(java.lang.String str, java.lang.String str2) {
        try {
            return new java.io.File(str, str2 + ".0").exists();
        } catch (java.lang.Throwable th) {
            com.amap.api.mapcore.util.gd.c(th, "leg", com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.FET);
            return false;
        }
    }

    private static byte[] a(com.amap.api.mapcore.util.gy gyVar, com.amap.api.mapcore.util.hl hlVar, java.util.List<java.lang.String> list) {
        try {
            java.io.File b = gyVar.b();
            if (b != null && b.exists()) {
                int i = 0;
                for (java.lang.String str : b.list()) {
                    if (str.contains(".0")) {
                        java.lang.String str2 = str.split("\\.")[0];
                        byte[] a = com.amap.api.mapcore.util.hs.a(gyVar, str2);
                        i += a.length;
                        list.add(str2);
                        if (i > hlVar.f.a()) {
                            break;
                        }
                        hlVar.g.b(a);
                    }
                }
                if (i <= 0) {
                    return null;
                }
                return hlVar.g.a();
            }
        } catch (java.lang.Throwable th) {
            com.amap.api.mapcore.util.gd.c(th, "leg", "gCo");
        }
        return new byte[0];
    }
}
