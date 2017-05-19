package marujolla.ksk.kcompat;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.Nullable;
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
        applyIndeterminateProgressTint();
    }

    public void applyIndeterminateProgressTint() {
        if (mProgressTintList != null) {
            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
                //The indeterminateTint to change progress bar color doesn't work below API level 21.
                Drawable drawable = getIndeterminateDrawable().getConstantState().newDrawable().mutate();
                if (drawable != null) {
                    if(mProgressTintList == null){
                        // we are clearing the color filter if its null
                        drawable.clearColorFilter();
                    } else {
                        // we are creating a new drawable so that it doesn't effect the other progressBar
                        drawable.setColorFilter(mProgressTintList.getDefaultColor(),
                                PorterDuff.Mode.SRC_IN);
                    }
                    setIndeterminateDrawable(drawable);
                }
            } else {
                super.setIndeterminateTintList(mProgressTintList);
            }
        }
    }

    /**
     * Applies a tint to the indeterminate drawable. Does not modify the
     * current tint mode, which is {@link PorterDuff.Mode#SRC_IN} by default.
     * <p>
     * Subsequent calls to {@link #setIndeterminateDrawable(Drawable)} will
     * automatically mutate the drawable and apply the specified tint and
     * tint mode using
     * {@link Drawable#setTintList(ColorStateList)}.
     *
     * @param tint the tint to apply, may be {@code null} to clear tint
     *
     * @attr ref android.R.styleable#ProgressBar_indeterminateTint
     * @see #getIndeterminateTintList()
     * @see Drawable#setTintList(ColorStateList)
     */
    public void setIndeterminateTintList(@Nullable ColorStateList tint) {
        mProgressTintList = tint;
        applyIndeterminateProgressTint();
    }
}
