package com.esotericsoftware.spine;

/* loaded from: classes22.dex */
public class SkeletonRendererDebug {
    public static final com.badlogic.gdx.graphics.Color q = com.badlogic.gdx.graphics.Color.RED;
    public static final com.badlogic.gdx.graphics.Color r = com.badlogic.gdx.graphics.Color.GREEN;

    /* renamed from: s, reason: collision with root package name */
    public static final com.badlogic.gdx.graphics.Color f309s = new com.badlogic.gdx.graphics.Color(0.0f, 0.0f, 1.0f, 0.5f);
    public static final com.badlogic.gdx.graphics.Color t = new com.badlogic.gdx.graphics.Color(1.0f, 0.64f, 0.0f, 0.5f);
    public static final com.badlogic.gdx.graphics.Color u = new com.badlogic.gdx.graphics.Color(0.0f, 1.0f, 0.0f, 0.5f);
    public final com.badlogic.gdx.graphics.glutils.ShapeRenderer a;
    public boolean b;
    public boolean c;
    public boolean d;
    public boolean e;
    public boolean f;
    public boolean g;
    public boolean h;
    public boolean i;
    public final com.esotericsoftware.spine.SkeletonBounds j;
    public final com.badlogic.gdx.utils.FloatArray k;
    public float l;
    public float m;
    public boolean n;
    public final com.badlogic.gdx.math.Vector2 o;
    public final com.badlogic.gdx.math.Vector2 p;

    public SkeletonRendererDebug() {
        this.b = true;
        this.c = true;
        this.d = true;
        this.e = true;
        this.f = true;
        this.g = true;
        this.h = true;
        this.i = true;
        this.j = new com.esotericsoftware.spine.SkeletonBounds();
        this.k = new com.badlogic.gdx.utils.FloatArray(32);
        this.l = 1.0f;
        this.m = 2.0f;
        this.o = new com.badlogic.gdx.math.Vector2();
        this.p = new com.badlogic.gdx.math.Vector2();
        this.a = new com.badlogic.gdx.graphics.glutils.ShapeRenderer();
    }

    public SkeletonRendererDebug(com.badlogic.gdx.graphics.glutils.ShapeRenderer shapeRenderer) {
        this.b = true;
        this.c = true;
        this.d = true;
        this.e = true;
        this.f = true;
        this.g = true;
        this.h = true;
        this.i = true;
        this.j = new com.esotericsoftware.spine.SkeletonBounds();
        this.k = new com.badlogic.gdx.utils.FloatArray(32);
        this.l = 1.0f;
        this.m = 2.0f;
        this.o = new com.badlogic.gdx.math.Vector2();
        this.p = new com.badlogic.gdx.math.Vector2();
        this.a = shapeRenderer;
    }

