package no.ntnu.stud.olavval;

import java.util.HashSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * The main method of the DeckApp program.
 * Draws 10 cards at random from a deck of 52 cards, and prints their value.
 * @author olavval
 * @version 2020.01.14
 */

public class DeckApp {

    private static Deck deck;
    private static HashSet<Card> hand;

    /**
     * Main method of DeckApp program. Draws 10 cards from the deck,
     * and prints various information about the hand that was drawn.
     * @param args No function.
     */
    // 1c)
    public static void main(String[] args) {
        deck = new Deck();

        //1c)
        hand = deck.assign(10);

        // prints all cards in hand

        hand.stream()
                .map(Card::getDetails)
                .sorted() //TODO fix sorting by numeric value. x1 x11 x12 x10 x2 etc..
                .forEachOrdered(System.out::print); //TODO format output with whitespace

        System.out.println(String.format("Printing all %s cards in hand:", hand.size()));
        hand.stream()
                .map(Card::getDetails)
                .sorted() //TODO fix sorting by numeric value. x1 x11 x12 x10 x2 etc..
                .forEachOrdered(
                        det -> Stream.concat(Stream.of(det), Stream.of(", "))
                                .forEachOrdered(System.out::print));
        System.out.println("");
        //1d) filter and print specific suit from hand

        System.out.println("Printing Clubs suit cards: ");
        hand.stream().filter(Card -> (Card.getSuit() == 'C'))
                .map(Card::getDetails)
                .forEach(System.out::println);


        // 1e) filters heart cards from hand into new set
        HashSet<Card> cardsOfHeart = hand.stream().filter(Card -> (Card.getSuit() == 'H'))
                .collect(Collectors.toCollection(HashSet::new));

        //print heart cards
        System.out.println( String.format( "Printing all %s heart cards:", cardsOfHeart.size() ) );
        cardsOfHeart.stream()
                .map(Card::getDetails) //map to card details
                .forEach(System.out::println);




    }
}
