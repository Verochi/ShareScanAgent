package com.jd.ad.sdk.jad_dq;

/* loaded from: classes23.dex */
public final class jad_cp {
    public static java.util.Map<java.lang.String, java.lang.String> jad_an = null;
    public static java.lang.String jad_bo = "";

    /* JADX WARN: Removed duplicated region for block: B:36:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0121 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static java.lang.String jad_an(java.lang.String str) {
        java.io.BufferedReader bufferedReader;
        java.io.BufferedReader bufferedReader2;
        java.util.Iterator it;
        if (str.trim().equals("")) {
            return "";
        }
        if (jad_an == null) {
            jad_an = new java.util.HashMap();
            java.lang.String[] strArr = {"/system/bin/sh", "-c", "getprop"};
            java.util.ArrayList arrayList = new java.util.ArrayList();
            try {
                java.lang.Process exec = java.lang.Runtime.getRuntime().exec(strArr);
                bufferedReader = new java.io.BufferedReader(new java.io.InputStreamReader(exec.getInputStream()));
                while (true) {
                    try {
                        java.lang.String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        arrayList.add(readLine);
                    } catch (java.lang.Throwable th) {
                        th = th;
                        bufferedReader2 = null;
                    }
                }
                bufferedReader2 = new java.io.BufferedReader(new java.io.InputStreamReader(exec.getErrorStream()));
                while (true) {
                    try {
                        java.lang.String readLine2 = bufferedReader2.readLine();
                        if (readLine2 != null) {
                            arrayList.add(readLine2);
                        } else {
                            try {
                                break;
                            } catch (java.io.IOException e) {
                                com.jd.android.sdk.coreinfo.util.Logger.e("CoreInfo.RomNameUtil", "RomNameUtil.exec() exception", e);
                            }
                        }
                    } catch (java.lang.Throwable th2) {
                        th = th2;
                        try {
                            com.jd.android.sdk.coreinfo.util.Logger.e("CoreInfo.RomNameUtil", "RomNameUtil.exec() exception", th);
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (java.io.IOException e2) {
                                    com.jd.android.sdk.coreinfo.util.Logger.e("CoreInfo.RomNameUtil", "RomNameUtil.exec() exception", e2);
                                }
                            }
                            if (bufferedReader2 != null) {
                                try {
                                    bufferedReader2.close();
                                } catch (java.io.IOException e3) {
                                    com.jd.android.sdk.coreinfo.util.Logger.e("CoreInfo.RomNameUtil", "RomNameUtil.exec() exception", e3);
                                }
                            }
                            arrayList = null;
                            if (arrayList != null) {
                                com.jd.android.sdk.coreinfo.util.Logger.d("CoreInfo.RomNameUtil", "Successfully get 'getprop' list.");
                                java.util.regex.Pattern compile = java.util.regex.Pattern.compile("\\[(.+)\\]: \\[(.*)\\]");
                                it = arrayList.iterator();
                                while (it.hasNext()) {
                                }
                                com.jd.android.sdk.coreinfo.util.Logger.d("CoreInfo.RomNameUtil", "System properties number: " + jad_an.size());
                            }
                            if (!jad_an.containsKey(str)) {
                            }
                        } finally {
                        }
                    }
                }
                bufferedReader.close();
                try {
                    bufferedReader2.close();
                } catch (java.io.IOException e4) {
                    com.jd.android.sdk.coreinfo.util.Logger.e("CoreInfo.RomNameUtil", "RomNameUtil.exec() exception", e4);
                }
                try {
                    bufferedReader.close();
                } catch (java.io.IOException e5) {
                    com.jd.android.sdk.coreinfo.util.Logger.e("CoreInfo.RomNameUtil", "RomNameUtil.exec() exception", e5);
                }
                try {
                    bufferedReader2.close();
                } catch (java.io.IOException e6) {
                    com.jd.android.sdk.coreinfo.util.Logger.e("CoreInfo.RomNameUtil", "RomNameUtil.exec() exception", e6);
                }
            } catch (java.lang.Throwable th3) {
                th = th3;
                bufferedReader = null;
                bufferedReader2 = null;
            }
            if (arrayList != null && arrayList.size() > 0) {
                com.jd.android.sdk.coreinfo.util.Logger.d("CoreInfo.RomNameUtil", "Successfully get 'getprop' list.");
                java.util.regex.Pattern compile2 = java.util.regex.Pattern.compile("\\[(.+)\\]: \\[(.*)\\]");
                it = arrayList.iterator();
                while (it.hasNext()) {
                    java.util.regex.Matcher matcher = compile2.matcher((java.lang.String) it.next());
                    if (matcher.find()) {
                        jad_an.put(matcher.group(1), matcher.group(2));
                    }
                }
                com.jd.android.sdk.coreinfo.util.Logger.d("CoreInfo.RomNameUtil", "System properties number: " + jad_an.size());
            }
        }
        return !jad_an.containsKey(str) ? jad_an.get(str) : "";
    }
}
