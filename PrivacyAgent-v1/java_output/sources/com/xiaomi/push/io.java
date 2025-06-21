package com.xiaomi.push;

/* loaded from: classes19.dex */
public final class io extends com.xiaomi.push.ir {
    protected java.io.InputStream a;
    protected java.io.OutputStream b;

    public io() {
        this.a = null;
        this.b = null;
    }

    public io(java.io.OutputStream outputStream) {
        this.a = null;
        this.b = outputStream;
    }

    @Override // com.xiaomi.push.ir
    public final int a(byte[] bArr, int i, int i2) {
        java.io.InputStream inputStream = this.a;
        if (inputStream == null) {
            throw new com.xiaomi.push.is("Cannot read from null inputStream");
        }
        try {
            int read = inputStream.read(bArr, i, i2);
            if (read >= 0) {
                return read;
            }
            throw new com.xiaomi.push.is((byte) 0);
        } catch (java.io.IOException e) {
            throw new com.xiaomi.push.is(e);
        }
    }

    @Override // com.xiaomi.push.ir
    public final void b(byte[] bArr, int i, int i2) {
        java.io.OutputStream outputStream = this.b;
        if (outputStream == null) {
            throw new com.xiaomi.push.is("Cannot write to null outputStream");
        }
        try {
            outputStream.write(bArr, i, i2);
        } catch (java.io.IOException e) {
            throw new com.xiaomi.push.is(e);
        }
    }
}
