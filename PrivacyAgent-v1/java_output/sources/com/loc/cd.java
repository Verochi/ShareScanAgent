package com.loc;

/* loaded from: classes23.dex */
public final class cd {
    public static com.loc.bx a(java.lang.ref.WeakReference<com.loc.bx> weakReference) {
        if (weakReference == null || weakReference.get() == null) {
            weakReference = new java.lang.ref.WeakReference<>(new com.loc.bx());
        }
        return weakReference.get();
    }

    public static java.lang.String a() {
        return com.loc.y.a(java.lang.System.currentTimeMillis());
    }

    public static java.lang.String a(android.content.Context context, com.loc.x xVar) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        try {
            java.lang.String e = com.loc.p.e();
            sb.append("\"sim\":\"");
            sb.append(e);
            sb.append("\",\"sdkversion\":\"");
            sb.append(xVar.c());
            sb.append("\",\"product\":\"");
            sb.append(xVar.a());
            sb.append("\",\"ed\":\"");
            sb.append(xVar.d());
            sb.append("\",\"nt\":\"");
            sb.append(com.loc.p.c(context));
            sb.append("\",\"np\":\"");
            sb.append(com.loc.p.b(context));
            sb.append("\",\"mnc\":\"");
            sb.append(com.loc.p.d());
            sb.append("\",\"ant\":\"");
            sb.append(com.loc.p.d(context));
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

    public static void a(android.content.Context context, com.loc.bx bxVar, java.lang.String str, int i, int i2, java.lang.String str2) {
        bxVar.a = com.loc.au.c(context, str);
        bxVar.d = i;
        bxVar.b = i2;
        bxVar.c = str2;
    }

    public static byte[] a(com.loc.bm bmVar, java.lang.String str) {
        com.loc.bm.b bVar;
        byte[] bArr = new byte[0];
        java.io.InputStream inputStream = null;
        try {
            bVar = bmVar.a(str);
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
                    com.loc.aw.b(th, "sui", "rdS");
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
