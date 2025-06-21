package com.getui.gtc.extension.distribution.gbd.n;

/* loaded from: classes22.dex */
public final class aa {
    public static final java.lang.String a = "su";
    public static final java.lang.String b = "\n";

    /* JADX WARN: Code restructure failed: missing block: B:49:0x00ca, code lost:
    
        if (r6 == null) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00d9, code lost:
    
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00d6, code lost:
    
        r6.destroy();
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x00d4, code lost:
    
        if (r6 != null) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x00ec, code lost:
    
        if (r6 == null) goto L86;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x00fb, code lost:
    
        throw r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x00f8, code lost:
    
        r6.destroy();
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x00f6, code lost:
    
        if (r6 != null) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x00a3, code lost:
    
        if (r6 == null) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x00ad, code lost:
    
        if (r6 != null) goto L67;
     */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00c3 A[Catch: all -> 0x00bf, TRY_LEAVE, TryCatch #10 {all -> 0x00bf, blocks: (B:59:0x00bb, B:43:0x00c3), top: B:58:0x00bb }] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00bb A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static com.getui.gtc.extension.distribution.gbd.c.e a(java.lang.String str, boolean z, boolean z2, java.lang.String str2) {
        java.lang.Process process;
        java.io.DataOutputStream dataOutputStream;
        com.getui.gtc.extension.distribution.gbd.c.e eVar = new com.getui.gtc.extension.distribution.gbd.c.e();
        if (android.text.TextUtils.isEmpty(str)) {
            eVar.d = -1;
            return eVar;
        }
        java.io.BufferedReader bufferedReader = null;
        try {
            if (z) {
                process = java.lang.Runtime.getRuntime().exec(a);
                try {
                    dataOutputStream = new java.io.DataOutputStream(process.getOutputStream());
                    try {
                        dataOutputStream.write(str.getBytes());
                        dataOutputStream.writeBytes("\n");
                        dataOutputStream.write(com.alipay.sdk.m.x.d.z.getBytes());
                        dataOutputStream.writeBytes("\n");
                        dataOutputStream.flush();
                        eVar.d = process.waitFor();
                    } catch (java.lang.Throwable th) {
                        th = th;
                        try {
                            com.getui.gtc.extension.distribution.gbd.n.j.a(th);
                            eVar.d = -2;
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (java.lang.Throwable th2) {
                                    try {
                                        com.getui.gtc.extension.distribution.gbd.n.j.a(th2);
                                    } finally {
                                    }
                                }
                            }
                            if (dataOutputStream != null) {
                                dataOutputStream.close();
                            }
                        } catch (java.lang.Throwable th3) {
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (java.lang.Throwable th4) {
                                    try {
                                        com.getui.gtc.extension.distribution.gbd.n.j.a(th4);
                                    } finally {
                                        if (process != null) {
                                            process.destroy();
                                        }
                                    }
                                }
                            }
                            if (dataOutputStream != null) {
                                dataOutputStream.close();
                            }
                        }
                    }
                } catch (java.lang.Throwable th5) {
                    th = th5;
                    dataOutputStream = null;
                    com.getui.gtc.extension.distribution.gbd.n.j.a(th);
                    eVar.d = -2;
                    if (bufferedReader != null) {
                    }
                    if (dataOutputStream != null) {
                    }
                }
            } else {
                process = java.lang.Runtime.getRuntime().exec(str);
                dataOutputStream = null;
            }
            if (z2) {
                java.io.BufferedReader bufferedReader2 = new java.io.BufferedReader(new java.io.InputStreamReader(process.getInputStream()));
                while (true) {
                    try {
                        java.lang.String readLine = bufferedReader2.readLine();
                        if (readLine == null) {
                            break;
                        }
                        if (!android.text.TextUtils.isEmpty(readLine)) {
                            java.lang.String replace = readLine.replace("\r|\n", "");
                            if (android.text.TextUtils.isEmpty(str2) || replace.matches(str2)) {
                                eVar.e.add(replace);
                            }
                        }
                    } catch (java.lang.Throwable th6) {
                        bufferedReader = bufferedReader2;
                        th = th6;
                        com.getui.gtc.extension.distribution.gbd.n.j.a(th);
                        eVar.d = -2;
                        if (bufferedReader != null) {
                        }
                        if (dataOutputStream != null) {
                        }
                    }
                }
                bufferedReader = bufferedReader2;
            }
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (java.lang.Throwable th7) {
                    try {
                        com.getui.gtc.extension.distribution.gbd.n.j.a(th7);
                    } finally {
                    }
                }
            }
            if (dataOutputStream != null) {
                dataOutputStream.close();
            }
        } catch (java.lang.Throwable th8) {
            th = th8;
            process = null;
            dataOutputStream = null;
        }
    }
}
