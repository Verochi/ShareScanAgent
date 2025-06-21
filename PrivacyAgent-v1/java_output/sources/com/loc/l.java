package com.loc;

/* loaded from: classes23.dex */
public final class l extends java.lang.Exception {
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

    /* JADX WARN: Removed duplicated region for block: B:10:0x0190  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x018d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public l(java.lang.String str) {
        super(str);
        int i;
        java.lang.String str2;
        java.lang.String str3;
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
            str3 = "IOException";
        } else {
            if (com.amap.api.maps.AMapException.ERROR_SOCKET.equals(str)) {
                i = 22;
            } else if ("socket 连接超时 - SocketTimeoutException".equals(str)) {
                this.f = 23;
                this.d = "1802";
                str3 = "SocketTimeoutException";
            } else if ("无效的参数 - IllegalArgumentException".equals(str)) {
                this.f = 24;
                this.d = "1901";
                str3 = "IllegalArgumentException";
            } else if ("空指针异常 - NullPointException".equals(str)) {
                this.f = 25;
                this.d = "1903";
                str3 = "NullPointException";
            } else if ("url异常 - MalformedURLException".equals(str)) {
                this.f = 26;
                this.d = "1803";
                str3 = "MalformedURLException";
            } else if ("未知主机 - UnKnowHostException".equals(str)) {
                this.f = 27;
                this.d = "1804";
                str3 = "UnknownHostException";
            } else if (com.amap.api.maps.AMapException.ERROR_UNKNOW_SERVICE.equals(str)) {
                this.f = 28;
                this.d = "1805";
                str3 = "CannotConnectToHostException";
            } else if ("协议解析错误 - ProtocolException".equals(str)) {
                this.f = 29;
                this.d = "1801";
                str3 = "ProtocolException";
            } else {
                if (com.amap.api.maps.AMapException.ERROR_CONNECTION.equals(str)) {
                    this.f = 30;
                    str2 = "1806";
                } else if ("服务QPS超限".equalsIgnoreCase(str)) {
                    this.f = 30;
                    str2 = com.anythink.core.api.ErrorCode.timeOutError;
                } else if (com.amap.api.maps.AMapException.ERROR_UNKNOWN.equals(str)) {
                    i = 31;
                } else if (com.amap.api.maps.AMapException.ERROR_FAILURE_AUTH.equals(str)) {
                    i = 32;
                } else if ("限制访问的接口".equals(str)) {
                    i = 33;
                } else {
                    if (!"requeust is null".equals(str)) {
                        if ("request url is empty".equals(str)) {
                            this.f = 2;
                        } else {
                            if (!"response is null".equals(str)) {
                                if ("thread pool has exception".equals(str)) {
                                    i = 4;
                                } else if ("sdk name is invalid".equals(str)) {
                                    i = 5;
                                } else if ("sdk info is null".equals(str)) {
                                    this.f = 6;
                                } else if ("sdk packages is null".equals(str)) {
                                    this.f = 7;
                                } else if ("线程池为空".equals(str)) {
                                    i = 8;
                                } else if ("获取对象错误".equals(str)) {
                                    i = 101;
                                } else if (!"DNS解析失败".equals(str)) {
                                    i = -1;
                                }
                            }
                            this.f = 3;
                        }
                        if (!"IO 操作异常 - IOException".equals(str)) {
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
                        return;
                    }
                    i = 1;
                }
                this.d = str2;
                this.e = "ConnectionException";
                if (!"IO 操作异常 - IOException".equals(str)) {
                }
            }
            this.f = i;
            if (!"IO 操作异常 - IOException".equals(str)) {
            }
        }
        this.e = str3;
        if (!"IO 操作异常 - IOException".equals(str)) {
        }
    }

    public l(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        this(str);
        this.b = str2;
        this.c = str3;
    }

    public final java.lang.String a() {
        return this.a;
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
