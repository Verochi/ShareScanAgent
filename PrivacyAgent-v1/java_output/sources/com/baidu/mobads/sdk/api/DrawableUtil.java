package com.baidu.mobads.sdk.api;

/* loaded from: classes.dex */
public class DrawableUtil {
    public static java.lang.Integer getDrawableId(java.lang.String str) {
        if ("blur_bg_white".equals(str)) {
            return java.lang.Integer.valueOf(com.baidu.mobads.proxy.R.drawable.bd_bg_blur_white);
        }
        if (com.baidu.mobads.sdk.internal.b.a.C0251a.b.equals(str)) {
            return java.lang.Integer.valueOf(com.baidu.mobads.proxy.R.drawable.bd_rsp_small_red_heart);
        }
        if (com.baidu.mobads.sdk.internal.b.a.C0251a.a.equals(str)) {
            return java.lang.Integer.valueOf(com.baidu.mobads.proxy.R.drawable.bd_rsp_big_red_heart);
        }
        return null;
    }
}
