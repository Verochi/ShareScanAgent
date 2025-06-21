package androidx.appcompat.app;

/* loaded from: classes.dex */
public class AppCompatViewInflater {
    private static final java.lang.String LOG_TAG = "AppCompatViewInflater";
    private final java.lang.Object[] mConstructorArgs = new java.lang.Object[2];
    private static final java.lang.Class<?>[] sConstructorSignature = {android.content.Context.class, android.util.AttributeSet.class};
    private static final int[] sOnClickAttrs = {android.R.attr.onClick};
    private static final java.lang.String[] sClassPrefixList = {"android.widget.", "android.view.", "android.webkit."};
    private static final androidx.collection.SimpleArrayMap<java.lang.String, java.lang.reflect.Constructor<? extends android.view.View>> sConstructorMap = new androidx.collection.SimpleArrayMap<>();

    public static class DeclaredOnClickListener implements android.view.View.OnClickListener {
        private final android.view.View mHostView;
        private final java.lang.String mMethodName;
        private android.content.Context mResolvedContext;
        private java.lang.reflect.Method mResolvedMethod;

        public DeclaredOnClickListener(@androidx.annotation.NonNull android.view.View view, @androidx.annotation.NonNull java.lang.String str) {
            this.mHostView = view;
            this.mMethodName = str;
        }

        private void resolveMethod(@androidx.annotation.Nullable android.content.Context context) {
            java.lang.String str;
            java.lang.reflect.Method method;
            while (context != null) {
                try {
                    if (!context.isRestricted() && (method = context.getClass().getMethod(this.mMethodName, android.view.View.class)) != null) {
                        this.mResolvedMethod = method;
                        this.mResolvedContext = context;
                        return;
                    }
                } catch (java.lang.NoSuchMethodException unused) {
                }
                context = context instanceof android.content.ContextWrapper ? ((android.content.ContextWrapper) context).getBaseContext() : null;
            }
            int id = this.mHostView.getId();
            if (id == -1) {
                str = "";
            } else {
                str = " with id '" + this.mHostView.getContext().getResources().getResourceEntryName(id) + "'";
            }
            throw new java.lang.IllegalStateException("Could not find method " + this.mMethodName + "(View) in a parent or ancestor Context for android:onClick attribute defined on view " + this.mHostView.getClass() + str);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(@androidx.annotation.NonNull android.view.View view) {
            if (this.mResolvedMethod == null) {
                resolveMethod(this.mHostView.getContext());
            }
            try {
                this.mResolvedMethod.invoke(this.mResolvedContext, view);
            } catch (java.lang.IllegalAccessException e) {
                throw new java.lang.IllegalStateException("Could not execute non-public method for android:onClick", e);
            } catch (java.lang.reflect.InvocationTargetException e2) {
                throw new java.lang.IllegalStateException("Could not execute method for android:onClick", e2);
            }
        }
    }

    private void checkOnClickListener(android.view.View view, android.util.AttributeSet attributeSet) {
        android.content.Context context = view.getContext();
        if ((context instanceof android.content.ContextWrapper) && androidx.core.view.ViewCompat.hasOnClickListeners(view)) {
            android.content.res.TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, sOnClickAttrs);
            java.lang.String string = obtainStyledAttributes.getString(0);
            if (string != null) {
                view.setOnClickListener(new androidx.appcompat.app.AppCompatViewInflater.DeclaredOnClickListener(view, string));
            }
            obtainStyledAttributes.recycle();
        }
    }

    private android.view.View createViewByPrefix(android.content.Context context, java.lang.String str, java.lang.String str2) throws java.lang.ClassNotFoundException, android.view.InflateException {
        java.lang.String str3;
        androidx.collection.SimpleArrayMap<java.lang.String, java.lang.reflect.Constructor<? extends android.view.View>> simpleArrayMap = sConstructorMap;
        java.lang.reflect.Constructor<? extends android.view.View> constructor = simpleArrayMap.get(str);
        if (constructor == null) {
            if (str2 != null) {
                try {
                    str3 = str2 + str;
                } catch (java.lang.Exception unused) {
                    return null;
                }
            } else {
                str3 = str;
            }
            constructor = java.lang.Class.forName(str3, false, context.getClassLoader()).asSubclass(android.view.View.class).getConstructor(sConstructorSignature);
            simpleArrayMap.put(str, constructor);
        }
        constructor.setAccessible(true);
        return constructor.newInstance(this.mConstructorArgs);
    }

