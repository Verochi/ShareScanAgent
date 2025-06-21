package defpackage;

/* loaded from: classes25.dex */
public final /* synthetic */ class sg3 {
    public static /* synthetic */ int a(double d) {
        long doubleToLongBits = java.lang.Double.doubleToLongBits(d);
        return (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
    }
}
