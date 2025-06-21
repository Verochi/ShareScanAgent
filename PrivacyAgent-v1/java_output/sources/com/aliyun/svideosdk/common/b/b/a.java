package com.aliyun.svideosdk.common.b.b;

/* loaded from: classes12.dex */
public class a {
    private static final java.util.List<java.lang.String> a;
    private static final java.util.List<java.lang.String> b;

    static {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        a = arrayList;
        java.util.ArrayList arrayList2 = new java.util.ArrayList();
        b = arrayList2;
        arrayList.add(com.aliyun.common.whitelist.DeviceModelList.HUWEI.HUAWEI_P6);
        arrayList2.add("M5s");
    }

    public static final boolean a(java.lang.String str) {
        return b.contains(str);
    }
}
