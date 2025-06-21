package com.bytedance.pangle.e;

/* loaded from: classes12.dex */
public final class f {

    /* renamed from: com.bytedance.pangle.e.f$1, reason: invalid class name */
    public static class AnonymousClass1 implements java.lang.Runnable {
        @Override // java.lang.Runnable
        public final void run() {
            com.bytedance.pangle.GlobalParam.getInstance().getReporter().saveRecord(com.bytedance.pangle.log.IZeusReporter.ZEUS_STAGE_DEX_OPT, "exec");
            android.os.SystemClock.sleep(com.bytedance.pangle.GlobalParam.getInstance().getDexOptDelayTime());
            com.bytedance.pangle.e.f.b();
        }
    }

    /* renamed from: com.bytedance.pangle.e.f$2, reason: invalid class name */
    public static class AnonymousClass2 implements com.bytedance.pangle.e.f.a {
        @Override // com.bytedance.pangle.e.f.a
        public final boolean a(java.lang.String str, int i) {
            return true;
        }
    }

    public interface a {
        boolean a(java.lang.String str, int i);
    }

    public static void a() {
        com.bytedance.pangle.GlobalParam.getInstance().getReporter().saveRecord(com.bytedance.pangle.log.IZeusReporter.ZEUS_STAGE_DEX_OPT, com.anythink.expressad.foundation.d.c.bT);
        if (com.bytedance.pangle.GlobalParam.getInstance().isCloseBgDex2oat()) {
            return;
        }
        if ((com.bytedance.pangle.util.i.e() || com.bytedance.pangle.util.i.g() || com.bytedance.pangle.util.i.b()) && com.bytedance.pangle.d.d.a(com.bytedance.pangle.Zeus.getAppApplication())) {
            com.bytedance.pangle.GlobalParam.getInstance().getReporter().saveRecord(com.bytedance.pangle.log.IZeusReporter.ZEUS_STAGE_DEX_OPT, "post");
            com.bytedance.pangle.d.e.a(new com.bytedance.pangle.e.f.AnonymousClass1());
        }
    }

    public static synchronized void b() {
        synchronized (com.bytedance.pangle.e.f.class) {
            java.util.Map<java.lang.String, ?> all = com.bytedance.pangle.e.b.a(com.bytedance.pangle.Zeus.getAppApplication()).getAll();
            if (all.size() > 0) {
                for (java.util.Map.Entry<java.lang.String, ?> entry : all.entrySet()) {
                    com.bytedance.pangle.log.ZeusLogger.i(com.bytedance.pangle.log.ZeusLogger.TAG_LOAD, "fullDex2oat start:" + entry.getKey());
                    if ((com.bytedance.pangle.util.i.g() ? new com.bytedance.pangle.e.e() : com.bytedance.pangle.util.i.e() ? new com.bytedance.pangle.e.d() : com.bytedance.pangle.util.i.b() ? new com.bytedance.pangle.e.c() : new com.bytedance.pangle.e.f.AnonymousClass2()).a(entry.getKey(), ((java.lang.Integer) entry.getValue()).intValue())) {
                        com.bytedance.pangle.e.b.a(com.bytedance.pangle.Zeus.getAppApplication()).edit().remove(entry.getKey()).apply();
                        com.bytedance.pangle.log.ZeusLogger.i(com.bytedance.pangle.log.ZeusLogger.TAG_LOAD, "fullDex2oat success:" + entry.getKey());
                        com.bytedance.pangle.util.l.a().b(entry.getKey(), ((java.lang.Integer) entry.getValue()).intValue(), true);
                        com.bytedance.pangle.log.ZeusLogger.i(com.bytedance.pangle.log.ZeusLogger.TAG_LOAD, "fullDex2oat markDexOptState:" + entry.getKey());
                    } else {
                        com.bytedance.pangle.log.ZeusLogger.i(com.bytedance.pangle.log.ZeusLogger.TAG_LOAD, "fullDex2oat failed:" + entry.getKey());
                    }
                }
            }
        }
    }
}
