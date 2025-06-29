package androidx.core.graphics;

/* loaded from: classes.dex */
public class PathParser {
    private static final java.lang.String LOGTAG = "PathParser";

    public static class ExtractFloatResult {
        int mEndPosition;
        boolean mEndWithNegOrDot;
    }

    public static class PathDataNode {
        public float[] mParams;
        public char mType;

        public PathDataNode(char c, float[] fArr) {
            this.mType = c;
            this.mParams = fArr;
        }

        public PathDataNode(androidx.core.graphics.PathParser.PathDataNode pathDataNode) {
            this.mType = pathDataNode.mType;
            float[] fArr = pathDataNode.mParams;
            this.mParams = androidx.core.graphics.PathParser.copyOfRange(fArr, 0, fArr.length);
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        private static void addCommand(android.graphics.Path path, float[] fArr, char c, char c2, float[] fArr2) {
            int i;
            int i2;
            float f;
            float f2;
            float f3;
            float f4;
            float f5;
            float f6;
            float f7;
            float f8;
            char c3 = c2;
            float f9 = fArr[0];
            float f10 = fArr[1];
            float f11 = fArr[2];
            float f12 = fArr[3];
            float f13 = fArr[4];
            float f14 = fArr[5];
            switch (c3) {
                case 'A':
                case 'a':
                    i = 7;
                    break;
                case 'C':
                case 'c':
                    i = 6;
                    break;
                case 'H':
                case 'V':
                case 'h':
                case 'v':
                    i = 1;
                    break;
                case 'L':
                case 'M':
                case 'T':
                case 'l':
                case 'm':
                case 't':
                default:
                    i = 2;
                    break;
                case 'Q':
                case 'S':
                case 'q':
                case 's':
                    i = 4;
                    break;
                case 'Z':
                case 'z':
                    path.close();
                    path.moveTo(f13, f14);
                    f9 = f13;
                    f11 = f9;
                    f10 = f14;
                    f12 = f10;
                    i = 2;
                    break;
            }
            float f15 = f9;
            float f16 = f10;
            float f17 = f13;
            float f18 = f14;
            int i3 = 0;
            char c4 = c;
            while (i3 < fArr2.length) {
                if (c3 != 'A') {
                    if (c3 == 'C') {
                        i2 = i3;
                        int i4 = i2 + 2;
                        int i5 = i2 + 3;
                        int i6 = i2 + 4;
                        int i7 = i2 + 5;
                        path.cubicTo(fArr2[i2 + 0], fArr2[i2 + 1], fArr2[i4], fArr2[i5], fArr2[i6], fArr2[i7]);
                        f15 = fArr2[i6];
                        float f19 = fArr2[i7];
                        float f20 = fArr2[i4];
                        float f21 = fArr2[i5];
                        f16 = f19;
                        f12 = f21;
                        f11 = f20;
                    } else if (c3 == 'H') {
                        i2 = i3;
                        int i8 = i2 + 0;
                        path.lineTo(fArr2[i8], f16);
                        f15 = fArr2[i8];
                    } else if (c3 == 'Q') {
                        i2 = i3;
                        int i9 = i2 + 0;
                        int i10 = i2 + 1;
                        int i11 = i2 + 2;
                        int i12 = i2 + 3;
                        path.quadTo(fArr2[i9], fArr2[i10], fArr2[i11], fArr2[i12]);
                        float f22 = fArr2[i9];
                        float f23 = fArr2[i10];
                        f15 = fArr2[i11];
                        f16 = fArr2[i12];
                        f11 = f22;
                        f12 = f23;
                    } else if (c3 == 'V') {
                        i2 = i3;
                        int i13 = i2 + 0;
                        path.lineTo(f15, fArr2[i13]);
                        f16 = fArr2[i13];
                    } else if (c3 != 'a') {
                        if (c3 != 'c') {
                            if (c3 == 'h') {
                                int i14 = i3 + 0;
                                path.rLineTo(fArr2[i14], 0.0f);
                                f15 += fArr2[i14];
                            } else if (c3 != 'q') {
                                if (c3 == 'v') {
                                    int i15 = i3 + 0;
                                    path.rLineTo(0.0f, fArr2[i15]);
                                    f4 = fArr2[i15];
                                } else if (c3 == 'L') {
                                    int i16 = i3 + 0;
                                    int i17 = i3 + 1;
                                    path.lineTo(fArr2[i16], fArr2[i17]);
                                    f15 = fArr2[i16];
                                    f16 = fArr2[i17];
                                } else if (c3 == 'M') {
                                    f15 = fArr2[i3 + 0];
                                    f16 = fArr2[i3 + 1];
                                    if (i3 > 0) {
                                        path.lineTo(f15, f16);
                                    } else {
                                        path.moveTo(f15, f16);
                                        i2 = i3;
                                        f18 = f16;
                                        f17 = f15;
                                    }
                                } else if (c3 == 'S') {
                                    if (c4 == 'c' || c4 == 's' || c4 == 'C' || c4 == 'S') {
                                        f15 = (f15 * 2.0f) - f11;
                                        f16 = (f16 * 2.0f) - f12;
                                    }
                                    float f24 = f16;
                                    int i18 = i3 + 0;
                                    int i19 = i3 + 1;
                                    int i20 = i3 + 2;
                                    int i21 = i3 + 3;
                                    path.cubicTo(f15, f24, fArr2[i18], fArr2[i19], fArr2[i20], fArr2[i21]);
                                    f = fArr2[i18];
                                    f2 = fArr2[i19];
                                    f15 = fArr2[i20];
                                    f16 = fArr2[i21];
                                    f11 = f;
                                    f12 = f2;
                                } else if (c3 == 'T') {
                                    if (c4 == 'q' || c4 == 't' || c4 == 'Q' || c4 == 'T') {
                                        f15 = (f15 * 2.0f) - f11;
                                        f16 = (f16 * 2.0f) - f12;
                                    }
                                    int i22 = i3 + 0;
                                    int i23 = i3 + 1;
                                    path.quadTo(f15, f16, fArr2[i22], fArr2[i23]);
                                    float f25 = fArr2[i22];
                                    float f26 = fArr2[i23];
                                    i2 = i3;
                                    f12 = f16;
                                    f11 = f15;
                                    f15 = f25;
                                    f16 = f26;
                                } else if (c3 == 'l') {
                                    int i24 = i3 + 0;
                                    int i25 = i3 + 1;
                                    path.rLineTo(fArr2[i24], fArr2[i25]);
                                    f15 += fArr2[i24];
                                    f4 = fArr2[i25];
                                } else if (c3 == 'm') {
                                    float f27 = fArr2[i3 + 0];
                                    f15 += f27;
                                    float f28 = fArr2[i3 + 1];
                                    f16 += f28;
                                    if (i3 > 0) {
                                        path.rLineTo(f27, f28);
                                    } else {
                                        path.rMoveTo(f27, f28);
                                        i2 = i3;
                                        f18 = f16;
                                        f17 = f15;
                                    }
                                } else if (c3 == 's') {
                                    if (c4 == 'c' || c4 == 's' || c4 == 'C' || c4 == 'S') {
                                        float f29 = f15 - f11;
                                        f5 = f16 - f12;
                                        f6 = f29;
                                    } else {
                                        f6 = 0.0f;
                                        f5 = 0.0f;
                                    }
                                    int i26 = i3 + 0;
                                    int i27 = i3 + 1;
                                    int i28 = i3 + 2;
                                    int i29 = i3 + 3;
                                    path.rCubicTo(f6, f5, fArr2[i26], fArr2[i27], fArr2[i28], fArr2[i29]);
                                    f = fArr2[i26] + f15;
                                    f2 = fArr2[i27] + f16;
                                    f15 += fArr2[i28];
                                    f3 = fArr2[i29];
                                } else if (c3 == 't') {
                                    if (c4 == 'q' || c4 == 't' || c4 == 'Q' || c4 == 'T') {
                                        f7 = f15 - f11;
                                        f8 = f16 - f12;
                                    } else {
                                        f8 = 0.0f;
                                        f7 = 0.0f;
                                    }
                                    int i30 = i3 + 0;
                                    int i31 = i3 + 1;
                                    path.rQuadTo(f7, f8, fArr2[i30], fArr2[i31]);
                                    float f30 = f7 + f15;
                                    float f31 = f8 + f16;
                                    f15 += fArr2[i30];
                                    f16 += fArr2[i31];
                                    f12 = f31;
                                    f11 = f30;
                                }
                                f16 += f4;
                            } else {
                                int i32 = i3 + 0;
                                int i33 = i3 + 1;
                                int i34 = i3 + 2;
                                int i35 = i3 + 3;
                                path.rQuadTo(fArr2[i32], fArr2[i33], fArr2[i34], fArr2[i35]);
                                f = fArr2[i32] + f15;
                                f2 = fArr2[i33] + f16;
                                f15 += fArr2[i34];
                                f3 = fArr2[i35];
                            }
                            i2 = i3;
                        } else {
                            int i36 = i3 + 2;
                            int i37 = i3 + 3;
                            int i38 = i3 + 4;
                            int i39 = i3 + 5;
                            path.rCubicTo(fArr2[i3 + 0], fArr2[i3 + 1], fArr2[i36], fArr2[i37], fArr2[i38], fArr2[i39]);
                            f = fArr2[i36] + f15;
                            f2 = fArr2[i37] + f16;
                            f15 += fArr2[i38];
                            f3 = fArr2[i39];
                        }
                        f16 += f3;
                        f11 = f;
                        f12 = f2;
                        i2 = i3;
                    } else {
                        int i40 = i3 + 5;
                        int i41 = i3 + 6;
                        i2 = i3;
                        drawArc(path, f15, f16, fArr2[i40] + f15, fArr2[i41] + f16, fArr2[i3 + 0], fArr2[i3 + 1], fArr2[i3 + 2], fArr2[i3 + 3] != 0.0f, fArr2[i3 + 4] != 0.0f);
                        f15 += fArr2[i40];
                        f16 += fArr2[i41];
                    }
                    i3 = i2 + i;
                    c4 = c2;
                    c3 = c4;
                } else {
                    i2 = i3;
                    int i42 = i2 + 5;
                    int i43 = i2 + 6;
                    drawArc(path, f15, f16, fArr2[i42], fArr2[i43], fArr2[i2 + 0], fArr2[i2 + 1], fArr2[i2 + 2], fArr2[i2 + 3] != 0.0f, fArr2[i2 + 4] != 0.0f);
                    f15 = fArr2[i42];
                    f16 = fArr2[i43];
                }
                f12 = f16;
                f11 = f15;
                i3 = i2 + i;
                c4 = c2;
                c3 = c4;
            }
            fArr[0] = f15;
            fArr[1] = f16;
            fArr[2] = f11;
            fArr[3] = f12;
            fArr[4] = f17;
            fArr[5] = f18;
        }

        private static void arcToBezier(android.graphics.Path path, double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9) {
            double d10 = d3;
            int ceil = (int) java.lang.Math.ceil(java.lang.Math.abs((d9 * 4.0d) / 3.141592653589793d));
            double cos = java.lang.Math.cos(d7);
            double sin = java.lang.Math.sin(d7);
            double cos2 = java.lang.Math.cos(d8);
            double sin2 = java.lang.Math.sin(d8);
            double d11 = -d10;
            double d12 = d11 * cos;
            double d13 = d4 * sin;
            double d14 = (d12 * sin2) - (d13 * cos2);
            double d15 = d11 * sin;
            double d16 = d4 * cos;
            double d17 = (sin2 * d15) + (cos2 * d16);
            double d18 = d9 / ceil;
            double d19 = d8;
            double d20 = d17;
            double d21 = d14;
            int i = 0;
            double d22 = d5;
            double d23 = d6;
            while (i < ceil) {
                double d24 = d19 + d18;
                double sin3 = java.lang.Math.sin(d24);
                double cos3 = java.lang.Math.cos(d24);
                double d25 = (d + ((d10 * cos) * cos3)) - (d13 * sin3);
                double d26 = d2 + (d10 * sin * cos3) + (d16 * sin3);
                double d27 = (d12 * sin3) - (d13 * cos3);
                double d28 = (sin3 * d15) + (cos3 * d16);
                double d29 = d24 - d19;
                double tan = java.lang.Math.tan(d29 / 2.0d);
                double sin4 = (java.lang.Math.sin(d29) * (java.lang.Math.sqrt(((tan * 3.0d) * tan) + 4.0d) - 1.0d)) / 3.0d;
                double d30 = d22 + (d21 * sin4);
                path.rLineTo(0.0f, 0.0f);
                path.cubicTo((float) d30, (float) (d23 + (d20 * sin4)), (float) (d25 - (sin4 * d27)), (float) (d26 - (sin4 * d28)), (float) d25, (float) d26);
                i++;
                d18 = d18;
                sin = sin;
                d22 = d25;
                d15 = d15;
                cos = cos;
                d19 = d24;
                d20 = d28;
                d21 = d27;
                ceil = ceil;
                d23 = d26;
                d10 = d3;
            }
        }

        private static void drawArc(android.graphics.Path path, float f, float f2, float f3, float f4, float f5, float f6, float f7, boolean z, boolean z2) {
            double d;
            double d2;
            double radians = java.lang.Math.toRadians(f7);
            double cos = java.lang.Math.cos(radians);
            double sin = java.lang.Math.sin(radians);
            double d3 = f;
            double d4 = d3 * cos;
            double d5 = f2;
            double d6 = f5;
            double d7 = (d4 + (d5 * sin)) / d6;
            double d8 = ((-f) * sin) + (d5 * cos);
            double d9 = f6;
            double d10 = d8 / d9;
            double d11 = f4;
            double d12 = ((f3 * cos) + (d11 * sin)) / d6;
            double d13 = (((-f3) * sin) + (d11 * cos)) / d9;
            double d14 = d7 - d12;
            double d15 = d10 - d13;
            double d16 = (d7 + d12) / 2.0d;
            double d17 = (d10 + d13) / 2.0d;
            double d18 = (d14 * d14) + (d15 * d15);
            if (d18 == 0.0d) {
                return;
            }
            double d19 = (1.0d / d18) - 0.25d;
            if (d19 < 0.0d) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append("Points are too far apart ");
                sb.append(d18);
                float sqrt = (float) (java.lang.Math.sqrt(d18) / 1.99999d);
                drawArc(path, f, f2, f3, f4, f5 * sqrt, f6 * sqrt, f7, z, z2);
                return;
            }
            double sqrt2 = java.lang.Math.sqrt(d19);
            double d20 = d14 * sqrt2;
            double d21 = sqrt2 * d15;
            if (z == z2) {
                d = d16 - d21;
                d2 = d17 + d20;
            } else {
                d = d16 + d21;
                d2 = d17 - d20;
            }
            double atan2 = java.lang.Math.atan2(d10 - d2, d7 - d);
            double atan22 = java.lang.Math.atan2(d13 - d2, d12 - d) - atan2;
            if (z2 != (atan22 >= 0.0d)) {
                atan22 = atan22 > 0.0d ? atan22 - 6.283185307179586d : atan22 + 6.283185307179586d;
            }
            double d22 = d * d6;
            double d23 = d2 * d9;
            arcToBezier(path, (d22 * cos) - (d23 * sin), (d22 * sin) + (d23 * cos), d6, d9, d3, d5, radians, atan2, atan22);
        }

