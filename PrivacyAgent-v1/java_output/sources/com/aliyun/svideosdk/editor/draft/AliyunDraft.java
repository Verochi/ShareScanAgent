package com.aliyun.svideosdk.editor.draft;

@com.aliyun.Visible
/* loaded from: classes12.dex */
public class AliyunDraft {
    private com.aliyun.svideosdk.common.struct.project.Config mConfig = new com.aliyun.svideosdk.common.struct.project.Config();
    private java.lang.String mCoverPath;
    private long mDuration;
    private java.lang.String mEditorProjectUri;
    private long mFileSize;
    private java.lang.String mId;
    private java.lang.String mName;
    private java.lang.String mProjectId;
    private long mUpdateTime;

    public com.aliyun.svideosdk.common.struct.project.Config getConfig() {
        return this.mConfig;
    }

    public java.lang.String getCoverPath() {
        return this.mCoverPath;
    }

    public long getDuration() {
        return this.mDuration;
    }

    public java.lang.String getEditorProjectUri() {
        return this.mEditorProjectUri;
    }

    public long getFileSize() {
        return this.mFileSize;
    }

    public java.lang.String getId() {
        return this.mId;
    }

    public java.lang.String getName() {
        return this.mName;
    }

    public java.lang.String getProjectId() {
        return this.mProjectId;
    }

    public long getUpdateTime() {
        return this.mUpdateTime;
    }

    public void setConfig(com.aliyun.svideosdk.common.struct.project.Config config) {
        this.mConfig = config;
    }

    public void setCoverPath(java.lang.String str) {
        this.mCoverPath = str;
    }

    public void setDuration(long j) {
        this.mDuration = j;
    }

    public void setEditorProjectUri(java.lang.String str) {
        this.mEditorProjectUri = str;
    }

    public void setFileSize(long j) {
        this.mFileSize = j;
    }

    public void setId(java.lang.String str) {
        this.mId = str;
    }

    public void setName(java.lang.String str) {
        this.mName = str;
    }

    public void setProjectId(java.lang.String str) {
        this.mProjectId = str;
    }

    public void setUpdateTime(long j) {
        this.mUpdateTime = j;
    }
}
