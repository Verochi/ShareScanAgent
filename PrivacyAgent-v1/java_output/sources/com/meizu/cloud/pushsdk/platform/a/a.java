package com.meizu.cloud.pushsdk.platform.a;

/* loaded from: classes23.dex */
public class a {
    private java.lang.String a;
    private java.lang.String b;
    private java.lang.String c;
    private java.lang.String d;
    private java.lang.String e;
    private java.lang.String f;
    private java.lang.String g;
    private java.lang.String h;
    private java.lang.String i;
    private java.lang.String j;
    private java.lang.String k;
    private java.lang.String l;
    private java.lang.String m;
    private java.lang.String n;
    private java.lang.String o;

    public a(android.content.Context context) {
        this.a = "https://api-push.meizu.com/garcia/api/client/";
        this.b = this.a + "message/registerPush";
        this.c = this.a + "message/unRegisterPush";
        this.d = this.a + "advance/unRegisterPush";
        this.e = this.a + "message/getRegisterSwitch";
        this.f = this.a + "message/changeRegisterSwitch";
        this.g = this.a + "message/changeAllSwitch";
        this.h = this.a + "message/subscribeTags";
        this.i = this.a + "message/unSubscribeTags";
        this.j = this.a + "message/unSubAllTags";
        this.k = this.a + "message/getSubTags";
        this.l = this.a + "message/subscribeAlias";
        this.m = this.a + "message/unSubscribeAlias";
        this.n = this.a + "message/getSubAlias";
        this.o = this.a + "advance/changeRegisterSwitch";
        com.meizu.cloud.pushsdk.c.a.a();
        if (com.meizu.cloud.pushsdk.util.MzSystemUtils.isOverseas()) {
            this.a = "https://api-push.in.meizu.com/garcia/api/client/";
            this.b = this.a + "message/registerPush";
            this.c = this.a + "message/unRegisterPush";
            this.d = this.a + "advance/unRegisterPush";
            this.e = this.a + "message/getRegisterSwitch";
            this.f = this.a + "message/changeRegisterSwitch";
            this.g = this.a + "message/changeAllSwitch";
            this.h = this.a + "message/subscribeTags";
            this.i = this.a + "message/unSubscribeTags";
            this.j = this.a + "message/unSubAllTags";
            this.k = this.a + "message/getSubTags";
            this.l = this.a + "message/subscribeAlias";
            this.m = this.a + "message/unSubscribeAlias";
            this.n = this.a + "message/getSubAlias";
            this.o = this.a + "advance/changeRegisterSwitch";
        }
    }

    public com.meizu.cloud.pushsdk.c.a.c a(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        java.util.LinkedHashMap linkedHashMap = new java.util.LinkedHashMap();
        linkedHashMap.put(com.anythink.expressad.videocommon.e.b.u, str);
        linkedHashMap.put("deviceId", str3);
        java.util.LinkedHashMap linkedHashMap2 = new java.util.LinkedHashMap(linkedHashMap);
        linkedHashMap2.put("sign", com.meizu.cloud.pushsdk.platform.b.a(linkedHashMap, str2));
        com.meizu.cloud.pushinternal.DebugLogger.i("PushAPI", "register post map " + linkedHashMap2);
        return com.meizu.cloud.pushsdk.c.a.b(this.b).a(linkedHashMap2).a().a();
    }

    public com.meizu.cloud.pushsdk.c.a.c a(java.lang.String str, java.lang.String str2, java.lang.String str3, int i, boolean z) {
        java.util.LinkedHashMap linkedHashMap = new java.util.LinkedHashMap();
        linkedHashMap.put(com.anythink.expressad.videocommon.e.b.u, str);
        linkedHashMap.put(com.meizu.cloud.pushsdk.constants.PushConstants.KEY_PUSH_ID, str3);
        linkedHashMap.put(com.sensorsdata.sf.ui.view.UIProperty.msgType, java.lang.String.valueOf(i));
        linkedHashMap.put("subSwitch", z ? "1" : "0");
        java.util.LinkedHashMap linkedHashMap2 = new java.util.LinkedHashMap(linkedHashMap);
        linkedHashMap2.put("sign", com.meizu.cloud.pushsdk.platform.b.a(linkedHashMap, str2));
        com.meizu.cloud.pushinternal.DebugLogger.i("PushAPI", this.f + " switchPush post map " + linkedHashMap2);
        return com.meizu.cloud.pushsdk.c.a.b(this.f).a(linkedHashMap2).a().a();
    }

