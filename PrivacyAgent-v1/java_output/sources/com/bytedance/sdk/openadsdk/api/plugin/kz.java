package com.bytedance.sdk.openadsdk.api.plugin;

/* loaded from: classes22.dex */
public class kz extends com.bytedance.sdk.openadsdk.api.vw {
    private static final com.bytedance.sdk.openadsdk.api.plugin.kz.vw vw = new com.bytedance.sdk.openadsdk.api.plugin.kz.vw(null);
    private com.bytedance.sdk.openadsdk.api.plugin.v t;
    private com.bytedance.sdk.openadsdk.vw.wg v = new com.bytedance.sdk.openadsdk.api.plugin.kz.AnonymousClass1();
    private volatile com.bykv.vk.openvk.api.proto.Initializer wg;

    /* renamed from: com.bytedance.sdk.openadsdk.api.plugin.kz$1, reason: invalid class name */
    public class AnonymousClass1 implements com.bytedance.sdk.openadsdk.vw.wg {
        public AnonymousClass1() {
        }

        @Override // com.bytedance.sdk.openadsdk.vw.wg
        public com.bykv.vk.openvk.api.proto.Bridge vw(int i) {
            return com.bytedance.sdk.openadsdk.api.plugin.kz.this.vw(i);
        }
    }

    public static final class vw extends com.bytedance.sdk.openadsdk.api.vw.t {
        private vw() {
        }

