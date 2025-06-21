package com.igexin.push.core.a.c;

/* loaded from: classes23.dex */
public final class h implements com.igexin.push.extension.mod.PushMessageInterface {
    private static final java.lang.String a = "PopupAction";
    private long b = 0;

    /* renamed from: com.igexin.push.core.a.c.h$1, reason: invalid class name */
    public class AnonymousClass1 implements com.igexin.push.a.e.a<byte[]> {
        final /* synthetic */ java.util.concurrent.ConcurrentHashMap a;
        final /* synthetic */ java.lang.String b;
        final /* synthetic */ com.igexin.push.extension.mod.PushTaskBean c;

        public AnonymousClass1(java.util.concurrent.ConcurrentHashMap concurrentHashMap, java.lang.String str, com.igexin.push.extension.mod.PushTaskBean pushTaskBean) {
            this.a = concurrentHashMap;
            this.b = str;
            this.c = pushTaskBean;
        }

        private void a() {
            this.a.remove(this.b);
            if (this.a.isEmpty()) {
                com.igexin.push.core.a.c.h.a(this.c);
            }
        }

        @Override // com.igexin.push.a.e.a
        public final /* synthetic */ void a(byte[] bArr) {
            this.a.remove(this.b);
            if (this.a.isEmpty()) {
                com.igexin.push.core.a.c.h.a(this.c);
            }
        }

        @Override // com.igexin.push.a.e.a
        public final void a(java.lang.Throwable th) {
            com.igexin.c.a.c.a.a(th);
        }
    }

    public static java.util.HashMap<java.lang.String, java.lang.Object> a(android.content.Context context) {
        try {
            return com.getui.gtc.base.util.CommonUtil.isMainProcess() ? com.igexin.push.h.d.a() : (java.util.HashMap) com.igexin.sdk.router.TransferGtcProcess.getInstance().transferGtcProcess(context, new android.content.Intent(), com.igexin.sdk.router.TransferGtcProcess.POPUACTION_METHODNAME).getSerializable("map");
        } catch (java.lang.Throwable th) {
            com.igexin.c.a.c.a.a(th);
            return new java.util.HashMap<>();
        }
    }

    private void a(com.igexin.push.core.b.l.b bVar, java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.Object> concurrentHashMap) {
        java.lang.String str = bVar.h;
        if (!android.text.TextUtils.isEmpty(str) && !com.igexin.push.a.e.a(str)) {
            concurrentHashMap.put(str, new java.lang.Object());
        }
        java.lang.String str2 = bVar.j;
        if (!android.text.TextUtils.isEmpty(str2) && !com.igexin.push.a.e.a(str2)) {
            concurrentHashMap.put(str2, new java.lang.Object());
        }
        java.util.ArrayList<com.igexin.push.core.b.l.b> arrayList = bVar.g;
        if (arrayList != null) {
            java.util.Iterator<com.igexin.push.core.b.l.b> it = arrayList.iterator();
            while (it.hasNext()) {
                a(it.next(), concurrentHashMap);
            }
        }
    }

    public static /* synthetic */ void a(com.igexin.push.extension.mod.PushTaskBean pushTaskBean) {
        boolean isAppForeground = com.getui.gtc.base.util.CommonUtil.isAppForeground();
        boolean z = !com.igexin.push.a.g.a && isAppForeground;
        java.util.HashMap<java.lang.String, java.lang.Object> a2 = a(com.igexin.push.core.e.l);
        boolean booleanValue = ((java.lang.Boolean) a2.get("isPause")).booleanValue();
        boolean z2 = ((java.lang.Boolean) a2.get("isTranslucent")).booleanValue() && ((java.lang.Integer) com.igexin.push.core.ServiceManager.getInstance().initType.first).equals(0);
        if (!z || booleanValue || z2) {
            com.igexin.c.a.c.a.b(a, "has one popup = " + com.igexin.push.a.g.a + " , appForeground = " + isAppForeground + " , is guardAndTranslucent = " + z2 + " , has Translucent popu " + booleanValue);
            return;
        }
        com.igexin.push.core.e.c.a();
        com.igexin.push.core.e.c.a(com.igexin.push.core.b.ag, pushTaskBean.getTaskId());
        java.util.Map<java.lang.String, com.igexin.push.extension.mod.PushTaskBean> map = com.igexin.push.core.e.ah;
        com.igexin.push.core.a.b.d();
        com.igexin.push.extension.mod.PushTaskBean pushTaskBean2 = map.get(com.igexin.push.core.a.b.a(pushTaskBean.getTaskId(), pushTaskBean.getMessageId()));
        if (pushTaskBean2 != null) {
            pushTaskBean2.setStatus(com.igexin.push.core.b.ag);
        }
        com.igexin.push.core.a.b.d();
        com.igexin.push.core.a.b.a(pushTaskBean.getTaskId(), pushTaskBean.getMessageId(), "1");
    }

