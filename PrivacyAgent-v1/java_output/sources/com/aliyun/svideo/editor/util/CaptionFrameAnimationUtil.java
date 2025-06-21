package com.aliyun.svideo.editor.util;

/* loaded from: classes12.dex */
public class CaptionFrameAnimationUtil {
    private static final java.lang.String TAG = "CaptionFrameAnimationUt";

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:5:0x04c8  */
    /* JADX WARN: Type inference failed for: r0v11, types: [com.aliyun.svideosdk.common.struct.effect.ActionBase, com.aliyun.svideosdk.common.struct.effect.ActionSet] */
    /* JADX WARN: Type inference failed for: r0v18, types: [com.aliyun.svideosdk.common.struct.effect.ActionBase, com.aliyun.svideosdk.common.struct.effect.ActionSet] */
    /* JADX WARN: Type inference failed for: r0v5, types: [com.aliyun.svideosdk.common.struct.effect.ActionFade] */
    /* JADX WARN: Type inference failed for: r0v6, types: [com.aliyun.svideosdk.common.struct.effect.ActionWipe] */
    /* JADX WARN: Type inference failed for: r0v7, types: [com.aliyun.svideosdk.common.struct.effect.ActionScale] */
    /* JADX WARN: Type inference failed for: r5v23, types: [com.aliyun.svideosdk.common.struct.effect.ActionShader] */
    /* JADX WARN: Type inference failed for: r5v31 */
    /* JADX WARN: Type inference failed for: r5v32, types: [com.aliyun.svideosdk.common.struct.effect.ActionBase, com.aliyun.svideosdk.common.struct.effect.ActionShader] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static com.aliyun.svideosdk.common.struct.effect.ActionBase createAction(android.content.Context context, int i, long j, long j2, int i2, int i3, int i4, int i5) {
        ?? actionShader;
        com.aliyun.svideosdk.common.struct.effect.ActionFrameBase actionFrameBase;
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("createAction: pasterWidth:");
        sb.append(i4);
        sb.append("  pasterHeight:");
        sb.append(i5);
        java.lang.String valueOf = java.lang.String.valueOf(i);
        java.lang.Float valueOf2 = java.lang.Float.valueOf(1.0f);
        switch (i) {
            case 0:
            default:
                actionFrameBase = null;
                if (actionFrameBase != null) {
                    actionFrameBase.setDuration(j);
                    actionFrameBase.setStartTime(j2);
                    actionFrameBase.setResId(valueOf);
                }
                return actionFrameBase;
            case 1:
                com.aliyun.svideosdk.common.struct.effect.ActionTranslate actionTranslate = new com.aliyun.svideosdk.common.struct.effect.ActionTranslate();
                setActionFromPoint(i2, i3, i4, i5, actionTranslate);
                actionTranslate.setToPointY(1.0f);
                actionTranslate.setToPointX(actionTranslate.getFromPointX());
                actionFrameBase = actionTranslate;
                if (actionFrameBase != null) {
                }
                return actionFrameBase;
            case 2:
                com.aliyun.svideosdk.common.struct.effect.ActionTranslate actionTranslate2 = new com.aliyun.svideosdk.common.struct.effect.ActionTranslate();
                setActionFromPoint(i2, i3, i4, i5, actionTranslate2);
                actionTranslate2.setToPointY(-1.0f);
                actionTranslate2.setToPointX(actionTranslate2.getFromPointX());
                actionFrameBase = actionTranslate2;
                if (actionFrameBase != null) {
                }
                return actionFrameBase;
            case 3:
                com.aliyun.svideosdk.common.struct.effect.ActionTranslate actionTranslate3 = new com.aliyun.svideosdk.common.struct.effect.ActionTranslate();
                setActionFromPoint(i2, i3, i4, i5, actionTranslate3);
                actionTranslate3.setToPointX(-1.0f);
                actionTranslate3.setToPointY(actionTranslate3.getFromPointY());
                actionFrameBase = actionTranslate3;
                if (actionFrameBase != null) {
                }
                return actionFrameBase;
            case 4:
                com.aliyun.svideosdk.common.struct.effect.ActionTranslate actionTranslate4 = new com.aliyun.svideosdk.common.struct.effect.ActionTranslate();
                setActionFromPoint(i2, i3, i4, i5, actionTranslate4);
                actionTranslate4.setToPointX(1.0f);
                actionTranslate4.setToPointY(actionTranslate4.getFromPointY());
                actionFrameBase = actionTranslate4;
                if (actionFrameBase != null) {
                }
                return actionFrameBase;
            case 5:
                ?? actionFade = new com.aliyun.svideosdk.common.struct.effect.ActionFade();
                actionFade.setFromAlpha(1.0f);
                actionFade.setToAlpha(0.2f);
                actionFrameBase = actionFade;
                if (actionFrameBase != null) {
                }
                return actionFrameBase;
            case 6:
                ?? actionWipe = new com.aliyun.svideosdk.common.struct.effect.ActionWipe();
                actionWipe.setWipeMode(1);
                actionWipe.setDirection(2);
                actionFrameBase = actionWipe;
                if (actionFrameBase != null) {
                }
                return actionFrameBase;
            case 7:
                ?? actionScale = new com.aliyun.svideosdk.common.struct.effect.ActionScale();
                actionScale.setFromScale(1.0f);
                actionScale.setToScale(0.25f);
                actionFrameBase = actionScale;
                if (actionFrameBase != null) {
                }
                return actionFrameBase;
            case 8:
                com.aliyun.svideosdk.common.struct.effect.ActionFrameBase actionFade2 = new com.aliyun.svideosdk.common.struct.effect.ActionFade();
                java.util.ArrayList arrayList = new java.util.ArrayList();
                arrayList.add(new com.aliyun.svideosdk.common.struct.effect.Frame(0.0f, java.lang.Float.valueOf(0.0f)));
                arrayList.add(new com.aliyun.svideosdk.common.struct.effect.Frame(0.7f, valueOf2));
                actionFade2.setFrameConfig(arrayList);
                actionFade2.setScope(com.aliyun.svideosdk.common.struct.effect.ActionBase.Scope.Part);
                actionFade2.setFillBefore(true);
                actionFade2.setFillAfter(true);
                actionFrameBase = actionFade2;
                if (actionFrameBase != null) {
                }
                return actionFrameBase;
            case 9:
                com.aliyun.svideosdk.common.struct.effect.ActionSet actionSet = new com.aliyun.svideosdk.common.struct.effect.ActionSet();
                actionSet.setMode(com.aliyun.svideosdk.common.struct.effect.ActionSet.AnimationMode.Independent);
                com.aliyun.svideosdk.common.struct.effect.ActionRotateBy actionRotateBy = new com.aliyun.svideosdk.common.struct.effect.ActionRotateBy();
                actionRotateBy.setFromDegree(0.0f);
                actionRotateBy.setRotateDegree(-0.5235988f);
                actionRotateBy.setCenterX(0.0f);
                actionRotateBy.setCenterY(1.0f);
                actionRotateBy.setStartTime(j2);
                long j3 = j / 6;
                actionRotateBy.setDuration(j3);
                com.aliyun.svideosdk.common.struct.effect.ActionRotateBy actionRotateBy2 = new com.aliyun.svideosdk.common.struct.effect.ActionRotateBy();
                actionRotateBy2.setFromDegree(-0.5235988f);
                actionRotateBy2.setRotateDegree(1.0471976f);
                actionRotateBy2.setCenterX(0.0f);
                actionRotateBy2.setCenterY(1.0f);
                actionRotateBy2.setRepeatMode(com.aliyun.svideosdk.common.struct.effect.ActionBase.RepeatMode.Reverse);
                actionRotateBy2.setStartTime(j2 + j3);
                actionRotateBy2.setDuration((j * 2) / 6);
                actionSet.addAction(actionRotateBy);
                actionSet.addAction(actionRotateBy2);
                actionSet.setResId(valueOf);
                return actionSet;
            case 10:
                com.aliyun.svideosdk.common.struct.effect.ActionSet actionSet2 = new com.aliyun.svideosdk.common.struct.effect.ActionSet();
                actionSet2.setMode(com.aliyun.svideosdk.common.struct.effect.ActionSet.AnimationMode.Independent);
                com.aliyun.svideosdk.common.struct.effect.ActionRotateTo actionRotateTo = new com.aliyun.svideosdk.common.struct.effect.ActionRotateTo();
                actionRotateTo.setFromDegree(0.0f);
                actionRotateTo.setRotateToDegree(0.5235988f);
                actionRotateTo.setCenterX(0.0f);
                actionRotateTo.setCenterY(-1.0f);
                actionRotateTo.setStartTime(j2);
                long j4 = j / 6;
                actionRotateTo.setDuration(j4);
                com.aliyun.svideosdk.common.struct.effect.ActionRotateTo actionRotateTo2 = new com.aliyun.svideosdk.common.struct.effect.ActionRotateTo();
                actionRotateTo2.setFromDegree(0.5235988f);
                actionRotateTo2.setRotateToDegree(-0.5235988f);
                actionRotateTo2.setCenterX(0.0f);
                actionRotateTo2.setCenterY(-1.0f);
                actionRotateTo2.setRepeatMode(com.aliyun.svideosdk.common.struct.effect.ActionBase.RepeatMode.Reverse);
                actionRotateTo2.setStartTime(j2 + j4);
                actionRotateTo2.setDuration(j / 3);
                actionSet2.addAction(actionRotateTo);
                actionSet2.addAction(actionRotateTo2);
                actionSet2.setResId(valueOf);
                return actionSet2;
            case 11:
                ?? actionSet3 = new com.aliyun.svideosdk.common.struct.effect.ActionSet();
                actionSet3.setMode(com.aliyun.svideosdk.common.struct.effect.ActionSet.AnimationMode.Dependent);
                com.aliyun.svideosdk.common.struct.effect.ActionFade actionFade3 = new com.aliyun.svideosdk.common.struct.effect.ActionFade();
                actionFade3.setFromAlpha(0.1f);
                actionFade3.setToAlpha(1.0f);
                long j5 = j / 4;
                actionFade3.setDuration(j5);
                actionFade3.setFillBefore(true);
                actionSet3.addAction(actionFade3);
                com.aliyun.svideosdk.common.struct.effect.ActionFade actionFade4 = new com.aliyun.svideosdk.common.struct.effect.ActionFade();
                actionFade4.setFromAlpha(1.0f);
                actionFade4.setToAlpha(0.1f);
                actionFade4.setStartOffset((j * 3) / 4);
                actionFade4.setDuration(j5);
                actionSet3.addAction(actionFade4);
                com.aliyun.svideosdk.common.struct.effect.ActionRotateBy actionRotateBy3 = new com.aliyun.svideosdk.common.struct.effect.ActionRotateBy();
                actionRotateBy3.setFromDegree(0.0f);
                actionRotateBy3.setRotateDegree(6.2831855f);
                long j6 = j / 2;
                actionRotateBy3.setDuration(j6);
                actionRotateBy3.setFillBefore(true);
                actionRotateBy3.setFillAfter(true);
                actionSet3.addAction(actionRotateBy3);
                com.aliyun.svideosdk.common.struct.effect.ActionScale actionScale2 = new com.aliyun.svideosdk.common.struct.effect.ActionScale();
                actionScale2.setFromScale(0.25f);
                actionScale2.setToScale(1.0f);
                actionScale2.setDuration(j6);
                actionScale2.setFillBefore(true);
                actionScale2.setFillAfter(true);
                actionSet3.addAction(actionScale2);
                actionSet3.setResId(valueOf);
                actionFrameBase = actionSet3;
                if (actionFrameBase != null) {
                }
                return actionFrameBase;
            case 12:
                com.aliyun.svideosdk.common.struct.effect.ActionSet actionSet4 = new com.aliyun.svideosdk.common.struct.effect.ActionSet();
                actionSet4.setMode(com.aliyun.svideosdk.common.struct.effect.ActionSet.AnimationMode.Independent);
                com.aliyun.svideosdk.common.struct.effect.ActionFade actionFade5 = new com.aliyun.svideosdk.common.struct.effect.ActionFade();
                actionFade5.setFromAlpha(0.1f);
                actionFade5.setToAlpha(1.0f);
                actionFade5.setStartTime(j2);
                actionFade5.setDuration(j / 3);
                actionFade5.setFillAfter(true);
                actionSet4.addAction(actionFade5);
                com.aliyun.svideosdk.common.struct.effect.ActionRotateBy actionRotateBy4 = new com.aliyun.svideosdk.common.struct.effect.ActionRotateBy();
                actionRotateBy4.setFromDegree(0.0f);
                actionRotateBy4.setRotateDegree(6.2831855f);
                actionRotateBy4.setStartTime(j2);
                long j7 = j / 2;
                actionRotateBy4.setDuration(j7);
                actionRotateBy4.setFillAfter(true);
                actionSet4.addAction(actionRotateBy4);
                com.aliyun.svideosdk.common.struct.effect.ActionScale actionScale3 = new com.aliyun.svideosdk.common.struct.effect.ActionScale();
                actionScale3.setFromScale(0.0f);
                actionScale3.setToScale(1.0f);
                actionScale3.setStartTime(j2);
                actionScale3.setDuration(j7);
                actionScale3.setFillAfter(true);
                actionSet4.addAction(actionScale3);
                actionSet4.setResId(valueOf);
                return actionSet4;
            case 13:
                actionShader = new com.aliyun.svideosdk.common.struct.effect.ActionShader();
                actionShader.setShader(com.aliyun.svideo.editor.util.AssetUtil.readAssertResource(context, "shader/wave.vert"), com.aliyun.svideo.editor.util.AssetUtil.readAssertResource(context, "shader/wave.frag"));
                actionFrameBase = actionShader;
                if (actionFrameBase != null) {
                }
                return actionFrameBase;
            case 14:
                com.aliyun.svideosdk.common.struct.effect.ActionSet actionSet5 = new com.aliyun.svideosdk.common.struct.effect.ActionSet();
                actionSet5.setScope(com.aliyun.svideosdk.common.struct.effect.ActionBase.Scope.Part);
                actionSet5.setMode(com.aliyun.svideosdk.common.struct.effect.ActionSet.AnimationMode.Dependent);
                com.aliyun.svideosdk.common.struct.effect.ActionBase.PartParam partParam = new com.aliyun.svideosdk.common.struct.effect.ActionBase.PartParam();
                partParam.setMode(com.aliyun.svideosdk.common.struct.effect.ActionBase.PartParam.Mode.Sequence);
                partParam.setOverlayRadio(0.7f);
                actionSet5.setPartParam(partParam);
                com.aliyun.svideosdk.common.struct.effect.ActionFade actionFade6 = new com.aliyun.svideosdk.common.struct.effect.ActionFade();
                actionFade6.setFromAlpha(0.1f);
                actionFade6.setToAlpha(1.0f);
                actionFade6.setDuration(j / 4);
                actionFade6.setFillBefore(true);
                actionFade6.setFillAfter(true);
                actionSet5.addAction(actionFade6);
                com.aliyun.svideosdk.common.struct.effect.ActionRotateBy actionRotateBy5 = new com.aliyun.svideosdk.common.struct.effect.ActionRotateBy();
                actionRotateBy5.setFromDegree(0.0f);
                actionRotateBy5.setRotateDegree(6.2831855f);
                actionRotateBy5.setDuration(j / 2);
                actionRotateBy5.setFillBefore(true);
                actionRotateBy5.setRepeatMode(com.aliyun.svideosdk.common.struct.effect.ActionBase.RepeatMode.Restart);
                actionRotateBy5.setFillAfter(true);
                actionSet5.addAction(actionRotateBy5);
                com.aliyun.svideosdk.common.struct.effect.ActionTranslate actionTranslate5 = new com.aliyun.svideosdk.common.struct.effect.ActionTranslate();
                actionTranslate5.setTranslateType(com.aliyun.svideosdk.common.struct.effect.ActionTranslate.TranslateType.TranslateBy);
                actionTranslate5.setFromPointX(0.0f);
                actionTranslate5.setFromPointY(-5.0f);
                actionTranslate5.setToPointX(0.0f);
                actionTranslate5.setToPointY(0.0f);
                actionTranslate5.setDuration(j);
                actionSet5.addAction(actionTranslate5);
                actionSet5.setFillBefore(true);
                actionSet5.setDuration((j * 3) / 4);
                actionSet5.setStartTime(j2);
                actionSet5.setResId(valueOf);
                return actionSet5;
            case 15:
                com.aliyun.svideosdk.common.struct.effect.ActionScale actionScale4 = new com.aliyun.svideosdk.common.struct.effect.ActionScale();
                java.util.ArrayList arrayList2 = new java.util.ArrayList();
                arrayList2.add(new com.aliyun.svideosdk.common.struct.effect.Frame(0.0f, valueOf2));
                arrayList2.add(new com.aliyun.svideosdk.common.struct.effect.Frame(0.06f, java.lang.Float.valueOf(0.92f)));
                arrayList2.add(new com.aliyun.svideosdk.common.struct.effect.Frame(0.12f, java.lang.Float.valueOf(1.0252f)));
                arrayList2.add(new com.aliyun.svideosdk.common.struct.effect.Frame(0.18f, java.lang.Float.valueOf(1.1775f)));
                arrayList2.add(new com.aliyun.svideosdk.common.struct.effect.Frame(0.24f, java.lang.Float.valueOf(1.3116f)));
                arrayList2.add(new com.aliyun.svideosdk.common.struct.effect.Frame(0.3f, java.lang.Float.valueOf(1.4128f)));
                arrayList2.add(new com.aliyun.svideosdk.common.struct.effect.Frame(0.36f, java.lang.Float.valueOf(1.4761f)));
                arrayList2.add(new com.aliyun.svideosdk.common.struct.effect.Frame(0.42f, java.lang.Float.valueOf(1.5f)));
                arrayList2.add(new com.aliyun.svideosdk.common.struct.effect.Frame(0.48f, java.lang.Float.valueOf(1.5f)));
                arrayList2.add(new com.aliyun.svideosdk.common.struct.effect.Frame(0.54f, java.lang.Float.valueOf(1.4727f)));
                arrayList2.add(new com.aliyun.svideosdk.common.struct.effect.Frame(0.6f, java.lang.Float.valueOf(1.4089f)));
                arrayList2.add(new com.aliyun.svideosdk.common.struct.effect.Frame(0.66f, java.lang.Float.valueOf(1.3093f)));
                arrayList2.add(new com.aliyun.svideosdk.common.struct.effect.Frame(0.72f, java.lang.Float.valueOf(1.1779f)));
                arrayList2.add(new com.aliyun.svideosdk.common.struct.effect.Frame(0.78f, java.lang.Float.valueOf(1.0283f)));
                arrayList2.add(new com.aliyun.svideosdk.common.struct.effect.Frame(0.9f, java.lang.Float.valueOf(0.92f)));
                arrayList2.add(new com.aliyun.svideosdk.common.struct.effect.Frame(1.0f, valueOf2));
                actionScale4.setFrameConfig(arrayList2);
                actionScale4.setStartTime(j2);
                actionScale4.setDuration(j / 2);
                actionScale4.setRepeatCount(1);
                actionScale4.setRepeatMode(com.aliyun.svideosdk.common.struct.effect.ActionBase.RepeatMode.Restart);
                actionScale4.setResId(valueOf);
                return actionScale4;
            case 16:
                actionShader = new com.aliyun.svideosdk.common.struct.effect.ActionShader();
                actionShader.setShader(com.aliyun.svideo.editor.util.AssetUtil.readAssertResource(context, "shader/round_scan.vert"), com.aliyun.svideo.editor.util.AssetUtil.readAssertResource(context, "shader/round_scan.frag"));
                actionShader.setResId(valueOf);
                actionFrameBase = actionShader;
                if (actionFrameBase != null) {
                }
                return actionFrameBase;
            case 17:
                ?? actionSet6 = new com.aliyun.svideosdk.common.struct.effect.ActionSet();
                actionSet6.setMode(com.aliyun.svideosdk.common.struct.effect.ActionSet.AnimationMode.Dependent);
                actionSet6.setScope(com.aliyun.svideosdk.common.struct.effect.ActionBase.Scope.Part);
                com.aliyun.svideosdk.common.struct.effect.ActionBase.PartParam partParam2 = new com.aliyun.svideosdk.common.struct.effect.ActionBase.PartParam();
                partParam2.setMode(com.aliyun.svideosdk.common.struct.effect.ActionBase.PartParam.Mode.Sequence);
                partParam2.setOverlayRadio(0.6f);
                actionSet6.setPartParam(partParam2);
                com.aliyun.svideosdk.common.struct.effect.ActionTranslate actionTranslate6 = new com.aliyun.svideosdk.common.struct.effect.ActionTranslate();
                com.aliyun.svideosdk.common.struct.effect.ActionTranslate.TranslateType translateType = com.aliyun.svideosdk.common.struct.effect.ActionTranslate.TranslateType.TranslateBy;
                actionTranslate6.setTranslateType(translateType);
                actionTranslate6.setFromPointX(0.0f);
                actionTranslate6.setFromPointY(0.0f);
                actionTranslate6.setToPointX(0.0f);
                actionTranslate6.setToPointY(1.0f);
                long j8 = j / 2;
                actionTranslate6.setDuration(j8);
                actionSet6.addAction(actionTranslate6);
                com.aliyun.svideosdk.common.struct.effect.ActionTranslate actionTranslate7 = new com.aliyun.svideosdk.common.struct.effect.ActionTranslate();
                actionTranslate7.setTranslateType(translateType);
                actionTranslate7.setFromPointX(0.0f);
                actionTranslate7.setFromPointY(1.0f);
                actionTranslate7.setToPointX(0.0f);
                actionTranslate7.setToPointY(0.0f);
                actionTranslate7.setFillAfter(true);
                actionTranslate7.setStartOffset(j8);
                actionTranslate7.setDuration(j8);
                actionSet6.addAction(actionTranslate7);
                com.aliyun.svideosdk.common.struct.effect.ActionFade actionFade7 = new com.aliyun.svideosdk.common.struct.effect.ActionFade();
                actionFade7.setFromAlpha(0.0f);
                actionFade7.setToAlpha(1.0f);
                actionFade7.setDuration(j / 4);
                actionFade7.setFillBefore(true);
                actionSet6.addAction(actionFade7);
                actionSet6.setFillBefore(true);
                actionSet6.setFillAfter(true);
                actionSet6.setResId(valueOf);
                actionFrameBase = actionSet6;
                if (actionFrameBase != null) {
                }
                return actionFrameBase;
        }
    }

    private static void setActionFromPoint(int i, int i2, int i3, int i4, com.aliyun.svideosdk.common.struct.effect.ActionTranslate actionTranslate) {
        actionTranslate.setFromPointX((((i3 * 1.0f) / i) * 2.0f) - 1.0f);
        actionTranslate.setFromPointY(1.0f - (((i4 * 1.0f) / i2) * 2.0f));
    }
}
