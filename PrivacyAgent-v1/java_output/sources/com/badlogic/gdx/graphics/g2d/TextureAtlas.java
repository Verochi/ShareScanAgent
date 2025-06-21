package com.badlogic.gdx.graphics.g2d;

/* loaded from: classes12.dex */
public class TextureAtlas implements com.badlogic.gdx.utils.Disposable {
    public static final java.lang.String[] c = new java.lang.String[4];
    public static final java.util.Comparator<com.badlogic.gdx.graphics.g2d.TextureAtlas.TextureAtlasData.Region> d = new com.badlogic.gdx.graphics.g2d.TextureAtlas.AnonymousClass1();
    public final com.badlogic.gdx.utils.ObjectSet<com.badlogic.gdx.graphics.Texture> a;
    public final com.badlogic.gdx.utils.Array<com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion> b;

    /* renamed from: com.badlogic.gdx.graphics.g2d.TextureAtlas$1, reason: invalid class name */
    public class AnonymousClass1 implements java.util.Comparator<com.badlogic.gdx.graphics.g2d.TextureAtlas.TextureAtlasData.Region> {
        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(com.badlogic.gdx.graphics.g2d.TextureAtlas.TextureAtlasData.Region region, com.badlogic.gdx.graphics.g2d.TextureAtlas.TextureAtlasData.Region region2) {
            int i = region.index;
            if (i == -1) {
                i = Integer.MAX_VALUE;
            }
            int i2 = region2.index;
            return i - (i2 != -1 ? i2 : Integer.MAX_VALUE);
        }
    }

    public static class AtlasRegion extends com.badlogic.gdx.graphics.g2d.TextureRegion {
        public int index;
        public java.lang.String name;
        public float offsetX;
        public float offsetY;
        public int originalHeight;
        public int originalWidth;
        public int packedHeight;
        public int packedWidth;
        public int[] pads;
        public boolean rotate;
        public int[] splits;

        public AtlasRegion(com.badlogic.gdx.graphics.Texture texture, int i, int i2, int i3, int i4) {
            super(texture, i, i2, i3, i4);
            this.originalWidth = i3;
            this.originalHeight = i4;
            this.packedWidth = i3;
            this.packedHeight = i4;
        }

        public AtlasRegion(com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion atlasRegion) {
            setRegion(atlasRegion);
            this.index = atlasRegion.index;
            this.name = atlasRegion.name;
            this.offsetX = atlasRegion.offsetX;
            this.offsetY = atlasRegion.offsetY;
            this.packedWidth = atlasRegion.packedWidth;
            this.packedHeight = atlasRegion.packedHeight;
            this.originalWidth = atlasRegion.originalWidth;
            this.originalHeight = atlasRegion.originalHeight;
            this.rotate = atlasRegion.rotate;
            this.splits = atlasRegion.splits;
        }

        @Override // com.badlogic.gdx.graphics.g2d.TextureRegion
        public void flip(boolean z, boolean z2) {
            super.flip(z, z2);
            if (z) {
                this.offsetX = (this.originalWidth - this.offsetX) - getRotatedPackedWidth();
            }
            if (z2) {
                this.offsetY = (this.originalHeight - this.offsetY) - getRotatedPackedHeight();
            }
        }

        public float getRotatedPackedHeight() {
            return this.rotate ? this.packedWidth : this.packedHeight;
        }

        public float getRotatedPackedWidth() {
            return this.rotate ? this.packedHeight : this.packedWidth;
        }

        public java.lang.String toString() {
            return this.name;
        }
    }

    public static class AtlasSprite extends com.badlogic.gdx.graphics.g2d.Sprite {
        public final com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion u;
        public float v;
        public float w;

