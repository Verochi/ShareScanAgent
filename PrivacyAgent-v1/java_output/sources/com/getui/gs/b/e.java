package com.getui.gs.b;

/* loaded from: classes22.dex */
public final class e {
    public com.getui.gs.b.b a;
    public com.getui.gs.b.c b;
    public com.getui.gs.b.f c;
    public com.getui.gs.b.a d;

    public static class a {
        private static final com.getui.gs.b.e a = new com.getui.gs.b.e((byte) 0);
    }

    private e() {
        try {
            com.getui.gtc.base.db.DbManager.init(com.getui.gs.a.d.a(), com.getui.gs.b.d.class, com.getui.gs.b.b.class, com.getui.gs.b.c.class, com.getui.gs.b.f.class, com.getui.gs.b.a.class);
            this.a = (com.getui.gs.b.b) com.getui.gtc.base.db.DbManager.getTable(com.getui.gs.b.d.class, com.getui.gs.b.b.class);
            this.b = (com.getui.gs.b.c) com.getui.gtc.base.db.DbManager.getTable(com.getui.gs.b.d.class, com.getui.gs.b.c.class);
            this.c = (com.getui.gs.b.f) com.getui.gtc.base.db.DbManager.getTable(com.getui.gs.b.d.class, com.getui.gs.b.f.class);
            this.d = (com.getui.gs.b.a) com.getui.gtc.base.db.DbManager.getTable(com.getui.gs.b.d.class, com.getui.gs.b.a.class);
        } catch (java.lang.Throwable th) {
            com.getui.gs.h.b.a.a.a.e(th);
        }
    }

    public /* synthetic */ e(byte b) {
        this();
    }
}
