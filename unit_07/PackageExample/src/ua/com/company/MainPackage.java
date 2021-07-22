package ua.com.company;

import ua.com.company.classes.Inheritor;

public class MainPackage 
{
    public MainPackage()
    {
        BaseClass bc = new BaseClass();
        Inheritor ir = new Inheritor();

        System.out.println (bc.toString());
        System.out.println (ir.toString());
    }
    
    public static void main(String[] args) 
    {
        new MainPackage();
        System.exit(0);
    }
}
