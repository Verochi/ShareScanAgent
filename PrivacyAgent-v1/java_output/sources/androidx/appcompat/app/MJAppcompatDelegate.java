package androidx.appcompat.app;

@kotlin.Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u0000 ,2\u00020\u0001:\u0001,B!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bB!\b\u0016\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u000bJ\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014J\b\u0010\u0015\u001a\u00020\rH\u0016J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0017H\u0016J.\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001e\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020 H\u0016J\u0012\u0010!\u001a\u00020\u00122\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\b\u0010$\u001a\u00020\u0012H\u0016J4\u0010%\u001a\u00020\u00122\u0006\u0010&\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001e\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020 H\u0002J(\u0010'\u001a\u00020\u00122\u0006\u0010\u001f\u001a\u00020 2\u0016\u0010(\u001a\u0012\u0012\u0004\u0012\u00020*0)j\b\u0012\u0004\u0012\u00020*`+H\u0002R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Landroidx/appcompat/app/MJAppcompatDelegate;", "Landroidx/appcompat/app/AppCompatDelegateImpl;", "activity", "Landroid/app/Activity;", "callback", "Landroidx/appcompat/app/AppCompatCallback;", "dispatcher", "Landroidx/appcompat/app/IContextLanguageDispatcher;", "(Landroid/app/Activity;Landroidx/appcompat/app/AppCompatCallback;Landroidx/appcompat/app/IContextLanguageDispatcher;)V", "dialog", "Landroid/app/Dialog;", "(Landroid/app/Dialog;Landroidx/appcompat/app/AppCompatCallback;Landroidx/appcompat/app/IContextLanguageDispatcher;)V", "mIsCalledFromConfigurationChange", "", "mLanguageDispatcher", "mStyleables", "Lcom/moji/theme/updater/Styleables;", "addStyleable", "", "styleable", "Lcom/moji/theme/updater/Styleable;", "applyDayNight", "attachBaseContext2", "Landroid/content/Context;", "baseContext", "createView", "Landroid/view/View;", "parent", "name", "", "context", "attrs", "Landroid/util/AttributeSet;", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onDestroy", "onViewCreated", com.anythink.expressad.a.B, "readAttributes", "updaters", "Ljava/util/ArrayList;", "Lcom/moji/theme/updater/ViewPropertyStyleUpdater;", "Lkotlin/collections/ArrayList;", "Companion", "MJWidget_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@android.annotation.SuppressLint({"RestrictedApi"})
/* loaded from: classes.dex */
public final class MJAppcompatDelegate extends androidx.appcompat.app.AppCompatDelegateImpl {

    @org.jetbrains.annotations.NotNull
    private static final java.lang.String ATTR_BACKGROUND = "background";

    @org.jetbrains.annotations.NotNull
    private static final java.lang.String ATTR_BORDER_COLOR = "border_color";

    @org.jetbrains.annotations.NotNull
    private static final java.lang.String ATTR_BUTTON = "button";

    @org.jetbrains.annotations.NotNull
    private static final java.lang.String ATTR_CARD_BACKGROUND_COLOR = "cardBackgroundColor";

    @org.jetbrains.annotations.NotNull
    private static final java.lang.String ATTR_DRAWABLE_TINT = "drawableTint";

    @org.jetbrains.annotations.NotNull
    private static final java.lang.String ATTR_FILL_COLOR = "fillColor";

    @org.jetbrains.annotations.NotNull
    private static final java.lang.String ATTR_FOREGROUND = "foreground";

    @org.jetbrains.annotations.NotNull
    private static final java.lang.String ATTR_MSELECTCOLOR = "mselectColor";

    @org.jetbrains.annotations.NotNull
    private static final java.lang.String ATTR_MTEXTCOLOR = "mtextColor";

    @org.jetbrains.annotations.NotNull
    private static final java.lang.String ATTR_PAGE_COLOR = "pageColor";

    @org.jetbrains.annotations.NotNull
    private static final java.lang.String ATTR_SHADOW_BG_COLOR = "bgColor";

    @org.jetbrains.annotations.NotNull
    private static final java.lang.String ATTR_SRC = "src";

    @org.jetbrains.annotations.NotNull
    private static final java.lang.String ATTR_TAB_TEXT_COLOR = "tabTextColor";

    @org.jetbrains.annotations.NotNull
    private static final java.lang.String ATTR_TEXT_COLOR = "textColor";

    @org.jetbrains.annotations.NotNull
    private static final java.lang.String ATTR_TEXT_COLOR_HINT = "textColorHint";

    @org.jetbrains.annotations.NotNull
    private static final java.lang.String ATTR_TEXT_CURSOR_DRAWABLE = "textCursorDrawable";

    @org.jetbrains.annotations.NotNull
    private static final java.lang.String ATTR_TINT = "tint";

    @org.jetbrains.annotations.NotNull
    private static final java.lang.String DRAWABLE_BOTTOM = "drawableBottom";

    @org.jetbrains.annotations.NotNull
    private static final java.lang.String DRAWABLE_BOTTOM_COMPAT = "drawableBottomCompat";

    @org.jetbrains.annotations.NotNull
    private static final java.lang.String DRAWABLE_LEFT = "drawableLeft";

    @org.jetbrains.annotations.NotNull
    private static final java.lang.String DRAWABLE_LEFT_COMPAT = "drawableLeftCompat";

    @org.jetbrains.annotations.NotNull
    private static final java.lang.String DRAWABLE_RIGHT = "drawableRight";

    @org.jetbrains.annotations.NotNull
    private static final java.lang.String DRAWABLE_RIGHT_COMPAT = "drawableRightCompat";

    @org.jetbrains.annotations.NotNull
    private static final java.lang.String DRAWABLE_TOP = "drawableTop";

    @org.jetbrains.annotations.NotNull
    private static final java.lang.String DRAWABLE_TOP_COMPAT = "drawableTopCompat";
    private boolean mIsCalledFromConfigurationChange;

    @org.jetbrains.annotations.NotNull
    private final androidx.appcompat.app.IContextLanguageDispatcher mLanguageDispatcher;

    @org.jetbrains.annotations.NotNull
    private final com.moji.theme.updater.Styleables mStyleables;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MJAppcompatDelegate(@org.jetbrains.annotations.NotNull android.app.Activity activity, @org.jetbrains.annotations.Nullable androidx.appcompat.app.AppCompatCallback appCompatCallback, @org.jetbrains.annotations.NotNull androidx.appcompat.app.IContextLanguageDispatcher dispatcher) {
        super(activity, appCompatCallback);
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(activity, "activity");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(dispatcher, "dispatcher");
        this.mStyleables = new com.moji.theme.updater.Styleables();
        this.mLanguageDispatcher = dispatcher;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MJAppcompatDelegate(@org.jetbrains.annotations.NotNull android.app.Dialog dialog, @org.jetbrains.annotations.Nullable androidx.appcompat.app.AppCompatCallback appCompatCallback, @org.jetbrains.annotations.NotNull androidx.appcompat.app.IContextLanguageDispatcher dispatcher) {
        super(dialog, appCompatCallback);
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(dialog, "dialog");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(dispatcher, "dispatcher");
        this.mStyleables = new com.moji.theme.updater.Styleables();
        this.mLanguageDispatcher = dispatcher;
    }

    private final void onViewCreated(android.view.View view, android.view.View parent, java.lang.String name, android.content.Context context, android.util.AttributeSet attrs) {
        if (view instanceof com.moji.theme.updater.Styleable) {
            this.mStyleables.add(new com.moji.theme.updater.WeakStyleableWrapper((com.moji.theme.updater.Styleable) view));
        }
        java.util.ArrayList<com.moji.theme.updater.ViewPropertyStyleUpdater> arrayList = new java.util.ArrayList<>();
        readAttributes(attrs, arrayList);
        if (!arrayList.isEmpty()) {
            this.mStyleables.add(new com.moji.theme.updater.ViewStyleable(view, arrayList));
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
    java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
     */
    private final void readAttributes(android.util.AttributeSet attrs, java.util.ArrayList<com.moji.theme.updater.ViewPropertyStyleUpdater> updaters) {
        java.lang.Integer intOrNull;
        int attributeCount = attrs.getAttributeCount();
        for (int i = 0; i < attributeCount; i++) {
            java.lang.String attrName = attrs.getAttributeName(i);
            if (!(attrName == null || attrName.length() == 0)) {
                java.lang.String attrValue = attrs.getAttributeValue(i);
                if (!(attrValue == null || attrValue.length() == 0)) {
                    kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(attrValue, "attrValue");
                    if (kotlin.text.StringsKt__StringsJVMKt.startsWith$default(attrValue, "?", false, 2, null)) {
                        java.lang.String substring = attrValue.substring(1);
                        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
                        intOrNull = kotlin.text.StringsKt__StringNumberConversionsKt.toIntOrNull(substring);
                        if (intOrNull != null) {
                            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(attrName, "attrName");
                            switch (attrName.hashCode()) {
                                case -2056911842:
                                    if (!attrName.equals(DRAWABLE_RIGHT)) {
                                        break;
                                    }
                                    updaters.add(new com.moji.theme.updater.TextViewCompoundDrawableUpdater(intOrNull.intValue(), false, true, false, false, 26, (kotlin.jvm.internal.DefaultConstructorMarker) null));
                                    break;
                                case -2039515683:
                                    if (attrName.equals(ATTR_TEXT_COLOR_HINT)) {
                                        updaters.add(new com.moji.theme.updater.TextColorHintUpdater(intOrNull.intValue()));
                                        break;
                                    } else {
                                        break;
                                    }
                                case -1936113503:
                                    if (attrName.equals(ATTR_TEXT_CURSOR_DRAWABLE)) {
                                        updaters.add(new com.moji.theme.updater.TextCursorDrawableUpdater(intOrNull.intValue()));
                                        break;
                                    } else {
                                        break;
                                    }
                                case -1554954719:
                                    if (attrName.equals(ATTR_TAB_TEXT_COLOR)) {
                                        updaters.add(new com.moji.theme.updater.TabTextColorUpdater(intOrNull.intValue()));
                                        break;
                                    } else {
                                        break;
                                    }
                                case -1519250112:
                                    if (!attrName.equals(DRAWABLE_RIGHT_COMPAT)) {
                                        break;
                                    }
                                    updaters.add(new com.moji.theme.updater.TextViewCompoundDrawableUpdater(intOrNull.intValue(), false, true, false, false, 26, (kotlin.jvm.internal.DefaultConstructorMarker) null));
                                    break;
                                case -1413542489:
                                    if (!attrName.equals(DRAWABLE_LEFT_COMPAT)) {
                                        break;
                                    }
                                    updaters.add(new com.moji.theme.updater.TextViewCompoundDrawableUpdater(intOrNull.intValue(), true, false, false, false, 28, (kotlin.jvm.internal.DefaultConstructorMarker) null));
                                    break;
                                case -1377687758:
                                    if (attrName.equals("button")) {
                                        updaters.add(new com.moji.theme.updater.ButtonUpdater(intOrNull.intValue()));
                                        break;
                                    } else {
                                        break;
                                    }
                                case -1332194002:
                                    if (attrName.equals(ATTR_BACKGROUND)) {
                                        updaters.add(new com.moji.theme.updater.BackgroundUpdater(intOrNull.intValue()));
                                        break;
                                    } else {
                                        break;
                                    }
                                case -1141881952:
                                    if (attrName.equals(ATTR_FILL_COLOR)) {
                                        updaters.add(new com.moji.theme.updater.FillColorUpdater(intOrNull.intValue()));
                                        break;
                                    } else {
                                        break;
                                    }
                                case -1063571914:
                                    if (attrName.equals(ATTR_TEXT_COLOR)) {
                                        updaters.add(new com.moji.theme.updater.TextColorUpdater(intOrNull.intValue()));
                                        break;
                                    } else {
                                        break;
                                    }
                                case -1050147509:
                                    if (!attrName.equals(DRAWABLE_BOTTOM_COMPAT)) {
                                        break;
                                    }
                                    updaters.add(new com.moji.theme.updater.TextViewCompoundDrawableUpdater(intOrNull.intValue(), false, false, false, true, 14, (kotlin.jvm.internal.DefaultConstructorMarker) null));
                                    break;
                                case -786678215:
                                    if (!attrName.equals(DRAWABLE_TOP_COMPAT)) {
                                        break;
                                    }
                                    updaters.add(new com.moji.theme.updater.TextViewCompoundDrawableUpdater(intOrNull.intValue(), false, false, true, false, 22, (kotlin.jvm.internal.DefaultConstructorMarker) null));
                                    break;
                                case -204859874:
                                    if (attrName.equals(ATTR_SHADOW_BG_COLOR)) {
                                        updaters.add(new com.moji.theme.updater.ShadowBgColorUpdater(intOrNull.intValue()));
                                        break;
                                    } else {
                                        break;
                                    }
                                case 114148:
                                    if (attrName.equals(ATTR_SRC)) {
                                        updaters.add(new com.moji.theme.updater.SrcUpdater(intOrNull.intValue()));
                                        break;
                                    } else {
                                        break;
                                    }
                                case 3560187:
                                    if (attrName.equals(ATTR_TINT)) {
                                        updaters.add(new com.moji.theme.updater.TintUpdater(intOrNull.intValue()));
                                        break;
                                    } else {
                                        break;
                                    }
                                case 208115817:
                                    if (!attrName.equals(DRAWABLE_BOTTOM)) {
                                        break;
                                    }
                                    updaters.add(new com.moji.theme.updater.TextViewCompoundDrawableUpdater(intOrNull.intValue(), false, false, false, true, 14, (kotlin.jvm.internal.DefaultConstructorMarker) null));
                                    break;
                                case 504672677:
                                    if (attrName.equals(ATTR_CARD_BACKGROUND_COLOR)) {
                                        updaters.add(new com.moji.theme.updater.CardBackgroundUpdater(intOrNull.intValue()));
                                        break;
                                    } else {
                                        break;
                                    }
                                case 574397399:
                                    if (!attrName.equals(DRAWABLE_TOP)) {
                                        break;
                                    }
                                    updaters.add(new com.moji.theme.updater.TextViewCompoundDrawableUpdater(intOrNull.intValue(), false, false, true, false, 22, (kotlin.jvm.internal.DefaultConstructorMarker) null));
                                    break;
                                case 626202053:
                                    if (!attrName.equals(DRAWABLE_LEFT)) {
                                        break;
                                    }
                                    updaters.add(new com.moji.theme.updater.TextViewCompoundDrawableUpdater(intOrNull.intValue(), true, false, false, false, 28, (kotlin.jvm.internal.DefaultConstructorMarker) null));
                                    break;
                                case 626444473:
                                    if (attrName.equals(ATTR_DRAWABLE_TINT)) {
                                        updaters.add(new com.moji.theme.updater.DrawableTintUpdater(intOrNull.intValue()));
                                        break;
                                    } else {
                                        break;
                                    }
                                case 857873940:
                                    if (attrName.equals(ATTR_PAGE_COLOR)) {
                                        updaters.add(new com.moji.theme.updater.PageColorUpdater(intOrNull.intValue()));
                                        break;
                                    } else {
                                        break;
                                    }
                                case 1723544976:
                                    if (attrName.equals(ATTR_BORDER_COLOR)) {
                                        updaters.add(new com.moji.theme.updater.BorderColorUpdater(intOrNull.intValue()));
                                        break;
                                    } else {
                                        break;
                                    }
                                case 1984457027:
                                    if (attrName.equals("foreground")) {
                                        updaters.add(new com.moji.theme.updater.ForegroundUpdater(intOrNull.intValue()));
                                        break;
                                    } else {
                                        break;
                                    }
                            }
                        } else {
                            com.moji.tool.log.MJLogger.d("MJAppcompatDelegate", "解析attr资源失败.");
                        }
                    }
                }
            }
        }
    }

    public final void addStyleable(@org.jetbrains.annotations.NotNull com.moji.theme.updater.Styleable styleable) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(styleable, "styleable");
        this.mStyleables.add(new com.moji.theme.updater.WeakStyleableWrapper(styleable));
    }

    @Override // androidx.appcompat.app.AppCompatDelegateImpl, androidx.appcompat.app.AppCompatDelegate
    public boolean applyDayNight() {
        boolean applyDayNight = super.applyDayNight();
        if (!this.mIsCalledFromConfigurationChange) {
            this.mStyleables.updateStyle();
        }
        androidx.appcompat.app.IContextLanguageDispatcher iContextLanguageDispatcher = this.mLanguageDispatcher;
        android.content.Context mContext = this.mContext;
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(mContext, "mContext");
        iContextLanguageDispatcher.dispatchContextLanguage(mContext);
        return applyDayNight;
    }

    @Override // androidx.appcompat.app.AppCompatDelegateImpl, androidx.appcompat.app.AppCompatDelegate
    @org.jetbrains.annotations.NotNull
    public android.content.Context attachBaseContext2(@org.jetbrains.annotations.NotNull android.content.Context baseContext) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(baseContext, "baseContext");
        android.content.Context attachBaseContext2 = super.attachBaseContext2(baseContext);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(attachBaseContext2, "super.attachBaseContext2(baseContext)");
        android.content.Context dispatchContextLanguage = this.mLanguageDispatcher.dispatchContextLanguage(attachBaseContext2);
        return dispatchContextLanguage == null ? attachBaseContext2 : dispatchContextLanguage;
    }

    @Override // androidx.appcompat.app.AppCompatDelegateImpl, androidx.appcompat.app.AppCompatDelegate
    @org.jetbrains.annotations.Nullable
    public android.view.View createView(@org.jetbrains.annotations.Nullable android.view.View parent, @org.jetbrains.annotations.Nullable java.lang.String name, @org.jetbrains.annotations.NotNull android.content.Context context, @org.jetbrains.annotations.NotNull android.util.AttributeSet attrs) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(context, "context");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(attrs, "attrs");
        android.view.View createView = super.createView(parent, name, context, attrs);
        if (createView != null) {
            onViewCreated(createView, parent, name, context, attrs);
        }
        return createView;
    }

    @Override // androidx.appcompat.app.AppCompatDelegateImpl, androidx.appcompat.app.AppCompatDelegate
    public void onConfigurationChanged(@org.jetbrains.annotations.Nullable android.content.res.Configuration newConfig) {
        try {
            this.mIsCalledFromConfigurationChange = true;
            super.onConfigurationChanged(newConfig);
            this.mIsCalledFromConfigurationChange = false;
            this.mStyleables.updateStyle();
        } catch (java.lang.Throwable th) {
            this.mIsCalledFromConfigurationChange = false;
            throw th;
        }
    }

    @Override // androidx.appcompat.app.AppCompatDelegateImpl, androidx.appcompat.app.AppCompatDelegate
    public void onDestroy() {
        super.onDestroy();
        this.mStyleables.clear();
    }
}
