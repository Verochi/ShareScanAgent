package com.jd.ad.sdk.jad_iv;

/* loaded from: classes23.dex */
public class jad_dq implements com.jd.ad.sdk.jad_iv.jad_er.jad_an {
    public java.lang.ref.WeakReference<android.view.View> jad_an;
    public com.jd.ad.sdk.jad_iv.jad_er jad_bo;
    public volatile com.jd.ad.sdk.bl.exposuremonitor.JADExposureListener jad_cp;
    public int jad_dq;
    public final com.jd.ad.sdk.jad_yl.jad_bo jad_er = new com.jd.ad.sdk.jad_yl.jad_bo();
    public java.lang.ref.WeakReference<java.lang.String> jad_fs;

    @Override // com.jd.ad.sdk.jad_iv.jad_er.jad_an
    public void jad_an(android.os.Message message) {
        com.jd.ad.sdk.jad_yl.jad_bo jad_boVar;
        int i;
        int jad_an;
        com.jd.ad.sdk.jad_yl.jad_bo jad_boVar2;
        int jad_an2;
        int i2;
        int i3 = message.what;
        int i4 = 0;
        if (i3 == 1) {
            android.view.View jad_bo = jad_bo();
            if (jad_bo == null) {
                com.jd.ad.sdk.jad_iv.jad_er jad_erVar = this.jad_bo;
                if (jad_erVar != null) {
                    jad_erVar.removeCallbacksAndMessages(null);
                    return;
                }
                return;
            }
            if (jad_bo.getVisibility() != 0) {
                com.jd.ad.sdk.jad_iv.jad_er jad_erVar2 = this.jad_bo;
                if (jad_erVar2 != null) {
                    jad_erVar2.sendEmptyMessageDelayed(1, 1000L);
                    return;
                }
                return;
            }
            if (this.jad_cp != null && (jad_boVar = this.jad_er) != null && !jad_boVar.jad_an) {
                android.graphics.Rect rect = new android.graphics.Rect();
                if (jad_bo.getGlobalVisibleRect(rect)) {
                    int width = rect.width();
                    int height = rect.height();
                    i = width;
                    i4 = height;
                } else {
                    i = 0;
                }
                int i5 = this.jad_dq;
                int width2 = jad_bo.getWidth();
                int height2 = jad_bo.getHeight();
                if (i5 == 1) {
                    int screenWidth = com.jd.ad.sdk.dl.baseinfo.JADScreenInfoUtils.getScreenWidth(com.jd.ad.sdk.jad_fq.jad_cp.jad_an());
                    int screenHeight = com.jd.ad.sdk.dl.baseinfo.JADScreenInfoUtils.getScreenHeight(com.jd.ad.sdk.jad_fq.jad_cp.jad_an());
                    jad_an = com.jd.ad.sdk.jad_jt.jad_iv.jad_an(height2 * width2, screenWidth * screenHeight);
                    i4 = height2;
                    height2 = screenHeight;
                    i = width2;
                    width2 = screenWidth;
                } else {
                    jad_an = com.jd.ad.sdk.jad_jt.jad_iv.jad_an(i4 * i, width2 * height2);
                }
                com.jd.ad.sdk.bl.exposuremonitor.JADExposureListener jADExposureListener = this.jad_cp;
                org.json.JSONObject jSONObject = new org.json.JSONObject();
                try {
                    jSONObject.put("visible_area", jad_an);
                    jSONObject.put("width", width2);
                    jSONObject.put("height", height2);
                    jSONObject.put("visible_width", i);
                    jSONObject.put("visible_height", i4);
                } catch (org.json.JSONException e) {
                    e.printStackTrace();
                }
                jADExposureListener.onPreExposure(jSONObject.toString());
                this.jad_er.jad_an = true;
            }
            com.jd.ad.sdk.jad_iv.jad_er jad_erVar3 = this.jad_bo;
            if (jad_erVar3 != null) {
                jad_erVar3.sendEmptyMessage(2);
                return;
            }
            return;
        }
        if (i3 != 2) {
            if (i3 == 3) {
                android.view.View jad_bo2 = jad_bo();
                if (jad_bo2 == null) {
                    com.jd.ad.sdk.jad_iv.jad_er jad_erVar4 = this.jad_bo;
                    if (jad_erVar4 != null) {
                        jad_erVar4.removeCallbacksAndMessages(null);
                        return;
                    }
                    return;
                }
                if (jad_bo2.getVisibility() != 0) {
                    com.jd.ad.sdk.jad_iv.jad_er jad_erVar5 = this.jad_bo;
                    if (jad_erVar5 != null) {
                        jad_erVar5.sendEmptyMessage(1);
                        return;
                    }
                    return;
                }
                if (jad_an()) {
                    com.jd.ad.sdk.jad_iv.jad_er jad_erVar6 = this.jad_bo;
                    if (jad_erVar6 != null) {
                        jad_erVar6.sendEmptyMessageDelayed(4, 1000L);
                        return;
                    }
                    return;
                }
                com.jd.ad.sdk.jad_iv.jad_er jad_erVar7 = this.jad_bo;
                if (jad_erVar7 != null) {
                    jad_erVar7.sendEmptyMessageDelayed(3, 1000L);
                    return;
                }
                return;
            }
            if (i3 != 4) {
                return;
            }
            android.view.View jad_bo3 = jad_bo();
            if (jad_bo3 == null) {
                com.jd.ad.sdk.jad_iv.jad_er jad_erVar8 = this.jad_bo;
                if (jad_erVar8 != null) {
                    jad_erVar8.removeCallbacksAndMessages(null);
                    return;
                }
                return;
            }
            if (jad_bo3.getVisibility() != 0) {
                com.jd.ad.sdk.jad_iv.jad_er jad_erVar9 = this.jad_bo;
                if (jad_erVar9 != null) {
                    jad_erVar9.sendEmptyMessage(1);
                    return;
                }
                return;
            }
            if (!jad_an()) {
                com.jd.ad.sdk.jad_iv.jad_er jad_erVar10 = this.jad_bo;
                if (jad_erVar10 != null) {
                    jad_erVar10.sendEmptyMessageDelayed(3, 1000L);
                    return;
                }
                return;
            }
            com.jd.ad.sdk.jad_yl.jad_bo jad_boVar3 = this.jad_er;
            if (jad_boVar3 != null && !jad_boVar3.jad_cp) {
                jad_an(false, com.jd.ad.sdk.dl.common.CommonConstants.ExposureType.EXPOSURE_VALID.getIndex());
            }
            com.jd.ad.sdk.jad_iv.jad_er jad_erVar11 = this.jad_bo;
            if (jad_erVar11 != null) {
                jad_erVar11.removeCallbacksAndMessages(null);
                return;
            }
            return;
        }
        android.view.View jad_bo4 = jad_bo();
        if (jad_bo4 == null) {
            com.jd.ad.sdk.jad_iv.jad_er jad_erVar12 = this.jad_bo;
            if (jad_erVar12 != null) {
                jad_erVar12.removeCallbacksAndMessages(null);
                return;
            }
            return;
        }
        if (jad_bo4.getVisibility() != 0) {
            com.jd.ad.sdk.jad_iv.jad_er jad_erVar13 = this.jad_bo;
            if (jad_erVar13 != null) {
                jad_erVar13.sendEmptyMessage(1);
                return;
            }
            return;
        }
        if (!jad_dq()) {
            com.jd.ad.sdk.jad_iv.jad_er jad_erVar14 = this.jad_bo;
            if (jad_erVar14 != null) {
                jad_erVar14.sendEmptyMessageDelayed(2, 1000L);
                return;
            }
            return;
        }
        if (this.jad_cp != null && (jad_boVar2 = this.jad_er) != null && !jad_boVar2.jad_bo) {
            android.graphics.Rect rect2 = new android.graphics.Rect();
            jad_bo4.getGlobalVisibleRect(rect2);
            int i6 = this.jad_dq;
            int width3 = rect2.width();
            int height3 = rect2.height();
            int width4 = jad_bo4.getWidth();
            int height4 = jad_bo4.getHeight();
            if (i6 == 1) {
                int screenWidth2 = com.jd.ad.sdk.dl.baseinfo.JADScreenInfoUtils.getScreenWidth(com.jd.ad.sdk.jad_fq.jad_cp.jad_an());
                int screenHeight2 = com.jd.ad.sdk.dl.baseinfo.JADScreenInfoUtils.getScreenHeight(com.jd.ad.sdk.jad_fq.jad_cp.jad_an());
                jad_an2 = com.jd.ad.sdk.jad_jt.jad_iv.jad_an(height4 * width4, screenWidth2 * screenHeight2);
                height3 = height4;
                height4 = screenHeight2;
                i2 = screenWidth2;
            } else {
                jad_an2 = com.jd.ad.sdk.jad_jt.jad_iv.jad_an(height3 * width3, width4 * height4);
                i2 = width4;
                width4 = width3;
            }
            com.jd.ad.sdk.bl.exposuremonitor.JADExposureListener jADExposureListener2 = this.jad_cp;
            org.json.JSONObject jSONObject2 = new org.json.JSONObject();
            try {
                jSONObject2.put("visible_area", jad_an2);
                jSONObject2.put("width", i2);
                jSONObject2.put("height", height4);
                jSONObject2.put("visible_width", width4);
                jSONObject2.put("visible_height", height3);
            } catch (org.json.JSONException e2) {
                e2.printStackTrace();
            }
            jADExposureListener2.onExposure(jSONObject2.toString());
            this.jad_er.jad_bo = true;
        }
        com.jd.ad.sdk.jad_iv.jad_er jad_erVar15 = this.jad_bo;
        if (jad_erVar15 != null) {
            jad_erVar15.sendEmptyMessage(3);
        }
    }

