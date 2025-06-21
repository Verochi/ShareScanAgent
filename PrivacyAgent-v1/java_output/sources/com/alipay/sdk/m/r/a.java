package com.alipay.sdk.m.r;

/* loaded from: classes.dex */
public enum a {
    None("none"),
    WapPay("js://wappay"),
    Update("js://update"),
    OpenWeb("loc:openweb"),
    SetResult("loc:setResult"),
    Exit("loc:exit");

    public java.lang.String a;

    a(java.lang.String str) {
        this.a = str;
    }

    public static com.alipay.sdk.m.r.a a(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return None;
        }
        com.alipay.sdk.m.r.a aVar = None;
        for (com.alipay.sdk.m.r.a aVar2 : values()) {
            if (str.startsWith(aVar2.a)) {
                return aVar2;
            }
        }
        return aVar;
    }
}
