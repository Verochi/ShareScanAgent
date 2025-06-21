package kotlin.io;

@kotlin.Metadata(d1 = {"\u0000\u0015\n\u0000\n\u0002\u0010(\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0002\b\t*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\t\u0010\u0004\u001a\u00020\u0003H\u0096\u0002J\t\u0010\u0005\u001a\u00020\u0002H\u0096\u0002R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0016\u0010\u000b\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\f"}, d2 = {"kotlin/io/LinesSequence$iterator$1", "", "", "", "hasNext", "next", com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.AD_COUNT, "Ljava/lang/String;", "nextValue", "t", "Z", "done", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class LinesSequence$iterator$1 implements java.util.Iterator<java.lang.String>, kotlin.jvm.internal.markers.KMappedMarker {

    /* renamed from: n, reason: from kotlin metadata */
    @org.jetbrains.annotations.Nullable
    public java.lang.String nextValue;

    /* renamed from: t, reason: from kotlin metadata */
    public boolean done;
    public final /* synthetic */ kotlin.io.LinesSequence u;

    public LinesSequence$iterator$1(kotlin.io.LinesSequence linesSequence) {
        this.u = linesSequence;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        java.io.BufferedReader bufferedReader;
        if (this.nextValue == null && !this.done) {
            bufferedReader = this.u.reader;
            java.lang.String readLine = bufferedReader.readLine();
            this.nextValue = readLine;
            if (readLine == null) {
                this.done = true;
            }
        }
        return this.nextValue != null;
    }

    @Override // java.util.Iterator
    @org.jetbrains.annotations.NotNull
    public java.lang.String next() {
        if (!hasNext()) {
            throw new java.util.NoSuchElementException();
        }
        java.lang.String str = this.nextValue;
        this.nextValue = null;
        kotlin.jvm.internal.Intrinsics.checkNotNull(str);
        return str;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new java.lang.UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
