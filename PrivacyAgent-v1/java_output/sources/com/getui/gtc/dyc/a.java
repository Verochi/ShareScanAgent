package com.getui.gtc.dyc;

/* loaded from: classes22.dex */
public class a implements com.getui.gtc.base.publish.Subscriber {
    private static java.lang.String a;

    /* renamed from: com.getui.gtc.dyc.a$1, reason: invalid class name */
    public class AnonymousClass1 implements com.getui.gtc.dyc.b.c {
        final /* synthetic */ com.getui.gtc.dyc.Callback a;

        public AnonymousClass1(com.getui.gtc.dyc.Callback callback) {
            this.a = callback;
        }

        @Override // com.getui.gtc.dyc.b.c
        public void a(java.util.Map<java.lang.String, java.lang.String> map, java.util.Map<java.lang.String, java.lang.String> map2) {
            try {
                this.a.a(map, map2);
            } catch (android.os.RemoteException e) {
                com.getui.gtc.dyc.a.a.a.a(e);
            }
        }

        @Override // com.getui.gtc.dyc.b.c
        public void b(java.lang.String str) {
            try {
                this.a.b(str);
            } catch (android.os.RemoteException e) {
                com.getui.gtc.dyc.a.a.a.a(e);
            }
        }
    }

    /* renamed from: com.getui.gtc.dyc.a$2, reason: invalid class name */
    public class AnonymousClass2 extends com.getui.gtc.dyc.Callback.a {
        final /* synthetic */ com.getui.gtc.dyc.b.b a;

        public AnonymousClass2(com.getui.gtc.dyc.b.b bVar) {
            this.a = bVar;
        }

        @Override // com.getui.gtc.dyc.Callback
        public void a(java.util.Map map, java.util.Map map2) throws android.os.RemoteException {
            this.a.i().a(map, map2);
        }

        @Override // com.getui.gtc.dyc.Callback
        public void b(java.lang.String str) throws android.os.RemoteException {
            this.a.i().b(str);
        }
    }

    /* renamed from: com.getui.gtc.dyc.a$a, reason: collision with other inner class name */
    public static class C0303a {
        private static com.getui.gtc.dyc.a a = new com.getui.gtc.dyc.a(null);
    }

    private a() {
    }

    public /* synthetic */ a(com.getui.gtc.dyc.a.AnonymousClass1 anonymousClass1) {
        this();
    }

    public static com.getui.gtc.dyc.a a() {
        a = java.lang.Thread.currentThread().getStackTrace()[2].getMethodName();
        return com.getui.gtc.dyc.a.C0303a.a;
    }

    private android.os.Bundle d() {
        android.os.Bundle bundle = new android.os.Bundle();
        bundle.putString(com.getui.gtc.base.ProcessSwitchContract.CLASS_NAME, getClass().getName());
        bundle.putString(com.getui.gtc.base.ProcessSwitchContract.GET_INSTANCE, a);
        return bundle;
    }

    public java.util.Map<java.lang.String, java.lang.String> a(com.getui.gtc.dyc.b.b bVar) {
        if (com.getui.gtc.base.util.CommonUtil.isGtcProcess()) {
            return com.getui.gtc.dyc.f.a().a(bVar);
        }
        android.os.Bundle d = d();
        d.putString(com.getui.gtc.base.ProcessSwitchContract.METHOD_NAME, "dyc-1-1");
        d.putParcelable("dyc-1-2", bVar);
        if (bVar.i() != null) {
            com.getui.gtc.base.util.BundleCompat.putBinder(d, "dyc-1-3", new com.getui.gtc.dyc.a.AnonymousClass2(bVar));
        }
        return (java.util.Map) com.getui.gtc.base.publish.Broker.getInstance().subscribe(d).get(com.getui.gtc.base.ProcessSwitchContract.METHOD_RETURN);
    }

    public java.util.Map<java.lang.String, java.lang.String> a(java.lang.String str) {
        if (com.getui.gtc.base.util.CommonUtil.isGtcProcess()) {
            return com.getui.gtc.dyc.f.a().a(str);
        }
        android.os.Bundle d = d();
        d.putString(com.getui.gtc.base.ProcessSwitchContract.METHOD_NAME, "dyc-2-1");
        d.putString("dyc-2-2", str);
        return (java.util.Map) com.getui.gtc.base.publish.Broker.getInstance().subscribe(d).get(com.getui.gtc.base.ProcessSwitchContract.METHOD_RETURN);
    }

