/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUIpackage;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Alejo
 */
public class PlaceholderListener implements FocusListener,KeyListener {
    private String placeholder;
     private boolean isUserPlaceholderDisplayed = true;
      private boolean isPasswordPlaceholderDisplayed = true;
    
     public PlaceholderListener(String placeholder) {
        this.placeholder = placeholder;
    }
     
    @Override
    public void keyTyped(KeyEvent e) {
       JTextField textField = (JTextField) e.getSource();
        if (textField.getText().equals(placeholder)) {
            e.consume();
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
       JTextField textField = (JTextField) e.getSource();
        if (textField.getText().equals(placeholder)) {
            e.consume();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
       JTextField textField = (JTextField) e.getSource();
        if (textField.getText().isEmpty()) {
            textField.setText(placeholder);
            textField.setForeground(new Color(204, 204, 204));
        } else if (textField.getText().equals(placeholder)) {
            textField.setText("");
            textField.setForeground(new Color(51, 51, 51));
        }
    }

    @Override
    public void focusGained(FocusEvent e) {
        if (e.getSource() instanceof JTextField) {
            JTextField textField = (JTextField) e.getSource();
            if (isUserPlaceholderDisplayed || textField.getText().equals(placeholder)) {
                textField.setText(""); // Borra el marcador de posición cuando se obtiene el foco
                textField.setForeground(new Color(51,51,51));
                isUserPlaceholderDisplayed = false;
            }
        } else if (e.getSource() instanceof JPasswordField) {
            JPasswordField pwdField = (JPasswordField) e.getSource();
            if (isPasswordPlaceholderDisplayed || String.valueOf(pwdField.getPassword()).equals(placeholder)) {
                pwdField.setText("");
                pwdField.setForeground(new Color(51, 51, 51));
                 isPasswordPlaceholderDisplayed = false;
            }
        }
    }

    @Override
    public void focusLost(FocusEvent e) {
       if (e.getSource() instanceof JTextField) {
            JTextField textField = (JTextField) e.getSource();
            if (textField.getText().isEmpty()) {
                textField.setText(placeholder);
                textField.setForeground(new Color(204, 204, 204));
                isUserPlaceholderDisplayed = true;
            }
        } else if (e.getSource() instanceof JPasswordField) {
            JPasswordField pwdField = (JPasswordField) e.getSource();
            if (String.valueOf(pwdField.getPassword()).isEmpty()) {
                pwdField.setText(placeholder);
                pwdField.setForeground(new Color(204, 204, 204));
                isPasswordPlaceholderDisplayed = true;
            }
        }
    }
    
}
