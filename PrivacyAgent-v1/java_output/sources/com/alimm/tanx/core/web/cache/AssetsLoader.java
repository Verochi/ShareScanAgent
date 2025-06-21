package com.alimm.tanx.core.web.cache;

/* loaded from: classes.dex */
class AssetsLoader {
    private static volatile com.alimm.tanx.core.web.cache.AssetsLoader assetsLoader;
    private java.util.concurrent.CopyOnWriteArraySet<java.lang.String> mAssetResSet;
    private android.content.Context mContext;
    private java.lang.String mDir = "";
    private boolean mCleared = false;
    private boolean mIsSuffixMod = false;

    /* renamed from: com.alimm.tanx.core.web.cache.AssetsLoader$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.alimm.tanx.core.web.cache.AssetsLoader assetsLoader = com.alimm.tanx.core.web.cache.AssetsLoader.this;
            assetsLoader.initResourceNoneRecursion(assetsLoader.mDir);
        }
    }

    private void addAssetsFile(java.lang.String str) {
        int indexOf;
        java.lang.String str2 = this.mDir + java.io.File.separator;
        if (!android.text.TextUtils.isEmpty(this.mDir) && (indexOf = str.indexOf(str2)) >= 0) {
            str = str.substring(indexOf + str2.length());
        }
        this.mAssetResSet.add(str);
    }

    public static com.alimm.tanx.core.web.cache.AssetsLoader getInstance() {
        if (assetsLoader == null) {
            synchronized (com.alimm.tanx.core.web.cache.AssetsLoader.class) {
                if (assetsLoader == null) {
                    assetsLoader = new com.alimm.tanx.core.web.cache.AssetsLoader();
                }
            }
        }
        return assetsLoader;
    }

    private java.lang.String getUrlPath(java.lang.String str) {
        try {
            java.lang.String path = new java.net.URL(str).getPath();
            return (!path.startsWith(net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR) || path.length() == 1) ? path : path.substring(1);
        } catch (java.net.MalformedURLException e) {
            e.printStackTrace();
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.alimm.tanx.core.web.cache.AssetsLoader initResourceNoneRecursion(java.lang.String str) {
        try {
            java.util.LinkedList linkedList = new java.util.LinkedList();
            java.lang.String[] list = com.alimm.tanx.core.utils.AssetsUtil.getApplicationAssets(this.mContext).list(str);
            if (list != null && list.length > 0) {
                for (java.lang.String str2 : list) {
                    java.lang.String str3 = str + java.io.File.separator + str2;
                    java.lang.String[] list2 = com.alimm.tanx.core.utils.AssetsUtil.getApplicationAssets(this.mContext).list(str3);
                    if (list2 != null && list2.length != 0) {
                        linkedList.add(str3);
                    }
                    addAssetsFile(str3);
                }
            }
            while (!linkedList.isEmpty() && !this.mCleared) {
                java.lang.String str4 = (java.lang.String) linkedList.removeFirst();
                java.lang.String[] list3 = com.alimm.tanx.core.utils.AssetsUtil.getApplicationAssets(this.mContext).list(str4);
                if (list3 != null && list3.length != 0) {
                    for (java.lang.String str5 : list3) {
                        android.content.res.AssetManager applicationAssets = com.alimm.tanx.core.utils.AssetsUtil.getApplicationAssets(this.mContext);
                        java.lang.StringBuilder sb = new java.lang.StringBuilder();
                        sb.append(str4);
                        java.lang.String str6 = java.io.File.separator;
                        sb.append(str6);
                        sb.append(str5);
                        java.lang.String[] list4 = applicationAssets.list(sb.toString());
                        if (list4 != null && list4.length != 0) {
                            linkedList.add(str4 + str6 + str5);
                        }
                        addAssetsFile(str4 + str6 + str5);
                    }
                }
                addAssetsFile(str4);
            }
        } catch (java.lang.Exception e) {
            com.alimm.tanx.core.utils.LogUtils.e(e);
        }
        return this;
    }

    public void clear() {
        this.mCleared = true;
        java.util.concurrent.CopyOnWriteArraySet<java.lang.String> copyOnWriteArraySet = this.mAssetResSet;
        if (copyOnWriteArraySet == null || copyOnWriteArraySet.size() <= 0) {
            return;
        }
        this.mAssetResSet.clear();
    }

    public java.io.InputStream getAssetFileStream(java.lang.String str) {
        try {
            return com.alimm.tanx.core.utils.AssetsUtil.getApplicationAssets(this.mContext).open(str);
        } catch (java.io.IOException unused) {
            return null;
        }
    }

    public java.io.InputStream getResByUrl(java.lang.String str) {
        java.lang.String urlPath = getUrlPath(str);
        if (android.text.TextUtils.isEmpty(urlPath)) {
            return null;
        }
        if (!this.mIsSuffixMod) {
            if (android.text.TextUtils.isEmpty(this.mDir)) {
                return getAssetFileStream(urlPath);
            }
            return getAssetFileStream(this.mDir + java.io.File.separator + urlPath);
        }
        java.util.concurrent.CopyOnWriteArraySet<java.lang.String> copyOnWriteArraySet = this.mAssetResSet;
        if (copyOnWriteArraySet != null) {
            java.util.Iterator<java.lang.String> it = copyOnWriteArraySet.iterator();
            while (it.hasNext()) {
                java.lang.String next = it.next();
                if (urlPath.endsWith(next)) {
                    if (android.text.TextUtils.isEmpty(this.mDir)) {
                        return getAssetFileStream(next);
                    }
                    return getAssetFileStream(this.mDir + java.io.File.separator + next);
                }
            }
        }
        return null;
    }

    public com.alimm.tanx.core.web.cache.AssetsLoader init(android.content.Context context) {
        this.mContext = context;
        this.mAssetResSet = new java.util.concurrent.CopyOnWriteArraySet<>();
        this.mCleared = false;
        return this;
    }

    public com.alimm.tanx.core.web.cache.AssetsLoader initData() {
        if (this.mIsSuffixMod && this.mAssetResSet.size() == 0) {
            new java.lang.Thread(new com.alimm.tanx.core.web.cache.AssetsLoader.AnonymousClass1()).start();
        }
        return this;
    }

    public com.alimm.tanx.core.web.cache.AssetsLoader isAssetsSuffixMod(boolean z) {
        this.mIsSuffixMod = z;
        return this;
    }

    public com.alimm.tanx.core.web.cache.AssetsLoader setDir(java.lang.String str) {
        this.mDir = str;
        return this;
    }
}
