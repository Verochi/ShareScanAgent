package cn.fly.verify;

/* loaded from: classes.dex */
public class cd {
    private static cn.fly.verify.cd a;
    private static volatile cn.fly.verify.fr.a b;

    /* renamed from: cn.fly.verify.cd$1, reason: invalid class name */
    public class AnonymousClass1 implements cn.fly.verify.fh.a {
        final /* synthetic */ java.util.ArrayList a;
        final /* synthetic */ cn.fly.verify.fv b;

        /* renamed from: cn.fly.verify.cd$1$1, reason: invalid class name and collision with other inner class name */
        public class C00071 implements java.io.FileFilter {
            final /* synthetic */ java.util.ArrayList a;

            public C00071(java.util.ArrayList arrayList) {
                this.a = arrayList;
            }

            @Override // java.io.FileFilter
            public boolean accept(java.io.File file) {
                return !this.a.contains(file.getAbsolutePath());
            }
        }

        public AnonymousClass1(java.util.ArrayList arrayList, cn.fly.verify.fv fvVar) {
            this.a = arrayList;
            this.b = fvVar;
        }

        @Override // cn.fly.verify.fh.a
        public void a(cn.fly.verify.fh.b bVar) {
            try {
                java.io.File file = new java.io.File(cn.fly.verify.ax.g().getFilesDir(), cn.fly.verify.dn.a("0037dfdcOe"));
                if (!file.exists()) {
                    file.mkdirs();
                }
                java.util.ArrayList arrayList = new java.util.ArrayList();
                java.util.Iterator it = this.a.iterator();
                while (it.hasNext()) {
                    java.util.HashMap hashMap = (java.util.HashMap) it.next();
                    try {
                        java.lang.Boolean bool = (java.lang.Boolean) hashMap.get(cn.fly.verify.dn.a("002b<df"));
                        boolean booleanValue = bool != null ? bool.booleanValue() : false;
                        java.lang.String str = (java.lang.String) hashMap.get(cn.fly.verify.dn.a("002RcdAe"));
                        java.lang.String str2 = (java.lang.String) hashMap.get(com.anythink.expressad.d.a.b.dH);
                        java.lang.String str3 = (java.lang.String) hashMap.get("args");
                        java.lang.Object obj = hashMap.get(cn.fly.verify.dn.a("002Zbgba"));
                        if (!android.text.TextUtils.isEmpty(str2) && !android.text.TextUtils.isEmpty(str)) {
                            java.lang.String a = cn.fly.verify.df.a((cn.fly.verify.bd) null);
                            java.util.HashMap hashMap2 = new java.util.HashMap();
                            hashMap2.put(cn.fly.verify.dn.a("004^babebgba"), a);
                            hashMap2.put(cn.fly.verify.dn.a("005gJcbbjGdc"), cn.fly.verify.bm.a().b());
                            hashMap2.put(cn.fly.verify.dn.a("004Nbdcbbgba"), cn.fly.verify.eh.a(cn.fly.verify.ax.g()).d().ah());
                            hashMap2.put(cn.fly.verify.dn.a("010[dfbabjeh)dFbhdfbgcb:c"), java.lang.Integer.valueOf(cn.fly.verify.ax.a));
                            hashMap2.put(cn.fly.verify.dn.a("006bhh.bjMdTbi"), cn.fly.verify.dv.a());
                            hashMap2.put(cn.fly.verify.dn.a("009bhhCch-daUbhDdg"), cn.fly.verify.ax.e());
                            hashMap2.put(cn.fly.verify.dn.a("006WbacbbdZbVbg,c"), cn.fly.verify.ax.a().a());
                            hashMap2.put(cn.fly.verify.dn.a("0107cdcbbhIad]dh]gghLdf"), java.lang.Boolean.valueOf(cn.fly.verify.ax.b()));
                            hashMap2.put(cn.fly.verify.dn.a("009$cdcbbhKadOcgEh.bbff"), java.lang.Boolean.valueOf(cn.fly.verify.ax.c()));
                            hashMap2.put(cn.fly.verify.dn.a("004dadBca"), java.lang.Long.valueOf(((java.lang.Long) cn.fly.verify.bo.a(cn.fly.verify.dn.a("004dadNca"), 5L)).longValue()));
                            hashMap2.put(cn.fly.verify.dn.a("002a%ba"), (java.lang.String) cn.fly.verify.bo.a(cn.fly.verify.dn.a("002aOba"), cn.fly.verify.dn.a("006Jfcfcfdfdfdfd")));
                            hashMap2.put("usridt", cn.fly.verify.bk.e());
                            hashMap2.put(cn.fly.verify.dn.a("002+bgba"), obj);
                            if (!android.text.TextUtils.isEmpty(str3)) {
                                hashMap2.put("args", cn.fly.verify.fm.a(str3));
                            }
                            hashMap2.put(cn.fly.verify.dn.a("008)baGdAbbbg:adIcgba"), bVar.h());
                            hashMap2.put("imei", null);
                            hashMap2.put("imsi", null);
                            hashMap2.put("sno", null);
                            hashMap2.put("ssno", null);
                            hashMap2.put("miui", bVar.p());
                            hashMap2.put(cn.fly.verify.dn.a("005TbdcbbaCde"), cn.fly.verify.fh.d.j());
                            hashMap2.put(cn.fly.verify.dn.a("007%cd(bag(cbbhbi"), cn.fly.verify.fh.d.k());
                            hashMap2.put(cn.fly.verify.dn.a("005:dcbh-bcCba"), cn.fly.verify.fh.d.l());
                            hashMap2.put(cn.fly.verify.dn.a("005bFbadfbgba"), bVar.k());
                            hashMap2.put(cn.fly.verify.dn.a("006bhhKbb7dWbh"), cn.fly.verify.fh.d.f());
                            hashMap2.put("appVerCode", java.lang.Integer.valueOf(cn.fly.verify.fh.d.m()));
                            hashMap2.put(cn.fly.verify.dn.a("011hba+bjKb.cc;d)cf.b>bdCd"), cn.fly.verify.fh.d.c());
                            hashMap2.put(cn.fly.verify.dn.a("005:dcdfdfbgba"), null);
                            hashMap2.put("osint", java.lang.Integer.valueOf(cn.fly.verify.fh.d.g()));
                            hashMap2.put("osname", cn.fly.verify.fh.d.h());
                            hashMap2.put("mdpName", cn.fly.verify.eb.class.getName());
                            java.lang.String a2 = cn.fly.verify.fm.a(hashMap2);
                            java.lang.String a3 = cn.fly.verify.fb.a(str);
                            if (!android.text.TextUtils.isEmpty(str2)) {
                                java.io.File file2 = new java.io.File(file, str2);
                                if (booleanValue) {
                                    arrayList.add(file2.getAbsolutePath());
                                }
                                cn.fly.verify.cd.b(java.lang.String.valueOf(obj), file2, booleanValue, a3, str2, a2);
                            }
                        }
                    } catch (java.lang.Throwable th) {
                        cn.fly.verify.dh.a().a(2, 50, th, cn.fly.verify.fq.a(hashMap.get(cn.fly.verify.dn.a("002$bgba")), -1) + "");
                    }
                }
                cn.fly.verify.fk.a(file, new cn.fly.verify.cd.AnonymousClass1.C00071(arrayList));
            } finally {
                try {
                } finally {
                }
            }
        }
    }

