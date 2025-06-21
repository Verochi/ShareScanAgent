package com.ss.android.socialbase.appdownloader.yl;

/* loaded from: classes19.dex */
public class v {
    private static com.ss.android.socialbase.appdownloader.view.vw t = null;
    private static android.app.AlertDialog v = null;
    private static final java.lang.String vw = "v";
    private static java.util.List<com.ss.android.socialbase.appdownloader.t.cp> wg = new java.util.ArrayList();

    /* renamed from: com.ss.android.socialbase.appdownloader.yl.v$1, reason: invalid class name */
    public static class AnonymousClass1 implements android.content.DialogInterface.OnKeyListener {
        @Override // android.content.DialogInterface.OnKeyListener
        public boolean onKey(android.content.DialogInterface dialogInterface, int i, android.view.KeyEvent keyEvent) {
            if (i != 4) {
                return false;
            }
            if (keyEvent.getAction() == 1) {
                com.ss.android.socialbase.appdownloader.yl.v.vw(false);
            }
            return true;
        }
    }

    /* renamed from: com.ss.android.socialbase.appdownloader.yl.v$2, reason: invalid class name */
    public static class AnonymousClass2 implements android.content.DialogInterface.OnClickListener {
        @Override // android.content.DialogInterface.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public void onClick(android.content.DialogInterface dialogInterface, int i) {
            com.ss.android.socialbase.appdownloader.yl.v.vw(false);
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackDialog(dialogInterface, i);
        }
    }

    /* renamed from: com.ss.android.socialbase.appdownloader.yl.v$3, reason: invalid class name */
    public static class AnonymousClass3 implements android.content.DialogInterface.OnClickListener {
        final /* synthetic */ android.app.Activity vw;
        final /* synthetic */ com.ss.android.socialbase.appdownloader.t.cp wg;

        public AnonymousClass3(android.app.Activity activity, com.ss.android.socialbase.appdownloader.t.cp cpVar) {
            this.vw = activity;
            this.wg = cpVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public void onClick(android.content.DialogInterface dialogInterface, int i) {
            com.ss.android.socialbase.appdownloader.yl.v.wg(this.vw, this.wg);
            dialogInterface.cancel();
            android.app.AlertDialog unused = com.ss.android.socialbase.appdownloader.yl.v.v = null;
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackDialog(dialogInterface, i);
        }
    }

    public static synchronized void vw(@androidx.annotation.NonNull android.app.Activity activity, @androidx.annotation.NonNull com.ss.android.socialbase.appdownloader.t.cp cpVar) {
        synchronized (com.ss.android.socialbase.appdownloader.yl.v.class) {
            if (cpVar == null) {
                return;
            }
            if (activity != null) {
                try {
                    if (!activity.isFinishing()) {
                        int vw2 = com.ss.android.socialbase.appdownloader.x.vw(com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getAppContext(), "tt_appdownloader_notification_request_title");
                        int vw3 = com.ss.android.socialbase.appdownloader.x.vw(com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getAppContext(), "tt_appdownloader_notification_request_message");
                        int vw4 = com.ss.android.socialbase.appdownloader.x.vw(com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getAppContext(), "tt_appdownloader_notification_request_btn_yes");
                        int vw5 = com.ss.android.socialbase.appdownloader.x.vw(com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getAppContext(), "tt_appdownloader_notification_request_btn_no");
                        wg.add(cpVar);
                        android.app.AlertDialog alertDialog = v;
                        if (alertDialog == null || !alertDialog.isShowing()) {
                            v = new android.app.AlertDialog.Builder(activity).setTitle(vw2).setMessage(vw3).setPositiveButton(vw4, new com.ss.android.socialbase.appdownloader.yl.v.AnonymousClass3(activity, cpVar)).setNegativeButton(vw5, new com.ss.android.socialbase.appdownloader.yl.v.AnonymousClass2()).setOnKeyListener(new com.ss.android.socialbase.appdownloader.yl.v.AnonymousClass1()).setCancelable(false).show();
                        }
                        return;
                    }
                } catch (java.lang.Throwable th) {
                    th.printStackTrace();
                    vw(false);
                    return;
                }
            }
            cpVar.wg();
        }
    }

    public static synchronized void vw(boolean z) {
        synchronized (com.ss.android.socialbase.appdownloader.yl.v.class) {
            try {
                android.app.AlertDialog alertDialog = v;
                if (alertDialog != null) {
                    alertDialog.cancel();
                    v = null;
                }
                for (com.ss.android.socialbase.appdownloader.t.cp cpVar : wg) {
                    if (cpVar != null) {
                        if (z) {
                            cpVar.vw();
                        } else {
                            cpVar.wg();
                        }
                    }
                }
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static boolean vw() {
        try {
            return androidx.core.app.NotificationManagerCompat.from(com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getAppContext()).areNotificationsEnabled();
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return true;
        }
    }

    public static void wg(@androidx.annotation.NonNull android.app.Activity activity, @androidx.annotation.NonNull com.ss.android.socialbase.appdownloader.t.cp cpVar) {
        if (activity != null) {
            try {
                if (!activity.isFinishing()) {
                    android.app.FragmentManager fragmentManager = activity.getFragmentManager();
                    java.lang.String str = vw;
                    com.ss.android.socialbase.appdownloader.view.vw vwVar = (com.ss.android.socialbase.appdownloader.view.vw) fragmentManager.findFragmentByTag(str);
                    t = vwVar;
                    if (vwVar == null) {
                        t = new com.ss.android.socialbase.appdownloader.view.vw();
                        fragmentManager.beginTransaction().add(t, str).commitAllowingStateLoss();
                        try {
                            fragmentManager.executePendingTransactions();
                        } catch (java.lang.Throwable th) {
                            th.printStackTrace();
                        }
                    }
                    t.vw();
                    return;
                }
            } catch (java.lang.Throwable th2) {
                try {
                    th2.printStackTrace();
                    cpVar.vw();
                    return;
                } catch (java.lang.Throwable th3) {
                    th3.printStackTrace();
                    return;
                }
            }
        }
        cpVar.vw();
    }
}
