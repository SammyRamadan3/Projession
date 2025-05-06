const choices = ["rock", "paper", "scissors"];
const buttons = document.querySelectorAll("button");
const result = document.querySelector("#result");
const userScore = document.querySelector("#userScore");
const computerScore = document.querySelector("#computerScore");

let userChoice;
let computerChoice;
let score = { user: 0, computer: 0 };

// Function to get a random choice for the computer
function getComputerChoice() {
  const randomIndex = Math.floor(Math.random() * choices.length);
  return choices[randomIndex];
}

// Function to determine the winner
function determineWinner() {
  if (userChoice === computerChoice) {
    result.textContent = "It's a tie!";
  } else if (
    (userChoice === "rock" && computerChoice === "scissors") ||
    (userChoice === "paper" && computerChoice === "rock") ||
    (userChoice === "scissors" && computerChoice === "paper")
  ) {
    result.textContent = "You win!";
    score.user++;
    userScore.textContent = score.user;
  } else {
    result.textContent = "Computer wins!";
    score.computer++;
    computerScore.textContent = score.computer;
  }
}

// Event listener for button clicks
buttons.forEach((button) => {
  button.addEventListener("click", () => {
    userChoice = button.id;
    computerChoice = getComputerChoice();
    determineWinner();
  });
});