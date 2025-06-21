package com.baidu.mobads.sdk.internal;

/* loaded from: classes.dex */
public class k {
    private static final java.lang.String a = "竞价参数格式错误，请检查参数是否为空";
    private static final java.lang.String b = "ecpm格式错误，请检查是否满足以下条件：ecpm需大于0，单位：分，无小数点";
    private static final java.lang.String c = "adn格式错误，请检查是否满足以下条件：整型，不支持小数，需在枚举值范围内";
    private static final java.lang.String d = "ad_t格式错误，请检查是否满足以下条件：整型，不支持小数，需在枚举值范围内";
    private static final java.lang.String e = "ad_time格式错误，请检查是否满足以下条件：秒级时间戳（10位数字）、无特殊符号";
    private static final java.lang.String f = "bid_t格式错误，请检查是否满足以下条件：整型，不支持小数，需在枚举值范围内";
    private static final java.lang.String g = "reason格式错误，请检查是否满足以下条件：整型，不支持小数，需在枚举值范围内";
    private static final java.lang.String h = "is_s格式错误，请检查是否满足以下条件：整型，不支持小数，需在枚举值范围内";
    private static final java.lang.String i = "is_c格式错误，请检查是否满足以下条件：整型，不支持小数，需在枚举值范围内";

    public static boolean a(boolean z, java.util.LinkedHashMap<java.lang.String, java.lang.Object> linkedHashMap, com.baidu.mobads.sdk.api.BiddingListener biddingListener) {
        if (linkedHashMap != null) {
            try {
                if (linkedHashMap.containsKey("ecpm")) {
                    java.lang.String valueOf = java.lang.String.valueOf(linkedHashMap.get("ecpm"));
                    if (!android.text.TextUtils.isEmpty(valueOf) && (valueOf.contains(".") || java.lang.Integer.parseInt(valueOf) <= 0)) {
                        if (biddingListener != null) {
                            biddingListener.onBiddingResult(false, b, null);
                        }
                        return false;
                    }
                }
                if (linkedHashMap.containsKey(com.baidu.mobads.sdk.api.SplashAd.KEY_BIDFAIL_ADN)) {
                    java.lang.String valueOf2 = java.lang.String.valueOf(linkedHashMap.get(com.baidu.mobads.sdk.api.SplashAd.KEY_BIDFAIL_ADN));
                    if (!android.text.TextUtils.isEmpty(valueOf2) && (valueOf2.contains(".") || java.lang.Integer.parseInt(valueOf2) < 0)) {
                        if (biddingListener != null) {
                            biddingListener.onBiddingResult(false, c, null);
                        }
                        return false;
                    }
                }
                if (linkedHashMap.containsKey("ad_t")) {
                    java.lang.String valueOf3 = java.lang.String.valueOf(linkedHashMap.get("ad_t"));
                    if (android.text.TextUtils.isEmpty(valueOf3) && (valueOf3.contains(".") || java.lang.Integer.parseInt(valueOf3) < 0)) {
                        if (biddingListener != null) {
                            biddingListener.onBiddingResult(false, d, null);
                        }
                        return false;
                    }
                }
                if (linkedHashMap.containsKey("ad_time")) {
                    java.lang.String valueOf4 = java.lang.String.valueOf(linkedHashMap.get("ad_time"));
                    if (valueOf4.length() == 13) {
                        linkedHashMap.put("ad_time", valueOf4.substring(0, 10));
                    }
                    if (android.text.TextUtils.isEmpty(valueOf4) && (valueOf4.contains(".") || java.lang.Double.parseDouble(valueOf4) < 1.0E9d)) {
                        if (biddingListener != null) {
                            biddingListener.onBiddingResult(false, e, null);
                        }
                        return false;
                    }
                }
                if (linkedHashMap.containsKey("bid_t")) {
                    java.lang.String valueOf5 = java.lang.String.valueOf(linkedHashMap.get("bid_t"));
                    if (android.text.TextUtils.isEmpty(valueOf5) && (valueOf5.contains(".") || java.lang.Integer.parseInt(valueOf5) < 0)) {
                        if (biddingListener != null) {
                            biddingListener.onBiddingResult(false, f, null);
                        }
                        return false;
                    }
                }
                if (!z) {
                    if (linkedHashMap.containsKey("reason")) {
                        java.lang.String valueOf6 = java.lang.String.valueOf(linkedHashMap.get("reason"));
                        if (android.text.TextUtils.isEmpty(valueOf6) && (valueOf6.contains(".") || java.lang.Integer.parseInt(valueOf6) < 0)) {
                            if (biddingListener != null) {
                                biddingListener.onBiddingResult(false, g, null);
                            }
                            return false;
                        }
                    }
                    if (linkedHashMap.containsKey("is_s")) {
                        java.lang.String valueOf7 = java.lang.String.valueOf(linkedHashMap.get("is_s"));
                        if (android.text.TextUtils.isEmpty(valueOf7) && (valueOf7.contains(".") || java.lang.Integer.parseInt(valueOf7) < 0)) {
                            if (biddingListener != null) {
                                biddingListener.onBiddingResult(false, h, null);
                            }
                            return false;
                        }
                    }
                    if (linkedHashMap.containsKey("is_c")) {
                        java.lang.String valueOf8 = java.lang.String.valueOf(linkedHashMap.get("is_c"));
                        if (android.text.TextUtils.isEmpty(valueOf8) && (valueOf8.contains(".") || java.lang.Integer.parseInt(valueOf8) < 0)) {
                            if (biddingListener != null) {
                                biddingListener.onBiddingResult(false, i, null);
                            }
                            return false;
                        }
                    }
                }
            } catch (java.lang.Throwable th) {
                if (biddingListener != null) {
                    biddingListener.onBiddingResult(false, a, null);
                }
                th.printStackTrace();
                return false;
            }
        }
        if (biddingListener != null) {
            biddingListener.onBiddingResult(true, "success", null);
        }
        return true;
    }
}
