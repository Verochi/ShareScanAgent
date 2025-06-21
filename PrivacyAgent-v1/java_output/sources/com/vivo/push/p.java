package com.vivo.push;

/* loaded from: classes19.dex */
public final class p {
    public static final android.net.Uri a = android.net.Uri.parse("content://com.vivo.push.sdk.service.SystemPushConfig/config");
    public static final android.net.Uri b = android.net.Uri.parse("content://com.vivo.push.sdk.service.SystemPushConfig/permission");
    public static final android.net.Uri c = android.net.Uri.parse("content://com.vivo.push.sdk.service.SystemPushConfig/clientState");
    public static final android.net.Uri d = android.net.Uri.parse("content://com.vivo.push.sdk.service.SystemPushConfig/debugInfo");

    public static java.lang.String a(int i) {
        switch (i) {
            case 2002:
                return "method_alias_bind";
            case 2003:
                return "method_alias_unbind";
            case 2004:
                return "method_tag_bind";
            case 2005:
                return "method_tag_unbind";
            case 2006:
                return "method_sdk_bind";
            case 2007:
                return "method_sdk_unbind";
            case 2008:
                return "method_stop";
            default:
                return null;
        }
    }
}
