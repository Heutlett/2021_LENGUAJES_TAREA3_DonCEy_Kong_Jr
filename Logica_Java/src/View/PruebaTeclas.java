package View;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

public class PruebaTeclas {

    public static void main(String[] args) {

        new WindowPrinc();
    }

}

class WindowPrinc extends JFrame {

    private JLabel lDireccion, lCouunt;
    private int disp;
    java.util.List<String> Dir;


    public WindowPrinc() {

        setTitle("Prueba");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setBounds(Toolkit.getDefaultToolkit().getScreenSize().width/2 - 100,
                Toolkit.getDefaultToolkit().getScreenSize().height/2 - 100,
                100, 100);

        setLayout(new FlowLayout());

        lDireccion = new JLabel("Direccion: N/A");
        lCouunt = new JLabel("Disparos: 0");
        disp = 0;
        Dir = new ArrayList<>();
        Dir.add("N/A");

        add(lDireccion);
        add(lCouunt);

        this.addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {

                int c = 0;

                if(c == 0 && Dir.size() < 2) {

                    switch(e.getKeyCode()) {

                        case KeyEvent.VK_UP:
                            Dir.add("ARRIBA");
                            break;
                        case KeyEvent.VK_DOWN:
                            Dir.add("ABAJO");
                            break;
                        case KeyEvent.VK_LEFT:
                            Dir.add("IZQUIERDA");
                            break;
                        case KeyEvent.VK_RIGHT:
                            Dir.add("DERECHA");
                            break;
                    }
                    c++;
                }

                if(e.getKeyCode() == KeyEvent.VK_SPACE) {
                    disp++;
                    lCouunt.setText("Disparos: " + disp);
                }

                lDireccion.setText("Direccion: " + Dir.get(Dir.size()-1));
            }

            @Override
            public void keyReleased(KeyEvent e) {

                switch(e.getKeyCode()) {

                    case KeyEvent.VK_UP:
                        deleteKey("ARRIBA");
                        break;
                    case KeyEvent.VK_DOWN:
                        deleteKey("ABAJO");
                        break;
                    case KeyEvent.VK_LEFT:
                        deleteKey("IZQUIERDA");
                        break;
                    case KeyEvent.VK_RIGHT:
                        deleteKey("DERECHA");
                        break;
                }

                lDireccion.setText("Direccion: " + Dir.get(Dir.size()-1));
            }

            void deleteKey(String dir) {

                for(int i = 0; i < Dir.size(); i++) {

                    if(dir == Dir.get(i)){

                        Dir.remove(i);
                    }
                }

                if(Dir.size() == 0) {

                    Dir.add("N/A");
                }
            }
        });

        setVisible(true);
    }
}



