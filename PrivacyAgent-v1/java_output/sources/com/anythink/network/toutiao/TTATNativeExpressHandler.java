package com.anythink.network.toutiao;

/* loaded from: classes12.dex */
public class TTATNativeExpressHandler {
    static final java.lang.String a = "TTATNativeExpressHandler";
    final java.util.List<com.bytedance.sdk.openadsdk.TTNativeExpressAd> b;
    final java.util.List<com.anythink.network.toutiao.TTATNativeExpressHandler.TTNativeExpressAdWrapper> c = new java.util.ArrayList();

    /* renamed from: com.anythink.network.toutiao.TTATNativeExpressHandler$1, reason: invalid class name */
    public class AnonymousClass1 implements com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener {
        final /* synthetic */ int[] a;
        final /* synthetic */ com.anythink.network.toutiao.TTATNativeExpressHandler.RenderCallback b;
        final /* synthetic */ com.bytedance.sdk.openadsdk.TTNativeExpressAd c;

        public AnonymousClass1(int[] iArr, com.anythink.network.toutiao.TTATNativeExpressHandler.RenderCallback renderCallback, com.bytedance.sdk.openadsdk.TTNativeExpressAd tTNativeExpressAd) {
            this.a = iArr;
            this.b = renderCallback;
            this.c = tTNativeExpressAd;
        }

        @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
        public final void onAdClicked(android.view.View view, int i) {
        }

        @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
        public final void onAdShow(android.view.View view, int i) {
        }

        @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
        public final void onRenderFail(android.view.View view, java.lang.String str, int i) {
            java.lang.String str2 = com.anythink.network.toutiao.TTATNativeExpressHandler.a;
            java.lang.String.format("onRenderFail, errorCode: %d, errorMsg: %s", java.lang.Integer.valueOf(i), str);
            int[] iArr = this.a;
            int i2 = iArr[0] - 1;
            iArr[0] = i2;
            if (i2 == 0) {
                if (com.anythink.network.toutiao.TTATNativeExpressHandler.this.c.size() == 0) {
                    com.anythink.network.toutiao.TTATNativeExpressHandler.RenderCallback renderCallback = this.b;
                    if (renderCallback != null) {
                        renderCallback.onRenderFail(str, i);
                        return;
                    }
                    return;
                }
                com.anythink.network.toutiao.TTATNativeExpressHandler.RenderCallback renderCallback2 = this.b;
                if (renderCallback2 != null) {
                    renderCallback2.onRenderSuccess(com.anythink.network.toutiao.TTATNativeExpressHandler.this.c);
                }
                com.anythink.network.toutiao.TTATNativeExpressHandler.this.c.clear();
                com.anythink.network.toutiao.TTATNativeExpressHandler.this.b.clear();
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
        public final void onRenderSuccess(android.view.View view, float f, float f2) {
            java.lang.String str = com.anythink.network.toutiao.TTATNativeExpressHandler.a;
            com.anythink.network.toutiao.TTATNativeExpressHandler tTATNativeExpressHandler = com.anythink.network.toutiao.TTATNativeExpressHandler.this;
            tTATNativeExpressHandler.c.add(tTATNativeExpressHandler.new TTNativeExpressAdWrapper(this.c, f, f2));
            int[] iArr = this.a;
            int i = iArr[0] - 1;
            iArr[0] = i;
            if (i == 0) {
                com.anythink.network.toutiao.TTATNativeExpressHandler.RenderCallback renderCallback = this.b;
                if (renderCallback != null) {
                    renderCallback.onRenderSuccess(com.anythink.network.toutiao.TTATNativeExpressHandler.this.c);
                }
                com.anythink.network.toutiao.TTATNativeExpressHandler.this.c.clear();
                com.anythink.network.toutiao.TTATNativeExpressHandler.this.b.clear();
            }
        }
    }

    public interface RenderCallback {
        void onRenderFail(java.lang.String str, int i);

        void onRenderSuccess(java.util.List<com.anythink.network.toutiao.TTATNativeExpressHandler.TTNativeExpressAdWrapper> list);
    }

    public class TTNativeExpressAdWrapper {
        public float expressHeight;
        public float expressWidth;
        public com.bytedance.sdk.openadsdk.TTNativeExpressAd ttNativeExpressAd;

        public TTNativeExpressAdWrapper(com.bytedance.sdk.openadsdk.TTNativeExpressAd tTNativeExpressAd, float f, float f2) {
            this.ttNativeExpressAd = tTNativeExpressAd;
            this.expressWidth = f;
            this.expressHeight = f2;
        }
    }

    public TTATNativeExpressHandler(java.util.List<com.bytedance.sdk.openadsdk.TTNativeExpressAd> list) {
        this.b = list;
    }

    public void startRender(com.anythink.network.toutiao.TTATNativeExpressHandler.RenderCallback renderCallback) {
        int[] iArr = {this.b.size()};
        for (com.bytedance.sdk.openadsdk.TTNativeExpressAd tTNativeExpressAd : this.b) {
            tTNativeExpressAd.setExpressInteractionListener(new com.anythink.network.toutiao.TTATNativeExpressHandler.AnonymousClass1(iArr, renderCallback, tTNativeExpressAd));
            tTNativeExpressAd.render();
        }
    }
}
