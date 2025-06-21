package com.aliyun.svideo.editor.effects.transition;

/* loaded from: classes12.dex */
public class TransitionEffectCache {
    private static final java.lang.String TAG = "TransitionEffectCache";
    private com.aliyun.svideosdk.editor.AliyunISourcePartManager mAliyunSourcePartManager;
    private java.util.HashSet<java.lang.Integer> mCheckTool = new java.util.HashSet<>();
    private java.util.LinkedHashMap<java.lang.Integer, com.aliyun.svideo.editor.effects.control.EffectInfo> mOldTransitionCache;
    private java.util.LinkedHashMap<java.lang.Integer, com.aliyun.svideo.editor.effects.control.EffectInfo> mTransitionCache;

    private TransitionEffectCache(com.aliyun.svideosdk.editor.AliyunISourcePartManager aliyunISourcePartManager) {
        this.mAliyunSourcePartManager = aliyunISourcePartManager;
    }

    public static com.aliyun.svideo.editor.effects.transition.TransitionEffectCache newInstance(com.aliyun.svideosdk.editor.AliyunISourcePartManager aliyunISourcePartManager) {
        com.aliyun.svideo.editor.effects.transition.TransitionEffectCache transitionEffectCache = new com.aliyun.svideo.editor.effects.transition.TransitionEffectCache(aliyunISourcePartManager);
        transitionEffectCache.mTransitionCache = new java.util.LinkedHashMap<>(aliyunISourcePartManager.getMediaPartCount());
        transitionEffectCache.mOldTransitionCache = new java.util.LinkedHashMap<>(aliyunISourcePartManager.getMediaPartCount());
        java.util.List<com.aliyun.svideosdk.common.struct.common.AliyunClip> allClips = aliyunISourcePartManager.getAllClips();
        if (allClips.size() > 0) {
            for (int i = 1; i < allClips.size(); i++) {
                com.aliyun.svideosdk.common.struct.effect.TransitionBase transition = allClips.get(i).getTransition();
                if (transition != null) {
                    com.aliyun.svideo.editor.effects.control.EffectInfo effectInfo = new com.aliyun.svideo.editor.effects.control.EffectInfo();
                    int i2 = i - 1;
                    effectInfo.clipIndex = i2;
                    int i3 = transition.mType;
                    effectInfo.transitionType = i3;
                    if (i3 == 0) {
                        effectInfo.transitionType = 5;
                    } else if (i3 == 1) {
                        com.aliyun.svideosdk.common.struct.effect.TransitionTranslate transitionTranslate = (com.aliyun.svideosdk.common.struct.effect.TransitionTranslate) transition;
                        if (transitionTranslate.getDirection() == 0) {
                            effectInfo.transitionType = 3;
                        } else if (transitionTranslate.getDirection() == 1) {
                            effectInfo.transitionType = 4;
                        } else if (transitionTranslate.getDirection() == 2) {
                            effectInfo.transitionType = 1;
                        } else if (transitionTranslate.getDirection() == 3) {
                            effectInfo.transitionType = 2;
                        }
                    } else if (i3 == 2) {
                        effectInfo.transitionType = 8;
                    } else if (i3 == 3) {
                        effectInfo.transitionType = 7;
                    } else if (i3 == 4) {
                        effectInfo.transitionType = 6;
                    } else if (i3 != 5) {
                        effectInfo.transitionType = 0;
                    } else {
                        effectInfo.transitionType = 9;
                        effectInfo.setSource(transition.getCustomSource());
                    }
                    effectInfo.type = com.aliyun.svideo.editor.effects.control.UIEditorPage.TRANSITION;
                    effectInfo.transitionBase = transition;
                    transitionEffectCache.mOldTransitionCache.put(java.lang.Integer.valueOf(i2), effectInfo);
                    transitionEffectCache.mTransitionCache.put(java.lang.Integer.valueOf(i2), effectInfo);
                }
            }
        }
        return transitionEffectCache;
    }

