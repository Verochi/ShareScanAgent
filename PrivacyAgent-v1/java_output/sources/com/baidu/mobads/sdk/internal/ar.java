package com.baidu.mobads.sdk.internal;

/* loaded from: classes.dex */
public class ar extends com.baidu.mobads.sdk.api.RouteInfo {
    private com.baidu.mobads.sdk.internal.y a;

    public ar(java.lang.String str) {
        setPath(str);
        b();
    }

    private void b() {
        com.baidu.mobads.sdk.api.RouteInfo routeInfo;
        try {
            java.lang.reflect.Method declaredMethod = java.lang.Class.forName(com.baidu.mobads.sdk.internal.z.ar + getPath()).getDeclaredMethod("getRoutesMap", new java.lang.Class[0]);
            declaredMethod.setAccessible(true);
            java.util.HashMap hashMap = (java.util.HashMap) declaredMethod.invoke(null, new java.lang.Object[0]);
            if (hashMap == null || hashMap.size() <= 0 || (routeInfo = (com.baidu.mobads.sdk.api.RouteInfo) hashMap.get(getPath())) == null) {
                return;
            }
            this.a = (com.baidu.mobads.sdk.internal.y) routeInfo.getDestination().getConstructor(new java.lang.Class[0]).newInstance(new java.lang.Object[0]);
        } catch (java.lang.Throwable unused) {
        }
    }

    public java.lang.Object a() {
        return this.a;
    }
}
