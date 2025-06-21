package com.autonavi.base.amap.mapcore;

/* loaded from: classes12.dex */
public class AeUtil {
    private static final java.lang.String AMAP_ASSETS_DB_CK_PATH = "ae/res.ck";
    private static final java.lang.String AMAP_GLOBAL_DB_NAME = "global.db";
    private static final java.lang.String AMAP_GLOBAL_SP_ITEM_MD5 = "amap_res_global_db_md5";
    private static final java.lang.String AMAP_GLOBAL_SP_NAME = "amap_res_global_db";
    private static final java.lang.String AMAP_INTERSECTION_ASSETS_DIR = "VM3DRes";
    public static final java.lang.String AMAP_RESZIP_TARGET_DIR_NAME = "res910";
    public static final java.lang.String CONFIGNAME = "GNaviConfig.xml";
    public static final boolean IS_AE = true;
    public static final java.lang.String RESZIPNAME = "res.zip";
    public static final java.lang.String ROOTPATH = "/amap/";
    public static final java.lang.String ROOT_DATA_PATH_NAME = "data_v6";
    public static final java.lang.String ROOT_DATA_PATH_OLD_NAME = "data";
    private static java.lang.String global_db_path;

    /* renamed from: com.autonavi.base.amap.mapcore.AeUtil$1, reason: invalid class name */
    public static class AnonymousClass1 extends com.amap.api.mapcore.util.ij {
        final /* synthetic */ android.content.Context val$context;
        final /* synthetic */ java.lang.String val$currentPath;

        public AnonymousClass1(java.lang.String str, android.content.Context context) {
            this.val$currentPath = str;
            this.val$context = context;
        }

        @Override // com.amap.api.mapcore.util.ij
        public final void runTask() {
            com.autonavi.base.amap.mapcore.AeUtil.loadEngineRes(this.val$currentPath, this.val$context);
        }
    }

    /* renamed from: com.autonavi.base.amap.mapcore.AeUtil$2, reason: invalid class name */
    public static class AnonymousClass2 extends com.amap.api.mapcore.util.ij {
        final /* synthetic */ android.content.Context val$context;
        final /* synthetic */ com.autonavi.base.ae.gmap.GLMapEngine.InitParam val$param;

        public AnonymousClass2(com.autonavi.base.ae.gmap.GLMapEngine.InitParam initParam, android.content.Context context) {
            this.val$param = initParam;
            this.val$context = context;
        }

        @Override // com.amap.api.mapcore.util.ij
        public final void runTask() {
            com.autonavi.base.amap.mapcore.AeUtil.loadAndSaveIntersectionRes("map_assets/VM3DRes", this.val$param.mIntersectionResPath, this.val$context);
        }
    }

