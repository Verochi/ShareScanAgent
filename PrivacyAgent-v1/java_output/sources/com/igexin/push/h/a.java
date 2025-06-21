package com.igexin.push.h;

/* loaded from: classes23.dex */
public final class a {
    private static final java.lang.String a = "BasicCheck";

    private static java.lang.String a(int i) {
        java.lang.String str;
        try {
            str = a(java.lang.String.format("/proc/%d/cmdline", java.lang.Integer.valueOf(i))).trim();
        } catch (java.lang.Exception e) {
            com.igexin.c.a.c.a.a(e);
            str = null;
        }
        try {
            if (android.text.TextUtils.isEmpty(str)) {
                return a(java.lang.String.format("/proc/%d/stat", java.lang.Integer.valueOf(i))).split("\\s+")[1].replace("(", "").replace(")", "");
            }
        } catch (java.lang.Exception e2) {
            com.igexin.c.a.c.a.a(e2);
        }
        return str;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v4, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r6v9 */
    private static java.lang.String a(java.lang.String str) {
        java.io.FileReader fileReader;
        java.lang.Throwable th;
        java.io.BufferedReader bufferedReader;
        java.lang.StringBuilder sb;
        try {
            try {
                sb = new java.lang.StringBuilder();
                fileReader = new java.io.FileReader((java.lang.String) str);
            } catch (java.lang.Throwable th2) {
                th = th2;
            }
        } catch (java.lang.Exception e) {
            e = e;
            bufferedReader = null;
            fileReader = null;
        } catch (java.lang.Throwable th3) {
            fileReader = null;
            th = th3;
            str = 0;
        }
        try {
            bufferedReader = new java.io.BufferedReader(fileReader);
            while (true) {
                try {
                    java.lang.String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    sb.append(readLine);
                    sb.append("\n");
                } catch (java.lang.Exception e2) {
                    e = e2;
                    com.igexin.c.a.c.a.a(e);
                    if (fileReader != null) {
                        try {
                            fileReader.close();
                        } catch (java.lang.Exception e3) {
                            com.igexin.c.a.c.a.a(e3);
                        }
                    }
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (java.lang.Exception e4) {
                            com.igexin.c.a.c.a.a(e4);
                        }
                    }
                    return null;
                }
            }
            if (sb.length() > 2) {
                java.lang.String substring = sb.substring(0, sb.length() - 2);
                try {
                    fileReader.close();
                } catch (java.lang.Exception e5) {
                    com.igexin.c.a.c.a.a(e5);
                }
                try {
                    bufferedReader.close();
                } catch (java.lang.Exception e6) {
                    com.igexin.c.a.c.a.a(e6);
                }
                return substring;
            }
            java.lang.String sb2 = sb.toString();
            try {
                fileReader.close();
            } catch (java.lang.Exception e7) {
                com.igexin.c.a.c.a.a(e7);
            }
            try {
                bufferedReader.close();
            } catch (java.lang.Exception e8) {
                com.igexin.c.a.c.a.a(e8);
            }
            return sb2;
        } catch (java.lang.Exception e9) {
            e = e9;
            bufferedReader = null;
        } catch (java.lang.Throwable th4) {
            th = th4;
            str = 0;
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (java.lang.Exception e10) {
                    com.igexin.c.a.c.a.a(e10);
                }
            }
            if (str == 0) {
                throw th;
            }
            try {
                str.close();
                throw th;
            } catch (java.lang.Exception e11) {
                com.igexin.c.a.c.a.a(e11);
                throw th;
            }
        }
    }

    public static boolean a() {
        try {
            java.lang.String str = com.igexin.push.h.g.a;
            return true;
        } catch (java.lang.Exception e) {
            com.igexin.c.a.c.a.a(e);
            return false;
        }
    }

    private static boolean b() {
        try {
            for (java.lang.String str : com.igexin.push.core.e.aI.split(",")) {
                if (com.igexin.push.core.e.F.toLowerCase().contains(str.toLowerCase())) {
                    return true;
                }
            }
        } catch (java.lang.Throwable th) {
            com.igexin.c.a.c.a.a(th);
        }
        return false;
    }

    private static boolean c() {
        try {
            for (java.lang.String str : com.igexin.push.config.d.B.split(",")) {
                if (com.igexin.push.h.n.e().toLowerCase().contains(str.toLowerCase())) {
                    return true;
                }
            }
        } catch (java.lang.Throwable th) {
            com.igexin.c.a.c.a.a(th);
        }
        return false;
    }
}
