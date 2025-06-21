package com.bumptech.glide.load.resource.bitmap;

@androidx.annotation.RequiresApi(27)
/* loaded from: classes.dex */
public final class ExifInterfaceImageHeaderParser implements com.bumptech.glide.load.ImageHeaderParser {
    @Override // com.bumptech.glide.load.ImageHeaderParser
    public int getOrientation(@androidx.annotation.NonNull java.io.InputStream inputStream, @androidx.annotation.NonNull com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool arrayPool) throws java.io.IOException {
        int attributeInt = new androidx.exifinterface.media.ExifInterface(inputStream).getAttributeInt(androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION, 1);
        if (attributeInt == 0) {
            return -1;
        }
        return attributeInt;
    }

    @Override // com.bumptech.glide.load.ImageHeaderParser
    public int getOrientation(@androidx.annotation.NonNull java.nio.ByteBuffer byteBuffer, @androidx.annotation.NonNull com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool arrayPool) throws java.io.IOException {
        return getOrientation(com.bumptech.glide.util.ByteBufferUtil.toStream(byteBuffer), arrayPool);
    }

    @Override // com.bumptech.glide.load.ImageHeaderParser
    @androidx.annotation.NonNull
    public com.bumptech.glide.load.ImageHeaderParser.ImageType getType(@androidx.annotation.NonNull java.io.InputStream inputStream) {
        return com.bumptech.glide.load.ImageHeaderParser.ImageType.UNKNOWN;
    }

    @Override // com.bumptech.glide.load.ImageHeaderParser
    @androidx.annotation.NonNull
    public com.bumptech.glide.load.ImageHeaderParser.ImageType getType(@androidx.annotation.NonNull java.nio.ByteBuffer byteBuffer) {
        return com.bumptech.glide.load.ImageHeaderParser.ImageType.UNKNOWN;
    }
}
