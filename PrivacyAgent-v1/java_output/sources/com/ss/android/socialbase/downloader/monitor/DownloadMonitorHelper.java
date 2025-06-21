package com.ss.android.socialbase.downloader.monitor;

/* loaded from: classes19.dex */
public class DownloadMonitorHelper {
    private static final java.lang.String DEFAULT_MONITOR_SCENE = "default";

    private static org.json.JSONObject getMonitorJson(java.lang.String str, com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo, com.ss.android.socialbase.downloader.exception.BaseException baseException, int i) {
        java.lang.String str2;
        java.lang.String str3;
        java.lang.String str4;
        int i2;
        java.lang.String str5;
        java.lang.String str6;
        java.lang.String str7;
        org.json.JSONObject jSONObject = null;
        try {
            org.json.JSONObject jSONObject2 = new org.json.JSONObject();
            try {
                com.ss.android.socialbase.downloader.downloader.IMonitorConfig monitorConfig = com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getMonitorConfig();
                if (monitorConfig != null) {
                    str2 = monitorConfig.getDeviceId();
                    str3 = parseDevicePostfix(str2);
                    str4 = monitorConfig.getAppId();
                    i2 = monitorConfig.getUpdateVersion();
                } else {
                    str2 = "";
                    str3 = str2;
                    str4 = str3;
                    i2 = 0;
                }
                java.lang.String requestLog = (baseException == null || !(baseException instanceof com.ss.android.socialbase.downloader.exception.DownloadTTNetException)) ? "" : ((com.ss.android.socialbase.downloader.exception.DownloadTTNetException) baseException).getRequestLog();
                jSONObject2.put(com.ss.android.socialbase.downloader.constants.MonitorConstants.EXTRA_DOWNLOAD_PAGE, str);
                jSONObject2.put("app_id", str4);
                jSONObject2.put("device_id", str2);
                jSONObject2.put(com.ss.android.socialbase.downloader.constants.MonitorConstants.EXTRA_DEVICE_ID_POSTFIX, str3);
                jSONObject2.put("update_version", i2);
                jSONObject2.put(com.ss.android.socialbase.downloader.constants.MonitorConstants.EXTRA_DOWNLOAD_STATUS, i);
                if (downloadInfo != null) {
                    jSONObject2.put(com.ss.android.socialbase.downloader.setting.DownloadSettingKeys.SETTING_TAG, com.ss.android.socialbase.downloader.setting.DownloadSetting.obtain(downloadInfo.getId()).optString(com.ss.android.socialbase.downloader.setting.DownloadSettingKeys.SETTING_TAG));
                    jSONObject2.put(com.ss.android.socialbase.downloader.constants.MonitorConstants.EXTRA_DOWNLOAD_ID, downloadInfo.getId());
                    jSONObject2.put("name", downloadInfo.getName());
                    jSONObject2.put("url", downloadInfo.getUrl());
                    jSONObject2.put(com.ss.android.socialbase.downloader.constants.MonitorConstants.EXTRA_DOWNLOAD_SAVE_PATH, downloadInfo.getSavePath());
                    jSONObject2.put(com.ss.android.socialbase.downloader.constants.MonitorConstants.EXTRA_DOWNLOAD_TIME, downloadInfo.getDownloadTime());
                    jSONObject2.put(com.ss.android.socialbase.downloader.constants.MonitorConstants.EXTRA_DOWNLOAD_CUR_BYTES, downloadInfo.getCurBytes());
                    jSONObject2.put(com.ss.android.socialbase.downloader.constants.MonitorConstants.EXTRA_DOWNLOAD_TOTAL_BYTES, downloadInfo.getTotalBytes());
                    jSONObject2.put(com.ss.android.socialbase.downloader.constants.MonitorConstants.EXTRA_DOWNLOAD_NETWORK_QUALITY, downloadInfo.getNetworkQuality());
                    int i3 = 1;
                    jSONObject2.put(com.ss.android.socialbase.downloader.constants.MonitorConstants.EXTRA_DOWNLOAD_ONLY_WIFI, downloadInfo.isOnlyWifi() ? 1 : 0);
                    jSONObject2.put(com.ss.android.socialbase.downloader.constants.MonitorConstants.EXTRA_DOWNLOAD_NEED_HTTPS_DEGRADE, downloadInfo.isNeedHttpsToHttpRetry() ? 1 : 0);
                    jSONObject2.put(com.ss.android.socialbase.downloader.constants.MonitorConstants.EXTRA_DOWNLOAD_HTTPS_DEGRADE_RETRY_USED, downloadInfo.isHttpsToHttpRetryUsed() ? 1 : 0);
                    jSONObject2.put("md5", downloadInfo.getMd5() == null ? "" : downloadInfo.getMd5());
                    jSONObject2.put(com.ss.android.socialbase.downloader.constants.MonitorConstants.EXTRA_DOWNLOAD_CHUNK_COUNT, downloadInfo.getChunkCount());
                    jSONObject2.put(com.ss.android.socialbase.downloader.constants.MonitorConstants.EXTRA_DOWNLOAD_IS_FORCE, downloadInfo.isForce() ? 1 : 0);
                    jSONObject2.put("retry_count", downloadInfo.getRetryCount());
                    jSONObject2.put(com.ss.android.socialbase.downloader.constants.MonitorConstants.EXTRA_DOWNLOAD_CUR_RETRY_TIME, downloadInfo.getCurRetryTime());
                    jSONObject2.put(com.ss.android.socialbase.downloader.constants.MonitorConstants.EXTRA_DOWNLOAD_NEED_RETRY_DELAY, downloadInfo.isNeedRetryDelay() ? 1 : 0);
                    jSONObject2.put(com.ss.android.socialbase.downloader.constants.MonitorConstants.EXTRA_DOWNLOAD_NEED_REUSE_FIRST_CONNECTION, downloadInfo.isNeedReuseFirstConnection() ? 1 : 0);
                    jSONObject2.put(com.ss.android.socialbase.downloader.constants.MonitorConstants.EXTRA_DOWNLOAD_DEFAULT_HTTP_SERVICE_BACKUP, downloadInfo.isNeedDefaultHttpServiceBackUp() ? 1 : 0);
                    jSONObject2.put(com.ss.android.socialbase.downloader.constants.MonitorConstants.EXTRA_DOWNLOAD_RETRY_DELAY_STATUS, downloadInfo.getRetryDelayStatus().ordinal());
                    jSONObject2.put(com.ss.android.socialbase.downloader.constants.MonitorConstants.EXTRA_DOWNLOAD_BACKUP_URL_USED, downloadInfo.isBackUpUrlUsed() ? 1 : 0);
                    jSONObject2.put(com.ss.android.socialbase.downloader.constants.MonitorConstants.EXTRA_DOWNLOAD_BYTE_ERROR_RETRY_STATUS, downloadInfo.getByteInvalidRetryStatus().ordinal());
                    jSONObject2.put(com.ss.android.socialbase.downloader.constants.MonitorConstants.EXTRA_DOWNLOAD_FORBIDDEN_HANDLER_STATUS, downloadInfo.getAsyncHandleStatus().ordinal());
                    jSONObject2.put(com.ss.android.socialbase.downloader.constants.MonitorConstants.EXTRA_DOWNLOAD_NEED_INDEPENDENT_PROCESS, downloadInfo.isNeedIndependentProcess() ? 1 : 0);
                    jSONObject2.put(com.ss.android.socialbase.downloader.constants.MonitorConstants.EXTRA_DOWNLOAD_HEAD_CONNECTION_ERROR_MSG, downloadInfo.getHeadConnectionException() != null ? downloadInfo.getHeadConnectionException() : "");
                    jSONObject2.put("extra", downloadInfo.getExtra() != null ? downloadInfo.getExtra() : "");
                    if (!downloadInfo.isAddListenerToSameTask()) {
                        i3 = 0;
                    }
                    jSONObject2.put(com.ss.android.socialbase.downloader.constants.MonitorConstants.EXTRA_DOWNLOAD_ADD_LISTENER_TO_SAME_TASK, i3);
                    jSONObject2.put(com.ss.android.socialbase.downloader.constants.MonitorConstants.EXTRA_DOWNLOAD_BACKUP_URL_COUNT, downloadInfo.getBackUpUrls() != null ? downloadInfo.getBackUpUrls().size() : 0);
                    jSONObject2.put(com.ss.android.socialbase.downloader.constants.MonitorConstants.EXTRA_DOWNLOAD_CUR_BACKUP_URL_INDEX, downloadInfo.getBackUpUrls() != null ? downloadInfo.getCurBackUpUrlIndex() : -1);
                    jSONObject2.put(com.ss.android.socialbase.downloader.constants.MonitorConstants.EXTRA_DOWNLOAD_FORBIDDEN_URLS, downloadInfo.getForbiddenBackupUrls() != null ? downloadInfo.getForbiddenBackupUrls().toString() : "");
                    jSONObject2.put("task_id", android.text.TextUtils.isEmpty(downloadInfo.getTaskId()) ? "" : downloadInfo.getTaskId());
                    try {
                        java.lang.String url = downloadInfo.getUrl();
                        if (android.text.TextUtils.isEmpty(url)) {
                            str5 = "";
                            str6 = str5;
                            str7 = str6;
                        } else {
                            android.net.Uri parse = android.net.Uri.parse(url);
                            str6 = parse.getHost();
                            str7 = parse.getPath();
                            str5 = parse.getLastPathSegment();
                            if (!android.text.TextUtils.isEmpty(str7) && !android.text.TextUtils.isEmpty(str5)) {
                                try {
                                    str7 = str7.substring(0, str7.length() - str5.length());
                                } catch (java.lang.Throwable th) {
                                    th.printStackTrace();
                                }
                            }
                        }
                        jSONObject2.put(com.ss.android.socialbase.downloader.constants.MonitorConstants.URL_HOST, str6);
                        jSONObject2.put(com.ss.android.socialbase.downloader.constants.MonitorConstants.URL_PATH, str7);
                        jSONObject2.put(com.ss.android.socialbase.downloader.constants.MonitorConstants.URL_LAST_PATH_SEGMENT, str5);
                    } catch (java.lang.Throwable th2) {
                        th2.printStackTrace();
                    }
                }
                jSONObject2.put("error_code", baseException != null ? baseException.getErrorCode() : 0);
                jSONObject2.put("error_msg", baseException != null ? baseException.getErrorMessage() : "");
                jSONObject2.put(com.ss.android.socialbase.downloader.constants.MonitorConstants.REQUEST_LOG, requestLog);
                return jSONObject2;
            } catch (org.json.JSONException e) {
                e = e;
                jSONObject = jSONObject2;
                e.printStackTrace();
                return jSONObject;
            }
        } catch (org.json.JSONException e2) {
            e = e2;
        }
    }

