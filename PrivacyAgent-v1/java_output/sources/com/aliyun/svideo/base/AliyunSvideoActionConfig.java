package com.aliyun.svideo.base;

/* loaded from: classes.dex */
public class AliyunSvideoActionConfig {
    private com.aliyun.svideo.base.ActionInfo mAction;

    public static class Instance {
        private static com.aliyun.svideo.base.AliyunSvideoActionConfig mActionConfig = new com.aliyun.svideo.base.AliyunSvideoActionConfig(null);

        private Instance() {
        }
    }

    private AliyunSvideoActionConfig() {
        this.mAction = new com.aliyun.svideo.base.ActionInfo();
    }

    public /* synthetic */ AliyunSvideoActionConfig(defpackage.l8 l8Var) {
        this();
    }

    public static com.aliyun.svideo.base.AliyunSvideoActionConfig getInstance() {
        return com.aliyun.svideo.base.AliyunSvideoActionConfig.Instance.mActionConfig;
    }

    public com.aliyun.svideo.base.ActionInfo getAction() {
        if (this.mAction == null) {
            this.mAction = new com.aliyun.svideo.base.ActionInfo();
        }
        return this.mAction;
    }

    public void registerCropFinishActivity(java.lang.String str) {
        this.mAction.setTagClassName(com.aliyun.svideo.base.ActionInfo.SVideoAction.CROP_TARGET_CLASSNAME, str);
    }

    public void registerEditFinishActivity(java.lang.String str) {
        this.mAction.setTagClassName(com.aliyun.svideo.base.ActionInfo.SVideoAction.EDITOR_TARGET_CLASSNAME, str);
    }

    public void registerPublishActivity(java.lang.String str) {
        this.mAction.setTagClassName(com.aliyun.svideo.base.ActionInfo.SVideoAction.PUBLISH_TARGET_CLASSNAME, str);
    }

    public void registerRecordFinishActivity(java.lang.String str) {
        this.mAction.setTagClassName(com.aliyun.svideo.base.ActionInfo.SVideoAction.RECORD_TARGET_CLASSNAME, str);
    }
}
