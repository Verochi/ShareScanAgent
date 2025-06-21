package com.ss.android.downloadlib.addownload.wg;

/* loaded from: classes19.dex */
public class v {
    private static final java.lang.String[] t = {"com", com.aliyun.vod.log.core.AliyunLogCommon.OPERATION_SYSTEM, "ss"};
    private static final int[] v = {3101, 3102, 3103, 3201, 3202, 3203};
    private static volatile com.ss.android.downloadlib.addownload.wg.v vw;
    private final java.util.LinkedList<com.ss.android.downloadlib.addownload.wg.v.vw> wg = new java.util.LinkedList<>();

    public static class vw {
        public final java.lang.String t;
        public final java.lang.String v;
        public final java.lang.String vw;
        public final int wg;
        public final long yl;

        private vw(java.lang.String str, int i, java.lang.String str2, java.lang.String str3, long j) {
            this.vw = str;
            this.wg = i;
            this.t = str2 != null ? str2.toLowerCase() : null;
            this.v = str3 != null ? str3.toLowerCase() : null;
            this.yl = j;
        }

        public /* synthetic */ vw(java.lang.String str, int i, java.lang.String str2, java.lang.String str3, long j, com.ss.android.downloadlib.addownload.wg.v.AnonymousClass1 anonymousClass1) {
            this(str, i, str2, str3, j);
        }
    }

    private v() {
    }

