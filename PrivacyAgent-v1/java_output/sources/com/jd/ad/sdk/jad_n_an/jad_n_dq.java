package com.jd.ad.sdk.jad_n_an;

/* loaded from: classes23.dex */
public class jad_n_dq implements com.jd.ad.sdk.dl.event.JADVideoReporter {
    public final com.jd.ad.sdk.dl.model.JADSlot jad_n_an;
    public final com.jd.ad.sdk.mdt.service.JADEventService jad_n_bo = com.jd.ad.sdk.mdt.servicemediator.JADMediator.getInstance().getEventService();

    public jad_n_dq(com.jd.ad.sdk.dl.model.JADSlot jADSlot) {
        this.jad_n_an = jADSlot;
    }

    public final void jad_n_an(int i, float f) {
        com.jd.ad.sdk.mdt.service.JADEventService jADEventService;
        com.jd.ad.sdk.dl.model.JADSlot jADSlot = this.jad_n_an;
        if (jADSlot == null || (jADEventService = this.jad_n_bo) == null) {
            return;
        }
        jADEventService.reportVideoEvent(jADSlot.getRequestId(), this.jad_n_an.getSlotID(), this.jad_n_an.getAdType(), this.jad_n_an.getTemplateId(), this.jad_n_an.getSen(), this.jad_n_an.getRem(), this.jad_n_an.getScdu(), this.jad_n_an.getDcdu(), this.jad_n_an.getEcdu(), this.jad_n_an.getSspt(), this.jad_n_an.getScav(), this.jad_n_an.getEventInteractionType(), this.jad_n_an.getAtst(), this.jad_n_an.getModelClickAreaType(), this.jad_n_an.getDstp(), this.jad_n_an.getSrtp(), i, com.jd.ad.sdk.fdt.utils.ConversionUtils.floatToDouble(f));
    }

    @Override // com.jd.ad.sdk.dl.event.JADVideoReporter
    public void reportVideoCompleted(float f) {
        jad_n_an(4, f);
    }

    @Override // com.jd.ad.sdk.dl.event.JADVideoReporter
    public void reportVideoError(float f, int i, int i2) {
        com.jd.ad.sdk.dl.model.JADSlot jADSlot = this.jad_n_an;
        java.lang.String requestId = jADSlot != null ? jADSlot.getRequestId() : "";
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "duration", java.lang.Float.valueOf(f));
        com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "errorCode", java.lang.Integer.valueOf(i));
        com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "extraCode", java.lang.Integer.valueOf(i2));
        com.jd.ad.sdk.mdt.service.JADEventService jADEventService = this.jad_n_bo;
        if (jADEventService != null) {
            jADEventService.reportVideoExceptionEvent(requestId, 11, jSONObject.toString());
        }
    }

    @Override // com.jd.ad.sdk.dl.event.JADVideoReporter
    public void reportVideoPause(float f) {
        jad_n_an(3, f);
    }

    @Override // com.jd.ad.sdk.dl.event.JADVideoReporter
    public void reportVideoPreloadCompleted() {
    }

    @Override // com.jd.ad.sdk.dl.event.JADVideoReporter
    public void reportVideoResume(float f) {
        jad_n_an(5, f);
    }

    @Override // com.jd.ad.sdk.dl.event.JADVideoReporter
    public void reportVideoStart(float f) {
        jad_n_an(2, f);
    }

    @Override // com.jd.ad.sdk.dl.event.JADVideoReporter
    public void reportVideoWillStart() {
        jad_n_an(1, 0.0f);
    }
}
