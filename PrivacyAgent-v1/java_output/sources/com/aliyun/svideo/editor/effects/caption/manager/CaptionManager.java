package com.aliyun.svideo.editor.effects.caption.manager;

/* loaded from: classes12.dex */
public class CaptionManager {
    private static final java.lang.String TAG = "CaptionManager";

    @androidx.annotation.Nullable
    public static com.aliyun.svideosdk.editor.impl.AliyunPasterControllerCompoundCaption addCaptionWithStartTime(android.content.Context context, com.aliyun.svideosdk.editor.AliyunPasterManager aliyunPasterManager, @androidx.annotation.Nullable java.lang.String str, java.lang.String str2, long j, long j2) {
        if (aliyunPasterManager == null || j2 <= 0) {
            return null;
        }
        com.aliyun.svideosdk.editor.impl.AliyunPasterControllerCompoundCaption addCaptionWithStartTime = aliyunPasterManager.addCaptionWithStartTime(android.text.TextUtils.isEmpty(str) ? context.getString(com.aliyun.svideo.editor.R.string.alivc_editor_effect_text_default) : str, null, new com.aliyun.svideosdk.common.struct.project.Source(str2), j, j2, java.util.concurrent.TimeUnit.MILLISECONDS);
        addCaptionWithStartTime.setColor(new com.aliyun.svideosdk.common.AliyunColor(android.graphics.Color.parseColor("#FFF9FAFB")));
        if (addCaptionWithStartTime.apply() == 0) {
            return addCaptionWithStartTime;
        }
        removeCaption(aliyunPasterManager, addCaptionWithStartTime);
        return null;
    }

    public static void applyBubbleEffectTemplateChanged(com.aliyun.svideosdk.editor.impl.AliyunPasterControllerCompoundCaption aliyunPasterControllerCompoundCaption, com.aliyun.svideosdk.common.struct.project.Source source) {
        if (aliyunPasterControllerCompoundCaption != null) {
            aliyunPasterControllerCompoundCaption.setBubbleEffectTemplate(source);
            aliyunPasterControllerCompoundCaption.apply();
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("applyBubbleEffectTemplateChanged: ");
            sb.append(aliyunPasterControllerCompoundCaption.getDuration());
        }
    }

    @java.lang.Deprecated
    public static void applyBubbleEffectTemplateChanged(com.aliyun.svideosdk.editor.impl.AliyunPasterControllerCompoundCaption aliyunPasterControllerCompoundCaption, java.lang.String str) {
        applyBubbleEffectTemplateChanged(aliyunPasterControllerCompoundCaption, new com.aliyun.svideosdk.common.struct.project.Source(str));
    }

    public static void applyCaptionBorderChanged(com.aliyun.svideosdk.editor.impl.AliyunPasterControllerCompoundCaption aliyunPasterControllerCompoundCaption, float f, float[] fArr, android.graphics.PointF pointF) {
        if (aliyunPasterControllerCompoundCaption == null) {
            return;
        }
        aliyunPasterControllerCompoundCaption.setRotate(f);
        if (fArr != null && fArr.length > 0) {
            aliyunPasterControllerCompoundCaption.setScale(fArr[0]);
        }
        if (pointF != null) {
            aliyunPasterControllerCompoundCaption.setPosition(pointF);
        }
        aliyunPasterControllerCompoundCaption.apply();
    }

    public static void applyCaptionFrameAnimation(com.aliyun.svideo.editor.view.IAlivcEditView iAlivcEditView, com.aliyun.svideosdk.editor.impl.AliyunPasterControllerCompoundCaption aliyunPasterControllerCompoundCaption, com.aliyun.svideosdk.common.struct.effect.ActionBase actionBase) {
        if (aliyunPasterControllerCompoundCaption == null) {
            return;
        }
        aliyunPasterControllerCompoundCaption.setFrameAnimation(actionBase);
        aliyunPasterControllerCompoundCaption.apply();
        com.aliyun.svideosdk.editor.AliyunIEditor aliyunIEditor = iAlivcEditView.getAliyunIEditor();
        java.util.concurrent.TimeUnit timeUnit = java.util.concurrent.TimeUnit.MILLISECONDS;
        aliyunIEditor.seek(aliyunPasterControllerCompoundCaption.getStartTime(timeUnit), timeUnit);
    }

