package com.badlogic.gdx.math;

/* loaded from: classes12.dex */
public abstract class Interpolation {
    public static final com.badlogic.gdx.math.Interpolation.Bounce bounce;
    public static final com.badlogic.gdx.math.Interpolation.BounceIn bounceIn;
    public static final com.badlogic.gdx.math.Interpolation.BounceOut bounceOut;
    public static final com.badlogic.gdx.math.Interpolation circle;
    public static final com.badlogic.gdx.math.Interpolation circleIn;
    public static final com.badlogic.gdx.math.Interpolation circleOut;
    public static final com.badlogic.gdx.math.Interpolation.Elastic elastic;
    public static final com.badlogic.gdx.math.Interpolation.ElasticIn elasticIn;
    public static final com.badlogic.gdx.math.Interpolation.ElasticOut elasticOut;
    public static final com.badlogic.gdx.math.Interpolation.Exp exp10;
    public static final com.badlogic.gdx.math.Interpolation.ExpIn exp10In;
    public static final com.badlogic.gdx.math.Interpolation.ExpOut exp10Out;
    public static final com.badlogic.gdx.math.Interpolation.Exp exp5;
    public static final com.badlogic.gdx.math.Interpolation.ExpIn exp5In;
    public static final com.badlogic.gdx.math.Interpolation.ExpOut exp5Out;
    public static final com.badlogic.gdx.math.Interpolation fade;
    public static final com.badlogic.gdx.math.Interpolation.Pow pow2;
    public static final com.badlogic.gdx.math.Interpolation.PowIn pow2In;
    public static final com.badlogic.gdx.math.Interpolation pow2InInverse;
    public static final com.badlogic.gdx.math.Interpolation.PowOut pow2Out;
    public static final com.badlogic.gdx.math.Interpolation pow2OutInverse;
    public static final com.badlogic.gdx.math.Interpolation.Pow pow3;
    public static final com.badlogic.gdx.math.Interpolation.PowIn pow3In;
    public static final com.badlogic.gdx.math.Interpolation pow3InInverse;
    public static final com.badlogic.gdx.math.Interpolation.PowOut pow3Out;
    public static final com.badlogic.gdx.math.Interpolation pow3OutInverse;
    public static final com.badlogic.gdx.math.Interpolation.Pow pow4;
    public static final com.badlogic.gdx.math.Interpolation.PowIn pow4In;
    public static final com.badlogic.gdx.math.Interpolation.PowOut pow4Out;
    public static final com.badlogic.gdx.math.Interpolation.Pow pow5;
    public static final com.badlogic.gdx.math.Interpolation.PowIn pow5In;
    public static final com.badlogic.gdx.math.Interpolation.PowOut pow5Out;
    public static final com.badlogic.gdx.math.Interpolation sine;
    public static final com.badlogic.gdx.math.Interpolation sineIn;
    public static final com.badlogic.gdx.math.Interpolation sineOut;
    public static final com.badlogic.gdx.math.Interpolation smoother;
    public static final com.badlogic.gdx.math.Interpolation.Swing swing;
    public static final com.badlogic.gdx.math.Interpolation.SwingIn swingIn;
    public static final com.badlogic.gdx.math.Interpolation.SwingOut swingOut;
    public static final com.badlogic.gdx.math.Interpolation linear = new com.badlogic.gdx.math.Interpolation.AnonymousClass1();
    public static final com.badlogic.gdx.math.Interpolation smooth = new com.badlogic.gdx.math.Interpolation.AnonymousClass2();
    public static final com.badlogic.gdx.math.Interpolation smooth2 = new com.badlogic.gdx.math.Interpolation.AnonymousClass3();

    /* renamed from: com.badlogic.gdx.math.Interpolation$1, reason: invalid class name */
    public class AnonymousClass1 extends com.badlogic.gdx.math.Interpolation {
        @Override // com.badlogic.gdx.math.Interpolation
        public float apply(float f) {
            return f;
        }
    }

