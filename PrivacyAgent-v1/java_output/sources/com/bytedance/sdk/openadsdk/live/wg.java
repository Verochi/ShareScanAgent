package com.bytedance.sdk.openadsdk.live;

/* loaded from: classes22.dex */
public final class wg implements com.bykv.vk.openvk.api.proto.Bridge {
    private static final com.bytedance.sdk.openadsdk.live.wg vw = new com.bytedance.sdk.openadsdk.live.wg();
    private volatile com.bykv.vk.openvk.api.proto.Bridge t;
    private java.util.Map<java.lang.String, java.lang.String> v;
    private com.bytedance.sdk.openadsdk.live.ITTLiveTokenInjectionAuth wg;
    private volatile com.bytedance.sdk.openadsdk.live.wg.C0277wg yl;

    /* renamed from: com.bytedance.sdk.openadsdk.live.wg$1, reason: invalid class name */
    public class AnonymousClass1 implements com.bytedance.android.live.base.api.MethodChannelService {
        public AnonymousClass1() {
        }

        @Override // com.bytedance.android.live.base.api.MethodChannelService
        public java.lang.String identity() {
            return com.bytedance.sdk.openadsdk.mediation.MediationConstant.ADN_PANGLE;
        }

        @Override // com.bytedance.android.live.base.api.MethodChannelService
        public java.lang.Object invokeMethod(java.lang.String str, java.util.Map<java.lang.String, java.lang.String> map) {
            if (com.bytedance.sdk.openadsdk.live.wg.this.t != null) {
                return com.bytedance.sdk.openadsdk.live.wg.this.t.call(0, com.bykv.vw.vw.vw.vw.wg.vw().vw(0, str).vw(1, map).wg(), java.lang.Object.class);
            }
            return null;
        }
    }

    /* renamed from: com.bytedance.sdk.openadsdk.live.wg$2, reason: invalid class name */
    public class AnonymousClass2 implements com.bytedance.android.live.base.api.ILiveInitCallback {
        public AnonymousClass2() {
        }

        @Override // com.bytedance.android.live.base.api.ILiveInitCallback
        public void onLiveInitFailed(java.lang.String str) {
            com.bytedance.sdk.openadsdk.api.t.vw("TTLiveSDkBridge", "onLiveInitFailed! ", str);
            if (com.bytedance.sdk.openadsdk.live.wg.this.yl != null) {
                com.bytedance.sdk.openadsdk.live.wg.this.yl.vw(-3, str, false);
            }
        }

        @Override // com.bytedance.android.live.base.api.ILiveInitCallback
        public void onLiveInitFinish() {
            com.bytedance.sdk.openadsdk.api.t.wg("TTLiveSDkBridge", "onLiveInitFinish!");
            com.bytedance.sdk.openadsdk.live.vw.vw();
            if (com.bytedance.sdk.openadsdk.live.wg.this.yl != null) {
                com.bytedance.sdk.openadsdk.live.wg.this.yl.vw(2, null, false);
            }
            com.bytedance.sdk.openadsdk.live.wg.this.v = null;
            com.bytedance.sdk.openadsdk.live.wg.this.wg = null;
        }
    }

    public static final class vw implements com.bykv.vk.openvk.api.proto.Bridge {
        private com.bytedance.sdk.openadsdk.live.ILiveAdCustomConfig vw;

        public vw(com.bytedance.sdk.openadsdk.live.ILiveAdCustomConfig iLiveAdCustomConfig) {
            this.vw = iLiveAdCustomConfig;
        }

        @Override // com.bykv.vk.openvk.api.proto.Caller
        public <T> T call(int i, com.bykv.vk.openvk.api.proto.ValueSet valueSet, java.lang.Class<T> cls) {
            if (i == 0) {
                return (T) java.lang.Integer.valueOf(this.vw.openLR(valueSet.stringValue(0)));
            }
            if (i == 1) {
                return (T) this.vw.convertToEnterFromMerge(valueSet.intValue(0));
            }
            if (i == 2) {
                return (T) this.vw.convertToEnterMethod(valueSet.intValue(0), valueSet.booleanValue(1));
            }
            if (i == 3) {
                return (T) this.vw.invoke(valueSet.intValue(0), (android.os.Bundle) valueSet.objectValue(1, android.os.Bundle.class));
            }
            if (i != 4) {
                return null;
            }
            this.vw.onEventV3(valueSet.stringValue(0), (org.json.JSONObject) valueSet.objectValue(1, org.json.JSONObject.class));
            return null;
        }

