package com.aliyun.svideosdk.editor.template;

/* loaded from: classes12.dex */
public class b extends com.aliyun.svideosdk.editor.template.c implements com.aliyun.svideosdk.editor.template.AliyunTemplateEditor {
    private com.aliyun.svideosdk.common.struct.template.AliyunTemplate c;

    public b(android.net.Uri uri) {
        super(uri);
        com.aliyun.svideosdk.common.struct.template.AliyunTemplate aliyunTemplate = com.aliyun.svideosdk.editor.template.AliyunTemplateFactory.getAliyunTemplate(android.net.Uri.parse(getEditorProject().getTemplate().getPath()));
        this.c = aliyunTemplate;
        if (aliyunTemplate == null) {
            throw new java.lang.IllegalArgumentException("can not find the template");
        }
    }

    @Override // com.aliyun.svideosdk.editor.template.c, com.aliyun.svideosdk.editor.template.AliyunTemplatePlayer
    public java.util.List<com.aliyun.svideosdk.common.struct.template.AliyunTemplateParam> getAllParams() {
        java.util.List<com.aliyun.svideosdk.common.struct.template.AliyunTemplateParam> allParams = super.getAllParams();
        for (com.aliyun.svideosdk.common.struct.template.AliyunTemplateParam aliyunTemplateParam : allParams) {
            for (com.aliyun.svideosdk.common.struct.template.AliyunTemplateParam aliyunTemplateParam2 : this.c.getParams()) {
                if (aliyunTemplateParam2.isLock() && aliyunTemplateParam2.getNodeKey().equals(aliyunTemplateParam.getNodeKey())) {
                    aliyunTemplateParam.setLock(aliyunTemplateParam2.isLock());
                }
            }
        }
        return allParams;
    }

    @Override // com.aliyun.svideosdk.editor.template.AliyunTemplateEditor
    public long getMainClipStartTime(int i) {
        return a().getClipStartTime(i);
    }

    @Override // com.aliyun.svideosdk.editor.template.AliyunTemplateEditor
    public void updateCaption(com.aliyun.svideosdk.common.struct.template.AliyunTemplateTextParam aliyunTemplateTextParam, java.lang.String str) {
        if (aliyunTemplateTextParam.getTarget() instanceof com.aliyun.svideosdk.common.struct.project.CaptionTrack) {
            com.aliyun.svideosdk.common.struct.project.CaptionTrack captionTrack = (com.aliyun.svideosdk.common.struct.project.CaptionTrack) aliyunTemplateTextParam.getTarget();
            aliyunTemplateTextParam.setText(str);
            captionTrack.setText(str);
            com.aliyun.svideosdk.common.AliyunCaption caption = captionTrack.toCaption();
            caption.setText(str);
            a().updateCaption(caption);
            captionTrack.updateInfo();
        }
    }