    public com.meizu.cloud.pushsdk.c.a.c<java.lang.String> a(java.lang.String str, java.lang.String str2, java.lang.String str3, java.io.File file) {
        java.util.LinkedHashMap linkedHashMap = new java.util.LinkedHashMap();
        linkedHashMap.put(com.huawei.hms.push.constant.RemoteMessageConst.MSGID, str);
        linkedHashMap.put("deviceId", str2);
        java.util.LinkedHashMap linkedHashMap2 = new java.util.LinkedHashMap(linkedHashMap);
        linkedHashMap2.put("sign", com.meizu.cloud.pushsdk.platform.b.a(linkedHashMap, "4a2ca769d79f4856bb3bd982d30de790"));
        if (!android.text.TextUtils.isEmpty(str3)) {
            linkedHashMap2.put(com.bytedance.sdk.openadsdk.mediation.MediationConstant.KEY_ERROR_MSG, str3);
        }
        com.meizu.cloud.pushinternal.DebugLogger.i("PushAPI", "uploadLogFile post map " + linkedHashMap2);
        return com.meizu.cloud.pushsdk.c.a.c("https://api-push.meizu.com/garcia/api/client/log/upload").a(linkedHashMap2).a("logFile", file).a().a();
    }

    public com.meizu.cloud.pushsdk.c.a.c a(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4) {
        java.util.LinkedHashMap linkedHashMap = new java.util.LinkedHashMap();
        linkedHashMap.put(com.anythink.expressad.videocommon.e.b.u, str);
        linkedHashMap.put(com.meizu.cloud.pushsdk.constants.PushConstants.KEY_PUSH_ID, str3);
        linkedHashMap.put(com.baidu.mobads.sdk.internal.bm.l, str4);
        java.util.LinkedHashMap linkedHashMap2 = new java.util.LinkedHashMap(linkedHashMap);
        linkedHashMap2.put("sign", com.meizu.cloud.pushsdk.platform.b.a(linkedHashMap, str2));
        com.meizu.cloud.pushinternal.DebugLogger.i("PushAPI", "subScribeTags post map " + linkedHashMap2);
        return com.meizu.cloud.pushsdk.c.a.b(this.h).a(linkedHashMap2).a().a();
    }

    public com.meizu.cloud.pushsdk.c.a.c a(java.lang.String str, java.lang.String str2, java.lang.String str3, boolean z) {
        java.util.LinkedHashMap linkedHashMap = new java.util.LinkedHashMap();
        linkedHashMap.put(com.anythink.expressad.videocommon.e.b.u, str);
        linkedHashMap.put(com.meizu.cloud.pushsdk.constants.PushConstants.KEY_PUSH_ID, str3);
        linkedHashMap.put("subSwitch", z ? "1" : "0");
        java.util.LinkedHashMap linkedHashMap2 = new java.util.LinkedHashMap(linkedHashMap);
        linkedHashMap2.put("sign", com.meizu.cloud.pushsdk.platform.b.a(linkedHashMap, str2));
        com.meizu.cloud.pushinternal.DebugLogger.i("PushAPI", this.g + " switchPush post map " + linkedHashMap2);
        return com.meizu.cloud.pushsdk.c.a.b(this.g).a(linkedHashMap2).a().a();
    }

    public com.meizu.cloud.pushsdk.c.a.c b(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        java.util.LinkedHashMap linkedHashMap = new java.util.LinkedHashMap();
        linkedHashMap.put(com.anythink.expressad.videocommon.e.b.u, str);
        linkedHashMap.put("deviceId", str3);
        java.util.LinkedHashMap linkedHashMap2 = new java.util.LinkedHashMap(linkedHashMap);
        linkedHashMap2.put("sign", com.meizu.cloud.pushsdk.platform.b.a(linkedHashMap, str2));
        com.meizu.cloud.pushinternal.DebugLogger.i("PushAPI", "unregister post map " + linkedHashMap2);
        return com.meizu.cloud.pushsdk.c.a.a(this.c).a(linkedHashMap2).a().a();
    }

    public com.meizu.cloud.pushsdk.c.a.c b(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4) {
        java.util.LinkedHashMap linkedHashMap = new java.util.LinkedHashMap();
        linkedHashMap.put(com.anythink.expressad.videocommon.e.b.u, str);
        linkedHashMap.put(com.meizu.cloud.pushsdk.constants.PushConstants.KEY_PUSH_ID, str3);
        linkedHashMap.put(com.baidu.mobads.sdk.internal.bm.l, str4);
        java.util.LinkedHashMap linkedHashMap2 = new java.util.LinkedHashMap(linkedHashMap);
        linkedHashMap2.put("sign", com.meizu.cloud.pushsdk.platform.b.a(linkedHashMap, str2));
        com.meizu.cloud.pushinternal.DebugLogger.i("PushAPI", "subScribeTags post map " + linkedHashMap2);
        return com.meizu.cloud.pushsdk.c.a.b(this.i).a(linkedHashMap2).a().a();
    }

