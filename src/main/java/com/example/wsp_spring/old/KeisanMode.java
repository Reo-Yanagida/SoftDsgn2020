package com.example.wsp_spring.old;

public class KeisanMode {

    private final float x;
    private final float y;
    private final String mode;

    public KeisanMode(float x, float y, String mode) {
        this.x = x;
        this.y = y;
        this.mode = mode;
    }

    public float getAns() {
        switch (mode) {
            case "+":
                return x + y;
            case "-":
                return x - y;
            case "*":
                return x * y;
            case "/":
                return x / y;
            //ここから
            case "%":
                return x % y;
            //ここまで追加
        }
        return 0;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public String getMode() {
        return mode;
    }

}
