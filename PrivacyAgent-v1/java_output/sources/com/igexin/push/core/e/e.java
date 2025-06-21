package com.igexin.push.core.e;

/* loaded from: classes23.dex */
public class e implements com.igexin.push.core.e.a {
    private static final java.lang.String b = "RALDataManager";
    private static final int c = 318;
    private static final int d = 300;
    private static volatile com.igexin.push.core.e.e e;
    public final java.util.List<com.igexin.push.core.b.m> a = new java.util.concurrent.CopyOnWriteArrayList();

    /* renamed from: com.igexin.push.core.e.e$1, reason: invalid class name */
    public class AnonymousClass1 extends com.igexin.push.b.d {
        final /* synthetic */ com.igexin.push.core.b.m a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(android.content.ContentValues contentValues, com.igexin.push.core.b.m mVar) {
            super(contentValues);
            this.a = mVar;
        }

        @Override // com.igexin.push.b.d
        public final void a_() throws java.lang.Exception {
            this.d.replace("ral", null, this.h);
        }
    }

    /* renamed from: com.igexin.push.core.e.e$2, reason: invalid class name */
    public class AnonymousClass2 extends com.igexin.push.b.d {
        final /* synthetic */ long a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(android.content.ContentValues contentValues, long j) {
            super(contentValues);
            this.a = j;
        }

        @Override // com.igexin.push.b.d
        public final void a_() throws java.lang.Exception {
            this.d.delete("ral", "id=?", new java.lang.String[]{java.lang.String.valueOf(this.a)});
        }
    }

    /* renamed from: com.igexin.push.core.e.e$3, reason: invalid class name */
    public class AnonymousClass3 extends com.igexin.push.b.d {
        final /* synthetic */ long a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(android.content.ContentValues contentValues, long j) {
            super(contentValues);
            this.a = j;
        }

        @Override // com.igexin.push.b.d
        public final void a_() throws java.lang.Exception {
            this.d.update("ral", this.h, "id=?", new java.lang.String[]{java.lang.String.valueOf(this.a)});
        }
    }

    private e() {
    }

    private int a(byte b2) {
        java.util.Iterator<com.igexin.push.core.b.m> it = this.a.iterator();
        int i = 0;
        while (it.hasNext()) {
            if (it.next().c == b2) {
                i++;
            }
        }
        return i;
    }

    public static android.content.ContentValues a(com.igexin.push.core.b.m mVar) {
        if (mVar == null) {
            return null;
        }
        android.content.ContentValues contentValues = new android.content.ContentValues();
        contentValues.put("id", java.lang.Long.valueOf(mVar.a));
        contentValues.put("data", com.igexin.c.b.a.b(mVar.b.getBytes()));
        contentValues.put("type", java.lang.Byte.valueOf(mVar.c));
        contentValues.put("time", java.lang.Long.valueOf(mVar.d));
        contentValues.put("send_times", java.lang.Integer.valueOf(mVar.e));
        return contentValues;
    }

    public static com.igexin.push.core.e.e a() {
        if (e == null) {
            synchronized (com.igexin.push.core.e.e.class) {
                if (e == null) {
                    e = new com.igexin.push.core.e.e();
                }
            }
        }
        return e;
    }

    private boolean a(long j, long j2) {
        com.igexin.push.core.b.m a = a(j);
        if (a == null) {
            return false;
        }
        a.d = j2;
        a.e++;
        com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) new com.igexin.push.core.e.e.AnonymousClass3(a(a), j), true, true);
        return true;
    }

    private java.util.List<com.igexin.push.core.b.m> b() {
        return this.a;
    }

    private void b(byte b2) {
        com.igexin.push.core.b.m mVar;
        try {
            java.util.Iterator<com.igexin.push.core.b.m> it = this.a.iterator();
            while (true) {
                if (!it.hasNext()) {
                    mVar = null;
                    break;
                } else {
                    mVar = it.next();
                    if (mVar.c == b2) {
                        break;
                    }
                }
            }
            if (mVar != null) {
                a(mVar.a, true);
            }
        } catch (java.lang.Throwable th) {
            com.igexin.c.a.c.a.a(th);
        }
    }

    public final com.igexin.push.core.b.m a(long j) {
        for (com.igexin.push.core.b.m mVar : this.a) {
            if (mVar.a == j) {
                return mVar;
            }
        }
        return null;
    }

    public final void a(long j, boolean z) {
        com.igexin.push.core.b.m a = a(j);
        if (a != null) {
            this.a.remove(a);
        }
        com.igexin.c.a.b.e.a().a(new com.igexin.push.core.e.e.AnonymousClass2(a(a), j), z, !z);
    }

    @Override // com.igexin.push.core.e.a
    public final void a(android.database.sqlite.SQLiteDatabase sQLiteDatabase) {
    }

    @Override // com.igexin.push.core.e.a
    public final void b(android.database.sqlite.SQLiteDatabase sQLiteDatabase) {
        android.database.Cursor cursor = null;
        try {
            try {
                cursor = sQLiteDatabase.query("ral", new java.lang.String[]{"id", "data", "type", "time", "send_times"}, null, null, null, null, null);
                long currentTimeMillis = java.lang.System.currentTimeMillis();
                if (cursor != null) {
                    while (cursor.moveToNext()) {
                        long j = cursor.getLong(0);
                        byte b2 = (byte) cursor.getInt(2);
                        long j2 = cursor.getLong(3);
                        int i = cursor.getInt(4);
                        if ((j2 == 0 || currentTimeMillis - j2 <= 259200000) && i < com.igexin.push.config.d.N - 1) {
                            java.util.List<com.igexin.push.core.b.m> list = this.a;
                            com.igexin.push.core.b.m mVar = new com.igexin.push.core.b.m(j, new java.lang.String(com.igexin.c.b.a.c(cursor.getBlob(1))), b2, j2);
                            mVar.e = i;
                            list.add(mVar);
                        } else {
                            a(j, true);
                        }
                    }
                }
                if (cursor != null) {
                    cursor.close();
                }
            } catch (java.lang.Exception e2) {
                com.igexin.c.a.c.a.a(e2);
                if (cursor != null) {
                    cursor.close();
                }
            }
        } catch (java.lang.Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    public final void b(com.igexin.push.core.b.m mVar) {
        byte b2;
        if (this.a.size() < c || (b2 = mVar.c) == 2 || b2 == 7) {
            byte b3 = mVar.c;
            if (b3 != 2) {
                if (b3 != 3) {
                    if (b3 != 5) {
                        if (b3 != 6) {
                            if (b3 != 7) {
                                if (b3 == 8 && a((byte) 8) >= 3) {
                                    return;
                                }
                            }
                        } else if (a((byte) 6) >= 10) {
                            return;
                        }
                    } else if (a((byte) 5) >= 3) {
                        return;
                    }
                } else if (a((byte) 3) >= 300) {
                    return;
                }
                this.a.add(mVar);
                com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) new com.igexin.push.core.e.e.AnonymousClass1(a(mVar), mVar), false, true);
            }
            b(b3);
            this.a.add(mVar);
            com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) new com.igexin.push.core.e.e.AnonymousClass1(a(mVar), mVar), false, true);
        }
    }

    @Override // com.igexin.push.core.e.a
    public final void c(android.database.sqlite.SQLiteDatabase sQLiteDatabase) {
    }
}
