package com.alimm.tanx.core.orange;

/* loaded from: classes.dex */
public class tanxc_do {
    public void tanxc_do(com.alimm.tanx.core.net.callback.NetWorkCallBack netWorkCallBack) {
        com.alimm.tanx.core.net.bean.RequestBean build = new com.alimm.tanx.core.net.bean.RequestBean().setUrl(com.alimm.tanx.core.request.C.getOrangeUrl()).build();
        build.setOverrideError(true);
        java.util.HashMap hashMap = new java.util.HashMap();
        hashMap.put("Content-Type", "application/json; charset=utf-8");
        build.setHeads(hashMap);
        com.alimm.tanx.core.net.NetWorkManager.getInstance().sendHttpGet(build, com.alimm.tanx.core.orange.bean.OrangeBean.class, netWorkCallBack);
    }
}