    public void draw(com.esotericsoftware.spine.Skeleton skeleton) {
        float f;
        float f2;
        com.badlogic.gdx.graphics.Color color;
        int i;
        int i2;
        int i3;
        int i4;
        com.badlogic.gdx.Gdx.gl.glEnable(com.badlogic.gdx.graphics.GL20.GL_BLEND);
        com.badlogic.gdx.Gdx.gl.glBlendFunc(this.n ? 1 : com.badlogic.gdx.graphics.GL20.GL_SRC_ALPHA, com.badlogic.gdx.graphics.GL20.GL_ONE_MINUS_SRC_ALPHA);
        com.badlogic.gdx.graphics.glutils.ShapeRenderer shapeRenderer = this.a;
        com.badlogic.gdx.utils.Array<com.esotericsoftware.spine.Bone> bones = skeleton.getBones();
        com.badlogic.gdx.utils.Array<com.esotericsoftware.spine.Slot> slots = skeleton.getSlots();
        shapeRenderer.begin(com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType.Filled);
        char c = 0;
        if (this.b) {
            int i5 = bones.size;
            int i6 = 0;
            while (i6 < i5) {
                com.esotericsoftware.spine.Bone bone = bones.get(i6);
                if (bone.c == null) {
                    i4 = i6;
                } else {
                    float f3 = bone.a.d;
                    float f4 = this.m;
                    if (f3 == 0.0f) {
                        f4 /= 2.0f;
                        shapeRenderer.setColor(r);
                        f3 = 8.0f;
                    } else {
                        shapeRenderer.setColor(q);
                    }
                    float f5 = bone.t * f3;
                    float f6 = bone.v;
                    float f7 = f3 * bone.w;
                    float f8 = bone.y;
                    i4 = i6;
                    shapeRenderer.rectLine(f6, f8, f5 + f6, f7 + f8, f4 * this.l);
                }
                i6 = i4 + 1;
            }
            shapeRenderer.x(skeleton.getX(), skeleton.getY(), this.l * 4.0f);
        }
        if (this.e) {
            shapeRenderer.setColor(r);
            int i7 = slots.size;
            for (int i8 = 0; i8 < i7; i8++) {
                com.esotericsoftware.spine.Slot slot = slots.get(i8);
                com.esotericsoftware.spine.attachments.Attachment attachment = slot.e;
                if (attachment instanceof com.esotericsoftware.spine.attachments.PointAttachment) {
                    com.esotericsoftware.spine.attachments.PointAttachment pointAttachment = (com.esotericsoftware.spine.attachments.PointAttachment) attachment;
                    pointAttachment.computeWorldPosition(slot.getBone(), this.o);
                    this.p.set(8.0f, 0.0f).rotate(pointAttachment.computeWorldRotation(slot.getBone()));
                    shapeRenderer.rectLine(this.o, this.p, (this.m / 2.0f) * this.l);
                }
            }
        }
        shapeRenderer.end();
        shapeRenderer.begin(com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType.Line);
        if (this.c) {
            shapeRenderer.setColor(f309s);
            int i9 = slots.size;
            for (int i10 = 0; i10 < i9; i10++) {
                com.esotericsoftware.spine.Slot slot2 = slots.get(i10);
                com.esotericsoftware.spine.attachments.Attachment attachment2 = slot2.e;
                if (attachment2 instanceof com.esotericsoftware.spine.attachments.RegionAttachment) {
                    float[] fArr = this.k.items;
                    ((com.esotericsoftware.spine.attachments.RegionAttachment) attachment2).computeWorldVertices(slot2.getBone(), fArr, 0, 2);
                    shapeRenderer.line(fArr[0], fArr[1], fArr[2], fArr[3]);
                    shapeRenderer.line(fArr[2], fArr[3], fArr[4], fArr[5]);
                    shapeRenderer.line(fArr[4], fArr[5], fArr[6], fArr[7]);
                    shapeRenderer.line(fArr[6], fArr[7], fArr[0], fArr[1]);
                }
            }
        }
        if (this.f || this.g) {
            int i11 = slots.size;
            for (int i12 = 0; i12 < i11; i12++) {
                com.esotericsoftware.spine.Slot slot3 = slots.get(i12);
                com.esotericsoftware.spine.attachments.Attachment attachment3 = slot3.e;
                if (attachment3 instanceof com.esotericsoftware.spine.attachments.MeshAttachment) {
                    com.esotericsoftware.spine.attachments.MeshAttachment meshAttachment = (com.esotericsoftware.spine.attachments.MeshAttachment) attachment3;
                    float[] size = this.k.setSize(meshAttachment.getWorldVerticesLength());
                    meshAttachment.computeWorldVertices(slot3, 0, meshAttachment.getWorldVerticesLength(), size, 0, 2);
                    short[] triangles = meshAttachment.getTriangles();
                    int hullLength = meshAttachment.getHullLength();
                    if (this.g) {
                        shapeRenderer.setColor(t);
                        int length = triangles.length;
                        int i13 = 0;
                        while (i13 < length) {
                            int i14 = triangles[i13] * 2;
                            int i15 = triangles[i13 + 1] * 2;
                            int i16 = triangles[i13 + 2] * 2;
                            shapeRenderer.triangle(size[i14], size[i14 + 1], size[i15], size[i15 + 1], size[i16], size[i16 + 1]);
                            i13 += 3;
                            hullLength = hullLength;
                            length = length;
                            triangles = triangles;
                        }
                    }
                    int i17 = hullLength;
                    if (this.f && i17 > 0) {
                        shapeRenderer.setColor(f309s);
                        float f9 = size[i17 - 2];
                        float f10 = size[i17 - 1];
                        int i18 = 0;
                        while (i18 < i17) {
                            float f11 = size[i18];
                            float f12 = size[i18 + 1];
                            shapeRenderer.line(f11, f12, f9, f10);
                            i18 += 2;
                            f9 = f11;
                            f10 = f12;
                        }
                    }
                }
            }
        }
        if (this.d) {
            com.esotericsoftware.spine.SkeletonBounds skeletonBounds = this.j;
            skeletonBounds.update(skeleton, true);
            shapeRenderer.setColor(u);
            shapeRenderer.rect(skeletonBounds.getMinX(), skeletonBounds.getMinY(), skeletonBounds.getWidth(), skeletonBounds.getHeight());
            com.badlogic.gdx.utils.Array<com.badlogic.gdx.utils.FloatArray> polygons = skeletonBounds.getPolygons();
            com.badlogic.gdx.utils.Array<com.esotericsoftware.spine.attachments.BoundingBoxAttachment> boundingBoxes = skeletonBounds.getBoundingBoxes();
            int i19 = polygons.size;
            for (int i20 = 0; i20 < i19; i20++) {
                com.badlogic.gdx.utils.FloatArray floatArray = polygons.get(i20);
                shapeRenderer.setColor(boundingBoxes.get(i20).getColor());
                shapeRenderer.polygon(floatArray.items, 0, floatArray.size);
            }
        }
        if (this.i) {
            int i21 = slots.size;
            for (int i22 = 0; i22 < i21; i22++) {
                com.esotericsoftware.spine.Slot slot4 = slots.get(i22);
                com.esotericsoftware.spine.attachments.Attachment attachment4 = slot4.e;
                if (attachment4 instanceof com.esotericsoftware.spine.attachments.ClippingAttachment) {
                    com.esotericsoftware.spine.attachments.ClippingAttachment clippingAttachment = (com.esotericsoftware.spine.attachments.ClippingAttachment) attachment4;
                    int worldVerticesLength = clippingAttachment.getWorldVerticesLength();
                    float[] size2 = this.k.setSize(worldVerticesLength);
                    clippingAttachment.computeWorldVertices(slot4, 0, worldVerticesLength, size2, 0, 2);
                    shapeRenderer.setColor(clippingAttachment.getColor());
                    for (int i23 = 2; i23 < worldVerticesLength; i23 += 2) {
                        shapeRenderer.line(size2[i23 - 2], size2[i23 - 1], size2[i23], size2[i23 + 1]);
                    }
                    shapeRenderer.line(size2[0], size2[1], size2[worldVerticesLength - 2], size2[worldVerticesLength - 1]);
                }
            }
        }
        if (this.h) {
            int i24 = slots.size;
            int i25 = 0;
            while (i25 < i24) {
                com.esotericsoftware.spine.Slot slot5 = slots.get(i25);
                com.esotericsoftware.spine.attachments.Attachment attachment5 = slot5.e;
                if (attachment5 instanceof com.esotericsoftware.spine.attachments.PathAttachment) {
                    com.esotericsoftware.spine.attachments.PathAttachment pathAttachment = (com.esotericsoftware.spine.attachments.PathAttachment) attachment5;
                    int worldVerticesLength2 = pathAttachment.getWorldVerticesLength();
                    float[] size3 = this.k.setSize(worldVerticesLength2);
                    pathAttachment.computeWorldVertices(slot5, 0, worldVerticesLength2, size3, 0, 2);
                    com.badlogic.gdx.graphics.Color color2 = pathAttachment.getColor();
                    float f13 = size3[2];
                    float f14 = size3[3];
                    if (pathAttachment.getClosed()) {
                        shapeRenderer.setColor(color2);
                        float f15 = size3[c];
                        float f16 = size3[1];
                        float f17 = size3[worldVerticesLength2 - 2];
                        float f18 = size3[worldVerticesLength2 - 1];
                        float f19 = size3[worldVerticesLength2 - 4];
                        float f20 = size3[worldVerticesLength2 - 3];
                        color = color2;
                        i = worldVerticesLength2;
                        i2 = i25;
                        shapeRenderer.curve(f13, f14, f15, f16, f17, f18, f19, f20, 32);
                        shapeRenderer.setColor(com.badlogic.gdx.graphics.Color.LIGHT_GRAY);
                        f = f14;
                        f2 = f13;
                        shapeRenderer.line(f2, f, f15, f16);
                        shapeRenderer.line(f19, f20, f17, f18);
                    } else {
                        f = f14;
                        f2 = f13;
                        color = color2;
                        i = worldVerticesLength2;
                        i2 = i25;
                    }
                    int i26 = i - 4;
                    float f21 = f2;
                    float f22 = f;
                    int i27 = 4;
                    while (i27 < i26) {
                        float f23 = size3[i27];
                        float f24 = size3[i27 + 1];
                        float f25 = size3[i27 + 2];
                        float f26 = size3[i27 + 3];
                        float f27 = size3[i27 + 4];
                        float f28 = size3[i27 + 5];
                        com.badlogic.gdx.graphics.Color color3 = color;
                        shapeRenderer.setColor(color3);
                        shapeRenderer.curve(f21, f22, f23, f24, f25, f26, f27, f28, 32);
                        shapeRenderer.setColor(com.badlogic.gdx.graphics.Color.LIGHT_GRAY);
                        shapeRenderer.line(f21, f22, f23, f24);
                        shapeRenderer.line(f27, f28, f25, f26);
                        i27 += 6;
                        f21 = f27;
                        f22 = f28;
                        i24 = i24;
                        i26 = i26;
                        color = color3;
                    }
                    i3 = i24;
                } else {
                    i3 = i24;
                    i2 = i25;
                }
                i25 = i2 + 1;
                i24 = i3;
                c = 0;
            }
        }
        shapeRenderer.end();
        shapeRenderer.begin(com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType.Filled);
        if (this.b) {
            shapeRenderer.setColor(r);
            int i28 = bones.size;
            for (int i29 = 0; i29 < i28; i29++) {
                com.esotericsoftware.spine.Bone bone2 = bones.get(i29);
                shapeRenderer.circle(bone2.v, bone2.y, this.l * 3.0f, 8);
            }
        }
        if (this.e) {
            shapeRenderer.setColor(r);
            int i30 = slots.size;
            for (int i31 = 0; i31 < i30; i31++) {
                com.esotericsoftware.spine.Slot slot6 = slots.get(i31);
                com.esotericsoftware.spine.attachments.Attachment attachment6 = slot6.e;
                if (attachment6 instanceof com.esotericsoftware.spine.attachments.PointAttachment) {
                    ((com.esotericsoftware.spine.attachments.PointAttachment) attachment6).computeWorldPosition(slot6.getBone(), this.o);
                    com.badlogic.gdx.math.Vector2 vector2 = this.o;
                    shapeRenderer.circle(vector2.x, vector2.y, this.l * 3.0f, 8);
                }
            }
        }
        shapeRenderer.end();
    }

    public com.badlogic.gdx.graphics.glutils.ShapeRenderer getShapeRenderer() {
        return this.a;
    }

    public void setBones(boolean z) {
        this.b = z;
    }

    public void setBoundingBoxes(boolean z) {
        this.d = z;
    }

    public void setClipping(boolean z) {
        this.i = z;
    }

    public void setMeshHull(boolean z) {
        this.f = z;
    }

    public void setMeshTriangles(boolean z) {
        this.g = z;
    }

    public void setPaths(boolean z) {
        this.h = z;
    }

    public void setPoints(boolean z) {
        this.e = z;
    }

    public void setPremultipliedAlpha(boolean z) {
        this.n = z;
    }

    public void setRegionAttachments(boolean z) {
        this.c = z;
    }

    public void setScale(float f) {
        this.l = f;
    }
}
