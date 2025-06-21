package com.huawei.hms.common.internal;

/* loaded from: classes22.dex */
public class TransactionIdCreater {
    private static final int API_SIZE = 6;
    private static final int APPID_SIZE = 9;
    private static final char FILL_BYTE = '0';

    public static java.lang.String getId(java.lang.String str, java.lang.String str2) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(com.huawei.hms.utils.StringUtil.addByteForNum(str, 9, FILL_BYTE));
        sb.append(com.huawei.hms.utils.StringUtil.addByteForNum(str2, 6, FILL_BYTE));
        java.util.Locale locale = java.util.Locale.ENGLISH;
        sb.append(new java.text.SimpleDateFormat("yyyyMMddHHmmssSSS", locale).format(new java.util.Date()));
        sb.append(java.lang.String.format(locale, "%06d", java.lang.Integer.valueOf(new java.util.Random().nextInt(1000000))));
        return sb.toString();
    }
}
