package com.jd.ad.sdk.jad_il;

/* loaded from: classes23.dex */
public class jad_an {
    public static android.content.Context jad_an;
    public static boolean jad_bo;

    public static java.lang.String jad_an() {
        boolean z;
        int myPid = android.os.Process.myPid();
        java.util.HashSet hashSet = new java.util.HashSet();
        java.io.BufferedReader bufferedReader = null;
        try {
            java.io.BufferedReader bufferedReader2 = new java.io.BufferedReader(new java.io.FileReader(java.lang.String.format(java.util.Locale.ENGLISH, "/proc/%d/maps", java.lang.Integer.valueOf(myPid))));
            while (true) {
                try {
                    java.lang.String readLine = bufferedReader2.readLine();
                    if (readLine == null) {
                        break;
                    }
                    java.lang.String[] split = readLine.split(" ");
                    if (split.length > 0) {
                        java.lang.String str = split[split.length - 1];
                        if (str.endsWith(".so") && str.startsWith("/data") && !str.contains("com.jingdong.app.mall")) {
                            java.lang.String[] strArr = com.jd.ad.sdk.jad_jm.jad_bo.jad_an;
                            int length = strArr.length;
                            int i = 0;
                            while (true) {
                                if (i >= length) {
                                    z = false;
                                    break;
                                }
                                if (java.util.regex.Pattern.matches(strArr[i], str)) {
                                    z = true;
                                    break;
                                }
                                i++;
                            }
                            if (!z) {
                                hashSet.add(str);
                            }
                        }
                    }
                } catch (java.lang.Exception unused) {
                    bufferedReader = bufferedReader2;
                    com.jd.ad.sdk.jad_jm.jad_cp.jad_an(bufferedReader);
                    return hashSet.toString();
                } catch (java.lang.Throwable th) {
                    th = th;
                    bufferedReader = bufferedReader2;
                    com.jd.ad.sdk.jad_jm.jad_cp.jad_an(bufferedReader);
                    throw th;
                }
            }
            com.jd.ad.sdk.jad_jm.jad_cp.jad_an(bufferedReader2);
        } catch (java.lang.Exception unused2) {
        } catch (java.lang.Throwable th2) {
            th = th2;
        }
        return hashSet.toString();
    }

    /* JADX WARN: Can't wrap try/catch for region: R(17:0|1|(2:2|3)|(2:29|30)|5|6|7|8|(8:10|(1:12)|13|14|(1:16)|(1:18)|21|22)|26|(0)|13|14|(0)|(0)|21|22) */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0024 A[Catch: Exception -> 0x0043, TRY_ENTER, TRY_LEAVE, TryCatch #3 {Exception -> 0x0043, blocks: (B:30:0x000c, B:12:0x0024, B:18:0x003c), top: B:29:0x000c }] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x003c A[Catch: Exception -> 0x0043, TRY_ENTER, TRY_LEAVE, TryCatch #3 {Exception -> 0x0043, blocks: (B:30:0x000c, B:12:0x0024, B:18:0x003c), top: B:29:0x000c }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static java.lang.String jad_bo() {
        boolean z;
        boolean z2;
        android.content.Context context = jad_an;
        boolean z3 = false;
        try {
            z = android.os.Debug.isDebuggerConnected();
        } catch (java.lang.Exception unused) {
            z = false;
        }
        if (z) {
            try {
                com.jd.ad.sdk.jad_kn.jad_an.jad_an |= 1;
            } catch (java.lang.Exception unused2) {
            }
        }
        if ((context.getApplicationInfo().flags & 2) != 0) {
            z2 = true;
            if (z2) {
                com.jd.ad.sdk.jad_kn.jad_an.jad_an |= 2;
            }
            if (android.provider.Settings.Secure.getInt(context.getContentResolver(), "adb_enabled", 0) > 0) {
                z3 = true;
            }
            if (z3) {
                com.jd.ad.sdk.jad_kn.jad_an.jad_an |= 4;
            }
            return java.lang.String.valueOf(com.jd.ad.sdk.jad_kn.jad_an.jad_an);
        }
        z2 = false;
        if (z2) {
        }
        if (android.provider.Settings.Secure.getInt(context.getContentResolver(), "adb_enabled", 0) > 0) {
        }
        if (z3) {
        }
        return java.lang.String.valueOf(com.jd.ad.sdk.jad_kn.jad_an.jad_an);
    }

