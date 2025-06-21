package androidx.appcompat.app;

@androidx.annotation.Keep
@kotlin.Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0014J\"\u0010\u0017\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u0016H\u0014J$\u0010\u0019\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\b2\b\u0010\u001a\u001a\u0004\u0018\u00010\bH\u0002J\"\u0010\u001b\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0018\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\b2\u0006\u0010 \u001a\u00020!H\u0002R\u0018\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\tR$\u0010\n\u001a\u0018\u0012\u0004\u0012\u00020\b\u0012\u000e\u0012\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\r0\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u000e\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u000f0\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0010¨\u0006\""}, d2 = {"Landroidx/appcompat/app/MJViewInflater;", "Landroidx/appcompat/app/AppCompatViewInflater;", "()V", "mConstructorArgs", "", "", "[Ljava/lang/Object;", "sClassPrefixList", "", "[Ljava/lang/String;", "sConstructorMap", "", "Ljava/lang/reflect/Constructor;", "Landroid/view/View;", "sConstructorSignature", "Ljava/lang/Class;", "[Ljava/lang/Class;", "createImageView", "Landroidx/appcompat/widget/AppCompatImageView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "createView", "name", "createViewByPrefix", com.alibaba.sdk.android.oss.common.RequestParameters.PREFIX, "createViewFromTag", "tag", "debugLog", "", "msg", "e", "", "MJWidget_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class MJViewInflater extends androidx.appcompat.app.AppCompatViewInflater {

    @org.jetbrains.annotations.NotNull
    private final java.lang.Class<? extends java.lang.Object>[] sConstructorSignature = {android.content.Context.class, android.util.AttributeSet.class};

    @org.jetbrains.annotations.NotNull
    private final java.lang.String[] sClassPrefixList = {"android.widget.", "android.view.", "android.webkit."};

    @org.jetbrains.annotations.NotNull
    private final java.util.Map<java.lang.String, java.lang.reflect.Constructor<? extends android.view.View>> sConstructorMap = new androidx.collection.ArrayMap();

    @org.jetbrains.annotations.NotNull
    private final java.lang.Object[] mConstructorArgs = new java.lang.Object[2];

    private final android.view.View createViewByPrefix(android.content.Context context, java.lang.String name, java.lang.String prefix) throws java.lang.ClassNotFoundException, android.view.InflateException {
        java.lang.String str;
        try {
            java.lang.reflect.Constructor<? extends android.view.View> constructor = this.sConstructorMap.get(name);
            if (constructor == null) {
                if (prefix != null) {
                    str = prefix + name;
                } else {
                    str = name;
                }
                java.lang.Class<? extends U> asSubclass = java.lang.Class.forName(str, false, context.getClassLoader()).asSubclass(android.view.View.class);
                java.lang.Class<? extends java.lang.Object>[] clsArr = this.sConstructorSignature;
                constructor = asSubclass.getConstructor((java.lang.Class[]) java.util.Arrays.copyOf(clsArr, clsArr.length));
                this.sConstructorMap.put(name, constructor);
            }
            if (constructor != null) {
                constructor.setAccessible(true);
            }
            if (constructor == null) {
                return null;
            }
            java.lang.Object[] objArr = this.mConstructorArgs;
            return constructor.newInstance(java.util.Arrays.copyOf(objArr, objArr.length));
        } catch (java.lang.Exception e) {
            debugLog("createViewByPrefix", e);
            return null;
        }
    }

    private final android.view.View createViewFromTag(android.content.Context context, java.lang.String tag, android.util.AttributeSet attrs) {
        android.view.View createViewByPrefix;
        if (kotlin.jvm.internal.Intrinsics.areEqual(com.anythink.expressad.a.B, tag)) {
            tag = attrs.getAttributeValue(null, "class");
        }
        try {
            java.lang.Object[] objArr = this.mConstructorArgs;
            objArr[0] = context;
            objArr[1] = attrs;
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(tag, "name");
            if (-1 == kotlin.text.StringsKt__StringsKt.indexOf$default((java.lang.CharSequence) tag, '.', 0, false, 6, (java.lang.Object) null)) {
                int length = this.sClassPrefixList.length;
                for (int i = 0; i < length; i++) {
                    android.view.View createViewByPrefix2 = createViewByPrefix(context, tag, this.sClassPrefixList[i]);
                    if (createViewByPrefix2 != null) {
                        return createViewByPrefix2;
                    }
                }
                createViewByPrefix = null;
            } else {
                createViewByPrefix = createViewByPrefix(context, tag, null);
            }
            java.lang.Object[] objArr2 = this.mConstructorArgs;
            objArr2[0] = null;
            objArr2[1] = null;
            return createViewByPrefix;
        } catch (java.lang.Exception e) {
            debugLog("createViewFromTag", e);
            return null;
        } finally {
            java.lang.Object[] objArr3 = this.mConstructorArgs;
            objArr3[0] = null;
            objArr3[1] = null;
        }
    }

    private final void debugLog(java.lang.String msg, java.lang.Throwable e) {
        if (com.moji.tool.log.MJLogger.isDevelopMode()) {
            com.moji.tool.log.MJLogger.e("MJViewInflater", msg, e);
        }
    }

    @Override // androidx.appcompat.app.AppCompatViewInflater
    @org.jetbrains.annotations.NotNull
    public androidx.appcompat.widget.AppCompatImageView createImageView(@org.jetbrains.annotations.NotNull android.content.Context context, @org.jetbrains.annotations.Nullable android.util.AttributeSet attrs) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(context, "context");
        return new com.moji.imageview.MJImageView(context, attrs, 0, 4, (kotlin.jvm.internal.DefaultConstructorMarker) null);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
    java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterative(DepthRegionTraversal.java:31)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visit(SwitchOverStringVisitor.java:60)
     */
    @Override // androidx.appcompat.app.AppCompatViewInflater
    @org.jetbrains.annotations.Nullable
    public android.view.View createView(@org.jetbrains.annotations.NotNull android.content.Context context, @org.jetbrains.annotations.NotNull java.lang.String name, @org.jetbrains.annotations.NotNull android.util.AttributeSet attrs) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(context, "context");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(name, "name");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(attrs, "attrs");
        switch (name.hashCode()) {
            case -1944884267:
                if (name.equals("com.moji.imageview.MJImageView")) {
                    return new com.moji.imageview.MJImageView(context, attrs, 0, 4, (kotlin.jvm.internal.DefaultConstructorMarker) null);
                }
                break;
            case -1763991049:
                if (name.equals("com.moji.imageview.FourCornerImageView")) {
                    return new com.moji.imageview.FourCornerImageView(context, attrs);
                }
                break;
            case -1406842887:
                if (name.equals("WebView")) {
                    return new android.webkit.WebView(context, attrs);
                }
                break;
            case -1088464209:
                if (name.equals("com.moji.imageview.TouchImageView")) {
                    return new com.moji.imageview.TouchImageView(context, attrs);
                }
                break;
            case -1013307840:
                if (name.equals("TextureView")) {
                    return new android.view.TextureView(context, attrs);
                }
                break;
            case -926489429:
                if (name.equals("com.moji.textview.TabTextView")) {
                    return new com.moji.textview.TabTextView(context, attrs, 0, 4, (kotlin.jvm.internal.DefaultConstructorMarker) null);
                }
                break;
            case 2666181:
                if (name.equals("View")) {
                    return new android.view.View(context, attrs);
                }
                break;
            case 17448617:
                if (name.equals("com.moji.divider.DividerView")) {
                    return new com.moji.divider.DividerView(context, attrs, 0, 4, (kotlin.jvm.internal.DefaultConstructorMarker) null);
                }
                break;
            case 265037010:
                if (name.equals("SurfaceView")) {
                    return new android.view.SurfaceView(context, attrs);
                }
                break;
            case 866862745:
                if (name.equals("com.moji.imageview.TabImageView")) {
                    return new com.moji.imageview.TabImageView(context, attrs, 0, 4, (kotlin.jvm.internal.DefaultConstructorMarker) null);
                }
                break;
            case 892581483:
                if (name.equals("com.moji.imageview.RoundCornerImageView")) {
                    return new com.moji.imageview.RoundCornerImageView(context, attrs);
                }
                break;
            case 1260470547:
                if (name.equals("ViewStub")) {
                    return new android.view.ViewStub(context, attrs);
                }
                break;
            case 1329453685:
                if (name.equals("com.moji.imageview.FaceImageView")) {
                    return new com.moji.imageview.FaceImageView(context, attrs);
                }
                break;
            case 1555633298:
                if (name.equals("com.moji.praise.PraiseLottieView")) {
                    return new com.moji.praise.PraiseLottieView(context, attrs, 0, 4, (kotlin.jvm.internal.DefaultConstructorMarker) null);
                }
                break;
            case 1689178411:
                if (name.equals("com.moji.titlebar.MJTitleBar")) {
                    return new com.moji.titlebar.MJTitleBar(context, attrs);
                }
                break;
        }
        return createViewFromTag(context, name, attrs);
    }
}
