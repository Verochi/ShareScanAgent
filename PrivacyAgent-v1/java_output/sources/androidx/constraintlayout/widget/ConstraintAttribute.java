package androidx.constraintlayout.widget;

/* loaded from: classes.dex */
public class ConstraintAttribute {
    private static final java.lang.String TAG = "TransitionLayout";
    boolean mBooleanValue;
    private int mColorValue;
    private float mFloatValue;
    private int mIntegerValue;
    java.lang.String mName;
    private java.lang.String mStringValue;
    private androidx.constraintlayout.widget.ConstraintAttribute.AttributeType mType;

    /* renamed from: androidx.constraintlayout.widget.ConstraintAttribute$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$androidx$constraintlayout$widget$ConstraintAttribute$AttributeType;

        static {
            int[] iArr = new int[androidx.constraintlayout.widget.ConstraintAttribute.AttributeType.values().length];
            $SwitchMap$androidx$constraintlayout$widget$ConstraintAttribute$AttributeType = iArr;
            try {
                iArr[androidx.constraintlayout.widget.ConstraintAttribute.AttributeType.COLOR_TYPE.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$widget$ConstraintAttribute$AttributeType[androidx.constraintlayout.widget.ConstraintAttribute.AttributeType.COLOR_DRAWABLE_TYPE.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$widget$ConstraintAttribute$AttributeType[androidx.constraintlayout.widget.ConstraintAttribute.AttributeType.INT_TYPE.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$widget$ConstraintAttribute$AttributeType[androidx.constraintlayout.widget.ConstraintAttribute.AttributeType.FLOAT_TYPE.ordinal()] = 4;
            } catch (java.lang.NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$widget$ConstraintAttribute$AttributeType[androidx.constraintlayout.widget.ConstraintAttribute.AttributeType.STRING_TYPE.ordinal()] = 5;
            } catch (java.lang.NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$widget$ConstraintAttribute$AttributeType[androidx.constraintlayout.widget.ConstraintAttribute.AttributeType.BOOLEAN_TYPE.ordinal()] = 6;
            } catch (java.lang.NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$widget$ConstraintAttribute$AttributeType[androidx.constraintlayout.widget.ConstraintAttribute.AttributeType.DIMENSION_TYPE.ordinal()] = 7;
            } catch (java.lang.NoSuchFieldError unused7) {
            }
        }
    }

    public enum AttributeType {
        INT_TYPE,
        FLOAT_TYPE,
        COLOR_TYPE,
        COLOR_DRAWABLE_TYPE,
        STRING_TYPE,
        BOOLEAN_TYPE,
        DIMENSION_TYPE
    }

    public ConstraintAttribute(androidx.constraintlayout.widget.ConstraintAttribute constraintAttribute, java.lang.Object obj) {
        this.mName = constraintAttribute.mName;
        this.mType = constraintAttribute.mType;
        setValue(obj);
    }

    public ConstraintAttribute(java.lang.String str, androidx.constraintlayout.widget.ConstraintAttribute.AttributeType attributeType) {
        this.mName = str;
        this.mType = attributeType;
    }

    public ConstraintAttribute(java.lang.String str, androidx.constraintlayout.widget.ConstraintAttribute.AttributeType attributeType, java.lang.Object obj) {
        this.mName = str;
        this.mType = attributeType;
        setValue(obj);
    }

    private static int clamp(int i) {
        int i2 = (i & (~(i >> 31))) - 255;
        return (i2 & (i2 >> 31)) + 255;
    }

    public static java.util.HashMap<java.lang.String, androidx.constraintlayout.widget.ConstraintAttribute> extractAttributes(java.util.HashMap<java.lang.String, androidx.constraintlayout.widget.ConstraintAttribute> hashMap, android.view.View view) {
        java.util.HashMap<java.lang.String, androidx.constraintlayout.widget.ConstraintAttribute> hashMap2 = new java.util.HashMap<>();
        java.lang.Class<?> cls = view.getClass();
        for (java.lang.String str : hashMap.keySet()) {
            androidx.constraintlayout.widget.ConstraintAttribute constraintAttribute = hashMap.get(str);
            try {
                if (str.equals("BackgroundColor")) {
                    hashMap2.put(str, new androidx.constraintlayout.widget.ConstraintAttribute(constraintAttribute, java.lang.Integer.valueOf(((android.graphics.drawable.ColorDrawable) view.getBackground()).getColor())));
                } else {
                    hashMap2.put(str, new androidx.constraintlayout.widget.ConstraintAttribute(constraintAttribute, cls.getMethod("getMap" + str, new java.lang.Class[0]).invoke(view, new java.lang.Object[0])));
                }
            } catch (java.lang.IllegalAccessException e) {
                e.printStackTrace();
            } catch (java.lang.NoSuchMethodException e2) {
                e2.printStackTrace();
            } catch (java.lang.reflect.InvocationTargetException e3) {
                e3.printStackTrace();
            }
        }
        return hashMap2;
    }

    public static void parse(android.content.Context context, org.xmlpull.v1.XmlPullParser xmlPullParser, java.util.HashMap<java.lang.String, androidx.constraintlayout.widget.ConstraintAttribute> hashMap) {
        androidx.constraintlayout.widget.ConstraintAttribute.AttributeType attributeType;
        java.lang.Object string;
        android.content.res.TypedArray obtainStyledAttributes = context.obtainStyledAttributes(android.util.Xml.asAttributeSet(xmlPullParser), androidx.constraintlayout.widget.R.styleable.CustomAttribute);
        int indexCount = obtainStyledAttributes.getIndexCount();
        java.lang.String str = null;
        java.lang.Object obj = null;
        androidx.constraintlayout.widget.ConstraintAttribute.AttributeType attributeType2 = null;
        for (int i = 0; i < indexCount; i++) {
            int index = obtainStyledAttributes.getIndex(i);
            if (index == androidx.constraintlayout.widget.R.styleable.CustomAttribute_attributeName) {
                str = obtainStyledAttributes.getString(index);
                if (str != null && str.length() > 0) {
                    str = java.lang.Character.toUpperCase(str.charAt(0)) + str.substring(1);
                }
            } else if (index == androidx.constraintlayout.widget.R.styleable.CustomAttribute_customBoolean) {
                obj = java.lang.Boolean.valueOf(obtainStyledAttributes.getBoolean(index, false));
                attributeType2 = androidx.constraintlayout.widget.ConstraintAttribute.AttributeType.BOOLEAN_TYPE;
            } else {
                if (index == androidx.constraintlayout.widget.R.styleable.CustomAttribute_customColorValue) {
                    attributeType = androidx.constraintlayout.widget.ConstraintAttribute.AttributeType.COLOR_TYPE;
                    string = java.lang.Integer.valueOf(obtainStyledAttributes.getColor(index, 0));
                } else if (index == androidx.constraintlayout.widget.R.styleable.CustomAttribute_customColorDrawableValue) {
                    attributeType = androidx.constraintlayout.widget.ConstraintAttribute.AttributeType.COLOR_DRAWABLE_TYPE;
                    string = java.lang.Integer.valueOf(obtainStyledAttributes.getColor(index, 0));
                } else if (index == androidx.constraintlayout.widget.R.styleable.CustomAttribute_customPixelDimension) {
                    attributeType = androidx.constraintlayout.widget.ConstraintAttribute.AttributeType.DIMENSION_TYPE;
                    string = java.lang.Float.valueOf(android.util.TypedValue.applyDimension(1, obtainStyledAttributes.getDimension(index, 0.0f), context.getResources().getDisplayMetrics()));
                } else if (index == androidx.constraintlayout.widget.R.styleable.CustomAttribute_customDimension) {
                    attributeType = androidx.constraintlayout.widget.ConstraintAttribute.AttributeType.DIMENSION_TYPE;
                    string = java.lang.Float.valueOf(obtainStyledAttributes.getDimension(index, 0.0f));
                } else if (index == androidx.constraintlayout.widget.R.styleable.CustomAttribute_customFloatValue) {
                    attributeType = androidx.constraintlayout.widget.ConstraintAttribute.AttributeType.FLOAT_TYPE;
                    string = java.lang.Float.valueOf(obtainStyledAttributes.getFloat(index, Float.NaN));
                } else if (index == androidx.constraintlayout.widget.R.styleable.CustomAttribute_customIntegerValue) {
                    attributeType = androidx.constraintlayout.widget.ConstraintAttribute.AttributeType.INT_TYPE;
                    string = java.lang.Integer.valueOf(obtainStyledAttributes.getInteger(index, -1));
                } else if (index == androidx.constraintlayout.widget.R.styleable.CustomAttribute_customStringValue) {
                    attributeType = androidx.constraintlayout.widget.ConstraintAttribute.AttributeType.STRING_TYPE;
                    string = obtainStyledAttributes.getString(index);
                }
                java.lang.Object obj2 = string;
                attributeType2 = attributeType;
                obj = obj2;
            }
        }
        if (str != null && obj != null) {
            hashMap.put(str, new androidx.constraintlayout.widget.ConstraintAttribute(str, attributeType2, obj));
        }
        obtainStyledAttributes.recycle();
    }

    public static void setAttributes(android.view.View view, java.util.HashMap<java.lang.String, androidx.constraintlayout.widget.ConstraintAttribute> hashMap) {
        java.lang.Class<?> cls = view.getClass();
        for (java.lang.String str : hashMap.keySet()) {
            androidx.constraintlayout.widget.ConstraintAttribute constraintAttribute = hashMap.get(str);
            java.lang.String str2 = "set" + str;
            try {
                switch (androidx.constraintlayout.widget.ConstraintAttribute.AnonymousClass1.$SwitchMap$androidx$constraintlayout$widget$ConstraintAttribute$AttributeType[constraintAttribute.mType.ordinal()]) {
                    case 1:
                        cls.getMethod(str2, java.lang.Integer.TYPE).invoke(view, java.lang.Integer.valueOf(constraintAttribute.mColorValue));
                        break;
                    case 2:
                        java.lang.reflect.Method method = cls.getMethod(str2, android.graphics.drawable.Drawable.class);
                        android.graphics.drawable.ColorDrawable colorDrawable = new android.graphics.drawable.ColorDrawable();
                        colorDrawable.setColor(constraintAttribute.mColorValue);
                        method.invoke(view, colorDrawable);
                        break;
                    case 3:
                        cls.getMethod(str2, java.lang.Integer.TYPE).invoke(view, java.lang.Integer.valueOf(constraintAttribute.mIntegerValue));
                        break;
                    case 4:
                        cls.getMethod(str2, java.lang.Float.TYPE).invoke(view, java.lang.Float.valueOf(constraintAttribute.mFloatValue));
                        break;
                    case 5:
                        cls.getMethod(str2, java.lang.CharSequence.class).invoke(view, constraintAttribute.mStringValue);
                        break;
                    case 6:
                        cls.getMethod(str2, java.lang.Boolean.TYPE).invoke(view, java.lang.Boolean.valueOf(constraintAttribute.mBooleanValue));
                        break;
                    case 7:
                        cls.getMethod(str2, java.lang.Float.TYPE).invoke(view, java.lang.Float.valueOf(constraintAttribute.mFloatValue));
                        break;
                }
            } catch (java.lang.IllegalAccessException e) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append(" Custom Attribute \"");
                sb.append(str);
                sb.append("\" not found on ");
                sb.append(cls.getName());
                e.printStackTrace();
            } catch (java.lang.NoSuchMethodException e2) {
                e2.getMessage();
                java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
                sb2.append(" Custom Attribute \"");
                sb2.append(str);
                sb2.append("\" not found on ");
                sb2.append(cls.getName());
                java.lang.StringBuilder sb3 = new java.lang.StringBuilder();
                sb3.append(cls.getName());
                sb3.append(" must have a method ");
                sb3.append(str2);
            } catch (java.lang.reflect.InvocationTargetException e3) {
                java.lang.StringBuilder sb4 = new java.lang.StringBuilder();
                sb4.append(" Custom Attribute \"");
                sb4.append(str);
                sb4.append("\" not found on ");
                sb4.append(cls.getName());
                e3.printStackTrace();
            }
        }
    }

    public boolean diff(androidx.constraintlayout.widget.ConstraintAttribute constraintAttribute) {
        androidx.constraintlayout.widget.ConstraintAttribute.AttributeType attributeType;
        if (constraintAttribute == null || (attributeType = this.mType) != constraintAttribute.mType) {
            return false;
        }
        switch (androidx.constraintlayout.widget.ConstraintAttribute.AnonymousClass1.$SwitchMap$androidx$constraintlayout$widget$ConstraintAttribute$AttributeType[attributeType.ordinal()]) {
            case 1:
            case 2:
                if (this.mColorValue == constraintAttribute.mColorValue) {
                }
                break;
            case 3:
                if (this.mIntegerValue == constraintAttribute.mIntegerValue) {
                }
                break;
            case 4:
                if (this.mFloatValue == constraintAttribute.mFloatValue) {
                }
                break;
            case 5:
                if (this.mIntegerValue == constraintAttribute.mIntegerValue) {
                }
                break;
            case 6:
                if (this.mBooleanValue == constraintAttribute.mBooleanValue) {
                }
                break;
            case 7:
                if (this.mFloatValue == constraintAttribute.mFloatValue) {
                }
                break;
        }
        return false;
    }

    public androidx.constraintlayout.widget.ConstraintAttribute.AttributeType getType() {
        return this.mType;
    }

    public float getValueToInterpolate() {
        switch (androidx.constraintlayout.widget.ConstraintAttribute.AnonymousClass1.$SwitchMap$androidx$constraintlayout$widget$ConstraintAttribute$AttributeType[this.mType.ordinal()]) {
            case 1:
            case 2:
                throw new java.lang.RuntimeException("Color does not have a single color to interpolate");
            case 3:
                return this.mIntegerValue;
            case 4:
                return this.mFloatValue;
            case 5:
                throw new java.lang.RuntimeException("Cannot interpolate String");
            case 6:
                return this.mBooleanValue ? 1.0f : 0.0f;
            case 7:
                return this.mFloatValue;
            default:
                return Float.NaN;
        }
    }

    public void getValuesToInterpolate(float[] fArr) {
        switch (androidx.constraintlayout.widget.ConstraintAttribute.AnonymousClass1.$SwitchMap$androidx$constraintlayout$widget$ConstraintAttribute$AttributeType[this.mType.ordinal()]) {
            case 1:
            case 2:
                int i = (this.mColorValue >> 24) & 255;
                float pow = (float) java.lang.Math.pow(((r0 >> 16) & 255) / 255.0f, 2.2d);
                float pow2 = (float) java.lang.Math.pow(((r0 >> 8) & 255) / 255.0f, 2.2d);
                float pow3 = (float) java.lang.Math.pow((r0 & 255) / 255.0f, 2.2d);
                fArr[0] = pow;
                fArr[1] = pow2;
                fArr[2] = pow3;
                fArr[3] = i / 255.0f;
                return;
            case 3:
                fArr[0] = this.mIntegerValue;
                return;
            case 4:
                fArr[0] = this.mFloatValue;
                return;
            case 5:
                throw new java.lang.RuntimeException("Color does not have a single color to interpolate");
            case 6:
                fArr[0] = this.mBooleanValue ? 1.0f : 0.0f;
                return;
            case 7:
                fArr[0] = this.mFloatValue;
                return;
            default:
                return;
        }
    }

    public int noOfInterpValues() {
        int i = androidx.constraintlayout.widget.ConstraintAttribute.AnonymousClass1.$SwitchMap$androidx$constraintlayout$widget$ConstraintAttribute$AttributeType[this.mType.ordinal()];
        return (i == 1 || i == 2) ? 4 : 1;
    }

    public void setColorValue(int i) {
        this.mColorValue = i;
    }

    public void setFloatValue(float f) {
        this.mFloatValue = f;
    }

    public void setIntValue(int i) {
        this.mIntegerValue = i;
    }

    public void setInterpolatedValue(android.view.View view, float[] fArr) {
        java.lang.Class<?> cls = view.getClass();
        java.lang.String str = "set" + this.mName;
        try {
            boolean z = true;
            switch (androidx.constraintlayout.widget.ConstraintAttribute.AnonymousClass1.$SwitchMap$androidx$constraintlayout$widget$ConstraintAttribute$AttributeType[this.mType.ordinal()]) {
                case 1:
                    cls.getMethod(str, java.lang.Integer.TYPE).invoke(view, java.lang.Integer.valueOf((clamp((int) (((float) java.lang.Math.pow(fArr[0], 0.45454545454545453d)) * 255.0f)) << 16) | (clamp((int) (fArr[3] * 255.0f)) << 24) | (clamp((int) (((float) java.lang.Math.pow(fArr[1], 0.45454545454545453d)) * 255.0f)) << 8) | clamp((int) (((float) java.lang.Math.pow(fArr[2], 0.45454545454545453d)) * 255.0f))));
                    return;
                case 2:
                    java.lang.reflect.Method method = cls.getMethod(str, android.graphics.drawable.Drawable.class);
                    int clamp = (clamp((int) (((float) java.lang.Math.pow(fArr[0], 0.45454545454545453d)) * 255.0f)) << 16) | (clamp((int) (fArr[3] * 255.0f)) << 24) | (clamp((int) (((float) java.lang.Math.pow(fArr[1], 0.45454545454545453d)) * 255.0f)) << 8) | clamp((int) (((float) java.lang.Math.pow(fArr[2], 0.45454545454545453d)) * 255.0f));
                    android.graphics.drawable.ColorDrawable colorDrawable = new android.graphics.drawable.ColorDrawable();
                    colorDrawable.setColor(clamp);
                    method.invoke(view, colorDrawable);
                    return;
                case 3:
                    cls.getMethod(str, java.lang.Integer.TYPE).invoke(view, java.lang.Integer.valueOf((int) fArr[0]));
                    return;
                case 4:
                    cls.getMethod(str, java.lang.Float.TYPE).invoke(view, java.lang.Float.valueOf(fArr[0]));
                    return;
                case 5:
                    throw new java.lang.RuntimeException("unable to interpolate strings " + this.mName);
                case 6:
                    java.lang.reflect.Method method2 = cls.getMethod(str, java.lang.Boolean.TYPE);
                    java.lang.Object[] objArr = new java.lang.Object[1];
                    if (fArr[0] <= 0.5f) {
                        z = false;
                    }
                    objArr[0] = java.lang.Boolean.valueOf(z);
                    method2.invoke(view, objArr);
                    return;
                case 7:
                    cls.getMethod(str, java.lang.Float.TYPE).invoke(view, java.lang.Float.valueOf(fArr[0]));
                    return;
                default:
                    return;
            }
        } catch (java.lang.IllegalAccessException e) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("cannot access method ");
            sb.append(str);
            sb.append("on View \"");
            sb.append(androidx.constraintlayout.motion.widget.Debug.getName(view));
            sb.append("\"");
            e.printStackTrace();
        } catch (java.lang.NoSuchMethodException e2) {
            java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
            sb2.append("no method ");
            sb2.append(str);
            sb2.append("on View \"");
            sb2.append(androidx.constraintlayout.motion.widget.Debug.getName(view));
            sb2.append("\"");
            e2.printStackTrace();
        } catch (java.lang.reflect.InvocationTargetException e3) {
            e3.printStackTrace();
        }
    }

    public void setStringValue(java.lang.String str) {
        this.mStringValue = str;
    }

    public void setValue(java.lang.Object obj) {
        switch (androidx.constraintlayout.widget.ConstraintAttribute.AnonymousClass1.$SwitchMap$androidx$constraintlayout$widget$ConstraintAttribute$AttributeType[this.mType.ordinal()]) {
            case 1:
            case 2:
                this.mColorValue = ((java.lang.Integer) obj).intValue();
                break;
            case 3:
                this.mIntegerValue = ((java.lang.Integer) obj).intValue();
                break;
            case 4:
                this.mFloatValue = ((java.lang.Float) obj).floatValue();
                break;
            case 5:
                this.mStringValue = (java.lang.String) obj;
                break;
            case 6:
                this.mBooleanValue = ((java.lang.Boolean) obj).booleanValue();
                break;
            case 7:
                this.mFloatValue = ((java.lang.Float) obj).floatValue();
                break;
        }
    }

    public void setValue(float[] fArr) {
        switch (androidx.constraintlayout.widget.ConstraintAttribute.AnonymousClass1.$SwitchMap$androidx$constraintlayout$widget$ConstraintAttribute$AttributeType[this.mType.ordinal()]) {
            case 1:
            case 2:
                int HSVToColor = android.graphics.Color.HSVToColor(fArr);
                this.mColorValue = HSVToColor;
                this.mColorValue = (clamp((int) (fArr[3] * 255.0f)) << 24) | (HSVToColor & 16777215);
                return;
            case 3:
                this.mIntegerValue = (int) fArr[0];
                return;
            case 4:
                this.mFloatValue = fArr[0];
                return;
            case 5:
                throw new java.lang.RuntimeException("Color does not have a single color to interpolate");
            case 6:
                this.mBooleanValue = ((double) fArr[0]) > 0.5d;
                return;
            case 7:
                this.mFloatValue = fArr[0];
                return;
            default:
                return;
        }
    }
}