        public static void nodesToPath(androidx.core.graphics.PathParser.PathDataNode[] pathDataNodeArr, android.graphics.Path path) {
            float[] fArr = new float[6];
            char c = 'm';
            for (int i = 0; i < pathDataNodeArr.length; i++) {
                androidx.core.graphics.PathParser.PathDataNode pathDataNode = pathDataNodeArr[i];
                addCommand(path, fArr, c, pathDataNode.mType, pathDataNode.mParams);
                c = pathDataNodeArr[i].mType;
            }
        }

        public void interpolatePathDataNode(androidx.core.graphics.PathParser.PathDataNode pathDataNode, androidx.core.graphics.PathParser.PathDataNode pathDataNode2, float f) {
            this.mType = pathDataNode.mType;
            int i = 0;
            while (true) {
                float[] fArr = pathDataNode.mParams;
                if (i >= fArr.length) {
                    return;
                }
                this.mParams[i] = (fArr[i] * (1.0f - f)) + (pathDataNode2.mParams[i] * f);
                i++;
            }
        }
    }

    private PathParser() {
    }

    private static void addNode(java.util.ArrayList<androidx.core.graphics.PathParser.PathDataNode> arrayList, char c, float[] fArr) {
        arrayList.add(new androidx.core.graphics.PathParser.PathDataNode(c, fArr));
    }

