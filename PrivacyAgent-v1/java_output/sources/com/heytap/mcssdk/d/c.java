package com.heytap.mcssdk.d;

/* loaded from: classes22.dex */
public abstract class c implements com.heytap.mcssdk.d.d {
    public static java.util.List<com.heytap.msp.push.mode.BaseMode> a(android.content.Context context, android.content.Intent intent) {
        int i;
        com.heytap.msp.push.mode.BaseMode a;
        if (intent == null) {
            return null;
        }
        try {
            i = java.lang.Integer.parseInt(com.heytap.mcssdk.utils.b.d(intent.getStringExtra("type")));
        } catch (java.lang.Exception e) {
            com.heytap.mcssdk.utils.d.e("MessageParser--getMessageByIntent--Exception:" + e.getMessage());
            i = 4096;
        }
        com.heytap.mcssdk.utils.d.b("MessageParser--getMessageByIntent--type:" + i);
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (com.heytap.mcssdk.d.d dVar : com.heytap.mcssdk.PushService.getInstance().getParsers()) {
            if (dVar != null && (a = dVar.a(context, i, intent)) != null) {
                arrayList.add(a);
            }
        }
        return arrayList;
    }

    public abstract com.heytap.msp.push.mode.BaseMode a(android.content.Intent intent, int i);
}
