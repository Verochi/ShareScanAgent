package com.xiaomi.push;

/* loaded from: classes19.dex */
final class bl implements java.lang.Runnable {
    final /* synthetic */ android.content.Context a;
    final /* synthetic */ com.xiaomi.push.bj.a b;

    public bl(com.xiaomi.push.bj.a aVar, android.content.Context context) {
        this.b = aVar;
        this.a = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        android.database.sqlite.SQLiteDatabase sQLiteDatabase = null;
        try {
            try {
                sQLiteDatabase = this.b.c();
                if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
                    sQLiteDatabase.beginTransaction();
                    this.b.a(this.a, sQLiteDatabase);
                    sQLiteDatabase.setTransactionSuccessful();
                }
                if (sQLiteDatabase != null) {
                    try {
                        sQLiteDatabase.endTransaction();
                    } catch (java.lang.Exception e) {
                        e = e;
                        com.xiaomi.channel.commonutils.logger.b.a(e);
                        this.b.a(this.a);
                    }
                }
                com.xiaomi.push.bh bhVar = this.b.c;
                if (bhVar != null) {
                    bhVar.close();
                }
            } catch (java.lang.Exception e2) {
                com.xiaomi.channel.commonutils.logger.b.a(e2);
                if (sQLiteDatabase != null) {
                    try {
                        sQLiteDatabase.endTransaction();
                    } catch (java.lang.Exception e3) {
                        e = e3;
                        com.xiaomi.channel.commonutils.logger.b.a(e);
                        this.b.a(this.a);
                    }
                }
                com.xiaomi.push.bh bhVar2 = this.b.c;
                if (bhVar2 != null) {
                    bhVar2.close();
                }
            }
            this.b.a(this.a);
        } catch (java.lang.Throwable th) {
            if (sQLiteDatabase != null) {
                try {
                    sQLiteDatabase.endTransaction();
                } catch (java.lang.Exception e4) {
                    com.xiaomi.channel.commonutils.logger.b.a(e4);
                    this.b.a(this.a);
                    throw th;
                }
            }
            com.xiaomi.push.bh bhVar3 = this.b.c;
            if (bhVar3 != null) {
                bhVar3.close();
            }
            this.b.a(this.a);
            throw th;
        }
    }
}