    public static void applyCaptionPostion(com.aliyun.svideosdk.editor.impl.AliyunPasterControllerCompoundCaption aliyunPasterControllerCompoundCaption, android.graphics.PointF pointF) {
        if (aliyunPasterControllerCompoundCaption == null || pointF == null) {
            return;
        }
        aliyunPasterControllerCompoundCaption.setPosition(pointF);
        aliyunPasterControllerCompoundCaption.apply();
    }

    public static void applyCaptionTextAlignmentChanged(com.aliyun.svideosdk.editor.impl.AliyunPasterControllerCompoundCaption aliyunPasterControllerCompoundCaption, int i) {
        if (aliyunPasterControllerCompoundCaption == null || i == 0) {
            return;
        }
        aliyunPasterControllerCompoundCaption.setTextAlignment(i);
        aliyunPasterControllerCompoundCaption.apply();
    }

    public static void applyCaptionTextBackgroundColorChanged(com.aliyun.svideosdk.editor.impl.AliyunPasterControllerCompoundCaption aliyunPasterControllerCompoundCaption, com.aliyun.svideosdk.common.AliyunColor aliyunColor) {
        if (aliyunPasterControllerCompoundCaption == null || aliyunColor == null) {
            return;
        }
        aliyunPasterControllerCompoundCaption.setBackgroundColor(aliyunColor);
        aliyunPasterControllerCompoundCaption.apply();
    }

    public static void applyCaptionTextBackgroundCornerRadiusChanged(com.aliyun.svideosdk.editor.impl.AliyunPasterControllerCompoundCaption aliyunPasterControllerCompoundCaption, int i) {
        if (aliyunPasterControllerCompoundCaption != null) {
            aliyunPasterControllerCompoundCaption.setBackgroundCornerRadius(i);
            aliyunPasterControllerCompoundCaption.apply();
        }
    }

    public static void applyCaptionTextChanged(com.aliyun.svideosdk.editor.impl.AliyunPasterControllerCompoundCaption aliyunPasterControllerCompoundCaption, java.lang.String str) {
        if (aliyunPasterControllerCompoundCaption == null || android.text.TextUtils.isEmpty(str)) {
            return;
        }
        aliyunPasterControllerCompoundCaption.setText(str);
        aliyunPasterControllerCompoundCaption.apply();
    }

    public static void applyCaptionTextColorChanged(com.aliyun.svideosdk.editor.impl.AliyunPasterControllerCompoundCaption aliyunPasterControllerCompoundCaption, com.aliyun.svideosdk.common.AliyunColor aliyunColor) {
        if (aliyunPasterControllerCompoundCaption == null || aliyunColor == null) {
            return;
        }
        aliyunPasterControllerCompoundCaption.setColor(aliyunColor);
        aliyunPasterControllerCompoundCaption.apply();
    }

    public static void applyCaptionTextFontTtfChanged(com.aliyun.svideosdk.editor.impl.AliyunPasterControllerCompoundCaption aliyunPasterControllerCompoundCaption, com.aliyun.svideosdk.common.struct.project.Source source) {
        if (aliyunPasterControllerCompoundCaption != null) {
            if (source != null) {
                if (android.text.TextUtils.isEmpty(source.getPath())) {
                    source.setPath(null);
                } else if (!source.getPath().endsWith(com.aliyun.svideo.editor.contant.CaptionConfig.FONT_NAME)) {
                    source.setPath(source.getPath() + com.aliyun.svideo.editor.contant.CaptionConfig.FONT_NAME);
                }
            }
            aliyunPasterControllerCompoundCaption.setFontPath(source);
            aliyunPasterControllerCompoundCaption.apply();
        }
    }

