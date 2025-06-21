package androidx.core.view;

/* loaded from: classes.dex */
public class DragStartHelper {
    private boolean mDragging;
    private int mLastTouchX;
    private int mLastTouchY;
    private final androidx.core.view.DragStartHelper.OnDragStartListener mListener;
    private final android.view.View.OnLongClickListener mLongClickListener = new androidx.core.view.DragStartHelper.AnonymousClass1();
    private final android.view.View.OnTouchListener mTouchListener = new androidx.core.view.DragStartHelper.AnonymousClass2();
    private final android.view.View mView;

    /* renamed from: androidx.core.view.DragStartHelper$1, reason: invalid class name */
    public class AnonymousClass1 implements android.view.View.OnLongClickListener {
        public AnonymousClass1() {
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(android.view.View view) {
            return androidx.core.view.DragStartHelper.this.onLongClick(view);
        }
    }

    /* renamed from: androidx.core.view.DragStartHelper$2, reason: invalid class name */
    public class AnonymousClass2 implements android.view.View.OnTouchListener {
        public AnonymousClass2() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(android.view.View view, android.view.MotionEvent motionEvent) {
            return androidx.core.view.DragStartHelper.this.onTouch(view, motionEvent);
        }
    }

    public interface OnDragStartListener {
        boolean onDragStart(android.view.View view, androidx.core.view.DragStartHelper dragStartHelper);
    }

    public DragStartHelper(android.view.View view, androidx.core.view.DragStartHelper.OnDragStartListener onDragStartListener) {
        this.mView = view;
        this.mListener = onDragStartListener;
    }

    public void attach() {
        this.mView.setOnLongClickListener(this.mLongClickListener);
        this.mView.setOnTouchListener(this.mTouchListener);
    }

    public void detach() {
        this.mView.setOnLongClickListener(null);
        this.mView.setOnTouchListener(null);
    }

    public void getTouchPosition(android.graphics.Point point) {
        point.set(this.mLastTouchX, this.mLastTouchY);
    }

    public boolean onLongClick(android.view.View view) {
        return this.mListener.onDragStart(view, this);
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0018, code lost:
    
        if (r2 != 3) goto L28;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouch(android.view.View view, android.view.MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    if (androidx.core.view.MotionEventCompat.isFromSource(motionEvent, 8194) && (motionEvent.getButtonState() & 1) != 0 && !this.mDragging && (this.mLastTouchX != x || this.mLastTouchY != y)) {
                        this.mLastTouchX = x;
                        this.mLastTouchY = y;
                        boolean onDragStart = this.mListener.onDragStart(view, this);
                        this.mDragging = onDragStart;
                        return onDragStart;
                    }
                }
            }
            this.mDragging = false;
        } else {
            this.mLastTouchX = x;
            this.mLastTouchY = y;
        }
        return false;
    }
}
