package com.jd.ad.sdk.jad_fq;

/* loaded from: classes23.dex */
public class jad_hu {
    public static java.lang.String jad_an() {
        java.lang.String hostAddress;
        java.util.regex.Matcher matcher;
        java.util.regex.Pattern compile = java.util.regex.Pattern.compile("(^10\\.(\\d{1}|[1-9]\\d|1\\d{2}|2[0-4]\\d|25\\d)\\.(\\d{1}|[1-9]\\d|1\\d{2}|2[0-4]\\d|25\\d)\\.(\\d{1}|[1-9]\\d|1\\d{2}|2[0-4]\\d|25\\d)$)|(^172\\.(1[6-9]|2\\d|3[0-1])\\.(\\d{1}|[1-9]\\d|1\\d{2}|2[0-4]\\d|25\\d)\\.(\\d{1}|[1-9]\\d|1\\d{2}|2[0-4]\\d|25\\d)$)|(^192\\.168\\.(\\d{1}|[1-9]\\d|1\\d{2}|2[0-4]\\d|25\\d)\\.(\\d{1}|[1-9]\\d|1\\d{2}|2[0-4]\\d|25\\d)$)");
        try {
            java.util.Enumeration<java.net.NetworkInterface> networkInterfaces = java.net.NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces != null) {
                if (!networkInterfaces.hasMoreElements()) {
                    return "";
                }
                java.net.NetworkInterface nextElement = networkInterfaces.nextElement();
                if (nextElement != null) {
                    java.util.Enumeration<java.net.InetAddress> inetAddresses = nextElement.getInetAddresses();
                    while (inetAddresses != null && inetAddresses.hasMoreElements()) {
                        java.net.InetAddress nextElement2 = inetAddresses.nextElement();
                        if (nextElement2 != null && (matcher = compile.matcher((hostAddress = nextElement2.getHostAddress()))) != null && matcher.matches()) {
                            return hostAddress;
                        }
                    }
                }
            }
            return "";
        } catch (java.lang.Exception e) {
            java.lang.StringBuilder jad_an = com.jd.ad.sdk.jad_bo.jad_bo.jad_an("Exception while get ip: ");
            jad_an.append(e.getMessage());
            com.jd.ad.sdk.logger.Logger.w(jad_an.toString(), new java.lang.Object[0]);
            return "";
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x001a, code lost:
    
        if (r1 != 1) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static java.lang.String jad_an(@androidx.annotation.NonNull android.content.Context context) {
        android.telephony.TelephonyManager telephonyManager;
        try {
            telephonyManager = (android.telephony.TelephonyManager) context.getSystemService(com.aliyun.vod.log.core.AliyunLogCommon.TERMINAL_TYPE);
        } catch (java.lang.SecurityException e) {
            e.printStackTrace();
            telephonyManager = null;
        }
        if (telephonyManager == null) {
            return "";
        }
        int simState = telephonyManager.getSimState();
        boolean z = simState != 0;
        if (!z) {
            return "";
        }
        java.lang.String networkOperatorName = telephonyManager.getNetworkOperatorName();
        return !android.text.TextUtils.isEmpty(networkOperatorName) ? networkOperatorName.contains("移动") ? moji.com.mjwallet.InputSmsCodeFragmentKt.MOBILE : networkOperatorName.contains("联通") ? "unicom" : networkOperatorName.contains("电信") ? "telecom" : "" : "";
    }
}
