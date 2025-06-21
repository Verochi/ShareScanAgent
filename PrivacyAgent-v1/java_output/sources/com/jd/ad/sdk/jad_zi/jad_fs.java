package com.jd.ad.sdk.jad_zi;

/* loaded from: classes23.dex */
public class jad_fs implements com.jd.ad.sdk.mdt.service.JADEventService {
    @Override // com.jd.ad.sdk.mdt.service.JADEventService
    public void reportClickEvent(java.lang.String str, java.lang.String str2, int i, int i2, int i3, int i4, int i5, long j, long j2, long j3, int i6, int i7, int i8, int i9, int i10, int i11, int i12) {
        com.jd.ad.sdk.jad_xk.jad_fs.jad_an(str, str2, 1, i, i2, i3, i4, i5, j, j2, j3, i6, i7, i8, i9, i10, i11, i12, 0);
    }

    @Override // com.jd.ad.sdk.mdt.service.JADEventService
    public void reportCloseEvent(java.lang.String str, java.lang.String str2, int i, int i2, int i3, int i4, int i5, long j, long j2, long j3, int i6, int i7, int i8, int i9, int i10) {
        com.jd.ad.sdk.jad_xk.jad_fs.jad_an(str, str2, 1, i, i2, i3, i4, i5, j, j2, j3, i6, i7, i8, i9, i10, 0);
    }

    @Override // com.jd.ad.sdk.mdt.service.JADEventService
    public void reportExceptionEvent(@androidx.annotation.NonNull java.lang.String str, int i, @androidx.annotation.NonNull java.lang.String str2) {
        com.jd.ad.sdk.jad_xk.jad_fs.jad_an(str, i, str2);
    }

    @Override // com.jd.ad.sdk.mdt.service.JADEventService
    public void reportExposureEvent(java.lang.String str, java.lang.String str2, int i, int i2, int i3, int i4, int i5, long j, long j2, int i6, int i7, int i8, int i9, java.lang.String str3, int i10, int i11) {
        com.jd.ad.sdk.jad_xk.jad_fs.jad_an(str, str2, 1, i, i2, i3, i4, i5, j, j2, i6, i7, i8, i9, com.jd.ad.sdk.fdt.utils.JsonUtils.parse2JSONObject(str3), i10, i11, 0);
    }

    @Override // com.jd.ad.sdk.mdt.service.JADEventService
    public void reportPreloadClickEvent(java.lang.String str, java.lang.String str2, int i, int i2, int i3, int i4, int i5, long j, long j2, long j3, int i6, int i7, int i8, int i9, int i10, int i11, int i12) {
        com.jd.ad.sdk.jad_xk.jad_fs.jad_an(str, str2, 1, i, i2, i3, i4, i5, j, j2, j3, i6, i7, i8, i9, i10, i11, i12, 1);
    }

    @Override // com.jd.ad.sdk.mdt.service.JADEventService
    public void reportPreloadCloseEvent(java.lang.String str, java.lang.String str2, int i, int i2, int i3, int i4, int i5, long j, long j2, long j3, int i6, int i7, int i8, int i9, int i10) {
        com.jd.ad.sdk.jad_xk.jad_fs.jad_an(str, str2, 1, i, i2, i3, i4, i5, j, j2, j3, i6, i7, i8, i9, i10, 1);
    }

    @Override // com.jd.ad.sdk.mdt.service.JADEventService
    public void reportPreloadExposureEvent(java.lang.String str, java.lang.String str2, int i, int i2, int i3, int i4, int i5, long j, long j2, int i6, int i7, int i8, int i9, java.lang.String str3, int i10, int i11) {
        com.jd.ad.sdk.jad_xk.jad_fs.jad_an(str, str2, 1, i, i2, i3, i4, i5, j, j2, i6, i7, i8, i9, com.jd.ad.sdk.fdt.utils.JsonUtils.parse2JSONObject(str3), i10, i11, 1);
    }

    @Override // com.jd.ad.sdk.mdt.service.JADEventService
    public void reportPreloadRenderSuccessEvent(@androidx.annotation.NonNull java.lang.String str, @androidx.annotation.NonNull java.lang.String str2, int i, int i2, int i3, int i4, long j, long j2, int i5, int i6, int i7, int i8, int i9) {
        com.jd.ad.sdk.jad_xk.jad_fs.jad_an(str, str2, 1, i, i2, i3, i4, j, 1, j2, i5, i6, i7, i8, i9, 1);
    }