        public AtlasSprite(com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion atlasRegion) {
            this.u = new com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion(atlasRegion);
            this.v = atlasRegion.offsetX;
            this.w = atlasRegion.offsetY;
            setRegion(atlasRegion);
            setOrigin(atlasRegion.originalWidth / 2.0f, atlasRegion.originalHeight / 2.0f);
            int regionWidth = atlasRegion.getRegionWidth();
            int regionHeight = atlasRegion.getRegionHeight();
            if (atlasRegion.rotate) {
                super.rotate90(true);
                super.setBounds(atlasRegion.offsetX, atlasRegion.offsetY, regionHeight, regionWidth);
            } else {
                super.setBounds(atlasRegion.offsetX, atlasRegion.offsetY, regionWidth, regionHeight);
            }
            setColor(1.0f, 1.0f, 1.0f, 1.0f);
        }

        public AtlasSprite(com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasSprite atlasSprite) {
            this.u = atlasSprite.u;
            this.v = atlasSprite.v;
            this.w = atlasSprite.w;
            set(atlasSprite);
        }

        @Override // com.badlogic.gdx.graphics.g2d.Sprite, com.badlogic.gdx.graphics.g2d.TextureRegion
        public void flip(boolean z, boolean z2) {
            if (this.u.rotate) {
                super.flip(z2, z);
            } else {
                super.flip(z, z2);
            }
            float originX = getOriginX();
            float originY = getOriginY();
            com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion atlasRegion = this.u;
            float f = atlasRegion.offsetX;
            float f2 = atlasRegion.offsetY;
            float widthRatio = getWidthRatio();
            float heightRatio = getHeightRatio();
            com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion atlasRegion2 = this.u;
            atlasRegion2.offsetX = this.v;
            atlasRegion2.offsetY = this.w;
            atlasRegion2.flip(z, z2);
            com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion atlasRegion3 = this.u;
            float f3 = atlasRegion3.offsetX;
            this.v = f3;
            float f4 = atlasRegion3.offsetY;
            this.w = f4;
            float f5 = f3 * widthRatio;
            atlasRegion3.offsetX = f5;
            float f6 = f4 * heightRatio;
            atlasRegion3.offsetY = f6;
            translate(f5 - f, f6 - f2);
            setOrigin(originX, originY);
        }

        public com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion getAtlasRegion() {
            return this.u;
        }

        @Override // com.badlogic.gdx.graphics.g2d.Sprite
        public float getHeight() {
            return (super.getHeight() / this.u.getRotatedPackedHeight()) * this.u.originalHeight;
        }

        public float getHeightRatio() {
            return super.getHeight() / this.u.getRotatedPackedHeight();
        }

        @Override // com.badlogic.gdx.graphics.g2d.Sprite
        public float getOriginX() {
            return super.getOriginX() + this.u.offsetX;
        }

        @Override // com.badlogic.gdx.graphics.g2d.Sprite
        public float getOriginY() {
            return super.getOriginY() + this.u.offsetY;
        }

        @Override // com.badlogic.gdx.graphics.g2d.Sprite
        public float getWidth() {
            return (super.getWidth() / this.u.getRotatedPackedWidth()) * this.u.originalWidth;
        }

        public float getWidthRatio() {
            return super.getWidth() / this.u.getRotatedPackedWidth();
        }

        @Override // com.badlogic.gdx.graphics.g2d.Sprite
        public float getX() {
            return super.getX() - this.u.offsetX;
        }

        @Override // com.badlogic.gdx.graphics.g2d.Sprite
        public float getY() {
            return super.getY() - this.u.offsetY;
        }

