package com.efs.sdk.memoryinfo;

/* loaded from: classes22.dex */
class e {
    final java.util.List<com.efs.sdk.base.protocol.record.EfsJSONLog> B = new java.util.ArrayList();
    volatile boolean C;
    private final com.efs.sdk.base.EfsReporter a;

    /* renamed from: com.efs.sdk.memoryinfo.e$1, reason: invalid class name */
    public class AnonymousClass1 implements com.umeng.commonsdk.statistics.internal.UMImprintChangeCallback {
        final /* synthetic */ android.content.Context D;

        public AnonymousClass1(android.content.Context context) {
            this.D = context;
        }

        @Override // com.umeng.commonsdk.statistics.internal.UMImprintChangeCallback
        public final void onImprintValueChanged(java.lang.String str, java.lang.String str2) {
            try {
                if (com.umeng.analytics.pro.bo.g.equals(str)) {
                    java.util.HashMap hashMap = new java.util.HashMap(1);
                    hashMap.put(com.umeng.umcrash.UMCrash.KEY_HEADER_UMID, str2);
                    com.efs.sdk.memoryinfo.e.this.a.addPublicParams(hashMap);
                    synchronized (com.efs.sdk.memoryinfo.e.class) {
                        com.efs.sdk.memoryinfo.e.b(com.efs.sdk.memoryinfo.e.this);
                    }
                    java.util.Iterator it = com.efs.sdk.memoryinfo.e.this.B.iterator();
                    while (it.hasNext()) {
                        com.efs.sdk.memoryinfo.e.this.a((com.efs.sdk.base.protocol.record.EfsJSONLog) it.next());
                    }
                    new java.lang.StringBuilder("send cache:").append(com.efs.sdk.memoryinfo.e.this.B.size());
                    boolean z = com.efs.sdk.memoryinfo.a.DEBUG;
                    com.efs.sdk.memoryinfo.e.this.B.clear();
                    com.umeng.commonsdk.statistics.idtracking.ImprintHandler.getImprintService(this.D).unregistImprintCallback(com.umeng.analytics.pro.bo.g, this);
                }
            } catch (java.lang.Throwable th) {
                com.efs.sdk.memoryinfo.f.a("umid ", th);
            }
        }
    }

    public e(android.content.Context context, com.efs.sdk.base.EfsReporter efsReporter) {
        this.a = efsReporter;
        java.lang.String uMId = com.umeng.commonsdk.utils.UMUtils.getUMId(context);
        this.C = !android.text.TextUtils.isEmpty(uMId);
        if (!this.C) {
            com.umeng.commonsdk.statistics.idtracking.ImprintHandler.getImprintService(context).registImprintCallback(com.umeng.analytics.pro.bo.g, new com.efs.sdk.memoryinfo.e.AnonymousClass1(context));
            return;
        }
        java.util.HashMap hashMap = new java.util.HashMap(1);
        hashMap.put(com.umeng.umcrash.UMCrash.KEY_HEADER_UMID, uMId);
        efsReporter.addPublicParams(hashMap);
    }

    public static /* synthetic */ boolean b(com.efs.sdk.memoryinfo.e eVar) {
        eVar.C = true;
        return true;
    }

    public final void a(com.efs.sdk.base.protocol.record.EfsJSONLog efsJSONLog) {
        try {
            this.a.send(efsJSONLog);
        } catch (java.lang.Throwable th) {
            com.efs.sdk.memoryinfo.f.a("send", th);
        }
    }
}
