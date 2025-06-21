package com.efs.sdk.base.core.cache;

/* loaded from: classes22.dex */
public class CacheManager {
    private boolean a;
    private boolean b;
    private com.efs.sdk.base.core.cache.a c;
    private com.efs.sdk.base.core.cache.CacheManager.a d;
    private java.util.List<java.io.File> e;

    public static class a implements java.util.Comparator<java.io.File> {
        @Override // java.util.Comparator
        public final /* synthetic */ int compare(java.io.File file, java.io.File file2) {
            long lastModified = file.lastModified() - file2.lastModified();
            if (lastModified > 0) {
                return 1;
            }
            return lastModified == 0 ? 0 : -1;
        }
    }

    public static class b {
        private static final com.efs.sdk.base.core.cache.CacheManager a = new com.efs.sdk.base.core.cache.CacheManager((byte) 0);
    }

    private CacheManager() {
        this.a = false;
        this.b = true;
        this.c = new com.efs.sdk.base.core.cache.a();
        this.d = new com.efs.sdk.base.core.cache.CacheManager.a();
    }

    public /* synthetic */ CacheManager(byte b2) {
        this();
    }

    private void a() {
        java.lang.String[] list;
        java.io.File d = com.efs.sdk.base.core.util.a.d(com.efs.sdk.base.core.controller.ControllerCenter.getGlobalEnvStruct().mAppContext, com.efs.sdk.base.core.controller.ControllerCenter.getGlobalEnvStruct().getAppid());
        if (!d.exists() || !d.isDirectory() || (list = d.list()) == null || list.length <= 0) {
            return;
        }
        for (java.lang.String str : list) {
            if (!com.efs.sdk.base.core.util.ProcessUtil.isProcessExist(com.efs.sdk.base.core.controller.ControllerCenter.getGlobalEnvStruct().mAppContext, str)) {
                java.io.File file = new java.io.File(d, str);
                java.util.List<java.io.File> listFiles = com.efs.sdk.base.core.util.FileUtil.listFiles(file);
                if (!listFiles.isEmpty()) {
                    for (java.io.File file2 : listFiles) {
                        if (a(file2.getName())) {
                            a(file2);
                        } else {
                            java.lang.String name = file2.getName();
                            com.efs.sdk.base.core.model.LogDto createLogDtoByName = (android.text.TextUtils.isEmpty(name) || !name.startsWith(com.efs.sdk.base.Constants.LOG_TYPE_CODELOGPERF)) ? com.efs.sdk.base.core.util.FileUtil.createLogDtoByName(name) : com.efs.sdk.base.core.util.FileUtil.createCodeLogDtoByName(name);
                            if (createLogDtoByName == null) {
                                onChangeDtoError(file2);
                            } else {
                                com.efs.sdk.base.core.cache.d a2 = this.c.a(createLogDtoByName.getLogProtocol());
                                if (a2 == null) {
                                    onChangeDtoError(file2);
                                } else {
                                    a2.a(file2);
                                }
                            }
                        }
                    }
                }
                com.efs.sdk.base.core.util.FileUtil.delete(file);
            }
        }
    }

    public static void a(java.io.File file) {
        com.efs.sdk.base.core.d.f fVar;
        java.lang.StringBuilder sb = new java.lang.StringBuilder("file is expire: ");
        sb.append(file.getName());
        sb.append(", now is ");
        com.efs.sdk.base.core.a.a.a();
        sb.append(com.efs.sdk.base.core.a.a.b());
        com.efs.sdk.base.core.util.Log.i("efs.cache", sb.toString());
        if (!file.getName().startsWith("wa_")) {
            fVar = com.efs.sdk.base.core.d.f.a.a;
            fVar.c.d();
        }
        com.efs.sdk.base.core.util.FileUtil.delete(file);
    }

    public static boolean a(java.lang.String str) {
        try {
            long parseLong = str.startsWith(com.efs.sdk.base.Constants.LOG_TYPE_CODELOGPERF) ? java.lang.Long.parseLong(str.substring(str.lastIndexOf("_") + 1)) : java.lang.Long.parseLong(str.substring(str.lastIndexOf("_") + 1));
            com.efs.sdk.base.core.a.a.a();
            return java.lang.Math.abs(com.efs.sdk.base.core.a.a.b() - parseLong) >= 604800000;
        } catch (java.lang.Throwable unused) {
            return true;
        }
    }

