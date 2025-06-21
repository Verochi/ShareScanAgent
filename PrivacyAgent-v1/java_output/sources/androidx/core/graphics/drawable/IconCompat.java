package androidx.core.graphics.drawable;

/* loaded from: classes.dex */
public class IconCompat extends androidx.versionedparcelable.CustomVersionedParcelable {
    private static final float ADAPTIVE_ICON_INSET_FACTOR = 0.25f;
    private static final int AMBIENT_SHADOW_ALPHA = 30;
    private static final float BLUR_FACTOR = 0.010416667f;
    static final android.graphics.PorterDuff.Mode DEFAULT_TINT_MODE = android.graphics.PorterDuff.Mode.SRC_IN;
    private static final float DEFAULT_VIEW_PORT_SCALE = 0.6666667f;

    @androidx.annotation.VisibleForTesting
    static final java.lang.String EXTRA_INT1 = "int1";

    @androidx.annotation.VisibleForTesting
    static final java.lang.String EXTRA_INT2 = "int2";

    @androidx.annotation.VisibleForTesting
    static final java.lang.String EXTRA_OBJ = "obj";

    @androidx.annotation.VisibleForTesting
    static final java.lang.String EXTRA_STRING1 = "string1";

    @androidx.annotation.VisibleForTesting
    static final java.lang.String EXTRA_TINT_LIST = "tint_list";

    @androidx.annotation.VisibleForTesting
    static final java.lang.String EXTRA_TINT_MODE = "tint_mode";

    @androidx.annotation.VisibleForTesting
    static final java.lang.String EXTRA_TYPE = "type";
    private static final float ICON_DIAMETER_FACTOR = 0.9166667f;
    private static final int KEY_SHADOW_ALPHA = 61;
    private static final float KEY_SHADOW_OFFSET_FACTOR = 0.020833334f;
    private static final java.lang.String TAG = "IconCompat";
    public static final int TYPE_ADAPTIVE_BITMAP = 5;
    public static final int TYPE_BITMAP = 1;
    public static final int TYPE_DATA = 3;
    public static final int TYPE_RESOURCE = 2;
    public static final int TYPE_UNKNOWN = -1;
    public static final int TYPE_URI = 4;
    public static final int TYPE_URI_ADAPTIVE_BITMAP = 6;

    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
    public byte[] mData;

    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
    public int mInt1;

    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
    public int mInt2;
    java.lang.Object mObj1;

    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
    public android.os.Parcelable mParcelable;

    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
    public java.lang.String mString1;

    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
    public android.content.res.ColorStateList mTintList;
    android.graphics.PorterDuff.Mode mTintMode;

    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
    public java.lang.String mTintModeStr;

    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int mType;

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
    public @interface IconType {
    }

    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
    public IconCompat() {
        this.mType = -1;
        this.mData = null;
        this.mParcelable = null;
        this.mInt1 = 0;
        this.mInt2 = 0;
        this.mTintList = null;
        this.mTintMode = DEFAULT_TINT_MODE;
        this.mTintModeStr = null;
    }

    private IconCompat(int i) {
        this.mData = null;
        this.mParcelable = null;
        this.mInt1 = 0;
        this.mInt2 = 0;
        this.mTintList = null;
        this.mTintMode = DEFAULT_TINT_MODE;
        this.mTintModeStr = null;
        this.mType = i;
    }

    @androidx.annotation.Nullable
    public static androidx.core.graphics.drawable.IconCompat createFromBundle(@androidx.annotation.NonNull android.os.Bundle bundle) {
        int i = bundle.getInt("type");
        androidx.core.graphics.drawable.IconCompat iconCompat = new androidx.core.graphics.drawable.IconCompat(i);
        iconCompat.mInt1 = bundle.getInt(EXTRA_INT1);
        iconCompat.mInt2 = bundle.getInt(EXTRA_INT2);
        iconCompat.mString1 = bundle.getString(EXTRA_STRING1);
        if (bundle.containsKey(EXTRA_TINT_LIST)) {
            iconCompat.mTintList = (android.content.res.ColorStateList) bundle.getParcelable(EXTRA_TINT_LIST);
        }
        if (bundle.containsKey(EXTRA_TINT_MODE)) {
            iconCompat.mTintMode = android.graphics.PorterDuff.Mode.valueOf(bundle.getString(EXTRA_TINT_MODE));
        }
        switch (i) {
            case -1:
            case 1:
            case 5:
                iconCompat.mObj1 = bundle.getParcelable(EXTRA_OBJ);
                return iconCompat;
            case 0:
            default:
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append("Unknown type ");
                sb.append(i);
                return null;
            case 2:
            case 4:
            case 6:
                iconCompat.mObj1 = bundle.getString(EXTRA_OBJ);
                return iconCompat;
            case 3:
                iconCompat.mObj1 = bundle.getByteArray(EXTRA_OBJ);
                return iconCompat;
        }
    }