    /* renamed from: com.badlogic.gdx.math.Interpolation$10, reason: invalid class name */
    public class AnonymousClass10 extends com.badlogic.gdx.math.Interpolation {
        @Override // com.badlogic.gdx.math.Interpolation
        public float apply(float f) {
            return 1.0f - com.badlogic.gdx.math.MathUtils.cos((f * 3.1415927f) / 2.0f);
        }
    }

    /* renamed from: com.badlogic.gdx.math.Interpolation$11, reason: invalid class name */
    public class AnonymousClass11 extends com.badlogic.gdx.math.Interpolation {
        @Override // com.badlogic.gdx.math.Interpolation
        public float apply(float f) {
            return com.badlogic.gdx.math.MathUtils.sin((f * 3.1415927f) / 2.0f);
        }
    }

    /* renamed from: com.badlogic.gdx.math.Interpolation$12, reason: invalid class name */
    public class AnonymousClass12 extends com.badlogic.gdx.math.Interpolation {
        @Override // com.badlogic.gdx.math.Interpolation
        public float apply(float f) {
            if (f <= 0.5f) {
                float f2 = f * 2.0f;
                return (1.0f - ((float) java.lang.Math.sqrt(1.0f - (f2 * f2)))) / 2.0f;
            }
            float f3 = (f - 1.0f) * 2.0f;
            return (((float) java.lang.Math.sqrt(1.0f - (f3 * f3))) + 1.0f) / 2.0f;
        }
    }

    /* renamed from: com.badlogic.gdx.math.Interpolation$13, reason: invalid class name */
    public class AnonymousClass13 extends com.badlogic.gdx.math.Interpolation {
        @Override // com.badlogic.gdx.math.Interpolation
        public float apply(float f) {
            return 1.0f - ((float) java.lang.Math.sqrt(1.0f - (f * f)));
        }
    }

    /* renamed from: com.badlogic.gdx.math.Interpolation$14, reason: invalid class name */
    public class AnonymousClass14 extends com.badlogic.gdx.math.Interpolation {
        @Override // com.badlogic.gdx.math.Interpolation
        public float apply(float f) {
            float f2 = f - 1.0f;
            return (float) java.lang.Math.sqrt(1.0f - (f2 * f2));
        }
    }

    /* renamed from: com.badlogic.gdx.math.Interpolation$2, reason: invalid class name */
    public class AnonymousClass2 extends com.badlogic.gdx.math.Interpolation {
        @Override // com.badlogic.gdx.math.Interpolation
        public float apply(float f) {
            return f * f * (3.0f - (f * 2.0f));
        }
    }

    /* renamed from: com.badlogic.gdx.math.Interpolation$3, reason: invalid class name */
    public class AnonymousClass3 extends com.badlogic.gdx.math.Interpolation {
        @Override // com.badlogic.gdx.math.Interpolation
        public float apply(float f) {
            float f2 = f * f * (3.0f - (f * 2.0f));
            return f2 * f2 * (3.0f - (f2 * 2.0f));
        }
    }

    /* renamed from: com.badlogic.gdx.math.Interpolation$4, reason: invalid class name */
    public class AnonymousClass4 extends com.badlogic.gdx.math.Interpolation {
        @Override // com.badlogic.gdx.math.Interpolation
        public float apply(float f) {
            return com.badlogic.gdx.math.MathUtils.clamp(f * f * f * ((f * ((6.0f * f) - 15.0f)) + 10.0f), 0.0f, 1.0f);
        }
    }

    /* renamed from: com.badlogic.gdx.math.Interpolation$5, reason: invalid class name */
    public class AnonymousClass5 extends com.badlogic.gdx.math.Interpolation {
        @Override // com.badlogic.gdx.math.Interpolation
        public float apply(float f) {
            return (float) java.lang.Math.sqrt(f);
        }
    }

    /* renamed from: com.badlogic.gdx.math.Interpolation$6, reason: invalid class name */
    public class AnonymousClass6 extends com.badlogic.gdx.math.Interpolation {
        @Override // com.badlogic.gdx.math.Interpolation
        public float apply(float f) {
            return 1.0f - ((float) java.lang.Math.sqrt(-(f - 1.0f)));
        }
    }

