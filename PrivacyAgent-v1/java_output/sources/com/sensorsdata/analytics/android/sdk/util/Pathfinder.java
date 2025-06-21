package com.sensorsdata.analytics.android.sdk.util;

/* loaded from: classes19.dex */
public class Pathfinder {
    private static final java.lang.String TAG = "SA.PathFinder";
    private final com.sensorsdata.analytics.android.sdk.util.Pathfinder.IntStack mIndexStack = new com.sensorsdata.analytics.android.sdk.util.Pathfinder.IntStack();

    public interface Accumulator {
        void accumulate(android.view.View view);
    }

    public static class IntStack {
        private static final int MAX_INDEX_STACK_SIZE = 256;
        private final int[] mStack = new int[256];
        private int mStackSize = 0;

        public int alloc() {
            int i = this.mStackSize;
            this.mStackSize = i + 1;
            this.mStack[i] = 0;
            return i;
        }

        public void free() {
            int i = this.mStackSize - 1;
            this.mStackSize = i;
            if (i < 0) {
                throw new java.lang.ArrayIndexOutOfBoundsException(this.mStackSize);
            }
        }

        public boolean full() {
            return this.mStack.length == this.mStackSize;
        }

        public void increment(int i) {
            int[] iArr = this.mStack;
            iArr[i] = iArr[i] + 1;
        }

        public int read(int i) {
            return this.mStack[i];
        }
    }

    public static class PathElement {
        public static final int SHORTEST_PREFIX = 1;
        public static final int ZERO_LENGTH_PREFIX = 0;
        public final int index;
        public final int prefix;
        public final java.lang.String viewClassName;
        public final int viewId;

        public PathElement(int i, java.lang.String str, int i2, int i3) {
            this.prefix = i;
            this.viewClassName = str;
            this.index = i2;
            this.viewId = i3;
        }

        public java.lang.String toString() {
            try {
                org.json.JSONObject jSONObject = new org.json.JSONObject();
                if (this.prefix == 1) {
                    jSONObject.put(com.alibaba.sdk.android.oss.common.RequestParameters.PREFIX, "shortest");
                }
                java.lang.String str = this.viewClassName;
                if (str != null) {
                    jSONObject.put("view_class", str);
                }
                int i = this.index;
                if (i > -1) {
                    jSONObject.put("index", i);
                }
                int i2 = this.viewId;
                if (i2 > -1) {
                    jSONObject.put("id", i2);
                }
                return jSONObject.toString();
            } catch (org.json.JSONException e) {
                throw new java.lang.RuntimeException("Can't serialize PathElement to String", e);
            }
        }
    }

    private android.view.View findPrefixedMatch(com.sensorsdata.analytics.android.sdk.util.Pathfinder.PathElement pathElement, android.view.View view, int i) {
        android.view.View findPrefixedMatch;
        int read = this.mIndexStack.read(i);
        if (matches(pathElement, view)) {
            this.mIndexStack.increment(i);
            int i2 = pathElement.index;
            if (i2 == -1 || i2 == read) {
                return view;
            }
        }
        if (pathElement.prefix != 1 || !(view instanceof android.view.ViewGroup)) {
            return null;
        }
        android.view.ViewGroup viewGroup = (android.view.ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            android.view.View childAt = viewGroup.getChildAt(i3);
            if (childAt != null && (findPrefixedMatch = findPrefixedMatch(pathElement, childAt, i)) != null) {
                return findPrefixedMatch;
            }
        }
        return null;
    }

    private void findTargetsInMatchedView(android.view.View view, java.util.List<com.sensorsdata.analytics.android.sdk.util.Pathfinder.PathElement> list, com.sensorsdata.analytics.android.sdk.util.Pathfinder.Accumulator accumulator) {
        if (list.isEmpty()) {
            accumulator.accumulate(view);
            return;
        }
        if (this.mIndexStack.full()) {
            com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "Path is too deep, there is no memory to perfrom the finding");
            return;
        }
        if (view instanceof android.view.ViewGroup) {
            android.view.ViewGroup viewGroup = (android.view.ViewGroup) view;
            com.sensorsdata.analytics.android.sdk.util.Pathfinder.PathElement pathElement = list.get(0);
            java.util.List<com.sensorsdata.analytics.android.sdk.util.Pathfinder.PathElement> subList = list.subList(1, list.size());
            int childCount = viewGroup.getChildCount();
            int alloc = this.mIndexStack.alloc();
            for (int i = 0; i < childCount; i++) {
                android.view.View findPrefixedMatch = findPrefixedMatch(pathElement, viewGroup.getChildAt(i), alloc);
                if (findPrefixedMatch != null) {
                    findTargetsInMatchedView(findPrefixedMatch, subList, accumulator);
                }
                if (pathElement.index >= 0 && this.mIndexStack.read(alloc) > pathElement.index) {
                    break;
                }
            }
            this.mIndexStack.free();
        }
    }

    public static boolean hasClassName(java.lang.Object obj, java.lang.String str) {
        java.lang.Class<?> cls = obj.getClass();
        java.lang.String canonicalName = com.sensorsdata.analytics.android.sdk.util.SnapCache.getInstance().getCanonicalName(cls);
        while (canonicalName != null) {
            if (canonicalName.equals(str)) {
                return true;
            }
            if (cls == java.lang.Object.class) {
                return false;
            }
            cls = cls.getSuperclass();
            canonicalName = com.sensorsdata.analytics.android.sdk.util.SnapCache.getInstance().getCanonicalName(cls);
        }
        return false;
    }

    private boolean matches(com.sensorsdata.analytics.android.sdk.util.Pathfinder.PathElement pathElement, android.view.View view) {
        java.lang.String str = pathElement.viewClassName;
        if (str == null || hasClassName(view, str)) {
            return -1 == pathElement.viewId || view.getId() == pathElement.viewId;
        }
        return false;
    }

    public void findTargetsInRoot(android.view.View view, java.util.List<com.sensorsdata.analytics.android.sdk.util.Pathfinder.PathElement> list, com.sensorsdata.analytics.android.sdk.util.Pathfinder.Accumulator accumulator) {
        if (list.isEmpty()) {
            return;
        }
        if (this.mIndexStack.full()) {
            com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "Path is too deep, there is no memory to perfrom the finding");
            return;
        }
        com.sensorsdata.analytics.android.sdk.util.Pathfinder.PathElement pathElement = list.get(0);
        java.util.List<com.sensorsdata.analytics.android.sdk.util.Pathfinder.PathElement> subList = list.subList(1, list.size());
        android.view.View findPrefixedMatch = findPrefixedMatch(pathElement, view, this.mIndexStack.alloc());
        this.mIndexStack.free();
        if (findPrefixedMatch != null) {
            findTargetsInMatchedView(findPrefixedMatch, subList, accumulator);
        }
    }
}
