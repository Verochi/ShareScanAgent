package com.badlogic.gdx.graphics.g2d;

/* loaded from: classes12.dex */
public class PixmapPacker implements com.badlogic.gdx.utils.Disposable {
    public boolean a;
    public boolean b;
    public int c;
    public int d;
    public com.badlogic.gdx.graphics.Pixmap.Format e;
    public int f;
    public boolean g;
    public com.badlogic.gdx.graphics.Color h;
    public final com.badlogic.gdx.utils.Array<com.badlogic.gdx.graphics.g2d.PixmapPacker.Page> i;
    public com.badlogic.gdx.graphics.g2d.PixmapPacker.PackStrategy j;

    public static class GuillotineStrategy implements com.badlogic.gdx.graphics.g2d.PixmapPacker.PackStrategy {
        public java.util.Comparator<com.badlogic.gdx.graphics.Pixmap> a;

        /* renamed from: com.badlogic.gdx.graphics.g2d.PixmapPacker$GuillotineStrategy$1, reason: invalid class name */
        public class AnonymousClass1 implements java.util.Comparator<com.badlogic.gdx.graphics.Pixmap> {
            public AnonymousClass1() {
            }

            @Override // java.util.Comparator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public int compare(com.badlogic.gdx.graphics.Pixmap pixmap, com.badlogic.gdx.graphics.Pixmap pixmap2) {
                return java.lang.Math.max(pixmap.getWidth(), pixmap.getHeight()) - java.lang.Math.max(pixmap2.getWidth(), pixmap2.getHeight());
            }
        }

        public static class GuillotinePage extends com.badlogic.gdx.graphics.g2d.PixmapPacker.Page {
            public com.badlogic.gdx.graphics.g2d.PixmapPacker.GuillotineStrategy.Node f;

            public GuillotinePage(com.badlogic.gdx.graphics.g2d.PixmapPacker pixmapPacker) {
                super(pixmapPacker);
                com.badlogic.gdx.graphics.g2d.PixmapPacker.GuillotineStrategy.Node node = new com.badlogic.gdx.graphics.g2d.PixmapPacker.GuillotineStrategy.Node();
                this.f = node;
                com.badlogic.gdx.math.Rectangle rectangle = node.c;
                int i = pixmapPacker.f;
                rectangle.x = i;
                rectangle.y = i;
                rectangle.width = pixmapPacker.c - (i * 2);
                rectangle.height = pixmapPacker.d - (i * 2);
            }
        }

        public static final class Node {
            public com.badlogic.gdx.graphics.g2d.PixmapPacker.GuillotineStrategy.Node a;
            public com.badlogic.gdx.graphics.g2d.PixmapPacker.GuillotineStrategy.Node b;
            public final com.badlogic.gdx.math.Rectangle c = new com.badlogic.gdx.math.Rectangle();
            public boolean d;
        }

        private com.badlogic.gdx.graphics.g2d.PixmapPacker.GuillotineStrategy.Node insert(com.badlogic.gdx.graphics.g2d.PixmapPacker.GuillotineStrategy.Node node, com.badlogic.gdx.math.Rectangle rectangle) {
            com.badlogic.gdx.graphics.g2d.PixmapPacker.GuillotineStrategy.Node node2;
            boolean z = node.d;
            if (!z && (node2 = node.a) != null && node.b != null) {
                com.badlogic.gdx.graphics.g2d.PixmapPacker.GuillotineStrategy.Node insert = insert(node2, rectangle);
                return insert == null ? insert(node.b, rectangle) : insert;
            }
            if (z) {
                return null;
            }
            com.badlogic.gdx.math.Rectangle rectangle2 = node.c;
            float f = rectangle2.width;
            float f2 = rectangle.width;
            if (f == f2 && rectangle2.height == rectangle.height) {
                return node;
            }
            if (f < f2 || rectangle2.height < rectangle.height) {
                return null;
            }
            node.a = new com.badlogic.gdx.graphics.g2d.PixmapPacker.GuillotineStrategy.Node();
            com.badlogic.gdx.graphics.g2d.PixmapPacker.GuillotineStrategy.Node node3 = new com.badlogic.gdx.graphics.g2d.PixmapPacker.GuillotineStrategy.Node();
            node.b = node3;
            com.badlogic.gdx.math.Rectangle rectangle3 = node.c;
            float f3 = rectangle3.width;
            float f4 = rectangle.width;
            int i = ((int) f3) - ((int) f4);
            float f5 = rectangle3.height;
            float f6 = rectangle.height;
            if (i > ((int) f5) - ((int) f6)) {
                com.badlogic.gdx.math.Rectangle rectangle4 = node.a.c;
                rectangle4.x = rectangle3.x;
                rectangle4.y = rectangle3.y;
                rectangle4.width = f4;
                rectangle4.height = f5;
                com.badlogic.gdx.math.Rectangle rectangle5 = node3.c;
                float f7 = rectangle3.x;
                float f8 = rectangle.width;
                rectangle5.x = f7 + f8;
                rectangle5.y = rectangle3.y;
                rectangle5.width = rectangle3.width - f8;
                rectangle5.height = rectangle3.height;
            } else {
                com.badlogic.gdx.math.Rectangle rectangle6 = node.a.c;
                rectangle6.x = rectangle3.x;
                rectangle6.y = rectangle3.y;
                rectangle6.width = f3;
                rectangle6.height = f6;
                com.badlogic.gdx.math.Rectangle rectangle7 = node3.c;
                rectangle7.x = rectangle3.x;
                float f9 = rectangle3.y;
                float f10 = rectangle.height;
                rectangle7.y = f9 + f10;
                rectangle7.width = rectangle3.width;
                rectangle7.height = rectangle3.height - f10;
            }
            return insert(node.a, rectangle);
        }

