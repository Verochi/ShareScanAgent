package kotlin.io;

@kotlin.Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u0019\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b*\u0010+J\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0002J\b\u0010\f\u001a\u00020\nH\u0002J\u0018\u0010\u000f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\nH\u0002J\u0010\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0012\u001a\u00020\u0010H\u0002J\b\u0010\u0013\u001a\u00020\u0010H\u0002R\u0016\u0010\u0016\u001a\u00020\u00148\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\f\u0010\u0015R\u0016\u0010\u0018\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\u0017R\u0014\u0010\u001b\u001a\u00020\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u001aR\u0014\u0010\u001e\u001a\u00020\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u001dR\u0014\u0010!\u001a\u00020\u001f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010 R\u0014\u0010$\u001a\u00020\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010#R\u0018\u0010)\u001a\u00060%j\u0002`&8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010(¨\u0006,"}, d2 = {"Lkotlin/io/LineReader;", "", "Ljava/io/InputStream;", "inputStream", "Ljava/nio/charset/Charset;", "charset", "", "readLine", "", "endOfInput", "", "b", "a", "nBytes", "nChars", "c", "", "f", "d", "e", "Ljava/nio/charset/CharsetDecoder;", "Ljava/nio/charset/CharsetDecoder;", "decoder", "Z", "directEOL", "", "[B", "bytes", "", "[C", "chars", "Ljava/nio/ByteBuffer;", "Ljava/nio/ByteBuffer;", "byteBuf", "Ljava/nio/CharBuffer;", "Ljava/nio/CharBuffer;", "charBuf", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "g", "Ljava/lang/StringBuilder;", "sb", "<init>", "()V", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class LineReader {

    @org.jetbrains.annotations.NotNull
    public static final kotlin.io.LineReader INSTANCE = new kotlin.io.LineReader();

    /* renamed from: a, reason: from kotlin metadata */
    public static java.nio.charset.CharsetDecoder decoder;

    /* renamed from: b, reason: from kotlin metadata */
    public static boolean directEOL;

    /* renamed from: c, reason: from kotlin metadata */
    @org.jetbrains.annotations.NotNull
    public static final byte[] bytes;

    /* renamed from: d, reason: from kotlin metadata */
    @org.jetbrains.annotations.NotNull
    public static final char[] chars;

    /* renamed from: e, reason: from kotlin metadata */
    @org.jetbrains.annotations.NotNull
    public static final java.nio.ByteBuffer byteBuf;

    /* renamed from: f, reason: from kotlin metadata */
    @org.jetbrains.annotations.NotNull
    public static final java.nio.CharBuffer charBuf;

    /* renamed from: g, reason: from kotlin metadata */
    @org.jetbrains.annotations.NotNull
    public static final java.lang.StringBuilder sb;

    static {
        byte[] bArr = new byte[32];
        bytes = bArr;
        char[] cArr = new char[32];
        chars = cArr;
        java.nio.ByteBuffer wrap = java.nio.ByteBuffer.wrap(bArr);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(wrap, "wrap(bytes)");
        byteBuf = wrap;
        java.nio.CharBuffer wrap2 = java.nio.CharBuffer.wrap(cArr);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(wrap2, "wrap(chars)");
        charBuf = wrap2;
        sb = new java.lang.StringBuilder();
    }

    public final int a() {
        java.nio.ByteBuffer byteBuffer = byteBuf;
        byteBuffer.compact();
        int position = byteBuffer.position();
        byteBuffer.position(0);
        return position;
    }

    public final int b(boolean endOfInput) {
        while (true) {
            java.nio.charset.CharsetDecoder charsetDecoder = decoder;
            if (charsetDecoder == null) {
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("decoder");
                charsetDecoder = null;
            }
            java.nio.ByteBuffer byteBuffer = byteBuf;
            java.nio.CharBuffer charBuffer = charBuf;
            java.nio.charset.CoderResult decode = charsetDecoder.decode(byteBuffer, charBuffer, endOfInput);
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(decode, "decoder.decode(byteBuf, charBuf, endOfInput)");
            if (decode.isError()) {
                d();
                decode.throwException();
            }
            int position = charBuffer.position();
            if (!decode.isOverflow()) {
                return position;
            }
            java.lang.StringBuilder sb2 = sb;
            char[] cArr = chars;
            int i = position - 1;
            sb2.append(cArr, 0, i);
            charBuffer.position(0);
            charBuffer.limit(32);
            charBuffer.put(cArr[i]);
        }
    }

    public final int c(int nBytes, int nChars) {
        java.nio.ByteBuffer byteBuffer = byteBuf;
        byteBuffer.limit(nBytes);
        charBuf.position(nChars);
        int b = b(true);
        java.nio.charset.CharsetDecoder charsetDecoder = decoder;
        if (charsetDecoder == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("decoder");
            charsetDecoder = null;
        }
        charsetDecoder.reset();
        byteBuffer.position(0);
        return b;
    }

    public final void d() {
        java.nio.charset.CharsetDecoder charsetDecoder = decoder;
        if (charsetDecoder == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("decoder");
            charsetDecoder = null;
        }
        charsetDecoder.reset();
        byteBuf.position(0);
        sb.setLength(0);
    }

    public final void e() {
        java.lang.StringBuilder sb2 = sb;
        sb2.setLength(32);
        sb2.trimToSize();
    }

    public final void f(java.nio.charset.Charset charset) {
        java.nio.charset.CharsetDecoder newDecoder = charset.newDecoder();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(newDecoder, "charset.newDecoder()");
        decoder = newDecoder;
        java.nio.ByteBuffer byteBuffer = byteBuf;
        byteBuffer.clear();
        java.nio.CharBuffer charBuffer = charBuf;
        charBuffer.clear();
        byteBuffer.put((byte) 10);
        byteBuffer.flip();
        java.nio.charset.CharsetDecoder charsetDecoder = decoder;
        if (charsetDecoder == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("decoder");
            charsetDecoder = null;
        }
        boolean z = false;
        charsetDecoder.decode(byteBuffer, charBuffer, false);
        if (charBuffer.position() == 1 && charBuffer.get(0) == '\n') {
            z = true;
        }
        directEOL = z;
        d();
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0020, code lost:
    
        if (kotlin.jvm.internal.Intrinsics.areEqual(r0.charset(), r12) == false) goto L9;
     */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final synchronized java.lang.String readLine(@org.jetbrains.annotations.NotNull java.io.InputStream inputStream, @org.jetbrains.annotations.NotNull java.nio.charset.Charset charset) {
        boolean z;
        int c;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(inputStream, "inputStream");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(charset, "charset");
        java.nio.charset.CharsetDecoder charsetDecoder = decoder;
        if (charsetDecoder != null) {
            if (charsetDecoder == null) {
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("decoder");
                charsetDecoder = null;
            }
        }
        f(charset);
        int i = 0;
        int i2 = 0;
        while (true) {
            int read = inputStream.read();
            z = true;
            if (read != -1) {
                int i3 = i + 1;
                bytes[i] = (byte) read;
                if (read != 10 && i3 != 32 && directEOL) {
                    i = i3;
                }
                java.nio.ByteBuffer byteBuffer = byteBuf;
                byteBuffer.limit(i3);
                charBuf.position(i2);
                i2 = b(false);
                if (i2 > 0 && chars[i2 - 1] == '\n') {
                    byteBuffer.position(0);
                    c = i2;
                    break;
                }
                i = a();
            } else {
                if ((sb.length() == 0) && i == 0 && i2 == 0) {
                    return null;
                }
                c = c(i, i2);
            }
        }
        if (c > 0) {
            char[] cArr = chars;
            if (cArr[c - 1] == '\n' && c - 1 > 0 && cArr[c - 1] == '\r') {
                c--;
            }
        }
        java.lang.StringBuilder sb2 = sb;
        if (sb2.length() != 0) {
            z = false;
        }
        if (z) {
            return new java.lang.String(chars, 0, c);
        }
        sb2.append(chars, 0, c);
        java.lang.String sb3 = sb2.toString();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(sb3, "sb.toString()");
        if (sb2.length() > 32) {
            e();
        }
        sb2.setLength(0);
        return sb3;
    }
}
