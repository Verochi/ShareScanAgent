package com.alipay.apmobilesecuritysdk.d;

/* loaded from: classes.dex */
public final class e {
    public static java.util.Map<java.lang.String, java.lang.String> a;
    public static final java.lang.String[] b = {"AD1", "AD2", "AD3", "AD8", "AD9", "AD10", "AD11", "AD12", "AD14", "AD15", "AD16", "AD18", "AD20", "AD21", "AD23", "AD24", "AD26", "AD27", "AD28", "AD29", "AD30", "AD31", "AD34", "AA1", "AA2", "AA3", "AA4", "AC4", "AC10", "AE1", "AE2", "AE3", "AE4", "AE5", "AE6", "AE7", "AE8", "AE9", "AE10", "AE11", "AE12", "AE13", "AE14", "AE15"};

    public static java.lang.String a(java.util.Map<java.lang.String, java.lang.String> map) {
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        java.util.ArrayList arrayList = new java.util.ArrayList(map.keySet());
        java.util.Collections.sort(arrayList);
        for (int i = 0; i < arrayList.size(); i++) {
            java.lang.String str = (java.lang.String) arrayList.get(i);
            java.lang.String str2 = map.get(str);
            java.lang.String str3 = "";
            if (str2 == null) {
                str2 = "";
            }
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            if (i != 0) {
                str3 = "&";
            }
            sb.append(str3);
            sb.append(str);
            sb.append(com.huawei.hms.framework.common.ContainerUtils.KEY_VALUE_DELIMITER);
            sb.append(str2);
            stringBuffer.append(sb.toString());
        }
        return stringBuffer.toString();
    }

    public static synchronized java.util.Map<java.lang.String, java.lang.String> a(android.content.Context context, java.util.Map<java.lang.String, java.lang.String> map) {
        java.util.Map<java.lang.String, java.lang.String> map2;
        synchronized (com.alipay.apmobilesecuritysdk.d.e.class) {
            if (a == null) {
                c(context, map);
            }
            a.putAll(com.alipay.apmobilesecuritysdk.d.d.a());
            map2 = a;
        }
        return map2;
    }

    public static synchronized void a() {
        synchronized (com.alipay.apmobilesecuritysdk.d.e.class) {
            a = null;
        }
    }

    public static synchronized java.lang.String b(android.content.Context context, java.util.Map<java.lang.String, java.lang.String> map) {
        java.lang.String a2;
        synchronized (com.alipay.apmobilesecuritysdk.d.e.class) {
            a(context, map);
            java.util.TreeMap treeMap = new java.util.TreeMap();
            for (java.lang.String str : b) {
                if (a.containsKey(str)) {
                    treeMap.put(str, a.get(str));
                }
            }
            a2 = com.alipay.sdk.m.y.b.a(a(treeMap));
        }
        return a2;
    }

    public static synchronized void c(android.content.Context context, java.util.Map<java.lang.String, java.lang.String> map) {
        synchronized (com.alipay.apmobilesecuritysdk.d.e.class) {
            java.util.TreeMap treeMap = new java.util.TreeMap();
            a = treeMap;
            treeMap.putAll(com.alipay.apmobilesecuritysdk.d.b.a(context, map));
            a.putAll(com.alipay.apmobilesecuritysdk.d.d.a(context));
            a.putAll(com.alipay.apmobilesecuritysdk.d.c.a(context));
            a.putAll(com.alipay.apmobilesecuritysdk.d.a.a(context, map));
        }
    }
}
