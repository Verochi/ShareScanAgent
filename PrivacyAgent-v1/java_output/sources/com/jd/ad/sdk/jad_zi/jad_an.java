package com.jd.ad.sdk.jad_zi;

/* loaded from: classes23.dex */
public class jad_an implements com.jd.ad.sdk.mdt.service.JADAdService {
    public final java.util.concurrent.ConcurrentHashMap<java.lang.String, com.jd.ad.sdk.jad_jt.jad_jt> jad_an = new java.util.concurrent.ConcurrentHashMap<>();
    public final java.util.concurrent.ConcurrentHashMap<java.lang.String, java.util.ArrayList<com.jd.ad.sdk.jad_jt.jad_jt>> jad_bo = new java.util.concurrent.ConcurrentHashMap<>();

    @Override // com.jd.ad.sdk.mdt.service.JADAdService
    public boolean enablePreloadAd(@androidx.annotation.NonNull java.lang.String str, @androidx.annotation.NonNull com.jd.ad.sdk.dl.model.JADSlot jADSlot) {
        if (this.jad_an.get(str) == null) {
            return false;
        }
        java.util.ArrayList<com.jd.ad.sdk.jad_jt.jad_jt> arrayList = this.jad_bo.get(jADSlot.getSlotID());
        return arrayList == null || arrayList.size() < com.jd.ad.sdk.jad_kx.jad_er.jad_an.jad_an.jad_an();
    }

    @Override // com.jd.ad.sdk.mdt.service.JADAdService
    public com.jd.ad.sdk.dl.model.IJADExtra getJADExtra(@androidx.annotation.NonNull java.lang.String str) {
        com.jd.ad.sdk.dl.model.IJADExtra iJADExtra = com.jd.ad.sdk.jad_na.jad_cp.jad_an.jad_an.jad_bo.get(str);
        return iJADExtra == null ? new com.jd.ad.sdk.dl.model.JADExtra() : iJADExtra;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x005f  */
    @Override // com.jd.ad.sdk.mdt.service.JADAdService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public java.util.List<com.jd.ad.sdk.dl.addata.JADMaterialData> getJADMaterialDataList(@androidx.annotation.NonNull java.lang.String str) {
        com.jd.ad.sdk.jad_yl.jad_jt jad_an;
        java.util.List<com.jd.ad.sdk.jad_yl.jad_fs> list;
        com.jd.ad.sdk.jad_yl.jad_hu jad_huVar;
        java.util.List<com.jd.ad.sdk.jad_yl.jad_dq> list2;
        com.jd.ad.sdk.jad_yl.jad_dq jad_dqVar;
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.lang.String str2 = com.jd.ad.sdk.jad_na.jad_cp.jad_an.jad_an.jad_an.get(str);
        if (android.text.TextUtils.isEmpty(str2)) {
            str2 = "";
        }
        com.jd.ad.sdk.jad_yl.jad_cp jad_cpVar = null;
        if (!android.text.TextUtils.isEmpty(str2)) {
            try {
                jad_an = com.jd.ad.sdk.jad_yl.jad_jt.jad_an(str2);
            } catch (org.json.JSONException e) {
                e.printStackTrace();
            }
            if (jad_an != null && (jad_huVar = jad_an.jad_cp) != null && (list2 = jad_huVar.jad_an) != null && !list2.isEmpty() && (jad_dqVar = list2.get(0)) != null) {
                jad_cpVar = jad_dqVar.jad_bo;
            }
            if (jad_cpVar != null && (list = jad_cpVar.jad_an) != null && !list.isEmpty()) {
                for (com.jd.ad.sdk.jad_yl.jad_fs jad_fsVar : list) {
                    if (jad_fsVar != null) {
                        com.jd.ad.sdk.jad_na.jad_an jad_anVar = new com.jd.ad.sdk.jad_na.jad_an();
                        jad_anVar.jad_an = jad_fsVar.jad_an;
                        jad_anVar.jad_bo = jad_fsVar.jad_bo;
                        jad_anVar.jad_dq = jad_fsVar.jad_iv;
                        jad_anVar.jad_fs = jad_fsVar.jad_mz;
                        jad_anVar.jad_jt = jad_fsVar.jad_ly;
                        jad_anVar.jad_hu = jad_cpVar.jad_cp;
                        jad_anVar.jad_iv = jad_cpVar.jad_er;
                        jad_anVar.jad_kx = jad_fsVar.jad_hu;
                        jad_anVar.jad_jw = jad_fsVar.jad_jt;
                        jad_anVar.jad_er = jad_fsVar.jad_na;
                        jad_anVar.jad_ob = jad_fsVar.jad_re;
                        jad_anVar.jad_pc = jad_fsVar.jad_sf;
                        jad_anVar.jad_ly = jad_fsVar.jad_ob;
                        jad_anVar.jad_mz = jad_fsVar.jad_pc;
                        jad_anVar.jad_na = jad_fsVar.jad_qd;
                        java.util.ArrayList arrayList2 = new java.util.ArrayList();
                        if (android.text.TextUtils.isEmpty(jad_fsVar.jad_er) || jad_cpVar.jad_cp == 10005) {
                            java.util.List<com.jd.ad.sdk.jad_yl.jad_er> list3 = jad_fsVar.jad_fs;
                            if (list3 != null && !list3.isEmpty()) {
                                for (com.jd.ad.sdk.jad_yl.jad_er jad_erVar : list3) {
                                    if (jad_erVar != null && !android.text.TextUtils.isEmpty(jad_erVar.jad_an)) {
                                        arrayList2.add(jad_erVar.jad_an);
                                    }
                                }
                            }
                        } else {
                            arrayList2.add(jad_fsVar.jad_er);
                        }
                        jad_anVar.jad_cp = arrayList2;
                        arrayList.add(jad_anVar);
                    }
                }
            }
            return arrayList;
        }
        jad_an = null;
        if (jad_an != null) {
            jad_cpVar = jad_dqVar.jad_bo;
        }
        if (jad_cpVar != null) {
            while (r8.hasNext()) {
            }
        }
        return arrayList;
    }

