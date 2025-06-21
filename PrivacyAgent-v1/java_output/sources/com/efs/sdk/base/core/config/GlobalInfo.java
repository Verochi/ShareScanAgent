package com.efs.sdk.base.core.config;

/* loaded from: classes22.dex */
public class GlobalInfo {
    private java.util.Map<java.lang.String, java.lang.Object> a = new java.util.concurrent.ConcurrentHashMap();

    public final void a(java.lang.String str, java.lang.Object obj) {
        if (obj != null) {
            this.a.put(str, obj);
        }
    }

    public final java.lang.Object b(java.lang.String str, java.lang.Object obj) {
        java.lang.Object obj2 = this.a.get(str);
        return (obj2 != null || this.a.containsKey(str)) ? obj2 : obj;
    }

    public java.util.Map<java.lang.String, java.lang.Object> getGlobalInfoMap() {
        java.util.HashMap hashMap = new java.util.HashMap(this.a);
        com.efs.sdk.base.core.a.a.a();
        hashMap.put("ctime", java.lang.Long.valueOf(com.efs.sdk.base.core.a.a.b() / 1000));
        com.efs.sdk.base.core.a.a.a();
        hashMap.put("w_tm", java.lang.Long.valueOf(com.efs.sdk.base.core.a.a.b() / 1000));
        return hashMap;
    }

    public java.util.List<com.efs.sdk.base.protocol.file.section.AbsSection> getGlobalSectionList(java.lang.String str) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        com.efs.sdk.base.protocol.file.section.KVSection kVSection = new com.efs.sdk.base.protocol.file.section.KVSection("global_head");
        com.efs.sdk.base.protocol.file.section.KVSection put = kVSection.put("type", str).put("appid", this.a.get("appid")).put("wid", this.a.get("wid")).put("pid", this.a.get("pid")).put("pkg", this.a.get("pkg")).put("ver", this.a.get("ver")).put("vcode", this.a.get("vcode")).put(com.aliyun.vod.log.struct.AliyunLogKey.KEY_PART_SIZE, this.a.get(com.aliyun.vod.log.struct.AliyunLogKey.KEY_PART_SIZE)).put("stime", this.a.get("stime"));
        com.efs.sdk.base.core.a.a.a();
        com.efs.sdk.base.protocol.file.section.KVSection put2 = put.put("ctime", java.lang.Long.valueOf(com.efs.sdk.base.core.a.a.b() / 1000));
        com.efs.sdk.base.core.a.a.a();
        put2.put("w_tm", java.lang.Long.valueOf(com.efs.sdk.base.core.a.a.b() / 1000)).put("sdk_ver", this.a.get("sdk_ver"));
        java.lang.String valueOf = java.lang.String.valueOf(b("uid", ""));
        if (!android.text.TextUtils.isEmpty(valueOf)) {
            kVSection.put("uid", valueOf);
        }
        arrayList.add(kVSection);
        com.efs.sdk.base.protocol.file.section.KVSection kVSection2 = new com.efs.sdk.base.protocol.file.section.KVSection("device_info");
        kVSection2.put("lang", this.a.get("lang")).put("brand", this.a.get("brand")).put("model", this.a.get("model")).put("build_model", this.a.get("build_model")).put("rom", this.a.get("rom")).put("sdk", this.a.get("sdk")).put("dsp_h", this.a.get("dsp_h")).put("dsp_w", this.a.get("dsp_w")).put("tzone", this.a.get("tzone")).put(com.alipay.sdk.m.k.b.k, this.a.get(com.alipay.sdk.m.k.b.k)).put(com.anythink.expressad.video.dynview.a.a.U, this.a.get(com.anythink.expressad.video.dynview.a.a.U));
        try {
            if (this.a.containsKey(com.umeng.umcrash.UMCrash.KEY_HEADER_ACCESS)) {
                kVSection2.put(com.umeng.umcrash.UMCrash.KEY_HEADER_ACCESS, this.a.get(com.umeng.umcrash.UMCrash.KEY_HEADER_ACCESS));
            }
            if (this.a.containsKey(com.umeng.umcrash.UMCrash.KEY_HEADER_ACCESS_SUBTYPE)) {
                kVSection2.put(com.umeng.umcrash.UMCrash.KEY_HEADER_ACCESS_SUBTYPE, this.a.get(com.umeng.umcrash.UMCrash.KEY_HEADER_ACCESS_SUBTYPE));
            }
            if (this.a.containsKey(com.umeng.umcrash.UMCrash.KEY_HEADER_NETWORK_TYPE)) {
                kVSection2.put(com.umeng.umcrash.UMCrash.KEY_HEADER_NETWORK_TYPE, this.a.get(com.umeng.umcrash.UMCrash.KEY_HEADER_NETWORK_TYPE));
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
        arrayList.add(kVSection2);
        return arrayList;
    }

    public java.lang.String getUUID(android.content.Context context) {
        java.lang.String valueOf = java.lang.String.valueOf(b("wid", ""));
        if (!android.text.TextUtils.isEmpty(valueOf)) {
            return valueOf;
        }
        java.lang.String a = com.efs.sdk.base.core.util.c.a(context);
        a("wid", a);
        return a;
    }
}
