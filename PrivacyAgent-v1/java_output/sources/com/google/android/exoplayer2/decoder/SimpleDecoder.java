package com.google.android.exoplayer2.decoder;

/* loaded from: classes22.dex */
public abstract class SimpleDecoder<I extends com.google.android.exoplayer2.decoder.DecoderInputBuffer, O extends com.google.android.exoplayer2.decoder.OutputBuffer, E extends com.google.android.exoplayer2.decoder.DecoderException> implements com.google.android.exoplayer2.decoder.Decoder<I, O, E> {
    public final java.lang.Thread a;
    public final java.lang.Object b = new java.lang.Object();
    public final java.util.ArrayDeque<I> c = new java.util.ArrayDeque<>();
    public final java.util.ArrayDeque<O> d = new java.util.ArrayDeque<>();
    public final I[] e;
    public final O[] f;
    public int g;
    public int h;
    public I i;
    public E j;
    public boolean k;
    public boolean l;
    public int m;

    /* renamed from: com.google.android.exoplayer2.decoder.SimpleDecoder$1, reason: invalid class name */
    public class AnonymousClass1 extends java.lang.Thread {
        public AnonymousClass1(java.lang.String str) {
            super(str);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            com.google.android.exoplayer2.decoder.SimpleDecoder.this.h();
        }
    }

    public SimpleDecoder(I[] iArr, O[] oArr) {
        this.e = iArr;
        this.g = iArr.length;
        for (int i = 0; i < this.g; i++) {
            this.e[i] = createInputBuffer();
        }
        this.f = oArr;
        this.h = oArr.length;
        for (int i2 = 0; i2 < this.h; i2++) {
            this.f[i2] = createOutputBuffer();
        }
        com.google.android.exoplayer2.decoder.SimpleDecoder.AnonymousClass1 anonymousClass1 = new com.google.android.exoplayer2.decoder.SimpleDecoder.AnonymousClass1("ExoPlayer:SimpleDecoder");
        this.a = anonymousClass1;
        anonymousClass1.start();
    }

    public final boolean b() {
        return !this.c.isEmpty() && this.h > 0;
    }

    public final boolean c() throws java.lang.InterruptedException {
        E createUnexpectedDecodeException;
        synchronized (this.b) {
            while (!this.l && !b()) {
                this.b.wait();
            }
            if (this.l) {
                return false;
            }
            I removeFirst = this.c.removeFirst();
            O[] oArr = this.f;
            int i = this.h - 1;
            this.h = i;
            O o = oArr[i];
            boolean z = this.k;
            this.k = false;
            if (removeFirst.isEndOfStream()) {
                o.addFlag(4);
            } else {
                if (removeFirst.isDecodeOnly()) {
                    o.addFlag(Integer.MIN_VALUE);
                }
                try {
                    createUnexpectedDecodeException = decode(removeFirst, o, z);
                } catch (java.lang.OutOfMemoryError e) {
                    createUnexpectedDecodeException = createUnexpectedDecodeException(e);
                } catch (java.lang.RuntimeException e2) {
                    createUnexpectedDecodeException = createUnexpectedDecodeException(e2);
                }
                if (createUnexpectedDecodeException != null) {
                    synchronized (this.b) {
                        this.j = createUnexpectedDecodeException;
                    }
                    return false;
                }
            }
            synchronized (this.b) {
                if (this.k) {
                    o.release();
                } else if (o.isDecodeOnly()) {
                    this.m++;
                    o.release();
                } else {
                    o.skippedOutputBufferCount = this.m;
                    this.m = 0;
                    this.d.addLast(o);
                }
                f(removeFirst);
            }
            return true;
        }
    }

    public abstract I createInputBuffer();

    public abstract O createOutputBuffer();

    public abstract E createUnexpectedDecodeException(java.lang.Throwable th);

    public final void d() {
        if (b()) {
            this.b.notify();
        }
    }

    @androidx.annotation.Nullable
    public abstract E decode(I i, O o, boolean z);

    @Override // com.google.android.exoplayer2.decoder.Decoder
    @androidx.annotation.Nullable
    public final I dequeueInputBuffer() throws com.google.android.exoplayer2.decoder.DecoderException {
        I i;
        synchronized (this.b) {
            e();
            com.google.android.exoplayer2.util.Assertions.checkState(this.i == null);
            int i2 = this.g;
            if (i2 == 0) {
                i = null;
            } else {
                I[] iArr = this.e;
                int i3 = i2 - 1;
                this.g = i3;
                i = iArr[i3];
            }
            this.i = i;
        }
        return i;
    }

    @Override // com.google.android.exoplayer2.decoder.Decoder
    @androidx.annotation.Nullable
    public final O dequeueOutputBuffer() throws com.google.android.exoplayer2.decoder.DecoderException {
        synchronized (this.b) {
            e();
            if (this.d.isEmpty()) {
                return null;
            }
            return this.d.removeFirst();
        }
    }

    public final void e() throws com.google.android.exoplayer2.decoder.DecoderException {
        E e = this.j;
        if (e != null) {
            throw e;
        }
    }

    public final void f(I i) {
        i.clear();
        I[] iArr = this.e;
        int i2 = this.g;
        this.g = i2 + 1;
        iArr[i2] = i;
    }

    @Override // com.google.android.exoplayer2.decoder.Decoder
    public final void flush() {
        synchronized (this.b) {
            this.k = true;
            this.m = 0;
            I i = this.i;
            if (i != null) {
                f(i);
                this.i = null;
            }
            while (!this.c.isEmpty()) {
                f(this.c.removeFirst());
            }
            while (!this.d.isEmpty()) {
                this.d.removeFirst().release();
            }
        }
    }

    public final void g(O o) {
        o.clear();
        O[] oArr = this.f;
        int i = this.h;
        this.h = i + 1;
        oArr[i] = o;
    }

    public final void h() {
        do {
            try {
            } catch (java.lang.InterruptedException e) {
                throw new java.lang.IllegalStateException(e);
            }
        } while (c());
    }

    @Override // com.google.android.exoplayer2.decoder.Decoder
    public final void queueInputBuffer(I i) throws com.google.android.exoplayer2.decoder.DecoderException {
        synchronized (this.b) {
            e();
            com.google.android.exoplayer2.util.Assertions.checkArgument(i == this.i);
            this.c.addLast(i);
            d();
            this.i = null;
        }
    }

    @Override // com.google.android.exoplayer2.decoder.Decoder
    @androidx.annotation.CallSuper
    public void release() {
        synchronized (this.b) {
            this.l = true;
            this.b.notify();
        }
        try {
            this.a.join();
        } catch (java.lang.InterruptedException unused) {
            java.lang.Thread.currentThread().interrupt();
        }
    }

    @androidx.annotation.CallSuper
    public void releaseOutputBuffer(O o) {
        synchronized (this.b) {
            g(o);
            d();
        }
    }

    public final void setInitialInputBufferSize(int i) {
        com.google.android.exoplayer2.util.Assertions.checkState(this.g == this.e.length);
        for (I i2 : this.e) {
            i2.ensureSpaceForWrite(i);
        }
    }
}
