package com.umeng.logsdk;

/* loaded from: classes19.dex */
public class UploadFileFilterCodeLog implements com.efs.sdk.base.core.cache.IFileFilter {
    private com.umeng.logsdk.ULogConfigManager a;
    private com.umeng.logsdk.b b;
    private java.lang.String c;
    private java.lang.String e;
    private long g;
    private long h;
    private int d = -1;
    private int f = -1;

    private void a() {
        com.efs.sdk.base.core.util.Log.i("UploadFileFilterCodeLog", "reset task.");
        this.b = null;
        this.c = null;
        this.d = -1;
        this.e = null;
        this.f = -1;
        this.g = 0L;
        this.h = 0L;
    }

    @Override // com.efs.sdk.base.core.cache.IFileFilter
    public boolean filter(java.io.File file) {
        java.lang.StringBuilder sb;
        java.lang.String sb2;
        java.lang.StringBuilder sb3;
        java.util.List<com.umeng.logsdk.b> taskList;
        if (this.b == null) {
            com.umeng.logsdk.ULogConfigManager uLogConfigManager = com.umeng.logsdk.ULogManager.getULogConfigManager();
            this.a = uLogConfigManager;
            if (uLogConfigManager != null && (taskList = uLogConfigManager.getTaskList()) != null && !taskList.isEmpty()) {
                int i = 0;
                while (true) {
                    if (i >= taskList.size()) {
                        break;
                    }
                    com.umeng.logsdk.b bVar = taskList.get(i);
                    this.b = bVar;
                    if (bVar != null) {
                        int i2 = bVar.b;
                        this.d = i2;
                        if (i2 == 0) {
                            this.c = bVar.a;
                            this.e = bVar.d;
                            this.f = bVar.c;
                            this.g = bVar.e;
                            this.h = bVar.f;
                            break;
                        }
                        a();
                    }
                    i++;
                }
            }
        }
        if (this.b != null && this.d == 0) {
            com.efs.sdk.base.core.util.Log.i("UploadFileFilterCodeLog", this.c + ", " + this.e + ", " + this.f + ", " + this.g + ", " + this.h);
            java.lang.String name = file.getName();
            com.efs.sdk.base.core.model.LogDto createLogDtoByName = (android.text.TextUtils.isEmpty(name) || !name.startsWith(com.efs.sdk.base.Constants.LOG_TYPE_CODELOGPERF)) ? com.efs.sdk.base.core.util.FileUtil.createLogDtoByName(name) : com.efs.sdk.base.core.util.FileUtil.createCodeLogDtoByName(name);
            if (createLogDtoByName == null) {
                com.efs.sdk.base.core.cache.CacheManager.getInstance().onChangeDtoError(file);
                return true;
            }
            long beginTime = createLogDtoByName.getBeginTime();
            createLogDtoByName.getEndTime();
            java.lang.String did = createLogDtoByName.getDid();
            java.lang.String uid = createLogDtoByName.getUid();
            if (beginTime >= this.g && beginTime <= this.h) {
                com.efs.sdk.base.core.util.Log.i("UploadFileFilterCodeLog", "task target type is " + this.f);
                int i3 = this.f;
                if (i3 == 1) {
                    if (android.text.TextUtils.isEmpty(this.e) || android.text.TextUtils.isEmpty(did) || !this.e.equals(did)) {
                        sb2 = "taskTarget is " + this.e + ", did is " + did;
                        com.efs.sdk.base.core.util.Log.i("UploadFileFilterCodeLog", sb2);
                    } else {
                        sb3 = new java.lang.StringBuilder("task is ");
                    }
                } else if (i3 == 0) {
                    if (android.text.TextUtils.isEmpty(this.e) || android.text.TextUtils.isEmpty(uid) || !this.e.equals(uid)) {
                        sb = new java.lang.StringBuilder("taskTarget is ");
                        sb.append(this.e);
                        sb.append(", uid is ");
                        sb.append(uid);
                    } else {
                        sb3 = new java.lang.StringBuilder("task is ");
                    }
                }
                sb3.append(this.c);
                sb3.append(", target is ");
                sb3.append(this.e);
                sb3.append(", file time is ");
                sb3.append(beginTime);
                com.efs.sdk.base.core.util.Log.i("UploadFileFilterCodeLog", sb3.toString());
                return false;
            }
            sb = new java.lang.StringBuilder("time is ");
            sb.append(beginTime >= this.g);
            sb.append(", is ");
            sb.append(beginTime <= this.h);
            sb2 = sb.toString();
            com.efs.sdk.base.core.util.Log.i("UploadFileFilterCodeLog", sb2);
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x0033, code lost:
    
        if (r0 != null) goto L10;
     */
    @Override // com.efs.sdk.base.core.cache.IFileFilter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void finish() {
        com.umeng.logsdk.ULogConfigManager uLogConfigManager;
        com.efs.sdk.base.core.util.Log.i("UploadFileFilterCodeLog", "clear task.");
        long currentTimeMillis = java.lang.System.currentTimeMillis();
        com.efs.sdk.base.core.util.Log.i("UploadFileFilterCodeLog", "taskEndTime is " + this.h + ", current time is " + currentTimeMillis);
        if (this.h > currentTimeMillis) {
            com.efs.sdk.base.core.util.Log.i("UploadFileFilterCodeLog", "future task. not remove.");
            uLogConfigManager = this.a;
        } else {
            com.umeng.logsdk.ULogConfigManager uLogConfigManager2 = this.a;
            if (uLogConfigManager2 != null) {
                uLogConfigManager2.reMoveTaskFroSP(this.c);
                uLogConfigManager = this.a;
                uLogConfigManager.removeTask(this.b);
            }
        }
        a();
    }

    @Override // com.efs.sdk.base.core.cache.IFileFilter
    public void finish(boolean z, boolean z2) {
    }

    @Override // com.efs.sdk.base.core.cache.IFileFilter
    public boolean hasTask() {
        java.util.List<com.umeng.logsdk.b> taskList;
        com.umeng.logsdk.ULogConfigManager uLogConfigManager = com.umeng.logsdk.ULogManager.getULogConfigManager();
        if (uLogConfigManager == null || (taskList = uLogConfigManager.getTaskList()) == null || taskList.isEmpty()) {
            return false;
        }
        for (int i = 0; i < taskList.size(); i++) {
            com.umeng.logsdk.b bVar = taskList.get(i);
            if (bVar != null && bVar.b == 0) {
                return true;
            }
        }
        return false;
    }
}
