package cn.fly.verify;

/* loaded from: classes.dex */
public class dd {
    private cn.fly.verify.dd.a a;

    public static class a {
        private java.lang.Number a;
        private java.lang.Number b;
        private java.lang.Number c;
        private java.lang.Number d;
        private boolean e;

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r13v22, types: [java.lang.Number] */
        /* JADX WARN: Type inference failed for: r13v29 */
        /* JADX WARN: Type inference failed for: r13v30 */
        /* JADX WARN: Type inference failed for: r13v31 */
        /* JADX WARN: Type inference failed for: r13v32 */
        /* JADX WARN: Type inference failed for: r13v33 */
        /* JADX WARN: Type inference failed for: r13v34 */
        /* JADX WARN: Type inference failed for: r13v35 */
        /* JADX WARN: Type inference failed for: r13v36 */
        public a(java.lang.Number number, java.lang.Number number2, java.lang.Number number3) {
            java.lang.Number[] numberArr = {number, number2, number3};
            int[] iArr = {0, 0, 0};
            for (int i = 0; i < 3; i++) {
                java.lang.Number number4 = numberArr[i];
                if (number4 != null) {
                    if (number4 instanceof java.lang.Byte) {
                        iArr[i] = 1;
                    } else if (number4 instanceof java.lang.Short) {
                        iArr[i] = 2;
                    } else if (number4 instanceof java.lang.Integer) {
                        iArr[i] = 3;
                    } else if (number4 instanceof java.lang.Long) {
                        iArr[i] = 4;
                    } else if (number4 instanceof java.lang.Float) {
                        iArr[i] = 5;
                    } else if (number4 instanceof java.lang.Double) {
                        iArr[i] = 6;
                    }
                }
            }
            int i2 = 0;
            for (int i3 = 0; i3 < 3; i3++) {
                int i4 = iArr[i3];
                if (i2 < i4) {
                    i2 = i4;
                }
            }
            ?? r13 = number;
            if (number != null) {
                switch (i2) {
                    case 1:
                        r13 = java.lang.Byte.valueOf(java.lang.Double.valueOf(java.lang.String.valueOf(number)).byteValue());
                        break;
                    case 2:
                        r13 = java.lang.Short.valueOf(java.lang.Double.valueOf(java.lang.String.valueOf(number)).shortValue());
                        break;
                    case 3:
                        r13 = java.lang.Integer.valueOf(java.lang.Double.valueOf(java.lang.String.valueOf(number)).intValue());
                        break;
                    case 4:
                        r13 = java.lang.Long.valueOf(java.lang.Double.valueOf(java.lang.String.valueOf(number)).longValue());
                        break;
                    case 5:
                        r13 = java.lang.Float.valueOf(java.lang.Double.valueOf(java.lang.String.valueOf(number)).floatValue());
                        break;
                    case 6:
                        r13 = java.lang.Double.valueOf(java.lang.String.valueOf(number));
                        break;
                }
            } else {
                r13 = new java.lang.Number[]{Integer.MIN_VALUE, Byte.MIN_VALUE, java.lang.Short.valueOf(kotlin.jvm.internal.ShortCompanionObject.MIN_VALUE), Integer.MIN_VALUE, Long.MIN_VALUE, java.lang.Float.valueOf(Float.MIN_VALUE), java.lang.Double.valueOf(Double.MIN_VALUE)}[i2];
            }
            if (number2 != null) {
                switch (i2) {
                    case 1:
                        number2 = java.lang.Byte.valueOf(java.lang.Double.valueOf(java.lang.String.valueOf(number2)).byteValue());
                        break;
                    case 2:
                        number2 = java.lang.Short.valueOf(java.lang.Double.valueOf(java.lang.String.valueOf(number2)).shortValue());
                        break;
                    case 3:
                        number2 = java.lang.Integer.valueOf(java.lang.Double.valueOf(java.lang.String.valueOf(number2)).intValue());
                        break;
                    case 4:
                        number2 = java.lang.Long.valueOf(java.lang.Double.valueOf(java.lang.String.valueOf(number2)).longValue());
                        break;
                    case 5:
                        number2 = java.lang.Float.valueOf(java.lang.Double.valueOf(java.lang.String.valueOf(number2)).floatValue());
                        break;
                    case 6:
                        number2 = java.lang.Double.valueOf(java.lang.String.valueOf(number2));
                        break;
                }
            } else {
                number2 = new java.lang.Number[]{Integer.MAX_VALUE, Byte.MAX_VALUE, java.lang.Short.valueOf(kotlin.jvm.internal.ShortCompanionObject.MAX_VALUE), Integer.MAX_VALUE, Long.MAX_VALUE, java.lang.Float.valueOf(Float.MAX_VALUE), java.lang.Double.valueOf(Double.MAX_VALUE)}[i2];
            }
            this.a = r13;
            this.b = number2;
            this.c = number3;
            boolean z = ((java.lang.Comparable) r13).compareTo(number2) > 0;
            this.e = z;
            if (this.c == null) {
                this.c = java.lang.Integer.valueOf(z ? -1 : 1);
            }
        }

        public boolean a() {
            java.lang.Object obj = this.d;
            if (obj == null) {
                obj = this.a;
            }
            java.lang.Comparable comparable = (java.lang.Comparable) obj;
            return this.e ? comparable.compareTo(this.b) >= 0 : comparable.compareTo(this.b) <= 0;
        }

        public java.lang.Number b() {
            int byteValue;
            int byteValue2;
            java.lang.Number valueOf;
            if (this.d == null) {
                this.d = this.a;
            }
            java.lang.Number number = this.d;
            java.lang.Number number2 = this.c;
            if (number2 instanceof java.lang.Double) {
                valueOf = java.lang.Double.valueOf(number.doubleValue() + this.c.doubleValue());
            } else if (number2 instanceof java.lang.Float) {
                valueOf = java.lang.Float.valueOf(number.floatValue() + this.c.floatValue());
            } else if (number2 instanceof java.lang.Long) {
                valueOf = java.lang.Long.valueOf(number.longValue() + this.c.longValue());
            } else {
                if (number2 instanceof java.lang.Integer) {
                    byteValue = number.intValue();
                    byteValue2 = this.c.intValue();
                } else if (number2 instanceof java.lang.Short) {
                    byteValue = number.shortValue();
                    byteValue2 = this.c.shortValue();
                } else {
                    byteValue = number.byteValue();
                    byteValue2 = this.c.byteValue();
                }
                valueOf = java.lang.Integer.valueOf(byteValue + byteValue2);
            }
            this.d = valueOf;
            return number;
        }
    }

    public dd(java.lang.Number number, java.lang.Number number2, java.lang.Number number3) {
        this.a = new cn.fly.verify.dd.a(number, number2, number3);
    }

    public cn.fly.verify.dd.a a() {
        return this.a;
    }

    public boolean a(java.lang.Number number) {
        return ((java.lang.Comparable) this.a.a).compareTo(number) <= 0 && ((java.lang.Comparable) this.a.b).compareTo(number) >= 0;
    }

    public boolean b(java.lang.Number number) {
        return a(number);
    }

    public java.lang.Number[] b() {
        return new java.lang.Number[]{this.a.a, this.a.b};
    }
}
