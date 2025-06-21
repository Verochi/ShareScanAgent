package com.aliyun.svideo.editor.effects.control;

/* loaded from: classes12.dex */
public class EditorService {
    private com.aliyun.svideo.editor.effects.control.EffectInfo lastFilterInfo;
    private com.aliyun.svideo.editor.effects.control.EffectInfo lastSoundInfo;
    private com.aliyun.svideo.editor.effects.control.EffectInfo lastTimeEffectInfo;
    private java.util.Map<com.aliyun.svideo.editor.effects.control.UIEditorPage, java.lang.Integer> mMap = new java.util.HashMap();
    private android.graphics.Paint mPaint;
    private com.aliyun.svideo.editor.effects.transition.TransitionEffectCache mTransitionEffectCache;

    public void addTabEffect(com.aliyun.svideo.editor.effects.control.UIEditorPage uIEditorPage, int i) {
        this.mMap.put(uIEditorPage, java.lang.Integer.valueOf(i));
    }

    public int getEffectIndex(com.aliyun.svideo.editor.effects.control.UIEditorPage uIEditorPage) {
        if (this.mMap.containsKey(uIEditorPage)) {
            return this.mMap.get(uIEditorPage).intValue();
        }
        return 0;
    }

    public com.aliyun.svideo.editor.effects.control.EffectInfo getLastFilterInfo() {
        if (this.lastFilterInfo == null) {
            com.aliyun.svideo.editor.effects.control.EffectInfo effectInfo = new com.aliyun.svideo.editor.effects.control.EffectInfo();
            this.lastFilterInfo = effectInfo;
            effectInfo.type = com.aliyun.svideo.editor.effects.control.UIEditorPage.FILTER;
            effectInfo.setPath(null);
            this.lastFilterInfo.setSource(null);
        }
        return this.lastFilterInfo;
    }

    public com.aliyun.svideo.editor.effects.control.EffectInfo getLastSoundInfo() {
        if (this.lastSoundInfo == null) {
            com.aliyun.svideo.editor.effects.control.EffectInfo effectInfo = new com.aliyun.svideo.editor.effects.control.EffectInfo();
            this.lastSoundInfo = effectInfo;
            effectInfo.type = com.aliyun.svideo.editor.effects.control.UIEditorPage.SOUND;
        }
        return this.lastSoundInfo;
    }

    public com.aliyun.svideo.editor.effects.control.EffectInfo getLastTimeEffectInfo() {
        if (this.lastTimeEffectInfo == null) {
            com.aliyun.svideo.editor.effects.control.EffectInfo effectInfo = new com.aliyun.svideo.editor.effects.control.EffectInfo();
            this.lastTimeEffectInfo = effectInfo;
            effectInfo.type = com.aliyun.svideo.editor.effects.control.UIEditorPage.TIME;
            effectInfo.timeEffectType = com.aliyun.svideosdk.editor.TimeEffectType.TIME_EFFECT_TYPE_NONE;
            effectInfo.isMoment = true;
        }
        return this.lastTimeEffectInfo;
    }

    public android.graphics.Paint getPaint() {
        return this.mPaint;
    }

    public com.aliyun.svideo.editor.effects.transition.TransitionEffectCache getTransitionEffectCache(com.aliyun.svideosdk.editor.AliyunISourcePartManager aliyunISourcePartManager) {
        com.aliyun.svideo.editor.effects.transition.TransitionEffectCache transitionEffectCache = this.mTransitionEffectCache;
        if (transitionEffectCache == null) {
            this.mTransitionEffectCache = com.aliyun.svideo.editor.effects.transition.TransitionEffectCache.newInstance(aliyunISourcePartManager);
        } else {
            transitionEffectCache.editor();
        }
        return this.mTransitionEffectCache;
    }

    public void setLastFilterInfo(com.aliyun.svideo.editor.effects.control.EffectInfo effectInfo) {
        this.lastFilterInfo = effectInfo;
    }

    public void setLastSoundInfo(com.aliyun.svideo.editor.effects.control.EffectInfo effectInfo) {
        this.lastSoundInfo = effectInfo;
    }

    public void setLastTimeEffectInfo(com.aliyun.svideo.editor.effects.control.EffectInfo effectInfo) {
        this.lastTimeEffectInfo = effectInfo;
    }

    public void setPaint(android.graphics.Paint paint) {
        this.mPaint = paint;
    }
}
