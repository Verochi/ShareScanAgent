package com.jd.ad.sdk.jad_zi;

/* loaded from: classes23.dex */
public class jad_kx implements com.jd.ad.sdk.mdt.service.JADVideoRenderService {
    @Override // com.jd.ad.sdk.mdt.service.JADVideoRenderService
    public com.jd.ad.sdk.bl.video.VideoRenderView createVideoRendView(android.content.Context context, @androidx.annotation.NonNull java.lang.String str, @androidx.annotation.NonNull com.jd.ad.sdk.dl.model.JADSlot jADSlot, long j, com.jd.ad.sdk.bl.video.listener.OnVideoRenderListener onVideoRenderListener, com.jd.ad.sdk.bl.video.listener.VideoLoadListener videoLoadListener) {
        try {
            int dip2px = (int) com.jd.ad.sdk.fdt.utils.ScreenUtils.dip2px(context, jADSlot.getWidth());
            int dip2px2 = (int) com.jd.ad.sdk.fdt.utils.ScreenUtils.dip2px(context, jADSlot.getHeight());
            java.util.List<com.jd.ad.sdk.dl.addata.JADMaterialData> jADMaterialDataList = com.jd.ad.sdk.mdt.servicemediator.JADMediator.getInstance().getAdService().getJADMaterialDataList(str);
            if (jADMaterialDataList != null && jADMaterialDataList.size() > 0) {
                java.lang.String str2 = com.jd.ad.sdk.bl.initsdk.JADYunSdk.getAppId() + jADSlot.getSlotID();
                com.jd.ad.sdk.dl.addata.JADMaterialData jADMaterialData = com.jd.ad.sdk.mdt.servicemediator.JADMediator.getInstance().getAdService().getJADMaterialDataList(str).get(0);
                if (jADMaterialData == null) {
                    return null;
                }
                java.lang.String videoUrl = jADMaterialData.getVideoUrl();
                int muted = jADMaterialData.getMuted();
                java.util.List<java.lang.String> imageUrls = jADMaterialData.getImageUrls();
                java.lang.String str3 = (imageUrls == null || imageUrls.size() <= 0) ? "" : imageUrls.get(0);
                if (android.text.TextUtils.isEmpty(str3) && android.text.TextUtils.isEmpty(videoUrl)) {
                    return null;
                }
                com.jd.ad.sdk.bl.video.VideoRenderView.jad_iv jad_ivVar = new com.jd.ad.sdk.bl.video.VideoRenderView.jad_iv();
                jad_ivVar.jad_an = dip2px;
                jad_ivVar.jad_bo = dip2px2;
                jad_ivVar.jad_ly = str;
                jad_ivVar.jad_fs = str3;
                jad_ivVar.jad_jw = videoUrl;
                jad_ivVar.jad_jt = jADSlot.getSkipTime();
                jad_ivVar.jad_cp = onVideoRenderListener;
                jad_ivVar.jad_dq = jADSlot.getEventInteractionType();
                jad_ivVar.jad_er = jADSlot.getModelClickAreaType();
                jad_ivVar.jad_hu = jADSlot.isHideSkip();
                jad_ivVar.jad_kx = str2;
                jad_ivVar.jad_ob = muted;
                jad_ivVar.jad_pc = jADMaterialData.getVideoDuration();
                jad_ivVar.jad_na = j;
                jad_ivVar.jad_iv = jADSlot.isHidePreloadLabel();
                jad_ivVar.jad_mz = videoLoadListener;
                com.jd.ad.sdk.bl.video.VideoRenderView videoRenderView = new com.jd.ad.sdk.bl.video.VideoRenderView(context, jad_ivVar);
                java.lang.Exception videoRenderException = videoRenderView.getVideoRenderException();
                if (videoRenderException == null) {
                    return videoRenderView;
                }
                throw videoRenderException;
            }
            return null;
        } catch (java.lang.Throwable th) {
            int sen = jADSlot != null ? jADSlot.getSen() : 0;
            java.lang.Exception exc = new java.lang.Exception("video render view init error", th);
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            java.lang.String message = exc.getMessage();
            int i = com.jd.ad.sdk.jad_wj.jad_an.RENDER_VIDEO_VIEW_INIT_OTHER_ERROR.jad_an;
            try {
                for (java.lang.Throwable cause = exc.getCause(); cause != null; cause = cause.getCause()) {
                    java.lang.String message2 = cause.getMessage();
                    if (android.text.TextUtils.isEmpty(message2) || !message2.startsWith("40")) {
                        message = message + "|" + message2;
                    } else {
                        java.lang.String[] split = message2.split(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                        i = java.lang.Integer.parseInt(split[0]);
                        message = message + "|" + split[1];
                    }
                }
            } catch (java.lang.Exception unused) {
                com.jd.ad.sdk.logger.Logger.d("错误信息拼接异常");
            } finally {
                jSONObject.put("code", i);
                jSONObject.put("msg", message);
            }
            int optInt = jSONObject.optInt("code");
            com.jd.ad.sdk.jad_xk.jad_fs.jad_an("", 5, optInt, jSONObject.optString("msg"), sen);
            com.jd.ad.sdk.logger.Logger.w(optInt + ": video render view error：" + android.util.Log.getStackTraceString(exc), new java.lang.Object[0]);
            return null;
        }
    }

    @Override // com.jd.ad.sdk.mdt.service.JADVideoRenderService
    public void registerAdViewClick(android.content.Context context, com.jd.ad.sdk.bl.video.VideoRenderView videoRenderView, com.jd.ad.sdk.bl.video.listener.VideoInteractionListener videoInteractionListener) {
        videoRenderView.setVideoInteractionListener(videoInteractionListener);
    }
}