        @Override // com.badlogic.gdx.graphics.g2d.Sprite
        public void rotate90(boolean z) {
            super.rotate90(z);
            float originX = getOriginX();
            float originY = getOriginY();
            com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion atlasRegion = this.u;
            float f = atlasRegion.offsetX;
            float f2 = atlasRegion.offsetY;
            float widthRatio = getWidthRatio();
            float heightRatio = getHeightRatio();
            if (z) {
                com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion atlasRegion2 = this.u;
                atlasRegion2.offsetX = f2;
                atlasRegion2.offsetY = ((atlasRegion2.originalHeight * heightRatio) - f) - (atlasRegion2.packedWidth * widthRatio);
            } else {
                com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion atlasRegion3 = this.u;
                atlasRegion3.offsetX = ((atlasRegion3.originalWidth * widthRatio) - f2) - (atlasRegion3.packedHeight * heightRatio);
                atlasRegion3.offsetY = f;
            }
            com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion atlasRegion4 = this.u;
            translate(atlasRegion4.offsetX - f, atlasRegion4.offsetY - f2);
            setOrigin(originX, originY);
        }

        @Override // com.badlogic.gdx.graphics.g2d.Sprite
        public void setBounds(float f, float f2, float f3, float f4) {
            com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion atlasRegion = this.u;
            float f5 = f3 / atlasRegion.originalWidth;
            float f6 = f4 / atlasRegion.originalHeight;
            float f7 = this.v * f5;
            atlasRegion.offsetX = f7;
            float f8 = this.w * f6;
            atlasRegion.offsetY = f8;
            boolean z = atlasRegion.rotate;
            super.setBounds(f + f7, f2 + f8, (z ? atlasRegion.packedHeight : atlasRegion.packedWidth) * f5, (z ? atlasRegion.packedWidth : atlasRegion.packedHeight) * f6);
        }

        @Override // com.badlogic.gdx.graphics.g2d.Sprite
        public void setOrigin(float f, float f2) {
            com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion atlasRegion = this.u;
            super.setOrigin(f - atlasRegion.offsetX, f2 - atlasRegion.offsetY);
        }

        @Override // com.badlogic.gdx.graphics.g2d.Sprite
        public void setOriginCenter() {
            float f = this.l / 2.0f;
            com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion atlasRegion = this.u;
            super.setOrigin(f - atlasRegion.offsetX, (this.m / 2.0f) - atlasRegion.offsetY);
        }

        @Override // com.badlogic.gdx.graphics.g2d.Sprite
        public void setPosition(float f, float f2) {
            com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion atlasRegion = this.u;
            super.setPosition(f + atlasRegion.offsetX, f2 + atlasRegion.offsetY);
        }

        @Override // com.badlogic.gdx.graphics.g2d.Sprite
        public void setSize(float f, float f2) {
            setBounds(getX(), getY(), f, f2);
        }

        @Override // com.badlogic.gdx.graphics.g2d.Sprite
        public void setX(float f) {
            super.setX(f + this.u.offsetX);
        }

        @Override // com.badlogic.gdx.graphics.g2d.Sprite
        public void setY(float f) {
            super.setY(f + this.u.offsetY);
        }

        public java.lang.String toString() {
            return this.u.toString();
        }
    }

    public static class TextureAtlasData {
        public final com.badlogic.gdx.utils.Array<com.badlogic.gdx.graphics.g2d.TextureAtlas.TextureAtlasData.Page> a = new com.badlogic.gdx.utils.Array<>();
        public final com.badlogic.gdx.utils.Array<com.badlogic.gdx.graphics.g2d.TextureAtlas.TextureAtlasData.Region> b = new com.badlogic.gdx.utils.Array<>();

        public static class Page {
            public final com.badlogic.gdx.graphics.Pixmap.Format format;
            public final float height;
            public final com.badlogic.gdx.graphics.Texture.TextureFilter magFilter;
            public final com.badlogic.gdx.graphics.Texture.TextureFilter minFilter;
            public com.badlogic.gdx.graphics.Texture texture;
            public final com.badlogic.gdx.files.FileHandle textureFile;
            public final com.badlogic.gdx.graphics.Texture.TextureWrap uWrap;
            public final boolean useMipMaps;
            public final com.badlogic.gdx.graphics.Texture.TextureWrap vWrap;
            public final float width;

