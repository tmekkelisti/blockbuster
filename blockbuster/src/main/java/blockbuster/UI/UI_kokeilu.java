/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blockbuster.UI;

import blockbuster.blockbuster.Logic;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author teeyoshi@cs
 */
public final class UI_kokeilu extends JFrame implements KeyListener {

    JFrame frame;
    JPanel titlePanel, gamePanel;
    JLabel bbLabel;
    Logic logic;

    public UI_kokeilu(Logic logic) throws InterruptedException {
        super("kokeilua");
        this.logic = logic;
        
        setSize(400, 700);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
//        gamePanel = new GamePanel(logic);
//        gamePanel.revalidate();
//        add(gamePanel);
//        setContentPane(gamePanel);

//        JFrame.setDefaultLookAndFeelDecorated(true);
//        this.frame = new JFrame("KOKEILUUI");
        setContentPane(this.luoUI());
//
        setFocusable(true);
        requestFocus();
        addKeyListener(this);
//        
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setSize(400, 700);
//        frame.setVisible(true);
        

        
    }
    

    public void aja(GamePanel gamePanel){
            logic.moveAll();
            
        
    }
    

    public JPanel luoUI() {
        
        gamePanel = new GamePanel(logic);
        gamePanel.setVisible(true);
        gamePanel.setOpaque(true);

        return gamePanel;
    }
//        JPanel totalGUI = new JPanel();
//        totalGUI.setLayout(null);
//
//        JPanel gamePanel = new GamePanel(logic);
//        totalGUI.add(gamePanel);
//        
//        JPanel peli = new JPanel();
//        peli.setLayout(null);
//        peli.setBorder(BorderFactory.createLineBorder(Color.black));
//        peli.setLocation(0, 0);
//        peli.setSize(400, 500);
//        peli.revalidate();
//        peli.repaint();
//        
//        totalGUI.add(peli);
//
//        
//        
//        titlePanel = new JPanel();
//        titlePanel.setLayout(null);
//        titlePanel.setLocation(0, 580);
//        titlePanel.setSize(250, 30);
//        totalGUI.add(titlePanel);
//
//        bbLabel = new JLabel("Blockbuster");
//        bbLabel.setLocation(10, 575);
//        bbLabel.setSize(120, 25);
//        bbLabel.setHorizontalAlignment(0);
//        titlePanel.add(bbLabel);
//
//        JPanel buttonPanel = new JPanel();
//        buttonPanel.setLayout(null);
//        buttonPanel.setBorder(BorderFactory.createLineBorder(Color.black));
//        buttonPanel.setLocation(0, 650);
//        buttonPanel.setSize(400, 50);
//
//        totalGUI.add(buttonPanel);
//
//        JButton startButton = new JButton("START");
//        startButton.setLocation(0, 600);
//        startButton.setSize(100, 50);
//        buttonPanel.add(startButton);
//
//        totalGUI.setVisible(true);
//        totalGUI.setOpaque(true);
//        return totalGUI;
//    }


    @Override
    public void keyTyped(KeyEvent ke) {
        logic.keyTyped(ke.getKeyChar());
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        try {
            logic.keyPressed(ke.getKeyCode());
        } catch (IOException ex) {
            Logger.getLogger(UI_kokeilu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        logic.keyReleased(ke.getKeyCode());
    }

}
