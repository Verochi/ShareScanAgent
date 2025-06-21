package com.huawei.hms.framework.common;

/* loaded from: classes22.dex */
public class ExceptionCode {
    public static final int CANCEL = 10000100;
    private static final java.lang.String CONNECT = "connect";
    public static final int CONNECTION_ABORT = 10000402;
    public static final int CONNECTION_REFUSED = 10000404;
    public static final int CONNECTION_RESET = 10000401;
    public static final int CONNECT_FAILED = 10000403;
    public static final int CRASH_EXCEPTION = 10000000;
    public static final int INTERRUPT_CONNECT_CLOSE = 10000405;
    public static final int INTERRUPT_EXCEPTION = 10000804;
    public static final int NETWORK_CHANGED = 10000201;
    public static final int NETWORK_IO_EXCEPTION = 10000802;
    public static final int NETWORK_TIMEOUT = 10000101;
    public static final int NETWORK_UNREACHABLE = 10000200;
    public static final int NETWORK_UNSUPPORTED = 10000102;
    public static final int PROTOCOL_ERROR = 10000801;
    private static final java.lang.String READ = "read";
    public static final int READ_ERROR = 10000601;
    public static final int ROUTE_FAILED = 10000301;
    public static final int SHUTDOWN_EXCEPTION = 10000202;
    public static final int SOCKET_CLOSE = 10000406;
    public static final int SOCKET_CONNECT_TIMEOUT = 10000400;
    public static final int SOCKET_READ_TIMEOUT = 10000600;
    public static final int SOCKET_TIMEOUT = 10000803;
    public static final int SOCKET_WRITE_TIMEOUT = 10000700;
    public static final int SSL_HANDSHAKE_EXCEPTION = 10000501;
    public static final int SSL_PEERUNVERIFIED_EXCEPTION = 10000502;
    public static final int SSL_PROTOCOL_EXCEPTION = 10000500;
    public static final int UNABLE_TO_RESOLVE_HOST = 10000300;
    public static final int UNEXPECTED_EOF = 10000800;
    private static final java.lang.String WRITE = "write";

    private static java.lang.String checkExceptionContainsKey(java.lang.Exception exc, java.lang.String... strArr) {
        return checkStrContainsKey(com.huawei.hms.framework.common.StringUtils.toLowerCase(exc.getMessage()), strArr);
    }

    private static java.lang.String checkStrContainsKey(java.lang.String str, java.lang.String... strArr) {
        if (android.text.TextUtils.isEmpty(str)) {
            return "";
        }
        for (java.lang.String str2 : strArr) {
            if (str.contains(str2)) {
                return str2;
            }
        }
        return "";
    }

    public static int getErrorCodeFromException(java.lang.Exception exc) {
        if (exc == null) {
            return NETWORK_IO_EXCEPTION;
        }
        if (!(exc instanceof java.io.IOException)) {
            return CRASH_EXCEPTION;
        }
        java.lang.String message = exc.getMessage();
        if (message == null) {
            return NETWORK_IO_EXCEPTION;
        }
        java.lang.String lowerCase = com.huawei.hms.framework.common.StringUtils.toLowerCase(message);
        int errorCodeFromMsg = getErrorCodeFromMsg(lowerCase);
        return errorCodeFromMsg != 10000802 ? errorCodeFromMsg : exc instanceof java.net.SocketTimeoutException ? getErrorCodeSocketTimeout(exc) : exc instanceof java.net.ConnectException ? CONNECT_FAILED : exc instanceof java.net.NoRouteToHostException ? ROUTE_FAILED : exc instanceof javax.net.ssl.SSLProtocolException ? SSL_PROTOCOL_EXCEPTION : exc instanceof javax.net.ssl.SSLHandshakeException ? SSL_HANDSHAKE_EXCEPTION : exc instanceof javax.net.ssl.SSLPeerUnverifiedException ? SSL_PEERUNVERIFIED_EXCEPTION : exc instanceof java.net.UnknownHostException ? UNABLE_TO_RESOLVE_HOST : exc instanceof java.io.InterruptedIOException ? lowerCase.contains("connection has been shut down") ? INTERRUPT_CONNECT_CLOSE : INTERRUPT_EXCEPTION : exc instanceof java.net.ProtocolException ? PROTOCOL_ERROR : errorCodeFromMsg;
    }

    private static int getErrorCodeFromMsg(java.lang.String str) {
        return str.contains("unexpected end of stream") ? UNEXPECTED_EOF : str.contains("unable to resolve host") ? UNABLE_TO_RESOLVE_HOST : str.contains("read error") ? READ_ERROR : str.contains("connection reset") ? CONNECTION_RESET : str.contains("software caused connection abort") ? CONNECTION_ABORT : str.contains("failed to connect to") ? CONNECT_FAILED : str.contains("connection refused") ? CONNECTION_REFUSED : str.contains("connection timed out") ? SOCKET_CONNECT_TIMEOUT : str.contains("no route to host") ? ROUTE_FAILED : str.contains("network is unreachable") ? NETWORK_UNREACHABLE : str.contains("socket closed") ? SOCKET_CLOSE : NETWORK_IO_EXCEPTION;
    }

    private static int getErrorCodeSocketTimeout(java.lang.Exception exc) {
        java.lang.String checkExceptionContainsKey = checkExceptionContainsKey(exc, CONNECT, READ, WRITE);
        checkExceptionContainsKey.hashCode();
        switch (checkExceptionContainsKey) {
            case "read":
                return SOCKET_READ_TIMEOUT;
            case "write":
                return SOCKET_WRITE_TIMEOUT;
            case "connect":
                return SOCKET_CONNECT_TIMEOUT;
            default:
                return SOCKET_TIMEOUT;
        }
    }
}
