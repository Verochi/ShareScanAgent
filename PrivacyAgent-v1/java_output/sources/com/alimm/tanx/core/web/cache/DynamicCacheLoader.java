package com.alimm.tanx.core.web.cache;

/* loaded from: classes.dex */
public class DynamicCacheLoader {
    private static volatile com.alimm.tanx.core.web.cache.DynamicCacheLoader INSTANCE;

    public static com.alimm.tanx.core.web.cache.DynamicCacheLoader getInstance() {
        if (INSTANCE == null) {
            synchronized (com.alimm.tanx.core.web.cache.DynamicCacheLoader.class) {
                if (INSTANCE == null) {
                    INSTANCE = new com.alimm.tanx.core.web.cache.DynamicCacheLoader();
                }
            }
        }
        return INSTANCE;
    }

    public java.io.File getResByUrl(java.io.File file, java.lang.String str) {
        java.lang.String urlPath = getUrlPath(str);
        if (!file.isDirectory()) {
            if (urlPath.endsWith(file.getName())) {
                return file;
            }
            return null;
        }
        for (java.io.File file2 : file.listFiles()) {
            if (file2.isDirectory()) {
                java.io.File resByUrl = getResByUrl(file2, str);
                if (resByUrl != null) {
                    return resByUrl;
                }
            } else if (urlPath.endsWith(file2.getName())) {
                return file2;
            }
        }
        return null;
    }

    public java.lang.String getUrlPath(java.lang.String str) {
        try {
            java.lang.String path = new java.net.URL(str).getPath();
            return (!path.startsWith(net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR) || path.length() == 1) ? path : path.substring(1);
        } catch (java.net.MalformedURLException e) {
            e.printStackTrace();
            return "";
        }
    }
}
