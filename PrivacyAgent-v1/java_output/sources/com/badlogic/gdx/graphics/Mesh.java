package com.badlogic.gdx.graphics;

/* loaded from: classes12.dex */
public class Mesh implements com.badlogic.gdx.utils.Disposable {
    public static final java.util.Map<com.badlogic.gdx.Application, com.badlogic.gdx.utils.Array<com.badlogic.gdx.graphics.Mesh>> f = new java.util.HashMap();
    public final com.badlogic.gdx.graphics.glutils.VertexData a;
    public final com.badlogic.gdx.graphics.glutils.IndexData b;
    public boolean c;
    public final boolean d;
    public final com.badlogic.gdx.math.Vector3 e;

    /* renamed from: com.badlogic.gdx.graphics.Mesh$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[com.badlogic.gdx.graphics.Mesh.VertexDataType.values().length];
            a = iArr;
            try {
                iArr[com.badlogic.gdx.graphics.Mesh.VertexDataType.VertexBufferObject.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                a[com.badlogic.gdx.graphics.Mesh.VertexDataType.VertexBufferObjectSubData.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                a[com.badlogic.gdx.graphics.Mesh.VertexDataType.VertexBufferObjectWithVAO.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
            try {
                a[com.badlogic.gdx.graphics.Mesh.VertexDataType.VertexArray.ordinal()] = 4;
            } catch (java.lang.NoSuchFieldError unused4) {
            }
        }
    }

    public enum VertexDataType {
        VertexArray,
        VertexBufferObject,
        VertexBufferObjectSubData,
        VertexBufferObjectWithVAO
    }

    public Mesh(com.badlogic.gdx.graphics.Mesh.VertexDataType vertexDataType, boolean z, int i, int i2, com.badlogic.gdx.graphics.VertexAttribute... vertexAttributeArr) {
        this.c = true;
        this.e = new com.badlogic.gdx.math.Vector3();
        int i3 = com.badlogic.gdx.graphics.Mesh.AnonymousClass1.a[vertexDataType.ordinal()];
        if (i3 == 1) {
            this.a = new com.badlogic.gdx.graphics.glutils.VertexBufferObject(z, i, vertexAttributeArr);
            this.b = new com.badlogic.gdx.graphics.glutils.IndexBufferObject(z, i2);
            this.d = false;
        } else if (i3 == 2) {
            this.a = new com.badlogic.gdx.graphics.glutils.VertexBufferObjectSubData(z, i, vertexAttributeArr);
            this.b = new com.badlogic.gdx.graphics.glutils.IndexBufferObjectSubData(z, i2);
            this.d = false;
        } else if (i3 != 3) {
            this.a = new com.badlogic.gdx.graphics.glutils.VertexArray(i, vertexAttributeArr);
            this.b = new com.badlogic.gdx.graphics.glutils.IndexArray(i2);
            this.d = true;
        } else {
            this.a = new com.badlogic.gdx.graphics.glutils.VertexBufferObjectWithVAO(z, i, vertexAttributeArr);
            this.b = new com.badlogic.gdx.graphics.glutils.IndexBufferObjectSubData(z, i2);
            this.d = false;
        }
        a(com.badlogic.gdx.Gdx.app, this);
    }

    public Mesh(com.badlogic.gdx.graphics.glutils.VertexData vertexData, com.badlogic.gdx.graphics.glutils.IndexData indexData, boolean z) {
        this.c = true;
        this.e = new com.badlogic.gdx.math.Vector3();
        this.a = vertexData;
        this.b = indexData;
        this.d = z;
        a(com.badlogic.gdx.Gdx.app, this);
    }

    public Mesh(boolean z, int i, int i2, com.badlogic.gdx.graphics.VertexAttributes vertexAttributes) {
        this.c = true;
        this.e = new com.badlogic.gdx.math.Vector3();
        this.a = b(z, i, vertexAttributes);
        this.b = new com.badlogic.gdx.graphics.glutils.IndexBufferObject(z, i2);
        this.d = false;
        a(com.badlogic.gdx.Gdx.app, this);
    }

    public Mesh(boolean z, int i, int i2, com.badlogic.gdx.graphics.VertexAttribute... vertexAttributeArr) {
        this.c = true;
        this.e = new com.badlogic.gdx.math.Vector3();
        this.a = b(z, i, new com.badlogic.gdx.graphics.VertexAttributes(vertexAttributeArr));
        this.b = new com.badlogic.gdx.graphics.glutils.IndexBufferObject(z, i2);
        this.d = false;
        a(com.badlogic.gdx.Gdx.app, this);
    }

    public Mesh(boolean z, boolean z2, int i, int i2, com.badlogic.gdx.graphics.VertexAttributes vertexAttributes) {
        this.c = true;
        this.e = new com.badlogic.gdx.math.Vector3();
        this.a = b(z, i, vertexAttributes);
        this.b = new com.badlogic.gdx.graphics.glutils.IndexBufferObject(z2, i2);
        this.d = false;
        a(com.badlogic.gdx.Gdx.app, this);
    }

    public static void a(com.badlogic.gdx.Application application, com.badlogic.gdx.graphics.Mesh mesh) {
        java.util.Map<com.badlogic.gdx.Application, com.badlogic.gdx.utils.Array<com.badlogic.gdx.graphics.Mesh>> map = f;
        com.badlogic.gdx.utils.Array<com.badlogic.gdx.graphics.Mesh> array = map.get(application);
        if (array == null) {
            array = new com.badlogic.gdx.utils.Array<>();
        }
        array.add(mesh);
        map.put(application, array);
    }

    public static void clearAllMeshes(com.badlogic.gdx.Application application) {
        f.remove(application);
    }

    public static java.lang.String getManagedStatus() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("Managed meshes/app: { ");
        java.util.Iterator<com.badlogic.gdx.Application> it = f.keySet().iterator();
        while (it.hasNext()) {
            sb.append(f.get(it.next()).size);
            sb.append(" ");
        }
        sb.append(com.alipay.sdk.m.u.i.d);
        return sb.toString();
    }

    public static void invalidateAllMeshes(com.badlogic.gdx.Application application) {
        com.badlogic.gdx.utils.Array<com.badlogic.gdx.graphics.Mesh> array = f.get(application);
        if (array == null) {
            return;
        }
        for (int i = 0; i < array.size; i++) {
            array.get(i).a.invalidate();
            array.get(i).b.invalidate();
        }
    }

    public static void transform(com.badlogic.gdx.math.Matrix4 matrix4, float[] fArr, int i, int i2, int i3, int i4, int i5) {
        if (i2 < 0 || i3 < 1 || i2 + i3 > i) {
            throw new java.lang.IndexOutOfBoundsException();
        }
        if (i4 < 0 || i5 < 1 || (i4 + i5) * i > fArr.length) {
            throw new java.lang.IndexOutOfBoundsException("start = " + i4 + ", count = " + i5 + ", vertexSize = " + i + ", length = " + fArr.length);
        }
        com.badlogic.gdx.math.Vector3 vector3 = new com.badlogic.gdx.math.Vector3();
        int i6 = i2 + (i4 * i);
        int i7 = 0;
        if (i3 == 1) {
            while (i7 < i5) {
                vector3.set(fArr[i6], 0.0f, 0.0f).mul(matrix4);
                fArr[i6] = vector3.x;
                i6 += i;
                i7++;
            }
            return;
        }
        if (i3 == 2) {
            while (i7 < i5) {
                int i8 = i6 + 1;
                vector3.set(fArr[i6], fArr[i8], 0.0f).mul(matrix4);
                fArr[i6] = vector3.x;
                fArr[i8] = vector3.y;
                i6 += i;
                i7++;
            }
            return;
        }
        if (i3 != 3) {
            return;
        }
        while (i7 < i5) {
            int i9 = i6 + 1;
            int i10 = i6 + 2;
            vector3.set(fArr[i6], fArr[i9], fArr[i10]).mul(matrix4);
            fArr[i6] = vector3.x;
            fArr[i9] = vector3.y;
            fArr[i10] = vector3.z;
            i6 += i;
            i7++;
        }
    }

    public static void transformUV(com.badlogic.gdx.math.Matrix3 matrix3, float[] fArr, int i, int i2, int i3, int i4) {
        if (i3 < 0 || i4 < 1 || (i3 + i4) * i > fArr.length) {
            throw new java.lang.IndexOutOfBoundsException("start = " + i3 + ", count = " + i4 + ", vertexSize = " + i + ", length = " + fArr.length);
        }
        com.badlogic.gdx.math.Vector2 vector2 = new com.badlogic.gdx.math.Vector2();
        int i5 = i2 + (i3 * i);
        for (int i6 = 0; i6 < i4; i6++) {
            int i7 = i5 + 1;
            vector2.set(fArr[i5], fArr[i7]).mul(matrix3);
            fArr[i5] = vector2.x;
            fArr[i7] = vector2.y;
            i5 += i;
        }
    }

    public final com.badlogic.gdx.graphics.glutils.VertexData b(boolean z, int i, com.badlogic.gdx.graphics.VertexAttributes vertexAttributes) {
        return com.badlogic.gdx.Gdx.gl30 != null ? new com.badlogic.gdx.graphics.glutils.VertexBufferObjectWithVAO(z, i, vertexAttributes) : new com.badlogic.gdx.graphics.glutils.VertexBufferObject(z, i, vertexAttributes);
    }

    public void bind(com.badlogic.gdx.graphics.glutils.ShaderProgram shaderProgram) {
        bind(shaderProgram, null);
    }

    public void bind(com.badlogic.gdx.graphics.glutils.ShaderProgram shaderProgram, int[] iArr) {
        this.a.bind(shaderProgram, iArr);
        if (this.b.getNumIndices() > 0) {
            this.b.bind();
        }
    }

    public com.badlogic.gdx.math.collision.BoundingBox calculateBoundingBox() {
        com.badlogic.gdx.math.collision.BoundingBox boundingBox = new com.badlogic.gdx.math.collision.BoundingBox();
        calculateBoundingBox(boundingBox);
        return boundingBox;
    }

    public com.badlogic.gdx.math.collision.BoundingBox calculateBoundingBox(com.badlogic.gdx.math.collision.BoundingBox boundingBox, int i, int i2) {
        return extendBoundingBox(boundingBox.inf(), i, i2);
    }

    public com.badlogic.gdx.math.collision.BoundingBox calculateBoundingBox(com.badlogic.gdx.math.collision.BoundingBox boundingBox, int i, int i2, com.badlogic.gdx.math.Matrix4 matrix4) {
        return extendBoundingBox(boundingBox.inf(), i, i2, matrix4);
    }

    public void calculateBoundingBox(com.badlogic.gdx.math.collision.BoundingBox boundingBox) {
        int numVertices = getNumVertices();
        if (numVertices == 0) {
            throw new com.badlogic.gdx.utils.GdxRuntimeException("No vertices defined");
        }
        java.nio.FloatBuffer buffer = this.a.getBuffer();
        boundingBox.inf();
        com.badlogic.gdx.graphics.VertexAttribute vertexAttribute = getVertexAttribute(1);
        int i = vertexAttribute.offset / 4;
        int i2 = this.a.getAttributes().vertexSize / 4;
        int i3 = vertexAttribute.numComponents;
        int i4 = 0;
        if (i3 == 1) {
            while (i4 < numVertices) {
                boundingBox.ext(buffer.get(i), 0.0f, 0.0f);
                i += i2;
                i4++;
            }
            return;
        }
        if (i3 == 2) {
            while (i4 < numVertices) {
                boundingBox.ext(buffer.get(i), buffer.get(i + 1), 0.0f);
                i += i2;
                i4++;
            }
            return;
        }
        if (i3 != 3) {
            return;
        }
        while (i4 < numVertices) {
            boundingBox.ext(buffer.get(i), buffer.get(i + 1), buffer.get(i + 2));
            i += i2;
            i4++;
        }
    }

    public float calculateRadius(float f2, float f3, float f4) {
        return calculateRadius(f2, f3, f4, 0, getNumIndices(), null);
    }

    public float calculateRadius(float f2, float f3, float f4, int i, int i2) {
        return calculateRadius(f2, f3, f4, i, i2, null);
    }

    public float calculateRadius(float f2, float f3, float f4, int i, int i2, com.badlogic.gdx.math.Matrix4 matrix4) {
        return (float) java.lang.Math.sqrt(calculateRadiusSquared(f2, f3, f4, i, i2, matrix4));
    }

    public float calculateRadius(com.badlogic.gdx.math.Vector3 vector3) {
        return calculateRadius(vector3.x, vector3.y, vector3.z, 0, getNumIndices(), null);
    }

    public float calculateRadius(com.badlogic.gdx.math.Vector3 vector3, int i, int i2) {
        return calculateRadius(vector3.x, vector3.y, vector3.z, i, i2, null);
    }

    public float calculateRadius(com.badlogic.gdx.math.Vector3 vector3, int i, int i2, com.badlogic.gdx.math.Matrix4 matrix4) {
        return calculateRadius(vector3.x, vector3.y, vector3.z, i, i2, matrix4);
    }

    public float calculateRadiusSquared(float f2, float f3, float f4, int i, int i2, com.badlogic.gdx.math.Matrix4 matrix4) {
        int i3;
        int numIndices = getNumIndices();
        if (i < 0 || i2 < 1 || (i3 = i + i2) > numIndices) {
            throw new com.badlogic.gdx.utils.GdxRuntimeException("Not enough indices");
        }
        java.nio.FloatBuffer buffer = this.a.getBuffer();
        java.nio.ShortBuffer buffer2 = this.b.getBuffer();
        com.badlogic.gdx.graphics.VertexAttribute vertexAttribute = getVertexAttribute(1);
        int i4 = vertexAttribute.offset / 4;
        int i5 = this.a.getAttributes().vertexSize / 4;
        int i6 = vertexAttribute.numComponents;
        float f5 = 0.0f;
        if (i6 == 1) {
            float f6 = 0.0f;
            for (int i7 = i; i7 < i3; i7++) {
                this.e.set(buffer.get((buffer2.get(i7) * i5) + i4), 0.0f, 0.0f);
                if (matrix4 != null) {
                    this.e.mul(matrix4);
                }
                float len2 = this.e.sub(f2, f3, f4).len2();
                if (len2 > f6) {
                    f6 = len2;
                }
            }
            return f6;
        }
        if (i6 == 2) {
            float f7 = 0.0f;
            for (int i8 = i; i8 < i3; i8++) {
                int i9 = (buffer2.get(i8) * i5) + i4;
                this.e.set(buffer.get(i9), buffer.get(i9 + 1), 0.0f);
                if (matrix4 != null) {
                    this.e.mul(matrix4);
                }
                float len22 = this.e.sub(f2, f3, f4).len2();
                if (len22 > f7) {
                    f7 = len22;
                }
            }
            return f7;
        }
        if (i6 != 3) {
            return 0.0f;
        }
        int i10 = i;
        while (i10 < i3) {
            int i11 = (buffer2.get(i10) * i5) + i4;
            int i12 = i4;
            this.e.set(buffer.get(i11), buffer.get(i11 + 1), buffer.get(i11 + 2));
            if (matrix4 != null) {
                this.e.mul(matrix4);
            }
            float len23 = this.e.sub(f2, f3, f4).len2();
            if (len23 > f5) {
                f5 = len23;
            }
            i10++;
            i4 = i12;
        }
        return f5;
    }

    public com.badlogic.gdx.graphics.Mesh copy(boolean z) {
        return copy(z, false, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x00f3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public com.badlogic.gdx.graphics.Mesh copy(boolean z, boolean z2, int[] iArr) {
        com.badlogic.gdx.graphics.VertexAttribute[] vertexAttributeArr;
        short[] sArr;
        int i;
        int numIndices;
        short[] sArr2;
        int i2;
        short s2;
        int vertexSize = getVertexSize() / 4;
        int numVertices = getNumVertices();
        int i3 = numVertices * vertexSize;
        float[] fArr = new float[i3];
        getVertices(0, i3, fArr);
        if (iArr != null) {
            int i4 = 0;
            int i5 = 0;
            for (int i6 = 0; i6 < iArr.length; i6++) {
                if (getVertexAttribute(iArr[i6]) != null) {
                    i4 += getVertexAttribute(iArr[i6]).numComponents;
                    i5++;
                }
            }
            if (i4 > 0) {
                vertexAttributeArr = new com.badlogic.gdx.graphics.VertexAttribute[i5];
                sArr = new short[i4];
                i = 0;
                int i7 = -1;
                int i8 = -1;
                for (int i9 : iArr) {
                    com.badlogic.gdx.graphics.VertexAttribute vertexAttribute = getVertexAttribute(i9);
                    if (vertexAttribute != null) {
                        for (int i10 = 0; i10 < vertexAttribute.numComponents; i10++) {
                            i7++;
                            sArr[i7] = (short) (vertexAttribute.offset + i10);
                        }
                        i8++;
                        vertexAttributeArr[i8] = vertexAttribute.copy();
                        i += vertexAttribute.numComponents;
                    }
                }
                if (sArr == null) {
                    sArr = new short[vertexSize];
                    for (short s3 = 0; s3 < vertexSize; s3 = (short) (s3 + 1)) {
                        sArr[s3] = s3;
                    }
                    i = vertexSize;
                }
                numIndices = getNumIndices();
                if (numIndices <= 0) {
                    sArr2 = new short[numIndices];
                    getIndices(sArr2);
                    if (z2 || i != vertexSize) {
                        float[] fArr2 = new float[i3];
                        int i11 = 0;
                        int i12 = 0;
                        while (i12 < numIndices) {
                            int i13 = sArr2[i12] * vertexSize;
                            if (z2) {
                                short s4 = 0;
                                s2 = -1;
                                while (s4 < i11 && s2 < 0) {
                                    int i14 = s4 * i;
                                    boolean z3 = true;
                                    int i15 = numIndices;
                                    for (int i16 = 0; i16 < sArr.length && z3; i16++) {
                                        if (fArr2[i14 + i16] != fArr[i13 + sArr[i16]]) {
                                            z3 = false;
                                        }
                                    }
                                    if (z3) {
                                        s2 = s4;
                                    }
                                    s4 = (short) (s4 + 1);
                                    numIndices = i15;
                                }
                                i2 = numIndices;
                            } else {
                                i2 = numIndices;
                                s2 = -1;
                            }
                            if (s2 > 0) {
                                sArr2[i12] = s2;
                            } else {
                                int i17 = i11 * i;
                                for (int i18 = 0; i18 < sArr.length; i18++) {
                                    fArr2[i17 + i18] = fArr[sArr[i18] + i13];
                                }
                                sArr2[i12] = (short) i11;
                                i11++;
                            }
                            i12++;
                            numIndices = i2;
                        }
                        fArr = fArr2;
                        numVertices = i11;
                    }
                } else {
                    sArr2 = null;
                }
                com.badlogic.gdx.graphics.Mesh mesh = vertexAttributeArr != null ? new com.badlogic.gdx.graphics.Mesh(z, numVertices, sArr2 == null ? 0 : sArr2.length, getVertexAttributes()) : new com.badlogic.gdx.graphics.Mesh(z, numVertices, sArr2 == null ? 0 : sArr2.length, vertexAttributeArr);
                mesh.setVertices(fArr, 0, numVertices * i);
                mesh.setIndices(sArr2);
                return mesh;
            }
        }
        vertexAttributeArr = null;
        sArr = null;
        i = 0;
        if (sArr == null) {
        }
        numIndices = getNumIndices();
        if (numIndices <= 0) {
        }
        if (vertexAttributeArr != null) {
        }
        mesh.setVertices(fArr, 0, numVertices * i);
        mesh.setIndices(sArr2);
        return mesh;
    }

    @Override // com.badlogic.gdx.utils.Disposable
    public void dispose() {
        java.util.Map<com.badlogic.gdx.Application, com.badlogic.gdx.utils.Array<com.badlogic.gdx.graphics.Mesh>> map = f;
        if (map.get(com.badlogic.gdx.Gdx.app) != null) {
            map.get(com.badlogic.gdx.Gdx.app).removeValue(this, true);
        }
        this.a.dispose();
        this.b.dispose();
    }

    public com.badlogic.gdx.math.collision.BoundingBox extendBoundingBox(com.badlogic.gdx.math.collision.BoundingBox boundingBox, int i, int i2) {
        return extendBoundingBox(boundingBox, i, i2, null);
    }

    public com.badlogic.gdx.math.collision.BoundingBox extendBoundingBox(com.badlogic.gdx.math.collision.BoundingBox boundingBox, int i, int i2, com.badlogic.gdx.math.Matrix4 matrix4) {
        int i3;
        int numIndices = getNumIndices();
        int numVertices = getNumVertices();
        if (numIndices != 0) {
            numVertices = numIndices;
        }
        if (i < 0 || i2 < 1 || (i3 = i + i2) > numVertices) {
            throw new com.badlogic.gdx.utils.GdxRuntimeException("Invalid part specified ( offset=" + i + ", count=" + i2 + ", max=" + numVertices + " )");
        }
        java.nio.FloatBuffer buffer = this.a.getBuffer();
        java.nio.ShortBuffer buffer2 = this.b.getBuffer();
        com.badlogic.gdx.graphics.VertexAttribute vertexAttribute = getVertexAttribute(1);
        int i4 = vertexAttribute.offset / 4;
        int i5 = this.a.getAttributes().vertexSize / 4;
        int i6 = vertexAttribute.numComponents;
        if (i6 != 1) {
            if (i6 != 2) {
                if (i6 == 3) {
                    if (numIndices > 0) {
                        while (i < i3) {
                            int i7 = (buffer2.get(i) * i5) + i4;
                            this.e.set(buffer.get(i7), buffer.get(i7 + 1), buffer.get(i7 + 2));
                            if (matrix4 != null) {
                                this.e.mul(matrix4);
                            }
                            boundingBox.ext(this.e);
                            i++;
                        }
                    } else {
                        while (i < i3) {
                            int i8 = (i * i5) + i4;
                            this.e.set(buffer.get(i8), buffer.get(i8 + 1), buffer.get(i8 + 2));
                            if (matrix4 != null) {
                                this.e.mul(matrix4);
                            }
                            boundingBox.ext(this.e);
                            i++;
                        }
                    }
                }
            } else if (numIndices > 0) {
                while (i < i3) {
                    int i9 = (buffer2.get(i) * i5) + i4;
                    this.e.set(buffer.get(i9), buffer.get(i9 + 1), 0.0f);
                    if (matrix4 != null) {
                        this.e.mul(matrix4);
                    }
                    boundingBox.ext(this.e);
                    i++;
                }
            } else {
                while (i < i3) {
                    int i10 = (i * i5) + i4;
                    this.e.set(buffer.get(i10), buffer.get(i10 + 1), 0.0f);
                    if (matrix4 != null) {
                        this.e.mul(matrix4);
                    }
                    boundingBox.ext(this.e);
                    i++;
                }
            }
        } else if (numIndices > 0) {
            while (i < i3) {
                this.e.set(buffer.get((buffer2.get(i) * i5) + i4), 0.0f, 0.0f);
                if (matrix4 != null) {
                    this.e.mul(matrix4);
                }
                boundingBox.ext(this.e);
                i++;
            }
        } else {
            while (i < i3) {
                this.e.set(buffer.get((i * i5) + i4), 0.0f, 0.0f);
                if (matrix4 != null) {
                    this.e.mul(matrix4);
                }
                boundingBox.ext(this.e);
                i++;
            }
        }
        return boundingBox;
    }

    public void getIndices(int i, int i2, short[] sArr, int i3) {
        int numIndices = getNumIndices();
        if (i2 < 0) {
            i2 = numIndices - i;
        }
        if (i < 0 || i >= numIndices || i + i2 > numIndices) {
            throw new java.lang.IllegalArgumentException("Invalid range specified, offset: " + i + ", count: " + i2 + ", max: " + numIndices);
        }
        if (sArr.length - i3 >= i2) {
            int position = getIndicesBuffer().position();
            getIndicesBuffer().position(i);
            getIndicesBuffer().get(sArr, i3, i2);
            getIndicesBuffer().position(position);
            return;
        }
        throw new java.lang.IllegalArgumentException("not enough room in indices array, has " + sArr.length + " shorts, needs " + i2);
    }

    public void getIndices(int i, short[] sArr, int i2) {
        getIndices(i, -1, sArr, i2);
    }

    public void getIndices(short[] sArr) {
        getIndices(sArr, 0);
    }

    public void getIndices(short[] sArr, int i) {
        getIndices(0, sArr, i);
    }

    public java.nio.ShortBuffer getIndicesBuffer() {
        return this.b.getBuffer();
    }

    public int getMaxIndices() {
        return this.b.getNumMaxIndices();
    }

    public int getMaxVertices() {
        return this.a.getNumMaxVertices();
    }

    public int getNumIndices() {
        return this.b.getNumIndices();
    }

    public int getNumVertices() {
        return this.a.getNumVertices();
    }

    public com.badlogic.gdx.graphics.VertexAttribute getVertexAttribute(int i) {
        com.badlogic.gdx.graphics.VertexAttributes attributes = this.a.getAttributes();
        int size = attributes.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (attributes.get(i2).usage == i) {
                return attributes.get(i2);
            }
        }
        return null;
    }

    public com.badlogic.gdx.graphics.VertexAttributes getVertexAttributes() {
        return this.a.getAttributes();
    }

    public int getVertexSize() {
        return this.a.getAttributes().vertexSize;
    }

    public float[] getVertices(int i, int i2, float[] fArr) {
        return getVertices(i, i2, fArr, 0);
    }

    public float[] getVertices(int i, int i2, float[] fArr, int i3) {
        int numVertices = (getNumVertices() * getVertexSize()) / 4;
        if (i2 == -1 && (i2 = numVertices - i) > fArr.length - i3) {
            i2 = fArr.length - i3;
        }
        if (i < 0 || i2 <= 0 || i + i2 > numVertices || i3 < 0 || i3 >= fArr.length) {
            throw new java.lang.IndexOutOfBoundsException();
        }
        if (fArr.length - i3 >= i2) {
            int position = getVerticesBuffer().position();
            getVerticesBuffer().position(i);
            getVerticesBuffer().get(fArr, i3, i2);
            getVerticesBuffer().position(position);
            return fArr;
        }
        throw new java.lang.IllegalArgumentException("not enough room in vertices array, has " + fArr.length + " floats, needs " + i2);
    }

    public float[] getVertices(int i, float[] fArr) {
        return getVertices(i, -1, fArr);
    }

    public float[] getVertices(float[] fArr) {
        return getVertices(0, -1, fArr);
    }

    public java.nio.FloatBuffer getVerticesBuffer() {
        return this.a.getBuffer();
    }

    public void render(com.badlogic.gdx.graphics.glutils.ShaderProgram shaderProgram, int i) {
        render(shaderProgram, i, 0, this.b.getNumMaxIndices() > 0 ? getNumIndices() : getNumVertices(), this.c);
    }

    public void render(com.badlogic.gdx.graphics.glutils.ShaderProgram shaderProgram, int i, int i2, int i3) {
        render(shaderProgram, i, i2, i3, this.c);
    }

    public void render(com.badlogic.gdx.graphics.glutils.ShaderProgram shaderProgram, int i, int i2, int i3, boolean z) {
        if (i3 == 0) {
            return;
        }
        if (z) {
            bind(shaderProgram);
        }
        if (this.d) {
            if (this.b.getNumIndices() > 0) {
                java.nio.ShortBuffer buffer = this.b.getBuffer();
                int position = buffer.position();
                int limit = buffer.limit();
                buffer.position(i2);
                buffer.limit(i2 + i3);
                com.badlogic.gdx.Gdx.gl20.glDrawElements(i, i3, com.badlogic.gdx.graphics.GL20.GL_UNSIGNED_SHORT, buffer);
                buffer.position(position);
                buffer.limit(limit);
            } else {
                com.badlogic.gdx.Gdx.gl20.glDrawArrays(i, i2, i3);
            }
        } else if (this.b.getNumIndices() > 0) {
            com.badlogic.gdx.Gdx.gl20.glDrawElements(i, i3, com.badlogic.gdx.graphics.GL20.GL_UNSIGNED_SHORT, i2 * 2);
        } else {
            com.badlogic.gdx.Gdx.gl20.glDrawArrays(i, i2, i3);
        }
        if (z) {
            unbind(shaderProgram);
        }
    }

    public void scale(float f2, float f3, float f4) {
        com.badlogic.gdx.graphics.VertexAttribute vertexAttribute = getVertexAttribute(1);
        int i = vertexAttribute.offset / 4;
        int i2 = vertexAttribute.numComponents;
        int numVertices = getNumVertices();
        int vertexSize = getVertexSize() / 4;
        float[] fArr = new float[numVertices * vertexSize];
        getVertices(fArr);
        int i3 = 0;
        if (i2 == 1) {
            while (i3 < numVertices) {
                fArr[i] = fArr[i] * f2;
                i += vertexSize;
                i3++;
            }
        } else if (i2 == 2) {
            while (i3 < numVertices) {
                fArr[i] = fArr[i] * f2;
                int i4 = i + 1;
                fArr[i4] = fArr[i4] * f3;
                i += vertexSize;
                i3++;
            }
        } else if (i2 == 3) {
            while (i3 < numVertices) {
                fArr[i] = fArr[i] * f2;
                int i5 = i + 1;
                fArr[i5] = fArr[i5] * f3;
                int i6 = i + 2;
                fArr[i6] = fArr[i6] * f4;
                i += vertexSize;
                i3++;
            }
        }
        setVertices(fArr);
    }

    public void setAutoBind(boolean z) {
        this.c = z;
    }

    public com.badlogic.gdx.graphics.Mesh setIndices(short[] sArr) {
        this.b.setIndices(sArr, 0, sArr.length);
        return this;
    }

    public com.badlogic.gdx.graphics.Mesh setIndices(short[] sArr, int i, int i2) {
        this.b.setIndices(sArr, i, i2);
        return this;
    }

    public com.badlogic.gdx.graphics.Mesh setVertices(float[] fArr) {
        this.a.setVertices(fArr, 0, fArr.length);
        return this;
    }

    public com.badlogic.gdx.graphics.Mesh setVertices(float[] fArr, int i, int i2) {
        this.a.setVertices(fArr, i, i2);
        return this;
    }

    public void transform(com.badlogic.gdx.math.Matrix4 matrix4) {
        transform(matrix4, 0, getNumVertices());
    }

    public void transform(com.badlogic.gdx.math.Matrix4 matrix4, int i, int i2) {
        com.badlogic.gdx.graphics.VertexAttribute vertexAttribute = getVertexAttribute(1);
        int i3 = vertexAttribute.offset / 4;
        int vertexSize = getVertexSize() / 4;
        int i4 = vertexAttribute.numComponents;
        getNumVertices();
        int i5 = i2 * vertexSize;
        float[] fArr = new float[i5];
        int i6 = i * vertexSize;
        getVertices(i6, i5, fArr);
        transform(matrix4, fArr, vertexSize, i3, i4, 0, i2);
        updateVertices(i6, fArr);
    }

    public void transformUV(com.badlogic.gdx.math.Matrix3 matrix3) {
        transformUV(matrix3, 0, getNumVertices());
    }

    public void transformUV(com.badlogic.gdx.math.Matrix3 matrix3, int i, int i2) {
        int i3 = getVertexAttribute(16).offset / 4;
        int vertexSize = getVertexSize() / 4;
        int numVertices = getNumVertices() * vertexSize;
        float[] fArr = new float[numVertices];
        getVertices(0, numVertices, fArr);
        transformUV(matrix3, fArr, vertexSize, i3, i, i2);
        setVertices(fArr, 0, numVertices);
    }

    public void unbind(com.badlogic.gdx.graphics.glutils.ShaderProgram shaderProgram) {
        unbind(shaderProgram, null);
    }

    public void unbind(com.badlogic.gdx.graphics.glutils.ShaderProgram shaderProgram, int[] iArr) {
        this.a.unbind(shaderProgram, iArr);
        if (this.b.getNumIndices() > 0) {
            this.b.unbind();
        }
    }

    public com.badlogic.gdx.graphics.Mesh updateVertices(int i, float[] fArr) {
        return updateVertices(i, fArr, 0, fArr.length);
    }

    public com.badlogic.gdx.graphics.Mesh updateVertices(int i, float[] fArr, int i2, int i3) {
        this.a.updateVertices(i, fArr, i2, i3);
        return this;
    }
}
