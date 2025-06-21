package com.badlogic.gdx.graphics.g2d;

/* loaded from: classes12.dex */
public class ParticleEmitter {
    public java.lang.String A;
    public int B;
    public boolean[] C;
    public boolean D;
    public boolean E;
    public boolean F;
    public int G;
    public boolean H;
    public com.badlogic.gdx.math.collision.BoundingBox I;
    public int J;
    public int K;
    public int L;
    public int M;
    public int N;
    public int O;
    public int P;
    public float Q;
    public float R;
    public float S;
    public float T;
    public float U;
    public float V;
    public boolean W;
    public boolean X;
    public boolean Y;
    public boolean Z;
    public com.badlogic.gdx.graphics.g2d.ParticleEmitter.RangedNumericValue a;
    public boolean a0;
    public com.badlogic.gdx.graphics.g2d.ParticleEmitter.ScaledNumericValue b;
    public boolean b0;
    public com.badlogic.gdx.graphics.g2d.ParticleEmitter.RangedNumericValue c;
    public boolean c0;
    public com.badlogic.gdx.graphics.g2d.ParticleEmitter.ScaledNumericValue d;
    public float d0;
    public float duration;
    public float durationTimer;
    public com.badlogic.gdx.graphics.g2d.ParticleEmitter.ScaledNumericValue e;
    public com.badlogic.gdx.graphics.g2d.ParticleEmitter.ExtraValue e0;
    public com.badlogic.gdx.graphics.g2d.ParticleEmitter.ScaledNumericValue f;
    public float f0;
    public com.badlogic.gdx.graphics.g2d.ParticleEmitter.ScaledNumericValue g;
    public com.badlogic.gdx.graphics.g2d.ParticleEmitter.ScaledNumericValue h;
    public com.badlogic.gdx.graphics.g2d.ParticleEmitter.ScaledNumericValue i;
    public com.badlogic.gdx.graphics.g2d.ParticleEmitter.ScaledNumericValue j;
    public com.badlogic.gdx.graphics.g2d.ParticleEmitter.ScaledNumericValue k;
    public com.badlogic.gdx.graphics.g2d.ParticleEmitter.ScaledNumericValue l;
    public com.badlogic.gdx.graphics.g2d.ParticleEmitter.GradientColorValue m;
    public com.badlogic.gdx.graphics.g2d.ParticleEmitter.RangedNumericValue n;
    public com.badlogic.gdx.graphics.g2d.ParticleEmitter.RangedNumericValue o;
    public com.badlogic.gdx.graphics.g2d.ParticleEmitter.ScaledNumericValue p;
    public com.badlogic.gdx.graphics.g2d.ParticleEmitter.ScaledNumericValue q;
    public com.badlogic.gdx.graphics.g2d.ParticleEmitter.SpawnShapeValue r;

    /* renamed from: s, reason: collision with root package name */
    public float f288s;
    public com.badlogic.gdx.graphics.g2d.Sprite t;
    public com.badlogic.gdx.graphics.g2d.ParticleEmitter.Particle[] u;
    public int v;
    public int w;
    public float x;
    public float y;
    public java.lang.String z;

    /* renamed from: com.badlogic.gdx.graphics.g2d.ParticleEmitter$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] a;
        public static final /* synthetic */ int[] b;

