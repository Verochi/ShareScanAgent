package com.aliyun.svideo.media;

/* loaded from: classes12.dex */
public class MediaDir {
    public java.lang.String dirName;
    public int fileCount;
    public int id;
    public int resId;
    public java.lang.String thumbnailUrl;
    public int type;
    public java.lang.String videoDirPath;

    public boolean equals(java.lang.Object obj) {
        if (obj instanceof com.aliyun.svideo.media.MediaDir) {
            return this.dirName.equals(((com.aliyun.svideo.media.MediaDir) obj).dirName);
        }
        return false;
    }
}
