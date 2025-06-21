package com.getui.gtc.dyc;

/* loaded from: classes22.dex */
class c {

    public static class a extends com.getui.gtc.base.db.AbstractDb {
        @Override // com.getui.gtc.base.db.AbstractDb
        public java.lang.String getDbName() {
            return "cg.db";
        }

        @Override // com.getui.gtc.base.db.AbstractDb
        public int getVersion() {
            return 1;
        }
    }

    /* renamed from: com.getui.gtc.dyc.c$c, reason: collision with other inner class name */
    public static class C0305c {
        private static com.getui.gtc.dyc.c a = new com.getui.gtc.dyc.c(null);
    }

    public static class d extends com.getui.gtc.base.db.AbstractTable {
        @Override // com.getui.gtc.base.db.AbstractTable
        public java.lang.String createSql() {
            return "CREATE TABLE IF NOT EXISTS sct (v TEXT PRIMARY KEY, c TEXT)";
        }

        @Override // com.getui.gtc.base.db.AbstractTable
        public java.lang.String getTableName() {
            return "sct";
        }
    }

    private c() {
        try {
            com.getui.gtc.base.db.DbManager.init(com.getui.gtc.base.GtcProvider.context(), com.getui.gtc.dyc.c.a.class, com.getui.gtc.dyc.c.d.class);
        } catch (java.lang.Throwable th) {
            com.getui.gtc.dyc.a.a.a.c(th);
        }
    }

    public /* synthetic */ c(com.getui.gtc.dyc.c.AnonymousClass1 anonymousClass1) {
        this();
    }

    public static com.getui.gtc.dyc.c a() {
        return com.getui.gtc.dyc.c.C0305c.a;
    }

    public com.getui.gtc.dyc.h a(java.lang.String str) {
        android.database.Cursor query = ((com.getui.gtc.dyc.c.d) com.getui.gtc.base.db.DbManager.getTable(com.getui.gtc.dyc.c.a.class, com.getui.gtc.dyc.c.d.class)).query(new java.lang.String[]{"c"}, "v=?", new java.lang.String[]{str});
        com.getui.gtc.dyc.h hVar = null;
        if (query == null) {
            return null;
        }
        if (query.moveToNext()) {
            try {
                hVar = com.getui.gtc.dyc.h.e(query.getString(query.getColumnIndex("c")));
            } catch (java.lang.Throwable th) {
                com.getui.gtc.dyc.a.a.a.c(th);
            }
        }
        query.close();
        return hVar;
    }

    public boolean a(java.lang.String str, com.getui.gtc.dyc.h hVar) {
        try {
            java.lang.String g = hVar.g();
            android.content.ContentValues contentValues = new android.content.ContentValues();
            contentValues.put("v", str);
            contentValues.put("c", g);
            return ((com.getui.gtc.dyc.c.d) com.getui.gtc.base.db.DbManager.getTable(com.getui.gtc.dyc.c.a.class, com.getui.gtc.dyc.c.d.class)).replace(null, contentValues) != -1;
        } catch (java.lang.Throwable th) {
            com.getui.gtc.dyc.a.a.a.c(th);
            return false;
        }
    }

    public java.util.HashMap<java.lang.String, com.getui.gtc.dyc.h> c() {
        android.database.Cursor query = ((com.getui.gtc.dyc.c.d) com.getui.gtc.base.db.DbManager.getTable(com.getui.gtc.dyc.c.a.class, com.getui.gtc.dyc.c.d.class)).query(new java.lang.String[]{"v", "c"}, null, null);
        if (query == null) {
            return null;
        }
        java.util.HashMap<java.lang.String, com.getui.gtc.dyc.h> hashMap = new java.util.HashMap<>();
        while (query.moveToNext()) {
            try {
                hashMap.put(query.getString(query.getColumnIndex("v")), com.getui.gtc.dyc.h.e(query.getString(query.getColumnIndex("c"))));
            } catch (java.lang.Throwable th) {
                com.getui.gtc.dyc.a.a.a.c(th);
            }
        }
        query.close();
        return hashMap;
    }
}
