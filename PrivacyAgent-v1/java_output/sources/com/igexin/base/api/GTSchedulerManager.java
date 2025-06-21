package com.igexin.base.api;

/* loaded from: classes22.dex */
public class GTSchedulerManager implements com.igexin.base.scheduler.c {
    private static com.igexin.base.api.GTSchedulerManager mInstance;
    private com.igexin.base.scheduler.c mBase = new com.igexin.base.scheduler.a();

    public enum TASKLEVEL {
        LEVEL_MIN(1),
        LEVEL_LOW(2),
        LEVEL_DEFAULT(3),
        LEVEL_HIGH(4),
        LEVEL_MAX(5);

        public int val;

        TASKLEVEL(int i) {
            this.val = i;
        }
    }

    private GTSchedulerManager() {
    }

    private void checkTask(com.igexin.base.scheduler.BaseTask baseTask) {
        baseTask.getClass();
    }

    public static com.igexin.base.api.GTSchedulerManager getInstance() {
        if (mInstance == null) {
            synchronized (com.igexin.base.api.GTSchedulerManager.class) {
                if (mInstance == null) {
                    mInstance = new com.igexin.base.api.GTSchedulerManager();
                }
            }
        }
        return mInstance;
    }

    @Override // com.igexin.base.scheduler.c
    public void execute(com.igexin.base.scheduler.BaseTask baseTask) {
        checkTask(baseTask);
        this.mBase.execute(baseTask);
    }

    @Override // com.igexin.base.scheduler.c
    public void submit(com.igexin.base.scheduler.BaseTask baseTask) {
        checkTask(baseTask);
        this.mBase.submit(baseTask);
    }
}
