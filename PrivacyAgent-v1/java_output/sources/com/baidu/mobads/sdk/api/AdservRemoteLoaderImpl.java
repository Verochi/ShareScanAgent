package com.baidu.mobads.sdk.api;

@com.baidu.mobads.sdk.api.Route(path = com.baidu.mobads.sdk.internal.c.a.a)
/* loaded from: classes.dex */
public class AdservRemoteLoaderImpl implements com.baidu.mobads.sdk.internal.u {
    @Override // com.baidu.mobads.sdk.internal.u
    public dalvik.system.DexClassLoader getClassLoaderFromJar(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.ClassLoader classLoader) {
        return com.baidu.mobads.sdk.internal.f.a().a(str, str2, str3, classLoader);
    }

    @Override // com.baidu.mobads.sdk.internal.u
    public void startLoadRemotePhp(double d, com.baidu.mobads.sdk.internal.am.b bVar) {
        com.baidu.mobads.sdk.internal.f.a().a(d, bVar);
    }
}
