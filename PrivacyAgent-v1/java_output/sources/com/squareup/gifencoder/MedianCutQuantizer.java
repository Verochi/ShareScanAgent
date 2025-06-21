package com.squareup.gifencoder;

/* loaded from: classes19.dex */
public final class MedianCutQuantizer implements com.squareup.gifencoder.ColorQuantizer {
    public static final com.squareup.gifencoder.MedianCutQuantizer INSTANCE = new com.squareup.gifencoder.MedianCutQuantizer();

    public static final class Cluster {
        public final com.squareup.gifencoder.Multiset<com.squareup.gifencoder.Color> a;
        public double b;
        public int c;

        public Cluster(com.squareup.gifencoder.Multiset<com.squareup.gifencoder.Color> multiset) {
            this.a = multiset;
            this.b = -1.0d;
            for (int i = 0; i < 3; i++) {
                double a = a(i);
                if (a > this.b) {
                    this.b = a;
                    this.c = i;
                }
            }
        }

        public double a(int i) {
            double d = Double.POSITIVE_INFINITY;
            double d2 = Double.NEGATIVE_INFINITY;
            for (com.squareup.gifencoder.Color color : this.a) {
                d = java.lang.Math.min(d, color.getComponent(i));
                d2 = java.lang.Math.max(d2, color.getComponent(i));
            }
            return d2 - d;
        }

        public java.util.Collection<com.squareup.gifencoder.MedianCutQuantizer.Cluster> b() {
            java.util.ArrayList arrayList = new java.util.ArrayList(this.a);
            java.util.Collections.sort(arrayList, new com.squareup.gifencoder.MedianCutQuantizer.ColorComponentComparator(this.c));
            int size = arrayList.size() / 2;
            return java.util.Arrays.asList(new com.squareup.gifencoder.MedianCutQuantizer.Cluster(new com.squareup.gifencoder.HashMultiset(arrayList.subList(0, size))), new com.squareup.gifencoder.MedianCutQuantizer.Cluster(new com.squareup.gifencoder.HashMultiset(arrayList.subList(size, arrayList.size()))));
        }
    }

    public static final class ClusterSpreadComparator implements java.util.Comparator<com.squareup.gifencoder.MedianCutQuantizer.Cluster> {
        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(com.squareup.gifencoder.MedianCutQuantizer.Cluster cluster, com.squareup.gifencoder.MedianCutQuantizer.Cluster cluster2) {
            double d = cluster2.b - cluster.b;
            return d == 0.0d ? com.squareup.gifencoder.ArbitraryComparator.n.compare(cluster, cluster2) : (int) java.lang.Math.signum(d);
        }
    }

    public static final class ColorComponentComparator implements java.util.Comparator<com.squareup.gifencoder.Color> {
        public final int n;

        public ColorComponentComparator(int i) {
            this.n = i;
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(com.squareup.gifencoder.Color color, com.squareup.gifencoder.Color color2) {
            double component = color.getComponent(this.n) - color2.getComponent(this.n);
            return component == 0.0d ? com.squareup.gifencoder.ArbitraryComparator.n.compare(color, color2) : (int) java.lang.Math.signum(component);
        }
    }

    @Override // com.squareup.gifencoder.ColorQuantizer
    public java.util.Set<com.squareup.gifencoder.Color> quantize(com.squareup.gifencoder.Multiset<com.squareup.gifencoder.Color> multiset, int i) {
        java.util.TreeSet treeSet = new java.util.TreeSet(new com.squareup.gifencoder.MedianCutQuantizer.ClusterSpreadComparator());
        treeSet.add(new com.squareup.gifencoder.MedianCutQuantizer.Cluster(multiset));
        while (treeSet.size() < i) {
            treeSet.addAll(((com.squareup.gifencoder.MedianCutQuantizer.Cluster) treeSet.pollFirst()).b());
        }
        java.util.HashSet hashSet = new java.util.HashSet();
        java.util.Iterator it = treeSet.iterator();
        while (it.hasNext()) {
            hashSet.add(com.squareup.gifencoder.Color.getCentroid(((com.squareup.gifencoder.MedianCutQuantizer.Cluster) it.next()).a));
        }
        return hashSet;
    }
}