    /* renamed from: cn.fly.verify.cd$2, reason: invalid class name */
    public class AnonymousClass2 implements java.lang.Runnable {
        final /* synthetic */ boolean a;
        final /* synthetic */ java.io.File b;
        final /* synthetic */ java.lang.String c;
        final /* synthetic */ java.lang.String d;
        final /* synthetic */ java.lang.String e;
        final /* synthetic */ java.lang.String f;

        public AnonymousClass2(boolean z, java.io.File file, java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4) {
            this.a = z;
            this.b = file;
            this.c = str;
            this.d = str2;
            this.e = str3;
            this.f = str4;
        }

        @Override // java.lang.Runnable
        public void run() {
            java.lang.Throwable th;
            int i;
            java.io.FileOutputStream fileOutputStream;
            try {
                java.io.ByteArrayOutputStream byteArrayOutputStream = null;
                if (this.a) {
                    try {
                        if (this.b.exists() && this.c.equals(cn.fly.verify.fi.a(this.b))) {
                            if (cn.fly.verify.cd.b(this.e, 5, this.b.getAbsolutePath(), null, this.f)) {
                                return;
                            }
                            this.b.delete();
                            return;
                        }
                        int i2 = 6;
                        try {
                            if (this.b.exists()) {
                                this.b.delete();
                            }
                            i = 7;
                            try {
                                try {
                                    fileOutputStream = new java.io.FileOutputStream(this.b);
                                    try {
                                        cn.fly.verify.fc.a aVar = new cn.fly.verify.fc.a();
                                        aVar.a = 60000;
                                        aVar.b = 15000;
                                        new cn.fly.verify.fc().a(this.d, fileOutputStream, aVar);
                                        cn.fly.verify.dw.a(fileOutputStream);
                                        if (this.b.length() <= 0 || !android.text.TextUtils.equals(this.c, cn.fly.verify.fi.a(this.b))) {
                                            if (this.b.exists()) {
                                                this.b.delete();
                                                return;
                                            }
                                            return;
                                        } else {
                                            if (cn.fly.verify.cd.b(this.e, 7, this.b.getAbsolutePath(), null, this.f)) {
                                                return;
                                            }
                                            this.b.delete();
                                            return;
                                        }
                                    } catch (java.lang.Throwable th2) {
                                        th = th2;
                                        cn.fly.verify.dw.a(fileOutputStream);
                                        if (this.b.length() > 0 && android.text.TextUtils.equals(this.c, cn.fly.verify.fi.a(this.b))) {
                                            if (!cn.fly.verify.cd.b(this.e, 7, this.b.getAbsolutePath(), null, this.f)) {
                                                this.b.delete();
                                            }
                                            i2 = 7;
                                        } else if (this.b.exists()) {
                                            this.b.delete();
                                        }
                                        try {
                                            throw th;
                                        } catch (java.lang.Throwable th3) {
                                            i = i2;
                                            th = th3;
                                        }
                                    }
                                } catch (java.lang.Throwable th4) {
                                    th = th4;
                                }
                            } catch (java.lang.Throwable th5) {
                                th = th5;
                                fileOutputStream = null;
                            }
                        } catch (java.lang.Throwable th6) {
                            th = th6;
                            i = 6;
                        }
                    } catch (java.lang.Throwable th7) {
                        th = th7;
                        i = 5;
                    }
                } else {
                    if (this.b.exists()) {
                        this.b.delete();
                    }
                    try {
                        try {
                            java.io.ByteArrayOutputStream byteArrayOutputStream2 = new java.io.ByteArrayOutputStream();
                            try {
                                cn.fly.verify.fc.a aVar2 = new cn.fly.verify.fc.a();
                                aVar2.a = 60000;
                                aVar2.b = 15000;
                                new cn.fly.verify.fc().a(this.d, byteArrayOutputStream2, aVar2);
                                cn.fly.verify.dw.a(byteArrayOutputStream2);
                                byte[] byteArray = byteArrayOutputStream2.toByteArray();
                                if (byteArray.length <= 0 || !android.text.TextUtils.equals(this.c, cn.fly.verify.fi.d(byteArray))) {
                                    return;
                                }
                                try {
                                    cn.fly.verify.cd.b(this.e, 9, null, byteArray, this.f);
                                    return;
                                } catch (java.lang.Throwable th8) {
                                    th = th8;
                                    i = 9;
                                }
                            } catch (java.lang.Throwable th9) {
                                th = th9;
                                byteArrayOutputStream = byteArrayOutputStream2;
                                cn.fly.verify.dw.a(byteArrayOutputStream);
                                throw th;
                            }
                        } catch (java.lang.Throwable th10) {
                            th = th10;
                            i = 8;
                        }
                    } catch (java.lang.Throwable th11) {
                        th = th11;
                    }
                }
            } catch (java.lang.Throwable th12) {
                th = th12;
                i = 13;
            }
            cn.fly.verify.dh.a().a(5, i, th, this.e);
            cn.fly.verify.ed.a().a(th);
        }
    }

