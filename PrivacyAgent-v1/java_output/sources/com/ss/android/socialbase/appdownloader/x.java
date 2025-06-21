package com.ss.android.socialbase.appdownloader;

/* loaded from: classes19.dex */
public class x {
    public static int kz(java.lang.String str) {
        try {
            return com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getAppContext().getResources().getIdentifier(str, "color", com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getAppContext().getPackageName());
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static int t(java.lang.String str) {
        try {
            return vw(str, com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getAppContext().getPackageName());
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static int v(java.lang.String str) {
        try {
            return com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getAppContext().getResources().getIdentifier(str, com.anythink.expressad.foundation.h.i.e, com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getAppContext().getPackageName());
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static int vw(android.content.Context context, java.lang.String str) {
        try {
            return context.getResources().getIdentifier(str, com.anythink.expressad.foundation.h.i.g, context.getPackageName());
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static int vw(java.lang.String str) {
        try {
            return com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getAppContext().getResources().getIdentifier(str, "layout", com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getAppContext().getPackageName());
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static int vw(java.lang.String str, java.lang.String str2) {
        try {
            return com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getAppContext().getResources().getIdentifier(str, com.anythink.expressad.foundation.h.i.c, str2);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static int wg(java.lang.String str) {
        return vw(com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getAppContext(), str);
    }

    public static int wg(java.lang.String str, java.lang.String str2) {
        try {
            return com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getAppContext().getResources().getIdentifier(str, "attr", str2);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static int yl(java.lang.String str) {
        try {
            return com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getAppContext().getResources().getIdentifier(str, "id", com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getAppContext().getPackageName());
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
}
