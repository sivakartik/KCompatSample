package marujolla.ksk.kcompat;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.ProgressBar;

/**
 * Created by shivakartik on 5/18/17.
 */

public class KCompatProgressBar extends ProgressBar {

    private ColorStateList mProgressTintList;

    public KCompatProgressBar(Context context) {
        super(context);
        init(context, null);
    }

    public KCompatProgressBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public KCompatProgressBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    @SuppressLint("NewApi")
    public KCompatProgressBar(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context, attrs);
    }

    public void init(Context context, AttributeSet attrs) {
        if (attrs == null) return;
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.KCompatProgressBar);
        if (typedArray.hasValue(R.styleable.KCompatProgressBar_kProgressTint)) {
            mProgressTintList = typedArray.getColorStateList(R.styleable.KCompatProgressBar_kProgressTint);
        }
        typedArray.recycle();
        applyProgressTint();
    }

    public void applyProgressTint() {
        if (mProgressTintList != null) {
            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
                //The indeterminateTint to change progress bar color doesn't work below API level 21.
               // we are creating a new drawable so that it doesn't effect the other progressBar
                Drawable drawable = getIndeterminateDrawable().getConstantState().newDrawable().mutate();
                drawable.setColorFilter(mProgressTintList.getDefaultColor(),
                        PorterDuff.Mode.SRC_IN);
                setIndeterminateDrawable(drawable);
            } else {
                setIndeterminateTintList(mProgressTintList);
            }
        }
    }
}
