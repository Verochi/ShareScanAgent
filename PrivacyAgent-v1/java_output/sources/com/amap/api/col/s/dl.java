package com.amap.api.col.s;

/* loaded from: classes12.dex */
public final class dl {
    public static com.amap.api.col.s.df a(java.lang.ref.WeakReference<com.amap.api.col.s.df> weakReference) {
        if (weakReference == null || weakReference.get() == null) {
            weakReference = new java.lang.ref.WeakReference<>(new com.amap.api.col.s.df());
        }
        return weakReference.get();
    }

    public static java.lang.String a() {
        return com.amap.api.col.s.bu.a(java.lang.System.currentTimeMillis());
    }

    public static java.lang.String a(android.content.Context context, com.amap.api.col.s.bt btVar) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        try {
            java.lang.String f = com.amap.api.col.s.bm.f(context);
            sb.append("\"sim\":\"");
            sb.append(f);
            sb.append("\",\"sdkversion\":\"");
            sb.append(btVar.d());
            sb.append("\",\"product\":\"");
            sb.append(btVar.b());
            sb.append("\",\"ed\":\"");
            sb.append(btVar.e());
            sb.append("\",\"nt\":\"");
            sb.append(com.amap.api.col.s.bm.d(context));
            sb.append("\",\"np\":\"");
            sb.append(com.amap.api.col.s.bm.b(context));
            sb.append("\",\"mnc\":\"");
            sb.append(com.amap.api.col.s.bm.c(context));
            sb.append("\",\"ant\":\"");
            sb.append(com.amap.api.col.s.bm.e(context));
            sb.append("\"");
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
        return sb.toString();
    }

    public static java.lang.String a(java.lang.String str, java.lang.String str2, int i, java.lang.String str3, java.lang.String str4) {
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        stringBuffer.append(str);
        stringBuffer.append(",\"timestamp\":\"");
        stringBuffer.append(str2);
        stringBuffer.append("\",\"et\":\"");
        stringBuffer.append(i);
        stringBuffer.append("\",\"classname\":\"");
        stringBuffer.append(str3);
        stringBuffer.append("\",");
        stringBuffer.append("\"detail\":\"");
        stringBuffer.append(str4);
        stringBuffer.append("\"");
        return stringBuffer.toString();
    }

    public static void a(android.content.Context context, com.amap.api.col.s.df dfVar, java.lang.String str, int i, int i2, java.lang.String str2) {
        dfVar.a = com.amap.api.col.s.ch.c(context, str);
        dfVar.d = i;
        dfVar.b = i2;
        dfVar.c = str2;
    }

    public static byte[] b(com.amap.api.col.s.cu cuVar, java.lang.String str) {
        com.amap.api.col.s.cu.b bVar;
        byte[] bArr = new byte[0];
        java.io.InputStream inputStream = null;
        try {
            bVar = cuVar.a(str);
            if (bVar == null) {
                if (bVar != null) {
                    try {
                        bVar.close();
                    } catch (java.lang.Throwable th) {
                        th.printStackTrace();
                    }
                }
                return bArr;
            }
            try {
                java.io.InputStream a = bVar.a();
                if (a == null) {
                    if (a != null) {
                        try {
                            a.close();
                        } catch (java.lang.Throwable th2) {
                            th2.printStackTrace();
                        }
                    }
                    try {
                        bVar.close();
                    } catch (java.lang.Throwable th3) {
                        th3.printStackTrace();
                    }
                    return bArr;
                }
                bArr = new byte[a.available()];
                a.read(bArr);
                try {
                    a.close();
                } catch (java.lang.Throwable th4) {
                    th4.printStackTrace();
                }
                try {
                    bVar.close();
                } catch (java.lang.Throwable th5) {
                    th5.printStackTrace();
                }
                return bArr;
            } catch (java.lang.Throwable th6) {
                th = th6;
                try {
                    com.amap.api.col.s.cj.c(th, "sui", "rdS");
                    if (0 != 0) {
                        try {
                            inputStream.close();
                        } catch (java.lang.Throwable th7) {
                            th7.printStackTrace();
                        }
                    }
                    if (bVar != null) {
                        try {
                            bVar.close();
                        } catch (java.lang.Throwable th8) {
                            th8.printStackTrace();
                        }
                    }
                    return bArr;
                } finally {
                }
            }
        } catch (java.lang.Throwable th9) {
            th = th9;
            bVar = null;
        }
    }
}
