/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package primenumbers;
import javax.swing.JFrame;
import java.awt.*;
/**
 *
 * @author Therock
 */
public class GUI extends JFrame{
    public GUI(){
        setTitle("Prime Numbers");
        setLayout(new FlowLayout());
        setSize(1000,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
