package com.jd.ad.sdk.fdt.utils;

/* loaded from: classes23.dex */
public class UUIDUtils {
    public static java.lang.String uuid() {
        return java.util.UUID.randomUUID().toString().replace(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER, "");
    }
}
