package com.baidu.mobads.sdk.api;

/* loaded from: classes.dex */
public enum CPUAdType {
    FEED("feed"),
    INTERSTITIAL(com.baidu.mobads.sdk.api.IAdInterListener.AdProdType.PRODUCT_INTERSTITIAL),
    REWARDVIDEO(com.baidu.mobads.sdk.api.IAdInterListener.AdProdType.PRODUCT_REWARDVIDEO),
    OTHER("custom");

    private final java.lang.String value;

    CPUAdType(java.lang.String str) {
        this.value = str;
    }

    public static com.baidu.mobads.sdk.api.CPUAdType parse(java.lang.String str) {
        for (com.baidu.mobads.sdk.api.CPUAdType cPUAdType : values()) {
            if (cPUAdType.value.equalsIgnoreCase(str)) {
                return cPUAdType;
            }
        }
        return null;
    }

    public java.lang.String getValue() {
        return this.value;
    }
}
