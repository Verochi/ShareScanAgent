package com.jd.ad.sdk.jad_jt;

/* loaded from: classes23.dex */
public class jad_an implements java.lang.Runnable {
    public final /* synthetic */ com.jd.ad.sdk.dl.model.JADSlot jad_an;
    public final /* synthetic */ com.jd.ad.sdk.bl.adload.JADAdLoadListener jad_bo;
    public final /* synthetic */ java.lang.String jad_cp;
    public final /* synthetic */ java.lang.String jad_dq;
    public final /* synthetic */ com.jd.ad.sdk.jad_jt.jad_jt jad_er;

    /* renamed from: com.jd.ad.sdk.jad_jt.jad_an$jad_an, reason: collision with other inner class name */
    public class C0385jad_an implements com.jd.ad.sdk.jad_zm.jad_ly.jad_an {

        /* renamed from: com.jd.ad.sdk.jad_jt.jad_an$jad_an$jad_an, reason: collision with other inner class name */
        public class RunnableC0386jad_an implements java.lang.Runnable {
            public RunnableC0386jad_an() {
            }

            @Override // java.lang.Runnable
            public void run() {
                com.jd.ad.sdk.jad_jt.jad_an jad_anVar = com.jd.ad.sdk.jad_jt.jad_an.this;
                com.jd.ad.sdk.jad_jt.jad_jt.jad_an(jad_anVar.jad_er, jad_anVar.jad_bo, jad_anVar.jad_an.getAdDataRequestSourceType());
            }
        }

        public C0385jad_an() {
        }

        @Override // com.jd.ad.sdk.jad_zm.jad_ly.jad_an
        public void jad_an(int i, java.lang.String str) {
            com.jd.ad.sdk.jad_jt.jad_an jad_anVar = com.jd.ad.sdk.jad_jt.jad_an.this;
            jad_anVar.jad_er.jad_an(jad_anVar.jad_bo, i, str);
            com.jd.ad.sdk.jad_jt.jad_an jad_anVar2 = com.jd.ad.sdk.jad_jt.jad_an.this;
            com.jd.ad.sdk.jad_xk.jad_fs.jad_an(jad_anVar2.jad_cp, 3, i, jad_anVar2.jad_er.jad_an(jad_anVar2.jad_an.getSlotID(), com.jd.ad.sdk.jad_jt.jad_an.this.jad_an.getAdType(), str), com.jd.ad.sdk.jad_jt.jad_an.this.jad_an.getSen());
        }

