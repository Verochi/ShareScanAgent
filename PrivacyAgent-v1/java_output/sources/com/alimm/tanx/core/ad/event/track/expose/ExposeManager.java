package com.alimm.tanx.core.ad.event.track.expose;

/* loaded from: classes.dex */
public class ExposeManager {
    private final com.alimm.tanx.core.ad.event.track.expose.IExposer tanxc_do;
    private final java.util.List<java.lang.String> tanxc_if;

    /* renamed from: com.alimm.tanx.core.ad.event.track.expose.ExposeManager$1, reason: invalid class name */
    public class AnonymousClass1 implements com.alimm.tanx.core.net.callback.NetWorkCallBack {
        final /* synthetic */ com.tanx.exposer.tanxc_do.tanxc_int.tanxc_if tanxc_do;

        public AnonymousClass1(com.tanx.exposer.tanxc_do.tanxc_int.tanxc_if tanxc_ifVar) {
            this.tanxc_do = tanxc_ifVar;
        }

        @Override // com.alimm.tanx.core.net.callback.NetWorkCallBack
        public void error(int i, java.lang.String str, java.lang.String str2) {
            com.alimm.tanx.core.utils.LogUtils.d("ExposeManager", str2);
            com.tanx.exposer.tanxc_do.tanxc_int.tanxc_if tanxc_ifVar = this.tanxc_do;
            if (tanxc_ifVar != null) {
                tanxc_ifVar.tanxc_do(i, str2);
            }
        }

        @Override // com.alimm.tanx.core.net.callback.NetWorkCallBack
        public void succ(java.lang.Object obj) {
            com.alimm.tanx.core.utils.LogUtils.d("ExposeManager", com.alibaba.fastjson.JSON.toJSONString(obj));
            com.tanx.exposer.tanxc_do.tanxc_int.tanxc_if tanxc_ifVar = this.tanxc_do;
            if (tanxc_ifVar != null) {
                tanxc_ifVar.tanxc_do();
            }
        }
    }

    /* renamed from: com.alimm.tanx.core.ad.event.track.expose.ExposeManager$2, reason: invalid class name */
    public class AnonymousClass2 implements com.tanx.exposer.achieve.tanxc_do.tanxc_do {
        public AnonymousClass2() {
        }

        @Override // com.tanx.exposer.achieve.tanxc_do.tanxc_do
        public android.os.Looper tanxc_do() {
            return android.os.Looper.getMainLooper();
        }

        @Override // com.tanx.exposer.achieve.tanxc_do.tanxc_do
        public void tanxc_do(int i, java.lang.String str, java.lang.String str2, com.tanx.exposer.achieve.AdMonitorType adMonitorType, com.tanx.exposer.tanxc_if tanxc_ifVar) {
            if (tanxc_ifVar != null) {
                com.alimm.tanx.core.utils.LogUtils.d("ExposeManager", "onExposeTempFail:url=" + str2 + ";exposeParams=" + tanxc_ifVar.toString() + ";msg=" + str + ";code=" + i);
                com.alimm.tanx.core.ut.impl.TanxExposerUt.sendMonitorFail(adMonitorType, str2, i, str, tanxc_ifVar.tanxc_do());
            }
        }

        @Override // com.tanx.exposer.achieve.tanxc_do.tanxc_do
        public void tanxc_do(java.lang.String str, com.tanx.exposer.achieve.AdMonitorType adMonitorType, com.tanx.exposer.tanxc_if tanxc_ifVar) {
            if (tanxc_ifVar != null) {
                com.alimm.tanx.core.utils.LogUtils.d("ExposeManager", "onExposeSuccess:url=" + str + ";exposeParams=" + tanxc_ifVar.toString());
                com.alimm.tanx.core.ut.impl.TanxExposerUt.sendMonitorSuc(adMonitorType, str, tanxc_ifVar.tanxc_do());
            }
        }

