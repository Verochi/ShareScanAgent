package com.airbnb.lottie.parser;

/* loaded from: classes.dex */
class JsonUtils {
    public static final com.airbnb.lottie.parser.moshi.JsonReader.Options a = com.airbnb.lottie.parser.moshi.JsonReader.Options.of("x", "y");

    /* renamed from: com.airbnb.lottie.parser.JsonUtils$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[com.airbnb.lottie.parser.moshi.JsonReader.Token.values().length];
            a = iArr;
            try {
                iArr[com.airbnb.lottie.parser.moshi.JsonReader.Token.NUMBER.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                a[com.airbnb.lottie.parser.moshi.JsonReader.Token.BEGIN_ARRAY.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                a[com.airbnb.lottie.parser.moshi.JsonReader.Token.BEGIN_OBJECT.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
        }
    }

    public static android.graphics.PointF a(com.airbnb.lottie.parser.moshi.JsonReader jsonReader, float f) throws java.io.IOException {
        jsonReader.beginArray();
        float nextDouble = (float) jsonReader.nextDouble();
        float nextDouble2 = (float) jsonReader.nextDouble();
        while (jsonReader.peek() != com.airbnb.lottie.parser.moshi.JsonReader.Token.END_ARRAY) {
            jsonReader.skipValue();
        }
        jsonReader.endArray();
        return new android.graphics.PointF(nextDouble * f, nextDouble2 * f);
    }

    public static android.graphics.PointF b(com.airbnb.lottie.parser.moshi.JsonReader jsonReader, float f) throws java.io.IOException {
        float nextDouble = (float) jsonReader.nextDouble();
        float nextDouble2 = (float) jsonReader.nextDouble();
        while (jsonReader.hasNext()) {
            jsonReader.skipValue();
        }
        return new android.graphics.PointF(nextDouble * f, nextDouble2 * f);
    }

    public static android.graphics.PointF c(com.airbnb.lottie.parser.moshi.JsonReader jsonReader, float f) throws java.io.IOException {
        jsonReader.beginObject();
        float f2 = 0.0f;
        float f3 = 0.0f;
        while (jsonReader.hasNext()) {
            int selectName = jsonReader.selectName(a);
            if (selectName == 0) {
                f2 = g(jsonReader);
            } else if (selectName != 1) {
                jsonReader.skipName();
                jsonReader.skipValue();
            } else {
                f3 = g(jsonReader);
            }
        }
        jsonReader.endObject();
        return new android.graphics.PointF(f2 * f, f3 * f);
    }

    @androidx.annotation.ColorInt
    public static int d(com.airbnb.lottie.parser.moshi.JsonReader jsonReader) throws java.io.IOException {
        jsonReader.beginArray();
        int nextDouble = (int) (jsonReader.nextDouble() * 255.0d);
        int nextDouble2 = (int) (jsonReader.nextDouble() * 255.0d);
        int nextDouble3 = (int) (jsonReader.nextDouble() * 255.0d);
        while (jsonReader.hasNext()) {
            jsonReader.skipValue();
        }
        jsonReader.endArray();
        return android.graphics.Color.argb(255, nextDouble, nextDouble2, nextDouble3);
    }

    public static android.graphics.PointF e(com.airbnb.lottie.parser.moshi.JsonReader jsonReader, float f) throws java.io.IOException {
        int i = com.airbnb.lottie.parser.JsonUtils.AnonymousClass1.a[jsonReader.peek().ordinal()];
        if (i == 1) {
            return b(jsonReader, f);
        }
        if (i == 2) {
            return a(jsonReader, f);
        }
        if (i == 3) {
            return c(jsonReader, f);
        }
        throw new java.lang.IllegalArgumentException("Unknown point starts with " + jsonReader.peek());
    }

    public static java.util.List<android.graphics.PointF> f(com.airbnb.lottie.parser.moshi.JsonReader jsonReader, float f) throws java.io.IOException {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        jsonReader.beginArray();
        while (jsonReader.peek() == com.airbnb.lottie.parser.moshi.JsonReader.Token.BEGIN_ARRAY) {
            jsonReader.beginArray();
            arrayList.add(e(jsonReader, f));
            jsonReader.endArray();
        }
        jsonReader.endArray();
        return arrayList;
    }

    public static float g(com.airbnb.lottie.parser.moshi.JsonReader jsonReader) throws java.io.IOException {
        com.airbnb.lottie.parser.moshi.JsonReader.Token peek = jsonReader.peek();
        int i = com.airbnb.lottie.parser.JsonUtils.AnonymousClass1.a[peek.ordinal()];
        if (i == 1) {
            return (float) jsonReader.nextDouble();
        }
        if (i != 2) {
            throw new java.lang.IllegalArgumentException("Unknown value for token of type " + peek);
        }
        jsonReader.beginArray();
        float nextDouble = (float) jsonReader.nextDouble();
        while (jsonReader.hasNext()) {
            jsonReader.skipValue();
        }
        jsonReader.endArray();
        return nextDouble;
    }
}
