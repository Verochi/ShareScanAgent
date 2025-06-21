package com.amap.api.mapcore.util;

/* loaded from: classes12.dex */
public final class fz {
    private static volatile com.amap.api.mapcore.util.fy a;
    private static java.util.Properties b = b();

    private fz() {
    }

    public static com.amap.api.mapcore.util.fy a() {
        if (a == null) {
            synchronized (com.amap.api.mapcore.util.fz.class) {
                if (a == null) {
                    try {
                        com.amap.api.mapcore.util.fy a2 = a(android.os.Build.MANUFACTURER);
                        if ("".equals(a2.a())) {
                            java.util.Iterator it = java.util.Arrays.asList(com.amap.api.mapcore.util.fy.MIUI.a(), com.amap.api.mapcore.util.fy.Flyme.a(), com.amap.api.mapcore.util.fy.EMUI.a(), com.amap.api.mapcore.util.fy.ColorOS.a(), com.amap.api.mapcore.util.fy.FuntouchOS.a(), com.amap.api.mapcore.util.fy.SmartisanOS.a(), com.amap.api.mapcore.util.fy.AmigoOS.a(), com.amap.api.mapcore.util.fy.Sense.a(), com.amap.api.mapcore.util.fy.LG.a(), com.amap.api.mapcore.util.fy.Google.a(), com.amap.api.mapcore.util.fy.NubiaUI.a()).iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    a2 = com.amap.api.mapcore.util.fy.Other;
                                    break;
                                }
                                com.amap.api.mapcore.util.fy a3 = a((java.lang.String) it.next());
                                if (!"".equals(a3.a())) {
                                    a2 = a3;
                                    break;
                                }
                            }
                        }
                        a = a2;
                    } catch (java.lang.Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return a;
    }

    private static com.amap.api.mapcore.util.fy a(java.lang.String str) {
        if (str == null || str.length() <= 0) {
            return com.amap.api.mapcore.util.fy.Other;
        }
        com.amap.api.mapcore.util.fy fyVar = com.amap.api.mapcore.util.fy.MIUI;
        if (!str.equals(fyVar.a())) {
            com.amap.api.mapcore.util.fy fyVar2 = com.amap.api.mapcore.util.fy.Flyme;
            if (!str.equals(fyVar2.a())) {
                com.amap.api.mapcore.util.fy fyVar3 = com.amap.api.mapcore.util.fy.EMUI;
                if (!str.equals(fyVar3.a())) {
                    com.amap.api.mapcore.util.fy fyVar4 = com.amap.api.mapcore.util.fy.ColorOS;
                    if (!str.equals(fyVar4.a())) {
                        com.amap.api.mapcore.util.fy fyVar5 = com.amap.api.mapcore.util.fy.FuntouchOS;
                        if (!str.equals(fyVar5.a())) {
                            com.amap.api.mapcore.util.fy fyVar6 = com.amap.api.mapcore.util.fy.SmartisanOS;
                            if (!str.equals(fyVar6.a())) {
                                com.amap.api.mapcore.util.fy fyVar7 = com.amap.api.mapcore.util.fy.AmigoOS;
                                if (!str.equals(fyVar7.a())) {
                                    com.amap.api.mapcore.util.fy fyVar8 = com.amap.api.mapcore.util.fy.EUI;
                                    if (!str.equals(fyVar8.a())) {
                                        com.amap.api.mapcore.util.fy fyVar9 = com.amap.api.mapcore.util.fy.Sense;
                                        if (!str.equals(fyVar9.a())) {
                                            com.amap.api.mapcore.util.fy fyVar10 = com.amap.api.mapcore.util.fy.LG;
                                            if (!str.equals(fyVar10.a())) {
                                                com.amap.api.mapcore.util.fy fyVar11 = com.amap.api.mapcore.util.fy.Google;
                                                if (!str.equals(fyVar11.a())) {
                                                    com.amap.api.mapcore.util.fy fyVar12 = com.amap.api.mapcore.util.fy.NubiaUI;
                                                    if (str.equals(fyVar12.a()) && l(fyVar12)) {
                                                        return fyVar12;
                                                    }
                                                } else if (k(fyVar11)) {
                                                    return fyVar11;
                                                }
                                            } else if (j(fyVar10)) {
                                                return fyVar10;
                                            }
                                        } else if (i(fyVar9)) {
                                            return fyVar9;
                                        }
                                    } else if (h(fyVar8)) {
                                        return fyVar8;
                                    }
                                } else if (g(fyVar7)) {
                                    return fyVar7;
                                }
                            } else if (f(fyVar6)) {
                                return fyVar6;
                            }
                        } else if (e(fyVar5)) {
                            return fyVar5;
                        }
                    } else if (d(fyVar4)) {
                        return fyVar4;
                    }
                } else if (c(fyVar3)) {
                    return fyVar3;
                }
            } else if (b(fyVar2)) {
                return fyVar2;
            }
        } else if (a(fyVar)) {
            return fyVar;
        }
        return com.amap.api.mapcore.util.fy.Other;
    }

    private static void a(com.amap.api.mapcore.util.fy fyVar, java.lang.String str) {
        java.util.regex.Matcher matcher = java.util.regex.Pattern.compile("([\\d.]+)[^\\d]*").matcher(str);
        if (matcher.find()) {
            try {
                java.lang.String group = matcher.group(1);
                fyVar.a(group);
                fyVar.a(java.lang.Integer.parseInt(group.split("\\.")[0]));
            } catch (java.lang.Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static boolean a(com.amap.api.mapcore.util.fy fyVar) {
        if (android.text.TextUtils.isEmpty(b(com.igexin.assist.control.xiaomi.XmSystemUtils.KEY_VERSION_MIUI))) {
            return false;
        }
        java.lang.String b2 = b("ro.build.version.incremental");
        a(fyVar, b2);
        fyVar.b(b2);
        return true;
    }

    private static java.lang.String b(java.lang.String str) {
        java.lang.String property = b.getProperty("[" + str + "]", null);
        return android.text.TextUtils.isEmpty(property) ? c(str) : property.replace("[", "").replace("]", "");
    }

    private static java.util.Properties b() {
        java.util.Properties properties = new java.util.Properties();
        try {
            properties.load(java.lang.Runtime.getRuntime().exec("getprop").getInputStream());
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
        return properties;
    }

    private static boolean b(com.amap.api.mapcore.util.fy fyVar) {
        java.lang.String b2 = b("ro.flyme.published");
        java.lang.String b3 = b("ro.meizu.setupwizard.flyme");
        if (android.text.TextUtils.isEmpty(b2) && android.text.TextUtils.isEmpty(b3)) {
            return false;
        }
        java.lang.String b4 = b("ro.build.display.id");
        a(fyVar, b4);
        fyVar.b(b4);
        return true;
    }

    private static java.lang.String c(java.lang.String str) {
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

    private static boolean c(com.amap.api.mapcore.util.fy fyVar) {
        java.lang.String b2 = b(com.alipay.sdk.m.c.a.a);
        if (android.text.TextUtils.isEmpty(b2)) {
            return false;
        }
        a(fyVar, b2);
        fyVar.b(b2);
        return true;
    }

    private static boolean d(com.amap.api.mapcore.util.fy fyVar) {
        java.lang.String b2 = b("ro.build.version.opporom");
        if (android.text.TextUtils.isEmpty(b2)) {
            return false;
        }
        a(fyVar, b2);
        fyVar.b(b2);
        return true;
    }

    private static boolean e(com.amap.api.mapcore.util.fy fyVar) {
        java.lang.String b2 = b("ro.vivo.os.build.display.id");
        if (android.text.TextUtils.isEmpty(b2)) {
            return false;
        }
        a(fyVar, b2);
        fyVar.b(b2);
        return true;
    }

    private static boolean f(com.amap.api.mapcore.util.fy fyVar) {
        java.lang.String b2 = b("ro.smartisan.version");
        if (android.text.TextUtils.isEmpty(b2)) {
            return false;
        }
        a(fyVar, b2);
        fyVar.b(b2);
        return true;
    }

    private static boolean g(com.amap.api.mapcore.util.fy fyVar) {
        java.lang.String b2 = b("ro.build.display.id");
        if (android.text.TextUtils.isEmpty(b2) || !b2.matches("amigo([\\d.]+)[a-zA-Z]*")) {
            return false;
        }
        a(fyVar, b2);
        fyVar.b(b2);
        return true;
    }

    private static boolean h(com.amap.api.mapcore.util.fy fyVar) {
        java.lang.String b2 = b("ro.letv.release.version");
        if (android.text.TextUtils.isEmpty(b2)) {
            return false;
        }
        a(fyVar, b2);
        fyVar.b(b2);
        return true;
    }

    private static boolean i(com.amap.api.mapcore.util.fy fyVar) {
        java.lang.String b2 = b("ro.build.sense.version");
        if (android.text.TextUtils.isEmpty(b2)) {
            return false;
        }
        a(fyVar, b2);
        fyVar.b(b2);
        return true;
    }

    private static boolean j(com.amap.api.mapcore.util.fy fyVar) {
        java.lang.String b2 = b("sys.lge.lgmdm_version");
        if (android.text.TextUtils.isEmpty(b2)) {
            return false;
        }
        a(fyVar, b2);
        fyVar.b(b2);
        return true;
    }

    private static boolean k(com.amap.api.mapcore.util.fy fyVar) {
        if (!"android-google".equals(b("ro.com.google.clientidbase"))) {
            return false;
        }
        java.lang.String b2 = b("ro.build.version.release");
        fyVar.a(android.os.Build.VERSION.SDK_INT);
        fyVar.b(b2);
        return true;
    }

    private static boolean l(com.amap.api.mapcore.util.fy fyVar) {
        java.lang.String b2 = b("ro.build.nubia.rom.code");
        if (android.text.TextUtils.isEmpty(b2)) {
            return false;
        }
        a(fyVar, b2);
        fyVar.b(b2);
        return true;
    }
}