    private void b() {
        java.lang.String[] list;
        java.io.File e = com.efs.sdk.base.core.util.a.e(com.efs.sdk.base.core.controller.ControllerCenter.getGlobalEnvStruct().mAppContext, com.efs.sdk.base.core.controller.ControllerCenter.getGlobalEnvStruct().getAppid());
        if (!e.exists() || !e.isDirectory() || (list = e.list()) == null || list.length <= 0) {
            return;
        }
        for (java.lang.String str : list) {
            if (!com.efs.sdk.base.core.util.ProcessUtil.isProcessExist(com.efs.sdk.base.core.controller.ControllerCenter.getGlobalEnvStruct().mAppContext, str)) {
                java.io.File file = new java.io.File(e, str);
                java.util.List<java.io.File> listFiles = com.efs.sdk.base.core.util.FileUtil.listFiles(file);
                if (!listFiles.isEmpty()) {
                    for (java.io.File file2 : listFiles) {
                        if (a(file2.getName())) {
                            a(file2);
                        } else {
                            java.lang.String name = file2.getName();
                            com.efs.sdk.base.core.model.LogDto createLogDtoByName = (android.text.TextUtils.isEmpty(name) || !name.startsWith(com.efs.sdk.base.Constants.LOG_TYPE_CODELOGPERF)) ? com.efs.sdk.base.core.util.FileUtil.createLogDtoByName(name) : com.efs.sdk.base.core.util.FileUtil.createCodeLogDtoByName(name);
                            if (createLogDtoByName == null) {
                                onChangeDtoError(file2);
                            } else {
                                com.efs.sdk.base.core.cache.d a2 = this.c.a(createLogDtoByName.getLogProtocol());
                                if (a2 == null) {
                                    onChangeDtoError(file2);
                                } else {
                                    a2.a(file2);
                                }
                            }
                        }
                    }
                }
                com.efs.sdk.base.core.util.FileUtil.delete(file);
            }
        }
    }

    public static com.efs.sdk.base.core.cache.CacheManager getInstance() {
        return com.efs.sdk.base.core.cache.CacheManager.b.a;
    }

    @androidx.annotation.Nullable
    public com.efs.sdk.base.core.model.LogDto changeLogDto(java.io.File file) {
        try {
            if (!file.exists()) {
                return null;
            }
            if (a(file.getName())) {
                a(file);
                return null;
            }
            java.lang.String name = file.getName();
            com.efs.sdk.base.core.model.LogDto createLogDtoByName = (android.text.TextUtils.isEmpty(name) || !name.startsWith(com.efs.sdk.base.Constants.LOG_TYPE_CODELOGPERF)) ? com.efs.sdk.base.core.util.FileUtil.createLogDtoByName(name) : com.efs.sdk.base.core.util.FileUtil.createCodeLogDtoByName(name);
            if (createLogDtoByName == null) {
                onChangeDtoError(file);
                return null;
            }
            com.efs.sdk.base.core.cache.d a2 = this.c.a(createLogDtoByName.getLogProtocol());
            if (a2 == null) {
                onChangeDtoError(file);
                return null;
            }
            if (a2.a(file, createLogDtoByName)) {
                return createLogDtoByName;
            }
            onChangeDtoError(file);
            return null;
        } catch (java.lang.Throwable th) {
            com.efs.sdk.base.core.util.Log.w("efs.cache", th);
            onChangeDtoError(file);
            return null;
        }
    }

    public void flushImmediately(byte b2, java.lang.String str) {
        com.efs.sdk.base.core.cache.d a2 = this.c.a(b2);
        if (a2 == null) {
            return;
        }
        a2.a(str);
    }

    public java.util.List<java.io.File> getCodeLogList() {
        return this.e;
    }

    public java.util.List<java.io.File> getFileList(int i, @androidx.annotation.Nullable com.efs.sdk.base.core.cache.IFileFilter iFileFilter) {
        com.efs.sdk.base.core.d.f fVar;
        a();
        java.io.File h = com.efs.sdk.base.core.util.a.h(com.efs.sdk.base.core.controller.ControllerCenter.getGlobalEnvStruct().mAppContext, com.efs.sdk.base.core.controller.ControllerCenter.getGlobalEnvStruct().getAppid());
        if (!h.exists()) {
            return java.util.Collections.emptyList();
        }
        java.util.List<java.io.File> listFiles = com.efs.sdk.base.core.util.FileUtil.listFiles(h);
        if (this.b) {
            fVar = com.efs.sdk.base.core.d.f.a.a;
            int size = listFiles.size();
            if (fVar.b != null && com.efs.sdk.base.core.controller.ControllerCenter.getGlobalEnvStruct().isEnableWaStat()) {
                com.efs.sdk.base.core.d.b bVar = new com.efs.sdk.base.core.d.b("efs_core", "log_lag", fVar.a.c);
                bVar.put("cnt", java.lang.Integer.valueOf(size));
                fVar.b.send(bVar);
            }
            this.b = false;
        }
        java.util.Collections.sort(listFiles, this.d);
        java.util.ArrayList arrayList = new java.util.ArrayList(i);
        for (int size2 = listFiles.size() - 1; size2 >= 0 && arrayList.size() < i; size2--) {
            java.io.File file = listFiles.get(size2);
            if (file.exists() && (iFileFilter == null || !iFileFilter.filter(file))) {
                arrayList.add(file);
            }
        }
        return arrayList;
    }

