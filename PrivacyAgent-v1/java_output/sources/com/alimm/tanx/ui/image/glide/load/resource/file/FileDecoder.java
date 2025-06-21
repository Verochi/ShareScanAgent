package com.alimm.tanx.ui.image.glide.load.resource.file;

/* loaded from: classes.dex */
public class FileDecoder implements com.alimm.tanx.ui.image.glide.load.ResourceDecoder<java.io.File, java.io.File> {
    @Override // com.alimm.tanx.ui.image.glide.load.ResourceDecoder
    public com.alimm.tanx.ui.image.glide.load.engine.Resource<java.io.File> decode(java.io.File file, int i, int i2) {
        return new com.alimm.tanx.ui.image.glide.load.resource.file.FileResource(file);
    }

    @Override // com.alimm.tanx.ui.image.glide.load.ResourceDecoder
    public java.lang.String getId() {
        return "";
    }
}
