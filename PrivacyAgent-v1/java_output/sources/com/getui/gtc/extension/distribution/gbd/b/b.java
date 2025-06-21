package com.getui.gtc.extension.distribution.gbd.b;

/* loaded from: classes22.dex */
public final class b {

    /* renamed from: com.getui.gtc.extension.distribution.gbd.b.b$1, reason: invalid class name */
    public static class AnonymousClass1 implements com.getui.gtc.extension.distribution.gbd.f.j<java.lang.Runtime, java.lang.Process> {
        /* renamed from: a, reason: avoid collision after fix types in other method */
        private static java.lang.Process a2(java.lang.Runtime runtime) {
            return runtime.exec("ip n");
        }

        @Override // com.getui.gtc.extension.distribution.gbd.f.j
        public final /* synthetic */ java.lang.Process a(java.lang.Runtime runtime) {
            return runtime.exec("ip n");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x0061 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x002c A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static java.util.List<com.getui.gtc.extension.distribution.gbd.c.h> a(int i, boolean z) {
        java.lang.Process process;
        boolean z2;
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.io.BufferedReader bufferedReader = null;
        try {
            try {
                java.lang.Runtime runtime = java.lang.Runtime.getRuntime();
                com.getui.gtc.extension.distribution.gbd.f.c unused = com.getui.gtc.extension.distribution.gbd.f.c.a.a;
                process = (java.lang.Process) com.getui.gtc.extension.distribution.gbd.f.c.a(z, com.getui.gtc.extension.distribution.gbd.f.b.r, runtime, new com.getui.gtc.extension.distribution.gbd.b.b.AnonymousClass1());
                if (process != null) {
                    try {
                        java.io.BufferedReader bufferedReader2 = new java.io.BufferedReader(new java.io.InputStreamReader(process.getInputStream()));
                        int i2 = 0;
                        while (true) {
                            try {
                                java.lang.String readLine = bufferedReader2.readLine();
                                if (readLine == null) {
                                    break;
                                }
                                try {
                                } catch (java.lang.Throwable th) {
                                    th = th;
                                }
                                if (!readLine.contains("192.168") && !readLine.contains("172.") && !readLine.contains("10.")) {
                                    z2 = false;
                                    if (!z2 || readLine.contains("wlan0")) {
                                        if (readLine.contains("FAILED")) {
                                            java.lang.String[] split = readLine.split(" +");
                                            if (split.length >= 6) {
                                                int i3 = i2 + 1;
                                                if (i2 > i) {
                                                    break;
                                                }
                                                try {
                                                    arrayList.add(new com.getui.gtc.extension.distribution.gbd.c.h(split[0], split[4].replaceAll(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR, ""), split[5]));
                                                    i2 = i3;
                                                } catch (java.lang.Throwable th2) {
                                                    th = th2;
                                                    i2 = i3;
                                                    com.getui.gtc.extension.distribution.gbd.n.j.a(th);
                                                }
                                            } else {
                                                continue;
                                            }
                                        } else {
                                            continue;
                                        }
                                    }
                                }
                                z2 = true;
                                if (!z2) {
                                }
                                if (readLine.contains("FAILED")) {
                                }
                            } catch (java.lang.Throwable th3) {
                                th = th3;
                                bufferedReader = bufferedReader2;
                                try {
                                    com.getui.gtc.extension.distribution.gbd.n.j.a(th);
                                    if (bufferedReader != null) {
                                        try {
                                            bufferedReader.close();
                                        } catch (java.io.IOException e) {
                                            com.getui.gtc.extension.distribution.gbd.n.j.a(e);
                                        }
                                    }
                                    if (process != null) {
                                        process.destroy();
                                    }
                                    return arrayList;
                                } finally {
                                }
                            }
                        }
                        bufferedReader = bufferedReader2;
                    } catch (java.lang.Throwable th4) {
                        th = th4;
                    }
                }
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (java.io.IOException e2) {
                        com.getui.gtc.extension.distribution.gbd.n.j.a(e2);
                    }
                }
            } catch (java.lang.Throwable th5) {
                th = th5;
                process = null;
            }
            if (process != null) {
                process.destroy();
            }
        } catch (java.lang.Throwable th6) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(th6);
        }
        return arrayList;
    }
}
