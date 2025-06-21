package com.aliyun.svideo.editor.util;

/* loaded from: classes12.dex */
public class EditorCommon {
    public static final java.lang.String BASE_URL = "https://m-api.qupaicloud.com";
    public static final java.lang.String QU_ANIMATION_FILTER = "aliyun_svideo_animation_filter";
    public static final int QU_ANIMATION_FILTER_ID = 0;
    public static final java.lang.String QU_ANIMATION_SPLIT_SCREEN_FILTER = "aliyun_svideo_split_screen_filters";
    public static final int QU_ANIMATION_SPLIT_SCREEN_FILTER_ID = 1;
    public static final java.lang.String QU_CAPTION = "aliyun_svideo_caption";
    public static final java.lang.String QU_COLOR_FILTER = "aliyun_svideo_filter";
    public static java.lang.String QU_DIR = null;
    public static final java.lang.String QU_LUT_FILTER_DEFAULT_GROUP = "default";
    public static final java.lang.String QU_MV = "aliyun_svideo_mv";
    public static final java.lang.String QU_NAME = "AliyunEditorDemo";
    public static final java.lang.String QU_OVERLAY = "aliyun_svideo_overlay";
    public static java.lang.String SD_DIR = null;
    private static final java.lang.String TAG = "Common";
    private static int length;
    private static java.lang.ref.WeakReference<android.view.View> mView;
    private static java.lang.Object object = new java.lang.Object();
    private static final java.lang.String MV1_1 = "folder1.1";
    private static final java.lang.String MV3_4 = "folder3.4";
    private static final java.lang.String MV4_3 = "folder4.3";
    private static final java.lang.String MV9_16 = "folder9.16";
    private static final java.lang.String MV16_9 = "folder16.9";
    public static java.lang.String[] mv_dirs = {MV1_1, MV3_4, MV4_3, MV9_16, MV16_9};

    /* renamed from: com.aliyun.svideo.editor.util.EditorCommon$1, reason: invalid class name */
    public class AnonymousClass1 implements java.io.FilenameFilter {
        @Override // java.io.FilenameFilter
        public boolean accept(java.io.File file, java.lang.String str) {
            return str != null && str.endsWith(".zip");
        }
    }

    /* renamed from: com.aliyun.svideo.editor.util.EditorCommon$2, reason: invalid class name */
    public class AnonymousClass2 extends android.os.AsyncTask {
        final /* synthetic */ java.io.File val$file;

        public AnonymousClass2(java.io.File file) {
            this.val$file = file;
        }

        @Override // android.os.AsyncTask
        public java.lang.Object doInBackground(java.lang.Object[] objArr) {
            try {
                int length = this.val$file.getAbsolutePath().length() - 4;
                if (!new java.io.File(this.val$file.getAbsolutePath().substring(0, length)).exists()) {
                    com.aliyun.svideo.editor.util.EditorCommon.unZipFolder(this.val$file.getAbsolutePath(), com.aliyun.svideo.editor.util.EditorCommon.SD_DIR + com.aliyun.svideo.editor.util.EditorCommon.QU_NAME);
                    com.aliyun.svideo.editor.util.EditorCommon.insertDB(this.val$file.getAbsolutePath().substring(0, length));
                }
                synchronized (com.aliyun.svideo.editor.util.EditorCommon.object) {
                    com.aliyun.svideo.editor.util.EditorCommon.length--;
                }
                return null;
            } catch (java.lang.Exception e) {
                e.printStackTrace();
                synchronized (com.aliyun.svideo.editor.util.EditorCommon.object) {
                    com.aliyun.svideo.editor.util.EditorCommon.length--;
                    return null;
                }
            }
        }

        @Override // android.os.AsyncTask
        public void onPostExecute(java.lang.Object obj) {
            synchronized (com.aliyun.svideo.editor.util.EditorCommon.object) {
                if (com.aliyun.svideo.editor.util.EditorCommon.length == 0 && !com.aliyun.svideo.editor.util.EditorCommon.isViewDestroy()) {
                    ((android.view.View) com.aliyun.svideo.editor.util.EditorCommon.mView.get()).setVisibility(8);
                }
            }
        }
    }

    public interface CopyCallback {
        void onFileCopy(java.lang.String str);
    }