        @Override // com.tanx.exposer.achieve.tanxc_do.tanxc_do
        public void tanxc_if(int i, java.lang.String str, java.lang.String str2, com.tanx.exposer.achieve.AdMonitorType adMonitorType, com.tanx.exposer.tanxc_if tanxc_ifVar) {
            if (tanxc_ifVar != null) {
                com.alimm.tanx.core.utils.LogUtils.d("ExposeManager", "onExposeTempFail:url=" + str2 + ";exposeParams=" + tanxc_ifVar.toString() + ";msg=" + str + ";code=" + i);
                com.alimm.tanx.core.ut.impl.TanxExposerUt.sendMonitorFail(adMonitorType, str2, i, str, tanxc_ifVar.tanxc_do());
            }
        }
    }

    /* renamed from: com.alimm.tanx.core.ad.event.track.expose.ExposeManager$3, reason: invalid class name */
    public class AnonymousClass3 implements com.alimm.tanx.core.ad.event.track.expose.ExposeCallback {
        final /* synthetic */ com.alimm.tanx.core.ad.event.track.expose.ExposeCallback tanxc_do;
        final /* synthetic */ com.alimm.tanx.core.ad.event.track.expose.tanxc_if tanxc_if;

        public AnonymousClass3(com.alimm.tanx.core.ad.event.track.expose.ExposeCallback exposeCallback, com.alimm.tanx.core.ad.event.track.expose.tanxc_if tanxc_ifVar) {
            this.tanxc_do = exposeCallback;
            this.tanxc_if = tanxc_ifVar;
        }

        @Override // com.alimm.tanx.core.ad.event.track.expose.ExposeCallback
        public void onFail(int i, java.lang.String str, java.lang.String str2) {
            com.alimm.tanx.core.ad.event.track.expose.ExposeManager.this.tanxc_if.remove(str2);
            this.tanxc_if.tanxc_new();
            com.alimm.tanx.core.ad.event.track.expose.ExposeCallback exposeCallback = this.tanxc_do;
            if (exposeCallback != null) {
                exposeCallback.onFail(i, str, str2);
            }
        }

        @Override // com.alimm.tanx.core.ad.event.track.expose.ExposeCallback
        public void onSucceed(int i, java.lang.String str) {
            this.tanxc_if.tanxc_do(true);
            com.alimm.tanx.core.ad.event.track.expose.ExposeManager.this.tanxc_if.remove(str);
            com.alimm.tanx.core.ad.event.track.expose.ExposeCallback exposeCallback = this.tanxc_do;
            if (exposeCallback != null) {
                exposeCallback.onSucceed(i, str);
            }
        }

        @Override // com.alimm.tanx.core.ad.event.track.expose.ExposeCallback
        public void send(java.lang.String str) {
            com.alimm.tanx.core.ad.event.track.expose.ExposeCallback exposeCallback = this.tanxc_do;
            if (exposeCallback != null) {
                exposeCallback.send(str);
            }
        }
    }

    public interface UtArgsNames {
        public static final java.lang.String creativeId = "creative_id";
        public static final java.lang.String interactType = "interact_type";
        public static final java.lang.String nameSpace = "tanx";
        public static final java.lang.String pid = "pid";
        public static final java.lang.String reqId = "req_id";
        public static final java.lang.String sessionId = "session_id";
        public static final java.lang.String templateId = "template_id";
    }

    public static class tanxc_do {
        static volatile com.alimm.tanx.core.ad.event.track.expose.ExposeManager tanxc_do = new com.alimm.tanx.core.ad.event.track.expose.ExposeManager((byte) 0);
    }

    private ExposeManager() {
        this.tanxc_do = new com.alimm.tanx.core.ad.event.track.expose.tanxc_do();
        this.tanxc_if = new java.util.ArrayList();
    }

    public /* synthetic */ ExposeManager(byte b) {
        this();
    }

