package com.aliyun.svideosdk.common.struct.project;

@com.aliyun.Visible
/* loaded from: classes12.dex */
public class AliyunEditorProject {

    @android.annotation.SuppressLint({"SimpleDateFormat"})
    public static final java.text.SimpleDateFormat DATE_FORMAT = new java.text.SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
    public static final java.lang.String DRAFT_DIR = "svideo_res/draft";
    public static final java.lang.String PROJECT_FILENAME = "project.aliyunvideo.json";
    public static final int PROJECT_VERSION = 1;
    public static final java.lang.String TEMPLATE_DRAFT_DIR = "svideo_res/template_draft";

    @com.google.gson.annotations.SerializedName("Cover")
    private com.aliyun.svideosdk.common.struct.project.Source mCover;

    @com.google.gson.annotations.SerializedName("CreationTime")
    private java.lang.String mCreationTime;

    @com.google.gson.annotations.SerializedName("CustomCover")
    private boolean mCustomCover;

    @com.google.gson.annotations.SerializedName(com.aliyun.auth.core.AliyunVodKey.KEY_VOD_DURATION)
    private float mDuration;

    @com.google.gson.annotations.SerializedName("ModifiedTime")
    private java.lang.String mModifiedTime;
    private transient java.io.File mProjectDir;
    private transient java.io.File mProjectFile;

    @com.google.gson.annotations.SerializedName("ProjectId")
    private java.lang.String mProjectId;

    @com.google.gson.annotations.SerializedName("ResourceSize")
    private long mResourceSize;

    @com.google.gson.annotations.SerializedName("Status")
    private java.lang.String mStatus;

    @com.google.gson.annotations.SerializedName("Template")
    private com.aliyun.svideosdk.common.struct.project.Source mTemplate;

    @com.google.gson.annotations.SerializedName(com.aliyun.auth.core.AliyunVodKey.KEY_VOD_TITLE)
    private java.lang.String mTitle;

    @com.google.gson.annotations.SerializedName("Version")
    private int mVersion = 1;

    @com.google.gson.annotations.SerializedName("Config")
    private com.aliyun.svideosdk.common.struct.project.Config mConfig = new com.aliyun.svideosdk.common.struct.project.Config();

    @com.google.gson.annotations.SerializedName("Timeline")
    public com.aliyun.svideosdk.common.struct.project.Timeline mTimeline = new com.aliyun.svideosdk.common.struct.project.Timeline();
    private java.lang.String mRequestID = null;

    private void clearGlobalTrack(com.aliyun.svideosdk.common.struct.project.GlobalTrack.Type type) {
        if (this.mTimeline.getGlobalTracks().isEmpty()) {
            return;
        }
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (com.aliyun.svideosdk.common.struct.project.GlobalTrack globalTrack : getTimeline().getGlobalTracks()) {
            if (globalTrack.getType() == type) {
                arrayList.add(globalTrack);
            }
        }
        getTimeline().getGlobalTracks().removeAll(arrayList);
    }

    private long getFileSize(java.io.File file) {
        if (file == null || !file.exists()) {
            return 0L;
        }
        return com.aliyun.common.utils.FileUtils.sizeOf(file);
    }

    private com.aliyun.svideosdk.common.struct.project.GlobalTrack getGlobalTrack(com.aliyun.svideosdk.common.struct.project.GlobalTrack.Type type) {
        if (this.mTimeline.getGlobalTracks().isEmpty()) {
            return null;
        }
        for (com.aliyun.svideosdk.common.struct.project.GlobalTrack globalTrack : getTimeline().getGlobalTracks()) {
            if (globalTrack.getType() == type) {
                return globalTrack;
            }
        }
        return null;
    }

    public static java.io.File getProjectFile(java.io.File file) {
        java.io.File file2 = new java.io.File(file, PROJECT_FILENAME);
        if (!file2.exists()) {
            try {
                file2.createNewFile();
            } catch (java.io.IOException e) {
                e.printStackTrace();
            }
        }
        return file2;
    }

    public void addAction(com.aliyun.svideosdk.common.struct.effect.ActionBase actionBase) {
        if (actionBase.isStream()) {
            com.aliyun.svideosdk.common.struct.project.VideoTrackClip videoTrackClipById = getVideoTrackClipById(actionBase.getTargetId());
            if (videoTrackClipById != null) {
                videoTrackClipById.getActions().add(actionBase);
                return;
            }
            return;
        }
        for (com.aliyun.svideosdk.common.struct.project.PasterTrack pasterTrack : getTimeline().getPasterTracks()) {
            if ((pasterTrack instanceof com.aliyun.svideosdk.common.struct.project.PhotoPasterTrack) && pasterTrack.getId() == actionBase.getTargetId()) {
                ((com.aliyun.svideosdk.common.struct.project.PhotoPasterTrack) pasterTrack).getActions().add(actionBase);
                return;
            }
        }
        if (getWaterMark() != null && getWaterMark().getId() == actionBase.getTargetId()) {
            getWaterMark().getActions().add(actionBase);
        }
        if (getTailWaterMark() == null || getTailWaterMark().getId() != actionBase.getTargetId()) {
            return;
        }
        getTailWaterMark().getActions().add(actionBase);
    }

