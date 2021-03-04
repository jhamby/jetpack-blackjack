package com.jakehamby.blackjack

import com.jakehamby.games.CardDeck
import com.jakehamby.games.PlayingCard
import org.junit.Test

import org.junit.Assert.*

/**
 * Verify the deck.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class CardDeckUnitTest {
    @Test
    fun one_deck_test() {
        val oneDeck = CardDeck(1)
        assertEquals(52, oneDeck.remaining)
        for (suit in PlayingCard.Suit.values()) {
            for (rank in PlayingCard.Rank.values()) {
                val card = oneDeck.dealOne()
                assertEquals(suit, card.suit)
                assertEquals(rank, card.rank)
                oneDeck.discard(card)
            }
        }
        assertEquals(0, oneDeck.remaining)
        oneDeck.shuffle()
        assertEquals(52, oneDeck.remaining)

        var allOrdered = true

        // make sure the cards have been shuffled a little bit
        for (suit in PlayingCard.Suit.values()) {
            for (rank in PlayingCard.Rank.values()) {
                val card = oneDeck.dealOne()
                if (suit != card.suit) allOrdered = false
                if (rank != card.rank) allOrdered = false
                oneDeck.discard(card)
            }
        }

        assertFalse(allOrdered)
    }

    @Test
    fun four_deck_test() {
        val oneDeck = CardDeck(4)
        assertEquals(52 * 4, oneDeck.remaining)
        for (deck in 0..3) {
            for (suit in PlayingCard.Suit.values()) {
                for (rank in PlayingCard.Rank.values()) {
                    val card = oneDeck.dealOne()
                    assertEquals(suit, card.suit)
                    assertEquals(rank, card.rank)
                    oneDeck.discard(card)
                }
            }
        }
        assertEquals(0, oneDeck.remaining)
        oneDeck.shuffle()
        assertEquals(52 * 4, oneDeck.remaining)

        var allOrdered = true

        // make sure the cards have been shuffled a little bit
        for (deck in 0..3) {
            for (suit in PlayingCard.Suit.values()) {
                for (rank in PlayingCard.Rank.values()) {
                    val card = oneDeck.dealOne()
                    if (suit != card.suit) allOrdered = false
                    if (rank != card.rank) allOrdered = false
                    oneDeck.discard(card)
                }
            }
        }

        assertFalse(allOrdered)
    }
}