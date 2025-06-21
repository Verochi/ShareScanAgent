package com.jd.ad.sdk.jad_s_an;

/* loaded from: classes23.dex */
public class jad_s_jw implements com.jd.ad.sdk.dl.event.JADVideoReporter {
    public final com.jd.ad.sdk.dl.model.JADSlot jad_s_an;
    public final com.jd.ad.sdk.mdt.service.JADEventService jad_s_bo = com.jd.ad.sdk.mdt.servicemediator.JADMediator.getInstance().getEventService();

    public jad_s_jw(com.jd.ad.sdk.dl.model.JADSlot jADSlot) {
        this.jad_s_an = jADSlot;
    }

    public final void jad_s_an(int i, float f) {
        com.jd.ad.sdk.mdt.service.JADEventService jADEventService;
        com.jd.ad.sdk.dl.model.JADSlot jADSlot = this.jad_s_an;
        if (jADSlot == null || (jADEventService = this.jad_s_bo) == null) {
            return;
        }
        jADEventService.reportVideoEvent(jADSlot.getRequestId(), this.jad_s_an.getSlotID(), this.jad_s_an.getAdType(), this.jad_s_an.getTemplateId(), this.jad_s_an.getSen(), this.jad_s_an.getRem(), this.jad_s_an.getScdu(), this.jad_s_an.getDcdu(), this.jad_s_an.getEcdu(), this.jad_s_an.getSspt(), this.jad_s_an.getScav(), this.jad_s_an.getEventInteractionType(), this.jad_s_an.getAtst(), this.jad_s_an.getModelClickAreaType(), this.jad_s_an.getDstp(), this.jad_s_an.getSrtp(), i, com.jd.ad.sdk.fdt.utils.ConversionUtils.floatToDouble(f));
    }

    @Override // com.jd.ad.sdk.dl.event.JADVideoReporter
    public void reportVideoCompleted(float f) {
        jad_s_an(5, f);
    }

    @Override // com.jd.ad.sdk.dl.event.JADVideoReporter
    public void reportVideoError(float f, int i, int i2) {
        com.jd.ad.sdk.dl.model.JADSlot jADSlot = this.jad_s_an;
        java.lang.String requestId = jADSlot != null ? jADSlot.getRequestId() : "";
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "duration", java.lang.Float.valueOf(f));
        com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "errorCode", java.lang.Integer.valueOf(i));
        com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "extraCode", java.lang.Integer.valueOf(i2));
        com.jd.ad.sdk.mdt.service.JADEventService jADEventService = this.jad_s_bo;
        if (jADEventService != null) {
            jADEventService.reportVideoExceptionEvent(requestId, 11, jSONObject.toString());
        }
    }

    @Override // com.jd.ad.sdk.dl.event.JADVideoReporter
    public void reportVideoPause(float f) {
        jad_s_an(4, f);
    }

    @Override // com.jd.ad.sdk.dl.event.JADVideoReporter
    public void reportVideoPreloadCompleted() {
        jad_s_an(2, 0.0f);
    }

    @Override // com.jd.ad.sdk.dl.event.JADVideoReporter
    public void reportVideoResume(float f) {
        jad_s_an(6, f);
    }

    @Override // com.jd.ad.sdk.dl.event.JADVideoReporter
    public void reportVideoStart(float f) {
        jad_s_an(3, f);
    }

    @Override // com.jd.ad.sdk.dl.event.JADVideoReporter
    public void reportVideoWillStart() {
        jad_s_an(1, 0.0f);
    }
}
