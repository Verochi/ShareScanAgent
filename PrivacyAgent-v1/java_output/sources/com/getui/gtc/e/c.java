package com.getui.gtc.e;

/* loaded from: classes22.dex */
public final class c {
    public com.getui.gtc.e.d a;
    public com.getui.gtc.e.a b;
    private com.getui.gtc.e.e c;

    public static class a {
        private static com.getui.gtc.e.c a = new com.getui.gtc.e.c((byte) 0);
    }

    private c() {
        try {
            com.getui.gtc.base.db.DbManager.init(com.getui.gtc.base.GtcProvider.context(), com.getui.gtc.e.b.class, com.getui.gtc.e.a.class, com.getui.gtc.e.d.class, com.getui.gtc.e.e.class);
            this.a = (com.getui.gtc.e.d) com.getui.gtc.base.db.DbManager.getTable(com.getui.gtc.e.b.class, com.getui.gtc.e.d.class);
            this.c = (com.getui.gtc.e.e) com.getui.gtc.base.db.DbManager.getTable(com.getui.gtc.e.b.class, com.getui.gtc.e.e.class);
            this.b = (com.getui.gtc.e.a) com.getui.gtc.base.db.DbManager.getTable(com.getui.gtc.e.b.class, com.getui.gtc.e.a.class);
        } catch (java.lang.Throwable th) {
            com.getui.gtc.h.c.a.c(th);
        }
    }

    public /* synthetic */ c(byte b) {
        this();
    }
}
