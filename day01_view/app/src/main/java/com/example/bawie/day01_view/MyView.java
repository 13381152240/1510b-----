package com.example.bawie.day01_view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import static android.content.ContentValues.TAG;

/**
 * Created by fan on 2017/11/30.
 */

public class MyView extends View {

    //API版本有关系
    public MyView(Context context) {
        super(context);
    }

    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public MyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    //测量
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        Log.d(TAG, "onMeasure: ");
    }

    //绘制
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Log.d(TAG, "onDraw: ");
        // 创建画笔

        /*
        *
        * void set  ARGB(int a, int r, int g, int b) //设置Paint对象颜色，参数一为alpha透明通道
void setAlpha(int a) //设置alpha不透明度，范围为0~255
void setAntiAlias(boolean aa) //是否抗锯齿，默认值是false
void setColor(int color) //设置颜色，这里Android内部定义的有Color类包含了一些常见颜色定义
void setFakeBoldText(boolean fakeBoldText) //设置伪粗体文本
void setLinearText(boolean linearText) //设置线性文本
PathEffect setPathEffect(PathEffect effect) //设置路径效果
Rasterizer setRasterizer(Rasterizer rasterizer) //设置光栅化
Shader setShader(Shader shader) //设置阴影 ,我们在后面会详细说一下Shader对象的
void setTextAlign(Paint.Align align) //设置文本对齐
void setTextScaleX(float scaleX) //设置文本缩放倍数，1.0f为原始
void setTextSize(float textSize) //设置字体大小
Typeface setTypeface(Typeface typeface) //设置字体，Typeface包含了字体的类型，粗细，还有倾斜、颜色等
        *
        *
        * */
        Paint p = new Paint();
        Paint p2 = new Paint();
        p2.setColor(Color.YELLOW);
        p.setColor(Color.RED);// 设置红色

        canvas.drawText("画圆：", 10, 20, p);// 画文本
       // canvas.drawCircle(100, 40, 100, p);// 小圆
        p.setAntiAlias(true);// 设置画笔的锯齿效果。 true是去除，大家一看效果就明白了
        //canvas.drawCircle(200, 80, 200, p);// 大圆
        //第一圆（x=100 y=200 ，r=100）
        canvas.drawCircle(200, 200, 100, p2);//绘制圆

        RectF oval3 = new RectF(80, 260, 200, 300);// 设置个新的长方形
        RectF oval2 = new RectF(100, 400, 400, 500);// 设置个新的长方形
         //直角矩形位置（x=100，y=400）
        canvas.drawRect(oval2,p);//直角矩形


       // canvas.drawRoundRect(oval3,100,300,p);//第二个参数是x半径，第三个参数是y半径


       /* //画贝塞尔曲线
        canvas.drawText("画贝塞尔曲线:", 10, 310, p);
        p.reset();
        p.setStyle(Paint.Style.STROKE);
        p.setColor(Color.RED);
        p.setStrokeWidth(10);
        Path path2=new Path();
        path2.moveTo(100, 200);//设置Path的起点
        path2.quadTo(150, 310, 170, 400); //设置贝塞尔曲线的控制点坐标和终点坐标
        canvas.drawPath(path2, p);//画出贝塞尔曲线

        //画点
        p.setStyle(Paint.Style.FILL);
        canvas.drawText("画点：", 10, 390, p);
        canvas.drawPoint(60, 390, p);//画一个点
        canvas.drawPoints(new float[]{60,400,65,400,70,400}, p);//画多个点*/
        RectF rect = new RectF(30, 20, 600, 700);


        canvas.drawArc(rect, //弧线所使用的矩形区域大小
                0,  //开始角度
                90, //扫过的角度
                true, //是否使用中心
                p);

        //绘制图片
        //画图片，就是贴图
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);
        canvas.drawBitmap(bitmap, 250,360, p);


    }
    //位置
    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        Log.d(TAG, "onLayout: ");
    }
    //监听
    @Override
    public boolean onTouchEvent(MotionEvent event) {

        Log.d(TAG, "onTouchEvent: ");
        return super.onTouchEvent(event);
    }
}

