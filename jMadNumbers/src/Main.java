/**
 * jMadNumbers - Mad Numbers game written in Java
 */

import java.util.concurrent.LinkedBlockingQueue;

import model.Model;
import view.View;
import controller.Controller;
import events.BoardEvent;

/**
 * Main application class.
 * Takes care of creating model, view and controller objects.
 * Creates event queue and connects it to other objects
 */

public class Main
{
    private static LinkedBlockingQueue<BoardEvent> eventQueue;     
    private static Model model;
    private static View view;
    
    public static void main(String[] args)
    {    
        eventQueue = new LinkedBlockingQueue<BoardEvent>();
        view = new View(eventQueue);
        model = new Model(view);
        new Controller(model, view, eventQueue);
    }
}