    private void a(java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.Object> concurrentHashMap, com.igexin.push.extension.mod.PushTaskBean pushTaskBean) {
        for (java.lang.String str : concurrentHashMap.keySet()) {
            com.igexin.push.a.e.a(str, new com.igexin.push.core.a.c.h.AnonymousClass1(concurrentHashMap, str, pushTaskBean));
        }
    }

    private static void b(com.igexin.push.extension.mod.PushTaskBean pushTaskBean) {
        boolean isAppForeground = com.getui.gtc.base.util.CommonUtil.isAppForeground();
        boolean z = !com.igexin.push.a.g.a && isAppForeground;
        java.util.HashMap<java.lang.String, java.lang.Object> a2 = a(com.igexin.push.core.e.l);
        boolean booleanValue = ((java.lang.Boolean) a2.get("isPause")).booleanValue();
        boolean z2 = ((java.lang.Boolean) a2.get("isTranslucent")).booleanValue() && ((java.lang.Integer) com.igexin.push.core.ServiceManager.getInstance().initType.first).equals(0);
        if (!z || booleanValue || z2) {
            com.igexin.c.a.c.a.b(a, "has one popup = " + com.igexin.push.a.g.a + " , appForeground = " + isAppForeground + " , is guardAndTranslucent = " + z2 + " , has Translucent popu " + booleanValue);
            return;
        }
        com.igexin.push.core.e.c.a();
        com.igexin.push.core.e.c.a(com.igexin.push.core.b.ag, pushTaskBean.getTaskId());
        java.util.Map<java.lang.String, com.igexin.push.extension.mod.PushTaskBean> map = com.igexin.push.core.e.ah;
        com.igexin.push.core.a.b.d();
        com.igexin.push.extension.mod.PushTaskBean pushTaskBean2 = map.get(com.igexin.push.core.a.b.a(pushTaskBean.getTaskId(), pushTaskBean.getMessageId()));
        if (pushTaskBean2 != null) {
            pushTaskBean2.setStatus(com.igexin.push.core.b.ag);
        }
        com.igexin.push.core.a.b.d();
        com.igexin.push.core.a.b.a(pushTaskBean.getTaskId(), pushTaskBean.getMessageId(), "1");
    }

    @Override // com.igexin.push.extension.mod.PushMessageInterface
    public final boolean executeAction(com.igexin.push.extension.mod.PushTaskBean pushTaskBean, com.igexin.push.extension.mod.BaseActionBean baseActionBean) {
        if (pushTaskBean == null || baseActionBean == null) {
            return false;
        }
        com.igexin.push.core.b.l lVar = (com.igexin.push.core.b.l) baseActionBean;
        lVar.e = pushTaskBean.getAppid();
        lVar.f = pushTaskBean.getMessageId();
        lVar.g = pushTaskBean.getTaskId();
        lVar.h = pushTaskBean.getAppKey();
        android.content.Intent intent = new android.content.Intent(com.igexin.push.core.e.l, (java.lang.Class<?>) com.igexin.sdk.PopupActivity.class);
        android.os.Bundle bundle = new android.os.Bundle();
        bundle.putSerializable("bean", lVar);
        intent.putExtras(bundle);
        intent.setFlags(343932928);
        intent.putExtra("action", com.igexin.push.core.b.q);
        com.igexin.push.core.e.l.startActivity(intent);
        com.igexin.c.a.c.a.b(a, "startActivity PopuAction");
        if (lVar.getDoActionId() == null) {
            return true;
        }
        com.igexin.push.core.a.b.d();
        com.igexin.push.core.a.b.a(pushTaskBean.getTaskId(), pushTaskBean.getMessageId(), lVar.getDoActionId());
        return true;
    }