    @androidx.annotation.Nullable
    @androidx.annotation.RequiresApi(23)
    public static androidx.core.graphics.drawable.IconCompat createFromIcon(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull android.graphics.drawable.Icon icon) {
        androidx.core.util.Preconditions.checkNotNull(icon);
        int type = getType(icon);
        if (type == 2) {
            java.lang.String resPackage = getResPackage(icon);
            try {
                return createWithResource(getResources(context, resPackage), resPackage, getResId(icon));
            } catch (android.content.res.Resources.NotFoundException unused) {
                throw new java.lang.IllegalArgumentException("Icon resource cannot be found");
            }
        }
        if (type == 4) {
            return createWithContentUri(getUri(icon));
        }
        if (type == 6) {
            return createWithAdaptiveBitmapContentUri(getUri(icon));
        }
        androidx.core.graphics.drawable.IconCompat iconCompat = new androidx.core.graphics.drawable.IconCompat(-1);
        iconCompat.mObj1 = icon;
        return iconCompat;
    }

    @androidx.annotation.Nullable
    @androidx.annotation.RequiresApi(23)
    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static androidx.core.graphics.drawable.IconCompat createFromIcon(@androidx.annotation.NonNull android.graphics.drawable.Icon icon) {
        androidx.core.util.Preconditions.checkNotNull(icon);
        int type = getType(icon);
        if (type == 2) {
            return createWithResource(null, getResPackage(icon), getResId(icon));
        }
        if (type == 4) {
            return createWithContentUri(getUri(icon));
        }
        if (type == 6) {
            return createWithAdaptiveBitmapContentUri(getUri(icon));
        }
        androidx.core.graphics.drawable.IconCompat iconCompat = new androidx.core.graphics.drawable.IconCompat(-1);
        iconCompat.mObj1 = icon;
        return iconCompat;
    }

    @androidx.annotation.Nullable
    @androidx.annotation.RequiresApi(23)
    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static androidx.core.graphics.drawable.IconCompat createFromIconOrNullIfZeroResId(@androidx.annotation.NonNull android.graphics.drawable.Icon icon) {
        if (getType(icon) == 2 && getResId(icon) == 0) {
            return null;
        }
        return createFromIcon(icon);
    }

    @androidx.annotation.VisibleForTesting
    public static android.graphics.Bitmap createLegacyIconFromAdaptiveIcon(android.graphics.Bitmap bitmap, boolean z) {
        int min = (int) (java.lang.Math.min(bitmap.getWidth(), bitmap.getHeight()) * DEFAULT_VIEW_PORT_SCALE);
        android.graphics.Bitmap createBitmap = android.graphics.Bitmap.createBitmap(min, min, android.graphics.Bitmap.Config.ARGB_8888);
        android.graphics.Canvas canvas = new android.graphics.Canvas(createBitmap);
        android.graphics.Paint paint = new android.graphics.Paint(3);
        float f = min;
        float f2 = 0.5f * f;
        float f3 = ICON_DIAMETER_FACTOR * f2;
        if (z) {
            float f4 = BLUR_FACTOR * f;
            paint.setColor(0);
            paint.setShadowLayer(f4, 0.0f, f * KEY_SHADOW_OFFSET_FACTOR, 1023410176);
            canvas.drawCircle(f2, f2, f3, paint);
            paint.setShadowLayer(f4, 0.0f, 0.0f, 503316480);
            canvas.drawCircle(f2, f2, f3, paint);
            paint.clearShadowLayer();
        }
        paint.setColor(androidx.core.view.ViewCompat.MEASURED_STATE_MASK);
        android.graphics.Shader.TileMode tileMode = android.graphics.Shader.TileMode.CLAMP;
        android.graphics.BitmapShader bitmapShader = new android.graphics.BitmapShader(bitmap, tileMode, tileMode);
        android.graphics.Matrix matrix = new android.graphics.Matrix();
        matrix.setTranslate((-(bitmap.getWidth() - min)) / 2, (-(bitmap.getHeight() - min)) / 2);
        bitmapShader.setLocalMatrix(matrix);
        paint.setShader(bitmapShader);
        canvas.drawCircle(f2, f2, f3, paint);
        canvas.setBitmap(null);
        return createBitmap;
    }

