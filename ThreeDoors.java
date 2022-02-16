import java.util.Random;

public class ThreeDoors {
	public static void main(String[] args) {
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
		System.out.println("Results after "+n+" games: \nStay: "+stayCount/n*100+"% Change: "+changeCount/n*100+"%");
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
