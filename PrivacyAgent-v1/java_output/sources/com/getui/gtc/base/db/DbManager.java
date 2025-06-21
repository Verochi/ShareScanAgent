package com.getui.gtc.base.db;

/* loaded from: classes22.dex */
public class DbManager {
    private static final java.util.Map<java.lang.Class<? extends com.getui.gtc.base.db.AbstractDb>, com.getui.gtc.base.db.AbstractDb> dbMap = new java.util.concurrent.ConcurrentHashMap();

    public static <T extends com.getui.gtc.base.db.AbstractTable> T getTable(java.lang.Class<? extends com.getui.gtc.base.db.AbstractDb> cls, java.lang.Class<T> cls2) {
        com.getui.gtc.base.db.AbstractDb abstractDb = dbMap.get(cls);
        if (abstractDb != null) {
            return (T) abstractDb.getTable(cls2);
        }
        throw new java.lang.RuntimeException("db " + cls.getSimpleName() + " has not been initialized");
    }

    public static java.util.Collection<com.getui.gtc.base.db.AbstractTable> getTables(java.lang.Class<? extends com.getui.gtc.base.db.AbstractDb> cls) {
        com.getui.gtc.base.db.AbstractDb abstractDb = dbMap.get(cls);
        if (abstractDb != null) {
            return abstractDb.getTables();
        }
        throw new java.lang.RuntimeException("db " + cls.getSimpleName() + "has not been initialized");
    }

    public static void init(android.content.Context context, java.lang.Class<? extends com.getui.gtc.base.db.AbstractDb> cls, java.lang.Class<? extends com.getui.gtc.base.db.AbstractTable>... clsArr) throws java.lang.IllegalAccessException, java.lang.InstantiationException {
        android.content.Context applicationContext = context.getApplicationContext();
        java.util.Map<java.lang.Class<? extends com.getui.gtc.base.db.AbstractDb>, com.getui.gtc.base.db.AbstractDb> map = dbMap;
        com.getui.gtc.base.db.AbstractDb abstractDb = map.get(cls);
        if (abstractDb == null) {
            abstractDb = cls.newInstance();
            map.put(cls, abstractDb);
        }
        for (java.lang.Class<? extends com.getui.gtc.base.db.AbstractTable> cls2 : clsArr) {
            abstractDb.addTable(cls2);
        }
        abstractDb.init(applicationContext);
    }
}
