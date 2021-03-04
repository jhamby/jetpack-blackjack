package com.jakehamby.games

import kotlin.random.Random

/**
 * Class to manage decks of playing cards.
 */
class CardDeck(numDecks: Int) {
    private val decks = MutableList(52 * numDecks) {
        val rank = PlayingCard.Rank.values()[it % 13]
        val suit = PlayingCard.Suit.values()[(it / 13) % 4]
        PlayingCard(rank, suit)
    }

    private val discardPile = mutableListOf<PlayingCard>()

    /**
     * Add the cards in the discard pile to the cards in the deck, then
     * swap each position in the deck(s) with a random card.
     */
    fun shuffle() {
        decks.addAll(discardPile)
        discardPile.clear()

        for (i in 0 until decks.size) {
            val swapCard = Random.nextInt(decks.size)
            if (i != swapCard) {
                val tmp = decks[i]
                decks[i] = decks[swapCard]
                decks[swapCard] = tmp
            }
        }
    }

    /**
     * Deal a single card from the deck.
     */
    fun dealOne() : PlayingCard {
        return decks.removeFirst()
    }

    /**
     * Deal multiple cards from the deck.
     */
    fun dealMultiple(count: Int) : List<PlayingCard> {
        val cards = mutableListOf<PlayingCard>()
        for (i in 0 until count) {
            cards.add(dealOne())
        }
        return cards
    }

    /**
     * Return one or more cards to the deck.
     * This isn't necessary in the current implementation.
     */
    fun discard(card : PlayingCard) {
        discardPile.add(card)
    }

    /**
     * Return one or more cards to the deck.
     * This isn't necessary in the current implementation.
     */
    fun discard(cards: Collection<PlayingCard>) {
        discardPile.addAll(cards)
    }

    /**
     * Return the number of cards remaining in the deck.
     */
    val remaining get() = decks.size
}