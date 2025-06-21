package com.zui.opendeviceidlibrary;

/* loaded from: classes19.dex */
public class OpenDeviceId {
    private static java.lang.String c = "OpenDeviceId library";
    private static boolean d;
    private com.zui.deviceidservice.IDeviceidInterface a;
    private com.zui.opendeviceidlibrary.OpenDeviceId.CallBack b;

    /* renamed from: com.zui.opendeviceidlibrary.OpenDeviceId$1, reason: invalid class name */
    class AnonymousClass1 implements android.content.ServiceConnection {
        final /* synthetic */ com.zui.opendeviceidlibrary.OpenDeviceId a;

        @Override // android.content.ServiceConnection
        public synchronized void onServiceConnected(android.content.ComponentName componentName, android.os.IBinder iBinder) {
            this.a.a = com.zui.deviceidservice.IDeviceidInterface.Stub.a(iBinder);
            if (this.a.b != null) {
                this.a.b.a(this.a);
            }
            this.a.a("Service onServiceConnected");
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(android.content.ComponentName componentName) {
            this.a.a = null;
            this.a.a("Service onServiceDisconnected");
        }
    }

    public interface CallBack {
        void a(com.zui.opendeviceidlibrary.OpenDeviceId openDeviceId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(java.lang.String str) {
    }
}
