package kingnalds;

import java.awt.*;
import java.awt.geom.*;
import javax.swing.Icon;

final class VectorIcon implements Icon {
    enum Type {CROWN,HOME,MENU,TAG,BAG,MORE,CART,SCOOTER,CALENDAR,BURGER,COFFEE,SHARE}
    private final Type type; private final int size; private final Color color;
    VectorIcon(Type type,int size,Color color){this.type=type;this.size=size;this.color=color;}
    public int getIconWidth(){return size;} public int getIconHeight(){return size;}
    public void paintIcon(Component c,Graphics raw,int x,int y){
        Graphics2D g=(Graphics2D)raw.create();g.translate(x,y);g.scale(size/32.0,size/32.0);
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        g.setColor(color);g.setStroke(new BasicStroke(1.8f,BasicStroke.CAP_ROUND,BasicStroke.JOIN_ROUND));draw(g);g.dispose();
    }
    private void draw(Graphics2D g){
        switch(type){
            case CROWN:{Path2D p=new Path2D.Double();p.moveTo(4,10);p.lineTo(10,20);p.lineTo(16,8);p.lineTo(22,20);p.lineTo(28,10);p.lineTo(25,26);p.lineTo(7,26);p.closePath();g.draw(p);g.drawLine(8,23,24,23);break;}
            case HOME:{Path2D p=new Path2D.Double();p.moveTo(5,15);p.lineTo(16,6);p.lineTo(27,15);g.draw(p);g.draw(new RoundRectangle2D.Double(8,14,16,12,2,2));g.drawRect(14,20,5,6);break;}
            case MENU:for(int i=0;i<3;i++){g.fillOval(5,8+i*7,3,3);g.drawLine(12,10+i*7,27,10+i*7);}break;
            case TAG:{Path2D p=new Path2D.Double();p.moveTo(5,15);p.lineTo(15,5);p.lineTo(26,6);p.lineTo(27,17);p.lineTo(17,27);p.closePath();g.draw(p);g.fillOval(17,9,3,3);break;}
            case BAG:g.draw(new RoundRectangle2D.Double(7,10,18,17,3,3));g.draw(new Arc2D.Double(11,4,10,12,0,180,Arc2D.OPEN));break;
            case MORE:g.fillOval(5,14,4,4);g.fillOval(14,14,4,4);g.fillOval(23,14,4,4);break;
            case CART:g.drawLine(4,7,8,7);g.drawLine(8,7,11,21);g.draw(new RoundRectangle2D.Double(10,10,17,11,3,3));g.fillOval(11,24,3,3);g.fillOval(23,24,3,3);break;
            case SCOOTER:g.drawOval(4,21,7,7);g.drawOval(22,21,7,7);g.drawLine(8,21,22,21);g.drawLine(13,21,17,13);g.drawLine(17,13,24,13);g.drawLine(24,13,26,21);g.drawLine(16,10,22,10);g.drawLine(24,13,26,8);g.drawLine(24,8,29,8);break;
            case CALENDAR:g.draw(new RoundRectangle2D.Double(5,7,22,21,3,3));g.drawLine(5,13,27,13);g.drawLine(10,4,10,10);g.drawLine(22,4,22,10);for(int yy=17;yy<25;yy+=6)for(int xx=10;xx<24;xx+=6)g.fillOval(xx,yy,2,2);break;
            case BURGER:g.draw(new Arc2D.Double(4,5,24,18,0,180,Arc2D.OPEN));g.drawLine(4,14,28,14);g.draw(new RoundRectangle2D.Double(4,17,24,5,3,3));g.draw(new Arc2D.Double(4,18,24,10,180,180,Arc2D.OPEN));break;
            case COFFEE:g.draw(new RoundRectangle2D.Double(6,10,17,15,3,3));g.draw(new Arc2D.Double(20,13,9,9,-90,180,Arc2D.OPEN));g.draw(new Arc2D.Double(10,2,5,11,80,100,Arc2D.OPEN));g.draw(new Arc2D.Double(17,2,5,11,80,100,Arc2D.OPEN));break;
            case SHARE:g.fillOval(4,13,6,6);g.fillOval(22,5,6,6);g.fillOval(22,21,6,6);g.drawLine(9,14,23,9);g.drawLine(9,18,23,23);break;
        }
    }
}
