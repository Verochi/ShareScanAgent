package com.alimm.tanx.ui.image.glide.load.resource.file;

/* loaded from: classes.dex */
public class FileToStreamDecoder<T> implements com.alimm.tanx.ui.image.glide.load.ResourceDecoder<java.io.File, T> {
    private static final com.alimm.tanx.ui.image.glide.load.resource.file.FileToStreamDecoder.FileOpener DEFAULT_FILE_OPENER = new com.alimm.tanx.ui.image.glide.load.resource.file.FileToStreamDecoder.FileOpener();
    private final com.alimm.tanx.ui.image.glide.load.resource.file.FileToStreamDecoder.FileOpener fileOpener;
    private com.alimm.tanx.ui.image.glide.load.ResourceDecoder<java.io.InputStream, T> streamDecoder;

    public static class FileOpener {
        public java.io.InputStream open(java.io.File file) throws java.io.FileNotFoundException {
            return new java.io.FileInputStream(file);
        }
    }

    public FileToStreamDecoder(com.alimm.tanx.ui.image.glide.load.ResourceDecoder<java.io.InputStream, T> resourceDecoder) {
        com.alimm.tanx.ui.image.glide.load.resource.file.FileToStreamDecoder.FileOpener fileOpener = DEFAULT_FILE_OPENER;
        this.streamDecoder = resourceDecoder;
        this.fileOpener = fileOpener;
    }

    public FileToStreamDecoder(com.alimm.tanx.ui.image.glide.load.ResourceDecoder<java.io.InputStream, T> resourceDecoder, com.alimm.tanx.ui.image.glide.load.resource.file.FileToStreamDecoder.FileOpener fileOpener) {
        this.streamDecoder = resourceDecoder;
        this.fileOpener = fileOpener;
    }

    @Override // com.alimm.tanx.ui.image.glide.load.ResourceDecoder
    public com.alimm.tanx.ui.image.glide.load.engine.Resource<T> decode(java.io.File file, int i, int i2) throws java.io.IOException {
        java.lang.Throwable th;
        java.io.InputStream inputStream;
        try {
            inputStream = this.fileOpener.open(file);
            try {
                com.alimm.tanx.ui.image.glide.load.engine.Resource<T> decode = this.streamDecoder.decode(inputStream, i, i2);
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (java.io.IOException unused) {
                    }
                }
                return decode;
            } catch (java.lang.Throwable th2) {
                th = th2;
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (java.io.IOException unused2) {
                    }
                }
                throw th;
            }
        } catch (java.lang.Throwable th3) {
            th = th3;
            inputStream = null;
        }
    }

    @Override // com.alimm.tanx.ui.image.glide.load.ResourceDecoder
    public java.lang.String getId() {
        return "";
    }
}
