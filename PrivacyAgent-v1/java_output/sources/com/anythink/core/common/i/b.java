package com.anythink.core.common.i;

/* loaded from: classes12.dex */
public final class b {
    public static int a() {
        return a(1);
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0056, code lost:
    
        if (r3 == null) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x004a, code lost:
    
        r3.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0048, code lost:
    
        if (r3 == null) goto L30;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static int a(int i) {
        java.io.FileReader fileReader;
        java.io.BufferedReader bufferedReader = null;
        try {
            fileReader = new java.io.FileReader(com.anythink.core.common.o.d.b("L3Byb2MvbWVtaW5mbw=="));
            try {
                java.io.BufferedReader bufferedReader2 = new java.io.BufferedReader(fileReader, 8192);
                java.lang.String str = "";
                for (int i2 = 0; i2 < i; i2++) {
                    try {
                        str = bufferedReader2.readLine();
                    } catch (java.io.IOException unused) {
                        bufferedReader = bufferedReader2;
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (java.io.IOException unused2) {
                            }
                        }
                    } catch (java.lang.Throwable unused3) {
                        bufferedReader = bufferedReader2;
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (java.io.IOException unused4) {
                            }
                        }
                    }
                }
                int longValue = (int) (java.lang.Long.valueOf(str.split("\\s+")[1]).longValue() / 1024);
                try {
                    bufferedReader2.close();
                } catch (java.io.IOException unused5) {
                }
                try {
                    fileReader.close();
                } catch (java.io.IOException unused6) {
                }
                return longValue;
            } catch (java.io.IOException unused7) {
            } catch (java.lang.Throwable unused8) {
            }
        } catch (java.io.IOException unused9) {
            fileReader = null;
        } catch (java.lang.Throwable unused10) {
            fileReader = null;
        }
        return 0;
    }

    public static int a(android.app.ActivityManager activityManager) {
        try {
            activityManager.getMemoryInfo(new android.app.ActivityManager.MemoryInfo());
            return (int) ((java.lang.Runtime.getRuntime().totalMemory() / 1024) / 1024);
        } catch (java.lang.Throwable unused) {
            return 0;
        }
    }

    private static int a(android.content.Context context, android.app.ActivityManager activityManager) {
        return (context.getApplicationContext().getApplicationInfo().flags & 1048576) == 1048576 ? activityManager.getLargeMemoryClass() : activityManager.getMemoryClass();
    }

    public static int b() {
        return a(3);
    }
}
