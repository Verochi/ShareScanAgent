package com.bytedance.sdk.openadsdk.vw;

/* loaded from: classes22.dex */
public final class t implements com.bykv.vk.openvk.api.proto.Bridge {
    private static volatile com.bytedance.sdk.openadsdk.vw.t vw;
    private com.bytedance.sdk.openadsdk.vw.vw t = new com.bytedance.sdk.openadsdk.vw.vw();
    private com.bytedance.sdk.openadsdk.vw.wg wg;

    /* renamed from: com.bytedance.sdk.openadsdk.vw.t$1, reason: invalid class name */
    public class AnonymousClass1 implements com.bytedance.sdk.openadsdk.vw.vw.InterfaceC0280vw {
        final /* synthetic */ com.bykv.vk.openvk.api.proto.EventListener vw;

        public AnonymousClass1(com.bykv.vk.openvk.api.proto.EventListener eventListener) {
            this.vw = eventListener;
        }

        @Override // com.bytedance.sdk.openadsdk.vw.vw.InterfaceC0280vw
        public void vw() {
            this.vw.onEvent(0, null);
        }

        @Override // com.bytedance.sdk.openadsdk.vw.vw.InterfaceC0280vw
        public void wg() {
            this.vw.onEvent(1, null);
        }
    }

    private t() {
    }

    public static com.bytedance.sdk.openadsdk.vw.t vw() {
        if (vw == null) {
            synchronized (com.bytedance.sdk.openadsdk.vw.t.class) {
                if (vw == null) {
                    vw = new com.bytedance.sdk.openadsdk.vw.t();
                }
            }
        }
        return vw;
    }

    private void vw(com.bykv.vk.openvk.api.proto.EventListener eventListener) {
        this.t.vw(new com.bytedance.sdk.openadsdk.vw.t.AnonymousClass1(eventListener));
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i, com.bykv.vk.openvk.api.proto.ValueSet valueSet, java.lang.Class<T> cls) {
        com.bykv.vk.openvk.api.proto.Bridge vw2;
        switch (i) {
            case 2:
                return (T) this.t.vw();
            case 3:
                return (T) com.bytedance.sdk.openadsdk.TTAppContextHolder.getContext();
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
                com.bytedance.sdk.openadsdk.vw.wg wgVar = this.wg;
                if (wgVar == null || (vw2 = wgVar.vw(4)) == null) {
                    return null;
                }
                return (T) vw2.call(i, valueSet, cls);
            case 9:
                java.lang.Object objectValue = valueSet.objectValue(0, java.lang.Object.class);
                if (objectValue instanceof com.bykv.vk.openvk.api.proto.EventListener) {
                    vw((com.bykv.vk.openvk.api.proto.EventListener) objectValue);
                }
                return null;
            case 10:
                com.bytedance.sdk.openadsdk.vw.wg wgVar2 = this.wg;
                if (wgVar2 == null) {
                    return null;
                }
                return (T) wgVar2.vw(valueSet.intValue(0));
            default:
                return null;
        }
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public com.bykv.vk.openvk.api.proto.ValueSet values() {
        return com.bykv.vw.vw.vw.vw.wg.vw().vw(10000, 5).wg();
    }

    public void vw(com.bytedance.sdk.openadsdk.vw.wg wgVar) {
        this.wg = wgVar;
    }

    public android.app.Application.ActivityLifecycleCallbacks wg() {
        return this.t;
    }
}