    /* renamed from: com.badlogic.gdx.math.Interpolation$7, reason: invalid class name */
    public class AnonymousClass7 extends com.badlogic.gdx.math.Interpolation {
        @Override // com.badlogic.gdx.math.Interpolation
        public float apply(float f) {
            return (float) java.lang.Math.cbrt(f);
        }
    }

    /* renamed from: com.badlogic.gdx.math.Interpolation$8, reason: invalid class name */
    public class AnonymousClass8 extends com.badlogic.gdx.math.Interpolation {
        @Override // com.badlogic.gdx.math.Interpolation
        public float apply(float f) {
            return 1.0f - ((float) java.lang.Math.cbrt(-(f - 1.0f)));
        }
    }

    /* renamed from: com.badlogic.gdx.math.Interpolation$9, reason: invalid class name */
    public class AnonymousClass9 extends com.badlogic.gdx.math.Interpolation {
        @Override // com.badlogic.gdx.math.Interpolation
        public float apply(float f) {
            return (1.0f - com.badlogic.gdx.math.MathUtils.cos(f * 3.1415927f)) / 2.0f;
        }
    }

    public static class Bounce extends com.badlogic.gdx.math.Interpolation.BounceOut {
        public Bounce(int i) {
            super(i);
        }

        public Bounce(float[] fArr, float[] fArr2) {
            super(fArr, fArr2);
        }

        public final float a(float f) {
            float f2 = this.a[0];
            float f3 = (f2 / 2.0f) + f;
            return f3 < f2 ? (f3 / (f2 / 2.0f)) - 1.0f : super.apply(f);
        }

        @Override // com.badlogic.gdx.math.Interpolation.BounceOut, com.badlogic.gdx.math.Interpolation
        public float apply(float f) {
            return f <= 0.5f ? (1.0f - a(1.0f - (f * 2.0f))) / 2.0f : (a((f * 2.0f) - 1.0f) / 2.0f) + 0.5f;
        }
    }

    public static class BounceIn extends com.badlogic.gdx.math.Interpolation.BounceOut {
        public BounceIn(int i) {
            super(i);
        }

        public BounceIn(float[] fArr, float[] fArr2) {
            super(fArr, fArr2);
        }

        @Override // com.badlogic.gdx.math.Interpolation.BounceOut, com.badlogic.gdx.math.Interpolation
        public float apply(float f) {
            return 1.0f - super.apply(1.0f - f);
        }
    }

    public static class BounceOut extends com.badlogic.gdx.math.Interpolation {
        public final float[] a;
        public final float[] b;

        public BounceOut(int i) {
            if (i < 2 || i > 5) {
                throw new java.lang.IllegalArgumentException("bounces cannot be < 2 or > 5: " + i);
            }
            float[] fArr = new float[i];
            this.a = fArr;
            float[] fArr2 = new float[i];
            this.b = fArr2;
            fArr2[0] = 1.0f;
            if (i == 2) {
                fArr[0] = 0.6f;
                fArr[1] = 0.4f;
                fArr2[1] = 0.33f;
            } else if (i == 3) {
                fArr[0] = 0.4f;
                fArr[1] = 0.4f;
                fArr[2] = 0.2f;
                fArr2[1] = 0.33f;
                fArr2[2] = 0.1f;
            } else if (i == 4) {
                fArr[0] = 0.34f;
                fArr[1] = 0.34f;
                fArr[2] = 0.2f;
                fArr[3] = 0.15f;
                fArr2[1] = 0.26f;
                fArr2[2] = 0.11f;
                fArr2[3] = 0.03f;
            } else if (i == 5) {
                fArr[0] = 0.3f;
                fArr[1] = 0.3f;
                fArr[2] = 0.2f;
                fArr[3] = 0.1f;
                fArr[4] = 0.1f;
                fArr2[1] = 0.45f;
                fArr2[2] = 0.3f;
                fArr2[3] = 0.15f;
                fArr2[4] = 0.06f;
            }
            fArr[0] = fArr[0] * 2.0f;
        }

