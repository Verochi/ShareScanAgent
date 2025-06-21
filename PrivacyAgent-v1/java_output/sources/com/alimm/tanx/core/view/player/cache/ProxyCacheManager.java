package com.alimm.tanx.core.view.player.cache;

/* loaded from: classes.dex */
public class ProxyCacheManager {
    public static final java.lang.String CACHE_DIR = "video-cache";
    public static final int MAX_CACHE_FILE = 10;
    public static java.io.File cacheRoot;
    public static com.alimm.tanx.core.view.player.cache.videocache.file.FileNameGenerator fileNameGenerator;
    private static com.alimm.tanx.core.view.player.cache.videocache.HttpProxyCacheServer sharedProxy;

    private ProxyCacheManager() {
    }

    public static boolean clearAllCache(android.content.Context context) {
        try {
            getProxy(context);
        } catch (java.lang.Exception e) {
            com.alimm.tanx.core.utils.LogUtils.e("ProxyCacheManager", e);
        }
        return com.alimm.tanx.core.utils.FileUtil.deleteFiles(com.alimm.tanx.core.utils.FileUtil.getIndividualCacheDirectory(context, CACHE_DIR));
    }

    public static java.io.File getCacheFile(java.lang.String str) {
        return new java.io.File(cacheRoot, fileNameGenerator.generate(str));
    }

    public static com.alimm.tanx.core.view.player.cache.videocache.HttpProxyCacheServer getProxy(android.content.Context context) {
        com.alimm.tanx.core.view.player.cache.videocache.HttpProxyCacheServer httpProxyCacheServer = sharedProxy;
        if (httpProxyCacheServer != null) {
            return httpProxyCacheServer;
        }
        com.alimm.tanx.core.view.player.cache.videocache.HttpProxyCacheServer newProxy = newProxy(context);
        sharedProxy = newProxy;
        return newProxy;
    }

    public static java.io.File getTempCacheFile(java.lang.String str) {
        return new java.io.File(cacheRoot, fileNameGenerator.generate(str) + ".download");
    }

    private static com.alimm.tanx.core.view.player.cache.videocache.HttpProxyCacheServer newProxy(android.content.Context context) {
        cacheRoot = com.alimm.tanx.core.utils.FileUtil.getIndividualCacheDirectory(context, CACHE_DIR);
        fileNameGenerator = new com.alimm.tanx.core.view.player.cache.videocache.file.Md5FileNameGenerator();
        return new com.alimm.tanx.core.view.player.cache.videocache.HttpProxyCacheServer.Builder(context).maxCacheFilesCount(10).cacheDirectory(cacheRoot).build();
    }
}