    public static class a implements java.lang.Runnable {
        private static final cn.fly.verify.cd.a[] a = new cn.fly.verify.cd.a[3];
        private long b;
        private java.util.HashMap<java.lang.String, java.lang.Object> c;

        /* renamed from: cn.fly.verify.cd$a$1, reason: invalid class name */
        public class AnonymousClass1 implements cn.fly.verify.dp {

            /* renamed from: cn.fly.verify.cd$a$1$1, reason: invalid class name and collision with other inner class name */
            public class C00081 implements cn.fly.verify.fh.a {
                public C00081() {
                }

                @Override // cn.fly.verify.fh.a
                public void a(cn.fly.verify.fh.b bVar) throws java.lang.Throwable {
                    cn.fly.verify.cd.b b;
                    android.content.ContentValues contentValues = new android.content.ContentValues();
                    contentValues.put(cn.fly.verify.dn.a("004gEbgbd%d"), java.lang.String.valueOf(cn.fly.verify.cd.a.this.b));
                    if (cn.fly.verify.cd.a.this.c != null) {
                        cn.fly.verify.cd.a.this.c.put(cn.fly.verify.dn.a("006bhh+bj(d)bi"), cn.fly.verify.dv.a());
                        cn.fly.verify.cd.a.this.c.put(cn.fly.verify.dn.a("006bhhh)bjcc"), cn.fly.verify.fh.d.c());
                        cn.fly.verify.cd.a.this.c.put(cn.fly.verify.dn.a("006bhh?bb5dNbh"), cn.fly.verify.fh.d.f());
                        long longValue = ((java.lang.Long) cn.fly.verify.bo.a(cn.fly.verify.dn.a("010DdfJgTbhKbgdMccbicgba"), 0L)).longValue();
                        if (longValue != 0) {
                            cn.fly.verify.cd.a.this.c.put(cn.fly.verify.dn.a("010Tdf=gMbhPbgd%ccbicgba"), java.lang.Long.valueOf(longValue));
                        }
                    }
                    contentValues.put(cn.fly.verify.dn.a("004Mba;bgb"), android.util.Base64.encodeToString(cn.fly.verify.fi.a(cn.fly.verify.fi.c(cn.fly.verify.fh.d.k()), cn.fly.verify.fm.a(cn.fly.verify.cd.a.this.c).getBytes("utf-8")), 2));
                    cn.fly.verify.fr.a(cn.fly.verify.cd.b, contentValues);
                    long longValue2 = ((java.lang.Long) cn.fly.verify.bo.a(cn.fly.verify.dn.a("004Xba2dHbeZh"), 2L)).longValue();
                    if (cn.fly.verify.dn.a("004cUcbMcd").equals(bVar.g())) {
                        longValue2 = 120;
                    }
                    if (!cn.fly.verify.bo.c() || (b = cn.fly.verify.cd.b.b()) == null) {
                        return;
                    }
                    if (longValue2 <= 0) {
                        b.run();
                    } else {
                        if (cn.fly.verify.bj.a().a(longValue2, b)) {
                            return;
                        }
                        b.c();
                    }
                }
            }