        public BounceOut(float[] fArr, float[] fArr2) {
            if (fArr.length != fArr2.length) {
                throw new java.lang.IllegalArgumentException("Must be the same number of widths and heights.");
            }
            this.a = fArr;
            this.b = fArr2;
        }

        @Override // com.badlogic.gdx.math.Interpolation
        public float apply(float f) {
            if (f == 1.0f) {
                return 1.0f;
            }
            float[] fArr = this.a;
            int i = 0;
            float f2 = f + (fArr[0] / 2.0f);
            int length = fArr.length;
            float f3 = 0.0f;
            float f4 = 0.0f;
            while (true) {
                if (i >= length) {
                    break;
                }
                f4 = this.a[i];
                if (f2 <= f4) {
                    f3 = this.b[i];
                    break;
                }
                f2 -= f4;
                i++;
            }
            float f5 = f2 / f4;
            float f6 = (4.0f / f4) * f3 * f5;
            return 1.0f - ((f6 - (f5 * f6)) * f4);
        }
    }

    public static class Elastic extends com.badlogic.gdx.math.Interpolation {
        public final float a;
        public final float b;
        public final float c;
        public final float d;

        public Elastic(float f, float f2, int i, float f3) {
            this.a = f;
            this.b = f2;
            this.c = f3;
            this.d = i * 3.1415927f * (i % 2 == 0 ? 1 : -1);
        }

        @Override // com.badlogic.gdx.math.Interpolation
        public float apply(float f) {
            if (f <= 0.5f) {
                return ((((float) java.lang.Math.pow(this.a, this.b * (r8 - 1.0f))) * com.badlogic.gdx.math.MathUtils.sin((f * 2.0f) * this.d)) * this.c) / 2.0f;
            }
            return 1.0f - (((((float) java.lang.Math.pow(this.a, this.b * (r8 - 1.0f))) * com.badlogic.gdx.math.MathUtils.sin(((1.0f - f) * 2.0f) * this.d)) * this.c) / 2.0f);
        }
    }

    public static class ElasticIn extends com.badlogic.gdx.math.Interpolation.Elastic {
        public ElasticIn(float f, float f2, int i, float f3) {
            super(f, f2, i, f3);
        }

        @Override // com.badlogic.gdx.math.Interpolation.Elastic, com.badlogic.gdx.math.Interpolation
        public float apply(float f) {
            if (f >= 0.99d) {
                return 1.0f;
            }
            return ((float) java.lang.Math.pow(this.a, this.b * (f - 1.0f))) * com.badlogic.gdx.math.MathUtils.sin(f * this.d) * this.c;
        }
    }

    public static class ElasticOut extends com.badlogic.gdx.math.Interpolation.Elastic {
        public ElasticOut(float f, float f2, int i, float f3) {
            super(f, f2, i, f3);
        }

        @Override // com.badlogic.gdx.math.Interpolation.Elastic, com.badlogic.gdx.math.Interpolation
        public float apply(float f) {
            if (f == 0.0f) {
                return 0.0f;
            }
            return 1.0f - ((((float) java.lang.Math.pow(this.a, this.b * (r6 - 1.0f))) * com.badlogic.gdx.math.MathUtils.sin((1.0f - f) * this.d)) * this.c);
        }
    }

    public static class Exp extends com.badlogic.gdx.math.Interpolation {
        public final float a;
        public final float b;
        public final float c;
        public final float d;

        public Exp(float f, float f2) {
            this.a = f;
            this.b = f2;
            float pow = (float) java.lang.Math.pow(f, -f2);
            this.c = pow;
            this.d = 1.0f / (1.0f - pow);
        }

