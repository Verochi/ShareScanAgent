package com.aliyun.svideosdk.common.struct.project;

/* loaded from: classes12.dex */
public class AliyunProjectInfo implements com.aliyun.svideosdk.common.struct.project.AliyunIProjectInfo {
    private com.aliyun.svideosdk.common.struct.project.AliyunEditorProject mProject;

    public AliyunProjectInfo(com.aliyun.svideosdk.common.struct.project.AliyunEditorProject aliyunEditorProject) {
        this.mProject = aliyunEditorProject;
    }

    @Override // com.aliyun.svideosdk.common.struct.project.AliyunIProjectInfo
    public java.util.List<com.aliyun.svideosdk.common.struct.effect.EffectBean> getMusicList() {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.util.Iterator<com.aliyun.svideosdk.common.struct.project.AudioTrack> it = this.mProject.getTimeline().getAudioTracks().iterator();
        while (it.hasNext()) {
            for (com.aliyun.svideosdk.common.struct.project.AudioTrackClip audioTrackClip : it.next().getAudioTrackClips()) {
                if (audioTrackClip.getType() == com.aliyun.svideosdk.common.struct.project.AudioTrackClip.Type.Music) {
                    com.aliyun.svideosdk.common.struct.effect.EffectBean effectBean = new com.aliyun.svideosdk.common.struct.effect.EffectBean();
                    effectBean.setId(audioTrackClip.getClipId());
                    effectBean.setOldId(audioTrackClip.getClipId());
                    effectBean.setDuration((long) ((audioTrackClip.getTimelineOut() - audioTrackClip.getTimelineIn()) * 1000000.0f));
                    effectBean.setPath(audioTrackClip.getSource().getPath());
                    effectBean.setSource(audioTrackClip.getSource());
                    effectBean.setStartTime((long) (audioTrackClip.getTimelineIn() * 1000000.0f));
                    effectBean.setStreamDuration((long) ((audioTrackClip.getOut() - audioTrackClip.getIn()) * 1000000.0f));
                    effectBean.setStreamStartTime((long) (audioTrackClip.getIn() * 1000000.0f));
                    effectBean.setWeight(audioTrackClip.getMixWeight());
                    arrayList.add(effectBean);
                }
            }
        }
        return arrayList;
    }

    @Override // com.aliyun.svideosdk.common.struct.project.AliyunIProjectInfo
    public java.util.List<com.aliyun.svideosdk.common.struct.effect.EffectPicture> getPictureList() {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.util.Iterator<com.aliyun.svideosdk.common.struct.project.PasterTrack> it = this.mProject.getPasterTrackByType(com.aliyun.svideosdk.common.struct.project.PasterTrack.Type.photo).iterator();
        while (it.hasNext()) {
            com.aliyun.svideosdk.common.struct.project.PhotoPasterTrack photoPasterTrack = (com.aliyun.svideosdk.common.struct.project.PhotoPasterTrack) it.next();
            com.aliyun.svideosdk.common.struct.effect.EffectPicture effectPicture = new com.aliyun.svideosdk.common.struct.effect.EffectPicture(photoPasterTrack.getSource().getPath());
            effectPicture.end = (long) (photoPasterTrack.getTimelineOut() * 1000000.0f);
            effectPicture.start = (long) (photoPasterTrack.getTimelineIn() * 1000000.0f);
            effectPicture.width = photoPasterTrack.getWidth();
            effectPicture.height = photoPasterTrack.getHeight();
            effectPicture.mirror = photoPasterTrack.isMirror();
            effectPicture.rotation = photoPasterTrack.getRotation();
            effectPicture.x = photoPasterTrack.getX();
            effectPicture.y = photoPasterTrack.getY();
            effectPicture.setViewId(photoPasterTrack.getId());
            effectPicture.setOldId(photoPasterTrack.getId());
            arrayList.add(effectPicture);
        }
        return arrayList;
    }
}
