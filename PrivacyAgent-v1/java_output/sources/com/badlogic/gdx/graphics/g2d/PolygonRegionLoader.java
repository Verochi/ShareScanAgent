package com.badlogic.gdx.graphics.g2d;

/* loaded from: classes12.dex */
public class PolygonRegionLoader extends com.badlogic.gdx.assets.loaders.SynchronousAssetLoader<com.badlogic.gdx.graphics.g2d.PolygonRegion, com.badlogic.gdx.graphics.g2d.PolygonRegionLoader.PolygonRegionParameters> {
    public com.badlogic.gdx.graphics.g2d.PolygonRegionLoader.PolygonRegionParameters b;
    public com.badlogic.gdx.math.EarClippingTriangulator c;

    public static class PolygonRegionParameters extends com.badlogic.gdx.assets.AssetLoaderParameters<com.badlogic.gdx.graphics.g2d.PolygonRegion> {
        public java.lang.String texturePrefix = "i ";
        public int readerBuffer = 1024;
        public java.lang.String[] textureExtensions = {com.aliyun.auth.common.AliyunVodHttpCommon.ImageExt.IMAGEEXT_PNG, "PNG", com.aliyun.auth.common.AliyunVodHttpCommon.ImageExt.IMAGEEXT_JPEG, "JPEG", com.aliyun.auth.common.AliyunVodHttpCommon.ImageExt.IMAGEEXT_JPG, "JPG", "cim", "CIM", "etc1", "ETC1", "ktx", "KTX", "zktx", "ZKTX"};
    }

    public PolygonRegionLoader() {
        this(new com.badlogic.gdx.assets.loaders.resolvers.InternalFileHandleResolver());
    }

    public PolygonRegionLoader(com.badlogic.gdx.assets.loaders.FileHandleResolver fileHandleResolver) {
        super(fileHandleResolver);
        this.b = new com.badlogic.gdx.graphics.g2d.PolygonRegionLoader.PolygonRegionParameters();
        this.c = new com.badlogic.gdx.math.EarClippingTriangulator();
    }

    @Override // com.badlogic.gdx.assets.loaders.AssetLoader
    public com.badlogic.gdx.utils.Array<com.badlogic.gdx.assets.AssetDescriptor> getDependencies(java.lang.String str, com.badlogic.gdx.files.FileHandle fileHandle, com.badlogic.gdx.graphics.g2d.PolygonRegionLoader.PolygonRegionParameters polygonRegionParameters) {
        java.lang.String str2;
        java.lang.String[] strArr;
        if (polygonRegionParameters == null) {
            polygonRegionParameters = this.b;
        }
        try {
            java.io.BufferedReader reader = fileHandle.reader(polygonRegionParameters.readerBuffer);
            while (true) {
                java.lang.String readLine = reader.readLine();
                if (readLine == null) {
                    str2 = null;
                    break;
                }
                if (readLine.startsWith(polygonRegionParameters.texturePrefix)) {
                    str2 = readLine.substring(polygonRegionParameters.texturePrefix.length());
                    break;
                }
            }
            reader.close();
            if (str2 == null && (strArr = polygonRegionParameters.textureExtensions) != null) {
                for (java.lang.String str3 : strArr) {
                    com.badlogic.gdx.files.FileHandle sibling = fileHandle.sibling(fileHandle.nameWithoutExtension().concat("." + str3));
                    if (sibling.exists()) {
                        str2 = sibling.name();
                    }
                }
            }
            if (str2 == null) {
                return null;
            }
            com.badlogic.gdx.utils.Array<com.badlogic.gdx.assets.AssetDescriptor> array = new com.badlogic.gdx.utils.Array<>(1);
            array.add(new com.badlogic.gdx.assets.AssetDescriptor(fileHandle.sibling(str2), com.badlogic.gdx.graphics.Texture.class));
            return array;
        } catch (java.io.IOException e) {
            throw new com.badlogic.gdx.utils.GdxRuntimeException("Error reading " + str, e);
        }
    }

    @Override // com.badlogic.gdx.assets.loaders.SynchronousAssetLoader
    public com.badlogic.gdx.graphics.g2d.PolygonRegion load(com.badlogic.gdx.assets.AssetManager assetManager, java.lang.String str, com.badlogic.gdx.files.FileHandle fileHandle, com.badlogic.gdx.graphics.g2d.PolygonRegionLoader.PolygonRegionParameters polygonRegionParameters) {
        return load(new com.badlogic.gdx.graphics.g2d.TextureRegion((com.badlogic.gdx.graphics.Texture) assetManager.get(assetManager.getDependencies(str).first())), fileHandle);
    }

    public com.badlogic.gdx.graphics.g2d.PolygonRegion load(com.badlogic.gdx.graphics.g2d.TextureRegion textureRegion, com.badlogic.gdx.files.FileHandle fileHandle) {
        java.lang.String readLine;
        java.io.BufferedReader reader = fileHandle.reader(256);
        do {
            try {
                try {
                    readLine = reader.readLine();
                    if (readLine == null) {
                        com.badlogic.gdx.utils.StreamUtils.closeQuietly(reader);
                        throw new com.badlogic.gdx.utils.GdxRuntimeException("Polygon shape not found: " + fileHandle);
                    }
                } catch (java.io.IOException e) {
                    throw new com.badlogic.gdx.utils.GdxRuntimeException("Error reading polygon shape file: " + fileHandle, e);
                }
            } finally {
                com.badlogic.gdx.utils.StreamUtils.closeQuietly(reader);
            }
        } while (!readLine.startsWith("s"));
        java.lang.String[] split = readLine.substring(1).trim().split(",");
        int length = split.length;
        float[] fArr = new float[length];
        for (int i = 0; i < length; i++) {
            fArr[i] = java.lang.Float.parseFloat(split[i]);
        }
        return new com.badlogic.gdx.graphics.g2d.PolygonRegion(textureRegion, fArr, this.c.computeTriangles(fArr).toArray());
    }
}