    public static androidx.core.graphics.drawable.IconCompat createWithAdaptiveBitmap(android.graphics.Bitmap bitmap) {
        if (bitmap == null) {
            throw new java.lang.IllegalArgumentException("Bitmap must not be null.");
        }
        androidx.core.graphics.drawable.IconCompat iconCompat = new androidx.core.graphics.drawable.IconCompat(5);
        iconCompat.mObj1 = bitmap;
        return iconCompat;
    }

    @androidx.annotation.NonNull
    public static androidx.core.graphics.drawable.IconCompat createWithAdaptiveBitmapContentUri(@androidx.annotation.NonNull android.net.Uri uri) {
        if (uri != null) {
            return createWithAdaptiveBitmapContentUri(uri.toString());
        }
        throw new java.lang.IllegalArgumentException("Uri must not be null.");
    }

    @androidx.annotation.NonNull
    public static androidx.core.graphics.drawable.IconCompat createWithAdaptiveBitmapContentUri(@androidx.annotation.NonNull java.lang.String str) {
        if (str == null) {
            throw new java.lang.IllegalArgumentException("Uri must not be null.");
        }
        androidx.core.graphics.drawable.IconCompat iconCompat = new androidx.core.graphics.drawable.IconCompat(6);
        iconCompat.mObj1 = str;
        return iconCompat;
    }

    public static androidx.core.graphics.drawable.IconCompat createWithBitmap(android.graphics.Bitmap bitmap) {
        if (bitmap == null) {
            throw new java.lang.IllegalArgumentException("Bitmap must not be null.");
        }
        androidx.core.graphics.drawable.IconCompat iconCompat = new androidx.core.graphics.drawable.IconCompat(1);
        iconCompat.mObj1 = bitmap;
        return iconCompat;
    }

    public static androidx.core.graphics.drawable.IconCompat createWithContentUri(android.net.Uri uri) {
        if (uri != null) {
            return createWithContentUri(uri.toString());
        }
        throw new java.lang.IllegalArgumentException("Uri must not be null.");
    }

    public static androidx.core.graphics.drawable.IconCompat createWithContentUri(java.lang.String str) {
        if (str == null) {
            throw new java.lang.IllegalArgumentException("Uri must not be null.");
        }
        androidx.core.graphics.drawable.IconCompat iconCompat = new androidx.core.graphics.drawable.IconCompat(4);
        iconCompat.mObj1 = str;
        return iconCompat;
    }

    public static androidx.core.graphics.drawable.IconCompat createWithData(byte[] bArr, int i, int i2) {
        if (bArr == null) {
            throw new java.lang.IllegalArgumentException("Data must not be null.");
        }
        androidx.core.graphics.drawable.IconCompat iconCompat = new androidx.core.graphics.drawable.IconCompat(3);
        iconCompat.mObj1 = bArr;
        iconCompat.mInt1 = i;
        iconCompat.mInt2 = i2;
        return iconCompat;
    }

    public static androidx.core.graphics.drawable.IconCompat createWithResource(android.content.Context context, @androidx.annotation.DrawableRes int i) {
        if (context != null) {
            return createWithResource(context.getResources(), context.getPackageName(), i);
        }
        throw new java.lang.IllegalArgumentException("Context must not be null.");
    }

    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static androidx.core.graphics.drawable.IconCompat createWithResource(android.content.res.Resources resources, java.lang.String str, @androidx.annotation.DrawableRes int i) {
        if (str == null) {
            throw new java.lang.IllegalArgumentException("Package must not be null.");
        }
        if (i == 0) {
            throw new java.lang.IllegalArgumentException("Drawable resource ID must not be 0");
        }
        androidx.core.graphics.drawable.IconCompat iconCompat = new androidx.core.graphics.drawable.IconCompat(2);
        iconCompat.mInt1 = i;
        if (resources != null) {
            try {
                iconCompat.mObj1 = resources.getResourceName(i);
            } catch (android.content.res.Resources.NotFoundException unused) {
                throw new java.lang.IllegalArgumentException("Icon resource cannot be found");
            }
        } else {
            iconCompat.mObj1 = str;
        }
        iconCompat.mString1 = str;
        return iconCompat;
    }

