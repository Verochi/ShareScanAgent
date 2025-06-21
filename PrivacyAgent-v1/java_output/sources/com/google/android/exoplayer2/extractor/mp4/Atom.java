package com.google.android.exoplayer2.extractor.mp4;

/* loaded from: classes22.dex */
abstract class Atom {
    public final int a;

    public static final class ContainerAtom extends com.google.android.exoplayer2.extractor.mp4.Atom {
        public final long b;
        public final java.util.List<com.google.android.exoplayer2.extractor.mp4.Atom.LeafAtom> c;
        public final java.util.List<com.google.android.exoplayer2.extractor.mp4.Atom.ContainerAtom> d;

        public ContainerAtom(int i, long j) {
            super(i);
            this.b = j;
            this.c = new java.util.ArrayList();
            this.d = new java.util.ArrayList();
        }

        public void d(com.google.android.exoplayer2.extractor.mp4.Atom.ContainerAtom containerAtom) {
            this.d.add(containerAtom);
        }

        public void e(com.google.android.exoplayer2.extractor.mp4.Atom.LeafAtom leafAtom) {
            this.c.add(leafAtom);
        }

        @androidx.annotation.Nullable
        public com.google.android.exoplayer2.extractor.mp4.Atom.ContainerAtom f(int i) {
            int size = this.d.size();
            for (int i2 = 0; i2 < size; i2++) {
                com.google.android.exoplayer2.extractor.mp4.Atom.ContainerAtom containerAtom = this.d.get(i2);
                if (containerAtom.a == i) {
                    return containerAtom;
                }
            }
            return null;
        }

        @androidx.annotation.Nullable
        public com.google.android.exoplayer2.extractor.mp4.Atom.LeafAtom g(int i) {
            int size = this.c.size();
            for (int i2 = 0; i2 < size; i2++) {
                com.google.android.exoplayer2.extractor.mp4.Atom.LeafAtom leafAtom = this.c.get(i2);
                if (leafAtom.a == i) {
                    return leafAtom;
                }
            }
            return null;
        }

        @Override // com.google.android.exoplayer2.extractor.mp4.Atom
        public java.lang.String toString() {
            java.lang.String a = com.google.android.exoplayer2.extractor.mp4.Atom.a(this.a);
            java.lang.String arrays = java.util.Arrays.toString(this.c.toArray());
            java.lang.String arrays2 = java.util.Arrays.toString(this.d.toArray());
            java.lang.StringBuilder sb = new java.lang.StringBuilder(java.lang.String.valueOf(a).length() + 22 + java.lang.String.valueOf(arrays).length() + java.lang.String.valueOf(arrays2).length());
            sb.append(a);
            sb.append(" leaves: ");
            sb.append(arrays);
            sb.append(" containers: ");
            sb.append(arrays2);
            return sb.toString();
        }
    }

    public static final class LeafAtom extends com.google.android.exoplayer2.extractor.mp4.Atom {
        public final com.google.android.exoplayer2.util.ParsableByteArray b;

        public LeafAtom(int i, com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray) {
            super(i);
            this.b = parsableByteArray;
        }
    }

    public Atom(int i) {
        this.a = i;
    }

    public static java.lang.String a(int i) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder(4);
        sb.append((char) ((i >> 24) & 255));
        sb.append((char) ((i >> 16) & 255));
        sb.append((char) ((i >> 8) & 255));
        sb.append((char) (i & 255));
        return sb.toString();
    }

    public static int b(int i) {
        return i & 16777215;
    }

    public static int c(int i) {
        return (i >> 24) & 255;
    }

    public java.lang.String toString() {
        return a(this.a);
    }
}
