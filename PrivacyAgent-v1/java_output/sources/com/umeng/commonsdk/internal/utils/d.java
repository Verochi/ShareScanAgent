package com.umeng.commonsdk.internal.utils;

/* loaded from: classes19.dex */
public class d {

    public static class a {
        public java.lang.String a;
        public java.lang.String b;
        public int c;
        public java.lang.String d;
        public java.lang.String e;
        public java.lang.String f;
        public java.lang.String g;
        public java.lang.String h;
        public java.lang.String i;
        public java.lang.String j;
        public java.lang.String k;
        public java.lang.String l;
    }

    /* JADX WARN: Removed duplicated region for block: B:114:0x0144 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:118:0x013d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0134 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:134:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:135:0x012d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static com.umeng.commonsdk.internal.utils.d.a a() {
        com.umeng.commonsdk.internal.utils.d.a aVar;
        java.io.BufferedReader bufferedReader;
        java.io.FileReader fileReader;
        java.lang.Throwable th;
        int i;
        java.io.FileReader fileReader2 = null;
        int i2 = 0;
        try {
            try {
                aVar = new com.umeng.commonsdk.internal.utils.d.a();
            } catch (java.lang.Throwable th2) {
                th = th2;
                fileReader = null;
                bufferedReader = null;
            }
            try {
                fileReader = new java.io.FileReader("/proc/cpuinfo");
                try {
                    bufferedReader = new java.io.BufferedReader(fileReader);
                    try {
                        try {
                            int i3 = 0;
                            boolean z = true;
                            i = 0;
                            for (java.lang.String readLine = bufferedReader.readLine(); !android.text.TextUtils.isEmpty(readLine) && (i3 = i3 + 1) < 30; readLine = bufferedReader.readLine()) {
                                try {
                                    java.lang.String[] split = readLine.split(":\\s+", 2);
                                    if (z && split != null && split.length > 1) {
                                        aVar.a = split[1];
                                        z = false;
                                    }
                                    if (split != null && split.length > 1 && split[0].contains("processor")) {
                                        i++;
                                    }
                                    if (split != null && split.length > 1 && split[0].contains("Features")) {
                                        aVar.d = split[1];
                                    }
                                    if (split != null && split.length > 1 && split[0].contains("implementer")) {
                                        aVar.e = split[1];
                                    }
                                    if (split != null && split.length > 1 && split[0].contains("architecture")) {
                                        aVar.f = split[1];
                                    }
                                    if (split != null && split.length > 1 && split[0].contains("variant")) {
                                        aVar.g = split[1];
                                    }
                                    if (split != null && split.length > 1 && split[0].contains("part")) {
                                        aVar.h = split[1];
                                    }
                                    if (split != null && split.length > 1 && split[0].contains("revision")) {
                                        aVar.i = split[1];
                                    }
                                    if (split != null && split.length > 1 && split[0].contains("Hardware")) {
                                        aVar.j = split[1];
                                    }
                                    if (split != null && split.length > 1 && split[0].contains("Revision")) {
                                        aVar.k = split[1];
                                    }
                                    if (split != null && split.length > 1 && split[0].contains("Serial")) {
                                        aVar.l = split[1];
                                    }
                                    if (split != null && split.length > 1 && split[0].contains("implementer")) {
                                        aVar.e = split[1];
                                    }
                                } catch (java.lang.Exception unused) {
                                    fileReader2 = fileReader;
                                    i2 = i;
                                    if (fileReader2 != null) {
                                        try {
                                            fileReader2.close();
                                        } catch (java.io.IOException unused2) {
                                        }
                                    }
                                    if (bufferedReader != null) {
                                        try {
                                            bufferedReader.close();
                                        } catch (java.io.IOException unused3) {
                                        }
                                    }
                                    i = i2;
                                    aVar.c = i;
                                    return aVar;
                                }
                            }
                            try {
                                fileReader.close();
                            } catch (java.io.IOException unused4) {
                            }
                            try {
                                bufferedReader.close();
                            } catch (java.io.IOException unused5) {
                            }
                        } catch (java.lang.Exception unused6) {
                            fileReader2 = fileReader;
                            if (fileReader2 != null) {
                            }
                            if (bufferedReader != null) {
                            }
                            i = i2;
                            aVar.c = i;
                            return aVar;
                        }
                    } catch (java.lang.Throwable th3) {
                        th = th3;
                        if (fileReader != null) {
                            try {
                                fileReader.close();
                            } catch (java.io.IOException unused7) {
                            }
                        }
                        if (bufferedReader != null) {
                            throw th;
                        }
                        try {
                            bufferedReader.close();
                            throw th;
                        } catch (java.io.IOException unused8) {
                            throw th;
                        }
                    }
                } catch (java.lang.Exception unused9) {
                    bufferedReader = null;
                } catch (java.lang.Throwable th4) {
                    th = th4;
                    bufferedReader = null;
                    th = th;
                    if (fileReader != null) {
                    }
                    if (bufferedReader != null) {
                    }
                }
            } catch (java.lang.Exception unused10) {
                bufferedReader = null;
            }
        } catch (java.lang.Exception unused11) {
            aVar = null;
            bufferedReader = null;
        }
        aVar.c = i;
        return aVar;
    }

    public static java.lang.String b() {
        java.lang.String str = "";
        try {
            java.io.InputStream inputStream = new java.lang.ProcessBuilder("/system/bin/cat", "/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_max_freq").start().getInputStream();
            byte[] bArr = new byte[24];
            while (inputStream.read(bArr) != -1) {
                str = str + new java.lang.String(bArr);
            }
            inputStream.close();
        } catch (java.lang.Exception unused) {
        }
        return str.trim();
    }

    public static java.lang.String c() {
        java.lang.String str = "";
        try {
            java.io.InputStream inputStream = new java.lang.ProcessBuilder("/system/bin/cat", "/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_min_freq").start().getInputStream();
            byte[] bArr = new byte[24];
            while (inputStream.read(bArr) != -1) {
                str = str + new java.lang.String(bArr);
            }
            inputStream.close();
        } catch (java.lang.Exception unused) {
        }
        return str.trim();
    }

    public static java.lang.String d() {
        java.io.BufferedReader bufferedReader;
        java.lang.Throwable th;
        java.io.BufferedReader bufferedReader2 = null;
        try {
            bufferedReader = new java.io.BufferedReader(new java.io.FileReader("/sys/devices/system/cpu/cpu0/cpufreq/scaling_cur_freq"));
            try {
                java.lang.String trim = bufferedReader.readLine().trim();
                try {
                    bufferedReader.close();
                    return trim;
                } catch (java.lang.Throwable unused) {
                    return trim;
                }
            } catch (java.lang.Exception unused2) {
                bufferedReader2 = bufferedReader;
                if (bufferedReader2 != null) {
                    try {
                        bufferedReader2.close();
                    } catch (java.lang.Throwable unused3) {
                    }
                }
                return "";
            } catch (java.lang.Throwable th2) {
                th = th2;
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (java.lang.Throwable unused4) {
                    }
                }
                throw th;
            }
        } catch (java.lang.Exception unused5) {
        } catch (java.lang.Throwable th3) {
            bufferedReader = null;
            th = th3;
        }
    }
}
