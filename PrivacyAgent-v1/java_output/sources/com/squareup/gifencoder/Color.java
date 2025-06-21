package com.squareup.gifencoder;

/* loaded from: classes19.dex */
public final class Color {
    public final double a;
    public final double b;
    public final double c;
    public static final com.squareup.gifencoder.Color BLACK = new com.squareup.gifencoder.Color(0.0d, 0.0d, 0.0d);
    public static final com.squareup.gifencoder.Color WHITE = new com.squareup.gifencoder.Color(1.0d, 1.0d, 1.0d);
    public static final com.squareup.gifencoder.Color RED = new com.squareup.gifencoder.Color(1.0d, 0.0d, 0.0d);
    public static final com.squareup.gifencoder.Color GREEN = new com.squareup.gifencoder.Color(0.0d, 1.0d, 0.0d);
    public static final com.squareup.gifencoder.Color BLUE = new com.squareup.gifencoder.Color(0.0d, 0.0d, 1.0d);

    public Color(double d, double d2, double d3) {
        this.a = d;
        this.b = d2;
        this.c = d3;
    }

    public static com.squareup.gifencoder.Color fromRgbInt(int i) {
        return new com.squareup.gifencoder.Color(((i >>> 16) & 255) / 255.0d, ((i >>> 8) & 255) / 255.0d, (i & 255) / 255.0d);
    }

    public static com.squareup.gifencoder.Color getCentroid(com.squareup.gifencoder.Multiset<com.squareup.gifencoder.Color> multiset) {
        com.squareup.gifencoder.Color color = BLACK;
        java.util.Iterator<com.squareup.gifencoder.Color> it = multiset.getDistinctElements().iterator();
        while (it.hasNext()) {
            color = color.plus(it.next().scaled(multiset.count(r2)));
        }
        return color.scaled(1.0d / multiset.size());
    }

    public boolean equals(java.lang.Object obj) {
        if (!(obj instanceof com.squareup.gifencoder.Color)) {
            return false;
        }
        com.squareup.gifencoder.Color color = (com.squareup.gifencoder.Color) obj;
        return this.a == color.a && this.b == color.b && this.c == color.c;
    }

    public double getComponent(int i) {
        if (i == 0) {
            return this.a;
        }
        if (i == 1) {
            return this.b;
        }
        if (i == 2) {
            return this.c;
        }
        throw new java.lang.IllegalArgumentException("Unexpected component index: " + i);
    }

    public double getEuclideanDistanceTo(com.squareup.gifencoder.Color color) {
        com.squareup.gifencoder.Color minus = minus(color);
        double d = minus.a;
        double d2 = minus.b;
        double d3 = (d * d) + (d2 * d2);
        double d4 = minus.c;
        return java.lang.Math.sqrt(d3 + (d4 * d4));
    }

    public com.squareup.gifencoder.Color getNearestColor(java.util.Collection<com.squareup.gifencoder.Color> collection) {
        com.squareup.gifencoder.Color color = null;
        double d = Double.POSITIVE_INFINITY;
        for (com.squareup.gifencoder.Color color2 : collection) {
            double euclideanDistanceTo = getEuclideanDistanceTo(color2);
            if (euclideanDistanceTo < d) {
                color = color2;
                d = euclideanDistanceTo;
            }
        }
        return color;
    }

    public int getRgbInt() {
        return (((int) (this.a * 255.0d)) << 16) | (((int) (this.b * 255.0d)) << 8) | ((int) (this.c * 255.0d));
    }

    public int hashCode() {
        long doubleToLongBits = java.lang.Double.doubleToLongBits(this.a);
        long doubleToLongBits2 = java.lang.Double.doubleToLongBits(this.b);
        int i = (((int) (doubleToLongBits ^ (doubleToLongBits >>> 32))) * 31) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)));
        long doubleToLongBits3 = java.lang.Double.doubleToLongBits(this.c);
        return (i * 31) + ((int) (doubleToLongBits3 ^ (doubleToLongBits3 >>> 32)));
    }

    public com.squareup.gifencoder.Color minus(com.squareup.gifencoder.Color color) {
        return new com.squareup.gifencoder.Color(this.a - color.a, this.b - color.b, this.c - color.c);
    }

    public com.squareup.gifencoder.Color plus(com.squareup.gifencoder.Color color) {
        return new com.squareup.gifencoder.Color(this.a + color.a, this.b + color.b, this.c + color.c);
    }

    public com.squareup.gifencoder.Color scaled(double d) {
        return new com.squareup.gifencoder.Color(d * this.a, this.b * d, this.c * d);
    }

    public java.lang.String toString() {
        return java.lang.String.format("Color[%f, %f, %f]", java.lang.Double.valueOf(this.a), java.lang.Double.valueOf(this.b), java.lang.Double.valueOf(this.c));
    }
}