    public static int jad_cp() {
        android.content.Context context = jad_an;
        try {
            boolean z = true;
            boolean z2 = !new com.jd.ad.sdk.jad_kn.jad_dq(context).jad_cp();
            if (com.jd.ad.sdk.jad_kn.jad_bo.jad_an("ro.product.cpu.abi").contains("x86")) {
                com.jd.ad.sdk.jad_kn.jad_bo.jad_an |= 1;
            }
            if (com.jd.ad.sdk.jad_kn.jad_bo.jad_an("ro.product.cpu.abilist").contains("x86")) {
                com.jd.ad.sdk.jad_kn.jad_bo.jad_an |= 2;
            }
            if (!context.getPackageManager().hasSystemFeature("android.hardware.camera")) {
                com.jd.ad.sdk.jad_kn.jad_bo.jad_an |= 8;
            }
            if (!context.getPackageManager().hasSystemFeature("android.hardware.camera.flash") && z2) {
                com.jd.ad.sdk.jad_kn.jad_bo.jad_an |= 16;
            }
            int i = 0;
            while (true) {
                java.lang.String[] strArr = com.jd.ad.sdk.jad_kn.jad_bo.jad_bo;
                if (i >= strArr.length) {
                    z = false;
                    break;
                }
                if (new java.io.File(strArr[i]).exists()) {
                    break;
                }
                i++;
            }
            if (z) {
                com.jd.ad.sdk.jad_kn.jad_bo.jad_an |= 64;
            }
            if (com.jd.ad.sdk.jad_kn.jad_bo.jad_an()) {
                com.jd.ad.sdk.jad_kn.jad_bo.jad_an |= 128;
            }
            if (android.text.TextUtils.isEmpty(com.jd.ad.sdk.jad_kn.jad_bo.jad_an("gsm.version.baseband")) && z2) {
                com.jd.ad.sdk.jad_kn.jad_bo.jad_an |= 256;
            }
            java.lang.String jad_bo2 = com.jd.ad.sdk.jad_kn.jad_bo.jad_bo();
            if (jad_bo2.contains("intel") || jad_bo2.contains("amd")) {
                com.jd.ad.sdk.jad_kn.jad_bo.jad_an |= 512;
            }
        } catch (java.lang.Exception unused) {
        }
        return (int) java.lang.Long.valueOf(com.jd.ad.sdk.jad_kn.jad_bo.jad_an).longValue();
    }

