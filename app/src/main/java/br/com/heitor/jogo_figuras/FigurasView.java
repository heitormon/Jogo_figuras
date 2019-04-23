package br.com.heitor.jogo_figuras;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class FigurasView extends View {

    public FigurasView(Context context){
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        ArrayList<Point> Ponteiros = new ArrayList<>();
        Paint paint = new Paint();
        Path path = new Path();
        int x = getWidth();
        int y = getHeight();
        int raio=100;
        Ponteiros = gerarPosições();
//        Point posição1 = new Point(x/4,2*y/4);
//        Point posição2 = new Point(x/4,3*y/4);
//        Point posição3 = new Point(3*x/4,2*y/4);
//        Point posição4 = new Point(3*x/4,3*y/4);

        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.WHITE);
        canvas.drawPaint(paint);
        paint.setColor(Color.parseColor("#da4747"));
        //Circulo
        canvas.drawCircle(Ponteiros.get(0).x,Ponteiros.get(0).y,raio,paint);

        //Quadrado
        canvas.drawRect((Ponteiros.get(1).x)-raio,(Ponteiros.get(1).y)-raio,raio+Ponteiros.get(1).x,raio+Ponteiros.get(1).y,paint);

        //Triangulo
       // canvas.drawCircle(3*x/4,2*y/4,raio,paint);
        Point a = new Point(Ponteiros.get(2).x, (Ponteiros.get(2).y)-raio);
        Point b = new Point(raio+Ponteiros.get(2).x, raio+Ponteiros.get(2).y);
        Point c = new Point((Ponteiros.get(2).x)-raio, raio+Ponteiros.get(2).y);

//        path.setFillType(Path.FillType.EVEN_ODD);

        path.lineTo(a.x, a.y);
        path.lineTo(b.x, b.y);
        path.lineTo(c.x, c.y);
        path.lineTo(a.x, a.y);
        path.close();

        canvas.drawPath(path, paint);
        //Retangulo

        canvas.drawRect((Ponteiros.get(3).x)-raio/2,(Ponteiros.get(3).y)-raio,raio/2+Ponteiros.get(3).x,raio+Ponteiros.get(3).y,paint);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);
    }

    public ArrayList<Point> gerarPosições(){
        ArrayList<Point> Ponteiros = new ArrayList<>();
        int x = getWidth();
        int y = getHeight();
        Point posição1 = new Point(x/4,2*y/4);
        Point posição2 = new Point(x/4,3*y/4);
        Point posição3 = new Point(3*x/4,2*y/4);
        Point posição4 = new Point(3*x/4,3*y/4);
        Ponteiros.add(posição1);
        Ponteiros.add(posição2);
        Ponteiros.add(posição3);
        Ponteiros.add(posição4);
        Collections.shuffle(Ponteiros);
        return Ponteiros;

    }
}