        @Override // com.bykv.vk.openvk.api.proto.Bridge
        public com.bykv.vk.openvk.api.proto.ValueSet values() {
            return com.bykv.vw.vw.vw.vw.wg.vw().vw(10000, 1).wg();
        }
    }

    /* renamed from: com.bytedance.sdk.openadsdk.live.wg$wg, reason: collision with other inner class name */
    public final class C0277wg implements com.bytedance.sdk.openadsdk.TTPluginListener {
        int vw;
        java.lang.String wg;

        private C0277wg() {
        }

        public /* synthetic */ C0277wg(com.bytedance.sdk.openadsdk.live.wg wgVar, com.bytedance.sdk.openadsdk.live.wg.AnonymousClass1 anonymousClass1) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void vw(int i, java.lang.ClassLoader classLoader, android.content.res.Resources resources, android.os.Bundle bundle, boolean z) {
            this.vw = i;
            if (com.bytedance.sdk.openadsdk.live.wg.this.t != null) {
                com.bytedance.sdk.openadsdk.live.wg.this.t.call(3, com.bykv.vw.vw.vw.vw.wg.vw().vw(0, i).vw(1, classLoader).vw(2, resources).vw(3, bundle).vw(4, com.bytedance.sdk.openadsdk.live.wg.this.vw(z)).wg(), null);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void vw(int i, java.lang.String str, boolean z) {
            this.vw = i;
            this.wg = str;
            if (com.bytedance.sdk.openadsdk.live.wg.this.t != null) {
                com.bykv.vw.vw.vw.vw.wg vw = com.bykv.vw.vw.vw.vw.wg.vw().vw(0, i);
                if (str != null) {
                    vw.vw(1, str);
                }
                vw.vw(2, com.bytedance.sdk.openadsdk.live.wg.this.vw(z));
                com.bytedance.sdk.openadsdk.live.wg.this.t.call(2, vw.wg(), null);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTPluginListener
        public android.os.Bundle config() {
            return null;
        }

        @Override // com.bytedance.sdk.openadsdk.TTPluginListener
        public void onPluginListener(int i, java.lang.ClassLoader classLoader, android.content.res.Resources resources, android.os.Bundle bundle) {
            vw(i, classLoader, resources, bundle, false);
        }

        @Override // com.bytedance.sdk.openadsdk.TTPluginListener
        public java.lang.String packageName() {
            return "com.byted.live.lite";
        }
    }

    private wg() {
    }

    private android.content.Context getContext(java.lang.Object obj) {
        if (obj instanceof android.content.Context) {
            return (android.content.Context) obj;
        }
        return null;
    }

    private com.bytedance.sdk.openadsdk.TTCustomController t(java.util.Map map) {
        java.lang.Object obj = map.get(com.bytedance.sdk.openadsdk.live.TTLiveConstants.INIT_CUSTOM_CONTROLLER);
        if (obj instanceof com.bykv.vk.openvk.api.proto.Bridge) {
            return new com.bytedance.sdk.openadsdk.t.vw.vw.x((com.bykv.vk.openvk.api.proto.Bridge) obj);
        }
        return null;
    }

    private java.lang.Object v(java.util.Map<java.lang.String, java.lang.Object> map) {
        try {
            java.lang.String str = (java.lang.String) map.get(com.bytedance.sdk.openadsdk.live.TTLiveConstants.EXPAND_METHOD_NAME_KEY);
            if (android.text.TextUtils.isEmpty(str)) {
                return null;
            }
            com.bytedance.android.live.base.api.IOuterLiveService liveRoomService = com.bytedance.android.openliveplugin.LivePluginHelper.getLiveRoomService();
            java.lang.Object[] objArr = (java.lang.Object[]) map.get(com.bytedance.sdk.openadsdk.live.TTLiveConstants.EXPAND_METHOD_PARAM_KEY);
            return objArr != null ? liveRoomService.callExpandMethod(str, objArr) : liveRoomService.callExpandMethod(str, new java.lang.Object[0]);
        } catch (java.lang.Throwable th) {
            com.bytedance.sdk.openadsdk.api.t.wg("TTLiveSDkBridge", th);
            return null;
        }
    }

    private android.os.Bundle vw(java.lang.Object obj) {
        if (obj instanceof android.os.Bundle) {
            return (android.os.Bundle) obj;
        }
        return null;
    }

    public static com.bykv.vk.openvk.api.proto.Bridge vw(com.bytedance.sdk.openadsdk.live.ILiveAdCustomConfig iLiveAdCustomConfig) {
        return new com.bytedance.sdk.openadsdk.live.wg.vw(iLiveAdCustomConfig);
    }

    public static com.bytedance.sdk.openadsdk.live.wg vw() {
        return vw;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public java.util.Map vw(boolean z) {
        java.util.HashMap hashMap = new java.util.HashMap();
        hashMap.put("onlyUpdateState", java.lang.Boolean.valueOf(z));
        return hashMap;
    }

    private void wg(java.util.Map map) {
        com.bytedance.android.live.base.api.ILiveHostContextParam.Builder hostActionParam = new com.bytedance.android.live.base.api.ILiveHostContextParam.Builder().setAppName(java.lang.String.valueOf(map.get("app_name"))).setChannel(java.lang.String.valueOf(map.get("channel"))).setIsDebug(java.lang.Boolean.valueOf(java.lang.String.valueOf(map.get("debug"))).booleanValue()).setECHostAppId(java.lang.String.valueOf(map.get(com.bytedance.sdk.openadsdk.live.TTLiveConstants.INIT_EC_HOST_APPID))).setPartner(java.lang.String.valueOf(map.get("partner"))).provideMethodChannel(new com.bytedance.sdk.openadsdk.live.wg.AnonymousClass1()).setPartnerSecret(com.bytedance.sdk.openadsdk.live.TTLiveConstants.INIT_PARTENER_SECERET).setHostPermission(new com.bytedance.sdk.openadsdk.live.core.TTHostPermissionInner(t(map))).setHostActionParam(new com.bytedance.sdk.openadsdk.live.core.vw(this.t));
        com.bytedance.sdk.openadsdk.live.ITTLiveTokenInjectionAuth iTTLiveTokenInjectionAuth = this.wg;
        if (iTTLiveTokenInjectionAuth != null) {
            hostActionParam.setInjectionAuth(new com.bytedance.sdk.openadsdk.live.core.wg(iTTLiveTokenInjectionAuth));
        }
        java.util.Map<java.lang.String, java.lang.String> map2 = this.v;
        if (map2 != null) {
            hostActionParam.addHostInitExtra(map2);
        }
        com.bytedance.sdk.openadsdk.live.wg.AnonymousClass2 anonymousClass2 = new com.bytedance.sdk.openadsdk.live.wg.AnonymousClass2();
        if (com.bytedance.sdk.openadsdk.TTAppContextHolder.getContext() instanceof android.app.Application) {
            hostActionParam.setContext((android.app.Application) com.bytedance.sdk.openadsdk.TTAppContextHolder.getContext());
        }
        boolean booleanValue = java.lang.Boolean.valueOf(java.lang.String.valueOf(map.get(com.bytedance.sdk.openadsdk.live.TTLiveConstants.INIT_SUB_PROCESS))).booleanValue();
        com.bytedance.sdk.openadsdk.api.t.vw("TTLiveSDkBridge", "execute live sdk initLive method end, (方法顺利执行结果)result: ", java.lang.Boolean.valueOf(com.bytedance.sdk.openadsdk.live.vw.vw(com.bytedance.sdk.openadsdk.TTAppContextHolder.getContext(), java.lang.String.valueOf(map.get(com.bytedance.sdk.openadsdk.live.TTLiveConstants.INIT_GENERATE_APPID)), hostActionParam, anonymousClass2, booleanValue)), " subProcess=", java.lang.Boolean.valueOf(booleanValue));
    }

    private java.lang.Boolean yl(java.util.Map<java.lang.String, java.lang.Object> map) {
        try {
            java.lang.String str = (java.lang.String) map.get(com.bytedance.sdk.openadsdk.live.TTLiveConstants.SCHEME_URI_KEY);
            if (android.text.TextUtils.isEmpty(str)) {
                return java.lang.Boolean.FALSE;
            }
            android.content.Context context = getContext(map.get("context"));
            android.net.Uri parse = android.net.Uri.parse(str);
            if (parse != null && context != null) {
                return java.lang.Boolean.valueOf(com.bytedance.sdk.openadsdk.live.vw.vw(context, parse));
            }
            return java.lang.Boolean.FALSE;
        } catch (java.lang.Throwable th) {
            com.bytedance.sdk.openadsdk.api.t.wg("TTLiveSDkBridge", th);
            return java.lang.Boolean.FALSE;
        }
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i, com.bykv.vk.openvk.api.proto.ValueSet valueSet, java.lang.Class<T> cls) {
        if (i == 5) {
            wg((java.util.Map) valueSet.objectValue(0, java.util.Map.class));
            return null;
        }
        if (i != 9) {
            return (T) vw(cls, i, (java.util.Map) valueSet.objectValue(0, java.util.Map.class));
        }
        this.t = (com.bykv.vk.openvk.api.proto.Bridge) valueSet.objectValue(0, com.bykv.vk.openvk.api.proto.Bridge.class);
        if (this.yl == null) {
            this.yl = new com.bytedance.sdk.openadsdk.live.wg.C0277wg(this, null);
            com.bykv.vk.openvk.api.proto.Bridge bridge = (com.bykv.vk.openvk.api.proto.Bridge) com.bytedance.sdk.openadsdk.vw.t.vw().call(10, com.bykv.vw.vw.vw.vw.wg.vw(1).vw(0, 4).wg(), com.bykv.vk.openvk.api.proto.Bridge.class);
            com.bykv.vk.openvk.api.proto.ValueSet wg = com.bykv.vw.vw.vw.vw.wg.vw(1).vw(0, this.yl).wg();
            if (bridge != null) {
                bridge.call(106, wg, java.lang.Void.class);
            }
        } else if (this.yl.vw == 2 || this.yl.vw == -3) {
            this.yl.vw(this.yl.vw, this.yl.wg, true);
        } else if (this.yl.vw != 0) {
            this.yl.vw(this.yl.vw, null, null, null, true);
        }
        return null;
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public com.bykv.vk.openvk.api.proto.ValueSet values() {
        return com.bykv.vw.vw.vw.vw.wg.vw().vw(10000, 2).wg();
    }

    public <T> T vw(java.lang.Class<T> cls, int i, java.util.Map<java.lang.String, java.lang.Object> map) {
        if (i == 0) {
            return !com.bytedance.sdk.openadsdk.live.vw.vw(getContext(map.get("context")), vw(map.get(com.bytedance.sdk.openadsdk.live.TTLiveConstants.BUNDLE_KEY))) ? (T) 2 : (T) 0;
        }
        if (i == 7) {
            return (T) v(map);
        }
        if (i != 8) {
            return null;
        }
        return (T) yl(map);
    }

    public void vw(com.bytedance.sdk.openadsdk.live.ITTLiveTokenInjectionAuth iTTLiveTokenInjectionAuth) {
        this.wg = iTTLiveTokenInjectionAuth;
    }

    public void vw(java.util.Map<java.lang.String, java.lang.String> map) {
        if (map == null || map.size() == 0) {
            return;
        }
        this.v = map;
    }
}
