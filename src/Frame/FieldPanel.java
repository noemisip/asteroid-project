package Frame;

import Modell.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class FieldPanel extends JPanel{
    static JLabel image;
    static JLabel icon;
    static View view;

    public FieldPanel() {
        try {
            image = new JLabel(new ImageIcon(ImageIO.read(new File("background.png"))));
        } catch (IOException e) {
            e.printStackTrace();
        }
        setMaximumSize(new Dimension(10, 10));
        this.setLayout(new BorderLayout());
        this.add(image);
        this.setVisible(true);
    }

    public static void init(String image_icon, Drawable drawable) {
        try {
            icon = new JLabel(new ImageIcon(ImageIO.read(new File(image_icon))));
        } catch (IOException e) {
            e.printStackTrace();
        }
        icon.setBounds(drawable.GetX(),drawable.GetY(),200,200);
        image.add(icon);
    }
    @Override public void paint(Graphics g) {

        try {
            Point upPt = new Point(350, 0);
            Point dnPt = new Point(700, 650);
            final BufferedImage upImg = ImageIO.read(new File("background.png"));
            if (upImg != null) {
                g.drawImage(upImg, upPt.x, upPt.y, this);

                if (view.GetDrawables() != null) {
                    for(int h=0;h<view.GetDrawables().size();h++) {
                        if(view.GetDrawables().get(h).GetName()!=null) {
                            if (view.GetDrawables().get(h).GetName().contains("asteroid")) {
                                Asteroid ast = (Asteroid) Main.getInstance().GetHash().get(view.GetDrawables().get(h).GetName());
                                if (ast.GetNeighbours() != null) {
                                    for (int l = 0; l < ast.GetNeighbours().size(); l++) {
                                        String peldanynev = Main.getInstance().GetKey(ast.GetNeighbours().get(l).GetAsteroid());
                                        for (int u = 0; u < view.GetDrawables().size(); u++) {
                                            if (view.GetDrawables().get(u).GetName() == peldanynev) {
                                                g.drawLine(view.GetDrawables().get(h).GetX()+10, view.GetDrawables().get(h).GetY()+10,
                                                        view.GetDrawables().get(u).GetX()+10, view.GetDrawables().get(u).GetY()+10);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }

                    for(int j=0;j<view.GetDrawables().size();j++){
                        view.GetDrawables().get(j).Draw(g,this);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void SetView(View v){view=v;}
}
