package com.efs.sdk.base.core.cache;

/* loaded from: classes22.dex */
public final class f implements com.efs.sdk.base.core.cache.IFileFilter {
    @Override // com.efs.sdk.base.core.cache.IFileFilter
    public final boolean filter(java.io.File file) {
        java.lang.String name = file.getName();
        com.efs.sdk.base.core.model.LogDto createLogDtoByName = (android.text.TextUtils.isEmpty(name) || !name.startsWith(com.efs.sdk.base.Constants.LOG_TYPE_CODELOGPERF)) ? com.efs.sdk.base.core.util.FileUtil.createLogDtoByName(name) : com.efs.sdk.base.core.util.FileUtil.createCodeLogDtoByName(name);
        if (createLogDtoByName != null) {
            return ("wa".equals(createLogDtoByName.getLogType()) || com.efs.sdk.base.core.b.c.a().a(createLogDtoByName.getLogType(), file.length())) ? false : true;
        }
        com.efs.sdk.base.core.cache.CacheManager.getInstance().onChangeDtoError(file);
        return true;
    }

    @Override // com.efs.sdk.base.core.cache.IFileFilter
    public final void finish() {
    }

    @Override // com.efs.sdk.base.core.cache.IFileFilter
    public final void finish(boolean z, boolean z2) {
    }

    @Override // com.efs.sdk.base.core.cache.IFileFilter
    public final boolean hasTask() {
        return false;
    }
}
