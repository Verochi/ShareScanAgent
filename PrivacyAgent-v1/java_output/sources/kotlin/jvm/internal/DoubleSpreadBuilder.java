package kotlin.jvm.internal;

@kotlin.Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0013\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\f\u0010\u0004\u001a\u00020\u0003*\u00020\u0002H\u0014J\u000e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005J\u0006\u0010\t\u001a\u00020\u0002R\u0014\u0010\f\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\u0010"}, d2 = {"Lkotlin/jvm/internal/DoubleSpreadBuilder;", "Lkotlin/jvm/internal/PrimitiveSpreadBuilder;", "", "", "getSize", "", "value", "", com.anythink.expressad.d.a.b.ay, "toArray", "d", "[D", "values", com.anythink.core.api.ATAdConst.NETWORK_REQUEST_PARAMS_KEY.BANNER_SIZE, "<init>", "(I)V", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class DoubleSpreadBuilder extends kotlin.jvm.internal.PrimitiveSpreadBuilder<double[]> {

    /* renamed from: d, reason: from kotlin metadata */
    @org.jetbrains.annotations.NotNull
    public final double[] values;

    public DoubleSpreadBuilder(int i) {
        super(i);
        this.values = new double[i];
    }

    public final void add(double value) {
        double[] dArr = this.values;
        int i = getCom.alibaba.sdk.android.oss.common.RequestParameters.POSITION java.lang.String();
        setPosition(i + 1);
        dArr[i] = value;
    }

    @Override // kotlin.jvm.internal.PrimitiveSpreadBuilder
    public int getSize(@org.jetbrains.annotations.NotNull double[] dArr) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(dArr, "<this>");
        return dArr.length;
    }

    @org.jetbrains.annotations.NotNull
    public final double[] toArray() {
        return toArray(this.values, new double[size()]);
    }
}