    @Override // com.igexin.push.extension.mod.PushMessageInterface
    public final com.igexin.push.extension.mod.BaseActionBean parseAction(org.json.JSONObject jSONObject) {
        float f;
        float f2;
        try {
            com.igexin.push.core.b.l lVar = new com.igexin.push.core.b.l();
            lVar.setType(com.igexin.push.core.b.q);
            lVar.setActionId(jSONObject.optString("actionid"));
            lVar.setDoActionId(jSONObject.optString(com.anythink.expressad.foundation.d.d.f238s));
            org.json.JSONObject jSONObject2 = new org.json.JSONObject(com.igexin.push.config.f.a(jSONObject.optString("body")));
            org.json.JSONObject optJSONObject = jSONObject2.optJSONObject("statisticsInfo");
            if (optJSONObject != null) {
                lVar.c = optJSONObject.optString("planName", "");
                lVar.d = optJSONObject.optString("nodeName", "");
            }
            org.json.JSONObject optJSONObject2 = jSONObject2.optJSONObject("properties");
            if (optJSONObject2 != null) {
                java.lang.String optString = optJSONObject2.optString("baseWidth");
                java.lang.String optString2 = optJSONObject2.optString("baseHeight");
                f = java.lang.Float.parseFloat(optString.substring(0, optString.length() - 2));
                f2 = java.lang.Float.parseFloat(optString2.substring(0, optString2.length() - 2));
            } else {
                f = 1.0f;
                f2 = 1.0f;
            }
            lVar.i = jSONObject2.optString("showActionId", "");
            lVar.a = new com.igexin.push.core.b.l.b(jSONObject2.optJSONObject(com.sensorsdata.sf.ui.view.UIProperty.type_mask), lVar.c, lVar.d, f, f2);
            lVar.b = new com.igexin.push.core.b.l.b(jSONObject2.optJSONObject("template"), lVar.c, lVar.d, f, f2);
            com.igexin.sdk.message.GTPopupMessage.EventProperties eventProperties = new com.igexin.sdk.message.GTPopupMessage.EventProperties(lVar.c, lVar.d, "", "");
            com.igexin.sdk.message.GTPopupMessage gTPopupMessage = new com.igexin.sdk.message.GTPopupMessage();
            gTPopupMessage.setEventProperties(eventProperties);
            lVar.j = gTPopupMessage;
            return lVar;
        } catch (java.lang.Throwable th) {
            com.igexin.c.a.c.a.a(th);
            return null;
        }
    }

    @Override // com.igexin.push.extension.mod.PushMessageInterface
    public final com.igexin.push.extension.mod.PushMessageInterface.ActionPrepareState prepareExecuteAction(com.igexin.push.extension.mod.PushTaskBean pushTaskBean, com.igexin.push.extension.mod.BaseActionBean baseActionBean) {
        boolean isAppForeground = com.getui.gtc.base.util.CommonUtil.isAppForeground();
        boolean z = (baseActionBean instanceof com.igexin.push.core.b.l) && !com.igexin.push.a.g.a && isAppForeground;
        long currentTimeMillis = java.lang.System.currentTimeMillis();
        boolean z2 = currentTimeMillis - this.b > 1000;
        java.util.HashMap<java.lang.String, java.lang.Object> a2 = a(com.igexin.push.core.e.l);
        boolean booleanValue = ((java.lang.Boolean) a2.get("isPause")).booleanValue();
        boolean z3 = ((java.lang.Boolean) a2.get("isTranslucent")).booleanValue() && ((java.lang.Integer) com.igexin.push.core.ServiceManager.getInstance().initType.first).equals(0);
        if (z && z2 && !booleanValue && !z3) {
            this.b = currentTimeMillis;
            java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.Object> concurrentHashMap = new java.util.concurrent.ConcurrentHashMap<>();
            a(((com.igexin.push.core.b.l) baseActionBean).b, concurrentHashMap);
            if (concurrentHashMap.size() <= 0) {
                return com.igexin.push.extension.mod.PushMessageInterface.ActionPrepareState.success;
            }
            a(concurrentHashMap, pushTaskBean);
            return com.igexin.push.extension.mod.PushMessageInterface.ActionPrepareState.wait;
        }
        com.igexin.c.a.c.a.b(a, "has one popup = " + com.igexin.push.a.g.a + " , appForeground = " + isAppForeground + " , is guardAndTranslucent = " + z3 + " ,overLimitTime = " + z2 + " , has Translucent popu " + booleanValue);
        return com.igexin.push.extension.mod.PushMessageInterface.ActionPrepareState.stop;
    }
}
