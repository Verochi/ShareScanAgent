package com.getui.gtc.base.db;

/* loaded from: classes22.dex */
public abstract class AbstractDb {
    private android.database.sqlite.SQLiteOpenHelper helper;
    private final java.util.Map<java.lang.Class<? extends com.getui.gtc.base.db.AbstractTable>, com.getui.gtc.base.db.AbstractTable> tables = new java.util.HashMap();
    private final java.util.concurrent.atomic.AtomicBoolean inited = new java.util.concurrent.atomic.AtomicBoolean(false);

    /* renamed from: com.getui.gtc.base.db.AbstractDb$1, reason: invalid class name */
    public class AnonymousClass1 extends android.database.sqlite.SQLiteOpenHelper {
        public AnonymousClass1(android.content.Context context, java.lang.String str, android.database.sqlite.SQLiteDatabase.CursorFactory cursorFactory, int i) {
            super(context, str, cursorFactory, i);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(android.database.sqlite.SQLiteDatabase sQLiteDatabase) {
            try {
                sQLiteDatabase.beginTransaction();
                try {
                    java.util.Iterator it = com.getui.gtc.base.db.AbstractDb.this.tables.keySet().iterator();
                    while (it.hasNext()) {
                        sQLiteDatabase.execSQL(((com.getui.gtc.base.db.AbstractTable) com.getui.gtc.base.db.AbstractDb.this.tables.get((java.lang.Class) it.next())).createSql());
                    }
                    sQLiteDatabase.setTransactionSuccessful();
                } finally {
                    sQLiteDatabase.endTransaction();
                }
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onDowngrade(android.database.sqlite.SQLiteDatabase sQLiteDatabase, int i, int i2) {
            try {
                sQLiteDatabase.beginTransaction();
                try {
                    java.util.Iterator it = com.getui.gtc.base.db.AbstractDb.this.tables.keySet().iterator();
                    while (it.hasNext()) {
                        ((com.getui.gtc.base.db.AbstractTable) com.getui.gtc.base.db.AbstractDb.this.tables.get((java.lang.Class) it.next())).onDowngradle(sQLiteDatabase, i, i2);
                    }
                    sQLiteDatabase.setTransactionSuccessful();
                } finally {
                    sQLiteDatabase.endTransaction();
                }
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(android.database.sqlite.SQLiteDatabase sQLiteDatabase, int i, int i2) {
            try {
                sQLiteDatabase.beginTransaction();
                try {
                    java.util.Iterator it = com.getui.gtc.base.db.AbstractDb.this.tables.keySet().iterator();
                    while (it.hasNext()) {
                        ((com.getui.gtc.base.db.AbstractTable) com.getui.gtc.base.db.AbstractDb.this.tables.get((java.lang.Class) it.next())).onUpgrade(sQLiteDatabase, i, i2);
                    }
                    sQLiteDatabase.setTransactionSuccessful();
                } finally {
                    sQLiteDatabase.endTransaction();
                }
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public interface TableConsumer {
        void accept(com.getui.gtc.base.db.AbstractTable abstractTable);
    }

    private void initCache() {
        java.util.Iterator<java.lang.Class<? extends com.getui.gtc.base.db.AbstractTable>> it = this.tables.keySet().iterator();
        while (it.hasNext()) {
            try {
                this.tables.get(it.next()).initCache();
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public final void addTable(java.lang.Class<? extends com.getui.gtc.base.db.AbstractTable> cls) throws java.lang.IllegalAccessException, java.lang.InstantiationException {
        com.getui.gtc.base.db.AbstractTable abstractTable = this.tables.get(cls);
        if (abstractTable == null) {
            abstractTable = cls.newInstance();
            this.tables.put(cls, abstractTable);
        }
        abstractTable.setDb(this);
    }

    public final void addTables(java.util.List<java.lang.Class<? extends com.getui.gtc.base.db.AbstractTable>> list) throws java.lang.InstantiationException, java.lang.IllegalAccessException {
        java.util.Iterator<java.lang.Class<? extends com.getui.gtc.base.db.AbstractTable>> it = list.iterator();
        while (it.hasNext()) {
            addTable(it.next());
        }
    }

    public abstract java.lang.String getDbName();

    public final android.database.sqlite.SQLiteOpenHelper getHelper() {
        android.database.sqlite.SQLiteOpenHelper sQLiteOpenHelper = this.helper;
        if (sQLiteOpenHelper != null) {
            return sQLiteOpenHelper;
        }
        throw new java.lang.RuntimeException("db " + getDbName() + " has not been initialized");
    }

    public final <T extends com.getui.gtc.base.db.AbstractTable> T getTable(java.lang.Class<T> cls) {
        T t = (T) this.tables.get(cls);
        if (t != null) {
            return t;
        }
        throw new java.lang.RuntimeException("table " + cls.getSimpleName() + " has not been added to db " + getDbName());
    }

    public final java.util.Collection<com.getui.gtc.base.db.AbstractTable> getTables() {
        java.util.Collection<com.getui.gtc.base.db.AbstractTable> values = this.tables.values();
        if (values.size() > 0) {
            return values;
        }
        throw new java.lang.RuntimeException("no table has been added to db " + getDbName());
    }

    public abstract int getVersion();

    public void init(android.content.Context context) {
        if (this.inited.getAndSet(true)) {
            return;
        }
        this.helper = new com.getui.gtc.base.db.AbstractDb.AnonymousClass1(context, getDbName(), null, getVersion());
        initCache();
    }
}
