package com.aliyun.vod.qupaiokhttp;

/* loaded from: classes12.dex */
class Utils {
    public static java.lang.String getFullUrl(java.lang.String str, java.util.List<com.aliyun.vod.qupaiokhttp.Part> list, boolean z) {
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        stringBuffer.append(str);
        int i = 0;
        if (stringBuffer.indexOf("?", 0) < 0 && list.size() > 0) {
            stringBuffer.append("?");
        }
        for (com.aliyun.vod.qupaiokhttp.Part part : list) {
            java.lang.String key = part.getKey();
            java.lang.String value = part.getValue();
            if (z) {
                try {
                    key = java.net.URLEncoder.encode(key, "UTF-8");
                    value = java.net.URLEncoder.encode(value, "UTF-8");
                } catch (java.io.UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
            stringBuffer.append(key);
            stringBuffer.append(com.huawei.hms.framework.common.ContainerUtils.KEY_VALUE_DELIMITER);
            stringBuffer.append(value);
            i++;
            if (i != list.size()) {
                stringBuffer.append("&");
            }
        }
        return stringBuffer.toString();
    }
}
