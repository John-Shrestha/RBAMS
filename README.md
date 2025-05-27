# Rural Bank Account Management System (RBAMS)

A console-based Java application designed to support financial inclusion in remote areas of Nepal.

## Features
- Manage Saving Accounts and Current Accounts
- Adheres to banking rules (withdrawal limits, overdraft facilities, interest application)
- Custom exception handling
- Secure transaction management

## System Design & OOP Implementation

| Class Name                     | Type             | Key Features                                                                 |
|--------------------------------|------------------|------------------------------------------------------------------------------|
| Bank Account                   | Abstract         | Base class with accountHolderName, accountNumber, balance                   |
| Savings Account                | Child Class      | Adds interest, applies interest periodically                                |
| Current Account                | Child Class      | Supports overdraft limit                                                    |
| Customer                       | Aggregation      | Holds multiple bank account objects                                         |
| Insufficient Balance Exception | Custom Exception | Thrown when withdrawal exceeds balance (or balance + overdraft for current) |

## Functionality & Operations

| Operation      | Description                                                                 |
|----------------|----------------------------------------------------------------------------|
| Deposit        | Adds funds to any account                                                  |
| Withdraw       | Checks balance/overdraft before allowing withdrawal                        |
| Add Interest   | Applies interest to saving account                                         |
| View Account   | Display all accounts of a customer                                         |
| Exit           | Terminates the program                                                     |

## Exception Handling
- **Custom Exception**: InsufficientBalanceException
  - Thrown when:
    - Saving account withdrawal exceeds balance
    - Current account withdrawal exceeds balance + overdraft limit

## Screenshots

### Deposit Operation

### Deposit Operation

<table>
  <tr>
    <td><img src="https://github.com/John-Shrestha/RBAMS/blob/b5b46a1c7e323643666992683236dd4e7aadd319/Screenshot%202025-05-27%20153055.png" alt="" width="400"></td>
    <td><img src="https://github.com/John-Shrestha/RBAMS/blob/68b42fcf47eaa9dc591febb709f1f4a48b0c641f/Screenshot%202025-05-27%20153137.png" alt="" width="400"></td>
     <td><img src="https://github.com/John-Shrestha/RBAMS/blob/59a11465197c32e591ce10be16076a5b64ac05f4/Screenshot%202025-05-27%20153158.png" alt="" width="400"></td>
  </tr>
</table>

### Withdrawal with Exception

<table>
  <tr>
    <td><img src="https://github.com/John-Shrestha/RBAMS/blob/dec4217452e62635679702a2f7d9dbfd891ef47e/Screenshot%202025-05-27%20153243.png" alt="" width="400"></td>
    <td><img src="https://github.com/John-Shrestha/RBAMS/blob/09bd766c44cb9aa55f1eeffe0d9e8055b66161c7/Screenshot%202025-05-27%20153311.png" alt="" width="400"></td>
  </tr>
</table>


### Interest Addition
![Interest Addition](screenshots/interest_addition.png)

## Getting Started

1. Clone the repository:
   ```bash
   git clone https://github.com/John-Shrestha/RBAMS.git