    public static com.alimm.tanx.core.ad.event.track.expose.ExposeManager tanxc_do() {
        return com.alimm.tanx.core.ad.event.track.expose.ExposeManager.tanxc_do.tanxc_do;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void tanxc_do(com.tanx.exposer.tanxc_do.tanxc_int.tanxc_int tanxc_intVar, com.tanx.exposer.tanxc_do.tanxc_int.tanxc_if tanxc_ifVar) {
        if (tanxc_intVar == null) {
            com.alimm.tanx.core.utils.LogUtils.d("ExposeManager", "requestOptions is null");
            return;
        }
        com.alimm.tanx.core.net.bean.RequestBean build = new com.alimm.tanx.core.net.bean.RequestBean().setUrl(tanxc_intVar.tanxc_do()).build();
        build.setOverrideError(true);
        build.setTryAgainCount(tanxc_intVar.tanxc_if());
        com.alimm.tanx.core.net.NetWorkManager.getInstance().sendHttpGet(build, java.lang.Object.class, false, false, new com.alimm.tanx.core.ad.event.track.expose.ExposeManager.AnonymousClass1(tanxc_ifVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void tanxc_do(java.lang.String str, int i, java.lang.Object obj, java.lang.Object obj2, java.lang.Object obj3, java.util.Map map) {
        com.alimm.tanx.core.utils.LogUtils.d("ExposeManager", "userTracker:page=" + str + ";eventId=" + i + ";arg1=" + obj + ";args" + com.tanx.exposer.tanxc_if.tanxc_if.tanxc_do((java.util.Map<java.lang.String, java.lang.Object>) map));
        if (tanxc_if()) {
            com.alimm.tanx.core.ut.impl.TanxBaseUt.track(str, null, null, i, 0, (java.lang.String) obj, (java.lang.String) obj2, (java.lang.String) obj3, map, null);
        } else {
            com.alimm.tanx.core.utils.LogUtils.d("ExposeManager", "埋点开关关闭，终止上报");
        }
    }

    private static boolean tanxc_if() {
        com.alimm.tanx.core.orange.bean.OrangeUtBean orangeUtBean;
        java.lang.Boolean bool;
        com.alimm.tanx.core.orange.bean.OrangeBean orangeBean = com.alimm.tanx.core.orange.OrangeManager.getInstance().getOrangeBean();
        if (orangeBean == null || (orangeUtBean = orangeBean.ut) == null || (bool = orangeUtBean.utTanxExposerSwitch) == null) {
            return false;
        }
        return bool.booleanValue();
    }

    public void tanxc_do(android.content.Context context) {
        com.tanx.exposer.tanxc_for.tanxc_do().tanxc_do(context, new com.tanx.exposer.tanxc_do.C0492tanxc_do(new defpackage.na0(this), new defpackage.oa0()).tanxc_do(2001).tanxc_if(true).tanxc_do(true).tanxc_do(com.tanx.exposer.tanxc_if.tanxc_if.tanxc_if(context), com.tanx.exposer.tanxc_if.tanxc_if.tanxc_do(context)).tanxc_for(com.alimm.tanx.core.TanxCoreSdk.getConfig().isDebugMode()).tanxc_do());
        com.tanx.exposer.tanxc_for.tanxc_do().tanxc_do(new com.alimm.tanx.core.ad.event.track.expose.ExposeManager.AnonymousClass2());
    }

    public void tanxc_do(com.alimm.tanx.core.ad.bean.BidInfo bidInfo, java.lang.String str, java.lang.String str2, com.tanx.exposer.achieve.AdMonitorType adMonitorType, java.util.List<com.alimm.tanx.core.ad.event.track.expose.tanxc_if> list, com.alimm.tanx.core.ad.event.track.expose.ExposeCallback exposeCallback) {
        if (!com.alimm.tanx.core.orange.OrangeManager.getInstance().getCommonSwitch("useNewExposerSwitch")) {
            tanxc_do(bidInfo, list, exposeCallback);
            return;
        }
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            jSONObject.put("pid", str2);
            jSONObject.put(com.alimm.tanx.core.ad.event.track.expose.ExposeManager.UtArgsNames.reqId, str);
            jSONObject.put("session_id", bidInfo.getSessionId());
            jSONObject.put(com.alimm.tanx.core.ad.event.track.expose.ExposeManager.UtArgsNames.templateId, bidInfo.getTemplateId());
            jSONObject.put("creative_id", bidInfo.getCreativeId());
            jSONObject.put(com.alimm.tanx.core.ad.event.track.expose.ExposeManager.UtArgsNames.interactType, bidInfo.getInteractType2Int());
            com.tanx.exposer.tanxc_if tanxc_do2 = new com.tanx.exposer.tanxc_if.tanxc_do().tanxc_do(com.alimm.tanx.core.ad.event.track.expose.ExposeManager.UtArgsNames.nameSpace).tanxc_if(str2).tanxc_do(jSONObject).tanxc_do();
            if (adMonitorType == com.tanx.exposer.achieve.AdMonitorType.EXPOSE) {
                com.tanx.exposer.tanxc_for.tanxc_do().tanxc_do(bidInfo.getImpTrackUrl(), tanxc_do2);
            } else if (adMonitorType == com.tanx.exposer.achieve.AdMonitorType.CLICK) {
                com.tanx.exposer.tanxc_for.tanxc_do().tanxc_if(bidInfo.getClickTrackUrl(), tanxc_do2);
            }
        } catch (org.json.JSONException e) {
            e.printStackTrace();
        }
    }

    public void tanxc_do(com.alimm.tanx.core.ad.bean.BidInfo bidInfo, java.lang.String str, java.lang.String str2, java.util.List<java.lang.String> list) {
        try {
            com.alimm.tanx.core.utils.LogUtils.d("ExposeManager", "exposeVideo3S ing reqId:" + str + " pid :" + str);
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            jSONObject.put("pid", str2);
            jSONObject.put(com.alimm.tanx.core.ad.event.track.expose.ExposeManager.UtArgsNames.reqId, str);
            jSONObject.put("session_id", bidInfo.getSessionId());
            jSONObject.put(com.alimm.tanx.core.ad.event.track.expose.ExposeManager.UtArgsNames.templateId, bidInfo.getTemplateId());
            jSONObject.put("creative_id", bidInfo.getCreativeId());
            jSONObject.put(com.alimm.tanx.core.ad.event.track.expose.ExposeManager.UtArgsNames.interactType, bidInfo.getInteractType2Int());
            com.tanx.exposer.tanxc_for.tanxc_do().tanxc_for(list, new com.tanx.exposer.tanxc_if.tanxc_do().tanxc_do(com.alimm.tanx.core.ad.event.track.expose.ExposeManager.UtArgsNames.nameSpace).tanxc_if(str2).tanxc_do(jSONObject).tanxc_do());
        } catch (org.json.JSONException e) {
            e.printStackTrace();
        }
    }

    public void tanxc_do(com.alimm.tanx.core.ad.listener.bean.IBidInfo iBidInfo, java.util.List<com.alimm.tanx.core.ad.event.track.expose.tanxc_if> list, com.alimm.tanx.core.ad.event.track.expose.ExposeCallback exposeCallback) {
        if (iBidInfo != null && list != null) {
            for (int i = 0; i < list.size(); i++) {
                com.alimm.tanx.core.ad.event.track.expose.tanxc_if tanxc_ifVar = list.get(i);
                if (tanxc_ifVar != null) {
                    java.lang.String tanxc_do2 = tanxc_ifVar.tanxc_do();
                    if (tanxc_ifVar.tanxc_int()) {
                        if (!tanxc_ifVar.tanxc_for() && !tanxc_ifVar.tanxc_try() && !this.tanxc_if.contains(tanxc_do2)) {
                            this.tanxc_if.add(tanxc_do2);
                        }
                    }
                    this.tanxc_do.onExpose(tanxc_ifVar.tanxc_if(), tanxc_do2, new com.alimm.tanx.core.ad.event.track.expose.ExposeManager.AnonymousClass3(exposeCallback, tanxc_ifVar));
                }
            }
            return;
        }
        java.lang.String str = "";
        java.lang.String str2 = iBidInfo == null ? " bidInfo == null" : "";
        if (list == null) {
            str2 = str2 + " monitorInfoList == null";
        } else if (list.size() <= 0) {
            str2 = str2 + " monitorInfoList size <= 0";
        } else {
            str = list.toString();
        }
        if (exposeCallback != null) {
            exposeCallback.onFail(com.alimm.tanx.core.ut.UtErrorCode.IMP_URL_ERROR.getIntCode(), str2, str);
        }
    }
}
