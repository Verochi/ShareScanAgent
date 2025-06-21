package com.igexin.push.core;

/* loaded from: classes23.dex */
public class c extends android.os.Handler {
    private static java.lang.String a = "com.igexin.push.core.c";
    private boolean b;

    public c(android.os.Looper looper) {
        super(looper);
        this.b = false;
    }

    private static void a() {
        if (com.igexin.push.core.e.u || com.igexin.push.core.e.O <= 10000) {
            return;
        }
        int random = (int) ((java.lang.Math.random() * 100.0d) + 150.0d);
        com.igexin.c.a.c.a.a(a + "|userPresent, rdelay = " + com.igexin.push.core.e.O + ", reset = " + random, new java.lang.Object[0]);
        com.igexin.push.core.e.b((long) random);
        com.igexin.push.g.b.e.g().a(com.igexin.push.core.e.O);
    }

    private static void a(android.content.Intent intent) {
        java.lang.String stringExtra = intent.getStringExtra("action");
        if (stringExtra.equals(com.igexin.sdk.PushConsts.ACTION_SERVICE_INITIALIZE)) {
            com.igexin.push.core.a.b.d();
            com.igexin.push.core.a.b.a(intent);
            return;
        }
        if (stringExtra.equals(com.igexin.sdk.PushConsts.ACTION_SERVICE_ONRESUME)) {
            com.igexin.c.a.c.a.a(a + "|handle onresume ~~~", new java.lang.Object[0]);
            com.igexin.push.core.a.b.d();
            com.igexin.push.core.a.b.b("on fg");
            return;
        }
        if (stringExtra.equals(com.igexin.sdk.PushConsts.ACTION_SERVICE_INITIALIZE_SLAVE)) {
            com.igexin.push.core.a.b.d();
            com.igexin.push.core.a.b.b(intent);
            com.igexin.assist.sdk.AssistPushManager.getInstance().turnOnPush(com.igexin.push.core.e.l);
            return;
        }
        if (stringExtra.equals(com.igexin.sdk.PushConsts.ACTION_BROADCAST_PUSHMANAGER)) {
            java.lang.String stringExtra2 = intent.getStringExtra("sc");
            if (android.text.TextUtils.isEmpty(com.igexin.push.core.e.i) || com.igexin.push.core.e.i.equals(stringExtra2)) {
                android.os.Bundle bundleExtra = intent.getBundleExtra(com.bytedance.sdk.openadsdk.live.TTLiveConstants.BUNDLE_KEY);
                com.igexin.push.core.a.b.d();
                com.igexin.push.core.a.b.a(bundleExtra);
                return;
            }
            com.igexin.c.a.c.a.a("safeCode not match!!" + com.igexin.push.core.e.i + "," + stringExtra2, new java.lang.Object[0]);
            com.igexin.c.a.c.a.d.a().a("safeCode not match!!" + com.igexin.push.core.e.i + "," + stringExtra2);
            return;
        }
        if (stringExtra.equals(com.igexin.sdk.PushConsts.ACTION_BROADCAST_USER_PRESENT)) {
            if (com.igexin.push.core.e.u || com.igexin.push.core.e.O <= 10000) {
                return;
            }
            int random = (int) ((java.lang.Math.random() * 100.0d) + 150.0d);
            com.igexin.c.a.c.a.a(a + "|userPresent, rdelay = " + com.igexin.push.core.e.O + ", reset = " + random, new java.lang.Object[0]);
            com.igexin.push.core.e.b((long) random);
            com.igexin.push.g.b.e.g().a(com.igexin.push.core.e.O);
            return;
        }
        if (stringExtra.equals("com.igexin.action.notification.click")) {
            android.content.Intent intent2 = (android.content.Intent) intent.getParcelableExtra("broadcast_intent");
            if (intent2 != null) {
                com.igexin.push.core.f.a.a();
                com.igexin.push.core.f.a.a(intent2);
                return;
            }
            return;
        }
        if (stringExtra.equals(com.igexin.push.core.b.L)) {
            java.util.HashMap hashMap = (java.util.HashMap) intent.getSerializableExtra("push_action");
            com.igexin.c.a.c.a.a(a + "| handle other push action broadcast", new java.lang.Object[0]);
            com.igexin.push.core.n.a().a.putAll(hashMap);
            com.igexin.push.core.n.a().d();
            return;
        }
        if (!stringExtra.equals("com.igexin.action.notification.delete")) {
            if (stringExtra.equals(com.igexin.sdk.PushConsts.ACTION_BROADCAST_UPLOAD_TYPE253)) {
                java.lang.String stringExtra3 = intent.getStringExtra("id");
                java.lang.String stringExtra4 = intent.getStringExtra("aid");
                com.igexin.push.core.c.a.a();
                com.igexin.push.core.c.a.a(stringExtra3, stringExtra4);
                return;
            }
            return;
        }
        if (intent.getBooleanExtra("isSummary", false)) {
            java.lang.String stringExtra5 = intent.getStringExtra("groupId");
            com.igexin.push.core.e.aj.remove(stringExtra5);
            com.igexin.push.core.e.ak.remove(stringExtra5);
            return;
        }
        com.igexin.push.extension.mod.PushTaskBean pushTaskBean = new com.igexin.push.extension.mod.PushTaskBean();
        pushTaskBean.setAppid(intent.getStringExtra("appid"));
        pushTaskBean.setMessageId(intent.getStringExtra("messageid"));
        java.lang.String stringExtra6 = intent.getStringExtra("taskid");
        pushTaskBean.setTaskId(stringExtra6);
        pushTaskBean.setId(intent.getStringExtra("id"));
        pushTaskBean.setAppKey(intent.getStringExtra("appkey"));
        com.igexin.push.core.e.c.a();
        com.igexin.push.core.e.c.a(stringExtra6, com.igexin.push.core.b.ak, intent.getIntExtra("redisplayFreq", 0));
        int parseInt = java.lang.Integer.parseInt(intent.getStringExtra("feedbackid")) + 30040;
        pushTaskBean.setCurrentActionid(parseInt);
        com.igexin.sdk.main.FeedbackImpl.getInstance().feedbackMessageAction(pushTaskBean, java.lang.String.valueOf(parseInt), "notifyStyle:" + intent.getStringExtra("notifyStyle"));
        com.igexin.push.core.a.b.d();
        java.lang.String a2 = com.igexin.push.core.a.b.a(intent.getStringExtra("taskid"), intent.getStringExtra("messageid"));
        com.igexin.c.a.c.a.a(a + "|notification delete = " + a2, new java.lang.Object[0]);
        try {
            com.igexin.push.core.e.ah.remove(a2);
            com.igexin.c.a.c.a.a(a + "|del notification, pushMessageMap remove = " + a2, new java.lang.Object[0]);
        } catch (java.lang.Exception e) {
            com.igexin.c.a.c.a.a(e);
            com.igexin.c.a.c.a.a("EndAction|" + e.toString(), new java.lang.Object[0]);
        }
    }

