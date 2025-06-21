package com.airbnb.lottie.parser;

/* loaded from: classes.dex */
class KeyframeParser {
    public static androidx.collection.SparseArrayCompat<java.lang.ref.WeakReference<android.view.animation.Interpolator>> b;
    public static final android.view.animation.Interpolator a = new android.view.animation.LinearInterpolator();
    public static com.airbnb.lottie.parser.moshi.JsonReader.Options c = com.airbnb.lottie.parser.moshi.JsonReader.Options.of("t", "s", "e", "o", "i", "h", com.huawei.hms.push.constant.RemoteMessageConst.TO, "ti");
    public static com.airbnb.lottie.parser.moshi.JsonReader.Options d = com.airbnb.lottie.parser.moshi.JsonReader.Options.of("x", "y");

    @androidx.annotation.Nullable
    public static java.lang.ref.WeakReference<android.view.animation.Interpolator> a(int i) {
        java.lang.ref.WeakReference<android.view.animation.Interpolator> weakReference;
        synchronized (com.airbnb.lottie.parser.KeyframeParser.class) {
            weakReference = g().get(i);
        }
        return weakReference;
    }

    public static android.view.animation.Interpolator b(android.graphics.PointF pointF, android.graphics.PointF pointF2) {
        android.view.animation.Interpolator create;
        pointF.x = com.airbnb.lottie.utils.MiscUtils.clamp(pointF.x, -1.0f, 1.0f);
        pointF.y = com.airbnb.lottie.utils.MiscUtils.clamp(pointF.y, -100.0f, 100.0f);
        pointF2.x = com.airbnb.lottie.utils.MiscUtils.clamp(pointF2.x, -1.0f, 1.0f);
        float clamp = com.airbnb.lottie.utils.MiscUtils.clamp(pointF2.y, -100.0f, 100.0f);
        pointF2.y = clamp;
        int hashFor = com.airbnb.lottie.utils.Utils.hashFor(pointF.x, pointF.y, pointF2.x, clamp);
        java.lang.ref.WeakReference<android.view.animation.Interpolator> a2 = a(hashFor);
        android.view.animation.Interpolator interpolator = a2 != null ? a2.get() : null;
        if (a2 == null || interpolator == null) {
            try {
                create = androidx.core.view.animation.PathInterpolatorCompat.create(pointF.x, pointF.y, pointF2.x, pointF2.y);
            } catch (java.lang.IllegalArgumentException e) {
                create = "The Path cannot loop back on itself.".equals(e.getMessage()) ? androidx.core.view.animation.PathInterpolatorCompat.create(java.lang.Math.min(pointF.x, 1.0f), pointF.y, java.lang.Math.max(pointF2.x, 0.0f), pointF2.y) : new android.view.animation.LinearInterpolator();
            }
            interpolator = create;
            try {
                h(hashFor, new java.lang.ref.WeakReference(interpolator));
            } catch (java.lang.ArrayIndexOutOfBoundsException unused) {
            }
        }
        return interpolator;
    }

    public static <T> com.airbnb.lottie.value.Keyframe<T> c(com.airbnb.lottie.parser.moshi.JsonReader jsonReader, com.airbnb.lottie.LottieComposition lottieComposition, float f, com.airbnb.lottie.parser.ValueParser<T> valueParser, boolean z, boolean z2) throws java.io.IOException {
        return (z && z2) ? e(lottieComposition, jsonReader, f, valueParser) : z ? d(lottieComposition, jsonReader, f, valueParser) : f(jsonReader, f, valueParser);
    }

