package com.alimm.tanx.ui.image.glide.load.model;

/* loaded from: classes.dex */
public class ImageVideoWrapperEncoder implements com.alimm.tanx.ui.image.glide.load.Encoder<com.alimm.tanx.ui.image.glide.load.model.ImageVideoWrapper> {
    private final com.alimm.tanx.ui.image.glide.load.Encoder<android.os.ParcelFileDescriptor> fileDescriptorEncoder;
    private java.lang.String id;
    private final com.alimm.tanx.ui.image.glide.load.Encoder<java.io.InputStream> streamEncoder;

    public ImageVideoWrapperEncoder(com.alimm.tanx.ui.image.glide.load.Encoder<java.io.InputStream> encoder, com.alimm.tanx.ui.image.glide.load.Encoder<android.os.ParcelFileDescriptor> encoder2) {
        this.streamEncoder = encoder;
        this.fileDescriptorEncoder = encoder2;
    }

    @Override // com.alimm.tanx.ui.image.glide.load.Encoder
    public boolean encode(com.alimm.tanx.ui.image.glide.load.model.ImageVideoWrapper imageVideoWrapper, java.io.OutputStream outputStream) {
        return imageVideoWrapper.getStream() != null ? this.streamEncoder.encode(imageVideoWrapper.getStream(), outputStream) : this.fileDescriptorEncoder.encode(imageVideoWrapper.getFileDescriptor(), outputStream);
    }

    @Override // com.alimm.tanx.ui.image.glide.load.Encoder
    public java.lang.String getId() {
        if (this.id == null) {
            this.id = this.streamEncoder.getId() + this.fileDescriptorEncoder.getId();
        }
        return this.id;
    }
}
