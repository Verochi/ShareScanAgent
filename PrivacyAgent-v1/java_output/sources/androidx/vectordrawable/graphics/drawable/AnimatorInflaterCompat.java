package androidx.vectordrawable.graphics.drawable;

@androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public class AnimatorInflaterCompat {
    private static final boolean DBG_ANIMATOR_INFLATER = false;
    private static final int MAX_NUM_POINTS = 100;
    private static final java.lang.String TAG = "AnimatorInflater";
    private static final int TOGETHER = 0;
    private static final int VALUE_TYPE_COLOR = 3;
    private static final int VALUE_TYPE_FLOAT = 0;
    private static final int VALUE_TYPE_INT = 1;
    private static final int VALUE_TYPE_PATH = 2;
    private static final int VALUE_TYPE_UNDEFINED = 4;

    public static class PathDataEvaluator implements android.animation.TypeEvaluator<androidx.core.graphics.PathParser.PathDataNode[]> {
        private androidx.core.graphics.PathParser.PathDataNode[] mNodeArray;

        public PathDataEvaluator() {
        }

        public PathDataEvaluator(androidx.core.graphics.PathParser.PathDataNode[] pathDataNodeArr) {
            this.mNodeArray = pathDataNodeArr;
        }

        @Override // android.animation.TypeEvaluator
        public androidx.core.graphics.PathParser.PathDataNode[] evaluate(float f, androidx.core.graphics.PathParser.PathDataNode[] pathDataNodeArr, androidx.core.graphics.PathParser.PathDataNode[] pathDataNodeArr2) {
            if (!androidx.core.graphics.PathParser.canMorph(pathDataNodeArr, pathDataNodeArr2)) {
                throw new java.lang.IllegalArgumentException("Can't interpolate between two incompatible pathData");
            }
            if (!androidx.core.graphics.PathParser.canMorph(this.mNodeArray, pathDataNodeArr)) {
                this.mNodeArray = androidx.core.graphics.PathParser.deepCopyNodes(pathDataNodeArr);
            }
            for (int i = 0; i < pathDataNodeArr.length; i++) {
                this.mNodeArray[i].interpolatePathDataNode(pathDataNodeArr[i], pathDataNodeArr2[i], f);
            }
            return this.mNodeArray;
        }
    }

    private AnimatorInflaterCompat() {
    }

    private static android.animation.Animator createAnimatorFromXml(android.content.Context context, android.content.res.Resources resources, android.content.res.Resources.Theme theme, org.xmlpull.v1.XmlPullParser xmlPullParser, float f) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        return createAnimatorFromXml(context, resources, theme, xmlPullParser, android.util.Xml.asAttributeSet(xmlPullParser), null, 0, f);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00b8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static android.animation.Animator createAnimatorFromXml(android.content.Context context, android.content.res.Resources resources, android.content.res.Resources.Theme theme, org.xmlpull.v1.XmlPullParser xmlPullParser, android.util.AttributeSet attributeSet, android.animation.AnimatorSet animatorSet, int i, float f) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        int i2;
        int depth = xmlPullParser.getDepth();
        android.animation.ValueAnimator valueAnimator = null;
        java.util.ArrayList arrayList = null;
        while (true) {
            int next = xmlPullParser.next();
            i2 = 0;
            if ((next != 3 || xmlPullParser.getDepth() > depth) && next != 1) {
                if (next == 2) {
                    java.lang.String name = xmlPullParser.getName();
                    if (name.equals("objectAnimator")) {
                        valueAnimator = loadObjectAnimator(context, resources, theme, attributeSet, f, xmlPullParser);
                    } else if (name.equals("animator")) {
                        valueAnimator = loadAnimator(context, resources, theme, attributeSet, null, f, xmlPullParser);
                    } else {
                        if (name.equals("set")) {
                            android.animation.AnimatorSet animatorSet2 = new android.animation.AnimatorSet();
                            android.content.res.TypedArray obtainAttributes = androidx.core.content.res.TypedArrayUtils.obtainAttributes(resources, theme, attributeSet, androidx.vectordrawable.graphics.drawable.AndroidResources.STYLEABLE_ANIMATOR_SET);
                            createAnimatorFromXml(context, resources, theme, xmlPullParser, attributeSet, animatorSet2, androidx.core.content.res.TypedArrayUtils.getNamedInt(obtainAttributes, xmlPullParser, "ordering", 0, 0), f);
                            obtainAttributes.recycle();
                            valueAnimator = animatorSet2;
                        } else {
                            if (!name.equals("propertyValuesHolder")) {
                                throw new java.lang.RuntimeException("Unknown animator name: " + xmlPullParser.getName());
                            }
                            android.animation.PropertyValuesHolder[] loadValues = loadValues(context, resources, theme, xmlPullParser, android.util.Xml.asAttributeSet(xmlPullParser));
                            if (loadValues != null && (valueAnimator instanceof android.animation.ValueAnimator)) {
                                valueAnimator.setValues(loadValues);
                            }
                            i2 = 1;
                        }
                        if (animatorSet != null && i2 == 0) {
                            if (arrayList == null) {
                                arrayList = new java.util.ArrayList();
                            }
                            arrayList.add(valueAnimator);
                        }
                    }
                    if (animatorSet != null) {
                        if (arrayList == null) {
                        }
                        arrayList.add(valueAnimator);
                    }
                }
            }
        }
        if (animatorSet != null && arrayList != null) {
            android.animation.Animator[] animatorArr = new android.animation.Animator[arrayList.size()];
            java.util.Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                animatorArr[i2] = (android.animation.Animator) it.next();
                i2++;
            }
            if (i == 0) {
                animatorSet.playTogether(animatorArr);
            } else {
                animatorSet.playSequentially(animatorArr);
            }
        }
        return valueAnimator;
    }

    private static android.animation.Keyframe createNewKeyframe(android.animation.Keyframe keyframe, float f) {
        return keyframe.getType() == java.lang.Float.TYPE ? android.animation.Keyframe.ofFloat(f) : keyframe.getType() == java.lang.Integer.TYPE ? android.animation.Keyframe.ofInt(f) : android.animation.Keyframe.ofObject(f);
    }

    private static void distributeKeyframes(android.animation.Keyframe[] keyframeArr, float f, int i, int i2) {
        float f2 = f / ((i2 - i) + 2);
        while (i <= i2) {
            keyframeArr[i].setFraction(keyframeArr[i - 1].getFraction() + f2);
            i++;
        }
    }

    private static void dumpKeyframes(java.lang.Object[] objArr, java.lang.String str) {
        if (objArr == null || objArr.length == 0) {
            return;
        }
        int length = objArr.length;
        for (int i = 0; i < length; i++) {
            android.animation.Keyframe keyframe = (android.animation.Keyframe) objArr[i];
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("Keyframe ");
            sb.append(i);
            sb.append(": fraction ");
            float fraction = keyframe.getFraction();
            java.lang.Object obj = com.igexin.push.core.b.m;
            sb.append(fraction < 0.0f ? com.igexin.push.core.b.m : java.lang.Float.valueOf(keyframe.getFraction()));
            sb.append(", , value : ");
            if (keyframe.hasValue()) {
                obj = keyframe.getValue();
            }
            sb.append(obj);
        }
    }

    private static android.animation.PropertyValuesHolder getPVH(android.content.res.TypedArray typedArray, int i, int i2, int i3, java.lang.String str) {
        android.animation.PropertyValuesHolder ofFloat;
        android.animation.PropertyValuesHolder ofObject;
        android.util.TypedValue peekValue = typedArray.peekValue(i2);
        boolean z = peekValue != null;
        int i4 = z ? peekValue.type : 0;
        android.util.TypedValue peekValue2 = typedArray.peekValue(i3);
        boolean z2 = peekValue2 != null;
        int i5 = z2 ? peekValue2.type : 0;
        if (i == 4) {
            i = ((z && isColorType(i4)) || (z2 && isColorType(i5))) ? 3 : 0;
        }
        boolean z3 = i == 0;
        android.animation.PropertyValuesHolder propertyValuesHolder = null;
        if (i != 2) {
            androidx.vectordrawable.graphics.drawable.ArgbEvaluator argbEvaluator = i == 3 ? androidx.vectordrawable.graphics.drawable.ArgbEvaluator.getInstance() : null;
            if (z3) {
                if (z) {
                    float dimension = i4 == 5 ? typedArray.getDimension(i2, 0.0f) : typedArray.getFloat(i2, 0.0f);
                    if (z2) {
                        ofFloat = android.animation.PropertyValuesHolder.ofFloat(str, dimension, i5 == 5 ? typedArray.getDimension(i3, 0.0f) : typedArray.getFloat(i3, 0.0f));
                    } else {
                        ofFloat = android.animation.PropertyValuesHolder.ofFloat(str, dimension);
                    }
                } else {
                    ofFloat = android.animation.PropertyValuesHolder.ofFloat(str, i5 == 5 ? typedArray.getDimension(i3, 0.0f) : typedArray.getFloat(i3, 0.0f));
                }
                propertyValuesHolder = ofFloat;
            } else if (z) {
                int dimension2 = i4 == 5 ? (int) typedArray.getDimension(i2, 0.0f) : isColorType(i4) ? typedArray.getColor(i2, 0) : typedArray.getInt(i2, 0);
                if (z2) {
                    propertyValuesHolder = android.animation.PropertyValuesHolder.ofInt(str, dimension2, i5 == 5 ? (int) typedArray.getDimension(i3, 0.0f) : isColorType(i5) ? typedArray.getColor(i3, 0) : typedArray.getInt(i3, 0));
                } else {
                    propertyValuesHolder = android.animation.PropertyValuesHolder.ofInt(str, dimension2);
                }
            } else if (z2) {
                propertyValuesHolder = android.animation.PropertyValuesHolder.ofInt(str, i5 == 5 ? (int) typedArray.getDimension(i3, 0.0f) : isColorType(i5) ? typedArray.getColor(i3, 0) : typedArray.getInt(i3, 0));
            }
            if (propertyValuesHolder == null || argbEvaluator == null) {
                return propertyValuesHolder;
            }
            propertyValuesHolder.setEvaluator(argbEvaluator);
            return propertyValuesHolder;
        }
        java.lang.String string = typedArray.getString(i2);
        java.lang.String string2 = typedArray.getString(i3);
        androidx.core.graphics.PathParser.PathDataNode[] createNodesFromPathData = androidx.core.graphics.PathParser.createNodesFromPathData(string);
        androidx.core.graphics.PathParser.PathDataNode[] createNodesFromPathData2 = androidx.core.graphics.PathParser.createNodesFromPathData(string2);
        if (createNodesFromPathData == null && createNodesFromPathData2 == null) {
            return null;
        }
        if (createNodesFromPathData == null) {
            if (createNodesFromPathData2 != null) {
                return android.animation.PropertyValuesHolder.ofObject(str, new androidx.vectordrawable.graphics.drawable.AnimatorInflaterCompat.PathDataEvaluator(), createNodesFromPathData2);
            }
            return null;
        }
        androidx.vectordrawable.graphics.drawable.AnimatorInflaterCompat.PathDataEvaluator pathDataEvaluator = new androidx.vectordrawable.graphics.drawable.AnimatorInflaterCompat.PathDataEvaluator();
        if (createNodesFromPathData2 == null) {
            ofObject = android.animation.PropertyValuesHolder.ofObject(str, pathDataEvaluator, createNodesFromPathData);
        } else {
            if (!androidx.core.graphics.PathParser.canMorph(createNodesFromPathData, createNodesFromPathData2)) {
                throw new android.view.InflateException(" Can't morph from " + string + " to " + string2);
            }
            ofObject = android.animation.PropertyValuesHolder.ofObject(str, pathDataEvaluator, createNodesFromPathData, createNodesFromPathData2);
        }
        return ofObject;
    }

    private static int inferValueTypeFromValues(android.content.res.TypedArray typedArray, int i, int i2) {
        android.util.TypedValue peekValue = typedArray.peekValue(i);
        boolean z = peekValue != null;
        int i3 = z ? peekValue.type : 0;
        android.util.TypedValue peekValue2 = typedArray.peekValue(i2);
        boolean z2 = peekValue2 != null;
        return ((z && isColorType(i3)) || (z2 && isColorType(z2 ? peekValue2.type : 0))) ? 3 : 0;
    }

    private static int inferValueTypeOfKeyframe(android.content.res.Resources resources, android.content.res.Resources.Theme theme, android.util.AttributeSet attributeSet, org.xmlpull.v1.XmlPullParser xmlPullParser) {
        android.content.res.TypedArray obtainAttributes = androidx.core.content.res.TypedArrayUtils.obtainAttributes(resources, theme, attributeSet, androidx.vectordrawable.graphics.drawable.AndroidResources.STYLEABLE_KEYFRAME);
        int i = 0;
        android.util.TypedValue peekNamedValue = androidx.core.content.res.TypedArrayUtils.peekNamedValue(obtainAttributes, xmlPullParser, "value", 0);
        if ((peekNamedValue != null) && isColorType(peekNamedValue.type)) {
            i = 3;
        }
        obtainAttributes.recycle();
        return i;
    }

    private static boolean isColorType(int i) {
        return i >= 28 && i <= 31;
    }

    public static android.animation.Animator loadAnimator(android.content.Context context, @androidx.annotation.AnimatorRes int i) throws android.content.res.Resources.NotFoundException {
        return android.os.Build.VERSION.SDK_INT >= 24 ? android.animation.AnimatorInflater.loadAnimator(context, i) : loadAnimator(context, context.getResources(), context.getTheme(), i);
    }

    public static android.animation.Animator loadAnimator(android.content.Context context, android.content.res.Resources resources, android.content.res.Resources.Theme theme, @androidx.annotation.AnimatorRes int i) throws android.content.res.Resources.NotFoundException {
        return loadAnimator(context, resources, theme, i, 1.0f);
    }

    public static android.animation.Animator loadAnimator(android.content.Context context, android.content.res.Resources resources, android.content.res.Resources.Theme theme, @androidx.annotation.AnimatorRes int i, float f) throws android.content.res.Resources.NotFoundException {
        android.content.res.XmlResourceParser xmlResourceParser = null;
        try {
            try {
                try {
                    xmlResourceParser = resources.getAnimation(i);
                    return createAnimatorFromXml(context, resources, theme, xmlResourceParser, f);
                } catch (org.xmlpull.v1.XmlPullParserException e) {
                    android.content.res.Resources.NotFoundException notFoundException = new android.content.res.Resources.NotFoundException("Can't load animation resource ID #0x" + java.lang.Integer.toHexString(i));
                    notFoundException.initCause(e);
                    throw notFoundException;
                }
            } catch (java.io.IOException e2) {
                android.content.res.Resources.NotFoundException notFoundException2 = new android.content.res.Resources.NotFoundException("Can't load animation resource ID #0x" + java.lang.Integer.toHexString(i));
                notFoundException2.initCause(e2);
                throw notFoundException2;
            }
        } finally {
            if (xmlResourceParser != null) {
                xmlResourceParser.close();
            }
        }
    }

    private static android.animation.ValueAnimator loadAnimator(android.content.Context context, android.content.res.Resources resources, android.content.res.Resources.Theme theme, android.util.AttributeSet attributeSet, android.animation.ValueAnimator valueAnimator, float f, org.xmlpull.v1.XmlPullParser xmlPullParser) throws android.content.res.Resources.NotFoundException {
        android.content.res.TypedArray obtainAttributes = androidx.core.content.res.TypedArrayUtils.obtainAttributes(resources, theme, attributeSet, androidx.vectordrawable.graphics.drawable.AndroidResources.STYLEABLE_ANIMATOR);
        android.content.res.TypedArray obtainAttributes2 = androidx.core.content.res.TypedArrayUtils.obtainAttributes(resources, theme, attributeSet, androidx.vectordrawable.graphics.drawable.AndroidResources.STYLEABLE_PROPERTY_ANIMATOR);
        if (valueAnimator == null) {
            valueAnimator = new android.animation.ValueAnimator();
        }
        parseAnimatorFromTypeArray(valueAnimator, obtainAttributes, obtainAttributes2, f, xmlPullParser);
        int namedResourceId = androidx.core.content.res.TypedArrayUtils.getNamedResourceId(obtainAttributes, xmlPullParser, "interpolator", 0, 0);
        if (namedResourceId > 0) {
            valueAnimator.setInterpolator(androidx.vectordrawable.graphics.drawable.AnimationUtilsCompat.loadInterpolator(context, namedResourceId));
        }
        obtainAttributes.recycle();
        if (obtainAttributes2 != null) {
            obtainAttributes2.recycle();
        }
        return valueAnimator;
    }

    private static android.animation.Keyframe loadKeyframe(android.content.Context context, android.content.res.Resources resources, android.content.res.Resources.Theme theme, android.util.AttributeSet attributeSet, int i, org.xmlpull.v1.XmlPullParser xmlPullParser) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        android.content.res.TypedArray obtainAttributes = androidx.core.content.res.TypedArrayUtils.obtainAttributes(resources, theme, attributeSet, androidx.vectordrawable.graphics.drawable.AndroidResources.STYLEABLE_KEYFRAME);
        float namedFloat = androidx.core.content.res.TypedArrayUtils.getNamedFloat(obtainAttributes, xmlPullParser, "fraction", 3, -1.0f);
        android.util.TypedValue peekNamedValue = androidx.core.content.res.TypedArrayUtils.peekNamedValue(obtainAttributes, xmlPullParser, "value", 0);
        boolean z = peekNamedValue != null;
        if (i == 4) {
            i = (z && isColorType(peekNamedValue.type)) ? 3 : 0;
        }
        android.animation.Keyframe ofInt = z ? i != 0 ? (i == 1 || i == 3) ? android.animation.Keyframe.ofInt(namedFloat, androidx.core.content.res.TypedArrayUtils.getNamedInt(obtainAttributes, xmlPullParser, "value", 0, 0)) : null : android.animation.Keyframe.ofFloat(namedFloat, androidx.core.content.res.TypedArrayUtils.getNamedFloat(obtainAttributes, xmlPullParser, "value", 0, 0.0f)) : i == 0 ? android.animation.Keyframe.ofFloat(namedFloat) : android.animation.Keyframe.ofInt(namedFloat);
        int namedResourceId = androidx.core.content.res.TypedArrayUtils.getNamedResourceId(obtainAttributes, xmlPullParser, "interpolator", 1, 0);
        if (namedResourceId > 0) {
            ofInt.setInterpolator(androidx.vectordrawable.graphics.drawable.AnimationUtilsCompat.loadInterpolator(context, namedResourceId));
        }
        obtainAttributes.recycle();
        return ofInt;
    }

    private static android.animation.ObjectAnimator loadObjectAnimator(android.content.Context context, android.content.res.Resources resources, android.content.res.Resources.Theme theme, android.util.AttributeSet attributeSet, float f, org.xmlpull.v1.XmlPullParser xmlPullParser) throws android.content.res.Resources.NotFoundException {
        android.animation.ObjectAnimator objectAnimator = new android.animation.ObjectAnimator();
        loadAnimator(context, resources, theme, attributeSet, objectAnimator, f, xmlPullParser);
        return objectAnimator;
    }

    private static android.animation.PropertyValuesHolder loadPvh(android.content.Context context, android.content.res.Resources resources, android.content.res.Resources.Theme theme, org.xmlpull.v1.XmlPullParser xmlPullParser, java.lang.String str, int i) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        int size;
        android.animation.PropertyValuesHolder propertyValuesHolder = null;
        java.util.ArrayList arrayList = null;
        while (true) {
            int next = xmlPullParser.next();
            if (next == 3 || next == 1) {
                break;
            }
            if (xmlPullParser.getName().equals("keyframe")) {
                if (i == 4) {
                    i = inferValueTypeOfKeyframe(resources, theme, android.util.Xml.asAttributeSet(xmlPullParser), xmlPullParser);
                }
                android.animation.Keyframe loadKeyframe = loadKeyframe(context, resources, theme, android.util.Xml.asAttributeSet(xmlPullParser), i, xmlPullParser);
                if (loadKeyframe != null) {
                    if (arrayList == null) {
                        arrayList = new java.util.ArrayList();
                    }
                    arrayList.add(loadKeyframe);
                }
                xmlPullParser.next();
            }
        }
        if (arrayList != null && (size = arrayList.size()) > 0) {
            android.animation.Keyframe keyframe = (android.animation.Keyframe) arrayList.get(0);
            android.animation.Keyframe keyframe2 = (android.animation.Keyframe) arrayList.get(size - 1);
            float fraction = keyframe2.getFraction();
            if (fraction < 1.0f) {
                if (fraction < 0.0f) {
                    keyframe2.setFraction(1.0f);
                } else {
                    arrayList.add(arrayList.size(), createNewKeyframe(keyframe2, 1.0f));
                    size++;
                }
            }
            float fraction2 = keyframe.getFraction();
            if (fraction2 != 0.0f) {
                if (fraction2 < 0.0f) {
                    keyframe.setFraction(0.0f);
                } else {
                    arrayList.add(0, createNewKeyframe(keyframe, 0.0f));
                    size++;
                }
            }
            android.animation.Keyframe[] keyframeArr = new android.animation.Keyframe[size];
            arrayList.toArray(keyframeArr);
            for (int i2 = 0; i2 < size; i2++) {
                android.animation.Keyframe keyframe3 = keyframeArr[i2];
                if (keyframe3.getFraction() < 0.0f) {
                    if (i2 == 0) {
                        keyframe3.setFraction(0.0f);
                    } else {
                        int i3 = size - 1;
                        if (i2 == i3) {
                            keyframe3.setFraction(1.0f);
                        } else {
                            int i4 = i2;
                            for (int i5 = i2 + 1; i5 < i3 && keyframeArr[i5].getFraction() < 0.0f; i5++) {
                                i4 = i5;
                            }
                            distributeKeyframes(keyframeArr, keyframeArr[i4 + 1].getFraction() - keyframeArr[i2 - 1].getFraction(), i2, i4);
                        }
                    }
                }
            }
            propertyValuesHolder = android.animation.PropertyValuesHolder.ofKeyframe(str, keyframeArr);
            if (i == 3) {
                propertyValuesHolder.setEvaluator(androidx.vectordrawable.graphics.drawable.ArgbEvaluator.getInstance());
            }
        }
        return propertyValuesHolder;
    }

    private static android.animation.PropertyValuesHolder[] loadValues(android.content.Context context, android.content.res.Resources resources, android.content.res.Resources.Theme theme, org.xmlpull.v1.XmlPullParser xmlPullParser, android.util.AttributeSet attributeSet) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        int i;
        android.animation.PropertyValuesHolder[] propertyValuesHolderArr = null;
        java.util.ArrayList arrayList = null;
        while (true) {
            int eventType = xmlPullParser.getEventType();
            if (eventType == 3 || eventType == 1) {
                break;
            }
            if (eventType != 2) {
                xmlPullParser.next();
            } else {
                if (xmlPullParser.getName().equals("propertyValuesHolder")) {
                    android.content.res.TypedArray obtainAttributes = androidx.core.content.res.TypedArrayUtils.obtainAttributes(resources, theme, attributeSet, androidx.vectordrawable.graphics.drawable.AndroidResources.STYLEABLE_PROPERTY_VALUES_HOLDER);
                    java.lang.String namedString = androidx.core.content.res.TypedArrayUtils.getNamedString(obtainAttributes, xmlPullParser, "propertyName", 3);
                    int namedInt = androidx.core.content.res.TypedArrayUtils.getNamedInt(obtainAttributes, xmlPullParser, "valueType", 2, 4);
                    android.animation.PropertyValuesHolder loadPvh = loadPvh(context, resources, theme, xmlPullParser, namedString, namedInt);
                    if (loadPvh == null) {
                        loadPvh = getPVH(obtainAttributes, namedInt, 0, 1, namedString);
                    }
                    if (loadPvh != null) {
                        if (arrayList == null) {
                            arrayList = new java.util.ArrayList();
                        }
                        arrayList.add(loadPvh);
                    }
                    obtainAttributes.recycle();
                }
                xmlPullParser.next();
            }
        }
        if (arrayList != null) {
            int size = arrayList.size();
            propertyValuesHolderArr = new android.animation.PropertyValuesHolder[size];
            for (i = 0; i < size; i++) {
                propertyValuesHolderArr[i] = (android.animation.PropertyValuesHolder) arrayList.get(i);
            }
        }
        return propertyValuesHolderArr;
    }

    private static void parseAnimatorFromTypeArray(android.animation.ValueAnimator valueAnimator, android.content.res.TypedArray typedArray, android.content.res.TypedArray typedArray2, float f, org.xmlpull.v1.XmlPullParser xmlPullParser) {
        long namedInt = androidx.core.content.res.TypedArrayUtils.getNamedInt(typedArray, xmlPullParser, "duration", 1, 300);
        long namedInt2 = androidx.core.content.res.TypedArrayUtils.getNamedInt(typedArray, xmlPullParser, "startOffset", 2, 0);
        int namedInt3 = androidx.core.content.res.TypedArrayUtils.getNamedInt(typedArray, xmlPullParser, "valueType", 7, 4);
        if (androidx.core.content.res.TypedArrayUtils.hasAttribute(xmlPullParser, "valueFrom") && androidx.core.content.res.TypedArrayUtils.hasAttribute(xmlPullParser, "valueTo")) {
            if (namedInt3 == 4) {
                namedInt3 = inferValueTypeFromValues(typedArray, 5, 6);
            }
            android.animation.PropertyValuesHolder pvh = getPVH(typedArray, namedInt3, 5, 6, "");
            if (pvh != null) {
                valueAnimator.setValues(pvh);
            }
        }
        valueAnimator.setDuration(namedInt);
        valueAnimator.setStartDelay(namedInt2);
        valueAnimator.setRepeatCount(androidx.core.content.res.TypedArrayUtils.getNamedInt(typedArray, xmlPullParser, "repeatCount", 3, 0));
        valueAnimator.setRepeatMode(androidx.core.content.res.TypedArrayUtils.getNamedInt(typedArray, xmlPullParser, "repeatMode", 4, 1));
        if (typedArray2 != null) {
            setupObjectAnimator(valueAnimator, typedArray2, namedInt3, f, xmlPullParser);
        }
    }

    private static void setupObjectAnimator(android.animation.ValueAnimator valueAnimator, android.content.res.TypedArray typedArray, int i, float f, org.xmlpull.v1.XmlPullParser xmlPullParser) {
        android.animation.ObjectAnimator objectAnimator = (android.animation.ObjectAnimator) valueAnimator;
        java.lang.String namedString = androidx.core.content.res.TypedArrayUtils.getNamedString(typedArray, xmlPullParser, "pathData", 1);
        if (namedString == null) {
            objectAnimator.setPropertyName(androidx.core.content.res.TypedArrayUtils.getNamedString(typedArray, xmlPullParser, "propertyName", 0));
            return;
        }
        java.lang.String namedString2 = androidx.core.content.res.TypedArrayUtils.getNamedString(typedArray, xmlPullParser, "propertyXName", 2);
        java.lang.String namedString3 = androidx.core.content.res.TypedArrayUtils.getNamedString(typedArray, xmlPullParser, "propertyYName", 3);
        if (i != 2) {
        }
        if (namedString2 != null || namedString3 != null) {
            setupPathMotion(androidx.core.graphics.PathParser.createPathFromPathData(namedString), objectAnimator, f * 0.5f, namedString2, namedString3);
            return;
        }
        throw new android.view.InflateException(typedArray.getPositionDescription() + " propertyXName or propertyYName is needed for PathData");
    }

    private static void setupPathMotion(android.graphics.Path path, android.animation.ObjectAnimator objectAnimator, float f, java.lang.String str, java.lang.String str2) {
        android.graphics.PathMeasure pathMeasure = new android.graphics.PathMeasure(path, false);
        java.util.ArrayList arrayList = new java.util.ArrayList();
        float f2 = 0.0f;
        arrayList.add(java.lang.Float.valueOf(0.0f));
        float f3 = 0.0f;
        do {
            f3 += pathMeasure.getLength();
            arrayList.add(java.lang.Float.valueOf(f3));
        } while (pathMeasure.nextContour());
        android.graphics.PathMeasure pathMeasure2 = new android.graphics.PathMeasure(path, false);
        int min = java.lang.Math.min(100, ((int) (f3 / f)) + 1);
        float[] fArr = new float[min];
        float[] fArr2 = new float[min];
        float[] fArr3 = new float[2];
        float f4 = f3 / (min - 1);
        int i = 0;
        int i2 = 0;
        while (true) {
            if (i >= min) {
                break;
            }
            pathMeasure2.getPosTan(f2 - ((java.lang.Float) arrayList.get(i2)).floatValue(), fArr3, null);
            fArr[i] = fArr3[0];
            fArr2[i] = fArr3[1];
            f2 += f4;
            int i3 = i2 + 1;
            if (i3 < arrayList.size() && f2 > ((java.lang.Float) arrayList.get(i3)).floatValue()) {
                pathMeasure2.nextContour();
                i2 = i3;
            }
            i++;
        }
        android.animation.PropertyValuesHolder ofFloat = str != null ? android.animation.PropertyValuesHolder.ofFloat(str, fArr) : null;
        android.animation.PropertyValuesHolder ofFloat2 = str2 != null ? android.animation.PropertyValuesHolder.ofFloat(str2, fArr2) : null;
        if (ofFloat == null) {
            objectAnimator.setValues(ofFloat2);
        } else if (ofFloat2 == null) {
            objectAnimator.setValues(ofFloat);
        } else {
            objectAnimator.setValues(ofFloat, ofFloat2);
        }
    }
}
