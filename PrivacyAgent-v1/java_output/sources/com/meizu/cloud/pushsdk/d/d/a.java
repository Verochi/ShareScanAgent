package com.meizu.cloud.pushsdk.d.d;

/* loaded from: classes23.dex */
public class a implements com.meizu.cloud.pushsdk.d.d.d {
    private static final java.lang.String a = "a";
    private android.database.sqlite.SQLiteDatabase b;
    private final com.meizu.cloud.pushsdk.d.d.b c;
    private final java.lang.String[] d = {"id", "eventData", "dateCreated"};
    private long e = -1;
    private final int f;

    public a(android.content.Context context, int i) {
        this.c = com.meizu.cloud.pushsdk.d.d.b.a(context, a(context));
        b();
        this.f = i;
    }

    private java.lang.String a(android.content.Context context) {
        java.lang.String processName = com.meizu.cloud.pushsdk.util.MzSystemUtils.getProcessName(context);
        if (android.text.TextUtils.isEmpty(processName)) {
            return "PushEvents.db";
        }
        return processName + "_PushEvents.db";
    }

    public static java.util.Map<java.lang.String, java.lang.String> a(byte[] bArr) {
        try {
            java.io.ByteArrayInputStream byteArrayInputStream = new java.io.ByteArrayInputStream(bArr);
            java.io.ObjectInputStream objectInputStream = new java.io.ObjectInputStream(byteArrayInputStream);
            java.util.HashMap hashMap = (java.util.HashMap) objectInputStream.readObject();
            objectInputStream.close();
            byteArrayInputStream.close();
            return hashMap;
        } catch (java.io.IOException | java.lang.ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static byte[] a(java.util.Map<java.lang.String, java.lang.String> map) {
        try {
            java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
            java.io.ObjectOutputStream objectOutputStream = new java.io.ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(map);
            objectOutputStream.close();
            byteArrayOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (java.io.IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public java.util.List<java.util.Map<java.lang.String, java.lang.Object>> a(int i) {
        return a(null, "id ASC LIMIT " + i);
    }

    public java.util.List<java.util.Map<java.lang.String, java.lang.Object>> a(java.lang.String str, java.lang.String str2) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        if (e()) {
            android.database.Cursor query = this.b.query("events", this.d, str, null, null, null, str2);
            query.moveToFirst();
            while (!query.isAfterLast()) {
                java.util.HashMap hashMap = new java.util.HashMap(4);
                hashMap.put("id", java.lang.Long.valueOf(query.getLong(0)));
                hashMap.put("eventData", a(query.getBlob(1)));
                hashMap.put("dateCreated", query.getString(2));
                query.moveToNext();
                arrayList.add(hashMap);
            }
            query.close();
        }
        return arrayList;
    }

    @Override // com.meizu.cloud.pushsdk.d.d.d
    public void a(com.meizu.cloud.pushsdk.d.a.a aVar) {
        b(aVar);
    }

    @Override // com.meizu.cloud.pushsdk.d.d.d
    public boolean a() {
        return e();
    }

    @Override // com.meizu.cloud.pushsdk.d.d.d
    public boolean a(long j) {
        int i;
        if (e()) {
            i = this.b.delete("events", "id=" + j, null);
        } else {
            i = -1;
        }
        com.meizu.cloud.pushsdk.d.f.c.b(a, "Removed event from database: " + j, new java.lang.Object[0]);
        return i == 1;
    }

    public long b(com.meizu.cloud.pushsdk.d.a.a aVar) {
        if (e()) {
            byte[] a2 = a((java.util.Map<java.lang.String, java.lang.String>) aVar.a());
            android.content.ContentValues contentValues = new android.content.ContentValues(2);
            contentValues.put("eventData", a2);
            this.e = this.b.insert("events", null, contentValues);
        }
        com.meizu.cloud.pushsdk.d.f.c.b(a, "Added event to database: " + this.e, new java.lang.Object[0]);
        return this.e;
    }

    public void b() {
        if (e()) {
            return;
        }
        try {
            android.database.sqlite.SQLiteDatabase writableDatabase = this.c.getWritableDatabase();
            this.b = writableDatabase;
            writableDatabase.enableWriteAheadLogging();
        } catch (java.lang.Exception e) {
            com.meizu.cloud.pushsdk.d.f.c.a(a, " open database error " + e.getMessage(), new java.lang.Object[0]);
        }
    }

    @Override // com.meizu.cloud.pushsdk.d.d.d
    public long c() {
        if (e()) {
            return android.database.DatabaseUtils.queryNumEntries(this.b, "events");
        }
        return 0L;
    }

    @Override // com.meizu.cloud.pushsdk.d.d.d
    public com.meizu.cloud.pushsdk.d.b.c d() {
        java.util.LinkedList linkedList = new java.util.LinkedList();
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (java.util.Map<java.lang.String, java.lang.Object> map : a(this.f)) {
            com.meizu.cloud.pushsdk.d.a.c cVar = new com.meizu.cloud.pushsdk.d.a.c();
            cVar.a((java.util.Map) map.get("eventData"));
            linkedList.add((java.lang.Long) map.get("id"));
            arrayList.add(cVar);
        }
        return new com.meizu.cloud.pushsdk.d.b.c(arrayList, linkedList);
    }

    public boolean e() {
        android.database.sqlite.SQLiteDatabase sQLiteDatabase = this.b;
        return sQLiteDatabase != null && sQLiteDatabase.isOpen();
    }
}