    public static <T> com.airbnb.lottie.value.Keyframe<T> d(com.airbnb.lottie.LottieComposition lottieComposition, com.airbnb.lottie.parser.moshi.JsonReader jsonReader, float f, com.airbnb.lottie.parser.ValueParser<T> valueParser) throws java.io.IOException {
        android.view.animation.Interpolator b2;
        T t;
        jsonReader.beginObject();
        android.graphics.PointF pointF = null;
        android.graphics.PointF pointF2 = null;
        T t2 = null;
        T t3 = null;
        android.graphics.PointF pointF3 = null;
        android.graphics.PointF pointF4 = null;
        boolean z = false;
        float f2 = 0.0f;
        while (jsonReader.hasNext()) {
            switch (jsonReader.selectName(c)) {
                case 0:
                    f2 = (float) jsonReader.nextDouble();
                    break;
                case 1:
                    t3 = valueParser.parse(jsonReader, f);
                    break;
                case 2:
                    t2 = valueParser.parse(jsonReader, f);
                    break;
                case 3:
                    pointF = com.airbnb.lottie.parser.JsonUtils.e(jsonReader, 1.0f);
                    break;
                case 4:
                    pointF2 = com.airbnb.lottie.parser.JsonUtils.e(jsonReader, 1.0f);
                    break;
                case 5:
                    if (jsonReader.nextInt() != 1) {
                        z = false;
                        break;
                    } else {
                        z = true;
                        break;
                    }
                case 6:
                    pointF3 = com.airbnb.lottie.parser.JsonUtils.e(jsonReader, f);
                    break;
                case 7:
                    pointF4 = com.airbnb.lottie.parser.JsonUtils.e(jsonReader, f);
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        if (z) {
            b2 = a;
            t = t3;
        } else {
            b2 = (pointF == null || pointF2 == null) ? a : b(pointF, pointF2);
            t = t2;
        }
        com.airbnb.lottie.value.Keyframe<T> keyframe = new com.airbnb.lottie.value.Keyframe<>(lottieComposition, t3, t, b2, f2, null);
        keyframe.pathCp1 = pointF3;
        keyframe.pathCp2 = pointF4;
        return keyframe;
    }

    public static <T> com.airbnb.lottie.value.Keyframe<T> e(com.airbnb.lottie.LottieComposition lottieComposition, com.airbnb.lottie.parser.moshi.JsonReader jsonReader, float f, com.airbnb.lottie.parser.ValueParser<T> valueParser) throws java.io.IOException {
        android.view.animation.Interpolator interpolator;
        android.view.animation.Interpolator b2;
        android.view.animation.Interpolator b3;
        T t;
        android.graphics.PointF pointF;
        com.airbnb.lottie.value.Keyframe<T> keyframe;
        android.graphics.PointF pointF2;
        float f2;
        android.graphics.PointF pointF3;
        float f3;
        jsonReader.beginObject();
        android.graphics.PointF pointF4 = null;
        boolean z = false;
        android.graphics.PointF pointF5 = null;
        android.graphics.PointF pointF6 = null;
        android.graphics.PointF pointF7 = null;
        T t2 = null;
        android.graphics.PointF pointF8 = null;
        android.graphics.PointF pointF9 = null;
        android.graphics.PointF pointF10 = null;
        float f4 = 0.0f;
        android.graphics.PointF pointF11 = null;
        T t3 = null;
        while (jsonReader.hasNext()) {
            switch (jsonReader.selectName(c)) {
                case 0:
                    pointF2 = pointF4;
                    f4 = (float) jsonReader.nextDouble();
                    pointF4 = pointF2;
                    break;
                case 1:
                    pointF2 = pointF4;
                    t2 = valueParser.parse(jsonReader, f);
                    pointF4 = pointF2;
                    break;
                case 2:
                    pointF2 = pointF4;
                    t3 = valueParser.parse(jsonReader, f);
                    pointF4 = pointF2;
                    break;
                case 3:
                    pointF2 = pointF4;
                    f2 = f4;
                    android.graphics.PointF pointF12 = pointF11;
                    if (jsonReader.peek() == com.airbnb.lottie.parser.moshi.JsonReader.Token.BEGIN_OBJECT) {
                        jsonReader.beginObject();
                        float f5 = 0.0f;
                        float f6 = 0.0f;
                        float f7 = 0.0f;
                        float f8 = 0.0f;
                        while (jsonReader.hasNext()) {
                            int selectName = jsonReader.selectName(d);
                            if (selectName != 0) {
                                if (selectName != 1) {
                                    jsonReader.skipValue();
                                } else if (jsonReader.peek() == com.airbnb.lottie.parser.moshi.JsonReader.Token.NUMBER) {
                                    f8 = (float) jsonReader.nextDouble();
                                    f6 = f8;
                                } else {
                                    jsonReader.beginArray();
                                    f6 = (float) jsonReader.nextDouble();
                                    f8 = (float) jsonReader.nextDouble();
                                    jsonReader.endArray();
                                }
                            } else if (jsonReader.peek() == com.airbnb.lottie.parser.moshi.JsonReader.Token.NUMBER) {
                                f7 = (float) jsonReader.nextDouble();
                                f5 = f7;
                            } else {
                                jsonReader.beginArray();
                                f5 = (float) jsonReader.nextDouble();
                                f7 = (float) jsonReader.nextDouble();
                                jsonReader.endArray();
                            }
                        }
                        android.graphics.PointF pointF13 = new android.graphics.PointF(f5, f6);
                        android.graphics.PointF pointF14 = new android.graphics.PointF(f7, f8);
                        jsonReader.endObject();
                        pointF8 = pointF14;
                        pointF7 = pointF13;
                        pointF11 = pointF12;
                        f4 = f2;
                        pointF4 = pointF2;
                        break;
                    } else {
                        pointF5 = com.airbnb.lottie.parser.JsonUtils.e(jsonReader, f);
                        f4 = f2;
                        pointF11 = pointF12;
                        pointF4 = pointF2;
                    }
                case 4:
                    if (jsonReader.peek() == com.airbnb.lottie.parser.moshi.JsonReader.Token.BEGIN_OBJECT) {
                        jsonReader.beginObject();
                        float f9 = 0.0f;
                        float f10 = 0.0f;
                        float f11 = 0.0f;
                        float f12 = 0.0f;
                        while (jsonReader.hasNext()) {
                            android.graphics.PointF pointF15 = pointF11;
                            int selectName2 = jsonReader.selectName(d);
                            if (selectName2 != 0) {
                                pointF3 = pointF4;
                                if (selectName2 != 1) {
                                    jsonReader.skipValue();
                                } else if (jsonReader.peek() == com.airbnb.lottie.parser.moshi.JsonReader.Token.NUMBER) {
                                    f12 = (float) jsonReader.nextDouble();
                                    f4 = f4;
                                    f10 = f12;
                                } else {
                                    f3 = f4;
                                    jsonReader.beginArray();
                                    f10 = (float) jsonReader.nextDouble();
                                    f12 = (float) jsonReader.nextDouble();
                                    jsonReader.endArray();
                                    f4 = f3;
                                }
                            } else {
                                pointF3 = pointF4;
                                f3 = f4;
                                if (jsonReader.peek() == com.airbnb.lottie.parser.moshi.JsonReader.Token.NUMBER) {
                                    f11 = (float) jsonReader.nextDouble();
                                    f4 = f3;
                                    f9 = f11;
                                } else {
                                    jsonReader.beginArray();
                                    f9 = (float) jsonReader.nextDouble();
                                    f11 = (float) jsonReader.nextDouble();
                                    jsonReader.endArray();
                                    f4 = f3;
                                }
                            }
                            pointF11 = pointF15;
                            pointF4 = pointF3;
                        }
                        pointF2 = pointF4;
                        f2 = f4;
                        android.graphics.PointF pointF16 = new android.graphics.PointF(f9, f10);
                        android.graphics.PointF pointF17 = new android.graphics.PointF(f11, f12);
                        jsonReader.endObject();
                        pointF10 = pointF17;
                        pointF9 = pointF16;
                        f4 = f2;
                        pointF4 = pointF2;
                        break;
                    } else {
                        pointF2 = pointF4;
                        pointF6 = com.airbnb.lottie.parser.JsonUtils.e(jsonReader, f);
                        pointF4 = pointF2;
                    }
                case 5:
                    if (jsonReader.nextInt() != 1) {
                        z = false;
                        break;
                    } else {
                        z = true;
                        break;
                    }
                case 6:
                    pointF11 = com.airbnb.lottie.parser.JsonUtils.e(jsonReader, f);
                    break;
                case 7:
                    pointF4 = com.airbnb.lottie.parser.JsonUtils.e(jsonReader, f);
                    break;
                default:
                    pointF2 = pointF4;
                    jsonReader.skipValue();
                    pointF4 = pointF2;
                    break;
            }
        }
        android.graphics.PointF pointF18 = pointF4;
        float f13 = f4;
        android.graphics.PointF pointF19 = pointF11;
        jsonReader.endObject();
        if (z) {
            interpolator = a;
            t = t2;
        } else {
            if (pointF5 != null && pointF6 != null) {
                interpolator = b(pointF5, pointF6);
            } else {
                if (pointF7 != null && pointF8 != null && pointF9 != null && pointF10 != null) {
                    b2 = b(pointF7, pointF9);
                    b3 = b(pointF8, pointF10);
                    t = t3;
                    interpolator = null;
                    if (b2 != null || b3 == null) {
                        pointF = pointF19;
                        keyframe = new com.airbnb.lottie.value.Keyframe<>(lottieComposition, t2, t, interpolator, f13, null);
                    } else {
                        pointF = pointF19;
                        keyframe = new com.airbnb.lottie.value.Keyframe<>(lottieComposition, t2, t, b2, b3, f13, null);
                    }
                    keyframe.pathCp1 = pointF;
                    keyframe.pathCp2 = pointF18;
                    return keyframe;
                }
                interpolator = a;
            }
            t = t3;
        }
        b2 = null;
        b3 = null;
        if (b2 != null) {
        }
        pointF = pointF19;
        keyframe = new com.airbnb.lottie.value.Keyframe<>(lottieComposition, t2, t, interpolator, f13, null);
        keyframe.pathCp1 = pointF;
        keyframe.pathCp2 = pointF18;
        return keyframe;
    }

    public static <T> com.airbnb.lottie.value.Keyframe<T> f(com.airbnb.lottie.parser.moshi.JsonReader jsonReader, float f, com.airbnb.lottie.parser.ValueParser<T> valueParser) throws java.io.IOException {
        return new com.airbnb.lottie.value.Keyframe<>(valueParser.parse(jsonReader, f));
    }

    public static androidx.collection.SparseArrayCompat<java.lang.ref.WeakReference<android.view.animation.Interpolator>> g() {
        if (b == null) {
            b = new androidx.collection.SparseArrayCompat<>();
        }
        return b;
    }

    public static void h(int i, java.lang.ref.WeakReference<android.view.animation.Interpolator> weakReference) {
        synchronized (com.airbnb.lottie.parser.KeyframeParser.class) {
            b.put(i, weakReference);
        }
    }
}
