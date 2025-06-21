package cn.fly.verify;

/* loaded from: classes.dex */
public class fr {

    public static class a {
        private java.lang.String a;
        private java.lang.String b;
        private android.database.sqlite.SQLiteDatabase c;
        private java.util.LinkedHashMap<java.lang.String, java.lang.String> d;
        private java.util.HashMap<java.lang.String, java.lang.Boolean> e;
        private java.lang.String f;
        private boolean g;

        private a(java.lang.String str, java.lang.String str2) {
            this.a = str;
            this.b = str2;
            this.d = new java.util.LinkedHashMap<>();
            this.e = new java.util.HashMap<>();
        }

        public /* synthetic */ a(java.lang.String str, java.lang.String str2, cn.fly.verify.fr.AnonymousClass1 anonymousClass1) {
            this(str, str2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Removed duplicated region for block: B:31:0x0096 A[DONT_GENERATE] */
        /* JADX WARN: Removed duplicated region for block: B:33:0x009b  */
        /* JADX WARN: Removed duplicated region for block: B:64:? A[RETURN, SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void a() throws java.lang.Throwable {
            boolean z;
            if (android.text.TextUtils.isEmpty(this.a)) {
                throw new java.lang.Throwable("path is null");
            }
            java.io.File file = new java.io.File(this.a);
            android.database.Cursor cursor = null;
            if (this.c != null && !file.exists()) {
                this.c.close();
                try {
                    java.io.File parentFile = file.getParentFile();
                    if (parentFile != null && (!parentFile.exists() || !parentFile.isDirectory())) {
                        parentFile.delete();
                        parentFile.mkdirs();
                    }
                } catch (java.lang.Throwable unused) {
                }
                this.c = null;
            }
            if (this.c != null) {
                return;
            }
            if (!file.exists()) {
                try {
                    java.io.File parentFile2 = file.getParentFile();
                    if (parentFile2 != null && (!parentFile2.exists() || !parentFile2.isDirectory())) {
                        parentFile2.delete();
                        parentFile2.mkdirs();
                        file.createNewFile();
                    }
                } catch (java.lang.Throwable unused2) {
                }
            }
            android.database.sqlite.SQLiteDatabase openOrCreateDatabase = android.database.sqlite.SQLiteDatabase.openOrCreateDatabase(file, (android.database.sqlite.SQLiteDatabase.CursorFactory) null);
            this.c = openOrCreateDatabase;
            try {
                cursor = openOrCreateDatabase.query(cn.fly.verify.dt.a("013Bfhde5gZdi)ifIdhdf?dBfh(ifBdj"), null, cn.fly.verify.dt.a("017i8dk7jfNiiihif=de@dcifRed0df9fAiiih"), new java.lang.String[]{cn.fly.verify.dt.a("005idAfeYgf"), this.b}, null, null, null);
                if (cursor != null) {
                    if (cursor.getCount() > 0) {
                        z = false;
                        if (z) {
                            return;
                        }
                        java.lang.StringBuilder sb = new java.lang.StringBuilder();
                        sb.append("create table  ");
                        sb.append(this.b);
                        sb.append("(");
                        for (java.util.Map.Entry<java.lang.String, java.lang.String> entry : this.d.entrySet()) {
                            java.lang.String key = entry.getKey();
                            java.lang.String value = entry.getValue();
                            boolean booleanValue = this.e.get(key).booleanValue();
                            boolean equals = key.equals(this.f);
                            boolean z2 = equals ? this.g : false;
                            sb.append(key);
                            sb.append(" ");
                            sb.append(value);
                            sb.append(booleanValue ? " not null" : "");
                            sb.append(equals ? " primary key" : "");
                            sb.append(z2 ? " autoincrement," : ",");
                        }
                        sb.replace(sb.length() - 1, sb.length(), ");");
                        try {
                            android.database.sqlite.SQLiteDatabase.class.getMethod(cn.fly.verify.dt.a("007f*ec6fcPejjjfc"), java.lang.String.class).invoke(this.c, sb.toString());
                            return;
                        } catch (java.lang.Throwable th) {
                            cn.fly.verify.ed.a().a(th);
                            return;
                        }
                    }
                }
                z = true;
                if (z) {
                }
            } finally {
                if (cursor != null) {
                    cursor.close();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public java.lang.String b() {
            return this.b;
        }

        public void a(java.lang.String str, java.lang.String str2, boolean z) {
            if (this.c == null) {
                this.d.put(str, str2);
                this.e.put(str, java.lang.Boolean.valueOf(z));
            }
        }
    }

    public static int a(cn.fly.verify.fr.a aVar, java.lang.String str, java.lang.String[] strArr) throws java.lang.Throwable {
        aVar.a();
        return aVar.c.delete(aVar.b(), str, strArr);
    }

    public static long a(cn.fly.verify.fr.a aVar, android.content.ContentValues contentValues) throws java.lang.Throwable {
        aVar.a();
        return aVar.c.replace(aVar.b(), null, contentValues);
    }

    public static android.database.Cursor a(cn.fly.verify.fr.a aVar, java.lang.String[] strArr, java.lang.String str, java.lang.String[] strArr2, java.lang.String str2) throws java.lang.Throwable {
        aVar.a();
        return aVar.c.query(aVar.b(), strArr, str, strArr2, null, null, str2);
    }

    public static cn.fly.verify.fr.a a(java.lang.String str, java.lang.String str2) {
        return new cn.fly.verify.fr.a(str, str2, null);
    }
}
