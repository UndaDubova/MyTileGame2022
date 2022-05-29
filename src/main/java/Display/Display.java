package Display;


import javax.swing.*;
import java.awt.*;

public class Display {
    private JFrame frame;
    private Canvas canvas;

    private String title;
    private int width,height;

    //constructor for display class
    public Display(String title, int width, int height){
        this.title = title;
        this.width = width;
        this.height = height;

        createDisplay();
    }

    //createDisplay method will initialize the JFrame
    private void createDisplay(){
        frame= new JFrame(title);
        frame.setSize(width,height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //w/o this line the window will close, but the process will keep running.

        //next - optional things:
        frame.setResizable(false); //non-resizable window
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);//LOL

        //canvas

        canvas = new Canvas();
        canvas.setPreferredSize(new Dimension(width, height));
        canvas.setMaximumSize(new Dimension(width, height));
        canvas.setMinimumSize(new Dimension(width, height));
        frame.add(canvas);
        frame.pack(); // will resize window so we can see canvas fully
    }


}
