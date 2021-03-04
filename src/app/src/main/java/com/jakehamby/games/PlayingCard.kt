package com.jakehamby.games

/**
 * Represents a standard (French-suited) playing card.
 */
data class PlayingCard(val rank: Rank, val suit: Suit) {
    enum class Rank(val rankName: String, val rankSymbol: String) {
        ACE("Ace", "A"),
        TWO("2", "2"),
        THREE("3", "3"),
        FOUR("4", "4"),
        FIVE("5", "5"),
        SIX("6", "6"),
        SEVEN("7", "7"),
        EIGHT("8", "8"),
        NINE("9", "9"),
        TEN("10", "10"),
        JACK("Jack", "J"),
        QUEEN("Queen", "Q"),
        KING("King", "K")
    }

    enum class Suit(val suitName: String, val suitSymbol: String) {
        CLUBS("Clubs", "♣"),
        DIAMONDS("Diamonds", "♦"),
        HEARTS("Hearts", "♥"),
        SPADES("Spades", "♠")
    }

    val blackjackValue: Int
        get() = if (rank.ordinal > 9)
            10
        else
            rank.ordinal + 1
}