package com.heytap.mcssdk.d;

/* loaded from: classes22.dex */
public class a extends com.heytap.mcssdk.d.c {
    @Override // com.heytap.mcssdk.d.d
    public com.heytap.msp.push.mode.BaseMode a(android.content.Context context, int i, android.content.Intent intent) {
        if (4105 == i) {
            return a(intent, i);
        }
        return null;
    }

    @Override // com.heytap.mcssdk.d.c
    public com.heytap.msp.push.mode.BaseMode a(android.content.Intent intent, int i) {
        try {
            com.heytap.mcssdk.c.b bVar = new com.heytap.mcssdk.c.b();
            bVar.a(java.lang.Integer.parseInt(com.heytap.mcssdk.utils.b.d(intent.getStringExtra(com.heytap.mcssdk.constant.b.y))));
            bVar.b(java.lang.Integer.parseInt(com.heytap.mcssdk.utils.b.d(intent.getStringExtra("code"))));
            bVar.e(com.heytap.mcssdk.utils.b.d(intent.getStringExtra("content")));
            bVar.a(com.heytap.mcssdk.utils.b.d(intent.getStringExtra(com.heytap.mcssdk.constant.b.z)));
            bVar.b(com.heytap.mcssdk.utils.b.d(intent.getStringExtra(com.heytap.mcssdk.constant.b.A)));
            bVar.f(com.heytap.mcssdk.utils.b.d(intent.getStringExtra(com.heytap.mcssdk.constant.b.e)));
            com.heytap.mcssdk.utils.d.b("OnHandleIntent-message:" + bVar.toString());
            return bVar;
        } catch (java.lang.Exception e) {
            com.heytap.mcssdk.utils.d.b("OnHandleIntent--" + e.getMessage());
            return null;
        }
    }
}