            public Page(com.badlogic.gdx.files.FileHandle fileHandle, float f, float f2, boolean z, com.badlogic.gdx.graphics.Pixmap.Format format, com.badlogic.gdx.graphics.Texture.TextureFilter textureFilter, com.badlogic.gdx.graphics.Texture.TextureFilter textureFilter2, com.badlogic.gdx.graphics.Texture.TextureWrap textureWrap, com.badlogic.gdx.graphics.Texture.TextureWrap textureWrap2) {
                this.width = f;
                this.height = f2;
                this.textureFile = fileHandle;
                this.useMipMaps = z;
                this.format = format;
                this.minFilter = textureFilter;
                this.magFilter = textureFilter2;
                this.uWrap = textureWrap;
                this.vWrap = textureWrap2;
            }
        }

        public static class Region {
            public boolean flip;
            public int height;
            public int index;
            public int left;
            public java.lang.String name;
            public float offsetX;
            public float offsetY;
            public int originalHeight;
            public int originalWidth;
            public int[] pads;
            public com.badlogic.gdx.graphics.g2d.TextureAtlas.TextureAtlasData.Page page;
            public boolean rotate;
            public int[] splits;
            public int top;
            public int width;
        }

        public TextureAtlasData(com.badlogic.gdx.files.FileHandle fileHandle, com.badlogic.gdx.files.FileHandle fileHandle2, boolean z) {
            float f;
            float f2;
            com.badlogic.gdx.graphics.Texture.TextureWrap textureWrap;
            com.badlogic.gdx.graphics.Texture.TextureWrap textureWrap2;
            java.io.BufferedReader bufferedReader = new java.io.BufferedReader(new java.io.InputStreamReader(fileHandle.read()), 64);
            while (true) {
                com.badlogic.gdx.graphics.g2d.TextureAtlas.TextureAtlasData.Page page = null;
                while (true) {
                    try {
                        try {
                            java.lang.String readLine = bufferedReader.readLine();
                            if (readLine == null) {
                                com.badlogic.gdx.utils.StreamUtils.closeQuietly(bufferedReader);
                                this.b.sort(com.badlogic.gdx.graphics.g2d.TextureAtlas.d);
                                return;
                            }
                            if (readLine.trim().length() == 0) {
                                break;
                            }
                            if (page == null) {
                                com.badlogic.gdx.files.FileHandle child = fileHandle2.child(readLine);
                                if (com.badlogic.gdx.graphics.g2d.TextureAtlas.c(bufferedReader) == 2) {
                                    java.lang.String[] strArr = com.badlogic.gdx.graphics.g2d.TextureAtlas.c;
                                    float parseInt = java.lang.Integer.parseInt(strArr[0]);
                                    float parseInt2 = java.lang.Integer.parseInt(strArr[1]);
                                    com.badlogic.gdx.graphics.g2d.TextureAtlas.c(bufferedReader);
                                    f2 = parseInt2;
                                    f = parseInt;
                                } else {
                                    f = 0.0f;
                                    f2 = 0.0f;
                                }
                                java.lang.String[] strArr2 = com.badlogic.gdx.graphics.g2d.TextureAtlas.c;
                                com.badlogic.gdx.graphics.Pixmap.Format valueOf = com.badlogic.gdx.graphics.Pixmap.Format.valueOf(strArr2[0]);
                                com.badlogic.gdx.graphics.g2d.TextureAtlas.c(bufferedReader);
                                com.badlogic.gdx.graphics.Texture.TextureFilter valueOf2 = com.badlogic.gdx.graphics.Texture.TextureFilter.valueOf(strArr2[0]);
                                com.badlogic.gdx.graphics.Texture.TextureFilter valueOf3 = com.badlogic.gdx.graphics.Texture.TextureFilter.valueOf(strArr2[1]);
                                java.lang.String d = com.badlogic.gdx.graphics.g2d.TextureAtlas.d(bufferedReader);
                                com.badlogic.gdx.graphics.Texture.TextureWrap textureWrap3 = com.badlogic.gdx.graphics.Texture.TextureWrap.ClampToEdge;
                                if (d.equals("x")) {
                                    textureWrap = com.badlogic.gdx.graphics.Texture.TextureWrap.Repeat;
                                    textureWrap2 = textureWrap3;
                                } else if (d.equals("y")) {
                                    textureWrap2 = com.badlogic.gdx.graphics.Texture.TextureWrap.Repeat;
                                    textureWrap = textureWrap3;
                                } else {
                                    textureWrap = d.equals("xy") ? com.badlogic.gdx.graphics.Texture.TextureWrap.Repeat : textureWrap3;
                                    textureWrap2 = textureWrap;
                                }
                                page = new com.badlogic.gdx.graphics.g2d.TextureAtlas.TextureAtlasData.Page(child, f, f2, valueOf2.isMipMap(), valueOf, valueOf2, valueOf3, textureWrap, textureWrap2);
                                this.a.add(page);
                            } else {
                                boolean booleanValue = java.lang.Boolean.valueOf(com.badlogic.gdx.graphics.g2d.TextureAtlas.d(bufferedReader)).booleanValue();
                                com.badlogic.gdx.graphics.g2d.TextureAtlas.c(bufferedReader);
                                java.lang.String[] strArr3 = com.badlogic.gdx.graphics.g2d.TextureAtlas.c;
                                int parseInt3 = java.lang.Integer.parseInt(strArr3[0]);
                                int parseInt4 = java.lang.Integer.parseInt(strArr3[1]);
                                com.badlogic.gdx.graphics.g2d.TextureAtlas.c(bufferedReader);
                                int parseInt5 = java.lang.Integer.parseInt(strArr3[0]);
                                int parseInt6 = java.lang.Integer.parseInt(strArr3[1]);
                                com.badlogic.gdx.graphics.g2d.TextureAtlas.TextureAtlasData.Region region = new com.badlogic.gdx.graphics.g2d.TextureAtlas.TextureAtlasData.Region();
                                region.page = page;
                                region.left = parseInt3;
                                region.top = parseInt4;
                                region.width = parseInt5;
                                region.height = parseInt6;
                                region.name = readLine;
                                region.rotate = booleanValue;
                                if (com.badlogic.gdx.graphics.g2d.TextureAtlas.c(bufferedReader) == 4) {
                                    region.splits = new int[]{java.lang.Integer.parseInt(strArr3[0]), java.lang.Integer.parseInt(strArr3[1]), java.lang.Integer.parseInt(strArr3[2]), java.lang.Integer.parseInt(strArr3[3])};
                                    if (com.badlogic.gdx.graphics.g2d.TextureAtlas.c(bufferedReader) == 4) {
                                        region.pads = new int[]{java.lang.Integer.parseInt(strArr3[0]), java.lang.Integer.parseInt(strArr3[1]), java.lang.Integer.parseInt(strArr3[2]), java.lang.Integer.parseInt(strArr3[3])};
                                        com.badlogic.gdx.graphics.g2d.TextureAtlas.c(bufferedReader);
                                    }
                                }
                                region.originalWidth = java.lang.Integer.parseInt(strArr3[0]);
                                region.originalHeight = java.lang.Integer.parseInt(strArr3[1]);
                                com.badlogic.gdx.graphics.g2d.TextureAtlas.c(bufferedReader);
                                region.offsetX = java.lang.Integer.parseInt(strArr3[0]);
                                region.offsetY = java.lang.Integer.parseInt(strArr3[1]);
                                region.index = java.lang.Integer.parseInt(com.badlogic.gdx.graphics.g2d.TextureAtlas.d(bufferedReader));
                                if (z) {
                                    region.flip = true;
                                }
                                this.b.add(region);
                            }
                        } catch (java.lang.Exception e) {
                            throw new com.badlogic.gdx.utils.GdxRuntimeException("Error reading pack file: " + fileHandle, e);
                        }
                    } catch (java.lang.Throwable th) {
                        com.badlogic.gdx.utils.StreamUtils.closeQuietly(bufferedReader);
                        throw th;
                    }
                }
            }
        }

