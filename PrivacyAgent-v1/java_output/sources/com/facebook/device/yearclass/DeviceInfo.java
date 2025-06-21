package com.facebook.device.yearclass;

/* loaded from: classes22.dex */
public class DeviceInfo {
    public static final int DEVICEINFO_UNKNOWN = -1;
    public static final java.io.FileFilter a = new com.facebook.device.yearclass.DeviceInfo.AnonymousClass1();

    /* renamed from: com.facebook.device.yearclass.DeviceInfo$1, reason: invalid class name */
    public static class AnonymousClass1 implements java.io.FileFilter {
        @Override // java.io.FileFilter
        public boolean accept(java.io.File file) {
            java.lang.String name = file.getName();
            if (!name.startsWith("cpu")) {
                return false;
            }
            for (int i = 3; i < name.length(); i++) {
                if (!java.lang.Character.isDigit(name.charAt(i))) {
                    return false;
                }
            }
            return true;
        }
    }

    public static int a(byte[] bArr, int i) {
        byte b;
        while (i < bArr.length && (b = bArr[i]) != 10) {
            if (java.lang.Character.isDigit(b)) {
                int i2 = i + 1;
                while (i2 < bArr.length && java.lang.Character.isDigit(bArr[i2])) {
                    i2++;
                }
                return java.lang.Integer.parseInt(new java.lang.String(bArr, 0, i, i2 - i));
            }
            i++;
        }
        return -1;
    }

    public static int b() {
        return new java.io.File("/sys/devices/system/cpu/").listFiles(a).length;
    }

    public static int c(java.lang.String str) {
        java.io.FileInputStream fileInputStream;
        java.io.FileInputStream fileInputStream2 = null;
        try {
            fileInputStream = new java.io.FileInputStream(str);
        } catch (java.io.IOException unused) {
        } catch (java.lang.Throwable th) {
            th = th;
        }
        try {
            java.io.BufferedReader bufferedReader = new java.io.BufferedReader(new java.io.InputStreamReader(fileInputStream));
            java.lang.String readLine = bufferedReader.readLine();
            bufferedReader.close();
            int d = d(readLine);
            try {
                fileInputStream.close();
            } catch (java.io.IOException unused2) {
            }
            return d;
        } catch (java.io.IOException unused3) {
            fileInputStream2 = fileInputStream;
            if (fileInputStream2 == null) {
                return -1;
            }
            try {
                fileInputStream2.close();
                return -1;
            } catch (java.io.IOException unused4) {
                return -1;
            }
        } catch (java.lang.Throwable th2) {
            th = th2;
            fileInputStream2 = fileInputStream;
            if (fileInputStream2 != null) {
                try {
                    fileInputStream2.close();
                } catch (java.io.IOException unused5) {
                }
            }
            throw th;
        }
    }

    public static int d(java.lang.String str) {
        if (str == null || !str.matches("0-[\\d]+$")) {
            return -1;
        }
        return java.lang.Integer.valueOf(str.substring(2)).intValue() + 1;
    }

    public static int e(java.lang.String str, java.io.FileInputStream fileInputStream) {
        byte[] bArr = new byte[1024];
        try {
            int read = fileInputStream.read(bArr);
            int i = 0;
            while (i < read) {
                byte b = bArr[i];
                if (b == 10 || i == 0) {
                    if (b == 10) {
                        i++;
                    }
                    for (int i2 = i; i2 < read; i2++) {
                        int i3 = i2 - i;
                        if (bArr[i2] != str.charAt(i3)) {
                            break;
                        }
                        if (i3 == str.length() - 1) {
                            return a(bArr, i2);
                        }
                    }
                }
                i++;
            }
            return -1;
        } catch (java.io.IOException | java.lang.NumberFormatException unused) {
            return -1;
        }
    }

    public static int getCPUMaxFreqKHz() {
        int i = -1;
        for (int i2 = 0; i2 < getNumberOfCPUCores(); i2++) {
            try {
                java.io.File file = new java.io.File("/sys/devices/system/cpu/cpu" + i2 + "/cpufreq/cpuinfo_max_freq");
                if (file.exists() && file.canRead()) {
                    byte[] bArr = new byte[128];
                    java.io.FileInputStream fileInputStream = new java.io.FileInputStream(file);
                    try {
                        fileInputStream.read(bArr);
                        int i3 = 0;
                        while (java.lang.Character.isDigit(bArr[i3]) && i3 < 128) {
                            i3++;
                        }
                        java.lang.Integer valueOf = java.lang.Integer.valueOf(java.lang.Integer.parseInt(new java.lang.String(bArr, 0, i3)));
                        if (valueOf.intValue() > i) {
                            i = valueOf.intValue();
                        }
                    } catch (java.lang.NumberFormatException unused) {
                    } catch (java.lang.Throwable th) {
                        fileInputStream.close();
                        throw th;
                    }
                    fileInputStream.close();
                }
            } catch (java.io.IOException unused2) {
                return -1;
            }
        }
        if (i == -1) {
            java.io.FileInputStream fileInputStream2 = new java.io.FileInputStream("/proc/cpuinfo");
            try {
                int e = e("cpu MHz", fileInputStream2) * 1000;
                if (e > i) {
                    i = e;
                }
                fileInputStream2.close();
            } catch (java.lang.Throwable th2) {
                fileInputStream2.close();
                throw th2;
            }
        }
        return i;
    }

    public static int getNumberOfCPUCores() {
        try {
            int c = c("/sys/devices/system/cpu/possible");
            if (c == -1) {
                c = c("/sys/devices/system/cpu/present");
            }
            return c == -1 ? b() : c;
        } catch (java.lang.NullPointerException | java.lang.SecurityException unused) {
            return -1;
        }
    }

    @android.annotation.TargetApi(16)
    public static long getTotalMemory(android.content.Context context) {
        android.app.ActivityManager.MemoryInfo memoryInfo = new android.app.ActivityManager.MemoryInfo();
        ((android.app.ActivityManager) context.getSystemService("activity")).getMemoryInfo(memoryInfo);
        return memoryInfo.totalMem;
    }
}
