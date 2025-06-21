package com.aliyun.vod.log.core;

/* loaded from: classes12.dex */
public class AliyunLogParam {
    public static java.lang.String generatePushParams(java.util.Map<java.lang.String, java.lang.String> map, java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, int i, java.lang.String str5, java.lang.String str6, java.lang.String str7) {
        return "&t" + com.huawei.hms.framework.common.ContainerUtils.KEY_VALUE_DELIMITER + java.lang.String.valueOf(java.lang.System.currentTimeMillis()) + "&ll" + com.huawei.hms.framework.common.ContainerUtils.KEY_VALUE_DELIMITER + str2 + "&lv" + com.huawei.hms.framework.common.ContainerUtils.KEY_VALUE_DELIMITER + "1&pd" + com.huawei.hms.framework.common.ContainerUtils.KEY_VALUE_DELIMITER + str + "&md" + com.huawei.hms.framework.common.ContainerUtils.KEY_VALUE_DELIMITER + str3 + "&sm" + com.huawei.hms.framework.common.ContainerUtils.KEY_VALUE_DELIMITER + str4 + "&hn" + com.huawei.hms.framework.common.ContainerUtils.KEY_VALUE_DELIMITER + getHostIp() + "&bi" + com.huawei.hms.framework.common.ContainerUtils.KEY_VALUE_DELIMITER + "&ri" + com.huawei.hms.framework.common.ContainerUtils.KEY_VALUE_DELIMITER + str5 + "&e" + com.huawei.hms.framework.common.ContainerUtils.KEY_VALUE_DELIMITER + java.lang.String.valueOf(i) + "&args" + com.huawei.hms.framework.common.ContainerUtils.KEY_VALUE_DELIMITER + transcodeArgs(map) + "&tt" + com.huawei.hms.framework.common.ContainerUtils.KEY_VALUE_DELIMITER + com.aliyun.vod.log.core.AliyunLogCommon.TERMINAL_TYPE + "&dm" + com.huawei.hms.framework.common.ContainerUtils.KEY_VALUE_DELIMITER + com.aliyun.vod.log.core.AliyunLogCommon.DEVICE_MODEL + "&os" + com.huawei.hms.framework.common.ContainerUtils.KEY_VALUE_DELIMITER + com.aliyun.vod.log.core.AliyunLogCommon.OPERATION_SYSTEM + "&ov" + com.huawei.hms.framework.common.ContainerUtils.KEY_VALUE_DELIMITER + com.aliyun.vod.log.core.AliyunLogCommon.OS_VERSION + "&av" + com.huawei.hms.framework.common.ContainerUtils.KEY_VALUE_DELIMITER + str7 + "&uuid" + com.huawei.hms.framework.common.ContainerUtils.KEY_VALUE_DELIMITER + com.aliyun.vod.log.core.AliyunLogCommon.UUID + "&dn" + com.huawei.hms.framework.common.ContainerUtils.KEY_VALUE_DELIMITER + "&co" + com.huawei.hms.framework.common.ContainerUtils.KEY_VALUE_DELIMITER + str6 + "&uat" + com.huawei.hms.framework.common.ContainerUtils.KEY_VALUE_DELIMITER + "&ui" + com.huawei.hms.framework.common.ContainerUtils.KEY_VALUE_DELIMITER + com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty.SURFACE_ROTATION_MODE_FALSE + "&app_id" + com.huawei.hms.framework.common.ContainerUtils.KEY_VALUE_DELIMITER + com.aliyun.vod.log.core.AliyunLogCommon.APPLICATION_ID + "&cdn_ip" + com.huawei.hms.framework.common.ContainerUtils.KEY_VALUE_DELIMITER + "&r" + com.huawei.hms.framework.common.ContainerUtils.KEY_VALUE_DELIMITER + "&app_n" + com.huawei.hms.framework.common.ContainerUtils.KEY_VALUE_DELIMITER + com.aliyun.vod.log.core.AliyunLogCommon.APPLICATION_NAME;
    }

    public static java.lang.String generateRandom() {
        return java.util.UUID.randomUUID().toString();
    }

    public static java.lang.String generateTimestamp() {
        java.util.Date date = new java.util.Date(java.lang.System.currentTimeMillis());
        java.text.SimpleDateFormat simpleDateFormat = new java.text.SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        simpleDateFormat.setTimeZone(new java.util.SimpleTimeZone(0, "GMT"));
        return simpleDateFormat.format(date);
    }

    public static java.lang.String generateTimestamp(long j) {
        java.util.Date date = new java.util.Date(j);
        java.text.SimpleDateFormat simpleDateFormat = new java.text.SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        simpleDateFormat.setTimeZone(new java.util.SimpleTimeZone(0, "GMT"));
        return simpleDateFormat.format(date);
    }

    public static java.lang.String getHostIp() {
        try {
            java.util.Enumeration<java.net.NetworkInterface> networkInterfaces = java.net.NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                java.util.Enumeration<java.net.InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    java.net.InetAddress nextElement = inetAddresses.nextElement();
                    if (!nextElement.isLoopbackAddress()) {
                        return nextElement.getHostAddress();
                    }
                }
            }
            return null;
        } catch (java.net.SocketException | java.lang.Exception unused) {
            return null;
        }
    }

    public static java.lang.String transcodeArgs(java.util.Map<java.lang.String, java.lang.String> map) {
        if (map != null) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            for (java.util.Map.Entry<java.lang.String, java.lang.String> entry : map.entrySet()) {
                sb.append(entry.getKey());
                sb.append(com.huawei.hms.framework.common.ContainerUtils.KEY_VALUE_DELIMITER);
                sb.append(entry.getValue());
                sb.append("&");
            }
            sb.deleteCharAt(sb.lastIndexOf("&"));
            try {
                return java.net.URLEncoder.encode(sb.toString(), "UTF-8");
            } catch (java.io.UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return "";
    }
}
