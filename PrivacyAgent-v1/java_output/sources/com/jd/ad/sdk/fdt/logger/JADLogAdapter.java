package com.jd.ad.sdk.fdt.logger;

/* loaded from: classes23.dex */
public class JADLogAdapter implements com.jd.ad.sdk.jad_kt.jad_bo {

    @androidx.annotation.NonNull
    private final com.jd.ad.sdk.jad_kt.jad_an formatStrategy;

    public JADLogAdapter() {
        com.jd.ad.sdk.jad_kt.jad_er.jad_an jad_bo = com.jd.ad.sdk.jad_kt.jad_er.jad_an().jad_bo(false).jad_an(false).jad_an(0).jad_bo(7);
        java.lang.StringBuilder jad_an = com.jd.ad.sdk.jad_bo.jad_bo.jad_an("JADLog");
        jad_an.append(com.jd.ad.sdk.bl.initsdk.JADYunSdk.getSDKVersion());
        this.formatStrategy = jad_bo.jad_an(jad_an.toString()).jad_an();
    }

    @Override // com.jd.ad.sdk.jad_kt.jad_bo
    public boolean isLoggable(int i, @androidx.annotation.Nullable java.lang.String str) {
        return i != 3;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0163  */
    @Override // com.jd.ad.sdk.jad_kt.jad_bo
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void log(int i, @androidx.annotation.Nullable java.lang.String str, @androidx.annotation.NonNull java.lang.String str2) {
        java.lang.String str3;
        int length;
        int i2;
        com.jd.ad.sdk.jad_kt.jad_er jad_erVar = (com.jd.ad.sdk.jad_kt.jad_er) this.formatStrategy;
        jad_erVar.getClass();
        str2.getClass();
        if (!com.jd.ad.sdk.jad_kt.jad_jt.jad_an((java.lang.CharSequence) str)) {
            java.lang.String str4 = jad_erVar.jad_fs;
            if (!(str4 == str ? true : (str4 == null || str == null || str4.length() != str.length()) ? false : str4.equals(str))) {
                str3 = jad_erVar.jad_fs + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER + str;
                if (jad_erVar.jad_dq) {
                    jad_erVar.jad_an(i, str3, "┌────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
                }
                int i3 = jad_erVar.jad_an;
                if (jad_erVar.jad_dq) {
                    java.lang.StackTraceElement[] stackTrace = java.lang.Thread.currentThread().getStackTrace();
                    if (jad_erVar.jad_cp) {
                        java.lang.StringBuilder jad_an = com.jd.ad.sdk.jad_bo.jad_bo.jad_an("│ Thread: ");
                        jad_an.append(java.lang.Thread.currentThread().getName());
                        jad_erVar.jad_an(i, str3, jad_an.toString());
                        if (jad_erVar.jad_dq) {
                            jad_erVar.jad_an(i, str3, "├┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄");
                        }
                    }
                    stackTrace.getClass();
                    int i4 = 5;
                    while (true) {
                        i2 = -1;
                        if (i4 >= stackTrace.length) {
                            break;
                        }
                        java.lang.String className = stackTrace[i4].getClassName();
                        if (!className.equals(com.jd.ad.sdk.jad_kt.jad_dq.class.getName()) && !className.equals(com.jd.ad.sdk.logger.Logger.class.getName())) {
                            i2 = (-1) + i4;
                            break;
                        }
                        i4++;
                    }
                    int i5 = i2 + jad_erVar.jad_bo;
                    java.lang.String str5 = "";
                    if (i3 + i5 > stackTrace.length) {
                        i3 = (stackTrace.length - i5) - 1;
                    }
                    while (i3 > 0) {
                        int i6 = i3 + i5;
                        if (i6 < stackTrace.length) {
                            java.lang.StringBuilder sb = new java.lang.StringBuilder();
                            sb.append((char) 9474);
                            sb.append(' ');
                            sb.append(str5);
                            java.lang.String className2 = stackTrace[i6].getClassName();
                            className2.getClass();
                            sb.append(className2.substring(className2.lastIndexOf(".") + 1));
                            sb.append(".");
                            sb.append(stackTrace[i6].getMethodName());
                            sb.append(" ");
                            sb.append(" (");
                            sb.append(stackTrace[i6].getFileName());
                            sb.append(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR);
                            sb.append(stackTrace[i6].getLineNumber());
                            sb.append(")");
                            jad_erVar.jad_an(i, str3, sb.toString());
                            str5 = str5 + "   ";
                        }
                        i3--;
                    }
                }
                byte[] bytes = str2.getBytes();
                length = bytes.length;
                if (length > 4000) {
                    if (jad_erVar.jad_an > 0 && jad_erVar.jad_dq) {
                        jad_erVar.jad_an(i, str3, "├┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄");
                    }
                    jad_erVar.jad_bo(i, str3, str2);
                    if (!jad_erVar.jad_dq) {
                        return;
                    }
                } else {
                    if (jad_erVar.jad_an > 0 && jad_erVar.jad_dq) {
                        jad_erVar.jad_an(i, str3, "├┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄");
                    }
                    for (int i7 = 0; i7 < length; i7 += 4000) {
                        jad_erVar.jad_bo(i, str3, new java.lang.String(bytes, i7, java.lang.Math.min(length - i7, 4000)));
                    }
                    if (!jad_erVar.jad_dq) {
                        return;
                    }
                }
                jad_erVar.jad_an(i, str3, "└────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
            }
        }
        str3 = jad_erVar.jad_fs;
        if (jad_erVar.jad_dq) {
        }
        int i32 = jad_erVar.jad_an;
        if (jad_erVar.jad_dq) {
        }
        byte[] bytes2 = str2.getBytes();
        length = bytes2.length;
        if (length > 4000) {
        }
        jad_erVar.jad_an(i, str3, "└────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
    }
}
