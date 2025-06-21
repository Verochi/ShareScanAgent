package com.esotericsoftware.spine;

/* loaded from: classes22.dex */
public class SkeletonRenderer {
    public static final short[] k = {0, 1, 2, 2, 3, 0};
    public boolean a;
    public com.esotericsoftware.spine.SkeletonRenderer.VertexEffect d;
    public final com.badlogic.gdx.utils.FloatArray b = new com.badlogic.gdx.utils.FloatArray(32);
    public final com.esotericsoftware.spine.utils.SkeletonClipping c = new com.esotericsoftware.spine.utils.SkeletonClipping();
    public final com.badlogic.gdx.math.Vector2 e = new com.badlogic.gdx.math.Vector2();
    public final com.badlogic.gdx.math.Vector2 f = new com.badlogic.gdx.math.Vector2();
    public final com.badlogic.gdx.graphics.Color g = new com.badlogic.gdx.graphics.Color();
    public final com.badlogic.gdx.graphics.Color h = new com.badlogic.gdx.graphics.Color();
    public final com.badlogic.gdx.graphics.Color i = new com.badlogic.gdx.graphics.Color();
    public final com.badlogic.gdx.graphics.Color j = new com.badlogic.gdx.graphics.Color();

    public interface VertexEffect {
        void begin(com.esotericsoftware.spine.Skeleton skeleton);

        void end();

        void transform(com.badlogic.gdx.math.Vector2 vector2, com.badlogic.gdx.math.Vector2 vector22, com.badlogic.gdx.graphics.Color color, com.badlogic.gdx.graphics.Color color2);
    }

    public final void a(float[] fArr, int i, int i2, float f, float f2) {
        com.badlogic.gdx.math.Vector2 vector2 = this.e;
        com.badlogic.gdx.math.Vector2 vector22 = this.f;
        com.badlogic.gdx.graphics.Color color = this.g;
        com.badlogic.gdx.graphics.Color color2 = this.h;
        com.badlogic.gdx.graphics.Color color3 = this.i;
        com.badlogic.gdx.graphics.Color color4 = this.j;
        com.esotericsoftware.spine.SkeletonRenderer.VertexEffect vertexEffect = this.d;
        color3.set(com.badlogic.gdx.utils.NumberUtils.floatToIntColor(f));
        color4.set(com.badlogic.gdx.utils.NumberUtils.floatToIntColor(f2));
        int i3 = 0;
        if (i2 == 5) {
            while (i3 < i) {
                vector2.x = fArr[i3];
                int i4 = i3 + 1;
                vector2.y = fArr[i4];
                int i5 = i3 + 3;
                vector22.x = fArr[i5];
                int i6 = i3 + 4;
                vector22.y = fArr[i6];
                color.set(color3);
                color2.set(color4);
                vertexEffect.transform(vector2, vector22, color, color2);
                fArr[i3] = vector2.x;
                fArr[i4] = vector2.y;
                fArr[i3 + 2] = color.toFloatBits();
                fArr[i5] = vector22.x;
                fArr[i6] = vector22.y;
                i3 += i2;
            }
            return;
        }
        while (i3 < i) {
            vector2.x = fArr[i3];
            int i7 = i3 + 1;
            vector2.y = fArr[i7];
            int i8 = i3 + 4;
            vector22.x = fArr[i8];
            int i9 = i3 + 5;
            vector22.y = fArr[i9];
            color.set(color3);
            color2.set(color4);
            vertexEffect.transform(vector2, vector22, color, color2);
            fArr[i3] = vector2.x;
            fArr[i7] = vector2.y;
            fArr[i3 + 2] = color.toFloatBits();
            fArr[i3 + 3] = color2.toFloatBits();
            fArr[i8] = vector22.x;
            fArr[i9] = vector22.y;
            i3 += i2;
        }
    }

