package com.efs.sdk.pa.a;

/* loaded from: classes22.dex */
final class f implements com.efs.sdk.pa.a.d {
    com.efs.sdk.pa.PAMsgListener a;
    boolean b;
    java.lang.String c;
    java.io.BufferedOutputStream d;

    /* JADX WARN: Removed duplicated region for block: B:28:0x008b A[Catch: Exception -> 0x00ae, TryCatch #0 {Exception -> 0x00ae, blocks: (B:7:0x0010, B:11:0x001d, B:13:0x0023, B:14:0x002d, B:17:0x0038, B:19:0x003e, B:22:0x004a, B:25:0x0054, B:26:0x0081, B:28:0x008b, B:30:0x0091, B:32:0x0097, B:34:0x009f, B:35:0x00a7, B:40:0x0059, B:42:0x005f, B:44:0x0065, B:47:0x0071, B:50:0x007b), top: B:6:0x0010 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static com.efs.sdk.pa.b b(java.lang.String str, long j, long j2) {
        java.lang.String str2;
        int indexOf;
        int indexOf2;
        int i;
        java.lang.String substring;
        int lastIndexOf;
        int i2;
        int i3;
        if (str == null) {
            return null;
        }
        com.efs.sdk.pa.b bVar = new com.efs.sdk.pa.b();
        try {
            int indexOf3 = str.indexOf(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR);
            java.lang.String str3 = "";
            if (indexOf3 != -1) {
                int i4 = indexOf3 + 2;
                if (i4 < str.length()) {
                    str2 = str.substring(i4, str.length());
                    bVar.a = str2;
                    if (!str.contains("(") && str.contains(")")) {
                        int indexOf4 = str.indexOf("(");
                        int indexOf5 = str.indexOf(")");
                        if (indexOf4 != -1 && indexOf5 != -1 && (i3 = indexOf4 + 1) < str.length() && indexOf5 > i3) {
                            substring = str.substring(i3, indexOf5);
                            bVar.b = substring;
                            if (!str.contains(com.igexin.push.core.b.m)) {
                            }
                            bVar.c = str3;
                            bVar.d = j;
                            bVar.e = j2;
                            return bVar;
                        }
                        substring = "";
                        bVar.b = substring;
                        if (!str.contains(com.igexin.push.core.b.m)) {
                        }
                        bVar.c = str3;
                        bVar.d = j;
                        bVar.e = j2;
                        return bVar;
                    }
                    if (str.contains("{") && str.contains(com.alipay.sdk.m.u.i.d)) {
                        indexOf = str.indexOf("{");
                        indexOf2 = str.indexOf(com.alipay.sdk.m.u.i.d);
                        if (indexOf != -1 && indexOf2 != -1 && (i = indexOf + 1) < str.length() && indexOf2 > i) {
                            substring = str.substring(i, indexOf2);
                            bVar.b = substring;
                            if (!str.contains(com.igexin.push.core.b.m) && str.contains(com.alipay.sdk.m.u.i.d) && (lastIndexOf = str.lastIndexOf(com.alipay.sdk.m.u.i.d)) != -1 && (i2 = lastIndexOf + 1) < str.length()) {
                                str3 = str.substring(i2, str.length());
                            }
                            bVar.c = str3;
                            bVar.d = j;
                            bVar.e = j2;
                            return bVar;
                        }
                    }
                    substring = "";
                    bVar.b = substring;
                    if (!str.contains(com.igexin.push.core.b.m)) {
                        str3 = str.substring(i2, str.length());
                    }
                    bVar.c = str3;
                    bVar.d = j;
                    bVar.e = j2;
                    return bVar;
                }
            }
            str2 = "";
            bVar.a = str2;
            if (!str.contains("(")) {
            }
            if (str.contains("{")) {
                indexOf = str.indexOf("{");
                indexOf2 = str.indexOf(com.alipay.sdk.m.u.i.d);
                if (indexOf != -1) {
                    substring = str.substring(i, indexOf2);
                    bVar.b = substring;
                    if (!str.contains(com.igexin.push.core.b.m)) {
                    }
                    bVar.c = str3;
                    bVar.d = j;
                    bVar.e = j2;
                    return bVar;
                }
            }
            substring = "";
            bVar.b = substring;
            if (!str.contains(com.igexin.push.core.b.m)) {
            }
            bVar.c = str3;
            bVar.d = j;
            bVar.e = j2;
            return bVar;
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.efs.sdk.pa.a.d
    public final void a(java.lang.String str, long j, long j2) {
        com.efs.sdk.pa.b b = b(str, j, j2);
        if (b != null) {
            if (this.b) {
                b.toString();
            }
            if (this.c != null) {
                try {
                    this.d.write((b.toString() + "\n").getBytes());
                } catch (java.lang.Exception unused) {
                }
            }
            this.a.msg(b);
        }
    }
}