    public com.meizu.cloud.pushsdk.c.a.c c(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        java.util.LinkedHashMap linkedHashMap = new java.util.LinkedHashMap();
        linkedHashMap.put(com.anythink.expressad.videocommon.e.b.u, str);
        linkedHashMap.put(com.meizu.cloud.pushsdk.constants.PushConstants.KEY_PUSH_ID, str3);
        java.util.LinkedHashMap linkedHashMap2 = new java.util.LinkedHashMap(linkedHashMap);
        linkedHashMap2.put("sign", com.meizu.cloud.pushsdk.platform.b.a(linkedHashMap, str2));
        com.meizu.cloud.pushinternal.DebugLogger.i("PushAPI", "checkPush post map " + linkedHashMap2);
        return com.meizu.cloud.pushsdk.c.a.a(this.e).a(linkedHashMap2).a().a();
    }

    public com.meizu.cloud.pushsdk.c.a.c c(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4) {
        java.util.LinkedHashMap linkedHashMap = new java.util.LinkedHashMap();
        linkedHashMap.put(com.anythink.expressad.videocommon.e.b.u, str);
        linkedHashMap.put(com.heytap.mcssdk.constant.b.z, str2);
        linkedHashMap.put(com.meizu.cloud.pushsdk.constants.PushConstants.KEY_PUSH_ID, str3);
        linkedHashMap.put(com.meizu.cloud.pushsdk.constants.PushConstants.SUB_ALIAS_STATUS_NAME, str4);
        java.util.LinkedHashMap linkedHashMap2 = new java.util.LinkedHashMap(linkedHashMap);
        linkedHashMap2.put("sign", com.meizu.cloud.pushsdk.platform.b.a(linkedHashMap, str2));
        com.meizu.cloud.pushinternal.DebugLogger.i("PushAPI", "subScribeTags post map " + linkedHashMap2);
        return com.meizu.cloud.pushsdk.c.a.b(this.l).a(linkedHashMap2).a().a();
    }

    public com.meizu.cloud.pushsdk.c.a.c d(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        java.util.LinkedHashMap linkedHashMap = new java.util.LinkedHashMap();
        linkedHashMap.put(com.anythink.expressad.videocommon.e.b.u, str);
        linkedHashMap.put(com.meizu.cloud.pushsdk.constants.PushConstants.KEY_PUSH_ID, str3);
        java.util.LinkedHashMap linkedHashMap2 = new java.util.LinkedHashMap(linkedHashMap);
        linkedHashMap2.put("sign", com.meizu.cloud.pushsdk.platform.b.a(linkedHashMap, str2));
        com.meizu.cloud.pushinternal.DebugLogger.i("PushAPI", "subScribeAllTags post map " + linkedHashMap2);
        return com.meizu.cloud.pushsdk.c.a.b(this.j).a(linkedHashMap2).a().a();
    }

    public com.meizu.cloud.pushsdk.c.a.c d(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4) {
        java.util.LinkedHashMap linkedHashMap = new java.util.LinkedHashMap();
        linkedHashMap.put(com.anythink.expressad.videocommon.e.b.u, str);
        linkedHashMap.put(com.meizu.cloud.pushsdk.constants.PushConstants.KEY_PUSH_ID, str3);
        linkedHashMap.put(com.meizu.cloud.pushsdk.constants.PushConstants.SUB_ALIAS_STATUS_NAME, str4);
        java.util.LinkedHashMap linkedHashMap2 = new java.util.LinkedHashMap(linkedHashMap);
        linkedHashMap2.put("sign", com.meizu.cloud.pushsdk.platform.b.a(linkedHashMap, str2));
        com.meizu.cloud.pushinternal.DebugLogger.i("PushAPI", "subScribeTags post map " + linkedHashMap2);
        return com.meizu.cloud.pushsdk.c.a.b(this.m).a(linkedHashMap2).a().a();
    }

    public com.meizu.cloud.pushsdk.c.a.c e(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        java.util.LinkedHashMap linkedHashMap = new java.util.LinkedHashMap();
        linkedHashMap.put(com.anythink.expressad.videocommon.e.b.u, str);
        linkedHashMap.put(com.meizu.cloud.pushsdk.constants.PushConstants.KEY_PUSH_ID, str3);
        java.util.LinkedHashMap linkedHashMap2 = new java.util.LinkedHashMap(linkedHashMap);
        linkedHashMap2.put("sign", com.meizu.cloud.pushsdk.platform.b.a(linkedHashMap, str2));
        com.meizu.cloud.pushinternal.DebugLogger.i("PushAPI", "checkPush post map " + linkedHashMap2);
        return com.meizu.cloud.pushsdk.c.a.a(this.k).a(linkedHashMap2).a().a();
    }
}
