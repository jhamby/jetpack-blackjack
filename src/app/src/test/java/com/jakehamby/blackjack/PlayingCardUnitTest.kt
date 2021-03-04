package com.jakehamby.blackjack

import com.jakehamby.games.PlayingCard
import org.junit.Test

import org.junit.Assert.*

/**
 * Verify the playing card type.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class PlayingCardUnitTest {
    @Test
    fun card_enum_types() {
        val aceHearts = PlayingCard(PlayingCard.Rank.ACE, PlayingCard.Suit.HEARTS)
        val sixClubs = PlayingCard(PlayingCard.Rank.SIX, PlayingCard.Suit.CLUBS)
        val queenDiamonds = PlayingCard(PlayingCard.Rank.QUEEN, PlayingCard.Suit.DIAMONDS)
        val kingSpades = PlayingCard(PlayingCard.Rank.KING, PlayingCard.Suit.SPADES)

        assertEquals(PlayingCard.Suit.HEARTS, aceHearts.suit)
        assertEquals(PlayingCard.Suit.CLUBS, sixClubs.suit)
        assertEquals(PlayingCard.Suit.DIAMONDS, queenDiamonds.suit)
        assertEquals(PlayingCard.Suit.SPADES, kingSpades.suit)

        assertEquals(PlayingCard.Rank.ACE, aceHearts.rank)
        assertEquals(PlayingCard.Rank.SIX, sixClubs.rank)
        assertEquals(PlayingCard.Rank.QUEEN, queenDiamonds.rank)
        assertEquals(PlayingCard.Rank.KING, kingSpades.rank)

        assertEquals("Ace",     aceHearts.rank.rankName)
        assertEquals("6",       sixClubs.rank.rankName)
        assertEquals("Queen",   queenDiamonds.rank.rankName)
        assertEquals("King",    kingSpades.rank.rankName)

        assertEquals("A", aceHearts.rank.rankSymbol)
        assertEquals("6", sixClubs.rank.rankSymbol)
        assertEquals("Q", queenDiamonds.rank.rankSymbol)
        assertEquals("K", kingSpades.rank.rankSymbol)

        assertEquals(1, aceHearts.blackjackValue)
        assertEquals(6, sixClubs.blackjackValue)
        assertEquals(10, queenDiamonds.blackjackValue)
        assertEquals(10, kingSpades.blackjackValue)

        assertEquals("Hearts",      aceHearts.suit.suitName)
        assertEquals("Clubs",       sixClubs.suit.suitName)
        assertEquals("Diamonds",    queenDiamonds.suit.suitName)
        assertEquals("Spades",      kingSpades.suit.suitName)

        assertEquals("♥", aceHearts.suit.suitSymbol)
        assertEquals("♣", sixClubs.suit.suitSymbol)
        assertEquals("♦", queenDiamonds.suit.suitSymbol)
        assertEquals("♠", kingSpades.suit.suitSymbol)
    }
}