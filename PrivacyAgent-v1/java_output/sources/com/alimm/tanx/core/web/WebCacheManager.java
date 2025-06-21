package com.alimm.tanx.core.web;

/* loaded from: classes.dex */
public class WebCacheManager {
    private static com.alimm.tanx.core.web.WebCacheManager instance;

    /* renamed from: com.alimm.tanx.core.web.WebCacheManager$1, reason: invalid class name */
    public class AnonymousClass1 implements com.alimm.tanx.core.web.cache.ResourceInterceptor {
        public AnonymousClass1() {
        }

        @Override // com.alimm.tanx.core.web.cache.ResourceInterceptor
        public boolean interceptor(java.lang.String str) {
            return true;
        }
    }

    public static com.alimm.tanx.core.web.WebCacheManager getInstance() {
        if (instance == null) {
            synchronized (com.alimm.tanx.core.web.WebCacheManager.class) {
                if (instance == null) {
                    instance = new com.alimm.tanx.core.web.WebCacheManager();
                }
            }
        }
        return instance;
    }

    private void initWebViewCache(android.content.Context context) {
        com.alimm.tanx.core.web.cache.WebViewCacheInterceptor.Builder builder = new com.alimm.tanx.core.web.cache.WebViewCacheInterceptor.Builder(context);
        builder.setCachePath(new java.io.File(context.getCacheDir(), "cache_path_name")).setDynamicCachePath(new java.io.File(context.getCacheDir(), "dynamic_webview_cache")).setCacheSize(52428800L).setConnectTimeoutSecond(20L).setReadTimeoutSecond(20L);
        com.alimm.tanx.core.web.cache.config.CacheExtensionConfig cacheExtensionConfig = new com.alimm.tanx.core.web.cache.config.CacheExtensionConfig();
        cacheExtensionConfig.addExtension(com.aliyun.auth.common.AliyunVodHttpCommon.Format.FORMAT_JSON).removeExtension("swf");
        builder.setCacheExtensionConfig(cacheExtensionConfig);
        builder.setDebug(com.alimm.tanx.core.utils.LogUtils.isDebug(""));
        builder.setResourceInterceptor(new com.alimm.tanx.core.web.WebCacheManager.AnonymousClass1());
        com.alimm.tanx.core.web.cache.WebViewCacheInterceptorInst.getInstance().init(builder);
    }

    private void preload() {
        com.alimm.tanx.core.web.webview.PreloadWebView.getInstance().preload(true);
    }

    public void destroy() {
        com.alimm.tanx.core.web.webview.PreloadWebView.getInstance().destroy();
    }

    public com.alimm.tanx.core.web.webview.AdWebViewManager getAdWebView() {
        return new com.alimm.tanx.core.web.webview.AdWebViewManager();
    }

    public void init(android.content.Context context) {
        preload();
        initWebViewCache(context);
    }
}