    public static boolean canMorph(@androidx.annotation.Nullable androidx.core.graphics.PathParser.PathDataNode[] pathDataNodeArr, @androidx.annotation.Nullable androidx.core.graphics.PathParser.PathDataNode[] pathDataNodeArr2) {
        if (pathDataNodeArr == null || pathDataNodeArr2 == null || pathDataNodeArr.length != pathDataNodeArr2.length) {
            return false;
        }
        for (int i = 0; i < pathDataNodeArr.length; i++) {
            androidx.core.graphics.PathParser.PathDataNode pathDataNode = pathDataNodeArr[i];
            char c = pathDataNode.mType;
            androidx.core.graphics.PathParser.PathDataNode pathDataNode2 = pathDataNodeArr2[i];
            if (c != pathDataNode2.mType || pathDataNode.mParams.length != pathDataNode2.mParams.length) {
                return false;
            }
        }
        return true;
    }

    public static float[] copyOfRange(float[] fArr, int i, int i2) {
        if (i > i2) {
            throw new java.lang.IllegalArgumentException();
        }
        int length = fArr.length;
        if (i < 0 || i > length) {
            throw new java.lang.ArrayIndexOutOfBoundsException();
        }
        int i3 = i2 - i;
        int min = java.lang.Math.min(i3, length - i);
        float[] fArr2 = new float[i3];
        java.lang.System.arraycopy(fArr, i, fArr2, 0, min);
        return fArr2;
    }

