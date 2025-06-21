package com.loc;

/* loaded from: classes23.dex */
public final class as {
    private static volatile com.loc.ar a;
    private static java.util.Properties b;

    private as() {
    }

    public static com.loc.ar a() {
        if (a == null) {
            synchronized (com.loc.as.class) {
                if (a == null) {
                    try {
                        com.loc.ar a2 = a(android.os.Build.MANUFACTURER);
                        if ("".equals(a2.a())) {
                            java.util.Iterator it = java.util.Arrays.asList(com.loc.ar.MIUI.a(), com.loc.ar.Flyme.a(), com.loc.ar.RH.a(), com.loc.ar.ColorOS.a(), com.loc.ar.FuntouchOS.a(), com.loc.ar.SmartisanOS.a(), com.loc.ar.AmigoOS.a(), com.loc.ar.Sense.a(), com.loc.ar.LG.a(), com.loc.ar.Google.a(), com.loc.ar.NubiaUI.a()).iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    a2 = com.loc.ar.Other;
                                    break;
                                }
                                com.loc.ar a3 = a((java.lang.String) it.next());
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

    private static com.loc.ar a(java.lang.String str) {
        if (str == null || str.length() <= 0) {
            return com.loc.ar.Other;
        }
        com.loc.ar arVar = com.loc.ar.MIUI;
        if (!str.equalsIgnoreCase(arVar.a())) {
            com.loc.ar arVar2 = com.loc.ar.Flyme;
            if (!str.equalsIgnoreCase(arVar2.a())) {
                com.loc.ar arVar3 = com.loc.ar.RH;
                if (!str.equalsIgnoreCase(arVar3.a())) {
                    com.loc.ar arVar4 = com.loc.ar.ColorOS;
                    if (!str.equalsIgnoreCase(arVar4.a())) {
                        com.loc.ar arVar5 = com.loc.ar.FuntouchOS;
                        if (!str.equalsIgnoreCase(arVar5.a())) {
                            com.loc.ar arVar6 = com.loc.ar.SmartisanOS;
                            if (!str.equalsIgnoreCase(arVar6.a())) {
                                com.loc.ar arVar7 = com.loc.ar.AmigoOS;
                                if (!str.equalsIgnoreCase(arVar7.a())) {
                                    com.loc.ar arVar8 = com.loc.ar.EUI;
                                    if (!str.equalsIgnoreCase(arVar8.a())) {
                                        com.loc.ar arVar9 = com.loc.ar.Sense;
                                        if (!str.equalsIgnoreCase(arVar9.a())) {
                                            com.loc.ar arVar10 = com.loc.ar.LG;
                                            if (!str.equalsIgnoreCase(arVar10.a())) {
                                                com.loc.ar arVar11 = com.loc.ar.Google;
                                                if (!str.equalsIgnoreCase(arVar11.a())) {
                                                    com.loc.ar arVar12 = com.loc.ar.NubiaUI;
                                                    if (str.equalsIgnoreCase(arVar12.a()) && l(arVar12)) {
                                                        return arVar12;
                                                    }
                                                } else if (k(arVar11)) {
                                                    return arVar11;
                                                }
                                            } else if (j(arVar10)) {
                                                return arVar10;
                                            }
                                        } else if (i(arVar9)) {
                                            return arVar9;
                                        }
                                    } else if (h(arVar8)) {
                                        return arVar8;
                                    }
                                } else if (g(arVar7)) {
                                    return arVar7;
                                }
                            } else if (f(arVar6)) {
                                return arVar6;
                            }
                        } else if (e(arVar5)) {
                            return arVar5;
                        }
                    } else if (d(arVar4)) {
                        return arVar4;
                    }
                } else if (c(arVar3)) {
                    return arVar3;
                }
            } else if (b(arVar2)) {
                return arVar2;
            }
        } else if (a(arVar)) {
            return arVar;
        }
        return com.loc.ar.Other;
    }

    private static void a(com.loc.ar arVar, java.lang.String str) {
        java.util.regex.Matcher matcher = java.util.regex.Pattern.compile("([\\d.]+)[^\\d]*").matcher(str);
        if (matcher.find()) {
            try {
                java.lang.String group = matcher.group(1);
                arVar.a(group);
                arVar.a(java.lang.Integer.parseInt(group.split("\\.")[0]));
            } catch (java.lang.Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static boolean a(com.loc.ar arVar) {
        if (android.text.TextUtils.isEmpty(b(com.igexin.assist.control.xiaomi.XmSystemUtils.KEY_VERSION_MIUI))) {
            return false;
        }
        java.lang.String b2 = b("ro.build.version.incremental");
        a(arVar, b2);
        arVar.b(b2);
        return true;
    }

    private static java.lang.String b(java.lang.String str) {
        java.util.Properties properties = b;
        java.lang.String str2 = null;
        if (properties != null) {
            str2 = properties.getProperty("[" + str + "]", null);
        }
        return android.text.TextUtils.isEmpty(str2) ? c(str) : str2.replace("[", "").replace("]", "");
    }

    private static boolean b(com.loc.ar arVar) {
        java.lang.String b2 = b("ro.flyme.published");
        java.lang.String b3 = b("ro.meizu.setupwizard.flyme");
        if (android.text.TextUtils.isEmpty(b2) && android.text.TextUtils.isEmpty(b3)) {
            return false;
        }
        java.lang.String b4 = b("ro.build.display.id");
        a(arVar, b4);
        arVar.b(b4);
        return true;
    }

    private static java.lang.String c(java.lang.String str) {
        java.io.BufferedReader bufferedReader;
        java.io.BufferedReader bufferedReader2 = null;
        try {
            bufferedReader = new java.io.BufferedReader(new java.io.InputStreamReader(java.lang.Runtime.getRuntime().exec("getprop ".concat(java.lang.String.valueOf(str))).getInputStream()), 1024);
        } catch (java.io.IOException unused) {
            bufferedReader = null;
        } catch (java.lang.Throwable th) {
            th = th;
        }
        try {
            java.lang.String readLine = bufferedReader.readLine();
            bufferedReader.close();
            try {
                bufferedReader.close();
            } catch (java.io.IOException unused2) {
            }
            return readLine;
        } catch (java.io.IOException unused3) {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (java.io.IOException unused4) {
                }
            }
            return null;
        } catch (java.lang.Throwable th2) {
            th = th2;
            bufferedReader2 = bufferedReader;
            if (bufferedReader2 != null) {
                try {
                    bufferedReader2.close();
                } catch (java.io.IOException unused5) {
                }
            }
            throw th;
        }
    }

    private static boolean c(com.loc.ar arVar) {
        java.lang.String b2 = b(com.alipay.sdk.m.c.a.a);
        if (android.text.TextUtils.isEmpty(b2)) {
            return false;
        }
        a(arVar, b2);
        arVar.b(b2);
        return true;
    }

    private static boolean d(com.loc.ar arVar) {
        java.lang.String b2 = b("ro.build.version.opporom");
        if (android.text.TextUtils.isEmpty(b2)) {
            return false;
        }
        a(arVar, b2);
        arVar.b(b2);
        return true;
    }

    private static boolean e(com.loc.ar arVar) {
        java.lang.String b2 = b("ro.vivo.os.build.display.id");
        if (android.text.TextUtils.isEmpty(b2)) {
            return false;
        }
        a(arVar, b2);
        arVar.b(b2);
        return true;
    }

    private static boolean f(com.loc.ar arVar) {
        java.lang.String b2 = b("ro.smartisan.version");
        if (android.text.TextUtils.isEmpty(b2)) {
            return false;
        }
        a(arVar, b2);
        arVar.b(b2);
        return true;
    }

    private static boolean g(com.loc.ar arVar) {
        java.lang.String b2 = b("ro.build.display.id");
        if (android.text.TextUtils.isEmpty(b2) || !b2.matches("amigo([\\d.]+)[a-zA-Z]*")) {
            return false;
        }
        a(arVar, b2);
        arVar.b(b2);
        return true;
    }

    private static boolean h(com.loc.ar arVar) {
        java.lang.String b2 = b("ro.letv.release.version");
        if (android.text.TextUtils.isEmpty(b2)) {
            return false;
        }
        a(arVar, b2);
        arVar.b(b2);
        return true;
    }

    private static boolean i(com.loc.ar arVar) {
        java.lang.String b2 = b("ro.build.sense.version");
        if (android.text.TextUtils.isEmpty(b2)) {
            return false;
        }
        a(arVar, b2);
        arVar.b(b2);
        return true;
    }

    private static boolean j(com.loc.ar arVar) {
        java.lang.String b2 = b("sys.lge.lgmdm_version");
        if (android.text.TextUtils.isEmpty(b2)) {
            return false;
        }
        a(arVar, b2);
        arVar.b(b2);
        return true;
    }

    private static boolean k(com.loc.ar arVar) {
        if (!"android-google".equals(b("ro.com.google.clientidbase"))) {
            return false;
        }
        java.lang.String b2 = b("ro.build.version.release");
        arVar.a(android.os.Build.VERSION.SDK_INT);
        arVar.b(b2);
        return true;
    }

    private static boolean l(com.loc.ar arVar) {
        java.lang.String b2 = b("ro.build.nubia.rom.code");
        if (android.text.TextUtils.isEmpty(b2)) {
            return false;
        }
        a(arVar, b2);
        arVar.b(b2);
        return true;
    }
}