    @Override // android.os.Handler
    public void handleMessage(android.os.Message message) {
        if (message == null) {
            return;
        }
        int i = message.what;
        if (i == com.igexin.push.core.b.S) {
            com.igexin.push.core.n.a().c();
            return;
        }
        java.lang.Object obj = message.obj;
        if (obj == null) {
            return;
        }
        try {
            if (i != com.igexin.push.core.b.P) {
                if (i == com.igexin.push.core.b.Q) {
                    com.igexin.push.core.a.b.d();
                    android.content.Intent intent = (android.content.Intent) message.obj;
                    if (intent == null || intent.getAction() == null) {
                        return;
                    }
                    try {
                        java.lang.String action = intent.getAction();
                        if (com.igexin.sdk.PushConsts.ACTION_BROADCAST_NETWORK_CHANGE.equals(action)) {
                            com.igexin.push.core.a.b.e();
                            return;
                        }
                        if (com.igexin.push.core.b.K.equals(action)) {
                            com.igexin.push.core.n.a().a(intent);
                            return;
                        }
                        if (com.igexin.push.core.b.M.equals(action)) {
                            if (com.igexin.push.config.d.c != 0) {
                                com.igexin.push.g.e.a().d();
                                return;
                            }
                            return;
                        } else if (!"android.intent.action.SCREEN_ON".equals(action)) {
                            if ("android.intent.action.SCREEN_OFF".equals(action)) {
                                com.igexin.push.core.e.y = 0;
                                return;
                            }
                            return;
                        } else {
                            com.igexin.push.core.e.y = 1;
                            com.igexin.push.g.a.a().a(true);
                            if (android.os.Build.VERSION.SDK_INT >= 26) {
                                com.igexin.push.core.a.b.b("screen on");
                                return;
                            }
                            return;
                        }
                    } catch (java.lang.Throwable th) {
                        com.igexin.c.a.c.a.a(th);
                        return;
                    }
                }
                if (i != com.igexin.push.core.b.U) {
                    if (i == com.igexin.push.core.b.R) {
                        android.os.Bundle bundle = (android.os.Bundle) obj;
                        com.igexin.push.core.n.a().b(bundle.getString("taskid"), bundle.getString("messageid"), bundle.getString("actionid"));
                        return;
                    }
                    if (i == com.igexin.push.core.b.V) {
                        if (this.b) {
                            return;
                        }
                        com.igexin.push.core.d unused = com.igexin.push.core.d.a.a;
                        com.igexin.push.core.d.c();
                        this.b = true;
                        return;
                    }
                    if (i != com.igexin.push.core.b.T || com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty.SURFACE_ROTATION_MODE_FALSE.equals(com.igexin.push.core.e.I)) {
                        return;
                    }
                    com.igexin.push.d.c.n nVar = new com.igexin.push.d.c.n();
                    nVar.c = 128;
                    nVar.f = message.obj;
                    nVar.g = message.getData().getByteArray("payload");
                    new com.igexin.push.core.a.b.d().a(nVar);
                    return;
                }
                android.os.Bundle bundle2 = (android.os.Bundle) obj;
                java.lang.String string = bundle2.getString("taskid");
                java.lang.String string2 = bundle2.getString("messageid");
                com.igexin.push.core.n a2 = com.igexin.push.core.n.a();
                if (string2 == null || string == null) {
                    return;
                }
                try {
                    com.igexin.push.core.a.b.d();
                    java.lang.String a3 = com.igexin.push.core.a.b.a(string, string2);
                    com.igexin.push.extension.mod.PushTaskBean pushTaskBean = com.igexin.push.core.e.ah.get(a3);
                    if (pushTaskBean == null) {
                        return;
                    }
                    int status = pushTaskBean.getStatus();
                    int i2 = com.igexin.push.core.b.ag;
                    if (status == i2) {
                        com.igexin.c.a.c.a.b("PushMessageExecutor", " has execute ".concat(java.lang.String.valueOf(a3)));
                        return;
                    }
                    pushTaskBean.setStatus(i2);
                    com.igexin.c.a.c.a.b("PushMessageExecutor", " do processActionExecute ".concat(java.lang.String.valueOf(a3)));
                    if (a2.a(string, string2) != com.igexin.push.extension.mod.PushMessageInterface.ActionPrepareState.success) {
                        pushTaskBean.setStatus(com.igexin.push.core.b.af);
                        return;
                    }
                    com.igexin.push.core.e.c.a();
                    com.igexin.push.core.e.c.a(com.igexin.push.core.b.ag, string);
                    pushTaskBean.setStatus(com.igexin.push.core.b.ag);
                    if (a2.a(string, string2, "1")) {
                        return;
                    }
                    com.igexin.push.core.e.c.a();
                    com.igexin.push.core.e.c.a(com.igexin.push.core.b.af, string);
                    pushTaskBean.setStatus(com.igexin.push.core.b.af);
                    return;
                } catch (java.lang.Throwable th2) {
                    com.igexin.c.a.c.a.a(th2);
                    return;
                }
            }
            android.content.Intent intent2 = (android.content.Intent) obj;
            if (intent2.hasExtra("action")) {
                java.lang.String stringExtra = intent2.getStringExtra("action");
                if (stringExtra.equals(com.igexin.sdk.PushConsts.ACTION_SERVICE_INITIALIZE)) {
                    com.igexin.push.core.a.b.d();
                    com.igexin.push.core.a.b.a(intent2);
                    return;
                }
                if (stringExtra.equals(com.igexin.sdk.PushConsts.ACTION_SERVICE_ONRESUME)) {
                    com.igexin.c.a.c.a.a(a + "|handle onresume ~~~", new java.lang.Object[0]);
                    com.igexin.push.core.a.b.d();
                    com.igexin.push.core.a.b.b("on fg");
                    return;
                }
                if (stringExtra.equals(com.igexin.sdk.PushConsts.ACTION_SERVICE_INITIALIZE_SLAVE)) {
                    com.igexin.push.core.a.b.d();
                    com.igexin.push.core.a.b.b(intent2);
                    com.igexin.assist.sdk.AssistPushManager.getInstance().turnOnPush(com.igexin.push.core.e.l);
                    return;
                }
                if (stringExtra.equals(com.igexin.sdk.PushConsts.ACTION_BROADCAST_PUSHMANAGER)) {
                    java.lang.String stringExtra2 = intent2.getStringExtra("sc");
                    if (android.text.TextUtils.isEmpty(com.igexin.push.core.e.i) || com.igexin.push.core.e.i.equals(stringExtra2)) {
                        android.os.Bundle bundleExtra = intent2.getBundleExtra(com.bytedance.sdk.openadsdk.live.TTLiveConstants.BUNDLE_KEY);
                        com.igexin.push.core.a.b.d();
                        com.igexin.push.core.a.b.a(bundleExtra);
                        return;
                    }
                    com.igexin.c.a.c.a.a("safeCode not match!!" + com.igexin.push.core.e.i + "," + stringExtra2, new java.lang.Object[0]);
                    com.igexin.c.a.c.a.d.a().a("safeCode not match!!" + com.igexin.push.core.e.i + "," + stringExtra2);
                    return;
                }
                if (stringExtra.equals(com.igexin.sdk.PushConsts.ACTION_BROADCAST_USER_PRESENT)) {
                    if (com.igexin.push.core.e.u || com.igexin.push.core.e.O <= 10000) {
                        return;
                    }
                    int random = (int) ((java.lang.Math.random() * 100.0d) + 150.0d);
                    com.igexin.c.a.c.a.a(a + "|userPresent, rdelay = " + com.igexin.push.core.e.O + ", reset = " + random, new java.lang.Object[0]);
                    com.igexin.push.core.e.b((long) random);
                    com.igexin.push.g.b.e.g().a(com.igexin.push.core.e.O);
                    return;
                }
                if (stringExtra.equals("com.igexin.action.notification.click")) {
                    android.content.Intent intent3 = (android.content.Intent) intent2.getParcelableExtra("broadcast_intent");
                    if (intent3 != null) {
                        com.igexin.push.core.f.a.a();
                        com.igexin.push.core.f.a.a(intent3);
                        return;
                    }
                    return;
                }
                if (stringExtra.equals(com.igexin.push.core.b.L)) {
                    java.util.HashMap hashMap = (java.util.HashMap) intent2.getSerializableExtra("push_action");
                    com.igexin.c.a.c.a.a(a + "| handle other push action broadcast", new java.lang.Object[0]);
                    com.igexin.push.core.n.a().a.putAll(hashMap);
                    com.igexin.push.core.n.a().d();
                    return;
                }
                if (!stringExtra.equals("com.igexin.action.notification.delete")) {
                    if (stringExtra.equals(com.igexin.sdk.PushConsts.ACTION_BROADCAST_UPLOAD_TYPE253)) {
                        java.lang.String stringExtra3 = intent2.getStringExtra("id");
                        java.lang.String stringExtra4 = intent2.getStringExtra("aid");
                        com.igexin.push.core.c.a.a();
                        com.igexin.push.core.c.a.a(stringExtra3, stringExtra4);
                        return;
                    }
                    return;
                }
                if (intent2.getBooleanExtra("isSummary", false)) {
                    java.lang.String stringExtra5 = intent2.getStringExtra("groupId");
                    com.igexin.push.core.e.aj.remove(stringExtra5);
                    com.igexin.push.core.e.ak.remove(stringExtra5);
                    return;
                }
                com.igexin.push.extension.mod.PushTaskBean pushTaskBean2 = new com.igexin.push.extension.mod.PushTaskBean();
                pushTaskBean2.setAppid(intent2.getStringExtra("appid"));
                pushTaskBean2.setMessageId(intent2.getStringExtra("messageid"));
                java.lang.String stringExtra6 = intent2.getStringExtra("taskid");
                pushTaskBean2.setTaskId(stringExtra6);
                pushTaskBean2.setId(intent2.getStringExtra("id"));
                pushTaskBean2.setAppKey(intent2.getStringExtra("appkey"));
                com.igexin.push.core.e.c.a();
                com.igexin.push.core.e.c.a(stringExtra6, com.igexin.push.core.b.ak, intent2.getIntExtra("redisplayFreq", 0));
                int parseInt = java.lang.Integer.parseInt(intent2.getStringExtra("feedbackid")) + 30040;
                pushTaskBean2.setCurrentActionid(parseInt);
                com.igexin.sdk.main.FeedbackImpl.getInstance().feedbackMessageAction(pushTaskBean2, java.lang.String.valueOf(parseInt), "notifyStyle:" + intent2.getStringExtra("notifyStyle"));
                com.igexin.push.core.a.b.d();
                java.lang.String a4 = com.igexin.push.core.a.b.a(intent2.getStringExtra("taskid"), intent2.getStringExtra("messageid"));
                com.igexin.c.a.c.a.a(a + "|notification delete = " + a4, new java.lang.Object[0]);
                try {
                    com.igexin.push.core.e.ah.remove(a4);
                    com.igexin.c.a.c.a.a(a + "|del notification, pushMessageMap remove = " + a4, new java.lang.Object[0]);
                    return;
                } catch (java.lang.Exception e) {
                    com.igexin.c.a.c.a.a(e);
                    com.igexin.c.a.c.a.a("EndAction|" + e.toString(), new java.lang.Object[0]);
                    return;
                }
            }
            return;
        } catch (java.lang.Throwable th3) {
            com.igexin.c.a.c.a.a(th3);
        }
        com.igexin.c.a.c.a.a(th3);
    }
}
