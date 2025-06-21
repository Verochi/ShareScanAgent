package com.airbnb.lottie.model.layer;

/* loaded from: classes.dex */
public class TextLayer extends com.airbnb.lottie.model.layer.BaseLayer {
    public final android.graphics.RectF A;
    public final android.graphics.Matrix B;
    public final android.graphics.Paint C;
    public final android.graphics.Paint D;
    public final java.util.Map<com.airbnb.lottie.model.FontCharacter, java.util.List<com.airbnb.lottie.animation.content.ContentGroup>> E;
    public final androidx.collection.LongSparseArray<java.lang.String> F;
    public final com.airbnb.lottie.animation.keyframe.TextKeyframeAnimation G;
    public final com.airbnb.lottie.LottieDrawable H;
    public final com.airbnb.lottie.LottieComposition I;

    @androidx.annotation.Nullable
    public com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<java.lang.Integer, java.lang.Integer> J;

    @androidx.annotation.Nullable
    public com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<java.lang.Integer, java.lang.Integer> K;

    @androidx.annotation.Nullable
    public com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<java.lang.Integer, java.lang.Integer> L;

    @androidx.annotation.Nullable
    public com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<java.lang.Integer, java.lang.Integer> M;

    @androidx.annotation.Nullable
    public com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<java.lang.Float, java.lang.Float> N;

    @androidx.annotation.Nullable
    public com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<java.lang.Float, java.lang.Float> O;

    @androidx.annotation.Nullable
    public com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<java.lang.Float, java.lang.Float> P;

    @androidx.annotation.Nullable
    public com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<java.lang.Float, java.lang.Float> Q;

    @androidx.annotation.Nullable
    public com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<java.lang.Float, java.lang.Float> R;

    @androidx.annotation.Nullable
    public com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<java.lang.Float, java.lang.Float> S;
    public final java.lang.StringBuilder z;

    /* renamed from: com.airbnb.lottie.model.layer.TextLayer$1, reason: invalid class name */
    public class AnonymousClass1 extends android.graphics.Paint {
        public AnonymousClass1(int i) {
            super(i);
            setStyle(android.graphics.Paint.Style.FILL);
        }
    }

    /* renamed from: com.airbnb.lottie.model.layer.TextLayer$2, reason: invalid class name */
    public class AnonymousClass2 extends android.graphics.Paint {
        public AnonymousClass2(int i) {
            super(i);
            setStyle(android.graphics.Paint.Style.STROKE);
        }
    }

