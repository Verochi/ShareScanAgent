package com.ss.android.socialbase.downloader.utils;

/* loaded from: classes19.dex */
public class DownloadHttpUtils {
    public static java.lang.String httpCodeToMessage(int i) {
        if (i == 449) {
            return "Retry With";
        }
        if (i == 451) {
            return "Unavailable For Legal Reasons";
        }
        if (i == 600) {
            return "Unparseable Response Headers";
        }
        if (i == 509) {
            return "Bandwidth Limit Exceeded";
        }
        if (i == 510) {
            return "Not Extended";
        }
        switch (i) {
            case 100:
                return "Continue";
            case 101:
                return "Switching Protocols";
            case 102:
                return "Processing";
            default:
                switch (i) {
                    case 200:
                        return com.baidu.mobads.sdk.internal.bz.k;
                    case 201:
                        return "Created";
                    case 202:
                        return "Accepted";
                    case 203:
                        return "Non-Authoritative Information";
                    case 204:
                        return "No Content";
                    case com.qq.e.comm.adevent.AdEventType.VIDEO_STOP /* 205 */:
                        return "Reset Content";
                    case com.qq.e.comm.adevent.AdEventType.VIDEO_COMPLETE /* 206 */:
                        return "Partial Content";
                    case com.qq.e.comm.adevent.AdEventType.VIDEO_ERROR /* 207 */:
                        return "Multi-Status";
                    default:
                        switch (i) {
                            case 300:
                                return "Multiple Choices";
                            case 301:
                                return "Moved Permanently";
                            case 302:
                                return "Move Temporarily";
                            case 303:
                                return "See Other";
                            case 304:
                                return "Not Modified";
                            case com.umeng.ccg.c.f452s /* 305 */:
                                return "Use Proxy";
                            case 306:
                                return "Switch Proxy";
                            case okhttp3.internal.http.StatusLine.HTTP_TEMP_REDIRECT /* 307 */:
                                return "Temporary Redirect";
                            default:
                                switch (i) {
                                    case 400:
                                        return "Bad Request";
                                    case 401:
                                        return "Unauthorized";
                                    case 402:
                                        return "Payment Required";
                                    case 403:
                                        return "Forbidden";
                                    case 404:
                                        return "Not Found";
                                    case 405:
                                        return "Method Not Allowed";
                                    case 406:
                                        return "Not Acceptable";
                                    case 407:
                                        return "Proxy Authentication Required";
                                    case com.bytedance.sdk.openadsdk.TTAdConstant.INTERACTION_TYPE_CODE /* 408 */:
                                        return "Request Timeout";
                                    case com.bytedance.sdk.openadsdk.TTAdConstant.IMAGE_LIST_CODE /* 409 */:
                                        return "Conflict";
                                    case com.bytedance.sdk.openadsdk.TTAdConstant.IMAGE_LIST_SIZE_CODE /* 410 */:
                                        return "Gone";
                                    case com.bytedance.sdk.openadsdk.TTAdConstant.IMAGE_CODE /* 411 */:
                                        return "Length Required";
                                    case com.bytedance.sdk.openadsdk.TTAdConstant.IMAGE_URL_CODE /* 412 */:
                                        return "Precondition Failed";
                                    case com.bytedance.sdk.openadsdk.TTAdConstant.VIDEO_INFO_CODE /* 413 */:
                                        return "Request Entity Too Large";
                                    case com.bytedance.sdk.openadsdk.TTAdConstant.VIDEO_URL_CODE /* 414 */:
                                        return "Request-URI Too Long";
                                    case com.bytedance.sdk.openadsdk.TTAdConstant.VIDEO_COVER_URL_CODE /* 415 */:
                                        return "Unsupported Media Type";
                                    case 416:
                                        return "Requested Range Not Satisfiable";
                                    case com.bytedance.sdk.openadsdk.TTAdConstant.LIVE_FEED_URL_CODE /* 417 */:
                                        return "Expectation Failed";
                                    case com.bytedance.sdk.openadsdk.TTAdConstant.DEEPLINK_FALL_BACK_CODE /* 418 */:
                                        return "I'm a teapot";
                                    default:
                                        switch (i) {
                                            case 421:
                                                return "Too Many Connections";
                                            case 422:
                                                return "Unprocessable Entity";
                                            case 423:
                                                return "Locked";
                                            case 424:
                                                return "Failed Dependency";
                                            case 425:
                                                return "Unordered Collection";
                                            case 426:
                                                return "Upgrade Required";
                                            default:
                                                switch (i) {
                                                    case 500:
                                                        return "Internal Server Error";
                                                    case 501:
                                                        return "Not Implemented";
                                                    case 502:
                                                        return "Bad Gateway";
                                                    case 503:
                                                        return "Service Unavailable";
                                                    case 504:
                                                        return "Gateway Timeout";
                                                    case com.anythink.basead.ui.GuideToClickView.a.e /* 505 */:
                                                        return "HTTP Version Not Supported";
                                                    case com.anythink.basead.ui.GuideToClickView.a.f /* 506 */:
                                                        return "Variant Also Negotiates";
                                                    case com.anythink.basead.ui.GuideToClickView.a.g /* 507 */:
                                                        return "Insufficient Storage";
                                                    default:
                                                        return "";
                                                }
                                        }
                                }
                        }
                }
        }
    }
}
