package com.jd.ad.sdk.jad_qd;

/* loaded from: classes23.dex */
public class jad_cp {
    public static final java.util.List<java.lang.String> jad_an = java.util.Arrays.asList("com.kingroot.kinguser", "MobileSubstrate", "libhooker", "Cephei.framework", "frida-agent-32.so", "liblhooker64.so", "libnathook.so", "io.virtualapp.sandvxposed64", "me.weishu.exp", "zygisk", "libsandhook", "frida", "zorro.dylib", "AXJ.dylib", "com.yztc.studio");
    public static final java.util.List<java.lang.String> jad_bo = java.util.Arrays.asList("com_yztc_studio_plugin", "com.miui.miuibbs", "com_wtkj_app_clicker", "com_github_uiautomator", "com_uwish_app");

    public static java.lang.Boolean jad_an() {
        try {
            java.lang.String[] strArr = {"/system/xbin/su", "/system/bin/su", "/sbin/su", "/su/bin/su"};
            for (int i = 0; i < 4; i++) {
                if (new java.io.File(strArr[i]).exists()) {
                    return java.lang.Boolean.TRUE;
                }
            }
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
        return java.lang.Boolean.FALSE;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(48:1|2|(1:4)(1:139)|5|(1:7)(1:138)|8|(1:10)(1:137)|(1:12)(1:136)|13|(1:135)(1:17)|(1:19)(1:134)|20|(1:133)(1:24)|25|26|(1:131)(1:30)|(2:32|(31:34|(29:37|(1:39)(1:127)|40|(1:42)(1:126)|43|(1:45)(1:125)|46|(3:103|104|(3:108|(2:110|(1:119)(1:117))|123))|48|(1:50)(1:102)|51|52|53|(3:56|(1:58)(1:97)|54)|98|99|(1:60)(1:96)|61|(5:64|65|(1:69)(0)|72|62)|95|94|73|(1:75)(1:89)|76|(1:78)(1:88)|79|(1:83)|84|85)|128|(0)(0)|40|(0)(0)|43|(0)(0)|46|(0)|48|(0)(0)|51|52|53|(1:54)|98|99|(0)(0)|61|(1:62)|95|94|73|(0)(0)|76|(0)(0)|79|(2:81|83)|84|85))|130|(29:37|(0)(0)|40|(0)(0)|43|(0)(0)|46|(0)|48|(0)(0)|51|52|53|(1:54)|98|99|(0)(0)|61|(1:62)|95|94|73|(0)(0)|76|(0)(0)|79|(0)|84|85)|128|(0)(0)|40|(0)(0)|43|(0)(0)|46|(0)|48|(0)(0)|51|52|53|(1:54)|98|99|(0)(0)|61|(1:62)|95|94|73|(0)(0)|76|(0)(0)|79|(0)|84|85) */
    /* JADX WARN: Removed duplicated region for block: B:102:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x00c6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:125:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x00ae A[Catch: Exception -> 0x019a, TryCatch #3 {Exception -> 0x019a, blocks: (B:2:0x0000, B:8:0x001d, B:13:0x002f, B:15:0x003d, B:20:0x004b, B:22:0x0058, B:24:0x005e, B:40:0x0096, B:42:0x00a7, B:43:0x00b6, B:46:0x00bd, B:51:0x00fe, B:61:0x0131, B:73:0x0162, B:76:0x016b, B:79:0x017b, B:81:0x0184, B:84:0x018f, B:94:0x0160, B:93:0x015d, B:126:0x00ae, B:133:0x0062, B:137:0x0024, B:139:0x000e, B:65:0x013f, B:67:0x014d, B:69:0x0156, B:72:0x0159), top: B:1:0x0000, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00a7 A[Catch: Exception -> 0x019a, TryCatch #3 {Exception -> 0x019a, blocks: (B:2:0x0000, B:8:0x001d, B:13:0x002f, B:15:0x003d, B:20:0x004b, B:22:0x0058, B:24:0x005e, B:40:0x0096, B:42:0x00a7, B:43:0x00b6, B:46:0x00bd, B:51:0x00fe, B:61:0x0131, B:73:0x0162, B:76:0x016b, B:79:0x017b, B:81:0x0184, B:84:0x018f, B:94:0x0160, B:93:0x015d, B:126:0x00ae, B:133:0x0062, B:137:0x0024, B:139:0x000e, B:65:0x013f, B:67:0x014d, B:69:0x0156, B:72:0x0159), top: B:1:0x0000, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0117 A[Catch: Exception -> 0x012a, TRY_LEAVE, TryCatch #2 {Exception -> 0x012a, blocks: (B:53:0x0101, B:54:0x0111, B:56:0x0117), top: B:52:0x0101 }] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x013f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0168  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0178  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0184 A[Catch: Exception -> 0x019a, TryCatch #3 {Exception -> 0x019a, blocks: (B:2:0x0000, B:8:0x001d, B:13:0x002f, B:15:0x003d, B:20:0x004b, B:22:0x0058, B:24:0x005e, B:40:0x0096, B:42:0x00a7, B:43:0x00b6, B:46:0x00bd, B:51:0x00fe, B:61:0x0131, B:73:0x0162, B:76:0x016b, B:79:0x017b, B:81:0x0184, B:84:0x018f, B:94:0x0160, B:93:0x015d, B:126:0x00ae, B:133:0x0062, B:137:0x0024, B:139:0x000e, B:65:0x013f, B:67:0x014d, B:69:0x0156, B:72:0x0159), top: B:1:0x0000, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:88:0x017a  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x016a  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0130  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static java.lang.String jad_an(android.content.Context context, java.lang.String str) {
        boolean z;
        android.content.pm.PackageManager packageManager;
        java.lang.String[] strArr;
        boolean z2;
        java.lang.Boolean bool;
        java.util.Iterator<android.view.inputmethod.InputMethodInfo> it;
        java.lang.String jad_bo2;
        boolean z3;
        boolean z4;
        try {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            android.content.pm.PackageManager packageManager2 = context.getPackageManager();
            java.lang.String str2 = "0";
            sb.append(packageManager2 == null ? false : packageManager2.hasSystemFeature("android.hardware.sensor.compass") ? "0" : "1");
            sb.append(packageManager2 == null ? false : packageManager2.hasSystemFeature("android.hardware.usb.host") ? "0" : "1");
            android.os.Vibrator vibrator = (android.os.Vibrator) context.getSystemService("vibrator");
            boolean z5 = true;
            sb.append(vibrator != null && vibrator.hasVibrator() ? "0" : "1");
            java.lang.String jad_cn = com.jd.ad.sdk.jad_qd.jad_an.jad_cn();
            if (jad_bo(context) && "0".equals(jad_cn)) {
                sb.append("1");
            } else {
                sb.append("0");
            }
            try {
                java.lang.String jad_bo3 = jad_bo("sys.usb.state");
                jad_bo2 = jad_bo("ro.debuggable");
                z3 = jad_bo3 != null && jad_bo3.contains("adb");
            } catch (java.lang.Exception unused) {
            }
            if (jad_bo2 != null) {
                if ("1".equals(jad_bo2)) {
                    z4 = true;
                    if (z3 && z4) {
                        z = true;
                        sb.append(!z ? "1" : "0");
                        boolean[] zArr = {false};
                        if (android.os.Looper.getMainLooper() == android.os.Looper.myLooper()) {
                            zArr[0] = jad_er();
                        } else {
                            com.jd.ad.sdk.fdt.thread.WorkExecutor.execute(new com.jd.ad.sdk.jad_qd.jad_bo(zArr));
                        }
                        sb.append(!zArr[0] ? "1" : "0");
                        packageManager = context.getPackageManager();
                        if (packageManager != null) {
                            try {
                                android.content.pm.PackageInfo packageInfo = packageManager.getPackageInfo(context.getPackageName(), 4096);
                                if (packageInfo != null && (strArr = packageInfo.requestedPermissions) != null) {
                                    for (java.lang.String str3 : strArr) {
                                        if (!android.text.TextUtils.isEmpty(str3) && (str3.equals("android.permission.READ_LOGS") || str3.equals("android.permission.READ_CALL_LOG"))) {
                                            z2 = true;
                                            break;
                                        }
                                    }
                                }
                            } catch (java.lang.Exception unused2) {
                            }
                        }
                        z2 = false;
                        sb.append(!z2 ? "1" : "0");
                        it = ((android.view.inputmethod.InputMethodManager) context.getSystemService("input_method")).getInputMethodList().iterator();
                        while (it.hasNext()) {
                            if ("com.android.adbkeyboard".equals(it.next().getPackageName())) {
                                break;
                            }
                        }
                        z5 = false;
                        sb.append(!z5 ? "1" : "0");
                        java.lang.String[] strArr2 = {"ro.boot.veritymode", "persist.sys.root_access"};
                        for (int i = 0; i < 2; i++) {
                            try {
                                java.lang.String property = java.lang.System.getProperty(strArr2[i]);
                                if (!"disabled".equals(property) && !"3".equals(property)) {
                                }
                                bool = java.lang.Boolean.TRUE;
                                break;
                            } catch (java.lang.Exception e) {
                                e.printStackTrace();
                            }
                        }
                        bool = java.lang.Boolean.FALSE;
                        sb.append(!bool.booleanValue() ? "1" : "0");
                        sb.append(!jad_an().booleanValue() ? "1" : "0");
                        if (jad_an(context) && jad_bo().booleanValue()) {
                            str2 = "1";
                        }
                        sb.append(str2);
                        return jad_an(sb.toString());
                    }
                    z = false;
                    sb.append(!z ? "1" : "0");
                    boolean[] zArr2 = {false};
                    if (android.os.Looper.getMainLooper() == android.os.Looper.myLooper()) {
                    }
                    sb.append(!zArr2[0] ? "1" : "0");
                    packageManager = context.getPackageManager();
                    if (packageManager != null) {
                    }
                    z2 = false;
                    sb.append(!z2 ? "1" : "0");
                    it = ((android.view.inputmethod.InputMethodManager) context.getSystemService("input_method")).getInputMethodList().iterator();
                    while (it.hasNext()) {
                    }
                    z5 = false;
                    sb.append(!z5 ? "1" : "0");
                    java.lang.String[] strArr22 = {"ro.boot.veritymode", "persist.sys.root_access"};
                    while (i < 2) {
                    }
                    bool = java.lang.Boolean.FALSE;
                    sb.append(!bool.booleanValue() ? "1" : "0");
                    sb.append(!jad_an().booleanValue() ? "1" : "0");
                    if (jad_an(context)) {
                        str2 = "1";
                    }
                    sb.append(str2);
                    return jad_an(sb.toString());
                }
            }
            z4 = false;
            if (z3) {
                z = true;
                sb.append(!z ? "1" : "0");
                boolean[] zArr22 = {false};
                if (android.os.Looper.getMainLooper() == android.os.Looper.myLooper()) {
                }
                sb.append(!zArr22[0] ? "1" : "0");
                packageManager = context.getPackageManager();
                if (packageManager != null) {
                }
                z2 = false;
                sb.append(!z2 ? "1" : "0");
                it = ((android.view.inputmethod.InputMethodManager) context.getSystemService("input_method")).getInputMethodList().iterator();
                while (it.hasNext()) {
                }
                z5 = false;
                sb.append(!z5 ? "1" : "0");
                java.lang.String[] strArr222 = {"ro.boot.veritymode", "persist.sys.root_access"};
                while (i < 2) {
                }
                bool = java.lang.Boolean.FALSE;
                sb.append(!bool.booleanValue() ? "1" : "0");
                sb.append(!jad_an().booleanValue() ? "1" : "0");
                if (jad_an(context)) {
                }
                sb.append(str2);
                return jad_an(sb.toString());
            }
            z = false;
            sb.append(!z ? "1" : "0");
            boolean[] zArr222 = {false};
            if (android.os.Looper.getMainLooper() == android.os.Looper.myLooper()) {
            }
            sb.append(!zArr222[0] ? "1" : "0");
            packageManager = context.getPackageManager();
            if (packageManager != null) {
            }
            z2 = false;
            sb.append(!z2 ? "1" : "0");
            it = ((android.view.inputmethod.InputMethodManager) context.getSystemService("input_method")).getInputMethodList().iterator();
            while (it.hasNext()) {
            }
            z5 = false;
            sb.append(!z5 ? "1" : "0");
            java.lang.String[] strArr2222 = {"ro.boot.veritymode", "persist.sys.root_access"};
            while (i < 2) {
            }
            bool = java.lang.Boolean.FALSE;
            sb.append(!bool.booleanValue() ? "1" : "0");
            sb.append(!jad_an().booleanValue() ? "1" : "0");
            if (jad_an(context)) {
            }
            sb.append(str2);
            return jad_an(sb.toString());
        } catch (java.lang.Exception unused3) {
            return str;
        }
    }

    public static java.lang.String jad_an(java.lang.String str) {
        try {
            return android.text.TextUtils.isEmpty(str) ? "NA" : new java.math.BigInteger(str, 2).toString(16);
        } catch (java.lang.Exception unused) {
            return "NA";
        }
    }

    public static boolean jad_an(android.content.Context context) {
        try {
            if (!context.getPackageManager().hasSystemFeature("android.hardware.usb.host")) {
                return false;
            }
            android.hardware.usb.UsbManager usbManager = (android.hardware.usb.UsbManager) context.getSystemService("usb");
            java.util.Iterator<java.util.Map.Entry<java.lang.String, android.hardware.usb.UsbDevice>> it = usbManager.getDeviceList().entrySet().iterator();
            while (it.hasNext()) {
                android.hardware.usb.UsbDevice value = it.next().getValue();
                if (usbManager.hasPermission(value) && value.getDeviceClass() == 8) {
                    return true;
                }
            }
            return false;
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static java.lang.Boolean jad_bo() {
        java.lang.String str;
        try {
            java.lang.Class<?> cls = java.lang.Class.forName("android.os.SystemProperties");
            str = (java.lang.String) cls.getDeclaredMethod(com.ss.android.socialbase.downloader.constants.MonitorConstants.CONNECT_TYPE_GET, java.lang.String.class).invoke(cls, "sys.usb.config");
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            str = null;
        }
        return (str == null || !str.contains("adb")) ? java.lang.Boolean.FALSE : java.lang.Boolean.TRUE;
    }

    public static java.lang.String jad_bo(java.lang.String str) {
        java.lang.String str2;
        try {
            java.lang.Class<?> loadClass = java.lang.ClassLoader.getSystemClassLoader().loadClass("android.os.SystemProperties");
            java.lang.reflect.Method method = loadClass.getMethod(com.ss.android.socialbase.downloader.constants.MonitorConstants.CONNECT_TYPE_GET, java.lang.String.class);
            method.setAccessible(true);
            str2 = (java.lang.String) method.invoke(loadClass, str);
        } catch (java.lang.Exception unused) {
            str2 = "";
        }
        if (android.text.TextUtils.isEmpty(str2)) {
            return null;
        }
        return str2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0015, code lost:
    
        r0 = r3.getActiveNetwork();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean jad_bo(android.content.Context context) {
        android.net.Network activeNetwork;
        if (androidx.core.content.ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_NETWORK_STATE") == -1) {
            return false;
        }
        try {
            android.net.ConnectivityManager connectivityManager = (android.net.ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager != null && activeNetwork != null && connectivityManager.getNetworkInfo(activeNetwork) != null) {
                return (java.lang.System.getProperty(org.apache.tools.ant.util.ProxySetup.HTTP_PROXY_HOST) == null || java.lang.System.getProperty(org.apache.tools.ant.util.ProxySetup.HTTP_PROXY_PORT) == null) ? false : true;
            }
            return false;
        } catch (java.lang.SecurityException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static java.lang.String jad_cp() {
        int i;
        try {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            java.lang.String str = "1";
            sb.append(com.jd.ad.sdk.jad_qd.jad_hu.jad_jt() == 1 ? "1" : "0");
            if (com.jd.ad.sdk.jad_qd.jad_fs.jad_an.jad_an.jad_an("zfbAppInstalled")) {
                com.jd.ad.sdk.jad_uh.jad_an jad_anVar = com.jd.ad.sdk.jad_uh.jad_an.jad_bo.jad_an;
                if (jad_anVar.jad_an("zfbAppInstalled", true)) {
                    i = jad_anVar.jad_cp("zfbAppInstalled");
                } else {
                    boolean jad_an2 = com.jd.ad.sdk.jad_fq.jad_bo.jad_an(com.alipay.sdk.m.u.n.b);
                    jad_anVar.jad_bo("zfbAppInstalled", java.lang.Integer.valueOf(jad_an2 ? 1 : 0));
                    i = jad_an2 ? 1 : 0;
                }
            } else {
                i = -1;
            }
            sb.append(i == 1 ? "1" : "0");
            if (com.jd.ad.sdk.jad_qd.jad_hu.jad_fs() != 1) {
                str = "0";
            }
            sb.append(str);
            return jad_an(sb.toString());
        } catch (java.lang.Exception unused) {
            return "NA";
        }
    }

    public static java.lang.String jad_cp(android.content.Context context) {
        java.lang.String str;
        android.content.pm.ApplicationInfo applicationInfo;
        try {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            android.content.pm.PackageManager packageManager = context.getPackageManager();
            if (packageManager != null) {
                int i = 0;
                while (true) {
                    java.util.List<java.lang.String> list = jad_bo;
                    if (i >= list.size()) {
                        break;
                    }
                    java.lang.String str2 = list.get(i);
                    if (!android.text.TextUtils.isEmpty(str2) && (applicationInfo = packageManager.getApplicationInfo(str2, 0)) != null && (applicationInfo.flags & 2097152) == 0) {
                        str = "1";
                        sb.append(str);
                        i++;
                    }
                    str = "0";
                    sb.append(str);
                    i++;
                }
            }
            if (!android.text.TextUtils.isEmpty(sb)) {
                return jad_an(sb.toString());
            }
        } catch (java.lang.Exception unused) {
        }
        return "NA";
    }

    public static java.lang.String jad_dq() {
        try {
            java.lang.String jad_an2 = com.jd.ad.sdk.jad_il.jad_an.jad_an();
            if (android.text.TextUtils.isEmpty(jad_an2)) {
                return "NA";
            }
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            int i = 0;
            while (true) {
                java.util.List<java.lang.String> list = jad_an;
                if (i >= list.size()) {
                    return jad_an(sb.toString());
                }
                java.lang.String str = list.get(i);
                sb.append((android.text.TextUtils.isEmpty(str) || !jad_an2.contains(str)) ? "0" : "1");
                i++;
            }
        } catch (java.lang.Exception unused) {
            return "NA";
        }
    }

    public static boolean jad_er() {
        try {
            java.net.Socket socket = new java.net.Socket();
            socket.connect(new java.net.InetSocketAddress(org.apache.tools.mail.MailMessage.DEFAULT_HOST, 5073), 500);
            socket.close();
            return true;
        } catch (java.lang.Exception unused) {
            return false;
        }
    }
}
