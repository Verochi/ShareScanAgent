package com.efs.sdk.memoryinfo;

/* loaded from: classes22.dex */
final class f {
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0069, code lost:
    
        r5 = java.lang.Long.parseLong(r8.group());
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static long a() {
        java.io.BufferedReader bufferedReader;
        long j;
        long j2 = -1;
        try {
            bufferedReader = new java.io.BufferedReader(new java.io.FileReader(new java.io.File("/proc/" + android.os.Process.myPid() + "/status")));
            try {
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                while (true) {
                    java.lang.String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    sb.append(readLine);
                    sb.append('\n');
                }
                java.lang.String[] split = sb.toString().trim().split("\n");
                int length = split.length;
                int length2 = split.length;
                int i = 0;
                while (true) {
                    if (i >= length2) {
                        j = -1;
                        break;
                    }
                    java.lang.String str = split[i];
                    if (str.startsWith("VmSize")) {
                        java.util.regex.Matcher matcher = java.util.regex.Pattern.compile("\\d+").matcher(str);
                        if (matcher.find()) {
                            break;
                        }
                    }
                    i++;
                }
                if (j == -1 && length > 12) {
                    try {
                        java.util.regex.Matcher matcher2 = java.util.regex.Pattern.compile("\\d+").matcher(split[12]);
                        if (matcher2.find()) {
                            j = java.lang.Long.parseLong(matcher2.group());
                        }
                    } catch (java.lang.Throwable unused) {
                        j2 = j;
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (java.lang.Throwable unused2) {
                            }
                        }
                        return j2;
                    }
                }
                try {
                    bufferedReader.close();
                    return j;
                } catch (java.lang.Throwable unused3) {
                    return j;
                }
            } catch (java.lang.Throwable unused4) {
            }
        } catch (java.lang.Throwable unused5) {
            bufferedReader = null;
        }
    }

    public static long a(android.os.Debug.MemoryInfo memoryInfo) {
        java.lang.String memoryStat;
        if (android.os.Build.VERSION.SDK_INT < 23) {
            return 0L;
        }
        memoryStat = memoryInfo.getMemoryStat("summary.graphics");
        try {
            if (android.text.TextUtils.isEmpty(memoryStat)) {
                return 0L;
            }
            return java.lang.Long.parseLong(memoryStat);
        } catch (java.lang.Exception unused) {
            return 0L;
        }
    }

    public static void a(java.lang.String str, java.lang.Throwable th) {
        boolean z = com.efs.sdk.memoryinfo.a.DEBUG;
    }
}
