package com.getui.gtc.dyc;

/* loaded from: classes22.dex */
public class g {

    /* renamed from: com.getui.gtc.dyc.g$1, reason: invalid class name */
    public class AnonymousClass1 implements com.getui.gtc.base.http.Call.Callback {
        final /* synthetic */ com.getui.gtc.dyc.g.c a;
        final /* synthetic */ com.getui.gtc.dyc.d c;
        final /* synthetic */ com.getui.gtc.dyc.b.b d;

        @Override // com.getui.gtc.base.http.Call.Callback
        public void onFailure(com.getui.gtc.base.http.Call call, java.lang.Exception exc) {
            com.getui.gtc.dyc.g.c cVar = this.a;
            if (cVar != null) {
                cVar.a(exc);
            }
        }

        @Override // com.getui.gtc.base.http.Call.Callback
        public void onResponse(com.getui.gtc.base.http.Call call, com.getui.gtc.base.http.Response response) {
            try {
                com.getui.gtc.dyc.h a = this.c.a(this.d, response);
                com.getui.gtc.dyc.g.c cVar = this.a;
                if (cVar != null) {
                    cVar.a(a);
                }
            } catch (java.lang.Throwable th) {
                com.getui.gtc.dyc.a.a.a.c(th);
                com.getui.gtc.dyc.g.c cVar2 = this.a;
                if (cVar2 != null) {
                    cVar2.a(th);
                }
            }
        }
    }

    public static class a {
        private static final com.getui.gtc.dyc.g a = new com.getui.gtc.dyc.g(null);
    }

    public interface c {
        void a(com.getui.gtc.dyc.h hVar);

        void a(java.lang.Throwable th);
    }

    private g() {
        a(com.getui.gtc.base.GtcProvider.context());
    }

    public /* synthetic */ g(com.getui.gtc.dyc.g.AnonymousClass1 anonymousClass1) {
        this();
    }

    public static com.getui.gtc.dyc.g a() {
        return com.getui.gtc.dyc.g.a.a;
    }

    private void a(android.content.Context context) {
        try {
            android.os.Bundle bundle = com.getui.gtc.base.util.CommonUtil.getAppInfoForSelf(context).metaData;
            if (bundle != null) {
                java.lang.String string = bundle.getString("DYC_P");
                if (!android.text.TextUtils.isEmpty(string)) {
                    com.getui.gtc.dyc.d.a = string;
                }
                java.lang.String string2 = bundle.getString("DYC_K");
                if (android.text.TextUtils.isEmpty(string2)) {
                    return;
                }
                com.getui.gtc.dyc.d.c = string2;
            }
        } catch (java.lang.Throwable th) {
            com.getui.gtc.dyc.a.a.a.c(th);
        }
    }

    public com.getui.gtc.dyc.h a(com.getui.gtc.dyc.b.b bVar) throws java.lang.Exception {
        return new com.getui.gtc.dyc.d().a(bVar);
    }
}