    @androidx.annotation.DrawableRes
    @androidx.annotation.IdRes
    @androidx.annotation.RequiresApi(23)
    private static int getResId(@androidx.annotation.NonNull android.graphics.drawable.Icon icon) {
        int resId;
        if (android.os.Build.VERSION.SDK_INT >= 28) {
            resId = icon.getResId();
            return resId;
        }
        try {
            return ((java.lang.Integer) icon.getClass().getMethod("getResId", new java.lang.Class[0]).invoke(icon, new java.lang.Object[0])).intValue();
        } catch (java.lang.IllegalAccessException | java.lang.NoSuchMethodException | java.lang.reflect.InvocationTargetException unused) {
            return 0;
        }
    }

    @androidx.annotation.Nullable
    @androidx.annotation.RequiresApi(23)
    private static java.lang.String getResPackage(@androidx.annotation.NonNull android.graphics.drawable.Icon icon) {
        java.lang.String resPackage;
        if (android.os.Build.VERSION.SDK_INT >= 28) {
            resPackage = icon.getResPackage();
            return resPackage;
        }
        try {
            return (java.lang.String) icon.getClass().getMethod("getResPackage", new java.lang.Class[0]).invoke(icon, new java.lang.Object[0]);
        } catch (java.lang.IllegalAccessException | java.lang.NoSuchMethodException | java.lang.reflect.InvocationTargetException unused) {
            return null;
        }
    }

    private static android.content.res.Resources getResources(android.content.Context context, java.lang.String str) {
        if (com.aliyun.vod.log.core.AliyunLogCommon.OPERATION_SYSTEM.equals(str)) {
            return android.content.res.Resources.getSystem();
        }
        android.content.pm.PackageManager packageManager = context.getPackageManager();
        try {
            android.content.pm.ApplicationInfo applicationInfo = packageManager.getApplicationInfo(str, 8192);
            if (applicationInfo != null) {
                return packageManager.getResourcesForApplication(applicationInfo);
            }
            return null;
        } catch (android.content.pm.PackageManager.NameNotFoundException unused) {
            java.lang.String.format("Unable to find pkg=%s for icon", str);
            return null;
        }
    }

