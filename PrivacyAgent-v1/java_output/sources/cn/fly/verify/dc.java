package cn.fly.verify;

/* loaded from: classes.dex */
public class dc {
    private java.lang.String a;
    private int b;
    private cn.fly.verify.cv c;
    private int d;
    private int e;
    private cn.fly.verify.cz f;

    /* renamed from: cn.fly.verify.dc$1, reason: invalid class name */
    public class AnonymousClass1 extends cn.fly.verify.dc {
        public AnonymousClass1(java.lang.String str, int i, java.util.ArrayList arrayList, java.util.ArrayList arrayList2, int i2, int i3, cn.fly.verify.cv cvVar) {
            super(str, i, arrayList, arrayList2, i2, i3, cvVar);
        }

        @Override // cn.fly.verify.dc
        public java.util.LinkedList<java.lang.Object> b(java.lang.Object... objArr) throws java.lang.Throwable {
            return new java.util.LinkedList<>();
        }
    }

    public static class a implements cn.fly.verify.cw<cn.fly.verify.dc.a> {
        public java.lang.Throwable a;
        public java.lang.Object b;

        public boolean a() {
            return this.a != null;
        }

        @Override // cn.fly.verify.cw
        public boolean a(cn.fly.verify.dc.a aVar, java.lang.Class<cn.fly.verify.dc.a> cls, java.lang.String str, java.lang.Object[] objArr, boolean[] zArr, java.lang.Object[] objArr2, java.lang.Throwable[] thArr) {
            if ("isError".equals(str) && objArr.length == 0) {
                objArr2[0] = java.lang.Boolean.valueOf(aVar.a());
                return true;
            }
            if ("getError".equals(str) && objArr.length == 0) {
                objArr2[0] = aVar.a;
                return true;
            }
            if (!"getResult".equals(str) || objArr.length != 0) {
                return false;
            }
            objArr2[0] = aVar.b;
            return true;
        }
    }

    public dc(java.lang.String str, int i, java.util.ArrayList<cn.fly.verify.db> arrayList, java.util.ArrayList<java.lang.Object> arrayList2, int i2, int i3, cn.fly.verify.cv cvVar) {
        this.a = str;
        this.b = i;
        this.f = new cn.fly.verify.cz(arrayList, arrayList2);
        this.d = i2;
        this.e = i3;
        this.c = cvVar;
    }

    public static cn.fly.verify.dc a(java.lang.String str, int i, java.util.ArrayList<cn.fly.verify.db> arrayList, java.util.ArrayList<java.lang.Object> arrayList2, int i2, int i3, cn.fly.verify.cv cvVar) {
        return new cn.fly.verify.dc.AnonymousClass1(str, i, arrayList, arrayList2, i2, i3, cvVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x00cb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(java.lang.String str, int i, java.util.ArrayList<cn.fly.verify.db> arrayList, int i2) {
        cn.fly.verify.db dbVar;
        cn.fly.verify.db dbVar2;
        if (i2 != 0) {
            cn.fly.verify.db dbVar3 = new cn.fly.verify.db(29);
            dbVar3.b = str;
            dbVar3.c = i;
            dbVar3.i = 1;
            arrayList.add(dbVar3);
        }
        cn.fly.verify.db dbVar4 = new cn.fly.verify.db(1);
        dbVar4.b = str;
        dbVar4.c = i;
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("arg");
        int i3 = i2 + 1;
        sb.append(i3);
        dbVar4.h = sb.toString();
        arrayList.add(dbVar4);
        int i4 = this.b;
        if (i2 >= i4 - 1) {
            for (int i5 = i4 - 1; i5 >= 0; i5 += -1) {
                cn.fly.verify.db dbVar5 = new cn.fly.verify.db(3);
                dbVar5.b = str;
                dbVar5.c = i;
                dbVar5.h = "arg" + (i5 + 1);
                arrayList.add(dbVar5);
            }
            if (this.a == null) {
                cn.fly.verify.db dbVar6 = new cn.fly.verify.db(2);
                dbVar6.b = str;
                dbVar6.c = i;
                dbVar6.q = this;
                arrayList.add(dbVar6);
                dbVar = new cn.fly.verify.db(32);
                dbVar.b = str;
                dbVar.c = i;
            } else {
                dbVar = new cn.fly.verify.db(31);
                dbVar.b = str;
                dbVar.c = i;
                dbVar.h = this.a;
            }
            dbVar.i = this.b;
            arrayList.add(dbVar);
            java.util.Iterator<cn.fly.verify.db> it = this.f.a().iterator();
            while (it.hasNext()) {
                if (it.next().a == 28) {
                    dbVar2 = new cn.fly.verify.db(28);
                }
            }
            if (i2 == 0) {
                cn.fly.verify.db dbVar7 = new cn.fly.verify.db(30);
                dbVar7.b = str;
                dbVar7.c = i;
                arrayList.add(dbVar7);
                return;
            }
            return;
        }
        a(str, i, arrayList, i3);
        dbVar2 = new cn.fly.verify.db(28);
        dbVar2.b = str;
        dbVar2.c = i;
        arrayList.add(dbVar2);
        if (i2 == 0) {
        }
    }

    public cn.fly.verify.dc.a a(java.lang.Object... objArr) {
        cn.fly.verify.dc.a aVar = new cn.fly.verify.dc.a();
        try {
            java.util.LinkedList<java.lang.Object> b = b(objArr);
            if (!b.isEmpty()) {
                aVar.b = b.get(0);
            }
        } catch (java.lang.Throwable th) {
            aVar.a = th;
        }
        return aVar;
    }

    public cn.fly.verify.dc a(cn.fly.verify.cv cvVar, java.lang.String str, int i) {
        if (this.b <= 1) {
            return this;
        }
        java.util.ArrayList<cn.fly.verify.db> arrayList = new java.util.ArrayList<>();
        a(str, i, arrayList, 0);
        return new cn.fly.verify.dc(null, 1, arrayList, new java.util.ArrayList(), 0, arrayList.size(), cvVar);
    }

    public java.util.LinkedList<java.lang.Object> b(java.lang.Object... objArr) throws java.lang.Throwable {
        cn.fly.verify.cv b = this.c.b();
        int i = this.b;
        if (i != 0) {
            if (objArr.length == i) {
                for (int length = objArr.length - 1; length >= 0; length--) {
                    b.a(objArr[length]);
                }
            } else if (objArr.length < i) {
                for (int length2 = objArr.length; length2 < this.b; length2++) {
                    b.a((java.lang.Object) null);
                }
                for (int length3 = objArr.length - 1; length3 >= 0; length3--) {
                    b.a(objArr[length3]);
                }
            } else {
                java.util.ArrayList arrayList = new java.util.ArrayList(0);
                for (int i2 = this.b - 1; i2 < objArr.length; i2++) {
                    arrayList.add(objArr[i2]);
                }
                b.a(arrayList);
                for (int i3 = this.b - 2; i3 >= 0; i3--) {
                    b.a(objArr[i3]);
                }
            }
        }
        java.util.LinkedList<java.lang.Object> linkedList = new java.util.LinkedList<>();
        this.f.a(this.d, this.e, b, linkedList);
        return linkedList;
    }
}
