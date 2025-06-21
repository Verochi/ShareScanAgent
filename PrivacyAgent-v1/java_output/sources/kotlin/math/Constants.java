package kotlin.math;

@kotlin.Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0006\n\u0002\b\u0010\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0005\u001a\u00020\u00028\u0000X\u0081\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0000X\u0081\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00028\u0000X\u0081\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0014\u0010\u000b\u001a\u00020\u00028\u0000X\u0081\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u0004R\u0014\u0010\r\u001a\u00020\u00028\u0000X\u0081\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u0004R\u0014\u0010\u000f\u001a\u00020\u00028\u0000X\u0081\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u0004¨\u0006\u0012"}, d2 = {"Lkotlin/math/Constants;", "", "", "b", "D", "LN2", "c", "epsilon", "d", "taylor_2_bound", "e", "taylor_n_bound", "f", "upper_taylor_2_bound", "g", "upper_taylor_n_bound", "<init>", "()V", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
final class Constants {

    @org.jetbrains.annotations.NotNull
    public static final kotlin.math.Constants a = new kotlin.math.Constants();

    /* renamed from: b, reason: from kotlin metadata */
    @kotlin.jvm.JvmField
    public static final double LN2 = java.lang.Math.log(2.0d);

    /* renamed from: c, reason: from kotlin metadata */
    @kotlin.jvm.JvmField
    public static final double epsilon;

    /* renamed from: d, reason: from kotlin metadata */
    @kotlin.jvm.JvmField
    public static final double taylor_2_bound;

    /* renamed from: e, reason: from kotlin metadata */
    @kotlin.jvm.JvmField
    public static final double taylor_n_bound;

    /* renamed from: f, reason: from kotlin metadata */
    @kotlin.jvm.JvmField
    public static final double upper_taylor_2_bound;

    /* renamed from: g, reason: from kotlin metadata */
    @kotlin.jvm.JvmField
    public static final double upper_taylor_n_bound;

    static {
        double ulp = java.lang.Math.ulp(1.0d);
        epsilon = ulp;
        double sqrt = java.lang.Math.sqrt(ulp);
        taylor_2_bound = sqrt;
        double sqrt2 = java.lang.Math.sqrt(sqrt);
        taylor_n_bound = sqrt2;
        double d = 1;
        upper_taylor_2_bound = d / sqrt;
        upper_taylor_n_bound = d / sqrt2;
    }
}
