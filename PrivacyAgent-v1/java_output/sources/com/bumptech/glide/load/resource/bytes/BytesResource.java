package com.bumptech.glide.load.resource.bytes;

/* loaded from: classes.dex */
public class BytesResource implements com.bumptech.glide.load.engine.Resource<byte[]> {
    private final byte[] bytes;

    public BytesResource(byte[] bArr) {
        this.bytes = (byte[]) com.bumptech.glide.util.Preconditions.checkNotNull(bArr);
    }

    @Override // com.bumptech.glide.load.engine.Resource
    @androidx.annotation.NonNull
    public byte[] get() {
        return this.bytes;
    }

    @Override // com.bumptech.glide.load.engine.Resource
    @androidx.annotation.NonNull
    public java.lang.Class<byte[]> getResourceClass() {
        return byte[].class;
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public int getSize() {
        return this.bytes.length;
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public void recycle() {
    }
}
