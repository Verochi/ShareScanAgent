package com.bytedance.sdk.openadsdk.api;

/* loaded from: classes22.dex */
public abstract class vw {
    private com.bytedance.sdk.openadsdk.TTAdSdk.InitCallback vw;

    /* renamed from: com.bytedance.sdk.openadsdk.api.vw$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ android.content.Context vw;
        final /* synthetic */ com.bykv.vw.vw.vw.vw.wg wg;

        public AnonymousClass1(android.content.Context context, com.bykv.vw.vw.vw.vw.wg wgVar) {
            this.vw = context;
            this.wg = wgVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.bytedance.sdk.openadsdk.api.vw.this.wg(this.vw, this.wg);
        }
    }

    public static abstract class t implements com.bytedance.sdk.openadsdk.TTAdManager {
        private java.util.List<java.lang.ref.WeakReference<com.bytedance.sdk.openadsdk.api.vw.wg<com.bykv.vk.openvk.api.proto.Manager>>> t = new java.util.concurrent.CopyOnWriteArrayList();
        private volatile com.bykv.vk.openvk.api.proto.Manager vw;
        private volatile boolean wg;

        /* renamed from: com.bytedance.sdk.openadsdk.api.vw$t$1, reason: invalid class name */
        public class AnonymousClass1 extends com.bytedance.sdk.openadsdk.api.vw.AbstractC0275vw<com.bykv.vk.openvk.api.proto.Loader> {
            final /* synthetic */ java.lang.ref.SoftReference t;
            com.bykv.vk.openvk.api.proto.Loader vw;
            final com.bytedance.sdk.openadsdk.api.vw.wg<com.bykv.vk.openvk.api.proto.Manager> wg;

            /* renamed from: com.bytedance.sdk.openadsdk.api.vw$t$1$1, reason: invalid class name and collision with other inner class name */
            public class C02741 implements com.bytedance.sdk.openadsdk.api.vw.wg<com.bykv.vk.openvk.api.proto.Manager> {
                public C02741() {
                }

                @Override // com.bytedance.sdk.openadsdk.api.vw.wg
                public void vw(com.bykv.vk.openvk.api.proto.Manager manager) {
                    com.bytedance.sdk.openadsdk.api.vw.t.AnonymousClass1 anonymousClass1 = com.bytedance.sdk.openadsdk.api.vw.t.AnonymousClass1.this;
                    anonymousClass1.vw = manager.createLoader((android.content.Context) anonymousClass1.t.get());
                }
            }

            /* renamed from: com.bytedance.sdk.openadsdk.api.vw$t$1$2, reason: invalid class name */
            public class AnonymousClass2 implements com.bytedance.sdk.openadsdk.api.vw.wg<com.bykv.vk.openvk.api.proto.Manager> {
                final /* synthetic */ com.bytedance.sdk.openadsdk.api.vw.wg vw;

                public AnonymousClass2(com.bytedance.sdk.openadsdk.api.vw.wg wgVar) {
                    this.vw = wgVar;
                }

                @Override // com.bytedance.sdk.openadsdk.api.vw.wg
                public void vw(com.bykv.vk.openvk.api.proto.Manager manager) {
                    com.bytedance.sdk.openadsdk.api.vw.t.AnonymousClass1 anonymousClass1 = com.bytedance.sdk.openadsdk.api.vw.t.AnonymousClass1.this;
                    com.bytedance.sdk.openadsdk.api.vw.t.this.vw(anonymousClass1.wg);
                    com.bytedance.sdk.openadsdk.api.vw.t.AnonymousClass1 anonymousClass12 = com.bytedance.sdk.openadsdk.api.vw.t.AnonymousClass1.this;
                    anonymousClass12.vw = manager.createLoader((android.content.Context) anonymousClass12.t.get());
                    this.vw.vw(com.bytedance.sdk.openadsdk.api.vw.t.AnonymousClass1.this.vw);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(java.lang.ref.SoftReference softReference) {
                super(null);
                this.t = softReference;
                this.wg = new com.bytedance.sdk.openadsdk.api.vw.t.AnonymousClass1.C02741();
            }

            @Override // com.bytedance.sdk.openadsdk.api.vw.AbstractC0275vw
            public void vw(com.bytedance.sdk.openadsdk.api.vw.wg<com.bykv.vk.openvk.api.proto.Loader> wgVar, int i) {
                com.bykv.vk.openvk.api.proto.Loader loader = this.vw;
                if (loader != null) {
                    wgVar.vw(loader);
                } else {
                    com.bytedance.sdk.openadsdk.api.vw.t.this.call(new com.bytedance.sdk.openadsdk.api.vw.t.AnonymousClass1.AnonymousClass2(wgVar), i + 10000);
                }
            }
        }

        /* renamed from: com.bytedance.sdk.openadsdk.api.vw$t$2, reason: invalid class name */
        public class AnonymousClass2 implements com.bytedance.sdk.openadsdk.api.vw.wg<com.bykv.vk.openvk.api.proto.Manager> {
            final /* synthetic */ java.lang.Object vw;

            public AnonymousClass2(java.lang.Object obj) {
                this.vw = obj;
            }

            @Override // com.bytedance.sdk.openadsdk.api.vw.wg
            public void vw(com.bykv.vk.openvk.api.proto.Manager manager) {
                manager.getBridge(1).call(4, com.bykv.vw.vw.vw.vw.wg.vw(1).vw(8, com.bytedance.sdk.openadsdk.api.vw.t.this.vw(this.vw)).wg(), java.lang.Void.class);
            }
        }

        /* renamed from: com.bytedance.sdk.openadsdk.api.vw$t$3, reason: invalid class name */
        public class AnonymousClass3 implements com.bytedance.sdk.openadsdk.api.vw.wg<com.bykv.vk.openvk.api.proto.Manager> {
            final /* synthetic */ java.lang.Object vw;

            public AnonymousClass3(java.lang.Object obj) {
                this.vw = obj;
            }

            @Override // com.bytedance.sdk.openadsdk.api.vw.wg
            public void vw(com.bykv.vk.openvk.api.proto.Manager manager) {
                manager.getBridge(1).call(5, com.bykv.vw.vw.vw.vw.wg.vw(1).vw(8, this.vw).wg(), java.lang.Void.class);
            }
        }

        /* renamed from: com.bytedance.sdk.openadsdk.api.vw$t$4, reason: invalid class name */
        public class AnonymousClass4 implements com.bytedance.sdk.openadsdk.api.vw.wg<com.bykv.vk.openvk.api.proto.Manager> {
            final /* synthetic */ java.lang.Class vw;
            final /* synthetic */ android.os.Bundle wg;

            public AnonymousClass4(java.lang.Class cls, android.os.Bundle bundle) {
                this.vw = cls;
                this.wg = bundle;
            }

            @Override // com.bytedance.sdk.openadsdk.api.vw.wg
            public void vw(com.bykv.vk.openvk.api.proto.Manager manager) {
                com.bytedance.sdk.openadsdk.api.vw.t.wg(com.bytedance.sdk.openadsdk.api.vw.t.this.vw, this.vw, this.wg);
            }
        }

        /* renamed from: com.bytedance.sdk.openadsdk.api.vw$t$5, reason: invalid class name */
        public class AnonymousClass5 implements com.bytedance.sdk.openadsdk.api.vw.wg<com.bykv.vk.openvk.api.proto.Manager> {
            final /* synthetic */ android.content.Context vw;

            public AnonymousClass5(android.content.Context context) {
                this.vw = context;
            }

            @Override // com.bytedance.sdk.openadsdk.api.vw.wg
            public void vw(com.bykv.vk.openvk.api.proto.Manager manager) {
                manager.getBridge(1).call(3, com.bykv.vw.vw.vw.vw.wg.vw(1).vw(7, this.vw).wg(), java.lang.Void.class);
            }
        }

        /* renamed from: com.bytedance.sdk.openadsdk.api.vw$t$6, reason: invalid class name */
        public class AnonymousClass6 implements com.bytedance.sdk.openadsdk.api.vw.wg<com.bykv.vk.openvk.api.proto.Manager> {
            final /* synthetic */ int vw;

            public AnonymousClass6(int i) {
                this.vw = i;
            }

            @Override // com.bytedance.sdk.openadsdk.api.vw.wg
            public void vw(com.bykv.vk.openvk.api.proto.Manager manager) {
                manager.getBridge(1).call(1, com.bykv.vw.vw.vw.vw.wg.vw().vw(11, this.vw).wg(), java.lang.Void.class);
            }
        }

        /* renamed from: com.bytedance.sdk.openadsdk.api.vw$t$7, reason: invalid class name */
        public class AnonymousClass7 implements java.lang.Runnable {
            final /* synthetic */ com.bytedance.sdk.openadsdk.api.vw.wg vw;
            final /* synthetic */ int wg;

            public AnonymousClass7(com.bytedance.sdk.openadsdk.api.vw.wg wgVar, int i) {
                this.vw = wgVar;
                this.wg = i;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (com.bytedance.sdk.openadsdk.api.vw.t.this.vw != null) {
                        this.vw.vw(com.bytedance.sdk.openadsdk.api.vw.t.this.vw);
                        return;
                    }
                    com.bytedance.sdk.openadsdk.api.t.v("_tt_ad_sdk_", "Not ready, no manager: " + this.wg);
                } catch (java.lang.Throwable th) {
                    com.bytedance.sdk.openadsdk.api.t.v("_tt_ad_sdk_", "Unexpected manager call error: " + th.getMessage());
                    com.bytedance.sdk.openadsdk.api.vw.t.this.vw(th);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void call(com.bytedance.sdk.openadsdk.api.vw.wg<com.bykv.vk.openvk.api.proto.Manager> wgVar, int i) {
            if (this.vw == null) {
                if (!this.wg && i > 10000) {
                    throw new java.lang.IllegalStateException("广告SDK未Ready, 请在load(请求广告）之前，先调用init and start方法，以避免无法请求广告");
                }
                com.bytedance.sdk.openadsdk.yl.vw.vw().vw(new com.bytedance.sdk.openadsdk.api.vw.t.AnonymousClass7(wgVar, i));
                return;
            }
            try {
                wgVar.vw(this.vw);
            } catch (java.lang.Throwable th) {
                com.bytedance.sdk.openadsdk.api.t.v("_tt_ad_sdk_", "Unexpected manager call error: " + th.getMessage());
                vw(th);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void vw(com.bykv.vk.openvk.api.proto.Manager manager) {
            this.vw = manager;
            if (this.vw != null) {
                java.util.Iterator<java.lang.ref.WeakReference<com.bytedance.sdk.openadsdk.api.vw.wg<com.bykv.vk.openvk.api.proto.Manager>>> it = this.t.iterator();
                while (it.hasNext()) {
                    java.lang.ref.WeakReference<com.bytedance.sdk.openadsdk.api.vw.wg<com.bykv.vk.openvk.api.proto.Manager>> next = it.next();
                    com.bytedance.sdk.openadsdk.api.vw.wg<com.bykv.vk.openvk.api.proto.Manager> wgVar = next != null ? next.get() : null;
                    if (wgVar != null) {
                        wgVar.vw(manager);
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void vw(com.bytedance.sdk.openadsdk.api.vw.wg<com.bykv.vk.openvk.api.proto.Manager> wgVar) {
            this.t.add(new java.lang.ref.WeakReference<>(wgVar));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static <T> T wg(com.bykv.vk.openvk.api.proto.Manager manager, java.lang.Class<T> cls, android.os.Bundle bundle) {
            return (T) manager.getBridge(1).call(6, com.bykv.vw.vw.vw.vw.wg.vw(2).vw(9, cls).vw(10, bundle).wg(), cls);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdManager
        public com.bytedance.sdk.openadsdk.TTAdNative createAdNative(android.content.Context context) {
            return new com.bytedance.sdk.openadsdk.api.vw.yl(new com.bytedance.sdk.openadsdk.api.vw.t.AnonymousClass1(new java.lang.ref.SoftReference(context))).vw();
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdManager
        public java.lang.String getBiddingToken(com.bytedance.sdk.openadsdk.AdSlot adSlot) {
            return getBiddingToken(adSlot, false, adSlot.getAdType() > 0 ? adSlot.getAdType() : adSlot.getNativeAdType());
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdManager
        public java.lang.String getBiddingToken(com.bytedance.sdk.openadsdk.AdSlot adSlot, boolean z, int i) {
            if (i <= 0) {
                i = adSlot.getAdType() > 0 ? adSlot.getAdType() : adSlot.getNativeAdType();
            }
            com.bykv.vk.openvk.api.proto.ValueSet wg = com.bykv.vw.vw.vw.vw.wg.vw(com.bytedance.sdk.openadsdk.t.vw.t.wg.vw(adSlot)).vw(13, z).vw(14, i).wg();
            if (this.vw != null) {
                return (java.lang.String) this.vw.getBridge(1).call(2, wg, java.lang.String.class);
            }
            return null;
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdManager
        public <T> T getExtra(java.lang.Class<T> cls, android.os.Bundle bundle) {
            if (this.vw != null) {
                return (T) wg(this.vw, cls, bundle);
            }
            call(new com.bytedance.sdk.openadsdk.api.vw.t.AnonymousClass4(cls, bundle), 6);
            return null;
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdManager
        public java.lang.String getPluginVersion() {
            return this.vw != null ? this.vw.values().stringValue(12) : "";
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdManager
        public java.lang.String getSDKVersion() {
            return "6.2.1.9";
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdManager
        public int getThemeStatus() {
            if (this.vw != null) {
                return this.vw.values().intValue(11);
            }
            return 0;
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdManager
        public void register(java.lang.Object obj) {
            call(new com.bytedance.sdk.openadsdk.api.vw.t.AnonymousClass2(obj), 4);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdManager
        public void requestPermissionIfNecessary(android.content.Context context) {
            call(new com.bytedance.sdk.openadsdk.api.vw.t.AnonymousClass5(context), 3);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdManager
        public void setThemeStatus(int i) {
            call(new com.bytedance.sdk.openadsdk.api.vw.t.AnonymousClass6(i), 1);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdManager
        public boolean tryShowInstallDialogWhenExit(android.app.Activity activity, com.bytedance.sdk.openadsdk.downloadnew.core.ExitInstallListener exitInstallListener) {
            java.util.HashMap hashMap = new java.util.HashMap();
            hashMap.put("activity", activity);
            hashMap.put(com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_EXIT_INSTALL_LISTENER, exitInstallListener);
            return ((java.lang.Boolean) com.bytedance.sdk.openadsdk.downloadnew.core.DownloadBridgeFactory.getDownloadBridge(com.bytedance.sdk.openadsdk.TTAppContextHolder.getContext()).call(0, com.bykv.vw.vw.vw.vw.wg.vw(1).vw(0, hashMap).wg(), java.lang.Boolean.class)).booleanValue();
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdManager
        public void unregister(java.lang.Object obj) {
            call(new com.bytedance.sdk.openadsdk.api.vw.t.AnonymousClass3(obj), 5);
        }

        public java.lang.Object vw(java.lang.Object obj) {
            return obj;
        }

        public void vw(java.lang.Throwable th) {
        }

        public void vw(boolean z) {
            this.wg = z;
        }
    }

    public class v implements com.bykv.vk.openvk.api.proto.EventListener {
        private v() {
        }

        public /* synthetic */ v(com.bytedance.sdk.openadsdk.api.vw vwVar, com.bytedance.sdk.openadsdk.api.vw.AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.bykv.vk.openvk.api.proto.EventListener
        public com.bykv.vk.openvk.api.proto.ValueSet onEvent(int i, com.bykv.vk.openvk.api.proto.Result result) {
            com.bytedance.sdk.openadsdk.api.vw.this.wg(result);
            return null;
        }
    }

    /* renamed from: com.bytedance.sdk.openadsdk.api.vw$vw, reason: collision with other inner class name */
    public static abstract class AbstractC0275vw<T> {
        private AbstractC0275vw() {
        }

        public /* synthetic */ AbstractC0275vw(com.bytedance.sdk.openadsdk.api.vw.AnonymousClass1 anonymousClass1) {
            this();
        }

        public abstract void vw(com.bytedance.sdk.openadsdk.api.vw.wg<T> wgVar, int i);
    }

    public interface wg<T> {
        void vw(T t);
    }

    public static class yl extends com.bytedance.sdk.openadsdk.t.vw.vw {
        private com.bytedance.sdk.openadsdk.api.vw.AbstractC0275vw<com.bykv.vk.openvk.api.proto.Loader> vw;

        /* renamed from: com.bytedance.sdk.openadsdk.api.vw$yl$1, reason: invalid class name */
        public class AnonymousClass1 implements com.bytedance.sdk.openadsdk.api.vw.wg<com.bykv.vk.openvk.api.proto.Loader> {
            final /* synthetic */ com.bykv.vk.openvk.api.proto.ValueSet vw;
            final /* synthetic */ com.bykv.vk.openvk.api.proto.Bridge wg;

            public AnonymousClass1(com.bykv.vk.openvk.api.proto.ValueSet valueSet, com.bykv.vk.openvk.api.proto.Bridge bridge) {
                this.vw = valueSet;
                this.wg = bridge;
            }

            @Override // com.bytedance.sdk.openadsdk.api.vw.wg
            public void vw(com.bykv.vk.openvk.api.proto.Loader loader) {
                loader.load(5, com.bykv.vw.vw.vw.vw.wg.vw(this.vw).vw(1, this.wg).wg(), null);
            }
        }

        /* renamed from: com.bytedance.sdk.openadsdk.api.vw$yl$10, reason: invalid class name */
        public class AnonymousClass10 implements com.bytedance.sdk.openadsdk.api.vw.wg<com.bykv.vk.openvk.api.proto.Loader> {
            final /* synthetic */ com.bykv.vk.openvk.api.proto.ValueSet vw;
            final /* synthetic */ com.bykv.vk.openvk.api.proto.Bridge wg;

            public AnonymousClass10(com.bykv.vk.openvk.api.proto.ValueSet valueSet, com.bykv.vk.openvk.api.proto.Bridge bridge) {
                this.vw = valueSet;
                this.wg = bridge;
            }

            @Override // com.bytedance.sdk.openadsdk.api.vw.wg
            public void vw(com.bykv.vk.openvk.api.proto.Loader loader) {
                loader.load(9, com.bykv.vw.vw.vw.vw.wg.vw(this.vw).vw(2, true).vw(1, this.wg).wg(), null);
            }
        }

        /* renamed from: com.bytedance.sdk.openadsdk.api.vw$yl$2, reason: invalid class name */
        public class AnonymousClass2 implements com.bytedance.sdk.openadsdk.api.vw.wg<com.bykv.vk.openvk.api.proto.Loader> {
            final /* synthetic */ com.bykv.vk.openvk.api.proto.ValueSet vw;
            final /* synthetic */ com.bykv.vk.openvk.api.proto.Bridge wg;

            public AnonymousClass2(com.bykv.vk.openvk.api.proto.ValueSet valueSet, com.bykv.vk.openvk.api.proto.Bridge bridge) {
                this.vw = valueSet;
                this.wg = bridge;
            }

            @Override // com.bytedance.sdk.openadsdk.api.vw.wg
            public void vw(com.bykv.vk.openvk.api.proto.Loader loader) {
                loader.load(1, com.bykv.vw.vw.vw.vw.wg.vw(this.vw).vw(2, true).vw(1, this.wg).wg(), null);
            }
        }

        /* renamed from: com.bytedance.sdk.openadsdk.api.vw$yl$3, reason: invalid class name */
        public class AnonymousClass3 implements com.bytedance.sdk.openadsdk.api.vw.wg<com.bykv.vk.openvk.api.proto.Loader> {
            final /* synthetic */ com.bykv.vk.openvk.api.proto.ValueSet vw;
            final /* synthetic */ com.bykv.vk.openvk.api.proto.Bridge wg;

            public AnonymousClass3(com.bykv.vk.openvk.api.proto.ValueSet valueSet, com.bykv.vk.openvk.api.proto.Bridge bridge) {
                this.vw = valueSet;
                this.wg = bridge;
            }

            @Override // com.bytedance.sdk.openadsdk.api.vw.wg
            public void vw(com.bykv.vk.openvk.api.proto.Loader loader) {
                loader.load(6, com.bykv.vw.vw.vw.vw.wg.vw(this.vw).vw(1, this.wg).wg(), null);
            }
        }

        /* renamed from: com.bytedance.sdk.openadsdk.api.vw$yl$4, reason: invalid class name */
        public class AnonymousClass4 implements com.bytedance.sdk.openadsdk.api.vw.wg<com.bykv.vk.openvk.api.proto.Loader> {
            final /* synthetic */ com.bykv.vk.openvk.api.proto.ValueSet vw;
            final /* synthetic */ com.bykv.vk.openvk.api.proto.Bridge wg;

            public AnonymousClass4(com.bykv.vk.openvk.api.proto.ValueSet valueSet, com.bykv.vk.openvk.api.proto.Bridge bridge) {
                this.vw = valueSet;
                this.wg = bridge;
            }

            @Override // com.bytedance.sdk.openadsdk.api.vw.wg
            public void vw(com.bykv.vk.openvk.api.proto.Loader loader) {
                loader.load(9, com.bykv.vw.vw.vw.vw.wg.vw(this.vw).vw(1, this.wg).wg(), null);
            }
        }

        /* renamed from: com.bytedance.sdk.openadsdk.api.vw$yl$5, reason: invalid class name */
        public class AnonymousClass5 implements com.bytedance.sdk.openadsdk.api.vw.wg<com.bykv.vk.openvk.api.proto.Loader> {
            final /* synthetic */ com.bykv.vk.openvk.api.proto.ValueSet vw;
            final /* synthetic */ com.bykv.vk.openvk.api.proto.Bridge wg;

            public AnonymousClass5(com.bykv.vk.openvk.api.proto.ValueSet valueSet, com.bykv.vk.openvk.api.proto.Bridge bridge) {
                this.vw = valueSet;
                this.wg = bridge;
            }

            @Override // com.bytedance.sdk.openadsdk.api.vw.wg
            public void vw(com.bykv.vk.openvk.api.proto.Loader loader) {
                loader.load(1, com.bykv.vw.vw.vw.vw.wg.vw(this.vw).vw(1, this.wg).wg(), null);
            }
        }

        /* renamed from: com.bytedance.sdk.openadsdk.api.vw$yl$6, reason: invalid class name */
        public class AnonymousClass6 implements com.bytedance.sdk.openadsdk.api.vw.wg<com.bykv.vk.openvk.api.proto.Loader> {
            final /* synthetic */ com.bykv.vk.openvk.api.proto.Bridge t;
            final /* synthetic */ com.bykv.vk.openvk.api.proto.ValueSet vw;
            final /* synthetic */ int wg;

            public AnonymousClass6(com.bykv.vk.openvk.api.proto.ValueSet valueSet, int i, com.bykv.vk.openvk.api.proto.Bridge bridge) {
                this.vw = valueSet;
                this.wg = i;
                this.t = bridge;
            }

            @Override // com.bytedance.sdk.openadsdk.api.vw.wg
            public void vw(com.bykv.vk.openvk.api.proto.Loader loader) {
                loader.load(3, com.bykv.vw.vw.vw.vw.wg.vw(this.vw).vw(3, this.wg).vw(1, this.t).wg(), null);
            }
        }

        /* renamed from: com.bytedance.sdk.openadsdk.api.vw$yl$7, reason: invalid class name */
        public class AnonymousClass7 implements com.bytedance.sdk.openadsdk.api.vw.wg<com.bykv.vk.openvk.api.proto.Loader> {
            final /* synthetic */ com.bykv.vk.openvk.api.proto.ValueSet vw;
            final /* synthetic */ com.bykv.vk.openvk.api.proto.Bridge wg;

            public AnonymousClass7(com.bykv.vk.openvk.api.proto.ValueSet valueSet, com.bykv.vk.openvk.api.proto.Bridge bridge) {
                this.vw = valueSet;
                this.wg = bridge;
            }

            @Override // com.bytedance.sdk.openadsdk.api.vw.wg
            public void vw(com.bykv.vk.openvk.api.proto.Loader loader) {
                loader.load(7, com.bykv.vw.vw.vw.vw.wg.vw(this.vw).vw(1, this.wg).wg(), null);
            }
        }

        /* renamed from: com.bytedance.sdk.openadsdk.api.vw$yl$8, reason: invalid class name */
        public class AnonymousClass8 implements com.bytedance.sdk.openadsdk.api.vw.wg<com.bykv.vk.openvk.api.proto.Loader> {
            final /* synthetic */ com.bykv.vk.openvk.api.proto.ValueSet vw;
            final /* synthetic */ com.bykv.vk.openvk.api.proto.Bridge wg;

            public AnonymousClass8(com.bykv.vk.openvk.api.proto.ValueSet valueSet, com.bykv.vk.openvk.api.proto.Bridge bridge) {
                this.vw = valueSet;
                this.wg = bridge;
            }

            @Override // com.bytedance.sdk.openadsdk.api.vw.wg
            public void vw(com.bykv.vk.openvk.api.proto.Loader loader) {
                loader.load(8, com.bykv.vw.vw.vw.vw.wg.vw(this.vw).vw(1, this.wg).wg(), null);
            }
        }

        /* renamed from: com.bytedance.sdk.openadsdk.api.vw$yl$9, reason: invalid class name */
        public class AnonymousClass9 implements com.bytedance.sdk.openadsdk.api.vw.wg<com.bykv.vk.openvk.api.proto.Loader> {
            final /* synthetic */ com.bykv.vk.openvk.api.proto.ValueSet vw;
            final /* synthetic */ com.bykv.vk.openvk.api.proto.Bridge wg;

            public AnonymousClass9(com.bykv.vk.openvk.api.proto.ValueSet valueSet, com.bykv.vk.openvk.api.proto.Bridge bridge) {
                this.vw = valueSet;
                this.wg = bridge;
            }

            @Override // com.bytedance.sdk.openadsdk.api.vw.wg
            public void vw(com.bykv.vk.openvk.api.proto.Loader loader) {
                loader.load(5, com.bykv.vw.vw.vw.vw.wg.vw(this.vw).vw(2, true).vw(1, this.wg).wg(), null);
            }
        }

        public yl(com.bytedance.sdk.openadsdk.api.vw.AbstractC0275vw<com.bykv.vk.openvk.api.proto.Loader> abstractC0275vw) {
            this.vw = abstractC0275vw;
        }

        private void vw(com.bytedance.sdk.openadsdk.api.vw.wg<com.bykv.vk.openvk.api.proto.Loader> wgVar, int i) {
            com.bytedance.sdk.openadsdk.api.t.wg("_tt_ad_sdk_", "load ad slot type: ".concat(java.lang.String.valueOf(i)));
            this.vw.vw(wgVar, i);
        }

        @Override // com.bytedance.sdk.openadsdk.t.vw.vw
        public void bt(com.bykv.vk.openvk.api.proto.ValueSet valueSet, com.bykv.vk.openvk.api.proto.Bridge bridge) {
            vw(new com.bytedance.sdk.openadsdk.api.vw.yl.AnonymousClass9(valueSet, bridge), 5);
        }

        @Override // com.bytedance.sdk.openadsdk.t.vw.vw
        public void kz(com.bykv.vk.openvk.api.proto.ValueSet valueSet, com.bykv.vk.openvk.api.proto.Bridge bridge) {
            vw(new com.bytedance.sdk.openadsdk.api.vw.yl.AnonymousClass8(valueSet, bridge), 8);
        }

        @Override // com.bytedance.sdk.openadsdk.t.vw.vw
        public void o(com.bykv.vk.openvk.api.proto.ValueSet valueSet, com.bykv.vk.openvk.api.proto.Bridge bridge) {
            vw(new com.bytedance.sdk.openadsdk.api.vw.yl.AnonymousClass10(valueSet, bridge), 9);
        }

        @Override // com.bytedance.sdk.openadsdk.t.vw.vw
        public void t(com.bykv.vk.openvk.api.proto.ValueSet valueSet, com.bykv.vk.openvk.api.proto.Bridge bridge) {
            vw(new com.bytedance.sdk.openadsdk.api.vw.yl.AnonymousClass4(valueSet, bridge), 9);
        }

        @Override // com.bytedance.sdk.openadsdk.t.vw.vw
        public void v(com.bykv.vk.openvk.api.proto.ValueSet valueSet, com.bykv.vk.openvk.api.proto.Bridge bridge) {
            vw(new com.bytedance.sdk.openadsdk.api.vw.yl.AnonymousClass5(valueSet, bridge), 1);
        }

        @Override // com.bytedance.sdk.openadsdk.t.vw.vw
        public android.util.Pair<java.lang.Integer, java.lang.String> vw(java.lang.Exception exc) {
            com.bytedance.sdk.openadsdk.api.t.v("_tt_ad_sdk_", "Load ad failed: " + exc.getMessage());
            if ((exc instanceof java.lang.IllegalStateException) && "广告SDK未Ready, 请在load(请求广告）之前，先调用init and start方法，以避免无法请求广告".equals(exc.getMessage())) {
                return new android.util.Pair<>(4208, exc.getMessage());
            }
            return new android.util.Pair<>(java.lang.Integer.valueOf(com.bytedance.sdk.openadsdk.TTAdConstant.INIT_FAILED_CREATE_INVOKE_FAILED), "Load ad failed: " + exc.getMessage());
        }

        @Override // com.bytedance.sdk.openadsdk.t.vw.vw
        public void vw(com.bykv.vk.openvk.api.proto.ValueSet valueSet, com.bykv.vk.openvk.api.proto.Bridge bridge) {
            vw(new com.bytedance.sdk.openadsdk.api.vw.yl.AnonymousClass1(valueSet, bridge), 5);
        }

        @Override // com.bytedance.sdk.openadsdk.t.vw.vw
        public void vw(com.bykv.vk.openvk.api.proto.ValueSet valueSet, com.bykv.vk.openvk.api.proto.Bridge bridge, int i) {
            vw(new com.bytedance.sdk.openadsdk.api.vw.yl.AnonymousClass6(valueSet, i, bridge), 3);
        }

        @Override // com.bytedance.sdk.openadsdk.t.vw.vw
        public void wg(com.bykv.vk.openvk.api.proto.ValueSet valueSet, com.bykv.vk.openvk.api.proto.Bridge bridge) {
            vw(new com.bytedance.sdk.openadsdk.api.vw.yl.AnonymousClass3(valueSet, bridge), 6);
        }

        @Override // com.bytedance.sdk.openadsdk.t.vw.vw
        public void x(com.bykv.vk.openvk.api.proto.ValueSet valueSet, com.bykv.vk.openvk.api.proto.Bridge bridge) {
            vw(new com.bytedance.sdk.openadsdk.api.vw.yl.AnonymousClass2(valueSet, bridge), 1);
        }

        @Override // com.bytedance.sdk.openadsdk.t.vw.vw
        public void yl(com.bykv.vk.openvk.api.proto.ValueSet valueSet, com.bykv.vk.openvk.api.proto.Bridge bridge) {
            vw(new com.bytedance.sdk.openadsdk.api.vw.yl.AnonymousClass7(valueSet, bridge), 7);
        }
    }

    public abstract com.bytedance.sdk.openadsdk.vw.wg t();

    public void vw(android.content.Context context, com.bytedance.sdk.openadsdk.AdConfig adConfig, com.bytedance.sdk.openadsdk.TTAdSdk.InitCallback initCallback) {
        com.bytedance.sdk.openadsdk.vw.t.vw().vw(t());
        if (wg(context, adConfig, initCallback)) {
            this.vw = initCallback;
            com.bykv.vw.vw.vw.vw.wg vw = com.bykv.vw.vw.vw.vw.wg.vw(com.bytedance.sdk.openadsdk.t.vw.t.vw.vw(adConfig));
            vw.vw(1, android.os.SystemClock.elapsedRealtime());
            vw.vw(5, "main");
            vw.vw(4, true);
            vw.vw(6, 999);
            vw.vw(10, 6219);
            vw.vw(11, "6.2.1.9");
            vw.vw(12, "com.byted.pangle");
            vw.vw(14, false);
            vw.vw(16, com.bytedance.sdk.openadsdk.vw.t.vw());
            java.lang.Thread currentThread = java.lang.Thread.currentThread();
            vw.vw(2, currentThread.getName());
            vw.vw(3, currentThread.getPriority());
            vw.vw(15, new com.bytedance.sdk.openadsdk.api.vw.v(this, null));
            if (!vw(context, vw)) {
                com.bytedance.sdk.openadsdk.yl.vw.vw().vw(new com.bytedance.sdk.openadsdk.api.vw.AnonymousClass1(context, vw));
            }
            wg().vw(true);
        }
    }

    public void vw(com.bykv.vk.openvk.api.proto.Manager manager) {
        com.bytedance.sdk.openadsdk.api.t.wg("_tt_ad_sdk_", "update manager");
        wg().vw(manager);
        wg().register(com.bytedance.sdk.openadsdk.vw.t.vw());
    }

    public void vw(com.bykv.vk.openvk.api.proto.Result result) {
    }

    public abstract boolean vw();

    public abstract boolean vw(android.content.Context context, com.bykv.vw.vw.vw.vw.wg wgVar);

    public abstract com.bytedance.sdk.openadsdk.api.vw.t wg();

    public abstract void wg(android.content.Context context, com.bykv.vw.vw.vw.vw.wg wgVar);

    public void wg(com.bykv.vk.openvk.api.proto.Result result) {
        vw(result);
        if (result.isSuccess()) {
            com.bytedance.sdk.openadsdk.api.t.wg("_tt_ad_sdk_", "init sdk success ");
            com.bytedance.sdk.openadsdk.TTAdSdk.InitCallback initCallback = this.vw;
            if (initCallback != null) {
                initCallback.success();
            }
        } else {
            com.bytedance.sdk.openadsdk.api.t.yl("_tt_ad_sdk_", "int sdk failed, code: " + result.code() + ", message: " + result.message());
            com.bytedance.sdk.openadsdk.TTAdSdk.InitCallback initCallback2 = this.vw;
            if (initCallback2 != null) {
                initCallback2.fail(result.code(), result.message() != null ? result.message() : "");
            }
        }
        this.vw = null;
    }

    public boolean wg(android.content.Context context, com.bytedance.sdk.openadsdk.AdConfig adConfig, com.bytedance.sdk.openadsdk.TTAdSdk.InitCallback initCallback) {
        return false;
    }
}
