package moji.com.service_loader_lib;

/* loaded from: classes20.dex */
public class MJServiceLoader {
    public static <T> java.util.Set<T> getAllImpl(java.lang.Class cls) {
        return (java.util.Set) moji.com.service_loader_lib.MJServiceImplPool.a.get(cls);
    }
}
