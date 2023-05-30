public class DeckOfCards {
    private enum Rank {
        ACE,TWO,THREE,FOUR,FIVE,SIX,SEVEN,EIGHT,NINE,TEN,JACK,QUEEN,KING
    }
    private enum Suit {
        DIAMOND,CLUB,HEART,SPADE
    }

    private class Card {
        Rank rank;
        Suit suit;

        public Card(Rank rank,Suit suit) {
            this.rank = rank;
            this.suit = suit;
        }
    }

    private Card[] cards;
    private static final int DECK_SIZE = 52;
    public DeckOfCards() {
        this.cards  = new Card[DeckOfCards.DECK_SIZE];
        int i = 0;
        for (Rank r: Rank.values()) {
            for (Suit s : Suit.values()) {
                this.cards[i] = new Card(r,s);
                i++;
            }
        }
    }


    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("########################################## DECK OF CARDS ##########################################\n");
        for (int i = 0 ; i < DeckOfCards.DECK_SIZE; i++) {
            sb.append(String.format("%s %s\n",this.cards[i].rank,this.cards[i].suit));
        }
        sb.append("########################################## DECK OF CARDS ##########################################\n");
        return sb.toString();
    }
}