        public com.badlogic.gdx.utils.Array<com.badlogic.gdx.graphics.g2d.TextureAtlas.TextureAtlasData.Page> getPages() {
            return this.a;
        }

        public com.badlogic.gdx.utils.Array<com.badlogic.gdx.graphics.g2d.TextureAtlas.TextureAtlasData.Region> getRegions() {
            return this.b;
        }
    }

    public TextureAtlas() {
        this.a = new com.badlogic.gdx.utils.ObjectSet<>(4);
        this.b = new com.badlogic.gdx.utils.Array<>();
    }

    public TextureAtlas(com.badlogic.gdx.files.FileHandle fileHandle) {
        this(fileHandle, fileHandle.parent());
    }

    public TextureAtlas(com.badlogic.gdx.files.FileHandle fileHandle, com.badlogic.gdx.files.FileHandle fileHandle2) {
        this(fileHandle, fileHandle2, false);
    }

    public TextureAtlas(com.badlogic.gdx.files.FileHandle fileHandle, com.badlogic.gdx.files.FileHandle fileHandle2, boolean z) {
        this(new com.badlogic.gdx.graphics.g2d.TextureAtlas.TextureAtlasData(fileHandle, fileHandle2, z));
    }

    public TextureAtlas(com.badlogic.gdx.files.FileHandle fileHandle, boolean z) {
        this(fileHandle, fileHandle.parent(), z);
    }

