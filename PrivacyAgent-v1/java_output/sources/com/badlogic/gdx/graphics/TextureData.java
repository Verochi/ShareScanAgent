package com.badlogic.gdx.graphics;

/* loaded from: classes12.dex */
public interface TextureData {

    public static class Factory {
        public static com.badlogic.gdx.graphics.TextureData loadFromFile(com.badlogic.gdx.files.FileHandle fileHandle, com.badlogic.gdx.graphics.Pixmap.Format format, boolean z) {
            if (fileHandle == null) {
                return null;
            }
            if (fileHandle.name().endsWith(".cim")) {
                return new com.badlogic.gdx.graphics.glutils.FileTextureData(fileHandle, com.badlogic.gdx.graphics.PixmapIO.readCIM(fileHandle), format, z);
            }
            if (fileHandle.name().endsWith(".etc1")) {
                return new com.badlogic.gdx.graphics.glutils.ETC1TextureData(fileHandle, z);
            }
            if (fileHandle.name().endsWith(".ktx") || fileHandle.name().endsWith(".zktx")) {
                return new com.badlogic.gdx.graphics.glutils.KTXTextureData(fileHandle, z);
            }
            if (fileHandle.name().endsWith(".webp")) {
                try {
                    java.io.InputStream read = fileHandle.read();
                    try {
                        android.graphics.Bitmap decodeStream = android.graphics.BitmapFactory.decodeStream(read);
                        java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
                        decodeStream.compress(android.graphics.Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        com.badlogic.gdx.graphics.glutils.PixmapTextureData pixmapTextureData = new com.badlogic.gdx.graphics.glutils.PixmapTextureData(new com.badlogic.gdx.graphics.Pixmap(byteArray, 0, byteArray.length), null, false, false);
                        if (read != null) {
                            read.close();
                        }
                        return pixmapTextureData;
                    } finally {
                    }
                } catch (java.io.IOException e) {
                    com.badlogic.gdx.Gdx.app.error("Factory", e.toString());
                }
            }
            return new com.badlogic.gdx.graphics.glutils.FileTextureData(fileHandle, new com.badlogic.gdx.graphics.Pixmap(fileHandle), format, z);
        }

        public static com.badlogic.gdx.graphics.TextureData loadFromFile(com.badlogic.gdx.files.FileHandle fileHandle, boolean z) {
            return loadFromFile(fileHandle, null, z);
        }
    }

    public enum TextureDataType {
        Pixmap,
        Custom
    }

    void consumeCustomData(int i);

    com.badlogic.gdx.graphics.Pixmap consumePixmap();

    boolean disposePixmap();

    com.badlogic.gdx.graphics.Pixmap.Format getFormat();

    int getHeight();

    com.badlogic.gdx.graphics.TextureData.TextureDataType getType();

    int getWidth();

    boolean isManaged();

    boolean isPrepared();

    void prepare();

    boolean useMipMaps();
}
