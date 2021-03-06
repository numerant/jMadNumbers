package controller;

import java.util.concurrent.BlockingQueue;

import events.BoardEvent;
import model.Model;
import view.View;

/**
 * Class implementing controller in MVC pattern
 */

public class Controller
{
    private BlockingQueue<BoardEvent> eventQueue;
    private Model model;
    private View view;
    
    public Controller(final Model model, final View view, final BlockingQueue<BoardEvent> eventQueue)
    {
        this.model = model;
        this.view = view;
        this.eventQueue = eventQueue;
          
        eventQueueLoop();
    }
    
    /**
     * Event queue loop - waits for a new event in the queue, takes it and starts processing method
     */
    
    private void eventQueueLoop()
    {
        while(true)
        {
            try
            {
                BoardEvent newEvent = eventQueue.take();
                processEvent(newEvent);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }
    
    /**
     * Method responsible for processing event from the queue. Calls model and view, if necessary.
     */
    
    private void processEvent(BoardEvent newEvent)
    {
        newEvent.process(view, model);
    }
}