    public static java.lang.String calculatePercent(java.util.List<com.aliyun.svideo.base.Form.AspectForm> list, int i, int i2) {
        java.lang.String str = null;
        if (list == null || list.size() == 0 || i2 <= 0 || i <= 0) {
            return null;
        }
        float f = i / i2;
        java.util.IdentityHashMap identityHashMap = new java.util.IdentityHashMap();
        int i3 = 0;
        int i4 = 0;
        while (i4 < list.size()) {
            int aspect = list.get(i4).getAspect();
            java.lang.String path = list.get(i4).getPath();
            if (aspect == 1) {
                if (exits(path + java.io.File.separator + MV1_1)) {
                    identityHashMap.put(new java.lang.Integer(1), java.lang.Float.valueOf(1.0f));
                    i4++;
                    str = path;
                }
            }
            if (aspect == 2) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append(path);
                java.lang.String str2 = java.io.File.separator;
                sb.append(str2);
                sb.append(MV3_4);
                if (exits(sb.toString())) {
                    identityHashMap.put(new java.lang.Integer(2), java.lang.Float.valueOf(0.75f));
                }
                if (exits(path + str2 + MV4_3)) {
                    identityHashMap.put(new java.lang.Integer(3), java.lang.Float.valueOf(1.3333334f));
                }
            } else if (aspect == 3) {
                java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
                sb2.append(path);
                java.lang.String str3 = java.io.File.separator;
                sb2.append(str3);
                sb2.append(MV9_16);
                if (exits(sb2.toString())) {
                    identityHashMap.put(new java.lang.Integer(4), java.lang.Float.valueOf(0.5625f));
                }
                if (exits(path + str3 + MV16_9)) {
                    identityHashMap.put(new java.lang.Integer(5), java.lang.Float.valueOf(1.7777778f));
                }
            }
            i4++;
            str = path;
        }
        float f2 = -1.0f;
        for (java.util.Map.Entry entry : identityHashMap.entrySet()) {
            if (f2 == -1.0f) {
                f2 = java.lang.Math.abs(f - ((java.lang.Float) entry.getValue()).floatValue());
                i3 = ((java.lang.Integer) entry.getKey()).intValue();
            } else {
                float abs = java.lang.Math.abs(f - ((java.lang.Float) entry.getValue()).floatValue());
                if (f2 >= abs) {
                    i3 = ((java.lang.Integer) entry.getKey()).intValue();
                    f2 = abs;
                }
            }
        }
        if (i3 == 0) {
            return str;
        }
        java.util.Iterator<com.aliyun.svideo.base.Form.AspectForm> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            com.aliyun.svideo.base.Form.AspectForm next = it.next();
            if (i3 == 1 && next.getAspect() == 1) {
                str = next.getPath();
                break;
            }
            if ((i3 == 2 || i3 == 3) && next.getAspect() == 2) {
                str = next.getPath();
                break;
            }
            if (i3 == 4 || i3 == 5) {
                if (next.getAspect() == 3) {
                    str = next.getPath();
                    break;
                }
            }
        }
        return str + java.io.File.separator + mv_dirs[i3 - 1];
    }

    public static void copyAll(android.content.Context context, android.view.View view) {
        SD_DIR = getExtFileDir(context);
        QU_DIR = SD_DIR + QU_NAME + java.io.File.separator;
        mView = new java.lang.ref.WeakReference<>(view);
        java.io.File file = new java.io.File(QU_DIR);
        copySelf(context, "font");
        copySelf(context, com.aliyun.svideo.editor.contant.CaptionConfig.COOL_TEXT_FILE_DIR);
        copySelf(context, com.aliyun.svideo.editor.contant.EditorConstants.LUT_FILE_DIR);
        copySelf(context, QU_NAME);
        file.mkdirs();
        unZip();
    }

    public static void copySelf(android.content.Context context, java.lang.String str) {
        copySelf(context, str, null);
    }

    public static void copySelf(android.content.Context context, java.lang.String str, com.aliyun.svideo.editor.util.EditorCommon.CopyCallback copyCallback) {
        try {
            if (com.aliyun.common.utils.StringUtils.isEmpty(SD_DIR)) {
                SD_DIR = getExtFileDir(context);
            }
            java.lang.String[] list = context.getAssets().list(str);
            if (list.length > 0) {
                java.io.File file = new java.io.File(SD_DIR + str);
                if (!file.exists()) {
                    file.mkdirs();
                }
                for (java.lang.String str2 : list) {
                    java.lang.StringBuilder sb = new java.lang.StringBuilder();
                    sb.append(SD_DIR);
                    sb.append(str);
                    java.lang.String str3 = java.io.File.separator;
                    sb.append(str3);
                    sb.append(str2);
                    java.io.File file2 = new java.io.File(sb.toString());
                    if (file2.isDirectory() || !file2.exists()) {
                        copySelf(context, str + str3 + str2, copyCallback);
                    }
                }
                return;
            }
            if (com.aliyun.common.utils.FileUtils.isFileExists(SD_DIR + str)) {
                return;
            }
            com.aliyun.common.logger.Logger.getDefaultLogger().d("copy...." + SD_DIR + str, new java.lang.Object[0]);
            java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
            sb2.append(SD_DIR);
            sb2.append(str);
            java.io.FileOutputStream fileOutputStream = new java.io.FileOutputStream(sb2.toString());
            java.io.InputStream open = context.getAssets().open(str);
            byte[] bArr = new byte[8192];
            for (int read = open.read(bArr); read > 0; read = open.read(bArr)) {
                fileOutputStream.write(bArr, 0, read);
            }
            fileOutputStream.flush();
            open.close();
            fileOutputStream.close();
            if (copyCallback != null) {
                copyCallback.onFileCopy(SD_DIR + str);
            }
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean exits(java.lang.String str) {
        if (str == null || "".equals(str)) {
            return false;
        }
        return new java.io.File(str).exists();
    }

    public static java.util.List<java.lang.String> getAnimationFilterList() {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.io.File file = new java.io.File(QU_DIR, QU_ANIMATION_FILTER);
        if (file.exists() && file.isDirectory()) {
            for (java.io.File file2 : file.listFiles()) {
                if (file2.exists()) {
                    arrayList.add(file2.getAbsolutePath());
                }
            }
        }
        return arrayList;
    }

    public static java.util.List<java.lang.String> getAnimationFilterListByDir(java.lang.String str) {
        if (str == null) {
            return null;
        }
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.io.File file = new java.io.File(str);
        if (file.exists() && file.isDirectory()) {
            java.io.File[] listFiles = file.listFiles();
            if (listFiles == null) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append("getAnimationFilterListByDir no file ,path = ");
                sb.append(str);
                return null;
            }
            for (java.io.File file2 : listFiles) {
                if (file2.exists() && !file2.getName().contains(".json")) {
                    arrayList.add(file2.getAbsolutePath());
                }
            }
        }
        return arrayList;
    }

    public static java.util.List<java.lang.String> getColorFilterList(android.content.Context context) {
        java.lang.String[] stringArray = context.getResources().getStringArray(com.aliyun.svideo.editor.R.array.filter_order);
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.lang.String localFilePath = com.moji.dynamic.DynamicLoadManager.getLocalFilePath(context, com.moji.dynamic.DynamicLoadType.ALI_FILTER);
        for (java.lang.String str : stringArray) {
            java.io.File file = com.moji.dynamic.DynamicLoadManager.isTypeReady(com.moji.dynamic.DynamicLoadType.ALI_FILTER) ? new java.io.File(localFilePath, str) : new java.io.File(QU_DIR + java.io.File.separator + QU_COLOR_FILTER, str);
            if (file.exists() && file.isDirectory()) {
                arrayList.add(file.getAbsolutePath());
            }
        }
        return arrayList;
    }

    public static java.util.List<java.lang.String> getCoolTextFileList() {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.io.File file = new java.io.File(SD_DIR, com.aliyun.svideo.editor.contant.CaptionConfig.COOL_TEXT_FILE_DIR);
        if (file.exists() && file.isDirectory()) {
            for (java.io.File file2 : file.listFiles()) {
                if (file2.exists()) {
                    arrayList.add(file2.getAbsolutePath());
                }
            }
        }
        return arrayList;
    }

    public static com.aliyun.svideo.base.Form.I18nBean getCurrentEffectI18n(java.lang.String str, java.lang.String str2) {
        java.io.File file = new java.io.File(str);
        java.io.File parentFile = file.getParentFile();
        java.io.File file2 = new java.io.File(parentFile, "i18n.json");
        if (!file.exists() || parentFile == null || !parentFile.exists() || !file2.exists()) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("getCurrentEffectI18n no file ,path = ");
            sb.append(str);
            return null;
        }
        try {
            return (com.aliyun.svideo.base.Form.I18nBean) new com.google.gson.Gson().fromJson((com.google.gson.JsonElement) new com.google.gson.JsonParser().parse(new java.io.InputStreamReader(new java.io.FileInputStream(file2))).getAsJsonObject().getAsJsonObject("children").getAsJsonObject(file.getName()).getAsJsonObject(str2), com.aliyun.svideo.base.Form.I18nBean.class);
        } catch (java.io.FileNotFoundException e) {
            java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
            sb2.append("getCurrentEffectI18n 解析json失败，msg = ");
            sb2.append(e.getMessage());
            return null;
        }
    }

    private static java.lang.String getExtFileDir(android.content.Context context) {
        return context.getExternalFilesDir("") + java.io.File.separator;
    }

    public static java.util.List<java.lang.String> getLutFilterList(android.content.Context context) {
        int[] intArray = context.getResources().getIntArray(com.aliyun.svideo.editor.R.array.lut_order);
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (int i : intArray) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append(SD_DIR);
            sb.append(com.aliyun.svideo.editor.contant.EditorConstants.LUT_FILE_DIR);
            java.lang.String str = java.io.File.separator;
            sb.append(str);
            sb.append("default");
            sb.append(str);
            sb.append(i);
            java.io.File file = new java.io.File(sb.toString(), "lookup.png");
            if (file.exists() && file.isFile()) {
                arrayList.add(file.getAbsolutePath());
            }
        }
        return arrayList;
    }

    public static java.lang.String getMVPath(java.util.List<com.aliyun.svideo.base.Form.AspectForm> list, int i, int i2) {
        if (list == null || list.size() == 0) {
            return null;
        }
        return calculatePercent(list, i, i2);
    }

    public static int getTotal(int[] iArr) {
        int i = 0;
        for (int i2 : iArr) {
            i += i2;
        }
        return i;
    }

    public static java.util.List<java.lang.String> getVideoEqList(android.content.Context context) {
        return java.util.Arrays.asList(context.getResources().getStringArray(com.aliyun.svideo.editor.R.array.videoeq_order));
    }

    private static void insertCaption() {
        com.aliyun.svideo.base.Form.ResourceForm resourceForm;
        java.util.List<com.aliyun.svideo.base.Form.PasterForm> pasterList;
        java.io.File file = new java.io.File(QU_DIR, QU_CAPTION);
        if (file.exists() && file.isDirectory()) {
            try {
                resourceForm = (com.aliyun.svideo.base.Form.ResourceForm) new com.aliyun.common.jasonparse.JSONSupportImpl().readValue(new java.io.File(file, "LocalPaster.json"), com.aliyun.svideo.base.Form.ResourceForm.class);
            } catch (java.lang.Exception e) {
                e.getMessage();
                resourceForm = null;
            }
            if (resourceForm == null || (pasterList = resourceForm.getPasterList()) == null) {
                return;
            }
            for (com.aliyun.svideo.base.Form.PasterForm pasterForm : pasterList) {
                com.aliyun.svideo.downloader.FileDownloaderModel fileDownloaderModel = new com.aliyun.svideo.downloader.FileDownloaderModel();
                fileDownloaderModel.setId(resourceForm.getId());
                fileDownloaderModel.setPath(QU_DIR + QU_CAPTION + java.io.File.separator + pasterForm.getName());
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append(fileDownloaderModel.getPath());
                sb.append("/icon.png");
                java.lang.String sb2 = sb.toString();
                fileDownloaderModel.setIcon(sb2);
                fileDownloaderModel.setDescription("assets");
                fileDownloaderModel.setIsnew(resourceForm.getIsNew());
                fileDownloaderModel.setName(resourceForm.getName());
                fileDownloaderModel.setNameEn(resourceForm.getNameEn());
                fileDownloaderModel.setLevel(resourceForm.getLevel());
                fileDownloaderModel.setEffectType(6);
                fileDownloaderModel.setUrl(fileDownloaderModel.getPath());
                fileDownloaderModel.setSubid(pasterForm.getId());
                fileDownloaderModel.setFontid(pasterForm.getFontId());
                fileDownloaderModel.setSubicon(sb2);
                fileDownloaderModel.setSubname(pasterForm.getName());
                fileDownloaderModel.setIsunzip(1);
                fileDownloaderModel.setTaskId(com.liulishuo.filedownloader.util.FileDownloadUtils.generateId(java.lang.String.valueOf(pasterForm.getId()), fileDownloaderModel.getPath()));
                java.util.HashMap<java.lang.String, java.lang.String> hashMap = new java.util.HashMap<>();
                hashMap.put(com.aliyun.svideo.downloader.FileDownloaderModel.SUBID, java.lang.String.valueOf(pasterForm.getId()));
                hashMap.put("task_id", java.lang.String.valueOf(fileDownloaderModel.getTaskId()));
                com.aliyun.svideo.downloader.DownloaderManager.getInstance().getDbController().insertDb(fileDownloaderModel, hashMap);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void insertDB(java.lang.String str) {
        if (str.endsWith(QU_MV)) {
            insertMV();
        } else if (str.endsWith(QU_CAPTION)) {
            insertCaption();
        } else if (str.endsWith(QU_OVERLAY)) {
            insertOverlay();
        }
    }

    private static void insertMV() {
        com.aliyun.svideo.base.Form.IMVForm iMVForm;
        java.io.File file = new java.io.File(QU_DIR, QU_MV);
        if (file.exists() && file.isDirectory()) {
            try {
                iMVForm = (com.aliyun.svideo.base.Form.IMVForm) new com.aliyun.common.jasonparse.JSONSupportImpl().readValue(new java.io.File(file, "LocalPaster.json"), com.aliyun.svideo.base.Form.IMVForm.class);
            } catch (java.lang.Exception e) {
                e.getMessage();
                iMVForm = null;
            }
            if (iMVForm != null) {
                for (com.aliyun.svideo.base.Form.AspectForm aspectForm : iMVForm.getAspectList()) {
                    com.aliyun.svideo.downloader.FileDownloaderModel fileDownloaderModel = new com.aliyun.svideo.downloader.FileDownloaderModel();
                    fileDownloaderModel.setEffectType(3);
                    fileDownloaderModel.setName(iMVForm.getName());
                    fileDownloaderModel.setNameEn(iMVForm.getNameEn());
                    fileDownloaderModel.setId(iMVForm.getId());
                    fileDownloaderModel.setPath(file.getAbsolutePath() + aspectForm.getPath());
                    fileDownloaderModel.setDescription("assets");
                    java.lang.StringBuilder sb = new java.lang.StringBuilder();
                    sb.append(fileDownloaderModel.getPath());
                    java.lang.String str = java.io.File.separator;
                    sb.append(str);
                    sb.append(com.aliyun.svideo.editor.contant.CaptionConfig.COOL_TEXT_FILE_ICON_NAME);
                    fileDownloaderModel.setPreviewpic(sb.toString());
                    fileDownloaderModel.setIcon(fileDownloaderModel.getPath() + str + com.aliyun.svideo.editor.contant.CaptionConfig.COOL_TEXT_FILE_ICON_NAME);
                    fileDownloaderModel.setAspect(aspectForm.getAspect());
                    fileDownloaderModel.setIsunzip(1);
                    fileDownloaderModel.setTaskId(com.liulishuo.filedownloader.util.FileDownloadUtils.generateId(java.lang.String.valueOf(fileDownloaderModel.getAspect()), fileDownloaderModel.getPath()));
                    java.util.HashMap<java.lang.String, java.lang.String> hashMap = new java.util.HashMap<>();
                    hashMap.put("task_id", java.lang.String.valueOf(com.liulishuo.filedownloader.util.FileDownloadUtils.generateId(java.lang.String.valueOf(fileDownloaderModel.getAspect()), fileDownloaderModel.getPath())));
                    hashMap.put("id", java.lang.String.valueOf(fileDownloaderModel.getId()));
                    hashMap.put(com.aliyun.svideo.downloader.FileDownloaderModel.ASPECT, java.lang.String.valueOf(fileDownloaderModel.getAspect()));
                    com.aliyun.svideo.downloader.DownloaderManager.getInstance().getDbController().insertDb(fileDownloaderModel, hashMap);
                }
            }
        }
    }

    private static void insertOverlay() {
        com.aliyun.svideo.base.Form.ResourceForm resourceForm;
        java.util.List<com.aliyun.svideo.base.Form.PasterForm> pasterList;
        java.io.File file = new java.io.File(QU_DIR, QU_OVERLAY);
        com.aliyun.common.jasonparse.JSONSupportImpl jSONSupportImpl = new com.aliyun.common.jasonparse.JSONSupportImpl();
        if (file.exists() && file.isDirectory()) {
            try {
                resourceForm = (com.aliyun.svideo.base.Form.ResourceForm) jSONSupportImpl.readValue(new java.io.File(file, "LocalPaster.json"), com.aliyun.svideo.base.Form.ResourceForm.class);
            } catch (java.lang.Exception e) {
                e.getMessage();
                resourceForm = null;
            }
            if (resourceForm == null || (pasterList = resourceForm.getPasterList()) == null) {
                return;
            }
            for (com.aliyun.svideo.base.Form.PasterForm pasterForm : pasterList) {
                com.aliyun.svideo.downloader.FileDownloaderModel fileDownloaderModel = new com.aliyun.svideo.downloader.FileDownloaderModel();
                fileDownloaderModel.setId(resourceForm.getId());
                fileDownloaderModel.setPath(QU_DIR + QU_OVERLAY + java.io.File.separator + pasterForm.getName());
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append(fileDownloaderModel.getPath());
                sb.append("/icon.png");
                java.lang.String sb2 = sb.toString();
                fileDownloaderModel.setIcon(sb2);
                fileDownloaderModel.setDescription("assets");
                fileDownloaderModel.setIsnew(resourceForm.getIsNew());
                fileDownloaderModel.setName(resourceForm.getName());
                fileDownloaderModel.setNameEn(resourceForm.getNameEn());
                fileDownloaderModel.setLevel(resourceForm.getLevel());
                fileDownloaderModel.setEffectType(2);
                fileDownloaderModel.setSubid(pasterForm.getId());
                fileDownloaderModel.setFontid(pasterForm.getFontId());
                fileDownloaderModel.setSubicon(sb2);
                fileDownloaderModel.setSubname(pasterForm.getName());
                fileDownloaderModel.setIsunzip(1);
                fileDownloaderModel.setTaskId(com.liulishuo.filedownloader.util.FileDownloadUtils.generateId(java.lang.String.valueOf(pasterForm.getId()), fileDownloaderModel.getPath()));
                java.util.HashMap<java.lang.String, java.lang.String> hashMap = new java.util.HashMap<>();
                hashMap.put(com.aliyun.svideo.downloader.FileDownloaderModel.SUBID, java.lang.String.valueOf(pasterForm.getId()));
                hashMap.put("task_id", java.lang.String.valueOf(fileDownloaderModel.getTaskId()));
                com.aliyun.svideo.downloader.DownloaderManager.getInstance().getDbController().insertDb(fileDownloaderModel, hashMap);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isViewDestroy() {
        return mView.get() == null || mView.get().getVisibility() != 0;
    }

    private static void unZip() {
        java.io.File[] listFiles = new java.io.File(SD_DIR + QU_NAME).listFiles(new com.aliyun.svideo.editor.util.EditorCommon.AnonymousClass1());
        if (listFiles == null || listFiles.length == 0) {
            if (isViewDestroy()) {
                return;
            }
            mView.get().setVisibility(8);
        } else {
            length = listFiles.length;
            for (java.io.File file : listFiles) {
                new com.aliyun.svideo.editor.util.EditorCommon.AnonymousClass2(file).executeOnExecutor(android.os.AsyncTask.THREAD_POOL_EXECUTOR, new java.lang.Object[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void unZipFolder(java.lang.String str, java.lang.String str2) throws java.lang.Exception {
        java.util.zip.ZipInputStream zipInputStream = new java.util.zip.ZipInputStream(new java.io.FileInputStream(str));
        while (true) {
            java.util.zip.ZipEntry nextEntry = zipInputStream.getNextEntry();
            if (nextEntry == null) {
                zipInputStream.close();
                return;
            }
            java.lang.String name = nextEntry.getName();
            if (nextEntry.isDirectory()) {
                new java.io.File(str2 + java.io.File.separator + name.substring(0, name.length() - 1)).mkdirs();
            } else {
                java.io.File file = new java.io.File(str2 + java.io.File.separator + name);
                file.createNewFile();
                java.io.FileOutputStream fileOutputStream = new java.io.FileOutputStream(file);
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = zipInputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    fileOutputStream.write(bArr, 0, read);
                    fileOutputStream.flush();
                }
                fileOutputStream.close();
            }
        }
    }
}