    /* renamed from: com.airbnb.lottie.model.layer.TextLayer$3, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass3 {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[com.airbnb.lottie.model.DocumentData.Justification.values().length];
            a = iArr;
            try {
                iArr[com.airbnb.lottie.model.DocumentData.Justification.LEFT_ALIGN.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                a[com.airbnb.lottie.model.DocumentData.Justification.RIGHT_ALIGN.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                a[com.airbnb.lottie.model.DocumentData.Justification.CENTER.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
        }
    }

    public TextLayer(com.airbnb.lottie.LottieDrawable lottieDrawable, com.airbnb.lottie.model.layer.Layer layer) {
        super(lottieDrawable, layer);
        com.airbnb.lottie.model.animatable.AnimatableFloatValue animatableFloatValue;
        com.airbnb.lottie.model.animatable.AnimatableFloatValue animatableFloatValue2;
        com.airbnb.lottie.model.animatable.AnimatableColorValue animatableColorValue;
        com.airbnb.lottie.model.animatable.AnimatableColorValue animatableColorValue2;
        this.z = new java.lang.StringBuilder(2);
        this.A = new android.graphics.RectF();
        this.B = new android.graphics.Matrix();
        this.C = new com.airbnb.lottie.model.layer.TextLayer.AnonymousClass1(1);
        this.D = new com.airbnb.lottie.model.layer.TextLayer.AnonymousClass2(1);
        this.E = new java.util.HashMap();
        this.F = new androidx.collection.LongSparseArray<>();
        this.H = lottieDrawable;
        this.I = layer.a();
        com.airbnb.lottie.animation.keyframe.TextKeyframeAnimation createAnimation = layer.o().createAnimation();
        this.G = createAnimation;
        createAnimation.addUpdateListener(this);
        addAnimation(createAnimation);
        com.airbnb.lottie.model.animatable.AnimatableTextProperties p = layer.p();
        if (p != null && (animatableColorValue2 = p.color) != null) {
            com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<java.lang.Integer, java.lang.Integer> createAnimation2 = animatableColorValue2.createAnimation();
            this.J = createAnimation2;
            createAnimation2.addUpdateListener(this);
            addAnimation(this.J);
        }
        if (p != null && (animatableColorValue = p.stroke) != null) {
            com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<java.lang.Integer, java.lang.Integer> createAnimation3 = animatableColorValue.createAnimation();
            this.L = createAnimation3;
            createAnimation3.addUpdateListener(this);
            addAnimation(this.L);
        }
        if (p != null && (animatableFloatValue2 = p.strokeWidth) != null) {
            com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<java.lang.Float, java.lang.Float> createAnimation4 = animatableFloatValue2.createAnimation();
            this.N = createAnimation4;
            createAnimation4.addUpdateListener(this);
            addAnimation(this.N);
        }
        if (p == null || (animatableFloatValue = p.tracking) == null) {
            return;
        }
        com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<java.lang.Float, java.lang.Float> createAnimation5 = animatableFloatValue.createAnimation();
        this.P = createAnimation5;
        createAnimation5.addUpdateListener(this);
        addAnimation(this.P);
    }

    public final void A(java.lang.String str, android.graphics.Paint paint, android.graphics.Canvas canvas) {
        if (paint.getColor() == 0) {
            return;
        }
        if (paint.getStyle() == android.graphics.Paint.Style.STROKE && paint.getStrokeWidth() == 0.0f) {
            return;
        }
        canvas.drawText(str, 0, str.length(), 0.0f, 0.0f, paint);
    }

    public final void B(com.airbnb.lottie.model.FontCharacter fontCharacter, android.graphics.Matrix matrix, float f, com.airbnb.lottie.model.DocumentData documentData, android.graphics.Canvas canvas) {
        java.util.List<com.airbnb.lottie.animation.content.ContentGroup> I = I(fontCharacter);
        for (int i = 0; i < I.size(); i++) {
            android.graphics.Path path = I.get(i).getPath();
            path.computeBounds(this.A, false);
            this.B.set(matrix);
            this.B.preTranslate(0.0f, (-documentData.baselineShift) * com.airbnb.lottie.utils.Utils.dpScale());
            this.B.preScale(f, f);
            path.transform(this.B);
            if (documentData.strokeOverFill) {
                E(path, this.C, canvas);
                E(path, this.D, canvas);
            } else {
                E(path, this.D, canvas);
                E(path, this.C, canvas);
            }
        }
    }

    public final void C(java.lang.String str, com.airbnb.lottie.model.DocumentData documentData, android.graphics.Canvas canvas) {
        if (documentData.strokeOverFill) {
            A(str, this.C, canvas);
            A(str, this.D, canvas);
        } else {
            A(str, this.D, canvas);
            A(str, this.C, canvas);
        }
    }

    public final void D(java.lang.String str, com.airbnb.lottie.model.DocumentData documentData, android.graphics.Canvas canvas, float f) {
        int i = 0;
        while (i < str.length()) {
            java.lang.String z = z(str, i);
            i += z.length();
            C(z, documentData, canvas);
            canvas.translate(this.C.measureText(z) + f, 0.0f);
        }
    }

    public final void E(android.graphics.Path path, android.graphics.Paint paint, android.graphics.Canvas canvas) {
        if (paint.getColor() == 0) {
            return;
        }
        if (paint.getStyle() == android.graphics.Paint.Style.STROKE && paint.getStrokeWidth() == 0.0f) {
            return;
        }
        canvas.drawPath(path, paint);
    }

    public final void F(java.lang.String str, com.airbnb.lottie.model.DocumentData documentData, android.graphics.Matrix matrix, com.airbnb.lottie.model.Font font, android.graphics.Canvas canvas, float f, float f2) {
        float floatValue;
        for (int i = 0; i < str.length(); i++) {
            com.airbnb.lottie.model.FontCharacter fontCharacter = this.I.getCharacters().get(com.airbnb.lottie.model.FontCharacter.hashFor(str.charAt(i), font.getFamily(), font.getStyle()));
            if (fontCharacter != null) {
                B(fontCharacter, matrix, f2, documentData, canvas);
                float width = ((float) fontCharacter.getWidth()) * f2 * com.airbnb.lottie.utils.Utils.dpScale() * f;
                float f3 = documentData.tracking / 10.0f;
                com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<java.lang.Float, java.lang.Float> baseKeyframeAnimation = this.Q;
                if (baseKeyframeAnimation != null) {
                    floatValue = baseKeyframeAnimation.getValue().floatValue();
                } else {
                    com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<java.lang.Float, java.lang.Float> baseKeyframeAnimation2 = this.P;
                    if (baseKeyframeAnimation2 != null) {
                        floatValue = baseKeyframeAnimation2.getValue().floatValue();
                    }
                    canvas.translate(width + (f3 * f), 0.0f);
                }
                f3 += floatValue;
                canvas.translate(width + (f3 * f), 0.0f);
            }
        }
    }

    public final void G(com.airbnb.lottie.model.DocumentData documentData, android.graphics.Matrix matrix, com.airbnb.lottie.model.Font font, android.graphics.Canvas canvas) {
        float floatValue;
        com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<java.lang.Float, java.lang.Float> baseKeyframeAnimation = this.S;
        if (baseKeyframeAnimation != null) {
            floatValue = baseKeyframeAnimation.getValue().floatValue();
        } else {
            com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<java.lang.Float, java.lang.Float> baseKeyframeAnimation2 = this.R;
            floatValue = baseKeyframeAnimation2 != null ? baseKeyframeAnimation2.getValue().floatValue() : documentData.size;
        }
        float f = floatValue / 100.0f;
        float scale = com.airbnb.lottie.utils.Utils.getScale(matrix);
        java.lang.String str = documentData.text;
        float dpScale = documentData.lineHeight * com.airbnb.lottie.utils.Utils.dpScale();
        java.util.List<java.lang.String> K = K(str);
        int size = K.size();
        for (int i = 0; i < size; i++) {
            java.lang.String str2 = K.get(i);
            float J = J(str2, font, f, scale);
            canvas.save();
            y(documentData.justification, canvas, J);
            canvas.translate(0.0f, (i * dpScale) - (((size - 1) * dpScale) / 2.0f));
            F(str2, documentData, matrix, font, canvas, scale, f);
            canvas.restore();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x00ab A[LOOP:0: B:16:0x00a9->B:17:0x00ab, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void H(com.airbnb.lottie.model.DocumentData documentData, com.airbnb.lottie.model.Font font, android.graphics.Matrix matrix, android.graphics.Canvas canvas) {
        float floatValue;
        float floatValue2;
        int size;
        int i;
        com.airbnb.lottie.utils.Utils.getScale(matrix);
        android.graphics.Typeface typeface = this.H.getTypeface(font.getFamily(), font.getStyle());
        if (typeface == null) {
            return;
        }
        java.lang.String str = documentData.text;
        com.airbnb.lottie.TextDelegate textDelegate = this.H.getTextDelegate();
        if (textDelegate != null) {
            str = textDelegate.getTextInternal(str);
        }
        this.C.setTypeface(typeface);
        com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<java.lang.Float, java.lang.Float> baseKeyframeAnimation = this.S;
        if (baseKeyframeAnimation != null) {
            floatValue = baseKeyframeAnimation.getValue().floatValue();
        } else {
            com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<java.lang.Float, java.lang.Float> baseKeyframeAnimation2 = this.R;
            floatValue = baseKeyframeAnimation2 != null ? baseKeyframeAnimation2.getValue().floatValue() : documentData.size;
        }
        this.C.setTextSize(com.airbnb.lottie.utils.Utils.dpScale() * floatValue);
        this.D.setTypeface(this.C.getTypeface());
        this.D.setTextSize(this.C.getTextSize());
        float dpScale = documentData.lineHeight * com.airbnb.lottie.utils.Utils.dpScale();
        float f = documentData.tracking / 10.0f;
        com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<java.lang.Float, java.lang.Float> baseKeyframeAnimation3 = this.Q;
        if (baseKeyframeAnimation3 == null) {
            com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<java.lang.Float, java.lang.Float> baseKeyframeAnimation4 = this.P;
            if (baseKeyframeAnimation4 != null) {
                floatValue2 = baseKeyframeAnimation4.getValue().floatValue();
            }
            float dpScale2 = ((f * com.airbnb.lottie.utils.Utils.dpScale()) * floatValue) / 100.0f;
            java.util.List<java.lang.String> K = K(str);
            size = K.size();
            for (i = 0; i < size; i++) {
                java.lang.String str2 = K.get(i);
                float measureText = this.D.measureText(str2) + ((str2.length() - 1) * dpScale2);
                canvas.save();
                y(documentData.justification, canvas, measureText);
                canvas.translate(0.0f, (i * dpScale) - (((size - 1) * dpScale) / 2.0f));
                D(str2, documentData, canvas, dpScale2);
                canvas.restore();
            }
        }
        floatValue2 = baseKeyframeAnimation3.getValue().floatValue();
        f += floatValue2;
        float dpScale22 = ((f * com.airbnb.lottie.utils.Utils.dpScale()) * floatValue) / 100.0f;
        java.util.List<java.lang.String> K2 = K(str);
        size = K2.size();
        while (i < size) {
        }
    }

    public final java.util.List<com.airbnb.lottie.animation.content.ContentGroup> I(com.airbnb.lottie.model.FontCharacter fontCharacter) {
        if (this.E.containsKey(fontCharacter)) {
            return this.E.get(fontCharacter);
        }
        java.util.List<com.airbnb.lottie.model.content.ShapeGroup> shapes = fontCharacter.getShapes();
        int size = shapes.size();
        java.util.ArrayList arrayList = new java.util.ArrayList(size);
        for (int i = 0; i < size; i++) {
            arrayList.add(new com.airbnb.lottie.animation.content.ContentGroup(this.H, this, shapes.get(i)));
        }
        this.E.put(fontCharacter, arrayList);
        return arrayList;
    }

    public final float J(java.lang.String str, com.airbnb.lottie.model.Font font, float f, float f2) {
        float f3 = 0.0f;
        for (int i = 0; i < str.length(); i++) {
            com.airbnb.lottie.model.FontCharacter fontCharacter = this.I.getCharacters().get(com.airbnb.lottie.model.FontCharacter.hashFor(str.charAt(i), font.getFamily(), font.getStyle()));
            if (fontCharacter != null) {
                f3 = (float) (f3 + (fontCharacter.getWidth() * f * com.airbnb.lottie.utils.Utils.dpScale() * f2));
            }
        }
        return f3;
    }

    public final java.util.List<java.lang.String> K(java.lang.String str) {
        return java.util.Arrays.asList(str.replaceAll("\r\n", "\r").replaceAll("\n", "\r").split("\r"));
    }

    public final boolean L(int i) {
        return java.lang.Character.getType(i) == 16 || java.lang.Character.getType(i) == 27 || java.lang.Character.getType(i) == 6 || java.lang.Character.getType(i) == 28 || java.lang.Character.getType(i) == 19;
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer, com.airbnb.lottie.model.KeyPathElement
    public <T> void addValueCallback(T t, @androidx.annotation.Nullable com.airbnb.lottie.value.LottieValueCallback<T> lottieValueCallback) {
        super.addValueCallback(t, lottieValueCallback);
        if (t == com.airbnb.lottie.LottieProperty.COLOR) {
            com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<java.lang.Integer, java.lang.Integer> baseKeyframeAnimation = this.K;
            if (baseKeyframeAnimation != null) {
                removeAnimation(baseKeyframeAnimation);
            }
            if (lottieValueCallback == null) {
                this.K = null;
                return;
            }
            com.airbnb.lottie.animation.keyframe.ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation = new com.airbnb.lottie.animation.keyframe.ValueCallbackKeyframeAnimation(lottieValueCallback);
            this.K = valueCallbackKeyframeAnimation;
            valueCallbackKeyframeAnimation.addUpdateListener(this);
            addAnimation(this.K);
            return;
        }
        if (t == com.airbnb.lottie.LottieProperty.STROKE_COLOR) {
            com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<java.lang.Integer, java.lang.Integer> baseKeyframeAnimation2 = this.M;
            if (baseKeyframeAnimation2 != null) {
                removeAnimation(baseKeyframeAnimation2);
            }
            if (lottieValueCallback == null) {
                this.M = null;
                return;
            }
            com.airbnb.lottie.animation.keyframe.ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation2 = new com.airbnb.lottie.animation.keyframe.ValueCallbackKeyframeAnimation(lottieValueCallback);
            this.M = valueCallbackKeyframeAnimation2;
            valueCallbackKeyframeAnimation2.addUpdateListener(this);
            addAnimation(this.M);
            return;
        }
        if (t == com.airbnb.lottie.LottieProperty.STROKE_WIDTH) {
            com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<java.lang.Float, java.lang.Float> baseKeyframeAnimation3 = this.O;
            if (baseKeyframeAnimation3 != null) {
                removeAnimation(baseKeyframeAnimation3);
            }
            if (lottieValueCallback == null) {
                this.O = null;
                return;
            }
            com.airbnb.lottie.animation.keyframe.ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation3 = new com.airbnb.lottie.animation.keyframe.ValueCallbackKeyframeAnimation(lottieValueCallback);
            this.O = valueCallbackKeyframeAnimation3;
            valueCallbackKeyframeAnimation3.addUpdateListener(this);
            addAnimation(this.O);
            return;
        }
        if (t == com.airbnb.lottie.LottieProperty.TEXT_TRACKING) {
            com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<java.lang.Float, java.lang.Float> baseKeyframeAnimation4 = this.Q;
            if (baseKeyframeAnimation4 != null) {
                removeAnimation(baseKeyframeAnimation4);
            }
            if (lottieValueCallback == null) {
                this.Q = null;
                return;
            }
            com.airbnb.lottie.animation.keyframe.ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation4 = new com.airbnb.lottie.animation.keyframe.ValueCallbackKeyframeAnimation(lottieValueCallback);
            this.Q = valueCallbackKeyframeAnimation4;
            valueCallbackKeyframeAnimation4.addUpdateListener(this);
            addAnimation(this.Q);
            return;
        }
        if (t == com.airbnb.lottie.LottieProperty.TEXT_SIZE) {
            com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<java.lang.Float, java.lang.Float> baseKeyframeAnimation5 = this.S;
            if (baseKeyframeAnimation5 != null) {
                removeAnimation(baseKeyframeAnimation5);
            }
            if (lottieValueCallback == null) {
                this.S = null;
                return;
            }
            com.airbnb.lottie.animation.keyframe.ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation5 = new com.airbnb.lottie.animation.keyframe.ValueCallbackKeyframeAnimation(lottieValueCallback);
            this.S = valueCallbackKeyframeAnimation5;
            valueCallbackKeyframeAnimation5.addUpdateListener(this);
            addAnimation(this.S);
        }
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer
    public void drawLayer(android.graphics.Canvas canvas, android.graphics.Matrix matrix, int i) {
        canvas.save();
        if (!this.H.useTextGlyphs()) {
            canvas.concat(matrix);
        }
        com.airbnb.lottie.model.DocumentData value = this.G.getValue();
        com.airbnb.lottie.model.Font font = this.I.getFonts().get(value.fontName);
        if (font == null) {
            canvas.restore();
            return;
        }
        com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<java.lang.Integer, java.lang.Integer> baseKeyframeAnimation = this.K;
        if (baseKeyframeAnimation != null) {
            this.C.setColor(baseKeyframeAnimation.getValue().intValue());
        } else {
            com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<java.lang.Integer, java.lang.Integer> baseKeyframeAnimation2 = this.J;
            if (baseKeyframeAnimation2 != null) {
                this.C.setColor(baseKeyframeAnimation2.getValue().intValue());
            } else {
                this.C.setColor(value.color);
            }
        }
        com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<java.lang.Integer, java.lang.Integer> baseKeyframeAnimation3 = this.M;
        if (baseKeyframeAnimation3 != null) {
            this.D.setColor(baseKeyframeAnimation3.getValue().intValue());
        } else {
            com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<java.lang.Integer, java.lang.Integer> baseKeyframeAnimation4 = this.L;
            if (baseKeyframeAnimation4 != null) {
                this.D.setColor(baseKeyframeAnimation4.getValue().intValue());
            } else {
                this.D.setColor(value.strokeColor);
            }
        }
        int intValue = ((this.v.getOpacity() == null ? 100 : this.v.getOpacity().getValue().intValue()) * 255) / 100;
        this.C.setAlpha(intValue);
        this.D.setAlpha(intValue);
        com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<java.lang.Float, java.lang.Float> baseKeyframeAnimation5 = this.O;
        if (baseKeyframeAnimation5 != null) {
            this.D.setStrokeWidth(baseKeyframeAnimation5.getValue().floatValue());
        } else {
            com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<java.lang.Float, java.lang.Float> baseKeyframeAnimation6 = this.N;
            if (baseKeyframeAnimation6 != null) {
                this.D.setStrokeWidth(baseKeyframeAnimation6.getValue().floatValue());
            } else {
                this.D.setStrokeWidth(value.strokeWidth * com.airbnb.lottie.utils.Utils.dpScale() * com.airbnb.lottie.utils.Utils.getScale(matrix));
            }
        }
        if (this.H.useTextGlyphs()) {
            G(value, matrix, font, canvas);
        } else {
            H(value, font, matrix, canvas);
        }
        canvas.restore();
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer, com.airbnb.lottie.animation.content.DrawingContent
    public void getBounds(android.graphics.RectF rectF, android.graphics.Matrix matrix, boolean z) {
        super.getBounds(rectF, matrix, z);
        rectF.set(0.0f, 0.0f, this.I.getBounds().width(), this.I.getBounds().height());
    }

    public final void y(com.airbnb.lottie.model.DocumentData.Justification justification, android.graphics.Canvas canvas, float f) {
        int i = com.airbnb.lottie.model.layer.TextLayer.AnonymousClass3.a[justification.ordinal()];
        if (i == 2) {
            canvas.translate(-f, 0.0f);
        } else {
            if (i != 3) {
                return;
            }
            canvas.translate((-f) / 2.0f, 0.0f);
        }
    }

    public final java.lang.String z(java.lang.String str, int i) {
        int codePointAt = str.codePointAt(i);
        int charCount = java.lang.Character.charCount(codePointAt) + i;
        while (charCount < str.length()) {
            int codePointAt2 = str.codePointAt(charCount);
            if (!L(codePointAt2)) {
                break;
            }
            charCount += java.lang.Character.charCount(codePointAt2);
            codePointAt = (codePointAt * 31) + codePointAt2;
        }
        long j = codePointAt;
        if (this.F.containsKey(j)) {
            return this.F.get(j);
        }
        this.z.setLength(0);
        while (i < charCount) {
            int codePointAt3 = str.codePointAt(i);
            this.z.appendCodePoint(codePointAt3);
            i += java.lang.Character.charCount(codePointAt3);
        }
        java.lang.String sb = this.z.toString();
        this.F.put(j, sb);
        return sb;
    }
}
