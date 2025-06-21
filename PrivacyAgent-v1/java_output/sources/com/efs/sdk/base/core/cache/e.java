package com.efs.sdk.base.core.cache;

/* loaded from: classes22.dex */
public final class e extends android.os.Handler implements com.efs.sdk.base.core.cache.d {
    private final java.util.concurrent.ConcurrentHashMap<java.lang.String, com.efs.sdk.base.core.cache.e.a> a;
    private com.efs.sdk.base.core.c.a.d b;
    private com.efs.sdk.base.core.c.a.c c;

    public static class a extends java.io.FileOutputStream {
        long a;
        java.io.File b;

        public a(@androidx.annotation.NonNull java.io.File file) {
            super(file);
            this.b = file;
            this.a = java.lang.System.currentTimeMillis();
        }
    }

    public e() {
        super(com.efs.sdk.base.core.util.concurrent.a.a.getLooper());
        this.a = new java.util.concurrent.ConcurrentHashMap<>();
        this.b = new com.efs.sdk.base.core.c.a.d();
        this.c = new com.efs.sdk.base.core.c.a.c();
    }

    private boolean a(com.efs.sdk.base.core.model.LogDto logDto, java.io.File file) {
        java.io.BufferedReader bufferedReader;
        java.io.FileReader fileReader;
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        java.io.FileReader fileReader2 = null;
        try {
            fileReader = new java.io.FileReader(file);
            try {
                bufferedReader = new java.io.BufferedReader(fileReader);
            } catch (java.lang.Throwable th) {
                th = th;
                bufferedReader = null;
            }
        } catch (java.lang.Throwable th2) {
            th = th2;
            bufferedReader = null;
        }
        try {
            for (java.lang.String readLine = bufferedReader.readLine(); readLine != null; readLine = bufferedReader.readLine()) {
                java.lang.String base64DecodeToStr = com.efs.sdk.base.core.util.secure.EncodeUtil.base64DecodeToStr(readLine.getBytes());
                if (!android.text.TextUtils.isEmpty(base64DecodeToStr)) {
                    sb.append(base64DecodeToStr);
                    sb.append("\n");
                }
            }
            logDto.setData(sb.toString().getBytes());
            logDto.setSendImediately(true);
            this.c.a(logDto);
            logDto.setFile(file);
            com.efs.sdk.base.core.util.FileUtil.safeClose(bufferedReader);
            com.efs.sdk.base.core.util.FileUtil.safeClose(fileReader);
            return true;
        } catch (java.lang.Throwable th3) {
            th = th3;
            fileReader2 = fileReader;
            try {
                com.efs.sdk.base.core.util.Log.e("efs.cache", "local decode error", th);
                com.efs.sdk.base.core.util.FileUtil.safeClose(bufferedReader);
                com.efs.sdk.base.core.util.FileUtil.safeClose(fileReader2);
                return false;
            } catch (java.lang.Throwable th4) {
                com.efs.sdk.base.core.util.FileUtil.safeClose(bufferedReader);
                com.efs.sdk.base.core.util.FileUtil.safeClose(fileReader2);
                throw th4;
            }
        }
    }

