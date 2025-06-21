package cn.fly.verify;

/* loaded from: classes.dex */
public class cz {
    static final java.util.HashMap<java.lang.String, java.lang.Class<?>> a = new java.util.HashMap<>();
    private final java.util.ArrayList<cn.fly.verify.db> b;
    private final java.util.ArrayList<java.lang.Object> c;

    public cz(java.util.ArrayList<cn.fly.verify.db> arrayList, java.util.ArrayList<java.lang.Object> arrayList2) {
        this.b = arrayList;
        this.c = arrayList2;
    }

    private void a(cn.fly.verify.cv cvVar) {
        cvVar.a("Object", java.lang.Object.class);
        cvVar.a("Class", java.lang.Class.class);
        cvVar.a("Method", java.lang.reflect.Method.class);
        cvVar.a("String", java.lang.String.class);
        cvVar.a("Thread", java.lang.Thread.class);
        cvVar.a(cn.fly.verify.bj.a("008XhjehPffe@gf$hg"), java.lang.Runnable.class);
        cvVar.a(cn.fly.verify.bj.a("006(fkelgiMjg@eg"), java.lang.System.class);
        cvVar.a("File", java.io.File.class);
        cvVar.a("URL", java.net.URL.class);
        cvVar.a("Double", java.lang.Double.class);
        cvVar.a("Float", java.lang.Float.class);
        cvVar.a("Long", java.lang.Long.class);
        cvVar.a("Integer", java.lang.Integer.class);
        cvVar.a(cn.fly.verify.bj.a("005NfkHiYfeek:j"), java.lang.Short.class);
        cvVar.a("Byte", java.lang.Byte.class);
        cvVar.a("Number", java.lang.Number.class);
        cvVar.a(cn.fly.verify.bj.a("009DhlIieLek edjgZek"), java.lang.Character.class);
        cvVar.a("Boolean", java.lang.Boolean.class);
        cvVar.a(cn.fly.verify.bj.a("006EedfeehgfThg"), java.lang.Double.TYPE);
        cvVar.a(cn.fly.verify.bj.a("0053fg@hNfe6ej"), java.lang.Float.TYPE);
        cvVar.a("long", java.lang.Long.TYPE);
        cvVar.a(cn.fly.verify.bj.a("003Oej:fj"), java.lang.Integer.TYPE);
        cvVar.a("short", java.lang.Short.TYPE);
        cvVar.a("byte", java.lang.Byte.TYPE);
        cvVar.a(cn.fly.verify.bj.a("004die,ek"), java.lang.Character.TYPE);
        cvVar.a("boolean", java.lang.Boolean.TYPE);
        cvVar.a("bigInt", java.math.BigInteger.class);
        cvVar.a("BigInteger", java.math.BigInteger.class);
        cvVar.a("bigDec", java.math.BigDecimal.class);
        cvVar.a("BigDecimal", java.math.BigDecimal.class);
        cvVar.a("List", java.util.List.class);
        cvVar.a("Map", java.util.Map.class);
        cvVar.a("Function", cn.fly.verify.dc.class);
        cvVar.a("fun", cn.fly.verify.dc.class);
        cvVar.a("Range", cn.fly.verify.dd.class);
        cvVar.a("Array", java.lang.reflect.Array.class);
        cvVar.a("Suba", cn.fly.verify.da.class);
        cvVar.a("VM", cn.fly.verify.da.class);
        for (java.util.Map.Entry<java.lang.String, java.lang.Class<?>> entry : a.entrySet()) {
            cvVar.a(entry.getKey(), entry.getValue());
        }
    }

    public java.util.ArrayList<cn.fly.verify.db> a() {
        return this.b;
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x001e, code lost:
    
        r0.d = true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(int i, int i2, cn.fly.verify.cv cvVar, java.util.List<java.lang.Object> list) throws java.lang.Throwable {
        java.lang.String sb;
        cn.fly.verify.db.a aVar = new cn.fly.verify.db.a();
        aVar.a = i;
        aVar.b = cvVar;
        aVar.c = list;
        aVar.f = this.b;
        aVar.g = this.c;
        while (true) {
            try {
                if (aVar.a >= i2) {
                    break;
                }
                if (cvVar.f()) {
                    break;
                }
                this.b.get(aVar.a).a(aVar);
                if (aVar.e) {
                    break;
                } else {
                    aVar.a++;
                }
            } catch (java.lang.Throwable th) {
                th = th;
                if (th instanceof cn.fly.verify.cy) {
                    sb = th.getMessage() == null ? th.getClass().getSimpleName() : th.getMessage();
                    th = th.getCause();
                } else {
                    java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
                    sb2.append("Suba Runtime Error: ");
                    sb2.append(th.getMessage() == null ? th.getClass().getSimpleName() : th.getMessage());
                    sb = sb2.toString();
                }
                throw new cn.fly.verify.cy(sb + "\r\n\tat " + this.b.get(aVar.a).b + " (" + this.b.get(aVar.a).c + ")", th);
            }
        }
        if (aVar.d || cvVar.d() <= 0 || list == null) {
            return;
        }
        try {
            list.add(cvVar.a());
        } catch (java.lang.Throwable unused) {
        }
    }

    public void a(java.util.HashMap<java.lang.String, java.lang.Object> hashMap, cn.fly.verify.cx cxVar) throws java.lang.Throwable {
        cn.fly.verify.cv cvVar = new cn.fly.verify.cv(hashMap, cxVar);
        a(cvVar);
        a(0, this.b.size(), cvVar, null);
    }
}
