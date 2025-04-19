# 🃏 War Card Game in Java

A terminal-based implementation of the classic "War" card game using Java. This project serves as a practical exercise in Object-Oriented Programming (OOP), utilizing classes such as `Card`, `Deck`, `Player`, and `Game` to simulate gameplay.

## 🎮 Game Overview

"War" is a simple two-player card game played with a standard 52-card deck. The deck is evenly divided between the two players. In each round:

- Both players reveal the top card of their decks.
- The player with the higher card wins the round and collects both cards, placing them at the bottom of their deck.
- In the event of a tie, a "war" is triggered:
  - Each player places three cards face down and then one card face up.
  - The player with the higher face-up card wins all the cards on the table.
  - If the face-up cards are equal again, the war continues recursively.
- The game continues until one player has all the cards and is declared the winner.

## 🧰 Technologies Used

- Java (Standard Edition)
- Object-Oriented Programming principles
- Collections Framework (e.g., `ArrayList`, `LinkedList`)
- Command-line interface for user interaction

## 🚀 Getting Started

### Prerequisites

- Java Development Kit (JDK) installed on your machine.

### Installation

1. Clone the repository:

```bash
git clone https://github.com/Joao-Severgnini/WarCardGameJava.git
```

2. Navigate to the project directory:

```bash
cd WarCardGameJava
```

3. Compile the Java files:

```bash
javac *.java
```

4. Run the application:

```bash
java Main
```

## 🗂️ Project Structure

```
├── Card.java           # Represents a playing card with suit and rank
├── Deck.java           # Manages a collection of cards and shuffling
├── Player.java         # Represents a player with their own deck
├── Game.java           # Controls the game flow and rules
├── Main.java           # Entry point of the application
└── README.md           # Project documentation
```

## ✅ Features

- Full implementation of the War card game rules
- Handles recursive wars in the event of consecutive ties
- Displays round-by-round updates in the terminal
- Determines and announces the winner at the end of the game

## 📝 Notes

- This implementation is for educational purposes and runs entirely in the terminal.
- No external libraries are required; the project uses only standard Java libraries.

## 👤 Author

Developed by João Severgnini.