    public TextureAtlas(com.badlogic.gdx.graphics.g2d.TextureAtlas.TextureAtlasData textureAtlasData) {
        this.a = new com.badlogic.gdx.utils.ObjectSet<>(4);
        this.b = new com.badlogic.gdx.utils.Array<>();
        if (textureAtlasData != null) {
            a(textureAtlasData);
        }
    }

    public TextureAtlas(java.lang.String str) {
        this(com.badlogic.gdx.Gdx.files.internal(str));
    }

    public static int c(java.io.BufferedReader bufferedReader) throws java.io.IOException {
        int indexOf;
        java.lang.String readLine = bufferedReader.readLine();
        int indexOf2 = readLine.indexOf(58);
        if (indexOf2 == -1) {
            throw new com.badlogic.gdx.utils.GdxRuntimeException("Invalid line: " + readLine);
        }
        int i = indexOf2 + 1;
        int i2 = 0;
        while (i2 < 3 && (indexOf = readLine.indexOf(44, i)) != -1) {
            c[i2] = readLine.substring(i, indexOf).trim();
            i = indexOf + 1;
            i2++;
        }
        c[i2] = readLine.substring(i).trim();
        return i2 + 1;
    }

    public static java.lang.String d(java.io.BufferedReader bufferedReader) throws java.io.IOException {
        java.lang.String readLine = bufferedReader.readLine();
        int indexOf = readLine.indexOf(58);
        if (indexOf != -1) {
            return readLine.substring(indexOf + 1).trim();
        }
        throw new com.badlogic.gdx.utils.GdxRuntimeException("Invalid line: " + readLine);
    }

