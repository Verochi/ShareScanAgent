package com.bytedance.sdk.openadsdk.bt.vw.vw.vw;

/* loaded from: classes22.dex */
public class v implements com.bykv.vk.openvk.api.proto.Bridge {
    private com.bykv.vk.openvk.api.proto.ValueSet vw = com.bykv.vw.vw.vw.vw.wg.vw;
    private final com.bytedance.sdk.openadsdk.TTAdNative.NativeAdListener wg;

    public v(com.bytedance.sdk.openadsdk.TTAdNative.NativeAdListener nativeAdListener) {
        this.wg = nativeAdListener;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0050, code lost:
    
        return null;
     */
    @Override // com.bykv.vk.openvk.api.proto.Caller
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public <T> T call(int i, com.bykv.vk.openvk.api.proto.ValueSet valueSet, java.lang.Class<T> cls) {
        if (this.wg != null) {
            switch (i) {
                case 143101:
                    this.wg.onError(valueSet.intValue(0), (java.lang.String) valueSet.objectValue(1, java.lang.String.class));
                    break;
                case 143102:
                    java.util.List list = (java.util.List) valueSet.objectValue(0, java.util.List.class);
                    if (list == null) {
                        list = new java.util.ArrayList(0);
                    }
                    java.util.ArrayList arrayList = new java.util.ArrayList();
                    java.util.Iterator it = list.iterator();
                    while (it.hasNext()) {
                        arrayList.add(new com.bytedance.sdk.openadsdk.t.vw.vw.cp((com.bykv.vk.openvk.api.proto.Bridge) it.next()));
                    }
                    this.wg.onNativeAdLoad(arrayList);
                    break;
            }
        } else {
            return null;
        }
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public com.bykv.vk.openvk.api.proto.ValueSet values() {
        return this.vw;
    }
}
