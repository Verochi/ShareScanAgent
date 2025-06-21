package com.aliyun.svideo.base;

/* loaded from: classes.dex */
public class ActionInfo {
    private java.util.LinkedList<java.lang.String> mDestroyClassNames;
    private android.util.SparseArray<java.lang.String> mTagClassNames = new android.util.SparseArray<>();

    /* renamed from: com.aliyun.svideo.base.ActionInfo$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$aliyun$svideo$base$ActionInfo$SVideoAction;

        static {
            int[] iArr = new int[com.aliyun.svideo.base.ActionInfo.SVideoAction.values().length];
            $SwitchMap$com$aliyun$svideo$base$ActionInfo$SVideoAction = iArr;
            try {
                iArr[com.aliyun.svideo.base.ActionInfo.SVideoAction.CROP_TARGET_CLASSNAME.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$aliyun$svideo$base$ActionInfo$SVideoAction[com.aliyun.svideo.base.ActionInfo.SVideoAction.RECORD_TARGET_CLASSNAME.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$aliyun$svideo$base$ActionInfo$SVideoAction[com.aliyun.svideo.base.ActionInfo.SVideoAction.EDITOR_TARGET_CLASSNAME.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$aliyun$svideo$base$ActionInfo$SVideoAction[com.aliyun.svideo.base.ActionInfo.SVideoAction.PUBLISH_TARGET_CLASSNAME.ordinal()] = 4;
            } catch (java.lang.NoSuchFieldError unused4) {
            }
        }
    }

    public enum SVideoAction {
        RECORD_TARGET_CLASSNAME,
        EDITOR_TARGET_CLASSNAME,
        CROP_TARGET_CLASSNAME,
        PUBLISH_TARGET_CLASSNAME;

        public int index() {
            return ordinal();
        }
    }

    public static java.lang.String getDefaultTargetConfig(com.aliyun.svideo.base.ActionInfo.SVideoAction sVideoAction) {
        int i = com.aliyun.svideo.base.ActionInfo.AnonymousClass1.$SwitchMap$com$aliyun$svideo$base$ActionInfo$SVideoAction[sVideoAction.ordinal()];
        if (i == 1) {
            return null;
        }
        if (i == 2) {
            return "com.aliyun.svideo.editor.editor.EditorActivity";
        }
        if (i == 3) {
            return "com.aliyun.svideo.editor.publish.UploadActivity";
        }
        if (i != 4) {
            return null;
        }
        return com.aliyun.svideo.editor.editor.EditorActivity.NEXT_ACTIVITY_CLASS_NAME;
    }

    public void clearTagClass() {
        this.mTagClassNames.clear();
    }

    public java.lang.String getTagClassName(com.aliyun.svideo.base.ActionInfo.SVideoAction sVideoAction) {
        java.lang.String str = this.mTagClassNames.get(sVideoAction.index());
        return str == null ? getDefaultTargetConfig(sVideoAction) : str;
    }

    public boolean isDestroyActivity(android.app.Activity activity) {
        return isDestroyClassName(activity.getPackageName());
    }

    public boolean isDestroyClassName(java.lang.String str) {
        return this.mDestroyClassNames.remove(str);
    }

    public void setDestroyClassName(java.lang.String str) {
        this.mDestroyClassNames.add(str);
    }

    public void setTagClassName(com.aliyun.svideo.base.ActionInfo.SVideoAction sVideoAction, java.lang.String str) {
        this.mTagClassNames.put(sVideoAction.index(), str);
    }
}