    public static void applyCaptionTextFontTypeFaceChanged(com.aliyun.svideosdk.editor.impl.AliyunPasterControllerCompoundCaption aliyunPasterControllerCompoundCaption, com.aliyun.svideosdk.common.AliyunTypeface aliyunTypeface) {
        if (aliyunPasterControllerCompoundCaption != null) {
            aliyunPasterControllerCompoundCaption.setFontTypeface(aliyunTypeface);
            aliyunPasterControllerCompoundCaption.apply();
        }
    }

    public static void applyCaptionTextShandowColorChanged(com.aliyun.svideosdk.editor.impl.AliyunPasterControllerCompoundCaption aliyunPasterControllerCompoundCaption, com.aliyun.svideosdk.common.AliyunColor aliyunColor) {
        if (aliyunPasterControllerCompoundCaption == null || aliyunColor == null) {
            return;
        }
        aliyunPasterControllerCompoundCaption.setShadowColor(aliyunColor);
        aliyunPasterControllerCompoundCaption.apply();
    }

    public static void applyCaptionTextShandowOffsetChanged(com.aliyun.svideosdk.editor.impl.AliyunPasterControllerCompoundCaption aliyunPasterControllerCompoundCaption, android.graphics.PointF pointF) {
        if (aliyunPasterControllerCompoundCaption == null || pointF == null) {
            return;
        }
        aliyunPasterControllerCompoundCaption.setShadowOffset(pointF);
        aliyunPasterControllerCompoundCaption.apply();
    }

    public static void applyCaptionTextStrokeColorChanged(com.aliyun.svideosdk.editor.impl.AliyunPasterControllerCompoundCaption aliyunPasterControllerCompoundCaption, com.aliyun.svideosdk.common.AliyunColor aliyunColor) {
        if (aliyunPasterControllerCompoundCaption == null || aliyunColor == null) {
            return;
        }
        aliyunPasterControllerCompoundCaption.setOutlineColor(aliyunColor);
        aliyunPasterControllerCompoundCaption.apply();
    }

    public static void applyCaptionTextStrokeWidthChanged(com.aliyun.svideosdk.editor.impl.AliyunPasterControllerCompoundCaption aliyunPasterControllerCompoundCaption, int i) {
        if (aliyunPasterControllerCompoundCaption == null || i <= 0) {
            return;
        }
        aliyunPasterControllerCompoundCaption.setOutlineWidth(i);
        aliyunPasterControllerCompoundCaption.apply();
    }

    public static void applyDurationChanged(com.aliyun.svideosdk.editor.impl.AliyunPasterControllerCompoundCaption aliyunPasterControllerCompoundCaption, long j, long j2) {
        if (aliyunPasterControllerCompoundCaption != null) {
            java.util.concurrent.TimeUnit timeUnit = java.util.concurrent.TimeUnit.MILLISECONDS;
            aliyunPasterControllerCompoundCaption.setStartTime(j, timeUnit);
            aliyunPasterControllerCompoundCaption.setDuration(j2, timeUnit);
            aliyunPasterControllerCompoundCaption.apply();
        }
    }

    public static void applyFontEffectTemplateChanged(com.aliyun.svideosdk.editor.impl.AliyunPasterControllerCompoundCaption aliyunPasterControllerCompoundCaption, com.aliyun.svideosdk.common.struct.project.Source source) {
        if (aliyunPasterControllerCompoundCaption != null) {
            aliyunPasterControllerCompoundCaption.setFontEffectTemplate(source);
            aliyunPasterControllerCompoundCaption.apply();
        }
    }

