package com.aliyun.svideo.base;

/* loaded from: classes.dex */
public class UIConfigManager {
    public static final java.lang.String TAG = "UIConfigManager";

    public static android.graphics.drawable.Drawable getDrawableResources(android.content.Context context, int i, int i2) {
        android.content.res.TypedArray obtainStyledAttributes = context.obtainStyledAttributes(new int[]{i});
        android.graphics.drawable.Drawable drawable = context.getResources().getDrawable(obtainStyledAttributes.getResourceId(0, i2));
        obtainStyledAttributes.recycle();
        return drawable;
    }

    public static void setImageBackgroundConfig(android.view.View view, int i, int i2) {
        android.content.res.TypedArray obtainStyledAttributes = view.getContext().obtainStyledAttributes(new int[]{i});
        view.setBackgroundResource(obtainStyledAttributes.getResourceId(0, i2));
        obtainStyledAttributes.recycle();
    }

    public static void setImageResourceConfig(android.widget.ImageView imageView, int i, int i2) {
        android.content.res.TypedArray obtainStyledAttributes = imageView.getContext().obtainStyledAttributes(new int[]{i});
        imageView.setImageResource(obtainStyledAttributes.getResourceId(0, i2));
        obtainStyledAttributes.recycle();
    }

    public static void setImageResourceConfig(android.widget.TextView textView, int i, int i2, int i3) {
        int[] iArr = {0, 0, 0, 0};
        android.content.res.TypedArray obtainStyledAttributes = textView.getContext().obtainStyledAttributes(new int[]{i2});
        iArr[i] = obtainStyledAttributes.getResourceId(0, i3);
        textView.setCompoundDrawablesWithIntrinsicBounds(iArr[0], iArr[1], iArr[2], iArr[3]);
        obtainStyledAttributes.recycle();
    }

    public static void setImageResourceConfig(android.widget.ImageView[] imageViewArr, int[] iArr, int[] iArr2) {
        if (imageViewArr.length <= 0) {
            return;
        }
        android.content.res.TypedArray obtainStyledAttributes = imageViewArr[0].getContext().obtainStyledAttributes(iArr);
        for (int i = 0; i < imageViewArr.length; i++) {
            imageViewArr[i].setImageResource(obtainStyledAttributes.getResourceId(i, iArr2[i]));
        }
        obtainStyledAttributes.recycle();
    }

    public static void setImageResourceConfig(android.widget.TextView[] textViewArr, int[] iArr, int[] iArr2, int[] iArr3) {
        if (textViewArr.length <= 0) {
            return;
        }
        android.content.res.TypedArray obtainStyledAttributes = textViewArr[0].getContext().obtainStyledAttributes(iArr2);
        for (int i = 0; i < textViewArr.length; i++) {
            int[] iArr4 = {0, 0, 0, 0};
            iArr4[iArr[i]] = obtainStyledAttributes.getResourceId(i, iArr3[i]);
            textViewArr[i].setCompoundDrawablesWithIntrinsicBounds(iArr4[0], iArr4[1], iArr4[2], iArr4[3]);
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("textView : ");
            sb.append((java.lang.Object) textViewArr[i].getText());
            sb.append(" ,drawable : ");
            sb.append(java.util.Arrays.toString(iArr4));
        }
        java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
        sb2.append("TypedArray.recycle , count : ");
        sb2.append(textViewArr.length);
        obtainStyledAttributes.recycle();
    }
}