    public void a(java.lang.String str, java.util.Map<java.lang.String, java.lang.String> map) {
        if (com.getui.gtc.base.util.CommonUtil.isGtcProcess()) {
            com.getui.gtc.dyc.f.a().a(str, map);
            return;
        }
        android.os.Bundle d = d();
        d.putString(com.getui.gtc.base.ProcessSwitchContract.METHOD_NAME, "dyc-4-1");
        d.putString("dyc-4-2", str);
        d.putSerializable("dyc-4-3", (java.util.HashMap) map);
        com.getui.gtc.base.publish.Broker.getInstance().subscribe(d);
    }

    public java.util.Map<java.lang.String, java.util.Map<java.lang.String, java.lang.String>> c() {
        if (com.getui.gtc.base.util.CommonUtil.isGtcProcess()) {
            return com.getui.gtc.dyc.f.a().c();
        }
        android.os.Bundle d = d();
        d.putString(com.getui.gtc.base.ProcessSwitchContract.METHOD_NAME, "dyc-3-1");
        return (java.util.Map) com.getui.gtc.base.publish.Broker.getInstance().subscribe(d).get(com.getui.gtc.base.ProcessSwitchContract.METHOD_RETURN);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x00b3 A[DONT_GENERATE, LOOP:0: B:19:0x00ad->B:21:0x00b3, LOOP_END] */
    @Override // com.getui.gtc.base.publish.Subscriber
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void receive(android.os.Bundle bundle, android.os.Bundle bundle2) {
        char c;
        java.io.Serializable serializable;
        java.util.ArrayList arrayList = new java.util.ArrayList();
        try {
            java.lang.Throwable th = (java.lang.Throwable) bundle2.getSerializable(com.getui.gtc.base.ProcessSwitchContract.METHOD_EXCEPTION);
            if (th != null) {
                arrayList.add(th);
            }
            java.lang.String string = bundle.getString(com.getui.gtc.base.ProcessSwitchContract.METHOD_NAME);
            if (android.text.TextUtils.isEmpty(string)) {
                throw new java.lang.RuntimeException("methodName missed");
            }
            switch (string.hashCode()) {
                case 2112999862:
                    if (string.equals("dyc-1-1")) {
                        c = 0;
                        break;
                    }
                    c = 65535;
                    break;
                case 2113000823:
                    if (string.equals("dyc-2-1")) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                case 2113001784:
                    if (string.equals("dyc-3-1")) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                case 2113002745:
                    if (string.equals("dyc-4-1")) {
                        c = 3;
                        break;
                    }
                    c = 65535;
                    break;
                default:
                    c = 65535;
                    break;
            }
            if (c == 0) {
                com.getui.gtc.dyc.b.b bVar = (com.getui.gtc.dyc.b.b) bundle.getParcelable("dyc-1-2");
                com.getui.gtc.dyc.Callback a2 = com.getui.gtc.dyc.Callback.a.a(com.getui.gtc.base.util.BundleCompat.getBinder(bundle, "dyc-1-3"));
                if (a2 != null) {
                    bVar.i(new com.getui.gtc.dyc.a.AnonymousClass1(a2));
                }
                serializable = (java.io.Serializable) a(bVar);
            } else if (c == 1) {
                serializable = (java.io.Serializable) a(bundle.getString("dyc-2-2"));
            } else {
                if (c != 2) {
                    if (c == 3) {
                        a(bundle.getString("dyc-4-2"), (java.util.HashMap) bundle.getSerializable("dyc-4-3"));
                    }
                }
                serializable = (java.io.Serializable) c();
            }
            bundle2.putSerializable(com.getui.gtc.base.ProcessSwitchContract.METHOD_RETURN, serializable);
        } catch (java.lang.Throwable th2) {
            try {
                arrayList.add(th2);
                java.util.Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    com.getui.gtc.dyc.a.a.a.a((java.lang.Throwable) it.next());
                }
            } finally {
                java.util.Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    com.getui.gtc.dyc.a.a.a.a((java.lang.Throwable) it2.next());
                }
            }
        }
    }
}
