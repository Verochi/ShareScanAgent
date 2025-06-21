package androidx.databinding.adapters;

@androidx.databinding.BindingMethods({@androidx.databinding.BindingMethod(attribute = "android:autoLink", method = "setAutoLinkMask", type = android.widget.TextView.class), @androidx.databinding.BindingMethod(attribute = "android:drawablePadding", method = "setCompoundDrawablePadding", type = android.widget.TextView.class), @androidx.databinding.BindingMethod(attribute = "android:editorExtras", method = "setInputExtras", type = android.widget.TextView.class), @androidx.databinding.BindingMethod(attribute = "android:inputType", method = "setRawInputType", type = android.widget.TextView.class), @androidx.databinding.BindingMethod(attribute = "android:scrollHorizontally", method = "setHorizontallyScrolling", type = android.widget.TextView.class), @androidx.databinding.BindingMethod(attribute = "android:textAllCaps", method = "setAllCaps", type = android.widget.TextView.class), @androidx.databinding.BindingMethod(attribute = "android:textColorHighlight", method = "setHighlightColor", type = android.widget.TextView.class), @androidx.databinding.BindingMethod(attribute = "android:textColorHint", method = "setHintTextColor", type = android.widget.TextView.class), @androidx.databinding.BindingMethod(attribute = "android:textColorLink", method = "setLinkTextColor", type = android.widget.TextView.class), @androidx.databinding.BindingMethod(attribute = "android:onEditorAction", method = "setOnEditorActionListener", type = android.widget.TextView.class)})
@androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
/* loaded from: classes.dex */
public class TextViewBindingAdapter {
    public static final int DECIMAL = 5;
    public static final int INTEGER = 1;
    public static final int SIGNED = 3;
    private static final java.lang.String TAG = "TextViewBindingAdapters";

    /* renamed from: androidx.databinding.adapters.TextViewBindingAdapter$1, reason: invalid class name */
    public class AnonymousClass1 implements android.text.TextWatcher {
        final /* synthetic */ androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged val$after;
        final /* synthetic */ androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged val$before;
        final /* synthetic */ androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged val$on;
        final /* synthetic */ androidx.databinding.InverseBindingListener val$textAttrChanged;

