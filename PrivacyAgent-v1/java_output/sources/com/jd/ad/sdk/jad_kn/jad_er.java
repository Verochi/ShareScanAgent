package com.jd.ad.sdk.jad_kn;

/* loaded from: classes23.dex */
public class jad_er {
    public static long jad_an;
    public static android.net.LocalServerSocket jad_bo;
    public static java.lang.String[] jad_cp = {"com.bly.dkplat", "com.by.chaos", "com.lbe.parallel", "com.excelliance.dualaid", "com.lody.virtual", "com.qihoo.magic", "com.dual.dualgenius", "com.jiubang.commerce.gomultiple"};

    public static boolean jad_an() {
        java.io.BufferedReader bufferedReader = null;
        try {
            try {
                java.io.BufferedReader bufferedReader2 = new java.io.BufferedReader(new java.io.FileReader("/proc/self/maps"));
                while (true) {
                    try {
                        java.lang.String readLine = bufferedReader2.readLine();
                        if (readLine == null) {
                            bufferedReader2.close();
                            break;
                        }
                        for (java.lang.String str : jad_cp) {
                            if (readLine.contains(str)) {
                                try {
                                    bufferedReader2.close();
                                    return true;
                                } catch (java.io.IOException unused) {
                                    return true;
                                }
                            }
                        }
                    } catch (java.lang.Exception unused2) {
                        bufferedReader = bufferedReader2;
                        if (bufferedReader != null) {
                            bufferedReader.close();
                        }
                        return false;
                    } catch (java.lang.Throwable th) {
                        th = th;
                        bufferedReader = bufferedReader2;
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (java.io.IOException unused3) {
                            }
                        }
                        throw th;
                    }
                }
            } catch (java.io.IOException unused4) {
            }
        } catch (java.lang.Exception unused5) {
        } catch (java.lang.Throwable th2) {
            th = th2;
        }
        return false;
    }

    public static boolean jad_an(android.content.Context context) {
        java.lang.String absolutePath = context.getFilesDir().getAbsolutePath();
        java.lang.String packageName = context.getPackageName();
        java.lang.String str = "/data/data/" + packageName + "/files";
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("/data/user/0/");
        sb.append(packageName);
        sb.append("/files");
        return (str.equals(absolutePath) || sb.toString().equals(absolutePath)) ? false : true;
    }
}