        @Override // com.jd.ad.sdk.jad_zm.jad_ly.jad_an
        public void jad_an(com.jd.ad.sdk.jad_zm.jad_mz jad_mzVar) {
            java.lang.String jad_an;
            java.lang.String jad_an2;
            java.lang.String jad_an3;
            com.jd.ad.sdk.jad_yl.jad_dq jad_dqVar;
            java.lang.String jad_an4;
            java.lang.String jad_an5;
            java.lang.String jad_an6;
            java.lang.String jad_an7;
            java.lang.String jad_an8;
            try {
                if (jad_mzVar.jad_cp() != 200) {
                    com.jd.ad.sdk.jad_jt.jad_an jad_anVar = com.jd.ad.sdk.jad_jt.jad_an.this;
                    jad_anVar.jad_er.jad_an(jad_anVar.jad_bo, jad_mzVar.jad_cp(), "error code: " + jad_mzVar.jad_cp());
                    java.lang.String jad_bo = jad_mzVar.jad_bo() != null ? jad_mzVar.jad_bo().jad_bo() : "";
                    com.jd.ad.sdk.logger.Logger.d("【load】loadAd error code:" + jad_mzVar.jad_cp() + ",msg=" + jad_bo);
                    java.lang.String str = com.jd.ad.sdk.jad_jt.jad_an.this.jad_cp;
                    int jad_cp = jad_mzVar.jad_cp();
                    com.jd.ad.sdk.jad_jt.jad_an jad_anVar2 = com.jd.ad.sdk.jad_jt.jad_an.this;
                    jad_an8 = jad_anVar2.jad_er.jad_an(jad_anVar2.jad_an.getSlotID(), com.jd.ad.sdk.jad_jt.jad_an.this.jad_an.getAdType(), jad_bo);
                    com.jd.ad.sdk.jad_xk.jad_fs.jad_an(str, 3, jad_cp, jad_an8, com.jd.ad.sdk.jad_jt.jad_an.this.jad_an.getSen());
                    return;
                }
                if (jad_mzVar.jad_bo() == null) {
                    com.jd.ad.sdk.logger.Logger.d("loadAd response body is null");
                    com.jd.ad.sdk.jad_jt.jad_an jad_anVar3 = com.jd.ad.sdk.jad_jt.jad_an.this;
                    com.jd.ad.sdk.jad_jt.jad_jt jad_jtVar = jad_anVar3.jad_er;
                    com.jd.ad.sdk.bl.adload.JADAdLoadListener jADAdLoadListener = jad_anVar3.jad_bo;
                    com.jd.ad.sdk.jad_wj.jad_an jad_anVar4 = com.jd.ad.sdk.jad_wj.jad_an.GW_RESPONSE_BODY_NULL_ERROR;
                    jad_jtVar.jad_an(jADAdLoadListener, jad_anVar4.jad_an(), jad_anVar4.jad_an(new java.lang.String[0]));
                    java.lang.String str2 = com.jd.ad.sdk.jad_jt.jad_an.this.jad_cp;
                    int jad_an9 = jad_anVar4.jad_an();
                    com.jd.ad.sdk.jad_jt.jad_an jad_anVar5 = com.jd.ad.sdk.jad_jt.jad_an.this;
                    jad_an7 = jad_anVar5.jad_er.jad_an(jad_anVar5.jad_an.getSlotID(), com.jd.ad.sdk.jad_jt.jad_an.this.jad_an.getAdType(), jad_anVar4.jad_an(new java.lang.String[0]));
                    com.jd.ad.sdk.jad_xk.jad_fs.jad_an(str2, 3, jad_an9, jad_an7, com.jd.ad.sdk.jad_jt.jad_an.this.jad_an.getSen());
                    return;
                }
                java.lang.String jad_bo2 = jad_mzVar.jad_bo().jad_bo();
                if (android.text.TextUtils.isEmpty(jad_bo2)) {
                    com.jd.ad.sdk.jad_jt.jad_an jad_anVar6 = com.jd.ad.sdk.jad_jt.jad_an.this;
                    com.jd.ad.sdk.jad_jt.jad_jt jad_jtVar2 = jad_anVar6.jad_er;
                    com.jd.ad.sdk.bl.adload.JADAdLoadListener jADAdLoadListener2 = jad_anVar6.jad_bo;
                    com.jd.ad.sdk.jad_wj.jad_an jad_anVar7 = com.jd.ad.sdk.jad_wj.jad_an.GW_RESPONSE_BODY_DATA_NULL_ERROR;
                    jad_jtVar2.jad_an(jADAdLoadListener2, jad_anVar7.jad_an(), jad_anVar7.jad_an(new java.lang.String[0]));
                    java.lang.String str3 = com.jd.ad.sdk.jad_jt.jad_an.this.jad_cp;
                    int jad_an10 = jad_anVar7.jad_an();
                    com.jd.ad.sdk.jad_jt.jad_an jad_anVar8 = com.jd.ad.sdk.jad_jt.jad_an.this;
                    jad_an6 = jad_anVar8.jad_er.jad_an(jad_anVar8.jad_an.getSlotID(), com.jd.ad.sdk.jad_jt.jad_an.this.jad_an.getAdType(), jad_anVar7.jad_an(new java.lang.String[0]));
                    com.jd.ad.sdk.jad_xk.jad_fs.jad_an(str3, 3, jad_an10, jad_an6, com.jd.ad.sdk.jad_jt.jad_an.this.jad_an.getSen());
                    return;
                }
                java.lang.String je = com.jd.ad.sdk.fdt.utils.ANEProxy.je(jad_bo2);
                com.jd.ad.sdk.logger.Logger.d("GW Data: " + je);
                if (android.text.TextUtils.isEmpty(je)) {
                    com.jd.ad.sdk.jad_jt.jad_an jad_anVar9 = com.jd.ad.sdk.jad_jt.jad_an.this;
                    com.jd.ad.sdk.jad_jt.jad_jt jad_jtVar3 = jad_anVar9.jad_er;
                    com.jd.ad.sdk.bl.adload.JADAdLoadListener jADAdLoadListener3 = jad_anVar9.jad_bo;
                    com.jd.ad.sdk.jad_wj.jad_an jad_anVar10 = com.jd.ad.sdk.jad_wj.jad_an.GW_RESPONSE_DES_ERROR_ERROR;
                    jad_jtVar3.jad_an(jADAdLoadListener3, jad_anVar10.jad_an(), jad_anVar10.jad_an(new java.lang.String[0]));
                    java.lang.String str4 = com.jd.ad.sdk.jad_jt.jad_an.this.jad_cp;
                    int jad_an11 = jad_anVar10.jad_an();
                    com.jd.ad.sdk.jad_jt.jad_an jad_anVar11 = com.jd.ad.sdk.jad_jt.jad_an.this;
                    jad_an5 = jad_anVar11.jad_er.jad_an(jad_anVar11.jad_an.getSlotID(), com.jd.ad.sdk.jad_jt.jad_an.this.jad_an.getAdType(), jad_anVar10.jad_an(new java.lang.String[0]));
                    com.jd.ad.sdk.jad_xk.jad_fs.jad_an(str4, 3, jad_an11, jad_an5, com.jd.ad.sdk.jad_jt.jad_an.this.jad_an.getSen());
                    return;
                }
                com.jd.ad.sdk.jad_yl.jad_jt jad_an12 = com.jd.ad.sdk.jad_yl.jad_jt.jad_an(je);
                if (jad_an12.jad_an() != 0) {
                    com.jd.ad.sdk.jad_jt.jad_an jad_anVar12 = com.jd.ad.sdk.jad_jt.jad_an.this;
                    jad_anVar12.jad_er.jad_an(jad_anVar12.jad_bo, jad_an12.jad_an(), jad_an12.jad_bo());
                    java.lang.String str5 = com.jd.ad.sdk.jad_jt.jad_an.this.jad_cp;
                    int jad_an13 = jad_an12.jad_an();
                    com.jd.ad.sdk.jad_jt.jad_an jad_anVar13 = com.jd.ad.sdk.jad_jt.jad_an.this;
                    jad_an4 = jad_anVar13.jad_er.jad_an(jad_anVar13.jad_an.getSlotID(), com.jd.ad.sdk.jad_jt.jad_an.this.jad_an.getAdType(), jad_an12.jad_bo());
                    com.jd.ad.sdk.jad_xk.jad_fs.jad_an(str5, 3, jad_an13, jad_an4, com.jd.ad.sdk.jad_jt.jad_an.this.jad_an.getSen());
                    return;
                }
                com.jd.ad.sdk.logger.Logger.d("【preload】缓存请求 - 成功");
                if (com.jd.ad.sdk.jad_jt.jad_an.this.jad_an.getAdDataRequestSourceType() == 1) {
                    com.jd.ad.sdk.logger.Logger.d("【preload】缓存 - 预加载广告数据");
                    com.jd.ad.sdk.jad_jt.jad_an jad_anVar14 = com.jd.ad.sdk.jad_jt.jad_an.this;
                    com.jd.ad.sdk.jad_jt.jad_jt.jad_an(jad_anVar14.jad_er, jad_anVar14.jad_an, je);
                } else {
                    if (com.jd.ad.sdk.jad_jt.jad_an.this.jad_an.getDynamicRenderTemplateHelper() != null) {
                        com.jd.ad.sdk.jad_jt.jad_an.this.jad_an.getDynamicRenderTemplateHelper().jad_an(je);
                    }
                    if (jad_an12.jad_cp() != null && jad_an12.jad_cp().jad_an() != null && jad_an12.jad_cp().jad_an().size() > 0 && (jad_dqVar = jad_an12.jad_cp().jad_an().get(0)) != null && jad_dqVar.jad_an() != null) {
                        com.jd.ad.sdk.jad_jt.jad_an.this.jad_an.setTemplateId(jad_dqVar.jad_an().jad_dq());
                        com.jd.ad.sdk.jad_jt.jad_an.this.jad_an.setMediaSpecSetType(jad_dqVar.jad_an().jad_cp());
                        com.jd.ad.sdk.jad_jt.jad_an.this.jad_an.setEventInteractionType(jad_dqVar.jad_an().jad_bo());
                        com.jd.ad.sdk.jad_jt.jad_an.this.jad_an.setModelClickAreaType(jad_dqVar.jad_an().jad_an());
                    }
                    com.jd.ad.sdk.jad_jt.jad_an jad_anVar15 = com.jd.ad.sdk.jad_jt.jad_an.this;
                    com.jd.ad.sdk.jad_jt.jad_jt.jad_an(jad_anVar15.jad_er, jad_anVar15.jad_dq, je);
                }
                com.jd.ad.sdk.jad_jt.jad_an jad_anVar16 = com.jd.ad.sdk.jad_jt.jad_an.this;
                com.jd.ad.sdk.jad_jt.jad_jt.jad_bo(jad_anVar16.jad_er, jad_anVar16.jad_an);
                com.jd.ad.sdk.fdt.utils.HandlerUtils.runOnUiThread(new com.jd.ad.sdk.jad_jt.jad_an.C0385jad_an.RunnableC0386jad_an());
            } catch (java.io.IOException e) {
                com.jd.ad.sdk.jad_jt.jad_an jad_anVar17 = com.jd.ad.sdk.jad_jt.jad_an.this;
                com.jd.ad.sdk.jad_jt.jad_jt jad_jtVar4 = jad_anVar17.jad_er;
                com.jd.ad.sdk.bl.adload.JADAdLoadListener jADAdLoadListener4 = jad_anVar17.jad_bo;
                com.jd.ad.sdk.jad_wj.jad_an jad_anVar18 = com.jd.ad.sdk.jad_wj.jad_an.GW_RESPONSE_DATA_IO_ERROR;
                jad_jtVar4.jad_an(jADAdLoadListener4, jad_anVar18.jad_an(), jad_anVar18.jad_an(new java.lang.String[0]));
                java.lang.String str6 = com.jd.ad.sdk.jad_jt.jad_an.this.jad_cp;
                int jad_an14 = jad_anVar18.jad_an();
                com.jd.ad.sdk.jad_jt.jad_an jad_anVar19 = com.jd.ad.sdk.jad_jt.jad_an.this;
                jad_an3 = jad_anVar19.jad_er.jad_an(jad_anVar19.jad_an.getSlotID(), com.jd.ad.sdk.jad_jt.jad_an.this.jad_an.getAdType(), jad_anVar18.jad_an(e.getMessage()));
                com.jd.ad.sdk.jad_xk.jad_fs.jad_an(str6, 3, jad_an14, jad_an3, com.jd.ad.sdk.jad_jt.jad_an.this.jad_an.getSen());
            } catch (org.json.JSONException e2) {
                com.jd.ad.sdk.jad_jt.jad_an jad_anVar20 = com.jd.ad.sdk.jad_jt.jad_an.this;
                com.jd.ad.sdk.jad_jt.jad_jt jad_jtVar5 = jad_anVar20.jad_er;
                com.jd.ad.sdk.bl.adload.JADAdLoadListener jADAdLoadListener5 = jad_anVar20.jad_bo;
                com.jd.ad.sdk.jad_wj.jad_an jad_anVar21 = com.jd.ad.sdk.jad_wj.jad_an.GW_RESPONSE_JSON_PARSER_ERROR;
                jad_jtVar5.jad_an(jADAdLoadListener5, jad_anVar21.jad_an(), jad_anVar21.jad_an(new java.lang.String[0]));
                java.lang.String str7 = com.jd.ad.sdk.jad_jt.jad_an.this.jad_cp;
                int jad_an15 = jad_anVar21.jad_an();
                com.jd.ad.sdk.jad_jt.jad_an jad_anVar22 = com.jd.ad.sdk.jad_jt.jad_an.this;
                jad_an2 = jad_anVar22.jad_er.jad_an(jad_anVar22.jad_an.getSlotID(), com.jd.ad.sdk.jad_jt.jad_an.this.jad_an.getAdType(), jad_anVar21.jad_an(e2.getMessage()));
                com.jd.ad.sdk.jad_xk.jad_fs.jad_an(str7, 3, jad_an15, jad_an2, com.jd.ad.sdk.jad_jt.jad_an.this.jad_an.getSen());
            } catch (java.lang.Exception e3) {
                com.jd.ad.sdk.jad_jt.jad_an jad_anVar23 = com.jd.ad.sdk.jad_jt.jad_an.this;
                com.jd.ad.sdk.jad_jt.jad_jt jad_jtVar6 = jad_anVar23.jad_er;
                com.jd.ad.sdk.bl.adload.JADAdLoadListener jADAdLoadListener6 = jad_anVar23.jad_bo;
                com.jd.ad.sdk.jad_wj.jad_an jad_anVar24 = com.jd.ad.sdk.jad_wj.jad_an.GW_RESPONSE_OTHER_ERROR;
                jad_jtVar6.jad_an(jADAdLoadListener6, jad_anVar24.jad_an(), jad_anVar24.jad_an(new java.lang.String[0]));
                java.lang.String str8 = com.jd.ad.sdk.jad_jt.jad_an.this.jad_cp;
                int jad_an16 = jad_anVar24.jad_an();
                com.jd.ad.sdk.jad_jt.jad_an jad_anVar25 = com.jd.ad.sdk.jad_jt.jad_an.this;
                jad_an = jad_anVar25.jad_er.jad_an(jad_anVar25.jad_an.getSlotID(), com.jd.ad.sdk.jad_jt.jad_an.this.jad_an.getAdType(), com.jd.ad.sdk.jad_wj.jad_an.GW_RESPONSE_DATA_IO_ERROR.jad_an(e3.getMessage()));
                com.jd.ad.sdk.jad_xk.jad_fs.jad_an(str8, 3, jad_an16, jad_an, com.jd.ad.sdk.jad_jt.jad_an.this.jad_an.getSen());
            }
        }
    }

