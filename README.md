# Voting System

This project implements a simple voting system with voter registration, voting, and receipt generation functionalities.

## Features

- **Voter Registration:** Allows users to register with their personal details including voter ID, name, age, address, father's name, and password.
- **Voting:** Voters can cast their votes for different political parties. The parties available are BJP, Congress, AAP, Shiv Sena, TMC, and an option for "None".
- **Receipt Generation:** Generates a receipt after voting displaying voter details, the party voted for, candidate's name, and address.

## Technologies Used

- **Java:** Core language used for the application.
- **Swing:** Used for GUI development.
- **MySQL:** Database management system for storing voter details and voting information.
- **JDBC:** Java Database Connectivity for connecting Java application with MySQL database.

## Screenshots

![Screenshot 2024-06-26 170434](https://github.com/Sun-shINe-arch/Voting-System/assets/40921219/9d035733-955a-439c-8c3f-d07453471220)
![Screenshot 2024-06-26 170505](https://github.com/Sun-shINe-arch/Voting-System/assets/40921219/1c20b904-e941-4771-8c7e-f55a88bcf781)


## Installation

1. **Clone the repository:**
   ```bash
   git clone https://github.com/Sun-shINe-arch/voting-system.git
2. **Set up MySQL Database:**
   Create a MySQL database named ARPIT.
   Update url, username, and password in the Java files (Data_Entry.java, Voting.java, Voting_receipt.java) to match your MySQL database credentials.
3. **Usage:**
   1.Voter ID Creation:
     Click on "Voter ID Creation" button to register as a voter.
     Enter personal details and click "Submit".
   2.Vote:
     Click on "Vote" button to cast your vote.
         Enter voter ID and password, then select a political party and confirm your vote.
   3.Voting Receipt:
     Click on "Voting Receipt" button to view the voting receipt.
     Enter voter ID and password to view your vote details.
## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

## Contact

For questions or suggestions, contact me at [mk7581505@gmail.com].
