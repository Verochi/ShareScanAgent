package com.google.common.math;

@com.google.common.annotations.Beta
@com.google.common.annotations.GwtIncompatible
/* loaded from: classes22.dex */
public abstract class LinearTransformation {

    public static final class LinearTransformationBuilder {
        public final double a;
        public final double b;

        public LinearTransformationBuilder(double d, double d2) {
            this.a = d;
            this.b = d2;
        }

        public /* synthetic */ LinearTransformationBuilder(double d, double d2, com.google.common.math.LinearTransformation.AnonymousClass1 anonymousClass1) {
            this(d, d2);
        }

        public com.google.common.math.LinearTransformation and(double d, double d2) {
            com.google.common.base.Preconditions.checkArgument(com.google.common.math.DoubleUtils.d(d) && com.google.common.math.DoubleUtils.d(d2));
            double d3 = this.a;
            if (d != d3) {
                return withSlope((d2 - this.b) / (d - d3));
            }
            com.google.common.base.Preconditions.checkArgument(d2 != this.b);
            return new com.google.common.math.LinearTransformation.VerticalLinearTransformation(this.a);
        }

        public com.google.common.math.LinearTransformation withSlope(double d) {
            com.google.common.base.Preconditions.checkArgument(!java.lang.Double.isNaN(d));
            return com.google.common.math.DoubleUtils.d(d) ? new com.google.common.math.LinearTransformation.RegularLinearTransformation(d, this.b - (this.a * d)) : new com.google.common.math.LinearTransformation.VerticalLinearTransformation(this.a);
        }
    }

    public static final class NaNLinearTransformation extends com.google.common.math.LinearTransformation {
        public static final com.google.common.math.LinearTransformation.NaNLinearTransformation a = new com.google.common.math.LinearTransformation.NaNLinearTransformation();

        @Override // com.google.common.math.LinearTransformation
        public com.google.common.math.LinearTransformation inverse() {
            return this;
        }

        @Override // com.google.common.math.LinearTransformation
        public boolean isHorizontal() {
            return false;
        }

        @Override // com.google.common.math.LinearTransformation
        public boolean isVertical() {
            return false;
        }

        @Override // com.google.common.math.LinearTransformation
        public double slope() {
            return Double.NaN;
        }

        public java.lang.String toString() {
            return "NaN";
        }

        @Override // com.google.common.math.LinearTransformation
        public double transform(double d) {
            return Double.NaN;
        }
    }

    public static final class RegularLinearTransformation extends com.google.common.math.LinearTransformation {
        public final double a;
        public final double b;

        @com.google.errorprone.annotations.concurrent.LazyInit
        public com.google.common.math.LinearTransformation c;

        public RegularLinearTransformation(double d, double d2) {
            this.a = d;
            this.b = d2;
            this.c = null;
        }

        public RegularLinearTransformation(double d, double d2, com.google.common.math.LinearTransformation linearTransformation) {
            this.a = d;
            this.b = d2;
            this.c = linearTransformation;
        }

        public final com.google.common.math.LinearTransformation a() {
            double d = this.a;
            return d != 0.0d ? new com.google.common.math.LinearTransformation.RegularLinearTransformation(1.0d / d, (this.b * (-1.0d)) / d, this) : new com.google.common.math.LinearTransformation.VerticalLinearTransformation(this.b, this);
        }

        @Override // com.google.common.math.LinearTransformation
        public com.google.common.math.LinearTransformation inverse() {
            com.google.common.math.LinearTransformation linearTransformation = this.c;
            if (linearTransformation != null) {
                return linearTransformation;
            }
            com.google.common.math.LinearTransformation a = a();
            this.c = a;
            return a;
        }

        @Override // com.google.common.math.LinearTransformation
        public boolean isHorizontal() {
            return this.a == 0.0d;
        }

        @Override // com.google.common.math.LinearTransformation
        public boolean isVertical() {
            return false;
        }

        @Override // com.google.common.math.LinearTransformation
        public double slope() {
            return this.a;
        }

        public java.lang.String toString() {
            return java.lang.String.format("y = %g * x + %g", java.lang.Double.valueOf(this.a), java.lang.Double.valueOf(this.b));
        }

        @Override // com.google.common.math.LinearTransformation
        public double transform(double d) {
            return (d * this.a) + this.b;
        }
    }

    public static final class VerticalLinearTransformation extends com.google.common.math.LinearTransformation {
        public final double a;

        @com.google.errorprone.annotations.concurrent.LazyInit
        public com.google.common.math.LinearTransformation b;

        public VerticalLinearTransformation(double d) {
            this.a = d;
            this.b = null;
        }

        public VerticalLinearTransformation(double d, com.google.common.math.LinearTransformation linearTransformation) {
            this.a = d;
            this.b = linearTransformation;
        }

        public final com.google.common.math.LinearTransformation a() {
            return new com.google.common.math.LinearTransformation.RegularLinearTransformation(0.0d, this.a, this);
        }

        @Override // com.google.common.math.LinearTransformation
        public com.google.common.math.LinearTransformation inverse() {
            com.google.common.math.LinearTransformation linearTransformation = this.b;
            if (linearTransformation != null) {
                return linearTransformation;
            }
            com.google.common.math.LinearTransformation a = a();
            this.b = a;
            return a;
        }

        @Override // com.google.common.math.LinearTransformation
        public boolean isHorizontal() {
            return false;
        }

        @Override // com.google.common.math.LinearTransformation
        public boolean isVertical() {
            return true;
        }

        @Override // com.google.common.math.LinearTransformation
        public double slope() {
            throw new java.lang.IllegalStateException();
        }

        public java.lang.String toString() {
            return java.lang.String.format("x = %g", java.lang.Double.valueOf(this.a));
        }

        @Override // com.google.common.math.LinearTransformation
        public double transform(double d) {
            throw new java.lang.IllegalStateException();
        }
    }

    public static com.google.common.math.LinearTransformation forNaN() {
        return com.google.common.math.LinearTransformation.NaNLinearTransformation.a;
    }

    public static com.google.common.math.LinearTransformation horizontal(double d) {
        com.google.common.base.Preconditions.checkArgument(com.google.common.math.DoubleUtils.d(d));
        return new com.google.common.math.LinearTransformation.RegularLinearTransformation(0.0d, d);
    }

    public static com.google.common.math.LinearTransformation.LinearTransformationBuilder mapping(double d, double d2) {
        com.google.common.base.Preconditions.checkArgument(com.google.common.math.DoubleUtils.d(d) && com.google.common.math.DoubleUtils.d(d2));
        return new com.google.common.math.LinearTransformation.LinearTransformationBuilder(d, d2, null);
    }

    public static com.google.common.math.LinearTransformation vertical(double d) {
        com.google.common.base.Preconditions.checkArgument(com.google.common.math.DoubleUtils.d(d));
        return new com.google.common.math.LinearTransformation.VerticalLinearTransformation(d);
    }

    public abstract com.google.common.math.LinearTransformation inverse();

    public abstract boolean isHorizontal();

    public abstract boolean isVertical();

    public abstract double slope();

    public abstract double transform(double d);
}
