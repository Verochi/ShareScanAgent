package com.alimm.tanx.core.ut.core;

/* loaded from: classes.dex */
public class UtRequest {
    private static final java.lang.String TAG = "UtRequest";
    private static volatile com.alimm.tanx.core.ut.core.UtRequest instance;
    private volatile java.util.concurrent.ConcurrentHashMap<java.lang.Integer, com.alimm.tanx.core.ut.bean.UtBean> ingConcurrentHashMap = new java.util.concurrent.ConcurrentHashMap<>();
    public java.util.concurrent.atomic.AtomicLong atomicLong = new java.util.concurrent.atomic.AtomicLong(0);

    public static com.alimm.tanx.core.ut.core.UtRequest getInstance() {
        if (instance == null) {
            synchronized (com.alimm.tanx.core.ut.core.UtRequest.class) {
                if (instance == null) {
                    instance = new com.alimm.tanx.core.ut.core.UtRequest();
                }
            }
        }
        return instance;
    }

    private void removeIngMap(com.alimm.tanx.core.ut.bean.UtBean utBean) {
        try {
            if (utBean == null) {
                com.alimm.tanx.core.utils.LogUtils.d(TAG, "UserReport :ingListLinkedHashMap-remove 过程为空");
                return;
            }
            com.alimm.tanx.core.ut.bean.UtBean utBean2 = this.ingConcurrentHashMap.get(java.lang.Integer.valueOf(utBean.hashCode()));
            com.alimm.tanx.core.utils.LogUtils.d(TAG, "UserReport :ingListLinkedHashMap -remove前 ->size():" + this.ingConcurrentHashMap.size() + "->ingConcurrentHashMap.get()->" + (utBean2 != null ? utBean2.toString() : ""));
            this.ingConcurrentHashMap.remove(java.lang.Integer.valueOf(utBean.hashCode()));
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("UserReport :ingListLinkedHashMap-remove后->size():");
            sb.append(this.ingConcurrentHashMap.size());
            com.alimm.tanx.core.utils.LogUtils.d(TAG, sb.toString());
        } catch (java.lang.Exception e) {
            com.alimm.tanx.core.utils.LogUtils.e(com.alimm.tanx.core.ut.core.IUserReport.TAG, e);
        }
    }

    private boolean request(com.alimm.tanx.core.ut.bean.UtBean utBean, boolean z) {
        if (!z) {
            this.ingConcurrentHashMap.put(java.lang.Integer.valueOf(utBean.hashCode()), utBean);
            com.alimm.tanx.core.utils.LogUtils.d(TAG, "request ->ingListLinkedHashMap->size():" + this.ingConcurrentHashMap.size());
        }
        com.alimm.tanx.core.net.bean.RequestBean build = new com.alimm.tanx.core.net.bean.RequestBean().setUrl(com.alimm.tanx.core.request.C.getUtUrl()).build();
        build.setOverrideError(true);
        java.util.HashMap hashMap = new java.util.HashMap();
        hashMap.put("Content-Type", "application/json; charset=utf-8");
        build.setHeads(hashMap);
        com.alimm.tanx.core.utils.LogUtils.d(TAG, utBean.toString());
        build.setJson(com.alibaba.fastjson.JSON.toJSONString(utBean));
        com.alimm.tanx.core.utils.LogUtils.d("ut-request-count:", "isCacheRequest:" + z);
        com.alimm.tanx.core.ut.bean.UtResponse utResponse = (com.alimm.tanx.core.ut.bean.UtResponse) com.alimm.tanx.core.net.NetWorkManager.getInstance().sendSyncHttpPost2Gzip(build, com.alimm.tanx.core.ut.bean.UtResponse.class);
        if (utResponse == null) {
            com.alimm.tanx.core.utils.LogUtils.e(TAG, "UserReport :error ->上报失败->:服务器返回空UtResponse reqId:" + utBean.reqId);
            if (!z) {
                removeIngMap(utBean);
                com.alimm.tanx.core.ut.core.CacheUserReportManager.getInstance().saveFile(build.getJson());
            }
            return false;
        }
        boolean z2 = utResponse.status == 0;
        if (z2) {
            com.alimm.tanx.core.utils.LogUtils.d(TAG, "UserReport :succ");
            if (!z) {
                removeIngMap(utBean);
            }
            com.alimm.tanx.core.utils.LogUtils.d(TAG, "UserReport :succ ->上报成功->:" + this.atomicLong.incrementAndGet());
        } else {
            if (!z) {
                com.alimm.tanx.core.utils.LogUtils.d(TAG, "UserReport :error ");
                removeIngMap(utBean);
                com.alimm.tanx.core.ut.core.CacheUserReportManager.getInstance().saveFile(build.getJson());
            }
            com.alimm.tanx.core.utils.LogUtils.d(TAG, "UserReport :error ->上报失败->:" + this.atomicLong.incrementAndGet() + " 服务器错误信息：" + utResponse.msg);
        }
        return z2;
    }

    public void destroy() {
    }

    public boolean requestCache(com.alimm.tanx.core.ut.bean.UtBean utBean) {
        try {
            return request(utBean, true);
        } catch (java.lang.Exception e) {
            com.alimm.tanx.core.utils.LogUtils.e(com.alimm.tanx.core.ut.core.IUserReport.TAG, e);
            return false;
        }
    }

    public boolean requestCache(java.io.File file) {
        try {
            return request((com.alimm.tanx.core.ut.bean.UtBean) com.alibaba.fastjson.JSON.parseObject(com.alimm.tanx.core.utils.FileUtils.getStrFromFile(file), com.alimm.tanx.core.ut.bean.UtBean.class), true);
        } catch (java.lang.Exception e) {
            com.alimm.tanx.core.utils.LogUtils.e(com.alimm.tanx.core.ut.core.IUserReport.TAG, e);
            return false;
        }
    }

    public boolean requestRealTime(com.alimm.tanx.core.ut.bean.UtBean utBean) {
        return request(utBean, false);
    }
}