    private com.ss.android.downloadlib.addownload.wg.v.vw t(java.lang.String str) {
        try {
            android.content.pm.PackageManager packageManager = com.ss.android.downloadlib.addownload.z.getContext().getPackageManager();
            android.content.pm.PackageInfo packageInfo = packageManager.getPackageInfo(str, 0);
            if (packageInfo != null) {
                return new com.ss.android.downloadlib.addownload.wg.v.vw(str, packageInfo.versionCode, packageInfo.versionName, (java.lang.String) packageManager.getApplicationLabel(packageInfo.applicationInfo), java.lang.System.currentTimeMillis(), null);
            }
            return null;
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static com.ss.android.downloadlib.addownload.wg.v vw() {
        if (vw == null) {
            synchronized (com.ss.android.downloadlib.addownload.wg.v.class) {
                if (vw == null) {
                    vw = new com.ss.android.downloadlib.addownload.wg.v();
                }
            }
        }
        return vw;
    }

    private static boolean vw(java.lang.String str, java.lang.String str2) {
        java.lang.String[] split;
        java.lang.String[] split2;
        boolean z;
        try {
            split = str.split("\\.");
            split2 = str2.split("\\.");
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
        if (split.length != 0 && split2.length != 0) {
            int i = 0;
            int i2 = 0;
            for (java.lang.String str3 : split) {
                java.lang.String[] strArr = t;
                int length = strArr.length;
                int i3 = 0;
                while (true) {
                    if (i3 >= length) {
                        z = false;
                        break;
                    }
                    java.lang.String str4 = strArr[i3];
                    if (str4.equals(str3)) {
                        if (i < split2.length && str4.equals(split2[i])) {
                            i++;
                        }
                        z = true;
                    } else {
                        i3++;
                    }
                }
                if (!z) {
                    int i4 = i2;
                    int i5 = i;
                    while (i < split2.length) {
                        if (str3.equals(split2[i])) {
                            if (i == i5) {
                                i5++;
                            }
                            i4++;
                            if (i4 >= 2) {
                                return true;
                            }
                        }
                        i++;
                    }
                    i = i5;
                    i2 = i4;
                }
            }
            return false;
        }
        return false;
    }

    private void wg() {
        long currentTimeMillis = java.lang.System.currentTimeMillis();
        synchronized (this.wg) {
            java.util.Iterator<com.ss.android.downloadlib.addownload.wg.v.vw> it = this.wg.iterator();
            while (it.hasNext() && currentTimeMillis - it.next().yl > 1800000) {
                it.remove();
            }
        }
    }

    public com.ss.android.downloadlib.addownload.wg.v.vw vw(com.ss.android.downloadad.api.vw.wg wgVar) {
        if (wgVar == null) {
            return null;
        }
        wg();
        synchronized (this.wg) {
            java.util.Iterator<com.ss.android.downloadlib.addownload.wg.v.vw> it = this.wg.iterator();
            while (it.hasNext()) {
                com.ss.android.downloadlib.addownload.wg.v.vw next = it.next();
                if (next.yl > wgVar.wy()) {
                    return next;
                }
            }
            return null;
        }
    }

    public void vw(java.lang.String str) {
        com.ss.android.downloadlib.addownload.wg.v.vw t2;
        wg();
        if (android.text.TextUtils.isEmpty(str) || (t2 = t(str)) == null) {
            return;
        }
        synchronized (this.wg) {
            this.wg.add(t2);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:118:0x00de, code lost:
    
        r7[2] = r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0095, code lost:
    
        r7[1] = r11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public android.util.Pair<com.ss.android.downloadlib.addownload.wg.v.vw, java.lang.Integer> wg(com.ss.android.downloadad.api.vw.wg wgVar) {
        int i;
        if (wgVar == null) {
            return null;
        }
        try {
            wg();
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
        if (this.wg.isEmpty()) {
            return null;
        }
        java.lang.String f = wgVar.f();
        java.lang.String yl = wgVar.yl();
        java.lang.String ao = wgVar.ao();
        int oo = wgVar.oo();
        int length = v.length;
        com.ss.android.downloadlib.addownload.wg.v.vw[] vwVarArr = new com.ss.android.downloadlib.addownload.wg.v.vw[length];
        synchronized (this.wg) {
            java.util.Iterator<com.ss.android.downloadlib.addownload.wg.v.vw> it = this.wg.iterator();
            android.content.pm.PackageInfo packageInfo = null;
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.ss.android.downloadlib.addownload.wg.v.vw next = it.next();
                if (next.yl >= wgVar.wy()) {
                    if (android.text.TextUtils.isEmpty(f)) {
                        if (packageInfo == null) {
                            packageInfo = com.ss.android.downloadlib.bt.vl.vw(wgVar);
                        }
                        if (packageInfo != null) {
                            try {
                                f = (java.lang.String) com.ss.android.downloadlib.addownload.z.getContext().getPackageManager().getApplicationLabel(packageInfo.applicationInfo);
                            } catch (java.lang.Throwable unused) {
                            }
                        }
                    }
                    if (!android.text.TextUtils.isEmpty(f) && !android.text.TextUtils.isEmpty(next.v)) {
                        f = f.toLowerCase();
                        if (f.equals(next.v)) {
                            vwVarArr[0] = next;
                            break;
                        }
                        if (f.contains(next.v) || next.v.contains(f)) {
                            break;
                        }
                    }
                    if (android.text.TextUtils.isEmpty(yl)) {
                        if (packageInfo == null) {
                            packageInfo = com.ss.android.downloadlib.bt.vl.vw(wgVar);
                        }
                        if (packageInfo != null) {
                            yl = packageInfo.packageName;
                        }
                    }
                    if (!android.text.TextUtils.isEmpty(yl) && !android.text.TextUtils.isEmpty(next.vw)) {
                        yl = yl.toLowerCase();
                        if (yl.contains(next.vw) || next.vw.contains(yl)) {
                            break;
                        }
                        if (vwVarArr[3] == null) {
                            if (vw(yl, next.vw)) {
                                vwVarArr[3] = next;
                            }
                        }
                    }
                    if (vwVarArr[4] == null) {
                        if (android.text.TextUtils.isEmpty(ao)) {
                            if (packageInfo == null) {
                                packageInfo = com.ss.android.downloadlib.bt.vl.vw(wgVar);
                            }
                            if (packageInfo != null) {
                                ao = packageInfo.versionName;
                            }
                        }
                        if (!android.text.TextUtils.isEmpty(ao) && !android.text.TextUtils.isEmpty(next.t)) {
                            ao = ao.toLowerCase();
                            if (ao.equals(next.t)) {
                                vwVarArr[4] = next;
                            }
                        }
                        if (vwVarArr[5] == null) {
                            if (oo <= 0) {
                                if (packageInfo == null) {
                                    packageInfo = com.ss.android.downloadlib.bt.vl.vw(wgVar);
                                }
                                if (packageInfo != null) {
                                    oo = packageInfo.versionCode;
                                }
                            }
                            if (oo == next.wg) {
                                vwVarArr[5] = next;
                            }
                        }
                    }
                }
            }
        }
        for (i = 0; i < length; i++) {
            if (vwVarArr[i] != null) {
                return new android.util.Pair<>(vwVarArr[i], java.lang.Integer.valueOf(v[i]));
            }
        }
        return null;
    }

    public void wg(java.lang.String str) {
        wg();
        if (android.text.TextUtils.isEmpty(str)) {
            return;
        }
        synchronized (this.wg) {
            java.util.Iterator<com.ss.android.downloadlib.addownload.wg.v.vw> it = this.wg.iterator();
            while (it.hasNext()) {
                if (str.equals(it.next().vw)) {
                    it.remove();
                    return;
                }
            }
        }
    }
}
