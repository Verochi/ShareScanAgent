package com.igexin.assist.action;

/* loaded from: classes22.dex */
public class MessageManger {
    private static final java.lang.String a = "Assist_MessageManger";
    private java.lang.String b;

    /* renamed from: com.igexin.assist.action.MessageManger$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ java.lang.String a;
        final /* synthetic */ boolean b;
        final /* synthetic */ android.content.Context c;

        public AnonymousClass1(java.lang.String str, boolean z, android.content.Context context) {
            this.a = str;
            this.b = z;
            this.c = context;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (com.igexin.push.core.e.m.get()) {
                com.igexin.c.a.c.a.b(com.igexin.assist.action.MessageManger.a, "delay 1s save token = " + this.a);
                com.igexin.assist.action.MessageManger.b(this.a, this.b);
                return;
            }
            android.content.Context context = this.c;
            if (context == null) {
                com.igexin.c.a.c.a.b(com.igexin.assist.action.MessageManger.a, " save token in SP ,but context is null " + this.a);
                return;
            }
            com.igexin.push.core.e.d a = com.igexin.push.core.e.d.a(context);
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            try {
                jSONObject.put("token", this.a);
                jSONObject.put("isForce", this.b);
            } catch (org.json.JSONException e) {
                com.igexin.c.a.c.a.a(e);
            }
            a.a(jSONObject);
        }
    }

    public class a implements java.lang.Runnable {
        com.igexin.assist.MessageBean a;

        public a(com.igexin.assist.MessageBean messageBean) {
            this.a = messageBean;
        }

        /* JADX WARN: Removed duplicated region for block: B:13:0x0049  */
        /* JADX WARN: Removed duplicated region for block: B:40:0x00af A[Catch: all -> 0x00cb, TRY_LEAVE, TryCatch #0 {all -> 0x00cb, blocks: (B:2:0x0000, B:4:0x0004, B:16:0x0051, B:18:0x005d, B:20:0x006d, B:22:0x0075, B:29:0x007f, B:31:0x008b, B:33:0x009b, B:35:0x00a3, B:40:0x00af, B:42:0x0028, B:45:0x0032, B:48:0x003c), top: B:1:0x0000 }] */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void run() {
            char c;
            try {
                com.igexin.assist.MessageBean messageBean = this.a;
                if (messageBean == null) {
                    return;
                }
                com.getui.gtc.base.GtcProvider.setContext(messageBean.getContext());
                java.lang.String messageType = this.a.getMessageType();
                int hashCode = messageType.hashCode();
                if (hashCode == -1161803523) {
                    if (messageType.equals(com.igexin.assist.sdk.AssistPushConsts.MSG_TYPE_ACTIONS)) {
                        c = 2;
                        if (c != 0) {
                        }
                    }
                    c = 65535;
                    if (c != 0) {
                    }
                } else if (hashCode != -786701938) {
                    if (hashCode == 110541305 && messageType.equals("token")) {
                        c = 0;
                        if (c != 0) {
                            com.igexin.assist.action.MessageManger.a(com.igexin.assist.action.MessageManger.this, this.a.getContext(), this.a.getStringMessage(), this.a.extra.getBoolean("isForce"));
                            return;
                        }
                        if (c == 1) {
                            if (android.text.TextUtils.isEmpty(this.a.getStringMessage())) {
                                return;
                            }
                            com.igexin.assist.action.a aVar = new com.igexin.assist.action.a();
                            aVar.a(this.a);
                            if (aVar.a(false) && aVar.e.equals(com.igexin.assist.sdk.AssistPushConsts.MSG_VALUE_PAYLOAD)) {
                                com.igexin.assist.action.MessageManger.a(com.igexin.assist.action.MessageManger.this, aVar, this.a.getContext());
                                return;
                            }
                            return;
                        }
                        if (c == 2 && !android.text.TextUtils.isEmpty(this.a.getStringMessage())) {
                            com.igexin.assist.action.a aVar2 = new com.igexin.assist.action.a();
                            aVar2.a(this.a);
                            if (aVar2.a(true) && aVar2.e.equals(com.igexin.assist.sdk.AssistPushConsts.MSG_VALUE_PAYLOAD)) {
                                com.igexin.assist.action.MessageManger.a(this.a.getContext(), aVar2);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    c = 65535;
                    if (c != 0) {
                    }
                } else {
                    if (messageType.equals("payload")) {
                        c = 1;
                        if (c != 0) {
                        }
                    }
                    c = 65535;
                    if (c != 0) {
                    }
                }
            } catch (java.lang.Throwable th) {
                com.igexin.c.a.c.a.a(th);
            }
        }
    }

    public static class b {
        private static final com.igexin.assist.action.MessageManger a = new com.igexin.assist.action.MessageManger((byte) 0);

        private b() {
        }
    }

    private MessageManger() {
    }

    public /* synthetic */ MessageManger(byte b2) {
        this();
    }

    private static com.igexin.push.extension.mod.PushTaskBean a(com.igexin.assist.action.a aVar) {
        long currentTimeMillis = java.lang.System.currentTimeMillis();
        com.igexin.push.extension.mod.PushTaskBean pushTaskBean = new com.igexin.push.extension.mod.PushTaskBean();
        pushTaskBean.setAppid(aVar.d);
        pushTaskBean.setMessageId(aVar.c);
        pushTaskBean.setTaskId(aVar.b);
        pushTaskBean.setId(java.lang.String.valueOf(currentTimeMillis));
        pushTaskBean.setCurrentActionid(1);
        return pushTaskBean;
    }

    public static /* synthetic */ void a(android.content.Context context, com.igexin.assist.action.a aVar) {
        if (!com.igexin.push.core.e.m.get()) {
            com.igexin.assist.util.AssistUtils.startGetuiService(context);
        }
        android.os.Message obtain = android.os.Message.obtain();
        obtain.what = com.igexin.push.core.b.T;
        obtain.obj = aVar.f;
        android.os.Bundle bundle = new android.os.Bundle();
        bundle.putString("content", aVar.f);
        byte[] bArr = aVar.a;
        if (bArr != null) {
            bundle.putByteArray("payload", bArr);
        }
        obtain.setData(bundle);
        com.igexin.push.core.d.a.a.a(obtain);
    }

    private void a(android.content.Context context, java.lang.String str, boolean z) {
        if (android.text.TextUtils.isEmpty(str)) {
            return;
        }
        com.igexin.c.a.c.a.e.a(a, "other token = ".concat(java.lang.String.valueOf(str)));
        if (com.igexin.push.core.e.m.get()) {
            b(str, z);
        } else {
            new android.os.Handler(android.os.Looper.getMainLooper()).postDelayed(new com.igexin.assist.action.MessageManger.AnonymousClass1(str, z, context), 1000L);
        }
    }

    public static /* synthetic */ void a(com.igexin.assist.action.MessageManger messageManger, android.content.Context context, java.lang.String str, boolean z) {
        if (android.text.TextUtils.isEmpty(str)) {
            return;
        }
        com.igexin.c.a.c.a.e.a(a, "other token = ".concat(java.lang.String.valueOf(str)));
        if (com.igexin.push.core.e.m.get()) {
            b(str, z);
        } else {
            new android.os.Handler(android.os.Looper.getMainLooper()).postDelayed(messageManger.new AnonymousClass1(str, z, context), 1000L);
        }
    }

    public static /* synthetic */ void a(com.igexin.assist.action.MessageManger messageManger, com.igexin.assist.action.a aVar, android.content.Context context) {
        if (context == null) {
            return;
        }
        try {
            com.igexin.push.core.e.d a2 = com.igexin.push.core.e.d.a(context);
            if (a2.a(aVar.b)) {
                messageManger.feedbackPushMessage(context, aVar, messageManger.getBrandCode() + "1");
                return;
            }
            a2.b(aVar.b);
            android.os.Bundle bundle = new android.os.Bundle();
            bundle.putInt("action", 10001);
            bundle.putSerializable(com.igexin.sdk.PushConsts.KEY_MESSAGE_DATA, new com.igexin.sdk.message.GTTransmitMessage(aVar.b, aVar.c, aVar.c + com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR + aVar.b, aVar.a));
            com.igexin.push.core.l.a(context);
            com.igexin.push.core.l.a().a(bundle);
            messageManger.feedbackPushMessage(context, aVar, messageManger.getBrandCode() + "0");
        } catch (java.lang.Throwable th) {
            com.igexin.c.a.c.a.a(th);
        }
    }

    private void a(com.igexin.assist.action.a aVar, android.content.Context context) {
        if (aVar == null || context == null) {
            return;
        }
        try {
            com.igexin.push.core.e.d a2 = com.igexin.push.core.e.d.a(context);
            if (a2.a(aVar.b)) {
                feedbackPushMessage(context, aVar, getBrandCode() + "1");
                return;
            }
            a2.b(aVar.b);
            android.os.Bundle bundle = new android.os.Bundle();
            bundle.putInt("action", 10001);
            bundle.putSerializable(com.igexin.sdk.PushConsts.KEY_MESSAGE_DATA, new com.igexin.sdk.message.GTTransmitMessage(aVar.b, aVar.c, aVar.c + com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR + aVar.b, aVar.a));
            com.igexin.push.core.l.a(context);
            com.igexin.push.core.l.a().a(bundle);
            feedbackPushMessage(context, aVar, getBrandCode() + "0");
        } catch (java.lang.Throwable th) {
            com.igexin.c.a.c.a.a(th);
        }
    }

    private static void a(java.lang.String str) {
        try {
            com.igexin.push.core.l.a().a(str);
        } catch (java.lang.Exception e) {
            com.igexin.c.a.c.a.a(e);
        }
    }

    private static void b(android.content.Context context, com.igexin.assist.action.a aVar) {
        if (!com.igexin.push.core.e.m.get()) {
            com.igexin.assist.util.AssistUtils.startGetuiService(context);
        }
        if (aVar == null) {
            return;
        }
        android.os.Message obtain = android.os.Message.obtain();
        obtain.what = com.igexin.push.core.b.T;
        obtain.obj = aVar.f;
        android.os.Bundle bundle = new android.os.Bundle();
        bundle.putString("content", aVar.f);
        byte[] bArr = aVar.a;
        if (bArr != null) {
            bundle.putByteArray("payload", bArr);
        }
        obtain.setData(bundle);
        com.igexin.push.core.d.a.a.a(obtain);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(java.lang.String str, boolean z) {
        a(str);
        if (!z) {
            try {
                if (str.equals(com.igexin.push.core.e.I)) {
                    return;
                }
            } catch (java.lang.Exception e) {
                com.igexin.c.a.c.a.a(e);
                return;
            }
        }
        com.igexin.push.core.e.f.a().b(str);
        if (com.igexin.push.core.e.u) {
            com.igexin.c.a.c.a.b(a, "online, send addphoneinfo");
            com.igexin.push.core.a.b.d().i();
        } else if (z) {
            com.igexin.push.core.e.f.a().c("");
        }
    }

    public static com.igexin.assist.action.MessageManger getInstance() {
        return com.igexin.assist.action.MessageManger.b.a;
    }

    public void addMessage(com.igexin.assist.MessageBean messageBean) {
        com.igexin.b.a.a().a.execute(new com.igexin.assist.action.MessageManger.a(messageBean));
    }

    public void feedbackPushMessage(android.content.Context context, com.igexin.assist.action.a aVar, java.lang.String str) {
        try {
            if (com.igexin.push.core.e.m.get()) {
                com.igexin.sdk.main.FeedbackImpl feedbackImpl = com.igexin.sdk.main.FeedbackImpl.getInstance();
                long currentTimeMillis = java.lang.System.currentTimeMillis();
                com.igexin.push.extension.mod.PushTaskBean pushTaskBean = new com.igexin.push.extension.mod.PushTaskBean();
                pushTaskBean.setAppid(aVar.d);
                pushTaskBean.setMessageId(aVar.c);
                pushTaskBean.setTaskId(aVar.b);
                pushTaskBean.setId(java.lang.String.valueOf(currentTimeMillis));
                pushTaskBean.setCurrentActionid(1);
                feedbackImpl.feedbackMultiBrandMessageAction(pushTaskBean, str);
                return;
            }
            com.igexin.push.core.e.d a2 = com.igexin.push.core.e.d.a(context);
            long currentTimeMillis2 = java.lang.System.currentTimeMillis();
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            jSONObject.put("id", java.lang.String.valueOf(currentTimeMillis2));
            jSONObject.put("messageid", aVar.c);
            jSONObject.put("taskid", aVar.b);
            jSONObject.put("multaid", str);
            jSONObject.put("timestamp", java.lang.String.valueOf(java.lang.System.currentTimeMillis()));
            a2.a(aVar.b, jSONObject);
        } catch (java.lang.Throwable th) {
            com.igexin.c.a.c.a.a(th);
        }
    }

    public java.lang.String getBrandCode() {
        if (!android.text.TextUtils.isEmpty(this.b)) {
            return this.b;
        }
        com.igexin.assist.control.AbstractPushManager abstractPushManager = com.igexin.assist.sdk.a.a().b;
        java.lang.String brandCode = abstractPushManager == null ? "" : abstractPushManager.getBrandCode();
        this.b = brandCode;
        return brandCode;
    }
}