    public void draw(com.badlogic.gdx.graphics.g2d.Batch batch, com.esotericsoftware.spine.Skeleton skeleton) {
        int i;
        int i2;
        float f;
        com.esotericsoftware.spine.Slot slot;
        com.esotericsoftware.spine.Skeleton skeleton2;
        float f2;
        com.esotericsoftware.spine.Slot slot2;
        float f3;
        com.esotericsoftware.spine.BlendMode blendMode;
        com.esotericsoftware.spine.attachments.RegionAttachment regionAttachment;
        com.esotericsoftware.spine.Slot slot3;
        com.esotericsoftware.spine.SkeletonRenderer.VertexEffect vertexEffect = this.d;
        if (vertexEffect != null) {
            vertexEffect.begin(skeleton);
        }
        boolean z = this.a;
        float[] fArr = this.b.items;
        com.badlogic.gdx.graphics.Color color = skeleton.k;
        float f4 = color.r;
        float f5 = color.g;
        float f6 = color.b;
        float f7 = color.a;
        com.badlogic.gdx.utils.Array<com.esotericsoftware.spine.Slot> array = skeleton.d;
        int i3 = array.size;
        com.esotericsoftware.spine.BlendMode blendMode2 = null;
        int i4 = 0;
        while (i4 < i3) {
            com.esotericsoftware.spine.Slot slot4 = array.get(i4);
            com.esotericsoftware.spine.attachments.Attachment attachment = slot4.e;
            if (attachment instanceof com.esotericsoftware.spine.attachments.RegionAttachment) {
                com.esotericsoftware.spine.attachments.RegionAttachment regionAttachment2 = (com.esotericsoftware.spine.attachments.RegionAttachment) attachment;
                i = i4;
                i2 = i3;
                regionAttachment2.computeWorldVertices(slot4.getBone(), fArr, 0, 5);
                com.badlogic.gdx.graphics.Color color2 = regionAttachment2.getColor();
                com.badlogic.gdx.graphics.Color color3 = slot4.getColor();
                f = f7;
                float f8 = color3.a * f7 * color2.a;
                float f9 = 255.0f;
                float f10 = f8 * 255.0f;
                if (z) {
                    f9 = f10;
                    f2 = f9;
                } else {
                    f2 = f10;
                }
                com.esotericsoftware.spine.BlendMode blendMode3 = slot4.a.getBlendMode();
                if (blendMode3 != blendMode2) {
                    if (blendMode3 == com.esotericsoftware.spine.BlendMode.additive && z) {
                        blendMode3 = com.esotericsoftware.spine.BlendMode.normal;
                        f2 = 0.0f;
                    }
                    slot2 = slot4;
                    batch.setBlendFunction(blendMode3.getSource(z), blendMode3.getDest());
                    float f11 = f2;
                    blendMode = blendMode3;
                    f3 = f11;
                } else {
                    slot2 = slot4;
                    f3 = f2;
                    blendMode = blendMode2;
                }
                float intToFloatColor = com.badlogic.gdx.utils.NumberUtils.intToFloatColor((((int) f3) << 24) | (((int) (((color3.b * f6) * color2.b) * f9)) << 16) | (((int) (((color3.g * f5) * color2.g) * f9)) << 8) | ((int) (color3.r * f4 * color2.r * f9)));
                float[] uVs = regionAttachment2.getUVs();
                int i5 = 2;
                int i6 = 0;
                while (i6 < 8) {
                    fArr[i5] = intToFloatColor;
                    fArr[i5 + 1] = uVs[i6];
                    fArr[i5 + 2] = uVs[i6 + 1];
                    i6 += 2;
                    i5 += 5;
                }
                if (vertexEffect != null) {
                    slot3 = slot2;
                    regionAttachment = regionAttachment2;
                    a(fArr, 20, 5, intToFloatColor, 0.0f);
                } else {
                    regionAttachment = regionAttachment2;
                    slot3 = slot2;
                }
                batch.draw(regionAttachment.getRegion().getTexture(), fArr, 0, 20);
                blendMode2 = blendMode;
                slot = slot3;
            } else {
                i = i4;
                i2 = i3;
                f = f7;
                if (attachment instanceof com.esotericsoftware.spine.attachments.ClippingAttachment) {
                    this.c.clipStart(slot4, (com.esotericsoftware.spine.attachments.ClippingAttachment) attachment);
                    i4 = i + 1;
                    i3 = i2;
                    f7 = f;
                } else {
                    slot = slot4;
                    if (attachment instanceof com.esotericsoftware.spine.attachments.MeshAttachment) {
                        throw new java.lang.RuntimeException(batch.getClass().getSimpleName() + " cannot render meshes, PolygonSpriteBatch or TwoColorPolygonBatch is required.");
                    }
                    if ((attachment instanceof com.esotericsoftware.spine.attachments.SkeletonAttachment) && (skeleton2 = ((com.esotericsoftware.spine.attachments.SkeletonAttachment) attachment).getSkeleton()) != null) {
                        draw(batch, skeleton2);
                    }
                }
            }
            this.c.clipEnd(slot);
            i4 = i + 1;
            i3 = i2;
            f7 = f;
        }
        this.c.clipEnd();
        if (vertexEffect != null) {
            vertexEffect.end();
        }
    }

