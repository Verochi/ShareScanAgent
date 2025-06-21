package cn.fly.verify;

/* loaded from: classes.dex */
public class cq {
    public cn.fly.verify.cq.a a;

    public interface a {
        java.lang.Object a(java.lang.String str, java.util.ArrayList<java.lang.Object> arrayList);
    }

    public cq(cn.fly.verify.cq.a aVar) {
        this.a = aVar;
    }

    public java.lang.Object a(java.lang.String str, java.util.ArrayList<java.lang.Object> arrayList) {
        cn.fly.verify.cq.a aVar = this.a;
        if (aVar == null) {
            return null;
        }
        return aVar.a(str, arrayList);
    }
}
