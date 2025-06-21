package com.aliyun.svideosdk.common.struct.project;

/* loaded from: classes12.dex */
public class ProjectVersionUtil {
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0176  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x01ae A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static java.util.List<com.aliyun.svideosdk.common.struct.effect.ActionBase> readAction(org.json.JSONArray jSONArray) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        if (jSONArray != null && jSONArray.length() > 0) {
            for (int i = 0; i < jSONArray.length(); i++) {
                org.json.JSONObject optJSONObject = jSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    com.aliyun.svideosdk.common.struct.effect.ActionFade actionFade = null;
                    switch (optJSONObject.optInt("mType")) {
                        case 0:
                            com.aliyun.svideosdk.common.struct.effect.ActionFade actionFade2 = new com.aliyun.svideosdk.common.struct.effect.ActionFade();
                            actionFade2.setFromAlpha((float) optJSONObject.optDouble("mFromAlpha"));
                            actionFade2.setToAlpha((float) optJSONObject.optDouble("mToAlpha"));
                            actionFade = actionFade2;
                            if (actionFade == null) {
                                actionFade.setTargetId(optJSONObject.optInt("mTargetId"));
                                actionFade.setStartTime(optJSONObject.optInt("mStartTime"));
                                actionFade.setDuration(optJSONObject.optInt("mDuration"));
                                actionFade.setIsStream(optJSONObject.optBoolean("mIsStream"));
                                java.lang.String optString = optJSONObject.optString("mAnimationConfig");
                                if (!com.aliyun.common.utils.StringUtils.isEmpty(optString)) {
                                    actionFade.setAnimationConfig(optString);
                                }
                                arrayList.add(actionFade);
                                break;
                            } else {
                                break;
                            }
                        case 1:
                            com.aliyun.svideosdk.common.struct.effect.ActionScale actionScale = new com.aliyun.svideosdk.common.struct.effect.ActionScale();
                            actionScale.setFromScale((float) optJSONObject.optDouble("mFromScale"));
                            actionScale.setToScale((float) optJSONObject.optDouble("mToScale"));
                            actionScale.setScaleAnchorEnable(optJSONObject.optBoolean("mScaleAnchorEnable"));
                            actionScale.setScaleAnchorBaseScale((float) optJSONObject.optDouble("mScaleAnchorBaseScale"));
                            actionScale.setScaleAnchorX((float) optJSONObject.optDouble("mScaleAnchorX"));
                            actionScale.setScaleAnchorY((float) optJSONObject.optDouble("mScaleAnchorY"));
                            actionFade = actionScale;
                            if (actionFade == null) {
                            }
                            break;
                        case 2:
                            com.aliyun.svideosdk.common.struct.effect.ActionTranslate actionTranslate = new com.aliyun.svideosdk.common.struct.effect.ActionTranslate();
                            actionTranslate.setFromPointX((float) optJSONObject.optDouble("mFromPointX"));
                            actionTranslate.setFromPointY((float) optJSONObject.optDouble("mFromPointY"));
                            actionTranslate.setToPointX((float) optJSONObject.optDouble("mToPointX"));
                            actionTranslate.setToPointY((float) optJSONObject.optDouble("mToPointY"));
                            actionFade = actionTranslate;
                            if (actionFade == null) {
                            }
                            break;
                        case 3:
                            com.aliyun.svideosdk.common.struct.effect.ActionRotate actionRotate = new com.aliyun.svideosdk.common.struct.effect.ActionRotate();
                            actionRotate.setClockwise(optJSONObject.optBoolean("mClockwise"));
                            actionRotate.setCenterCoordinateSys(optJSONObject.optInt("mCenterCoordinateSys"));
                            actionRotate.setCenterX((float) optJSONObject.optDouble("mCenterX"));
                            actionRotate.setCenterY((float) optJSONObject.optDouble("mCenterY"));
                            actionRotate.setRepeat(optJSONObject.optBoolean("mRepeat"));
                            actionRotate.setDurationPerCircle((long) optJSONObject.optDouble("mDurationPerCircle"));
                            actionFade = actionRotate;
                            if (actionFade == null) {
                            }
                            break;
                        case 4:
                            com.aliyun.svideosdk.common.struct.effect.ActionRotateBy actionRotateBy = new com.aliyun.svideosdk.common.struct.effect.ActionRotateBy();
                            actionRotateBy.setCenterCoordinateSys(optJSONObject.optInt("mCenterCoordinateSys"));
                            actionRotateBy.setCenterX((float) optJSONObject.optDouble("mCenterX"));
                            actionRotateBy.setCenterY((float) optJSONObject.optDouble("mCenterY"));
                            actionRotateBy.setFromDegree((float) optJSONObject.optDouble("mFromDegree"));
                            actionRotateBy.setRotateDegree((float) optJSONObject.optDouble("mRotateDegree"));
                            actionFade = actionRotateBy;
                            if (actionFade == null) {
                            }
                            break;
                        case 5:
                            com.aliyun.svideosdk.common.struct.effect.ActionRotateTo actionRotateTo = new com.aliyun.svideosdk.common.struct.effect.ActionRotateTo();
                            actionRotateTo.setCenterCoordinateSys(optJSONObject.optInt("mCenterCoordinateSys"));
                            actionRotateTo.setCenterX((float) optJSONObject.optDouble("mCenterX"));
                            actionRotateTo.setCenterY((float) optJSONObject.optDouble("mCenterY"));
                            actionRotateTo.setFromDegree((float) optJSONObject.optDouble("mFromDegree"));
                            actionRotateTo.setRotateToDegree((float) optJSONObject.optDouble("mRotateToDegree"));
                            actionFade = actionRotateTo;
                            if (actionFade == null) {
                            }
                            break;
                        case 6:
                            com.aliyun.svideosdk.common.struct.effect.ActionWipe actionWipe = new com.aliyun.svideosdk.common.struct.effect.ActionWipe();
                            actionWipe.setDirection(optJSONObject.optInt("mDirection"));
                            actionWipe.setWipeMode(optJSONObject.optInt("mWipeMode"));
                            actionFade = actionWipe;
                            if (actionFade == null) {
                            }
                            break;
                        case 7:
                            optJSONObject.optString("VertexShader");
                            optJSONObject.optString("FragmentShader");
                            throw null;
                        default:
                            if (actionFade == null) {
                            }
                            break;
                    }
                }
            }
        }
        return arrayList;
    }

    private static java.util.List<com.aliyun.svideosdk.common.struct.project.AudioTrackClip> readAudio(org.json.JSONArray jSONArray, com.aliyun.svideosdk.common.struct.project.AudioTrackClip.Type type) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        if (jSONArray != null && jSONArray.length() > 0) {
            for (int i = 0; i < jSONArray.length(); i++) {
                org.json.JSONObject optJSONObject = jSONArray.optJSONObject(i);
                com.aliyun.svideosdk.common.struct.project.AudioTrackClip audioTrackClip = new com.aliyun.svideosdk.common.struct.project.AudioTrackClip();
                audioTrackClip.setType(type);
                audioTrackClip.setSource(new com.aliyun.svideosdk.common.struct.project.Source(optJSONObject.optString(com.aliyun.svideo.crop.bean.AlivcCropInputParam.INTENT_KEY_PATH)));
                audioTrackClip.setIn(optJSONObject.optLong("mStreamStartTime") / 1000000.0f);
                audioTrackClip.setOut(audioTrackClip.getIn() + (optJSONObject.optLong("mStreamDuration") / 1000000.0f));
                audioTrackClip.setTimelineIn(optJSONObject.optLong("mStartTime") / 1000000.0f);
                audioTrackClip.setTimelineOut(optJSONObject.optLong("mStreamDuration") / 1000000.0f);
                audioTrackClip.setMixWeight(optJSONObject.optInt("mWeight") * 10);
                audioTrackClip.setDenoiseWeight((int) optJSONObject.optDouble("mDenoiseWeight"));
                audioTrackClip.getEffects().addAll(readAudioEffect(optJSONObject.optJSONArray("mAudioEffects")));
                audioTrackClip.getEffects().addAll(readAudioEffectFade(optJSONObject.optJSONArray("mAudioFades")));
                arrayList.add(audioTrackClip);
            }
        }
        return arrayList;
    }

    private static java.util.List<com.aliyun.svideosdk.common.struct.project.Effect> readAudioEffect(org.json.JSONArray jSONArray) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        if (jSONArray != null && jSONArray.length() > 0) {
            for (int i = 0; i < jSONArray.length(); i++) {
                org.json.JSONObject optJSONObject = jSONArray.optJSONObject(i);
                com.aliyun.svideosdk.common.struct.project.AudioEffect audioEffect = new com.aliyun.svideosdk.common.struct.project.AudioEffect();
                audioEffect.mEffectType = com.aliyun.svideosdk.editor.AudioEffectType.values()[optJSONObject.optInt("mType")];
                audioEffect.mEffectParam = optJSONObject.optInt("mEffectParam");
                arrayList.add(audioEffect);
            }
        }
        return arrayList;
    }

    private static java.util.List<com.aliyun.svideosdk.common.struct.project.Effect> readAudioEffectFade(org.json.JSONArray jSONArray) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        if (jSONArray != null && jSONArray.length() > 0) {
            for (int i = 0; i < jSONArray.length(); i++) {
                org.json.JSONObject optJSONObject = jSONArray.optJSONObject(i);
                arrayList.add(new com.aliyun.svideosdk.common.struct.project.AudioFade(optJSONObject.optInt("shapeType"), optJSONObject.optLong("duration"), optJSONObject.optBoolean("isFadeIn")));
            }
        }
        return arrayList;
    }

    private static java.util.List<com.aliyun.svideosdk.common.struct.project.Effect> readBlurBackgroundEffect(org.json.JSONArray jSONArray) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        if (jSONArray != null && jSONArray.length() > 0) {
            for (int i = 0; i < jSONArray.length(); i++) {
                org.json.JSONObject optJSONObject = jSONArray.optJSONObject(i);
                arrayList.add(new com.aliyun.svideosdk.common.struct.effect.BlurBackground(0, 0, optJSONObject.optLong("mStartTimeMills"), optJSONObject.optLong("mDurationMills"), optJSONObject.optInt("mBlurRadius")));
            }
        }
        return arrayList;
    }

    private static java.util.List<com.aliyun.svideosdk.common.struct.project.Effect> readDisplayModeEffect(org.json.JSONArray jSONArray) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        if (jSONArray != null && jSONArray.length() > 0) {
            for (int i = 0; i < jSONArray.length(); i++) {
                org.json.JSONObject optJSONObject = jSONArray.optJSONObject(i);
                arrayList.add(new com.aliyun.svideosdk.common.struct.project.RunningDisplayMode(0, 0, optJSONObject.optLong("mStartTimeMills"), optJSONObject.optLong("mDurationMills"), optJSONObject.optInt("mDisplayMode")));
            }
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v10, types: [com.aliyun.svideosdk.common.struct.project.PhotoPasterTrack, com.aliyun.svideosdk.common.struct.project.SubTitleTrack] */
    /* JADX WARN: Type inference failed for: r11v77 */
    /* JADX WARN: Type inference failed for: r11v78 */
    public static com.aliyun.svideosdk.common.struct.project.AliyunEditorProject readProject(java.io.File file, org.json.JSONObject jSONObject) {
        java.lang.String str;
        java.lang.String str2;
        com.aliyun.svideosdk.common.struct.project.GifPasterTrack gifPasterTrack;
        com.aliyun.svideosdk.editor.TimeEffectType timeEffectType;
        org.json.JSONArray jSONArray;
        java.lang.String str3;
        try {
            com.aliyun.svideosdk.common.struct.project.AliyunEditorProject aliyunEditorProject = new com.aliyun.svideosdk.common.struct.project.AliyunEditorProject();
            aliyunEditorProject.getConfig().setGop(jSONObject.optInt("mGop"));
            aliyunEditorProject.getConfig().setVideoQuality(jSONObject.optInt(com.aliyun.svideo.editor.bean.AlivcEditInputParam.INTENT_KEY_QUALITY));
            aliyunEditorProject.getConfig().setBitrate(jSONObject.optInt("mBitrate"));
            aliyunEditorProject.getConfig().setFps(jSONObject.optInt("mFps"));
            aliyunEditorProject.getConfig().setCrf(jSONObject.optInt(com.aliyun.svideo.editor.bean.AlivcEditInputParam.INTETN_KEY_CRF));
            aliyunEditorProject.getConfig().setVideoCodec(jSONObject.optInt(com.aliyun.svideo.editor.bean.AlivcEditInputParam.INTENT_KEY_CODEC));
            aliyunEditorProject.getConfig().setScale((float) jSONObject.optDouble(com.aliyun.svideo.editor.bean.AlivcEditInputParam.INTETN_KEY_SCANLE_RATE));
            aliyunEditorProject.getConfig().setOutputWidth(jSONObject.optInt("mOutputWidth"));
            aliyunEditorProject.getConfig().setOutputHeight(jSONObject.optInt("mOutputHeight"));
            aliyunEditorProject.getConfig().setMute(jSONObject.optBoolean("isSilence"));
            aliyunEditorProject.getConfig().setVolume(jSONObject.optInt("mPrimaryVolume"));
            aliyunEditorProject.getConfig().setBackgroundColor(jSONObject.optInt("mFillBackgroundColor"));
            java.util.List<com.aliyun.svideosdk.common.struct.effect.ActionBase> readAction = readAction(jSONObject.optJSONArray("mActions"));
            org.json.JSONArray optJSONArray = jSONObject.optJSONArray("mTrackList");
            java.lang.String str4 = "mDuration";
            if (optJSONArray != null && optJSONArray.length() > 0) {
                int i = 0;
                while (i < optJSONArray.length()) {
                    org.json.JSONArray optJSONArray2 = optJSONArray.optJSONObject(i).optJSONArray("mClipList");
                    if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                        int i2 = 0;
                        while (i2 < optJSONArray2.length()) {
                            org.json.JSONObject optJSONObject = optJSONArray2.optJSONObject(i2);
                            com.aliyun.svideosdk.common.struct.project.MainVideoTrackClip mainVideoTrackClip = new com.aliyun.svideosdk.common.struct.project.MainVideoTrackClip();
                            org.json.JSONArray jSONArray2 = optJSONArray2;
                            boolean equals = "ANY_VIDEO_TYPE".equals(optJSONObject.optString("mediaType"));
                            java.lang.String str5 = str4;
                            mainVideoTrackClip.setIn(optJSONObject.optLong(com.umeng.analytics.AnalyticsConfig.RTD_START_TIME) / 1000.0f);
                            mainVideoTrackClip.setOut(optJSONObject.optLong(equals ? "endTime" : str5) / 1000.0f);
                            mainVideoTrackClip.setDuration(equals ? mainVideoTrackClip.getOut() - mainVideoTrackClip.getIn() : 2.1474836E9f);
                            mainVideoTrackClip.setMixWeight(optJSONObject.optInt("mMusicWeight") * 10);
                            mainVideoTrackClip.setDenoiseWeight((int) optJSONObject.optDouble("denoiseWeight"));
                            mainVideoTrackClip.setType(!equals ? 1 : 0);
                            mainVideoTrackClip.setSource(new com.aliyun.svideosdk.common.struct.project.Source(optJSONObject.optString("src")));
                            mainVideoTrackClip.setRotation(optJSONObject.optInt("rotation"));
                            mainVideoTrackClip.setDisplayMode(optJSONObject.optInt("mDisplayMode"));
                            mainVideoTrackClip.setBrightness((float) optJSONObject.optDouble("mBrightness"));
                            mainVideoTrackClip.setContrast((float) optJSONObject.optDouble("mContrast"));
                            mainVideoTrackClip.setVignette((float) optJSONObject.optDouble("mVignette"));
                            mainVideoTrackClip.setSaturation((float) optJSONObject.optDouble("mSaturation"));
                            mainVideoTrackClip.setSharpness((float) optJSONObject.optDouble("mSharpness"));
                            com.aliyun.svideosdk.common.struct.effect.TransitionBase readTransition = readTransition(optJSONObject.optJSONObject("mTransition"));
                            if (readTransition != null) {
                                mainVideoTrackClip.getEffects().add(readTransition);
                            }
                            mainVideoTrackClip.getEffects().addAll(readDisplayModeEffect(optJSONObject.optJSONArray("mRunningDisplayModes")));
                            mainVideoTrackClip.getEffects().addAll(readBlurBackgroundEffect(optJSONObject.optJSONArray("mBlurBackgrounds")));
                            mainVideoTrackClip.getEffects().addAll(readAudioEffect(optJSONObject.optJSONArray("mAudioEffects")));
                            mainVideoTrackClip.getEffects().addAll(readAudioEffectFade(optJSONObject.optJSONArray("mAudioFades")));
                            int optInt = optJSONObject.optInt("mId");
                            for (com.aliyun.svideosdk.common.struct.effect.ActionBase actionBase : readAction) {
                                if (actionBase.getTargetId() == optInt) {
                                    mainVideoTrackClip.getActions().add(actionBase);
                                }
                            }
                            aliyunEditorProject.getTimeline().getPrimaryTrack().getVideoTrackClips().add(mainVideoTrackClip);
                            i2++;
                            optJSONArray2 = jSONArray2;
                            str4 = str5;
                        }
                    }
                    i++;
                    str4 = str4;
                }
            }
            java.lang.String str6 = str4;
            org.json.JSONObject optJSONObject2 = jSONObject.optJSONObject("waterMark");
            java.lang.String str7 = "uri";
            java.lang.String str8 = "height";
            if (optJSONObject2 != null) {
                com.aliyun.svideosdk.common.struct.project.WaterMark waterMark = new com.aliyun.svideosdk.common.struct.project.WaterMark();
                waterMark.setSource(new com.aliyun.svideosdk.common.struct.project.Source(optJSONObject2.optString("uri")));
                waterMark.setWidth((float) optJSONObject2.optDouble("width"));
                waterMark.setHeight((float) optJSONObject2.optDouble("height"));
                waterMark.setX((float) optJSONObject2.optDouble("xCoord"));
                waterMark.setY((float) optJSONObject2.optDouble("yCoord"));
                waterMark.getActions().addAll(readAction(optJSONObject2.optJSONArray("mActions")));
                aliyunEditorProject.getTimeline().getGlobalTracks().add(waterMark);
            }
            org.json.JSONObject optJSONObject3 = jSONObject.optJSONObject("tailWaterMark");
            if (optJSONObject3 != null) {
                com.aliyun.svideosdk.common.struct.project.TailWaterMark tailWaterMark = new com.aliyun.svideosdk.common.struct.project.TailWaterMark();
                tailWaterMark.setSource(new com.aliyun.svideosdk.common.struct.project.Source(optJSONObject3.optString("mImgPath")));
                tailWaterMark.setWidth((float) optJSONObject3.optDouble("mSizeX"));
                tailWaterMark.setHeight((float) optJSONObject3.optDouble("mPosX"));
                tailWaterMark.setX((float) optJSONObject3.optDouble("mPosX"));
                tailWaterMark.setY((float) optJSONObject3.optDouble("mPosY"));
                str = str6;
                tailWaterMark.setDuration(optJSONObject3.optLong(str));
                tailWaterMark.getActions().addAll(readAction(optJSONObject3.optJSONArray("mActions")));
                aliyunEditorProject.getTimeline().getGlobalTracks().add(tailWaterMark);
            } else {
                str = str6;
            }
            org.json.JSONObject optJSONObject4 = jSONObject.optJSONObject("canvasInfo");
            if (optJSONObject4 != null) {
                com.aliyun.svideosdk.common.struct.project.PaintTrack paintTrack = new com.aliyun.svideosdk.common.struct.project.PaintTrack();
                paintTrack.setSource(new com.aliyun.svideosdk.common.struct.project.Source(jSONObject.optString("canvasPath")));
                paintTrack.setCanvasInfo((com.aliyun.svideosdk.common.struct.CanvasInfo) new com.google.gson.Gson().fromJson(optJSONObject4.toString(), com.aliyun.svideosdk.common.struct.CanvasInfo.class));
                paintTrack.setTimelineIn(0.0f);
                paintTrack.setTimelineOut(2.1474836E9f);
                aliyunEditorProject.getTimeline().getGlobalTracks().add(paintTrack);
            }
            java.lang.String optString = jSONObject.optString("mVideoMV");
            if (!com.aliyun.common.utils.StringUtils.isEmpty(optString)) {
                com.aliyun.svideosdk.common.struct.project.MVFilter mVFilter = new com.aliyun.svideosdk.common.struct.project.MVFilter();
                mVFilter.setSource(new com.aliyun.svideosdk.common.struct.project.Source(optString));
                mVFilter.setTimelineIn(0.0f);
                mVFilter.setTimelineOut(2.1474836E9f);
                mVFilter.setMute(jSONObject.optBoolean("mNeedClearMvAudio"));
                mVFilter.setMixWeight(jSONObject.optInt("mMvAudioWeight"));
                aliyunEditorProject.getTimeline().getEffectTracks().add(mVFilter);
            }
            org.json.JSONObject optJSONObject5 = jSONObject.optJSONObject("mColorFilter");
            java.lang.String str9 = "mResPath";
            if (optJSONObject5 != null) {
                com.aliyun.svideosdk.common.struct.project.Filter filter = new com.aliyun.svideosdk.common.struct.project.Filter(new com.aliyun.svideosdk.common.struct.project.Source(optJSONObject5.optString("mResPath")));
                filter.setType(com.aliyun.svideosdk.common.struct.project.EffectTrack.Type.filter);
                filter.setTimelineIn(optJSONObject5.optInt("mStartTime") / 1000.0f);
                filter.setTimelineOut(filter.getTimelineIn() + (optJSONObject5.optInt(str) / 1000.0f));
                aliyunEditorProject.getTimeline().getEffectTracks().add(filter);
            }
            org.json.JSONArray optJSONArray3 = jSONObject.optJSONArray("mAnimationFilters");
            java.util.ArrayList arrayList = new java.util.ArrayList();
            if (optJSONArray3 != null && optJSONArray3.length() > 0) {
                int i3 = 0;
                while (i3 < optJSONArray3.length()) {
                    org.json.JSONObject optJSONObject6 = optJSONArray3.optJSONObject(i3);
                    org.json.JSONArray jSONArray3 = optJSONArray3;
                    com.aliyun.svideosdk.common.struct.project.Filter filter2 = new com.aliyun.svideosdk.common.struct.project.Filter(optJSONObject6.optString(str9));
                    filter2.setType(com.aliyun.svideosdk.common.struct.project.EffectTrack.Type.animation_filter);
                    filter2.setTimelineIn(optJSONObject6.optInt("mStartTime") / 1000.0f);
                    java.lang.String str10 = str9;
                    filter2.setTimelineOut(filter2.getTimelineIn() + (optJSONObject6.optInt(str) / 1000.0f));
                    boolean optBoolean = optJSONObject6.optBoolean("mInvert");
                    org.json.JSONObject optJSONObject7 = optJSONObject6.optJSONObject("mEffectConfig");
                    if (optJSONObject7 != null) {
                        str3 = str7;
                        filter2.setEffectConfig((com.aliyun.svideosdk.common.struct.effect.EffectConfig) new com.google.gson.Gson().fromJson(optJSONObject7.toString(), com.aliyun.svideosdk.common.struct.effect.EffectConfig.class));
                    } else {
                        str3 = str7;
                    }
                    if (optBoolean) {
                        arrayList.add(filter2);
                    } else {
                        aliyunEditorProject.getTimeline().getEffectTracks().add(filter2);
                    }
                    i3++;
                    optJSONArray3 = jSONArray3;
                    str9 = str10;
                    str7 = str3;
                }
            }
            java.lang.String str11 = str7;
            org.json.JSONArray optJSONArray4 = jSONObject.optJSONArray("mTimeFilters");
            if (optJSONArray4 != null && optJSONArray4.length() > 0) {
                int i4 = 0;
                while (i4 < optJSONArray4.length()) {
                    org.json.JSONObject optJSONObject8 = optJSONArray4.optJSONObject(i4);
                    com.aliyun.svideosdk.common.struct.project.TimeFilter timeFilter = new com.aliyun.svideosdk.common.struct.project.TimeFilter();
                    int optInt2 = optJSONObject8.optInt("mType");
                    if (optInt2 == com.aliyun.svideosdk.editor.TimeEffectType.TIME_EFFECT_TYPE_NONE.ordinal()) {
                        jSONArray = optJSONArray4;
                    } else {
                        if (optInt2 == 1) {
                            timeEffectType = com.aliyun.svideosdk.editor.TimeEffectType.TIME_EFFECT_TYPE_RATE;
                        } else if (optInt2 != 2) {
                            if (optInt2 == 3) {
                                timeEffectType = com.aliyun.svideosdk.editor.TimeEffectType.TIME_EFFECT_TYPE_INVERT;
                            }
                            if (optInt2 != 1 && optInt2 != 2) {
                                jSONArray = optJSONArray4;
                                aliyunEditorProject.getTimeline().getEffectTracks().add(timeFilter);
                            }
                            jSONArray = optJSONArray4;
                            timeFilter.setStartTime(optJSONObject8.optLong("mStartTime"));
                            timeFilter.setDuration(optJSONObject8.optLong(str));
                            timeFilter.setParam((float) optJSONObject8.optDouble("mParam"));
                            timeFilter.setNeedOriginDuration(optJSONObject8.optBoolean("mIsNeedOriginDuration"));
                            aliyunEditorProject.getTimeline().getEffectTracks().add(timeFilter);
                        } else {
                            timeEffectType = com.aliyun.svideosdk.editor.TimeEffectType.TIME_EFFECT_TYPE_REPEAT;
                        }
                        timeFilter.setTimeFilterType(timeEffectType.ordinal());
                        if (optInt2 != 1) {
                            jSONArray = optJSONArray4;
                            aliyunEditorProject.getTimeline().getEffectTracks().add(timeFilter);
                        }
                        jSONArray = optJSONArray4;
                        timeFilter.setStartTime(optJSONObject8.optLong("mStartTime"));
                        timeFilter.setDuration(optJSONObject8.optLong(str));
                        timeFilter.setParam((float) optJSONObject8.optDouble("mParam"));
                        timeFilter.setNeedOriginDuration(optJSONObject8.optBoolean("mIsNeedOriginDuration"));
                        aliyunEditorProject.getTimeline().getEffectTracks().add(timeFilter);
                    }
                    i4++;
                    optJSONArray4 = jSONArray;
                }
            }
            if (!arrayList.isEmpty()) {
                aliyunEditorProject.getTimeline().getEffectTracks().addAll(arrayList);
            }
            java.util.List<com.aliyun.svideosdk.common.struct.project.AudioTrackClip> readAudio = readAudio(jSONObject.optJSONArray("mAudioMixes"), com.aliyun.svideosdk.common.struct.project.AudioTrackClip.Type.Music);
            readAudio.addAll(readAudio(jSONObject.optJSONArray("mAudioMixes"), com.aliyun.svideosdk.common.struct.project.AudioTrackClip.Type.Dubs));
            for (com.aliyun.svideosdk.common.struct.project.AudioTrackClip audioTrackClip : readAudio) {
                com.aliyun.svideosdk.common.struct.project.AudioTrack audioTrack = new com.aliyun.svideosdk.common.struct.project.AudioTrack();
                audioTrack.getAudioTrackClips().add(audioTrackClip);
                audioTrack.setDuration(audioTrackClip.getOut() - audioTrackClip.getIn());
                aliyunEditorProject.getTimeline().getAudioTracks().add(audioTrack);
            }
            org.json.JSONArray optJSONArray5 = jSONObject.optJSONArray("mStaticImages");
            float f = 1000000.0f;
            if (optJSONArray5 != null && optJSONArray5.length() > 0) {
                for (int i5 = 0; i5 < optJSONArray5.length(); i5++) {
                    org.json.JSONObject optJSONObject9 = optJSONArray5.optJSONObject(i5);
                    com.aliyun.svideosdk.common.struct.project.PhotoPasterTrack photoPasterTrack = new com.aliyun.svideosdk.common.struct.project.PhotoPasterTrack();
                    photoPasterTrack.setSource(new com.aliyun.svideosdk.common.struct.project.Source(optJSONObject9.optString("path")));
                    photoPasterTrack.setX((float) optJSONObject9.optDouble("x"));
                    photoPasterTrack.setY((float) optJSONObject9.optDouble("y"));
                    photoPasterTrack.setWidth((float) optJSONObject9.optDouble("width"));
                    photoPasterTrack.setHeight((float) optJSONObject9.optDouble("height"));
                    photoPasterTrack.setRotation((float) optJSONObject9.optDouble("rotation"));
                    photoPasterTrack.setMirror(optJSONObject9.optBoolean("mirror"));
                    photoPasterTrack.setTimelineIn(optJSONObject9.optLong(com.anythink.expressad.foundation.d.c.bT) / 1000000.0f);
                    photoPasterTrack.setTimelineOut(optJSONObject9.optLong("end") / 1000000.0f);
                }
            }
            org.json.JSONArray optJSONArray6 = jSONObject.optJSONArray("captionList");
            if (optJSONArray6 != null && optJSONArray6.length() > 0) {
                int i6 = 0;
                while (i6 < optJSONArray5.length()) {
                    org.json.JSONObject optJSONObject10 = optJSONArray5.optJSONObject(i6);
                    com.aliyun.svideosdk.common.struct.project.CaptionTrack captionTrack = new com.aliyun.svideosdk.common.struct.project.CaptionTrack();
                    captionTrack.setTimelineIn(optJSONObject10.optLong(com.umeng.analytics.AnalyticsConfig.RTD_START_TIME) / f);
                    java.lang.String str12 = str8;
                    captionTrack.setTimelineOut(captionTrack.getTimelineIn() + (optJSONObject10.optLong("duration") / 1000000.0f));
                    captionTrack.setRotation((float) optJSONObject10.optDouble("rotation"));
                    captionTrack.setScale((float) optJSONObject10.optDouble("scale"));
                    captionTrack.setText(optJSONObject10.optString("text"));
                    captionTrack.setX((float) optJSONObject10.optDouble("x"));
                    captionTrack.setY((float) optJSONObject10.optDouble("y"));
                    captionTrack.setWidth((float) optJSONObject10.optDouble("width"));
                    captionTrack.setHeight((float) optJSONObject10.optDouble(str12));
                    captionTrack.setFontSize((float) optJSONObject10.optDouble("fontSize"));
                    java.lang.String optString2 = optJSONObject10.optString("fontPath");
                    if (!com.aliyun.common.utils.StringUtils.isEmpty(optString2)) {
                        captionTrack.setFont(new com.aliyun.svideosdk.common.struct.project.Source(optString2));
                    }
                    captionTrack.setTypeface(optJSONObject10.optInt("fontTypeface"));
                    captionTrack.setTextColor(optJSONObject10.optInt("fontColor"));
                    captionTrack.setOutlineColor(optJSONObject10.optInt("outlineColor"));
                    captionTrack.setOutlineWidth((float) optJSONObject10.optDouble("outlineWidth"));
                    captionTrack.setShadowColor(optJSONObject10.optInt("shadowColor"));
                    captionTrack.setShadowOffsetX((float) optJSONObject10.optDouble("shadowOffsetX"));
                    captionTrack.setShadowOffsetY((float) optJSONObject10.optDouble("shadowOffsetY"));
                    java.lang.String optString3 = optJSONObject10.optString("fontEffectTempldate");
                    if (!com.aliyun.common.utils.StringUtils.isEmpty(optString3)) {
                        captionTrack.setFontEffectSource(new com.aliyun.svideosdk.common.struct.project.Source(optString3));
                    }
                    java.lang.String optString4 = optJSONObject10.optString("bubbleEffectTempldate");
                    if (!com.aliyun.common.utils.StringUtils.isEmpty(optString4)) {
                        captionTrack.setSource(new com.aliyun.svideosdk.common.struct.project.Source(optString4));
                    }
                    aliyunEditorProject.getTimeline().getPasterTracks().add(captionTrack);
                    i6++;
                    str8 = str12;
                    f = 1000000.0f;
                }
            }
            java.lang.String str13 = str8;
            org.json.JSONArray optJSONArray7 = jSONObject.optJSONArray("mRollCaptionDescriptorList");
            if (optJSONArray7 != null && optJSONArray7.length() > 0) {
                com.aliyun.svideosdk.common.struct.project.RollCaptionTrack rollCaptionTrack = new com.aliyun.svideosdk.common.struct.project.RollCaptionTrack();
                for (int i7 = 0; i7 < optJSONArray7.length(); i7++) {
                    org.json.JSONObject optJSONObject11 = optJSONArray7.optJSONObject(i7);
                    com.aliyun.svideosdk.common.struct.project.RollCaptionTrackClip rollCaptionTrackClip = new com.aliyun.svideosdk.common.struct.project.RollCaptionTrackClip();
                    rollCaptionTrackClip.setText(optJSONObject11.optString("mCaptionText"));
                    rollCaptionTrackClip.setTimelineIn(optJSONObject11.optLong("mStartTs") / 1000.0f);
                    rollCaptionTrackClip.setTextColor(optJSONObject11.optInt("mTextColor"));
                    rollCaptionTrackClip.setOutlineColor(optJSONObject11.optInt("mTextStrokeColor"));
                    java.lang.String optString5 = optJSONObject11.optString("mFont");
                    if (!com.aliyun.common.utils.StringUtils.isEmpty(optString5)) {
                        rollCaptionTrackClip.setFont(new com.aliyun.svideosdk.common.struct.project.Source(optString5));
                    }
                    rollCaptionTrack.getRollCaptionTrackClips().add(rollCaptionTrackClip);
                }
                aliyunEditorProject.getTimeline().getPasterTracks().add(rollCaptionTrack);
            }
            org.json.JSONArray optJSONArray8 = jSONObject.optJSONArray("pasterList");
            if (optJSONArray8 != null && optJSONArray8.length() > 0) {
                int i8 = 0;
                while (i8 < optJSONArray8.length()) {
                    org.json.JSONObject optJSONObject12 = optJSONArray8.optJSONObject(i8);
                    int optInt3 = optJSONObject12.optInt("type");
                    if (optInt3 == 0) {
                        str2 = str11;
                        com.aliyun.svideosdk.common.struct.project.GifPasterTrack gifPasterTrack2 = new com.aliyun.svideosdk.common.struct.project.GifPasterTrack();
                        gifPasterTrack2.setSource(new com.aliyun.svideosdk.common.struct.project.Source(optJSONObject12.optString(str2)));
                        gifPasterTrack = gifPasterTrack2;
                    } else if (optInt3 == 1 || optInt3 == 2) {
                        com.aliyun.svideosdk.common.struct.project.BubbleCaptionTrack subTitleTrack = optInt3 == 1 ? new com.aliyun.svideosdk.common.struct.project.SubTitleTrack() : new com.aliyun.svideosdk.common.struct.project.BubbleCaptionTrack();
                        subTitleTrack.setText(optJSONObject12.optString("text"));
                        subTitleTrack.setTextColor(optJSONObject12.optInt("textColor"));
                        subTitleTrack.setTextStrokeColor(optJSONObject12.optInt("textStrokeColor"));
                        subTitleTrack.setTextBackgroundColor(optJSONObject12.optInt("textLabelColor"));
                        subTitleTrack.setTextRotation((float) optJSONObject12.optDouble("textRotation"));
                        subTitleTrack.setTextMaxLines(optJSONObject12.optInt("mTextMaxLines"));
                        subTitleTrack.setTextAlignment(optJSONObject12.optInt("mTextAlignment"));
                        subTitleTrack.setTextWidth((float) optJSONObject12.optDouble("textWidth"));
                        subTitleTrack.setTextHeight((float) optJSONObject12.optDouble("textHeight"));
                        subTitleTrack.setTextPaddingX((float) optJSONObject12.optDouble("mTextPaddingX"));
                        subTitleTrack.setTextPaddingY((float) optJSONObject12.optDouble("mTextPaddingY"));
                        subTitleTrack.setTextSize((float) optJSONObject12.optDouble("mTextSize"));
                        if (optInt3 == 1) {
                            subTitleTrack.setFont(new com.aliyun.svideosdk.common.struct.project.Source(optJSONObject12.optString("font")));
                            str2 = str11;
                            gifPasterTrack = subTitleTrack;
                        } else {
                            str2 = str11;
                            subTitleTrack.setSource(new com.aliyun.svideosdk.common.struct.project.Source(optJSONObject12.optString(str2)));
                            subTitleTrack.setTextCenterX((float) optJSONObject12.optDouble("textOffsetX"));
                            subTitleTrack.setTextCenterY((float) optJSONObject12.optDouble("textOffsetY"));
                            gifPasterTrack = subTitleTrack;
                        }
                    } else {
                        str2 = str11;
                        gifPasterTrack = null;
                    }
                    if (gifPasterTrack != null) {
                        gifPasterTrack.setTimelineIn(optJSONObject12.optLong(com.anythink.expressad.foundation.d.c.bT) / 1000000.0f);
                        gifPasterTrack.setTimelineOut(optJSONObject12.optLong("end") / 1000000.0f);
                        gifPasterTrack.setMirror(optJSONObject12.optBoolean("mirror"));
                        gifPasterTrack.setRotation((float) optJSONObject12.optDouble("rotation"));
                        gifPasterTrack.setX((float) optJSONObject12.optDouble("x"));
                        gifPasterTrack.setY((float) optJSONObject12.optDouble("y"));
                        gifPasterTrack.setWidth((float) optJSONObject12.optDouble("width"));
                        gifPasterTrack.setHeight((float) optJSONObject12.optDouble(str13));
                        gifPasterTrack.getActions().addAll(readAction(optJSONObject12.optJSONArray(com.igexin.assist.sdk.AssistPushConsts.MSG_TYPE_ACTIONS)));
                        aliyunEditorProject.getTimeline().getPasterTracks().add(gifPasterTrack);
                    }
                    i8++;
                    str11 = str2;
                }
            }
            long currentTimeMillis = java.lang.System.currentTimeMillis();
            aliyunEditorProject.setTitle(file.getName());
            aliyunEditorProject.setCreationTime(com.aliyun.svideosdk.common.struct.project.AliyunEditorProject.DATE_FORMAT.format(new java.util.Date(currentTimeMillis)));
            aliyunEditorProject.setModifiedTime(aliyunEditorProject.getCreationTime());
            aliyunEditorProject.refreshTimeLine();
            aliyunEditorProject.setVersion(0);
            return aliyunEditorProject;
        } catch (java.lang.Throwable unused) {
            return null;
        }
    }

    private static com.aliyun.svideosdk.common.struct.effect.TransitionBase readTransition(org.json.JSONObject jSONObject) {
        com.aliyun.svideosdk.common.struct.effect.TransitionBase transitionBase = null;
        transitionBase = null;
        transitionBase = null;
        transitionBase = null;
        if (jSONObject != null && jSONObject.has("mType")) {
            int optInt = jSONObject.optInt("mType");
            if (optInt == 0) {
                com.aliyun.svideosdk.common.struct.effect.TransitionShutter transitionShutter = new com.aliyun.svideosdk.common.struct.effect.TransitionShutter();
                transitionShutter.setLineWidth((float) jSONObject.optDouble("mLineWidth"));
                transitionShutter.setOrientation(jSONObject.optInt("mOrientation"));
                transitionBase = transitionShutter;
            } else if (optInt == 1) {
                com.aliyun.svideosdk.common.struct.effect.TransitionTranslate transitionTranslate = new com.aliyun.svideosdk.common.struct.effect.TransitionTranslate();
                transitionTranslate.setDirection(jSONObject.optInt("mDirection"));
                transitionBase = transitionTranslate;
            } else if (optInt == 2) {
                transitionBase = new com.aliyun.svideosdk.common.struct.effect.TransitionCircle();
            } else if (optInt == 3) {
                transitionBase = new com.aliyun.svideosdk.common.struct.effect.TransitionFiveStar();
            } else if (optInt == 4) {
                transitionBase = new com.aliyun.svideosdk.common.struct.effect.TransitionFade();
            } else if (optInt == 5) {
                java.lang.String optString = jSONObject.optString("mFilePath");
                if (!com.aliyun.common.utils.StringUtils.isEmpty(optString)) {
                    com.aliyun.svideosdk.common.struct.effect.TransitionBase transitionBase2 = new com.aliyun.svideosdk.common.struct.effect.TransitionBase();
                    transitionBase2.setParamsString(jSONObject.optString("mParamsString"));
                    transitionBase2.setCustomSource(new com.aliyun.svideosdk.common.struct.project.Source(optString));
                    transitionBase = transitionBase2;
                }
            }
            if (transitionBase != null) {
                transitionBase.setOverlapDuration(jSONObject.optLong("mOverlapDuration"));
            }
        }
        return transitionBase;
    }
}
