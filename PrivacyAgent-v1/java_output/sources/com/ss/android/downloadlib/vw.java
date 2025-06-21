package com.ss.android.downloadlib;

/* loaded from: classes19.dex */
public class vw implements com.ss.android.downloadad.api.vw, com.ss.android.socialbase.appdownloader.wg.t, com.ss.android.socialbase.downloader.common.AppStatusManager.AppStatusChangeListener, com.ss.android.socialbase.downloader.depend.IOpenInstallerListener {
    private static volatile com.ss.android.downloadlib.vw v = null;
    private static java.lang.String vw = "vw";
    private com.ss.android.downloadlib.vw.wg t;
    private long wg;

    /* renamed from: com.ss.android.downloadlib.vw$1, reason: invalid class name */
    public class AnonymousClass1 implements com.ss.android.downloadlib.wg.bt {
        final /* synthetic */ com.ss.android.downloadad.api.vw.wg vw;
        final /* synthetic */ java.lang.String wg;

        public AnonymousClass1(com.ss.android.downloadad.api.vw.wg wgVar, java.lang.String str) {
            this.vw = wgVar;
            this.wg = str;
        }

        @Override // com.ss.android.downloadlib.wg.bt
        public void vw(boolean z) {
            com.ss.android.socialbase.downloader.logger.Logger.d(com.ss.android.downloadlib.vw.vw, "appBackForeground->".concat(java.lang.String.valueOf(z)));
            if (!z) {
                if (com.ss.android.downloadlib.wg.vw.vw(this.wg, this.vw) || this.vw.lb() != 4) {
                    return;
                }
                com.ss.android.downloadlib.addownload.vw.vw.vw().vw(this.vw);
                return;
            }
            if (!(com.ss.android.downloadlib.wg.kz.t(this.vw) ? com.ss.android.downloadlib.wg.vw.vw(this.wg, this.vw) : false) && com.ss.android.downloadlib.wg.kz.v(this.vw) && this.vw.lb() == 4) {
                com.ss.android.downloadlib.addownload.vw.vw.vw().vw(this.vw);
            }
        }
    }

    /* renamed from: com.ss.android.downloadlib.vw$2, reason: invalid class name */
    public class AnonymousClass2 implements java.lang.Runnable {
        final /* synthetic */ long vw;

        public AnonymousClass2(long j) {
            this.vw = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.ss.android.downloadlib.vw.vw().vw(this.vw);
        }
    }

    /* renamed from: com.ss.android.downloadlib.vw$3, reason: invalid class name */
    public class AnonymousClass3 implements java.lang.Runnable {
        final /* synthetic */ java.lang.String vw;
        final /* synthetic */ com.ss.android.downloadad.api.vw.wg wg;

        public AnonymousClass3(java.lang.String str, com.ss.android.downloadad.api.vw.wg wgVar) {
            this.vw = str;
            this.wg = wgVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            java.lang.String vw = com.ss.android.downloadlib.bt.vw.vw(this.vw);
            if (android.text.TextUtils.isEmpty(vw)) {
                return;
            }
            com.ss.android.downloadlib.addownload.z.getContext().getSharedPreferences("sp_ttdownloader_md5", 0).edit().putString(java.lang.String.valueOf(this.wg.wg()), vw).apply();
        }
    }

    /* renamed from: com.ss.android.downloadlib.vw$4, reason: invalid class name */
    public class AnonymousClass4 implements com.ss.android.downloadlib.wg.v {
        final /* synthetic */ com.ss.android.socialbase.downloader.model.DownloadInfo vw;
        final /* synthetic */ org.json.JSONObject wg;

        public AnonymousClass4(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo, org.json.JSONObject jSONObject) {
            this.vw = downloadInfo;
            this.wg = jSONObject;
        }

        @Override // com.ss.android.downloadlib.wg.v
        public void vw(boolean z) {
            if (!z) {
                android.content.Intent intent = (android.content.Intent) this.vw.getTempCacheData().get(com.huawei.hms.support.api.entity.core.CommonCode.Resolution.HAS_RESOLUTION_FROM_APK);
                if (intent != null) {
                    this.vw.getTempCacheData().remove(com.huawei.hms.support.api.entity.core.CommonCode.Resolution.HAS_RESOLUTION_FROM_APK);
                    com.ss.android.socialbase.appdownloader.t.vw(com.ss.android.downloadlib.addownload.z.getContext(), intent);
                    com.ss.android.downloadlib.bt.vl.vw(this.wg, "backup", (java.lang.Object) 1);
                } else {
                    com.ss.android.downloadlib.bt.vl.vw(this.wg, "backup", (java.lang.Object) 2);
                }
            }
            com.ss.android.downloadad.api.vw.wg vw = com.ss.android.downloadlib.addownload.wg.kz.vw().vw(this.vw);
            if (vw != null) {
                com.ss.android.downloadlib.v.vw.vw().vw(z ? "installer_delay_success" : "installer_delay_failed", this.wg, vw);
            } else {
                com.ss.android.downloadlib.yl.t.vw().wg("ah nativeModel=null");
            }
            if (z) {
                com.ss.android.downloadlib.addownload.z.qm();
                com.ss.android.downloadlib.addownload.z.getContext();
            }
        }
    }

    public class t implements java.lang.Runnable {
        private final com.ss.android.downloadad.api.vw.wg wg;

