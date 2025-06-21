package com.alimm.tanx.core.ad.event.track.expose;

/* loaded from: classes.dex */
public class tanxc_do implements com.alimm.tanx.core.ad.event.track.expose.IExposer {

    /* renamed from: com.alimm.tanx.core.ad.event.track.expose.tanxc_do$1, reason: invalid class name */
    public class AnonymousClass1 implements com.alimm.tanx.core.net.callback.NetWorkCallBack {
        final /* synthetic */ java.lang.String tanxc_do;
        final /* synthetic */ com.alimm.tanx.core.ad.event.track.expose.ExposeCallback tanxc_if;

        public AnonymousClass1(java.lang.String str, com.alimm.tanx.core.ad.event.track.expose.ExposeCallback exposeCallback) {
            this.tanxc_do = str;
            this.tanxc_if = exposeCallback;
        }

        @Override // com.alimm.tanx.core.net.callback.NetWorkCallBack
        public void error(int i, java.lang.String str, java.lang.String str2) {
            com.alimm.tanx.core.utils.LogUtils.d("DefaultExposer", this.tanxc_do);
            com.alimm.tanx.core.utils.LogUtils.d("DefaultExposer", str2);
            com.alimm.tanx.core.ad.event.track.expose.ExposeCallback exposeCallback = this.tanxc_if;
            if (exposeCallback != null) {
                exposeCallback.onFail(i, str2, this.tanxc_do);
            }
        }

        @Override // com.alimm.tanx.core.net.callback.NetWorkCallBack
        public void succ(java.lang.Object obj) {
            com.alimm.tanx.core.utils.LogUtils.d("DefaultExposer", com.alibaba.fastjson.JSON.toJSONString(obj));
            com.alimm.tanx.core.ad.event.track.expose.ExposeCallback exposeCallback = this.tanxc_if;
            if (exposeCallback != null) {
                exposeCallback.onSucceed(200, this.tanxc_do);
            }
        }
    }

    @Override // com.alimm.tanx.core.ad.event.track.expose.IExposer
    public void onExpose(java.lang.String str, java.lang.String str2, com.alimm.tanx.core.ad.event.track.expose.ExposeCallback exposeCallback) {
        try {
            com.alimm.tanx.core.net.bean.RequestBean build = new com.alimm.tanx.core.net.bean.RequestBean().setUrl(str2).build();
            build.setOverrideError(true);
            exposeCallback.send(str2);
            com.alimm.tanx.core.net.NetWorkManager.getInstance().sendHttpGet(build, java.lang.Object.class, false, false, new com.alimm.tanx.core.ad.event.track.expose.tanxc_do.AnonymousClass1(str2, exposeCallback));
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            com.alimm.tanx.core.utils.LogUtils.d("DefaultExposer", str2);
            if (exposeCallback != null) {
                exposeCallback.onFail(com.alimm.tanx.core.ut.UtErrorCode.CRASH_ERROR.getIntCode(), com.alimm.tanx.core.utils.LogUtils.getStackTraceMessage(e), str2);
            }
        }
    }
}
