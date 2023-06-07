package general;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Game {

	public ArrayList<Player> playerList;
	Player firstPlayer;

	public void  setUp(){

		Scanner scanner = new Scanner(System.in);

		//ask user how many player

		System.out.print("How many players?");
		int playerCount = scanner.nextInt();
		scanner.nextLine(); // ÏûºÄ»»ÐÐ·û


		LocalDate minBirthday = null;

		//ask the name and birthday

		for (int i = 0; i < playerCount; i++) {
			System.out.print("please insert player" + (i + 1) + " 's name");
			String name = scanner.nextLine();

			System.out.print("please insert " + name + " 's birth (YYYY-MM-DD) : ");
			String birthdayString = scanner.nextLine();
			LocalDate birthday = LocalDate.parse(birthdayString, DateTimeFormatter.ISO_LOCAL_DATE);

			playerList.add(new Player(name,this,birthday));



		}

		//decide which one first and order

		for (Player player:playerList){
			if (minBirthday == null || player.birth.isBefore(minBirthday)) {
				minBirthday = player.birth;
				firstPlayer = player;
			}
		}

		//setup cards




		//start game in main


	}

}