    public void addAnimationFilter(com.aliyun.svideosdk.common.struct.project.Filter filter) {
        if (filter != null) {
            this.mTimeline.getEffectTracks().add(filter);
        }
    }

    public void addAudioTrackClip(com.aliyun.svideosdk.common.struct.project.AudioTrackClip audioTrackClip) {
        com.aliyun.svideosdk.common.struct.project.AudioTrack audioTrack = new com.aliyun.svideosdk.common.struct.project.AudioTrack();
        audioTrack.getAudioTrackClips().add(audioTrackClip);
        audioTrack.setDuration(audioTrackClip.getOut() - audioTrackClip.getIn());
        this.mTimeline.getAudioTracks().add(audioTrack);
    }

    public void addEffect(int i, com.aliyun.svideosdk.common.struct.project.Effect effect) {
        removeEffect(i, effect);
        com.aliyun.svideosdk.common.struct.project.VideoTrackClip videoTrackClipById = getVideoTrackClipById(i);
        if (videoTrackClipById != null) {
            videoTrackClipById.getEffects().add(effect);
            return;
        }
        com.aliyun.svideosdk.common.struct.project.AudioTrackClip audioTrackClipById = getAudioTrackClipById(i);
        if (audioTrackClipById != null) {
            audioTrackClipById.getEffects().add(effect);
        }
    }

    public void addPasterTrack(com.aliyun.svideosdk.common.struct.project.PasterTrack pasterTrack) {
        getTimeline().getPasterTracks().add(pasterTrack);
    }

    public void addTimeFilter(com.aliyun.svideosdk.common.struct.project.TimeFilter timeFilter) {
        if (timeFilter != null) {
            if (this.mTimeline.getEffectTracks().isEmpty()) {
                this.mTimeline.getEffectTracks().add(new com.aliyun.svideosdk.common.struct.project.EffectTrack());
            }
            this.mTimeline.getEffectTracks().add(timeFilter);
        }
    }

    public void clearAnimationFilters() {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (com.aliyun.svideosdk.common.struct.project.EffectTrack effectTrack : this.mTimeline.getEffectTracks()) {
            if (effectTrack.getType() == com.aliyun.svideosdk.common.struct.project.EffectTrack.Type.animation_filter) {
                arrayList.add(effectTrack);
            }
        }
        this.mTimeline.getEffectTracks().removeAll(arrayList);
    }

    public void clearColorEffect() {
        clearEffectTrack(com.aliyun.svideosdk.common.struct.project.EffectTrack.Type.filter);
    }

    public void clearEffectTrack(com.aliyun.svideosdk.common.struct.project.EffectTrack.Type type) {
        if (this.mTimeline.getEffectTracks().isEmpty()) {
            return;
        }
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (com.aliyun.svideosdk.common.struct.project.EffectTrack effectTrack : this.mTimeline.getEffectTracks()) {
            if (effectTrack.getType() == type) {
                arrayList.add(effectTrack);
            }
        }
        this.mTimeline.getEffectTracks().removeAll(arrayList);
    }

