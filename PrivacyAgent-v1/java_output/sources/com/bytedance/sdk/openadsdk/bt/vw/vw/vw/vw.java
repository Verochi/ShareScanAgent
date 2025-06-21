package com.bytedance.sdk.openadsdk.bt.vw.vw.vw;

/* loaded from: classes22.dex */
public class vw implements com.bykv.vk.openvk.api.proto.Bridge {
    private com.bykv.vk.openvk.api.proto.ValueSet vw = com.bykv.vw.vw.vw.vw.wg.vw;
    private final com.bytedance.sdk.openadsdk.TTAdNative.DrawFeedAdListener wg;

    public vw(com.bytedance.sdk.openadsdk.TTAdNative.DrawFeedAdListener drawFeedAdListener) {
        this.wg = drawFeedAdListener;
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
                case 172101:
                    this.wg.onError(valueSet.intValue(0), (java.lang.String) valueSet.objectValue(1, java.lang.String.class));
                    break;
                case 172102:
                    java.util.List list = (java.util.List) valueSet.objectValue(0, java.util.List.class);
                    if (list == null) {
                        list = new java.util.ArrayList(0);
                    }
                    java.util.ArrayList arrayList = new java.util.ArrayList();
                    java.util.Iterator it = list.iterator();
                    while (it.hasNext()) {
                        arrayList.add(new com.bytedance.sdk.openadsdk.t.vw.vw.es((com.bykv.vk.openvk.api.proto.Bridge) it.next()));
                    }
                    this.wg.onDrawFeedAdLoad(arrayList);
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