    @Override // com.jd.ad.sdk.mdt.service.JADAdService
    public void loadAd(@androidx.annotation.NonNull java.lang.String str, @androidx.annotation.NonNull com.jd.ad.sdk.dl.model.JADSlot jADSlot, @androidx.annotation.NonNull com.jd.ad.sdk.bl.adload.JADAdLoadListener jADAdLoadListener) {
        com.jd.ad.sdk.jad_jt.jad_jt jad_jtVar = this.jad_an.get(str);
        if (jad_jtVar == null) {
            com.jd.ad.sdk.mdt.service.JADEventService eventService = com.jd.ad.sdk.mdt.servicemediator.JADMediator.getInstance().getEventService();
            java.lang.String requestId = jADSlot.getRequestId();
            com.jd.ad.sdk.jad_wj.jad_an jad_anVar = com.jd.ad.sdk.jad_wj.jad_an.GW_REQUEST_REGISTER_AD_SERVICE_ERROR;
            eventService.reportRequestErrorEvent(requestId, jad_anVar.jad_an, jad_anVar.jad_an(new java.lang.String[0]));
            jADAdLoadListener.onLoadFailure(jad_anVar.jad_an, jad_anVar.jad_an(new java.lang.String[0]));
            return;
        }
        java.lang.String requestId2 = jADSlot.getRequestId();
        try {
            if (jADSlot.getAdDataRequestSourceType() == 0) {
                if (jad_jtVar.jad_an == 2) {
                    return;
                }
            } else if (!com.jd.ad.sdk.mdt.servicemediator.JADMediator.getInstance().getAdService().enablePreloadAd(str, jADSlot)) {
                return;
            } else {
                com.jd.ad.sdk.mdt.servicemediator.JADMediator.getInstance().getAdService().registerAdPreloader(str, jADSlot);
            }
            if (jad_jtVar.jad_an(jADSlot, jADAdLoadListener)) {
                com.jd.ad.sdk.fdt.thread.WorkExecutor.execute(new com.jd.ad.sdk.jad_jt.jad_an(jad_jtVar, jADSlot, jADAdLoadListener, requestId2, str));
            }
        } catch (java.lang.Exception e) {
            com.jd.ad.sdk.jad_wj.jad_an jad_anVar2 = com.jd.ad.sdk.jad_wj.jad_an.GW_REQUEST_OTHER_ERROR;
            jad_jtVar.jad_an(jADAdLoadListener, jad_anVar2.jad_an, jad_anVar2.jad_an(new java.lang.String[0]));
            com.jd.ad.sdk.jad_xk.jad_fs.jad_an(requestId2, 3, jad_anVar2.jad_an, jad_jtVar.jad_an(jADSlot.getSlotID(), jADSlot.getAdType(), jad_anVar2.jad_an(e.getMessage())), jADSlot.getSen());
        }
    }

    @Override // com.jd.ad.sdk.mdt.service.JADAdService
    public void loadAdFromCache(@androidx.annotation.NonNull java.lang.String str, @androidx.annotation.NonNull com.jd.ad.sdk.dl.model.JADSlot jADSlot, @androidx.annotation.NonNull com.jd.ad.sdk.bl.adload.JADAdLoadListener jADAdLoadListener) {
        com.jd.ad.sdk.jad_jt.jad_jt jad_jtVar = this.jad_an.get(str);
        if (jad_jtVar == null || jADSlot == null) {
            return;
        }
        try {
            if (jad_jtVar.jad_an == 1) {
                return;
            }
            jADSlot.setAdDataRequestSourceType(2);
            com.jd.ad.sdk.fdt.thread.WorkExecutor.execute(new com.jd.ad.sdk.jad_jt.jad_bo(jad_jtVar, jADSlot, str, jADAdLoadListener));
        } catch (java.lang.Exception e) {
            java.lang.StringBuilder jad_an = com.jd.ad.sdk.jad_bo.jad_bo.jad_an("Exception while preload ad load from cache failed:");
            jad_an.append(android.util.Log.getStackTraceString(e));
            com.jd.ad.sdk.logger.Logger.d(jad_an.toString());
        }
    }

