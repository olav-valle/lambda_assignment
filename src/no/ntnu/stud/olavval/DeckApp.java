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
        System.out.print(String.format("Printing all %s cards in hand: ", hand.size()));
        hand.stream()
                .map(Card::getDetails)
                .sorted() //TODO fix sorting by numeric value. x1 x11 x12 x10 x2 etc..
                .forEachOrdered(
                        det -> Stream.concat(Stream.of(det), Stream.of(", "))
                                .forEachOrdered(System.out::print));
        //TODO refactor formatted print to own method
        System.out.println("");

        //1d) filter and print specific suit from hand
        //TODO refactor to separate method and make calls for each suit

        System.out.print("Printing all Spades suit cards: ");
        hand.stream()
                .filter(Card -> (Card.getSuit() == 'S'))
                .map(Card::getDetails)
                .sorted() //TODO fix sorting by numeric value. x1 x11 x12 x10 x2 etc..
                .forEachOrdered(
                        det -> Stream
                                .concat( Stream.of(det), Stream.of(", ") ) //separates cards with ", "
                                .forEachOrdered(System.out::print) );
        System.out.println(""); //line break


        // 1e) filters heart cards from hand into new set
        HashSet<Card> cardsOfHeart = hand.stream()
                .filter(Card -> ( Card.getSuit() == 'H') )
                .collect(Collectors
                        .toCollection(HashSet::new));

        //print heart cards
        System.out.print( String.format( "Printing all %s heart cards: ", cardsOfHeart.size() ) );
        cardsOfHeart.stream()
                .map(Card::getDetails) //map to card details
                .sorted() //TODO fix sorting by numeric value. x1 x11 x12 x10 x2 etc..
                .forEachOrdered(
                        det -> Stream
                                .concat( Stream.of(det), Stream.of(", ") ) //separates cards with ", "
                                .forEachOrdered(System.out::print)
                );
        System.out.println("");

        //1f) stream map cards to stream of suit chars
        System.out.print("Printing only suit value of cards in hand: ");
        hand.stream().map(Card::getSuit).sorted().forEachOrdered(System.out::print);
        System.out.println("");

        //1g) stream reduce card values to sum of values in hand
        System.out.println(
                String.format("The sum of the face values on hand is %s",
                        hand.stream()
                        .map(Card::getFace)
                        .reduce(0, Integer::sum)
                )
        );

    }

}
