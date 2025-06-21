package com.bytedance.pangle.service.client;

@androidx.annotation.Keep
/* loaded from: classes.dex */
public class ServiceManagerNative {
    private static volatile com.bytedance.pangle.service.client.ServiceManagerNative sInstance;
    private final java.util.HashMap<android.content.ServiceConnection, com.bytedance.pangle.g> serviceConn2ServiceConn = new java.util.HashMap<>();
    public java.util.HashMap<android.os.IBinder, java.util.HashMap<android.content.ServiceConnection, java.util.HashSet<android.content.ComponentName>>> process2ConnAndService = new java.util.HashMap<>();
    private java.util.HashMap<android.content.ServiceConnection, java.util.HashSet<android.content.pm.ServiceInfo>> conn2Service = new java.util.HashMap<>();

    /* renamed from: com.bytedance.pangle.service.client.ServiceManagerNative$1, reason: invalid class name */
    public class AnonymousClass1 extends com.bytedance.pangle.g.a {
        final /* synthetic */ android.content.ServiceConnection a;

        public AnonymousClass1(android.content.ServiceConnection serviceConnection) {
            this.a = serviceConnection;
        }

        @Override // com.bytedance.pangle.g
        public final int a() {
            return this.a.hashCode();
        }

        @Override // com.bytedance.pangle.g
        public final void a(android.content.ComponentName componentName, android.os.IBinder iBinder) {
            this.a.onServiceConnected(componentName, iBinder);
        }
    }

    private ServiceManagerNative() {
    }

    public static com.bytedance.pangle.service.client.ServiceManagerNative getInstance() {
        if (sInstance == null) {
            synchronized (com.bytedance.pangle.service.client.ServiceManagerNative.class) {
                if (sInstance == null) {
                    sInstance = new com.bytedance.pangle.service.client.ServiceManagerNative();
                }
            }
        }
        return sInstance;
    }

    public boolean bindServiceNative(android.content.Context context, android.content.Intent intent, android.content.ServiceConnection serviceConnection, int i, java.lang.String str) {
        android.content.pm.ServiceInfo queryServiceFromPlugin = queryServiceFromPlugin(intent, str);
        if (queryServiceFromPlugin == null) {
            return context.bindService(intent, serviceConnection, i);
        }
        if (!this.serviceConn2ServiceConn.containsKey(serviceConnection)) {
            this.serviceConn2ServiceConn.put(serviceConnection, new com.bytedance.pangle.service.client.ServiceManagerNative.AnonymousClass1(serviceConnection));
        }
        if (this.conn2Service.get(serviceConnection) == null) {
            this.conn2Service.put(serviceConnection, new java.util.HashSet<>());
        }
        this.conn2Service.get(serviceConnection).add(queryServiceFromPlugin);
        com.bytedance.pangle.e a = com.bytedance.pangle.servermanager.b.a(queryServiceFromPlugin.processName);
        android.os.IBinder asBinder = a.asBinder();
        java.util.HashMap<android.content.ServiceConnection, java.util.HashSet<android.content.ComponentName>> hashMap = this.process2ConnAndService.get(asBinder);
        if (hashMap == null) {
            hashMap = new java.util.HashMap<>();
            this.process2ConnAndService.put(asBinder, hashMap);
        }
        java.util.HashSet<android.content.ComponentName> hashSet = hashMap.get(serviceConnection);
        if (hashSet == null) {
            hashSet = new java.util.HashSet<>();
            hashMap.put(serviceConnection, hashSet);
        }
        hashSet.add(intent.getComponent());
        try {
            return a.a(intent, this.serviceConn2ServiceConn.get(serviceConnection), i, str);
        } catch (android.os.RemoteException e) {
            com.bytedance.pangle.log.ZeusLogger.errReport(com.bytedance.pangle.log.ZeusLogger.TAG_SERVICE, "bindService failed!", e);
            return false;
        }
    }

    public android.content.pm.ServiceInfo queryServiceFromPlugin(android.content.Intent intent, java.lang.String str) {
        com.bytedance.pangle.Zeus.loadPlugin(str);
        android.content.ComponentName component = intent.getComponent();
        if (component == null) {
            return null;
        }
        return com.bytedance.pangle.plugin.PluginManager.getInstance().getPlugin(str).pluginServices.get(component.getClassName());
    }

    public android.content.ComponentName startServiceNative(android.content.Context context, android.content.Intent intent, java.lang.String str) {
        android.content.pm.ServiceInfo queryServiceFromPlugin = queryServiceFromPlugin(intent, str);
        if (queryServiceFromPlugin == null) {
            return context.startService(intent);
        }
        try {
            return com.bytedance.pangle.servermanager.b.a(queryServiceFromPlugin.processName).a(intent, str);
        } catch (android.os.RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean stopServiceNative(android.content.Context context, android.content.Intent intent, java.lang.String str) {
        android.content.pm.ServiceInfo queryServiceFromPlugin = queryServiceFromPlugin(intent, str);
        if (queryServiceFromPlugin == null) {
            return context.stopService(intent);
        }
        try {
            return com.bytedance.pangle.servermanager.b.a(queryServiceFromPlugin.processName).b(intent, str);
        } catch (android.os.RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void unbindServiceNative(android.content.ServiceConnection serviceConnection) {
        java.util.HashSet<android.content.pm.ServiceInfo> hashSet = this.conn2Service.get(serviceConnection);
        if (hashSet != null) {
            java.util.Iterator<android.content.pm.ServiceInfo> it = hashSet.iterator();
            while (it.hasNext()) {
                try {
                    com.bytedance.pangle.servermanager.b.a(it.next().processName).a(this.serviceConn2ServiceConn.get(serviceConnection));
                } catch (android.os.RemoteException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