    private android.view.View createViewFromTag(android.content.Context context, java.lang.String str, android.util.AttributeSet attributeSet) {
        if (str.equals(com.anythink.expressad.a.B)) {
            str = attributeSet.getAttributeValue(null, "class");
        }
        try {
            java.lang.Object[] objArr = this.mConstructorArgs;
            objArr[0] = context;
            objArr[1] = attributeSet;
            if (-1 != str.indexOf(46)) {
                return createViewByPrefix(context, str, null);
            }
            int i = 0;
            while (true) {
                java.lang.String[] strArr = sClassPrefixList;
                if (i >= strArr.length) {
                    return null;
                }
                android.view.View createViewByPrefix = createViewByPrefix(context, str, strArr[i]);
                if (createViewByPrefix != null) {
                    return createViewByPrefix;
                }
                i++;
            }
        } catch (java.lang.Exception unused) {
            return null;
        } finally {
            java.lang.Object[] objArr2 = this.mConstructorArgs;
            objArr2[0] = null;
            objArr2[1] = null;
        }
    }

    private static android.content.Context themifyContext(android.content.Context context, android.util.AttributeSet attributeSet, boolean z, boolean z2) {
        android.content.res.TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, androidx.appcompat.R.styleable.View, 0, 0);
        int resourceId = z ? obtainStyledAttributes.getResourceId(androidx.appcompat.R.styleable.View_android_theme, 0) : 0;
        if (z2 && resourceId == 0) {
            resourceId = obtainStyledAttributes.getResourceId(androidx.appcompat.R.styleable.View_theme, 0);
        }
        obtainStyledAttributes.recycle();
        return resourceId != 0 ? ((context instanceof androidx.appcompat.view.ContextThemeWrapper) && ((androidx.appcompat.view.ContextThemeWrapper) context).getThemeResId() == resourceId) ? context : new androidx.appcompat.view.ContextThemeWrapper(context, resourceId) : context;
    }

    private void verifyNotNull(android.view.View view, java.lang.String str) {
        if (view != null) {
            return;
        }
        throw new java.lang.IllegalStateException(getClass().getName() + " asked to inflate view for <" + str + ">, but returned null");
    }

    @androidx.annotation.NonNull
    public androidx.appcompat.widget.AppCompatAutoCompleteTextView createAutoCompleteTextView(android.content.Context context, android.util.AttributeSet attributeSet) {
        return new androidx.appcompat.widget.AppCompatAutoCompleteTextView(context, attributeSet);
    }

    @androidx.annotation.NonNull
    public androidx.appcompat.widget.AppCompatButton createButton(android.content.Context context, android.util.AttributeSet attributeSet) {
        return new androidx.appcompat.widget.AppCompatButton(context, attributeSet);
    }

    @androidx.annotation.NonNull
    public androidx.appcompat.widget.AppCompatCheckBox createCheckBox(android.content.Context context, android.util.AttributeSet attributeSet) {
        return new androidx.appcompat.widget.AppCompatCheckBox(context, attributeSet);
    }

    @androidx.annotation.NonNull
    public androidx.appcompat.widget.AppCompatCheckedTextView createCheckedTextView(android.content.Context context, android.util.AttributeSet attributeSet) {
        return new androidx.appcompat.widget.AppCompatCheckedTextView(context, attributeSet);
    }

    @androidx.annotation.NonNull
    public androidx.appcompat.widget.AppCompatEditText createEditText(android.content.Context context, android.util.AttributeSet attributeSet) {
        return new androidx.appcompat.widget.AppCompatEditText(context, attributeSet);
    }

    @androidx.annotation.NonNull
    public androidx.appcompat.widget.AppCompatImageButton createImageButton(android.content.Context context, android.util.AttributeSet attributeSet) {
        return new androidx.appcompat.widget.AppCompatImageButton(context, attributeSet);
    }

    @androidx.annotation.NonNull
    public androidx.appcompat.widget.AppCompatImageView createImageView(android.content.Context context, android.util.AttributeSet attributeSet) {
        return new androidx.appcompat.widget.AppCompatImageView(context, attributeSet);
    }

    @androidx.annotation.NonNull
    public androidx.appcompat.widget.AppCompatMultiAutoCompleteTextView createMultiAutoCompleteTextView(android.content.Context context, android.util.AttributeSet attributeSet) {
        return new androidx.appcompat.widget.AppCompatMultiAutoCompleteTextView(context, attributeSet);
    }

    @androidx.annotation.NonNull
    public androidx.appcompat.widget.AppCompatRadioButton createRadioButton(android.content.Context context, android.util.AttributeSet attributeSet) {
        return new androidx.appcompat.widget.AppCompatRadioButton(context, attributeSet);
    }

    @androidx.annotation.NonNull
    public androidx.appcompat.widget.AppCompatRatingBar createRatingBar(android.content.Context context, android.util.AttributeSet attributeSet) {
        return new androidx.appcompat.widget.AppCompatRatingBar(context, attributeSet);
    }

    @androidx.annotation.NonNull
    public androidx.appcompat.widget.AppCompatSeekBar createSeekBar(android.content.Context context, android.util.AttributeSet attributeSet) {
        return new androidx.appcompat.widget.AppCompatSeekBar(context, attributeSet);
    }

    @androidx.annotation.NonNull
    public androidx.appcompat.widget.AppCompatSpinner createSpinner(android.content.Context context, android.util.AttributeSet attributeSet) {
        return new androidx.appcompat.widget.AppCompatSpinner(context, attributeSet);
    }

    @androidx.annotation.NonNull
    public androidx.appcompat.widget.AppCompatTextView createTextView(android.content.Context context, android.util.AttributeSet attributeSet) {
        return new androidx.appcompat.widget.AppCompatTextView(context, attributeSet);
    }

    @androidx.annotation.NonNull
    public androidx.appcompat.widget.AppCompatToggleButton createToggleButton(android.content.Context context, android.util.AttributeSet attributeSet) {
        return new androidx.appcompat.widget.AppCompatToggleButton(context, attributeSet);
    }

    @androidx.annotation.Nullable
    public android.view.View createView(android.content.Context context, java.lang.String str, android.util.AttributeSet attributeSet) {
        return null;
    }

    public final android.view.View createView(android.view.View view, java.lang.String str, @androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull android.util.AttributeSet attributeSet, boolean z, boolean z2, boolean z3, boolean z4) {
        android.content.Context context2;
        android.view.View createRatingBar;
        context2 = (!z || view == null) ? context : view.getContext();
        if (z2 || z3) {
            context2 = themifyContext(context2, attributeSet, z2, z3);
        }
        if (z4) {
            context2 = androidx.appcompat.widget.TintContextWrapper.wrap(context2);
        }
        str.hashCode();
        switch (str) {
            case "RatingBar":
                createRatingBar = createRatingBar(context2, attributeSet);
                verifyNotNull(createRatingBar, str);
                break;
            case "CheckedTextView":
                createRatingBar = createCheckedTextView(context2, attributeSet);
                verifyNotNull(createRatingBar, str);
                break;
            case "MultiAutoCompleteTextView":
                createRatingBar = createMultiAutoCompleteTextView(context2, attributeSet);
                verifyNotNull(createRatingBar, str);
                break;
            case "TextView":
                createRatingBar = createTextView(context2, attributeSet);
                verifyNotNull(createRatingBar, str);
                break;
            case "ImageButton":
                createRatingBar = createImageButton(context2, attributeSet);
                verifyNotNull(createRatingBar, str);
                break;
            case "SeekBar":
                createRatingBar = createSeekBar(context2, attributeSet);
                verifyNotNull(createRatingBar, str);
                break;
            case "Spinner":
                createRatingBar = createSpinner(context2, attributeSet);
                verifyNotNull(createRatingBar, str);
                break;
            case "RadioButton":
                createRatingBar = createRadioButton(context2, attributeSet);
                verifyNotNull(createRatingBar, str);
                break;
            case "ToggleButton":
                createRatingBar = createToggleButton(context2, attributeSet);
                verifyNotNull(createRatingBar, str);
                break;
            case "ImageView":
                createRatingBar = createImageView(context2, attributeSet);
                verifyNotNull(createRatingBar, str);
                break;
            case "AutoCompleteTextView":
                createRatingBar = createAutoCompleteTextView(context2, attributeSet);
                verifyNotNull(createRatingBar, str);
                break;
            case "CheckBox":
                createRatingBar = createCheckBox(context2, attributeSet);
                verifyNotNull(createRatingBar, str);
                break;
            case "EditText":
                createRatingBar = createEditText(context2, attributeSet);
                verifyNotNull(createRatingBar, str);
                break;
            case "Button":
                createRatingBar = createButton(context2, attributeSet);
                verifyNotNull(createRatingBar, str);
                break;
            default:
                createRatingBar = createView(context2, str, attributeSet);
                break;
        }
        if (createRatingBar == null && context != context2) {
            createRatingBar = createViewFromTag(context2, str, attributeSet);
        }
        if (createRatingBar != null) {
            checkOnClickListener(createRatingBar, attributeSet);
        }
        return createRatingBar;
    }
}
