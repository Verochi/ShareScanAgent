package com.alimm.tanx.ui.image.glide.load.data;

/* loaded from: classes.dex */
public class ByteArrayFetcher implements com.alimm.tanx.ui.image.glide.load.data.DataFetcher<java.io.InputStream> {
    private final byte[] bytes;
    private final java.lang.String id;

    public ByteArrayFetcher(byte[] bArr, java.lang.String str) {
        this.bytes = bArr;
        this.id = str;
    }

    @Override // com.alimm.tanx.ui.image.glide.load.data.DataFetcher
    public void cancel() {
    }

    @Override // com.alimm.tanx.ui.image.glide.load.data.DataFetcher
    public void cleanup() {
    }

    @Override // com.alimm.tanx.ui.image.glide.load.data.DataFetcher
    public java.lang.String getId() {
        return this.id;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.alimm.tanx.ui.image.glide.load.data.DataFetcher
    public java.io.InputStream loadData(com.alimm.tanx.ui.image.glide.Priority priority) {
        return new java.io.ByteArrayInputStream(this.bytes);
    }
}
