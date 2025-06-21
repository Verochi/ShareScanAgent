package com.efs.sdk.base.core.controller;

import com.efs.sdk.base.core.c.d.AnonymousClass1;

/* loaded from: classes22.dex */
public class ControllerCenter implements android.os.Handler.Callback {
    private static com.efs.sdk.base.core.config.GlobalEnvStruct h;
    private int a = 0;
    private final int b = 0;
    private final int c = 1;
    private final int d = 2;
    private final int e = 3;
    private volatile boolean f = false;
    private com.efs.sdk.base.core.controller.a.a g;
    private boolean i;
    private android.os.Handler j;

    /* renamed from: com.efs.sdk.base.core.controller.ControllerCenter$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ com.efs.sdk.base.protocol.ILogProtocol a;

        public AnonymousClass1(com.efs.sdk.base.protocol.ILogProtocol iLogProtocol) {
            this.a = iLogProtocol;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.efs.sdk.base.core.c.d dVar;
            try {
                this.a.insertGlobal(com.efs.sdk.base.core.config.GlobalInfoManager.getInstance().getGlobalInfo());
                if (!"wa".equalsIgnoreCase(this.a.getLogType())) {
                    com.efs.sdk.base.core.controller.ControllerCenter.a(this.a);
                }
                if (com.efs.sdk.base.core.controller.ControllerCenter.getGlobalEnvStruct().isEnableSendLog()) {
                    com.efs.sdk.base.core.model.LogDto buildLogDto = com.efs.sdk.base.core.model.LogDto.buildLogDto(this.a);
                    dVar = com.efs.sdk.base.core.c.d.a.a;
                    com.efs.sdk.base.core.util.concurrent.WorkThreadUtil.submit(dVar.new AnonymousClass1(buildLogDto));
                }
            } catch (java.lang.Throwable th) {
                com.efs.sdk.base.core.util.Log.e("efs.base", "log send error", th);
            }
        }
    }

    public ControllerCenter(com.efs.sdk.base.EfsReporter.Builder builder) {
        this.i = false;
        com.efs.sdk.base.core.config.GlobalEnvStruct globalEnvStruct = builder.getGlobalEnvStruct();
        h = globalEnvStruct;
        this.i = globalEnvStruct.isOpenCodeLog();
        android.os.Handler handler = new android.os.Handler(com.efs.sdk.base.core.util.concurrent.a.a.getLooper(), this);
        this.j = handler;
        handler.sendEmptyMessage(0);
    }

    private void a() {
        if (this.g == null) {
            this.g = new com.efs.sdk.base.core.controller.a.a();
        }
        try {
            android.content.IntentFilter intentFilter = new android.content.IntentFilter();
            intentFilter.addAction(com.igexin.sdk.PushConsts.ACTION_BROADCAST_NETWORK_CHANGE);
            h.mAppContext.registerReceiver(this.g, intentFilter);
        } catch (java.lang.Throwable th) {
            com.efs.sdk.base.core.util.Log.w("efs.base", "register network change receiver error", th);
            int i = this.a + 1;
            this.a = i;
            if (i < 3) {
                this.j.sendEmptyMessageDelayed(3, 6000L);
            }
        }
    }

    public static /* synthetic */ void a(com.efs.sdk.base.protocol.ILogProtocol iLogProtocol) {
        for (android.webkit.ValueCallback<android.util.Pair<android.os.Message, android.os.Message>> valueCallback : getGlobalEnvStruct().getCallback(9)) {
            java.util.HashMap hashMap = new java.util.HashMap(4);
            hashMap.put("log_type", iLogProtocol.getLogType());
            hashMap.put(com.igexin.c.a.c.a.d.d, iLogProtocol.generateString());
            hashMap.put("link_key", iLogProtocol.getLinkKey());
            hashMap.put("link_id", iLogProtocol.getLinkId());
            android.os.Message obtain = android.os.Message.obtain(null, 9, hashMap);
            android.os.Message obtain2 = android.os.Message.obtain();
            valueCallback.onReceiveValue(new android.util.Pair<>(obtain, obtain2));
            obtain.recycle();
            obtain2.recycle();
        }
    }