    public void clearMusic() {
        if (getTimeline().getAudioTracks().isEmpty()) {
            return;
        }
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.util.Iterator<com.aliyun.svideosdk.common.struct.project.AudioTrack> it = getTimeline().getAudioTracks().iterator();
        while (it.hasNext()) {
            for (com.aliyun.svideosdk.common.struct.project.AudioTrackClip audioTrackClip : it.next().getAudioTrackClips()) {
                if (audioTrackClip.getType() == com.aliyun.svideosdk.common.struct.project.AudioTrackClip.Type.Music) {
                    arrayList.add(audioTrackClip);
                }
            }
        }
        java.util.Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            removeAudioTrackClip(((com.aliyun.svideosdk.common.struct.project.AudioTrackClip) it2.next()).getClipId());
        }
    }

    public void clearRollCaptionTrack() {
        com.aliyun.svideosdk.common.struct.project.RollCaptionTrack rollCaptionTrack = getRollCaptionTrack();
        if (rollCaptionTrack != null) {
            getTimeline().getPasterTracks().remove(rollCaptionTrack);
        }
    }

    public void clearTimeFilters() {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (com.aliyun.svideosdk.common.struct.project.EffectTrack effectTrack : this.mTimeline.getEffectTracks()) {
            if (effectTrack.getType() == com.aliyun.svideosdk.common.struct.project.EffectTrack.Type.time_effect) {
                arrayList.add(effectTrack);
            }
        }
        this.mTimeline.getEffectTracks().removeAll(arrayList);
    }

    public java.util.List<com.aliyun.svideosdk.common.struct.project.Filter> getAllAnimationFilters() {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (com.aliyun.svideosdk.common.struct.project.EffectTrack effectTrack : this.mTimeline.getEffectTracks()) {
            if (effectTrack.getType() == com.aliyun.svideosdk.common.struct.project.EffectTrack.Type.animation_filter) {
                arrayList.add((com.aliyun.svideosdk.common.struct.project.Filter) effectTrack);
            }
        }
        return new java.util.ArrayList(arrayList);
    }

    public java.util.List<com.aliyun.svideosdk.common.struct.project.TimeFilter> getAllTimeFilters() {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (com.aliyun.svideosdk.common.struct.project.EffectTrack effectTrack : this.mTimeline.getEffectTracks()) {
            if (effectTrack.getType() == com.aliyun.svideosdk.common.struct.project.EffectTrack.Type.time_effect) {
                arrayList.add((com.aliyun.svideosdk.common.struct.project.TimeFilter) effectTrack);
            }
        }
        return new java.util.ArrayList(arrayList);
    }

    public int getAudioId() {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.util.Iterator<com.aliyun.svideosdk.common.struct.project.AudioTrack> it = getTimeline().getAudioTracks().iterator();
        while (it.hasNext()) {
            for (com.aliyun.svideosdk.common.struct.project.AudioTrackClip audioTrackClip : it.next().getAudioTrackClips()) {
                if (audioTrackClip.getType() == com.aliyun.svideosdk.common.struct.project.AudioTrackClip.Type.Music) {
                    arrayList.add(audioTrackClip);
                }
            }
        }
        if (arrayList.size() == 0) {
            return 0;
        }
        return ((com.aliyun.svideosdk.common.struct.project.AudioTrackClip) arrayList.get(arrayList.size() - 1)).getSource().getIntId();
    }

    public com.aliyun.svideosdk.common.struct.project.AudioTrackClip getAudioTrackClipById(int i) {
        java.util.Iterator<com.aliyun.svideosdk.common.struct.project.AudioTrack> it = getTimeline().getAudioTracks().iterator();
        while (it.hasNext()) {
            for (com.aliyun.svideosdk.common.struct.project.AudioTrackClip audioTrackClip : it.next().getAudioTrackClips()) {
                if (audioTrackClip.getClipId() == i) {
                    return audioTrackClip;
                }
            }
        }
        return null;
    }

    public com.aliyun.svideosdk.common.struct.project.PaintTrack getCanvasTrack() {
        return (com.aliyun.svideosdk.common.struct.project.PaintTrack) getGlobalTrack(com.aliyun.svideosdk.common.struct.project.GlobalTrack.Type.paint);
    }

    public com.aliyun.svideosdk.common.struct.project.Filter getColorEffect() {
        if (this.mTimeline.getEffectTracks().isEmpty()) {
            return null;
        }
        for (com.aliyun.svideosdk.common.struct.project.EffectTrack effectTrack : this.mTimeline.getEffectTracks()) {
            if (effectTrack.getType() == com.aliyun.svideosdk.common.struct.project.EffectTrack.Type.filter) {
                return (com.aliyun.svideosdk.common.struct.project.Filter) effectTrack;
            }
        }
        return null;
    }

    public com.aliyun.svideosdk.common.struct.project.Config getConfig() {
        return this.mConfig;
    }

    public com.aliyun.svideosdk.common.struct.project.Source getCover() {
        return this.mCover;
    }

    public java.lang.String getCreationTime() {
        return this.mCreationTime;
    }

    public float getDuration() {
        return this.mDuration;
    }

    public com.aliyun.svideosdk.common.struct.project.MVFilter getMVEffect() {
        if (this.mTimeline.getEffectTracks().isEmpty()) {
            return null;
        }
        for (com.aliyun.svideosdk.common.struct.project.EffectTrack effectTrack : this.mTimeline.getEffectTracks()) {
            if (effectTrack.getType() == com.aliyun.svideosdk.common.struct.project.EffectTrack.Type.mv) {
                return (com.aliyun.svideosdk.common.struct.project.MVFilter) effectTrack;
            }
        }
        return null;
    }

    public java.lang.String getModifiedTime() {
        return this.mModifiedTime;
    }

    public com.aliyun.svideosdk.common.struct.project.PasterTrack getPasterTrackByID(int i) {
        for (com.aliyun.svideosdk.common.struct.project.PasterTrack pasterTrack : getTimeline().getPasterTracks()) {
            if (pasterTrack.getId() == i) {
                return pasterTrack;
            }
        }
        return null;
    }

    public java.util.List<com.aliyun.svideosdk.common.struct.project.PasterTrack> getPasterTrackByType(com.aliyun.svideosdk.common.struct.project.PasterTrack.Type type) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (com.aliyun.svideosdk.common.struct.project.PasterTrack pasterTrack : getTimeline().getPasterTracks()) {
            if (pasterTrack.getType() == type) {
                arrayList.add(pasterTrack);
            }
        }
        return arrayList;
    }

    public java.io.File getProjectDir() {
        return this.mProjectDir;
    }

    public java.io.File getProjectFile() {
        return this.mProjectFile;
    }

    public java.lang.String getProjectId() {
        return this.mProjectId;
    }

    public java.lang.String getRequestID() {
        return this.mRequestID;
    }

    public long getResourceSize() {
        return this.mResourceSize;
    }

    public com.aliyun.svideosdk.common.struct.project.RollCaptionTrack getRollCaptionTrack() {
        for (com.aliyun.svideosdk.common.struct.project.PasterTrack pasterTrack : getTimeline().getPasterTracks()) {
            if (pasterTrack.getType() == com.aliyun.svideosdk.common.struct.project.PasterTrack.Type.roll_captions) {
                return (com.aliyun.svideosdk.common.struct.project.RollCaptionTrack) pasterTrack;
            }
        }
        return null;
    }

    public com.aliyun.svideosdk.common.struct.project.TailWaterMark getTailWaterMark() {
        return (com.aliyun.svideosdk.common.struct.project.TailWaterMark) getGlobalTrack(com.aliyun.svideosdk.common.struct.project.GlobalTrack.Type.tail_watermark);
    }

    public com.aliyun.svideosdk.common.struct.project.Source getTemplate() {
        return this.mTemplate;
    }

    public com.aliyun.svideosdk.common.struct.project.Timeline getTimeline() {
        return this.mTimeline;
    }

    public java.lang.String getTitle() {
        return this.mTitle;
    }

    public android.net.Uri getUri() {
        java.io.File file = this.mProjectFile;
        if (file == null) {
            return null;
        }
        return android.net.Uri.fromFile(file);
    }

    public int getVersion() {
        return this.mVersion;
    }

    public com.aliyun.svideosdk.common.struct.project.VideoTrackClip getVideoTrackClipById(int i) {
        java.util.Iterator<com.aliyun.svideosdk.common.struct.project.VideoTrack> it = getTimeline().getVideoTracks().iterator();
        while (it.hasNext()) {
            for (com.aliyun.svideosdk.common.struct.project.VideoTrackClip videoTrackClip : it.next().getVideoTrackClips()) {
                if (videoTrackClip.getClipId() == i) {
                    return videoTrackClip;
                }
            }
        }
        return null;
    }

    public com.aliyun.svideosdk.common.struct.project.WaterMark getWaterMark() {
        return (com.aliyun.svideosdk.common.struct.project.WaterMark) getGlobalTrack(com.aliyun.svideosdk.common.struct.project.GlobalTrack.Type.watermark);
    }

    public boolean isCustomCover() {
        return this.mCustomCover;
    }

    public void refreshTimeLine() {
        float timelineOut;
        com.aliyun.svideosdk.common.struct.project.VideoTrackClip videoTrackClip = null;
        for (com.aliyun.svideosdk.common.struct.project.VideoTrackClip videoTrackClip2 : getTimeline().getPrimaryTrack().getVideoTrackClips()) {
            if (videoTrackClip == null) {
                videoTrackClip2.setTimelineIn(0.0f);
                timelineOut = videoTrackClip2.getOut() - videoTrackClip2.getIn();
            } else {
                videoTrackClip2.setTimelineIn(videoTrackClip.getTimelineOut());
                timelineOut = videoTrackClip.getTimelineOut() + (videoTrackClip2.getOut() - videoTrackClip2.getIn());
            }
            videoTrackClip2.setTimelineOut(timelineOut);
            videoTrackClip = videoTrackClip2;
        }
        if (videoTrackClip != null) {
            getTimeline().getPrimaryTrack().setDuration(videoTrackClip.getTimelineOut());
            setDuration(videoTrackClip.getTimelineOut());
            getTimeline().setDuration(getDuration());
        }
    }

    public void removeActionById(int i) {
        java.util.Iterator<com.aliyun.svideosdk.common.struct.project.VideoTrack> it = getTimeline().getVideoTracks().iterator();
        while (it.hasNext()) {
            for (com.aliyun.svideosdk.common.struct.project.VideoTrackClip videoTrackClip : it.next().getVideoTrackClips()) {
                for (com.aliyun.svideosdk.common.struct.effect.ActionBase actionBase : videoTrackClip.getActions()) {
                    if (actionBase.getId() == i) {
                        videoTrackClip.getActions().remove(actionBase);
                        return;
                    }
                }
            }
        }
        for (com.aliyun.svideosdk.common.struct.project.PasterTrack pasterTrack : getTimeline().getPasterTracks()) {
            if (pasterTrack instanceof com.aliyun.svideosdk.common.struct.project.PhotoPasterTrack) {
                com.aliyun.svideosdk.common.struct.project.PhotoPasterTrack photoPasterTrack = (com.aliyun.svideosdk.common.struct.project.PhotoPasterTrack) pasterTrack;
                for (com.aliyun.svideosdk.common.struct.effect.ActionBase actionBase2 : photoPasterTrack.getActions()) {
                    if (actionBase2.getId() == i) {
                        photoPasterTrack.getActions().remove(actionBase2);
                        return;
                    }
                }
            }
        }
        if (getWaterMark() != null) {
            java.util.Iterator<com.aliyun.svideosdk.common.struct.effect.ActionBase> it2 = getWaterMark().getActions().iterator();
            while (it2.hasNext()) {
                com.aliyun.svideosdk.common.struct.effect.ActionBase next = it2.next();
                if (next.getId() == i) {
                    getWaterMark().getActions().remove(next);
                    return;
                }
            }
        }
        if (getTailWaterMark() != null) {
            java.util.Iterator<com.aliyun.svideosdk.common.struct.effect.ActionBase> it3 = getTailWaterMark().getActions().iterator();
            while (it3.hasNext()) {
                com.aliyun.svideosdk.common.struct.effect.ActionBase next2 = it3.next();
                if (next2.getId() == i) {
                    getTailWaterMark().getActions().remove(next2);
                    return;
                }
            }
        }
    }

    public void removeAnimationFilter(int i) {
        for (com.aliyun.svideosdk.common.struct.project.EffectTrack effectTrack : this.mTimeline.getEffectTracks()) {
            if (effectTrack.getId() == i) {
                this.mTimeline.getEffectTracks().remove(effectTrack);
            }
        }
    }

    public void removeAudioTrackClip(int i) {
        for (com.aliyun.svideosdk.common.struct.project.AudioTrack audioTrack : getTimeline().getAudioTracks()) {
            for (com.aliyun.svideosdk.common.struct.project.AudioTrackClip audioTrackClip : audioTrack.getAudioTrackClips()) {
                if (audioTrackClip.getClipId() == i) {
                    audioTrack.getAudioTrackClips().remove(audioTrackClip);
                    if (audioTrack.getAudioTrackClips().isEmpty()) {
                        getTimeline().getAudioTracks().remove(audioTrack);
                        return;
                    }
                    return;
                }
            }
        }
    }

    public void removeCanvasTrack() {
        clearGlobalTrack(com.aliyun.svideosdk.common.struct.project.GlobalTrack.Type.paint);
    }

    public void removeEffect(int i, com.aliyun.svideosdk.common.struct.project.Effect effect) {
        com.aliyun.svideosdk.common.struct.project.VideoTrackClip videoTrackClipById = getVideoTrackClipById(i);
        if (videoTrackClipById != null) {
            for (com.aliyun.svideosdk.common.struct.project.Effect effect2 : videoTrackClipById.getEffects()) {
                if (effect.getType() == effect2.getType()) {
                    if (effect.getType() != com.aliyun.svideosdk.common.struct.project.Effect.Type.audio_fade) {
                        videoTrackClipById.getEffects().remove(effect2);
                        return;
                    } else if (((com.aliyun.svideosdk.common.struct.project.AudioFade) effect2).isFadeIn == ((com.aliyun.svideosdk.common.struct.project.AudioFade) effect).isFadeIn) {
                        videoTrackClipById.getEffects().remove(effect2);
                        return;
                    }
                }
            }
        }
        com.aliyun.svideosdk.common.struct.project.AudioTrackClip audioTrackClipById = getAudioTrackClipById(i);
        if (audioTrackClipById != null) {
            for (com.aliyun.svideosdk.common.struct.project.Effect effect3 : audioTrackClipById.getEffects()) {
                if (effect.getType() == effect3.getType()) {
                    if (effect.getType() != com.aliyun.svideosdk.common.struct.project.Effect.Type.audio_fade) {
                        audioTrackClipById.getEffects().remove(effect3);
                        return;
                    } else if (((com.aliyun.svideosdk.common.struct.project.AudioFade) effect3).isFadeIn == ((com.aliyun.svideosdk.common.struct.project.AudioFade) effect).isFadeIn) {
                        audioTrackClipById.getEffects().remove(effect3);
                        return;
                    }
                }
            }
        }
    }

    public void removePasterTrack(int i) {
        for (com.aliyun.svideosdk.common.struct.project.PasterTrack pasterTrack : getTimeline().getPasterTracks()) {
            if (pasterTrack.getId() == i) {
                getTimeline().getPasterTracks().remove(pasterTrack);
                return;
            }
        }
    }

    public void removeTimeFilter(int i) {
        for (com.aliyun.svideosdk.common.struct.project.EffectTrack effectTrack : this.mTimeline.getEffectTracks()) {
            if (effectTrack.getId() == i) {
                this.mTimeline.getEffectTracks().remove(effectTrack);
            }
        }
    }

    public void removeVideoTrackClip(int i) {
        for (com.aliyun.svideosdk.common.struct.project.VideoTrack videoTrack : getTimeline().getVideoTracks()) {
            for (com.aliyun.svideosdk.common.struct.project.VideoTrackClip videoTrackClip : videoTrack.getVideoTrackClips()) {
                if (videoTrackClip.getClipId() == i) {
                    videoTrack.getVideoTrackClips().remove(videoTrackClip);
                    return;
                }
            }
        }
    }

    public void setCanvasTrack(com.aliyun.svideosdk.common.struct.project.PaintTrack paintTrack) {
        removeCanvasTrack();
        if (paintTrack != null) {
            getTimeline().getGlobalTracks().add(paintTrack);
        }
    }

    public void setColorEffect(com.aliyun.svideosdk.common.struct.project.Filter filter) {
        clearEffectTrack(com.aliyun.svideosdk.common.struct.project.EffectTrack.Type.filter);
        if (filter != null) {
            this.mTimeline.getEffectTracks().add(filter);
        }
    }

    public void setCover(com.aliyun.svideosdk.common.struct.project.Source source) {
        this.mCover = source;
    }

    public void setCreationTime(java.lang.String str) {
        this.mCreationTime = str;
    }

    public void setCustomCover(boolean z) {
        this.mCustomCover = z;
    }

    public void setDenoise(int i, int i2) {
        com.aliyun.svideosdk.common.struct.project.VideoTrackClip videoTrackClipById = getVideoTrackClipById(i);
        if (videoTrackClipById != null) {
            videoTrackClipById.setDenoiseWeight(i2);
            return;
        }
        com.aliyun.svideosdk.common.struct.project.AudioTrackClip audioTrackClipById = getAudioTrackClipById(i);
        if (audioTrackClipById != null) {
            audioTrackClipById.setDenoiseWeight(i2);
        }
    }

    public void setDuration(float f) {
        this.mDuration = f;
    }

    public void setLutEffect(com.aliyun.svideosdk.common.struct.project.Filter filter) {
        clearEffectTrack(com.aliyun.svideosdk.common.struct.project.EffectTrack.Type.lut_filter);
        if (filter != null) {
            this.mTimeline.getEffectTracks().add(filter);
        }
    }

    public void setMVEffect(com.aliyun.svideosdk.common.struct.project.MVFilter mVFilter) {
        clearEffectTrack(com.aliyun.svideosdk.common.struct.project.EffectTrack.Type.mv);
        if (mVFilter != null) {
            this.mTimeline.getEffectTracks().add(mVFilter);
        }
    }

    public void setModifiedTime(java.lang.String str) {
        this.mModifiedTime = str;
    }

    public void setMusicWeight(int i, int i2) {
        com.aliyun.svideosdk.common.struct.project.VideoTrackClip videoTrackClipById = getVideoTrackClipById(i);
        if (videoTrackClipById != null) {
            videoTrackClipById.setMixWeight(i2);
            return;
        }
        com.aliyun.svideosdk.common.struct.project.AudioTrackClip audioTrackClipById = getAudioTrackClipById(i);
        if (audioTrackClipById != null) {
            audioTrackClipById.setMixWeight(i2);
            return;
        }
        com.aliyun.svideosdk.common.struct.project.MVFilter mVEffect = getMVEffect();
        if (mVEffect == null || mVEffect.getId() != i) {
            return;
        }
        mVEffect.setMixWeight(i2);
    }

    public void setProjectDir(java.io.File file, java.io.File file2) {
        this.mProjectDir = file;
        this.mProjectFile = file2;
    }

    public void setProjectId(java.lang.String str) {
        this.mProjectId = str;
    }

    public void setRequestID(java.lang.String str) {
        this.mRequestID = str;
    }

    public void setResourceSize(long j) {
        this.mResourceSize = j;
    }

    public void setRollCaptionTrack(com.aliyun.svideosdk.common.struct.project.RollCaptionTrack rollCaptionTrack) {
        clearRollCaptionTrack();
        if (rollCaptionTrack != null) {
            getTimeline().getPasterTracks().add(rollCaptionTrack);
        }
    }

    public void setTailWaterMark(com.aliyun.svideosdk.common.struct.project.TailWaterMark tailWaterMark) {
        clearGlobalTrack(com.aliyun.svideosdk.common.struct.project.GlobalTrack.Type.tail_watermark);
        if (tailWaterMark != null) {
            getTimeline().getGlobalTracks().add(tailWaterMark);
        }
    }

    public void setTemplate(com.aliyun.svideosdk.common.struct.project.Source source) {
        this.mTemplate = source;
    }

    public void setTitle(java.lang.String str) {
        this.mTitle = str;
    }

    public void setVersion(int i) {
        this.mVersion = i;
    }

    public void setWaterMark(com.aliyun.svideosdk.common.struct.project.WaterMark waterMark) {
        clearGlobalTrack(com.aliyun.svideosdk.common.struct.project.GlobalTrack.Type.watermark);
        if (waterMark != null) {
            getTimeline().getGlobalTracks().add(waterMark);
        }
    }

    public void updateAnimationFilter(com.aliyun.svideosdk.common.struct.effect.EffectFilter effectFilter) {
        if (effectFilter != null) {
            for (com.aliyun.svideosdk.common.struct.project.EffectTrack effectTrack : this.mTimeline.getEffectTracks()) {
                if (effectTrack.getId() == effectFilter.getViewId() && effectTrack.getType() == com.aliyun.svideosdk.common.struct.project.EffectTrack.Type.animation_filter) {
                    ((com.aliyun.svideosdk.common.struct.project.Filter) effectTrack).setEffectConfig(effectFilter.getEffectConfig());
                }
            }
        }
    }

    public void updateFileSize() {
        java.util.ArrayList<com.aliyun.svideosdk.common.struct.project.Source> arrayList = new java.util.ArrayList();
        java.util.Iterator<com.aliyun.svideosdk.common.struct.project.VideoTrack> it = this.mTimeline.getVideoTracks().iterator();
        while (it.hasNext()) {
            for (com.aliyun.svideosdk.common.struct.project.VideoTrackClip videoTrackClip : it.next().getVideoTrackClips()) {
                if (videoTrackClip.getSource() != null && !arrayList.contains(videoTrackClip.getSource())) {
                    arrayList.add(videoTrackClip.getSource());
                }
                for (com.aliyun.svideosdk.common.struct.project.Effect effect : videoTrackClip.getEffects()) {
                    if (effect.getType() == com.aliyun.svideosdk.common.struct.project.Effect.Type.transition) {
                        com.aliyun.svideosdk.common.struct.effect.TransitionBase transitionBase = (com.aliyun.svideosdk.common.struct.effect.TransitionBase) effect;
                        if (transitionBase.mType == 5 && transitionBase.getCustomSource() != null && !arrayList.contains(transitionBase.getCustomSource())) {
                            arrayList.add(transitionBase.getCustomSource());
                        }
                    }
                }
            }
        }
        java.util.Iterator<com.aliyun.svideosdk.common.struct.project.AudioTrack> it2 = this.mTimeline.getAudioTracks().iterator();
        while (it2.hasNext()) {
            for (com.aliyun.svideosdk.common.struct.project.AudioTrackClip audioTrackClip : it2.next().getAudioTrackClips()) {
                if (audioTrackClip.getSource() != null && !arrayList.contains(audioTrackClip.getSource())) {
                    arrayList.add(audioTrackClip.getSource());
                }
            }
        }
        for (com.aliyun.svideosdk.common.struct.project.PasterTrack pasterTrack : this.mTimeline.getPasterTracks()) {
            if (pasterTrack instanceof com.aliyun.svideosdk.common.struct.project.PhotoPasterTrack) {
                com.aliyun.svideosdk.common.struct.project.PhotoPasterTrack photoPasterTrack = (com.aliyun.svideosdk.common.struct.project.PhotoPasterTrack) pasterTrack;
                if (photoPasterTrack.getSource() != null && !arrayList.contains(photoPasterTrack.getSource())) {
                    arrayList.add(photoPasterTrack.getSource());
                }
            }
            if (pasterTrack instanceof com.aliyun.svideosdk.common.struct.project.CaptionTrack) {
                com.aliyun.svideosdk.common.struct.project.CaptionTrack captionTrack = (com.aliyun.svideosdk.common.struct.project.CaptionTrack) pasterTrack;
                if (captionTrack.getFont() != null && !arrayList.contains(captionTrack.getFont())) {
                    arrayList.add(captionTrack.getFont());
                }
                if (captionTrack.getFontEffectSource() != null && !arrayList.contains(captionTrack.getFontEffectSource())) {
                    arrayList.add(captionTrack.getFontEffectSource());
                }
            }
            if (pasterTrack instanceof com.aliyun.svideosdk.common.struct.project.BubbleCaptionTrack) {
                com.aliyun.svideosdk.common.struct.project.BubbleCaptionTrack bubbleCaptionTrack = (com.aliyun.svideosdk.common.struct.project.BubbleCaptionTrack) pasterTrack;
                if (bubbleCaptionTrack.getFont() != null && !arrayList.contains(bubbleCaptionTrack.getFont())) {
                    arrayList.add(bubbleCaptionTrack.getFont());
                }
            }
            if (pasterTrack instanceof com.aliyun.svideosdk.common.struct.project.RollCaptionTrack) {
                for (com.aliyun.svideosdk.common.struct.project.RollCaptionTrackClip rollCaptionTrackClip : ((com.aliyun.svideosdk.common.struct.project.RollCaptionTrack) pasterTrack).getRollCaptionTrackClips()) {
                    if (rollCaptionTrackClip.getFont() != null && !arrayList.contains(rollCaptionTrackClip.getFont())) {
                        arrayList.add(rollCaptionTrackClip.getFont());
                    }
                }
            }
        }
        for (com.aliyun.svideosdk.common.struct.project.GlobalTrack globalTrack : this.mTimeline.getGlobalTracks()) {
            if (globalTrack instanceof com.aliyun.svideosdk.common.struct.project.WaterMark) {
                com.aliyun.svideosdk.common.struct.project.WaterMark waterMark = (com.aliyun.svideosdk.common.struct.project.WaterMark) globalTrack;
                if (waterMark.getSource() != null && !arrayList.contains(waterMark.getSource())) {
                    arrayList.add(waterMark.getSource());
                }
            }
            if (globalTrack instanceof com.aliyun.svideosdk.common.struct.project.PaintTrack) {
                com.aliyun.svideosdk.common.struct.project.PaintTrack paintTrack = (com.aliyun.svideosdk.common.struct.project.PaintTrack) globalTrack;
                if (paintTrack.getSource() != null && !arrayList.contains(paintTrack.getSource())) {
                    arrayList.add(paintTrack.getSource());
                }
            }
        }
        for (com.aliyun.svideosdk.common.struct.project.EffectTrack effectTrack : this.mTimeline.getEffectTracks()) {
            if (effectTrack instanceof com.aliyun.svideosdk.common.struct.project.MVFilter) {
                com.aliyun.svideosdk.common.struct.project.MVFilter mVFilter = (com.aliyun.svideosdk.common.struct.project.MVFilter) effectTrack;
                if (mVFilter.getSource() != null && !arrayList.contains(mVFilter.getSource())) {
                    arrayList.add(mVFilter.getSource());
                }
            }
            if (effectTrack instanceof com.aliyun.svideosdk.common.struct.project.Filter) {
                com.aliyun.svideosdk.common.struct.project.Filter filter = (com.aliyun.svideosdk.common.struct.project.Filter) effectTrack;
                if (filter.getSource() != null && !arrayList.contains(filter.getSource())) {
                    arrayList.add(filter.getSource());
                }
            }
        }
        if (getCover() != null && !arrayList.contains(getCover())) {
            arrayList.add(getCover());
        }
        long j = 0;
        for (com.aliyun.svideosdk.common.struct.project.Source source : arrayList) {
            if (!com.aliyun.common.utils.StringUtils.isEmpty(source.getPath())) {
                j += getFileSize(new java.io.File(source.getPath()));
            }
        }
        setResourceSize(j / 1024);
    }

    public void updateTransition(int i, com.aliyun.svideosdk.common.struct.effect.TransitionBase transitionBase) {
        for (com.aliyun.svideosdk.common.struct.project.VideoTrackClip videoTrackClip : getTimeline().getPrimaryTrack().getVideoTrackClips()) {
            if (videoTrackClip.getClipId() == i) {
                com.aliyun.svideosdk.common.struct.effect.TransitionBase transition = videoTrackClip.getTransition();
                if (transition != null) {
                    transition.setEffectConfig(transitionBase.getEffectConfig());
                    return;
                }
                return;
            }
        }
    }
}
