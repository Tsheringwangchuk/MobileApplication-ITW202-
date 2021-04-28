package edu.gcit.to_d0_9;

public class calculator {
    public enum Operator{ADD, SUB, MUL, DIV}

    public double add(double firstoperand, double secondoperand)
    {
        return firstoperand + secondoperand;
    }
    public double sub(double firstoperand, double secondoperand)
    {
        return firstoperand - secondoperand;
    }
    public double mul(double firstoperand, double secondoperand)
    {
        return firstoperand * secondoperand;
    }
    public double div(double firstoperand, double secondoperand)
    {
        return firstoperand / secondoperand;
    }
}
