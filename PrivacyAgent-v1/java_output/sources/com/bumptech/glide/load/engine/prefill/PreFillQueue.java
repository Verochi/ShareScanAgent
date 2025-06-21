package com.bumptech.glide.load.engine.prefill;

/* loaded from: classes.dex */
final class PreFillQueue {
    private final java.util.Map<com.bumptech.glide.load.engine.prefill.PreFillType, java.lang.Integer> bitmapsPerType;
    private int bitmapsRemaining;
    private int keyIndex;
    private final java.util.List<com.bumptech.glide.load.engine.prefill.PreFillType> keyList;

    public PreFillQueue(java.util.Map<com.bumptech.glide.load.engine.prefill.PreFillType, java.lang.Integer> map) {
        this.bitmapsPerType = map;
        this.keyList = new java.util.ArrayList(map.keySet());
        java.util.Iterator<java.lang.Integer> it = map.values().iterator();
        while (it.hasNext()) {
            this.bitmapsRemaining += it.next().intValue();
        }
    }

    public int getSize() {
        return this.bitmapsRemaining;
    }

    public boolean isEmpty() {
        return this.bitmapsRemaining == 0;
    }

    public com.bumptech.glide.load.engine.prefill.PreFillType remove() {
        com.bumptech.glide.load.engine.prefill.PreFillType preFillType = this.keyList.get(this.keyIndex);
        java.lang.Integer num = this.bitmapsPerType.get(preFillType);
        if (num.intValue() == 1) {
            this.bitmapsPerType.remove(preFillType);
            this.keyList.remove(this.keyIndex);
        } else {
            this.bitmapsPerType.put(preFillType, java.lang.Integer.valueOf(num.intValue() - 1));
        }
        this.bitmapsRemaining--;
        this.keyIndex = this.keyList.isEmpty() ? 0 : (this.keyIndex + 1) % this.keyList.size();
        return preFillType;
    }
}