    public static long captionDurationBoundJudge(com.aliyun.svideosdk.editor.AliyunIEditor aliyunIEditor, long j) {
        if (aliyunIEditor != null) {
            long duration = aliyunIEditor.getPlayerController().getDuration();
            long currentPlayPosition = aliyunIEditor.getPlayerController().getCurrentPlayPosition();
            if (currentPlayPosition + j <= duration) {
                return j;
            }
            long j2 = duration - currentPlayPosition;
            if (j2 >= 500) {
                return j2;
            }
        }
        return 0L;
    }

    public static void downloadFont(com.aliyun.svideo.downloader.FileDownloaderModel fileDownloaderModel, com.aliyun.svideo.downloader.FileDownloaderCallback fileDownloaderCallback) {
        if (fileDownloaderModel == null || fileDownloaderCallback == null) {
            return;
        }
        fileDownloaderModel.setEffectType(1);
        fileDownloaderModel.setIsunzip(1);
        com.aliyun.svideo.downloader.DownloaderManager.getInstance().startTask(com.aliyun.svideo.downloader.DownloaderManager.getInstance().addTask(fileDownloaderModel, fileDownloaderModel.getUrl()).getTaskId(), fileDownloaderCallback);
    }

    public static void downloadPaster(com.aliyun.svideo.downloader.FileDownloaderModel fileDownloaderModel, com.aliyun.svideo.downloader.FileDownloaderCallback fileDownloaderCallback) {
        fileDownloaderModel.setEffectType(6);
        fileDownloaderModel.setIsunzip(1);
        com.aliyun.svideo.downloader.DownloaderManager.getInstance().startTask(com.aliyun.svideo.downloader.DownloaderManager.getInstance().addTask(fileDownloaderModel, fileDownloaderModel.getUrl()).getTaskId(), fileDownloaderCallback);
    }

    @androidx.annotation.Nullable
    public static com.aliyun.svideosdk.editor.AliyunIPasterController findControllerAtPoint(com.aliyun.svideosdk.editor.AliyunPasterManager aliyunPasterManager, android.view.MotionEvent motionEvent, android.graphics.PointF pointF, long j) {
        if (aliyunPasterManager == null || motionEvent == null || pointF == null || j < 0) {
            return null;
        }
        pointF.x = motionEvent.getX();
        pointF.y = motionEvent.getY();
        com.aliyun.svideosdk.editor.AliyunIPasterController findControllerAtPoint = aliyunPasterManager.findControllerAtPoint(pointF, j, java.util.concurrent.TimeUnit.MILLISECONDS);
        if (isCaptionAnimatorActive(j, findControllerAtPoint)) {
            return null;
        }
        return findControllerAtPoint;
    }

    public static java.util.List<com.aliyun.svideo.downloader.FileDownloaderModel> getBubbleFromLocal() {
        return com.aliyun.svideo.downloader.DownloaderManager.getInstance().getDbController().getResourceByType(6);
    }

    @androidx.annotation.Nullable
    public static com.aliyun.svideosdk.editor.impl.AliyunPasterControllerCompoundCaption getCaptionController(com.aliyun.svideo.editor.effects.caption.listener.OnCaptionChooserStateChangeListener onCaptionChooserStateChangeListener) {
        if (onCaptionChooserStateChangeListener != null) {
            return onCaptionChooserStateChangeListener.getAliyunPasterController();
        }
        return null;
    }

    public static int getCaptionControllerId(com.aliyun.svideo.editor.effects.caption.listener.OnCaptionChooserStateChangeListener onCaptionChooserStateChangeListener) {
        if (onCaptionChooserStateChangeListener != null) {
            return getCaptionControllerId(onCaptionChooserStateChangeListener.getAliyunPasterController());
        }
        return 0;
    }

    public static int getCaptionControllerId(com.aliyun.svideosdk.editor.impl.AliyunPasterControllerCompoundCaption aliyunPasterControllerCompoundCaption) {
        if (aliyunPasterControllerCompoundCaption != null) {
            return java.lang.System.identityHashCode(aliyunPasterControllerCompoundCaption);
        }
        return 0;
    }

