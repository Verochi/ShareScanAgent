package cn.fly.verify;

@java.lang.Deprecated
/* loaded from: classes.dex */
public final class av {
    private cn.fly.verify.fb a;

    public av(int i, java.lang.String str, java.lang.String str2) {
        this.a = new cn.fly.verify.fb(i, str, str2);
    }

    public static java.util.HashMap<java.lang.String, java.lang.String> a() throws java.lang.Throwable {
        return cn.fly.verify.fb.a();
    }

    public <T> T a(java.util.HashMap<java.lang.String, java.lang.String> hashMap, java.util.HashMap<java.lang.String, java.lang.Object> hashMap2, java.lang.String str, boolean z) throws java.lang.Throwable {
        return (T) a(true, hashMap, hashMap2, str, z);
    }

    public <T> T a(boolean z, java.util.HashMap<java.lang.String, java.lang.String> hashMap, java.util.HashMap<java.lang.String, java.lang.Object> hashMap2, java.lang.String str, boolean z2) throws java.lang.Throwable {
        return (T) this.a.a(z, hashMap, hashMap2, str, z2);
    }
}