        @Override // com.badlogic.gdx.math.Interpolation
        public float apply(float f) {
            return (f <= 0.5f ? (((float) java.lang.Math.pow(this.a, this.b * ((f * 2.0f) - 1.0f))) - this.c) * this.d : 2.0f - ((((float) java.lang.Math.pow(this.a, (-this.b) * ((f * 2.0f) - 1.0f))) - this.c) * this.d)) / 2.0f;
        }
    }

    public static class ExpIn extends com.badlogic.gdx.math.Interpolation.Exp {
        public ExpIn(float f, float f2) {
            super(f, f2);
        }

        @Override // com.badlogic.gdx.math.Interpolation.Exp, com.badlogic.gdx.math.Interpolation
        public float apply(float f) {
            return (((float) java.lang.Math.pow(this.a, this.b * (f - 1.0f))) - this.c) * this.d;
        }
    }

    public static class ExpOut extends com.badlogic.gdx.math.Interpolation.Exp {
        public ExpOut(float f, float f2) {
            super(f, f2);
        }

        @Override // com.badlogic.gdx.math.Interpolation.Exp, com.badlogic.gdx.math.Interpolation
        public float apply(float f) {
            return 1.0f - ((((float) java.lang.Math.pow(this.a, (-this.b) * f)) - this.c) * this.d);
        }
    }

    public static class Pow extends com.badlogic.gdx.math.Interpolation {
        public final int a;

        public Pow(int i) {
            this.a = i;
        }

        @Override // com.badlogic.gdx.math.Interpolation
        public float apply(float f) {
            if (f <= 0.5f) {
                return ((float) java.lang.Math.pow(f * 2.0f, this.a)) / 2.0f;
            }
            return (((float) java.lang.Math.pow((f - 1.0f) * 2.0f, this.a)) / (this.a % 2 == 0 ? -2 : 2)) + 1.0f;
        }
    }

    public static class PowIn extends com.badlogic.gdx.math.Interpolation.Pow {
        public PowIn(int i) {
            super(i);
        }

        @Override // com.badlogic.gdx.math.Interpolation.Pow, com.badlogic.gdx.math.Interpolation
        public float apply(float f) {
            return (float) java.lang.Math.pow(f, this.a);
        }
    }

    public static class PowOut extends com.badlogic.gdx.math.Interpolation.Pow {
        public PowOut(int i) {
            super(i);
        }

        @Override // com.badlogic.gdx.math.Interpolation.Pow, com.badlogic.gdx.math.Interpolation
        public float apply(float f) {
            return (((float) java.lang.Math.pow(f - 1.0f, this.a)) * (this.a % 2 == 0 ? -1 : 1)) + 1.0f;
        }
    }

    public static class Swing extends com.badlogic.gdx.math.Interpolation {
        public final float a;

        public Swing(float f) {
            this.a = f * 2.0f;
        }

        @Override // com.badlogic.gdx.math.Interpolation
        public float apply(float f) {
            if (f <= 0.5f) {
                float f2 = f * 2.0f;
                float f3 = this.a;
                return ((f2 * f2) * (((1.0f + f3) * f2) - f3)) / 2.0f;
            }
            float f4 = (f - 1.0f) * 2.0f;
            float f5 = this.a;
            return (((f4 * f4) * (((f5 + 1.0f) * f4) + f5)) / 2.0f) + 1.0f;
        }
    }

    public static class SwingIn extends com.badlogic.gdx.math.Interpolation {
        public final float a;

        public SwingIn(float f) {
            this.a = f;
        }

        @Override // com.badlogic.gdx.math.Interpolation
        public float apply(float f) {
            float f2 = this.a;
            return f * f * (((1.0f + f2) * f) - f2);
        }
    }

    public static class SwingOut extends com.badlogic.gdx.math.Interpolation {
        public final float a;

        public SwingOut(float f) {
            this.a = f;
        }

        @Override // com.badlogic.gdx.math.Interpolation
        public float apply(float f) {
            float f2 = f - 1.0f;
            float f3 = this.a;
            return (f2 * f2 * (((f3 + 1.0f) * f2) + f3)) + 1.0f;
        }
    }

