package kotlin.time;

@kotlin.SinceKotlin(version = "1.3")
@kotlin.Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0003\u001a\u00020\u0002H\u0014J\u001b\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0086\u0002ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\bJ\u001a\u0010\n\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002ø\u0001\u0000¢\u0006\u0004\b\n\u0010\bR\u0016\u0010\r\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\f\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0010"}, d2 = {"Lkotlin/time/TestTimeSource;", "Lkotlin/time/AbstractLongTimeSource;", "", "read", "Lkotlin/time/Duration;", "duration", "", "plusAssign-LRDsOJo", "(J)V", "plusAssign", "a", "b", "J", "reading", "<init>", "()V", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1})
@kotlin.time.ExperimentalTime
/* loaded from: classes14.dex */
public final class TestTimeSource extends kotlin.time.AbstractLongTimeSource {

    /* renamed from: b, reason: from kotlin metadata */
    public long reading;

    public TestTimeSource() {
        super(kotlin.time.DurationUnit.NANOSECONDS);
    }

    public final void a(long duration) {
        throw new java.lang.IllegalStateException("TestTimeSource will overflow if its reading " + this.reading + "ns is advanced by " + ((java.lang.Object) kotlin.time.Duration.m674toStringimpl(duration)) + '.');
    }

    /* renamed from: plusAssign-LRDsOJo, reason: not valid java name */
    public final void m733plusAssignLRDsOJo(long duration) {
        long j;
        long m671toLongimpl = kotlin.time.Duration.m671toLongimpl(duration, getUnit());
        if (m671toLongimpl == Long.MIN_VALUE || m671toLongimpl == Long.MAX_VALUE) {
            double m668toDoubleimpl = this.reading + kotlin.time.Duration.m668toDoubleimpl(duration, getUnit());
            if (m668toDoubleimpl > 9.223372036854776E18d || m668toDoubleimpl < -9.223372036854776E18d) {
                a(duration);
            }
            j = (long) m668toDoubleimpl;
        } else {
            long j2 = this.reading;
            j = j2 + m671toLongimpl;
            if ((m671toLongimpl ^ j2) >= 0 && (j2 ^ j) < 0) {
                a(duration);
            }
        }
        this.reading = j;
    }

    @Override // kotlin.time.AbstractLongTimeSource
    /* renamed from: read, reason: from getter */
    public long getReading() {
        return this.reading;
    }
}