    public void draw(com.badlogic.gdx.graphics.g2d.PolygonSpriteBatch polygonSpriteBatch, com.esotericsoftware.spine.Skeleton skeleton) {
        int i;
        int i2;
        com.badlogic.gdx.graphics.Color color;
        com.badlogic.gdx.math.Vector2 vector2;
        com.badlogic.gdx.graphics.Texture texture;
        com.badlogic.gdx.graphics.Color color2;
        int i3;
        float[] fArr;
        float[] fArr2;
        short[] sArr;
        com.esotericsoftware.spine.Skeleton skeleton2;
        float f;
        float f2;
        float f3;
        boolean z;
        com.badlogic.gdx.graphics.Color color3;
        com.badlogic.gdx.graphics.Color color4;
        com.badlogic.gdx.math.Vector2 vector22;
        com.badlogic.gdx.graphics.Color color5;
        int i4;
        short[] sArr2;
        int i5;
        com.badlogic.gdx.utils.Array<com.esotericsoftware.spine.Slot> array;
        com.badlogic.gdx.graphics.Color color6;
        int i6;
        float f4;
        com.esotericsoftware.spine.SkeletonRenderer.VertexEffect vertexEffect;
        com.badlogic.gdx.math.Vector2 vector23;
        com.badlogic.gdx.graphics.Color color7;
        com.esotericsoftware.spine.Slot slot;
        float f5;
        boolean z2;
        float f6;
        int i7;
        com.badlogic.gdx.graphics.Color color8;
        short[] sArr3;
        int i8;
        com.esotericsoftware.spine.BlendMode blendMode;
        float f7;
        com.badlogic.gdx.math.Vector2 vector24 = this.e;
        com.badlogic.gdx.math.Vector2 vector25 = this.f;
        com.badlogic.gdx.graphics.Color color9 = this.g;
        com.badlogic.gdx.graphics.Color color10 = this.h;
        com.badlogic.gdx.graphics.Color color11 = this.i;
        com.badlogic.gdx.graphics.Color color12 = this.j;
        com.esotericsoftware.spine.SkeletonRenderer.VertexEffect vertexEffect2 = this.d;
        if (vertexEffect2 != null) {
            vertexEffect2.begin(skeleton);
        }
        boolean z3 = this.a;
        com.badlogic.gdx.graphics.Color color13 = skeleton.k;
        float f8 = color13.r;
        float f9 = color13.g;
        float f10 = color13.b;
        float f11 = color13.a;
        com.badlogic.gdx.utils.Array<com.esotericsoftware.spine.Slot> array2 = skeleton.d;
        int i9 = array2.size;
        com.badlogic.gdx.math.Vector2 vector26 = vector25;
        com.badlogic.gdx.graphics.Color color14 = color11;
        com.badlogic.gdx.graphics.Color color15 = null;
        com.esotericsoftware.spine.BlendMode blendMode2 = null;
        float[] fArr3 = null;
        float[] fArr4 = null;
        short[] sArr4 = null;
        int i10 = 0;
        int i11 = 0;
        while (i10 < i9) {
            int i12 = i10;
            com.esotericsoftware.spine.Slot slot2 = array2.get(i10);
            if (this.c.isClipping()) {
                i2 = i9;
                i = 2;
            } else {
                i = 5;
                i2 = i9;
            }
            com.esotericsoftware.spine.attachments.Attachment attachment = slot2.e;
            com.badlogic.gdx.utils.Array<com.esotericsoftware.spine.Slot> array3 = array2;
            if (attachment instanceof com.esotericsoftware.spine.attachments.RegionAttachment) {
                com.esotericsoftware.spine.attachments.RegionAttachment regionAttachment = (com.esotericsoftware.spine.attachments.RegionAttachment) attachment;
                int i13 = i << 2;
                float[] fArr5 = this.b.items;
                color = color12;
                vector2 = vector24;
                regionAttachment.computeWorldVertices(slot2.getBone(), fArr5, 0, i);
                short[] sArr5 = k;
                texture = regionAttachment.getRegion().getTexture();
                fArr2 = regionAttachment.getUVs();
                fArr = fArr5;
                i3 = i13;
                color2 = regionAttachment.getColor();
                sArr = sArr5;
            } else {
                color = color12;
                vector2 = vector24;
                if (attachment instanceof com.esotericsoftware.spine.attachments.MeshAttachment) {
                    com.esotericsoftware.spine.attachments.MeshAttachment meshAttachment = (com.esotericsoftware.spine.attachments.MeshAttachment) attachment;
                    int worldVerticesLength = meshAttachment.getWorldVerticesLength();
                    i3 = (worldVerticesLength >> 1) * i;
                    float[] size = this.b.setSize(i3);
                    meshAttachment.computeWorldVertices(slot2, 0, worldVerticesLength, size, 0, i);
                    short[] triangles = meshAttachment.getTriangles();
                    com.badlogic.gdx.graphics.Texture texture2 = meshAttachment.getRegion().getTexture();
                    fArr2 = meshAttachment.getUVs();
                    color2 = meshAttachment.getColor();
                    sArr = triangles;
                    texture = texture2;
                    fArr = size;
                } else if (attachment instanceof com.esotericsoftware.spine.attachments.ClippingAttachment) {
                    this.c.clipStart(slot2, (com.esotericsoftware.spine.attachments.ClippingAttachment) attachment);
                    f = f11;
                    f2 = f10;
                    f3 = f8;
                    z = z3;
                    color3 = color10;
                    color4 = color9;
                    vector22 = vector26;
                    color5 = color14;
                    i4 = i11;
                    fArr2 = fArr4;
                    sArr2 = sArr4;
                    i5 = i2;
                    array = array3;
                    color6 = color;
                    i6 = i12;
                    f4 = f9;
                    vertexEffect = vertexEffect2;
                    vector23 = vector2;
                    i10 = i6 + 1;
                    color14 = color5;
                    color10 = color3;
                    color9 = color4;
                    vector24 = vector23;
                    z3 = z;
                    vertexEffect2 = vertexEffect;
                    f9 = f4;
                    i9 = i5;
                    array2 = array;
                    f11 = f;
                    f8 = f3;
                    sArr4 = sArr2;
                    fArr4 = fArr2;
                    i11 = i4;
                    color12 = color6;
                    vector26 = vector22;
                    f10 = f2;
                } else {
                    if ((attachment instanceof com.esotericsoftware.spine.attachments.SkeletonAttachment) && (skeleton2 = ((com.esotericsoftware.spine.attachments.SkeletonAttachment) attachment).getSkeleton()) != null) {
                        draw(polygonSpriteBatch, skeleton2);
                    }
                    texture = null;
                    color2 = color15;
                    i3 = i11;
                    fArr = fArr3;
                    fArr2 = fArr4;
                    sArr = sArr4;
                }
            }
            if (texture != null) {
                com.badlogic.gdx.graphics.Color color16 = slot2.getColor();
                com.badlogic.gdx.graphics.Color color17 = color10;
                float f12 = f11;
                float f13 = color16.a * f11 * color2.a;
                float f14 = 255.0f;
                float f15 = f13 * 255.0f;
                if (z3) {
                    f14 = f15;
                    f5 = f14;
                } else {
                    f5 = f15;
                }
                com.esotericsoftware.spine.BlendMode blendMode3 = slot2.a.getBlendMode();
                com.esotericsoftware.spine.BlendMode blendMode4 = blendMode2;
                if (blendMode3 != blendMode4) {
                    if (blendMode3 == com.esotericsoftware.spine.BlendMode.additive && z3) {
                        blendMode = com.esotericsoftware.spine.BlendMode.normal;
                        f7 = 0.0f;
                    } else {
                        blendMode = blendMode3;
                        f7 = f5;
                    }
                    z2 = z3;
                    polygonSpriteBatch.setBlendFunction(blendMode.getSource(z3), blendMode.getDest());
                    f6 = f7;
                    blendMode2 = blendMode;
                } else {
                    z2 = z3;
                    blendMode2 = blendMode4;
                    f6 = f5;
                }
                float intToFloatColor = com.badlogic.gdx.utils.NumberUtils.intToFloatColor(((int) (color16.r * f8 * color2.r * f14)) | (((int) f6) << 24) | (((int) (((color16.b * f10) * color2.b) * f14)) << 16) | (((int) (((color16.g * f9) * color2.g) * f14)) << 8));
                if (this.c.isClipping()) {
                    this.c.clipTriangles(fArr, i3, sArr, sArr.length, fArr2, intToFloatColor, 0.0f, false);
                    com.badlogic.gdx.utils.FloatArray clippedVertices = this.c.getClippedVertices();
                    com.badlogic.gdx.utils.ShortArray clippedTriangles = this.c.getClippedTriangles();
                    if (vertexEffect2 != null) {
                        sArr3 = sArr;
                        i5 = i2;
                        i8 = i3;
                        array = array3;
                        f = f12;
                        f2 = f10;
                        f4 = f9;
                        f3 = f8;
                        a(clippedVertices.items, clippedVertices.size, 5, intToFloatColor, 0.0f);
                    } else {
                        sArr3 = sArr;
                        i8 = i3;
                        f2 = f10;
                        f4 = f9;
                        f3 = f8;
                        i5 = i2;
                        array = array3;
                        f = f12;
                    }
                    z = z2;
                    color7 = color2;
                    color5 = color14;
                    slot = slot2;
                    i6 = i12;
                    color3 = color17;
                    color4 = color9;
                    com.badlogic.gdx.math.Vector2 vector27 = vector26;
                    vector23 = vector2;
                    polygonSpriteBatch.draw(texture, clippedVertices.items, 0, clippedVertices.size, clippedTriangles.items, 0, clippedTriangles.size);
                    sArr2 = sArr3;
                    i4 = i8;
                    vertexEffect = vertexEffect2;
                    vector22 = vector27;
                    color6 = color;
                } else {
                    short[] sArr6 = sArr;
                    int i14 = i3;
                    f2 = f10;
                    f4 = f9;
                    f3 = f8;
                    com.esotericsoftware.spine.SkeletonRenderer.VertexEffect vertexEffect3 = vertexEffect2;
                    color7 = color2;
                    color4 = color9;
                    com.badlogic.gdx.math.Vector2 vector28 = vector26;
                    color5 = color14;
                    color3 = color17;
                    i5 = i2;
                    array = array3;
                    com.badlogic.gdx.graphics.Color color18 = color;
                    vector23 = vector2;
                    f = f12;
                    slot = slot2;
                    z = z2;
                    i6 = i12;
                    if (vertexEffect3 != null) {
                        color5.set(com.badlogic.gdx.utils.NumberUtils.floatToIntColor(intToFloatColor));
                        color8 = color18;
                        color8.set(0);
                        i7 = i14;
                        int i15 = 0;
                        int i16 = 0;
                        while (i15 < i7) {
                            vector23.x = fArr[i15];
                            int i17 = i15 + 1;
                            vector23.y = fArr[i17];
                            color4.set(color5);
                            color3.set(color8);
                            vector28.x = fArr2[i16];
                            vector28.y = fArr2[i16 + 1];
                            vertexEffect3.transform(vector23, vector28, color4, color3);
                            fArr[i15] = vector23.x;
                            fArr[i17] = vector23.y;
                            fArr[i15 + 2] = color4.toFloatBits();
                            fArr[i15 + 3] = vector28.x;
                            fArr[i15 + 4] = vector28.y;
                            i15 += 5;
                            i16 += 2;
                        }
                        vector22 = vector28;
                    } else {
                        i7 = i14;
                        vector22 = vector28;
                        color8 = color18;
                        int i18 = 0;
                        int i19 = 2;
                        while (i19 < i7) {
                            fArr[i19] = intToFloatColor;
                            fArr[i19 + 1] = fArr2[i18];
                            fArr[i19 + 2] = fArr2[i18 + 1];
                            i19 += 5;
                            i18 += 2;
                        }
                    }
                    sArr2 = sArr6;
                    i4 = i7;
                    color6 = color8;
                    vertexEffect = vertexEffect3;
                    polygonSpriteBatch.draw(texture, fArr, 0, i7, sArr2, 0, sArr6.length);
                }
            } else {
                sArr2 = sArr;
                i4 = i3;
                f = f11;
                f2 = f10;
                f4 = f9;
                f3 = f8;
                z = z3;
                color7 = color2;
                slot = slot2;
                color3 = color10;
                color4 = color9;
                vector22 = vector26;
                color5 = color14;
                i5 = i2;
                array = array3;
                color6 = color;
                vector23 = vector2;
                i6 = i12;
                vertexEffect = vertexEffect2;
            }
            this.c.clipEnd(slot);
            com.badlogic.gdx.graphics.Color color19 = color7;
            fArr3 = fArr;
            color15 = color19;
            i10 = i6 + 1;
            color14 = color5;
            color10 = color3;
            color9 = color4;
            vector24 = vector23;
            z3 = z;
            vertexEffect2 = vertexEffect;
            f9 = f4;
            i9 = i5;
            array2 = array;
            f11 = f;
            f8 = f3;
            sArr4 = sArr2;
            fArr4 = fArr2;
            i11 = i4;
            color12 = color6;
            vector26 = vector22;
            f10 = f2;
        }
        com.esotericsoftware.spine.SkeletonRenderer.VertexEffect vertexEffect4 = vertexEffect2;
        this.c.clipEnd();
        if (vertexEffect4 != null) {
            vertexEffect4.end();
        }
    }

