package card;


public abstract class Card{

    //basic attribution
    public int value ;
    public String name;
    public CardKind cardKind;

    public Card(int value, String name, CardKind cardkind){
        this.value=value;
        this.name=name;
        this.cardKind=cardkind;

    }

    public void use() {}


    public String toString(){

        return name + " Value: " + value;
    }
}