        public t(com.ss.android.downloadad.api.vw.wg wgVar) {
            this.wg = wgVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                try {
                    this.wg.es(true);
                    com.ss.android.downloadlib.vw.this.t(this.wg);
                } catch (java.lang.Exception e) {
                    e.printStackTrace();
                }
            } finally {
                this.wg.es(false);
            }
        }
    }

    @androidx.annotation.WorkerThread
    /* renamed from: com.ss.android.downloadlib.vw$vw, reason: collision with other inner class name */
    public class RunnableC0475vw implements java.lang.Runnable {
        private final int wg;

        public RunnableC0475vw(int i) {
            this.wg = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                com.ss.android.downloadlib.addownload.wg.kz.vw().wg();
                java.util.concurrent.ConcurrentHashMap<java.lang.Long, com.ss.android.downloadad.api.vw.wg> t = com.ss.android.downloadlib.addownload.wg.kz.vw().t();
                if (t == null || t.isEmpty()) {
                    return;
                }
                com.ss.android.downloadlib.vw.this.vw(t, this.wg);
            } catch (java.lang.Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static class wg implements java.lang.Runnable {
        private long t;
        private int v;
        private long vw;
        private int wg;
        private long yl;

        private wg(long j, int i, long j2, int i2) {
            this.vw = j;
            this.wg = i;
            this.t = j2;
            this.v = i2;
        }

        public /* synthetic */ wg(long j, int i, long j2, int i2, com.ss.android.downloadlib.vw.AnonymousClass1 anonymousClass1) {
            this(j, i, j2, i2);
        }

        private int vw(boolean z, com.ss.android.downloadad.api.vw.wg wgVar, com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo, boolean z2, org.json.JSONObject jSONObject) {
            com.ss.android.socialbase.downloader.setting.DownloadSetting obtain = com.ss.android.socialbase.downloader.setting.DownloadSetting.obtain(downloadInfo.getId());
            int i = 1;
            if (obtain.optInt("install_failed_check_ttmd5", 1) == 1) {
                int checkMd5Status = downloadInfo.checkMd5Status();
                try {
                    jSONObject.put("ttmd5_status", checkMd5Status);
                } catch (java.lang.Throwable unused) {
                }
                if (!com.ss.android.socialbase.downloader.utils.DownloadUtils.isMd5Valid(checkMd5Status)) {
                    return 2005;
                }
            }
            int i2 = this.v;
            if (i2 != 2000) {
                return i2;
            }
            if (obtain.optInt("install_failed_check_signature", 1) == 1 && com.ss.android.downloadlib.bt.vl.yl(com.ss.android.downloadlib.addownload.z.getContext(), wgVar.yl())) {
                if (!com.ss.android.downloadlib.bt.vl.vw(com.ss.android.downloadlib.bt.vl.x(com.ss.android.downloadlib.addownload.z.getContext(), downloadInfo.getTargetFilePath()), com.ss.android.downloadlib.bt.vl.o(com.ss.android.downloadlib.addownload.z.getContext(), wgVar.yl()))) {
                    return 2006;
                }
            }
            if (!z) {
                return 2002;
            }
            long j = this.yl;
            long j2 = this.t;
            if (j <= j2) {
                return 2000;
            }
            try {
                jSONObject.put("install_time", j - j2);
                if (wgVar.wy() <= this.t) {
                    i = 0;
                }
                jSONObject.put("install_again", i);
            } catch (java.lang.Throwable unused2) {
            }
            return !z2 ? 2003 : 2004;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void wg() {
            this.yl = java.lang.System.currentTimeMillis();
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (vw()) {
                    com.ss.android.downloadlib.vw.vw().vw(this.vw, this.wg);
                }
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:16:0x0064, code lost:
        
            if (r9 < r1) goto L21;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean vw() {
            com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo;
            double d;
            org.json.JSONObject jSONObject;
            com.ss.android.downloadad.api.vw.wg v = com.ss.android.downloadlib.addownload.wg.kz.vw().v(this.vw);
            boolean z = false;
            if (v == null || com.ss.android.downloadlib.bt.vl.wg(v) || v.t.get() || (downloadInfo = com.ss.android.socialbase.downloader.downloader.Downloader.getInstance(com.ss.android.downloadlib.addownload.z.getContext()).getDownloadInfo(v.tq())) == null) {
                return false;
            }
            long mi = v.mi();
            long vw = com.ss.android.downloadlib.bt.vl.vw(android.os.Environment.getDataDirectory());
            long min = java.lang.Math.min(524288000L, vw / 10);
            long totalBytes = downloadInfo.getTotalBytes();
            double d2 = totalBytes;
            double d3 = min + (2.5d * d2);
            if (mi <= -1 || totalBytes <= -1) {
                d = d2;
            } else {
                d = d2;
            }
            z = true;
            boolean vw2 = com.ss.android.socialbase.appdownloader.wg.vw(com.ss.android.downloadlib.addownload.z.getContext());
            org.json.JSONObject jSONObject2 = new org.json.JSONObject();
            int vw3 = vw(z, v, downloadInfo, vw2, jSONObject2);
            this.v = vw3;
            try {
                jSONObject = jSONObject2;
            } catch (java.lang.Exception e) {
                e = e;
                jSONObject = jSONObject2;
            }
            try {
                jSONObject.putOpt("fail_status", java.lang.Integer.valueOf(vw3));
                jSONObject.putOpt("available_space", java.lang.Long.valueOf(mi / 1048576));
                jSONObject.putOpt("total_space", java.lang.Long.valueOf(vw / 1048576));
                if (totalBytes > 0) {
                    jSONObject.putOpt(com.qq.e.ads.nativ.NativeUnifiedADAppInfoImpl.Keys.PACKAGE_SIZE, java.lang.Long.valueOf(totalBytes / 1048576));
                }
                jSONObject.putOpt("space_enough", java.lang.Integer.valueOf(z ? 1 : 2));
                if (mi > 0 && totalBytes > 0) {
                    jSONObject.put("available_space_ratio", mi / d);
                }
                jSONObject.putOpt("permission_unknown_source_install", java.lang.Integer.valueOf(vw2 ? 1 : 2));
                jSONObject.put("is_update_download", v.ih() ? 1 : 2);
            } catch (java.lang.Exception e2) {
                e = e2;
                e.printStackTrace();
                com.ss.android.downloadlib.v.vw.vw().wg("install_failed", jSONObject, v);
                return true;
            }
            com.ss.android.downloadlib.v.vw.vw().wg("install_failed", jSONObject, v);
            return true;
        }
    }

    private vw() {
        com.ss.android.socialbase.appdownloader.wg.vw(this);
        com.ss.android.socialbase.downloader.common.AppStatusManager.getInstance().registerAppSwitchListener(this);
    }

    public static java.lang.String t(@androidx.annotation.NonNull com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo, @androidx.annotation.NonNull com.ss.android.downloadad.api.vw.wg wgVar) {
        java.io.File file = new java.io.File(downloadInfo.getSavePath(), downloadInfo.getName());
        java.lang.String str = null;
        if (file.exists()) {
            try {
                android.content.pm.PackageInfo packageArchiveInfo = com.ss.android.downloadlib.addownload.z.getContext().getPackageManager().getPackageArchiveInfo(file.getAbsolutePath(), com.ss.android.socialbase.appdownloader.t.vw());
                if (packageArchiveInfo != null) {
                    str = packageArchiveInfo.packageName;
                }
            } catch (java.lang.Exception e) {
                e.printStackTrace();
            }
        }
        if (android.text.TextUtils.isEmpty(str) || str.equals(downloadInfo.getPackageName())) {
            return downloadInfo.getPackageName();
        }
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            jSONObject.put("real_package_name", str);
            jSONObject.put("input_package_name", downloadInfo.getPackageName());
        } catch (org.json.JSONException e2) {
            e2.printStackTrace();
        }
        com.ss.android.downloadlib.v.vw.vw().vw("embeded_ad", "package_name_error", jSONObject, wgVar);
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @androidx.annotation.WorkerThread
    public void t(com.ss.android.downloadad.api.vw.wg wgVar) {
        android.os.SystemClock.sleep(com.google.android.exoplayer2.audio.SilenceSkippingAudioProcessor.DEFAULT_PADDING_SILENCE_US);
        int i = 15;
        while (i > 0) {
            if (com.ss.android.downloadlib.bt.vl.wg(wgVar)) {
                vw(wgVar.yl());
                return;
            }
            i--;
            if (i == 0) {
                return;
            } else {
                android.os.SystemClock.sleep(com.google.android.exoplayer2.audio.SilenceSkippingAudioProcessor.DEFAULT_PADDING_SILENCE_US);
            }
        }
    }

    private int v(com.ss.android.downloadad.api.vw.wg wgVar) {
        int realStatus;
        double optDouble = com.ss.android.socialbase.downloader.setting.DownloadSetting.obtain(wgVar.tq()).optDouble("download_failed_finally_hours", 48.0d);
        if (optDouble <= 0.0d) {
            return -1;
        }
        if (java.lang.System.currentTimeMillis() - wgVar.e() < optDouble * 60.0d * 60.0d * 1000.0d) {
            return 1;
        }
        if (wgVar.v.get()) {
            return 0;
        }
        com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo = com.ss.android.socialbase.downloader.downloader.Downloader.getInstance(com.ss.android.downloadlib.addownload.z.getContext()).getDownloadInfo(wgVar.tq());
        if (downloadInfo == null || (realStatus = downloadInfo.getRealStatus()) == -3 || realStatus == -4) {
            return -1;
        }
        if (!com.ss.android.socialbase.downloader.constants.DownloadStatus.isDownloading(realStatus) && wgVar.v.compareAndSet(false, true)) {
            try {
                org.json.JSONObject jSONObject = new org.json.JSONObject();
                vw(jSONObject, downloadInfo);
                jSONObject.putOpt(com.ss.android.socialbase.downloader.constants.MonitorConstants.EXTRA_DOWNLOAD_STATUS, java.lang.Integer.valueOf(realStatus));
                jSONObject.putOpt("fail_status", java.lang.Integer.valueOf(wgVar.up()));
                jSONObject.putOpt("fail_msg", wgVar.tv());
                jSONObject.put("download_failed_times", wgVar.iq());
                if (downloadInfo.getTotalBytes() > 0) {
                    jSONObject.put("download_percent", downloadInfo.getCurBytes() / downloadInfo.getTotalBytes());
                }
                jSONObject.put("is_update_download", wgVar.ih() ? 1 : 2);
                com.ss.android.downloadlib.v.vw.vw().vw(wgVar.es(), "download_failed_finally", jSONObject, wgVar);
                com.ss.android.downloadlib.addownload.wg.x.vw().vw(wgVar);
                return 0;
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
        }
        return 1;
    }

    private int vw(com.ss.android.downloadad.api.vw.wg wgVar, com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo, java.lang.String str, org.json.JSONObject jSONObject) {
        int wg2 = com.ss.android.socialbase.appdownloader.t.wg(com.ss.android.downloadlib.addownload.z.getContext(), downloadInfo);
        int wg3 = com.ss.android.downloadlib.bt.vl.wg(com.ss.android.downloadlib.addownload.z.getContext(), str);
        if (wg2 > 0 && wg3 > 0 && wg2 != wg3) {
            return wg3 > wg2 ? 3011 : 3010;
        }
        if (com.ss.android.socialbase.downloader.setting.DownloadSetting.obtain(wgVar.tq()).optInt("install_finish_check_ttmd5", 1) != 1) {
            return 3001;
        }
        java.lang.String string = com.ss.android.downloadlib.addownload.z.getContext().getSharedPreferences("sp_ttdownloader_md5", 0).getString(java.lang.String.valueOf(wgVar.wg()), null);
        if (android.text.TextUtils.isEmpty(string) && downloadInfo != null) {
            string = com.ss.android.downloadlib.bt.vw.vw(downloadInfo.getTargetFilePath());
        }
        int vw2 = com.ss.android.downloadlib.bt.vw.vw(string, com.ss.android.downloadlib.bt.vw.wg(str));
        try {
            jSONObject.put("ttmd5_status", vw2);
        } catch (java.lang.Throwable unused) {
        }
        if (vw2 == 0) {
            return 3000;
        }
        return vw2 == 1 ? 3002 : 3001;
    }

    public static com.ss.android.downloadlib.vw vw() {
        if (v == null) {
            synchronized (com.ss.android.downloadlib.vw.class) {
                if (v == null) {
                    v = new com.ss.android.downloadlib.vw();
                }
            }
        }
        return v;
    }

    private static com.ss.android.socialbase.downloader.model.DownloadInfo vw(java.util.List<com.ss.android.socialbase.downloader.model.DownloadInfo> list, java.lang.String str) {
        if (list != null && !list.isEmpty() && !android.text.TextUtils.isEmpty(str)) {
            for (com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo : list) {
                if (downloadInfo != null) {
                    if (str.equals(downloadInfo.getPackageName())) {
                        return downloadInfo;
                    }
                    if (com.ss.android.downloadlib.bt.vl.vw(com.ss.android.downloadlib.addownload.z.getContext(), downloadInfo.getTargetFilePath(), str)) {
                        return downloadInfo;
                    }
                }
            }
        }
        return null;
    }

    private org.json.JSONObject vw(com.ss.android.downloadad.api.vw.wg wgVar, java.lang.String str, int i) {
        com.ss.android.socialbase.appdownloader.vw vw2;
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo = com.ss.android.socialbase.downloader.downloader.Downloader.getInstance(com.ss.android.downloadlib.addownload.z.getContext()).getDownloadInfo(wgVar.tq());
            jSONObject.putOpt(com.umeng.ccg.a.j, java.lang.Integer.valueOf(i));
            com.ss.android.downloadlib.bt.kz.vw(jSONObject, wgVar.tq());
            com.ss.android.downloadlib.bt.kz.vw(wgVar, jSONObject);
            jSONObject.put("is_update_download", wgVar.ih() ? 1 : 2);
            jSONObject.put("install_after_back_app", wgVar.ip() ? 1 : 2);
            jSONObject.putOpt("clean_space_install_params", wgVar.g() ? "1" : "2");
            if (downloadInfo != null) {
                vw(jSONObject, downloadInfo);
                try {
                    jSONObject.put("uninstall_resume_count", downloadInfo.getUninstallResumeCount());
                    if (wgVar.wy() > 0) {
                        long currentTimeMillis = java.lang.System.currentTimeMillis() - wgVar.wy();
                        jSONObject.put("install_time", currentTimeMillis);
                        if (currentTimeMillis > com.ss.android.socialbase.downloader.setting.DownloadSetting.obtain(downloadInfo.getId()).optLong("check_install_finish_expired_duration", 86400000L)) {
                            jSONObject.put("install_expired", 1);
                        } else {
                            jSONObject.put("install_expired", 0);
                        }
                    }
                } catch (java.lang.Throwable unused) {
                }
                java.lang.String string = com.ss.android.socialbase.downloader.utils.DownloadUtils.getString(downloadInfo.getTempCacheData().get("ah_attempt"), null);
                if (!android.text.TextUtils.isEmpty(string) && (vw2 = com.ss.android.socialbase.appdownloader.vw.vw(string)) != null) {
                    vw2.vw(jSONObject);
                }
            }
            int vw3 = vw(wgVar, downloadInfo, str, jSONObject);
            jSONObject.put("fail_status", vw3);
            if (vw3 == 3000) {
                jSONObject.put("hijack", 2);
            } else if (vw3 == 3001) {
                jSONObject.put("hijack", 0);
            } else {
                jSONObject.put("hijack", 1);
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
        return jSONObject;
    }

    public static org.json.JSONObject vw(org.json.JSONObject jSONObject, com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) {
        if (jSONObject != null && downloadInfo != null) {
            int i = 1;
            if (com.ss.android.socialbase.downloader.setting.DownloadSetting.obtain(downloadInfo.getId()).optInt("download_event_opt", 1) == 0) {
                return jSONObject;
            }
            try {
                jSONObject.put(com.ss.android.socialbase.downloader.constants.MonitorConstants.EXTRA_DOWNLOAD_ID, downloadInfo.getId());
                jSONObject.put("name", downloadInfo.getName());
                jSONObject.put(com.ss.android.socialbase.downloader.constants.MonitorConstants.EXTRA_DOWNLOAD_CUR_BYTES, downloadInfo.getCurBytes());
                jSONObject.put(com.ss.android.socialbase.downloader.constants.MonitorConstants.EXTRA_DOWNLOAD_TOTAL_BYTES, downloadInfo.getTotalBytes());
                jSONObject.put(com.ss.android.socialbase.downloader.constants.MonitorConstants.EXTRA_DOWNLOAD_NETWORK_QUALITY, downloadInfo.getNetworkQuality());
                jSONObject.put(com.ss.android.socialbase.downloader.constants.MonitorConstants.EXTRA_CUR_NETWORK_QUALITY, com.ss.android.socialbase.downloader.network.NetTrafficManager.getInstance().getCurrentNetworkQuality().name());
                jSONObject.put(com.ss.android.socialbase.downloader.constants.MonitorConstants.EXTRA_DOWNLOAD_ONLY_WIFI, downloadInfo.isOnlyWifi() ? 1 : 0);
                jSONObject.put(com.ss.android.socialbase.downloader.constants.MonitorConstants.EXTRA_DOWNLOAD_NEED_HTTPS_DEGRADE, downloadInfo.isNeedHttpsToHttpRetry() ? 1 : 0);
                jSONObject.put(com.ss.android.socialbase.downloader.constants.MonitorConstants.EXTRA_DOWNLOAD_HTTPS_DEGRADE_RETRY_USED, downloadInfo.isHttpsToHttpRetryUsed() ? 1 : 0);
                jSONObject.put(com.ss.android.socialbase.downloader.constants.MonitorConstants.EXTRA_DOWNLOAD_CHUNK_COUNT, downloadInfo.getChunkCount());
                jSONObject.put("retry_count", downloadInfo.getRetryCount());
                jSONObject.put(com.ss.android.socialbase.downloader.constants.MonitorConstants.EXTRA_DOWNLOAD_CUR_RETRY_TIME, downloadInfo.getCurRetryTime());
                jSONObject.put(com.ss.android.socialbase.downloader.constants.MonitorConstants.EXTRA_DOWNLOAD_NEED_RETRY_DELAY, downloadInfo.isNeedRetryDelay() ? 1 : 0);
                jSONObject.put(com.ss.android.socialbase.downloader.constants.MonitorConstants.EXTRA_DOWNLOAD_BACKUP_URL_USED, downloadInfo.isBackUpUrlUsed() ? 1 : 0);
                jSONObject.put(com.ss.android.socialbase.downloader.constants.MonitorConstants.EXTRA_DOWNLOAD_HEAD_CONNECTION_ERROR_MSG, downloadInfo.getHeadConnectionException() != null ? downloadInfo.getHeadConnectionException() : "");
                jSONObject.put(com.ss.android.socialbase.downloader.constants.MonitorConstants.EXTRA_DOWNLOAD_NEED_INDEPENDENT_PROCESS, downloadInfo.isNeedIndependentProcess() ? 1 : 0);
                jSONObject.put(com.ss.android.socialbase.downloader.constants.MonitorConstants.EXTRA_TOTAL_RETRY_COUNT, downloadInfo.getTotalRetryCount());
                jSONObject.put(com.ss.android.socialbase.downloader.constants.MonitorConstants.EXTRA_CUR_RETRY_TIME_IN_TOTAL, downloadInfo.getCurRetryTimeInTotal());
                jSONObject.put(com.ss.android.socialbase.downloader.constants.MonitorConstants.EXTRA_REAL_DOWNLOAD_TIME, downloadInfo.getRealDownloadTime());
                jSONObject.put("first_speed_time", downloadInfo.getFirstSpeedTime());
                jSONObject.put("all_connect_time", downloadInfo.getAllConnectTime());
                jSONObject.put("download_prepare_time", downloadInfo.getDownloadPrepareTime());
                jSONObject.put(com.ss.android.socialbase.downloader.constants.MonitorConstants.EXTRA_DOWNLOAD_TIME, downloadInfo.getRealDownloadTime() + downloadInfo.getAllConnectTime() + downloadInfo.getDownloadPrepareTime());
                jSONObject.put(com.ss.android.socialbase.downloader.constants.MonitorConstants.EXTRA_CHUNK_DOWNGRADE_UESD, downloadInfo.isChunkDowngradeRetryUsed() ? 1 : 0);
                jSONObject.put(com.ss.android.socialbase.downloader.constants.MonitorConstants.EXTRA_NEED_CHUNK_DOWNGRADE_RETRY, downloadInfo.isNeedChunkDowngradeRetry() ? 1 : 0);
                jSONObject.put("failed_resume_count", downloadInfo.getFailedResumeCount());
                jSONObject.put(com.ss.android.socialbase.downloader.constants.MonitorConstants.EXTRA_PRECONNECT_LEVEL, downloadInfo.getPreconnectLevel());
                jSONObject.put("md5", downloadInfo.getMd5());
                jSONObject.put("expect_file_length", downloadInfo.getExpectFileLength());
                jSONObject.put("retry_schedule_count", downloadInfo.getRetryScheduleCount());
                jSONObject.put("rw_concurrent", downloadInfo.isRwConcurrent() ? 1 : 0);
                double curBytes = downloadInfo.getCurBytes() / 1048576.0d;
                double realDownloadTime = downloadInfo.getRealDownloadTime() / 1000.0d;
                if (curBytes > 0.0d && realDownloadTime > 0.0d) {
                    double d = curBytes / realDownloadTime;
                    try {
                        jSONObject.put(com.ss.android.socialbase.downloader.constants.MonitorConstants.DOWNLOAD_SPEED, d);
                    } catch (java.lang.Exception unused) {
                    }
                    com.ss.android.socialbase.downloader.logger.Logger.d(vw, "download speed : " + d + "MB/s");
                }
                try {
                    jSONObject.put("is_download_service_foreground", com.ss.android.socialbase.downloader.downloader.Downloader.getInstance(com.ss.android.downloadlib.addownload.z.getContext()).isDownloadServiceForeground(downloadInfo.getId()) ? 1 : 0);
                } catch (java.lang.Exception e) {
                    e.printStackTrace();
                }
                if (downloadInfo.getBackUpUrls() != null) {
                    jSONObject.put(com.ss.android.socialbase.downloader.constants.MonitorConstants.EXTRA_DOWNLOAD_BACKUP_URL_COUNT, downloadInfo.getBackUpUrls().size());
                    jSONObject.put(com.ss.android.socialbase.downloader.constants.MonitorConstants.EXTRA_DOWNLOAD_CUR_BACKUP_URL_INDEX, downloadInfo.getCurBackUpUrlIndex());
                }
                jSONObject.put("clear_space_restart_times", com.ss.android.downloadlib.addownload.t.v.vw().wg(downloadInfo.getUrl()));
                jSONObject.put("mime_type", downloadInfo.getMimeType());
                if (!com.ss.android.socialbase.downloader.utils.DownloadUtils.isNetworkConnected(com.ss.android.downloadlib.addownload.z.getContext())) {
                    i = 2;
                }
                jSONObject.put("network_available", i);
                jSONObject.put(com.ss.android.socialbase.downloader.constants.MonitorConstants.STATUS_CODE, downloadInfo.getHttpStatusCode());
                wg(jSONObject, downloadInfo);
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
        }
        return jSONObject;
    }

    @androidx.annotation.WorkerThread
    public static synchronized void vw(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo, com.ss.android.downloadad.api.vw.wg wgVar) {
        synchronized (com.ss.android.downloadlib.vw.class) {
            if (downloadInfo == null) {
                com.ss.android.downloadlib.yl.t.vw().vw("onDownloadFinish info null");
                return;
            }
            if (wgVar == null) {
                com.ss.android.downloadlib.yl.t.vw().vw("onDownloadFinish nativeModel null");
                return;
            }
            if (wgVar.aq() != 1) {
                return;
            }
            com.ss.android.downloadlib.t.o.vw().v(wgVar);
            java.lang.String t2 = t(downloadInfo, wgVar);
            com.ss.android.downloadlib.addownload.wg.kz.vw().wg(downloadInfo.getUrl(), t2);
            java.util.Map<java.lang.Long, com.ss.android.downloadad.api.vw.wg> vw2 = com.ss.android.downloadlib.addownload.wg.kz.vw().vw(downloadInfo.getUrl(), t2);
            wgVar.kz(java.lang.System.currentTimeMillis());
            wgVar.yl(2);
            wgVar.wg(t2);
            vw2.put(java.lang.Long.valueOf(wgVar.wg()), wgVar);
            com.ss.android.downloadlib.addownload.wg.x.vw().vw(vw2.values());
            wg(wgVar);
            com.ss.android.downloadlib.bt.vw().vw(downloadInfo, t2);
            if ("application/vnd.android.package-archive".equals(downloadInfo.getMimeType())) {
                vw().vw(wgVar);
                vw().wg(downloadInfo, wgVar);
                if (wgVar.kk()) {
                    com.ss.android.downloadlib.addownload.vw.vw.vw().vw(downloadInfo.getId(), wgVar.wg(), wgVar.vl(), t2, downloadInfo.getTitle(), wgVar.v(), downloadInfo.getTargetFilePath());
                }
                wgVar.wg();
                wgVar.v();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @androidx.annotation.WorkerThread
    public void vw(@androidx.annotation.NonNull java.util.concurrent.ConcurrentHashMap<java.lang.Long, com.ss.android.downloadad.api.vw.wg> concurrentHashMap, int i) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        long currentTimeMillis = java.lang.System.currentTimeMillis();
        for (com.ss.android.downloadad.api.vw.wg wgVar : concurrentHashMap.values()) {
            if (wgVar.t.get()) {
                if (currentTimeMillis - wgVar.e() >= com.ss.android.socialbase.downloader.setting.DownloadSetting.obtain(wgVar.tq()).optInt("start_event_expire_hours", 168) * 60 * 60 * 1000) {
                    arrayList.add(java.lang.Long.valueOf(wgVar.wg()));
                }
            } else if (wgVar.aq() == 1) {
                if (v(wgVar) <= 0 && currentTimeMillis - wgVar.e() >= com.ss.android.socialbase.downloader.setting.DownloadSetting.obtain(wgVar.tq()).optInt("start_event_expire_hours", 168) * 60 * 60 * 1000) {
                    arrayList.add(java.lang.Long.valueOf(wgVar.wg()));
                }
            } else if (wgVar.aq() != 2) {
                arrayList.add(java.lang.Long.valueOf(wgVar.wg()));
            } else if (!wgVar.ki()) {
                if (com.ss.android.downloadlib.bt.vl.wg(wgVar)) {
                    if (wgVar.lb() == 4) {
                        i = wgVar.lb();
                    }
                    com.ss.android.downloadlib.v.vw.vw().vw(vw(wgVar, wgVar.yl(), i), wgVar);
                    arrayList.add(java.lang.Long.valueOf(wgVar.wg()));
                    com.ss.android.downloadlib.addownload.t.v.vw(wgVar);
                } else if (currentTimeMillis - wgVar.e() >= com.ss.android.socialbase.downloader.setting.DownloadSetting.obtain(wgVar.tq()).optInt("finish_event_expire_hours", 168) * 60 * 60 * 1000) {
                    arrayList.add(java.lang.Long.valueOf(wgVar.wg()));
                } else if (android.text.TextUtils.isEmpty(wgVar.yl())) {
                    arrayList.add(java.lang.Long.valueOf(wgVar.wg()));
                }
            }
        }
        com.ss.android.downloadlib.addownload.wg.kz.vw().vw(arrayList);
    }

    private org.json.JSONObject wg(@androidx.annotation.NonNull com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo, com.ss.android.socialbase.appdownloader.vw vwVar) {
        com.ss.android.downloadad.api.vw.wg vw2 = com.ss.android.downloadlib.addownload.wg.kz.vw().vw(downloadInfo);
        if (vw2 == null) {
            return null;
        }
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        vwVar.vw(jSONObject);
        try {
            jSONObject.put(com.ss.android.socialbase.downloader.constants.MonitorConstants.EXTRA_DOWNLOAD_ID, downloadInfo.getId());
            jSONObject.put("name", downloadInfo.getName());
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
        com.ss.android.downloadlib.bt.kz.vw(jSONObject, downloadInfo.getId());
        com.ss.android.downloadlib.v.vw.vw().vw("embeded_ad", "ah_result", jSONObject, vw2);
        return jSONObject;
    }

    public static org.json.JSONObject wg(org.json.JSONObject jSONObject, com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) {
        if (jSONObject == null || downloadInfo == null || com.ss.android.socialbase.downloader.setting.DownloadSetting.obtain(downloadInfo.getId()).optInt("download_event_opt", 1) == 0) {
            return jSONObject;
        }
        try {
            long wg2 = com.ss.android.downloadlib.bt.vl.wg(0L);
            double d = wg2;
            jSONObject.put("available_space", d / 1048576.0d);
            long totalBytes = downloadInfo.getTotalBytes();
            double d2 = totalBytes;
            jSONObject.put("apk_size", d2 / 1048576.0d);
            if (wg2 > 0 && totalBytes > 0) {
                jSONObject.put("available_space_ratio", d / d2);
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
        return jSONObject;
    }

    private static void wg(com.ss.android.downloadad.api.vw.wg wgVar) {
        if (wgVar == null) {
            return;
        }
        java.lang.String s2 = android.text.TextUtils.isEmpty(wgVar.s()) ? "" : wgVar.s();
        com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo = com.ss.android.socialbase.downloader.downloader.Downloader.getInstance(com.ss.android.downloadlib.addownload.z.getContext()).getDownloadInfo(wgVar.tq());
        wgVar.vl("");
        com.ss.android.downloadlib.addownload.wg.x.vw().vw(wgVar);
        org.json.JSONObject vw2 = vw(new org.json.JSONObject(), downloadInfo);
        int i = 1;
        try {
            vw2.putOpt("finish_reason", s2);
            vw2.putOpt("finish_from_reserve_wifi", java.lang.Integer.valueOf(downloadInfo.isDownloadFromReserveWifi() ? 1 : 0));
        } catch (org.json.JSONException e) {
            e.printStackTrace();
        }
        com.ss.android.downloadad.api.vw.wg vw3 = com.ss.android.downloadlib.addownload.wg.kz.vw().vw(downloadInfo);
        com.ss.android.downloadlib.bt.kz.vw(vw2, downloadInfo.getId());
        try {
            vw2.put("download_failed_times", vw3.iq());
            vw2.put("can_show_notification", com.ss.android.socialbase.appdownloader.yl.v.vw() ? 1 : 2);
            if (downloadInfo.getExpectFileLength() > 0 && downloadInfo.getTotalBytes() > 0) {
                vw2.put("file_length_gap", downloadInfo.getExpectFileLength() - downloadInfo.getTotalBytes());
            }
            vw2.put("ttmd5_status", downloadInfo.getTTMd5CheckStatus());
            vw2.put("has_send_download_failed_finally", vw3.v.get() ? 1 : 2);
            if (!vw3.ih()) {
                i = 2;
            }
            vw2.put("is_update_download", i);
            com.ss.android.downloadlib.bt.kz.vw(vw3, vw2);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
        com.ss.android.downloadlib.v.vw.vw().wg(com.aliyun.svideo.editor.effectmanager.MorePasterAdapter.DOWNLOAD_FINISH, vw2, wgVar);
    }

    @Override // com.ss.android.socialbase.downloader.common.AppStatusManager.AppStatusChangeListener
    public void onAppBackground() {
        com.ss.android.socialbase.downloader.logger.Logger.d(vw, "onAppBackground()");
        vw(6);
    }

    @Override // com.ss.android.socialbase.downloader.common.AppStatusManager.AppStatusChangeListener
    public void onAppForeground() {
        com.ss.android.socialbase.downloader.logger.Logger.d(vw, "onAppForeground()");
        wg();
        vw(5);
    }

    @Override // com.ss.android.socialbase.downloader.depend.IOpenInstallerListener
    public void onOpenInstaller(@androidx.annotation.Nullable com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo, @androidx.annotation.Nullable java.lang.String str) {
        if (downloadInfo == null) {
            com.ss.android.downloadlib.yl.t.vw().vw("info is null");
        } else if ((com.ss.android.socialbase.downloader.setting.DownloadSetting.obtain(downloadInfo).optInt("check_applink_mode") & 2) != 0) {
            com.ss.android.downloadlib.wg.yl.vw().wg(new com.ss.android.downloadlib.vw.AnonymousClass4(downloadInfo, (org.json.JSONObject) downloadInfo.getTempCacheData().get("ah_ext_json")));
        }
    }

    @Override // com.ss.android.downloadad.api.vw
    public void vw(int i) {
        long currentTimeMillis = java.lang.System.currentTimeMillis();
        if (currentTimeMillis - this.wg < com.igexin.push.config.c.l) {
            return;
        }
        com.ss.android.downloadlib.v.vw().vw(new com.ss.android.downloadlib.vw.RunnableC0475vw(i), this.wg > 0 ? 2000L : 8000L);
        this.wg = currentTimeMillis;
    }

    public void vw(long j) {
        com.ss.android.downloadlib.addownload.wg.v.vw vw2;
        int i;
        try {
            com.ss.android.downloadad.api.vw.wg v2 = com.ss.android.downloadlib.addownload.wg.kz.vw().v(j);
            if (v2 != null && !com.ss.android.downloadlib.bt.vl.wg(v2) && !v2.t.get()) {
                android.util.Pair<com.ss.android.downloadlib.addownload.wg.v.vw, java.lang.Integer> wg2 = com.ss.android.downloadlib.addownload.wg.v.vw().wg(v2);
                if (wg2 != null) {
                    vw2 = (com.ss.android.downloadlib.addownload.wg.v.vw) wg2.first;
                    i = ((java.lang.Integer) wg2.second).intValue();
                } else {
                    vw2 = com.ss.android.downloadlib.addownload.wg.v.vw().vw(v2);
                    i = -1;
                }
                if (vw2 == null) {
                    return;
                }
                com.ss.android.downloadlib.addownload.wg.v.vw().wg(vw2.vw);
                org.json.JSONObject jSONObject = new org.json.JSONObject();
                jSONObject.put("installed_app_name", vw2.v);
                jSONObject.put("installed_pkg_name", vw2.vw);
                if (i == -1) {
                    com.ss.android.downloadlib.v.vw.vw().wg("install_finish_may_hijack", jSONObject, v2);
                    return;
                }
                jSONObject.put("error_code", i);
                com.ss.android.downloadlib.bt.kz.vw(jSONObject, v2.tq());
                com.ss.android.downloadlib.v.vw.vw().wg("install_finish_hijack", jSONObject, v2);
            }
        } catch (java.lang.Throwable th) {
            com.ss.android.downloadlib.yl.t.vw().vw(th, "trySendInstallFinishHijack");
        }
    }

    public void vw(long j, int i) {
        long optLong = com.ss.android.socialbase.downloader.setting.DownloadSetting.obtain(i).optLong("check_install_finish_hijack_delay_time", com.heytap.mcssdk.constant.a.h);
        if (optLong < 0) {
            return;
        }
        com.ss.android.downloadlib.v.vw().vw(new com.ss.android.downloadlib.vw.AnonymousClass2(j), java.lang.Math.max(optLong, 300000L));
    }

    public void vw(com.ss.android.downloadad.api.vw.wg wgVar) {
        com.ss.android.downloadlib.v.vw().vw(new com.ss.android.downloadlib.vw.t(wgVar));
    }

    public void vw(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo, long j, long j2, long j3, long j4, long j5, boolean z) {
        com.ss.android.downloadad.api.vw.wg vw2 = com.ss.android.downloadlib.addownload.wg.kz.vw().vw(downloadInfo);
        if (vw2 == null) {
            com.ss.android.downloadlib.yl.t.vw().vw("trySendClearSpaceEvent nativeModel null");
            return;
        }
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            jSONObject.putOpt("space_before", java.lang.Double.valueOf(j / 1048576.0d));
            jSONObject.putOpt("space_cleaned", java.lang.Double.valueOf((j2 - j) / 1048576.0d));
            jSONObject.putOpt("clean_up_time_cost", java.lang.Long.valueOf(j4));
            jSONObject.putOpt("is_download_restarted", java.lang.Integer.valueOf(z ? 1 : 0));
            jSONObject.putOpt("byte_required", java.lang.Long.valueOf(j3));
            jSONObject.putOpt("byte_required_after", java.lang.Double.valueOf((j3 - j2) / 1048576.0d));
            jSONObject.putOpt("clear_sleep_time", java.lang.Long.valueOf(j5));
            com.ss.android.downloadlib.bt.kz.t(downloadInfo, jSONObject);
            com.ss.android.downloadlib.v.vw.vw().vw("cleanup", jSONObject, vw2);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    public void vw(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo, com.ss.android.downloadad.api.vw.wg wgVar, int i) {
        long max;
        if (downloadInfo == null || wgVar == null) {
            return;
        }
        wg();
        long currentTimeMillis = java.lang.System.currentTimeMillis();
        wgVar.wg(currentTimeMillis);
        wgVar.bt(com.ss.android.downloadlib.bt.vl.vw(android.os.Environment.getDataDirectory(), -1L));
        if (i != 2000) {
            max = 2000;
        } else {
            long optLong = com.ss.android.socialbase.downloader.setting.DownloadSetting.obtain(downloadInfo.getId()).optLong("check_install_failed_delay_time", com.igexin.push.config.c.l);
            if (optLong < 0) {
                return;
            } else {
                max = java.lang.Math.max(optLong, 30000L);
            }
        }
        long j = max;
        com.ss.android.downloadlib.vw.wg wgVar2 = new com.ss.android.downloadlib.vw.wg(wgVar.wg(), downloadInfo.getId(), currentTimeMillis, i, null);
        com.ss.android.downloadlib.v.vw().vw(wgVar2, j);
        this.t = wgVar2;
        com.ss.android.downloadlib.addownload.wg.x.vw().vw(wgVar);
    }

    @Override // com.ss.android.socialbase.appdownloader.wg.t
    public void vw(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo, com.ss.android.socialbase.appdownloader.vw vwVar) {
        org.json.JSONObject wg2;
        if (downloadInfo == null || vwVar == null) {
            return;
        }
        org.json.JSONArray optJSONArray = com.ss.android.socialbase.downloader.setting.DownloadSetting.obtain(downloadInfo.getId()).optJSONArray("ah_report_config");
        if (vwVar.wg != 0) {
            downloadInfo.getTempCacheData().remove(com.huawei.hms.support.api.entity.core.CommonCode.Resolution.HAS_RESOLUTION_FROM_APK);
        }
        if (optJSONArray == null || (wg2 = wg(downloadInfo, vwVar)) == null) {
            return;
        }
        downloadInfo.getTempCacheData().put("ah_ext_json", wg2);
    }

    @androidx.annotation.WorkerThread
    public synchronized void vw(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return;
        }
        if (com.ss.android.downloadlib.bt.vl.wg()) {
            throw new java.lang.RuntimeException("handleAppInstalled in main thread.");
        }
        com.ss.android.downloadad.api.vw.wg vw2 = com.ss.android.downloadlib.addownload.wg.kz.vw().vw(str);
        if (vw2 == null) {
            com.ss.android.downloadlib.addownload.wg.v.vw().vw(str);
            return;
        }
        com.ss.android.downloadlib.addownload.yl vw3 = com.ss.android.downloadlib.bt.vw().vw(vw2.vw());
        if (vw3 != null) {
            vw3.kz();
        }
        if (vw2.t.get()) {
            return;
        }
        if (com.ss.android.socialbase.downloader.setting.DownloadSetting.obtain(vw2.tq()).optInt("notification_opt_2") == 1) {
            com.ss.android.socialbase.downloader.notification.DownloadNotificationManager.getInstance().cancelNotification(vw2.tq());
        }
        new com.ss.android.downloadlib.wg.wg().vw(vw2, new com.ss.android.downloadlib.vw.AnonymousClass1(vw2, str), com.ss.android.downloadlib.bt.yl.vw(vw2).optInt("try_applink_delay_after_installed", 0));
        com.ss.android.downloadlib.t.o.vw().kz(vw2);
        vw(str, vw2);
        com.ss.android.downloadlib.addownload.vw.vw.vw().wg(str);
        com.ss.android.socialbase.downloader.model.DownloadInfo vw4 = vw((java.util.List<com.ss.android.socialbase.downloader.model.DownloadInfo>) com.ss.android.socialbase.downloader.downloader.Downloader.getInstance(com.ss.android.downloadlib.addownload.z.getContext()).getSuccessedDownloadInfosWithMimeType("application/vnd.android.package-archive"), str);
        if (vw4 == null) {
            com.ss.android.downloadlib.bt.vw().wg(null, str);
            return;
        }
        if (com.ss.android.socialbase.downloader.setting.DownloadSetting.obtain(vw4.getId()).optInt(com.ss.android.socialbase.downloader.setting.DownloadSettingKeys.NO_HIDE_NOTIFICATION) != 1) {
            com.ss.android.socialbase.downloader.notification.DownloadNotificationManager.getInstance().hideNotification(vw4.getId());
        }
        com.ss.android.downloadlib.bt.vw().wg(vw4, str);
        com.ss.android.downloadlib.addownload.t.v.vw(vw4);
    }

    public void vw(java.lang.String str, com.ss.android.downloadad.api.vw.wg wgVar) {
        if (wgVar != null && com.ss.android.downloadlib.bt.vl.wg(wgVar) && wgVar.t.compareAndSet(false, true)) {
            com.ss.android.downloadlib.v.vw.vw().vw(wgVar.es(), "install_finish", vw(wgVar, str, wgVar.lb() != 4 ? 3 : 4), wgVar);
            com.ss.android.downloadlib.addownload.wg.x.vw().vw(wgVar);
        }
    }

    public synchronized void wg() {
        com.ss.android.downloadlib.vw.wg wgVar = this.t;
        if (wgVar != null) {
            wgVar.wg();
            this.t = null;
        }
    }

    public void wg(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo, com.ss.android.downloadad.api.vw.wg wgVar) {
        if (downloadInfo == null || wgVar == null || com.ss.android.socialbase.downloader.setting.DownloadSetting.obtain(downloadInfo.getId()).optInt("install_finish_check_ttmd5", 1) == 0) {
            return;
        }
        java.lang.String targetFilePath = downloadInfo.getTargetFilePath();
        if (android.text.TextUtils.isEmpty(targetFilePath)) {
            return;
        }
        com.ss.android.downloadlib.v.vw().wg(new com.ss.android.downloadlib.vw.AnonymousClass3(targetFilePath, wgVar));
    }
}
