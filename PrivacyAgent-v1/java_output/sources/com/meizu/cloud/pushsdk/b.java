package com.meizu.cloud.pushsdk;

/* loaded from: classes23.dex */
public class b {
    private static volatile com.meizu.cloud.pushsdk.b b;
    private final android.util.SparseArray<com.meizu.cloud.pushsdk.handler.c> a;
    private java.util.Map<java.lang.String, com.meizu.cloud.pushsdk.handler.a> c;
    private com.meizu.cloud.pushsdk.handler.a.f.a d;
    private com.meizu.cloud.pushsdk.handler.a.a.a e;

    public class a extends com.meizu.cloud.pushsdk.handler.a {
        public a() {
        }

        @Override // com.meizu.cloud.pushsdk.handler.a
        public void a(android.content.Context context, android.content.Intent intent) {
            java.util.Iterator it = com.meizu.cloud.pushsdk.b.this.c.entrySet().iterator();
            while (it.hasNext()) {
                com.meizu.cloud.pushsdk.handler.a aVar = (com.meizu.cloud.pushsdk.handler.a) ((java.util.Map.Entry) it.next()).getValue();
                if (aVar != null) {
                    aVar.a(context, intent);
                }
            }
        }

        @Override // com.meizu.cloud.pushsdk.handler.b
        public void a(android.content.Context context, com.meizu.cloud.pushsdk.handler.MzPushMessage mzPushMessage) {
            java.util.Iterator it = com.meizu.cloud.pushsdk.b.this.c.entrySet().iterator();
            while (it.hasNext()) {
                com.meizu.cloud.pushsdk.handler.a aVar = (com.meizu.cloud.pushsdk.handler.a) ((java.util.Map.Entry) it.next()).getValue();
                if (aVar != null) {
                    aVar.a(context, mzPushMessage);
                }
            }
        }

        @Override // com.meizu.cloud.pushsdk.handler.b
        public void a(android.content.Context context, com.meizu.cloud.pushsdk.platform.message.PushSwitchStatus pushSwitchStatus) {
            java.util.Iterator it = com.meizu.cloud.pushsdk.b.this.c.entrySet().iterator();
            while (it.hasNext()) {
                com.meizu.cloud.pushsdk.handler.a aVar = (com.meizu.cloud.pushsdk.handler.a) ((java.util.Map.Entry) it.next()).getValue();
                if (aVar != null) {
                    aVar.a(context, pushSwitchStatus);
                }
            }
        }

        @Override // com.meizu.cloud.pushsdk.handler.b
        public void a(android.content.Context context, com.meizu.cloud.pushsdk.platform.message.RegisterStatus registerStatus) {
            java.util.Iterator it = com.meizu.cloud.pushsdk.b.this.c.entrySet().iterator();
            while (it.hasNext()) {
                com.meizu.cloud.pushsdk.handler.a aVar = (com.meizu.cloud.pushsdk.handler.a) ((java.util.Map.Entry) it.next()).getValue();
                if (aVar != null) {
                    aVar.a(context, registerStatus);
                }
            }
        }

        @Override // com.meizu.cloud.pushsdk.handler.b
        public void a(android.content.Context context, com.meizu.cloud.pushsdk.platform.message.SubAliasStatus subAliasStatus) {
            java.util.Iterator it = com.meizu.cloud.pushsdk.b.this.c.entrySet().iterator();
            while (it.hasNext()) {
                com.meizu.cloud.pushsdk.handler.a aVar = (com.meizu.cloud.pushsdk.handler.a) ((java.util.Map.Entry) it.next()).getValue();
                if (aVar != null) {
                    aVar.a(context, subAliasStatus);
                }
            }
        }

        @Override // com.meizu.cloud.pushsdk.handler.b
        public void a(android.content.Context context, com.meizu.cloud.pushsdk.platform.message.SubTagsStatus subTagsStatus) {
            java.util.Iterator it = com.meizu.cloud.pushsdk.b.this.c.entrySet().iterator();
            while (it.hasNext()) {
                com.meizu.cloud.pushsdk.handler.a aVar = (com.meizu.cloud.pushsdk.handler.a) ((java.util.Map.Entry) it.next()).getValue();
                if (aVar != null) {
                    aVar.a(context, subTagsStatus);
                }
            }
        }

        @Override // com.meizu.cloud.pushsdk.handler.b
        public void a(android.content.Context context, com.meizu.cloud.pushsdk.platform.message.UnRegisterStatus unRegisterStatus) {
            java.util.Iterator it = com.meizu.cloud.pushsdk.b.this.c.entrySet().iterator();
            while (it.hasNext()) {
                com.meizu.cloud.pushsdk.handler.a aVar = (com.meizu.cloud.pushsdk.handler.a) ((java.util.Map.Entry) it.next()).getValue();
                if (aVar != null) {
                    aVar.a(context, unRegisterStatus);
                }
            }
        }

