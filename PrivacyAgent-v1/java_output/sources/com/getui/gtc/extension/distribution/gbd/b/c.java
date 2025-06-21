package com.getui.gtc.extension.distribution.gbd.b;

/* loaded from: classes22.dex */
public final class c {

    /* renamed from: com.getui.gtc.extension.distribution.gbd.b.c$1, reason: invalid class name */
    public static class AnonymousClass1 implements com.getui.gtc.extension.distribution.gbd.f.j<java.lang.Runtime, java.lang.Process> {
        /* renamed from: a, reason: avoid collision after fix types in other method */
        private static java.lang.Process a2(java.lang.Runtime runtime) {
            return runtime.exec("cat /proc/net/arp");
        }

        @Override // com.getui.gtc.extension.distribution.gbd.f.j
        public final /* synthetic */ java.lang.Process a(java.lang.Runtime runtime) {
            return runtime.exec("cat /proc/net/arp");
        }
    }

    public static java.util.List<com.getui.gtc.extension.distribution.gbd.c.h> a(int i, boolean z) {
        java.lang.Process process;
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.io.BufferedReader bufferedReader = null;
        try {
            try {
                java.lang.Runtime runtime = java.lang.Runtime.getRuntime();
                com.getui.gtc.extension.distribution.gbd.f.c unused = com.getui.gtc.extension.distribution.gbd.f.c.a.a;
                process = (java.lang.Process) com.getui.gtc.extension.distribution.gbd.f.c.a(z, com.getui.gtc.extension.distribution.gbd.f.b.f328s, runtime, new com.getui.gtc.extension.distribution.gbd.b.c.AnonymousClass1());
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
                                    if (!readLine.contains("IP") && !readLine.contains(com.alipay.sdk.m.u.c.b)) {
                                        i2++;
                                        if (i2 > i) {
                                            break;
                                        }
                                        java.lang.String[] split = readLine.split(" +");
                                        arrayList.add(new com.getui.gtc.extension.distribution.gbd.c.h(split[0], split[3].replaceAll(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR, ""), ""));
                                    }
                                } catch (java.lang.Throwable th) {
                                    com.getui.gtc.extension.distribution.gbd.n.j.a(th);
                                }
                            } catch (java.lang.Throwable th2) {
                                th = th2;
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
                    } catch (java.lang.Throwable th3) {
                        th = th3;
                    }
                }
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (java.io.IOException e2) {
                        com.getui.gtc.extension.distribution.gbd.n.j.a(e2);
                    }
                }
            } catch (java.lang.Throwable th4) {
                com.getui.gtc.extension.distribution.gbd.n.j.a(th4);
            }
        } catch (java.lang.Throwable th5) {
            th = th5;
            process = null;
        }
        if (process != null) {
            process.destroy();
        }
        return arrayList;
    }
}
