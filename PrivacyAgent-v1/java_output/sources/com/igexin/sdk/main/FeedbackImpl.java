package com.igexin.sdk.main;

/* loaded from: classes23.dex */
public class FeedbackImpl {
    private static final java.lang.String TAG = "FeedbackImpl";
    public static volatile com.igexin.sdk.main.FeedbackImpl instance;

    private FeedbackImpl() {
    }

    public static com.igexin.sdk.main.FeedbackImpl getInstance() {
        if (instance == null) {
            synchronized (com.igexin.sdk.main.FeedbackImpl.class) {
                if (instance == null) {
                    instance = new com.igexin.sdk.main.FeedbackImpl();
                }
            }
        }
        return instance;
    }

    public void asyncFeedback(java.lang.Runnable runnable) {
        com.igexin.b.a.a().a(TAG).execute(runnable);
    }

    public void clearFeedbackMessage() {
        int i = com.igexin.push.core.e.am - 100;
        if (i < 0) {
            i = 0;
        }
        com.igexin.push.core.e.am = i;
        long currentTimeMillis = java.lang.System.currentTimeMillis();
        java.util.Iterator<java.util.Map.Entry<java.lang.String, java.lang.Long>> it = com.igexin.push.core.e.al.entrySet().iterator();
        while (it.hasNext()) {
            java.util.Map.Entry<java.lang.String, java.lang.Long> next = it.next();
            next.getKey();
            if (currentTimeMillis - next.getValue().longValue() > 3600000) {
                it.remove();
            }
        }
    }

    public void feedbackMessageAction(com.igexin.push.extension.mod.PushTaskBean pushTaskBean, java.lang.String str) {
        feedbackMessageAction(pushTaskBean, str, "ok");
    }

    public void feedbackMessageAction(com.igexin.push.extension.mod.PushTaskBean pushTaskBean, java.lang.String str, java.lang.String str2) {
        if (android.text.TextUtils.isEmpty(str)) {
            return;
        }
        long currentTimeMillis = java.lang.System.currentTimeMillis();
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            jSONObject.put("action", "pushmessage_feedback");
            jSONObject.put("appid", pushTaskBean.getAppid());
            jSONObject.put("id", java.lang.String.valueOf(currentTimeMillis));
            jSONObject.put("appkey", pushTaskBean.getAppKey());
            jSONObject.put("messageid", pushTaskBean.getMessageId());
            jSONObject.put("taskid", pushTaskBean.getTaskId());
            jSONObject.put("actionid", str);
            jSONObject.put("result", str2);
            jSONObject.put("timestamp", java.lang.String.valueOf(java.lang.System.currentTimeMillis()));
        } catch (java.lang.Throwable th) {
            com.igexin.c.a.c.a.a(th);
        }
        java.lang.String jSONObject2 = jSONObject.toString();
        com.igexin.push.d.c.b bVar = new com.igexin.push.d.c.b();
        bVar.c = 128;
        bVar.b = (int) currentTimeMillis;
        bVar.e = com.igexin.push.core.b.N;
        bVar.f = jSONObject2;
        bVar.h = com.igexin.push.core.e.A;
        com.igexin.push.core.e.e.a().b(new com.igexin.push.core.b.m(currentTimeMillis, jSONObject2, (byte) 3, com.igexin.push.core.e.u ? currentTimeMillis : 0L));
        if (com.igexin.push.core.d.a.a.h != null) {
            com.igexin.push.core.d.a.a.h.a("C-" + com.igexin.push.core.e.A, bVar, false);
        }
        com.igexin.c.a.c.a.a("feedback|" + pushTaskBean.getTaskId() + "|" + pushTaskBean.getMessageId() + "|" + str, new java.lang.Object[0]);
    }

    public void feedbackMultiBrandMessageAction(com.igexin.push.extension.mod.PushTaskBean pushTaskBean, java.lang.String str) {
        feedbackMessageAction(pushTaskBean, com.igexin.assist.sdk.AssistPushConsts.PUSHMESSAGE_ACTION_MULTI_BRAND_RECEIVE.concat(java.lang.String.valueOf(str)), "ok");
    }

    public void feedbackMultiBrandMessageAction(org.json.JSONObject jSONObject, java.lang.String str) {
        try {
            com.igexin.push.extension.mod.PushTaskBean pushTaskBean = new com.igexin.push.extension.mod.PushTaskBean();
            pushTaskBean.parse(jSONObject);
            feedbackMultiBrandMessageAction(pushTaskBean, str);
        } catch (java.lang.Exception e) {
            com.igexin.c.a.c.a.a(e);
        }
    }
}
