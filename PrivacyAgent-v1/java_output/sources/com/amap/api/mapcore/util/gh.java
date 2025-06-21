package com.amap.api.mapcore.util;

/* loaded from: classes12.dex */
public final class gh {
    private static java.util.Map<java.lang.Class<? extends com.amap.api.mapcore.util.gg>, com.amap.api.mapcore.util.gg> d = new java.util.HashMap();
    private com.amap.api.mapcore.util.gk a;
    private android.database.sqlite.SQLiteDatabase b;
    private com.amap.api.mapcore.util.gg c;

    public gh(android.content.Context context, com.amap.api.mapcore.util.gg ggVar) {
        try {
            this.a = new com.amap.api.mapcore.util.gk(context.getApplicationContext(), ggVar.b(), ggVar);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
        this.c = ggVar;
    }

    private static android.content.ContentValues a(java.lang.Object obj, com.amap.api.mapcore.util.gi giVar) {
        android.content.ContentValues contentValues = new android.content.ContentValues();
        for (java.lang.reflect.Field field : a(obj.getClass(), giVar.b())) {
            field.setAccessible(true);
            a(obj, field, contentValues);
        }
        return contentValues;
    }

    private android.database.sqlite.SQLiteDatabase a() {
        try {
            if (this.b == null) {
                this.b = this.a.getReadableDatabase();
            }
        } catch (java.lang.Throwable th) {
            com.amap.api.mapcore.util.ga.a(th, "dbs", "grd");
        }
        return this.b;
    }

    private static <T> com.amap.api.mapcore.util.gi a(java.lang.Class<T> cls) {
        java.lang.annotation.Annotation annotation = cls.getAnnotation(com.amap.api.mapcore.util.gi.class);
        if (annotation != null) {
            return (com.amap.api.mapcore.util.gi) annotation;
        }
        return null;
    }

    private static <T> T a(android.database.Cursor cursor, java.lang.Class<T> cls, com.amap.api.mapcore.util.gi giVar) throws java.lang.IllegalAccessException, java.lang.InstantiationException, java.lang.NoSuchMethodException, java.lang.reflect.InvocationTargetException {
        java.lang.reflect.Field[] a = a((java.lang.Class<?>) cls, giVar.b());
        java.lang.reflect.Constructor<T> declaredConstructor = cls.getDeclaredConstructor(new java.lang.Class[0]);
        declaredConstructor.setAccessible(true);
        T newInstance = declaredConstructor.newInstance(new java.lang.Object[0]);
        for (java.lang.reflect.Field field : a) {
            field.setAccessible(true);
            java.lang.annotation.Annotation annotation = field.getAnnotation(com.amap.api.mapcore.util.gj.class);
            if (annotation != null) {
                com.amap.api.mapcore.util.gj gjVar = (com.amap.api.mapcore.util.gj) annotation;
                int b = gjVar.b();
                int columnIndex = cursor.getColumnIndex(gjVar.a());
                switch (b) {
                    case 1:
                        field.set(newInstance, java.lang.Short.valueOf(cursor.getShort(columnIndex)));
                        break;
                    case 2:
                        field.set(newInstance, java.lang.Integer.valueOf(cursor.getInt(columnIndex)));
                        break;
                    case 3:
                        field.set(newInstance, java.lang.Float.valueOf(cursor.getFloat(columnIndex)));
                        break;
                    case 4:
                        field.set(newInstance, java.lang.Double.valueOf(cursor.getDouble(columnIndex)));
                        break;
                    case 5:
                        field.set(newInstance, java.lang.Long.valueOf(cursor.getLong(columnIndex)));
                        break;
                    case 6:
                        field.set(newInstance, cursor.getString(columnIndex));
                        break;
                    case 7:
                        field.set(newInstance, cursor.getBlob(columnIndex));
                        break;
                }
            }
        }
        return newInstance;
    }

    private static <T> java.lang.String a(com.amap.api.mapcore.util.gi giVar) {
        if (giVar == null) {
            return null;
        }
        return giVar.a();
    }

    private static <T> void a(android.database.sqlite.SQLiteDatabase sQLiteDatabase, T t) {
        com.amap.api.mapcore.util.gi a = a((java.lang.Class) t.getClass());
        java.lang.String a2 = a(a);
        if (android.text.TextUtils.isEmpty(a2) || sQLiteDatabase == null) {
            return;
        }
        sQLiteDatabase.insert(a2, null, a(t, a));
    }

    private <T> void a(T t) {
        b(t);
    }

    private static void a(java.lang.Object obj, java.lang.reflect.Field field, android.content.ContentValues contentValues) {
        java.lang.annotation.Annotation annotation = field.getAnnotation(com.amap.api.mapcore.util.gj.class);
        if (annotation == null) {
        }
        com.amap.api.mapcore.util.gj gjVar = (com.amap.api.mapcore.util.gj) annotation;
        try {
            switch (gjVar.b()) {
                case 1:
                    contentValues.put(gjVar.a(), java.lang.Short.valueOf(field.getShort(obj)));
                    break;
                case 2:
                    contentValues.put(gjVar.a(), java.lang.Integer.valueOf(field.getInt(obj)));
                    break;
                case 3:
                    contentValues.put(gjVar.a(), java.lang.Float.valueOf(field.getFloat(obj)));
                    break;
                case 4:
                    contentValues.put(gjVar.a(), java.lang.Double.valueOf(field.getDouble(obj)));
                    break;
                case 5:
                    contentValues.put(gjVar.a(), java.lang.Long.valueOf(field.getLong(obj)));
                    break;
                case 6:
                    contentValues.put(gjVar.a(), (java.lang.String) field.get(obj));
                    break;
                case 7:
                    contentValues.put(gjVar.a(), (byte[]) field.get(obj));
                    break;
            }
        } catch (java.lang.IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    private <T> void a(java.lang.String str, java.lang.Object obj) {
        android.database.sqlite.SQLiteDatabase sQLiteDatabase;
        synchronized (this.c) {
            if (obj == null) {
                return;
            }
            com.amap.api.mapcore.util.gi a = a((java.lang.Class) obj.getClass());
            java.lang.String a2 = a(a);
            if (android.text.TextUtils.isEmpty(a2)) {
                return;
            }
            android.content.ContentValues a3 = a(obj, a);
            android.database.sqlite.SQLiteDatabase b = b();
            this.b = b;
            if (b == null) {
                return;
            }
            try {
                b.update(a2, a3, str, null);
                sQLiteDatabase = this.b;
            } catch (java.lang.Throwable th) {
                try {
                    com.amap.api.mapcore.util.ga.a(th, "dbs", "udd");
                    android.database.sqlite.SQLiteDatabase sQLiteDatabase2 = this.b;
                    if (sQLiteDatabase2 != null) {
                        sQLiteDatabase2.close();
                    }
                } catch (java.lang.Throwable th2) {
                    android.database.sqlite.SQLiteDatabase sQLiteDatabase3 = this.b;
                    if (sQLiteDatabase3 != null) {
                        sQLiteDatabase3.close();
                        this.b = null;
                    }
                    throw th2;
                }
            }
            if (sQLiteDatabase != null) {
                sQLiteDatabase.close();
                this.b = null;
            }
        }
    }

    private static java.lang.reflect.Field[] a(java.lang.Class<?> cls, boolean z) {
        if (cls == null) {
            return null;
        }
        return z ? cls.getSuperclass().getDeclaredFields() : cls.getDeclaredFields();
    }

    private android.database.sqlite.SQLiteDatabase b() {
        try {
            android.database.sqlite.SQLiteDatabase sQLiteDatabase = this.b;
            if (sQLiteDatabase == null || sQLiteDatabase.isReadOnly()) {
                android.database.sqlite.SQLiteDatabase sQLiteDatabase2 = this.b;
                if (sQLiteDatabase2 != null) {
                    sQLiteDatabase2.close();
                }
                this.b = this.a.getWritableDatabase();
            }
        } catch (java.lang.Throwable th) {
            com.amap.api.mapcore.util.ga.a(th, "dbs", "gwd");
        }
        return this.b;
    }

    private <T> void b(T t) {
        android.database.sqlite.SQLiteDatabase sQLiteDatabase;
        synchronized (this.c) {
            android.database.sqlite.SQLiteDatabase b = b();
            this.b = b;
            if (b == null) {
                return;
            }
            try {
                a(b, t);
                sQLiteDatabase = this.b;
            } catch (java.lang.Throwable th) {
                try {
                    com.amap.api.mapcore.util.ga.a(th, "dbs", "itd");
                    android.database.sqlite.SQLiteDatabase sQLiteDatabase2 = this.b;
                    if (sQLiteDatabase2 != null) {
                        sQLiteDatabase2.close();
                    }
                } catch (java.lang.Throwable th2) {
                    android.database.sqlite.SQLiteDatabase sQLiteDatabase3 = this.b;
                    if (sQLiteDatabase3 != null) {
                        sQLiteDatabase3.close();
                        this.b = null;
                    }
                    throw th2;
                }
            }
            if (sQLiteDatabase != null) {
                sQLiteDatabase.close();
                this.b = null;
            }
        }
    }

    private <T> void b(java.lang.String str, java.lang.Object obj) {
        a(str, obj);
    }

    private <T> java.util.List<T> c(java.lang.String str, java.lang.Class<T> cls) {
        android.database.Cursor cursor;
        java.lang.String str2;
        java.lang.String str3;
        synchronized (this.c) {
            java.util.ArrayList arrayList = new java.util.ArrayList();
            com.amap.api.mapcore.util.gi a = a((java.lang.Class) cls);
            java.lang.String a2 = a(a);
            if (this.b == null) {
                this.b = a();
            }
            if (this.b == null || android.text.TextUtils.isEmpty(a2) || str == null) {
                return arrayList;
            }
            try {
                cursor = this.b.query(a2, null, str, null, null, null, null);
                try {
                } catch (java.lang.Throwable th) {
                    th = th;
                    try {
                        com.amap.api.mapcore.util.ga.a(th, "dbs", "sld");
                        try {
                            android.database.sqlite.SQLiteDatabase sQLiteDatabase = this.b;
                            if (sQLiteDatabase != null) {
                                sQLiteDatabase.close();
                                this.b = null;
                            }
                        } catch (java.lang.Throwable th2) {
                            th = th2;
                            str2 = "dbs";
                            str3 = "sld";
                            com.amap.api.mapcore.util.ga.a(th, str2, str3);
                            return arrayList;
                        }
                        return arrayList;
                    } finally {
                        if (cursor != null) {
                            try {
                                cursor.close();
                            } catch (java.lang.Throwable th3) {
                                com.amap.api.mapcore.util.ga.a(th3, "dbs", "sld");
                            }
                        }
                        try {
                            android.database.sqlite.SQLiteDatabase sQLiteDatabase2 = this.b;
                            if (sQLiteDatabase2 == null) {
                                throw th;
                            }
                            sQLiteDatabase2.close();
                            this.b = null;
                            throw th;
                        } catch (java.lang.Throwable th4) {
                            com.amap.api.mapcore.util.ga.a(th4, "dbs", "sld");
                        }
                    }
                }
            } catch (java.lang.Throwable th5) {
                th = th5;
                cursor = null;
            }
            if (cursor == null) {
                this.b.close();
                this.b = null;
                if (cursor != null) {
                    try {
                        cursor.close();
                    } catch (java.lang.Throwable th6) {
                        com.amap.api.mapcore.util.ga.a(th6, "dbs", "sld");
                    }
                }
                try {
                    android.database.sqlite.SQLiteDatabase sQLiteDatabase3 = this.b;
                    if (sQLiteDatabase3 != null) {
                        sQLiteDatabase3.close();
                        this.b = null;
                    }
                } catch (java.lang.Throwable th7) {
                    com.amap.api.mapcore.util.ga.a(th7, "dbs", "sld");
                }
                return arrayList;
            }
            while (cursor.moveToNext()) {
                arrayList.add(a(cursor, cls, a));
            }
            try {
                cursor.close();
            } catch (java.lang.Throwable th8) {
                com.amap.api.mapcore.util.ga.a(th8, "dbs", "sld");
            }
            try {
                android.database.sqlite.SQLiteDatabase sQLiteDatabase4 = this.b;
                if (sQLiteDatabase4 != null) {
                    sQLiteDatabase4.close();
                    this.b = null;
                }
            } catch (java.lang.Throwable th9) {
                th = th9;
                str2 = "dbs";
                str3 = "sld";
                com.amap.api.mapcore.util.ga.a(th, str2, str3);
                return arrayList;
            }
            return arrayList;
        }
    }

    public final void a(java.lang.Object obj, java.lang.String str) {
        synchronized (this.c) {
            java.util.List b = b(str, (java.lang.Class) obj.getClass());
            if (b != null && b.size() != 0) {
                b(str, obj);
            }
            a((com.amap.api.mapcore.util.gh) obj);
        }
    }

    public final <T> void a(java.lang.String str, java.lang.Class<T> cls) {
        android.database.sqlite.SQLiteDatabase sQLiteDatabase;
        synchronized (this.c) {
            java.lang.String a = a(a((java.lang.Class) cls));
            if (android.text.TextUtils.isEmpty(a)) {
                return;
            }
            android.database.sqlite.SQLiteDatabase b = b();
            this.b = b;
            if (b == null) {
                return;
            }
            try {
                b.delete(a, str, null);
                sQLiteDatabase = this.b;
            } catch (java.lang.Throwable th) {
                try {
                    com.amap.api.mapcore.util.ga.a(th, "dbs", "dld");
                    android.database.sqlite.SQLiteDatabase sQLiteDatabase2 = this.b;
                    if (sQLiteDatabase2 != null) {
                        sQLiteDatabase2.close();
                    }
                } catch (java.lang.Throwable th2) {
                    android.database.sqlite.SQLiteDatabase sQLiteDatabase3 = this.b;
                    if (sQLiteDatabase3 != null) {
                        sQLiteDatabase3.close();
                        this.b = null;
                    }
                    throw th2;
                }
            }
            if (sQLiteDatabase != null) {
                sQLiteDatabase.close();
                this.b = null;
            }
        }
    }

    public final <T> void a(java.util.List<T> list) {
        java.lang.String str;
        java.lang.String str2;
        synchronized (this.c) {
            if (list.size() == 0) {
                return;
            }
            android.database.sqlite.SQLiteDatabase b = b();
            this.b = b;
            if (b == null) {
                return;
            }
            try {
                b.beginTransaction();
                java.util.Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    a(this.b, it.next());
                }
                this.b.setTransactionSuccessful();
                try {
                    this.b.close();
                    this.b = null;
                } catch (java.lang.Throwable th) {
                    th = th;
                    str = "dbs";
                    str2 = "ild";
                    com.amap.api.mapcore.util.ga.a(th, str, str2);
                }
            } catch (java.lang.Throwable th2) {
                try {
                    com.amap.api.mapcore.util.ga.a(th2, "dbs", "ild");
                    try {
                        if (this.b.inTransaction()) {
                            this.b.endTransaction();
                        }
                    } catch (java.lang.Throwable th3) {
                        com.amap.api.mapcore.util.ga.a(th3, "dbs", "ild");
                    }
                    try {
                        this.b.close();
                        this.b = null;
                    } catch (java.lang.Throwable th4) {
                        th = th4;
                        str = "dbs";
                        str2 = "ild";
                        com.amap.api.mapcore.util.ga.a(th, str, str2);
                    }
                } finally {
                    try {
                        if (this.b.inTransaction()) {
                            this.b.endTransaction();
                        }
                    } catch (java.lang.Throwable th5) {
                        com.amap.api.mapcore.util.ga.a(th5, "dbs", "ild");
                    }
                    try {
                        this.b.close();
                        this.b = null;
                        throw th;
                    } catch (java.lang.Throwable th6) {
                        com.amap.api.mapcore.util.ga.a(th6, "dbs", "ild");
                    }
                }
            }
        }
    }

    public final <T> java.util.List<T> b(java.lang.String str, java.lang.Class<T> cls) {
        return c(str, cls);
    }
}