        static {
            int[] iArr = new int[com.badlogic.gdx.graphics.g2d.ParticleEmitter.SpawnShape.values().length];
            b = iArr;
            try {
                iArr[com.badlogic.gdx.graphics.g2d.ParticleEmitter.SpawnShape.square.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                b[com.badlogic.gdx.graphics.g2d.ParticleEmitter.SpawnShape.ellipse.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                b[com.badlogic.gdx.graphics.g2d.ParticleEmitter.SpawnShape.line.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[com.badlogic.gdx.graphics.g2d.ParticleEmitter.SpawnEllipseSide.values().length];
            a = iArr2;
            try {
                iArr2[com.badlogic.gdx.graphics.g2d.ParticleEmitter.SpawnEllipseSide.top.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused4) {
            }
            try {
                a[com.badlogic.gdx.graphics.g2d.ParticleEmitter.SpawnEllipseSide.bottom.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused5) {
            }
        }
    }

    public static class ExtraValue {
        public float a;
        public float b;
        public float c;
        public float d;

        public float getBgRatioH() {
            return this.d;
        }

        public float getBgRatioW() {
            return this.c;
        }

        public float getScreenRatioH() {
            return this.b;
        }

        public float getScreenRatioW() {
            return this.a;
        }

        public void setBgRatioH(float f) {
            this.d = f;
        }

        public void setBgRatioW(float f) {
            this.c = f;
        }

        public void setScreenRatioH(float f) {
            this.b = f;
        }

        public void setScreenRatioW(float f) {
            this.a = f;
        }
    }

    public static class GradientColorValue extends com.badlogic.gdx.graphics.g2d.ParticleEmitter.ParticleValue {
        public static float[] e = new float[4];
        public float[] c = {1.0f, 1.0f, 1.0f};
        public float[] d = {0.0f};

        public GradientColorValue() {
            this.b = true;
        }

        public float[] getColor(float f) {
            float[] fArr = this.d;
            int length = fArr.length;
            int i = 1;
            int i2 = 0;
            while (true) {
                if (i >= length) {
                    i = -1;
                    break;
                }
                if (fArr[i] > f) {
                    break;
                }
                i2 = i;
                i++;
            }
            float f2 = fArr[i2];
            int i3 = i2 * 3;
            float[] fArr2 = this.c;
            float f3 = fArr2[i3];
            float f4 = fArr2[i3 + 1];
            float f5 = fArr2[i3 + 2];
            if (i == -1) {
                float[] fArr3 = e;
                fArr3[0] = f3;
                fArr3[1] = f4;
                fArr3[2] = f5;
                return fArr3;
            }
            float f6 = (f - f2) / (fArr[i] - f2);
            int i4 = i * 3;
            float[] fArr4 = e;
            fArr4[0] = f3 + ((fArr2[i4] - f3) * f6);
            fArr4[1] = f4 + ((fArr2[i4 + 1] - f4) * f6);
            fArr4[2] = f5 + ((fArr2[i4 + 2] - f5) * f6);
            return fArr4;
        }

        public float[] getColors() {
            return this.c;
        }

        public float[] getTimeline() {
            return this.d;
        }

        public void load(com.badlogic.gdx.graphics.g2d.ParticleEmitter.GradientColorValue gradientColorValue) {
            super.load((com.badlogic.gdx.graphics.g2d.ParticleEmitter.ParticleValue) gradientColorValue);
            float[] fArr = new float[gradientColorValue.c.length];
            this.c = fArr;
            java.lang.System.arraycopy(gradientColorValue.c, 0, fArr, 0, fArr.length);
            float[] fArr2 = new float[gradientColorValue.d.length];
            this.d = fArr2;
            java.lang.System.arraycopy(gradientColorValue.d, 0, fArr2, 0, fArr2.length);
        }

        @Override // com.badlogic.gdx.graphics.g2d.ParticleEmitter.ParticleValue
        public void load(java.io.BufferedReader bufferedReader) throws java.io.IOException {
            super.load(bufferedReader);
            if (!this.a) {
                return;
            }
            this.c = new float[com.badlogic.gdx.graphics.g2d.ParticleEmitter.f(bufferedReader, "colorsCount")];
            int i = 0;
            int i2 = 0;
            while (true) {
                float[] fArr = this.c;
                if (i2 >= fArr.length) {
                    break;
                }
                fArr[i2] = com.badlogic.gdx.graphics.g2d.ParticleEmitter.e(bufferedReader, "colors" + i2);
                i2++;
            }
            this.d = new float[com.badlogic.gdx.graphics.g2d.ParticleEmitter.f(bufferedReader, "timelineCount")];
            while (true) {
                float[] fArr2 = this.d;
                if (i >= fArr2.length) {
                    return;
                }
                fArr2[i] = com.badlogic.gdx.graphics.g2d.ParticleEmitter.e(bufferedReader, "timeline" + i);
                i++;
            }
        }

        @Override // com.badlogic.gdx.graphics.g2d.ParticleEmitter.ParticleValue
        public void save(java.io.Writer writer) throws java.io.IOException {
            super.save(writer);
            if (this.a) {
                writer.write("colorsCount: " + this.c.length + "\n");
                for (int i = 0; i < this.c.length; i++) {
                    writer.write("colors" + i + ": " + this.c[i] + "\n");
                }
                writer.write("timelineCount: " + this.d.length + "\n");
                for (int i2 = 0; i2 < this.d.length; i2++) {
                    writer.write("timeline" + i2 + ": " + this.d[i2] + "\n");
                }
            }
        }

        public void setColors(float[] fArr) {
            this.c = fArr;
        }

        public void setTimeline(float[] fArr) {
            this.d = fArr;
        }
    }

    public static class NumericValue extends com.badlogic.gdx.graphics.g2d.ParticleEmitter.ParticleValue {
        public float c;

        public float getValue() {
            return this.c;
        }

        public void load(com.badlogic.gdx.graphics.g2d.ParticleEmitter.NumericValue numericValue) {
            super.load((com.badlogic.gdx.graphics.g2d.ParticleEmitter.ParticleValue) numericValue);
            this.c = numericValue.c;
        }

        @Override // com.badlogic.gdx.graphics.g2d.ParticleEmitter.ParticleValue
        public void load(java.io.BufferedReader bufferedReader) throws java.io.IOException {
            super.load(bufferedReader);
            if (this.a) {
                this.c = com.badlogic.gdx.graphics.g2d.ParticleEmitter.e(bufferedReader, "value");
            }
        }

        @Override // com.badlogic.gdx.graphics.g2d.ParticleEmitter.ParticleValue
        public void save(java.io.Writer writer) throws java.io.IOException {
            super.save(writer);
            if (this.a) {
                writer.write("value: " + this.c + "\n");
            }
        }

        public void setValue(float f) {
            this.c = f;
        }
    }

    public static class Particle extends com.badlogic.gdx.graphics.g2d.Sprite {
        protected float angle;
        protected float angleCos;
        protected float angleDiff;
        protected float angleSin;
        protected int currentLife;
        protected float gravity;
        protected float gravityDiff;
        protected int life;
        protected float rotation;
        protected float rotationDiff;
        protected float scale;
        protected float scaleDiff;
        protected float[] tint;
        protected float transparency;
        protected float transparencyDiff;
        protected float velocity;
        protected float velocityDiff;
        protected float wind;
        protected float windDiff;

        public Particle(com.badlogic.gdx.graphics.g2d.Sprite sprite) {
            super(sprite);
        }
    }

    public static class ParticleValue {
        public boolean a;
        public boolean b;

        public boolean isActive() {
            return this.b || this.a;
        }

        public boolean isAlwaysActive() {
            return this.b;
        }

        public void load(com.badlogic.gdx.graphics.g2d.ParticleEmitter.ParticleValue particleValue) {
            this.a = particleValue.a;
            this.b = particleValue.b;
        }

        public void load(java.io.BufferedReader bufferedReader) throws java.io.IOException {
            if (this.b) {
                this.a = true;
            } else {
                this.a = com.badlogic.gdx.graphics.g2d.ParticleEmitter.c(bufferedReader, "active");
            }
        }

        public void save(java.io.Writer writer) throws java.io.IOException {
            if (this.b) {
                this.a = true;
                return;
            }
            writer.write("active: " + this.a + "\n");
        }

        public void setActive(boolean z) {
            this.a = z;
        }

        public void setAlwaysActive(boolean z) {
            this.b = z;
        }
    }

    public static class RangedNumericValue extends com.badlogic.gdx.graphics.g2d.ParticleEmitter.ParticleValue {
        public float c;
        public float d;

        public float getLowMax() {
            return this.d;
        }

        public float getLowMin() {
            return this.c;
        }

        public void load(com.badlogic.gdx.graphics.g2d.ParticleEmitter.RangedNumericValue rangedNumericValue) {
            super.load((com.badlogic.gdx.graphics.g2d.ParticleEmitter.ParticleValue) rangedNumericValue);
            this.d = rangedNumericValue.d;
            this.c = rangedNumericValue.c;
        }

        @Override // com.badlogic.gdx.graphics.g2d.ParticleEmitter.ParticleValue
        public void load(java.io.BufferedReader bufferedReader) throws java.io.IOException {
            super.load(bufferedReader);
            if (this.a) {
                this.c = com.badlogic.gdx.graphics.g2d.ParticleEmitter.e(bufferedReader, "lowMin");
                this.d = com.badlogic.gdx.graphics.g2d.ParticleEmitter.e(bufferedReader, "lowMax");
            }
        }

        public float newLowValue() {
            float f = this.c;
            return f + ((this.d - f) * com.badlogic.gdx.math.MathUtils.random());
        }

        @Override // com.badlogic.gdx.graphics.g2d.ParticleEmitter.ParticleValue
        public void save(java.io.Writer writer) throws java.io.IOException {
            super.save(writer);
            if (this.a) {
                writer.write("lowMin: " + this.c + "\n");
                writer.write("lowMax: " + this.d + "\n");
            }
        }

        public void setLow(float f) {
            this.c = f;
            this.d = f;
        }

        public void setLow(float f, float f2) {
            this.c = f;
            this.d = f2;
        }

        public void setLowMax(float f) {
            this.d = f;
        }

        public void setLowMin(float f) {
            this.c = f;
        }
    }

    public static class ScaledNumericValue extends com.badlogic.gdx.graphics.g2d.ParticleEmitter.RangedNumericValue {
        public float[] e = {1.0f};
        public float[] f = {0.0f};
        public float g;
        public float h;
        public boolean i;

        public float getHighMax() {
            return this.h;
        }

        public float getHighMin() {
            return this.g;
        }

        public float getScale(float f) {
            float[] fArr = this.f;
            int length = fArr.length;
            int i = 1;
            while (true) {
                if (i >= length) {
                    i = -1;
                    break;
                }
                if (fArr[i] > f) {
                    break;
                }
                i++;
            }
            if (i == -1) {
                return this.e[length - 1];
            }
            float[] fArr2 = this.e;
            int i2 = i - 1;
            float f2 = fArr2[i2];
            float f3 = fArr[i2];
            return f2 + ((fArr2[i] - f2) * ((f - f3) / (fArr[i] - f3)));
        }

        public float[] getScaling() {
            return this.e;
        }

        public float[] getTimeline() {
            return this.f;
        }

        public boolean isRelative() {
            return this.i;
        }

        public void load(com.badlogic.gdx.graphics.g2d.ParticleEmitter.ScaledNumericValue scaledNumericValue) {
            super.load((com.badlogic.gdx.graphics.g2d.ParticleEmitter.RangedNumericValue) scaledNumericValue);
            this.h = scaledNumericValue.h;
            this.g = scaledNumericValue.g;
            float[] fArr = new float[scaledNumericValue.e.length];
            this.e = fArr;
            java.lang.System.arraycopy(scaledNumericValue.e, 0, fArr, 0, fArr.length);
            float[] fArr2 = new float[scaledNumericValue.f.length];
            this.f = fArr2;
            java.lang.System.arraycopy(scaledNumericValue.f, 0, fArr2, 0, fArr2.length);
            this.i = scaledNumericValue.i;
        }

        @Override // com.badlogic.gdx.graphics.g2d.ParticleEmitter.RangedNumericValue, com.badlogic.gdx.graphics.g2d.ParticleEmitter.ParticleValue
        public void load(java.io.BufferedReader bufferedReader) throws java.io.IOException {
            super.load(bufferedReader);
            if (!this.a) {
                return;
            }
            this.g = com.badlogic.gdx.graphics.g2d.ParticleEmitter.e(bufferedReader, "highMin");
            this.h = com.badlogic.gdx.graphics.g2d.ParticleEmitter.e(bufferedReader, "highMax");
            this.i = com.badlogic.gdx.graphics.g2d.ParticleEmitter.c(bufferedReader, "relative");
            this.e = new float[com.badlogic.gdx.graphics.g2d.ParticleEmitter.f(bufferedReader, "scalingCount")];
            int i = 0;
            int i2 = 0;
            while (true) {
                float[] fArr = this.e;
                if (i2 >= fArr.length) {
                    break;
                }
                fArr[i2] = com.badlogic.gdx.graphics.g2d.ParticleEmitter.e(bufferedReader, "scaling" + i2);
                i2++;
            }
            this.f = new float[com.badlogic.gdx.graphics.g2d.ParticleEmitter.f(bufferedReader, "timelineCount")];
            while (true) {
                float[] fArr2 = this.f;
                if (i >= fArr2.length) {
                    return;
                }
                fArr2[i] = com.badlogic.gdx.graphics.g2d.ParticleEmitter.e(bufferedReader, "timeline" + i);
                i++;
            }
        }

        public float newHighValue() {
            float f = this.g;
            return f + ((this.h - f) * com.badlogic.gdx.math.MathUtils.random());
        }

        @Override // com.badlogic.gdx.graphics.g2d.ParticleEmitter.RangedNumericValue, com.badlogic.gdx.graphics.g2d.ParticleEmitter.ParticleValue
        public void save(java.io.Writer writer) throws java.io.IOException {
            super.save(writer);
            if (this.a) {
                writer.write("highMin: " + this.g + "\n");
                writer.write("highMax: " + this.h + "\n");
                writer.write("relative: " + this.i + "\n");
                writer.write("scalingCount: " + this.e.length + "\n");
                for (int i = 0; i < this.e.length; i++) {
                    writer.write("scaling" + i + ": " + this.e[i] + "\n");
                }
                writer.write("timelineCount: " + this.f.length + "\n");
                for (int i2 = 0; i2 < this.f.length; i2++) {
                    writer.write("timeline" + i2 + ": " + this.f[i2] + "\n");
                }
            }
        }

        public void setHigh(float f) {
            this.g = f;
            this.h = f;
        }

        public void setHigh(float f, float f2) {
            this.g = f;
            this.h = f2;
        }

        public void setHighMax(float f) {
            this.h = f;
        }

        public void setHighMin(float f) {
            this.g = f;
        }

        public void setRelative(boolean z) {
            this.i = z;
        }

        public void setScaling(float[] fArr) {
            this.e = fArr;
        }

        public void setTimeline(float[] fArr) {
            this.f = fArr;
        }
    }

    public enum SpawnEllipseSide {
        both,
        top,
        bottom
    }

    public enum SpawnShape {
        point,
        line,
        square,
        ellipse
    }

    public static class SpawnShapeValue extends com.badlogic.gdx.graphics.g2d.ParticleEmitter.ParticleValue {
        public boolean d;
        public com.badlogic.gdx.graphics.g2d.ParticleEmitter.SpawnShape c = com.badlogic.gdx.graphics.g2d.ParticleEmitter.SpawnShape.point;
        public com.badlogic.gdx.graphics.g2d.ParticleEmitter.SpawnEllipseSide e = com.badlogic.gdx.graphics.g2d.ParticleEmitter.SpawnEllipseSide.both;

        public com.badlogic.gdx.graphics.g2d.ParticleEmitter.SpawnShape getShape() {
            return this.c;
        }

        public com.badlogic.gdx.graphics.g2d.ParticleEmitter.SpawnEllipseSide getSide() {
            return this.e;
        }

        public boolean isEdges() {
            return this.d;
        }

        public void load(com.badlogic.gdx.graphics.g2d.ParticleEmitter.SpawnShapeValue spawnShapeValue) {
            super.load((com.badlogic.gdx.graphics.g2d.ParticleEmitter.ParticleValue) spawnShapeValue);
            this.c = spawnShapeValue.c;
            this.d = spawnShapeValue.d;
            this.e = spawnShapeValue.e;
        }

        @Override // com.badlogic.gdx.graphics.g2d.ParticleEmitter.ParticleValue
        public void load(java.io.BufferedReader bufferedReader) throws java.io.IOException {
            super.load(bufferedReader);
            if (this.a) {
                com.badlogic.gdx.graphics.g2d.ParticleEmitter.SpawnShape valueOf = com.badlogic.gdx.graphics.g2d.ParticleEmitter.SpawnShape.valueOf(com.badlogic.gdx.graphics.g2d.ParticleEmitter.g(bufferedReader, "shape"));
                this.c = valueOf;
                if (valueOf == com.badlogic.gdx.graphics.g2d.ParticleEmitter.SpawnShape.ellipse) {
                    this.d = com.badlogic.gdx.graphics.g2d.ParticleEmitter.c(bufferedReader, "edges");
                    this.e = com.badlogic.gdx.graphics.g2d.ParticleEmitter.SpawnEllipseSide.valueOf(com.badlogic.gdx.graphics.g2d.ParticleEmitter.g(bufferedReader, "side"));
                }
            }
        }

        @Override // com.badlogic.gdx.graphics.g2d.ParticleEmitter.ParticleValue
        public void save(java.io.Writer writer) throws java.io.IOException {
            super.save(writer);
            if (this.a) {
                writer.write("shape: " + this.c + "\n");
                if (this.c == com.badlogic.gdx.graphics.g2d.ParticleEmitter.SpawnShape.ellipse) {
                    writer.write("edges: " + this.d + "\n");
                    writer.write("side: " + this.e + "\n");
                }
            }
        }

        public void setEdges(boolean z) {
            this.d = z;
        }

        public void setShape(com.badlogic.gdx.graphics.g2d.ParticleEmitter.SpawnShape spawnShape) {
            this.c = spawnShape;
        }

        public void setSide(com.badlogic.gdx.graphics.g2d.ParticleEmitter.SpawnEllipseSide spawnEllipseSide) {
            this.e = spawnEllipseSide;
        }
    }

    public ParticleEmitter() {
        this.a = new com.badlogic.gdx.graphics.g2d.ParticleEmitter.RangedNumericValue();
        this.b = new com.badlogic.gdx.graphics.g2d.ParticleEmitter.ScaledNumericValue();
        this.c = new com.badlogic.gdx.graphics.g2d.ParticleEmitter.RangedNumericValue();
        this.d = new com.badlogic.gdx.graphics.g2d.ParticleEmitter.ScaledNumericValue();
        this.e = new com.badlogic.gdx.graphics.g2d.ParticleEmitter.ScaledNumericValue();
        this.f = new com.badlogic.gdx.graphics.g2d.ParticleEmitter.ScaledNumericValue();
        this.g = new com.badlogic.gdx.graphics.g2d.ParticleEmitter.ScaledNumericValue();
        this.h = new com.badlogic.gdx.graphics.g2d.ParticleEmitter.ScaledNumericValue();
        this.i = new com.badlogic.gdx.graphics.g2d.ParticleEmitter.ScaledNumericValue();
        this.j = new com.badlogic.gdx.graphics.g2d.ParticleEmitter.ScaledNumericValue();
        this.k = new com.badlogic.gdx.graphics.g2d.ParticleEmitter.ScaledNumericValue();
        this.l = new com.badlogic.gdx.graphics.g2d.ParticleEmitter.ScaledNumericValue();
        this.m = new com.badlogic.gdx.graphics.g2d.ParticleEmitter.GradientColorValue();
        this.n = new com.badlogic.gdx.graphics.g2d.ParticleEmitter.ScaledNumericValue();
        this.o = new com.badlogic.gdx.graphics.g2d.ParticleEmitter.ScaledNumericValue();
        this.p = new com.badlogic.gdx.graphics.g2d.ParticleEmitter.ScaledNumericValue();
        this.q = new com.badlogic.gdx.graphics.g2d.ParticleEmitter.ScaledNumericValue();
        this.r = new com.badlogic.gdx.graphics.g2d.ParticleEmitter.SpawnShapeValue();
        this.w = 4;
        this.duration = 1.0f;
        this.a0 = true;
        this.b0 = false;
        this.c0 = true;
        this.d0 = 1.0f;
        this.f0 = 1.0f;
        b();
    }

    public ParticleEmitter(com.badlogic.gdx.graphics.g2d.ParticleEmitter particleEmitter) {
        this.a = new com.badlogic.gdx.graphics.g2d.ParticleEmitter.RangedNumericValue();
        this.b = new com.badlogic.gdx.graphics.g2d.ParticleEmitter.ScaledNumericValue();
        this.c = new com.badlogic.gdx.graphics.g2d.ParticleEmitter.RangedNumericValue();
        this.d = new com.badlogic.gdx.graphics.g2d.ParticleEmitter.ScaledNumericValue();
        this.e = new com.badlogic.gdx.graphics.g2d.ParticleEmitter.ScaledNumericValue();
        this.f = new com.badlogic.gdx.graphics.g2d.ParticleEmitter.ScaledNumericValue();
        this.g = new com.badlogic.gdx.graphics.g2d.ParticleEmitter.ScaledNumericValue();
        this.h = new com.badlogic.gdx.graphics.g2d.ParticleEmitter.ScaledNumericValue();
        this.i = new com.badlogic.gdx.graphics.g2d.ParticleEmitter.ScaledNumericValue();
        this.j = new com.badlogic.gdx.graphics.g2d.ParticleEmitter.ScaledNumericValue();
        this.k = new com.badlogic.gdx.graphics.g2d.ParticleEmitter.ScaledNumericValue();
        this.l = new com.badlogic.gdx.graphics.g2d.ParticleEmitter.ScaledNumericValue();
        this.m = new com.badlogic.gdx.graphics.g2d.ParticleEmitter.GradientColorValue();
        this.n = new com.badlogic.gdx.graphics.g2d.ParticleEmitter.ScaledNumericValue();
        this.o = new com.badlogic.gdx.graphics.g2d.ParticleEmitter.ScaledNumericValue();
        this.p = new com.badlogic.gdx.graphics.g2d.ParticleEmitter.ScaledNumericValue();
        this.q = new com.badlogic.gdx.graphics.g2d.ParticleEmitter.ScaledNumericValue();
        this.r = new com.badlogic.gdx.graphics.g2d.ParticleEmitter.SpawnShapeValue();
        this.w = 4;
        this.duration = 1.0f;
        this.a0 = true;
        this.b0 = false;
        this.c0 = true;
        this.d0 = 1.0f;
        this.f0 = 1.0f;
        this.t = particleEmitter.t;
        this.z = particleEmitter.z;
        this.A = particleEmitter.A;
        setMaxParticleCount(particleEmitter.w);
        this.v = particleEmitter.v;
        this.a.load(particleEmitter.a);
        this.c.load(particleEmitter.c);
        this.e.load(particleEmitter.e);
        this.d.load(particleEmitter.d);
        this.b.load(particleEmitter.b);
        this.f.load(particleEmitter.f);
        this.g.load(particleEmitter.g);
        this.h.load(particleEmitter.h);
        this.i.load(particleEmitter.i);
        this.j.load(particleEmitter.j);
        this.k.load(particleEmitter.k);
        this.l.load(particleEmitter.l);
        this.m.load(particleEmitter.m);
        this.n.load(particleEmitter.n);
        this.o.load(particleEmitter.o);
        this.p.load(particleEmitter.p);
        this.q.load(particleEmitter.q);
        this.r.load(particleEmitter.r);
        this.W = particleEmitter.W;
        this.X = particleEmitter.X;
        this.Y = particleEmitter.Y;
        this.Z = particleEmitter.Z;
        this.a0 = particleEmitter.a0;
        this.b0 = particleEmitter.b0;
        this.c0 = particleEmitter.c0;
        this.e0 = particleEmitter.e0;
    }

    public ParticleEmitter(java.io.BufferedReader bufferedReader) throws java.io.IOException {
        this.a = new com.badlogic.gdx.graphics.g2d.ParticleEmitter.RangedNumericValue();
        this.b = new com.badlogic.gdx.graphics.g2d.ParticleEmitter.ScaledNumericValue();
        this.c = new com.badlogic.gdx.graphics.g2d.ParticleEmitter.RangedNumericValue();
        this.d = new com.badlogic.gdx.graphics.g2d.ParticleEmitter.ScaledNumericValue();
        this.e = new com.badlogic.gdx.graphics.g2d.ParticleEmitter.ScaledNumericValue();
        this.f = new com.badlogic.gdx.graphics.g2d.ParticleEmitter.ScaledNumericValue();
        this.g = new com.badlogic.gdx.graphics.g2d.ParticleEmitter.ScaledNumericValue();
        this.h = new com.badlogic.gdx.graphics.g2d.ParticleEmitter.ScaledNumericValue();
        this.i = new com.badlogic.gdx.graphics.g2d.ParticleEmitter.ScaledNumericValue();
        this.j = new com.badlogic.gdx.graphics.g2d.ParticleEmitter.ScaledNumericValue();
        this.k = new com.badlogic.gdx.graphics.g2d.ParticleEmitter.ScaledNumericValue();
        this.l = new com.badlogic.gdx.graphics.g2d.ParticleEmitter.ScaledNumericValue();
        this.m = new com.badlogic.gdx.graphics.g2d.ParticleEmitter.GradientColorValue();
        this.n = new com.badlogic.gdx.graphics.g2d.ParticleEmitter.ScaledNumericValue();
        this.o = new com.badlogic.gdx.graphics.g2d.ParticleEmitter.ScaledNumericValue();
        this.p = new com.badlogic.gdx.graphics.g2d.ParticleEmitter.ScaledNumericValue();
        this.q = new com.badlogic.gdx.graphics.g2d.ParticleEmitter.ScaledNumericValue();
        this.r = new com.badlogic.gdx.graphics.g2d.ParticleEmitter.SpawnShapeValue();
        this.w = 4;
        this.duration = 1.0f;
        this.a0 = true;
        this.b0 = false;
        this.c0 = true;
        this.d0 = 1.0f;
        this.f0 = 1.0f;
        b();
        load(bufferedReader);
    }

    public static boolean c(java.io.BufferedReader bufferedReader, java.lang.String str) throws java.io.IOException {
        return java.lang.Boolean.parseBoolean(g(bufferedReader, str));
    }

    public static boolean d(java.lang.String str) throws java.io.IOException {
        return java.lang.Boolean.parseBoolean(h(str));
    }

    public static float e(java.io.BufferedReader bufferedReader, java.lang.String str) throws java.io.IOException {
        return java.lang.Float.parseFloat(g(bufferedReader, str));
    }

    public static int f(java.io.BufferedReader bufferedReader, java.lang.String str) throws java.io.IOException {
        return java.lang.Integer.parseInt(g(bufferedReader, str));
    }

    public static java.lang.String g(java.io.BufferedReader bufferedReader, java.lang.String str) throws java.io.IOException {
        java.lang.String readLine = bufferedReader.readLine();
        if (readLine != null) {
            return h(readLine);
        }
        throw new java.io.IOException("Missing value: " + str);
    }

    public static java.lang.String h(java.lang.String str) throws java.io.IOException {
        return str.substring(str.indexOf(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR) + 1).trim();
    }

    public final void a(int i) {
        float f;
        float f2;
        float random;
        float random2;
        com.badlogic.gdx.graphics.g2d.ParticleEmitter.Particle[] particleArr = this.u;
        com.badlogic.gdx.graphics.g2d.ParticleEmitter.Particle particle = particleArr[i];
        if (particle == null) {
            particle = newParticle(this.t);
            particleArr[i] = particle;
            particle.flip(this.E, this.F);
        }
        float f3 = this.durationTimer / this.duration;
        int i2 = this.G;
        int scale = this.O + ((int) (this.P * this.d.getScale(f3)));
        particle.life = scale;
        particle.currentLife = scale;
        com.badlogic.gdx.graphics.g2d.ParticleEmitter.ScaledNumericValue scaledNumericValue = this.h;
        if (scaledNumericValue.a) {
            particle.velocity = scaledNumericValue.newLowValue();
            particle.velocityDiff = this.h.newHighValue();
            if (!this.h.isRelative()) {
                particle.velocityDiff -= particle.velocity;
            }
        }
        particle.angle = this.i.newLowValue();
        particle.angleDiff = this.i.newHighValue();
        if (!this.i.isRelative()) {
            particle.angleDiff -= particle.angle;
        }
        int i3 = i2 & 2;
        if (i3 == 0) {
            f = particle.angle + (particle.angleDiff * this.i.getScale(0.0f));
            particle.angle = f;
            particle.angleCos = com.badlogic.gdx.math.MathUtils.cosDeg(f);
            particle.angleSin = com.badlogic.gdx.math.MathUtils.sinDeg(f);
        } else {
            f = 0.0f;
        }
        float width = this.t.getWidth();
        particle.scale = this.f.newLowValue() / width;
        particle.scaleDiff = this.f.newHighValue() / width;
        if (!this.f.isRelative()) {
            particle.scaleDiff -= particle.scale;
        }
        particle.setScale(particle.scale + (particle.scaleDiff * this.f.getScale(0.0f)));
        com.badlogic.gdx.graphics.g2d.ParticleEmitter.ScaledNumericValue scaledNumericValue2 = this.g;
        if (scaledNumericValue2.a) {
            particle.rotation = scaledNumericValue2.newLowValue();
            particle.rotationDiff = this.g.newHighValue();
            if (!this.g.isRelative()) {
                particle.rotationDiff -= particle.rotation;
            }
            float scale2 = particle.rotation + (particle.rotationDiff * this.g.getScale(0.0f));
            if (this.Y) {
                scale2 += f;
            }
            particle.setRotation(scale2);
        }
        com.badlogic.gdx.graphics.g2d.ParticleEmitter.ScaledNumericValue scaledNumericValue3 = this.j;
        if (scaledNumericValue3.a) {
            particle.wind = scaledNumericValue3.newLowValue();
            particle.windDiff = this.j.newHighValue();
            if (!this.j.isRelative()) {
                particle.windDiff -= particle.wind;
            }
        }
        com.badlogic.gdx.graphics.g2d.ParticleEmitter.ScaledNumericValue scaledNumericValue4 = this.k;
        if (scaledNumericValue4.a) {
            particle.gravity = scaledNumericValue4.newLowValue();
            particle.gravityDiff = this.k.newHighValue();
            if (!this.k.isRelative()) {
                particle.gravityDiff -= particle.gravity;
            }
        }
        float[] fArr = particle.tint;
        if (fArr == null) {
            fArr = new float[3];
            particle.tint = fArr;
        }
        float[] color = this.m.getColor(0.0f);
        fArr[0] = color[0];
        fArr[1] = color[1];
        fArr[2] = color[2];
        particle.transparency = this.l.newLowValue();
        particle.transparencyDiff = this.l.newHighValue() - particle.transparency;
        float f4 = this.x;
        com.badlogic.gdx.graphics.g2d.ParticleEmitter.RangedNumericValue rangedNumericValue = this.n;
        if (rangedNumericValue.a) {
            f4 += rangedNumericValue.newLowValue();
        }
        float f5 = this.y;
        com.badlogic.gdx.graphics.g2d.ParticleEmitter.RangedNumericValue rangedNumericValue2 = this.o;
        if (rangedNumericValue2.a) {
            f5 += rangedNumericValue2.newLowValue();
        }
        int i4 = com.badlogic.gdx.graphics.g2d.ParticleEmitter.AnonymousClass1.b[this.r.c.ordinal()];
        if (i4 != 1) {
            if (i4 == 2) {
                float scale3 = this.Q + (this.R * this.p.getScale(f3));
                float scale4 = this.S + (this.T * this.q.getScale(f3));
                float f6 = scale3 / 2.0f;
                float f7 = scale4 / 2.0f;
                if (f6 != 0.0f && f7 != 0.0f) {
                    float f8 = f6 / f7;
                    com.badlogic.gdx.graphics.g2d.ParticleEmitter.SpawnShapeValue spawnShapeValue = this.r;
                    if (spawnShapeValue.d) {
                        int i5 = com.badlogic.gdx.graphics.g2d.ParticleEmitter.AnonymousClass1.a[spawnShapeValue.e.ordinal()];
                        float random3 = i5 != 1 ? i5 != 2 ? com.badlogic.gdx.math.MathUtils.random(360.0f) : com.badlogic.gdx.math.MathUtils.random(179.0f) : -com.badlogic.gdx.math.MathUtils.random(179.0f);
                        float cosDeg = com.badlogic.gdx.math.MathUtils.cosDeg(random3);
                        float sinDeg = com.badlogic.gdx.math.MathUtils.sinDeg(random3);
                        f4 += cosDeg * f6;
                        f5 += (f6 * sinDeg) / f8;
                        if (i3 == 0) {
                            particle.angle = random3;
                            particle.angleCos = cosDeg;
                            particle.angleSin = sinDeg;
                        }
                    } else {
                        float f9 = f6 * f6;
                        do {
                            random = com.badlogic.gdx.math.MathUtils.random(scale3) - f6;
                            random2 = com.badlogic.gdx.math.MathUtils.random(scale4) - f7;
                        } while ((random * random) + (random2 * random2) > f9);
                        f4 += random;
                        f5 += random2 / f8;
                    }
                }
            } else if (i4 == 3) {
                float scale5 = this.Q + (this.R * this.p.getScale(f3));
                float scale6 = this.S + (this.T * this.q.getScale(f3));
                if (scale5 != 0.0f) {
                    float random4 = com.badlogic.gdx.math.MathUtils.random() * scale5;
                    f4 += random4;
                    f5 += random4 * (scale6 / scale5);
                } else {
                    f5 += scale6 * com.badlogic.gdx.math.MathUtils.random();
                }
            }
            f2 = 2.0f;
        } else {
            float scale7 = this.Q + (this.R * this.p.getScale(f3));
            float scale8 = this.S + (this.T * this.q.getScale(f3));
            f2 = 2.0f;
            f4 += com.badlogic.gdx.math.MathUtils.random(scale7) - (scale7 / 2.0f);
            f5 += com.badlogic.gdx.math.MathUtils.random(scale8) - (scale8 / 2.0f);
        }
        float height = this.t.getHeight();
        particle.setBounds(f4 - (width / f2), f5 - (height / f2), width, height);
        int scale9 = (int) (this.M + (this.N * this.b.getScale(f3)));
        if (scale9 > 0) {
            int i6 = particle.currentLife;
            if (scale9 >= i6) {
                scale9 = i6 - 1;
            }
            j(particle, scale9 / 1000.0f, scale9);
        }
    }

    public void addParticle() {
        int i = this.B;
        if (i == this.w) {
            return;
        }
        boolean[] zArr = this.C;
        int length = zArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (!zArr[i2]) {
                a(i2);
                zArr[i2] = true;
                this.B = i + 1;
                return;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x001f, code lost:
    
        a(r3);
        r0[r3] = true;
        r2 = r2 + 1;
        r3 = r3 + 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void addParticles(int i) {
        int min = java.lang.Math.min(i, this.w - this.B);
        if (min == 0) {
            return;
        }
        boolean[] zArr = this.C;
        int i2 = (int) (min * this.f0);
        int length = zArr.length;
        int i3 = 0;
        int i4 = 0;
        loop0: while (i3 < i2) {
            while (i4 < length) {
                if (!zArr[i4]) {
                    break;
                } else {
                    i4++;
                }
            }
            break loop0;
        }
        this.B += i2;
    }

    public void allowCompletion() {
        this.H = true;
        this.durationTimer = this.duration;
    }

    public final void b() {
        this.c.setAlwaysActive(true);
        this.e.setAlwaysActive(true);
        this.d.setAlwaysActive(true);
        this.f.setAlwaysActive(true);
        this.l.setAlwaysActive(true);
        this.r.setAlwaysActive(true);
        this.p.setAlwaysActive(true);
        this.q.setAlwaysActive(true);
    }

    public boolean cleansUpBlendFunction() {
        return this.c0;
    }

    public void draw(com.badlogic.gdx.graphics.g2d.Batch batch) {
        if (this.b0) {
            batch.setBlendFunction(1, com.badlogic.gdx.graphics.GL20.GL_ONE_MINUS_SRC_ALPHA);
        } else if (this.a0) {
            batch.setBlendFunction(com.badlogic.gdx.graphics.GL20.GL_SRC_ALPHA, 1);
        } else {
            batch.setBlendFunction(com.badlogic.gdx.graphics.GL20.GL_SRC_ALPHA, com.badlogic.gdx.graphics.GL20.GL_ONE_MINUS_SRC_ALPHA);
        }
        com.badlogic.gdx.graphics.g2d.ParticleEmitter.Particle[] particleArr = this.u;
        boolean[] zArr = this.C;
        int length = zArr.length;
        for (int i = 0; i < length; i++) {
            if (zArr[i]) {
                particleArr[i].draw(batch);
            }
        }
        if (this.c0) {
            if (this.a0 || this.b0) {
                batch.setBlendFunction(com.badlogic.gdx.graphics.GL20.GL_SRC_ALPHA, com.badlogic.gdx.graphics.GL20.GL_ONE_MINUS_SRC_ALPHA);
            }
        }
    }

    public void draw(com.badlogic.gdx.graphics.g2d.Batch batch, float f) {
        float f2 = this.f288s + (f * 1000.0f);
        this.f288s = f2;
        if (f2 < 1.0f) {
            draw(batch);
            return;
        }
        int i = (int) f2;
        float f3 = i;
        this.f288s = f2 - f3;
        if (this.b0) {
            batch.setBlendFunction(1, com.badlogic.gdx.graphics.GL20.GL_ONE_MINUS_SRC_ALPHA);
        } else if (this.a0) {
            batch.setBlendFunction(com.badlogic.gdx.graphics.GL20.GL_SRC_ALPHA, 1);
        } else {
            batch.setBlendFunction(com.badlogic.gdx.graphics.GL20.GL_SRC_ALPHA, com.badlogic.gdx.graphics.GL20.GL_ONE_MINUS_SRC_ALPHA);
        }
        com.badlogic.gdx.graphics.g2d.ParticleEmitter.Particle[] particleArr = this.u;
        boolean[] zArr = this.C;
        int i2 = this.B;
        int length = zArr.length;
        for (int i3 = 0; i3 < length; i3++) {
            if (zArr[i3]) {
                com.badlogic.gdx.graphics.g2d.ParticleEmitter.Particle particle = particleArr[i3];
                if (j(particle, f, i)) {
                    particle.draw(batch);
                } else {
                    zArr[i3] = false;
                    i2--;
                }
            }
        }
        this.B = i2;
        if (this.c0 && (this.a0 || this.b0)) {
            batch.setBlendFunction(com.badlogic.gdx.graphics.GL20.GL_SRC_ALPHA, com.badlogic.gdx.graphics.GL20.GL_ONE_MINUS_SRC_ALPHA);
        }
        float f4 = this.V;
        if (f4 < this.U) {
            this.V = f4 + f3;
            return;
        }
        if (this.D) {
            this.D = false;
            addParticle();
        }
        float f5 = this.durationTimer;
        if (f5 < this.duration) {
            this.durationTimer = f5 + f3;
        } else if (!this.X || this.H) {
            return;
        } else {
            i();
        }
        this.L += i;
        float scale = this.J + (this.K * this.e.getScale(this.durationTimer / this.duration));
        if (scale > 0.0f) {
            float f6 = 1000.0f / scale;
            int i4 = this.L;
            if (i4 >= f6) {
                int min = java.lang.Math.min((int) (i4 / f6), this.w - i2);
                this.L = (int) (((int) (this.L - (min * f6))) % f6);
                addParticles(min);
            }
        }
        int i5 = this.v;
        if (i2 < i5) {
            addParticles(i5 - i2);
        }
    }

    public void flipY() {
        com.badlogic.gdx.graphics.g2d.ParticleEmitter.ScaledNumericValue scaledNumericValue = this.i;
        scaledNumericValue.setHigh(-scaledNumericValue.getHighMin(), -this.i.getHighMax());
        com.badlogic.gdx.graphics.g2d.ParticleEmitter.ScaledNumericValue scaledNumericValue2 = this.i;
        scaledNumericValue2.setLow(-scaledNumericValue2.getLowMin(), -this.i.getLowMax());
        com.badlogic.gdx.graphics.g2d.ParticleEmitter.ScaledNumericValue scaledNumericValue3 = this.k;
        scaledNumericValue3.setHigh(-scaledNumericValue3.getHighMin(), -this.k.getHighMax());
        com.badlogic.gdx.graphics.g2d.ParticleEmitter.ScaledNumericValue scaledNumericValue4 = this.k;
        scaledNumericValue4.setLow(-scaledNumericValue4.getLowMin(), -this.k.getLowMax());
        com.badlogic.gdx.graphics.g2d.ParticleEmitter.ScaledNumericValue scaledNumericValue5 = this.j;
        scaledNumericValue5.setHigh(-scaledNumericValue5.getHighMin(), -this.j.getHighMax());
        com.badlogic.gdx.graphics.g2d.ParticleEmitter.ScaledNumericValue scaledNumericValue6 = this.j;
        scaledNumericValue6.setLow(-scaledNumericValue6.getLowMin(), -this.j.getLowMax());
        com.badlogic.gdx.graphics.g2d.ParticleEmitter.ScaledNumericValue scaledNumericValue7 = this.g;
        scaledNumericValue7.setHigh(-scaledNumericValue7.getHighMin(), -this.g.getHighMax());
        com.badlogic.gdx.graphics.g2d.ParticleEmitter.ScaledNumericValue scaledNumericValue8 = this.g;
        scaledNumericValue8.setLow(-scaledNumericValue8.getLowMin(), -this.g.getLowMax());
        com.badlogic.gdx.graphics.g2d.ParticleEmitter.RangedNumericValue rangedNumericValue = this.o;
        rangedNumericValue.setLow(-rangedNumericValue.getLowMin(), -this.o.getLowMax());
    }

    public int getActiveCount() {
        return this.B;
    }

    public com.badlogic.gdx.graphics.g2d.ParticleEmitter.ScaledNumericValue getAngle() {
        return this.i;
    }

    public com.badlogic.gdx.math.collision.BoundingBox getBoundingBox() {
        if (this.I == null) {
            this.I = new com.badlogic.gdx.math.collision.BoundingBox();
        }
        com.badlogic.gdx.graphics.g2d.ParticleEmitter.Particle[] particleArr = this.u;
        boolean[] zArr = this.C;
        com.badlogic.gdx.math.collision.BoundingBox boundingBox = this.I;
        boundingBox.inf();
        int length = zArr.length;
        for (int i = 0; i < length; i++) {
            if (zArr[i]) {
                com.badlogic.gdx.math.Rectangle boundingRectangle = particleArr[i].getBoundingRectangle();
                boundingBox.ext(boundingRectangle.x, boundingRectangle.y, 0.0f);
                boundingBox.ext(boundingRectangle.x + boundingRectangle.width, boundingRectangle.y + boundingRectangle.height, 0.0f);
            }
        }
        return boundingBox;
    }

    public com.badlogic.gdx.graphics.g2d.ParticleEmitter.RangedNumericValue getDelay() {
        return this.a;
    }

    public com.badlogic.gdx.graphics.g2d.ParticleEmitter.RangedNumericValue getDuration() {
        return this.c;
    }

    public com.badlogic.gdx.graphics.g2d.ParticleEmitter.ScaledNumericValue getEmission() {
        return this.e;
    }

    public com.badlogic.gdx.graphics.g2d.ParticleEmitter.ExtraValue getExtraValue() {
        return this.e0;
    }

    public com.badlogic.gdx.graphics.g2d.ParticleEmitter.ScaledNumericValue getGravity() {
        return this.k;
    }

    public java.lang.String getImagePath() {
        return this.A;
    }

    public com.badlogic.gdx.graphics.g2d.ParticleEmitter.ScaledNumericValue getLife() {
        return this.d;
    }

    public com.badlogic.gdx.graphics.g2d.ParticleEmitter.ScaledNumericValue getLifeOffset() {
        return this.b;
    }

    public int getMaxParticleCount() {
        return this.w;
    }

    public int getMinParticleCount() {
        return this.v;
    }

    public java.lang.String getName() {
        return this.z;
    }

    public float getPercentComplete() {
        if (this.V < this.U) {
            return 0.0f;
        }
        return java.lang.Math.min(1.0f, this.durationTimer / this.duration);
    }

    public com.badlogic.gdx.graphics.g2d.ParticleEmitter.ScaledNumericValue getRotation() {
        return this.g;
    }

    public com.badlogic.gdx.graphics.g2d.ParticleEmitter.ScaledNumericValue getScale() {
        return this.f;
    }

    public com.badlogic.gdx.graphics.g2d.ParticleEmitter.ScaledNumericValue getSpawnHeight() {
        return this.q;
    }

    public com.badlogic.gdx.graphics.g2d.ParticleEmitter.SpawnShapeValue getSpawnShape() {
        return this.r;
    }

    public com.badlogic.gdx.graphics.g2d.ParticleEmitter.ScaledNumericValue getSpawnWidth() {
        return this.p;
    }

    public com.badlogic.gdx.graphics.g2d.Sprite getSprite() {
        return this.t;
    }

    public com.badlogic.gdx.graphics.g2d.ParticleEmitter.GradientColorValue getTint() {
        return this.m;
    }

    public com.badlogic.gdx.graphics.g2d.ParticleEmitter.ScaledNumericValue getTransparency() {
        return this.l;
    }

    public com.badlogic.gdx.graphics.g2d.ParticleEmitter.ScaledNumericValue getVelocity() {
        return this.h;
    }

    public com.badlogic.gdx.graphics.g2d.ParticleEmitter.ScaledNumericValue getWind() {
        return this.j;
    }

    public float getX() {
        return this.x;
    }

    public com.badlogic.gdx.graphics.g2d.ParticleEmitter.RangedNumericValue getXOffsetValue() {
        return this.n;
    }

    public float getY() {
        return this.y;
    }

    public com.badlogic.gdx.graphics.g2d.ParticleEmitter.RangedNumericValue getYOffsetValue() {
        return this.o;
    }

    public final void i() {
        com.badlogic.gdx.graphics.g2d.ParticleEmitter.RangedNumericValue rangedNumericValue = this.a;
        this.U = rangedNumericValue.a ? rangedNumericValue.newLowValue() : 0.0f;
        this.V = 0.0f;
        this.durationTimer -= this.duration;
        this.duration = this.c.newLowValue();
        this.J = (int) this.e.newLowValue();
        this.K = (int) this.e.newHighValue();
        if (!this.e.isRelative()) {
            this.K -= this.J;
        }
        this.O = (int) this.d.newLowValue();
        this.P = (int) this.d.newHighValue();
        if (!this.d.isRelative()) {
            this.P -= this.O;
        }
        com.badlogic.gdx.graphics.g2d.ParticleEmitter.ScaledNumericValue scaledNumericValue = this.b;
        this.M = scaledNumericValue.a ? (int) scaledNumericValue.newLowValue() : 0;
        this.N = (int) this.b.newHighValue();
        if (!this.b.isRelative()) {
            this.N -= this.M;
        }
        this.Q = this.p.newLowValue();
        this.R = this.p.newHighValue();
        if (!this.p.isRelative()) {
            this.R -= this.Q;
        }
        this.S = this.q.newLowValue();
        this.T = this.q.newHighValue();
        if (!this.q.isRelative()) {
            this.T -= this.S;
        }
        this.G = 0;
        com.badlogic.gdx.graphics.g2d.ParticleEmitter.ScaledNumericValue scaledNumericValue2 = this.i;
        if (scaledNumericValue2.a && scaledNumericValue2.f.length > 1) {
            this.G = 0 | 2;
        }
        if (this.h.a) {
            this.G |= 8;
        }
        if (this.f.f.length > 1) {
            this.G |= 1;
        }
        com.badlogic.gdx.graphics.g2d.ParticleEmitter.ScaledNumericValue scaledNumericValue3 = this.g;
        if (scaledNumericValue3.a && scaledNumericValue3.f.length > 1) {
            this.G |= 4;
        }
        if (this.j.a) {
            this.G |= 16;
        }
        if (this.k.a) {
            this.G |= 32;
        }
        if (this.m.d.length > 1) {
            this.G |= 64;
        }
    }

    public boolean isAdditive() {
        return this.a0;
    }

    public boolean isAligned() {
        return this.Y;
    }

    public boolean isAttached() {
        return this.W;
    }

    public boolean isBehind() {
        return this.Z;
    }

    public boolean isComplete() {
        return (!this.X || this.H) && this.V >= this.U && this.durationTimer >= this.duration && this.B == 0;
    }

    public boolean isContinuous() {
        return this.X;
    }

    public boolean isPremultipliedAlpha() {
        return this.b0;
    }

    public final boolean j(com.badlogic.gdx.graphics.g2d.ParticleEmitter.Particle particle, float f, int i) {
        float f2;
        float f3;
        int i2 = particle.currentLife - i;
        if (i2 <= 0) {
            return false;
        }
        particle.currentLife = i2;
        float f4 = 1.0f - (i2 / particle.life);
        int i3 = this.G;
        if ((i3 & 1) != 0) {
            particle.setScale(particle.scale + (particle.scaleDiff * this.f.getScale(f4)));
        }
        if ((i3 & 8) != 0) {
            float scale = (particle.velocity + (particle.velocityDiff * this.h.getScale(f4))) * f;
            if ((i3 & 2) != 0) {
                float scale2 = particle.angle + (particle.angleDiff * this.i.getScale(f4));
                f2 = com.badlogic.gdx.math.MathUtils.cosDeg(scale2) * scale;
                f3 = scale * com.badlogic.gdx.math.MathUtils.sinDeg(scale2);
                if ((i3 & 4) != 0) {
                    float scale3 = particle.rotation + (particle.rotationDiff * this.g.getScale(f4));
                    if (this.Y) {
                        scale3 += scale2;
                    }
                    particle.setRotation(scale3);
                }
            } else {
                f2 = scale * particle.angleCos;
                f3 = scale * particle.angleSin;
                if (this.Y || (i3 & 4) != 0) {
                    float scale4 = particle.rotation + (particle.rotationDiff * this.g.getScale(f4));
                    if (this.Y) {
                        scale4 += particle.angle;
                    }
                    particle.setRotation(scale4);
                }
            }
            if ((i3 & 16) != 0) {
                f2 += (particle.wind + (particle.windDiff * this.j.getScale(f4))) * f;
            }
            if ((i3 & 32) != 0) {
                f3 += (particle.gravity + (particle.gravityDiff * this.k.getScale(f4))) * f;
            }
            float f5 = this.f0;
            particle.translate(f2 * f5, f3 * f5);
        } else if ((i3 & 4) != 0) {
            particle.setRotation(particle.rotation + (particle.rotationDiff * this.g.getScale(f4)));
        }
        float[] color = (i3 & 64) != 0 ? this.m.getColor(f4) : particle.tint;
        if (this.b0) {
            float f6 = this.a0 ? 0.0f : 1.0f;
            float scale5 = particle.transparency + (particle.transparencyDiff * this.l.getScale(f4));
            particle.setColor(color[0] * scale5, color[1] * scale5, color[2] * scale5, scale5 * f6 * this.d0);
        } else {
            particle.setColor(color[0], color[1], color[2], (particle.transparency + (particle.transparencyDiff * this.l.getScale(f4))) * this.d0);
        }
        return true;
    }

    public void load(java.io.BufferedReader bufferedReader) throws java.io.IOException {
        try {
            this.z = g(bufferedReader, "name");
            bufferedReader.readLine();
            this.a.load(bufferedReader);
            bufferedReader.readLine();
            this.c.load(bufferedReader);
            bufferedReader.readLine();
            setMinParticleCount(f(bufferedReader, "minParticleCount"));
            setMaxParticleCount(f(bufferedReader, "maxParticleCount"));
            bufferedReader.readLine();
            this.e.load(bufferedReader);
            bufferedReader.readLine();
            this.d.load(bufferedReader);
            bufferedReader.readLine();
            this.b.load(bufferedReader);
            bufferedReader.readLine();
            this.n.load(bufferedReader);
            bufferedReader.readLine();
            this.o.load(bufferedReader);
            bufferedReader.readLine();
            this.r.load(bufferedReader);
            bufferedReader.readLine();
            this.p.load(bufferedReader);
            bufferedReader.readLine();
            this.q.load(bufferedReader);
            bufferedReader.readLine();
            this.f.load(bufferedReader);
            bufferedReader.readLine();
            this.h.load(bufferedReader);
            bufferedReader.readLine();
            this.i.load(bufferedReader);
            bufferedReader.readLine();
            this.g.load(bufferedReader);
            bufferedReader.readLine();
            this.j.load(bufferedReader);
            bufferedReader.readLine();
            this.k.load(bufferedReader);
            bufferedReader.readLine();
            this.m.load(bufferedReader);
            bufferedReader.readLine();
            this.l.load(bufferedReader);
            bufferedReader.readLine();
            this.W = c(bufferedReader, "attached");
            this.X = c(bufferedReader, "continuous");
            this.Y = c(bufferedReader, "aligned");
            this.a0 = c(bufferedReader, "additive");
            this.Z = c(bufferedReader, "behind");
            java.lang.String readLine = bufferedReader.readLine();
            if (readLine.startsWith("premultipliedAlpha")) {
                this.b0 = d(readLine);
                bufferedReader.readLine();
            }
            setImagePath(bufferedReader.readLine());
            bufferedReader.readLine();
            com.badlogic.gdx.graphics.g2d.ParticleEmitter.ExtraValue extraValue = new com.badlogic.gdx.graphics.g2d.ParticleEmitter.ExtraValue();
            extraValue.a = e(bufferedReader, "ratioScreenW");
            extraValue.b = e(bufferedReader, "ratioScreenH");
            extraValue.c = e(bufferedReader, "ratioBgW");
            extraValue.d = e(bufferedReader, "ratioBgH");
            this.e0 = extraValue;
            bufferedReader.readLine();
        } catch (java.lang.RuntimeException e) {
            if (this.z == null) {
                throw e;
            }
            throw new java.lang.RuntimeException("Error parsing emitter: " + this.z, e);
        }
    }

    public com.badlogic.gdx.graphics.g2d.ParticleEmitter.Particle newParticle(com.badlogic.gdx.graphics.g2d.Sprite sprite) {
        return new com.badlogic.gdx.graphics.g2d.ParticleEmitter.Particle(sprite);
    }

    public void reset() {
        this.L = 0;
        this.durationTimer = this.duration;
        boolean[] zArr = this.C;
        int length = zArr.length;
        for (int i = 0; i < length; i++) {
            zArr[i] = false;
        }
        this.B = 0;
        start();
    }

    public void save(java.io.Writer writer) throws java.io.IOException {
        writer.write(this.z + "\n");
        writer.write("- Delay -\n");
        this.a.save(writer);
        writer.write("- Duration - \n");
        this.c.save(writer);
        writer.write("- Count - \n");
        writer.write("min: " + this.v + "\n");
        writer.write("max: " + this.w + "\n");
        writer.write("- Emission - \n");
        this.e.save(writer);
        writer.write("- Life - \n");
        this.d.save(writer);
        writer.write("- Life Offset - \n");
        this.b.save(writer);
        writer.write("- X Offset - \n");
        this.n.save(writer);
        writer.write("- Y Offset - \n");
        this.o.save(writer);
        writer.write("- Spawn Shape - \n");
        this.r.save(writer);
        writer.write("- Spawn Width - \n");
        this.p.save(writer);
        writer.write("- Spawn Height - \n");
        this.q.save(writer);
        writer.write("- Scale - \n");
        this.f.save(writer);
        writer.write("- Velocity - \n");
        this.h.save(writer);
        writer.write("- Angle - \n");
        this.i.save(writer);
        writer.write("- Rotation - \n");
        this.g.save(writer);
        writer.write("- Wind - \n");
        this.j.save(writer);
        writer.write("- Gravity - \n");
        this.k.save(writer);
        writer.write("- Tint - \n");
        this.m.save(writer);
        writer.write("- Transparency - \n");
        this.l.save(writer);
        writer.write("- Options - \n");
        writer.write("attached: " + this.W + "\n");
        writer.write("continuous: " + this.X + "\n");
        writer.write("aligned: " + this.Y + "\n");
        writer.write("additive: " + this.a0 + "\n");
        writer.write("behind: " + this.Z + "\n");
        writer.write("premultipliedAlpha: " + this.b0 + "\n");
        writer.write("- Image Path -\n");
        writer.write(this.A + "\n");
        writer.write("- Extra -\n");
        writer.write("ratioScreenW: " + this.e0.a + "\n");
        writer.write("ratioScreenH: " + this.e0.b + "\n");
        writer.write("ratioBgW: " + this.e0.c + "\n");
        writer.write("ratioBgH: " + this.e0.d + "\n");
    }

    public void setAdditive(boolean z) {
        this.a0 = z;
    }

    public void setAligned(boolean z) {
        this.Y = z;
    }

    public void setAttached(boolean z) {
        this.W = z;
    }

    public void setBehind(boolean z) {
        this.Z = z;
    }

    public void setCleansUpBlendFunction(boolean z) {
        this.c0 = z;
    }

    public void setContinuous(boolean z) {
        this.X = z;
    }

    public void setExtraValue(com.badlogic.gdx.graphics.g2d.ParticleEmitter.ExtraValue extraValue) {
        this.e0 = extraValue;
    }

    public void setFlip(boolean z, boolean z2) {
        this.E = z;
        this.F = z2;
        com.badlogic.gdx.graphics.g2d.ParticleEmitter.Particle[] particleArr = this.u;
        if (particleArr == null) {
            return;
        }
        int length = particleArr.length;
        for (int i = 0; i < length; i++) {
            com.badlogic.gdx.graphics.g2d.ParticleEmitter.Particle particle = this.u[i];
            if (particle != null) {
                particle.flip(z, z2);
            }
        }
    }

    public void setImagePath(java.lang.String str) {
        this.A = str;
    }

    public void setMaxParticleCount(int i) {
        this.w = i;
        this.C = new boolean[i];
        this.B = 0;
        this.u = new com.badlogic.gdx.graphics.g2d.ParticleEmitter.Particle[i];
    }

    public void setMinParticleCount(int i) {
        this.v = i;
    }

    public void setName(java.lang.String str) {
        this.z = str;
    }

    public void setParticleFade(float f, float f2) {
        this.d0 = f;
        this.f0 = f2;
    }

    public void setPosition(float f, float f2) {
        if (this.W) {
            float f3 = f - this.x;
            float f4 = f2 - this.y;
            boolean[] zArr = this.C;
            int length = zArr.length;
            for (int i = 0; i < length; i++) {
                if (zArr[i]) {
                    this.u[i].translate(f3, f4);
                }
            }
        }
        this.x = f;
        this.y = f2;
    }

    public void setPremultipliedAlpha(boolean z) {
        this.b0 = z;
    }

    public void setSprite(com.badlogic.gdx.graphics.g2d.Sprite sprite) {
        this.t = sprite;
        if (sprite == null) {
            return;
        }
        float originX = sprite.getOriginX();
        float originY = sprite.getOriginY();
        com.badlogic.gdx.graphics.Texture texture = sprite.getTexture();
        int length = this.u.length;
        for (int i = 0; i < length; i++) {
            com.badlogic.gdx.graphics.g2d.ParticleEmitter.Particle particle = this.u[i];
            if (particle == null) {
                return;
            }
            particle.setTexture(texture);
            particle.setOrigin(originX, originY);
        }
    }

    public void start() {
        this.D = true;
        this.H = false;
        i();
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0049  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void update(float f) {
        boolean z;
        float f2 = this.f288s + (f * 1000.0f);
        this.f288s = f2;
        if (f2 < 1.0f) {
            return;
        }
        int i = (int) f2;
        float f3 = i;
        this.f288s = f2 - f3;
        float f4 = this.V;
        if (f4 < this.U) {
            this.V = f4 + f3;
        } else {
            if (this.D) {
                this.D = false;
                addParticle();
            }
            float f5 = this.durationTimer;
            if (f5 < this.duration) {
                this.durationTimer = f5 + f3;
            } else if (!this.X || this.H) {
                z = true;
                if (!z) {
                    this.L += i;
                    float scale = this.J + (this.K * this.e.getScale(this.durationTimer / this.duration));
                    if (scale > 0.0f) {
                        float f6 = 1000.0f / scale;
                        int i2 = this.L;
                        if (i2 >= f6) {
                            int min = java.lang.Math.min((int) (i2 / f6), this.w - this.B);
                            this.L = (int) (((int) (this.L - (min * f6))) % f6);
                            addParticles(min);
                        }
                    }
                    int i3 = this.B;
                    int i4 = this.v;
                    if (i3 < i4) {
                        addParticles(i4 - i3);
                    }
                }
            } else {
                i();
            }
            z = false;
            if (!z) {
            }
        }
        boolean[] zArr = this.C;
        int i5 = this.B;
        com.badlogic.gdx.graphics.g2d.ParticleEmitter.Particle[] particleArr = this.u;
        int length = zArr.length;
        for (int i6 = 0; i6 < length; i6++) {
            if (zArr[i6] && !j(particleArr[i6], f, i)) {
                zArr[i6] = false;
                i5--;
            }
        }
        this.B = i5;
    }
}
