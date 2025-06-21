package com.xiaomi.push.service;

/* loaded from: classes19.dex */
public final class bk implements com.xiaomi.push.service.c.n {
    private static final boolean a = android.util.Log.isLoggable("UNDatas", 3);
    private static final java.util.Map<java.lang.Integer, java.util.Map<java.lang.String, java.util.List<java.lang.String>>> b = new java.util.HashMap();
    private static android.content.Context c;

    public bk(android.content.Context context) {
        c = context;
    }

    @Override // com.xiaomi.push.service.c.n
    public final void a() {
        java.util.Map<java.lang.Integer, java.util.Map<java.lang.String, java.util.List<java.lang.String>>> map = b;
        if (map.size() > 0) {
            synchronized (map) {
                java.util.HashMap hashMap = new java.util.HashMap();
                hashMap.putAll(map);
                if (hashMap.size() > 0) {
                    for (java.lang.Integer num : hashMap.keySet()) {
                        java.util.Map map2 = (java.util.Map) hashMap.get(num);
                        if (map2 != null && map2.size() > 0) {
                            java.lang.StringBuilder sb = new java.lang.StringBuilder();
                            java.util.Iterator it = map2.keySet().iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    break;
                                }
                                java.lang.String str = (java.lang.String) it.next();
                                sb.append(str);
                                sb.append(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR);
                                java.util.List list = (java.util.List) map2.get(str);
                                if (!com.xiaomi.push.jd.a(list)) {
                                    for (int i = 0; i < list.size(); i++) {
                                        if (i != 0) {
                                            sb.append(",");
                                        }
                                        sb.append((java.lang.String) list.get(i));
                                    }
                                }
                                sb.append(com.alipay.sdk.m.u.i.b);
                            }
                            java.lang.String a2 = com.xiaomi.push.service.ag.a();
                            java.lang.String str2 = com.xiaomi.push.gu.NotificationRemoved.ah;
                            com.xiaomi.push.hk hkVar = new com.xiaomi.push.hk();
                            if (str2 != null) {
                                hkVar.e = str2;
                            }
                            if (a2 != null) {
                                hkVar.c = a2;
                            }
                            hkVar.a(false);
                            hkVar.a("removed_reason", java.lang.String.valueOf(num));
                            hkVar.a("all_delete_msgId_appId", sb.toString());
                            com.xiaomi.channel.commonutils.logger.b.b("UNDatas upload all removed messages reason: " + num + " allIds: " + sb.toString());
                            android.content.Context context = c;
                            if (a) {
                                com.xiaomi.channel.commonutils.logger.b.b("UNDatas upload message notification:".concat(java.lang.String.valueOf(hkVar)));
                            }
                            com.xiaomi.push.m.a(context).a(new com.xiaomi.push.service.bl(hkVar), 0);
                        }
                        b.remove(num);
                    }
                }
            }
        }
    }
}
