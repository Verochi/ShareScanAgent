package com.airbnb.lottie;

/* loaded from: classes.dex */
public class PerformanceTracker {
    public boolean a = false;
    public final java.util.Set<com.airbnb.lottie.PerformanceTracker.FrameListener> b = new androidx.collection.ArraySet();
    public final java.util.Map<java.lang.String, com.airbnb.lottie.utils.MeanCalculator> c = new java.util.HashMap();
    public final java.util.Comparator<androidx.core.util.Pair<java.lang.String, java.lang.Float>> d = new com.airbnb.lottie.PerformanceTracker.AnonymousClass1();

    /* renamed from: com.airbnb.lottie.PerformanceTracker$1, reason: invalid class name */
    public class AnonymousClass1 implements java.util.Comparator<androidx.core.util.Pair<java.lang.String, java.lang.Float>> {
        public AnonymousClass1() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(androidx.core.util.Pair<java.lang.String, java.lang.Float> pair, androidx.core.util.Pair<java.lang.String, java.lang.Float> pair2) {
            float floatValue = pair.second.floatValue();
            float floatValue2 = pair2.second.floatValue();
            if (floatValue2 > floatValue) {
                return 1;
            }
            return floatValue > floatValue2 ? -1 : 0;
        }
    }

    public interface FrameListener {
        void onFrameRendered(float f);
    }

    public void a(boolean z) {
        this.a = z;
    }

    public void addFrameListener(com.airbnb.lottie.PerformanceTracker.FrameListener frameListener) {
        this.b.add(frameListener);
    }

    public void clearRenderTimes() {
        this.c.clear();
    }

    public java.util.List<androidx.core.util.Pair<java.lang.String, java.lang.Float>> getSortedRenderTimes() {
        if (!this.a) {
            return java.util.Collections.emptyList();
        }
        java.util.ArrayList arrayList = new java.util.ArrayList(this.c.size());
        for (java.util.Map.Entry<java.lang.String, com.airbnb.lottie.utils.MeanCalculator> entry : this.c.entrySet()) {
            arrayList.add(new androidx.core.util.Pair(entry.getKey(), java.lang.Float.valueOf(entry.getValue().getMean())));
        }
        java.util.Collections.sort(arrayList, this.d);
        return arrayList;
    }

    public void logRenderTimes() {
        if (this.a) {
            java.util.List<androidx.core.util.Pair<java.lang.String, java.lang.Float>> sortedRenderTimes = getSortedRenderTimes();
            for (int i = 0; i < sortedRenderTimes.size(); i++) {
                androidx.core.util.Pair<java.lang.String, java.lang.Float> pair = sortedRenderTimes.get(i);
                java.lang.String.format("\t\t%30s:%.2f", pair.first, pair.second);
            }
        }
    }

    public void recordRenderTime(java.lang.String str, float f) {
        if (this.a) {
            com.airbnb.lottie.utils.MeanCalculator meanCalculator = this.c.get(str);
            if (meanCalculator == null) {
                meanCalculator = new com.airbnb.lottie.utils.MeanCalculator();
                this.c.put(str, meanCalculator);
            }
            meanCalculator.add(f);
            if (str.equals("__container")) {
                java.util.Iterator<com.airbnb.lottie.PerformanceTracker.FrameListener> it = this.b.iterator();
                while (it.hasNext()) {
                    it.next().onFrameRendered(f);
                }
            }
        }
    }

    public void removeFrameListener(com.airbnb.lottie.PerformanceTracker.FrameListener frameListener) {
        this.b.remove(frameListener);
    }
}
