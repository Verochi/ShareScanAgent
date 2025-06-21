package defpackage;

/* loaded from: classes22.dex */
public final /* synthetic */ class r1 {
    public static /* synthetic */ boolean a(sun.misc.Unsafe unsafe, java.lang.Object obj, long j, java.lang.Object obj2, java.lang.Object obj3) {
        while (!unsafe.compareAndSwapObject(obj, j, obj2, obj3)) {
            if (unsafe.getObject(obj, j) != obj2) {
                return false;
            }
        }
        return true;
    }
}
