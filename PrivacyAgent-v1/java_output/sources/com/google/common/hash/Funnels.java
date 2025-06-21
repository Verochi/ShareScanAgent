package com.google.common.hash;

@com.google.common.annotations.Beta
/* loaded from: classes22.dex */
public final class Funnels {

    public enum ByteArrayFunnel implements com.google.common.hash.Funnel<byte[]> {
        INSTANCE;

        @Override // com.google.common.hash.Funnel
        public void funnel(byte[] bArr, com.google.common.hash.PrimitiveSink primitiveSink) {
            primitiveSink.putBytes(bArr);
        }

        @Override // java.lang.Enum
        public java.lang.String toString() {
            return "Funnels.byteArrayFunnel()";
        }
    }

    public enum IntegerFunnel implements com.google.common.hash.Funnel<java.lang.Integer> {
        INSTANCE;

        @Override // com.google.common.hash.Funnel
        public void funnel(java.lang.Integer num, com.google.common.hash.PrimitiveSink primitiveSink) {
            primitiveSink.putInt(num.intValue());
        }

        @Override // java.lang.Enum
        public java.lang.String toString() {
            return "Funnels.integerFunnel()";
        }
    }

    public enum LongFunnel implements com.google.common.hash.Funnel<java.lang.Long> {
        INSTANCE;

        @Override // com.google.common.hash.Funnel
        public void funnel(java.lang.Long l, com.google.common.hash.PrimitiveSink primitiveSink) {
            primitiveSink.putLong(l.longValue());
        }

        @Override // java.lang.Enum
        public java.lang.String toString() {
            return "Funnels.longFunnel()";
        }
    }

    public static class SequentialFunnel<E> implements com.google.common.hash.Funnel<java.lang.Iterable<? extends E>>, java.io.Serializable {
        private final com.google.common.hash.Funnel<E> elementFunnel;

        public SequentialFunnel(com.google.common.hash.Funnel<E> funnel) {
            this.elementFunnel = (com.google.common.hash.Funnel) com.google.common.base.Preconditions.checkNotNull(funnel);
        }

        public boolean equals(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
            if (obj instanceof com.google.common.hash.Funnels.SequentialFunnel) {
                return this.elementFunnel.equals(((com.google.common.hash.Funnels.SequentialFunnel) obj).elementFunnel);
            }
            return false;
        }

        @Override // com.google.common.hash.Funnel
        public void funnel(java.lang.Iterable<? extends E> iterable, com.google.common.hash.PrimitiveSink primitiveSink) {
            java.util.Iterator<? extends E> it = iterable.iterator();
            while (it.hasNext()) {
                this.elementFunnel.funnel(it.next(), primitiveSink);
            }
        }

        public int hashCode() {
            return com.google.common.hash.Funnels.SequentialFunnel.class.hashCode() ^ this.elementFunnel.hashCode();
        }

        public java.lang.String toString() {
            return "Funnels.sequentialFunnel(" + this.elementFunnel + ")";
        }
    }

    public static class SinkAsStream extends java.io.OutputStream {
        public final com.google.common.hash.PrimitiveSink n;

        public SinkAsStream(com.google.common.hash.PrimitiveSink primitiveSink) {
            this.n = (com.google.common.hash.PrimitiveSink) com.google.common.base.Preconditions.checkNotNull(primitiveSink);
        }

        public java.lang.String toString() {
            return "Funnels.asOutputStream(" + this.n + ")";
        }

        @Override // java.io.OutputStream
        public void write(int i) {
            this.n.putByte((byte) i);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr) {
            this.n.putBytes(bArr);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i, int i2) {
            this.n.putBytes(bArr, i, i2);
        }
    }

    public static class StringCharsetFunnel implements com.google.common.hash.Funnel<java.lang.CharSequence>, java.io.Serializable {
        private final java.nio.charset.Charset charset;

        public static class SerializedForm implements java.io.Serializable {
            private static final long serialVersionUID = 0;
            private final java.lang.String charsetCanonicalName;

            public SerializedForm(java.nio.charset.Charset charset) {
                this.charsetCanonicalName = charset.name();
            }

            private java.lang.Object readResolve() {
                return com.google.common.hash.Funnels.stringFunnel(java.nio.charset.Charset.forName(this.charsetCanonicalName));
            }
        }

        public StringCharsetFunnel(java.nio.charset.Charset charset) {
            this.charset = (java.nio.charset.Charset) com.google.common.base.Preconditions.checkNotNull(charset);
        }

        public boolean equals(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
            if (obj instanceof com.google.common.hash.Funnels.StringCharsetFunnel) {
                return this.charset.equals(((com.google.common.hash.Funnels.StringCharsetFunnel) obj).charset);
            }
            return false;
        }

        @Override // com.google.common.hash.Funnel
        public void funnel(java.lang.CharSequence charSequence, com.google.common.hash.PrimitiveSink primitiveSink) {
            primitiveSink.putString(charSequence, this.charset);
        }

        public int hashCode() {
            return com.google.common.hash.Funnels.StringCharsetFunnel.class.hashCode() ^ this.charset.hashCode();
        }

        public java.lang.String toString() {
            return "Funnels.stringFunnel(" + this.charset.name() + ")";
        }

        public java.lang.Object writeReplace() {
            return new com.google.common.hash.Funnels.StringCharsetFunnel.SerializedForm(this.charset);
        }
    }

    public enum UnencodedCharsFunnel implements com.google.common.hash.Funnel<java.lang.CharSequence> {
        INSTANCE;

        @Override // com.google.common.hash.Funnel
        public void funnel(java.lang.CharSequence charSequence, com.google.common.hash.PrimitiveSink primitiveSink) {
            primitiveSink.putUnencodedChars(charSequence);
        }

        @Override // java.lang.Enum
        public java.lang.String toString() {
            return "Funnels.unencodedCharsFunnel()";
        }
    }

    public static java.io.OutputStream asOutputStream(com.google.common.hash.PrimitiveSink primitiveSink) {
        return new com.google.common.hash.Funnels.SinkAsStream(primitiveSink);
    }

    public static com.google.common.hash.Funnel<byte[]> byteArrayFunnel() {
        return com.google.common.hash.Funnels.ByteArrayFunnel.INSTANCE;
    }

    public static com.google.common.hash.Funnel<java.lang.Integer> integerFunnel() {
        return com.google.common.hash.Funnels.IntegerFunnel.INSTANCE;
    }

    public static com.google.common.hash.Funnel<java.lang.Long> longFunnel() {
        return com.google.common.hash.Funnels.LongFunnel.INSTANCE;
    }

    public static <E> com.google.common.hash.Funnel<java.lang.Iterable<? extends E>> sequentialFunnel(com.google.common.hash.Funnel<E> funnel) {
        return new com.google.common.hash.Funnels.SequentialFunnel(funnel);
    }

    public static com.google.common.hash.Funnel<java.lang.CharSequence> stringFunnel(java.nio.charset.Charset charset) {
        return new com.google.common.hash.Funnels.StringCharsetFunnel(charset);
    }

    public static com.google.common.hash.Funnel<java.lang.CharSequence> unencodedCharsFunnel() {
        return com.google.common.hash.Funnels.UnencodedCharsFunnel.INSTANCE;
    }
}
