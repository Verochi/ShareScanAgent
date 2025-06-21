package cn.fly.verify;

/* loaded from: classes.dex */
public class am {
    public static volatile java.lang.String a;
    public static java.util.concurrent.ExecutorService b = java.util.concurrent.Executors.newSingleThreadExecutor();

    public static java.lang.String a() {
        if (android.text.TextUtils.isEmpty(a)) {
            a = cn.fly.verify.bn.a(new cn.fly.verify.be());
        }
        return a;
    }
}