    private void b(com.efs.sdk.base.protocol.ILogProtocol iLogProtocol) {
        if (iLogProtocol == null) {
            return;
        }
        com.efs.sdk.base.core.util.concurrent.WorkThreadUtil.submit(new com.efs.sdk.base.core.controller.ControllerCenter.AnonymousClass1(iLogProtocol));
    }

    @androidx.annotation.NonNull
    public static com.efs.sdk.base.core.config.GlobalEnvStruct getGlobalEnvStruct() {
        return h;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(@androidx.annotation.NonNull android.os.Message message) {
        com.efs.sdk.base.core.d.f fVar;
        com.efs.sdk.base.core.d.f fVar2;
        com.efs.sdk.base.core.b.h unused;
        int i = message.what;
        if (i == 0) {
            com.efs.sdk.base.core.config.GlobalInfoManager.getInstance().initGlobalInfo();
            unused = com.efs.sdk.base.core.b.h.a.a;
            com.efs.sdk.base.core.config.remote.b.a().b();
            a();
            fVar = com.efs.sdk.base.core.d.f.a.a;
            boolean isIntl = h.isIntl();
            com.efs.sdk.base.core.d.c cVar = fVar.a;
            if (isIntl) {
                cVar.a = "https://errnewlogos.umeng.com/api/crashsdk/logcollect";
                cVar.b = "4ea4e41a3993";
            } else {
                cVar.a = "https://errnewlog.umeng.com/api/crashsdk/logcollect";
                cVar.b = "28ef1713347d";
            }
            fVar.b = this;
            fVar.c.a = this;
            fVar.d.a = this;
            this.f = true;
            com.efs.sdk.base.core.b.e.a().sendEmptyMessageDelayed(0, h.getLogSendDelayMills());
            if (this.i) {
                com.efs.sdk.base.core.b.e.a().sendEmptyMessageDelayed(10, h.getLogSendDelayMills());
            }
            fVar2 = com.efs.sdk.base.core.d.f.a.a;
            if (fVar2.b != null && getGlobalEnvStruct().isEnableWaStat()) {
                fVar2.b.send(new com.efs.sdk.base.core.d.b("efs_core", "pvuv", fVar2.a.c));
            }
        } else if (i == 1) {
            java.lang.Object obj = message.obj;
            if (obj != null && (obj instanceof com.efs.sdk.base.protocol.ILogProtocol)) {
                b((com.efs.sdk.base.protocol.ILogProtocol) obj);
            }
        } else if (i == 3) {
            a();
        }
        return true;
    }

    public void send(com.efs.sdk.base.protocol.ILogProtocol iLogProtocol) {
        if (this.f) {
            b(iLogProtocol);
            return;
        }
        android.os.Message obtain = android.os.Message.obtain();
        obtain.what = 1;
        obtain.obj = iLogProtocol;
        this.j.sendMessage(obtain);
    }

    @androidx.annotation.Nullable
    public com.efs.sdk.base.http.HttpResponse sendSyncImmediately(java.lang.String str, int i, java.lang.String str2, boolean z, java.io.File file) {
        com.efs.sdk.base.core.c.d dVar;
        com.efs.sdk.base.core.model.LogDto logDto = new com.efs.sdk.base.core.model.LogDto(str, (byte) 2);
        logDto.setLogBodyType(1);
        logDto.setFile(file);
        logDto.setCp(str2);
        logDto.setDe(i);
        logDto.setLimitByFlow(z);
        logDto.setSendImediately(true);
        dVar = com.efs.sdk.base.core.c.d.a.a;
        dVar.a.a(logDto);
        return logDto.getResponseDto();
    }
}
