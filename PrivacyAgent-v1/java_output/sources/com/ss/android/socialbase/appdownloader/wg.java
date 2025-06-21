package com.ss.android.socialbase.appdownloader;

/* loaded from: classes19.dex */
public class wg {
    private static com.ss.android.socialbase.appdownloader.wg.vw t = null;
    private static final java.lang.String vw = "wg";
    private static com.ss.android.socialbase.appdownloader.wg.t wg;

    /* renamed from: com.ss.android.socialbase.appdownloader.wg$1, reason: invalid class name */
    public static class AnonymousClass1 implements com.ss.android.socialbase.appdownloader.wg.InterfaceC0484wg {
        @Override // com.ss.android.socialbase.appdownloader.wg.InterfaceC0484wg
        public boolean vw(@androidx.annotation.NonNull android.content.Context context) {
            return com.ss.android.socialbase.appdownloader.wg.v(context);
        }
    }

    /* renamed from: com.ss.android.socialbase.appdownloader.wg$2, reason: invalid class name */
    public static class AnonymousClass2 implements com.ss.android.socialbase.appdownloader.wg.InterfaceC0484wg {
        @Override // com.ss.android.socialbase.appdownloader.wg.InterfaceC0484wg
        public boolean vw(@androidx.annotation.NonNull android.content.Context context) {
            return com.ss.android.socialbase.appdownloader.wg.yl(context);
        }
    }

    public interface t {
        void vw(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo, com.ss.android.socialbase.appdownloader.vw vwVar);
    }

    public static class v implements java.util.concurrent.Callable<java.lang.Boolean> {
        private final android.os.Handler t;
        private final long v;
        private final android.content.Context vw;
        private final com.ss.android.socialbase.appdownloader.wg.InterfaceC0484wg wg;

        public v(android.os.Handler handler, android.content.Context context, com.ss.android.socialbase.appdownloader.wg.InterfaceC0484wg interfaceC0484wg, long j) {
            this.vw = context;
            this.wg = interfaceC0484wg;
            this.t = handler;
            this.v = j;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public java.lang.Boolean call() throws java.lang.Exception {
            com.ss.android.socialbase.appdownloader.wg.InterfaceC0484wg interfaceC0484wg;
            try {
                interfaceC0484wg = this.wg;
            } catch (java.lang.Throwable unused) {
            }
            if (interfaceC0484wg != null) {
                long j = this.v;
                if (j > 0 && j <= 10000) {
                    android.content.Context context = this.vw;
                    boolean vw = context != null ? interfaceC0484wg.vw(context) : false;
                    android.os.Message obtain = android.os.Message.obtain();
                    if (vw) {
                        obtain.what = 2;
                        this.t.sendMessage(obtain);
                    } else {
                        obtain.what = 1;
                        this.t.sendMessageDelayed(obtain, this.v);
                    }
                    return java.lang.Boolean.FALSE;
                }
            }
            return java.lang.Boolean.FALSE;
        }
    }

    public static class vw implements com.ss.android.socialbase.downloader.common.AppStatusManager.AppStatusChangeListener {
        private org.json.JSONObject t;
        private final com.ss.android.socialbase.appdownloader.wg.yl vw;
        private final int wg;

        public vw(android.content.Context context, android.content.Intent intent, int i, org.json.JSONObject jSONObject, com.ss.android.socialbase.appdownloader.wg.InterfaceC0484wg interfaceC0484wg) {
            this.t = jSONObject;
            int optInt = jSONObject.optInt(com.ss.android.socialbase.downloader.setting.DownloadSettingKeys.AhPlans.KEY_JUMP_UNKNWON_SOURCE_QUERY_INTERVAL, 1000);
            this.wg = optInt;
            this.vw = new com.ss.android.socialbase.appdownloader.wg.yl(context, intent, i, interfaceC0484wg, optInt);
        }

        @Override // com.ss.android.socialbase.downloader.common.AppStatusManager.AppStatusChangeListener
        public void onAppBackground() {
            int optInt = this.t.optInt(com.ss.android.socialbase.downloader.setting.DownloadSettingKeys.AhPlans.KEY_JUMP_UNKNWON_SOURCE_WAIT_TIME_OUT, 20);
            android.os.Message obtain = android.os.Message.obtain();
            obtain.what = 1;
            this.vw.kz.sendMessage(obtain);
            if (optInt <= 0 || optInt >= 60) {
                return;
            }
            android.os.Message obtain2 = android.os.Message.obtain();
            obtain2.what = 2;
            this.vw.kz.sendMessageDelayed(obtain2, optInt * 1000);
        }

