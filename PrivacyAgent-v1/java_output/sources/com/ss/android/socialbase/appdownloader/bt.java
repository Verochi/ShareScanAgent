package com.ss.android.socialbase.appdownloader;

/* loaded from: classes19.dex */
public final class bt {

    public static class vw {
        private boolean bt;
        private int kz;
        private android.graphics.drawable.Drawable t;
        private java.lang.String v;
        private java.lang.String vw;
        private java.lang.String wg;
        private java.lang.String yl;

        public vw(java.lang.String str, java.lang.String str2, android.graphics.drawable.Drawable drawable, java.lang.String str3, java.lang.String str4, int i, boolean z) {
            wg(str2);
            vw(drawable);
            vw(str);
            t(str3);
            v(str4);
            vw(i);
            vw(z);
        }

        public java.lang.String bt() {
            return this.yl;
        }

        public int kz() {
            return this.kz;
        }

        public java.lang.String t() {
            return this.vw;
        }

        public void t(java.lang.String str) {
            this.v = str;
        }

        public java.lang.String toString() {
            return "{\n  pkg name: " + t() + "\n  app icon: " + vw() + "\n  app name: " + v() + "\n  app path: " + yl() + "\n  app v name: " + bt() + "\n  app v code: " + kz() + "\n  is system: " + wg() + com.alipay.sdk.m.u.i.d;
        }

        public java.lang.String v() {
            return this.wg;
        }

        public void v(java.lang.String str) {
            this.yl = str;
        }

        public android.graphics.drawable.Drawable vw() {
            return this.t;
        }

        public void vw(int i) {
            this.kz = i;
        }

        public void vw(android.graphics.drawable.Drawable drawable) {
            this.t = drawable;
        }

        public void vw(java.lang.String str) {
            this.vw = str;
        }

        public void vw(boolean z) {
            this.bt = z;
        }

        public void wg(java.lang.String str) {
            this.wg = str;
        }

        public boolean wg() {
            return this.bt;
        }

        public java.lang.String yl() {
            return this.v;
        }
    }

    private static boolean t(java.lang.String str) {
        if (str == null) {
            return true;
        }
        int length = str.length();
        for (int i = 0; i < length; i++) {
            if (!java.lang.Character.isWhitespace(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static int vw(java.lang.String str) {
        if (t(str)) {
            return -1;
        }
        try {
            android.content.pm.PackageInfo packageInfo = com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getAppContext().getPackageManager().getPackageInfo(str, 0);
            if (packageInfo == null) {
                return -1;
            }
            return packageInfo.versionCode;
        } catch (android.content.pm.PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return -1;
        }
    }

    private static com.ss.android.socialbase.appdownloader.bt.vw vw(android.content.pm.PackageManager packageManager, android.content.pm.PackageInfo packageInfo) {
        android.graphics.drawable.Drawable drawable = null;
        if (packageInfo == null) {
            return null;
        }
        android.content.pm.ApplicationInfo applicationInfo = packageInfo.applicationInfo;
        java.lang.String str = packageInfo.packageName;
        java.lang.String charSequence = (applicationInfo == null || applicationInfo.loadLabel(packageManager) == null) ? "" : applicationInfo.loadLabel(packageManager).toString();
        try {
            drawable = applicationInfo.loadIcon(packageManager);
        } catch (java.lang.Exception unused) {
        }
        return new com.ss.android.socialbase.appdownloader.bt.vw(str, charSequence, drawable, applicationInfo.sourceDir, packageInfo.versionName, packageInfo.versionCode, (applicationInfo.flags & 1) != 0);
    }

    public static com.ss.android.socialbase.appdownloader.bt.vw wg(java.lang.String str) {
        try {
            android.content.pm.PackageManager packageManager = com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getAppContext().getPackageManager();
            if (packageManager == null) {
                return null;
            }
            return vw(packageManager, packageManager.getPackageInfo(str, 0));
        } catch (android.content.pm.PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}