        @Override // com.meizu.cloud.pushsdk.handler.b
        public void a(android.content.Context context, java.lang.String str) {
            java.util.Iterator it = com.meizu.cloud.pushsdk.b.this.c.entrySet().iterator();
            while (it.hasNext()) {
                com.meizu.cloud.pushsdk.handler.a aVar = (com.meizu.cloud.pushsdk.handler.a) ((java.util.Map.Entry) it.next()).getValue();
                if (aVar != null) {
                    aVar.a(context, str);
                }
            }
        }

        @Override // com.meizu.cloud.pushsdk.handler.b
        public void a(android.content.Context context, java.lang.String str, java.lang.String str2) {
            java.util.Iterator it = com.meizu.cloud.pushsdk.b.this.c.entrySet().iterator();
            while (it.hasNext()) {
                com.meizu.cloud.pushsdk.handler.a aVar = (com.meizu.cloud.pushsdk.handler.a) ((java.util.Map.Entry) it.next()).getValue();
                if (aVar != null) {
                    aVar.a(context, str, str2);
                }
            }
        }

        @Override // com.meizu.cloud.pushsdk.handler.b
        public void a(android.content.Context context, boolean z) {
            java.util.Iterator it = com.meizu.cloud.pushsdk.b.this.c.entrySet().iterator();
            while (it.hasNext()) {
                com.meizu.cloud.pushsdk.handler.a aVar = (com.meizu.cloud.pushsdk.handler.a) ((java.util.Map.Entry) it.next()).getValue();
                if (aVar != null) {
                    aVar.a(context, z);
                }
            }
        }

        @Override // com.meizu.cloud.pushsdk.handler.b
        public void a(com.meizu.cloud.pushsdk.notification.PushNotificationBuilder pushNotificationBuilder) {
            java.util.Iterator it = com.meizu.cloud.pushsdk.b.this.c.entrySet().iterator();
            while (it.hasNext()) {
                com.meizu.cloud.pushsdk.handler.a aVar = (com.meizu.cloud.pushsdk.handler.a) ((java.util.Map.Entry) it.next()).getValue();
                if (aVar != null) {
                    aVar.a(pushNotificationBuilder);
                }
            }
        }

        @Override // com.meizu.cloud.pushsdk.handler.b
        public void b(android.content.Context context, com.meizu.cloud.pushsdk.handler.MzPushMessage mzPushMessage) {
            java.util.Iterator it = com.meizu.cloud.pushsdk.b.this.c.entrySet().iterator();
            while (it.hasNext()) {
                com.meizu.cloud.pushsdk.handler.a aVar = (com.meizu.cloud.pushsdk.handler.a) ((java.util.Map.Entry) it.next()).getValue();
                if (aVar != null) {
                    aVar.b(context, mzPushMessage);
                }
            }
        }

        @Override // com.meizu.cloud.pushsdk.handler.b
        public void b(android.content.Context context, java.lang.String str) {
            java.util.Iterator it = com.meizu.cloud.pushsdk.b.this.c.entrySet().iterator();
            while (it.hasNext()) {
                com.meizu.cloud.pushsdk.handler.a aVar = (com.meizu.cloud.pushsdk.handler.a) ((java.util.Map.Entry) it.next()).getValue();
                if (aVar != null) {
                    aVar.b(context, str);
                }
            }
        }

        @Override // com.meizu.cloud.pushsdk.handler.b
        public void c(android.content.Context context, com.meizu.cloud.pushsdk.handler.MzPushMessage mzPushMessage) {
            java.util.Iterator it = com.meizu.cloud.pushsdk.b.this.c.entrySet().iterator();
            while (it.hasNext()) {
                com.meizu.cloud.pushsdk.handler.a aVar = (com.meizu.cloud.pushsdk.handler.a) ((java.util.Map.Entry) it.next()).getValue();
                if (aVar != null) {
                    aVar.c(context, mzPushMessage);
                }
            }
        }

        @Override // com.meizu.cloud.pushsdk.handler.b
        public void c(android.content.Context context, java.lang.String str) {
            java.util.Iterator it = com.meizu.cloud.pushsdk.b.this.c.entrySet().iterator();
            while (it.hasNext()) {
                com.meizu.cloud.pushsdk.handler.a aVar = (com.meizu.cloud.pushsdk.handler.a) ((java.util.Map.Entry) it.next()).getValue();
                if (aVar != null) {
                    aVar.c(context, str);
                }
            }
        }
    }

    public b(android.content.Context context) {
        this(context, null);
    }

    public b(android.content.Context context, java.util.List<com.meizu.cloud.pushsdk.handler.c> list) {
        this(context, list, null);
    }