    @Override // com.aliyun.svideosdk.editor.template.AliyunTemplateEditor
    public void updateMediaClip(com.aliyun.svideosdk.common.struct.template.AliyunTemplateVideoParam aliyunTemplateVideoParam, com.aliyun.svideosdk.common.struct.common.AliyunClip aliyunClip) {
        int i;
        com.aliyun.svideosdk.editor.impl.s sVar;
        int i2;
        com.aliyun.svideosdk.editor.AliyunIPipController createPipInTrack;
        int i3;
        if (aliyunClip instanceof com.aliyun.svideosdk.common.struct.common.AliyunVideoClip) {
            com.aliyun.svideosdk.common.struct.common.AliyunVideoClip aliyunVideoClip = (com.aliyun.svideosdk.common.struct.common.AliyunVideoClip) aliyunClip;
            if (aliyunVideoClip.getEndTime() - aliyunVideoClip.getStartTime() < (aliyunTemplateVideoParam.getTimelineOut() - aliyunTemplateVideoParam.getTimelineIn()) * 1000.0f) {
                throw new java.lang.IllegalArgumentException("The video duration is less than the param duration");
            }
        }
        if (aliyunTemplateVideoParam.getTarget() instanceof com.aliyun.svideosdk.common.struct.project.PipVideoTrackClip) {
            com.aliyun.svideosdk.editor.AliyunIPipManager pipManager = a().getPipManager();
            com.aliyun.svideosdk.common.struct.project.PipVideoTrackClip pipVideoTrackClip = (com.aliyun.svideosdk.common.struct.project.PipVideoTrackClip) aliyunTemplateVideoParam.getTarget();
            long timelineOut = (long) ((pipVideoTrackClip.getTimelineOut() - pipVideoTrackClip.getTimelineIn()) * 1000000.0f);
            java.util.Iterator<com.aliyun.svideosdk.editor.AliyunIPipController> it = a().getPipManager().getAllPip().iterator();
            while (true) {
                i = 0;
                sVar = null;
                if (!it.hasNext()) {
                    i2 = 0;
                    break;
                }
                com.aliyun.svideosdk.editor.AliyunIPipController next = it.next();
                if (next.getStreamId() == pipVideoTrackClip.getClipId()) {
                    com.aliyun.svideosdk.editor.impl.s sVar2 = (com.aliyun.svideosdk.editor.impl.s) next.getOwnerTrack();
                    if (sVar2.getPipClips().size() > 1) {
                        i3 = sVar2.b().getVideoTrackClips().indexOf(pipVideoTrackClip);
                    } else {
                        i = getEditorProject().getTimeline().getVideoTracks().indexOf(sVar2.b());
                        sVar2 = null;
                        i3 = 0;
                    }
                    pipManager.removePip(next);
                    int i4 = i3;
                    sVar = sVar2;
                    i2 = i;
                    i = i4;
                }
            }
            java.lang.String source = aliyunClip.getSource();
            if (sVar == null) {
                createPipInTrack = pipManager.createNewPip(source);
                com.aliyun.svideosdk.common.struct.project.VideoTrack b = ((com.aliyun.svideosdk.editor.impl.s) createPipInTrack.getOwnerTrack()).b();
                getEditorProject().getTimeline().getVideoTracks().remove(b);
                getEditorProject().getTimeline().getVideoTracks().add(i2, b);
            } else {
                createPipInTrack = pipManager.createPipInTrack(source, sVar);
                com.aliyun.svideosdk.common.struct.project.PipVideoTrackClip c = ((com.aliyun.svideosdk.editor.impl.q) createPipInTrack).c();
                sVar.b().getVideoTrackClips().remove(c);
                sVar.b().getVideoTrackClips().add(i, c);
            }
            com.aliyun.svideosdk.editor.impl.q qVar = (com.aliyun.svideosdk.editor.impl.q) createPipInTrack;
            com.aliyun.svideosdk.editor.impl.q a = qVar.a((long) (pipVideoTrackClip.getDuration() * 1000000.0f));
            java.util.concurrent.TimeUnit timeUnit = java.util.concurrent.TimeUnit.MICROSECONDS;
            a.setClipStartTime(0L, timeUnit).setClipEndTime(timelineOut, timeUnit).setTimelineStartTime(((long) pipVideoTrackClip.getTimelineIn()) * 1000000, timeUnit).setBorderColor(pipVideoTrackClip.getBorder().getColor()).setBorderWidth(pipVideoTrackClip.getBorder().getWidth() * getEditorProject().getConfig().getOutputWidth()).setBorderCornerRadius(pipVideoTrackClip.getBorder().getCornerRadius() * getEditorProject().getConfig().getOutputWidth()).apply();
            qVar.getLayoutController().setScale(pipVideoTrackClip.getScale()).setAlpha(pipVideoTrackClip.getAlpha()).setRotation(pipVideoTrackClip.getRotationRadian()).setPosition(pipVideoTrackClip.getCenterX(), pipVideoTrackClip.getCenterY()).apply();
            qVar.getAugmentationController().setBrightness(pipVideoTrackClip.getBrightness()).setSharpness(pipVideoTrackClip.getSharpness()).setSaturation(pipVideoTrackClip.getSaturation()).setContrast(pipVideoTrackClip.getContrast()).setVignette(pipVideoTrackClip.getVignette()).apply();
            qVar.getAudioController().setVolume(pipVideoTrackClip.getMixWeight()).denoise(pipVideoTrackClip.getDenoiseWeight()).apply();
            for (com.aliyun.svideosdk.common.struct.project.Effect effect : pipVideoTrackClip.getEffects()) {
                if (effect.getType() == com.aliyun.svideosdk.common.struct.project.Effect.Type.audio_effect) {
                    qVar.getAudioController().setAudioEffect(((com.aliyun.svideosdk.common.struct.project.AudioEffect) effect).mEffectType, r2.mEffectParam / 100.0f);
                } else if (effect.getType() == com.aliyun.svideosdk.common.struct.project.Effect.Type.audio_fade) {
                    com.aliyun.svideosdk.common.struct.project.AudioFade audioFade = (com.aliyun.svideosdk.common.struct.project.AudioFade) effect;
                    com.aliyun.svideosdk.editor.ShapeType shapeType = com.aliyun.svideosdk.editor.ShapeType.SHAPE_TYPE_LINEAR;
                    int i5 = audioFade.shapeType;
                    if (i5 == 1 || i5 == 3) {
                        shapeType = com.aliyun.svideosdk.editor.ShapeType.SHAPE_TYPE_SIN;
                    }
                    if (audioFade.isFadeIn) {
                        qVar.getAudioController().setAudioFadeIn(shapeType, com.aliyun.common.media.TimeUnitUtil.secondsToMicros(audioFade.duration));
                    } else {
                        qVar.getAudioController().setAudioFadeOut(shapeType, com.aliyun.common.media.TimeUnitUtil.secondsToMicros(audioFade.duration));
                    }
                }
            }
            qVar.getAudioController().apply();
            java.util.Iterator<com.aliyun.svideosdk.common.struct.effect.ActionBase> it2 = pipVideoTrackClip.getActions().iterator();
            while (it2.hasNext()) {
                qVar.getAnimationController().addFrameAnimation(it2.next());
            }
            a().draw(a().getCurrentPlayPosition());
            aliyunTemplateVideoParam.setTarget(qVar.c());
        } else if (aliyunTemplateVideoParam.getTarget() instanceof com.aliyun.svideosdk.common.struct.project.VideoTrackClip) {
            int indexOf = getEditorProject().getTimeline().getPrimaryTrack().getVideoTrackClips().indexOf(aliyunTemplateVideoParam.getTarget());
            if (indexOf == -1) {
                return;
            }
            long currentPlayPosition = a().getCurrentPlayPosition();
            com.aliyun.svideosdk.editor.AliyunISourcePartManager sourcePartManager = a().getSourcePartManager();
            aliyunClip.setTransition(((com.aliyun.svideosdk.common.struct.project.VideoTrackClip) aliyunTemplateVideoParam.getTarget()).getTransition());
            sourcePartManager.updateMediaClip(indexOf, aliyunClip);
            a().applySourceChange();
            com.aliyun.svideosdk.common.struct.project.VideoTrackClip videoTrackClip = getEditorProject().getTimeline().getPrimaryTrack().getVideoTrackClips().get(indexOf);
            videoTrackClip.setNodeKey(aliyunTemplateVideoParam.getNodeKey());
            aliyunTemplateVideoParam.setTarget(videoTrackClip);
            a().play();
            a().seek(currentPlayPosition);
        }
        a().saveEffectToLocal();
    }
}
