package com.anythink.basead.d;

/* loaded from: classes12.dex */
public final class e extends com.anythink.basead.d.b {
    boolean a;

    /* renamed from: com.anythink.basead.d.e$1, reason: invalid class name */
    public class AnonymousClass1 implements com.anythink.basead.e.c {
        final /* synthetic */ com.anythink.basead.e.d a;

        public AnonymousClass1(com.anythink.basead.e.d dVar) {
            this.a = dVar;
        }

        @Override // com.anythink.basead.e.c
        public final void onAdCacheLoaded() {
            com.anythink.basead.d.h a = com.anythink.basead.d.e.this.a();
            com.anythink.basead.e.d dVar = this.a;
            if (dVar != null) {
                dVar.onNativeAdLoaded(a);
            }
        }

        @Override // com.anythink.basead.e.c
        public final void onAdDataLoaded() {
        }

        @Override // com.anythink.basead.e.c
        public final void onAdLoadFailed(com.anythink.basead.c.e eVar) {
            com.anythink.basead.e.d dVar = this.a;
            if (dVar != null) {
                dVar.onNativeAdLoadError(eVar);
            }
        }
    }

    public e(android.content.Context context, com.anythink.basead.d.b.EnumC0136b enumC0136b, com.anythink.core.common.f.m mVar, boolean z) {
        super(context, enumC0136b, mVar);
        this.a = z;
    }

    public final com.anythink.basead.d.h a() {
        return new com.anythink.basead.d.h(this.b, this.e, this.c, this.f, this.a);
    }

    public final void a(com.anythink.basead.e.d dVar) {
        super.a(new com.anythink.basead.d.e.AnonymousClass1(dVar));
    }
}