    private static boolean checkEngineRes(java.io.File file) {
        java.io.File[] listFiles = file.listFiles();
        if (listFiles != null && listFiles.length > 0) {
            for (java.io.File file2 : listFiles) {
                if (file2 != null && file2.getName().contains(AMAP_GLOBAL_DB_NAME)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static java.lang.String formatFileSeparator(java.lang.String str) {
        return str != null ? str.replace("//", net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR) : str;
    }

    private static java.lang.String getAssetsGlobalDbMd5(android.content.Context context) {
        return new java.lang.String(com.autonavi.base.amap.mapcore.FileUtil.readFileContentsFromAssets(context, AMAP_ASSETS_DB_CK_PATH));
    }

    public static java.lang.String getGlobalDbPath() {
        return global_db_path;
    }

    public static void initCrashHandle(android.content.Context context) {
        com.amap.api.mapcore.util.fh a;
        try {
            com.amap.api.mapcore.util.gn.a();
            if (!com.amap.api.mapcore.util.gl.a(com.amap.api.mapcore.util.dl.a()).a(context) || (a = com.amap.api.mapcore.util.dl.a()) == null) {
                return;
            }
            com.autonavi.amap.mapcore.MsgProcessor.nativeInitInfo(context, com.amap.api.mapcore.util.gl.a(a).b(context), a.a(), a.b(), a.c(), a.g());
        } catch (java.lang.Throwable th) {
            com.amap.api.mapcore.util.dl.a(th);
        }
    }

    public static void initIntersectionRes(android.content.Context context, com.autonavi.base.ae.gmap.GLMapEngine.InitParam initParam) {
        java.lang.String mapBaseStorage = com.autonavi.base.amap.mapcore.FileUtil.getMapBaseStorage(context);
        java.lang.String str = mapBaseStorage + "/VM3DRes/";
        java.io.File file = new java.io.File(mapBaseStorage);
        if (!file.exists()) {
            file.mkdir();
        }
        java.io.File file2 = new java.io.File(str);
        if (!file2.exists()) {
            file2.mkdir();
        }
        initParam.mIntersectionResPath = str;
        initParam.mIntersectionResPath = formatFileSeparator(str);
        if (android.os.Looper.myLooper() != android.os.Looper.getMainLooper()) {
            loadAndSaveIntersectionRes("map_assets/VM3DRes", initParam.mIntersectionResPath, context);
            return;
        }
        try {
            com.amap.api.mapcore.util.dj.a().a(new com.autonavi.base.amap.mapcore.AeUtil.AnonymousClass2(initParam, context));
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    public static com.autonavi.base.ae.gmap.GLMapEngine.InitParam initResource(android.content.Context context) {
        java.lang.String mapBaseStorage = com.autonavi.base.amap.mapcore.FileUtil.getMapBaseStorage(context);
        java.lang.String str = mapBaseStorage + "/data_v6/";
        java.io.File file = new java.io.File(mapBaseStorage);
        if (!file.exists()) {
            file.mkdir();
        }
        java.io.File file2 = new java.io.File(str);
        if (!file2.exists()) {
            file2.mkdir();
        }
        if (android.os.Looper.myLooper() == android.os.Looper.getMainLooper()) {
            try {
                com.amap.api.mapcore.util.dj.a().a(new com.autonavi.base.amap.mapcore.AeUtil.AnonymousClass1(mapBaseStorage, context));
            } catch (java.lang.Exception e) {
                e.printStackTrace();
            }
        } else {
            loadEngineRes(mapBaseStorage, context);
        }
        com.autonavi.base.ae.gmap.GLMapEngine.InitParam initParam = new com.autonavi.base.ae.gmap.GLMapEngine.InitParam();
        byte[] readFileContentsFromAssets = com.autonavi.base.amap.mapcore.FileUtil.readFileContentsFromAssets(context, "ae/GNaviConfig.xml");
        initParam.mRootPath = mapBaseStorage;
        if (readFileContentsFromAssets != null) {
            try {
                java.lang.String str2 = new java.lang.String(readFileContentsFromAssets, "utf-8");
                initParam.mConfigContent = str2;
                if (!str2.contains(ROOT_DATA_PATH_NAME)) {
                    throw new java.lang.Exception("GNaviConfig.xml 和数据目录data_v6不匹配");
                }
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
                com.amap.api.mapcore.util.di.c(context, "initConfig error:" + th.getMessage());
            }
        }
        java.lang.String str3 = str + "/map/";
        initParam.mOfflineDataPath = str3;
        initParam.mP3dCrossPath = str;
        initParam.mOfflineDataPath = formatFileSeparator(str3);
        initParam.mRootPath = formatFileSeparator(initParam.mRootPath);
        initParam.mP3dCrossPath = formatFileSeparator(initParam.mP3dCrossPath);
        return initParam;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void loadAndSaveIntersectionRes(java.lang.String str, java.lang.String str2, android.content.Context context) {
        java.io.File file = new java.io.File(str2);
        if (!file.exists()) {
            file.mkdirs();
        }
        try {
            java.lang.String[] list = context.getAssets().list(str);
            if (list == null) {
                return;
            }
            for (java.lang.String str3 : list) {
                readAssetsFileAndSave(str + net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR + str3, new java.io.File(str2, str3).getAbsolutePath(), context);
            }
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(11:0|1|(1:53)(1:5)|6|(6:8|(1:10)|(1:13)|14|15|(6:23|24|(1:26)|27|29|(2:19|20)(1:22))(2:17|(0)(0)))|50|(0)|14|15|(0)(0)|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0040, code lost:
    
        if (r8.equals(r10) != false) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0077, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0078, code lost:
    
        r0.printStackTrace();
     */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x004f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:48:0x0078 -> B:26:0x00da). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void loadEngineRes(java.lang.String str, android.content.Context context) {
        java.lang.String assetsGlobalDbMd5;
        boolean z;
        java.io.File file = new java.io.File(str, AMAP_RESZIP_TARGET_DIR_NAME);
        boolean z2 = true;
        java.io.InputStream inputStream = null;
        if (!(file.exists() && file.isDirectory()) && file.mkdirs()) {
            assetsGlobalDbMd5 = getAssetsGlobalDbMd5(context);
            z = true;
        } else {
            assetsGlobalDbMd5 = null;
            z = false;
        }
        if (!z) {
            assetsGlobalDbMd5 = getAssetsGlobalDbMd5(context);
            java.lang.String a = com.amap.api.mapcore.util.db.a(context, AMAP_GLOBAL_SP_NAME, AMAP_GLOBAL_SP_ITEM_MD5, "");
            if (!android.text.TextUtils.isEmpty(a)) {
            }
            if (z2 ? false : checkEngineRes(file)) {
                try {
                    try {
                        try {
                            inputStream = context.getAssets().open("ae/res.zip");
                            com.autonavi.base.amap.mapcore.FileUtil.decompress(inputStream, file.getAbsolutePath());
                            global_db_path = file + "/global.db";
                            if (inputStream != null) {
                                inputStream.close();
                            }
                        } catch (java.lang.Exception e) {
                            e.printStackTrace();
                            com.amap.api.mapcore.util.dl.a(e);
                            com.amap.api.mapcore.util.di.c(context, "loadEngineRes error:" + e.getMessage());
                            if (inputStream != null) {
                                inputStream.close();
                            }
                        }
                    } catch (java.lang.OutOfMemoryError e2) {
                        e2.printStackTrace();
                        com.amap.api.mapcore.util.dl.a(e2);
                        com.amap.api.mapcore.util.di.c(context, "loadEngineRes error:" + e2.getMessage());
                        if (inputStream != null) {
                            inputStream.close();
                        }
                    }
                    if (z2) {
                        return;
                    }
                    com.amap.api.mapcore.util.db.a(context, AMAP_GLOBAL_SP_NAME, AMAP_GLOBAL_SP_ITEM_MD5, (java.lang.Object) assetsGlobalDbMd5);
                    return;
                } catch (java.lang.Throwable th) {
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (java.io.IOException e3) {
                            e3.printStackTrace();
                        }
                    }
                    throw th;
                }
            }
            global_db_path = file + "/global.db";
            if (z2) {
            }
        }
        z2 = z;
        if (z2 ? false : checkEngineRes(file)) {
        }
    }

    public static boolean loadLib(android.content.Context context) {
        try {
            if (!com.autonavi.config.a.b) {
                java.lang.System.loadLibrary(com.autonavi.config.a.a);
                com.autonavi.config.a.b = true;
            }
            return true;
        } catch (java.lang.Throwable th) {
            com.amap.api.mapcore.util.gd.c(th, "AeUtil", "loadLib");
            com.amap.api.mapcore.util.dl.a(th);
            com.amap.api.mapcore.util.dn.b(com.amap.api.mapcore.util.dm.c, "load so failed " + th.getMessage());
            return false;
        }
    }

    public static void readAssetsFileAndSave(java.lang.String str, java.lang.String str2, android.content.Context context) {
        java.io.FileOutputStream fileOutputStream;
        if (android.text.TextUtils.isEmpty(str)) {
            return;
        }
        java.io.InputStream inputStream = null;
        try {
            java.io.InputStream open = context.getAssets().open(str);
            try {
                java.io.File file = new java.io.File(str2);
                if (file.exists()) {
                    file.delete();
                }
                file.createNewFile();
                java.io.FileOutputStream fileOutputStream2 = new java.io.FileOutputStream(file);
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = open.read(bArr, 0, 1024);
                        if (read > 0) {
                            fileOutputStream2.write(bArr, 0, read);
                        } else {
                            try {
                                break;
                            } catch (java.io.IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                    open.close();
                    try {
                        fileOutputStream2.close();
                    } catch (java.io.IOException e2) {
                        e2.printStackTrace();
                    }
                } catch (java.lang.Throwable th) {
                    inputStream = open;
                    fileOutputStream = fileOutputStream2;
                    th = th;
                    try {
                        th.printStackTrace();
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (java.io.IOException e3) {
                                e3.printStackTrace();
                            }
                        }
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (java.io.IOException e4) {
                                e4.printStackTrace();
                            }
                        }
                    } finally {
                    }
                }
            } catch (java.lang.Throwable th2) {
                th = th2;
                inputStream = open;
                fileOutputStream = null;
            }
        } catch (java.lang.Throwable th3) {
            th = th3;
            fileOutputStream = null;
        }
    }
}
