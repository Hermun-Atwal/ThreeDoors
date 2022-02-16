import java.util.Random;

public class ThreeDoors {
	public static void main(String[] args) {
		System.out.println("You have three doors and behind one there is a brand new car, if you choose the right door you get to take the car home. "
				+ "\nAfter you choose a door the host, who knows where the car is opens one of the doors that you did not choose and \nreveals that the car is not there"
				+ " and gives you the opportunity to swap your chosen door with the remaining door.\n");
		System.out.println("At first the probability of you chosing the right door is 1/3. Even with removing one of the doors it seems that the \n"
				+ "new probability would be 1/2, but in fact after removing one of the doors each door has a different probability. your door \n"
				+ "has a probabilty of 1/3 still and the door that the host did not remove has a probability of 2/3. The following is a simulation \n"
				+ "of the gameshow.\n");
		System.out.println("These probabilities are dependant on certain senarios and assumptions, after the door is chosen by the player\n"
				+ "we have more information on the remaining two doors, because the host must choose to eliminate one that is not the correct door.\n"
				+ "Since the host explicitly chose not to eliminate the remaining door it adds value to its probability, but not to the players door.\n"
				+ "We must note that chosing between these last two doors is not the same as chosing between two doors at random, staying does not \n"
				+ "make use of the new information.\n");
		int n = 100000;
		double stayCount = 0;
		double changeCount = 0;
		for(int i = 0; i<n; i++) {
			if(gameShow(true)) {
				stayCount++;
			}
			if(gameShow(false)) {
				changeCount++;
			}
		}
		System.out.println("Results after "+n+" games each: \nStay: "+stayCount/n*100+"% Change: "+changeCount/n*100+"%");
	}
	public static boolean gameShow(boolean stay) {
		int  [] doors = new int[3];
		Random rand = new  Random();
		int prizeDoor = rand.nextInt(3);
		doors[prizeDoor]++;
		int choosenDoor = rand.nextInt(3);
		doors[choosenDoor]++;
		for(int i = 0; i<doors.length; i++) {
			if(doors[i] == 0) {
				doors[i]--;
			}
		}
		if(stay && prizeDoor == choosenDoor || !stay && prizeDoor != choosenDoor) {
			return true;
		}
		return false;
	}
}
