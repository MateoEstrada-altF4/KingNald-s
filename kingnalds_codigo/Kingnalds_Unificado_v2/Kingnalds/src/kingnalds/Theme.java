package kingnalds;

import java.awt.Color;
import java.awt.Font;

final class Theme {
    static final Color BLACK=new Color(5,6,6), SURFACE=new Color(16,15,14);
    static final Color GOLD=new Color(202,164,78), GOLD_LIGHT=new Color(240,211,145);
    static final Color IVORY=new Color(238,226,199), MUTED=new Color(158,155,148);
    static final Color WINE=new Color(76,13,18), WINE_HOVER=new Color(119,29,32);
    static Font serif(int style,int size){return new Font("Serif",style,size);}
    static Font sans(int style,int size){return new Font("SansSerif",style,size);}
    private Theme(){}
}

