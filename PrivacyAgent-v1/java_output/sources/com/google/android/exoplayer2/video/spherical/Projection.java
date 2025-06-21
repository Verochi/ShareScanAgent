package com.google.android.exoplayer2.video.spherical;

/* loaded from: classes22.dex */
public final class Projection {
    public static final int DRAW_MODE_TRIANGLES = 0;
    public static final int DRAW_MODE_TRIANGLES_FAN = 2;
    public static final int DRAW_MODE_TRIANGLES_STRIP = 1;
    public static final int POSITION_COORDS_PER_VERTEX = 3;
    public static final int TEXTURE_COORDS_PER_VERTEX = 2;
    public final com.google.android.exoplayer2.video.spherical.Projection.Mesh leftMesh;
    public final com.google.android.exoplayer2.video.spherical.Projection.Mesh rightMesh;
    public final boolean singleMesh;
    public final int stereoMode;

    @java.lang.annotation.Documented
    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface DrawMode {
    }

    public static final class Mesh {
        public final com.google.android.exoplayer2.video.spherical.Projection.SubMesh[] a;

        public Mesh(com.google.android.exoplayer2.video.spherical.Projection.SubMesh... subMeshArr) {
            this.a = subMeshArr;
        }

        public com.google.android.exoplayer2.video.spherical.Projection.SubMesh getSubMesh(int i) {
            return this.a[i];
        }

        public int getSubMeshCount() {
            return this.a.length;
        }
    }

    public static final class SubMesh {
        public static final int VIDEO_TEXTURE_ID = 0;
        public final int mode;
        public final float[] textureCoords;
        public final int textureId;
        public final float[] vertices;

        public SubMesh(int i, float[] fArr, float[] fArr2, int i2) {
            this.textureId = i;
            com.google.android.exoplayer2.util.Assertions.checkArgument(((long) fArr.length) * 2 == ((long) fArr2.length) * 3);
            this.vertices = fArr;
            this.textureCoords = fArr2;
            this.mode = i2;
        }

        public int getVertexCount() {
            return this.vertices.length / 3;
        }
    }

    public Projection(com.google.android.exoplayer2.video.spherical.Projection.Mesh mesh, int i) {
        this(mesh, mesh, i);
    }

    public Projection(com.google.android.exoplayer2.video.spherical.Projection.Mesh mesh, com.google.android.exoplayer2.video.spherical.Projection.Mesh mesh2, int i) {
        this.leftMesh = mesh;
        this.rightMesh = mesh2;
        this.stereoMode = i;
        this.singleMesh = mesh == mesh2;
    }

    public static com.google.android.exoplayer2.video.spherical.Projection createEquirectangular(float f, int i, int i2, float f2, float f3, int i3) {
        int i4;
        float f4;
        int i5;
        int i6;
        int i7;
        float[] fArr;
        int i8 = i;
        int i9 = i2;
        com.google.android.exoplayer2.util.Assertions.checkArgument(f > 0.0f);
        com.google.android.exoplayer2.util.Assertions.checkArgument(i8 >= 1);
        com.google.android.exoplayer2.util.Assertions.checkArgument(i9 >= 1);
        com.google.android.exoplayer2.util.Assertions.checkArgument(f2 > 0.0f && f2 <= 180.0f);
        com.google.android.exoplayer2.util.Assertions.checkArgument(f3 > 0.0f && f3 <= 360.0f);
        float radians = (float) java.lang.Math.toRadians(f2);
        float radians2 = (float) java.lang.Math.toRadians(f3);
        float f5 = radians / i8;
        float f6 = radians2 / i9;
        int i10 = i9 + 1;
        int i11 = ((i10 * 2) + 2) * i8;
        float[] fArr2 = new float[i11 * 3];
        float[] fArr3 = new float[i11 * 2];
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        while (i12 < i8) {
            float f7 = radians / 2.0f;
            float f8 = (i12 * f5) - f7;
            int i15 = i12 + 1;
            float f9 = (i15 * f5) - f7;
            int i16 = 0;
            while (i16 < i10) {
                float f10 = f8;
                int i17 = i15;
                int i18 = 0;
                int i19 = 2;
                while (i18 < i19) {
                    if (i18 == 0) {
                        f4 = f10;
                        i4 = i10;
                    } else {
                        i4 = i10;
                        f4 = f9;
                    }
                    float f11 = i16 * f6;
                    float f12 = f6;
                    int i20 = i13 + 1;
                    int i21 = i16;
                    double d = f;
                    float f13 = f5;
                    double d2 = (f11 + 3.1415927f) - (radians2 / 2.0f);
                    int i22 = i18;
                    double d3 = f4;
                    float[] fArr4 = fArr3;
                    float f14 = f9;
                    fArr2[i13] = -((float) (java.lang.Math.sin(d2) * d * java.lang.Math.cos(d3)));
                    int i23 = i20 + 1;
                    int i24 = i12;
                    fArr2[i20] = (float) (d * java.lang.Math.sin(d3));
                    int i25 = i23 + 1;
                    fArr2[i23] = (float) (d * java.lang.Math.cos(d2) * java.lang.Math.cos(d3));
                    int i26 = i14 + 1;
                    fArr4[i14] = f11 / radians2;
                    int i27 = i26 + 1;
                    fArr4[i26] = ((i24 + i22) * f13) / radians;
                    if (i21 == 0 && i22 == 0) {
                        i5 = i2;
                        i6 = i21;
                        i7 = i22;
                    } else {
                        i5 = i2;
                        i6 = i21;
                        i7 = i22;
                        if (i6 != i5 || i7 != 1) {
                            fArr = fArr4;
                            i14 = i27;
                            i13 = i25;
                            int i28 = i7 + 1;
                            fArr3 = fArr;
                            i12 = i24;
                            i10 = i4;
                            f6 = f12;
                            f5 = f13;
                            f9 = f14;
                            i19 = 2;
                            i9 = i5;
                            i16 = i6;
                            i18 = i28;
                        }
                    }
                    java.lang.System.arraycopy(fArr2, i25 - 3, fArr2, i25, 3);
                    i25 += 3;
                    fArr = fArr4;
                    java.lang.System.arraycopy(fArr, i27 - 2, fArr, i27, 2);
                    i27 += 2;
                    i14 = i27;
                    i13 = i25;
                    int i282 = i7 + 1;
                    fArr3 = fArr;
                    i12 = i24;
                    i10 = i4;
                    f6 = f12;
                    f5 = f13;
                    f9 = f14;
                    i19 = 2;
                    i9 = i5;
                    i16 = i6;
                    i18 = i282;
                }
                int i29 = i16;
                int i30 = i9;
                int i31 = i29 + 1;
                f8 = f10;
                i15 = i17;
                i10 = i10;
                f6 = f6;
                f9 = f9;
                i9 = i30;
                i16 = i31;
            }
            i8 = i;
            i12 = i15;
        }
        return new com.google.android.exoplayer2.video.spherical.Projection(new com.google.android.exoplayer2.video.spherical.Projection.Mesh(new com.google.android.exoplayer2.video.spherical.Projection.SubMesh(0, fArr2, fArr3, 1)), i3);
    }

    public static com.google.android.exoplayer2.video.spherical.Projection createEquirectangular(int i) {
        return createEquirectangular(50.0f, 36, 72, 180.0f, 360.0f, i);
    }
}
