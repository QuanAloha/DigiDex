package app;

public class AppControl {

    public GameControl ()
	{
		System.out.println("Starting DigiDex...");
		
		// The constructor is called from main, so it is executing in the main thread.
		// All GUI work needs to be done by the GUI thread.  Make a call to ask the
		// GUI thread to run this object, then simply return to main.  The remainder
		// of the game setup will take place when the 'run' method is called by
		// the GUI thread (later).
		
		SwingUtilities.invokeLater(this);
		
		// Nothing else for the main thread to do -- simply return.
	}
	
	/**
	 * This is the first function invoked (called) by the GUI thread.
	 * Set up the game.
	 */
	public void run ()
	{
		// Set up game objects.
		state = new AppState(this);
		view = new AppView(state, this);
		
		// Making mouse Listeners
		view.addMouseListener(state);
		view.addMouseMotionListener(state);
		
		// Making a timer to trigger 60 times in a second.
		timer = new Timer(16, this);
		timer.start();
	}
	
	/** This is called when an action is performed and it listens to it.
	 * 
	 * @param e event information
	 */
	public void actionPerformed(ActionEvent e)
	{
		state.updateAll(1.0/60.0);
		view.repaint();
	}
	
	/** This method manages a hash map full of image references for TT.
	 * 
	 * @param name The path name of the image.
	 * @return Buffered image of the desired image.
	 */
	public BufferedImage loadImage(String name)
	{
		// Load the background jpg
		try
		{
			// Go through the map and search the desired image.
			
			if (images.containsKey(name))
			{
				return (BufferedImage) images.get(name);
			}
			
			// If the image isn't loaded yet then load it and store in the map.
			ClassLoader loader = this.getClass().getClassLoader();
			InputStream is = loader.getResourceAsStream(name);
			image = javax.imageio.ImageIO.read(is);
			
			images.put(name,image);
		}
		catch (IOException e)
		{
			System.out.println("Unable to load background.");
		}
		// Return the loaded file. 
		return (BufferedImage) images.get(name);
	}
    
}
