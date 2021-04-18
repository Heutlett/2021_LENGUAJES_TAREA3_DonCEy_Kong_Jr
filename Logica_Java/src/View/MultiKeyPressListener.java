package View;

import Controller.GameManager;
import Models.Entidades.Movibles.EntidadMovible;
import Models.Entidades.Movibles.Mono;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

class MultiKeyPressListener implements KeyListener {
    // Set of currently pressed keys

    GameManager gameManager;

    public MultiKeyPressListener(GameManager gameManager){
        this.gameManager = gameManager;
    }

    private final Set<Integer> pressedKeys = new HashSet<>();


    @Override
    public synchronized void keyPressed(KeyEvent e) {
        pressedKeys.add(e.getKeyCode());
        Point offset = new Point();
        if (!pressedKeys.isEmpty()) {
            for (Iterator<Integer> it = pressedKeys.iterator(); it.hasNext();) {
                switch (it.next()) {
                    case KeyEvent.VK_UP:
                        offset.y = -1;
                        break;
                    case KeyEvent.VK_LEFT:
                        offset.x = -1;
                        break;
                    case KeyEvent.VK_DOWN:
                        offset.y = 1;
                        break;
                    case KeyEvent.VK_RIGHT:
                        offset.x = 1;
                        System.out.println("DERECHAA");
                        break;


                }
            }
        }

        if(offset.x == -1 && offset.y ==1){
            System.out.println("Estoy presionando dos teclas");
        }

        //System.out.println(offset); // Do something with the offset.
    }

    @Override
    public synchronized void keyReleased(KeyEvent e) {
        pressedKeys.remove(e.getKeyCode());
    }

    @Override
    public void keyTyped(KeyEvent e) { /* Not used */ }
}