    public static androidx.core.graphics.PathParser.PathDataNode[] createNodesFromPathData(java.lang.String str) {
        if (str == null) {
            return null;
        }
        java.util.ArrayList arrayList = new java.util.ArrayList();
        int i = 1;
        int i2 = 0;
        while (i < str.length()) {
            int nextStart = nextStart(str, i);
            java.lang.String trim = str.substring(i2, nextStart).trim();
            if (trim.length() > 0) {
                addNode(arrayList, trim.charAt(0), getFloats(trim));
            }
            i2 = nextStart;
            i = nextStart + 1;
        }
        if (i - i2 == 1 && i2 < str.length()) {
            addNode(arrayList, str.charAt(i2), new float[0]);
        }
        return (androidx.core.graphics.PathParser.PathDataNode[]) arrayList.toArray(new androidx.core.graphics.PathParser.PathDataNode[arrayList.size()]);
    }

    public static android.graphics.Path createPathFromPathData(java.lang.String str) {
        android.graphics.Path path = new android.graphics.Path();
        androidx.core.graphics.PathParser.PathDataNode[] createNodesFromPathData = createNodesFromPathData(str);
        if (createNodesFromPathData == null) {
            return null;
        }
        try {
            androidx.core.graphics.PathParser.PathDataNode.nodesToPath(createNodesFromPathData, path);
            return path;
        } catch (java.lang.RuntimeException e) {
            throw new java.lang.RuntimeException("Error in parsing " + str, e);
        }
    }

