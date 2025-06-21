package com.aliyun.svideosdk.common.impl;

/* loaded from: classes12.dex */
public class c implements com.aliyun.svideosdk.common.AliyunIClipManager {
    protected java.util.List<com.aliyun.svideosdk.common.struct.common.AliyunClip> a = new java.util.ArrayList();

    public c(java.util.List<com.aliyun.svideosdk.common.struct.project.VideoTrackClip> list) {
        if (list != null) {
            com.aliyun.svideosdk.common.struct.common.AliyunClip aliyunClip = null;
            for (com.aliyun.svideosdk.common.struct.project.VideoTrackClip videoTrackClip : list) {
                if (videoTrackClip instanceof com.aliyun.svideosdk.common.struct.project.MainVideoTrackClip) {
                    com.aliyun.svideosdk.common.struct.project.MainVideoTrackClip mainVideoTrackClip = (com.aliyun.svideosdk.common.struct.project.MainVideoTrackClip) videoTrackClip;
                    if (videoTrackClip.getType() == 0) {
                        aliyunClip = new com.aliyun.svideosdk.common.struct.common.AliyunVideoClip.Builder().source(videoTrackClip.getSource().getPath()).startTime((long) (videoTrackClip.getIn() * 1000.0f)).endTime((long) (videoTrackClip.getOut() * 1000.0f)).displayMode(com.aliyun.svideosdk.common.struct.common.AliyunDisplayMode.getInstanceByValue(mainVideoTrackClip.getDisplayMode())).rotation(videoTrackClip.getRotation()).transition(videoTrackClip.getTransition()).id(videoTrackClip.getClipId()).build();
                    } else if (videoTrackClip.getType() == 1) {
                        aliyunClip = new com.aliyun.svideosdk.common.struct.common.AliyunImageClip.Builder().displayMode(com.aliyun.svideosdk.common.struct.common.AliyunDisplayMode.getInstanceByValue(mainVideoTrackClip.getDisplayMode())).duration((long) ((videoTrackClip.getOut() - videoTrackClip.getIn()) * 1000.0f)).id(videoTrackClip.getClipId()).transition(videoTrackClip.getTransition()).source(videoTrackClip.getSource().getPath()).build();
                    }
                    this.a.add(aliyunClip);
                }
            }
        }
    }

    @Override // com.aliyun.svideosdk.common.AliyunIClipManager
    public int addMediaClip(int i, com.aliyun.svideosdk.common.struct.common.AliyunClip aliyunClip) {
        if (aliyunClip == null) {
            return -20003007;
        }
        if (i < 0 || i >= getMediaClipCount()) {
            return -20003006;
        }
        this.a.add(i, aliyunClip);
        return i;
    }

    @Override // com.aliyun.svideosdk.common.AliyunIClipManager
    public int addMediaClip(com.aliyun.svideosdk.common.struct.common.AliyunClip aliyunClip) {
        if (aliyunClip == null) {
            return -20003007;
        }
        this.a.add(aliyunClip);
        return getMediaClipCount() - 1;
    }

    @Override // com.aliyun.svideosdk.common.AliyunIClipManager
    public int deleteLastMediaClip() {
        if (getMediaClipCount() == 0) {
            return -20003008;
        }
        this.a.remove(getMediaClipCount() - 1);
        return 0;
    }

    @Override // com.aliyun.svideosdk.common.AliyunIClipManager
    public int deleteMediaClip(int i) {
        if (i < 0 || i >= getMediaClipCount()) {
            return -20003006;
        }
        this.a.remove(i);
        return 0;
    }

    @Override // com.aliyun.svideosdk.common.AliyunIClipManager
    public void deleteMediaClip(com.aliyun.svideosdk.common.struct.common.AliyunClip aliyunClip) {
        this.a.remove(aliyunClip);
    }

    @Override // com.aliyun.svideosdk.common.AliyunIClipManager
    public java.util.List<com.aliyun.svideosdk.common.struct.common.AliyunClip> getAllClips() {
        java.util.ArrayList arrayList = new java.util.ArrayList(java.util.Arrays.asList(new com.aliyun.svideosdk.common.struct.common.AliyunClip[getMediaClipCount()]));
        java.util.Collections.copy(arrayList, this.a);
        return arrayList;
    }

    @Override // com.aliyun.svideosdk.common.AliyunIClipManager
    public com.aliyun.svideosdk.common.struct.common.AliyunClip getMediaClip(int i) {
        if (i < 0 || i >= getMediaClipCount()) {
            return null;
        }
        return this.a.get(i);
    }

    @Override // com.aliyun.svideosdk.common.AliyunIClipManager
    public int getMediaClipCount() {
        return this.a.size();
    }

    @Override // com.aliyun.svideosdk.common.AliyunIClipManager
    public void swap(int i, int i2) {
        if (i == i2 || i >= getMediaClipCount() || i2 >= getMediaClipCount() || i < 0 || i >= getMediaClipCount() || i2 < 0 || i2 >= getMediaClipCount()) {
            return;
        }
        java.util.Collections.swap(this.a, i, i2);
    }

    @Override // com.aliyun.svideosdk.common.AliyunIClipManager
    public void updateAllClips(java.util.List<com.aliyun.svideosdk.common.struct.common.AliyunClip> list) {
        this.a.clear();
        java.util.Collections.addAll(this.a, new com.aliyun.svideosdk.common.struct.common.AliyunClip[list.size()]);
        java.util.Collections.copy(this.a, list);
    }

    @Override // com.aliyun.svideosdk.common.AliyunIClipManager
    public int updateMediaClip(int i, com.aliyun.svideosdk.common.struct.common.AliyunClip aliyunClip) {
        if (aliyunClip == null) {
            return -20003007;
        }
        if (i < 0 || i >= getMediaClipCount()) {
            return -20003006;
        }
        this.a.set(i, aliyunClip);
        return i;
    }
}
