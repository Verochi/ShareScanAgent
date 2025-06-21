package com.loc;

/* loaded from: classes23.dex */
public final class by {
    public static int a(com.loc.bx bxVar) {
        com.loc.bm bmVar = null;
        try {
            try {
                if (bxVar.f.c()) {
                    bxVar.f.a(true);
                    com.loc.bm a = com.loc.bm.a(new java.io.File(bxVar.a), bxVar.b);
                    try {
                        java.util.ArrayList arrayList = new java.util.ArrayList();
                        byte[] a2 = a(a, bxVar, arrayList);
                        if (a2 != null && a2.length != 0) {
                            com.loc.av avVar = new com.loc.av(a2, bxVar.c);
                            com.loc.bp.a();
                            org.json.JSONObject jSONObject = new org.json.JSONObject(new java.lang.String(com.loc.bp.a(avVar).a));
                            if (jSONObject.has("code") && jSONObject.getInt("code") == 1) {
                                com.loc.cq cqVar = bxVar.f;
                                if (cqVar != null) {
                                    cqVar.a(a2.length);
                                }
                                if (bxVar.f.b() < Integer.MAX_VALUE) {
                                    a(a, arrayList);
                                } else {
                                    try {
                                        a.d();
                                    } catch (java.lang.Throwable th) {
                                        com.loc.aw.b(th, "ofm", "dlo");
                                    }
                                }
                                return a2.length;
                            }
                            bmVar = a;
                        }
                        try {
                            a.close();
                        } catch (java.lang.Throwable th2) {
                            th2.printStackTrace();
                        }
                        return -1;
                    } catch (java.lang.Throwable th3) {
                        th = th3;
                        bmVar = a;
                        try {
                            com.loc.aw.b(th, "leg", "uts");
                            if (bmVar != null) {
                                bmVar.close();
                            }
                            return -1;
                        } catch (java.lang.Throwable th4) {
                            if (bmVar != null) {
                                try {
                                    bmVar.close();
                                } catch (java.lang.Throwable th5) {
                                    th5.printStackTrace();
                                }
                            }
                            throw th4;
                        }
                    }
                }
            } catch (java.lang.Throwable th6) {
                th = th6;
            }
            if (bmVar != null) {
                bmVar.close();
            }
        } catch (java.lang.Throwable th7) {
            th7.printStackTrace();
        }
        return -1;
    }

    private static void a(com.loc.bm bmVar, java.util.List<java.lang.String> list) {
        if (bmVar != null) {
            try {
                java.util.Iterator<java.lang.String> it = list.iterator();
                while (it.hasNext()) {
                    bmVar.c(it.next());
                }
                bmVar.close();
            } catch (java.lang.Throwable th) {
                com.loc.aw.b(th, "ofm", "dlo");
            }
        }
    }

    public static void a(java.lang.String str, byte[] bArr, com.loc.bx bxVar) throws java.io.IOException, java.security.cert.CertificateException, java.security.NoSuchAlgorithmException, javax.crypto.IllegalBlockSizeException, javax.crypto.BadPaddingException, javax.crypto.NoSuchPaddingException, java.security.InvalidKeyException, java.security.spec.InvalidKeySpecException {
        com.loc.bm bmVar;
        java.io.OutputStream outputStream = null;
        try {
            if (a(bxVar.a, str)) {
                return;
            }
            java.io.File file = new java.io.File(bxVar.a);
            if (!file.exists()) {
                file.mkdirs();
            }
            bmVar = com.loc.bm.a(file, bxVar.b);
            try {
                bmVar.a(bxVar.d);
                byte[] b = bxVar.e.b(bArr);
                com.loc.bm.a b2 = bmVar.b(str);
                outputStream = b2.a();
                outputStream.write(b);
                b2.b();
                bmVar.c();
                try {
                    outputStream.close();
                } catch (java.lang.Throwable th) {
                    th.printStackTrace();
                }
                try {
                    bmVar.close();
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
                if (bmVar == null) {
                    throw th;
                }
                try {
                    bmVar.close();
                    throw th;
                } catch (java.lang.Throwable th5) {
                    th5.printStackTrace();
                    throw th;
                }
            }
        } catch (java.lang.Throwable th6) {
            th = th6;
            bmVar = null;
        }
    }

    private static boolean a(java.lang.String str, java.lang.String str2) {
        try {
            return new java.io.File(str, str2 + ".0").exists();
        } catch (java.lang.Throwable th) {
            com.loc.aw.b(th, "leg", com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.FET);
            return false;
        }
    }

    private static byte[] a(com.loc.bm bmVar, com.loc.bx bxVar, java.util.List<java.lang.String> list) {
        try {
            java.io.File b = bmVar.b();
            if (b != null && b.exists()) {
                int i = 0;
                for (java.lang.String str : b.list()) {
                    if (str.contains(".0")) {
                        java.lang.String str2 = str.split("\\.")[0];
                        byte[] a = com.loc.cd.a(bmVar, str2);
                        i += a.length;
                        list.add(str2);
                        if (i > bxVar.f.b()) {
                            break;
                        }
                        bxVar.g.b(a);
                    }
                }
                if (i <= 0) {
                    return null;
                }
                return bxVar.g.a();
            }
        } catch (java.lang.Throwable th) {
            com.loc.aw.b(th, "leg", "gCo");
        }
        return new byte[0];
    }
}
