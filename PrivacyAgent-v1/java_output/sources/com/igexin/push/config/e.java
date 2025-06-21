package com.igexin.push.config;

/* loaded from: classes23.dex */
public final class e {
    private static java.lang.String a = "FileConfig";

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0055 A[Catch: all -> 0x00d1, Exception -> 0x00e7, TryCatch #15 {Exception -> 0x00e7, all -> 0x00d1, blocks: (B:11:0x0048, B:13:0x0055, B:16:0x007f, B:17:0x0086, B:19:0x0087), top: B:10:0x0048 }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00a0 A[Catch: all -> 0x00c1, Exception -> 0x00c6, TryCatch #18 {Exception -> 0x00c6, all -> 0x00c1, blocks: (B:23:0x009a, B:25:0x00a0, B:28:0x00a8), top: B:22:0x009a }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00b0 A[EDGE_INSN: B:32:0x00b0->B:33:0x00b0 BREAK  A[LOOP:0: B:22:0x009a->B:30:0x009a], EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v18 */
    /* JADX WARN: Type inference failed for: r0v19, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v20 */
    /* JADX WARN: Type inference failed for: r0v21 */
    /* JADX WARN: Type inference failed for: r0v23 */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v5, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r2v2, types: [android.content.res.AssetManager] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a() {
        java.io.FileInputStream fileInputStream;
        java.io.FileInputStream fileInputStream2;
        java.io.BufferedReader bufferedReader;
        java.lang.String readLine;
        ?? r0 = com.igexin.push.core.e.g + ".properties";
        java.io.InputStream inputStream = null;
        r3 = null;
        r3 = null;
        java.io.BufferedReader bufferedReader2 = null;
        java.io.BufferedReader bufferedReader3 = null;
        try {
            try {
                r0 = com.igexin.push.core.e.l.getResources().getAssets().open(r0);
            } catch (java.lang.Exception e) {
                com.igexin.c.a.c.a.a(e);
            }
            try {
                a((java.io.InputStream) r0);
            } catch (java.lang.Exception unused) {
                r0 = r0;
                if (r0 != 0) {
                    r0.close();
                    r0 = r0;
                }
                if (!new java.io.File(com.igexin.push.h.j.a).exists()) {
                }
                fileInputStream2 = new java.io.FileInputStream(com.igexin.push.h.j.a);
                try {
                    bufferedReader = new java.io.BufferedReader(new java.io.InputStreamReader(fileInputStream2, "UTF-8"));
                    while (true) {
                        try {
                            readLine = bufferedReader.readLine();
                            if (readLine != null) {
                            }
                        } catch (java.lang.Exception unused2) {
                            bufferedReader2 = bufferedReader;
                            fileInputStream = fileInputStream2;
                            if (bufferedReader2 != null) {
                                try {
                                    bufferedReader2.close();
                                } catch (java.io.IOException e2) {
                                    com.igexin.c.a.c.a.a(e2);
                                }
                            }
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                    return;
                                } catch (java.lang.Exception e3) {
                                    com.igexin.c.a.c.a.a(e3);
                                    return;
                                }
                            }
                            return;
                        } catch (java.lang.Throwable th) {
                            bufferedReader3 = bufferedReader;
                            r0 = fileInputStream2;
                            th = th;
                            if (bufferedReader3 != null) {
                                try {
                                    bufferedReader3.close();
                                } catch (java.io.IOException e4) {
                                    com.igexin.c.a.c.a.a(e4);
                                }
                            }
                            if (r0 == 0) {
                                throw th;
                            }
                            try {
                                r0.close();
                                throw th;
                            } catch (java.lang.Exception e5) {
                                com.igexin.c.a.c.a.a(e5);
                                throw th;
                            }
                        }
                    }
                    bufferedReader.close();
                    try {
                        fileInputStream2.close();
                    } catch (java.lang.Exception e6) {
                        com.igexin.c.a.c.a.a(e6);
                        return;
                    }
                } catch (java.lang.Exception unused3) {
                } catch (java.lang.Throwable th2) {
                    th = th2;
                    r0 = fileInputStream2;
                }
            } catch (java.lang.Throwable th3) {
                th = th3;
                inputStream = r0;
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (java.lang.Exception e7) {
                        com.igexin.c.a.c.a.a(e7);
                    }
                }
                throw th;
            }
        } catch (java.lang.Exception unused4) {
            r0 = 0;
        } catch (java.lang.Throwable th4) {
            th = th4;
        }
        if (r0 != 0) {
            r0.close();
            r0 = r0;
        }
        try {
            if (!new java.io.File(com.igexin.push.h.j.a).exists()) {
                com.igexin.push.h.j.a = com.igexin.push.h.j.b(com.igexin.push.core.e.l) + com.igexin.push.core.e.g + ".properties";
                if (!new java.io.File(com.igexin.push.h.j.a).exists()) {
                    throw new java.lang.RuntimeException("extraConfigPath no exists");
                }
            }
            fileInputStream2 = new java.io.FileInputStream(com.igexin.push.h.j.a);
            bufferedReader = new java.io.BufferedReader(new java.io.InputStreamReader(fileInputStream2, "UTF-8"));
            while (true) {
                readLine = bufferedReader.readLine();
                if (readLine != null) {
                    try {
                        break;
                    } catch (java.io.IOException e8) {
                        com.igexin.c.a.c.a.a(e8);
                    }
                } else if (!readLine.startsWith("#")) {
                    int length = readLine.split(com.huawei.hms.framework.common.ContainerUtils.KEY_VALUE_DELIMITER).length;
                }
            }
            bufferedReader.close();
            fileInputStream2.close();
        } catch (java.lang.Exception unused5) {
            fileInputStream = r0;
        } catch (java.lang.Throwable th5) {
            th = th5;
        }
    }

    private static void a(java.io.InputStream inputStream) {
        java.io.BufferedReader bufferedReader = null;
        try {
            try {
                java.io.BufferedReader bufferedReader2 = new java.io.BufferedReader(new java.io.InputStreamReader(inputStream, "UTF-8"));
                while (true) {
                    try {
                        java.lang.String readLine = bufferedReader2.readLine();
                        if (readLine == null) {
                            try {
                                bufferedReader2.close();
                                return;
                            } catch (java.lang.Exception e) {
                                com.igexin.c.a.c.a.a(e);
                                return;
                            }
                        }
                        if (!readLine.startsWith("#")) {
                            java.lang.String[] split = readLine.split(com.huawei.hms.framework.common.ContainerUtils.KEY_VALUE_DELIMITER);
                            char c = 2;
                            if (split.length >= 2) {
                                java.lang.String trim = split[0].trim();
                                java.lang.String trim2 = split[1].trim();
                                switch (trim.hashCode()) {
                                    case -1784363506:
                                        if (trim.equals("sdk.readlocalcell.enable")) {
                                            c = 6;
                                            break;
                                        }
                                        c = 65535;
                                        break;
                                    case -1734610495:
                                        if (trim.equals("sdk.enter.backup.detect.failed.cnt")) {
                                            c = '\r';
                                            break;
                                        }
                                        c = 65535;
                                        break;
                                    case -1286040506:
                                        if (trim.equals("sdk.detect.ip.expired.time")) {
                                            c = 15;
                                            break;
                                        }
                                        c = 65535;
                                        break;
                                    case -1050591911:
                                        if (trim.equals("sdk.feature.setsilenttime.enable")) {
                                            c = '\t';
                                            break;
                                        }
                                        c = 65535;
                                        break;
                                    case -1004501973:
                                        if (trim.equals("sdk.config_address")) {
                                            c = 1;
                                            break;
                                        }
                                        c = 65535;
                                        break;
                                    case -416668775:
                                        if (trim.equals("sdk.feature.setsockettimeout.enable")) {
                                            c = 11;
                                            break;
                                        }
                                        c = 65535;
                                        break;
                                    case -367623287:
                                        if (trim.equals("sdk.address.id")) {
                                            c = 18;
                                            break;
                                        }
                                        c = 65535;
                                        break;
                                    case -52474114:
                                        if (trim.equals("sdk.feature.sendmessage.enable")) {
                                            c = 7;
                                            break;
                                        }
                                        c = 65535;
                                        break;
                                    case 85426222:
                                        if (trim.equals("sdk.cm_address_backup")) {
                                            c = 4;
                                            break;
                                        }
                                        c = 65535;
                                        break;
                                    case 178406040:
                                        if (trim.equals("sdk.stay.backup.time")) {
                                            c = '\f';
                                            break;
                                        }
                                        c = 65535;
                                        break;
                                    case 275980049:
                                        if (trim.equals("sdk.login.failed.cnt")) {
                                            c = 14;
                                            break;
                                        }
                                        c = 65535;
                                        break;
                                    case 352273926:
                                        if (trim.equals("sdk.feature.setheartbeatinterval.enable")) {
                                            c = '\n';
                                            break;
                                        }
                                        c = 65535;
                                        break;
                                    case 914256432:
                                        if (trim.equals("sdk.bi_address")) {
                                            break;
                                        }
                                        c = 65535;
                                        break;
                                    case 1188929677:
                                        if (trim.equals("sdk.feature.settag.enable")) {
                                            c = '\b';
                                            break;
                                        }
                                        c = 65535;
                                        break;
                                    case 1457933893:
                                        if (trim.equals("sdk.log_address")) {
                                            c = 3;
                                            break;
                                        }
                                        c = 65535;
                                        break;
                                    case 1488582065:
                                        if (trim.equals("sdk.address.key")) {
                                            c = 17;
                                            break;
                                        }
                                        c = 65535;
                                        break;
                                    case 1603576119:
                                        if (trim.equals("sdk.domainbackup.enable")) {
                                            c = 5;
                                            break;
                                        }
                                        c = 65535;
                                        break;
                                    case 1676315519:
                                        if (trim.equals("sdk.detect.interval.time")) {
                                            c = 16;
                                            break;
                                        }
                                        c = 65535;
                                        break;
                                    case 2077859667:
                                        if (trim.equals("sdk.cm_address")) {
                                            c = 0;
                                            break;
                                        }
                                        c = 65535;
                                        break;
                                    default:
                                        c = 65535;
                                        break;
                                }
                                switch (c) {
                                    case 0:
                                        com.igexin.push.config.SDKUrlConfig.setXfrAddressIps(trim2.split(","));
                                        break;
                                    case 1:
                                        com.igexin.push.config.SDKUrlConfig.CONFIG_ADDRESS_IPS = trim2.split(",");
                                        break;
                                    case 2:
                                        com.igexin.push.config.SDKUrlConfig.BI_ADDRESS_IPS = trim2.split(",");
                                        break;
                                    case 3:
                                        com.igexin.push.config.SDKUrlConfig.LOG_ADDRESS_IPS = trim2.split(",");
                                        break;
                                    case 4:
                                        com.igexin.push.config.SDKUrlConfig.XFR_ADDRESS_BAK = trim2.split(",");
                                        break;
                                    case 5:
                                        com.igexin.push.config.d.g = java.lang.Boolean.parseBoolean(trim2);
                                        break;
                                    case 6:
                                        com.igexin.push.config.d.h = java.lang.Boolean.parseBoolean(trim2);
                                        break;
                                    case 7:
                                        com.igexin.push.config.d.j = java.lang.Boolean.parseBoolean(trim2);
                                        break;
                                    case '\b':
                                        com.igexin.push.config.d.k = java.lang.Boolean.parseBoolean(trim2);
                                        break;
                                    case '\t':
                                        com.igexin.push.config.d.l = java.lang.Boolean.parseBoolean(trim2);
                                        break;
                                    case '\n':
                                        com.igexin.push.config.d.m = java.lang.Boolean.parseBoolean(trim2);
                                        break;
                                    case 11:
                                        com.igexin.push.config.d.n = java.lang.Boolean.parseBoolean(trim2);
                                        break;
                                    case '\f':
                                        com.igexin.push.config.d.r = java.lang.Long.parseLong(trim2) * 1000;
                                        break;
                                    case '\r':
                                        com.igexin.push.config.d.f385s = java.lang.Integer.parseInt(trim2);
                                        break;
                                    case 14:
                                        com.igexin.push.config.d.t = java.lang.Integer.parseInt(trim2);
                                        break;
                                    case 15:
                                        com.igexin.push.config.d.u = java.lang.Long.parseLong(trim2) * 1000;
                                        break;
                                    case 16:
                                        com.igexin.push.config.d.v = java.lang.Long.parseLong(trim2) * 1000;
                                        break;
                                    case 17:
                                        com.igexin.push.h.g.a = trim2;
                                        break;
                                    case 18:
                                        com.igexin.push.h.g.b = trim2;
                                        break;
                                }
                                com.igexin.c.a.c.a.a(a, "loadConfigFromFile, config line:".concat(readLine));
                            }
                        }
                    } catch (java.lang.Exception unused) {
                        bufferedReader = bufferedReader2;
                        com.igexin.c.a.c.a.a(a + "｜no config file found.", new java.lang.Object[0]);
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                                return;
                            } catch (java.lang.Exception e2) {
                                com.igexin.c.a.c.a.a(e2);
                                return;
                            }
                        }
                        return;
                    } catch (java.lang.Throwable th) {
                        th = th;
                        bufferedReader = bufferedReader2;
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (java.lang.Exception e3) {
                                com.igexin.c.a.c.a.a(e3);
                            }
                        }
                        throw th;
                    }
                }
            } catch (java.lang.Exception unused2) {
            }
        } catch (java.lang.Throwable th2) {
            th = th2;
        }
    }

    public static void a(java.lang.Boolean bool) {
        try {
            com.igexin.push.h.j.l();
            if (new java.io.File(com.igexin.push.h.j.e).exists()) {
                b(bool);
                return;
            }
            byte[] bytes = "sdk.debug=".concat(java.lang.String.valueOf(bool)).getBytes();
            if (bytes != null) {
                com.igexin.push.h.j.a(bytes, com.igexin.push.h.j.e);
            }
        } catch (java.lang.Throwable th) {
            com.igexin.c.a.c.a.a(th);
        }
    }

    public static void a(boolean z, boolean z2) {
        try {
            com.igexin.push.h.j.l();
            com.igexin.push.core.d.c.a().a(com.igexin.push.core.d.c.a, java.lang.Boolean.valueOf(z));
            com.igexin.push.core.d.c.a().a(com.igexin.push.core.d.c.b, java.lang.Boolean.valueOf(z2));
        } catch (java.lang.Throwable th) {
            com.igexin.c.a.c.a.a(th);
        }
    }

    public static int b() {
        try {
            com.igexin.push.h.j.l();
            java.lang.Boolean a2 = com.igexin.push.core.d.c.a().a(com.igexin.push.core.d.c.a);
            int i = a2 == null ? -1 : a2.booleanValue() ? 1 : 0;
            com.igexin.c.a.c.a.a(a + "|getGuardMeFromFile gm= " + i, new java.lang.Object[0]);
            return i;
        } catch (java.lang.Throwable th) {
            com.igexin.c.a.c.a.a(th);
            return -1;
        }
    }

    private static void b(java.lang.Boolean bool) {
        java.io.FileInputStream fileInputStream;
        java.io.BufferedReader bufferedReader = null;
        try {
            fileInputStream = new java.io.FileInputStream(com.igexin.push.h.j.e);
            try {
                java.io.BufferedReader bufferedReader2 = new java.io.BufferedReader(new java.io.InputStreamReader(fileInputStream, "UTF-8"));
                try {
                    java.lang.StringBuilder sb = new java.lang.StringBuilder();
                    while (true) {
                        java.lang.String readLine = bufferedReader2.readLine();
                        if (readLine == null) {
                            break;
                        }
                        if (readLine.startsWith("#")) {
                            sb.append(readLine);
                        } else {
                            java.lang.String[] split = readLine.split(com.huawei.hms.framework.common.ContainerUtils.KEY_VALUE_DELIMITER);
                            if (split.length < 2) {
                                sb.append(readLine);
                            } else {
                                java.lang.String trim = split[0].trim();
                                split[1].trim();
                                if (!trim.equals("sdk.debug")) {
                                    sb.append(readLine);
                                }
                            }
                        }
                        sb.append("\n");
                    }
                    sb.append("sdk.debug=".concat(java.lang.String.valueOf(bool)));
                    byte[] bytes = sb.toString().getBytes();
                    if (bytes != null) {
                        com.igexin.push.h.j.a(bytes, com.igexin.push.h.j.e);
                    }
                    try {
                        bufferedReader2.close();
                    } catch (java.io.IOException e) {
                        com.igexin.c.a.c.a.a(e);
                    }
                    try {
                        fileInputStream.close();
                    } catch (java.lang.Exception e2) {
                        com.igexin.c.a.c.a.a(e2);
                    }
                } catch (java.lang.Exception unused) {
                    bufferedReader = bufferedReader2;
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (java.io.IOException e3) {
                            com.igexin.c.a.c.a.a(e3);
                        }
                    }
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (java.lang.Exception e4) {
                            com.igexin.c.a.c.a.a(e4);
                        }
                    }
                } catch (java.lang.Throwable th) {
                    th = th;
                    bufferedReader = bufferedReader2;
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (java.io.IOException e5) {
                            com.igexin.c.a.c.a.a(e5);
                        }
                    }
                    if (fileInputStream == null) {
                        throw th;
                    }
                    try {
                        fileInputStream.close();
                        throw th;
                    } catch (java.lang.Exception e6) {
                        com.igexin.c.a.c.a.a(e6);
                        throw th;
                    }
                }
            } catch (java.lang.Exception unused2) {
            } catch (java.lang.Throwable th2) {
                th = th2;
            }
        } catch (java.lang.Exception unused3) {
            fileInputStream = null;
        } catch (java.lang.Throwable th3) {
            th = th3;
            fileInputStream = null;
        }
    }

    public static int c() {
        try {
            java.lang.Boolean a2 = com.igexin.push.core.d.c.a().a(com.igexin.push.core.d.c.b);
            int i = a2 == null ? -1 : a2.booleanValue() ? 1 : 0;
            com.igexin.c.a.c.a.a(a + "|getGuardOthersFromFile gm= " + i, new java.lang.Object[0]);
            return i;
        } catch (java.lang.Throwable th) {
            com.igexin.c.a.c.a.a(th);
            return -1;
        }
    }
}
