package com.victor.tallybook.main.widget

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.graphics.RectF
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import com.victor.tallybook.R

class MainBottomNavigationBar: LinearLayout {

    private lateinit var mPaint: Paint
    private lateinit var mPath: Path
    private var mTabWidth = 0

    private var mRadius = dp2px(36)

    constructor(context: Context) : super(context){
        init(context)
    }
    constructor(context: Context, attrs: AttributeSet?): super(context, attrs){
        init(context)
    }
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int): super(context, attrs, defStyleAttr){
        init(context)
    }

    private fun init(context: Context){
        setBackgroundColor(Color.DKGRAY)
        setWillNotDraw(false)
        mPaint = Paint(Paint.ANTI_ALIAS_FLAG)
        mPaint.style = Paint.Style.FILL_AND_STROKE
        mPaint.color = Color.WHITE
        mPaint.strokeWidth = 1f
        mPath = Path()

        mTabWidth = width / 5
//        val view = LayoutInflater.from(context).inflate(R.layout.main_bottom_navigation_layout, this)
//        addView(view)
    }

    override fun onDraw(canvas: Canvas) {
        val dp28 = dp2px(36)
        val dp18 = dp2px(64)

        val dpx = dp28 - (width / 2 - dp2px(150))
        val dpy = dp28 + (width / 2 - dp2px(150))
//        paint.setColor(getResources().getColor(R.color.White));
//        mPaint.setShadowLayer(15f,0f,0f, Color.RED);
        mPath.moveTo(0f, dp28)
        mPath.lineTo( width / 2 - dp28, dp28)
        val rectF = RectF(width / 2 - dp28, 0f,width / 2 + dp28, 2 * dp28)
        mPath.addArc(rectF, 180f, 180f)
        mPath.moveTo(width / 2 + dp28, dp28)
        mPath.lineTo(width.toFloat(), dp28)
        mPath.lineTo(width.toFloat(),  dp28 + dp18)
        mPath.lineTo(0f, dp28 + dp18)
        mPath.lineTo(0f, dp28)
        // close 会闭合图形 比如绘制弧线会变成闭合的线路
//        mPath.close();
        canvas.drawPath(mPath, mPaint);
        super.onDraw(canvas)
    }

    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
        super.onLayout(changed, l, t, r, b)
    }


    private fun dp2px(value: Int): Float{
        return value * resources.displayMetrics.density
    }

}