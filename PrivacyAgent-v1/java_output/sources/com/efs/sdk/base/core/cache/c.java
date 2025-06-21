package com.efs.sdk.base.core.cache;

/* loaded from: classes22.dex */
public final class c implements com.efs.sdk.base.core.cache.d {
    @Override // com.efs.sdk.base.core.cache.d
    public final void a(com.efs.sdk.base.core.model.LogDto logDto) {
        com.efs.sdk.base.core.d.f fVar;
        com.efs.sdk.base.core.d.f fVar2;
        if (logDto.getData() == null) {
            return;
        }
        java.lang.String fileName = com.efs.sdk.base.core.util.FileUtil.getFileName(logDto);
        java.io.File file = new java.io.File(com.efs.sdk.base.core.util.a.h(com.efs.sdk.base.core.controller.ControllerCenter.getGlobalEnvStruct().mAppContext, com.efs.sdk.base.core.controller.ControllerCenter.getGlobalEnvStruct().getAppid()), fileName);
        com.efs.sdk.base.core.util.FileUtil.write(file, logDto.getData());
        try {
            if (com.efs.sdk.base.core.controller.ControllerCenter.getGlobalEnvStruct().isEnablePaBackup() && "patrace".equals(logDto.getLogType())) {
                java.io.File file2 = new java.io.File(com.efs.sdk.base.core.controller.ControllerCenter.getGlobalEnvStruct().mAppContext.getApplicationInfo().dataDir + java.io.File.separator + "apm_backup_files", fileName);
                com.efs.sdk.base.core.util.FileUtil.copy(file, file2);
                if (com.efs.sdk.base.core.controller.ControllerCenter.getGlobalEnvStruct().isDebug()) {
                    com.efs.sdk.base.core.util.Log.d("efs.base", "backup patrace file to " + file2.getAbsolutePath());
                }
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
        fVar = com.efs.sdk.base.core.d.f.a.a;
        fVar.c.b();
        fVar2 = com.efs.sdk.base.core.d.f.a.a;
        fVar2.c.c();
    }

    @Override // com.efs.sdk.base.core.cache.d
    public final void a(java.io.File file) {
        com.efs.sdk.base.core.util.FileUtil.move(file, com.efs.sdk.base.core.util.a.h(com.efs.sdk.base.core.controller.ControllerCenter.getGlobalEnvStruct().mAppContext, com.efs.sdk.base.core.controller.ControllerCenter.getGlobalEnvStruct().getAppid()));
    }

    @Override // com.efs.sdk.base.core.cache.d
    public final void a(java.lang.String str) {
    }

    @Override // com.efs.sdk.base.core.cache.d
    public final boolean a(java.io.File file, com.efs.sdk.base.core.model.LogDto logDto) {
        if (!file.exists()) {
            return false;
        }
        logDto.setFile(file);
        logDto.setSendImediately(true);
        logDto.setLogBodyType(1);
        return true;
    }
}
