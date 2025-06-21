package androidx.vectordrawable.graphics.drawable;

/* loaded from: classes.dex */
public class VectorDrawableCompat extends androidx.vectordrawable.graphics.drawable.VectorDrawableCommon {
    private static final boolean DBG_VECTOR_DRAWABLE = false;
    static final android.graphics.PorterDuff.Mode DEFAULT_TINT_MODE = android.graphics.PorterDuff.Mode.SRC_IN;
    private static final int LINECAP_BUTT = 0;
    private static final int LINECAP_ROUND = 1;
    private static final int LINECAP_SQUARE = 2;
    private static final int LINEJOIN_BEVEL = 2;
    private static final int LINEJOIN_MITER = 0;
    private static final int LINEJOIN_ROUND = 1;
    static final java.lang.String LOGTAG = "VectorDrawableCompat";
    private static final int MAX_CACHED_BITMAP_SIZE = 2048;
    private static final java.lang.String SHAPE_CLIP_PATH = "clip-path";
    private static final java.lang.String SHAPE_GROUP = "group";
    private static final java.lang.String SHAPE_PATH = "path";
    private static final java.lang.String SHAPE_VECTOR = "vector";
    private boolean mAllowCaching;
    private android.graphics.drawable.Drawable.ConstantState mCachedConstantStateDelegate;
    private android.graphics.ColorFilter mColorFilter;
    private boolean mMutated;
    private android.graphics.PorterDuffColorFilter mTintFilter;
    private final android.graphics.Rect mTmpBounds;
    private final float[] mTmpFloats;
    private final android.graphics.Matrix mTmpMatrix;
    private androidx.vectordrawable.graphics.drawable.VectorDrawableCompat.VectorDrawableCompatState mVectorState;

    public static class VClipPath extends androidx.vectordrawable.graphics.drawable.VectorDrawableCompat.VPath {
        public VClipPath() {
        }

        public VClipPath(androidx.vectordrawable.graphics.drawable.VectorDrawableCompat.VClipPath vClipPath) {
            super(vClipPath);
        }

        private void updateStateFromTypedArray(android.content.res.TypedArray typedArray, org.xmlpull.v1.XmlPullParser xmlPullParser) {
            java.lang.String string = typedArray.getString(0);
            if (string != null) {
                this.mPathName = string;
            }
            java.lang.String string2 = typedArray.getString(1);
            if (string2 != null) {
                this.mNodes = androidx.core.graphics.PathParser.createNodesFromPathData(string2);
            }
            this.mFillRule = androidx.core.content.res.TypedArrayUtils.getNamedInt(typedArray, xmlPullParser, "fillType", 2, 0);
        }

        public void inflate(android.content.res.Resources resources, android.util.AttributeSet attributeSet, android.content.res.Resources.Theme theme, org.xmlpull.v1.XmlPullParser xmlPullParser) {
            if (androidx.core.content.res.TypedArrayUtils.hasAttribute(xmlPullParser, "pathData")) {
                android.content.res.TypedArray obtainAttributes = androidx.core.content.res.TypedArrayUtils.obtainAttributes(resources, theme, attributeSet, androidx.vectordrawable.graphics.drawable.AndroidResources.STYLEABLE_VECTOR_DRAWABLE_CLIP_PATH);
                updateStateFromTypedArray(obtainAttributes, xmlPullParser);
                obtainAttributes.recycle();
            }
        }

        @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCompat.VPath
        public boolean isClipPath() {
            return true;
        }
    }

    public static class VFullPath extends androidx.vectordrawable.graphics.drawable.VectorDrawableCompat.VPath {
        float mFillAlpha;
        androidx.core.content.res.ComplexColorCompat mFillColor;
        float mStrokeAlpha;
        androidx.core.content.res.ComplexColorCompat mStrokeColor;
        android.graphics.Paint.Cap mStrokeLineCap;
        android.graphics.Paint.Join mStrokeLineJoin;
        float mStrokeMiterlimit;
        float mStrokeWidth;
        private int[] mThemeAttrs;
        float mTrimPathEnd;
        float mTrimPathOffset;
        float mTrimPathStart;

        public VFullPath() {
            this.mStrokeWidth = 0.0f;
            this.mStrokeAlpha = 1.0f;
            this.mFillAlpha = 1.0f;
            this.mTrimPathStart = 0.0f;
            this.mTrimPathEnd = 1.0f;
            this.mTrimPathOffset = 0.0f;
            this.mStrokeLineCap = android.graphics.Paint.Cap.BUTT;
            this.mStrokeLineJoin = android.graphics.Paint.Join.MITER;
            this.mStrokeMiterlimit = 4.0f;
        }

        public VFullPath(androidx.vectordrawable.graphics.drawable.VectorDrawableCompat.VFullPath vFullPath) {
            super(vFullPath);
            this.mStrokeWidth = 0.0f;
            this.mStrokeAlpha = 1.0f;
            this.mFillAlpha = 1.0f;
            this.mTrimPathStart = 0.0f;
            this.mTrimPathEnd = 1.0f;
            this.mTrimPathOffset = 0.0f;
            this.mStrokeLineCap = android.graphics.Paint.Cap.BUTT;
            this.mStrokeLineJoin = android.graphics.Paint.Join.MITER;
            this.mStrokeMiterlimit = 4.0f;
            this.mThemeAttrs = vFullPath.mThemeAttrs;
            this.mStrokeColor = vFullPath.mStrokeColor;
            this.mStrokeWidth = vFullPath.mStrokeWidth;
            this.mStrokeAlpha = vFullPath.mStrokeAlpha;
            this.mFillColor = vFullPath.mFillColor;
            this.mFillRule = vFullPath.mFillRule;
            this.mFillAlpha = vFullPath.mFillAlpha;
            this.mTrimPathStart = vFullPath.mTrimPathStart;
            this.mTrimPathEnd = vFullPath.mTrimPathEnd;
            this.mTrimPathOffset = vFullPath.mTrimPathOffset;
            this.mStrokeLineCap = vFullPath.mStrokeLineCap;
            this.mStrokeLineJoin = vFullPath.mStrokeLineJoin;
            this.mStrokeMiterlimit = vFullPath.mStrokeMiterlimit;
        }

        private android.graphics.Paint.Cap getStrokeLineCap(int i, android.graphics.Paint.Cap cap) {
            return i != 0 ? i != 1 ? i != 2 ? cap : android.graphics.Paint.Cap.SQUARE : android.graphics.Paint.Cap.ROUND : android.graphics.Paint.Cap.BUTT;
        }

        private android.graphics.Paint.Join getStrokeLineJoin(int i, android.graphics.Paint.Join join) {
            return i != 0 ? i != 1 ? i != 2 ? join : android.graphics.Paint.Join.BEVEL : android.graphics.Paint.Join.ROUND : android.graphics.Paint.Join.MITER;
        }

