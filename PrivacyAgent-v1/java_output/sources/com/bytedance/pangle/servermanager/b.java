package com.bytedance.pangle.servermanager;

/* loaded from: classes.dex */
public final class b {
    private static final java.lang.Object a = new java.lang.Object();
    private static final java.lang.Object b = new java.lang.Object();
    private static final java.lang.Object c = new java.lang.Object();
    private static final java.util.Map<java.lang.String, java.lang.Boolean> d = new java.util.concurrent.ConcurrentHashMap();
    private static final java.util.Map<java.lang.String, com.bytedance.pangle.e> e = new java.util.concurrent.ConcurrentHashMap();
    private static com.bytedance.pangle.c f;

    /* renamed from: com.bytedance.pangle.servermanager.b$1, reason: invalid class name */
    public static class AnonymousClass1 implements android.os.IBinder.DeathRecipient {
        final /* synthetic */ java.lang.String a;
        final /* synthetic */ android.os.IBinder b;

        public AnonymousClass1(java.lang.String str, android.os.IBinder iBinder) {
            this.a = str;
            this.b = iBinder;
        }

        @Override // android.os.IBinder.DeathRecipient
        public final void binderDied() {
            com.bytedance.pangle.servermanager.b.d.put(this.a, java.lang.Boolean.FALSE);
            com.bytedance.pangle.log.ZeusLogger.w(com.bytedance.pangle.log.ZeusLogger.TAG_SERVER, "generateServerManager binderDied.");
            java.util.HashMap<android.content.ServiceConnection, java.util.HashSet<android.content.ComponentName>> hashMap = com.bytedance.pangle.service.client.ServiceManagerNative.getInstance().process2ConnAndService.get(this.b);
            if (hashMap != null) {
                for (android.content.ServiceConnection serviceConnection : hashMap.keySet()) {
                    java.util.Iterator<android.content.ComponentName> it = hashMap.get(serviceConnection).iterator();
                    while (it.hasNext()) {
                        serviceConnection.onServiceDisconnected(it.next());
                    }
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0094 A[Catch: RemoteException -> 0x0099, TRY_LEAVE, TryCatch #0 {RemoteException -> 0x0099, blocks: (B:14:0x0056, B:23:0x008f, B:26:0x0094, B:28:0x0076, B:31:0x0080), top: B:13:0x0056 }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0080 A[Catch: RemoteException -> 0x0099, TryCatch #0 {RemoteException -> 0x0099, blocks: (B:14:0x0056, B:23:0x008f, B:26:0x0094, B:28:0x0076, B:31:0x0080), top: B:13:0x0056 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static android.os.IInterface a(java.lang.String str, java.lang.String str2) {
        android.os.IBinder iBinder;
        int hashCode;
        if (!com.bytedance.pangle.Zeus.hasInit()) {
            throw new java.lang.RuntimeException("generateServerManager 请先初始化Zeus, processName:".concat(java.lang.String.valueOf(str2)));
        }
        android.content.pm.ProviderInfo providerInfo = com.bytedance.pangle.Zeus.getServerManagerHashMap().get(str2);
        if (providerInfo == null) {
            throw new java.lang.RuntimeException("宿主中没有找对对应进程的serverManager ".concat(java.lang.String.valueOf(str2)));
        }
        android.os.Bundle call = com.bytedance.pangle.Zeus.getAppApplication().getContentResolver().call(android.net.Uri.parse("content://" + providerInfo.authority), "query_binder", str, (android.os.Bundle) null);
        if (call != null) {
            call.setClassLoader(com.bytedance.pangle.servermanager.AbsServerManager.class.getClassLoader());
            com.bytedance.pangle.servermanager.a aVar = (com.bytedance.pangle.servermanager.a) call.getParcelable("binder");
            if (aVar != null) {
                iBinder = aVar.a;
                if (iBinder != null && iBinder.isBinderAlive()) {
                    try {
                        char c2 = 0;
                        iBinder.linkToDeath(new com.bytedance.pangle.servermanager.b.AnonymousClass1(str2, iBinder), 0);
                        d.put(str2, java.lang.Boolean.TRUE);
                        hashCode = str.hashCode();
                        if (hashCode == -807062458) {
                            if (hashCode == 1984153269 && str.equals("service")) {
                                c2 = 1;
                                if (c2 != 0) {
                                    return com.bytedance.pangle.c.a.a(iBinder);
                                }
                                if (c2 == 1) {
                                    return com.bytedance.pangle.e.a.a(iBinder);
                                }
                            }
                            c2 = 65535;
                            if (c2 != 0) {
                            }
                        } else {
                            if (str.equals("package")) {
                                if (c2 != 0) {
                                }
                            }
                            c2 = 65535;
                            if (c2 != 0) {
                            }
                        }
                    } catch (android.os.RemoteException e2) {
                        com.bytedance.pangle.log.ZeusLogger.errReport(com.bytedance.pangle.log.ZeusLogger.TAG_SERVER, "generateServerManager failed.", e2);
                    }
                }
                return null;
            }
        }
        iBinder = null;
        if (iBinder != null) {
            char c22 = 0;
            iBinder.linkToDeath(new com.bytedance.pangle.servermanager.b.AnonymousClass1(str2, iBinder), 0);
            d.put(str2, java.lang.Boolean.TRUE);
            hashCode = str.hashCode();
            if (hashCode == -807062458) {
            }
        }
        return null;
    }

    public static com.bytedance.pangle.c a() {
        java.lang.Boolean bool = d.get("main");
        if (bool == null || !bool.booleanValue()) {
            f = null;
        }
        if (f == null) {
            synchronized (c) {
                com.bytedance.pangle.c cVar = (com.bytedance.pangle.c) a("package", "main");
                if (cVar == null) {
                    com.bytedance.pangle.log.ZeusLogger.errReport(com.bytedance.pangle.log.ZeusLogger.TAG_SERVER, "getPackageManager failed!!!");
                    return null;
                }
                f = cVar;
            }
        }
        return f;
    }

    public static com.bytedance.pangle.e a(java.lang.String str) {
        java.lang.Boolean bool = d.get(str);
        if (bool == null || !bool.booleanValue()) {
            e.remove(str);
        }
        java.util.Map<java.lang.String, com.bytedance.pangle.e> map = e;
        if (map.get(str) == null) {
            synchronized (b) {
                com.bytedance.pangle.e eVar = (com.bytedance.pangle.e) a("service", str);
                if (eVar == null) {
                    com.bytedance.pangle.log.ZeusLogger.errReport(com.bytedance.pangle.log.ZeusLogger.TAG_SERVER, "getServiceManager failed!!!");
                    return null;
                }
                map.put(str, eVar);
            }
        }
        return map.get(str);
    }
}