    public java.util.List<java.io.File> getFileListCodeLog(int i, @androidx.annotation.Nullable com.efs.sdk.base.core.cache.IFileFilter iFileFilter) {
        b();
        java.util.List<java.io.File> list = this.e;
        if (list == null || list.isEmpty()) {
            java.io.File i2 = com.efs.sdk.base.core.util.a.i(com.efs.sdk.base.core.controller.ControllerCenter.getGlobalEnvStruct().mAppContext, com.efs.sdk.base.core.controller.ControllerCenter.getGlobalEnvStruct().getAppid());
            if (!i2.exists()) {
                return java.util.Collections.emptyList();
            }
            java.util.List<java.io.File> listFiles = com.efs.sdk.base.core.util.FileUtil.listFiles(i2);
            this.e = listFiles;
            java.util.Collections.sort(listFiles, this.d);
        }
        java.util.ArrayList arrayList = new java.util.ArrayList(i);
        for (int size = this.e.size() - 1; size >= 0 && arrayList.size() < i; size--) {
            java.io.File file = this.e.get(size);
            if (file.exists()) {
                if (iFileFilter == null || !iFileFilter.filter(file)) {
                    com.efs.sdk.base.core.util.Log.i("efs.cache", "[-->>] add file is " + file.getName());
                    arrayList.add(file);
                } else {
                    com.efs.sdk.base.core.util.Log.i("efs.cache", "[--xx] filter file is " + file.getName());
                }
            }
        }
        return arrayList;
    }

    public java.util.List<com.efs.sdk.base.core.model.LogDto> getLogDto(int i, com.efs.sdk.base.core.cache.IFileFilter iFileFilter) {
        a();
        java.util.List<java.io.File> fileList = getFileList(i, iFileFilter);
        java.util.ArrayList arrayList = new java.util.ArrayList(i);
        for (java.io.File file : fileList) {
            com.efs.sdk.base.core.model.LogDto changeLogDto = changeLogDto(file);
            if (changeLogDto == null) {
                com.efs.sdk.base.core.util.Log.w("efs.cache", "file upload error, name is " + file.getName());
            } else {
                arrayList.add(changeLogDto);
            }
        }
        return arrayList;
    }

    public java.util.List<com.efs.sdk.base.core.model.LogDto> getLogDtoCodeLog(int i, com.efs.sdk.base.core.cache.IFileFilter iFileFilter) {
        b();
        java.util.List<java.io.File> fileListCodeLog = getFileListCodeLog(i, iFileFilter);
        java.util.ArrayList arrayList = new java.util.ArrayList(i);
        for (java.io.File file : fileListCodeLog) {
            com.efs.sdk.base.core.model.LogDto changeLogDto = changeLogDto(file);
            if (changeLogDto == null) {
                com.efs.sdk.base.core.util.Log.w("efs.cache", "file upload error, name is " + file.getName());
            } else {
                arrayList.add(changeLogDto);
            }
        }
        return arrayList;
    }

    public void onChangeDtoError(@androidx.annotation.NonNull java.io.File file) {
        com.efs.sdk.base.core.d.f fVar;
        if (!file.getName().startsWith("wa_")) {
            fVar = com.efs.sdk.base.core.d.f.a.a;
            fVar.c.c.incrementAndGet();
        }
        com.efs.sdk.base.core.util.FileUtil.delete(file);
    }

    public void put(com.efs.sdk.base.core.model.LogDto logDto) {
        com.efs.sdk.base.core.cache.d a2;
        com.efs.sdk.base.core.d.f fVar;
        if (!"wa".equals(logDto.getLogType()) && !com.efs.sdk.base.Constants.LOG_TYPE_CODELOGPERF.equals(logDto.getLogType()) && !com.efs.sdk.base.core.cache.b.a().a) {
            if (!this.a) {
                fVar = com.efs.sdk.base.core.d.f.a.a;
                int i = com.efs.sdk.base.core.config.remote.b.a().d.mConfigVersion;
                if (fVar.b != null || com.efs.sdk.base.core.controller.ControllerCenter.getGlobalEnvStruct().isEnableWaStat()) {
                    fVar.b.send(fVar.a("disk_limit", i));
                }
            }
            this.a = true;
            return;
        }
        if (!com.efs.sdk.base.Constants.LOG_TYPE_CODELOGPERF.equals(logDto.getLogType()) || com.efs.sdk.base.core.cache.b.a().b) {
            if ((logDto.getLogBodyType() == 0 && (logDto.getData() == null || logDto.getData().length == 0)) || (a2 = this.c.a(logDto.getLogProtocol())) == null) {
                return;
            }
            a2.a(logDto);
        }
    }
}
