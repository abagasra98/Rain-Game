/**
 * @author abagas3,jchow23,bkonig2
 */
public class RainGame {

	public static void main(String[] args) {
		// To get points type your netids above (CORRECTLY-Please double check your partner correctly spells your netid correctly!!)
		// Your netid is the unique part of your @illinois email address
		// Do not put your name or your UIN. 
		// REMEMBER TO COMMIT this file...
	
		int x=0, y=0, dx=0, dy=0, score = -1, lives = 3, level = 1;
		String text = "";
		long startTime = System.currentTimeMillis();
		
		Zen.setFont("Helvetica-64");
		while (Zen.isRunning() && lives > 0) {
			
			if (y >= Zen.getZenHeight()) {
				x += 50;
				y = Zen.getZenHeight() / 2;
				//lives--;
			}
			
			if (text.length() == 0) {
				x = 0;
				y = Zen.getZenHeight() / 2;
				dx = 0;
				//if (dy < 15)
					dy += 1;
				System.out.println(dy);
				text = "" + (int) (Math.random() * 999);
				long elapsed = System.currentTimeMillis() - startTime;
				startTime = System.currentTimeMillis();
				score += elapsed / elapsed;
			}
			Zen.setColor(255, 0, 255);
			Zen.fillRect(0, 0, Zen.getZenWidth(), Zen.getZenHeight());

			Zen.setColor(0, 255, 0);
			Zen.drawText(text, x, y);
			
			Zen.drawText("Lives: " + lives,10,60);
			Zen.drawText("Score: " + score,10,120);
			
			x += dx;
			y += dy;
			
			// Find out what keys the user has been pressing.
			String user = Zen.getEditText();
			// Reset the keyboard input to an empty string
			// So next iteration we will only get the most recently pressed keys.
			Zen.setEditText("");
			
			for(int i=0;i < user.length();i++) {
				char c = user.charAt(i);
				try {
					if(c == text.charAt(0))
						text = text.substring(1,text.length()); // all except first character
				} catch (IndexOutOfBoundsException e) {
					System.out.println("Exception caught! New problem generated");
				}
				
			}
			Zen.flipBuffer();
			Zen.sleep(90);// sleep for 90 milliseconds

		}
	}

}