        public /* synthetic */ vw(com.bytedance.sdk.openadsdk.api.plugin.kz.AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.bytedance.sdk.openadsdk.api.vw.t
        public java.lang.Object vw(java.lang.Object obj) {
            boolean z = obj instanceof com.bytedance.sdk.openadsdk.TTPluginListener;
            if (z) {
                com.bytedance.sdk.openadsdk.api.plugin.yl.vw(com.bytedance.sdk.openadsdk.TTAppContextHolder.getContext()).vw((com.bytedance.sdk.openadsdk.TTPluginListener) obj);
            }
            if (!z) {
                return obj instanceof com.bytedance.sdk.openadsdk.live.ILiveAdCustomConfig ? com.bytedance.sdk.openadsdk.live.wg.vw((com.bytedance.sdk.openadsdk.live.ILiveAdCustomConfig) obj) : obj;
            }
            com.bytedance.sdk.openadsdk.TTPluginListener tTPluginListener = (com.bytedance.sdk.openadsdk.TTPluginListener) obj;
            return com.bytedance.sdk.openadsdk.api.plugin.yl.vw(com.bytedance.sdk.openadsdk.TTAppContextHolder.getContext()).vw(tTPluginListener.packageName(), tTPluginListener.config());
        }

        @Override // com.bytedance.sdk.openadsdk.api.vw.t
        public void vw(java.lang.Throwable th) {
            com.bytedance.sdk.openadsdk.api.plugin.yl.vw(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.bykv.vk.openvk.api.proto.Bridge vw(int i) {
        if (i == 2) {
            return com.bytedance.sdk.openadsdk.live.wg.vw();
        }
        if (i == 3) {
            return com.bytedance.sdk.openadsdk.downloadnew.v.vw(com.bytedance.sdk.openadsdk.TTAppContextHolder.getContext());
        }
        if (i != 4) {
            return null;
        }
        return com.bytedance.sdk.openadsdk.api.plugin.vw.vw.vw();
    }

    private com.bykv.vk.openvk.api.proto.Initializer vw(com.bytedance.sdk.openadsdk.api.plugin.v vVar) throws com.bytedance.sdk.openadsdk.api.plugin.vw {
        if (this.wg == null) {
            synchronized (this) {
                if (this.wg == null) {
                    com.bytedance.sdk.openadsdk.api.t.wg("TTPluginManager", "Create initializer");
                    this.wg = wg(vVar);
                }
            }
        }
        return this.wg;
    }

    private static com.bykv.vk.openvk.api.proto.Initializer wg(com.bytedance.sdk.openadsdk.api.plugin.v vVar) throws com.bytedance.sdk.openadsdk.api.plugin.vw {
        try {
            vVar.wg("call_create_initializer");
            dalvik.system.BaseDexClassLoader vw2 = com.bytedance.sdk.openadsdk.api.plugin.yl.vw(com.bytedance.sdk.openadsdk.TTAppContextHolder.getContext()).vw(vVar);
            if (vw2 == null) {
                throw new com.bytedance.sdk.openadsdk.api.plugin.vw(4205, "Get initializer failed");
            }
            java.lang.Class<?> loadClass = vw2.loadClass(com.bytedance.sdk.openadsdk.TTAdSdk.INITIALIZER_CLASS_NAME);
            vVar.wg("get_init_class_cost");
            android.os.Bundle bundle = new android.os.Bundle();
            bundle.putLong("call_init_time", vVar.wg());
            bundle.putSerializable(com.bytedance.sdk.openadsdk.api.plugin.PluginConstants.KEY_PL_UPDATE_EVENT_LISTENER, new com.bytedance.sdk.openadsdk.api.plugin.yl.t());
            vVar.wg("create_bundle_cost");
            java.lang.reflect.Method declaredMethod = loadClass.getDeclaredMethod("getNewInstance", android.os.Bundle.class);
            vVar.wg("get_init_method_cost");
            try {
                com.bykv.vk.openvk.api.proto.Initializer initializer = (com.bykv.vk.openvk.api.proto.Initializer) declaredMethod.invoke(null, bundle);
                vVar.wg("get_init_instance_cost");
                com.bytedance.sdk.openadsdk.api.t.wg("TTPluginManager", "Create initializer success");
                return initializer;
            } catch (java.lang.Throwable th) {
                com.bytedance.pangle.Zeus.unInstallPlugin("com.byted.pangle");
                throw th;
            }
        } catch (java.lang.Throwable th2) {
            if (!(th2 instanceof com.bytedance.sdk.openadsdk.api.plugin.vw)) {
                throw new com.bytedance.sdk.openadsdk.api.plugin.vw(4206, th2.getMessage());
            }
            throw new com.bytedance.sdk.openadsdk.api.plugin.vw(4205, "(" + th2.vw() + ", " + th2.getMessage() + ")");
        }
    }

    @Override // com.bytedance.sdk.openadsdk.api.vw
    public com.bytedance.sdk.openadsdk.vw.wg t() {
        return this.v;
    }

    @Override // com.bytedance.sdk.openadsdk.api.vw
    public void vw(com.bykv.vk.openvk.api.proto.Result result) {
        if (!result.isSuccess()) {
            com.bytedance.sdk.openadsdk.api.plugin.t.vw(result.code(), result.message(), 0L);
            return;
        }
        android.os.Bundle bundle = new android.os.Bundle();
        bundle.putInt("action", 0);
        java.util.concurrent.ExecutorService executorService = (java.util.concurrent.ExecutorService) com.bytedance.sdk.openadsdk.TTAdSdk.getAdManager().getExtra(java.util.concurrent.ExecutorService.class, bundle);
        if (executorService != null) {
            com.bytedance.sdk.openadsdk.yl.vw.vw().vw(executorService);
        }
        com.bytedance.sdk.openadsdk.api.plugin.t.vw();
    }

    @Override // com.bytedance.sdk.openadsdk.api.vw
    public boolean vw() {
        if (this.wg != null) {
            return this.wg.isInitSuccess();
        }
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.api.vw
    public boolean vw(android.content.Context context, com.bykv.vw.vw.vw.vw.wg wgVar) {
        if (this.wg == null) {
            return false;
        }
        this.wg.init(context, wgVar.wg());
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.api.vw
    public com.bytedance.sdk.openadsdk.api.vw.t wg() {
        return vw;
    }

    @Override // com.bytedance.sdk.openadsdk.api.vw
    public void wg(android.content.Context context, com.bykv.vw.vw.vw.vw.wg wgVar) {
        com.bytedance.sdk.openadsdk.api.plugin.v vVar = this.t;
        if (vVar == null) {
            vVar = com.bytedance.sdk.openadsdk.api.plugin.v.vw("duration");
        }
        vVar.wg("wait_asyn_cost");
        try {
            com.bykv.vk.openvk.api.proto.Initializer vw2 = vw(vVar);
            try {
                if (vw2 == null) {
                    wg(com.bykv.vw.vw.vw.vw.vw.vw().vw(false).vw(com.bytedance.sdk.openadsdk.TTAdConstant.INIT_FAILED_CREATE_INITIALIZER_FAILED).vw("Init error").wg());
                    return;
                }
                vw(vw2.getManager());
                try {
                    vVar.vw();
                    org.json.JSONObject jSONObject = new org.json.JSONObject();
                    vVar.vw(jSONObject, 20L);
                    jSONObject.put("zeus", com.bytedance.sdk.openadsdk.api.plugin.yl.vw(com.bytedance.sdk.openadsdk.TTAppContextHolder.getContext()).vw());
                    vw2.init(context, wgVar.vw(9, jSONObject).wg());
                    if (context != null) {
                        com.bytedance.pangle.Zeus.hookHuaWeiVerifier((android.app.Application) context.getApplicationContext());
                    }
                } catch (java.lang.Exception e) {
                    com.bytedance.pangle.Zeus.unInstallPlugin("com.byted.pangle");
                    wg(com.bykv.vw.vw.vw.vw.vw.vw().vw(false).vw(4207).vw("Init error").wg());
                    throw e;
                }
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
                wg(com.bykv.vw.vw.vw.vw.vw.vw().vw(false).vw(4203).vw("UnExpected initializer error :" + th.getMessage()).wg());
            }
        } catch (com.bytedance.sdk.openadsdk.api.plugin.vw e2) {
            e2.printStackTrace();
            wg(com.bykv.vw.vw.vw.vw.vw.vw().vw(false).vw(e2.vw()).vw(e2.getMessage()).wg());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.api.vw
    public boolean wg(android.content.Context context, com.bytedance.sdk.openadsdk.AdConfig adConfig, com.bytedance.sdk.openadsdk.TTAdSdk.InitCallback initCallback) {
        super.wg(context, adConfig, initCallback);
        this.t = com.bytedance.sdk.openadsdk.api.plugin.v.vw("duration");
        if (com.bytedance.android.openliveplugin.process.LiveProcessUtils.inLiveProcess(com.bytedance.sdk.openadsdk.TTAppContextHolder.getContext()).booleanValue()) {
            return false;
        }
        com.bytedance.sdk.openadsdk.api.plugin.t.vw(adConfig);
        return true;
    }
}