        private void updateStateFromTypedArray(android.content.res.TypedArray typedArray, org.xmlpull.v1.XmlPullParser xmlPullParser, android.content.res.Resources.Theme theme) {
            this.mThemeAttrs = null;
            if (androidx.core.content.res.TypedArrayUtils.hasAttribute(xmlPullParser, "pathData")) {
                java.lang.String string = typedArray.getString(0);
                if (string != null) {
                    this.mPathName = string;
                }
                java.lang.String string2 = typedArray.getString(2);
                if (string2 != null) {
                    this.mNodes = androidx.core.graphics.PathParser.createNodesFromPathData(string2);
                }
                this.mFillColor = androidx.core.content.res.TypedArrayUtils.getNamedComplexColor(typedArray, xmlPullParser, theme, "fillColor", 1, 0);
                this.mFillAlpha = androidx.core.content.res.TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "fillAlpha", 12, this.mFillAlpha);
                this.mStrokeLineCap = getStrokeLineCap(androidx.core.content.res.TypedArrayUtils.getNamedInt(typedArray, xmlPullParser, "strokeLineCap", 8, -1), this.mStrokeLineCap);
                this.mStrokeLineJoin = getStrokeLineJoin(androidx.core.content.res.TypedArrayUtils.getNamedInt(typedArray, xmlPullParser, "strokeLineJoin", 9, -1), this.mStrokeLineJoin);
                this.mStrokeMiterlimit = androidx.core.content.res.TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "strokeMiterLimit", 10, this.mStrokeMiterlimit);
                this.mStrokeColor = androidx.core.content.res.TypedArrayUtils.getNamedComplexColor(typedArray, xmlPullParser, theme, "strokeColor", 3, 0);
                this.mStrokeAlpha = androidx.core.content.res.TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "strokeAlpha", 11, this.mStrokeAlpha);
                this.mStrokeWidth = androidx.core.content.res.TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "strokeWidth", 4, this.mStrokeWidth);
                this.mTrimPathEnd = androidx.core.content.res.TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "trimPathEnd", 6, this.mTrimPathEnd);
                this.mTrimPathOffset = androidx.core.content.res.TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "trimPathOffset", 7, this.mTrimPathOffset);
                this.mTrimPathStart = androidx.core.content.res.TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "trimPathStart", 5, this.mTrimPathStart);
                this.mFillRule = androidx.core.content.res.TypedArrayUtils.getNamedInt(typedArray, xmlPullParser, "fillType", 13, this.mFillRule);
            }
        }

        @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCompat.VPath
        public void applyTheme(android.content.res.Resources.Theme theme) {
        }

        @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCompat.VPath
        public boolean canApplyTheme() {
            return this.mThemeAttrs != null;
        }

        public float getFillAlpha() {
            return this.mFillAlpha;
        }

        @androidx.annotation.ColorInt
        public int getFillColor() {
            return this.mFillColor.getColor();
        }

        public float getStrokeAlpha() {
            return this.mStrokeAlpha;
        }

        @androidx.annotation.ColorInt
        public int getStrokeColor() {
            return this.mStrokeColor.getColor();
        }

        public float getStrokeWidth() {
            return this.mStrokeWidth;
        }

        public float getTrimPathEnd() {
            return this.mTrimPathEnd;
        }

        public float getTrimPathOffset() {
            return this.mTrimPathOffset;
        }

        public float getTrimPathStart() {
            return this.mTrimPathStart;
        }

        public void inflate(android.content.res.Resources resources, android.util.AttributeSet attributeSet, android.content.res.Resources.Theme theme, org.xmlpull.v1.XmlPullParser xmlPullParser) {
            android.content.res.TypedArray obtainAttributes = androidx.core.content.res.TypedArrayUtils.obtainAttributes(resources, theme, attributeSet, androidx.vectordrawable.graphics.drawable.AndroidResources.STYLEABLE_VECTOR_DRAWABLE_PATH);
            updateStateFromTypedArray(obtainAttributes, xmlPullParser, theme);
            obtainAttributes.recycle();
        }

        @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCompat.VObject
        public boolean isStateful() {
            return this.mFillColor.isStateful() || this.mStrokeColor.isStateful();
        }

        @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCompat.VObject
        public boolean onStateChanged(int[] iArr) {
            return this.mStrokeColor.onStateChanged(iArr) | this.mFillColor.onStateChanged(iArr);
        }

        public void setFillAlpha(float f) {
            this.mFillAlpha = f;
        }

        public void setFillColor(int i) {
            this.mFillColor.setColor(i);
        }

        public void setStrokeAlpha(float f) {
            this.mStrokeAlpha = f;
        }

        public void setStrokeColor(int i) {
            this.mStrokeColor.setColor(i);
        }

        public void setStrokeWidth(float f) {
            this.mStrokeWidth = f;
        }

        public void setTrimPathEnd(float f) {
            this.mTrimPathEnd = f;
        }

        public void setTrimPathOffset(float f) {
            this.mTrimPathOffset = f;
        }

        public void setTrimPathStart(float f) {
            this.mTrimPathStart = f;
        }
    }

    public static class VGroup extends androidx.vectordrawable.graphics.drawable.VectorDrawableCompat.VObject {
        int mChangingConfigurations;
        final java.util.ArrayList<androidx.vectordrawable.graphics.drawable.VectorDrawableCompat.VObject> mChildren;
        private java.lang.String mGroupName;
        final android.graphics.Matrix mLocalMatrix;
        private float mPivotX;
        private float mPivotY;
        float mRotate;
        private float mScaleX;
        private float mScaleY;
        final android.graphics.Matrix mStackedMatrix;
        private int[] mThemeAttrs;
        private float mTranslateX;
        private float mTranslateY;

        public VGroup() {
            super(null);
            this.mStackedMatrix = new android.graphics.Matrix();
            this.mChildren = new java.util.ArrayList<>();
            this.mRotate = 0.0f;
            this.mPivotX = 0.0f;
            this.mPivotY = 0.0f;
            this.mScaleX = 1.0f;
            this.mScaleY = 1.0f;
            this.mTranslateX = 0.0f;
            this.mTranslateY = 0.0f;
            this.mLocalMatrix = new android.graphics.Matrix();
            this.mGroupName = null;
        }

        public VGroup(androidx.vectordrawable.graphics.drawable.VectorDrawableCompat.VGroup vGroup, androidx.collection.ArrayMap<java.lang.String, java.lang.Object> arrayMap) {
            super(null);
            androidx.vectordrawable.graphics.drawable.VectorDrawableCompat.VPath vClipPath;
            this.mStackedMatrix = new android.graphics.Matrix();
            this.mChildren = new java.util.ArrayList<>();
            this.mRotate = 0.0f;
            this.mPivotX = 0.0f;
            this.mPivotY = 0.0f;
            this.mScaleX = 1.0f;
            this.mScaleY = 1.0f;
            this.mTranslateX = 0.0f;
            this.mTranslateY = 0.0f;
            android.graphics.Matrix matrix = new android.graphics.Matrix();
            this.mLocalMatrix = matrix;
            this.mGroupName = null;
            this.mRotate = vGroup.mRotate;
            this.mPivotX = vGroup.mPivotX;
            this.mPivotY = vGroup.mPivotY;
            this.mScaleX = vGroup.mScaleX;
            this.mScaleY = vGroup.mScaleY;
            this.mTranslateX = vGroup.mTranslateX;
            this.mTranslateY = vGroup.mTranslateY;
            this.mThemeAttrs = vGroup.mThemeAttrs;
            java.lang.String str = vGroup.mGroupName;
            this.mGroupName = str;
            this.mChangingConfigurations = vGroup.mChangingConfigurations;
            if (str != null) {
                arrayMap.put(str, this);
            }
            matrix.set(vGroup.mLocalMatrix);
            java.util.ArrayList<androidx.vectordrawable.graphics.drawable.VectorDrawableCompat.VObject> arrayList = vGroup.mChildren;
            for (int i = 0; i < arrayList.size(); i++) {
                androidx.vectordrawable.graphics.drawable.VectorDrawableCompat.VObject vObject = arrayList.get(i);
                if (vObject instanceof androidx.vectordrawable.graphics.drawable.VectorDrawableCompat.VGroup) {
                    this.mChildren.add(new androidx.vectordrawable.graphics.drawable.VectorDrawableCompat.VGroup((androidx.vectordrawable.graphics.drawable.VectorDrawableCompat.VGroup) vObject, arrayMap));
                } else {
                    if (vObject instanceof androidx.vectordrawable.graphics.drawable.VectorDrawableCompat.VFullPath) {
                        vClipPath = new androidx.vectordrawable.graphics.drawable.VectorDrawableCompat.VFullPath((androidx.vectordrawable.graphics.drawable.VectorDrawableCompat.VFullPath) vObject);
                    } else {
                        if (!(vObject instanceof androidx.vectordrawable.graphics.drawable.VectorDrawableCompat.VClipPath)) {
                            throw new java.lang.IllegalStateException("Unknown object in the tree!");
                        }
                        vClipPath = new androidx.vectordrawable.graphics.drawable.VectorDrawableCompat.VClipPath((androidx.vectordrawable.graphics.drawable.VectorDrawableCompat.VClipPath) vObject);
                    }
                    this.mChildren.add(vClipPath);
                    java.lang.String str2 = vClipPath.mPathName;
                    if (str2 != null) {
                        arrayMap.put(str2, vClipPath);
                    }
                }
            }
        }

        private void updateLocalMatrix() {
            this.mLocalMatrix.reset();
            this.mLocalMatrix.postTranslate(-this.mPivotX, -this.mPivotY);
            this.mLocalMatrix.postScale(this.mScaleX, this.mScaleY);
            this.mLocalMatrix.postRotate(this.mRotate, 0.0f, 0.0f);
            this.mLocalMatrix.postTranslate(this.mTranslateX + this.mPivotX, this.mTranslateY + this.mPivotY);
        }

        private void updateStateFromTypedArray(android.content.res.TypedArray typedArray, org.xmlpull.v1.XmlPullParser xmlPullParser) {
            this.mThemeAttrs = null;
            this.mRotate = androidx.core.content.res.TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "rotation", 5, this.mRotate);
            this.mPivotX = typedArray.getFloat(1, this.mPivotX);
            this.mPivotY = typedArray.getFloat(2, this.mPivotY);
            this.mScaleX = androidx.core.content.res.TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "scaleX", 3, this.mScaleX);
            this.mScaleY = androidx.core.content.res.TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "scaleY", 4, this.mScaleY);
            this.mTranslateX = androidx.core.content.res.TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "translateX", 6, this.mTranslateX);
            this.mTranslateY = androidx.core.content.res.TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "translateY", 7, this.mTranslateY);
            java.lang.String string = typedArray.getString(0);
            if (string != null) {
                this.mGroupName = string;
            }
            updateLocalMatrix();
        }

        public java.lang.String getGroupName() {
            return this.mGroupName;
        }

        public android.graphics.Matrix getLocalMatrix() {
            return this.mLocalMatrix;
        }

        public float getPivotX() {
            return this.mPivotX;
        }

        public float getPivotY() {
            return this.mPivotY;
        }

        public float getRotation() {
            return this.mRotate;
        }

        public float getScaleX() {
            return this.mScaleX;
        }

        public float getScaleY() {
            return this.mScaleY;
        }

        public float getTranslateX() {
            return this.mTranslateX;
        }

        public float getTranslateY() {
            return this.mTranslateY;
        }

        public void inflate(android.content.res.Resources resources, android.util.AttributeSet attributeSet, android.content.res.Resources.Theme theme, org.xmlpull.v1.XmlPullParser xmlPullParser) {
            android.content.res.TypedArray obtainAttributes = androidx.core.content.res.TypedArrayUtils.obtainAttributes(resources, theme, attributeSet, androidx.vectordrawable.graphics.drawable.AndroidResources.STYLEABLE_VECTOR_DRAWABLE_GROUP);
            updateStateFromTypedArray(obtainAttributes, xmlPullParser);
            obtainAttributes.recycle();
        }

        @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCompat.VObject
        public boolean isStateful() {
            for (int i = 0; i < this.mChildren.size(); i++) {
                if (this.mChildren.get(i).isStateful()) {
                    return true;
                }
            }
            return false;
        }

        @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCompat.VObject
        public boolean onStateChanged(int[] iArr) {
            boolean z = false;
            for (int i = 0; i < this.mChildren.size(); i++) {
                z |= this.mChildren.get(i).onStateChanged(iArr);
            }
            return z;
        }

        public void setPivotX(float f) {
            if (f != this.mPivotX) {
                this.mPivotX = f;
                updateLocalMatrix();
            }
        }

        public void setPivotY(float f) {
            if (f != this.mPivotY) {
                this.mPivotY = f;
                updateLocalMatrix();
            }
        }

        public void setRotation(float f) {
            if (f != this.mRotate) {
                this.mRotate = f;
                updateLocalMatrix();
            }
        }

        public void setScaleX(float f) {
            if (f != this.mScaleX) {
                this.mScaleX = f;
                updateLocalMatrix();
            }
        }

        public void setScaleY(float f) {
            if (f != this.mScaleY) {
                this.mScaleY = f;
                updateLocalMatrix();
            }
        }

        public void setTranslateX(float f) {
            if (f != this.mTranslateX) {
                this.mTranslateX = f;
                updateLocalMatrix();
            }
        }

        public void setTranslateY(float f) {
            if (f != this.mTranslateY) {
                this.mTranslateY = f;
                updateLocalMatrix();
            }
        }
    }

    public static abstract class VObject {
        private VObject() {
        }

        public /* synthetic */ VObject(androidx.vectordrawable.graphics.drawable.VectorDrawableCompat.AnonymousClass1 anonymousClass1) {
            this();
        }

        public boolean isStateful() {
            return false;
        }

        public boolean onStateChanged(int[] iArr) {
            return false;
        }
    }

    public static abstract class VPath extends androidx.vectordrawable.graphics.drawable.VectorDrawableCompat.VObject {
        protected static final int FILL_TYPE_WINDING = 0;
        int mChangingConfigurations;
        int mFillRule;
        protected androidx.core.graphics.PathParser.PathDataNode[] mNodes;
        java.lang.String mPathName;

        public VPath() {
            super(null);
            this.mNodes = null;
            this.mFillRule = 0;
        }

        public VPath(androidx.vectordrawable.graphics.drawable.VectorDrawableCompat.VPath vPath) {
            super(null);
            this.mNodes = null;
            this.mFillRule = 0;
            this.mPathName = vPath.mPathName;
            this.mChangingConfigurations = vPath.mChangingConfigurations;
            this.mNodes = androidx.core.graphics.PathParser.deepCopyNodes(vPath.mNodes);
        }

        public void applyTheme(android.content.res.Resources.Theme theme) {
        }

        public boolean canApplyTheme() {
            return false;
        }

        public androidx.core.graphics.PathParser.PathDataNode[] getPathData() {
            return this.mNodes;
        }

        public java.lang.String getPathName() {
            return this.mPathName;
        }

        public boolean isClipPath() {
            return false;
        }

        public java.lang.String nodesToString(androidx.core.graphics.PathParser.PathDataNode[] pathDataNodeArr) {
            java.lang.String str = " ";
            for (int i = 0; i < pathDataNodeArr.length; i++) {
                str = str + pathDataNodeArr[i].mType + com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR;
                for (float f : pathDataNodeArr[i].mParams) {
                    str = str + f + ",";
                }
            }
            return str;
        }

        public void printVPath(int i) {
            java.lang.String str = "";
            for (int i2 = 0; i2 < i; i2++) {
                str = str + "    ";
            }
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append(str);
            sb.append("current path is :");
            sb.append(this.mPathName);
            sb.append(" pathData is ");
            sb.append(nodesToString(this.mNodes));
        }

        public void setPathData(androidx.core.graphics.PathParser.PathDataNode[] pathDataNodeArr) {
            if (androidx.core.graphics.PathParser.canMorph(this.mNodes, pathDataNodeArr)) {
                androidx.core.graphics.PathParser.updateNodes(this.mNodes, pathDataNodeArr);
            } else {
                this.mNodes = androidx.core.graphics.PathParser.deepCopyNodes(pathDataNodeArr);
            }
        }

        public void toPath(android.graphics.Path path) {
            path.reset();
            androidx.core.graphics.PathParser.PathDataNode[] pathDataNodeArr = this.mNodes;
            if (pathDataNodeArr != null) {
                androidx.core.graphics.PathParser.PathDataNode.nodesToPath(pathDataNodeArr, path);
            }
        }
    }

    public static class VPathRenderer {
        private static final android.graphics.Matrix IDENTITY_MATRIX = new android.graphics.Matrix();
        float mBaseHeight;
        float mBaseWidth;
        private int mChangingConfigurations;
        android.graphics.Paint mFillPaint;
        private final android.graphics.Matrix mFinalPathMatrix;
        java.lang.Boolean mIsStateful;
        private final android.graphics.Path mPath;
        private android.graphics.PathMeasure mPathMeasure;
        private final android.graphics.Path mRenderPath;
        int mRootAlpha;
        final androidx.vectordrawable.graphics.drawable.VectorDrawableCompat.VGroup mRootGroup;
        java.lang.String mRootName;
        android.graphics.Paint mStrokePaint;
        final androidx.collection.ArrayMap<java.lang.String, java.lang.Object> mVGTargetsMap;
        float mViewportHeight;
        float mViewportWidth;

        public VPathRenderer() {
            this.mFinalPathMatrix = new android.graphics.Matrix();
            this.mBaseWidth = 0.0f;
            this.mBaseHeight = 0.0f;
            this.mViewportWidth = 0.0f;
            this.mViewportHeight = 0.0f;
            this.mRootAlpha = 255;
            this.mRootName = null;
            this.mIsStateful = null;
            this.mVGTargetsMap = new androidx.collection.ArrayMap<>();
            this.mRootGroup = new androidx.vectordrawable.graphics.drawable.VectorDrawableCompat.VGroup();
            this.mPath = new android.graphics.Path();
            this.mRenderPath = new android.graphics.Path();
        }

        public VPathRenderer(androidx.vectordrawable.graphics.drawable.VectorDrawableCompat.VPathRenderer vPathRenderer) {
            this.mFinalPathMatrix = new android.graphics.Matrix();
            this.mBaseWidth = 0.0f;
            this.mBaseHeight = 0.0f;
            this.mViewportWidth = 0.0f;
            this.mViewportHeight = 0.0f;
            this.mRootAlpha = 255;
            this.mRootName = null;
            this.mIsStateful = null;
            androidx.collection.ArrayMap<java.lang.String, java.lang.Object> arrayMap = new androidx.collection.ArrayMap<>();
            this.mVGTargetsMap = arrayMap;
            this.mRootGroup = new androidx.vectordrawable.graphics.drawable.VectorDrawableCompat.VGroup(vPathRenderer.mRootGroup, arrayMap);
            this.mPath = new android.graphics.Path(vPathRenderer.mPath);
            this.mRenderPath = new android.graphics.Path(vPathRenderer.mRenderPath);
            this.mBaseWidth = vPathRenderer.mBaseWidth;
            this.mBaseHeight = vPathRenderer.mBaseHeight;
            this.mViewportWidth = vPathRenderer.mViewportWidth;
            this.mViewportHeight = vPathRenderer.mViewportHeight;
            this.mChangingConfigurations = vPathRenderer.mChangingConfigurations;
            this.mRootAlpha = vPathRenderer.mRootAlpha;
            this.mRootName = vPathRenderer.mRootName;
            java.lang.String str = vPathRenderer.mRootName;
            if (str != null) {
                arrayMap.put(str, this);
            }
            this.mIsStateful = vPathRenderer.mIsStateful;
        }

        private static float cross(float f, float f2, float f3, float f4) {
            return (f * f4) - (f2 * f3);
        }

        private void drawGroupTree(androidx.vectordrawable.graphics.drawable.VectorDrawableCompat.VGroup vGroup, android.graphics.Matrix matrix, android.graphics.Canvas canvas, int i, int i2, android.graphics.ColorFilter colorFilter) {
            vGroup.mStackedMatrix.set(matrix);
            vGroup.mStackedMatrix.preConcat(vGroup.mLocalMatrix);
            canvas.save();
            for (int i3 = 0; i3 < vGroup.mChildren.size(); i3++) {
                androidx.vectordrawable.graphics.drawable.VectorDrawableCompat.VObject vObject = vGroup.mChildren.get(i3);
                if (vObject instanceof androidx.vectordrawable.graphics.drawable.VectorDrawableCompat.VGroup) {
                    drawGroupTree((androidx.vectordrawable.graphics.drawable.VectorDrawableCompat.VGroup) vObject, vGroup.mStackedMatrix, canvas, i, i2, colorFilter);
                } else if (vObject instanceof androidx.vectordrawable.graphics.drawable.VectorDrawableCompat.VPath) {
                    drawPath(vGroup, (androidx.vectordrawable.graphics.drawable.VectorDrawableCompat.VPath) vObject, canvas, i, i2, colorFilter);
                }
            }
            canvas.restore();
        }

        private void drawPath(androidx.vectordrawable.graphics.drawable.VectorDrawableCompat.VGroup vGroup, androidx.vectordrawable.graphics.drawable.VectorDrawableCompat.VPath vPath, android.graphics.Canvas canvas, int i, int i2, android.graphics.ColorFilter colorFilter) {
            float f = i / this.mViewportWidth;
            float f2 = i2 / this.mViewportHeight;
            float min = java.lang.Math.min(f, f2);
            android.graphics.Matrix matrix = vGroup.mStackedMatrix;
            this.mFinalPathMatrix.set(matrix);
            this.mFinalPathMatrix.postScale(f, f2);
            float matrixScale = getMatrixScale(matrix);
            if (matrixScale == 0.0f) {
                return;
            }
            vPath.toPath(this.mPath);
            android.graphics.Path path = this.mPath;
            this.mRenderPath.reset();
            if (vPath.isClipPath()) {
                this.mRenderPath.setFillType(vPath.mFillRule == 0 ? android.graphics.Path.FillType.WINDING : android.graphics.Path.FillType.EVEN_ODD);
                this.mRenderPath.addPath(path, this.mFinalPathMatrix);
                canvas.clipPath(this.mRenderPath);
                return;
            }
            androidx.vectordrawable.graphics.drawable.VectorDrawableCompat.VFullPath vFullPath = (androidx.vectordrawable.graphics.drawable.VectorDrawableCompat.VFullPath) vPath;
            float f3 = vFullPath.mTrimPathStart;
            if (f3 != 0.0f || vFullPath.mTrimPathEnd != 1.0f) {
                float f4 = vFullPath.mTrimPathOffset;
                float f5 = (f3 + f4) % 1.0f;
                float f6 = (vFullPath.mTrimPathEnd + f4) % 1.0f;
                if (this.mPathMeasure == null) {
                    this.mPathMeasure = new android.graphics.PathMeasure();
                }
                this.mPathMeasure.setPath(this.mPath, false);
                float length = this.mPathMeasure.getLength();
                float f7 = f5 * length;
                float f8 = f6 * length;
                path.reset();
                if (f7 > f8) {
                    this.mPathMeasure.getSegment(f7, length, path, true);
                    this.mPathMeasure.getSegment(0.0f, f8, path, true);
                } else {
                    this.mPathMeasure.getSegment(f7, f8, path, true);
                }
                path.rLineTo(0.0f, 0.0f);
            }
            this.mRenderPath.addPath(path, this.mFinalPathMatrix);
            if (vFullPath.mFillColor.willDraw()) {
                androidx.core.content.res.ComplexColorCompat complexColorCompat = vFullPath.mFillColor;
                if (this.mFillPaint == null) {
                    android.graphics.Paint paint = new android.graphics.Paint(1);
                    this.mFillPaint = paint;
                    paint.setStyle(android.graphics.Paint.Style.FILL);
                }
                android.graphics.Paint paint2 = this.mFillPaint;
                if (complexColorCompat.isGradient()) {
                    android.graphics.Shader shader = complexColorCompat.getShader();
                    shader.setLocalMatrix(this.mFinalPathMatrix);
                    paint2.setShader(shader);
                    paint2.setAlpha(java.lang.Math.round(vFullPath.mFillAlpha * 255.0f));
                } else {
                    paint2.setShader(null);
                    paint2.setAlpha(255);
                    paint2.setColor(androidx.vectordrawable.graphics.drawable.VectorDrawableCompat.applyAlpha(complexColorCompat.getColor(), vFullPath.mFillAlpha));
                }
                paint2.setColorFilter(colorFilter);
                this.mRenderPath.setFillType(vFullPath.mFillRule == 0 ? android.graphics.Path.FillType.WINDING : android.graphics.Path.FillType.EVEN_ODD);
                canvas.drawPath(this.mRenderPath, paint2);
            }
            if (vFullPath.mStrokeColor.willDraw()) {
                androidx.core.content.res.ComplexColorCompat complexColorCompat2 = vFullPath.mStrokeColor;
                if (this.mStrokePaint == null) {
                    android.graphics.Paint paint3 = new android.graphics.Paint(1);
                    this.mStrokePaint = paint3;
                    paint3.setStyle(android.graphics.Paint.Style.STROKE);
                }
                android.graphics.Paint paint4 = this.mStrokePaint;
                android.graphics.Paint.Join join = vFullPath.mStrokeLineJoin;
                if (join != null) {
                    paint4.setStrokeJoin(join);
                }
                android.graphics.Paint.Cap cap = vFullPath.mStrokeLineCap;
                if (cap != null) {
                    paint4.setStrokeCap(cap);
                }
                paint4.setStrokeMiter(vFullPath.mStrokeMiterlimit);
                if (complexColorCompat2.isGradient()) {
                    android.graphics.Shader shader2 = complexColorCompat2.getShader();
                    shader2.setLocalMatrix(this.mFinalPathMatrix);
                    paint4.setShader(shader2);
                    paint4.setAlpha(java.lang.Math.round(vFullPath.mStrokeAlpha * 255.0f));
                } else {
                    paint4.setShader(null);
                    paint4.setAlpha(255);
                    paint4.setColor(androidx.vectordrawable.graphics.drawable.VectorDrawableCompat.applyAlpha(complexColorCompat2.getColor(), vFullPath.mStrokeAlpha));
                }
                paint4.setColorFilter(colorFilter);
                paint4.setStrokeWidth(vFullPath.mStrokeWidth * min * matrixScale);
                canvas.drawPath(this.mRenderPath, paint4);
            }
        }

        private float getMatrixScale(android.graphics.Matrix matrix) {
            float[] fArr = {0.0f, 1.0f, 1.0f, 0.0f};
            matrix.mapVectors(fArr);
            float hypot = (float) java.lang.Math.hypot(fArr[0], fArr[1]);
            float hypot2 = (float) java.lang.Math.hypot(fArr[2], fArr[3]);
            float cross = cross(fArr[0], fArr[1], fArr[2], fArr[3]);
            float max = java.lang.Math.max(hypot, hypot2);
            if (max > 0.0f) {
                return java.lang.Math.abs(cross) / max;
            }
            return 0.0f;
        }

        public void draw(android.graphics.Canvas canvas, int i, int i2, android.graphics.ColorFilter colorFilter) {
            drawGroupTree(this.mRootGroup, IDENTITY_MATRIX, canvas, i, i2, colorFilter);
        }

        public float getAlpha() {
            return getRootAlpha() / 255.0f;
        }

        public int getRootAlpha() {
            return this.mRootAlpha;
        }

        public boolean isStateful() {
            if (this.mIsStateful == null) {
                this.mIsStateful = java.lang.Boolean.valueOf(this.mRootGroup.isStateful());
            }
            return this.mIsStateful.booleanValue();
        }

        public boolean onStateChanged(int[] iArr) {
            return this.mRootGroup.onStateChanged(iArr);
        }

        public void setAlpha(float f) {
            setRootAlpha((int) (f * 255.0f));
        }

        public void setRootAlpha(int i) {
            this.mRootAlpha = i;
        }
    }

    public static class VectorDrawableCompatState extends android.graphics.drawable.Drawable.ConstantState {
        boolean mAutoMirrored;
        boolean mCacheDirty;
        boolean mCachedAutoMirrored;
        android.graphics.Bitmap mCachedBitmap;
        int mCachedRootAlpha;
        int[] mCachedThemeAttrs;
        android.content.res.ColorStateList mCachedTint;
        android.graphics.PorterDuff.Mode mCachedTintMode;
        int mChangingConfigurations;
        android.graphics.Paint mTempPaint;
        android.content.res.ColorStateList mTint;
        android.graphics.PorterDuff.Mode mTintMode;
        androidx.vectordrawable.graphics.drawable.VectorDrawableCompat.VPathRenderer mVPathRenderer;

        public VectorDrawableCompatState() {
            this.mTint = null;
            this.mTintMode = androidx.vectordrawable.graphics.drawable.VectorDrawableCompat.DEFAULT_TINT_MODE;
            this.mVPathRenderer = new androidx.vectordrawable.graphics.drawable.VectorDrawableCompat.VPathRenderer();
        }

        public VectorDrawableCompatState(androidx.vectordrawable.graphics.drawable.VectorDrawableCompat.VectorDrawableCompatState vectorDrawableCompatState) {
            this.mTint = null;
            this.mTintMode = androidx.vectordrawable.graphics.drawable.VectorDrawableCompat.DEFAULT_TINT_MODE;
            if (vectorDrawableCompatState != null) {
                this.mChangingConfigurations = vectorDrawableCompatState.mChangingConfigurations;
                androidx.vectordrawable.graphics.drawable.VectorDrawableCompat.VPathRenderer vPathRenderer = new androidx.vectordrawable.graphics.drawable.VectorDrawableCompat.VPathRenderer(vectorDrawableCompatState.mVPathRenderer);
                this.mVPathRenderer = vPathRenderer;
                if (vectorDrawableCompatState.mVPathRenderer.mFillPaint != null) {
                    vPathRenderer.mFillPaint = new android.graphics.Paint(vectorDrawableCompatState.mVPathRenderer.mFillPaint);
                }
                if (vectorDrawableCompatState.mVPathRenderer.mStrokePaint != null) {
                    this.mVPathRenderer.mStrokePaint = new android.graphics.Paint(vectorDrawableCompatState.mVPathRenderer.mStrokePaint);
                }
                this.mTint = vectorDrawableCompatState.mTint;
                this.mTintMode = vectorDrawableCompatState.mTintMode;
                this.mAutoMirrored = vectorDrawableCompatState.mAutoMirrored;
            }
        }

        public boolean canReuseBitmap(int i, int i2) {
            return i == this.mCachedBitmap.getWidth() && i2 == this.mCachedBitmap.getHeight();
        }

        public boolean canReuseCache() {
            return !this.mCacheDirty && this.mCachedTint == this.mTint && this.mCachedTintMode == this.mTintMode && this.mCachedAutoMirrored == this.mAutoMirrored && this.mCachedRootAlpha == this.mVPathRenderer.getRootAlpha();
        }

        public void createCachedBitmapIfNeeded(int i, int i2) {
            if (this.mCachedBitmap == null || !canReuseBitmap(i, i2)) {
                this.mCachedBitmap = android.graphics.Bitmap.createBitmap(i, i2, android.graphics.Bitmap.Config.ARGB_8888);
                this.mCacheDirty = true;
            }
        }

        public void drawCachedBitmapWithRootAlpha(android.graphics.Canvas canvas, android.graphics.ColorFilter colorFilter, android.graphics.Rect rect) {
            canvas.drawBitmap(this.mCachedBitmap, (android.graphics.Rect) null, rect, getPaint(colorFilter));
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.mChangingConfigurations;
        }

        public android.graphics.Paint getPaint(android.graphics.ColorFilter colorFilter) {
            if (!hasTranslucentRoot() && colorFilter == null) {
                return null;
            }
            if (this.mTempPaint == null) {
                android.graphics.Paint paint = new android.graphics.Paint();
                this.mTempPaint = paint;
                paint.setFilterBitmap(true);
            }
            this.mTempPaint.setAlpha(this.mVPathRenderer.getRootAlpha());
            this.mTempPaint.setColorFilter(colorFilter);
            return this.mTempPaint;
        }

        public boolean hasTranslucentRoot() {
            return this.mVPathRenderer.getRootAlpha() < 255;
        }

        public boolean isStateful() {
            return this.mVPathRenderer.isStateful();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        @androidx.annotation.NonNull
        public android.graphics.drawable.Drawable newDrawable() {
            return new androidx.vectordrawable.graphics.drawable.VectorDrawableCompat(this);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        @androidx.annotation.NonNull
        public android.graphics.drawable.Drawable newDrawable(android.content.res.Resources resources) {
            return new androidx.vectordrawable.graphics.drawable.VectorDrawableCompat(this);
        }

        public boolean onStateChanged(int[] iArr) {
            boolean onStateChanged = this.mVPathRenderer.onStateChanged(iArr);
            this.mCacheDirty |= onStateChanged;
            return onStateChanged;
        }

        public void updateCacheStates() {
            this.mCachedTint = this.mTint;
            this.mCachedTintMode = this.mTintMode;
            this.mCachedRootAlpha = this.mVPathRenderer.getRootAlpha();
            this.mCachedAutoMirrored = this.mAutoMirrored;
            this.mCacheDirty = false;
        }

        public void updateCachedBitmap(int i, int i2) {
            this.mCachedBitmap.eraseColor(0);
            this.mVPathRenderer.draw(new android.graphics.Canvas(this.mCachedBitmap), i, i2, null);
        }
    }

    @androidx.annotation.RequiresApi(24)
    public static class VectorDrawableDelegateState extends android.graphics.drawable.Drawable.ConstantState {
        private final android.graphics.drawable.Drawable.ConstantState mDelegateState;

        public VectorDrawableDelegateState(android.graphics.drawable.Drawable.ConstantState constantState) {
            this.mDelegateState = constantState;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public boolean canApplyTheme() {
            return this.mDelegateState.canApplyTheme();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.mDelegateState.getChangingConfigurations();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public android.graphics.drawable.Drawable newDrawable() {
            androidx.vectordrawable.graphics.drawable.VectorDrawableCompat vectorDrawableCompat = new androidx.vectordrawable.graphics.drawable.VectorDrawableCompat();
            vectorDrawableCompat.mDelegateDrawable = (android.graphics.drawable.VectorDrawable) this.mDelegateState.newDrawable();
            return vectorDrawableCompat;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public android.graphics.drawable.Drawable newDrawable(android.content.res.Resources resources) {
            androidx.vectordrawable.graphics.drawable.VectorDrawableCompat vectorDrawableCompat = new androidx.vectordrawable.graphics.drawable.VectorDrawableCompat();
            vectorDrawableCompat.mDelegateDrawable = (android.graphics.drawable.VectorDrawable) this.mDelegateState.newDrawable(resources);
            return vectorDrawableCompat;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public android.graphics.drawable.Drawable newDrawable(android.content.res.Resources resources, android.content.res.Resources.Theme theme) {
            androidx.vectordrawable.graphics.drawable.VectorDrawableCompat vectorDrawableCompat = new androidx.vectordrawable.graphics.drawable.VectorDrawableCompat();
            vectorDrawableCompat.mDelegateDrawable = (android.graphics.drawable.VectorDrawable) this.mDelegateState.newDrawable(resources, theme);
            return vectorDrawableCompat;
        }
    }

    public VectorDrawableCompat() {
        this.mAllowCaching = true;
        this.mTmpFloats = new float[9];
        this.mTmpMatrix = new android.graphics.Matrix();
        this.mTmpBounds = new android.graphics.Rect();
        this.mVectorState = new androidx.vectordrawable.graphics.drawable.VectorDrawableCompat.VectorDrawableCompatState();
    }

    public VectorDrawableCompat(@androidx.annotation.NonNull androidx.vectordrawable.graphics.drawable.VectorDrawableCompat.VectorDrawableCompatState vectorDrawableCompatState) {
        this.mAllowCaching = true;
        this.mTmpFloats = new float[9];
        this.mTmpMatrix = new android.graphics.Matrix();
        this.mTmpBounds = new android.graphics.Rect();
        this.mVectorState = vectorDrawableCompatState;
        this.mTintFilter = updateTintFilter(this.mTintFilter, vectorDrawableCompatState.mTint, vectorDrawableCompatState.mTintMode);
    }

    public static int applyAlpha(int i, float f) {
        return (i & 16777215) | (((int) (android.graphics.Color.alpha(i) * f)) << 24);
    }

    @androidx.annotation.Nullable
    public static androidx.vectordrawable.graphics.drawable.VectorDrawableCompat create(@androidx.annotation.NonNull android.content.res.Resources resources, @androidx.annotation.DrawableRes int i, @androidx.annotation.Nullable android.content.res.Resources.Theme theme) {
        int next;
        if (android.os.Build.VERSION.SDK_INT >= 24) {
            androidx.vectordrawable.graphics.drawable.VectorDrawableCompat vectorDrawableCompat = new androidx.vectordrawable.graphics.drawable.VectorDrawableCompat();
            vectorDrawableCompat.mDelegateDrawable = androidx.core.content.res.ResourcesCompat.getDrawable(resources, i, theme);
            vectorDrawableCompat.mCachedConstantStateDelegate = new androidx.vectordrawable.graphics.drawable.VectorDrawableCompat.VectorDrawableDelegateState(vectorDrawableCompat.mDelegateDrawable.getConstantState());
            return vectorDrawableCompat;
        }
        try {
            android.content.res.XmlResourceParser xml = resources.getXml(i);
            android.util.AttributeSet asAttributeSet = android.util.Xml.asAttributeSet(xml);
            do {
                next = xml.next();
                if (next == 2) {
                    break;
                }
            } while (next != 1);
            if (next == 2) {
                return createFromXmlInner(resources, (org.xmlpull.v1.XmlPullParser) xml, asAttributeSet, theme);
            }
            throw new org.xmlpull.v1.XmlPullParserException("No start tag found");
        } catch (java.io.IOException | org.xmlpull.v1.XmlPullParserException unused) {
            return null;
        }
    }

    public static androidx.vectordrawable.graphics.drawable.VectorDrawableCompat createFromXmlInner(android.content.res.Resources resources, org.xmlpull.v1.XmlPullParser xmlPullParser, android.util.AttributeSet attributeSet, android.content.res.Resources.Theme theme) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        androidx.vectordrawable.graphics.drawable.VectorDrawableCompat vectorDrawableCompat = new androidx.vectordrawable.graphics.drawable.VectorDrawableCompat();
        vectorDrawableCompat.inflate(resources, xmlPullParser, attributeSet, theme);
        return vectorDrawableCompat;
    }

    private void inflateInternal(android.content.res.Resources resources, org.xmlpull.v1.XmlPullParser xmlPullParser, android.util.AttributeSet attributeSet, android.content.res.Resources.Theme theme) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        androidx.vectordrawable.graphics.drawable.VectorDrawableCompat.VectorDrawableCompatState vectorDrawableCompatState = this.mVectorState;
        androidx.vectordrawable.graphics.drawable.VectorDrawableCompat.VPathRenderer vPathRenderer = vectorDrawableCompatState.mVPathRenderer;
        java.util.ArrayDeque arrayDeque = new java.util.ArrayDeque();
        arrayDeque.push(vPathRenderer.mRootGroup);
        int eventType = xmlPullParser.getEventType();
        int depth = xmlPullParser.getDepth() + 1;
        boolean z = true;
        while (eventType != 1 && (xmlPullParser.getDepth() >= depth || eventType != 3)) {
            if (eventType == 2) {
                java.lang.String name = xmlPullParser.getName();
                androidx.vectordrawable.graphics.drawable.VectorDrawableCompat.VGroup vGroup = (androidx.vectordrawable.graphics.drawable.VectorDrawableCompat.VGroup) arrayDeque.peek();
                if ("path".equals(name)) {
                    androidx.vectordrawable.graphics.drawable.VectorDrawableCompat.VFullPath vFullPath = new androidx.vectordrawable.graphics.drawable.VectorDrawableCompat.VFullPath();
                    vFullPath.inflate(resources, attributeSet, theme, xmlPullParser);
                    vGroup.mChildren.add(vFullPath);
                    if (vFullPath.getPathName() != null) {
                        vPathRenderer.mVGTargetsMap.put(vFullPath.getPathName(), vFullPath);
                    }
                    vectorDrawableCompatState.mChangingConfigurations = vFullPath.mChangingConfigurations | vectorDrawableCompatState.mChangingConfigurations;
                    z = false;
                } else if (SHAPE_CLIP_PATH.equals(name)) {
                    androidx.vectordrawable.graphics.drawable.VectorDrawableCompat.VClipPath vClipPath = new androidx.vectordrawable.graphics.drawable.VectorDrawableCompat.VClipPath();
                    vClipPath.inflate(resources, attributeSet, theme, xmlPullParser);
                    vGroup.mChildren.add(vClipPath);
                    if (vClipPath.getPathName() != null) {
                        vPathRenderer.mVGTargetsMap.put(vClipPath.getPathName(), vClipPath);
                    }
                    vectorDrawableCompatState.mChangingConfigurations = vClipPath.mChangingConfigurations | vectorDrawableCompatState.mChangingConfigurations;
                } else if (SHAPE_GROUP.equals(name)) {
                    androidx.vectordrawable.graphics.drawable.VectorDrawableCompat.VGroup vGroup2 = new androidx.vectordrawable.graphics.drawable.VectorDrawableCompat.VGroup();
                    vGroup2.inflate(resources, attributeSet, theme, xmlPullParser);
                    vGroup.mChildren.add(vGroup2);
                    arrayDeque.push(vGroup2);
                    if (vGroup2.getGroupName() != null) {
                        vPathRenderer.mVGTargetsMap.put(vGroup2.getGroupName(), vGroup2);
                    }
                    vectorDrawableCompatState.mChangingConfigurations = vGroup2.mChangingConfigurations | vectorDrawableCompatState.mChangingConfigurations;
                }
            } else if (eventType == 3 && SHAPE_GROUP.equals(xmlPullParser.getName())) {
                arrayDeque.pop();
            }
            eventType = xmlPullParser.next();
        }
        if (z) {
            throw new org.xmlpull.v1.XmlPullParserException("no path defined");
        }
    }

    private boolean needMirroring() {
        return isAutoMirrored() && androidx.core.graphics.drawable.DrawableCompat.getLayoutDirection(this) == 1;
    }

    private static android.graphics.PorterDuff.Mode parseTintModeCompat(int i, android.graphics.PorterDuff.Mode mode) {
        if (i == 3) {
            return android.graphics.PorterDuff.Mode.SRC_OVER;
        }
        if (i == 5) {
            return android.graphics.PorterDuff.Mode.SRC_IN;
        }
        if (i == 9) {
            return android.graphics.PorterDuff.Mode.SRC_ATOP;
        }
        switch (i) {
            case 14:
                return android.graphics.PorterDuff.Mode.MULTIPLY;
            case 15:
                return android.graphics.PorterDuff.Mode.SCREEN;
            case 16:
                return android.graphics.PorterDuff.Mode.ADD;
            default:
                return mode;
        }
    }

    private void printGroupTree(androidx.vectordrawable.graphics.drawable.VectorDrawableCompat.VGroup vGroup, int i) {
        java.lang.String str = "";
        for (int i2 = 0; i2 < i; i2++) {
            str = str + "    ";
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(str);
        sb.append("current group is :");
        sb.append(vGroup.getGroupName());
        sb.append(" rotation is ");
        sb.append(vGroup.mRotate);
        java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
        sb2.append(str);
        sb2.append("matrix is :");
        sb2.append(vGroup.getLocalMatrix().toString());
        for (int i3 = 0; i3 < vGroup.mChildren.size(); i3++) {
            androidx.vectordrawable.graphics.drawable.VectorDrawableCompat.VObject vObject = vGroup.mChildren.get(i3);
            if (vObject instanceof androidx.vectordrawable.graphics.drawable.VectorDrawableCompat.VGroup) {
                printGroupTree((androidx.vectordrawable.graphics.drawable.VectorDrawableCompat.VGroup) vObject, i + 1);
            } else {
                ((androidx.vectordrawable.graphics.drawable.VectorDrawableCompat.VPath) vObject).printVPath(i + 1);
            }
        }
    }

    private void updateStateFromTypedArray(android.content.res.TypedArray typedArray, org.xmlpull.v1.XmlPullParser xmlPullParser, android.content.res.Resources.Theme theme) throws org.xmlpull.v1.XmlPullParserException {
        androidx.vectordrawable.graphics.drawable.VectorDrawableCompat.VectorDrawableCompatState vectorDrawableCompatState = this.mVectorState;
        androidx.vectordrawable.graphics.drawable.VectorDrawableCompat.VPathRenderer vPathRenderer = vectorDrawableCompatState.mVPathRenderer;
        vectorDrawableCompatState.mTintMode = parseTintModeCompat(androidx.core.content.res.TypedArrayUtils.getNamedInt(typedArray, xmlPullParser, "tintMode", 6, -1), android.graphics.PorterDuff.Mode.SRC_IN);
        android.content.res.ColorStateList namedColorStateList = androidx.core.content.res.TypedArrayUtils.getNamedColorStateList(typedArray, xmlPullParser, theme, "tint", 1);
        if (namedColorStateList != null) {
            vectorDrawableCompatState.mTint = namedColorStateList;
        }
        vectorDrawableCompatState.mAutoMirrored = androidx.core.content.res.TypedArrayUtils.getNamedBoolean(typedArray, xmlPullParser, "autoMirrored", 5, vectorDrawableCompatState.mAutoMirrored);
        vPathRenderer.mViewportWidth = androidx.core.content.res.TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "viewportWidth", 7, vPathRenderer.mViewportWidth);
        float namedFloat = androidx.core.content.res.TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "viewportHeight", 8, vPathRenderer.mViewportHeight);
        vPathRenderer.mViewportHeight = namedFloat;
        if (vPathRenderer.mViewportWidth <= 0.0f) {
            throw new org.xmlpull.v1.XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires viewportWidth > 0");
        }
        if (namedFloat <= 0.0f) {
            throw new org.xmlpull.v1.XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires viewportHeight > 0");
        }
        vPathRenderer.mBaseWidth = typedArray.getDimension(3, vPathRenderer.mBaseWidth);
        float dimension = typedArray.getDimension(2, vPathRenderer.mBaseHeight);
        vPathRenderer.mBaseHeight = dimension;
        if (vPathRenderer.mBaseWidth <= 0.0f) {
            throw new org.xmlpull.v1.XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires width > 0");
        }
        if (dimension <= 0.0f) {
            throw new org.xmlpull.v1.XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires height > 0");
        }
        vPathRenderer.setAlpha(androidx.core.content.res.TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "alpha", 4, vPathRenderer.getAlpha()));
        java.lang.String string = typedArray.getString(0);
        if (string != null) {
            vPathRenderer.mRootName = string;
            vPathRenderer.mVGTargetsMap.put(string, vPathRenderer);
        }
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void applyTheme(android.content.res.Resources.Theme theme) {
        super.applyTheme(theme);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean canApplyTheme() {
        android.graphics.drawable.Drawable drawable = this.mDelegateDrawable;
        if (drawable == null) {
            return false;
        }
        androidx.core.graphics.drawable.DrawableCompat.canApplyTheme(drawable);
        return false;
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void clearColorFilter() {
        super.clearColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(android.graphics.Canvas canvas) {
        android.graphics.drawable.Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            drawable.draw(canvas);
            return;
        }
        copyBounds(this.mTmpBounds);
        if (this.mTmpBounds.width() <= 0 || this.mTmpBounds.height() <= 0) {
            return;
        }
        android.graphics.ColorFilter colorFilter = this.mColorFilter;
        if (colorFilter == null) {
            colorFilter = this.mTintFilter;
        }
        canvas.getMatrix(this.mTmpMatrix);
        this.mTmpMatrix.getValues(this.mTmpFloats);
        float abs = java.lang.Math.abs(this.mTmpFloats[0]);
        float abs2 = java.lang.Math.abs(this.mTmpFloats[4]);
        float abs3 = java.lang.Math.abs(this.mTmpFloats[1]);
        float abs4 = java.lang.Math.abs(this.mTmpFloats[3]);
        if (abs3 != 0.0f || abs4 != 0.0f) {
            abs = 1.0f;
            abs2 = 1.0f;
        }
        int min = java.lang.Math.min(2048, (int) (this.mTmpBounds.width() * abs));
        int min2 = java.lang.Math.min(2048, (int) (this.mTmpBounds.height() * abs2));
        if (min <= 0 || min2 <= 0) {
            return;
        }
        int save = canvas.save();
        android.graphics.Rect rect = this.mTmpBounds;
        canvas.translate(rect.left, rect.top);
        if (needMirroring()) {
            canvas.translate(this.mTmpBounds.width(), 0.0f);
            canvas.scale(-1.0f, 1.0f);
        }
        this.mTmpBounds.offsetTo(0, 0);
        this.mVectorState.createCachedBitmapIfNeeded(min, min2);
        if (!this.mAllowCaching) {
            this.mVectorState.updateCachedBitmap(min, min2);
        } else if (!this.mVectorState.canReuseCache()) {
            this.mVectorState.updateCachedBitmap(min, min2);
            this.mVectorState.updateCacheStates();
        }
        this.mVectorState.drawCachedBitmapWithRootAlpha(canvas, colorFilter, this.mTmpBounds);
        canvas.restoreToCount(save);
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        android.graphics.drawable.Drawable drawable = this.mDelegateDrawable;
        return drawable != null ? androidx.core.graphics.drawable.DrawableCompat.getAlpha(drawable) : this.mVectorState.mVPathRenderer.getRootAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        android.graphics.drawable.Drawable drawable = this.mDelegateDrawable;
        return drawable != null ? drawable.getChangingConfigurations() : super.getChangingConfigurations() | this.mVectorState.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    public android.graphics.ColorFilter getColorFilter() {
        android.graphics.drawable.Drawable drawable = this.mDelegateDrawable;
        return drawable != null ? androidx.core.graphics.drawable.DrawableCompat.getColorFilter(drawable) : this.mColorFilter;
    }

    @Override // android.graphics.drawable.Drawable
    public android.graphics.drawable.Drawable.ConstantState getConstantState() {
        if (this.mDelegateDrawable != null && android.os.Build.VERSION.SDK_INT >= 24) {
            return new androidx.vectordrawable.graphics.drawable.VectorDrawableCompat.VectorDrawableDelegateState(this.mDelegateDrawable.getConstantState());
        }
        this.mVectorState.mChangingConfigurations = getChangingConfigurations();
        return this.mVectorState;
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ android.graphics.drawable.Drawable getCurrent() {
        return super.getCurrent();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        android.graphics.drawable.Drawable drawable = this.mDelegateDrawable;
        return drawable != null ? drawable.getIntrinsicHeight() : (int) this.mVectorState.mVPathRenderer.mBaseHeight;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        android.graphics.drawable.Drawable drawable = this.mDelegateDrawable;
        return drawable != null ? drawable.getIntrinsicWidth() : (int) this.mVectorState.mVPathRenderer.mBaseWidth;
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getMinimumHeight() {
        return super.getMinimumHeight();
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getMinimumWidth() {
        return super.getMinimumWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        android.graphics.drawable.Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            return drawable.getOpacity();
        }
        return -3;
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean getPadding(android.graphics.Rect rect) {
        return super.getPadding(rect);
    }

    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public float getPixelSize() {
        androidx.vectordrawable.graphics.drawable.VectorDrawableCompat.VPathRenderer vPathRenderer;
        androidx.vectordrawable.graphics.drawable.VectorDrawableCompat.VectorDrawableCompatState vectorDrawableCompatState = this.mVectorState;
        if (vectorDrawableCompatState == null || (vPathRenderer = vectorDrawableCompatState.mVPathRenderer) == null) {
            return 1.0f;
        }
        float f = vPathRenderer.mBaseWidth;
        if (f == 0.0f) {
            return 1.0f;
        }
        float f2 = vPathRenderer.mBaseHeight;
        if (f2 == 0.0f) {
            return 1.0f;
        }
        float f3 = vPathRenderer.mViewportHeight;
        if (f3 == 0.0f) {
            return 1.0f;
        }
        float f4 = vPathRenderer.mViewportWidth;
        if (f4 == 0.0f) {
            return 1.0f;
        }
        return java.lang.Math.min(f4 / f, f3 / f2);
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int[] getState() {
        return super.getState();
    }

    public java.lang.Object getTargetByName(java.lang.String str) {
        return this.mVectorState.mVPathRenderer.mVGTargetsMap.get(str);
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ android.graphics.Region getTransparentRegion() {
        return super.getTransparentRegion();
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(android.content.res.Resources resources, org.xmlpull.v1.XmlPullParser xmlPullParser, android.util.AttributeSet attributeSet) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        android.graphics.drawable.Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            drawable.inflate(resources, xmlPullParser, attributeSet);
        } else {
            inflate(resources, xmlPullParser, attributeSet, null);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(android.content.res.Resources resources, org.xmlpull.v1.XmlPullParser xmlPullParser, android.util.AttributeSet attributeSet, android.content.res.Resources.Theme theme) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        android.graphics.drawable.Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            androidx.core.graphics.drawable.DrawableCompat.inflate(drawable, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        androidx.vectordrawable.graphics.drawable.VectorDrawableCompat.VectorDrawableCompatState vectorDrawableCompatState = this.mVectorState;
        vectorDrawableCompatState.mVPathRenderer = new androidx.vectordrawable.graphics.drawable.VectorDrawableCompat.VPathRenderer();
        android.content.res.TypedArray obtainAttributes = androidx.core.content.res.TypedArrayUtils.obtainAttributes(resources, theme, attributeSet, androidx.vectordrawable.graphics.drawable.AndroidResources.STYLEABLE_VECTOR_DRAWABLE_TYPE_ARRAY);
        updateStateFromTypedArray(obtainAttributes, xmlPullParser, theme);
        obtainAttributes.recycle();
        vectorDrawableCompatState.mChangingConfigurations = getChangingConfigurations();
        vectorDrawableCompatState.mCacheDirty = true;
        inflateInternal(resources, xmlPullParser, attributeSet, theme);
        this.mTintFilter = updateTintFilter(this.mTintFilter, vectorDrawableCompatState.mTint, vectorDrawableCompatState.mTintMode);
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        android.graphics.drawable.Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            drawable.invalidateSelf();
        } else {
            super.invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        android.graphics.drawable.Drawable drawable = this.mDelegateDrawable;
        return drawable != null ? androidx.core.graphics.drawable.DrawableCompat.isAutoMirrored(drawable) : this.mVectorState.mAutoMirrored;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        androidx.vectordrawable.graphics.drawable.VectorDrawableCompat.VectorDrawableCompatState vectorDrawableCompatState;
        android.content.res.ColorStateList colorStateList;
        android.graphics.drawable.Drawable drawable = this.mDelegateDrawable;
        return drawable != null ? drawable.isStateful() : super.isStateful() || ((vectorDrawableCompatState = this.mVectorState) != null && (vectorDrawableCompatState.isStateful() || ((colorStateList = this.mVectorState.mTint) != null && colorStateList.isStateful())));
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void jumpToCurrentState() {
        super.jumpToCurrentState();
    }

    @Override // android.graphics.drawable.Drawable
    public android.graphics.drawable.Drawable mutate() {
        android.graphics.drawable.Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            drawable.mutate();
            return this;
        }
        if (!this.mMutated && super.mutate() == this) {
            this.mVectorState = new androidx.vectordrawable.graphics.drawable.VectorDrawableCompat.VectorDrawableCompatState(this.mVectorState);
            this.mMutated = true;
        }
        return this;
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public void onBoundsChange(android.graphics.Rect rect) {
        android.graphics.drawable.Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        boolean z;
        android.graphics.PorterDuff.Mode mode;
        android.graphics.drawable.Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            return drawable.setState(iArr);
        }
        androidx.vectordrawable.graphics.drawable.VectorDrawableCompat.VectorDrawableCompatState vectorDrawableCompatState = this.mVectorState;
        android.content.res.ColorStateList colorStateList = vectorDrawableCompatState.mTint;
        if (colorStateList == null || (mode = vectorDrawableCompatState.mTintMode) == null) {
            z = false;
        } else {
            this.mTintFilter = updateTintFilter(this.mTintFilter, colorStateList, mode);
            invalidateSelf();
            z = true;
        }
        if (!vectorDrawableCompatState.isStateful() || !vectorDrawableCompatState.onStateChanged(iArr)) {
            return z;
        }
        invalidateSelf();
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void scheduleSelf(java.lang.Runnable runnable, long j) {
        android.graphics.drawable.Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            drawable.scheduleSelf(runnable, j);
        } else {
            super.scheduleSelf(runnable, j);
        }
    }

    public void setAllowCaching(boolean z) {
        this.mAllowCaching = z;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        android.graphics.drawable.Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            drawable.setAlpha(i);
        } else if (this.mVectorState.mVPathRenderer.getRootAlpha() != i) {
            this.mVectorState.mVPathRenderer.setRootAlpha(i);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean z) {
        android.graphics.drawable.Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            androidx.core.graphics.drawable.DrawableCompat.setAutoMirrored(drawable, z);
        } else {
            this.mVectorState.mAutoMirrored = z;
        }
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setChangingConfigurations(int i) {
        super.setChangingConfigurations(i);
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setColorFilter(int i, android.graphics.PorterDuff.Mode mode) {
        super.setColorFilter(i, mode);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(android.graphics.ColorFilter colorFilter) {
        android.graphics.drawable.Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
        } else {
            this.mColorFilter = colorFilter;
            invalidateSelf();
        }
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setFilterBitmap(boolean z) {
        super.setFilterBitmap(z);
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setHotspot(float f, float f2) {
        super.setHotspot(f, f2);
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setHotspotBounds(int i, int i2, int i3, int i4) {
        super.setHotspotBounds(i, i2, i3, i4);
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean setState(int[] iArr) {
        return super.setState(iArr);
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTint(int i) {
        android.graphics.drawable.Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            androidx.core.graphics.drawable.DrawableCompat.setTint(drawable, i);
        } else {
            setTintList(android.content.res.ColorStateList.valueOf(i));
        }
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTintList(android.content.res.ColorStateList colorStateList) {
        android.graphics.drawable.Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            androidx.core.graphics.drawable.DrawableCompat.setTintList(drawable, colorStateList);
            return;
        }
        androidx.vectordrawable.graphics.drawable.VectorDrawableCompat.VectorDrawableCompatState vectorDrawableCompatState = this.mVectorState;
        if (vectorDrawableCompatState.mTint != colorStateList) {
            vectorDrawableCompatState.mTint = colorStateList;
            this.mTintFilter = updateTintFilter(this.mTintFilter, colorStateList, vectorDrawableCompatState.mTintMode);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTintMode(android.graphics.PorterDuff.Mode mode) {
        android.graphics.drawable.Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            androidx.core.graphics.drawable.DrawableCompat.setTintMode(drawable, mode);
            return;
        }
        androidx.vectordrawable.graphics.drawable.VectorDrawableCompat.VectorDrawableCompatState vectorDrawableCompatState = this.mVectorState;
        if (vectorDrawableCompatState.mTintMode != mode) {
            vectorDrawableCompatState.mTintMode = mode;
            this.mTintFilter = updateTintFilter(this.mTintFilter, vectorDrawableCompatState.mTint, mode);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        android.graphics.drawable.Drawable drawable = this.mDelegateDrawable;
        return drawable != null ? drawable.setVisible(z, z2) : super.setVisible(z, z2);
    }

    @Override // android.graphics.drawable.Drawable
    public void unscheduleSelf(java.lang.Runnable runnable) {
        android.graphics.drawable.Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            drawable.unscheduleSelf(runnable);
        } else {
            super.unscheduleSelf(runnable);
        }
    }

    public android.graphics.PorterDuffColorFilter updateTintFilter(android.graphics.PorterDuffColorFilter porterDuffColorFilter, android.content.res.ColorStateList colorStateList, android.graphics.PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new android.graphics.PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }
}