    static {
        com.badlogic.gdx.math.Interpolation.AnonymousClass4 anonymousClass4 = new com.badlogic.gdx.math.Interpolation.AnonymousClass4();
        smoother = anonymousClass4;
        fade = anonymousClass4;
        pow2 = new com.badlogic.gdx.math.Interpolation.Pow(2);
        pow2In = new com.badlogic.gdx.math.Interpolation.PowIn(2);
        pow2Out = new com.badlogic.gdx.math.Interpolation.PowOut(2);
        pow2InInverse = new com.badlogic.gdx.math.Interpolation.AnonymousClass5();
        pow2OutInverse = new com.badlogic.gdx.math.Interpolation.AnonymousClass6();
        pow3 = new com.badlogic.gdx.math.Interpolation.Pow(3);
        pow3In = new com.badlogic.gdx.math.Interpolation.PowIn(3);
        pow3Out = new com.badlogic.gdx.math.Interpolation.PowOut(3);
        pow3InInverse = new com.badlogic.gdx.math.Interpolation.AnonymousClass7();
        pow3OutInverse = new com.badlogic.gdx.math.Interpolation.AnonymousClass8();
        pow4 = new com.badlogic.gdx.math.Interpolation.Pow(4);
        pow4In = new com.badlogic.gdx.math.Interpolation.PowIn(4);
        pow4Out = new com.badlogic.gdx.math.Interpolation.PowOut(4);
        pow5 = new com.badlogic.gdx.math.Interpolation.Pow(5);
        pow5In = new com.badlogic.gdx.math.Interpolation.PowIn(5);
        pow5Out = new com.badlogic.gdx.math.Interpolation.PowOut(5);
        sine = new com.badlogic.gdx.math.Interpolation.AnonymousClass9();
        sineIn = new com.badlogic.gdx.math.Interpolation.AnonymousClass10();
        sineOut = new com.badlogic.gdx.math.Interpolation.AnonymousClass11();
        exp10 = new com.badlogic.gdx.math.Interpolation.Exp(2.0f, 10.0f);
        exp10In = new com.badlogic.gdx.math.Interpolation.ExpIn(2.0f, 10.0f);
        exp10Out = new com.badlogic.gdx.math.Interpolation.ExpOut(2.0f, 10.0f);
        exp5 = new com.badlogic.gdx.math.Interpolation.Exp(2.0f, 5.0f);
        exp5In = new com.badlogic.gdx.math.Interpolation.ExpIn(2.0f, 5.0f);
        exp5Out = new com.badlogic.gdx.math.Interpolation.ExpOut(2.0f, 5.0f);
        circle = new com.badlogic.gdx.math.Interpolation.AnonymousClass12();
        circleIn = new com.badlogic.gdx.math.Interpolation.AnonymousClass13();
        circleOut = new com.badlogic.gdx.math.Interpolation.AnonymousClass14();
        elastic = new com.badlogic.gdx.math.Interpolation.Elastic(2.0f, 10.0f, 7, 1.0f);
        elasticIn = new com.badlogic.gdx.math.Interpolation.ElasticIn(2.0f, 10.0f, 6, 1.0f);
        elasticOut = new com.badlogic.gdx.math.Interpolation.ElasticOut(2.0f, 10.0f, 7, 1.0f);
        swing = new com.badlogic.gdx.math.Interpolation.Swing(1.5f);
        swingIn = new com.badlogic.gdx.math.Interpolation.SwingIn(2.0f);
        swingOut = new com.badlogic.gdx.math.Interpolation.SwingOut(2.0f);
        bounce = new com.badlogic.gdx.math.Interpolation.Bounce(4);
        bounceIn = new com.badlogic.gdx.math.Interpolation.BounceIn(4);
        bounceOut = new com.badlogic.gdx.math.Interpolation.BounceOut(4);
    }

    public abstract float apply(float f);

    public float apply(float f, float f2, float f3) {
        return f + ((f2 - f) * apply(f3));
    }
}