        @Override // com.ss.android.socialbase.downloader.common.AppStatusManager.AppStatusChangeListener
        public void onAppForeground() {
            if (!this.vw.x) {
                android.os.Message obtain = android.os.Message.obtain();
                obtain.what = 2;
                this.vw.kz.sendMessage(obtain);
            }
            com.ss.android.socialbase.downloader.common.AppStatusManager.getInstance().unregisterAppSwitchListener(this);
            com.ss.android.socialbase.appdownloader.wg.vw unused = com.ss.android.socialbase.appdownloader.wg.t = null;
        }
    }

    /* renamed from: com.ss.android.socialbase.appdownloader.wg$wg, reason: collision with other inner class name */
    public interface InterfaceC0484wg {
        boolean vw(@androidx.annotation.NonNull android.content.Context context);
    }

    public static class yl implements com.ss.android.socialbase.downloader.thread.WeakDownloadHandler.IHandler {
        public static int vw;
        private static int wg;
        private final long bt;
        private final android.os.Handler kz;
        private java.util.concurrent.Future<java.lang.Boolean> o;
        private final android.content.Context t;
        private final android.content.Intent v;
        private boolean x = false;
        private final com.ss.android.socialbase.appdownloader.wg.InterfaceC0484wg yl;

        public yl(android.content.Context context, android.content.Intent intent, int i, com.ss.android.socialbase.appdownloader.wg.InterfaceC0484wg interfaceC0484wg, long j) {
            this.t = context;
            this.v = intent;
            wg = i;
            this.yl = interfaceC0484wg;
            this.kz = new com.ss.android.socialbase.downloader.thread.WeakDownloadHandler(android.os.Looper.getMainLooper(), this);
            this.bt = j;
        }

        @Override // com.ss.android.socialbase.downloader.thread.WeakDownloadHandler.IHandler
        public void handleMsg(android.os.Message message) {
            if (message != null) {
                int i = message.what;
                if (i == 1) {
                    long j = this.bt;
                    if (j <= 0 || j > 10000) {
                        return;
                    }
                    vw = 1;
                    this.o = com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getCPUThreadExecutor().submit(new com.ss.android.socialbase.appdownloader.wg.v(this.kz, this.t, this.yl, this.bt));
                    return;
                }
                if (i == 2) {
                    vw = 2;
                    this.kz.removeMessages(2);
                    this.kz.removeMessages(1);
                    java.util.concurrent.Future<java.lang.Boolean> future = this.o;
                    if (future != null) {
                        future.cancel(true);
                    }
                    if (!this.x && (android.os.Build.VERSION.SDK_INT < 29 || com.ss.android.socialbase.downloader.common.AppStatusManager.getInstance().isAppForeground())) {
                        android.content.Intent intent = this.v;
                        if (intent != null) {
                            com.ss.android.socialbase.appdownloader.wg.wg(this.t, intent);
                        } else {
                            com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo = com.ss.android.socialbase.downloader.downloader.Downloader.getInstance(this.t).getDownloadInfo(wg);
                            if (downloadInfo != null && downloadInfo.isDownloadOverStatus()) {
                                com.ss.android.socialbase.appdownloader.t.wg(this.t, wg, false);
                            }
                        }
                        this.x = true;
                    }
                    com.ss.android.socialbase.appdownloader.wg.wg(wg, this.v == null, com.ss.android.socialbase.appdownloader.wg.vw(this.t));
                }
            }
        }
    }

