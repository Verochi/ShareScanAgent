package com.ss.android.socialbase.appdownloader.kz;

/* loaded from: classes19.dex */
public class kz {
    private static java.lang.Boolean vw;

    private static boolean kz() {
        try {
            java.util.HashSet<java.lang.String> hashSet = new java.util.HashSet();
            java.io.BufferedReader bufferedReader = new java.io.BufferedReader(new java.io.FileReader("/proc/" + android.os.Process.myPid() + "/maps"));
            while (true) {
                java.lang.String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                if (readLine.endsWith(".so") || readLine.endsWith(".jar")) {
                    hashSet.add(readLine.substring(readLine.lastIndexOf(" ") + 1));
                }
            }
            bufferedReader.close();
            for (java.lang.String str : hashSet) {
                if (str.contains(vw("636f6d2e73617572696b2e737562737472617465")) || str.contains(vw("58706f7365644272696467652e6a6172")) || str.contains(vw("6c696273616e64686f6f6b2e656478702e736f"))) {
                    return true;
                }
            }
            return false;
        } catch (java.lang.Exception unused) {
            return false;
        }
    }

    private static boolean kz(android.content.Context context) {
        java.util.List asList = java.util.Arrays.asList(vw("64652e726f62762e616e64726f69642e78706f736564"), vw("636f6d2e746f706a6f686e77752e6d616769736b"), vw("696f2e76612e6578706f736564"), vw("636f6d2e77696e642e636f74746572"), vw("6f72672e6d656f776361742e656478706f7365642e6d616e61676572"), vw("6d652e7765697368752e657870"), vw("636f6d2e73617572696b2e737562737472617465"));
        android.content.pm.PackageManager packageManager = context.getPackageManager();
        java.util.Iterator it = asList.iterator();
        while (it.hasNext()) {
            try {
            } catch (android.content.pm.PackageManager.NameNotFoundException e) {
                e.printStackTrace();
            }
            if (packageManager.getPackageInfo((java.lang.String) it.next(), 0) != null) {
                return true;
            }
        }
        return false;
    }

    @androidx.annotation.WorkerThread
    public static boolean t() {
        try {
            java.net.InetAddress.getByName(vw("3132372e302e302e31"));
            new java.net.Socket(vw("3132372e302e302e31"), java.lang.Integer.parseInt(vw("3237303432")));
            return true;
        } catch (java.io.IOException unused) {
            return false;
        }
    }

    public static boolean t(android.content.Context context) {
        android.content.Intent registerReceiver = context.registerReceiver(null, new android.content.IntentFilter("android.intent.action.BATTERY_CHANGED"));
        return registerReceiver != null && registerReceiver.getIntExtra("plugged", -1) == 2;
    }

    private static int v() {
        java.lang.String str = null;
        try {
            java.lang.Object invoke = java.lang.Class.forName("android.os.SystemProperties").getMethod(com.ss.android.socialbase.downloader.constants.MonitorConstants.CONNECT_TYPE_GET, java.lang.String.class).invoke(null, vw("726f2e736563757265"));
            if (invoke != null) {
                str = (java.lang.String) invoke;
            }
        } catch (java.lang.Exception unused) {
        }
        return (str == null || !"0".equals(str)) ? 1 : 0;
    }

    public static boolean v(android.content.Context context) {
        int simState;
        try {
            simState = ((android.telephony.TelephonyManager) context.getSystemService(com.aliyun.vod.log.core.AliyunLogCommon.TERMINAL_TYPE)).getSimState();
        } catch (java.lang.Throwable unused) {
        }
        return (simState == 1 || simState == 0) ? false : true;
    }

    private static java.lang.String vw(@androidx.annotation.NonNull java.lang.String str) {
        return com.ss.android.socialbase.downloader.utils.DownloadUtils.hexToString(str);
    }

    @androidx.annotation.WorkerThread
    public static synchronized void vw(@androidx.annotation.NonNull android.content.Context context) {
        synchronized (com.ss.android.socialbase.appdownloader.kz.kz.class) {
            if (vw == null) {
                vw = java.lang.Boolean.valueOf((wg() || wg(context) || t(context) || !v(context) || t() || yl(context)) ? false : true);
            }
        }
    }

    public static boolean vw() {
        java.lang.Boolean bool = vw;
        if (bool == null) {
            return true;
        }
        return bool.booleanValue();
    }

    public static boolean wg() {
        if (v() == 0) {
            return true;
        }
        return yl();
    }

    public static boolean wg(android.content.Context context) {
        return (context.getApplicationInfo().flags & 2) != 0;
    }

    private static boolean yl() {
        java.lang.String[] strArr = {vw("2f7362696e2f7375"), vw("2f73797374656d2f62696e2f7375"), vw("2f73797374656d2f7862696e2f7375"), vw("2f646174612f6c6f63616c2f7862696e2f7375"), vw("2f646174612f6c6f63616c2f62696e2f7375"), vw("2f73797374656d2f73642f7862696e2f7375"), vw("2f73797374656d2f62696e2f6661696c736166652f7375"), vw("2f646174612f6c6f63616c2f7375")};
        for (int i = 0; i < 8; i++) {
            if (new java.io.File(strArr[i]).exists()) {
                return true;
            }
        }
        return false;
    }

    @androidx.annotation.WorkerThread
    public static boolean yl(android.content.Context context) {
        return kz() || kz(context);
    }
}
