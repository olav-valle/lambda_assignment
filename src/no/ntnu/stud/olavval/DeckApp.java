package no.ntnu.stud.olavval;

import java.util.HashSet;

/**
 * The main method of the DeckApp program.
 * Draws 10 cards at random from a deck of 52 cards, and prints their value.
 * @author olavval
 * @version 2020.01.14
 */

public class DeckApp {

    private static Deck deck;

    public static void main(String[] args) {
        deck = new Deck();

        (deck.assign(10)).stream().map(Card::getDetails).forEach(System.out::println);

    }
}
