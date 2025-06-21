package com.aliyun.svideo.editor.effects.control;

/* loaded from: classes12.dex */
public class EffectInfo implements java.io.Serializable {
    public com.aliyun.svideosdk.editor.AudioEffectType audioEffectType;
    public int clipIndex;
    public long endTime;

    @java.lang.Deprecated
    public java.lang.String fontPath;
    public com.aliyun.svideosdk.common.struct.project.Source fontSource;
    public int id;
    public boolean isAudioMixBar;
    public boolean isCategory;
    public boolean isLocalMusic;
    public boolean isMoment;
    public java.util.List<com.aliyun.svideo.base.Form.AspectForm> list;
    private com.aliyun.svideosdk.common.struct.project.Source mSource;
    public int mixId;
    public int musicWeight;
    public java.util.List<com.aliyun.svideo.editor.effects.control.EffectInfo> mutiEffect;
    public int soundWeight;
    public long streamEndTime;
    public long streamStartTime;
    public com.aliyun.svideosdk.editor.TimeEffectType timeEffectType;
    public float timeParam;
    public com.aliyun.svideosdk.common.struct.effect.TransitionBase transitionBase;
    public int transitionType;
    public com.aliyun.svideo.editor.effects.control.UIEditorPage type;
    public long startTime = -1;
    public boolean isUpdateTransition = false;
    public boolean needReplay = false;

    public boolean equals(@androidx.annotation.Nullable java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && (obj instanceof com.aliyun.svideo.editor.effects.control.EffectInfo)) {
            com.aliyun.svideo.editor.effects.control.EffectInfo effectInfo = (com.aliyun.svideo.editor.effects.control.EffectInfo) obj;
            int i = this.transitionType;
            if (i == effectInfo.transitionType) {
                if (i == 9) {
                    return this.mSource.equals(effectInfo.mSource);
                }
                return true;
            }
        }
        return false;
    }

    @java.lang.Deprecated
    public java.lang.String getPath() {
        com.aliyun.svideosdk.common.struct.project.Source source = this.mSource;
        if (source != null) {
            return source.getPath();
        }
        return null;
    }

    public com.aliyun.svideosdk.common.struct.project.Source getSource() {
        return this.mSource;
    }

    @java.lang.Deprecated
    public void setPath(java.lang.String str) {
        this.mSource = new com.aliyun.svideosdk.common.struct.project.Source(str);
    }

    public void setSource(com.aliyun.svideosdk.common.struct.project.Source source) {
        this.mSource = source;
    }
}