    private static long b(java.lang.String str) {
        java.util.Map<java.lang.String, java.lang.String> c = com.efs.sdk.base.core.config.remote.b.a().c();
        java.lang.String concat = "record_accumulation_time_".concat(java.lang.String.valueOf(str));
        if (!c.containsKey(concat)) {
            return 60000L;
        }
        java.lang.String str2 = c.get(concat);
        if (android.text.TextUtils.isEmpty(str2)) {
            return 60000L;
        }
        try {
            return java.lang.Math.max(java.lang.Long.parseLong(str2) * 1000, 1000L);
        } catch (java.lang.Throwable th) {
            com.efs.sdk.base.core.util.Log.e("efs.cache", "get cache interval error", th);
            return 60000L;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x00bf  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private com.efs.sdk.base.core.cache.e.a b(com.efs.sdk.base.core.model.LogDto logDto) {
        java.io.File file;
        com.efs.sdk.base.core.cache.e.a aVar;
        java.lang.Throwable th;
        com.efs.sdk.base.core.d.f fVar;
        com.efs.sdk.base.core.cache.e.a putIfAbsent;
        if (this.a.containsKey(logDto.getLogType())) {
            return this.a.get(logDto.getLogType());
        }
        if (com.efs.sdk.base.Constants.LOG_TYPE_CODELOGPERF.equals(logDto.getLogType())) {
            file = new java.io.File(com.efs.sdk.base.core.util.a.g(com.efs.sdk.base.core.controller.ControllerCenter.getGlobalEnvStruct().mAppContext, com.efs.sdk.base.core.controller.ControllerCenter.getGlobalEnvStruct().getAppid()), com.efs.sdk.base.core.util.FileUtil.getCodelogFileName(logDto));
        } else {
            file = new java.io.File(com.efs.sdk.base.core.util.a.f(com.efs.sdk.base.core.controller.ControllerCenter.getGlobalEnvStruct().mAppContext, com.efs.sdk.base.core.controller.ControllerCenter.getGlobalEnvStruct().getAppid()), com.efs.sdk.base.core.util.FileUtil.getFileName(logDto));
        }
        try {
            aVar = new com.efs.sdk.base.core.cache.e.a(file);
            try {
                putIfAbsent = this.a.putIfAbsent(logDto.getLogType(), aVar);
            } catch (java.lang.Throwable th2) {
                th = th2;
                th.printStackTrace();
                if (!"wa".equalsIgnoreCase(logDto.getLogType())) {
                }
                return aVar;
            }
        } catch (java.lang.Throwable th3) {
            aVar = null;
            th = th3;
        }
        if (putIfAbsent != null) {
            com.efs.sdk.base.core.util.FileUtil.safeClose(aVar);
            com.efs.sdk.base.core.util.FileUtil.delete(file);
            return putIfAbsent;
        }
        if (com.efs.sdk.base.Constants.LOG_TYPE_CODELOGPERF.equals(logDto.getLogType())) {
            android.os.Message obtain = android.os.Message.obtain();
            obtain.obj = logDto.getLogType();
            obtain.what = 1;
            sendMessage(obtain);
        } else {
            android.os.Message obtain2 = android.os.Message.obtain();
            obtain2.obj = logDto.getLogType();
            obtain2.what = 1;
            sendMessageDelayed(obtain2, b(logDto.getLogType()));
        }
        if (!"wa".equalsIgnoreCase(logDto.getLogType())) {
            fVar = com.efs.sdk.base.core.d.f.a.a;
            fVar.c.b();
        }
        return aVar;
    }

    private void c(java.lang.String str) {
        com.efs.sdk.base.core.cache.e.a aVar;
        com.efs.sdk.base.core.d.f fVar;
        com.efs.sdk.base.core.d.f fVar2;
        if (this.a.containsKey(str) && (aVar = this.a.get(str)) != null) {
            try {
                aVar.flush();
                com.efs.sdk.base.core.util.FileUtil.safeClose(aVar);
                com.efs.sdk.base.core.util.Log.i("RecordLogCacheProcessor", "save file, type is ".concat(java.lang.String.valueOf(str)));
                a(aVar.b);
            } catch (java.lang.Throwable th) {
                try {
                    th.printStackTrace();
                    this.a.remove(str);
                    if ("wa".equalsIgnoreCase(str)) {
                        return;
                    }
                    fVar2 = com.efs.sdk.base.core.d.f.a.a;
                    fVar2.c.c();
                } finally {
                    this.a.remove(str);
                    if (!"wa".equalsIgnoreCase(str)) {
                        fVar = com.efs.sdk.base.core.d.f.a.a;
                        fVar.c.c();
                    }
                }
            }
        }
    }

    @Override // com.efs.sdk.base.core.cache.d
    public final void a(com.efs.sdk.base.core.model.LogDto logDto) {
        android.os.Message obtain = android.os.Message.obtain();
        obtain.obj = logDto;
        obtain.what = 0;
        sendMessage(obtain);
    }

    @Override // com.efs.sdk.base.core.cache.d
    public final void a(java.io.File file) {
        java.lang.String fileName;
        java.io.File h;
        java.lang.String name = file.getName();
        com.efs.sdk.base.core.model.LogDto createLogDtoByName = (android.text.TextUtils.isEmpty(name) || !name.startsWith(com.efs.sdk.base.Constants.LOG_TYPE_CODELOGPERF)) ? com.efs.sdk.base.core.util.FileUtil.createLogDtoByName(name) : com.efs.sdk.base.core.util.FileUtil.createCodeLogDtoByName(name);
        if (createLogDtoByName == null) {
            com.efs.sdk.base.core.cache.CacheManager.getInstance().onChangeDtoError(file);
            return;
        }
        if (!a(createLogDtoByName, file) || createLogDtoByName.getData() == null || createLogDtoByName.getData().length <= 0) {
            com.efs.sdk.base.core.cache.CacheManager.getInstance().onChangeDtoError(file);
            return;
        }
        if (com.efs.sdk.base.Constants.LOG_TYPE_CODELOGPERF.equals(createLogDtoByName.getLogType())) {
            fileName = com.efs.sdk.base.core.util.FileUtil.getCodelogFileName(createLogDtoByName);
            h = com.efs.sdk.base.core.util.a.i(com.efs.sdk.base.core.controller.ControllerCenter.getGlobalEnvStruct().mAppContext, com.efs.sdk.base.core.controller.ControllerCenter.getGlobalEnvStruct().getAppid());
        } else {
            fileName = com.efs.sdk.base.core.util.FileUtil.getFileName(createLogDtoByName);
            h = com.efs.sdk.base.core.util.a.h(com.efs.sdk.base.core.controller.ControllerCenter.getGlobalEnvStruct().mAppContext, com.efs.sdk.base.core.controller.ControllerCenter.getGlobalEnvStruct().getAppid());
        }
        java.io.File file2 = new java.io.File(h, fileName);
        com.efs.sdk.base.core.util.Log.i("RecordLogCacheProcessor", "upload file, name is ".concat(java.lang.String.valueOf(name)));
        com.efs.sdk.base.core.util.FileUtil.write(file2, createLogDtoByName.getData());
        com.efs.sdk.base.core.util.FileUtil.delete(file);
    }

    @Override // com.efs.sdk.base.core.cache.d
    public final void a(@androidx.annotation.NonNull java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return;
        }
        android.os.Message obtain = android.os.Message.obtain();
        obtain.obj = str;
        obtain.what = 1;
        sendMessage(obtain);
    }

    @Override // com.efs.sdk.base.core.cache.d
    public final boolean a(java.io.File file, com.efs.sdk.base.core.model.LogDto logDto) {
        if (!logDto.isCp()) {
            a(file);
            return false;
        }
        if (!file.exists()) {
            return false;
        }
        logDto.setFile(file);
        logDto.setSendImediately(true);
        logDto.setLogBodyType(1);
        return true;
    }

    @Override // android.os.Handler
    public final void handleMessage(@androidx.annotation.NonNull android.os.Message message) {
        int i = message.what;
        if (i != 0) {
            if (i != 1) {
                return;
            }
            java.lang.Object obj = message.obj;
            if (obj instanceof java.lang.String) {
                c(obj.toString());
                return;
            }
            return;
        }
        com.efs.sdk.base.core.model.LogDto logDto = (com.efs.sdk.base.core.model.LogDto) message.obj;
        for (int i2 = 0; i2 < 3; i2++) {
            try {
                com.efs.sdk.base.core.cache.e.a b = b(logDto);
                if (b == null) {
                    com.efs.sdk.base.core.util.Log.w("efs.cache", "writer is null for type " + logDto.getLogType());
                    return;
                }
                if (b.getChannel().position() + logDto.getData().length > 819200) {
                    c(logDto.getLogType());
                    b = b(logDto);
                    if (b == null) {
                        com.efs.sdk.base.core.util.Log.w("efs.cache", "writer is null for type " + logDto.getLogType());
                        return;
                    }
                }
                b.write(com.efs.sdk.base.core.util.secure.EncodeUtil.base64Encode(logDto.getData()));
                b.write("\n".getBytes());
                return;
            } catch (java.lang.Throwable th) {
                com.efs.sdk.base.core.util.Log.e("efs.cache", "cache file error", th);
            }
        }
    }
}