    public static androidx.core.graphics.PathParser.PathDataNode[] deepCopyNodes(androidx.core.graphics.PathParser.PathDataNode[] pathDataNodeArr) {
        if (pathDataNodeArr == null) {
            return null;
        }
        androidx.core.graphics.PathParser.PathDataNode[] pathDataNodeArr2 = new androidx.core.graphics.PathParser.PathDataNode[pathDataNodeArr.length];
        for (int i = 0; i < pathDataNodeArr.length; i++) {
            pathDataNodeArr2[i] = new androidx.core.graphics.PathParser.PathDataNode(pathDataNodeArr[i]);
        }
        return pathDataNodeArr2;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003a A[LOOP:0: B:2:0x0007->B:14:0x003a, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x003d A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void extract(java.lang.String str, int i, androidx.core.graphics.PathParser.ExtractFloatResult extractFloatResult) {
        extractFloatResult.mEndWithNegOrDot = false;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        for (int i2 = i; i2 < str.length(); i2++) {
            char charAt = str.charAt(i2);
            if (charAt != ' ') {
                if (charAt != 'E' && charAt != 'e') {
                    switch (charAt) {
                        case ',':
                            break;
                        case '-':
                            if (i2 != i && !z) {
                                extractFloatResult.mEndWithNegOrDot = true;
                                break;
                            }
                            z = false;
                            break;
                        case '.':
                            if (z2) {
                                extractFloatResult.mEndWithNegOrDot = true;
                                break;
                            } else {
                                z = false;
                                z2 = true;
                                break;
                            }
                        default:
                            z = false;
                            break;
                    }
                } else {
                    z = true;
                }
                if (!z3) {
                    extractFloatResult.mEndPosition = i2;
                }
            }
            z = false;
            z3 = true;
            if (!z3) {
            }
        }
        extractFloatResult.mEndPosition = i2;
    }

    private static float[] getFloats(java.lang.String str) {
        if (str.charAt(0) == 'z' || str.charAt(0) == 'Z') {
            return new float[0];
        }
        try {
            float[] fArr = new float[str.length()];
            androidx.core.graphics.PathParser.ExtractFloatResult extractFloatResult = new androidx.core.graphics.PathParser.ExtractFloatResult();
            int length = str.length();
            int i = 1;
            int i2 = 0;
            while (i < length) {
                extract(str, i, extractFloatResult);
                int i3 = extractFloatResult.mEndPosition;
                if (i < i3) {
                    fArr[i2] = java.lang.Float.parseFloat(str.substring(i, i3));
                    i2++;
                }
                i = extractFloatResult.mEndWithNegOrDot ? i3 : i3 + 1;
            }
            return copyOfRange(fArr, 0, i2);
        } catch (java.lang.NumberFormatException e) {
            throw new java.lang.RuntimeException("error in parsing \"" + str + "\"", e);
        }
    }

    public static boolean interpolatePathDataNodes(androidx.core.graphics.PathParser.PathDataNode[] pathDataNodeArr, androidx.core.graphics.PathParser.PathDataNode[] pathDataNodeArr2, androidx.core.graphics.PathParser.PathDataNode[] pathDataNodeArr3, float f) {
        if (pathDataNodeArr == null || pathDataNodeArr2 == null || pathDataNodeArr3 == null) {
            throw new java.lang.IllegalArgumentException("The nodes to be interpolated and resulting nodes cannot be null");
        }
        if (pathDataNodeArr.length != pathDataNodeArr2.length || pathDataNodeArr2.length != pathDataNodeArr3.length) {
            throw new java.lang.IllegalArgumentException("The nodes to be interpolated and resulting nodes must have the same length");
        }
        if (!canMorph(pathDataNodeArr2, pathDataNodeArr3)) {
            return false;
        }
        for (int i = 0; i < pathDataNodeArr.length; i++) {
            pathDataNodeArr[i].interpolatePathDataNode(pathDataNodeArr2[i], pathDataNodeArr3[i], f);
        }
        return true;
    }

    private static int nextStart(java.lang.String str, int i) {
        while (i < str.length()) {
            char charAt = str.charAt(i);
            if (((charAt - 'A') * (charAt - 'Z') <= 0 || (charAt - 'a') * (charAt - 'z') <= 0) && charAt != 'e' && charAt != 'E') {
                return i;
            }
            i++;
        }
        return i;
    }

    public static void updateNodes(androidx.core.graphics.PathParser.PathDataNode[] pathDataNodeArr, androidx.core.graphics.PathParser.PathDataNode[] pathDataNodeArr2) {
        for (int i = 0; i < pathDataNodeArr2.length; i++) {
            pathDataNodeArr[i].mType = pathDataNodeArr2[i].mType;
            int i2 = 0;
            while (true) {
                float[] fArr = pathDataNodeArr2[i].mParams;
                if (i2 < fArr.length) {
                    pathDataNodeArr[i].mParams[i2] = fArr[i2];
                    i2++;
                }
            }
        }
    }
}
