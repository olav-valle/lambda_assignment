package no.ntnu.stud.olavval;

import org.w3c.dom.ls.LSOutput;

import java.security.SecureRandom;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;

/**
 * Represents a deck of 52 playing cards. A deck contains 4 groups of cards, called suits,
 * which each have 13 unique cards. The suits are called "Spades", "Hearts", "Diamonds" and "Clubs".
 * The 13 cards in each suit have values from 1 to 13. Four of these values are referred to as "face cards",
 * and their values are symbolised by characters instead of numbers. These four cards are the "Ace" = 1,
 * the "Jack" = 11, the "Queen" = 12 and the "King" = 13.
 *
 * @author olavval
 * @version 2020.01.14
 */
public class Deck {

    private final char[] suit = {'S', 'H', 'D', 'C'};

    private HashMap<String, Card> deck;
    /*  Cards in deck mapped with a combination of suit ('S', 'H', 'D', 'C')
        and value ('A', '2', ..., 'J', 'Q', 'K') as key
        */

    /**
     * Deck constructor. Generates a full 52 card deck.
     */
    public Deck()
    {
        deck = new HashMap<>();

        int face = 1;
        int king = 13;
        // 1 (ace) and king (13) are the min and max face values a card can have.

        int suitValue = 0;

        while(suitValue <= 3) {

            while(face <= king){
                deck.put( ("" + suit[suitValue] + face), new Card(suit[suitValue], face));
                face++;
            }
            face = 1;
            suitValue++;
        }

        //deck.values().stream().map(Card::getDetails).sorted().forEachOrdered(System.out::println);

    }// constructor

    /**
     * Draws a number of cards from the deck, and returns them as a set. The number is specified by parameter <code>draw</code>.
     * @param draw the number of cards to draw.
     */
    public HashSet<Card> assign(int draw)
    {
        Random rand = new SecureRandom();

        HashSet<Card> cardSet = new HashSet<>();

        HashSet<Integer> intSet = new HashSet<>();

        //TODO implement the RNG so numbers are collected in a set, which checks that all numbers are unique
        // and continues generating numbers until the set has the required number of ints in it.
        // while(intSet.size() < draw){intSet.add(rand.nextInt)}, or something similar.

        while(intSet.size() < draw){
            intSet.add(rand.nextInt(52));
        }

        intSet.forEach(i -> cardSet.add( (Card) ( this.deck.values().toArray() )[i] ) );

        return cardSet;
    }
}