    public final void a(com.badlogic.gdx.graphics.g2d.TextureAtlas.TextureAtlasData textureAtlasData) {
        com.badlogic.gdx.utils.ObjectMap objectMap = new com.badlogic.gdx.utils.ObjectMap();
        java.util.Iterator<com.badlogic.gdx.graphics.g2d.TextureAtlas.TextureAtlasData.Page> it = textureAtlasData.a.iterator();
        while (it.hasNext()) {
            com.badlogic.gdx.graphics.g2d.TextureAtlas.TextureAtlasData.Page next = it.next();
            com.badlogic.gdx.graphics.Texture texture = next.texture;
            if (texture == null) {
                texture = new com.badlogic.gdx.graphics.Texture(next.textureFile, next.format, next.useMipMaps);
                texture.setFilter(next.minFilter, next.magFilter);
                texture.setWrap(next.uWrap, next.vWrap);
            } else {
                texture.setFilter(next.minFilter, next.magFilter);
                texture.setWrap(next.uWrap, next.vWrap);
            }
            this.a.add(texture);
            objectMap.put(next, texture);
        }
        java.util.Iterator<com.badlogic.gdx.graphics.g2d.TextureAtlas.TextureAtlasData.Region> it2 = textureAtlasData.b.iterator();
        while (it2.hasNext()) {
            com.badlogic.gdx.graphics.g2d.TextureAtlas.TextureAtlasData.Region next2 = it2.next();
            int i = next2.width;
            int i2 = next2.height;
            com.badlogic.gdx.graphics.Texture texture2 = (com.badlogic.gdx.graphics.Texture) objectMap.get(next2.page);
            int i3 = next2.left;
            int i4 = next2.top;
            boolean z = next2.rotate;
            com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion atlasRegion = new com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion(texture2, i3, i4, z ? i2 : i, z ? i : i2);
            atlasRegion.index = next2.index;
            atlasRegion.name = next2.name;
            atlasRegion.offsetX = next2.offsetX;
            atlasRegion.offsetY = next2.offsetY;
            atlasRegion.originalHeight = next2.originalHeight;
            atlasRegion.originalWidth = next2.originalWidth;
            atlasRegion.rotate = next2.rotate;
            atlasRegion.splits = next2.splits;
            atlasRegion.pads = next2.pads;
            if (next2.flip) {
                atlasRegion.flip(false, true);
            }
            this.b.add(atlasRegion);
        }
    }

    public com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion addRegion(java.lang.String str, com.badlogic.gdx.graphics.Texture texture, int i, int i2, int i3, int i4) {
        this.a.add(texture);
        com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion atlasRegion = new com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion(texture, i, i2, i3, i4);
        atlasRegion.name = str;
        atlasRegion.originalWidth = i3;
        atlasRegion.originalHeight = i4;
        atlasRegion.index = -1;
        this.b.add(atlasRegion);
        return atlasRegion;
    }

    public com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion addRegion(java.lang.String str, com.badlogic.gdx.graphics.g2d.TextureRegion textureRegion) {
        return addRegion(str, textureRegion.a, textureRegion.getRegionX(), textureRegion.getRegionY(), textureRegion.getRegionWidth(), textureRegion.getRegionHeight());
    }

    public final com.badlogic.gdx.graphics.g2d.Sprite b(com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion atlasRegion) {
        if (atlasRegion.packedWidth != atlasRegion.originalWidth || atlasRegion.packedHeight != atlasRegion.originalHeight) {
            return new com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasSprite(atlasRegion);
        }
        if (!atlasRegion.rotate) {
            return new com.badlogic.gdx.graphics.g2d.Sprite(atlasRegion);
        }
        com.badlogic.gdx.graphics.g2d.Sprite sprite = new com.badlogic.gdx.graphics.g2d.Sprite(atlasRegion);
        sprite.setBounds(0.0f, 0.0f, atlasRegion.getRegionHeight(), atlasRegion.getRegionWidth());
        sprite.rotate90(true);
        return sprite;
    }

