package cn.fly.verify;

/* loaded from: classes.dex */
public abstract class b implements java.io.Serializable {
    protected cn.fly.verify.fl g = new cn.fly.verify.fl();
    protected java.util.HashMap<java.lang.String, java.lang.Object> h = new java.util.HashMap<>();

    public cn.fly.verify.b b(java.lang.String str) {
        if (!android.text.TextUtils.isEmpty(str)) {
            try {
                this.h = this.g.a(str);
            } catch (java.lang.Throwable th) {
                cn.fly.verify.f.a().a(th, "[FlyVerify] ==>%s", "Entity analyse exception.");
            }
        }
        return this;
    }
}
