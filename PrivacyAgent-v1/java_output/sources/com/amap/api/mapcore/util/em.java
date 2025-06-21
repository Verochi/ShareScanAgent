package com.amap.api.mapcore.util;

/* loaded from: classes12.dex */
public final class em extends java.lang.Exception {
    private java.lang.String a;
    private int b;

    public em() {
        this.a = "";
        this.b = 1000;
    }

    public em(java.lang.String str) {
        super(str);
        this.b = 1000;
        this.a = str;
        a(str);
    }

    private void a(java.lang.String str) {
        if ("用户签名未通过".equals(str)) {
            this.b = 1001;
            return;
        }
        if (com.amap.api.services.core.AMapException.AMAP_INVALID_USER_KEY.equals(str)) {
            this.b = 1002;
            return;
        }
        if (com.amap.api.services.core.AMapException.AMAP_SERVICE_NOT_AVAILBALE.equals(str)) {
            this.b = 1003;
            return;
        }
        if (com.amap.api.services.core.AMapException.AMAP_DAILY_QUERY_OVER_LIMIT.equals(str)) {
            this.b = 1004;
            return;
        }
        if (com.amap.api.services.core.AMapException.AMAP_ACCESS_TOO_FREQUENT.equals(str)) {
            this.b = 1005;
            return;
        }
        if (com.amap.api.services.core.AMapException.AMAP_INVALID_USER_IP.equals(str)) {
            this.b = 1006;
            return;
        }
        if (com.amap.api.services.core.AMapException.AMAP_INVALID_USER_DOMAIN.equals(str)) {
            this.b = 1007;
            return;
        }
        if (com.amap.api.services.core.AMapException.AMAP_INVALID_USER_SCODE.equals(str)) {
            this.b = 1008;
            return;
        }
        if (com.amap.api.services.core.AMapException.AMAP_USERKEY_PLAT_NOMATCH.equals(str)) {
            this.b = 1009;
            return;
        }
        if (com.amap.api.services.core.AMapException.AMAP_IP_QUERY_OVER_LIMIT.equals(str)) {
            this.b = 1010;
            return;
        }
        if (com.amap.api.services.core.AMapException.AMAP_NOT_SUPPORT_HTTPS.equals(str)) {
            this.b = 1011;
            return;
        }
        if (com.amap.api.services.core.AMapException.AMAP_INSUFFICIENT_PRIVILEGES.equals(str)) {
            this.b = 1012;
            return;
        }
        if (com.amap.api.services.core.AMapException.AMAP_USER_KEY_RECYCLED.equals(str)) {
            this.b = 1013;
            return;
        }
        if (com.amap.api.services.core.AMapException.AMAP_ENGINE_RESPONSE_ERROR.equals(str)) {
            this.b = 1100;
            return;
        }
        if (com.amap.api.services.core.AMapException.AMAP_ENGINE_RESPONSE_DATA_ERROR.equals(str)) {
            this.b = com.amap.api.services.core.AMapException.CODE_AMAP_ENGINE_RESPONSE_DATA_ERROR;
            return;
        }
        if (com.amap.api.services.core.AMapException.AMAP_ENGINE_CONNECT_TIMEOUT.equals(str)) {
            this.b = com.amap.api.services.core.AMapException.CODE_AMAP_ENGINE_CONNECT_TIMEOUT;
            return;
        }
        if (com.amap.api.services.core.AMapException.AMAP_ENGINE_RETURN_TIMEOUT.equals(str)) {
            this.b = com.amap.api.services.core.AMapException.CODE_AMAP_ENGINE_RETURN_TIMEOUT;
            return;
        }
        if (com.amap.api.services.core.AMapException.AMAP_SERVICE_INVALID_PARAMS.equals(str)) {
            this.b = com.amap.api.services.core.AMapException.CODE_AMAP_SERVICE_INVALID_PARAMS;
            return;
        }
        if (com.amap.api.services.core.AMapException.AMAP_SERVICE_MISSING_REQUIRED_PARAMS.equals(str)) {
            this.b = com.amap.api.services.core.AMapException.CODE_AMAP_SERVICE_MISSING_REQUIRED_PARAMS;
            return;
        }
        if (com.amap.api.services.core.AMapException.AMAP_SERVICE_ILLEGAL_REQUEST.equals(str)) {
            this.b = com.amap.api.services.core.AMapException.CODE_AMAP_SERVICE_ILLEGAL_REQUEST;
            return;
        }
        if (com.amap.api.services.core.AMapException.AMAP_SERVICE_UNKNOWN_ERROR.equals(str)) {
            this.b = com.amap.api.services.core.AMapException.CODE_AMAP_SERVICE_UNKNOWN_ERROR;
            return;
        }
        if ("协议解析错误 - ProtocolException".equals(str)) {
            this.b = com.amap.api.services.core.AMapException.CODE_AMAP_CLIENT_ERROR_PROTOCOL;
            return;
        }
        if ("socket 连接超时 - SocketTimeoutException".equals(str)) {
            this.b = com.amap.api.services.core.AMapException.CODE_AMAP_CLIENT_SOCKET_TIMEOUT_EXCEPTION;
            return;
        }
        if ("url异常 - MalformedURLException".equals(str)) {
            this.b = com.amap.api.services.core.AMapException.CODE_AMAP_CLIENT_URL_EXCEPTION;
            return;
        }
        if ("未知主机 - UnKnowHostException".equals(str)) {
            this.b = com.amap.api.services.core.AMapException.CODE_AMAP_CLIENT_UNKNOWHOST_EXCEPTION;
            return;
        }
        if (com.amap.api.services.core.AMapException.AMAP_CLIENT_UNKNOWN_ERROR.equals(str)) {
            this.b = 1900;
            return;
        }
        if ("无效的参数 - IllegalArgumentException".equals(str)) {
            this.b = com.amap.api.services.core.AMapException.CODE_AMAP_CLIENT_INVALID_PARAMETER;
            return;
        }
        if (com.amap.api.services.core.AMapException.AMAP_CLIENT_NETWORK_EXCEPTION.equals(str)) {
            this.b = com.amap.api.services.core.AMapException.CODE_AMAP_CLIENT_NETWORK_EXCEPTION;
            return;
        }
        if ("IO 操作异常 - IOException".equals(str)) {
            this.b = com.amap.api.services.core.AMapException.CODE_AMAP_CLIENT_IO_EXCEPTION;
        } else if ("空指针异常 - NullPointException".equals(str)) {
            this.b = com.amap.api.services.core.AMapException.CODE_AMAP_CLIENT_NULLPOINT_EXCEPTION;
        } else {
            this.b = 1800;
        }
    }

    public final java.lang.String a() {
        return this.a;
    }
}
