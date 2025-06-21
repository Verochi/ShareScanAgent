package com.amap.api.col.s;

/* loaded from: classes12.dex */
public final class cf {
    public static volatile com.amap.api.col.s.ce a;
    public static java.util.Properties b = f();

    public static com.amap.api.col.s.ce a() {
        if (a == null) {
            synchronized (com.amap.api.col.s.cf.class) {
                if (a == null) {
                    try {
                        com.amap.api.col.s.ce b2 = b(android.os.Build.MANUFACTURER);
                        if ("".equals(b2.a())) {
                            java.util.Iterator it = java.util.Arrays.asList(com.amap.api.col.s.ce.MIUI.a(), com.amap.api.col.s.ce.Flyme.a(), com.amap.api.col.s.ce.EMUI.a(), com.amap.api.col.s.ce.ColorOS.a(), com.amap.api.col.s.ce.FuntouchOS.a(), com.amap.api.col.s.ce.SmartisanOS.a(), com.amap.api.col.s.ce.AmigoOS.a(), com.amap.api.col.s.ce.Sense.a(), com.amap.api.col.s.ce.LG.a(), com.amap.api.col.s.ce.Google.a(), com.amap.api.col.s.ce.NubiaUI.a()).iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    b2 = com.amap.api.col.s.ce.Other;
                                    break;
                                }
                                com.amap.api.col.s.ce b3 = b((java.lang.String) it.next());
                                if (!"".equals(b3.a())) {
                                    b2 = b3;
                                    break;
                                }
                            }
                        }
                        a = b2;
                    } catch (java.lang.Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return a;
    }

    public static com.amap.api.col.s.ce b(java.lang.String str) {
        if (str == null || str.length() <= 0) {
            return com.amap.api.col.s.ce.Other;
        }
        com.amap.api.col.s.ce ceVar = com.amap.api.col.s.ce.MIUI;
        if (!str.equals(ceVar.a())) {
            com.amap.api.col.s.ce ceVar2 = com.amap.api.col.s.ce.Flyme;
            if (!str.equals(ceVar2.a())) {
                com.amap.api.col.s.ce ceVar3 = com.amap.api.col.s.ce.EMUI;
                if (!str.equals(ceVar3.a())) {
                    com.amap.api.col.s.ce ceVar4 = com.amap.api.col.s.ce.ColorOS;
                    if (!str.equals(ceVar4.a())) {
                        com.amap.api.col.s.ce ceVar5 = com.amap.api.col.s.ce.FuntouchOS;
                        if (!str.equals(ceVar5.a())) {
                            com.amap.api.col.s.ce ceVar6 = com.amap.api.col.s.ce.SmartisanOS;
                            if (!str.equals(ceVar6.a())) {
                                com.amap.api.col.s.ce ceVar7 = com.amap.api.col.s.ce.AmigoOS;
                                if (!str.equals(ceVar7.a())) {
                                    com.amap.api.col.s.ce ceVar8 = com.amap.api.col.s.ce.EUI;
                                    if (!str.equals(ceVar8.a())) {
                                        com.amap.api.col.s.ce ceVar9 = com.amap.api.col.s.ce.Sense;
                                        if (!str.equals(ceVar9.a())) {
                                            com.amap.api.col.s.ce ceVar10 = com.amap.api.col.s.ce.LG;
                                            if (!str.equals(ceVar10.a())) {
                                                com.amap.api.col.s.ce ceVar11 = com.amap.api.col.s.ce.Google;
                                                if (!str.equals(ceVar11.a())) {
                                                    com.amap.api.col.s.ce ceVar12 = com.amap.api.col.s.ce.NubiaUI;
                                                    if (str.equals(ceVar12.a()) && r(ceVar12)) {
                                                        return ceVar12;
                                                    }
                                                } else if (q(ceVar11)) {
                                                    return ceVar11;
                                                }
                                            } else if (p(ceVar10)) {
                                                return ceVar10;
                                            }
                                        } else if (o(ceVar9)) {
                                            return ceVar9;
                                        }
                                    } else if (n(ceVar8)) {
                                        return ceVar8;
                                    }
                                } else if (m(ceVar7)) {
                                    return ceVar7;
                                }
                            } else if (l(ceVar6)) {
                                return ceVar6;
                            }
                        } else if (k(ceVar5)) {
                            return ceVar5;
                        }
                    } else if (j(ceVar4)) {
                        return ceVar4;
                    }
                } else if (i(ceVar3)) {
                    return ceVar3;
                }
            } else if (g(ceVar2)) {
                return ceVar2;
            }
        } else if (d(ceVar)) {
            return ceVar;
        }
        return com.amap.api.col.s.ce.Other;
    }

    public static void c(com.amap.api.col.s.ce ceVar, java.lang.String str) {
        java.util.regex.Matcher matcher = java.util.regex.Pattern.compile("([\\d.]+)[^\\d]*").matcher(str);
        if (matcher.find()) {
            try {
                java.lang.String group = matcher.group(1);
                ceVar.a(group);
                ceVar.a(java.lang.Integer.parseInt(group.split("\\.")[0]));
            } catch (java.lang.Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean d(com.amap.api.col.s.ce ceVar) {
        if (android.text.TextUtils.isEmpty(e(com.igexin.assist.control.xiaomi.XmSystemUtils.KEY_VERSION_MIUI))) {
            return false;
        }
        java.lang.String e = e("ro.build.version.incremental");
        c(ceVar, e);
        ceVar.b(e);
        return true;
    }

    public static java.lang.String e(java.lang.String str) {
        java.lang.String property = b.getProperty("[" + str + "]", null);
        return android.text.TextUtils.isEmpty(property) ? h(str) : property.replace("[", "").replace("]", "");
    }

    public static java.util.Properties f() {
        java.util.Properties properties = new java.util.Properties();
        try {
            properties.load(java.lang.Runtime.getRuntime().exec("getprop").getInputStream());
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
        return properties;
    }

    public static boolean g(com.amap.api.col.s.ce ceVar) {
        java.lang.String e = e("ro.flyme.published");
        java.lang.String e2 = e("ro.meizu.setupwizard.flyme");
        if (android.text.TextUtils.isEmpty(e) && android.text.TextUtils.isEmpty(e2)) {
            return false;
        }
        java.lang.String e3 = e("ro.build.display.id");
        c(ceVar, e3);
        ceVar.b(e3);
        return true;
    }

    public static java.lang.String h(java.lang.String str) {
        java.io.BufferedReader bufferedReader;
        java.io.BufferedReader bufferedReader2 = null;
        try {
            bufferedReader = new java.io.BufferedReader(new java.io.InputStreamReader(java.lang.Runtime.getRuntime().exec("getprop ".concat(java.lang.String.valueOf(str))).getInputStream()), 1024);
            try {
                java.lang.String readLine = bufferedReader.readLine();
                bufferedReader.close();
                try {
                    bufferedReader.close();
                } catch (java.io.IOException unused) {
                }
                return readLine;
            } catch (java.io.IOException unused2) {
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (java.io.IOException unused3) {
                    }
                }
                return null;
            } catch (java.lang.Throwable th) {
                th = th;
                bufferedReader2 = bufferedReader;
                if (bufferedReader2 != null) {
                    try {
                        bufferedReader2.close();
                    } catch (java.io.IOException unused4) {
                    }
                }
                throw th;
            }
        } catch (java.io.IOException unused5) {
            bufferedReader = null;
        } catch (java.lang.Throwable th2) {
            th = th2;
        }
    }

    public static boolean i(com.amap.api.col.s.ce ceVar) {
        java.lang.String e = e(com.alipay.sdk.m.c.a.a);
        if (android.text.TextUtils.isEmpty(e)) {
            return false;
        }
        c(ceVar, e);
        ceVar.b(e);
        return true;
    }

    public static boolean j(com.amap.api.col.s.ce ceVar) {
        java.lang.String e = e("ro.build.version.opporom");
        if (android.text.TextUtils.isEmpty(e)) {
            return false;
        }
        c(ceVar, e);
        ceVar.b(e);
        return true;
    }

    public static boolean k(com.amap.api.col.s.ce ceVar) {
        java.lang.String e = e("ro.vivo.os.build.display.id");
        if (android.text.TextUtils.isEmpty(e)) {
            return false;
        }
        c(ceVar, e);
        ceVar.b(e);
        return true;
    }

    public static boolean l(com.amap.api.col.s.ce ceVar) {
        java.lang.String e = e("ro.smartisan.version");
        if (android.text.TextUtils.isEmpty(e)) {
            return false;
        }
        c(ceVar, e);
        ceVar.b(e);
        return true;
    }

    public static boolean m(com.amap.api.col.s.ce ceVar) {
        java.lang.String e = e("ro.build.display.id");
        if (android.text.TextUtils.isEmpty(e) || !e.matches("amigo([\\d.]+)[a-zA-Z]*")) {
            return false;
        }
        c(ceVar, e);
        ceVar.b(e);
        return true;
    }

    public static boolean n(com.amap.api.col.s.ce ceVar) {
        java.lang.String e = e("ro.letv.release.version");
        if (android.text.TextUtils.isEmpty(e)) {
            return false;
        }
        c(ceVar, e);
        ceVar.b(e);
        return true;
    }

    public static boolean o(com.amap.api.col.s.ce ceVar) {
        java.lang.String e = e("ro.build.sense.version");
        if (android.text.TextUtils.isEmpty(e)) {
            return false;
        }
        c(ceVar, e);
        ceVar.b(e);
        return true;
    }

    public static boolean p(com.amap.api.col.s.ce ceVar) {
        java.lang.String e = e("sys.lge.lgmdm_version");
        if (android.text.TextUtils.isEmpty(e)) {
            return false;
        }
        c(ceVar, e);
        ceVar.b(e);
        return true;
    }

    public static boolean q(com.amap.api.col.s.ce ceVar) {
        if (!"android-google".equals(e("ro.com.google.clientidbase"))) {
            return false;
        }
        java.lang.String e = e("ro.build.version.release");
        ceVar.a(android.os.Build.VERSION.SDK_INT);
        ceVar.b(e);
        return true;
    }

    public static boolean r(com.amap.api.col.s.ce ceVar) {
        java.lang.String e = e("ro.build.nubia.rom.code");
        if (android.text.TextUtils.isEmpty(e)) {
            return false;
        }
        c(ceVar, e);
        ceVar.b(e);
        return true;
    }
}