    public static void t(int i, org.json.JSONObject jSONObject) {
        int i2 = 1;
        boolean z = jSONObject.optInt(com.ss.android.socialbase.downloader.setting.DownloadSettingKeys.AhPlans.KEY_ALLOW_UNKNOWN_SOURCE_ON_STARTUP) == 1;
        org.json.JSONObject jSONObject2 = new org.json.JSONObject();
        if (!z) {
            i2 = 2;
        }
        try {
            jSONObject2.put(com.umeng.ccg.a.j, i2);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
        com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getEventListener().onUnityEvent(i, com.ss.android.socialbase.downloader.constants.MonitorConstants.UnityLabel.GUIDE_AUTH_OPEN_SETTING, jSONObject2);
    }

    private static void v(int i, org.json.JSONObject jSONObject) {
        int i2 = 1;
        boolean z = jSONObject.optInt(com.ss.android.socialbase.downloader.setting.DownloadSettingKeys.AhPlans.KEY_ALLOW_UNKNOWN_SOURCE_ON_STARTUP) == 1;
        org.json.JSONObject jSONObject2 = new org.json.JSONObject();
        if (!z) {
            i2 = 2;
        }
        try {
            jSONObject2.put(com.umeng.ccg.a.j, i2);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
        com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getEventListener().onUnityEvent(i, com.ss.android.socialbase.downloader.constants.MonitorConstants.UnityLabel.GUIDE_AUTH_DIALOG_SHOW, jSONObject2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean v(android.content.Context context) {
        if (context == null) {
            return true;
        }
        try {
            return android.provider.Settings.Secure.getInt(context.getContentResolver(), "install_non_market_apps", 1) > 0;
        } catch (java.lang.Throwable unused) {
            return true;
        }
    }

    public static int vw(@androidx.annotation.NonNull com.ss.android.socialbase.downloader.setting.DownloadSetting downloadSetting) {
        if (!(downloadSetting.optJSONObject(com.ss.android.socialbase.downloader.setting.DownloadSettingKeys.KEY_ANTI_HIJACK_DIR) != null ? !android.text.TextUtils.isEmpty(r0.optString(com.ss.android.socialbase.downloader.setting.DownloadSettingKeys.AntiHijackDir.KEY_ANTI_HIJACK_DIR_NAME)) : false)) {
            return 5;
        }
        if (!com.ss.android.socialbase.downloader.setting.DownloadSetting.obtainGlobal().optBugFix(com.ss.android.socialbase.downloader.setting.DownloadSettingKeys.BugFix.BUGFIX_GET_DOWNLOAD_INFO_BY_LIST)) {
            return 4;
        }
        org.json.JSONArray optJSONArray = downloadSetting.optJSONArray(com.ss.android.socialbase.downloader.setting.DownloadSettingKeys.KEY_AH_PLANS);
        int i = -1;
        if (optJSONArray != null) {
            int length = optJSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                org.json.JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                if (com.ss.android.socialbase.appdownloader.kz.vw.vw(optJSONObject)) {
                    java.lang.String optString = optJSONObject.optString("type");
                    if ("plan_a".equals(optString) || "plan_b".equals(optString) || "plan_e".equals(optString) || "plan_f".equals(optString)) {
                        i = vw(optJSONObject, downloadSetting).wg;
                        if (i == 0) {
                            return 0;
                        }
                    } else if ("plan_d".equalsIgnoreCase(optString) || "plan_h".equalsIgnoreCase(optString) || ("plan_g".equalsIgnoreCase(optString) && (i = wg(optJSONObject, downloadSetting).wg) == 0)) {
                        return 0;
                    }
                }
            }
        }
        return i;
    }

    @androidx.annotation.NonNull
    public static com.ss.android.socialbase.appdownloader.vw vw(org.json.JSONObject jSONObject, com.ss.android.socialbase.downloader.setting.DownloadSetting downloadSetting) {
        com.ss.android.socialbase.appdownloader.vw vwVar = new com.ss.android.socialbase.appdownloader.vw();
        if (jSONObject == null) {
            return vwVar;
        }
        java.lang.String optString = jSONObject.optString("type");
        vwVar.vw = optString;
        if ("plan_b".equals(optString)) {
            vwVar.yl = "custom";
            if (com.ss.android.socialbase.appdownloader.vw.v.vw(com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getAppContext(), "custom", jSONObject, downloadSetting)) {
                vwVar.wg = 0;
                return vwVar;
            }
            vw(vwVar, 3);
        } else {
            java.lang.String optString2 = jSONObject.optString(com.ss.android.socialbase.downloader.setting.DownloadSettingKeys.AhPlans.KEY_AH_DEVICE_PLANS);
            vwVar.yl = optString2;
            if (!android.text.TextUtils.isEmpty(optString2)) {
                for (java.lang.String str : optString2.split(",")) {
                    if (com.ss.android.socialbase.appdownloader.vw.v.vw(com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getAppContext(), str, jSONObject, downloadSetting)) {
                        vwVar.wg = 0;
                        return vwVar;
                    }
                    vw(vwVar, 3);
                }
            }
        }
        return vwVar;
    }

    public static com.ss.android.socialbase.appdownloader.vw vw(org.json.JSONObject jSONObject, java.lang.String str, android.content.Context context, com.ss.android.socialbase.downloader.setting.DownloadSetting downloadSetting) {
        com.ss.android.socialbase.appdownloader.vw vwVar = new com.ss.android.socialbase.appdownloader.vw();
        if (jSONObject != null && com.ss.android.socialbase.appdownloader.kz.yl.t()) {
            vwVar.vw = jSONObject.optString("type");
            if (downloadSetting.optInt("bi", 0) == 1) {
                vwVar.wg = 0;
                return vwVar;
            }
            if (vw(context)) {
                vwVar.wg = 2;
            } else if (com.ss.android.socialbase.appdownloader.kz.vw.vw(str) != null) {
                vwVar.wg = 0;
            } else {
                vwVar.wg = 9;
            }
        }
        return vwVar;
    }

    public static java.lang.String vw(java.lang.Throwable th) {
        java.lang.String th2 = th.toString();
        return th2.length() > 800 ? th2.substring(0, 500) : th2;
    }

    public static void vw(int i, org.json.JSONObject jSONObject) {
        int i2 = 1;
        boolean z = jSONObject.optInt(com.ss.android.socialbase.downloader.setting.DownloadSettingKeys.AhPlans.KEY_ALLOW_UNKNOWN_SOURCE_ON_STARTUP) == 1;
        org.json.JSONObject jSONObject2 = new org.json.JSONObject();
        if (!z) {
            i2 = 2;
        }
        try {
            jSONObject2.put(com.umeng.ccg.a.j, i2);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
        com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getEventListener().onUnityEvent(i, com.ss.android.socialbase.downloader.constants.MonitorConstants.UnityLabel.GUIDE_AUTH_DIALOG_CONFIRM, jSONObject2);
    }

    private static void vw(android.content.Context context, android.content.Intent intent, int i, org.json.JSONObject jSONObject, com.ss.android.socialbase.appdownloader.wg.InterfaceC0484wg interfaceC0484wg) {
        if (t != null) {
            com.ss.android.socialbase.downloader.common.AppStatusManager.getInstance().unregisterAppSwitchListener(t);
            t = null;
        }
        t = new com.ss.android.socialbase.appdownloader.wg.vw(context, intent, i, jSONObject, interfaceC0484wg);
        com.ss.android.socialbase.downloader.common.AppStatusManager.getInstance().registerAppSwitchListener(t);
    }

    private static void vw(com.ss.android.socialbase.appdownloader.vw vwVar, int i) {
        int i2 = vwVar.wg;
        if (i2 != -1) {
            vwVar.wg = (i2 * 10) + i;
        } else {
            vwVar.wg = i;
        }
    }

    public static void vw(com.ss.android.socialbase.appdownloader.wg.t tVar) {
        wg = tVar;
    }

    public static boolean vw() {
        return com.ss.android.socialbase.appdownloader.wg.yl.vw == 1;
    }

    public static boolean vw(android.content.Context context) {
        if (context == null) {
            return true;
        }
        if (com.ss.android.socialbase.appdownloader.kz.yl.t() && android.os.Build.VERSION.SDK_INT < 26) {
            return v(context);
        }
        if (android.os.Build.VERSION.SDK_INT >= 26 && context.getApplicationInfo().targetSdkVersion >= 26) {
            return yl(context);
        }
        return true;
    }

    public static boolean vw(android.content.Context context, @androidx.annotation.Nullable android.content.Intent intent, int i, org.json.JSONObject jSONObject) {
        try {
            if (com.ss.android.socialbase.appdownloader.kz.yl.t() && android.os.Build.VERSION.SDK_INT < 26 && !v(context)) {
                com.ss.android.socialbase.appdownloader.vw.kz kzVar = new com.ss.android.socialbase.appdownloader.vw.kz(context);
                if (kzVar.vw()) {
                    vw(context, intent, i, jSONObject, new com.ss.android.socialbase.appdownloader.wg.AnonymousClass1());
                    return wg(context, kzVar.wg());
                }
            } else if (android.os.Build.VERSION.SDK_INT >= 26 && context.getApplicationInfo().targetSdkVersion >= 26 && !yl(context)) {
                com.ss.android.socialbase.appdownloader.vw.wg wgVar = new com.ss.android.socialbase.appdownloader.vw.wg(context);
                if (wgVar.vw()) {
                    vw(context, intent, i, jSONObject, new com.ss.android.socialbase.appdownloader.wg.AnonymousClass2());
                    return wg(context, wgVar.wg());
                }
            }
        } catch (java.lang.Throwable unused) {
        }
        return false;
    }

    public static boolean vw(android.content.Context context, @androidx.annotation.Nullable android.content.Intent intent, org.json.JSONObject jSONObject, int i, @androidx.annotation.Nullable com.ss.android.socialbase.appdownloader.vw vwVar) {
        if (context != null && jSONObject != null) {
            long optLong = jSONObject.optLong(com.ss.android.socialbase.downloader.setting.DownloadSettingKeys.AhPlans.KEY_JUMP_INTERVAL, 0L);
            if (optLong <= 0) {
                return false;
            }
            android.content.SharedPreferences sharedPreferences = context.getSharedPreferences(com.ss.android.socialbase.downloader.constants.DownloadConstants.SP_ANTI_HIJACK_CONFIG, 0);
            if ((java.lang.System.currentTimeMillis() - sharedPreferences.getLong(com.ss.android.socialbase.downloader.constants.SpJsonConstants.KEY_LAST_JUMP_UNKNOWN_SOURCE_TIME, 0L)) / 60000 >= optLong && !vw(context)) {
                sharedPreferences.edit().putLong(com.ss.android.socialbase.downloader.constants.SpJsonConstants.KEY_LAST_JUMP_UNKNOWN_SOURCE_TIME, java.lang.System.currentTimeMillis()).apply();
                if (!(jSONObject.optInt(com.ss.android.socialbase.downloader.setting.DownloadSettingKeys.AhPlans.KEY_SHOW_UNKNOWN_SOURCE_DIALOG, 0) == 1)) {
                    if (vw(context, intent, i, jSONObject)) {
                        t(i, jSONObject);
                    }
                    return true;
                }
                android.content.Intent intent2 = new android.content.Intent(context, (java.lang.Class<?>) com.ss.android.socialbase.appdownloader.view.JumpUnknownSourceActivity.class);
                intent2.addFlags(268435456);
                intent2.putExtra(com.huawei.hms.support.api.entity.core.CommonCode.Resolution.HAS_RESOLUTION_FROM_APK, intent);
                intent2.putExtra("config", jSONObject.toString());
                intent2.putExtra("id", i);
                try {
                    if (vw(context, intent2, false)) {
                        v(i, jSONObject);
                    }
                    return true;
                } catch (java.lang.Throwable th) {
                    if (vwVar != null) {
                        vwVar.wg = 1;
                        vwVar.t = "tryShowUnknownSourceDialog" + vw(th);
                    }
                    return false;
                }
            }
        }
        return false;
    }

    public static boolean vw(android.content.Context context, android.content.Intent intent, boolean z) {
        if (context == null || intent == null) {
            return false;
        }
        if (!z) {
            intent.putExtra("start_only_for_android", true);
            context.startActivity(intent);
            return true;
        }
        try {
            intent.putExtra("start_only_for_android", true);
            context.startActivity(intent);
            return true;
        } catch (java.lang.Throwable unused) {
            return false;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0173  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0196  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x01a7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static boolean vw(android.content.Context context, com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo, android.content.Intent intent, org.json.JSONObject jSONObject, boolean z) {
        com.ss.android.socialbase.downloader.setting.DownloadSetting obtain;
        com.ss.android.socialbase.appdownloader.vw vw2;
        boolean vw3;
        boolean z2 = false;
        if (jSONObject != null && downloadInfo != null) {
            com.ss.android.socialbase.appdownloader.vw vwVar = new com.ss.android.socialbase.appdownloader.vw();
            java.lang.String optString = jSONObject.optString("type");
            if (!android.text.TextUtils.isEmpty(optString)) {
                obtain = com.ss.android.socialbase.downloader.setting.DownloadSetting.obtain(downloadInfo);
                vwVar.vw = optString;
                optString.hashCode();
                switch (optString) {
                    case "plan_a":
                    case "plan_e":
                        if (!downloadInfo.isSavePathRedirected()) {
                            vwVar.wg = downloadInfo.getAntiHijackErrorCode(-1);
                            if (z2) {
                                downloadInfo.getTempCacheData().put("ah_attempt", vwVar.vw());
                            }
                            if (wg != null) {
                                downloadInfo.getTempCacheData().put(com.huawei.hms.support.api.entity.core.CommonCode.Resolution.HAS_RESOLUTION_FROM_APK, intent);
                                wg.vw(downloadInfo, vwVar);
                                break;
                            }
                        }
                        vw2 = vw(jSONObject, obtain);
                        if (vw2.wg == 0) {
                            if (optString.equals("plan_f") && android.text.TextUtils.isEmpty(downloadInfo.getDBJsonString(com.ss.android.socialbase.downloader.constants.DbJsonConstants.CONTENT_URI))) {
                                vwVar.wg = downloadInfo.getAntiHijackErrorCode(10);
                                if (z2) {
                                }
                                if (wg != null) {
                                }
                            } else {
                                vw3 = vw(context, downloadInfo, jSONObject, vwVar);
                                z2 = vw3;
                                if (z2) {
                                }
                                if (wg != null) {
                                }
                            }
                        }
                        vwVar = vw2;
                        if (z2) {
                        }
                        if (wg != null) {
                        }
                        break;
                    case "plan_b":
                        vw2 = vw(jSONObject, obtain);
                        if (vw2.wg == 0) {
                            if (downloadInfo.isSavePathRedirected()) {
                                vw3 = wg(context, downloadInfo, jSONObject, vwVar);
                                z2 = vw3;
                                if (z2) {
                                }
                                if (wg != null) {
                                }
                            } else {
                                vwVar.wg = downloadInfo.getAntiHijackErrorCode(-1);
                                if (z2) {
                                }
                                if (wg != null) {
                                }
                            }
                        }
                        vwVar = vw2;
                        if (z2) {
                        }
                        if (wg != null) {
                        }
                        break;
                    case "plan_c":
                        if (android.os.Build.VERSION.SDK_INT >= 26 || com.ss.android.socialbase.appdownloader.kz.yl.t()) {
                            if ((jSONObject.optInt(com.ss.android.socialbase.downloader.setting.DownloadSettingKeys.AhPlans.KEY_JUMP_UNKNOWN_SOURCE_ENABLE_FOR_ALL, 0) == 1) || z) {
                                if (!(jSONObject.optInt(com.ss.android.socialbase.downloader.setting.DownloadSettingKeys.AhPlans.KEY_ALLOW_UNKNOWN_SOURCE_ON_STARTUP) == 1)) {
                                    vw3 = vw(context, intent, jSONObject, downloadInfo.getId(), vwVar);
                                    z2 = vw3;
                                }
                            }
                        }
                        if (z2) {
                        }
                        if (wg != null) {
                        }
                        break;
                    case "plan_d":
                        vwVar.vw = "plan_d";
                        if (com.ss.android.socialbase.appdownloader.kz.yl.v()) {
                            try {
                                com.ss.android.socialbase.appdownloader.t.vw(context, intent);
                                vwVar.wg = 0;
                                z2 = true;
                            } catch (java.lang.Throwable th) {
                                vwVar.wg = 4;
                                vwVar.t = th.toString();
                            }
                        } else {
                            vwVar.wg = 2;
                        }
                        if (z2) {
                        }
                        if (wg != null) {
                        }
                        break;
                    case "plan_f":
                        vw2 = vw(jSONObject, obtain);
                        if (vw2.wg == 0) {
                        }
                        vwVar = vw2;
                        if (z2) {
                        }
                        if (wg != null) {
                        }
                        break;
                    case "plan_g":
                        vw2 = wg(jSONObject, obtain);
                        if (vw2.wg == 0) {
                            vw3 = vw(context, downloadInfo, jSONObject, vwVar, obtain);
                            z2 = vw3;
                            if (z2) {
                            }
                            if (wg != null) {
                            }
                        }
                        vwVar = vw2;
                        if (z2) {
                        }
                        if (wg != null) {
                        }
                        break;
                    case "plan_h":
                        java.lang.String vw4 = com.ss.android.socialbase.appdownloader.kz.t.vw(obtain.optString("bh"), obtain.optString("s"));
                        com.ss.android.socialbase.appdownloader.vw vw5 = vw(jSONObject, vw4, context, obtain);
                        if (vw5.wg != 0) {
                            vwVar = vw5;
                        } else {
                            java.lang.String packageName = context.getPackageName();
                            if (com.ss.android.socialbase.appdownloader.kz.vw.vw(com.ss.android.socialbase.downloader.setting.DownloadSetting.getGlobalSettings(), context, vw4)) {
                                try {
                                    com.ss.android.socialbase.appdownloader.t.vw(context, intent);
                                    vwVar.wg = 0;
                                    z2 = true;
                                } catch (java.lang.Throwable th2) {
                                    try {
                                        vwVar.wg = 1;
                                        vwVar.t = th2.toString();
                                    } finally {
                                        com.ss.android.socialbase.appdownloader.kz.vw.vw(com.ss.android.socialbase.downloader.setting.DownloadSetting.getGlobalSettings(), context, packageName);
                                    }
                                }
                            } else {
                                vwVar.wg = 11;
                            }
                        }
                        if (z2) {
                        }
                        if (wg != null) {
                        }
                        break;
                    default:
                        if (z2) {
                        }
                        if (wg != null) {
                        }
                        break;
                }
            }
        }
        return z2;
    }

    public static boolean vw(android.content.Context context, com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo, android.content.Intent intent, boolean z) {
        org.json.JSONArray optJSONArray = com.ss.android.socialbase.downloader.setting.DownloadSetting.obtain(downloadInfo.getId()).optJSONArray(com.ss.android.socialbase.downloader.setting.DownloadSettingKeys.KEY_AH_PLANS);
        if (optJSONArray == null) {
            return false;
        }
        int length = optJSONArray.length();
        for (int i = 0; i < length; i++) {
            org.json.JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            if (com.ss.android.socialbase.appdownloader.kz.vw.vw(optJSONObject) && vw(context, downloadInfo, intent, optJSONObject, z)) {
                return true;
            }
        }
        return false;
    }

    private static boolean vw(android.content.Context context, com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo, org.json.JSONObject jSONObject, com.ss.android.socialbase.appdownloader.vw vwVar) {
        java.lang.String str;
        boolean z;
        if (context != null && jSONObject != null) {
            java.lang.String optString = jSONObject.optString(com.ss.android.socialbase.downloader.setting.DownloadSettingKeys.AhPlans.KEY_AH_DEVICE_PLANS);
            vwVar.yl = optString;
            if (!android.text.TextUtils.isEmpty(optString)) {
                java.lang.String[] split = optString.split(",");
                java.lang.String savePath = downloadInfo.getSavePath();
                if (android.text.TextUtils.isEmpty(savePath)) {
                    return false;
                }
                java.io.File file = new java.io.File(savePath);
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                int length = split.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        str = null;
                        z = false;
                        break;
                    }
                    str = split[i];
                    com.ss.android.socialbase.appdownloader.vw.vw vw2 = com.ss.android.socialbase.appdownloader.vw.v.vw(context, str, jSONObject, downloadInfo);
                    if (vw2 != null) {
                        android.content.Intent wg2 = vw2.wg();
                        if (wg2 == null) {
                            vw(vwVar, 3);
                            sb.append(str);
                            sb.append(" resolveActivity failed! ");
                        } else if (vw(file, downloadInfo, jSONObject)) {
                            z = true;
                            try {
                                vw(context, wg2, false);
                                break;
                            } catch (java.lang.Throwable th) {
                                sb.append(str);
                                sb.append(" startActivity failed : ");
                                sb.append(vw(th));
                                vw(vwVar, 1);
                            }
                        } else {
                            vw(vwVar, 6);
                            sb.append(str);
                            sb.append(" createDescFile failed! ");
                        }
                    }
                    sb.append("  ");
                    i++;
                }
                if (z) {
                    vwVar.v = str;
                    vwVar.wg = 0;
                } else {
                    vwVar.t = sb.toString();
                }
                return z;
            }
        }
        return false;
    }

    private static boolean vw(android.content.Context context, @androidx.annotation.NonNull com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo, org.json.JSONObject jSONObject, @androidx.annotation.NonNull com.ss.android.socialbase.appdownloader.vw vwVar, com.ss.android.socialbase.downloader.setting.DownloadSetting downloadSetting) {
        boolean z;
        java.lang.String optString = jSONObject.optString("type");
        vwVar.vw = optString;
        android.content.Intent wg2 = com.ss.android.socialbase.appdownloader.vw.v.vw(context, "vbi", jSONObject, downloadInfo).wg();
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        try {
            z = wg(context, wg2);
        } catch (java.lang.Throwable th) {
            sb.append(optString);
            sb.append(" startActivity failed : ");
            sb.append(vw(th));
            vw(vwVar, 1);
            z = false;
        }
        if (z) {
            vwVar.wg = 0;
        } else {
            vwVar.t = sb.toString();
        }
        return true;
    }

    private static boolean vw(java.io.File file, com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo, @androidx.annotation.NonNull org.json.JSONObject jSONObject) {
        if (file == null) {
            return false;
        }
        java.lang.String path = file.getPath();
        org.json.JSONObject optJSONObject = com.ss.android.socialbase.downloader.setting.DownloadSetting.obtain(downloadInfo.getId()).optJSONObject(com.ss.android.socialbase.downloader.setting.DownloadSettingKeys.KEY_ANTI_HIJACK_DIR);
        java.io.File file2 = null;
        java.lang.String optString = optJSONObject != null ? optJSONObject.optString(com.ss.android.socialbase.downloader.setting.DownloadSettingKeys.AntiHijackDir.KEY_ANTI_HIJACK_INSTALL_DESC) : null;
        if (!android.text.TextUtils.isEmpty(optString) && !android.text.TextUtils.isEmpty(optString)) {
            file2 = new java.io.File(path + java.io.File.separator + optString);
        }
        if (file2 == null) {
            return true;
        }
        try {
            if (!file2.createNewFile()) {
                return true;
            }
            file2.deleteOnExit();
            return true;
        } catch (java.io.IOException unused) {
            return false;
        }
    }

    public static com.ss.android.socialbase.appdownloader.vw wg(org.json.JSONObject jSONObject, com.ss.android.socialbase.downloader.setting.DownloadSetting downloadSetting) {
        com.ss.android.socialbase.appdownloader.vw vwVar = new com.ss.android.socialbase.appdownloader.vw();
        if (jSONObject == null) {
            return vwVar;
        }
        vwVar.vw = jSONObject.optString("type");
        vwVar.yl = "vbi";
        if (com.ss.android.socialbase.appdownloader.vw.v.vw(com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getAppContext(), "vbi", jSONObject, downloadSetting)) {
            vwVar.wg = 0;
        } else {
            vw(vwVar, 3);
        }
        return vwVar;
    }

    public static void wg(int i, org.json.JSONObject jSONObject) {
        int i2 = 1;
        boolean z = jSONObject.optInt(com.ss.android.socialbase.downloader.setting.DownloadSettingKeys.AhPlans.KEY_ALLOW_UNKNOWN_SOURCE_ON_STARTUP) == 1;
        org.json.JSONObject jSONObject2 = new org.json.JSONObject();
        if (!z) {
            i2 = 2;
        }
        try {
            jSONObject2.put(com.umeng.ccg.a.j, i2);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
        com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getEventListener().onUnityEvent(i, com.ss.android.socialbase.downloader.constants.MonitorConstants.UnityLabel.GUIDE_AUTH_DIALOG_CANCEL, jSONObject2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void wg(int i, boolean z, boolean z2) {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        int i2 = 1;
        try {
            jSONObject.put(com.umeng.ccg.a.j, z ? 1 : 2);
            if (!z2) {
                i2 = 2;
            }
            jSONObject.put(androidx.core.provider.FontsContractCompat.Columns.RESULT_CODE, i2);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
        com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getEventListener().onUnityEvent(i, com.ss.android.socialbase.downloader.constants.MonitorConstants.UnityLabel.GUIDE_AUTH_RESULT, jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean wg(android.content.Context context, android.content.Intent intent) {
        return vw(context, intent, true);
    }

    private static boolean wg(android.content.Context context, @androidx.annotation.NonNull com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo, org.json.JSONObject jSONObject, @androidx.annotation.NonNull com.ss.android.socialbase.appdownloader.vw vwVar) {
        if (context != null && jSONObject != null) {
            java.lang.String savePath = downloadInfo.getSavePath();
            if (android.text.TextUtils.isEmpty(savePath)) {
                return false;
            }
            vwVar.v = "custom";
            com.ss.android.socialbase.appdownloader.vw.vw vw2 = com.ss.android.socialbase.appdownloader.vw.v.vw(context, "custom", jSONObject, downloadInfo);
            if (vw2 != null && vw2.vw()) {
                android.content.Intent wg2 = vw2.wg();
                if (wg2 == null) {
                    return false;
                }
                if (!vw(new java.io.File(savePath), downloadInfo, jSONObject)) {
                    vwVar.wg = 6;
                } else {
                    if (wg(context, wg2)) {
                        vwVar.wg = 0;
                        return true;
                    }
                    vwVar.wg = 1;
                }
                return false;
            }
            vwVar.wg = 3;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @androidx.annotation.RequiresApi(api = 26)
    public static boolean yl(android.content.Context context) {
        boolean canRequestPackageInstalls;
        if (context == null) {
            return true;
        }
        try {
            canRequestPackageInstalls = context.getPackageManager().canRequestPackageInstalls();
            return canRequestPackageInstalls;
        } catch (java.lang.Throwable unused) {
            return true;
        }
    }
}
