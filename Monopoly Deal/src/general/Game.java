package general;

import card.Card;
import card.CardKind;
import card.actionCard.DoubleRent;
import card.actionCard.ForcedDeal;
import card.actionCard.PassGo;
import card.actionCard.SayNo;
import card.actionCard.buildHouse.BuildHotel;
import card.actionCard.buildHouse.BuildHouse;
import card.actionCard.demandMoney.BirthdayCard;
import card.actionCard.demandMoney.DebtCollector;
import card.actionCard.rentCard.MulticoloredRentCard;
import card.actionCard.rentCard.RentCard;
import card.actionCard.steal.DealBreaker;
import card.actionCard.steal.StealDeal;
import card.moneyCard.MoneyCard;
import card.propertyCard.PropertyCard;

import java.time.LocalDate;
import java.time.Period;
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
			Period age = Period.between(birthday, LocalDate.now());
			if (age.getYears() < 8) {
				System.out.println("you are under 8 years age, please try again");
				i--;
				continue;
			}

			playerList.add(new Player(name,birthday));



		}

		//decide which one first and order

		for (Player player:playerList){
			if (minBirthday == null || player.birth.isAfter(minBirthday)) {
				minBirthday = player.birth;
				firstPlayer = player;
			}
		}

		//System.out.println(firstPlayer.name);

		//set up library

		//6 cards of 1M, 5 cards of 2M, 3 cards of 3M, 3 cards of 4M, 2 cards of 5M¡¯ 1 card of 10M.

		cardLibrary.add(new MoneyCard(1,"1M"));
		cardLibrary.add(new MoneyCard(1,"1M"));
		cardLibrary.add(new MoneyCard(1,"1M"));
		cardLibrary.add(new MoneyCard(1,"1M"));
		cardLibrary.add(new MoneyCard(1,"1M"));
		cardLibrary.add(new MoneyCard(1,"1M"));
		cardLibrary.add(new MoneyCard(2,"2M"));
		cardLibrary.add(new MoneyCard(2,"2M"));
		cardLibrary.add(new MoneyCard(2,"2M"));
		cardLibrary.add(new MoneyCard(2,"2M"));
		cardLibrary.add(new MoneyCard(2,"2M"));
		cardLibrary.add(new MoneyCard(3,"3M"));
		cardLibrary.add(new MoneyCard(3,"3M"));
		cardLibrary.add(new MoneyCard(3,"3M"));
		cardLibrary.add(new MoneyCard(4,"4M"));
		cardLibrary.add(new MoneyCard(4,"4M"));
		cardLibrary.add(new MoneyCard(4,"4M"));
		cardLibrary.add(new MoneyCard(5,"5M"));
		cardLibrary.add(new MoneyCard(5,"5M"));
		cardLibrary.add(new MoneyCard(10,"10M"));

		//Properties
		//2 Blue, 2 Brown, 2 Utility, 3 Green, 3 Yellow, 3 Red, 3 Orange, 3 Pink, 3 Light Blue, 4 Railroad



		//Wildcards

		//Action Cards
		//2 Deal Breaker, 3 Just Say No, 3 Sly Deal, 4 Force Deal, 3 Debt
		//Collector, 3 It¡¯s My Birthday, 10 Pass Go, 3 House, 3 Hotel, and 2 Double The Rent Cards
		cardLibrary.add(new DealBreaker());
		cardLibrary.add(new DealBreaker());
		cardLibrary.add(new SayNo());
		cardLibrary.add(new SayNo());
		cardLibrary.add(new SayNo());
		cardLibrary.add(new StealDeal());
		cardLibrary.add(new StealDeal());
		cardLibrary.add(new StealDeal());
		cardLibrary.add(new ForcedDeal());
		cardLibrary.add(new ForcedDeal());
		cardLibrary.add(new ForcedDeal());
		cardLibrary.add(new ForcedDeal());
		cardLibrary.add(new DebtCollector());
		cardLibrary.add(new DebtCollector());
		cardLibrary.add(new DebtCollector());
		cardLibrary.add(new BirthdayCard());
		cardLibrary.add(new BirthdayCard());
		cardLibrary.add(new BirthdayCard());
		cardLibrary.add(new PassGo());
		cardLibrary.add(new PassGo());
		cardLibrary.add(new PassGo());
		cardLibrary.add(new PassGo());
		cardLibrary.add(new PassGo());
		cardLibrary.add(new PassGo());
		cardLibrary.add(new PassGo());
		cardLibrary.add(new PassGo());
		cardLibrary.add(new PassGo());
		cardLibrary.add(new PassGo());
		cardLibrary.add(new BuildHouse());
		cardLibrary.add(new BuildHouse());
		cardLibrary.add(new BuildHouse());
		cardLibrary.add(new BuildHotel());
		cardLibrary.add(new BuildHotel());
		cardLibrary.add(new BuildHotel());
		cardLibrary.add(new DoubleRent());
		cardLibrary.add(new DoubleRent());

		//Rent Cards
		cardLibrary.add(new RentCard(Colour.BLUE,Colour.GREEN));
		cardLibrary.add(new RentCard(Colour.BLUE,Colour.GREEN));

		cardLibrary.add(new RentCard(Colour.RED,Colour.YELLOW));
		cardLibrary.add(new RentCard(Colour.RED,Colour.YELLOW));

		cardLibrary.add(new RentCard(Colour.ORANGE,Colour.PINK));
		cardLibrary.add(new RentCard(Colour.ORANGE,Colour.PINK));

		cardLibrary.add(new RentCard(Colour.LIGHT_BLUE,Colour.BROWN));
		cardLibrary.add(new RentCard(Colour.LIGHT_BLUE,Colour.BROWN));

		cardLibrary.add(new RentCard(Colour.RAILROAD,Colour.UTILITY));
		cardLibrary.add(new RentCard(Colour.RAILROAD,Colour.UTILITY));

		cardLibrary.add(new MulticoloredRentCard());
		cardLibrary.add(new MulticoloredRentCard());
		cardLibrary.add(new MulticoloredRentCard());



		shuffle();

	}

	public void turnRound(){

		int index = playerList.indexOf(firstPlayer);
		while (true){
			Round round = new Round(playerList.get(index%(playerList.size())));
			System.out.println("It is "+playerList.get(index%(playerList.size())).name +" round");
			boolean win = round.inRound();
			if (win){
				break;
			}
			index++;
			//maybe can add a limit to reuse card before it is empty maybe 7 cards
			//need to consider card used and the library
		}



	}



}
