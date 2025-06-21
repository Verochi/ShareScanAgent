package com.google.common.hash;

@com.google.errorprone.annotations.Immutable
/* loaded from: classes22.dex */
abstract class AbstractCompositeHashFunction extends com.google.common.hash.AbstractHashFunction {
    private static final long serialVersionUID = 0;
    public final com.google.common.hash.HashFunction[] n;

    /* renamed from: com.google.common.hash.AbstractCompositeHashFunction$1, reason: invalid class name */
    public class AnonymousClass1 implements com.google.common.hash.Hasher {
        public final /* synthetic */ com.google.common.hash.Hasher[] a;

        public AnonymousClass1(com.google.common.hash.Hasher[] hasherArr) {
            this.a = hasherArr;
        }

        @Override // com.google.common.hash.Hasher
        public com.google.common.hash.HashCode hash() {
            return com.google.common.hash.AbstractCompositeHashFunction.this.b(this.a);
        }

        @Override // com.google.common.hash.PrimitiveSink
        public com.google.common.hash.Hasher putBoolean(boolean z) {
            for (com.google.common.hash.Hasher hasher : this.a) {
                hasher.putBoolean(z);
            }
            return this;
        }

        @Override // com.google.common.hash.PrimitiveSink
        public com.google.common.hash.Hasher putByte(byte b) {
            for (com.google.common.hash.Hasher hasher : this.a) {
                hasher.putByte(b);
            }
            return this;
        }

        @Override // com.google.common.hash.PrimitiveSink
        public com.google.common.hash.Hasher putBytes(java.nio.ByteBuffer byteBuffer) {
            int position = byteBuffer.position();
            for (com.google.common.hash.Hasher hasher : this.a) {
                byteBuffer.position(position);
                hasher.putBytes(byteBuffer);
            }
            return this;
        }

        @Override // com.google.common.hash.PrimitiveSink
        public com.google.common.hash.Hasher putBytes(byte[] bArr) {
            for (com.google.common.hash.Hasher hasher : this.a) {
                hasher.putBytes(bArr);
            }
            return this;
        }

        @Override // com.google.common.hash.PrimitiveSink
        public com.google.common.hash.Hasher putBytes(byte[] bArr, int i, int i2) {
            for (com.google.common.hash.Hasher hasher : this.a) {
                hasher.putBytes(bArr, i, i2);
            }
            return this;
        }

        @Override // com.google.common.hash.PrimitiveSink
        public com.google.common.hash.Hasher putChar(char c) {
            for (com.google.common.hash.Hasher hasher : this.a) {
                hasher.putChar(c);
            }
            return this;
        }

        @Override // com.google.common.hash.PrimitiveSink
        public com.google.common.hash.Hasher putDouble(double d) {
            for (com.google.common.hash.Hasher hasher : this.a) {
                hasher.putDouble(d);
            }
            return this;
        }

        @Override // com.google.common.hash.PrimitiveSink
        public com.google.common.hash.Hasher putFloat(float f) {
            for (com.google.common.hash.Hasher hasher : this.a) {
                hasher.putFloat(f);
            }
            return this;
        }

        @Override // com.google.common.hash.PrimitiveSink
        public com.google.common.hash.Hasher putInt(int i) {
            for (com.google.common.hash.Hasher hasher : this.a) {
                hasher.putInt(i);
            }
            return this;
        }

        @Override // com.google.common.hash.PrimitiveSink
        public com.google.common.hash.Hasher putLong(long j) {
            for (com.google.common.hash.Hasher hasher : this.a) {
                hasher.putLong(j);
            }
            return this;
        }

        @Override // com.google.common.hash.Hasher
        public <T> com.google.common.hash.Hasher putObject(T t, com.google.common.hash.Funnel<? super T> funnel) {
            for (com.google.common.hash.Hasher hasher : this.a) {
                hasher.putObject(t, funnel);
            }
            return this;
        }

        @Override // com.google.common.hash.PrimitiveSink
        public com.google.common.hash.Hasher putShort(short s2) {
            for (com.google.common.hash.Hasher hasher : this.a) {
                hasher.putShort(s2);
            }
            return this;
        }

        @Override // com.google.common.hash.PrimitiveSink
        public com.google.common.hash.Hasher putString(java.lang.CharSequence charSequence, java.nio.charset.Charset charset) {
            for (com.google.common.hash.Hasher hasher : this.a) {
                hasher.putString(charSequence, charset);
            }
            return this;
        }

        @Override // com.google.common.hash.PrimitiveSink
        public com.google.common.hash.Hasher putUnencodedChars(java.lang.CharSequence charSequence) {
            for (com.google.common.hash.Hasher hasher : this.a) {
                hasher.putUnencodedChars(charSequence);
            }
            return this;
        }
    }

    public AbstractCompositeHashFunction(com.google.common.hash.HashFunction... hashFunctionArr) {
        for (com.google.common.hash.HashFunction hashFunction : hashFunctionArr) {
            com.google.common.base.Preconditions.checkNotNull(hashFunction);
        }
        this.n = hashFunctionArr;
    }

    public final com.google.common.hash.Hasher a(com.google.common.hash.Hasher[] hasherArr) {
        return new com.google.common.hash.AbstractCompositeHashFunction.AnonymousClass1(hasherArr);
    }

    public abstract com.google.common.hash.HashCode b(com.google.common.hash.Hasher[] hasherArr);

    @Override // com.google.common.hash.HashFunction
    public com.google.common.hash.Hasher newHasher() {
        int length = this.n.length;
        com.google.common.hash.Hasher[] hasherArr = new com.google.common.hash.Hasher[length];
        for (int i = 0; i < length; i++) {
            hasherArr[i] = this.n[i].newHasher();
        }
        return a(hasherArr);
    }

    @Override // com.google.common.hash.AbstractHashFunction, com.google.common.hash.HashFunction
    public com.google.common.hash.Hasher newHasher(int i) {
        com.google.common.base.Preconditions.checkArgument(i >= 0);
        int length = this.n.length;
        com.google.common.hash.Hasher[] hasherArr = new com.google.common.hash.Hasher[length];
        for (int i2 = 0; i2 < length; i2++) {
            hasherArr[i2] = this.n[i2].newHasher(i);
        }
        return a(hasherArr);
    }
}
