package com.zx.module.base;

/* loaded from: classes19.dex */
public interface ZXModule {
    java.lang.String getModuleIdentifier();

    java.lang.String getModuleVersion();

    java.lang.String invoke(java.lang.String str, java.lang.String str2) throws com.zx.module.exception.ZXModuleInvokeException;

    java.lang.String invokeAsync(java.lang.String str, java.lang.String str2, com.zx.module.base.Callback callback) throws com.zx.module.exception.ZXModuleInvokeException;

    void onCreate(com.zx.module.context.ContextHolder contextHolder) throws com.zx.module.exception.ZXModuleOnCreateException;

    void onDestroy() throws com.zx.module.exception.ZXModuleOnDestroyException;

    void setMessageListener(com.zx.module.base.Listener listener);

    void start() throws com.zx.module.exception.ZXModuleStartException;
}
