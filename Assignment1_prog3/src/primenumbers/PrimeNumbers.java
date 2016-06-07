/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package primenumbers;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
/**
 *
 * @author Therock
 */
public class PrimeNumbers extends Thread{

    static Boolean[] primes;
    static int index,size;
    static JTextArea ta;
    static GUI g;

    public static void main(String[] args) {   
        g = new GUI();
        JPanel p1 = new JPanel();
        p1.setLayout(new FlowLayout());
        
        JLabel j = new JLabel("Please enter a positive integer.");
        JTextField tf = new JTextField(10);
        JButton b = new JButton("Go");
        
        p1.add(j);
        p1.add(tf);
        p1.add(b);
        
        g.add("North",p1);
        
        ta = new JTextArea(25,80);
        JScrollPane sp = new JScrollPane(ta);
        g.getContentPane().add(sp);
        
        
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                ta.setText(null);
                if(tf.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Please enter an integer.");
                    size = 0;
                }else{
                    try {
                        size = Integer.parseInt(tf.getText());
                        primes = new Boolean[size];
                        primes[0] = false;
                        primes[1] = false;
                        for(int i = 2; i < primes.length; i++){
                            primes[i] = true;
                        }


                        for(index = 2; index < Math.sqrt(size); index++){
                            if(primes[index] == true){
                                Thread t = new PrimeNumbers();
                                t.start();
                                try {
                                    t.join();
                                } catch (InterruptedException ex) {
                                    ex.getMessage();
                                }
                            }            
                        }

                        primesPrint();
                        
                      } catch (NumberFormatException nfe) {
                        JOptionPane.showMessageDialog(null, "Not a number");
                      }
                }
            }
        });
        g.setVisible(true);  
        
    }
    @Override
    public void run(){
        for(int j = index; j < size; j++){
            if(j%index == 0 && j != index)
            isPrime(j);
        }
    }
    public static synchronized void isPrime(int ind){
        primes[ind] = false;
    }

    public static void primesPrint(){
        int counter = 0;
        for(int k = 0; k < size; k++){
            if(primes[k] == true){
                ta.append(k + "\t");
                counter++;
                if(counter%10 == 0)
                    ta.append("\n");
            }
        }
    }      
}
