package kotlin.io;

@kotlin.Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0012*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\t\u0010\u0003\u001a\u00020\u0002H\u0096\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0002R\"\u0010\u0005\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0015\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\"\u0010\u0019\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0010\u001a\u0004\b\u0017\u0010\u0012\"\u0004\b\u0018\u0010\u0014¨\u0006\u001a"}, d2 = {"kotlin/io/ByteStreamsKt$iterator$1", "Lkotlin/collections/ByteIterator;", "", "hasNext", "", "nextByte", "", "a", "", com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.AD_COUNT, "I", "getNextByte", "()I", "setNextByte", "(I)V", "t", "Z", "getNextPrepared", "()Z", "setNextPrepared", "(Z)V", "nextPrepared", com.umeng.analytics.pro.bo.aN, "getFinished", "setFinished", "finished", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class ByteStreamsKt$iterator$1 extends kotlin.collections.ByteIterator {

    /* renamed from: n, reason: from kotlin metadata */
    public int nextByte = -1;

    /* renamed from: t, reason: from kotlin metadata */
    public boolean nextPrepared;

    /* renamed from: u, reason: from kotlin metadata */
    public boolean finished;
    public final /* synthetic */ java.io.BufferedInputStream v;

    public ByteStreamsKt$iterator$1(java.io.BufferedInputStream bufferedInputStream) {
        this.v = bufferedInputStream;
    }

    public final void a() {
        if (this.nextPrepared || this.finished) {
            return;
        }
        int read = this.v.read();
        this.nextByte = read;
        this.nextPrepared = true;
        this.finished = read == -1;
    }

    public final boolean getFinished() {
        return this.finished;
    }

    public final int getNextByte() {
        return this.nextByte;
    }

    public final boolean getNextPrepared() {
        return this.nextPrepared;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        a();
        return !this.finished;
    }

    @Override // kotlin.collections.ByteIterator
    public byte nextByte() {
        a();
        if (this.finished) {
            throw new java.util.NoSuchElementException("Input stream is over.");
        }
        byte b = (byte) this.nextByte;
        this.nextPrepared = false;
        return b;
    }

    public final void setFinished(boolean z) {
        this.finished = z;
    }

    public final void setNextByte(int i) {
        this.nextByte = i;
    }

    public final void setNextPrepared(boolean z) {
        this.nextPrepared = z;
    }
}
