<h2 align="center">Pokemon Card Collection Inventory</h2>
<p>
<img src="https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white"/>
  <img src="https://img.shields.io/badge/MySQL-4479A1?style=for-the-badge&logo=mysql&logoColor=white"/>
  <img src="https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=apachemaven&logoColor=white"/>
</p>

<p>
  A simple UI <b>Pokemon Card Inventory System</b> built with Java, JDBC, and MySQL. I built it to keep track of my Pokemon cards, their prices, and filter by details like, rarity, type, or element. It is an extremely simple UI program that I may later build a front-end to it as another project.
</p>

---

## Features
- **View All Cards** - display the full card list with details
- **Add a Card** - insert new cards into the collection's list
- **Update a Card** - change/edit existing cards and anything in their details
- **Delete a Card** - remove cards by index number from the list
- **Search Card by Name** - quicly search through the list to find a specific card and its details
- **Card count Displayed** - count the cards and show total

  ---

## Tech Stack
- Java (OOP, JDBC)
- MySQL (relational database)
- Maven (project management & depdencies)

---

## Screenshots of UI and MySQL table

<details>
  <summary>Main Menu</summary>
  <img src="images/mainMenu.png" alt="Main Menu" width="600"/>
</details>

<details>
  <summary>Adding a Card</summary>
  <img src="images/addingCard.png" alt="Adding a Card" width="600"/>
</details>

<details>
  <summary>Display/View All Cards</summary>
  <img src="images/viewAll.png" alt="Display all Cards" width="600"/>
</details>

<details>
  <summary>MySQL Table</summary>
  <img src="images/MySQL.png" alt="MySQL Table" width="600"/>
</details>

---

<h3>Author: <p>Bruce Brown</p></h3>

---

## Installation

1. Clone the repository
git clone https://github.com/BizzyProgramming/PokemonCardJDBC.git

2. Open the project in your IDE

3. Make sure you have MySQL installed and running. Create a database named pokemoncards.

4. Update the dataBase class with your MySQL credentials if needed

5. Built the project using Maven to resolve dependencies:

gitbash
mvn clean install

---

Usage

- Run start class
- Use the console menu to view, add, update, delete, or search cards.
- The system tracks all the cards in the inventory and displays them automatically after viewing all cards.
