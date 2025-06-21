package androidx.core.content;

@kotlin.Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a0\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u00042\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0002\b\bH\u0087\b¨\u0006\t"}, d2 = {com.aliyun.vod.log.core.AliyunLogCommon.SubModule.EDIT, "", "Landroid/content/SharedPreferences;", "commit", "", "action", "Lkotlin/Function1;", "Landroid/content/SharedPreferences$Editor;", "Lkotlin/ExtensionFunctionType;", "core-ktx_release"}, k = 2, mv = {1, 1, 16})
/* loaded from: classes.dex */
public final class SharedPreferencesKt {
    @android.annotation.SuppressLint({"ApplySharedPref"})
    public static final void edit(@org.jetbrains.annotations.NotNull android.content.SharedPreferences edit, boolean z, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super android.content.SharedPreferences.Editor, kotlin.Unit> action) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(edit, "$this$edit");
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(action, "action");
        android.content.SharedPreferences.Editor editor = edit.edit();
        kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(editor, "editor");
        action.invoke(editor);
        if (z) {
            editor.commit();
        } else {
            editor.apply();
        }
    }

    public static /* synthetic */ void edit$default(android.content.SharedPreferences edit, boolean z, kotlin.jvm.functions.Function1 action, int i, java.lang.Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(edit, "$this$edit");
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(action, "action");
        android.content.SharedPreferences.Editor editor = edit.edit();
        kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(editor, "editor");
        action.invoke(editor);
        if (z) {
            editor.commit();
        } else {
            editor.apply();
        }
    }
}