    public final void jad_an(boolean z, int i) {
        int jad_an;
        java.util.List<java.lang.String> list;
        android.view.View jad_bo = jad_bo();
        if (this.jad_cp == null || jad_bo == null) {
            return;
        }
        if (jad_an() || z) {
            com.jd.ad.sdk.jad_yl.jad_bo jad_boVar = this.jad_er;
            if (jad_boVar != null) {
                jad_boVar.jad_cp = true;
            }
            com.jd.ad.sdk.bl.exposuremonitor.JADExposureListener jADExposureListener = this.jad_cp;
            android.graphics.Rect rect = new android.graphics.Rect();
            jad_bo.getGlobalVisibleRect(rect);
            int i2 = this.jad_dq;
            int width = rect.width();
            int height = rect.height();
            int width2 = jad_bo.getWidth();
            int height2 = jad_bo.getHeight();
            if (i2 == 1) {
                int screenWidth = com.jd.ad.sdk.dl.baseinfo.JADScreenInfoUtils.getScreenWidth(com.jd.ad.sdk.jad_fq.jad_cp.jad_an());
                int screenHeight = com.jd.ad.sdk.dl.baseinfo.JADScreenInfoUtils.getScreenHeight(com.jd.ad.sdk.jad_fq.jad_cp.jad_an());
                jad_an = com.jd.ad.sdk.jad_jt.jad_iv.jad_an(height2 * width2, screenWidth * screenHeight);
                width = width2;
                width2 = screenWidth;
                height = height2;
                height2 = screenHeight;
            } else {
                jad_an = com.jd.ad.sdk.jad_jt.jad_iv.jad_an(height * width, width2 * height2);
            }
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            try {
                jSONObject.put("visible_area", jad_an);
                jSONObject.put("width", width2);
                jSONObject.put("height", height2);
                jSONObject.put("visible_width", width);
                jSONObject.put("visible_height", height);
            } catch (org.json.JSONException e) {
                e.printStackTrace();
            }
            jADExposureListener.onDelayExposure(1000L, jSONObject.toString(), i);
            java.lang.ref.WeakReference<java.lang.String> weakReference = this.jad_fs;
            if (weakReference == null || weakReference.get() == null) {
                com.jd.ad.sdk.jad_wj.jad_an jad_anVar = com.jd.ad.sdk.jad_wj.jad_an.EXPOSURE_SERVER_REPORT_ERROR;
                com.jd.ad.sdk.jad_xk.jad_fs.jad_an("", jad_anVar.jad_an, jad_anVar.jad_an(new java.lang.String[0]));
            } else {
                com.jd.ad.sdk.jad_yl.jad_fs jad_cp = com.jd.ad.sdk.jad_na.jad_bo.jad_an.jad_an.jad_cp(com.jd.ad.sdk.jad_na.jad_cp.jad_an.jad_an.jad_an(this.jad_fs.get()));
                com.jd.ad.sdk.jad_xk.jad_iv.jad_cp.jad_an.jad_an((jad_cp == null || (list = jad_cp.jad_jw) == null) ? new java.lang.String[0] : (java.lang.String[]) list.toArray(new java.lang.String[0]));
            }
            this.jad_cp = null;
            com.jd.ad.sdk.jad_iv.jad_er jad_erVar = this.jad_bo;
            if (jad_erVar != null) {
                jad_erVar.removeCallbacksAndMessages(null);
                this.jad_bo = null;
            }
        }
    }

