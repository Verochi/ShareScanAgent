package com.amap.api.mapcore.util;

/* loaded from: classes12.dex */
public final class eu extends java.lang.Exception {
    private java.lang.String a;
    private java.lang.String b;
    private java.lang.String c;
    private java.lang.String d;
    private java.lang.String e;
    private int f;
    private int g;
    private volatile boolean h;
    private java.lang.String i;
    private java.util.Map<java.lang.String, java.util.List<java.lang.String>> j;

    public eu(java.lang.String str) {
        super(str);
        this.a = com.amap.api.maps.AMapException.ERROR_UNKNOWN;
        this.b = "";
        this.c = "";
        this.d = "1900";
        this.e = "UnknownError";
        this.f = -1;
        this.g = -1;
        this.h = false;
        this.a = str;
        if ("IO 操作异常 - IOException".equals(str)) {
            this.f = 21;
            this.d = "1902";
            this.e = "IOException";
        } else if (com.amap.api.maps.AMapException.ERROR_SOCKET.equals(str)) {
            this.f = 22;
        } else if ("socket 连接超时 - SocketTimeoutException".equals(str)) {
            this.f = 23;
            this.d = "1802";
            this.e = "SocketTimeoutException";
        } else if ("无效的参数 - IllegalArgumentException".equals(str)) {
            this.f = 24;
            this.d = "1901";
            this.e = "IllegalArgumentException";
        } else if ("空指针异常 - NullPointException".equals(str)) {
            this.f = 25;
            this.d = "1903";
            this.e = "NullPointException";
        } else if ("url异常 - MalformedURLException".equals(str)) {
            this.f = 26;
            this.d = "1803";
            this.e = "MalformedURLException";
        } else if ("未知主机 - UnKnowHostException".equals(str)) {
            this.f = 27;
            this.d = "1804";
            this.e = "UnknownHostException";
        } else if (com.amap.api.maps.AMapException.ERROR_UNKNOW_SERVICE.equals(str)) {
            this.f = 28;
            this.d = "1805";
            this.e = "CannotConnectToHostException";
        } else if ("协议解析错误 - ProtocolException".equals(str)) {
            this.f = 29;
            this.d = "1801";
            this.e = "ProtocolException";
        } else if (com.amap.api.maps.AMapException.ERROR_CONNECTION.equals(str)) {
            this.f = 30;
            this.d = "1806";
            this.e = "ConnectionException";
        } else if ("服务QPS超限".equalsIgnoreCase(str)) {
            this.f = 30;
            this.d = com.anythink.core.api.ErrorCode.timeOutError;
            this.e = "ConnectionException";
        } else if (com.amap.api.maps.AMapException.ERROR_UNKNOWN.equals(str)) {
            this.f = 31;
        } else if (com.amap.api.maps.AMapException.ERROR_FAILURE_AUTH.equals(str)) {
            this.f = 32;
        } else if ("requeust is null".equals(str)) {
            this.f = 1;
        } else if ("request url is empty".equals(str)) {
            this.f = 2;
        } else if ("response is null".equals(str)) {
            this.f = 3;
        } else if ("thread pool has exception".equals(str)) {
            this.f = 4;
        } else if ("sdk name is invalid".equals(str)) {
            this.f = 5;
        } else if ("sdk info is null".equals(str)) {
            this.f = 6;
        } else if ("sdk packages is null".equals(str)) {
            this.f = 7;
        } else if ("线程池为空".equals(str)) {
            this.f = 8;
        } else if ("获取对象错误".equals(str)) {
            this.f = 101;
        } else if ("DNS解析失败".equals(str)) {
            this.f = 3;
        } else {
            this.f = -1;
        }
        if ("IO 操作异常 - IOException".equals(str)) {
            this.g = 7;
            return;
        }
        if (com.amap.api.maps.AMapException.ERROR_SOCKET.equals(str)) {
            this.g = 6;
            return;
        }
        if ("socket 连接超时 - SocketTimeoutException".equals(str)) {
            this.g = 2;
            return;
        }
        if (!"未知主机 - UnKnowHostException".equals(str)) {
            if (com.amap.api.maps.AMapException.ERROR_CONNECTION.equals(str)) {
                this.g = 6;
                return;
            } else if (!com.amap.api.maps.AMapException.ERROR_UNKNOWN.equals(str) && "DNS解析失败".equals(str)) {
                this.g = 3;
                return;
            }
        }
        this.g = 9;
    }

    public eu(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        this(str);
        this.b = str2;
        this.c = str3;
    }

    public final java.lang.String a() {
        return this.a;
    }

    public final void a(int i) {
        this.f = i;
    }

    public final void a(java.lang.String str) {
        this.i = str;
    }

    public final void a(java.util.Map<java.lang.String, java.util.List<java.lang.String>> map) {
        this.j = map;
    }

    public final java.lang.String b() {
        return this.d;
    }

    public final java.lang.String c() {
        return this.e;
    }

    public final java.lang.String d() {
        return this.b;
    }

    public final java.lang.String e() {
        return this.c;
    }

    public final int f() {
        return this.f;
    }

    public final int g() {
        return this.g;
    }

    public final int h() {
        this.g = 10;
        return 10;
    }

    public final boolean i() {
        return this.h;
    }

    public final void j() {
        this.h = true;
    }
}
