package com.aliyun.common.utils;

/* loaded from: classes.dex */
public class SizeMap {
    private final java.util.HashMap<com.aliyun.common.utils.AspectRatio, java.util.SortedSet<com.aliyun.common.utils.Size>> mRatios = new java.util.HashMap<>();

    public boolean add(com.aliyun.common.utils.Size size) {
        for (com.aliyun.common.utils.AspectRatio aspectRatio : this.mRatios.keySet()) {
            if (aspectRatio.matches(size)) {
                java.util.SortedSet<com.aliyun.common.utils.Size> sortedSet = this.mRatios.get(aspectRatio);
                if (sortedSet.contains(size)) {
                    return false;
                }
                sortedSet.add(size);
                return true;
            }
        }
        java.util.TreeSet treeSet = new java.util.TreeSet();
        treeSet.add(size);
        this.mRatios.put(com.aliyun.common.utils.AspectRatio.of(size.getWidth(), size.getHeight()), treeSet);
        return true;
    }

    public void clear() {
        this.mRatios.clear();
    }

    public boolean isEmpty() {
        return this.mRatios.isEmpty();
    }

    public java.util.Set<com.aliyun.common.utils.AspectRatio> ratios() {
        return this.mRatios.keySet();
    }

    public void remove(com.aliyun.common.utils.AspectRatio aspectRatio) {
        this.mRatios.remove(aspectRatio);
    }

    public java.util.SortedSet<com.aliyun.common.utils.Size> sizes(com.aliyun.common.utils.AspectRatio aspectRatio) {
        return this.mRatios.get(aspectRatio);
    }
}
