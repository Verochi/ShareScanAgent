package com.efs.sdk.base.core.b;

/* loaded from: classes22.dex */
public final class e extends android.os.Handler {
    public int a;
    public int b;
    public com.efs.sdk.base.core.b.d c;
    public com.efs.sdk.base.core.cache.IFileFilter d;
    private com.efs.sdk.base.core.b.d e;
    private com.efs.sdk.base.core.b.d f;
    private java.util.List<java.lang.String> g;
    private java.util.List<java.lang.String> h;
    private java.util.concurrent.atomic.AtomicInteger i;
    private java.util.concurrent.atomic.AtomicInteger j;
    private com.efs.sdk.base.core.cache.IFileFilter k;

    public static class a {
        private static final com.efs.sdk.base.core.b.e a = new com.efs.sdk.base.core.b.e((byte) 0);
    }

    private e() {
        super(com.efs.sdk.base.core.util.concurrent.a.a.getLooper());
        this.a = 5;
        this.b = 1000;
        this.g = new java.util.ArrayList();
        this.h = new java.util.ArrayList();
        this.i = new java.util.concurrent.atomic.AtomicInteger(0);
        this.j = new java.util.concurrent.atomic.AtomicInteger(0);
        this.c = new com.efs.sdk.base.core.b.a();
        this.e = new com.efs.sdk.base.core.b.b();
        this.f = new com.efs.sdk.base.core.d.e();
        this.k = new com.efs.sdk.base.core.cache.f();
    }

    public /* synthetic */ e(byte b) {
        this();
    }

    public static com.efs.sdk.base.core.b.e a() {
        return com.efs.sdk.base.core.b.e.a.a;
    }

    public final void a(java.lang.Object obj, int i) {
        android.os.Message obtain = android.os.Message.obtain();
        obtain.what = 1;
        obtain.obj = obj;
        obtain.arg1 = i;
        sendMessage(obtain);
    }

    public final void b(java.lang.Object obj, int i) {
        android.os.Message obtain = android.os.Message.obtain();
        obtain.what = 11;
        obtain.obj = obj;
        obtain.arg1 = i;
        sendMessage(obtain);
    }