    private static boolean isMonitorStatus(int[] iArr, int i) {
        if (iArr != null && iArr.length > 0) {
            for (int i2 : iArr) {
                if (i == i2) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(24:12|(4:68|69|70|(16:72|73|15|(2:49|(1:(2:57|(1:59)(2:60|61)))(1:54))|18|19|(2:23|24)|27|28|29|(1:31)|32|33|(1:45)|36|(2:40|41)(1:39)))|14|15|(0)|49|(1:51)|(0)|18|19|(3:21|23|24)|27|28|29|(0)|32|33|(0)|43|45|36|(0)|40|41) */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0114, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0115, code lost:
    
        r0.printStackTrace();
     */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00e9 A[Catch: JSONException -> 0x0114, all -> 0x013a, TryCatch #0 {JSONException -> 0x0114, blocks: (B:29:0x00ad, B:31:0x00e9, B:32:0x00fa), top: B:28:0x00ad, outer: #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0058 A[Catch: all -> 0x013a, TRY_LEAVE, TryCatch #3 {all -> 0x013a, blocks: (B:70:0x002f, B:72:0x0033, B:19:0x007f, B:21:0x0095, B:27:0x00a8, B:29:0x00ad, B:31:0x00e9, B:32:0x00fa, B:40:0x012e, B:43:0x0120, B:45:0x0126, B:48:0x0115, B:49:0x0047, B:51:0x004d, B:57:0x0058, B:61:0x0065, B:65:0x006b, B:67:0x0077, B:77:0x002c, B:69:0x0025), top: B:12:0x0023, inners: #0, #2, #4 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void monitorDownloadConnect(@androidx.annotation.Nullable com.ss.android.socialbase.downloader.network.IDownloadHeadHttpConnection iDownloadHeadHttpConnection, java.lang.String str, java.lang.String str2, long j, java.lang.String str3, int i, java.io.IOException iOException, com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) {
        com.ss.android.socialbase.downloader.setting.DownloadSetting obtain;
        int optInt;
        java.lang.String hostIp;
        java.lang.String errorMessage;
        int httpStatusCode;
        java.lang.String path;
        java.lang.String lastPathSegment;
        org.json.JSONObject jSONObject;
        com.ss.android.socialbase.downloader.monitor.IDownloadMonitorListener downloadMonitorListener;
        if (downloadInfo == null || (optInt = (obtain = com.ss.android.socialbase.downloader.setting.DownloadSetting.obtain(downloadInfo.getId())).optInt(com.ss.android.socialbase.downloader.setting.DownloadSettingKeys.MONITOR_DOWNLOAD_CONNECT, 0)) <= 0 || android.text.TextUtils.isEmpty(str)) {
            return;
        }
        int i2 = -1;
        try {
            if (iDownloadHeadHttpConnection != null) {
                try {
                    i2 = iDownloadHeadHttpConnection.getResponseCode();
                } catch (java.lang.Throwable th) {
                    th.printStackTrace();
                }
                if (iDownloadHeadHttpConnection instanceof com.ss.android.socialbase.downloader.network.AbsDownloadHttpConnection) {
                    hostIp = ((com.ss.android.socialbase.downloader.network.AbsDownloadHttpConnection) iDownloadHeadHttpConnection).getHostIp();
                    java.lang.String str4 = "";
                    if (i2 >= 200 || i2 >= 400) {
                        if (downloadInfo.getCurRetryTime() == 0 && ((httpStatusCode = downloadInfo.getHttpStatusCode()) < 200 || httpStatusCode >= 400)) {
                            return;
                        }
                        if (iOException != null) {
                            if (com.ss.android.socialbase.downloader.utils.DownloadUtils.isNetworkConnected(com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getAppContext())) {
                                try {
                                    com.ss.android.socialbase.downloader.utils.DownloadUtils.parseException(iOException, "");
                                } catch (com.ss.android.socialbase.downloader.exception.BaseException e) {
                                    i2 = e.getErrorCode();
                                    errorMessage = e.getErrorMessage();
                                    if (e instanceof com.ss.android.socialbase.downloader.exception.DownloadTTNetException) {
                                        str4 = ((com.ss.android.socialbase.downloader.exception.DownloadTTNetException) e).getRequestLog();
                                    }
                                }
                            } else {
                                i2 = com.ss.android.socialbase.downloader.constants.DownloadErrorCode.ERROR_NETWORK_NOT_AVAILABLE;
                            }
                        }
                    }
                    errorMessage = null;
                    android.net.Uri parse = android.net.Uri.parse(str);
                    java.lang.String host = parse.getHost();
                    path = parse.getPath();
                    lastPathSegment = parse.getLastPathSegment();
                    if (!android.text.TextUtils.isEmpty(path) && !android.text.TextUtils.isEmpty(lastPathSegment)) {
                        try {
                            path = path.substring(0, path.length() - lastPathSegment.length());
                        } catch (java.lang.Throwable unused) {
                        }
                    }
                    jSONObject = new org.json.JSONObject();
                    jSONObject.put(com.ss.android.socialbase.downloader.setting.DownloadSettingKeys.SETTING_TAG, obtain.optString(com.ss.android.socialbase.downloader.setting.DownloadSettingKeys.SETTING_TAG));
                    jSONObject.put(com.ss.android.socialbase.downloader.constants.MonitorConstants.URL_HOST, host);
                    jSONObject.putOpt(com.ss.android.socialbase.downloader.constants.MonitorConstants.HOST_IP, str2);
                    jSONObject.putOpt(com.ss.android.socialbase.downloader.constants.MonitorConstants.HOST_REAL_IP, hostIp);
                    jSONObject.put(com.ss.android.socialbase.downloader.constants.MonitorConstants.URL_PATH, path);
                    jSONObject.put(com.ss.android.socialbase.downloader.constants.MonitorConstants.URL_LAST_PATH_SEGMENT, lastPathSegment);
                    jSONObject.put(com.ss.android.socialbase.downloader.constants.MonitorConstants.NET_LIB, i);
                    jSONObject.put(com.ss.android.socialbase.downloader.constants.MonitorConstants.CONNECT_TYPE, str3);
                    jSONObject.put(com.ss.android.socialbase.downloader.constants.MonitorConstants.STATUS_CODE, i2);
                    jSONObject.put(com.ss.android.socialbase.downloader.constants.MonitorConstants.REQUEST_LOG, str4);
                    if (errorMessage != null) {
                        jSONObject.put("error_msg", com.ss.android.socialbase.downloader.utils.DownloadUtils.getFixLengthString(errorMessage, obtain.optInt(com.ss.android.socialbase.downloader.setting.DownloadSettingKeys.KEY_EXCEPTION_MSG_LENGTH, 500)));
                    }
                    jSONObject.put(com.ss.android.socialbase.downloader.constants.MonitorConstants.CONNECT_TIME, j);
                    jSONObject.put("pkg_name", downloadInfo.getPackageName());
                    jSONObject.put("name", downloadInfo.getTitle());
                    if ((optInt != 1 || optInt == 3) && (downloadMonitorListener = com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getDownloadMonitorListener()) != null) {
                        downloadMonitorListener.monitorEvent(com.ss.android.socialbase.downloader.constants.MonitorConstants.DOWNLOAD_CONNECT, jSONObject, null, null);
                    }
                    if (optInt != 2 || optInt == 3) {
                        com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getEventListener().onEvent(downloadInfo.getId(), com.ss.android.socialbase.downloader.constants.MonitorConstants.DOWNLOAD_CONNECT, jSONObject);
                    }
                    return;
                }
            }
            hostIp = null;
            java.lang.String str42 = "";
            if (i2 >= 200) {
            }
            if (downloadInfo.getCurRetryTime() == 0) {
            }
            if (iOException != null) {
            }
            errorMessage = null;
            android.net.Uri parse2 = android.net.Uri.parse(str);
            java.lang.String host2 = parse2.getHost();
            path = parse2.getPath();
            lastPathSegment = parse2.getLastPathSegment();
            if (!android.text.TextUtils.isEmpty(path)) {
                path = path.substring(0, path.length() - lastPathSegment.length());
            }
            jSONObject = new org.json.JSONObject();
            jSONObject.put(com.ss.android.socialbase.downloader.setting.DownloadSettingKeys.SETTING_TAG, obtain.optString(com.ss.android.socialbase.downloader.setting.DownloadSettingKeys.SETTING_TAG));
            jSONObject.put(com.ss.android.socialbase.downloader.constants.MonitorConstants.URL_HOST, host2);
            jSONObject.putOpt(com.ss.android.socialbase.downloader.constants.MonitorConstants.HOST_IP, str2);
            jSONObject.putOpt(com.ss.android.socialbase.downloader.constants.MonitorConstants.HOST_REAL_IP, hostIp);
            jSONObject.put(com.ss.android.socialbase.downloader.constants.MonitorConstants.URL_PATH, path);
            jSONObject.put(com.ss.android.socialbase.downloader.constants.MonitorConstants.URL_LAST_PATH_SEGMENT, lastPathSegment);
            jSONObject.put(com.ss.android.socialbase.downloader.constants.MonitorConstants.NET_LIB, i);
            jSONObject.put(com.ss.android.socialbase.downloader.constants.MonitorConstants.CONNECT_TYPE, str3);
            jSONObject.put(com.ss.android.socialbase.downloader.constants.MonitorConstants.STATUS_CODE, i2);
            jSONObject.put(com.ss.android.socialbase.downloader.constants.MonitorConstants.REQUEST_LOG, str42);
            if (errorMessage != null) {
            }
            jSONObject.put(com.ss.android.socialbase.downloader.constants.MonitorConstants.CONNECT_TIME, j);
            jSONObject.put("pkg_name", downloadInfo.getPackageName());
            jSONObject.put("name", downloadInfo.getTitle());
            if (optInt != 1) {
            }
            downloadMonitorListener.monitorEvent(com.ss.android.socialbase.downloader.constants.MonitorConstants.DOWNLOAD_CONNECT, jSONObject, null, null);
            if (optInt != 2) {
            }
            com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getEventListener().onEvent(downloadInfo.getId(), com.ss.android.socialbase.downloader.constants.MonitorConstants.DOWNLOAD_CONNECT, jSONObject);
        } catch (java.lang.Throwable th2) {
            th2.printStackTrace();
        }
    }

    public static void monitorDownloadIO(com.ss.android.socialbase.downloader.setting.DownloadSetting downloadSetting, com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo, java.lang.String str, com.ss.android.socialbase.downloader.network.IDownloadHttpConnection iDownloadHttpConnection, boolean z, boolean z2, com.ss.android.socialbase.downloader.exception.BaseException baseException, long j, long j2, boolean z3, long j3, long j4, long j5, org.json.JSONObject jSONObject) {
        monitorIO(com.ss.android.socialbase.downloader.constants.MonitorConstants.DOWNLOAD_IO, downloadSetting.optInt(com.ss.android.socialbase.downloader.setting.DownloadSettingKeys.MONITOR_DOWNLOAD_IO), downloadSetting, downloadInfo, str, null, null, iDownloadHttpConnection, z, z2, baseException, j, j2, z3, j3, j4, j5, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0070 A[Catch: all -> 0x018e, TryCatch #1 {all -> 0x018e, blocks: (B:6:0x0016, B:8:0x002d, B:17:0x0065, B:19:0x0070, B:22:0x0077, B:24:0x0083, B:25:0x008d, B:29:0x009a, B:31:0x009e, B:32:0x00a4, B:34:0x00a8, B:36:0x00bb, B:38:0x0108, B:39:0x0119, B:41:0x012b, B:43:0x0134, B:44:0x014f, B:53:0x0182, B:56:0x016e, B:58:0x0174, B:66:0x004d, B:69:0x005e, B:70:0x005a), top: B:5:0x0016 }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0108 A[Catch: all -> 0x018e, TryCatch #1 {all -> 0x018e, blocks: (B:6:0x0016, B:8:0x002d, B:17:0x0065, B:19:0x0070, B:22:0x0077, B:24:0x0083, B:25:0x008d, B:29:0x009a, B:31:0x009e, B:32:0x00a4, B:34:0x00a8, B:36:0x00bb, B:38:0x0108, B:39:0x0119, B:41:0x012b, B:43:0x0134, B:44:0x014f, B:53:0x0182, B:56:0x016e, B:58:0x0174, B:66:0x004d, B:69:0x005e, B:70:0x005a), top: B:5:0x0016 }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x012b A[Catch: all -> 0x018e, TryCatch #1 {all -> 0x018e, blocks: (B:6:0x0016, B:8:0x002d, B:17:0x0065, B:19:0x0070, B:22:0x0077, B:24:0x0083, B:25:0x008d, B:29:0x009a, B:31:0x009e, B:32:0x00a4, B:34:0x00a8, B:36:0x00bb, B:38:0x0108, B:39:0x0119, B:41:0x012b, B:43:0x0134, B:44:0x014f, B:53:0x0182, B:56:0x016e, B:58:0x0174, B:66:0x004d, B:69:0x005e, B:70:0x005a), top: B:5:0x0016 }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0134 A[Catch: all -> 0x018e, TryCatch #1 {all -> 0x018e, blocks: (B:6:0x0016, B:8:0x002d, B:17:0x0065, B:19:0x0070, B:22:0x0077, B:24:0x0083, B:25:0x008d, B:29:0x009a, B:31:0x009e, B:32:0x00a4, B:34:0x00a8, B:36:0x00bb, B:38:0x0108, B:39:0x0119, B:41:0x012b, B:43:0x0134, B:44:0x014f, B:53:0x0182, B:56:0x016e, B:58:0x0174, B:66:0x004d, B:69:0x005e, B:70:0x005a), top: B:5:0x0016 }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0180 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0174 A[Catch: all -> 0x018e, TryCatch #1 {all -> 0x018e, blocks: (B:6:0x0016, B:8:0x002d, B:17:0x0065, B:19:0x0070, B:22:0x0077, B:24:0x0083, B:25:0x008d, B:29:0x009a, B:31:0x009e, B:32:0x00a4, B:34:0x00a8, B:36:0x00bb, B:38:0x0108, B:39:0x0119, B:41:0x012b, B:43:0x0134, B:44:0x014f, B:53:0x0182, B:56:0x016e, B:58:0x0174, B:66:0x004d, B:69:0x005e, B:70:0x005a), top: B:5:0x0016 }] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x017b  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00b5  */
    /* JADX WARN: Type inference failed for: r17v0 */
    /* JADX WARN: Type inference failed for: r17v1 */
    /* JADX WARN: Type inference failed for: r17v3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void monitorIO(java.lang.String str, int i, com.ss.android.socialbase.downloader.setting.DownloadSetting downloadSetting, com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo, java.lang.String str2, java.lang.String str3, java.lang.String str4, com.ss.android.socialbase.downloader.network.IDownloadHttpConnection iDownloadHttpConnection, boolean z, boolean z2, com.ss.android.socialbase.downloader.exception.BaseException baseException, long j, long j2, boolean z3, long j3, long j4, long j5, org.json.JSONObject jSONObject) {
        int i2;
        java.lang.String errorMessage;
        long j6;
        java.lang.String str5;
        int i3;
        int i4;
        double nanos;
        com.ss.android.socialbase.downloader.monitor.IDownloadMonitorListener downloadMonitorListener;
        java.lang.String str6;
        int i5;
        if (i <= 0 || j2 <= 0) {
            return;
        }
        try {
            android.net.Uri parse = android.net.Uri.parse(str2);
            java.lang.String host = parse.getHost();
            java.lang.String path = parse.getPath();
            java.lang.String lastPathSegment = parse.getLastPathSegment();
            if (!android.text.TextUtils.isEmpty(path) && !android.text.TextUtils.isEmpty(lastPathSegment)) {
                try {
                    path = path.substring(0, path.length() - lastPathSegment.length());
                } catch (java.lang.Throwable unused) {
                }
            }
            if (z) {
                i2 = 1;
            } else if (z2) {
                i2 = 2;
            } else {
                if (baseException != null) {
                    i2 = !com.ss.android.socialbase.downloader.utils.DownloadUtils.isNetworkConnected(com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getAppContext()) ? com.ss.android.socialbase.downloader.constants.DownloadErrorCode.ERROR_NETWORK_NOT_AVAILABLE : baseException.getErrorCode();
                    errorMessage = baseException.getErrorMessage();
                    org.json.JSONObject jSONObject2 = new org.json.JSONObject();
                    if (iDownloadHttpConnection == null) {
                        i3 = iDownloadHttpConnection instanceof com.ss.android.socialbase.downloader.network.IDefaultDownloadHttpConnection ? 0 : 1;
                        java.lang.String responseHeaderField = iDownloadHttpConnection.getResponseHeaderField(com.ss.android.socialbase.downloader.utils.DownloadUtils.X_CACHE);
                        ?? contains = android.text.TextUtils.isEmpty(responseHeaderField) ? -1 : responseHeaderField.toLowerCase().contains("hit");
                        if (downloadSetting.optInt(com.ss.android.socialbase.downloader.setting.DownloadSettingKeys.MONITOR_SLA, 1) == 1 && !z && !z2 && (iDownloadHttpConnection instanceof com.ss.android.socialbase.downloader.network.AbsDownloadHttpConnection)) {
                            ((com.ss.android.socialbase.downloader.network.AbsDownloadHttpConnection) iDownloadHttpConnection).monitorNetworkInfo(jSONObject2, true);
                        }
                        j6 = j;
                        str5 = iDownloadHttpConnection instanceof com.ss.android.socialbase.downloader.network.AbsDownloadHttpConnection ? ((com.ss.android.socialbase.downloader.network.AbsDownloadHttpConnection) iDownloadHttpConnection).getRequestLog() : "";
                        i4 = contains;
                    } else {
                        j6 = j;
                        str5 = "";
                        i3 = -1;
                        i4 = -1;
                    }
                    double d = j6 / 1048576.0d;
                    double d2 = j2;
                    nanos = d2 / java.util.concurrent.TimeUnit.SECONDS.toNanos(1L);
                    jSONObject2.put(com.ss.android.socialbase.downloader.setting.DownloadSettingKeys.SETTING_TAG, downloadSetting.optString(com.ss.android.socialbase.downloader.setting.DownloadSettingKeys.SETTING_TAG));
                    jSONObject2.put(com.ss.android.socialbase.downloader.constants.MonitorConstants.URL_HOST, host);
                    jSONObject2.putOpt(com.ss.android.socialbase.downloader.constants.MonitorConstants.HOST_IP, str3);
                    jSONObject2.putOpt(com.ss.android.socialbase.downloader.constants.MonitorConstants.HOST_REAL_IP, str4);
                    jSONObject2.put(com.ss.android.socialbase.downloader.constants.MonitorConstants.URL_PATH, path);
                    jSONObject2.put(com.ss.android.socialbase.downloader.constants.MonitorConstants.URL_LAST_PATH_SEGMENT, lastPathSegment);
                    jSONObject2.put(com.ss.android.socialbase.downloader.constants.MonitorConstants.NET_LIB, i3);
                    jSONObject2.put(com.ss.android.socialbase.downloader.constants.MonitorConstants.HIT_CDN_CACHE, i4);
                    jSONObject2.put(com.ss.android.socialbase.downloader.constants.MonitorConstants.STATUS_CODE, i2);
                    jSONObject2.put(com.ss.android.socialbase.downloader.constants.MonitorConstants.REQUEST_LOG, str5);
                    if (errorMessage != null) {
                        jSONObject2.put("error_msg", com.ss.android.socialbase.downloader.utils.DownloadUtils.getFixLengthString(errorMessage, downloadSetting.optInt(com.ss.android.socialbase.downloader.setting.DownloadSettingKeys.KEY_EXCEPTION_MSG_LENGTH, 500)));
                    }
                    jSONObject2.put(com.ss.android.socialbase.downloader.constants.MonitorConstants.DOWNLOAD_SEC, nanos);
                    jSONObject2.put(com.ss.android.socialbase.downloader.constants.MonitorConstants.DOWNLOAD_MB, d);
                    if (nanos > 0.0d) {
                        jSONObject2.put(com.ss.android.socialbase.downloader.constants.MonitorConstants.DOWNLOAD_SPEED, d / nanos);
                    }
                    if (z3) {
                        jSONObject2.put(com.ss.android.socialbase.downloader.constants.MonitorConstants.RW_READ_TIME, j3 / d2);
                        jSONObject2.put(com.ss.android.socialbase.downloader.constants.MonitorConstants.RW_WRITE_TIME, j4 / d2);
                        jSONObject2.put(com.ss.android.socialbase.downloader.constants.MonitorConstants.RW_SYNC_TIME, j5 / d2);
                    }
                    jSONObject2.put("pkg_name", downloadInfo.getPackageName());
                    jSONObject2.put("name", downloadInfo.getTitle());
                    if (i != 1 && i != 3) {
                        i5 = 2;
                        str6 = str;
                        if (i != i5 || i == 3) {
                            com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getEventListener().onEvent(downloadInfo.getId(), str6, jSONObject2);
                        }
                        return;
                    }
                    downloadMonitorListener = com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getDownloadMonitorListener();
                    if (downloadMonitorListener == null) {
                        str6 = str;
                        downloadMonitorListener.monitorEvent(str6, jSONObject2, null, null);
                    } else {
                        str6 = str;
                    }
                    i5 = 2;
                    if (i != i5) {
                    }
                    com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getEventListener().onEvent(downloadInfo.getId(), str6, jSONObject2);
                }
                i2 = 0;
            }
            errorMessage = null;
            org.json.JSONObject jSONObject22 = new org.json.JSONObject();
            if (iDownloadHttpConnection == null) {
            }
            double d3 = j6 / 1048576.0d;
            double d22 = j2;
            nanos = d22 / java.util.concurrent.TimeUnit.SECONDS.toNanos(1L);
            jSONObject22.put(com.ss.android.socialbase.downloader.setting.DownloadSettingKeys.SETTING_TAG, downloadSetting.optString(com.ss.android.socialbase.downloader.setting.DownloadSettingKeys.SETTING_TAG));
            jSONObject22.put(com.ss.android.socialbase.downloader.constants.MonitorConstants.URL_HOST, host);
            jSONObject22.putOpt(com.ss.android.socialbase.downloader.constants.MonitorConstants.HOST_IP, str3);
            jSONObject22.putOpt(com.ss.android.socialbase.downloader.constants.MonitorConstants.HOST_REAL_IP, str4);
            jSONObject22.put(com.ss.android.socialbase.downloader.constants.MonitorConstants.URL_PATH, path);
            jSONObject22.put(com.ss.android.socialbase.downloader.constants.MonitorConstants.URL_LAST_PATH_SEGMENT, lastPathSegment);
            jSONObject22.put(com.ss.android.socialbase.downloader.constants.MonitorConstants.NET_LIB, i3);
            jSONObject22.put(com.ss.android.socialbase.downloader.constants.MonitorConstants.HIT_CDN_CACHE, i4);
            jSONObject22.put(com.ss.android.socialbase.downloader.constants.MonitorConstants.STATUS_CODE, i2);
            jSONObject22.put(com.ss.android.socialbase.downloader.constants.MonitorConstants.REQUEST_LOG, str5);
            if (errorMessage != null) {
            }
            jSONObject22.put(com.ss.android.socialbase.downloader.constants.MonitorConstants.DOWNLOAD_SEC, nanos);
            jSONObject22.put(com.ss.android.socialbase.downloader.constants.MonitorConstants.DOWNLOAD_MB, d3);
            if (nanos > 0.0d) {
            }
            if (z3) {
            }
            jSONObject22.put("pkg_name", downloadInfo.getPackageName());
            jSONObject22.put("name", downloadInfo.getTitle());
            if (i != 1) {
                i5 = 2;
                str6 = str;
                if (i != i5) {
                }
                com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getEventListener().onEvent(downloadInfo.getId(), str6, jSONObject22);
            }
            downloadMonitorListener = com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getDownloadMonitorListener();
            if (downloadMonitorListener == null) {
            }
            i5 = 2;
            if (i != i5) {
            }
            com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getEventListener().onEvent(downloadInfo.getId(), str6, jSONObject22);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public static void monitorSegmentIO(com.ss.android.socialbase.downloader.setting.DownloadSetting downloadSetting, com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo, java.lang.String str, java.lang.String str2, java.lang.String str3, boolean z, com.ss.android.socialbase.downloader.network.IDownloadHttpConnection iDownloadHttpConnection, com.ss.android.socialbase.downloader.exception.BaseException baseException, long j, long j2) {
        monitorIO(com.ss.android.socialbase.downloader.constants.MonitorConstants.SEGMENT_IO, downloadSetting.optInt(com.ss.android.socialbase.downloader.setting.DownloadSettingKeys.MONITOR_SEGMENT_IO), downloadSetting, downloadInfo, str, str2, str3, iDownloadHttpConnection, z, false, baseException, j, j2, false, -1L, -1L, -1L, null);
    }

    public static void monitorSegmentsError(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo, java.util.List<com.ss.android.socialbase.downloader.segment.Segment> list) {
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            jSONObject.put(com.ss.android.socialbase.downloader.constants.DBDefinition.SEGMENT_TABLE_NAME, com.ss.android.socialbase.downloader.segment.Segment.toString(list));
            jSONObject.put(com.ss.android.socialbase.downloader.constants.MonitorConstants.EXTRA_DOWNLOAD_CUR_BYTES, downloadInfo.getCurBytes());
            jSONObject.put(com.ss.android.socialbase.downloader.constants.MonitorConstants.EXTRA_DOWNLOAD_TOTAL_BYTES, downloadInfo.getTotalBytes());
            com.ss.android.socialbase.downloader.monitor.InnerEventListener eventListener = com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getEventListener();
            if (eventListener != null) {
                eventListener.onEvent(downloadInfo.getId(), "segments_error", jSONObject);
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public static void monitorSend(com.ss.android.socialbase.downloader.model.DownloadTask downloadTask, com.ss.android.socialbase.downloader.exception.BaseException baseException, int i) {
        if (downloadTask == null) {
            return;
        }
        try {
            com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo = downloadTask.getDownloadInfo();
            if (downloadInfo == null) {
                return;
            }
            com.ss.android.socialbase.downloader.depend.IDownloadMonitorDepend monitorDepend = downloadTask.getMonitorDepend();
            boolean isMonitorStatus = com.ss.android.socialbase.downloader.constants.DownloadStatus.isMonitorStatus(i);
            if (!isMonitorStatus && !(isMonitorStatus = isMonitorStatus(downloadInfo.getExtraMonitorStatus(), i)) && monitorDepend != null && (monitorDepend instanceof com.ss.android.socialbase.downloader.depend.AbsDownloadMonitorDepend)) {
                isMonitorStatus = isMonitorStatus(((com.ss.android.socialbase.downloader.depend.AbsDownloadMonitorDepend) monitorDepend).getAdditionalMonitorStatus(), i);
            }
            if (isMonitorStatus) {
                try {
                    com.ss.android.socialbase.downloader.depend.IDownloadDepend depend = downloadTask.getDepend();
                    if (depend != null) {
                        depend.monitorLogSend(downloadInfo, baseException, i);
                    }
                } catch (java.lang.Throwable th) {
                    th.printStackTrace();
                }
                monitorSendWithTaskMonitor(monitorDepend, downloadInfo, baseException, i);
                monitorSendWithGlobalSdkMonitor(com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getDownloadMonitorListener(), downloadInfo, baseException, i);
            }
        } catch (java.lang.Throwable th2) {
            th2.printStackTrace();
        }
    }

    public static void monitorSendWithGlobalSdkMonitor(com.ss.android.socialbase.downloader.monitor.IDownloadMonitorListener iDownloadMonitorListener, com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo, com.ss.android.socialbase.downloader.exception.BaseException baseException, int i) {
        if (iDownloadMonitorListener == null || !downloadInfo.isNeedSDKMonitor() || android.text.TextUtils.isEmpty(downloadInfo.getMonitorScene())) {
            return;
        }
        try {
            org.json.JSONObject monitorJson = getMonitorJson(downloadInfo.getMonitorScene(), downloadInfo, baseException, i);
            if (monitorJson == null) {
                monitorJson = new org.json.JSONObject();
            }
            if (i == -1) {
                monitorJson.put("status", baseException.getErrorCode());
                iDownloadMonitorListener.monitorEvent("download_failed", monitorJson, null, null);
            } else {
                putMonitorJsonStatus(i, monitorJson, downloadInfo);
                iDownloadMonitorListener.monitorEvent("download_common", monitorJson, null, null);
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public static void monitorSendWithTaskMonitor(com.ss.android.socialbase.downloader.depend.IDownloadMonitorDepend iDownloadMonitorDepend, com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo, com.ss.android.socialbase.downloader.exception.BaseException baseException, int i) {
        if (iDownloadMonitorDepend == null) {
            return;
        }
        try {
            java.lang.String eventPage = iDownloadMonitorDepend.getEventPage();
            if (android.text.TextUtils.isEmpty(eventPage)) {
                eventPage = "default";
            }
            org.json.JSONObject monitorJson = getMonitorJson(eventPage, downloadInfo, baseException, i);
            if (monitorJson == null) {
                monitorJson = new org.json.JSONObject();
            }
            iDownloadMonitorDepend.monitorLogSend(monitorJson);
        } catch (java.lang.Throwable unused) {
        }
    }

    public static java.lang.String parseDevicePostfix(java.lang.String str) {
        try {
            return android.text.TextUtils.isDigitsOnly(str) ? java.lang.String.valueOf(java.lang.Long.valueOf(str).longValue() % 100) : "";
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    private static void putMonitorJsonStatus(int i, org.json.JSONObject jSONObject, com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) throws org.json.JSONException {
        java.lang.String str;
        if (i == -5) {
            str = "download_uncomplete";
        } else if (i == -4) {
            str = "download_cancel";
        } else if (i != -3) {
            str = i != -2 ? i != 0 ? i != 2 ? i != 6 ? "" : "download_first_start" : com.aliyun.svideo.editor.effectmanager.MorePasterAdapter.DOWNLOAD_START : "download_create" : "download_pause";
        } else {
            double downloadSpeed = downloadInfo.getDownloadSpeed();
            if (downloadSpeed >= 0.0d) {
                jSONObject.put(com.ss.android.socialbase.downloader.constants.MonitorConstants.DOWNLOAD_SPEED, downloadSpeed);
            }
            str = "download_success";
        }
        jSONObject.put("status", str);
    }
}
