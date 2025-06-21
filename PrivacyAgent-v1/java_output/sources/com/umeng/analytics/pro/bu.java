package com.umeng.analytics.pro;

/* loaded from: classes19.dex */
public enum bu {
    UnKnownCode(5000),
    Timeout(5001),
    NetworkUnavailable(5002),
    SSLException(com.qq.e.comm.constants.ErrorCode.VIDEO_PLAY_ERROR),
    IOException(com.qq.e.comm.constants.ErrorCode.NO_AD_FILL),
    UnKnownHostException(com.qq.e.comm.constants.ErrorCode.TRAFFIC_CONTROL_DAY),
    HttpError(com.qq.e.comm.constants.ErrorCode.PACKAGE_NAME_ERROR),
    EmptyResponse(com.qq.e.comm.constants.ErrorCode.RESOURCE_LOAD_ERROR),
    ErrorResponse(com.qq.e.comm.constants.ErrorCode.IMAGE_LOAD_ERROR),
    ErrorMakeRequestBody(com.qq.e.comm.constants.ErrorCode.TRAFFIC_CONTROL_HOUR);

    private final int k;

    bu(int i) {
        this.k = i;
    }

    private java.lang.String b() {
        return "错误码：" + this.k + " 错误信息：";
    }

    public java.lang.String a() {
        if (this == UnKnownCode) {
            return b() + "--未知错误--";
        }
        if (this == Timeout) {
            return b() + "--连接超时--";
        }
        if (this == NetworkUnavailable) {
            return b() + "--网络不可用--";
        }
        if (this == SSLException) {
            return b() + "--SSL证书认证失败--";
        }
        if (this == IOException) {
            return b() + "--IO异常--";
        }
        if (this == HttpError) {
            return b() + "--服务端返回HTTP错误--";
        }
        if (this == EmptyResponse) {
            return b() + "--服务端返回数据为空--";
        }
        if (this == ErrorResponse) {
            return b() + "--服务端返回错误数据--";
        }
        if (this != ErrorMakeRequestBody) {
            return "unknown";
        }
        return b() + "--请求报文构建错误--";
    }
}
