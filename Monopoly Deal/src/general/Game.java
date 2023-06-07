package general;

import card.Card;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;

public class Game {

	public static ArrayList<Player>  playerList = new ArrayList<>();
	Player firstPlayer;

	public static Stack<Card> cardLibrary = new Stack<Card>();
	public static ArrayList<Card> discard = new ArrayList<Card>();// after using

	public void shuffle(){
		Collections.shuffle(cardLibrary);
	}

	public Stack<Card> getCards() {
		return cardLibrary;
	}

	public void  setUp(){

		Scanner scanner = new Scanner(System.in);

		//ask user how many player

		System.out.print("How many players? ");
		int playerCount = scanner.nextInt();
		scanner.nextLine();


		LocalDate minBirthday = null;

		//ask the name and birthday

		for (int i = 0; i < playerCount; i++) {
			System.out.print("please insert player" + (i + 1) + " 's name: ");
			String name = scanner.nextLine();

			System.out.print("please insert " + name + " 's birth (YYYY-MM-DD) : ");
			String birthdayString = scanner.nextLine();
			LocalDate birthday = LocalDate.parse(birthdayString, DateTimeFormatter.ISO_LOCAL_DATE);

			playerList.add(new Player(name,birthday));



		}

		//decide which one first and order

		for (Player player:playerList){
			if (minBirthday == null || player.birth.isAfter(minBirthday)) {
				minBirthday = player.birth;
				firstPlayer = player;
			}
		}

		System.out.println(firstPlayer.name);

	}

	public void turnRound(){

		int index = playerList.indexOf(firstPlayer);
		while (true){
			Round round = new Round(playerList.get(index%4));
			System.out.println("It is "+playerList.get(index%4).name +" round");
			boolean win = round.inRound();
			if (win){
				break;
			}
			index++;
			//maybe can add a limit to reuse card before it is empty
			//need to consider card used and the library
		}



	}



}