    public b(android.content.Context context, java.util.List<com.meizu.cloud.pushsdk.handler.c> list, com.meizu.cloud.pushsdk.handler.a aVar) {
        this.a = new android.util.SparseArray<>();
        if (context == null) {
            throw new java.lang.IllegalArgumentException("Context must not be null.");
        }
        android.content.Context applicationContext = context.getApplicationContext();
        this.c = new java.util.HashMap();
        com.meizu.cloud.pushsdk.b.a aVar2 = new com.meizu.cloud.pushsdk.b.a();
        if (com.meizu.cloud.pushsdk.constants.PushConstants.PUSH_PACKAGE_NAME.equalsIgnoreCase(applicationContext.getPackageName())) {
            this.d = new com.meizu.cloud.pushsdk.handler.a.f.a(applicationContext);
            if (com.meizu.cloud.pushsdk.util.MinSdkChecker.isSupportNotificationSort()) {
                this.e = new com.meizu.cloud.pushsdk.handler.a.a.a(applicationContext);
            }
        }
        if (list != null) {
            a(list);
            return;
        }
        a(new com.meizu.cloud.pushsdk.handler.a.c(applicationContext, aVar2));
        a(new com.meizu.cloud.pushsdk.handler.a.b(applicationContext, aVar2));
        a(new com.meizu.cloud.pushsdk.handler.a.e(applicationContext, aVar2));
        a(new com.meizu.cloud.pushsdk.handler.a.d.b(applicationContext, aVar2));
        a(new com.meizu.cloud.pushsdk.handler.a.d(applicationContext, aVar2));
        a(new com.meizu.cloud.pushsdk.handler.a.f(applicationContext, aVar2));
        a(new com.meizu.cloud.pushsdk.handler.a.d.d(applicationContext, aVar2));
        a(new com.meizu.cloud.pushsdk.handler.a.e.a(applicationContext, aVar2));
        a(new com.meizu.cloud.pushsdk.handler.a.e.c(applicationContext, aVar2));
        a(new com.meizu.cloud.pushsdk.handler.a.e.f(applicationContext, aVar2));
        a(new com.meizu.cloud.pushsdk.handler.a.e.d(applicationContext, aVar2));
        a(new com.meizu.cloud.pushsdk.handler.a.e.e(applicationContext, aVar2));
        a(new com.meizu.cloud.pushsdk.handler.a.f.c(applicationContext, aVar2));
        a(new com.meizu.cloud.pushsdk.handler.a.e.b(applicationContext, aVar2));
        a(new com.meizu.cloud.pushsdk.handler.a.d.e(applicationContext, aVar2));
        a(new com.meizu.cloud.pushsdk.handler.a.b.a(applicationContext, aVar2));
        a(new com.meizu.cloud.pushsdk.handler.a.d.a(applicationContext, aVar2));
        a(new com.meizu.cloud.pushsdk.handler.a.d.f(applicationContext, aVar2));
        a(new com.meizu.cloud.pushsdk.handler.a.f.b(applicationContext, aVar2));
        a(new com.meizu.cloud.pushsdk.handler.a.d.c(applicationContext, aVar2));
    }

    public static com.meizu.cloud.pushsdk.b a(android.content.Context context) {
        if (b == null) {
            synchronized (com.meizu.cloud.pushsdk.b.class) {
                if (b == null) {
                    com.meizu.cloud.pushinternal.DebugLogger.i("PushMessageProxy", "PushMessageProxy init");
                    b = new com.meizu.cloud.pushsdk.b(context);
                }
            }
        }
        return b;
    }

    public com.meizu.cloud.pushsdk.b a(com.meizu.cloud.pushsdk.handler.c cVar) {
        this.a.put(cVar.a(), cVar);
        return this;
    }

    public com.meizu.cloud.pushsdk.b a(java.lang.String str, com.meizu.cloud.pushsdk.handler.a aVar) {
        this.c.put(str, aVar);
        return this;
    }

    public com.meizu.cloud.pushsdk.b a(java.util.List<com.meizu.cloud.pushsdk.handler.c> list) {
        if (list == null) {
            throw new java.lang.IllegalArgumentException("messageManagerList must not be null.");
        }
        java.util.Iterator<com.meizu.cloud.pushsdk.handler.c> it = list.iterator();
        while (it.hasNext()) {
            a(it.next());
        }
        return this;
    }

    public com.meizu.cloud.pushsdk.handler.a.f.a a() {
        return this.d;
    }

    public void a(android.content.Intent intent) {
        com.meizu.cloud.pushinternal.DebugLogger.e("PushMessageProxy", "process message start");
        try {
            com.meizu.cloud.pushinternal.DebugLogger.i("PushMessageProxy", "receive action " + intent.getAction() + " method " + intent.getStringExtra("method"));
            for (int i = 0; i < this.a.size() && !this.a.valueAt(i).b(intent); i++) {
            }
        } catch (java.lang.Exception e) {
            com.meizu.cloud.pushinternal.DebugLogger.e("PushMessageProxy", "process message error " + e.getMessage());
        }
    }

    public com.meizu.cloud.pushsdk.handler.a.a.a b() {
        return this.e;
    }
}