        @Override // com.badlogic.gdx.graphics.g2d.PixmapPacker.PackStrategy
        public com.badlogic.gdx.graphics.g2d.PixmapPacker.Page pack(com.badlogic.gdx.graphics.g2d.PixmapPacker pixmapPacker, java.lang.String str, com.badlogic.gdx.math.Rectangle rectangle) {
            com.badlogic.gdx.graphics.g2d.PixmapPacker.GuillotineStrategy.GuillotinePage guillotinePage;
            com.badlogic.gdx.utils.Array<com.badlogic.gdx.graphics.g2d.PixmapPacker.Page> array = pixmapPacker.i;
            if (array.size == 0) {
                guillotinePage = new com.badlogic.gdx.graphics.g2d.PixmapPacker.GuillotineStrategy.GuillotinePage(pixmapPacker);
                pixmapPacker.i.add(guillotinePage);
            } else {
                guillotinePage = (com.badlogic.gdx.graphics.g2d.PixmapPacker.GuillotineStrategy.GuillotinePage) array.peek();
            }
            float f = pixmapPacker.f;
            rectangle.width += f;
            rectangle.height += f;
            com.badlogic.gdx.graphics.g2d.PixmapPacker.GuillotineStrategy.Node insert = insert(guillotinePage.f, rectangle);
            if (insert == null) {
                guillotinePage = new com.badlogic.gdx.graphics.g2d.PixmapPacker.GuillotineStrategy.GuillotinePage(pixmapPacker);
                pixmapPacker.i.add(guillotinePage);
                insert = insert(guillotinePage.f, rectangle);
            }
            insert.d = true;
            com.badlogic.gdx.math.Rectangle rectangle2 = insert.c;
            rectangle.set(rectangle2.x, rectangle2.y, rectangle2.width - f, rectangle2.height - f);
            return guillotinePage;
        }

