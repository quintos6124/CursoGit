package poo;
import javax.swing.*;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.*;
import java.util.*;


public class PruebaTemporizador {
    public static void main(String[] args) {
        DameLaHora oyente=new DameLaHora();

        Timer mitemporizador=new Timer(5_000,oyente);
        mitemporizador.start();

        JOptionPane.showMessageDialog(null,"Pulsa aceptar para detener");
        System.exit(0);
    }
}

class DameLaHora implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {
        Date ahora=new Date();
        System.out.println("Te pongo la hora cada 5 seg: "+ahora);
        Toolkit.getDefaultToolkit().beep();
    }
}