    @androidx.annotation.RequiresApi(23)
    private static int getType(@androidx.annotation.NonNull android.graphics.drawable.Icon icon) {
        int type;
        if (android.os.Build.VERSION.SDK_INT >= 28) {
            type = icon.getType();
            return type;
        }
        try {
            return ((java.lang.Integer) icon.getClass().getMethod("getType", new java.lang.Class[0]).invoke(icon, new java.lang.Object[0])).intValue();
        } catch (java.lang.IllegalAccessException unused) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("Unable to get icon type ");
            sb.append(icon);
            return -1;
        } catch (java.lang.NoSuchMethodException unused2) {
            java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
            sb2.append("Unable to get icon type ");
            sb2.append(icon);
            return -1;
        } catch (java.lang.reflect.InvocationTargetException unused3) {
            java.lang.StringBuilder sb3 = new java.lang.StringBuilder();
            sb3.append("Unable to get icon type ");
            sb3.append(icon);
            return -1;
        }
    }

    @androidx.annotation.Nullable
    @androidx.annotation.RequiresApi(23)
    private static android.net.Uri getUri(@androidx.annotation.NonNull android.graphics.drawable.Icon icon) {
        android.net.Uri uri;
        if (android.os.Build.VERSION.SDK_INT >= 28) {
            uri = icon.getUri();
            return uri;
        }
        try {
            return (android.net.Uri) icon.getClass().getMethod("getUri", new java.lang.Class[0]).invoke(icon, new java.lang.Object[0]);
        } catch (java.lang.IllegalAccessException | java.lang.NoSuchMethodException | java.lang.reflect.InvocationTargetException unused) {
            return null;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private android.graphics.drawable.Drawable loadDrawableInner(android.content.Context context) {
        switch (this.mType) {
            case 1:
                return new android.graphics.drawable.BitmapDrawable(context.getResources(), (android.graphics.Bitmap) this.mObj1);
            case 2:
                java.lang.String resPackage = getResPackage();
                if (android.text.TextUtils.isEmpty(resPackage)) {
                    resPackage = context.getPackageName();
                }
                try {
                    return androidx.core.content.res.ResourcesCompat.getDrawable(getResources(context, resPackage), this.mInt1, context.getTheme());
                } catch (java.lang.RuntimeException unused) {
                    java.lang.String.format("Unable to load resource 0x%08x from pkg=%s", java.lang.Integer.valueOf(this.mInt1), this.mObj1);
                    break;
                }
            case 3:
                return new android.graphics.drawable.BitmapDrawable(context.getResources(), android.graphics.BitmapFactory.decodeByteArray((byte[]) this.mObj1, this.mInt1, this.mInt2));
            case 4:
                java.io.InputStream uriInputStream = getUriInputStream(context);
                if (uriInputStream != null) {
                    return new android.graphics.drawable.BitmapDrawable(context.getResources(), android.graphics.BitmapFactory.decodeStream(uriInputStream));
                }
                return null;
            case 5:
                return new android.graphics.drawable.BitmapDrawable(context.getResources(), createLegacyIconFromAdaptiveIcon((android.graphics.Bitmap) this.mObj1, false));
            case 6:
                java.io.InputStream uriInputStream2 = getUriInputStream(context);
                if (uriInputStream2 != null) {
                    return android.os.Build.VERSION.SDK_INT >= 26 ? new android.graphics.drawable.AdaptiveIconDrawable(null, new android.graphics.drawable.BitmapDrawable(context.getResources(), android.graphics.BitmapFactory.decodeStream(uriInputStream2))) : new android.graphics.drawable.BitmapDrawable(context.getResources(), createLegacyIconFromAdaptiveIcon(android.graphics.BitmapFactory.decodeStream(uriInputStream2), false));
                }
                return null;
            default:
                return null;
        }
    }

    private static java.lang.String typeToString(int i) {
        switch (i) {
            case 1:
                return "BITMAP";
            case 2:
                return "RESOURCE";
            case 3:
                return "DATA";
            case 4:
                return "URI";
            case 5:
                return "BITMAP_MASKABLE";
            case 6:
                return "URI_MASKABLE";
            default:
                return com.huawei.hms.framework.network.grs.GrsBaseInfo.CountryCodeSource.UNKNOWN;
        }
    }

    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void addToShortcutIntent(@androidx.annotation.NonNull android.content.Intent intent, @androidx.annotation.Nullable android.graphics.drawable.Drawable drawable, @androidx.annotation.NonNull android.content.Context context) {
        android.graphics.Bitmap bitmap;
        checkResource(context);
        int i = this.mType;
        if (i == 1) {
            bitmap = (android.graphics.Bitmap) this.mObj1;
            if (drawable != null) {
                bitmap = bitmap.copy(bitmap.getConfig(), true);
            }
        } else if (i == 2) {
            try {
                android.content.Context createPackageContext = context.createPackageContext(getResPackage(), 0);
                if (drawable == null) {
                    intent.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", android.content.Intent.ShortcutIconResource.fromContext(createPackageContext, this.mInt1));
                    return;
                }
                android.graphics.drawable.Drawable drawable2 = androidx.core.content.ContextCompat.getDrawable(createPackageContext, this.mInt1);
                if (drawable2.getIntrinsicWidth() > 0 && drawable2.getIntrinsicHeight() > 0) {
                    bitmap = android.graphics.Bitmap.createBitmap(drawable2.getIntrinsicWidth(), drawable2.getIntrinsicHeight(), android.graphics.Bitmap.Config.ARGB_8888);
                    drawable2.setBounds(0, 0, bitmap.getWidth(), bitmap.getHeight());
                    drawable2.draw(new android.graphics.Canvas(bitmap));
                }
                int launcherLargeIconSize = ((android.app.ActivityManager) createPackageContext.getSystemService("activity")).getLauncherLargeIconSize();
                bitmap = android.graphics.Bitmap.createBitmap(launcherLargeIconSize, launcherLargeIconSize, android.graphics.Bitmap.Config.ARGB_8888);
                drawable2.setBounds(0, 0, bitmap.getWidth(), bitmap.getHeight());
                drawable2.draw(new android.graphics.Canvas(bitmap));
            } catch (android.content.pm.PackageManager.NameNotFoundException e) {
                throw new java.lang.IllegalArgumentException("Can't find package " + this.mObj1, e);
            }
        } else {
            if (i != 5) {
                throw new java.lang.IllegalArgumentException("Icon type not supported for intent shortcuts");
            }
            bitmap = createLegacyIconFromAdaptiveIcon((android.graphics.Bitmap) this.mObj1, true);
        }
        if (drawable != null) {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            drawable.setBounds(width / 2, height / 2, width, height);
            drawable.draw(new android.graphics.Canvas(bitmap));
        }
        intent.putExtra("android.intent.extra.shortcut.ICON", bitmap);
    }

    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void checkResource(@androidx.annotation.NonNull android.content.Context context) {
        java.lang.Object obj;
        if (this.mType != 2 || (obj = this.mObj1) == null) {
            return;
        }
        java.lang.String str = (java.lang.String) obj;
        if (str.contains(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR)) {
            java.lang.String str2 = str.split(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR, -1)[1];
            java.lang.String str3 = str2.split(net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR, -1)[0];
            java.lang.String str4 = str2.split(net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR, -1)[1];
            java.lang.String str5 = str.split(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR, -1)[0];
            if ("0_resource_name_obfuscated".equals(str4)) {
                return;
            }
            java.lang.String resPackage = getResPackage();
            int identifier = getResources(context, resPackage).getIdentifier(str4, str3, str5);
            if (this.mInt1 != identifier) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append("Id has changed for ");
                sb.append(resPackage);
                sb.append(" ");
                sb.append(str);
                this.mInt1 = identifier;
            }
        }
    }

    @androidx.annotation.Nullable
    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public android.graphics.Bitmap getBitmap() {
        int i = this.mType;
        if (i == -1 && android.os.Build.VERSION.SDK_INT >= 23) {
            java.lang.Object obj = this.mObj1;
            if (obj instanceof android.graphics.Bitmap) {
                return (android.graphics.Bitmap) obj;
            }
            return null;
        }
        if (i == 1) {
            return (android.graphics.Bitmap) this.mObj1;
        }
        if (i == 5) {
            return createLegacyIconFromAdaptiveIcon((android.graphics.Bitmap) this.mObj1, true);
        }
        throw new java.lang.IllegalStateException("called getBitmap() on " + this);
    }

    @androidx.annotation.IdRes
    public int getResId() {
        int i = this.mType;
        if (i == -1 && android.os.Build.VERSION.SDK_INT >= 23) {
            return getResId((android.graphics.drawable.Icon) this.mObj1);
        }
        if (i == 2) {
            return this.mInt1;
        }
        throw new java.lang.IllegalStateException("called getResId() on " + this);
    }

    @androidx.annotation.NonNull
    public java.lang.String getResPackage() {
        int i = this.mType;
        if (i == -1 && android.os.Build.VERSION.SDK_INT >= 23) {
            return getResPackage((android.graphics.drawable.Icon) this.mObj1);
        }
        if (i == 2) {
            return android.text.TextUtils.isEmpty(this.mString1) ? ((java.lang.String) this.mObj1).split(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR, -1)[0] : this.mString1;
        }
        throw new java.lang.IllegalStateException("called getResPackage() on " + this);
    }

    public int getType() {
        int i = this.mType;
        return (i != -1 || android.os.Build.VERSION.SDK_INT < 23) ? i : getType((android.graphics.drawable.Icon) this.mObj1);
    }

    @androidx.annotation.NonNull
    public android.net.Uri getUri() {
        int i = this.mType;
        if (i == -1 && android.os.Build.VERSION.SDK_INT >= 23) {
            return getUri((android.graphics.drawable.Icon) this.mObj1);
        }
        if (i == 4 || i == 6) {
            return android.net.Uri.parse((java.lang.String) this.mObj1);
        }
        throw new java.lang.IllegalStateException("called getUri() on " + this);
    }

    @androidx.annotation.Nullable
    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    public java.io.InputStream getUriInputStream(@androidx.annotation.NonNull android.content.Context context) {
        android.net.Uri uri = getUri();
        java.lang.String scheme = uri.getScheme();
        if ("content".equals(scheme) || "file".equals(scheme)) {
            try {
                return context.getContentResolver().openInputStream(uri);
            } catch (java.lang.Exception unused) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append("Unable to load image from URI: ");
                sb.append(uri);
                return null;
            }
        }
        try {
            return new java.io.FileInputStream(new java.io.File((java.lang.String) this.mObj1));
        } catch (java.io.FileNotFoundException unused2) {
            java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
            sb2.append("Unable to load image from path: ");
            sb2.append(uri);
            return null;
        }
    }

    @androidx.annotation.Nullable
    public android.graphics.drawable.Drawable loadDrawable(@androidx.annotation.NonNull android.content.Context context) {
        android.graphics.drawable.Drawable loadDrawable;
        checkResource(context);
        if (android.os.Build.VERSION.SDK_INT >= 23) {
            loadDrawable = toIcon(context).loadDrawable(context);
            return loadDrawable;
        }
        android.graphics.drawable.Drawable loadDrawableInner = loadDrawableInner(context);
        if (loadDrawableInner != null && (this.mTintList != null || this.mTintMode != DEFAULT_TINT_MODE)) {
            loadDrawableInner.mutate();
            androidx.core.graphics.drawable.DrawableCompat.setTintList(loadDrawableInner, this.mTintList);
            androidx.core.graphics.drawable.DrawableCompat.setTintMode(loadDrawableInner, this.mTintMode);
        }
        return loadDrawableInner;
    }

    @Override // androidx.versionedparcelable.CustomVersionedParcelable
    public void onPostParceling() {
        this.mTintMode = android.graphics.PorterDuff.Mode.valueOf(this.mTintModeStr);
        switch (this.mType) {
            case -1:
                android.os.Parcelable parcelable = this.mParcelable;
                if (parcelable == null) {
                    throw new java.lang.IllegalArgumentException("Invalid icon");
                }
                this.mObj1 = parcelable;
                return;
            case 0:
            default:
                return;
            case 1:
            case 5:
                android.os.Parcelable parcelable2 = this.mParcelable;
                if (parcelable2 != null) {
                    this.mObj1 = parcelable2;
                    return;
                }
                byte[] bArr = this.mData;
                this.mObj1 = bArr;
                this.mType = 3;
                this.mInt1 = 0;
                this.mInt2 = bArr.length;
                return;
            case 2:
            case 4:
            case 6:
                java.lang.String str = new java.lang.String(this.mData, java.nio.charset.Charset.forName("UTF-16"));
                this.mObj1 = str;
                if (this.mType == 2 && this.mString1 == null) {
                    this.mString1 = str.split(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR, -1)[0];
                    return;
                }
                return;
            case 3:
                this.mObj1 = this.mData;
                return;
        }
    }

    @Override // androidx.versionedparcelable.CustomVersionedParcelable
    public void onPreParceling(boolean z) {
        this.mTintModeStr = this.mTintMode.name();
        switch (this.mType) {
            case -1:
                if (z) {
                    throw new java.lang.IllegalArgumentException("Can't serialize Icon created with IconCompat#createFromIcon");
                }
                this.mParcelable = (android.os.Parcelable) this.mObj1;
                return;
            case 0:
            default:
                return;
            case 1:
            case 5:
                if (!z) {
                    this.mParcelable = (android.os.Parcelable) this.mObj1;
                    return;
                }
                android.graphics.Bitmap bitmap = (android.graphics.Bitmap) this.mObj1;
                java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
                bitmap.compress(android.graphics.Bitmap.CompressFormat.PNG, 90, byteArrayOutputStream);
                this.mData = byteArrayOutputStream.toByteArray();
                return;
            case 2:
                this.mData = ((java.lang.String) this.mObj1).getBytes(java.nio.charset.Charset.forName("UTF-16"));
                return;
            case 3:
                this.mData = (byte[]) this.mObj1;
                return;
            case 4:
            case 6:
                this.mData = this.mObj1.toString().getBytes(java.nio.charset.Charset.forName("UTF-16"));
                return;
        }
    }

    public androidx.core.graphics.drawable.IconCompat setTint(@androidx.annotation.ColorInt int i) {
        return setTintList(android.content.res.ColorStateList.valueOf(i));
    }

    public androidx.core.graphics.drawable.IconCompat setTintList(android.content.res.ColorStateList colorStateList) {
        this.mTintList = colorStateList;
        return this;
    }

    public androidx.core.graphics.drawable.IconCompat setTintMode(android.graphics.PorterDuff.Mode mode) {
        this.mTintMode = mode;
        return this;
    }

    @androidx.annotation.NonNull
    public android.os.Bundle toBundle() {
        android.os.Bundle bundle = new android.os.Bundle();
        switch (this.mType) {
            case -1:
                bundle.putParcelable(EXTRA_OBJ, (android.os.Parcelable) this.mObj1);
                break;
            case 0:
            default:
                throw new java.lang.IllegalArgumentException("Invalid icon");
            case 1:
            case 5:
                bundle.putParcelable(EXTRA_OBJ, (android.graphics.Bitmap) this.mObj1);
                break;
            case 2:
            case 4:
            case 6:
                bundle.putString(EXTRA_OBJ, (java.lang.String) this.mObj1);
                break;
            case 3:
                bundle.putByteArray(EXTRA_OBJ, (byte[]) this.mObj1);
                break;
        }
        bundle.putInt("type", this.mType);
        bundle.putInt(EXTRA_INT1, this.mInt1);
        bundle.putInt(EXTRA_INT2, this.mInt2);
        bundle.putString(EXTRA_STRING1, this.mString1);
        android.content.res.ColorStateList colorStateList = this.mTintList;
        if (colorStateList != null) {
            bundle.putParcelable(EXTRA_TINT_LIST, colorStateList);
        }
        android.graphics.PorterDuff.Mode mode = this.mTintMode;
        if (mode != DEFAULT_TINT_MODE) {
            bundle.putString(EXTRA_TINT_MODE, mode.name());
        }
        return bundle;
    }

    @androidx.annotation.NonNull
    @androidx.annotation.RequiresApi(23)
    @java.lang.Deprecated
    public android.graphics.drawable.Icon toIcon() {
        return toIcon(null);
    }

    @androidx.annotation.NonNull
    @androidx.annotation.RequiresApi(23)
    public android.graphics.drawable.Icon toIcon(@androidx.annotation.Nullable android.content.Context context) {
        android.graphics.drawable.Icon createWithBitmap;
        switch (this.mType) {
            case -1:
                return (android.graphics.drawable.Icon) this.mObj1;
            case 0:
            default:
                throw new java.lang.IllegalArgumentException("Unknown type");
            case 1:
                createWithBitmap = android.graphics.drawable.Icon.createWithBitmap((android.graphics.Bitmap) this.mObj1);
                break;
            case 2:
                createWithBitmap = android.graphics.drawable.Icon.createWithResource(getResPackage(), this.mInt1);
                break;
            case 3:
                createWithBitmap = android.graphics.drawable.Icon.createWithData((byte[]) this.mObj1, this.mInt1, this.mInt2);
                break;
            case 4:
                createWithBitmap = android.graphics.drawable.Icon.createWithContentUri((java.lang.String) this.mObj1);
                break;
            case 5:
                if (android.os.Build.VERSION.SDK_INT < 26) {
                    createWithBitmap = android.graphics.drawable.Icon.createWithBitmap(createLegacyIconFromAdaptiveIcon((android.graphics.Bitmap) this.mObj1, false));
                    break;
                } else {
                    createWithBitmap = android.graphics.drawable.Icon.createWithAdaptiveBitmap((android.graphics.Bitmap) this.mObj1);
                    break;
                }
            case 6:
                int i = android.os.Build.VERSION.SDK_INT;
                if (i >= 30) {
                    createWithBitmap = android.graphics.drawable.Icon.createWithAdaptiveBitmapContentUri(getUri());
                    break;
                } else {
                    if (context == null) {
                        throw new java.lang.IllegalArgumentException("Context is required to resolve the file uri of the icon: " + getUri());
                    }
                    java.io.InputStream uriInputStream = getUriInputStream(context);
                    if (uriInputStream == null) {
                        throw new java.lang.IllegalStateException("Cannot load adaptive icon from uri: " + getUri());
                    }
                    if (i < 26) {
                        createWithBitmap = android.graphics.drawable.Icon.createWithBitmap(createLegacyIconFromAdaptiveIcon(android.graphics.BitmapFactory.decodeStream(uriInputStream), false));
                        break;
                    } else {
                        createWithBitmap = android.graphics.drawable.Icon.createWithAdaptiveBitmap(android.graphics.BitmapFactory.decodeStream(uriInputStream));
                        break;
                    }
                }
        }
        android.content.res.ColorStateList colorStateList = this.mTintList;
        if (colorStateList != null) {
            createWithBitmap.setTintList(colorStateList);
        }
        android.graphics.PorterDuff.Mode mode = this.mTintMode;
        if (mode != DEFAULT_TINT_MODE) {
            createWithBitmap.setTintMode(mode);
        }
        return createWithBitmap;
    }

    @androidx.annotation.NonNull
    public java.lang.String toString() {
        if (this.mType == -1) {
            return java.lang.String.valueOf(this.mObj1);
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder("Icon(typ=");
        sb.append(typeToString(this.mType));
        switch (this.mType) {
            case 1:
            case 5:
                sb.append(" size=");
                sb.append(((android.graphics.Bitmap) this.mObj1).getWidth());
                sb.append("x");
                sb.append(((android.graphics.Bitmap) this.mObj1).getHeight());
                break;
            case 2:
                sb.append(" pkg=");
                sb.append(this.mString1);
                sb.append(" id=");
                sb.append(java.lang.String.format("0x%08x", java.lang.Integer.valueOf(getResId())));
                break;
            case 3:
                sb.append(" len=");
                sb.append(this.mInt1);
                if (this.mInt2 != 0) {
                    sb.append(" off=");
                    sb.append(this.mInt2);
                    break;
                }
                break;
            case 4:
            case 6:
                sb.append(" uri=");
                sb.append(this.mObj1);
                break;
        }
        if (this.mTintList != null) {
            sb.append(" tint=");
            sb.append(this.mTintList);
        }
        if (this.mTintMode != DEFAULT_TINT_MODE) {
            sb.append(" mode=");
            sb.append(this.mTintMode);
        }
        sb.append(")");
        return sb.toString();
    }
}
