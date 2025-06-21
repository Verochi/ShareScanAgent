package com.igexin.push.core.f;

/* loaded from: classes23.dex */
public class a {
    private static final java.lang.String a = "NotificationExecutor";
    private static com.igexin.push.core.f.a b;

    public static com.igexin.push.core.f.a a() {
        if (b == null) {
            synchronized (com.igexin.push.core.f.a.class) {
                if (b == null) {
                    b = new com.igexin.push.core.f.a();
                }
            }
        }
        return b;
    }

    public static void a(android.content.Intent intent) {
        java.lang.String str;
        java.lang.String stringExtra = intent.getStringExtra("taskid");
        java.lang.String stringExtra2 = intent.getStringExtra("groupId");
        java.util.HashSet<java.lang.String> hashSet = com.igexin.push.core.e.aj.get(stringExtra2);
        java.lang.Integer num = com.igexin.push.core.e.ak.get(stringExtra2);
        if (hashSet != null && !hashSet.isEmpty()) {
            hashSet.remove(stringExtra);
        }
        if (!android.text.TextUtils.isEmpty(stringExtra2) && num != null && hashSet != null && hashSet.isEmpty()) {
            ((android.app.NotificationManager) com.igexin.push.core.e.l.getSystemService(com.huawei.hms.push.constant.RemoteMessageConst.NOTIFICATION)).cancel(num.intValue());
            com.igexin.push.core.e.aj.remove(stringExtra2);
            com.igexin.push.core.e.ak.remove(stringExtra2);
        }
        java.lang.String stringExtra3 = intent.getStringExtra("checkpackage");
        java.lang.String stringExtra4 = intent.getStringExtra("accesstoken");
        if (stringExtra3 == null || stringExtra4 == null || !stringExtra3.equals(com.igexin.push.core.e.l.getPackageName()) || !stringExtra4.equals(com.igexin.push.core.e.aC)) {
            return;
        }
        intent.putExtra("accesstoken", com.igexin.push.core.e.an);
        com.igexin.push.core.n.a().a(intent);
        com.igexin.push.core.e.c.a();
        com.igexin.push.core.e.c.a(stringExtra, com.igexin.push.core.b.aj, intent.getIntExtra("redisplayFreq", 0));
        com.igexin.push.extension.mod.PushTaskBean pushTaskBean = new com.igexin.push.extension.mod.PushTaskBean();
        pushTaskBean.setAppid(intent.getStringExtra("appid"));
        pushTaskBean.setMessageId(intent.getStringExtra("messageid"));
        pushTaskBean.setTaskId(stringExtra);
        pushTaskBean.setId(intent.getStringExtra("id"));
        intent.getStringExtra("bigStyle");
        intent.getStringExtra("notifyStyle");
        try {
            int parseInt = java.lang.Integer.parseInt(intent.getStringExtra("feedbackid")) + 30010;
            pushTaskBean.setCurrentActionid(parseInt);
            if (intent.getBooleanExtra("isFloat", false)) {
                str = "notifyFloat:" + intent.getStringExtra("bigStyle");
            } else {
                str = "notifyStyle:" + intent.getStringExtra("notifyStyle");
            }
            com.igexin.sdk.main.FeedbackImpl.getInstance().feedbackMessageAction(pushTaskBean, java.lang.String.valueOf(parseInt), str);
        } catch (java.lang.Exception unused) {
        }
    }
}