    public final boolean jad_an() {
        return this.jad_dq == 1 ? jad_dq() : jad_cp();
    }

    public final android.view.View jad_bo() {
        java.lang.ref.WeakReference<android.view.View> weakReference = this.jad_an;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public final boolean jad_cp() {
        int jad_an;
        android.view.View jad_bo = jad_bo();
        if (jad_bo == null) {
            return false;
        }
        android.graphics.Rect rect = new android.graphics.Rect();
        if (!jad_bo.getGlobalVisibleRect(rect)) {
            return false;
        }
        int i = this.jad_dq;
        int width = rect.width();
        int height = rect.height();
        int width2 = jad_bo.getWidth();
        int height2 = jad_bo.getHeight();
        if (i == 1) {
            jad_an = com.jd.ad.sdk.jad_jt.jad_iv.jad_an(height2 * width2, com.jd.ad.sdk.dl.baseinfo.JADScreenInfoUtils.getScreenWidth(com.jd.ad.sdk.jad_fq.jad_cp.jad_an()) * com.jd.ad.sdk.dl.baseinfo.JADScreenInfoUtils.getScreenHeight(com.jd.ad.sdk.jad_fq.jad_cp.jad_an()));
            width = width2;
        } else {
            jad_an = com.jd.ad.sdk.jad_jt.jad_iv.jad_an(height * width, width2 * height2);
            height2 = height;
        }
        if (i == 1) {
            if (width < 1 || height2 < 1) {
                return false;
            }
        } else if (jad_an < 50) {
            return false;
        }
        return true;
    }

    public final boolean jad_dq() {
        android.view.View jad_bo = jad_bo();
        if (jad_bo == null) {
            return false;
        }
        android.graphics.Rect rect = new android.graphics.Rect();
        return jad_bo.getGlobalVisibleRect(rect) && rect.width() >= 1 && rect.height() >= 1;
    }
}