    public java.util.List<com.aliyun.svideo.editor.effects.control.EffectInfo> checkTransitionCacheIsDelete() {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        if (this.mTransitionCache.size() != 0) {
            java.util.Iterator<java.util.Map.Entry<java.lang.Integer, com.aliyun.svideo.editor.effects.control.EffectInfo>> it = this.mTransitionCache.entrySet().iterator();
            while (it.hasNext()) {
                java.util.Map.Entry<java.lang.Integer, com.aliyun.svideo.editor.effects.control.EffectInfo> next = it.next();
                com.aliyun.svideo.editor.effects.control.EffectInfo value = next.getValue();
                if (value != null && value.getSource() != null && value.getSource().getPath() != null && !new java.io.File(value.getSource().getPath()).exists()) {
                    it.remove();
                    java.lang.StringBuilder sb = new java.lang.StringBuilder();
                    sb.append("removeTransition mTransitionCache path :");
                    sb.append(value.getSource().getPath());
                    value.setPath(null);
                    value.setSource(null);
                    value.transitionBase = new com.aliyun.svideosdk.common.struct.effect.TransitionBase();
                    arrayList.add(value);
                    this.mCheckTool.remove(next.getKey());
                }
            }
        }
        if (this.mOldTransitionCache.size() != 0) {
            java.util.Iterator<java.util.Map.Entry<java.lang.Integer, com.aliyun.svideo.editor.effects.control.EffectInfo>> it2 = this.mOldTransitionCache.entrySet().iterator();
            while (it2.hasNext()) {
                com.aliyun.svideo.editor.effects.control.EffectInfo value2 = it2.next().getValue();
                if (value2 != null && value2.getSource() != null && value2.getSource().getPath() != null && !new java.io.File(value2.getSource().getPath()).exists()) {
                    it2.remove();
                    java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
                    sb2.append("removeTransition mOldTransitionCache path :");
                    sb2.append(value2.getSource().getPath());
                    value2.setPath(null);
                    value2.setSource(null);
                    value2.transitionBase = new com.aliyun.svideosdk.common.struct.effect.TransitionBase();
                    arrayList.add(value2);
                }
            }
        }
        return arrayList;
    }

    public void commitCache() {
        this.mOldTransitionCache = new java.util.LinkedHashMap<>(this.mTransitionCache);
        this.mTransitionCache.clear();
        this.mCheckTool.clear();
    }

    public void editor() {
        java.util.LinkedHashMap<java.lang.Integer, com.aliyun.svideo.editor.effects.control.EffectInfo> linkedHashMap = this.mTransitionCache;
        if (linkedHashMap == null || linkedHashMap.size() <= 0) {
            this.mTransitionCache = new java.util.LinkedHashMap<>(this.mOldTransitionCache);
        }
    }

    public com.aliyun.svideo.editor.effects.control.EffectInfo get(int i) {
        return this.mTransitionCache.get(java.lang.Integer.valueOf(i));
    }

    public com.aliyun.svideosdk.editor.AliyunISourcePartManager getAliyunSourcePartManager() {
        return this.mAliyunSourcePartManager;
    }

    public int getCount() {
        return this.mAliyunSourcePartManager.getMediaPartCount();
    }

    public void put(int i, com.aliyun.svideo.editor.effects.control.EffectInfo effectInfo) {
        this.mTransitionCache.put(java.lang.Integer.valueOf(i), effectInfo);
        this.mCheckTool.add(java.lang.Integer.valueOf(i));
    }

    public java.util.LinkedHashMap<java.lang.Integer, com.aliyun.svideo.editor.effects.control.EffectInfo> recover() {
        java.util.LinkedHashMap<java.lang.Integer, com.aliyun.svideo.editor.effects.control.EffectInfo> linkedHashMap = new java.util.LinkedHashMap<>();
        java.util.Iterator<java.lang.Integer> it = this.mCheckTool.iterator();
        while (it.hasNext()) {
            java.lang.Integer next = it.next();
            com.aliyun.svideo.editor.effects.control.EffectInfo effectInfo = this.mOldTransitionCache.get(next);
            com.aliyun.svideo.editor.effects.control.EffectInfo effectInfo2 = this.mTransitionCache.get(next);
            if (effectInfo == null) {
                effectInfo = new com.aliyun.svideo.editor.effects.control.EffectInfo();
                effectInfo.clipIndex = effectInfo2.clipIndex;
                effectInfo.transitionType = 0;
                effectInfo.type = com.aliyun.svideo.editor.effects.control.UIEditorPage.TRANSITION;
            }
            if (!effectInfo.equals(effectInfo2)) {
                linkedHashMap.put(next, effectInfo);
            }
        }
        this.mTransitionCache.clear();
        this.mCheckTool.clear();
        return linkedHashMap;
    }
}