    public com.badlogic.gdx.graphics.g2d.NinePatch createPatch(java.lang.String str) {
        int i = this.b.size;
        for (int i2 = 0; i2 < i; i2++) {
            com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion atlasRegion = this.b.get(i2);
            if (atlasRegion.name.equals(str)) {
                int[] iArr = atlasRegion.splits;
                if (iArr == null) {
                    throw new java.lang.IllegalArgumentException("Region does not have ninepatch splits: " + str);
                }
                com.badlogic.gdx.graphics.g2d.NinePatch ninePatch = new com.badlogic.gdx.graphics.g2d.NinePatch(atlasRegion, iArr[0], iArr[1], iArr[2], iArr[3]);
                if (atlasRegion.pads != null) {
                    ninePatch.setPadding(r0[0], r0[1], r0[2], r0[3]);
                }
                return ninePatch;
            }
        }
        return null;
    }

    public com.badlogic.gdx.graphics.g2d.Sprite createSprite(java.lang.String str) {
        int i = this.b.size;
        for (int i2 = 0; i2 < i; i2++) {
            if (this.b.get(i2).name.equals(str)) {
                return b(this.b.get(i2));
            }
        }
        return null;
    }

    public com.badlogic.gdx.graphics.g2d.Sprite createSprite(java.lang.String str, int i) {
        int i2 = this.b.size;
        for (int i3 = 0; i3 < i2; i3++) {
            com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion atlasRegion = this.b.get(i3);
            if (atlasRegion.name.equals(str) && atlasRegion.index == i) {
                return b(this.b.get(i3));
            }
        }
        return null;
    }

    public com.badlogic.gdx.utils.Array<com.badlogic.gdx.graphics.g2d.Sprite> createSprites() {
        com.badlogic.gdx.utils.Array<com.badlogic.gdx.graphics.g2d.Sprite> array = new com.badlogic.gdx.utils.Array<>(this.b.size);
        int i = this.b.size;
        for (int i2 = 0; i2 < i; i2++) {
            array.add(b(this.b.get(i2)));
        }
        return array;
    }

    public com.badlogic.gdx.utils.Array<com.badlogic.gdx.graphics.g2d.Sprite> createSprites(java.lang.String str) {
        com.badlogic.gdx.utils.Array<com.badlogic.gdx.graphics.g2d.Sprite> array = new com.badlogic.gdx.utils.Array<>();
        int i = this.b.size;
        for (int i2 = 0; i2 < i; i2++) {
            com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion atlasRegion = this.b.get(i2);
            if (atlasRegion.name.equals(str)) {
                array.add(b(atlasRegion));
            }
        }
        return array;
    }

    @Override // com.badlogic.gdx.utils.Disposable
    public void dispose() {
        com.badlogic.gdx.utils.ObjectSet.ObjectSetIterator<com.badlogic.gdx.graphics.Texture> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().dispose();
        }
        this.a.clear();
    }

    public com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion findRegion(java.lang.String str) {
        int i = this.b.size;
        for (int i2 = 0; i2 < i; i2++) {
            if (this.b.get(i2).name.equals(str)) {
                return this.b.get(i2);
            }
        }
        return null;
    }

    public com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion findRegion(java.lang.String str, int i) {
        int i2 = this.b.size;
        for (int i3 = 0; i3 < i2; i3++) {
            com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion atlasRegion = this.b.get(i3);
            if (atlasRegion.name.equals(str) && atlasRegion.index == i) {
                return atlasRegion;
            }
        }
        return null;
    }

    public com.badlogic.gdx.utils.Array<com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion> findRegions(java.lang.String str) {
        com.badlogic.gdx.utils.Array<com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion> array = new com.badlogic.gdx.utils.Array<>();
        int i = this.b.size;
        for (int i2 = 0; i2 < i; i2++) {
            com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion atlasRegion = this.b.get(i2);
            if (atlasRegion.name.equals(str)) {
                array.add(new com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion(atlasRegion));
            }
        }
        return array;
    }

    public com.badlogic.gdx.utils.Array<com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion> getRegions() {
        return this.b;
    }

    public com.badlogic.gdx.utils.ObjectSet<com.badlogic.gdx.graphics.Texture> getTextures() {
        return this.a;
    }
}
