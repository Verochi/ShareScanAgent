package com.xiaomi.push;

/* loaded from: classes19.dex */
public final class ex {
    public static int a(java.lang.Throwable th) {
        java.lang.Throwable th2;
        boolean z = th instanceof com.xiaomi.push.fh;
        if (z && (th2 = ((com.xiaomi.push.fh) th).a) != null) {
            th = th2;
        }
        java.lang.String message = th.getMessage();
        if (th.getCause() != null) {
            message = th.getCause().getMessage();
        }
        if (th instanceof java.net.SocketTimeoutException) {
            return 105;
        }
        if (!(th instanceof java.net.SocketException)) {
            if (th instanceof java.net.UnknownHostException) {
                return 107;
            }
            return z ? 399 : 0;
        }
        if (message.indexOf("Network is unreachable") != -1) {
            return 102;
        }
        if (message.indexOf("Connection refused") != -1) {
            return 103;
        }
        if (message.indexOf("Connection timed out") != -1) {
            return 105;
        }
        if (message.endsWith("EACCES (Permission denied)")) {
            return 101;
        }
        if (message.indexOf("Connection reset by peer") != -1) {
            return 109;
        }
        if (message.indexOf("Broken pipe") != -1) {
            return 110;
        }
        if (message.indexOf("No route to host") != -1) {
            return 104;
        }
        return message.endsWith("EINVAL (Invalid argument)") ? 106 : 199;
    }
}
