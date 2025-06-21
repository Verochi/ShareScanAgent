package cn.fly.verify;

/* loaded from: classes.dex */
public class aa {
    public static java.lang.String[] a(boolean z) {
        java.lang.String[] strArr = {"", ""};
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
        try {
            java.util.Enumeration<java.net.NetworkInterface> networkInterfaces = java.net.NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                java.net.NetworkInterface nextElement = networkInterfaces.nextElement();
                if (!z || !nextElement.getName().toLowerCase().contains("wlan")) {
                    java.util.Enumeration<java.net.InetAddress> inetAddresses = nextElement.getInetAddresses();
                    while (inetAddresses.hasMoreElements()) {
                        java.net.InetAddress nextElement2 = inetAddresses.nextElement();
                        if (!nextElement2.isLoopbackAddress() && !nextElement2.isLinkLocalAddress()) {
                            java.lang.String hostAddress = nextElement2.getHostAddress();
                            if (!android.text.TextUtils.isEmpty(hostAddress)) {
                                if (nextElement2 instanceof java.net.Inet6Address) {
                                    sb.append(hostAddress);
                                    sb.append(",");
                                } else if (nextElement2 instanceof java.net.Inet4Address) {
                                    sb2.append(hostAddress);
                                    sb2.append(",");
                                }
                            }
                        }
                    }
                }
            }
            if (!android.text.TextUtils.isEmpty(sb)) {
                sb = sb.delete(sb.length() - 1, sb.length());
            }
            if (!android.text.TextUtils.isEmpty(sb2)) {
                sb2 = sb2.delete(sb2.length() - 1, sb2.length());
            }
            strArr[0] = sb2.toString();
            strArr[1] = sb.toString();
            return strArr;
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return strArr;
        }
    }
}