        public AnonymousClass1(androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged beforeTextChanged, androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged onTextChanged, androidx.databinding.InverseBindingListener inverseBindingListener, androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged afterTextChanged) {
            this.val$before = beforeTextChanged;
            this.val$on = onTextChanged;
            this.val$textAttrChanged = inverseBindingListener;
            this.val$after = afterTextChanged;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(android.text.Editable editable) {
            androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged afterTextChanged = this.val$after;
            if (afterTextChanged != null) {
                afterTextChanged.afterTextChanged(editable);
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(java.lang.CharSequence charSequence, int i, int i2, int i3) {
            androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged beforeTextChanged = this.val$before;
            if (beforeTextChanged != null) {
                beforeTextChanged.beforeTextChanged(charSequence, i, i2, i3);
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(java.lang.CharSequence charSequence, int i, int i2, int i3) {
            androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged onTextChanged = this.val$on;
            if (onTextChanged != null) {
                onTextChanged.onTextChanged(charSequence, i, i2, i3);
            }
            androidx.databinding.InverseBindingListener inverseBindingListener = this.val$textAttrChanged;
            if (inverseBindingListener != null) {
                inverseBindingListener.onChange();
            }
        }
    }

    public interface AfterTextChanged {
        void afterTextChanged(android.text.Editable editable);
    }

    public interface BeforeTextChanged {
        void beforeTextChanged(java.lang.CharSequence charSequence, int i, int i2, int i3);
    }

    public interface OnTextChanged {
        void onTextChanged(java.lang.CharSequence charSequence, int i, int i2, int i3);
    }

    @androidx.databinding.InverseBindingAdapter(attribute = "android:text", event = "android:textAttrChanged")
    public static java.lang.String getTextString(android.widget.TextView textView) {
        return textView.getText().toString();
    }

    private static boolean haveContentsChanged(java.lang.CharSequence charSequence, java.lang.CharSequence charSequence2) {
        if ((charSequence == null) != (charSequence2 == null)) {
            return true;
        }
        if (charSequence == null) {
            return false;
        }
        int length = charSequence.length();
        if (length != charSequence2.length()) {
            return true;
        }
        for (int i = 0; i < length; i++) {
            if (charSequence.charAt(i) != charSequence2.charAt(i)) {
                return true;
            }
        }
        return false;
    }

    @androidx.databinding.BindingAdapter({"android:autoText"})
    public static void setAutoText(android.widget.TextView textView, boolean z) {
        android.text.method.KeyListener keyListener = textView.getKeyListener();
        android.text.method.TextKeyListener.Capitalize capitalize = android.text.method.TextKeyListener.Capitalize.NONE;
        int inputType = keyListener != null ? keyListener.getInputType() : 0;
        if ((inputType & 4096) != 0) {
            capitalize = android.text.method.TextKeyListener.Capitalize.CHARACTERS;
        } else if ((inputType & 8192) != 0) {
            capitalize = android.text.method.TextKeyListener.Capitalize.WORDS;
        } else if ((inputType & 16384) != 0) {
            capitalize = android.text.method.TextKeyListener.Capitalize.SENTENCES;
        }
        textView.setKeyListener(android.text.method.TextKeyListener.getInstance(z, capitalize));
    }

    @androidx.databinding.BindingAdapter({"android:bufferType"})
    public static void setBufferType(android.widget.TextView textView, android.widget.TextView.BufferType bufferType) {
        textView.setText(textView.getText(), bufferType);
    }

    @androidx.databinding.BindingAdapter({"android:capitalize"})
    public static void setCapitalize(android.widget.TextView textView, android.text.method.TextKeyListener.Capitalize capitalize) {
        textView.setKeyListener(android.text.method.TextKeyListener.getInstance((textView.getKeyListener().getInputType() & 32768) != 0, capitalize));
    }

    @androidx.databinding.BindingAdapter({"android:digits"})
    public static void setDigits(android.widget.TextView textView, java.lang.CharSequence charSequence) {
        if (charSequence != null) {
            textView.setKeyListener(android.text.method.DigitsKeyListener.getInstance(charSequence.toString()));
        } else if (textView.getKeyListener() instanceof android.text.method.DigitsKeyListener) {
            textView.setKeyListener(null);
        }
    }

    @androidx.databinding.BindingAdapter({"android:drawableBottom"})
    public static void setDrawableBottom(android.widget.TextView textView, android.graphics.drawable.Drawable drawable) {
        setIntrinsicBounds(drawable);
        android.graphics.drawable.Drawable[] compoundDrawables = textView.getCompoundDrawables();
        textView.setCompoundDrawables(compoundDrawables[0], compoundDrawables[1], compoundDrawables[2], drawable);
    }

    @androidx.databinding.BindingAdapter({"android:drawableEnd"})
    public static void setDrawableEnd(android.widget.TextView textView, android.graphics.drawable.Drawable drawable) {
        setIntrinsicBounds(drawable);
        android.graphics.drawable.Drawable[] compoundDrawablesRelative = textView.getCompoundDrawablesRelative();
        textView.setCompoundDrawablesRelative(compoundDrawablesRelative[0], compoundDrawablesRelative[1], drawable, compoundDrawablesRelative[3]);
    }

    @androidx.databinding.BindingAdapter({"android:drawableLeft"})
    public static void setDrawableLeft(android.widget.TextView textView, android.graphics.drawable.Drawable drawable) {
        setIntrinsicBounds(drawable);
        android.graphics.drawable.Drawable[] compoundDrawables = textView.getCompoundDrawables();
        textView.setCompoundDrawables(drawable, compoundDrawables[1], compoundDrawables[2], compoundDrawables[3]);
    }

    @androidx.databinding.BindingAdapter({"android:drawableRight"})
    public static void setDrawableRight(android.widget.TextView textView, android.graphics.drawable.Drawable drawable) {
        setIntrinsicBounds(drawable);
        android.graphics.drawable.Drawable[] compoundDrawables = textView.getCompoundDrawables();
        textView.setCompoundDrawables(compoundDrawables[0], compoundDrawables[1], drawable, compoundDrawables[3]);
    }

    @androidx.databinding.BindingAdapter({"android:drawableStart"})
    public static void setDrawableStart(android.widget.TextView textView, android.graphics.drawable.Drawable drawable) {
        setIntrinsicBounds(drawable);
        android.graphics.drawable.Drawable[] compoundDrawablesRelative = textView.getCompoundDrawablesRelative();
        textView.setCompoundDrawablesRelative(drawable, compoundDrawablesRelative[1], compoundDrawablesRelative[2], compoundDrawablesRelative[3]);
    }

    @androidx.databinding.BindingAdapter({"android:drawableTop"})
    public static void setDrawableTop(android.widget.TextView textView, android.graphics.drawable.Drawable drawable) {
        setIntrinsicBounds(drawable);
        android.graphics.drawable.Drawable[] compoundDrawables = textView.getCompoundDrawables();
        textView.setCompoundDrawables(compoundDrawables[0], drawable, compoundDrawables[2], compoundDrawables[3]);
    }

    @androidx.databinding.BindingAdapter({"android:imeActionId"})
    public static void setImeActionLabel(android.widget.TextView textView, int i) {
        textView.setImeActionLabel(textView.getImeActionLabel(), i);
    }

    @androidx.databinding.BindingAdapter({"android:imeActionLabel"})
    public static void setImeActionLabel(android.widget.TextView textView, java.lang.CharSequence charSequence) {
        textView.setImeActionLabel(charSequence, textView.getImeActionId());
    }

    @androidx.databinding.BindingAdapter({"android:inputMethod"})
    public static void setInputMethod(android.widget.TextView textView, java.lang.CharSequence charSequence) {
        try {
            textView.setKeyListener((android.text.method.KeyListener) java.lang.Class.forName(charSequence.toString()).newInstance());
        } catch (java.lang.ClassNotFoundException unused) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("Could not create input method: ");
            sb.append((java.lang.Object) charSequence);
        } catch (java.lang.IllegalAccessException unused2) {
            java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
            sb2.append("Could not create input method: ");
            sb2.append((java.lang.Object) charSequence);
        } catch (java.lang.InstantiationException unused3) {
            java.lang.StringBuilder sb3 = new java.lang.StringBuilder();
            sb3.append("Could not create input method: ");
            sb3.append((java.lang.Object) charSequence);
        }
    }

    private static void setIntrinsicBounds(android.graphics.drawable.Drawable drawable) {
        if (drawable != null) {
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        }
    }

    @androidx.databinding.BindingAdapter({"android:lineSpacingExtra"})
    public static void setLineSpacingExtra(android.widget.TextView textView, float f) {
        textView.setLineSpacing(f, textView.getLineSpacingMultiplier());
    }

    @androidx.databinding.BindingAdapter({"android:lineSpacingMultiplier"})
    public static void setLineSpacingMultiplier(android.widget.TextView textView, float f) {
        textView.setLineSpacing(textView.getLineSpacingExtra(), f);
    }

    @androidx.databinding.BindingAdapter({"android:maxLength"})
    public static void setMaxLength(android.widget.TextView textView, int i) {
        boolean z;
        android.text.InputFilter[] filters = textView.getFilters();
        if (filters == null) {
            filters = new android.text.InputFilter[]{new android.text.InputFilter.LengthFilter(i)};
        } else {
            int i2 = 0;
            while (true) {
                if (i2 >= filters.length) {
                    z = false;
                    break;
                }
                android.text.InputFilter inputFilter = filters[i2];
                if (inputFilter instanceof android.text.InputFilter.LengthFilter) {
                    if (((android.text.InputFilter.LengthFilter) inputFilter).getMax() != i) {
                        filters[i2] = new android.text.InputFilter.LengthFilter(i);
                    }
                    z = true;
                } else {
                    i2++;
                }
            }
            if (!z) {
                int length = filters.length + 1;
                android.text.InputFilter[] inputFilterArr = new android.text.InputFilter[length];
                java.lang.System.arraycopy(filters, 0, inputFilterArr, 0, filters.length);
                inputFilterArr[length - 1] = new android.text.InputFilter.LengthFilter(i);
                filters = inputFilterArr;
            }
        }
        textView.setFilters(filters);
    }

    @androidx.databinding.BindingAdapter({"android:numeric"})
    public static void setNumeric(android.widget.TextView textView, int i) {
        textView.setKeyListener(android.text.method.DigitsKeyListener.getInstance((i & 3) != 0, (i & 5) != 0));
    }

    @androidx.databinding.BindingAdapter({"android:password"})
    public static void setPassword(android.widget.TextView textView, boolean z) {
        if (z) {
            textView.setTransformationMethod(android.text.method.PasswordTransformationMethod.getInstance());
        } else if (textView.getTransformationMethod() instanceof android.text.method.PasswordTransformationMethod) {
            textView.setTransformationMethod(null);
        }
    }

    @androidx.databinding.BindingAdapter({"android:phoneNumber"})
    public static void setPhoneNumber(android.widget.TextView textView, boolean z) {
        if (z) {
            textView.setKeyListener(android.text.method.DialerKeyListener.getInstance());
        } else if (textView.getKeyListener() instanceof android.text.method.DialerKeyListener) {
            textView.setKeyListener(null);
        }
    }

    @androidx.databinding.BindingAdapter({"android:shadowColor"})
    public static void setShadowColor(android.widget.TextView textView, int i) {
        textView.setShadowLayer(textView.getShadowRadius(), textView.getShadowDx(), textView.getShadowDy(), i);
    }

    @androidx.databinding.BindingAdapter({"android:shadowDx"})
    public static void setShadowDx(android.widget.TextView textView, float f) {
        int shadowColor = textView.getShadowColor();
        textView.setShadowLayer(textView.getShadowRadius(), f, textView.getShadowDy(), shadowColor);
    }

    @androidx.databinding.BindingAdapter({"android:shadowDy"})
    public static void setShadowDy(android.widget.TextView textView, float f) {
        int shadowColor = textView.getShadowColor();
        textView.setShadowLayer(textView.getShadowRadius(), textView.getShadowDx(), f, shadowColor);
    }

    @androidx.databinding.BindingAdapter({"android:shadowRadius"})
    public static void setShadowRadius(android.widget.TextView textView, float f) {
        textView.setShadowLayer(f, textView.getShadowDx(), textView.getShadowDy(), textView.getShadowColor());
    }

    @androidx.databinding.BindingAdapter({"android:text"})
    public static void setText(android.widget.TextView textView, java.lang.CharSequence charSequence) {
        java.lang.CharSequence text = textView.getText();
        if (charSequence != text) {
            if (charSequence == null && text.length() == 0) {
                return;
            }
            if (charSequence instanceof android.text.Spanned) {
                if (charSequence.equals(text)) {
                    return;
                }
            } else if (!haveContentsChanged(charSequence, text)) {
                return;
            }
            textView.setText(charSequence);
        }
    }

    @androidx.databinding.BindingAdapter({"android:textSize"})
    public static void setTextSize(android.widget.TextView textView, float f) {
        textView.setTextSize(0, f);
    }

    @androidx.databinding.BindingAdapter(requireAll = false, value = {"android:beforeTextChanged", "android:onTextChanged", "android:afterTextChanged", "android:textAttrChanged"})
    public static void setTextWatcher(android.widget.TextView textView, androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged beforeTextChanged, androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged onTextChanged, androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged afterTextChanged, androidx.databinding.InverseBindingListener inverseBindingListener) {
        androidx.databinding.adapters.TextViewBindingAdapter.AnonymousClass1 anonymousClass1 = (beforeTextChanged == null && afterTextChanged == null && onTextChanged == null && inverseBindingListener == null) ? null : new androidx.databinding.adapters.TextViewBindingAdapter.AnonymousClass1(beforeTextChanged, onTextChanged, inverseBindingListener, afterTextChanged);
        android.text.TextWatcher textWatcher = (android.text.TextWatcher) androidx.databinding.adapters.ListenerUtil.trackListener(textView, anonymousClass1, androidx.databinding.library.baseAdapters.R.id.textWatcher);
        if (textWatcher != null) {
            textView.removeTextChangedListener(textWatcher);
        }
        if (anonymousClass1 != null) {
            textView.addTextChangedListener(anonymousClass1);
        }
    }
}
