package com.alimm.tanx.core.view.player.cache.videocache;

/* loaded from: classes.dex */
public final class StorageUtils {
    private static final java.lang.String INDIVIDUAL_DIR_NAME = "video-cache";
    private static final com.alimm.tanx.core.view.player.cache.videocache.log.Logger LOG = com.alimm.tanx.core.view.player.cache.videocache.log.LoggerFactory.getLogger("StorageUtils");

    public static boolean deleteFile(java.lang.String str) {
        java.io.File file = new java.io.File(str);
        if (!file.exists()) {
            return true;
        }
        if (file.isFile()) {
            return file.delete();
        }
        java.lang.String[] list = file.list();
        if (list != null) {
            for (java.lang.String str2 : list) {
                deleteFile(str + java.io.File.separator + str2);
            }
        }
        return file.delete();
    }

    public static boolean deleteFiles(java.io.File file) {
        java.io.File[] listFiles = file.listFiles();
        if (listFiles == null) {
            return true;
        }
        for (java.io.File file2 : listFiles) {
            if (!file2.isDirectory() && file2.exists() && !file2.delete()) {
                return false;
            }
        }
        return true;
    }

    private static java.io.File getCacheDirectory(android.content.Context context, boolean z) {
        java.io.File cacheDir = context.getCacheDir();
        if (cacheDir != null) {
            return cacheDir;
        }
        java.lang.String str = "/data/data/" + context.getPackageName() + "/cache/";
        LOG.warn("Can't define system cache directory! '" + str + "%s' will be used.");
        return new java.io.File(str);
    }

    public static java.io.File getIndividualCacheDirectory(android.content.Context context) {
        return new java.io.File(getCacheDirectory(context, true), "video-cache");
    }
}
