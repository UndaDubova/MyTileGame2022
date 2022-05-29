import Display.Display;

public class Game implements Runnable {

    private Display display;
    public int width, height;
    public String title;
    private boolean running = false;
    //A thread will let us run a class separately from the rest of the program
    //We need to allow this game class to run on a thread (implement runnable).
    // If you implement runnable you must have a public void run method.

    private Thread thread;

    public Game(String title, int width, int height) {

        this.width = width;
        this.height = height;
        this.title = title;

    }

    private void init() {
        display = new Display(title, width, height);
    }
    private void tick(){}
    private void render(){}
//here we need to use the game loop:
    public void run() {
        init();
        while(running){
            tick();
            render();
        }
        stop();
    }

    public synchronized void start() {
        if(running)
            return;
        running = true;
        thread = new Thread(this); //this game class
        thread.start();//this one calls the run method
    }

    public synchronized void stop() {
        if(!running)
            return;
        running = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
