package com.aliyun.svideo.editor.draft;

/* loaded from: classes12.dex */
public class CloudDraftItem {
    public boolean isDownload;

    @com.google.gson.annotations.SerializedName("backup_time")
    public long mBackupTime;

    @com.google.gson.annotations.SerializedName("cover_url")
    public java.lang.String mCoverPath;
    public java.lang.String mDraftId;

    @com.google.gson.annotations.SerializedName("duration")
    public long mDuration;

    @com.google.gson.annotations.SerializedName(tv.danmaku.ijk.media.player.IjkMediaPlayer.OnNativeInvokeListener.ARG_FILE_SIZE)
    public long mFileSize;

    @com.google.gson.annotations.SerializedName("modified_time")
    public java.lang.String mModifiedTime;

    @com.google.gson.annotations.SerializedName("name")
    public java.lang.String mName;

    @com.google.gson.annotations.SerializedName("id")
    public java.lang.String mProjectId;

    @com.google.gson.annotations.SerializedName("project_url")
    public java.lang.String mProjectUrl;
}
