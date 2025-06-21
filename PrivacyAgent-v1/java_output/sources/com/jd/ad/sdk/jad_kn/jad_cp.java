package com.jd.ad.sdk.jad_kn;

/* loaded from: classes23.dex */
public class jad_cp {
    public static long jad_an;

    public static java.lang.Boolean jad_an() {
        java.io.BufferedReader bufferedReader;
        java.lang.String readLine;
        java.util.HashSet hashSet = new java.util.HashSet();
        java.lang.StringBuilder jad_an2 = com.jd.ad.sdk.jad_bo.jad_bo.jad_an("/proc/");
        jad_an2.append(android.os.Process.myPid());
        jad_an2.append("/maps");
        try {
            bufferedReader = new java.io.BufferedReader(new java.io.FileReader(jad_an2.toString()));
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
        do {
            readLine = bufferedReader.readLine();
            if (readLine == null) {
                java.util.Iterator it = hashSet.iterator();
                while (it.hasNext()) {
                    java.lang.String str = (java.lang.String) it.next();
                    if (!str.contains("com.saurik.substrate") && !str.contains("XposedBridge.jar")) {
                    }
                    return java.lang.Boolean.TRUE;
                }
                bufferedReader.close();
                return java.lang.Boolean.FALSE;
            }
            if (readLine.endsWith(".jar") || readLine.endsWith(".so")) {
                hashSet.add(readLine.substring(readLine.lastIndexOf(" ") + 1));
            }
        } while (!readLine.toLowerCase().contains("frida"));
        return java.lang.Boolean.TRUE;
    }

    public static java.lang.Boolean jad_an(android.content.Context context) {
        try {
            throw new java.lang.Exception("Deteck hook");
        } catch (java.lang.Exception e) {
            int i = 0;
            for (java.lang.StackTraceElement stackTraceElement : e.getStackTrace()) {
                if (("com.saurik.substrate.MS$2".equals(stackTraceElement.getClassName()) && "invoke".equals(stackTraceElement.getMethodName())) || (("de.robv.android.xposed.XposedBridge".equals(stackTraceElement.getClassName()) && "main".equals(stackTraceElement.getMethodName())) || ("de.robv.android.xposed.XposedBridge".equals(stackTraceElement.getClassName()) && "handleHookedMethod".equals(stackTraceElement.getMethodName())))) {
                    return java.lang.Boolean.TRUE;
                }
                if ("com.android.internal.os.ZygoteInit".equals(stackTraceElement.getClassName()) && (i = i + 1) == 2) {
                    return java.lang.Boolean.TRUE;
                }
            }
            return java.lang.Boolean.FALSE;
        }
    }
}
