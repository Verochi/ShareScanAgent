package com.xiaomi.push;

/* loaded from: classes19.dex */
public final class cc {
    private static int a(android.content.Context context, int i) {
        int b = com.xiaomi.push.gc.b(context);
        if (-1 == b) {
            return -1;
        }
        return (i * (b == 0 ? 13 : 11)) / 10;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0028, code lost:
    
        if (com.xiaomi.push.dx.a(r2) != (-1)) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0043, code lost:
    
        if (com.xiaomi.push.dx.a(r2) != (-1)) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static int a(com.xiaomi.push.hw hwVar, com.xiaomi.push.gk gkVar) {
        int b;
        int a;
        java.lang.String str;
        switch (com.xiaomi.push.cd.a[gkVar.ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
                return com.xiaomi.push.Cdo.b(gkVar.L);
            case 11:
                b = com.xiaomi.push.Cdo.b(gkVar.L);
                if (hwVar != null) {
                    try {
                        if (hwVar instanceof com.xiaomi.push.hc) {
                            java.lang.String str2 = ((com.xiaomi.push.hc) hwVar).e;
                            if (!android.text.TextUtils.isEmpty(str2) && com.xiaomi.push.Cdo.a(com.xiaomi.push.Cdo.a(str2)) != -1) {
                                a = com.xiaomi.push.Cdo.a(com.xiaomi.push.Cdo.a(str2));
                                return a;
                            }
                        } else if (hwVar instanceof com.xiaomi.push.hk) {
                            java.lang.String str3 = ((com.xiaomi.push.hk) hwVar).e;
                            if (!android.text.TextUtils.isEmpty(str3)) {
                                if (com.xiaomi.push.Cdo.a(com.xiaomi.push.Cdo.a(str3)) != -1) {
                                    b = com.xiaomi.push.Cdo.a(com.xiaomi.push.Cdo.a(str3));
                                }
                                if (com.xiaomi.push.gu.UploadTinyData.equals(com.xiaomi.push.Cdo.a(str3))) {
                                    return -1;
                                }
                            }
                        }
                    } catch (java.lang.Exception unused) {
                        com.xiaomi.channel.commonutils.logger.b.d("PERF_ERROR : parse Notification type error");
                        return b;
                    }
                }
                return b;
            case 12:
                b = com.xiaomi.push.Cdo.b(gkVar.L);
                if (hwVar != null) {
                    try {
                        if (!(hwVar instanceof com.xiaomi.push.hg)) {
                            if (hwVar instanceof com.xiaomi.push.hf) {
                                str = ((com.xiaomi.push.hf) hwVar).d;
                                if (!android.text.TextUtils.isEmpty(str)) {
                                    break;
                                }
                            }
                        } else {
                            str = ((com.xiaomi.push.hg) hwVar).d;
                            if (!android.text.TextUtils.isEmpty(str)) {
                                break;
                            }
                        }
                        a = com.xiaomi.push.dx.a(str);
                        return a;
                    } catch (java.lang.Exception unused2) {
                        com.xiaomi.channel.commonutils.logger.b.d("PERF_ERROR : parse Command type error");
                    }
                }
                return b;
            default:
                return -1;
        }
    }

    private static void a(java.lang.String str, android.content.Context context, int i, int i2) {
        if (i <= 0 || i2 <= 0) {
            return;
        }
        int a = a(context, i2);
        if (i != com.xiaomi.push.Cdo.a(com.xiaomi.push.gu.UploadTinyData)) {
            com.xiaomi.push.dp.a(context.getApplicationContext()).a(str, i, a);
        }
    }

    public static void a(java.lang.String str, android.content.Context context, com.xiaomi.push.hh hhVar, int i) {
        com.xiaomi.push.gk gkVar;
        if (context == null || hhVar == null || (gkVar = hhVar.a) == null) {
            return;
        }
        int b = com.xiaomi.push.Cdo.b(gkVar.L);
        if (i <= 0) {
            byte[] a = com.xiaomi.push.hv.a(hhVar);
            i = a != null ? a.length : 0;
        }
        a(str, context, b, i);
    }

    public static void a(java.lang.String str, android.content.Context context, com.xiaomi.push.hw hwVar, com.xiaomi.push.gk gkVar, int i) {
        a(str, context, a(hwVar, gkVar), i);
    }
}
