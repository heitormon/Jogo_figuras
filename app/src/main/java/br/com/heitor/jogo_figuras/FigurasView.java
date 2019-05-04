package br.com.heitor.jogo_figuras;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.RectF;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class FigurasView extends View {
    private boolean telaCriada=false;
    private ArrayList<Point> ponteiro = new ArrayList<>();

    public FigurasView(Context context){
        super(context);
    }

    private ArrayList<Point> posicoes = new ArrayList<>();

    public ArrayList<Point> gerarPosicoes(){
        ArrayList<Point> Ponteiros = new ArrayList<>();
        int x = getWidth();
        int y = getHeight();
        Point posição1 = new Point(3*x/6,2*y/6);
        Point posição2 = new Point(2*x/6,3*y/6);
        Point posição3 = new Point(3*x/6,4*y/6);
        Point posição4 = new Point(4*x/6,3*y/6);
        Ponteiros.add(posição1);
        Ponteiros.add(posição2);
        Ponteiros.add(posição3);
        Ponteiros.add(posição4);


        return Ponteiros;

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        posicoes = gerarPosicoes();
        gerarFiguras(canvas, paint, posicoes);

    }
    public void gerarFiguras(Canvas canvas, Paint paint,ArrayList<Point> Ponteiros) {

        int y = getHeight();
        float raio= (float) (1.3*y/6);
        Random random = new Random ();
        int a = random.nextInt(156)+100;
        int r = random.nextInt(156)+100;
        int g = random.nextInt(156)+100;
        int b = random.nextInt(156)+100;

        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.WHITE);
        canvas.drawPaint(paint);
        paint.setColor(Color.argb(a, r, g, b));
        //Circulo
        canvas.drawCircle(Ponteiros.get(0).x,Ponteiros.get(0).y,raio,paint);
        //Circulo
        canvas.drawCircle(Ponteiros.get(1).x,Ponteiros.get(1).y,raio,paint);
        //Circulo
        canvas.drawCircle(Ponteiros.get(2).x,Ponteiros.get(2).y,raio,paint);
        //Circulo
        canvas.drawCircle(Ponteiros.get(3).x,Ponteiros.get(3).y,raio,paint);


    }
}