    public jad_an(com.jd.ad.sdk.jad_jt.jad_jt jad_jtVar, com.jd.ad.sdk.dl.model.JADSlot jADSlot, com.jd.ad.sdk.bl.adload.JADAdLoadListener jADAdLoadListener, java.lang.String str, java.lang.String str2) {
        this.jad_er = jad_jtVar;
        this.jad_an = jADSlot;
        this.jad_bo = jADAdLoadListener;
        this.jad_cp = str;
        this.jad_dq = str2;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.jd.ad.sdk.jad_jt.jad_jt.jad_an(this.jad_er, this.jad_an);
        com.jd.ad.sdk.jad_pc.jad_cp jad_cp = com.jd.ad.sdk.jad_re.jad_an.jad_cp();
        java.lang.String jad_an = com.jd.ad.sdk.jad_jt.jad_hu.jad_an(jad_cp, this.jad_an.getSlotID());
        com.jd.ad.sdk.logger.Logger.d("loadAd URl: " + jad_an);
        if (android.text.TextUtils.isEmpty(jad_an)) {
            com.jd.ad.sdk.jad_jt.jad_jt jad_jtVar = this.jad_er;
            com.jd.ad.sdk.bl.adload.JADAdLoadListener jADAdLoadListener = this.jad_bo;
            com.jd.ad.sdk.jad_wj.jad_an jad_anVar = com.jd.ad.sdk.jad_wj.jad_an.GW_REQUEST_URL_IS_NULL_ERROR;
            jad_jtVar.jad_an(jADAdLoadListener, jad_anVar.jad_an, jad_anVar.jad_an(new java.lang.String[0]));
            com.jd.ad.sdk.jad_xk.jad_fs.jad_an(this.jad_cp, 7, jad_anVar.jad_an, this.jad_er.jad_an(this.jad_an.getSlotID(), this.jad_an.getAdType(), jad_anVar.jad_an(new java.lang.String[0])), 0);
            return;
        }
        com.jd.ad.sdk.jad_zm.jad_er jad_erVar = new com.jd.ad.sdk.jad_zm.jad_er(com.jd.ad.sdk.jad_jt.jad_hu.jad_bo(this.jad_an));
        com.jd.ad.sdk.jad_zm.jad_fs jad_fsVar = new com.jd.ad.sdk.jad_zm.jad_fs();
        jad_fsVar.jad_bo("User-Agent", com.jd.ad.sdk.jad_qd.jad_hu.jad_dq());
        jad_fsVar.jad_bo("Content-Type", "application/stream");
        this.jad_er.getClass();
        com.jd.ad.sdk.jad_pc.jad_an jad_an2 = com.jd.ad.sdk.jad_re.jad_an.jad_an();
        if (jad_an2 == null || !"1".equals(jad_an2.jad_bo)) {
            jad_fsVar.jad_an("sdkxid", "default");
        }
        com.jd.ad.sdk.jad_zm.jad_ly.jad_bo jad_an3 = com.jd.ad.sdk.jad_zm.jad_bo.jad_an();
        jad_an3.jad_er = jad_an;
        jad_an3.jad_fs = jad_erVar;
        jad_an3.jad_bo = jad_fsVar;
        jad_an3.jad_cp = jad_cp == null ? 5000 : (int) jad_cp.jad_dq;
        jad_an3.jad_dq = jad_cp != null ? (int) jad_cp.jad_dq : 5000;
        jad_an3.jad_jt = new com.jd.ad.sdk.jad_jt.jad_an.C0385jad_an();
        com.jd.ad.sdk.jad_jt.jad_jt jad_jtVar2 = this.jad_er;
        com.jd.ad.sdk.dl.model.JADSlot jADSlot = this.jad_an;
        jad_jtVar2.getClass();
        if (jADSlot != null) {
            long currentTimeMillis = java.lang.System.currentTimeMillis() - jADSlot.getLoadTime();
            java.lang.String requestId = jADSlot.getRequestId();
            java.lang.String slotID = jADSlot.getSlotID();
            int adType = jADSlot.getAdType();
            int sen = jADSlot.getSen();
            int rem = jADSlot.getRem();
            int width = (int) jADSlot.getWidth();
            int height = (int) jADSlot.getHeight();
            if (rem == 2) {
                width = (int) jADSlot.getAdImageWidth();
                height = (int) jADSlot.getAdImageHeight();
            }
            int i = width;
            int i2 = height;
            int templateId = jADSlot.getTemplateId();
            int ds = com.jd.ad.sdk.mdt.servicemediator.JADMediator.getInstance().getInitService().getDs(jADSlot.getSlotID());
            int r = com.jd.ad.sdk.mdt.servicemediator.JADMediator.getInstance().getInitService().getR(jADSlot.getSlotID());
            double floatToDouble = (jADSlot.isFromNativeAd() || adType != 1) ? 0.0d : com.jd.ad.sdk.fdt.utils.ConversionUtils.floatToDouble(jADSlot.getTolerateTime());
            if (jADSlot.getAdDataRequestSourceType() == 1 || jADSlot.getAdDataRequestSourceType() == 2) {
                com.jd.ad.sdk.jad_xk.jad_fs.jad_an(requestId, slotID, 1, adType, sen, i2, i, templateId, rem, currentTimeMillis, ds, r, 1, floatToDouble);
            } else {
                com.jd.ad.sdk.jad_xk.jad_fs.jad_an(requestId, slotID, 1, adType, sen, i2, i, templateId, rem, currentTimeMillis, ds, r, 0, floatToDouble);
            }
        }
        jad_an3.jad_an(com.jd.ad.sdk.jad_ep.jad_bo.jad_an);
    }
}
