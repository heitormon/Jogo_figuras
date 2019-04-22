package br.com.heitor.jogo_figuras;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

public class FigurasView extends View {

    public FigurasView(Context context){
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //Circulo
        int x = getWidth();
        int y = getHeight();
        int raio=100;
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.WHITE);
        canvas.drawPaint(paint);
        paint.setColor(Color.parseColor("#da4747"));
        canvas.drawCircle(x/4,2*y/4,raio,paint);

        //Quadrado
        canvas.drawRect(100,100,200,200,paint);

        //Triangulo
        canvas.drawCircle(3*x/4,2*y/4,raio,paint);

        //Retangulo
        canvas.drawCircle(3*x/4,3*y/4,raio,paint);
    }
}