        @Override // com.badlogic.gdx.graphics.g2d.PixmapPacker.PackStrategy
        public void sort(com.badlogic.gdx.utils.Array<com.badlogic.gdx.graphics.Pixmap> array) {
            if (this.a == null) {
                this.a = new com.badlogic.gdx.graphics.g2d.PixmapPacker.GuillotineStrategy.AnonymousClass1();
            }
            array.sort(this.a);
        }
    }

    public interface PackStrategy {
        com.badlogic.gdx.graphics.g2d.PixmapPacker.Page pack(com.badlogic.gdx.graphics.g2d.PixmapPacker pixmapPacker, java.lang.String str, com.badlogic.gdx.math.Rectangle rectangle);

        void sort(com.badlogic.gdx.utils.Array<com.badlogic.gdx.graphics.Pixmap> array);
    }

    public static class Page {
        public com.badlogic.gdx.graphics.Pixmap b;
        public com.badlogic.gdx.graphics.Texture c;
        public boolean e;
        public com.badlogic.gdx.utils.OrderedMap<java.lang.String, com.badlogic.gdx.math.Rectangle> a = new com.badlogic.gdx.utils.OrderedMap<>();
        public final com.badlogic.gdx.utils.Array<java.lang.String> d = new com.badlogic.gdx.utils.Array<>();

        /* renamed from: com.badlogic.gdx.graphics.g2d.PixmapPacker$Page$1, reason: invalid class name */
        public class AnonymousClass1 extends com.badlogic.gdx.graphics.Texture {
            public AnonymousClass1(com.badlogic.gdx.graphics.TextureData textureData) {
                super(textureData);
            }

            @Override // com.badlogic.gdx.graphics.Texture, com.badlogic.gdx.graphics.GLTexture, com.badlogic.gdx.utils.Disposable
            public void dispose() {
                super.dispose();
                com.badlogic.gdx.graphics.g2d.PixmapPacker.Page.this.b.dispose();
            }
        }

        public Page(com.badlogic.gdx.graphics.g2d.PixmapPacker pixmapPacker) {
            this.b = new com.badlogic.gdx.graphics.Pixmap(pixmapPacker.c, pixmapPacker.d, pixmapPacker.e);
            this.b.setColor(pixmapPacker.getTransparentColor());
            this.b.fill();
        }

        public com.badlogic.gdx.graphics.Pixmap getPixmap() {
            return this.b;
        }

        public com.badlogic.gdx.utils.OrderedMap<java.lang.String, com.badlogic.gdx.math.Rectangle> getRects() {
            return this.a;
        }

        public com.badlogic.gdx.graphics.Texture getTexture() {
            return this.c;
        }

        public boolean updateTexture(com.badlogic.gdx.graphics.Texture.TextureFilter textureFilter, com.badlogic.gdx.graphics.Texture.TextureFilter textureFilter2, boolean z) {
            com.badlogic.gdx.graphics.Texture texture = this.c;
            if (texture == null) {
                com.badlogic.gdx.graphics.Pixmap pixmap = this.b;
                com.badlogic.gdx.graphics.g2d.PixmapPacker.Page.AnonymousClass1 anonymousClass1 = new com.badlogic.gdx.graphics.g2d.PixmapPacker.Page.AnonymousClass1(new com.badlogic.gdx.graphics.glutils.PixmapTextureData(pixmap, pixmap.getFormat(), z, false, true));
                this.c = anonymousClass1;
                anonymousClass1.setFilter(textureFilter, textureFilter2);
            } else {
                if (!this.e) {
                    return false;
                }
                texture.load(texture.getTextureData());
            }
            this.e = false;
            return true;
        }
    }

    public static class SkylineStrategy implements com.badlogic.gdx.graphics.g2d.PixmapPacker.PackStrategy {
        public java.util.Comparator<com.badlogic.gdx.graphics.Pixmap> a;

        /* renamed from: com.badlogic.gdx.graphics.g2d.PixmapPacker$SkylineStrategy$1, reason: invalid class name */
        public class AnonymousClass1 implements java.util.Comparator<com.badlogic.gdx.graphics.Pixmap> {
            public AnonymousClass1() {
            }

            @Override // java.util.Comparator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public int compare(com.badlogic.gdx.graphics.Pixmap pixmap, com.badlogic.gdx.graphics.Pixmap pixmap2) {
                return pixmap.getHeight() - pixmap2.getHeight();
            }
        }

        public static class SkylinePage extends com.badlogic.gdx.graphics.g2d.PixmapPacker.Page {
            public com.badlogic.gdx.utils.Array<com.badlogic.gdx.graphics.g2d.PixmapPacker.SkylineStrategy.SkylinePage.Row> f;

            public static class Row {
                public int a;
                public int b;
                public int c;
            }

            public SkylinePage(com.badlogic.gdx.graphics.g2d.PixmapPacker pixmapPacker) {
                super(pixmapPacker);
                this.f = new com.badlogic.gdx.utils.Array<>();
            }
        }

        @Override // com.badlogic.gdx.graphics.g2d.PixmapPacker.PackStrategy
        public com.badlogic.gdx.graphics.g2d.PixmapPacker.Page pack(com.badlogic.gdx.graphics.g2d.PixmapPacker pixmapPacker, java.lang.String str, com.badlogic.gdx.math.Rectangle rectangle) {
            int i;
            int i2 = pixmapPacker.f;
            int i3 = i2 * 2;
            int i4 = pixmapPacker.c - i3;
            int i5 = pixmapPacker.d - i3;
            int i6 = ((int) rectangle.width) + i2;
            int i7 = ((int) rectangle.height) + i2;
            int i8 = pixmapPacker.i.size;
            for (int i9 = 0; i9 < i8; i9++) {
                com.badlogic.gdx.graphics.g2d.PixmapPacker.SkylineStrategy.SkylinePage skylinePage = (com.badlogic.gdx.graphics.g2d.PixmapPacker.SkylineStrategy.SkylinePage) pixmapPacker.i.get(i9);
                int i10 = skylinePage.f.size - 1;
                com.badlogic.gdx.graphics.g2d.PixmapPacker.SkylineStrategy.SkylinePage.Row row = null;
                for (int i11 = 0; i11 < i10; i11++) {
                    com.badlogic.gdx.graphics.g2d.PixmapPacker.SkylineStrategy.SkylinePage.Row row2 = skylinePage.f.get(i11);
                    if (row2.a + i6 < i4 && row2.b + i7 < i5 && i7 <= (i = row2.c) && (row == null || i < row.c)) {
                        row = row2;
                    }
                }
                if (row == null) {
                    row = skylinePage.f.peek();
                    if (row.b + i7 < i5) {
                        if (row.a + i6 < i4) {
                            row.c = java.lang.Math.max(row.c, i7);
                        } else {
                            com.badlogic.gdx.graphics.g2d.PixmapPacker.SkylineStrategy.SkylinePage.Row row3 = new com.badlogic.gdx.graphics.g2d.PixmapPacker.SkylineStrategy.SkylinePage.Row();
                            row3.b = row.b + row.c;
                            row3.c = i7;
                            skylinePage.f.add(row3);
                            row = row3;
                        }
                    }
                }
                int i12 = row.a;
                rectangle.x = i12;
                rectangle.y = row.b;
                row.a = i12 + i6;
                return skylinePage;
            }
            com.badlogic.gdx.graphics.g2d.PixmapPacker.SkylineStrategy.SkylinePage skylinePage2 = new com.badlogic.gdx.graphics.g2d.PixmapPacker.SkylineStrategy.SkylinePage(pixmapPacker);
            pixmapPacker.i.add(skylinePage2);
            com.badlogic.gdx.graphics.g2d.PixmapPacker.SkylineStrategy.SkylinePage.Row row4 = new com.badlogic.gdx.graphics.g2d.PixmapPacker.SkylineStrategy.SkylinePage.Row();
            row4.a = i6 + i2;
            row4.b = i2;
            row4.c = i7;
            skylinePage2.f.add(row4);
            float f = i2;
            rectangle.x = f;
            rectangle.y = f;
            return skylinePage2;
        }

        @Override // com.badlogic.gdx.graphics.g2d.PixmapPacker.PackStrategy
        public void sort(com.badlogic.gdx.utils.Array<com.badlogic.gdx.graphics.Pixmap> array) {
            if (this.a == null) {
                this.a = new com.badlogic.gdx.graphics.g2d.PixmapPacker.SkylineStrategy.AnonymousClass1();
            }
            array.sort(this.a);
        }
    }

    public PixmapPacker(int i, int i2, com.badlogic.gdx.graphics.Pixmap.Format format, int i3, boolean z) {
        this(i, i2, format, i3, z, new com.badlogic.gdx.graphics.g2d.PixmapPacker.GuillotineStrategy());
    }

    public PixmapPacker(int i, int i2, com.badlogic.gdx.graphics.Pixmap.Format format, int i3, boolean z, com.badlogic.gdx.graphics.g2d.PixmapPacker.PackStrategy packStrategy) {
        this.h = new com.badlogic.gdx.graphics.Color(0.0f, 0.0f, 0.0f, 0.0f);
        this.i = new com.badlogic.gdx.utils.Array<>();
        this.c = i;
        this.d = i2;
        this.e = format;
        this.f = i3;
        this.g = z;
        this.j = packStrategy;
    }

    @Override // com.badlogic.gdx.utils.Disposable
    public synchronized void dispose() {
        java.util.Iterator<com.badlogic.gdx.graphics.g2d.PixmapPacker.Page> it = this.i.iterator();
        while (it.hasNext()) {
            com.badlogic.gdx.graphics.g2d.PixmapPacker.Page next = it.next();
            if (next.c == null) {
                next.b.dispose();
            }
        }
        this.b = true;
    }

    public synchronized com.badlogic.gdx.graphics.g2d.TextureAtlas generateTextureAtlas(com.badlogic.gdx.graphics.Texture.TextureFilter textureFilter, com.badlogic.gdx.graphics.Texture.TextureFilter textureFilter2, boolean z) {
        com.badlogic.gdx.graphics.g2d.TextureAtlas textureAtlas;
        textureAtlas = new com.badlogic.gdx.graphics.g2d.TextureAtlas();
        updateTextureAtlas(textureAtlas, textureFilter, textureFilter2, z);
        return textureAtlas;
    }

    public boolean getDuplicateBorder() {
        return this.g;
    }

    public boolean getPackToTexture() {
        return this.a;
    }

    public int getPadding() {
        return this.f;
    }

    public synchronized com.badlogic.gdx.graphics.g2d.PixmapPacker.Page getPage(java.lang.String str) {
        java.util.Iterator<com.badlogic.gdx.graphics.g2d.PixmapPacker.Page> it = this.i.iterator();
        while (it.hasNext()) {
            com.badlogic.gdx.graphics.g2d.PixmapPacker.Page next = it.next();
            if (next.a.get(str) != null) {
                return next;
            }
        }
        return null;
    }

    public com.badlogic.gdx.graphics.Pixmap.Format getPageFormat() {
        return this.e;
    }

    public int getPageHeight() {
        return this.d;
    }

    public synchronized int getPageIndex(java.lang.String str) {
        int i = 0;
        while (true) {
            com.badlogic.gdx.utils.Array<com.badlogic.gdx.graphics.g2d.PixmapPacker.Page> array = this.i;
            if (i >= array.size) {
                return -1;
            }
            if (array.get(i).a.get(str) != null) {
                return i;
            }
            i++;
        }
    }

    public int getPageWidth() {
        return this.c;
    }

    public com.badlogic.gdx.utils.Array<com.badlogic.gdx.graphics.g2d.PixmapPacker.Page> getPages() {
        return this.i;
    }

    public synchronized com.badlogic.gdx.math.Rectangle getRect(java.lang.String str) {
        java.util.Iterator<com.badlogic.gdx.graphics.g2d.PixmapPacker.Page> it = this.i.iterator();
        while (it.hasNext()) {
            com.badlogic.gdx.math.Rectangle rectangle = it.next().a.get(str);
            if (rectangle != null) {
                return rectangle;
            }
        }
        return null;
    }

    public com.badlogic.gdx.graphics.Color getTransparentColor() {
        return this.h;
    }

    public synchronized com.badlogic.gdx.math.Rectangle pack(com.badlogic.gdx.graphics.Pixmap pixmap) {
        return pack(null, pixmap);
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x0187, code lost:
    
        throw new com.badlogic.gdx.utils.GdxRuntimeException("Page size too small for pixmap.");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized com.badlogic.gdx.math.Rectangle pack(java.lang.String str, com.badlogic.gdx.graphics.Pixmap pixmap) {
        int i;
        com.badlogic.gdx.graphics.Texture texture;
        if (this.b) {
            return null;
        }
        if (str != null && getRect(str) != null) {
            throw new com.badlogic.gdx.utils.GdxRuntimeException("Pixmap has already been packed with name: " + str);
        }
        com.badlogic.gdx.math.Rectangle rectangle = new com.badlogic.gdx.math.Rectangle(0.0f, 0.0f, pixmap.getWidth(), pixmap.getHeight());
        if (rectangle.getWidth() <= this.c && rectangle.getHeight() <= this.d) {
            com.badlogic.gdx.graphics.g2d.PixmapPacker.Page pack = this.j.pack(this, str, rectangle);
            if (str != null) {
                pack.a.put(str, rectangle);
                pack.d.add(str);
            }
            int i2 = (int) rectangle.x;
            int i3 = (int) rectangle.y;
            int i4 = (int) rectangle.width;
            int i5 = (int) rectangle.height;
            if (!this.a || this.g || (texture = pack.c) == null || pack.e) {
                i = i5;
                pack.e = true;
            } else {
                texture.bind();
                i = i5;
                com.badlogic.gdx.Gdx.gl.glTexSubImage2D(pack.c.glTarget, 0, i2, i3, i4, i5, pixmap.getGLFormat(), pixmap.getGLType(), pixmap.getPixels());
            }
            pack.b.setBlending(com.badlogic.gdx.graphics.Pixmap.Blending.None);
            pack.b.drawPixmap(pixmap, i2, i3);
            if (this.g) {
                int width = pixmap.getWidth();
                int height = pixmap.getHeight();
                int i6 = i2 - 1;
                int i7 = i3 - 1;
                pack.b.drawPixmap(pixmap, 0, 0, 1, 1, i6, i7, 1, 1);
                int i8 = width - 1;
                int i9 = i2 + i4;
                pack.b.drawPixmap(pixmap, i8, 0, 1, 1, i9, i7, 1, 1);
                int i10 = height - 1;
                int i11 = i3 + i;
                pack.b.drawPixmap(pixmap, 0, i10, 1, 1, i6, i11, 1, 1);
                pack.b.drawPixmap(pixmap, i8, i10, 1, 1, i9, i11, 1, 1);
                pack.b.drawPixmap(pixmap, 0, 0, width, 1, i2, i7, i4, 1);
                pack.b.drawPixmap(pixmap, 0, i10, width, 1, i2, i11, i4, 1);
                pack.b.drawPixmap(pixmap, 0, 0, 1, height, i6, i3, 1, i);
                pack.b.drawPixmap(pixmap, i8, 0, 1, height, i9, i3, 1, i);
            }
            return rectangle;
        }
        throw new com.badlogic.gdx.utils.GdxRuntimeException("Page size too small for pixmap: " + str);
    }

    public void setDuplicateBorder(boolean z) {
        this.g = z;
    }

    public void setPackToTexture(boolean z) {
        this.a = z;
    }

    public void setPadding(int i) {
        this.f = i;
    }

    public void setPageFormat(com.badlogic.gdx.graphics.Pixmap.Format format) {
        this.e = format;
    }

    public void setPageHeight(int i) {
        this.d = i;
    }

    public void setPageWidth(int i) {
        this.c = i;
    }

    public void setTransparentColor(com.badlogic.gdx.graphics.Color color) {
        this.h.set(color);
    }

    public void sort(com.badlogic.gdx.utils.Array<com.badlogic.gdx.graphics.Pixmap> array) {
        this.j.sort(array);
    }

    public synchronized void updatePageTextures(com.badlogic.gdx.graphics.Texture.TextureFilter textureFilter, com.badlogic.gdx.graphics.Texture.TextureFilter textureFilter2, boolean z) {
        java.util.Iterator<com.badlogic.gdx.graphics.g2d.PixmapPacker.Page> it = this.i.iterator();
        while (it.hasNext()) {
            it.next().updateTexture(textureFilter, textureFilter2, z);
        }
    }

    public synchronized void updateTextureAtlas(com.badlogic.gdx.graphics.g2d.TextureAtlas textureAtlas, com.badlogic.gdx.graphics.Texture.TextureFilter textureFilter, com.badlogic.gdx.graphics.Texture.TextureFilter textureFilter2, boolean z) {
        updatePageTextures(textureFilter, textureFilter2, z);
        java.util.Iterator<com.badlogic.gdx.graphics.g2d.PixmapPacker.Page> it = this.i.iterator();
        while (it.hasNext()) {
            com.badlogic.gdx.graphics.g2d.PixmapPacker.Page next = it.next();
            com.badlogic.gdx.utils.Array<java.lang.String> array = next.d;
            if (array.size > 0) {
                java.util.Iterator<java.lang.String> it2 = array.iterator();
                while (it2.hasNext()) {
                    java.lang.String next2 = it2.next();
                    com.badlogic.gdx.math.Rectangle rectangle = next.a.get(next2);
                    textureAtlas.addRegion(next2, new com.badlogic.gdx.graphics.g2d.TextureRegion(next.c, (int) rectangle.x, (int) rectangle.y, (int) rectangle.width, (int) rectangle.height));
                }
                next.d.clear();
                textureAtlas.getTextures().add(next.c);
            }
        }
    }

    public synchronized void updateTextureRegions(com.badlogic.gdx.utils.Array<com.badlogic.gdx.graphics.g2d.TextureRegion> array, com.badlogic.gdx.graphics.Texture.TextureFilter textureFilter, com.badlogic.gdx.graphics.Texture.TextureFilter textureFilter2, boolean z) {
        updatePageTextures(textureFilter, textureFilter2, z);
        while (true) {
            int i = array.size;
            com.badlogic.gdx.utils.Array<com.badlogic.gdx.graphics.g2d.PixmapPacker.Page> array2 = this.i;
            if (i < array2.size) {
                array.add(new com.badlogic.gdx.graphics.g2d.TextureRegion(array2.get(i).c));
            }
        }
    }
}