    public void draw(com.esotericsoftware.spine.utils.TwoColorPolygonBatch twoColorPolygonBatch, com.esotericsoftware.spine.Skeleton skeleton) {
        int i;
        int i2;
        com.badlogic.gdx.graphics.Color color;
        com.badlogic.gdx.math.Vector2 vector2;
        com.badlogic.gdx.graphics.Texture texture;
        com.badlogic.gdx.graphics.Color color2;
        float[] fArr;
        int i3;
        short[] sArr;
        float[] fArr2;
        com.esotericsoftware.spine.Skeleton skeleton2;
        float f;
        float f2;
        boolean z;
        com.badlogic.gdx.graphics.Color color3;
        com.badlogic.gdx.graphics.Color color4;
        com.badlogic.gdx.math.Vector2 vector22;
        com.badlogic.gdx.graphics.Color color5;
        float[] fArr3;
        int i4;
        short[] sArr2;
        int i5;
        com.badlogic.gdx.utils.Array<com.esotericsoftware.spine.Slot> array;
        com.badlogic.gdx.graphics.Color color6;
        int i6;
        float f3;
        float f4;
        com.esotericsoftware.spine.SkeletonRenderer.VertexEffect vertexEffect;
        com.badlogic.gdx.math.Vector2 vector23;
        com.badlogic.gdx.graphics.Color color7;
        com.esotericsoftware.spine.Slot slot;
        float f5;
        boolean z2;
        float f6;
        int i7;
        com.badlogic.gdx.graphics.Color color8;
        short[] sArr3;
        int i8;
        com.esotericsoftware.spine.BlendMode blendMode;
        float f7;
        com.badlogic.gdx.math.Vector2 vector24 = this.e;
        com.badlogic.gdx.math.Vector2 vector25 = this.f;
        com.badlogic.gdx.graphics.Color color9 = this.g;
        com.badlogic.gdx.graphics.Color color10 = this.h;
        com.badlogic.gdx.graphics.Color color11 = this.i;
        com.badlogic.gdx.graphics.Color color12 = this.j;
        com.esotericsoftware.spine.SkeletonRenderer.VertexEffect vertexEffect2 = this.d;
        if (vertexEffect2 != null) {
            vertexEffect2.begin(skeleton);
        }
        boolean z3 = this.a;
        twoColorPolygonBatch.setPremultipliedAlpha(z3);
        com.badlogic.gdx.graphics.Color color13 = skeleton.k;
        float f8 = color13.r;
        float f9 = color13.g;
        float f10 = color13.b;
        float f11 = color13.a;
        com.badlogic.gdx.utils.Array<com.esotericsoftware.spine.Slot> array2 = skeleton.d;
        int i9 = array2.size;
        com.badlogic.gdx.math.Vector2 vector26 = vector25;
        com.badlogic.gdx.graphics.Color color14 = color11;
        com.badlogic.gdx.graphics.Color color15 = null;
        com.esotericsoftware.spine.BlendMode blendMode2 = null;
        float[] fArr4 = null;
        short[] sArr4 = null;
        float[] fArr5 = null;
        int i10 = 0;
        int i11 = 0;
        while (i10 < i9) {
            int i12 = i10;
            com.esotericsoftware.spine.Slot slot2 = array2.get(i10);
            if (this.c.isClipping()) {
                i2 = i9;
                i = 2;
            } else {
                i = 6;
                i2 = i9;
            }
            com.esotericsoftware.spine.attachments.Attachment attachment = slot2.e;
            com.badlogic.gdx.utils.Array<com.esotericsoftware.spine.Slot> array3 = array2;
            if (attachment instanceof com.esotericsoftware.spine.attachments.RegionAttachment) {
                com.esotericsoftware.spine.attachments.RegionAttachment regionAttachment = (com.esotericsoftware.spine.attachments.RegionAttachment) attachment;
                int i13 = i << 2;
                float[] fArr6 = this.b.items;
                color = color12;
                vector2 = vector24;
                regionAttachment.computeWorldVertices(slot2.getBone(), fArr6, 0, i);
                short[] sArr5 = k;
                texture = regionAttachment.getRegion().getTexture();
                fArr2 = regionAttachment.getUVs();
                fArr = fArr6;
                i3 = i13;
                color2 = regionAttachment.getColor();
                sArr = sArr5;
            } else {
                color = color12;
                vector2 = vector24;
                if (attachment instanceof com.esotericsoftware.spine.attachments.MeshAttachment) {
                    com.esotericsoftware.spine.attachments.MeshAttachment meshAttachment = (com.esotericsoftware.spine.attachments.MeshAttachment) attachment;
                    int worldVerticesLength = meshAttachment.getWorldVerticesLength();
                    i3 = (worldVerticesLength >> 1) * i;
                    float[] size = this.b.setSize(i3);
                    meshAttachment.computeWorldVertices(slot2, 0, worldVerticesLength, size, 0, i);
                    short[] triangles = meshAttachment.getTriangles();
                    com.badlogic.gdx.graphics.Texture texture2 = meshAttachment.getRegion().getTexture();
                    fArr2 = meshAttachment.getUVs();
                    color2 = meshAttachment.getColor();
                    sArr = triangles;
                    texture = texture2;
                    fArr = size;
                } else if (attachment instanceof com.esotericsoftware.spine.attachments.ClippingAttachment) {
                    this.c.clipStart(slot2, (com.esotericsoftware.spine.attachments.ClippingAttachment) attachment);
                    f = f10;
                    f2 = f8;
                    z = z3;
                    color3 = color10;
                    color4 = color9;
                    vector22 = vector26;
                    color5 = color14;
                    fArr3 = fArr4;
                    i4 = i11;
                    sArr2 = sArr4;
                    fArr2 = fArr5;
                    i5 = i2;
                    array = array3;
                    color6 = color;
                    i6 = i12;
                    f3 = f11;
                    f4 = f9;
                    vertexEffect = vertexEffect2;
                    vector23 = vector2;
                    i10 = i6 + 1;
                    color14 = color5;
                    color10 = color3;
                    vector24 = vector23;
                    vertexEffect2 = vertexEffect;
                    color12 = color6;
                    f9 = f4;
                    i9 = i5;
                    array2 = array;
                    f11 = f3;
                    f8 = f2;
                    vector26 = vector22;
                    i11 = i4;
                    fArr5 = fArr2;
                    sArr4 = sArr2;
                    color9 = color4;
                    fArr4 = fArr3;
                    z3 = z;
                    f10 = f;
                } else {
                    if ((attachment instanceof com.esotericsoftware.spine.attachments.SkeletonAttachment) && (skeleton2 = ((com.esotericsoftware.spine.attachments.SkeletonAttachment) attachment).getSkeleton()) != null) {
                        draw(twoColorPolygonBatch, skeleton2);
                    }
                    texture = null;
                    color2 = color15;
                    fArr = fArr4;
                    i3 = i11;
                    sArr = sArr4;
                    fArr2 = fArr5;
                }
            }
            if (texture != null) {
                com.badlogic.gdx.graphics.Color color16 = slot2.getColor();
                com.badlogic.gdx.graphics.Color color17 = color10;
                float f12 = f11;
                float f13 = color16.a * f11 * color2.a;
                float f14 = 255.0f;
                float f15 = f13 * 255.0f;
                if (z3) {
                    f14 = f15;
                    f5 = f14;
                } else {
                    f5 = f15;
                }
                com.esotericsoftware.spine.BlendMode blendMode3 = slot2.a.getBlendMode();
                com.badlogic.gdx.graphics.Color color18 = color9;
                com.esotericsoftware.spine.BlendMode blendMode4 = blendMode2;
                if (blendMode3 != blendMode4) {
                    if (blendMode3 == com.esotericsoftware.spine.BlendMode.additive && z3) {
                        blendMode = com.esotericsoftware.spine.BlendMode.normal;
                        f7 = 0.0f;
                    } else {
                        blendMode = blendMode3;
                        f7 = f5;
                    }
                    z2 = z3;
                    twoColorPolygonBatch.setBlendFunction(blendMode.getSource(z3), blendMode.getDest());
                    f6 = f7;
                    blendMode2 = blendMode;
                } else {
                    z2 = z3;
                    blendMode2 = blendMode4;
                    f6 = f5;
                }
                float f16 = color2.r * f8 * f14;
                float f17 = color2.g * f9 * f14;
                float f18 = f9;
                float f19 = color2.b * f10 * f14;
                float intToFloatColor = com.badlogic.gdx.utils.NumberUtils.intToFloatColor((((int) f6) << 24) | (((int) (color16.b * f19)) << 16) | (((int) (color16.g * f17)) << 8) | ((int) (color16.r * f16)));
                com.badlogic.gdx.graphics.Color darkColor = slot2.getDarkColor();
                float intToFloatColor2 = darkColor == null ? 0.0f : com.badlogic.gdx.utils.NumberUtils.intToFloatColor(((int) (f16 * darkColor.r)) | (((int) (f19 * darkColor.b)) << 16) | (((int) (f17 * darkColor.g)) << 8));
                if (this.c.isClipping()) {
                    this.c.clipTriangles(fArr, i3, sArr, sArr.length, fArr2, intToFloatColor, intToFloatColor2, true);
                    com.badlogic.gdx.utils.FloatArray clippedVertices = this.c.getClippedVertices();
                    com.badlogic.gdx.utils.ShortArray clippedTriangles = this.c.getClippedTriangles();
                    if (vertexEffect2 != null) {
                        sArr3 = sArr;
                        i5 = i2;
                        i8 = i3;
                        array = array3;
                        f3 = f12;
                        f = f10;
                        f4 = f18;
                        f2 = f8;
                        a(clippedVertices.items, clippedVertices.size, 6, intToFloatColor, intToFloatColor2);
                    } else {
                        sArr3 = sArr;
                        i8 = i3;
                        f = f10;
                        f2 = f8;
                        i5 = i2;
                        array = array3;
                        f3 = f12;
                        f4 = f18;
                    }
                    z = z2;
                    vertexEffect = vertexEffect2;
                    color7 = color2;
                    color6 = color;
                    color5 = color14;
                    i6 = i12;
                    color3 = color17;
                    slot = slot2;
                    vector23 = vector2;
                    twoColorPolygonBatch.draw(texture, clippedVertices.items, 0, clippedVertices.size, clippedTriangles.items, 0, clippedTriangles.size);
                    sArr2 = sArr3;
                    i4 = i8;
                    color4 = color18;
                    vector22 = vector26;
                } else {
                    short[] sArr6 = sArr;
                    int i14 = i3;
                    f = f10;
                    f2 = f8;
                    vertexEffect = vertexEffect2;
                    color7 = color2;
                    slot = slot2;
                    com.badlogic.gdx.math.Vector2 vector27 = vector26;
                    color5 = color14;
                    color3 = color17;
                    i5 = i2;
                    array = array3;
                    color6 = color;
                    vector23 = vector2;
                    f3 = f12;
                    z = z2;
                    f4 = f18;
                    i6 = i12;
                    if (vertexEffect != null) {
                        color5.set(com.badlogic.gdx.utils.NumberUtils.floatToIntColor(intToFloatColor));
                        color6.set(com.badlogic.gdx.utils.NumberUtils.floatToIntColor(intToFloatColor2));
                        i7 = i14;
                        int i15 = 0;
                        int i16 = 0;
                        while (i15 < i7) {
                            vector23.x = fArr[i15];
                            int i17 = i15 + 1;
                            vector23.y = fArr[i17];
                            color18.set(color5);
                            color3.set(color6);
                            vector27.x = fArr2[i16];
                            vector27.y = fArr2[i16 + 1];
                            vertexEffect.transform(vector23, vector27, color18, color3);
                            fArr[i15] = vector23.x;
                            fArr[i17] = vector23.y;
                            fArr[i15 + 2] = color18.toFloatBits();
                            fArr[i15 + 3] = color3.toFloatBits();
                            fArr[i15 + 4] = vector27.x;
                            fArr[i15 + 5] = vector27.y;
                            i15 += 6;
                            i16 += 2;
                        }
                        color8 = color18;
                        vector22 = vector27;
                    } else {
                        i7 = i14;
                        color8 = color18;
                        vector22 = vector27;
                        int i18 = 0;
                        int i19 = 2;
                        while (i19 < i7) {
                            fArr[i19] = intToFloatColor;
                            fArr[i19 + 1] = intToFloatColor2;
                            fArr[i19 + 2] = fArr2[i18];
                            fArr[i19 + 3] = fArr2[i18 + 1];
                            i19 += 6;
                            i18 += 2;
                        }
                    }
                    sArr2 = sArr6;
                    color4 = color8;
                    i4 = i7;
                    twoColorPolygonBatch.draw(texture, fArr, 0, i7, sArr2, 0, sArr6.length);
                }
            } else {
                sArr2 = sArr;
                i4 = i3;
                f3 = f11;
                f = f10;
                f4 = f9;
                f2 = f8;
                z = z3;
                vertexEffect = vertexEffect2;
                color7 = color2;
                slot = slot2;
                color3 = color10;
                color4 = color9;
                vector22 = vector26;
                color5 = color14;
                i5 = i2;
                array = array3;
                color6 = color;
                vector23 = vector2;
                i6 = i12;
            }
            this.c.clipEnd(slot);
            fArr3 = fArr;
            color15 = color7;
            i10 = i6 + 1;
            color14 = color5;
            color10 = color3;
            vector24 = vector23;
            vertexEffect2 = vertexEffect;
            color12 = color6;
            f9 = f4;
            i9 = i5;
            array2 = array;
            f11 = f3;
            f8 = f2;
            vector26 = vector22;
            i11 = i4;
            fArr5 = fArr2;
            sArr4 = sArr2;
            color9 = color4;
            fArr4 = fArr3;
            z3 = z;
            f10 = f;
        }
        com.esotericsoftware.spine.SkeletonRenderer.VertexEffect vertexEffect3 = vertexEffect2;
        this.c.clipEnd();
        if (vertexEffect3 != null) {
            vertexEffect3.end();
        }
    }

    public boolean getPremultipliedAlpha() {
        return this.a;
    }

    public com.esotericsoftware.spine.SkeletonRenderer.VertexEffect getVertexEffect() {
        return this.d;
    }

    public void setPremultipliedAlpha(boolean z) {
        this.a = z;
    }

    public void setVertexEffect(com.esotericsoftware.spine.SkeletonRenderer.VertexEffect vertexEffect) {
        this.d = vertexEffect;
    }
}
