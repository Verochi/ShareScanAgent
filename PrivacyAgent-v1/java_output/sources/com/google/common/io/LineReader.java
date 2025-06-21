package com.google.common.io;

@com.google.common.annotations.Beta
@com.google.common.annotations.GwtIncompatible
/* loaded from: classes22.dex */
public final class LineReader {
    public final java.lang.Readable a;

    @org.checkerframework.checker.nullness.compatqual.NullableDecl
    public final java.io.Reader b;
    public final java.nio.CharBuffer c;
    public final char[] d;
    public final java.util.Queue<java.lang.String> e;
    public final com.google.common.io.LineBuffer f;

    /* renamed from: com.google.common.io.LineReader$1, reason: invalid class name */
    public class AnonymousClass1 extends com.google.common.io.LineBuffer {
        public AnonymousClass1() {
        }

        @Override // com.google.common.io.LineBuffer
        public void d(java.lang.String str, java.lang.String str2) {
            com.google.common.io.LineReader.this.e.add(str);
        }
    }

    public LineReader(java.lang.Readable readable) {
        java.nio.CharBuffer c = com.google.common.io.CharStreams.c();
        this.c = c;
        this.d = c.array();
        this.e = new java.util.LinkedList();
        this.f = new com.google.common.io.LineReader.AnonymousClass1();
        this.a = (java.lang.Readable) com.google.common.base.Preconditions.checkNotNull(readable);
        this.b = readable instanceof java.io.Reader ? (java.io.Reader) readable : null;
    }

    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public java.lang.String readLine() throws java.io.IOException {
        int read;
        while (true) {
            if (this.e.peek() != null) {
                break;
            }
            this.c.clear();
            java.io.Reader reader = this.b;
            if (reader != null) {
                char[] cArr = this.d;
                read = reader.read(cArr, 0, cArr.length);
            } else {
                read = this.a.read(this.c);
            }
            if (read == -1) {
                this.f.b();
                break;
            }
            this.f.a(this.d, 0, read);
        }
        return this.e.poll();
    }
}