            public AnonymousClass1() {
            }

            @Override // cn.fly.verify.dp
            public boolean a(cn.fly.verify.fj fjVar) {
                cn.fly.verify.fh.a(cn.fly.verify.ax.g()).g().a(new cn.fly.verify.cd.a.AnonymousClass1.C00081());
                return false;
            }
        }

        private a(long j, java.util.HashMap<java.lang.String, java.lang.Object> hashMap) {
            this.b = j;
            this.c = hashMap;
        }

        private void a() {
            try {
                cn.fly.verify.cd.a[] aVarArr = a;
                synchronized (aVarArr) {
                    for (int i = 0; i < 3; i++) {
                        if (aVarArr[i] == null) {
                            this.b = 0L;
                            java.util.HashMap<java.lang.String, java.lang.Object> hashMap = this.c;
                            if (hashMap != null) {
                                hashMap.clear();
                            }
                            this.c = null;
                            aVarArr[i] = this;
                            return;
                        }
                    }
                }
            } catch (java.lang.Throwable unused) {
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static cn.fly.verify.cd.a b(long j, java.util.HashMap<java.lang.String, java.lang.Object> hashMap) {
            cn.fly.verify.cd.a[] aVarArr = a;
            synchronized (aVarArr) {
                for (int i = 0; i < 3; i++) {
                    cn.fly.verify.cd.a aVar = aVarArr[i];
                    if (aVar != null) {
                        aVar.b = j;
                        java.util.HashMap<java.lang.String, java.lang.Object> hashMap2 = aVar.c;
                        if (hashMap2 != null) {
                            hashMap2.clear();
                        }
                        aVar.c = hashMap;
                        aVarArr[i] = null;
                        return aVar;
                    }
                }
                return new cn.fly.verify.cd.a(j, hashMap);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                cn.fly.verify.dq.a(cn.fly.verify.dq.a(cn.fly.verify.dq.b), new cn.fly.verify.cd.a.AnonymousClass1());
            } finally {
                try {
                } finally {
                }
            }
        }
    }

    public static class b implements java.lang.Runnable {
        private static final cn.fly.verify.cd.b[] b = {new cn.fly.verify.cd.b()};
        public boolean a = false;

        /* renamed from: cn.fly.verify.cd$b$1, reason: invalid class name */
        public class AnonymousClass1 implements cn.fly.verify.fh.a {
            public AnonymousClass1() {
            }

            /* JADX WARN: Code restructure failed: missing block: B:11:0x001e, code lost:
            
                cn.fly.verify.bj.a().b();
             */
            @Override // cn.fly.verify.fh.a
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void a(cn.fly.verify.fh.b bVar) {
                try {
                    java.lang.String[][] strArr = new java.lang.String[50][];
                    cn.fly.verify.cd.b bVar2 = cn.fly.verify.cd.b.this;
                    while (true) {
                        int a = bVar2.a(strArr);
                        if (a <= 0) {
                            break;
                        }
                        android.util.SparseArray a2 = cn.fly.verify.cd.b.this.a(strArr, a, bVar);
                        if (a2.size() == 0 && cn.fly.verify.cd.b.this.a) {
                            break;
                        }
                        if (a2.size() > 0) {
                            cn.fly.verify.cd.b.this.a((android.util.SparseArray<java.lang.String>) a2);
                        }
                        if (a < 50) {
                            break;
                        } else {
                            bVar2 = cn.fly.verify.cd.b.this;
                        }
                    }
                } finally {
                    cn.fly.verify.cd.b.this.c();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int a(android.util.SparseArray<java.lang.String> sparseArray) {
            try {
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                int size = sparseArray.size();
                for (int i = 0; i < size; i++) {
                    if (sb.length() > 0) {
                        sb.append(", ");
                    }
                    sb.append('\'');
                    sb.append(sparseArray.valueAt(i));
                    sb.append('\'');
                }
                try {
                    return cn.fly.verify.fr.a(cn.fly.verify.cd.b, "time in (" + sb.toString() + ")", null);
                } catch (java.lang.Throwable th) {
                    cn.fly.verify.ed.a().b(th);
                    return cn.fly.verify.fr.a(cn.fly.verify.cd.b, "time in (" + sb.toString() + ")", null);
                }
            } catch (java.lang.Throwable th2) {
                cn.fly.verify.ed.a().b(th2);
                return 0;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int a(java.lang.String[][] strArr) {
            long j;
            int i = 0;
            android.database.Cursor cursor = null;
            try {
                cursor = cn.fly.verify.fr.a(cn.fly.verify.cd.b, new java.lang.String[]{cn.fly.verify.dn.a("004g5bgbd;d"), cn.fly.verify.dn.a("0042baNbgb")}, null, null, "time desc");
                if (cursor == null) {
                    if (cursor != null) {
                        try {
                            cursor.close();
                        } catch (java.lang.Throwable unused) {
                        }
                    }
                    return 0;
                }
                if (!cursor.moveToFirst()) {
                    try {
                        cursor.close();
                    } catch (java.lang.Throwable unused2) {
                    }
                    return 0;
                }
                long currentTimeMillis = java.lang.System.currentTimeMillis();
                int i2 = 0;
                try {
                    do {
                        try {
                            java.lang.String[] strArr2 = {cursor.getString(0), cursor.getString(1)};
                            try {
                                j = java.lang.Long.parseLong(strArr2[0]);
                            } catch (java.lang.Throwable unused3) {
                                j = -1;
                            }
                            if (j <= currentTimeMillis) {
                                strArr[i2] = strArr2;
                                i2++;
                            }
                            if (i2 < strArr.length) {
                            }
                            cursor.close();
                            return i2;
                        } catch (java.lang.Throwable th) {
                            th = th;
                            i = i2;
                            try {
                                cn.fly.verify.ed.a().b(th);
                                if (cursor != null) {
                                    try {
                                        cursor.close();
                                    } catch (java.lang.Throwable unused4) {
                                    }
                                }
                                return i;
                            } catch (java.lang.Throwable th2) {
                                if (cursor != null) {
                                    try {
                                        cursor.close();
                                    } catch (java.lang.Throwable unused5) {
                                    }
                                }
                                throw th2;
                            }
                        }
                    } while (cursor.moveToNext());
                    cursor.close();
                    return i2;
                } catch (java.lang.Throwable unused6) {
                    return i2;
                }
            } catch (java.lang.Throwable th3) {
                th = th3;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public android.util.SparseArray<java.lang.String> a(java.lang.String[][] strArr, int i, cn.fly.verify.fh.b bVar) {
            java.util.HashMap<java.lang.String, java.lang.Object> hashMap;
            java.util.ArrayList arrayList;
            android.util.SparseArray<java.lang.String> sparseArray = new android.util.SparseArray<>();
            try {
                hashMap = new java.util.HashMap<>();
                hashMap.put(cn.fly.verify.dn.a("004hebg"), java.lang.Integer.valueOf(cn.fly.verify.fh.d.e()));
                hashMap.put(cn.fly.verify.dn.a("006Bba)d!bbbg8ad"), bVar.h());
                hashMap.put(cn.fly.verify.dn.a("005YbdcbbaOde"), cn.fly.verify.fh.d.j());
                hashMap.put(cn.fly.verify.dn.a("004Sbabebgba"), cn.fly.verify.df.a((cn.fly.verify.bd) null));
                hashMap.put(cn.fly.verify.dn.a("011cdgNddcbbhbj*gEbi,hd"), bVar.g());
                hashMap.put(cn.fly.verify.dn.a("015$ba6bgb[cf9dgAddcbbhbjcibiThd"), java.lang.Integer.valueOf(bVar.w()));
                arrayList = new java.util.ArrayList();
                byte[] c = cn.fly.verify.fi.c(cn.fly.verify.fh.d.k());
                for (int i2 = 0; i2 < i; i2++) {
                    java.lang.String[] strArr2 = strArr[i2];
                    try {
                        java.util.HashMap a = cn.fly.verify.fm.a(new java.lang.String(cn.fly.verify.fi.b(c, android.util.Base64.decode(strArr2[1], 2)), "utf-8").trim());
                        sparseArray.put(i2, strArr2[0]);
                        arrayList.add(a);
                    } catch (java.lang.Throwable th) {
                        cn.fly.verify.ed.a().b(th);
                    }
                }
            } catch (java.lang.Throwable th2) {
                cn.fly.verify.ed.a().b(th2);
            }
            if (arrayList.isEmpty()) {
                return new android.util.SparseArray<>();
            }
            hashMap.put(cn.fly.verify.dn.a("005Fba(bgb[df"), arrayList);
            hashMap.put(cn.fly.verify.dn.a("005gGcbbj,dc"), cn.fly.verify.bm.a().b());
            java.util.HashMap<java.lang.String, java.lang.String> hashMap2 = new java.util.HashMap<>();
            hashMap2.put(cn.fly.verify.dn.a("013$cedf.dAbhficgba!dcgIbgMg2bi"), cn.fly.verify.bk.c());
            hashMap2.put(cn.fly.verify.dn.a("004]bdcbbgba"), cn.fly.verify.eh.a(cn.fly.verify.ax.g()).d().ai());
            cn.fly.verify.fc.a aVar = new cn.fly.verify.fc.a();
            aVar.a = 30000;
            aVar.b = 30000;
            if (!com.meizu.cloud.pushsdk.platform.message.BasicPushStatus.SUCCESS_CODE.equals(java.lang.String.valueOf(cn.fly.verify.fm.a((java.lang.String) new cn.fly.verify.fb(1024, "ceeef5035212dfe7c6a0acdc0ef35ce5b118aab916477037d7381f85c6b6176fcf57b1d1c3296af0bb1c483fe5e1eb0ce9eb2953b44e494ca60777a1b033cc07", "191737288d17e660c4b61440d5d14228a0bf9854499f9d68d8274db55d6d954489371ecf314f26bec236e58fac7fffa9b27bcf923e1229c4080d49f7758739e5bd6014383ed2a75ce1be9b0ab22f283c5c5e11216c5658ba444212b6270d629f2d615b8dfdec8545fb7d4f935b0cc10b6948ab4fc1cb1dd496a8f94b51e888dd", aVar).b(false, hashMap2, hashMap, cn.fly.verify.dj.a().a("gclg") + "/v6/gcl", false)).get(cn.fly.verify.dn.a("006Mdf_gbgNbedf"))))) {
                sparseArray.clear();
            }
            return sparseArray;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static cn.fly.verify.cd.b b() {
            cn.fly.verify.cd.b[] bVarArr = b;
            synchronized (bVarArr) {
                cn.fly.verify.cd.b bVar = bVarArr[0];
                if (bVar == null) {
                    return null;
                }
                bVarArr[0] = null;
                if (bVar.a) {
                    bVar.a = false;
                }
                return bVar;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c() {
            cn.fly.verify.cd.b[] bVarArr = b;
            synchronized (bVarArr) {
                if (bVarArr[0] == null) {
                    bVarArr[0] = this;
                }
            }
            this.a = false;
        }

        @Override // java.lang.Runnable
        public void run() {
            cn.fly.verify.fh.a(cn.fly.verify.ax.g()).h().g().w().a(new cn.fly.verify.cd.b.AnonymousClass1());
        }
    }

    private cd() {
        try {
            android.content.Context g = cn.fly.verify.ax.g();
            java.lang.String str = cn.fly.verify.dn.a;
            java.io.File a2 = cn.fly.verify.fq.a(g, str, true);
            if (a2.exists() && a2.length() > 209715200) {
                a2.delete();
                a2 = cn.fly.verify.fq.a(cn.fly.verify.ax.g(), str, true);
            }
            b = cn.fly.verify.fr.a(a2.getAbsolutePath(), cn.fly.verify.dn.a("008CdiKbgb-dh;dbh") + "_1");
            b.a(cn.fly.verify.dn.a("004g_bgbd*d"), cn.fly.verify.dn.a("004gdJca3g"), true);
            b.a(cn.fly.verify.dn.a("0041ba6bgb"), cn.fly.verify.dn.a("004gd%ca5g"), true);
            cn.fly.verify.cd.b b2 = cn.fly.verify.cd.b.b();
            if (b2 != null) {
                cn.fly.verify.bj.a().a(0L, 180, b2);
            }
        } catch (java.lang.Throwable th) {
            cn.fly.verify.ed.a().b(th);
        }
    }

    public static synchronized cn.fly.verify.cd a() {
        cn.fly.verify.cd cdVar;
        synchronized (cn.fly.verify.cd.class) {
            if (a == null) {
                a = new cn.fly.verify.cd();
            }
            cdVar = a;
        }
        return cdVar;
    }

    public static java.lang.String a(int[] iArr) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        for (int i = 0; i < iArr.length; i++) {
            if (iArr[i] < cn.fly.verify.dy.f().length()) {
                sb.append((char) (r2.charAt(iArr[i]) - 2));
            }
        }
        return sb.toString();
    }

    public static void a(java.util.ArrayList<java.util.HashMap<java.lang.String, java.lang.Object>> arrayList, cn.fly.verify.fv<java.lang.Void> fvVar) throws java.lang.Throwable {
        if (arrayList == null || arrayList.isEmpty()) {
            fvVar.a(null);
        } else {
            cn.fly.verify.fh.a(cn.fly.verify.ax.g()).h().p().k().a(new cn.fly.verify.cd.AnonymousClass1(arrayList, fvVar));
        }
    }

    public static void a(java.lang.Object... objArr) {
        try {
            try {
                cn.fly.verify.di.a().a(13);
                cn.fly.verify.fq.a(b(objArr));
            } catch (java.lang.Throwable th) {
                try {
                    cn.fly.verify.di.a().a(5, th);
                    cn.fly.verify.fq.a((java.io.File) null);
                } catch (java.lang.Throwable th2) {
                    try {
                        cn.fly.verify.fq.a((java.io.File) null);
                    } catch (java.lang.Throwable th3) {
                        cn.fly.verify.di.a().a(4, th3);
                    }
                    throw th2;
                }
            }
        } catch (java.lang.Throwable th4) {
            cn.fly.verify.di.a().a(4, th4);
        }
    }

    private static java.io.File b(java.lang.Object... objArr) throws java.lang.Throwable {
        int i;
        java.io.InputStream inputStream;
        java.io.File file;
        java.io.FileOutputStream fileOutputStream;
        cn.fly.verify.di a2;
        java.lang.String str = (java.lang.String) objArr[0];
        java.lang.String str2 = (java.lang.String) objArr[1];
        java.lang.String str3 = (java.lang.String) objArr[4];
        java.lang.String str4 = (java.lang.String) objArr[5];
        java.io.InputStream inputStream2 = null;
        if (android.text.TextUtils.isEmpty(str) || android.text.TextUtils.isEmpty(str2)) {
            return null;
        }
        try {
            java.io.File file2 = new java.io.File(cn.fly.verify.ax.g().getFilesDir(), cn.fly.verify.dn.a("0036df_aa"));
            byte[] bArr = (byte[]) objArr[2];
            try {
                i = java.lang.Integer.parseInt(java.lang.String.valueOf(objArr[3]));
            } catch (java.lang.Throwable unused) {
                i = 0;
            }
            if (bArr == null || i <= 0 || bArr.length < i || !str.equals(cn.fly.verify.fi.b(bArr, 0, i))) {
                java.io.File file3 = new java.io.File(file2, cn.fly.verify.dn.a("008aOcb0cWcddbdf?aa"));
                if (file3.exists() && str.equals(cn.fly.verify.fi.a(file3))) {
                    inputStream = new java.io.FileInputStream(file3);
                } else {
                    cn.fly.verify.di.a().a(20);
                    file3.delete();
                    inputStream = null;
                }
            } else {
                inputStream = new java.io.ByteArrayInputStream(bArr, 0, i);
            }
            if (inputStream != null) {
                try {
                    file = new java.io.File(file2, java.lang.String.valueOf(java.lang.System.currentTimeMillis()));
                    if (!file.exists()) {
                        file.mkdirs();
                    }
                    java.io.File file4 = new java.io.File(file, file.getName() + cn.fly.verify.dn.a("0048dbeabgKh"));
                    try {
                        fileOutputStream = new java.io.FileOutputStream(file4);
                        try {
                            cn.fly.verify.fi.a(str2, inputStream, fileOutputStream);
                            cn.fly.verify.dw.a(inputStream, fileOutputStream);
                            try {
                                if (cn.fly.verify.dk.a().b()) {
                                    cn.fly.verify.di.a().a(14);
                                    cn.fly.verify.bf.a(str, file4, str3, str4);
                                } else {
                                    cn.fly.verify.di.a().a(19);
                                }
                            } catch (java.lang.Throwable th) {
                                try {
                                    cn.fly.verify.di.a().a(6, th);
                                    try {
                                        cn.fly.verify.fq.a(file);
                                    } catch (java.lang.Throwable th2) {
                                        th = th2;
                                        a2 = cn.fly.verify.di.a();
                                        a2.a(4, th);
                                        cn.fly.verify.dw.a(inputStream2);
                                        return file;
                                    }
                                } finally {
                                }
                            }
                            try {
                                cn.fly.verify.fq.a(file);
                            } catch (java.lang.Throwable th3) {
                                th = th3;
                                a2 = cn.fly.verify.di.a();
                                a2.a(4, th);
                                cn.fly.verify.dw.a(inputStream2);
                                return file;
                            }
                        } catch (java.lang.Throwable th4) {
                            th = th4;
                            cn.fly.verify.dw.a(inputStream, fileOutputStream);
                            throw th;
                        }
                    } catch (java.lang.Throwable th5) {
                        th = th5;
                        fileOutputStream = null;
                    }
                } catch (java.lang.Throwable th6) {
                    th = th6;
                    inputStream2 = inputStream;
                    cn.fly.verify.dw.a(inputStream2);
                    throw th;
                }
            } else {
                file = null;
                inputStream2 = inputStream;
            }
            cn.fly.verify.dw.a(inputStream2);
            return file;
        } catch (java.lang.Throwable th7) {
            th = th7;
            cn.fly.verify.dw.a(inputStream2);
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(java.lang.String str, java.io.File file, boolean z, java.lang.String str2, java.lang.String str3, java.lang.String str4) {
        new java.lang.Thread(new cn.fly.verify.cd.AnonymousClass2(z, file, str3, str2, str, str4)).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean b(java.lang.String str, int i, java.lang.String str2, byte[] bArr, java.lang.String str3) {
        try {
            java.lang.reflect.Method method = null;
            boolean z = false;
            for (java.lang.reflect.Method method2 : cn.fly.verify.er.class.getMethods()) {
                java.lang.annotation.Annotation[] annotations = method2.getAnnotations();
                if (annotations != null) {
                    int length = annotations.length;
                    int i2 = 0;
                    while (true) {
                        if (i2 >= length) {
                            break;
                        }
                        java.lang.annotation.Annotation annotation = annotations[i2];
                        if (annotation != null && annotation.annotationType() == cn.fly.verify.es.class) {
                            method = method2;
                            z = true;
                            break;
                        }
                        i2++;
                    }
                    if (z) {
                        break;
                    }
                }
            }
            if (bArr != null) {
                cn.fly.verify.ce.a(cn.fly.verify.ax.g(), bArr, str3, method);
            } else {
                cn.fly.verify.ce.a(cn.fly.verify.ax.g(), str2, str3, method);
            }
            return true;
        } catch (java.lang.Throwable th) {
            try {
                cn.fly.verify.dh.a().a(6, i, th, str);
                cn.fly.verify.ed.a().a(th);
            } catch (java.lang.Throwable unused) {
            }
            return false;
        }
    }

    public void a(long j, java.util.HashMap<java.lang.String, java.lang.Object> hashMap) {
        boolean a2 = cn.fly.verify.bo.a();
        cn.fly.verify.ed.a().a("DH PD: " + hashMap.get(cn.fly.verify.dn.a("004g-bi<hd")) + ", to: " + a2, new java.lang.Object[0]);
        if (a2) {
            cn.fly.verify.ea.d.execute(cn.fly.verify.cd.a.b(j, hashMap));
        }
    }
}