    @Override // com.jd.ad.sdk.mdt.service.JADEventService
    public void reportPreloadResponseEvent(@androidx.annotation.NonNull java.lang.String str, @androidx.annotation.NonNull java.lang.String str2, int i, int i2, int i3, int i4, long j, int i5, int i6, int i7, int i8, int i9) {
        com.jd.ad.sdk.jad_xk.jad_fs.jad_an(str, str2, 1, i, i2, i3, i4, j, 0, 0L, i5, i6, i7, i8, i9, 1);
    }

    @Override // com.jd.ad.sdk.mdt.service.JADEventService
    public void reportRenderFailedEvent(@androidx.annotation.NonNull java.lang.String str, int i, @androidx.annotation.NonNull java.lang.String str2, int i2) {
        com.jd.ad.sdk.jad_xk.jad_fs.jad_an(str, 10, i, str2, i2);
    }

    @Override // com.jd.ad.sdk.mdt.service.JADEventService
    public void reportRenderSuccessEvent(@androidx.annotation.NonNull java.lang.String str, @androidx.annotation.NonNull java.lang.String str2, int i, int i2, int i3, int i4, long j, long j2, int i5, int i6, int i7, int i8, int i9) {
        com.jd.ad.sdk.jad_xk.jad_fs.jad_an(str, str2, 1, i, i2, i3, i4, j, 1, j2, i5, i6, i7, i8, i9, 0);
    }

    @Override // com.jd.ad.sdk.mdt.service.JADEventService
    public void reportRequestErrorEvent(@androidx.annotation.NonNull java.lang.String str, int i, @androidx.annotation.NonNull java.lang.String str2) {
        com.jd.ad.sdk.jad_xk.jad_fs.jad_an(str, 7, i, str2, 0);
    }

    @Override // com.jd.ad.sdk.mdt.service.JADEventService
    public void reportResponseEvent(@androidx.annotation.NonNull java.lang.String str, @androidx.annotation.NonNull java.lang.String str2, int i, int i2, int i3, int i4, long j, int i5, int i6, int i7, int i8, int i9) {
        com.jd.ad.sdk.jad_xk.jad_fs.jad_an(str, str2, 1, i, i2, i3, i4, j, 0, 0L, i5, i6, i7, i8, i9, 0);
    }

    @Override // com.jd.ad.sdk.mdt.service.JADEventService
    public void reportVideoEvent(java.lang.String str, java.lang.String str2, int i, int i2, int i3, int i4, long j, long j2, long j3, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, double d) {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "tp", 4);
        com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "adrid", str);
        com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "pid", str2);
        com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "pfid", 1);
        com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "adt", java.lang.Integer.valueOf(i));
        com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "clid", com.jd.ad.sdk.fdt.utils.UUIDUtils.uuid());
        com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "tpid", java.lang.Integer.valueOf(i2));
        com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "clf", java.lang.Integer.valueOf(com.jd.ad.sdk.dl.common.CommonConstants.ClickFrom.VIDEO.ordinal()));
        com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "sen", java.lang.Integer.valueOf(i3));
        com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "rem", java.lang.Integer.valueOf(i4));
        com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "dety", 10);
        com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "scdu", java.lang.Long.valueOf(j));
        com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "dcdu", java.lang.Long.valueOf(j2));
        com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "ecdu", java.lang.Long.valueOf(j3));
        com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "sspt", java.lang.Integer.valueOf(i5));
        com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "scav", java.lang.Integer.valueOf(i6));
        com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "adat", java.lang.Integer.valueOf(i7));
        com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "atst", java.lang.Integer.valueOf(i8));
        com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "catp", java.lang.Integer.valueOf(i9));
        com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "dstp", java.lang.Integer.valueOf(i10));
        com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "srtp", java.lang.Integer.valueOf(i11));
        com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "ipl", 0);
        com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "vpst", java.lang.Integer.valueOf(i12));
        com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "vpdt", java.lang.Double.valueOf(d));
        com.jd.ad.sdk.jad_xk.jad_iv.jad_cp.jad_an.jad_bo(jSONObject);
    }

    @Override // com.jd.ad.sdk.mdt.service.JADEventService
    public void reportVideoExceptionEvent(@androidx.annotation.NonNull java.lang.String str, int i, @androidx.annotation.NonNull java.lang.String str2) {
        com.jd.ad.sdk.jad_xk.jad_fs.jad_an(str, 11, i, str2, 0);
    }
}
