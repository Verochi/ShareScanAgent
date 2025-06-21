package com.autonavi.base.ae.gmap.gloverlay;

/* loaded from: classes12.dex */
public abstract class BaseMapOverlay<T extends com.autonavi.base.ae.gmap.gloverlay.GLOverlay, E> implements java.io.Serializable {
    private static final long serialVersionUID = 1;
    protected android.content.Context mContext;
    protected int mEngineID;
    protected T mGLOverlay;
    protected java.util.Vector<E> mItemList;
    protected int mLastFocusedIndex;
    protected com.autonavi.base.amap.api.mapcore.IAMapDelegate mMapView;

    public BaseMapOverlay(int i, android.content.Context context, com.autonavi.amap.mapcore.interfaces.IAMap iAMap) {
        this.mItemList = null;
        this.mEngineID = i;
        this.mContext = context;
        try {
            this.mMapView = (com.autonavi.base.amap.api.mapcore.IAMapDelegate) iAMap;
        } catch (java.lang.Throwable unused) {
        }
        this.mItemList = new java.util.Vector<>();
        iniGLOverlay();
    }

    public abstract void addItem(E e);

    public boolean clear() {
        try {
            this.mItemList.clear();
            clearFocus();
            T t = this.mGLOverlay;
            if (t == null) {
                return true;
            }
            t.removeAll();
            return true;
        } catch (java.lang.Exception unused) {
            return false;
        }
    }

    public void clearFocus() {
        this.mLastFocusedIndex = -1;
        this.mGLOverlay.clearFocus();
    }

    public T getGLOverlay() {
        return this.mGLOverlay;
    }

    public final E getItem(int i) {
        try {
            synchronized (this.mItemList) {
                if (i >= 0) {
                    if (i <= this.mItemList.size() - 1) {
                        return this.mItemList.get(i);
                    }
                }
                return null;
            }
        } catch (java.lang.IndexOutOfBoundsException unused) {
            return null;
        }
    }

    public java.util.List<E> getItems() {
        return this.mItemList;
    }

    public int getSize() {
        return this.mItemList.size();
    }

    public abstract void iniGLOverlay();

    public boolean isClickable() {
        T t = this.mGLOverlay;
        if (t != null) {
            return t.isClickable();
        }
        return false;
    }

    public boolean isVisible() {
        T t = this.mGLOverlay;
        if (t != null) {
            return t.isVisible();
        }
        return false;
    }

    public void releaseInstance() {
        if (getGLOverlay() != null) {
            com.autonavi.base.amap.api.mapcore.IAMapDelegate iAMapDelegate = this.mMapView;
            if (iAMapDelegate != null && iAMapDelegate.isMaploaded()) {
                this.mMapView.removeEngineGLOverlay(this);
            }
            getGLOverlay().releaseInstance();
            this.mGLOverlay = null;
        }
    }

    public boolean removeAll() {
        return clear();
    }

    public void removeItem(int i) {
        if (i >= 0) {
            try {
                if (i > this.mItemList.size() - 1) {
                    return;
                }
                if (i == this.mLastFocusedIndex) {
                    this.mLastFocusedIndex = -1;
                    clearFocus();
                }
                this.mItemList.remove(i);
                T t = this.mGLOverlay;
                if (t != null) {
                    t.removeItem(i);
                }
            } catch (java.lang.IndexOutOfBoundsException unused) {
            }
        }
    }

    public void removeItem(E e) {
        if (e == null) {
            return;
        }
        try {
            synchronized (this.mItemList) {
                removeItem(this.mItemList.indexOf(e));
            }
        } catch (java.lang.IndexOutOfBoundsException unused) {
        }
    }

    public abstract void resumeMarker(android.graphics.Bitmap bitmap);

    public void setClickable(boolean z) {
        T t = this.mGLOverlay;
        if (t != null) {
            t.setClickable(z);
        }
    }

    public abstract void setVisible(boolean z);
}