    @Override // com.jd.ad.sdk.mdt.service.JADAdService
    public synchronized void printRequestData(@androidx.annotation.NonNull com.jd.ad.sdk.dl.model.JADSlot jADSlot) {
        java.lang.String str;
        if (com.jd.ad.sdk.bl.initsdk.JADYunSdk.isEnableLog()) {
            java.lang.String adUrl = com.jd.ad.sdk.mdt.servicemediator.JADMediator.getInstance().getInitService().getAdUrl(jADSlot.getSlotID());
            byte[] jad_bo = com.jd.ad.sdk.jad_jt.jad_hu.jad_bo(jADSlot);
            if (jad_bo != null) {
                java.lang.String str2 = new java.lang.String(jad_bo);
                if (!android.text.TextUtils.isEmpty(str2)) {
                    java.util.HashMap hashMap = new java.util.HashMap(3);
                    hashMap.put("Content-Type", com.baidu.mobads.sdk.internal.am.d);
                    hashMap.put("User-Agent", com.jd.ad.sdk.jad_qd.jad_hu.jad_dq());
                    hashMap.put("sdkxid", "default");
                    if (!android.text.TextUtils.isEmpty(adUrl) && !android.text.TextUtils.isEmpty(str2)) {
                        java.lang.StringBuilder sb = new java.lang.StringBuilder();
                        sb.append("curl -v ");
                        for (java.util.Map.Entry entry : hashMap.entrySet()) {
                            sb.append("-H '" + ((java.lang.String) entry.getKey()) + ": " + ((java.lang.String) entry.getValue()) + "' ");
                        }
                        sb.append("-d '" + str2 + "' ");
                        sb.append("'" + adUrl + "'");
                        str = sb.toString();
                        com.jd.ad.sdk.logger.Logger.w(str, new java.lang.Object[0]);
                    }
                    com.jd.ad.sdk.logger.Logger.w("url or requestData is empty", new java.lang.Object[0]);
                    str = "";
                    com.jd.ad.sdk.logger.Logger.w(str, new java.lang.Object[0]);
                }
            }
        }
    }

    @Override // com.jd.ad.sdk.mdt.service.JADAdService
    public void registerAd(java.lang.String str) {
        if (this.jad_an.get(str) == null) {
            this.jad_an.put(str, new com.jd.ad.sdk.jad_jt.jad_jt());
        }
    }

    @Override // com.jd.ad.sdk.mdt.service.JADAdService
    public void registerAdPreloader(@androidx.annotation.NonNull java.lang.String str, @androidx.annotation.NonNull com.jd.ad.sdk.dl.model.JADSlot jADSlot) {
        com.jd.ad.sdk.jad_jt.jad_jt jad_jtVar = this.jad_an.get(str);
        if (jad_jtVar != null) {
            java.util.ArrayList<com.jd.ad.sdk.jad_jt.jad_jt> arrayList = this.jad_bo.get(jADSlot.getSlotID());
            if (arrayList == null) {
                arrayList = new java.util.ArrayList<>();
            }
            arrayList.add(jad_jtVar);
            this.jad_bo.put(jADSlot.getSlotID(), arrayList);
        }
    }

    @Override // com.jd.ad.sdk.mdt.service.JADAdService
    public void removeData(@androidx.annotation.NonNull java.lang.String str) {
        com.jd.ad.sdk.jad_na.jad_cp jad_cpVar = com.jd.ad.sdk.jad_na.jad_cp.jad_an.jad_an;
        jad_cpVar.jad_an.remove(str);
        jad_cpVar.jad_bo.remove(str);
    }

    @Override // com.jd.ad.sdk.mdt.service.JADAdService
    public void unregisterAd(@androidx.annotation.NonNull java.lang.String str) {
        if (this.jad_an.get(str) == null) {
            return;
        }
        this.jad_an.remove(str);
    }

    @Override // com.jd.ad.sdk.mdt.service.JADAdService
    public void unregisterAdPreloader(@androidx.annotation.NonNull java.lang.String str, @androidx.annotation.NonNull com.jd.ad.sdk.dl.model.JADSlot jADSlot) {
        java.util.ArrayList<com.jd.ad.sdk.jad_jt.jad_jt> arrayList;
        com.jd.ad.sdk.jad_jt.jad_jt jad_jtVar = this.jad_an.get(str);
        if (jad_jtVar == null || (arrayList = this.jad_bo.get(jADSlot.getSlotID())) == null || arrayList.size() <= 0) {
            return;
        }
        arrayList.remove(jad_jtVar);
        this.jad_bo.put(jADSlot.getSlotID(), arrayList);
    }
}
