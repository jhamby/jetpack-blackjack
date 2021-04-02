# MVP Blackjack Source Code
Simple "minimum viable product" Blackjack game to teach myself the Jetpack Compose framework.
This README provides a roadmap to the source code and the current implementation progress.

## Features

- The complete state of the game is preserved across app restarts, using Room for the data model.
- The launch screen has a brief card-flipping animation and intro text, with menu buttons.
- From the launch screen, the user can see the rules of Blackjack, change settings, or start play.
- The back button in the top app bar works to return to the top-level launch screen.
- Window insets are used to handle IME animations and other graphic effects.
- Unidirectional data flow is used to update the UI and pass state changes.

## Architecture

Unlike traditional Android apps, the entire app runs as a single Activity which changes its
composable hierarchy based on observed state changes.

### Screens

The landing screen shows off the card turn animation with a Jack and an Ace, which then move
up to the top of the screen, with intro text below, and buttons. Timeline:

- 0.0 to 2.0 sec: time to flip each card over.
- 2.0 to 4.0 sec: time to move cards to top of screen.
- 3.0 to 4.0 sec: fade in the screens and buttons.

The settings and game rules screens don't have any special features. The in-game screen has
the most complexity, and I'll talk about it in a future commit.

### Data Model

Game settings and game state are stored in Room as follows:

* `Settings` table has key-value pairs, including `screen` for the currently active screen.
* `Hands` table has a column for the player number, or "D" for dealer, with one or more cards.
  When a player splits hands, the split hands will be named "1S1" and "1S2" (for player 1).
* `Deck` table holds the shuffled undealt cards.
* `Discard` table holds the discard pile, to make reshuffling in the middle of a hand easier.

### Game Logic

Allowed values for the `screen` setting are 0 for the landing screen, 1 for settings, 2 for rules,
and 3 for the game screen. When the game is being played, `game_state` will be 0 for bet input,
1 after the initial hand is dealt, 2 after asking for insurance, 3 if all hands have been played,
and 4 or higher to indicate the player hand being played (including split hands, as well as
multiple players when I add that feature). The difference between state 0 and state 3 is that
state 3 will show the most-recently-played hand as well as the wins/losses.

The rules of the game will be implemented as async handlers for flows of data from Room and
user events. My goal in writing this code is to correctly handle the OS killing the process and
restarting it at any time, while minimizing database reads for cached values.

## Project Goals

* Use Kotlin and the latest Android Jetpack APIs.
* Use a custom font and color scheme.
* Use Hilt to write unit tests and functional tests.
* Support accessibility (e.g. large fonts, screen readers).
* Multiple languages (English, Spanish, French to start).
* Preserves settings and current game state across app restarts.
* No obvious resource leaks or bugs.

## Resources used

* [Jetpack Compose samples](https://github.com/android/compose-samples)
* [Accompanist Utils](https://google.github.io/accompanist/)