    public static android.graphics.RectF getCaptionRectF(android.view.ViewGroup.LayoutParams layoutParams, com.aliyun.svideosdk.editor.impl.AliyunPasterControllerCompoundCaption aliyunPasterControllerCompoundCaption) {
        if (layoutParams == null || aliyunPasterControllerCompoundCaption == null) {
            return null;
        }
        return aliyunPasterControllerCompoundCaption.getSize();
    }

    public static com.aliyun.svideo.editor.bean.AlivcCaptionBorderBean getCaptionSize(android.view.ViewGroup.LayoutParams layoutParams, com.aliyun.svideosdk.editor.impl.AliyunPasterControllerCompoundCaption aliyunPasterControllerCompoundCaption) {
        if (layoutParams == null || aliyunPasterControllerCompoundCaption == null) {
            return null;
        }
        return new com.aliyun.svideo.editor.bean.AlivcCaptionBorderBean(aliyunPasterControllerCompoundCaption.getSize(), aliyunPasterControllerCompoundCaption.getScale(), aliyunPasterControllerCompoundCaption.getRotate());
    }

    @androidx.annotation.NonNull
    public static java.util.List<com.aliyun.svideo.downloader.FileDownloaderModel> getFontFromLocal() {
        java.util.List<com.aliyun.svideo.downloader.FileDownloaderModel> resourceByType = com.aliyun.svideo.downloader.DownloaderManager.getInstance().getDbController().getResourceByType(1);
        if (resourceByType == null) {
            resourceByType = new java.util.ArrayList<>();
        }
        com.aliyun.svideo.downloader.FileDownloaderModel fileDownloaderModel = new com.aliyun.svideo.downloader.FileDownloaderModel();
        fileDownloaderModel.setIcon("system_font");
        resourceByType.add(0, fileDownloaderModel);
        return resourceByType;
    }

    public static int getRootViewHeight(android.view.View view) {
        android.view.View rootView;
        android.view.View findViewById;
        if (view == null || (rootView = view.getRootView()) == null || (findViewById = rootView.findViewById(android.R.id.content)) == null) {
            return 0;
        }
        return findViewById.getHeight();
    }

    private static boolean isCaptionAnimatorActive(long j, com.aliyun.svideosdk.editor.AliyunIPasterController aliyunIPasterController) {
        java.util.List<com.aliyun.svideosdk.common.struct.effect.ActionBase> frameAnimations;
        return (aliyunIPasterController instanceof com.aliyun.svideosdk.editor.impl.AliyunPasterControllerCompoundCaption) && (frameAnimations = ((com.aliyun.svideosdk.editor.impl.AliyunPasterControllerCompoundCaption) aliyunIPasterController).getFrameAnimations()) != null && frameAnimations.size() > 0 && j - aliyunIPasterController.getStartTime(java.util.concurrent.TimeUnit.MILLISECONDS) > 200;
    }

    public static boolean isTextOnly(com.aliyun.svideosdk.editor.impl.AliyunPasterControllerCompoundCaption aliyunPasterControllerCompoundCaption) {
        if (aliyunPasterControllerCompoundCaption != null) {
            return android.text.TextUtils.isEmpty(aliyunPasterControllerCompoundCaption.getBubbleEffectTemplate());
        }
        return true;
    }

    public static void removeCaption(com.aliyun.svideosdk.editor.AliyunPasterManager aliyunPasterManager, com.aliyun.svideosdk.editor.impl.AliyunPasterControllerCompoundCaption aliyunPasterControllerCompoundCaption) {
        if (aliyunPasterManager == null || aliyunPasterControllerCompoundCaption == null) {
            return;
        }
        aliyunPasterManager.remove(aliyunPasterControllerCompoundCaption);
    }
}