    @Override // android.os.Handler
    public final void handleMessage(android.os.Message message) {
        com.efs.sdk.base.core.b.h hVar;
        super.handleMessage(message);
        hVar = com.efs.sdk.base.core.b.h.a.a;
        if (hVar.a()) {
            int i = message.what;
            if (i == 0) {
                java.lang.String netStatus = com.efs.sdk.base.core.config.GlobalInfoManager.getInstance().getNetStatus();
                if (com.efs.sdk.base.core.util.NetworkUtil.NETWORK_CLASS_DENIED.equalsIgnoreCase(netStatus) || com.efs.sdk.base.core.util.NetworkUtil.NETWORK_CLASS_DISCONNECTED.equalsIgnoreCase(netStatus)) {
                    com.efs.sdk.base.core.util.Log.i("efs.send_log", "log cann't be send because net status is ".concat(java.lang.String.valueOf(netStatus)));
                    sendEmptyMessageDelayed(0, com.efs.sdk.base.core.controller.ControllerCenter.getGlobalEnvStruct().getLogSendIntervalMills());
                    return;
                }
                java.util.List<com.efs.sdk.base.core.model.LogDto> emptyList = java.util.Collections.emptyList();
                try {
                    emptyList = com.efs.sdk.base.core.cache.CacheManager.getInstance().getLogDto(this.a, this.k);
                } catch (java.lang.Throwable unused) {
                }
                for (com.efs.sdk.base.core.model.LogDto logDto : emptyList) {
                    if ("wa".equals(logDto.getLogType()) || com.efs.sdk.base.core.b.c.a().a(logDto.getLogType(), logDto.getBodySize())) {
                        com.efs.sdk.base.core.b.d dVar = this.c;
                        if ("wa".equals(logDto.getLogType())) {
                            dVar = this.f;
                        }
                        java.lang.String uuid = java.util.UUID.randomUUID().toString();
                        this.g.add(uuid);
                        if (com.efs.sdk.base.core.util.concurrent.WorkThreadUtil.submit(new com.efs.sdk.base.core.b.f(logDto, dVar, uuid)) == null) {
                            a(uuid, -1);
                        }
                    }
                }
                if (this.g.size() <= 0) {
                    sendEmptyMessageDelayed(0, com.efs.sdk.base.core.controller.ControllerCenter.getGlobalEnvStruct().getLogSendIntervalMills());
                    return;
                }
                return;
            }
            if (i == 1) {
                java.lang.Object obj = message.obj;
                if (obj != null) {
                    this.g.remove(obj.toString());
                }
                int incrementAndGet = message.arg1 != 0 ? this.i.incrementAndGet() : 0;
                if (this.g.isEmpty()) {
                    if (incrementAndGet < 5) {
                        sendEmptyMessage(0);
                        return;
                    }
                    this.i.set(0);
                    sendEmptyMessageDelayed(0, com.efs.sdk.base.core.controller.ControllerCenter.getGlobalEnvStruct().getLogSendDelayMills());
                    com.efs.sdk.base.core.util.Log.i("efs.send_log", "request error cnt gt 5, next request delay 10s");
                    return;
                }
                return;
            }
            if (i != 10) {
                if (i != 11) {
                    return;
                }
                java.lang.Object obj2 = message.obj;
                if (obj2 != null) {
                    this.h.remove(obj2.toString());
                }
                int incrementAndGet2 = message.arg1 != 0 ? this.j.incrementAndGet() : 0;
                if (this.h.isEmpty()) {
                    if (incrementAndGet2 == 0) {
                        com.efs.sdk.base.core.util.Log.i("efs.send_log", "send secess.");
                        this.d.finish();
                    }
                    if (incrementAndGet2 < 5) {
                        sendEmptyMessage(10);
                        return;
                    }
                    this.j.set(0);
                    sendEmptyMessageDelayed(10, com.efs.sdk.base.core.controller.ControllerCenter.getGlobalEnvStruct().getLogSendDelayMills());
                    com.efs.sdk.base.core.util.Log.i("efs.send_log", "request error cnt gt 5, next request delay 10s");
                    return;
                }
                return;
            }
            if (!this.d.hasTask()) {
                com.efs.sdk.base.core.util.Log.i("efs.send_log", "-> none task. return.");
                return;
            }
            java.lang.String netStatus2 = com.efs.sdk.base.core.config.GlobalInfoManager.getInstance().getNetStatus();
            if (com.efs.sdk.base.core.util.NetworkUtil.NETWORK_CLASS_DENIED.equalsIgnoreCase(netStatus2) || com.efs.sdk.base.core.util.NetworkUtil.NETWORK_CLASS_DISCONNECTED.equalsIgnoreCase(netStatus2)) {
                com.efs.sdk.base.core.util.Log.i("efs.send_log", "log cann't be send because net status is ".concat(java.lang.String.valueOf(netStatus2)));
                com.efs.sdk.base.core.util.Log.i("efs.send_log", "-> none net. over.");
                sendEmptyMessageDelayed(10, 300000L);
                return;
            }
            java.util.List<com.efs.sdk.base.core.model.LogDto> emptyList2 = java.util.Collections.emptyList();
            try {
                emptyList2 = com.efs.sdk.base.core.cache.CacheManager.getInstance().getLogDtoCodeLog(this.b, this.d);
            } catch (java.lang.Throwable unused2) {
            }
            for (com.efs.sdk.base.core.model.LogDto logDto2 : emptyList2) {
                com.efs.sdk.base.core.b.d dVar2 = this.e;
                java.lang.String uuid2 = java.util.UUID.randomUUID().toString();
                this.h.add(uuid2);
                if (com.efs.sdk.base.core.util.concurrent.WorkThreadUtil.submit(new com.efs.sdk.base.core.b.g(logDto2, dVar2, uuid2)) == null) {
                    b(uuid2, -1);
                }
            }
            if (this.h.size() <= 0) {
                if (com.efs.sdk.base.core.cache.CacheManager.getInstance().getCodeLogList() == null || com.efs.sdk.base.core.cache.CacheManager.getInstance().getCodeLogList().isEmpty()) {
                    com.efs.sdk.base.core.util.Log.i("efs.send_log", "-> deal done and none log. return.");
                    sendEmptyMessageDelayed(10, 300000L);
                } else {
                    if (!this.d.hasTask()) {
                        com.efs.sdk.base.core.util.Log.i("efs.send_log", "-> deal done and none task. return.");
                        return;
                    }
                    com.efs.sdk.base.core.util.Log.i("efs.send_log", "-> deal done and has task. next interval.");
                    this.d.finish();
                    sendEmptyMessageDelayed(10, com.efs.sdk.base.core.controller.ControllerCenter.getGlobalEnvStruct().getLogSendIntervalMills());
                }
            }
        }
    }
}
