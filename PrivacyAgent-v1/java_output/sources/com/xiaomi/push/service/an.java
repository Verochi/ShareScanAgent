package com.xiaomi.push.service;

/* loaded from: classes19.dex */
public abstract class an {
    public static java.lang.String A = "ext_cloud_attr";
    public static java.lang.String B = "ext_pkg_name";
    public static java.lang.String C = "ext_notify_id";
    public static java.lang.String D = "ext_clicked_button";
    public static java.lang.String E = "ext_notify_type";
    public static java.lang.String F = "ext_session";
    public static java.lang.String G = "sig";
    public static java.lang.String H = "ext_notify_title";
    public static java.lang.String I = "ext_notify_description";
    public static java.lang.String J = "ext_messenger";
    public static java.lang.String K = "title";
    public static java.lang.String L = "description";
    public static java.lang.String M = "notifyId";
    public static java.lang.String N = "dump";
    public static java.lang.String a = "1";
    public static java.lang.String b = "2";
    public static java.lang.String c = "3";
    public static java.lang.String d = "com.xiaomi.push.OPEN_CHANNEL";
    public static java.lang.String e = "com.xiaomi.push.SEND_MESSAGE";
    public static java.lang.String f = "com.xiaomi.push.SEND_IQ";
    public static java.lang.String g = "com.xiaomi.push.BATCH_SEND_MESSAGE";
    public static java.lang.String h = "com.xiaomi.push.SEND_PRES";
    public static java.lang.String i = "com.xiaomi.push.CLOSE_CHANNEL";
    public static java.lang.String j = "com.xiaomi.push.FORCE_RECONN";
    public static java.lang.String k = "com.xiaomi.push.RESET_CONN";
    public static java.lang.String l = "com.xiaomi.push.UPDATE_CHANNEL_INFO";
    public static java.lang.String m = "com.xiaomi.push.SEND_STATS";
    public static java.lang.String n = "com.xiaomi.push.HANDLE_FCM_MSG";
    public static java.lang.String o = "com.xiaomi.push.CHANGE_HOST";
    public static java.lang.String p = "com.xiaomi.push.PING_TIMER";
    public static java.lang.String q = "ext_user_id";
    public static java.lang.String r = "ext_user_server";

    /* renamed from: s, reason: collision with root package name */
    public static java.lang.String f488s = "ext_user_res";
    public static java.lang.String t = "ext_chid";
    public static java.lang.String u = "ext_sid";
    public static java.lang.String v = "ext_token";
    public static java.lang.String w = "ext_auth_method";
    public static java.lang.String x = "ext_security";
    public static java.lang.String y = "ext_kick";
    public static java.lang.String z = "ext_client_attr";

    public static java.lang.String a(int i2) {
        switch (i2) {
            case 0:
                return "ERROR_OK";
            case 1:
                return "ERROR_SERVICE_NOT_INSTALLED";
            case 2:
                return "ERROR_NETWORK_NOT_AVAILABLE";
            case 3:
                return "ERROR_NETWORK_FAILED";
            case 4:
                return "ERROR_ACCESS_DENIED";
            case 5:
                return "ERROR_AUTH_FAILED";
            case 6:
                return "ERROR_MULTI_LOGIN";
            case 7:
                return "ERROR_SERVER_ERROR";
            case 8:
                return "ERROR_RECEIVE_TIMEOUT";
            case 9:
                return "ERROR_READ_ERROR";
            case 10:
                return "ERROR_SEND_ERROR";
            case 11:
                return "ERROR_RESET";
            case 12:
                return "ERROR_NO_CLIENT";
            case 13:
                return "ERROR_SERVER_STREAM";
            case 14:
                return "ERROR_THREAD_BLOCK";
            case 15:
                return "ERROR_SERVICE_DESTROY";
            case 16:
                return "ERROR_SESSION_CHANGED";
            case 17:
                return "ERROR_READ_TIMEOUT";
            case 18:
                return "ERROR_CONNECTIING_TIMEOUT";
            case 19:
                return "ERROR_USER_BLOCKED";
            case 20:
                return "ERROR_REDIRECT";
            case 21:
                return "ERROR_BIND_TIMEOUT";
            case 22:
                return "ERROR_PING_TIMEOUT";
            default:
                return java.lang.String.valueOf(i2);
        }
    }
}