    public static java.lang.String jad_dq() {
        java.lang.Boolean bool;
        try {
            if (com.jd.ad.sdk.jad_kn.jad_cp.jad_an(jad_an).booleanValue()) {
                com.jd.ad.sdk.jad_kn.jad_cp.jad_an |= 2;
            }
            if (com.jd.ad.sdk.jad_kn.jad_cp.jad_an().booleanValue()) {
                com.jd.ad.sdk.jad_kn.jad_cp.jad_an |= 4;
            }
            try {
                try {
                    java.lang.Class.forName("de.robv.android.xposed.XC_MethodHook");
                    bool = java.lang.Boolean.TRUE;
                } catch (java.lang.Exception unused) {
                    java.lang.Class.forName("de.robv.android.xposed.XposedHelpers");
                    bool = java.lang.Boolean.FALSE;
                }
            } catch (java.lang.Exception unused2) {
                bool = java.lang.Boolean.FALSE;
            }
            if (bool.booleanValue()) {
                com.jd.ad.sdk.jad_kn.jad_cp.jad_an |= 8;
            }
            java.lang.Boolean bool2 = java.lang.Boolean.FALSE;
            try {
                if (java.lang.System.getProperty("vxp") != null) {
                    bool2 = java.lang.Boolean.TRUE;
                }
            } catch (java.lang.Exception unused3) {
            }
            if (bool2.booleanValue()) {
                com.jd.ad.sdk.jad_kn.jad_cp.jad_an |= 16;
            }
        } catch (java.lang.Exception unused4) {
        }
        return java.lang.String.valueOf(com.jd.ad.sdk.jad_kn.jad_cp.jad_an);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(12:0|1|(13:2|3|(1:5)|6|(2:7|(2:9|(2:12|13)(1:11))(2:65|66))|(1:15)|16|(1:18)|19|(2:61|62)|21|(1:23)|24)|(10:53|(2:55|(2:57|(1:59)))|60|(1:29)|30|31|(2:32|(4:34|35|(2:37|(2:41|42)(2:39|40))|49)(1:50))|(1:44)|46|47)(1:26)|27|(0)|30|31|(3:32|(0)(0)|49)|(0)|46|47) */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0089 A[Catch: Exception -> 0x00c1, TRY_LEAVE, TryCatch #2 {Exception -> 0x00c1, blocks: (B:3:0x0002, B:5:0x0008, B:6:0x000f, B:9:0x001f, B:15:0x002f, B:16:0x0036, B:18:0x003c, B:19:0x0043, B:62:0x0048, B:23:0x0059, B:24:0x0060, B:29:0x0089, B:44:0x00ba, B:53:0x006b, B:55:0x0073, B:57:0x007b, B:11:0x0029), top: B:2:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x009e A[Catch: Exception -> 0x00b7, TryCatch #1 {Exception -> 0x00b7, blocks: (B:31:0x0090, B:32:0x0098, B:34:0x009e, B:37:0x00aa), top: B:30:0x0090 }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00ba A[Catch: Exception -> 0x00c1, TRY_ENTER, TRY_LEAVE, TryCatch #2 {Exception -> 0x00c1, blocks: (B:3:0x0002, B:5:0x0008, B:6:0x000f, B:9:0x001f, B:15:0x002f, B:16:0x0036, B:18:0x003c, B:19:0x0043, B:62:0x0048, B:23:0x0059, B:24:0x0060, B:29:0x0089, B:44:0x00ba, B:53:0x006b, B:55:0x0073, B:57:0x007b, B:11:0x0029), top: B:2:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00b8 A[EDGE_INSN: B:50:0x00b8->B:43:0x00b8 BREAK  A[LOOP:1: B:32:0x0098->B:49:?], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static java.lang.String jad_er() {
        boolean z;
        boolean z2;
        boolean z3;
        java.lang.String packageName;
        boolean z4;
        java.util.Iterator<java.lang.String> it;
        android.content.Context context = jad_an;
        try {
            if (com.jd.ad.sdk.jad_kn.jad_er.jad_an(context)) {
                com.jd.ad.sdk.jad_kn.jad_er.jad_an |= 1;
            }
            java.lang.String path = context.getFilesDir().getPath();
            java.lang.String[] strArr = com.jd.ad.sdk.jad_kn.jad_er.jad_cp;
            int length = strArr.length;
            z = false;
            int i = 0;
            while (true) {
                if (i >= length) {
                    z2 = false;
                    break;
                }
                if (path.contains(strArr[i])) {
                    z2 = true;
                    break;
                }
                i++;
            }
            if (z2) {
                com.jd.ad.sdk.jad_kn.jad_er.jad_an |= 2;
            }
            if (com.jd.ad.sdk.jad_kn.jad_er.jad_an()) {
                com.jd.ad.sdk.jad_kn.jad_er.jad_an |= 4;
            }
            if (com.jd.ad.sdk.jad_kn.jad_er.jad_bo == null) {
                try {
                    com.jd.ad.sdk.jad_kn.jad_er.jad_bo = new android.net.LocalServerSocket(context.getPackageName());
                } catch (java.io.IOException unused) {
                    z3 = true;
                }
            }
            z3 = false;
            if (z3) {
                com.jd.ad.sdk.jad_kn.jad_er.jad_an |= 16;
            }
            packageName = context.getPackageName();
        } catch (java.lang.Exception unused2) {
        }
        if (!android.text.TextUtils.isEmpty(packageName)) {
            if (!packageName.equals("com.jingdong.app.mall")) {
                if (!packageName.equals("com.jd.pingou")) {
                    if (packageName.equals("com.jd.jdlite")) {
                    }
                }
            }
            z4 = true;
            if (z4) {
                com.jd.ad.sdk.jad_kn.jad_er.jad_an |= 32;
            }
            it = com.jd.ad.sdk.jad_jm.jad_an.jad_an(context).iterator();
            loop1: while (true) {
                if (it.hasNext()) {
                    break;
                }
                java.lang.String next = it.next();
                for (java.lang.String str : com.jd.ad.sdk.jad_kn.jad_er.jad_cp) {
                    if (next.contains(str)) {
                        z = true;
                        break loop1;
                    }
                }
            }
            if (z) {
                com.jd.ad.sdk.jad_kn.jad_er.jad_an |= 64;
            }
            return java.lang.String.valueOf(com.jd.ad.sdk.jad_kn.jad_er.jad_an);
        }
        z4 = false;
        if (z4) {
        }
        it = com.jd.ad.sdk.jad_jm.jad_an.jad_an(context).iterator();
        loop1: while (true) {
            if (it.hasNext()) {
            }
        }
        if (z) {
        }
        return java.lang.String.valueOf(com.jd.ad.sdk.jad_kn.jad_er.jad_an);
    }

    public static boolean jad_fs() {
        try {
            return ((android.app.KeyguardManager) jad_an.getSystemService("keyguard")).inKeyguardRestrictedInputMode();
        } catch (java.lang.Exception e) {
            com.jd.android.sdk.coreinfo.util.Logger.e("AntiSDK", e.getMessage());
            return false;
        }
    }

    public static boolean jad_jt() {
        try {
            return !((android.os.PowerManager) jad_an.getSystemService("power")).isScreenOn();
        } catch (java.lang.Exception e) {
            com.jd.android.sdk.coreinfo.util.Logger.e("AntiSDK", e.getMessage());
            return false;
        }
    }
}
