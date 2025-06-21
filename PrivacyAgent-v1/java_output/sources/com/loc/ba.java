package com.loc;

/* loaded from: classes23.dex */
public final class ba {
    private static java.util.Map<java.lang.Class<? extends com.loc.az>, com.loc.az> d = new java.util.HashMap();
    private com.loc.bd a;
    private android.database.sqlite.SQLiteDatabase b;
    private com.loc.az c;

    public ba(android.content.Context context, com.loc.az azVar) {
        try {
            this.a = new com.loc.bd(context.getApplicationContext(), azVar.a(), azVar);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
        this.c = azVar;
    }

    private static android.content.ContentValues a(java.lang.Object obj, com.loc.bb bbVar) {
        android.content.ContentValues contentValues = new android.content.ContentValues();
        for (java.lang.reflect.Field field : a(obj.getClass(), bbVar.b())) {
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
            com.loc.at.a(th, "dbs", "grd");
        }
        return this.b;
    }

    public static synchronized com.loc.az a(java.lang.Class<? extends com.loc.az> cls) throws java.lang.IllegalAccessException, java.lang.InstantiationException {
        com.loc.az azVar;
        synchronized (com.loc.ba.class) {
            if (d.get(cls) == null) {
                d.put(cls, cls.newInstance());
            }
            azVar = d.get(cls);
        }
        return azVar;
    }

    private static <T> T a(android.database.Cursor cursor, java.lang.Class<T> cls, com.loc.bb bbVar) throws java.lang.IllegalAccessException, java.lang.InstantiationException, java.lang.NoSuchMethodException, java.lang.reflect.InvocationTargetException {
        java.lang.Object valueOf;
        java.lang.reflect.Field[] a = a((java.lang.Class<?>) cls, bbVar.b());
        java.lang.reflect.Constructor<T> declaredConstructor = cls.getDeclaredConstructor(new java.lang.Class[0]);
        declaredConstructor.setAccessible(true);
        T newInstance = declaredConstructor.newInstance(new java.lang.Object[0]);
        for (java.lang.reflect.Field field : a) {
            field.setAccessible(true);
            java.lang.annotation.Annotation annotation = field.getAnnotation(com.loc.bc.class);
            if (annotation != null) {
                com.loc.bc bcVar = (com.loc.bc) annotation;
                int b = bcVar.b();
                int columnIndex = cursor.getColumnIndex(bcVar.a());
                switch (b) {
                    case 1:
                        valueOf = java.lang.Short.valueOf(cursor.getShort(columnIndex));
                        break;
                    case 2:
                        valueOf = java.lang.Integer.valueOf(cursor.getInt(columnIndex));
                        break;
                    case 3:
                        valueOf = java.lang.Float.valueOf(cursor.getFloat(columnIndex));
                        break;
                    case 4:
                        valueOf = java.lang.Double.valueOf(cursor.getDouble(columnIndex));
                        break;
                    case 5:
                        valueOf = java.lang.Long.valueOf(cursor.getLong(columnIndex));
                        break;
                    case 6:
                        valueOf = cursor.getString(columnIndex);
                        break;
                    case 7:
                        field.set(newInstance, cursor.getBlob(columnIndex));
                        continue;
                }
                field.set(newInstance, valueOf);
            }
        }
        return newInstance;
    }

    private static <T> java.lang.String a(com.loc.bb bbVar) {
        if (bbVar == null) {
            return null;
        }
        return bbVar.a();
    }

    private static <T> void a(android.database.sqlite.SQLiteDatabase sQLiteDatabase, T t) {
        com.loc.bb b = b((java.lang.Class) t.getClass());
        java.lang.String a = a(b);
        if (android.text.TextUtils.isEmpty(a) || sQLiteDatabase == null) {
            return;
        }
        sQLiteDatabase.insert(a, null, a(t, b));
    }

    private <T> void a(T t) {
        b((com.loc.ba) t);
    }

    private static void a(java.lang.Object obj, java.lang.reflect.Field field, android.content.ContentValues contentValues) {
        java.lang.annotation.Annotation annotation = field.getAnnotation(com.loc.bc.class);
        if (annotation == null) {
        }
        com.loc.bc bcVar = (com.loc.bc) annotation;
        try {
            switch (bcVar.b()) {
                case 1:
                    contentValues.put(bcVar.a(), java.lang.Short.valueOf(field.getShort(obj)));
                    break;
                case 2:
                    contentValues.put(bcVar.a(), java.lang.Integer.valueOf(field.getInt(obj)));
                    break;
                case 3:
                    contentValues.put(bcVar.a(), java.lang.Float.valueOf(field.getFloat(obj)));
                    break;
                case 4:
                    contentValues.put(bcVar.a(), java.lang.Double.valueOf(field.getDouble(obj)));
                    break;
                case 5:
                    contentValues.put(bcVar.a(), java.lang.Long.valueOf(field.getLong(obj)));
                    break;
                case 6:
                    contentValues.put(bcVar.a(), (java.lang.String) field.get(obj));
                    break;
                case 7:
                    contentValues.put(bcVar.a(), (byte[]) field.get(obj));
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
            com.loc.bb b = b((java.lang.Class) obj.getClass());
            java.lang.String a = a(b);
            if (android.text.TextUtils.isEmpty(a)) {
                return;
            }
            android.content.ContentValues a2 = a(obj, b);
            android.database.sqlite.SQLiteDatabase b2 = b();
            this.b = b2;
            if (b2 == null) {
                return;
            }
            try {
                b2.update(a, a2, str, null);
                sQLiteDatabase = this.b;
            } catch (java.lang.Throwable th) {
                try {
                    com.loc.at.a(th, "dbs", "udd");
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
            com.loc.at.a(th, "dbs", "gwd");
        }
        return this.b;
    }

    private static <T> com.loc.bb b(java.lang.Class<T> cls) {
        java.lang.annotation.Annotation annotation = cls.getAnnotation(com.loc.bb.class);
        if (annotation != null) {
            return (com.loc.bb) annotation;
        }
        return null;
    }

    private <T> java.util.List<T> b(java.lang.String str, java.lang.Class<T> cls) {
        android.database.Cursor cursor;
        java.lang.String str2;
        java.lang.String str3;
        synchronized (this.c) {
            java.util.ArrayList arrayList = new java.util.ArrayList();
            com.loc.bb b = b((java.lang.Class) cls);
            java.lang.String a = a(b);
            if (this.b == null) {
                this.b = a();
            }
            if (this.b == null || android.text.TextUtils.isEmpty(a) || str == null) {
                return arrayList;
            }
            try {
                cursor = this.b.query(a, null, str, null, null, null, null);
                try {
                } catch (java.lang.Throwable th) {
                    th = th;
                    try {
                        com.loc.at.a(th, "dbs", "sld");
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
                            com.loc.at.a(th, str2, str3);
                            return arrayList;
                        }
                        return arrayList;
                    } finally {
                        if (cursor != null) {
                            try {
                                cursor.close();
                            } catch (java.lang.Throwable th3) {
                                com.loc.at.a(th3, "dbs", "sld");
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
                            com.loc.at.a(th4, "dbs", "sld");
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
                        com.loc.at.a(th6, "dbs", "sld");
                    }
                }
                try {
                    android.database.sqlite.SQLiteDatabase sQLiteDatabase3 = this.b;
                    if (sQLiteDatabase3 != null) {
                        sQLiteDatabase3.close();
                        this.b = null;
                    }
                } catch (java.lang.Throwable th7) {
                    com.loc.at.a(th7, "dbs", "sld");
                }
                return arrayList;
            }
            while (cursor.moveToNext()) {
                arrayList.add(a(cursor, cls, b));
            }
            try {
                cursor.close();
            } catch (java.lang.Throwable th8) {
                com.loc.at.a(th8, "dbs", "sld");
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
                com.loc.at.a(th, str2, str3);
                return arrayList;
            }
            return arrayList;
        }
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
                    com.loc.at.a(th, "dbs", "itd");
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

    public final <T> java.util.List<T> a(java.lang.String str, java.lang.Class<T> cls) {
        return b(str, (java.lang.Class) cls);
    }

    public final void a(java.lang.Object obj, java.lang.String str) {
        synchronized (this.c) {
            java.util.List a = a(str, (java.lang.Class) obj.getClass());
            if (a != null && a.size() != 0) {
                b(str, obj);
            }
            a((com.loc.ba) obj);
        }
    }
}
