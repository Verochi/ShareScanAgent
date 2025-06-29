package com.ss.android.socialbase.downloader.constants;

/* loaded from: classes19.dex */
public class DownloadConstants {
    public static final java.lang.String ACTION_DOWNLOAD_MULTI_PROCESS_NOTIFY = "com.ss.android.downloader.action.MULTI_PROCESS_NOTIFY";
    public static final java.lang.String ACTION_DOWNLOAD_PROCESS_NOTIFY = "com.ss.android.downloader.action.PROCESS_NOTIFY";
    public static final java.lang.String ACTION_RETRY = "com.ss.android.downloader.action.DOWNLOAD_WAKEUP";
    public static final java.lang.String AUTO_INSTALL_WITHOUT_NOTIFICATION = "auto_install_without_notification";
    public static final int CONNECT_TIMEOUT = 30000;
    public static final org.json.JSONObject EMPTY_JSON = new org.json.JSONObject();
    public static final java.lang.String EXTRA_DOWNLOAD_ID = "extra_download_id";
    public static final java.lang.String EXTRA_REQUEST_HOST_IP = "ss_d_request_host_ip_114";
    public static final java.lang.String EXTRA_THROTTLE_NET_SPEED = "extra_throttle_net_speed";
    public static final java.lang.String EXTRA_TTNET_PROTECT_TIMEOUT = "extra_ttnet_protect_timeout";
    public static final long GB = 1073741824;
    public static final long HOUR = 3600000;
    public static final int HTTP_REQUESTED_RANGE_NOT_SATISFIABLE = 416;
    public static final int IO_TIMEOUT = 30000;
    public static final long KB = 1024;
    public static final java.lang.String KEY_FIX_DOWNLOADER_DB_SIGBUS = "fix_downloader_db_sigbus";
    public static final java.lang.String KEY_PAUSED_RESUME_COUNT = "paused_resume_count";
    public static long LIMIT_INTERVSL = 50;
    public static long LIMIT_SPEED_EVERTS_ECOND = 512000;
    public static volatile java.lang.String LOWER_OPPO = "";
    public static final long MB = 1048576;
    public static volatile java.lang.String MIME_APK = "";
    public static final java.lang.String MIME_PLG = "mime_type_plg";
    public static final java.lang.String MIME_PLUGIN = "mime_type_plugin";
    public static long MIN_CHUNK_REUSE_SIZE = 5242880;
    public static long MIN_DELAY_NOTIFY_SUCCESS_SIZE = 31457280;
    public static long MIN_DELAY_NOTIFY_SUCCESS_SIZE2 = 10485760;
    public static final long MK_DIR_MIN_SPACE = 16384;
    public static final int SECOND_TO_MILLS = 1000;
    public static final java.lang.String SP_ANTI_HIJACK_CONFIG = "sp_ah_config";
    public static final java.lang.String SP_DOWNLOAD_INFO = "sp_download_info";
    public static final long TB = 1099511627776L;
    public static volatile java.lang.String UPPER_OPPO = "";
    public static final java.lang.String USER_AGENT = "User-Agent";

    public static void setMimeApk(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return;
        }
        MIME_APK = str;
    }
}
