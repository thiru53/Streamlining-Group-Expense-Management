# Streamlining-Group-Expense-Management
The Group Expense Management and Financial Balance Enhancement Project is designed to streamline the process of overseeing shared expenditures. The purpose of this project is to evaluate your programming and logical skills. Each task comes with a predefined description and examples to assist you.

## Task 1: Efficient Expense Group Management-Squad Expenses Starter		
Perform the following tasks before API development:

Download the MySQL database by clicking on the provided link. ExpenseSharing.sql
Access your database information by clicking on the "Database Info" tab.
Set up the downloaded database in the provided database environment and code.
This API endpoint serves as the launching pad for a new expense sharing squad. It facilitates the creation of a shared expense group by processing a POST request to the "/expense/group" endpoint. The request should include a JSON payload containing fundamental information such as the group's title, a brief yet enticing description, the applicable category, and the names of participants ready to embark on this financial journey together.

POST "/expense/group"

Request Body: 

    {   
        "title": "Roommates",   
        "description": "Expense sharing among roommates",   
        "category": "Housing",   
        "participants": ["Abhilasha", "Nikki", "Purnima"] 
    }

The entered data in '/expense/group'will undergo thorough validation to ensure accuracy and completeness. Special attention will be given to the:

1)"Title of the group should not be null or blank."-The title of the input should not be null or blank 2)"Participants list should contain more than 1 non-blank participant."-To check that the participants list should be List and not string and also it should not be null, empty or have only one participnat name.

Upon successful addition, the group details are saved in the "expense_sharing" table, with participants stored in the "expense_sharing_participants" table.

The response  returned in JSON format is :

    {     
        "id": 1,     
        "title": "Roommates",     
        "description": "Expense sharing among roommates",     
        "category": "Housing",     
        "participants": [         
            "Abhilasha",         
            "Nikki",         
            "Purnima"     
        ] 
    }

Implementing this endpoint imparts practical knowledge in API development. You will learn to handle and validate incoming JSON data, integrate with databases for seamless storage of group details, and generate response data that confirms successful group creation while providing a unique group ID. This experience sets the groundwork for building user-friendly APIs and enhancing data management skills.

## Task 2: Group Details Retrieval-Explore Shared Financial Ventures

This endpoint opens the door to a treasury of shared financial ventures. It facilitates the retrieval of all existing expense sharing groups through a GET request to the "/expense/groups" endpoint. Upon retrieval, the response provides a list of group details, including each group's unique identifier, title, description, category, and the list of participants involved in each group's financial endeavors.

If no groups are found, an appropriate message is displayed.

GET /expense/groups

The response provides a list of group details:

    [       
        {         
            "id": 1,         
            "title": "Roommates",         
            "description": "Expense sharing among roommates",         
            "category": "Housing",         
            "participants": [             
                "Abhilasha",             
                "Nikki",             
                "Purnima"         
            ]     
        } 
    ]

Building upon the earlier implementation of creating expense sharing groups, you will grasp the full spectrum of API development by creating this retrieval endpoint. By implementing this, you will learn how to create a comprehensive API that not only adds data but also retrieves it. You'll understand the dynamics of handling GET requests, retrieving data from a database, and structuring the response in a user-friendly format. Connecting this endpoint to the previous one, you will create a seamless flow of creating and exploring shared financial ventures.


## Task 3: Dive into Group Detail using Group ID

This endpoint offers a deep dive into the details of an individual expense sharing group. By processing a GET request to the "/expense/groupById/{id}" URL, users can retrieve the specifics of a group based on its unique ID. If the requested group ID is not found, the API responds with an appropriate error message.

GET /expense/groupById/1

The success response includes the group's ID, title, description, category, and participants:

    {     
        "id": 1,     
        "title": "Roommates",     
        "description": "Expense sharing among roommates",     
        "category": "Housing",     
        "participants": [         
            "Abhilasha",         
            "Nikki",         
            "Purnima"     
        ] 
    }

The failure response when requested group ID is not found:

    {     
        "message": "Expense sharing group with id {id} not found",     
        "success": false 
    }

This endpoint extends the functionality established by the previous two endpoints. Developers will learn how to fetch and present specific data based on user input. This involves handling dynamic parameters in the URL and querying the database for specific records. This practical implementation connects the dots from creating and listing groups to providing detailed insights into individual groups, forming a seamless and user-friendly experience.



## Task 4: Update Expense Sharing Group Details by Group ID
This task revolves around modifying the details of an existing expense sharing group. This task will implement a POST endpoint, "/expense/group/update/{id}", where users can provide updated group information in a JSON object. If the group ID is not found, an appropriate error message is displayed. Upon successful update, the API returns the modified group details, including ID, title, description, category, and the revised list of participants.

Example Input:

POST /expense/group/update/1

Request Body:

    {
        "title": "Group Partners",
        "description": "Shared expenses among close friends",
        "category": "Social",
        "participants": ["Abhilasha", "Nikki", "Purnima", "Riya"]
    }

The entered data in '/expense/group/update/1' will undergo thorough validation to ensure accuracy and completeness. Special attention will be given to the:



1)"Expense sharing group with id {id} not found"-If expense sharing group with {id} is not found.

2)"Title of the group should not be null or blank."-The title of the input should not be null or blank

3)"Participants list should contain more than 1 non-blank participant."-To check that the participants list should be List and not string and also it should not be null, empty or have only one participnat name.

4)"Expense Sharing details are the same. No updation required."-If the input is same as the existing one.

Upon successful updation, the group details are updated in the "expense_sharing" table, with participants updated and stored in the "expense_sharing_participants" table.

The success response  returned in JSON format is :

    {
        "id": 1,
        "title": "Group Partners",
        "description": "Shared expenses among close friends",
        "category": "Social",
        "participants": [
            "Abhilasha",
            "Nikki",
            "Purnima",
            "Riya"
        ]
    }

By completing this task, you will gain practical experience in implementing API endpoints for updating data. The task involves handling dynamic parameters in the URL, processing and validating JSON data, and updating database records. This valuable skill set can be applied to build robust APIs that offer the ability to modify and manage data effectively.

## Task 5: Delete Expense Sharing Group by ID
This task focuses on implementing the deletion of an expense sharing group by its ID. A POST endpoint, "/expense/group/delete/{id}", enables users to delete a group. When a group is deleted, all related expenses and transaction entries are also removed. If the group ID is not found, the API responds with an appropriate error message. The response of successful deletion includes a JSON format response indicating the success of the operation.

Example (Successful Deletion):

POST /expense/group/delete/1

Response Body:

    {
        "success":true
    }

Example Response (when group ID is not found):

POST /expense/group/delete/2

    {
        "message": "Expense Sharing group with ID 2 not found",
        "success": false
    }

Completing this task equips you with the expertise to design APIs for removing data from a system. It involves handling dynamic parameters in the URL, managing associated data removal in the database, and generating meaningful responses to communicate the outcome of the operation. This proficiency in managing data deletion will be valuable when building APIs for various systems.

## Task 6: Expense Management-Add Expense to Group	
This task focuses on enhancing the expense management capabilities of the system by allowing users to add expenses to an expense sharing group. The task involves implementing a POST endpoint, "/expense/group/{groupId}/addExpense", which facilitates the addition of expenses.

The input JSON object includes details such as the expense title, amount, payer, beneficiaries, and payment date.

Example Input:

    {   
        "title": "RoomRent",   
        "amount": 7000.0,   
        "paidBy": "Abhilasha",   
        "forWhom": ["Purnima", "Nikki", "Abhilasha","Riya"],   
        "paymentDate": "2023-08-09" 
    }

The entered data in '/expense/group/{groupId}/addExpense' will undergo thorough validation to ensure accuracy and completeness. Special attention will be given to the:

1)"Expense Sharing group with id " + groupId + " not found"- If the group is not found in the expense_sharing table. 2)"Title of the group should not be null or blank."- The title of the input should not be null or blank 3)"Participants list should contain more than 1 non-blank participant."-The "forWhom" list should be List and not String, and the "forWhom" list should not be empty ,null or should not have only one name in "forWhom" list. 4)"Paid By name should be there" 5)"Paid by participant '" + paidBy + "' is not found in the participants list"-If the paid by name is not there in the participants list of the group Id 6)"Participant '" + participant + "' is not found in the participants list"-If any name in the "forWhom" list is not there in the participants list of the group Id

Upon successfull validation the expense related to the group is stored in the "expenses" table and"expense_for_whom" table which stores the corresponsing expense id and for whom participants.

The successful response includes the updated list of expenses associated with the group:

    {     
        "id": 1,     
        "title": "RoomRent",     
        "groupId": 1,     
        "amount": 7000.0,     
        "paidBy": "Abhilasha",     
        "forWhom": [         
            "Purnima",         
            "Nikki",         
            "Abhilasha",         
            "Riya"     
        ],     
        "paymentDate": "2023-08-09" 
    }

This task extends the expense tracking functionality by implementing calculations and updates for individual contributions. Upon successful expense addition, the system clears any existing transaction entries associated with the expense ID. It then recalculates individual contributions based on the updated expense information and stores the calculated contributions in the "expense_transactions" table. The corresponding transaction entries are recorded in the "transaction_entries" table.

Completing this task will empower developers to create a vital feature for expense sharing. You will learn to handle complex data inputs, validate participants, and maintain accurate expense records. This experience will contribute to your skills in handling data storage, validation, and user interaction within a financial system. You will also learn how to orchestrate the recalculation of contributions, ensuring data consistency and accuracy. This experience will contribute to their skills in managing financial data and performing complex calculations in an automated manner.

## Task 7: View All Expenses
This task focuses on providing users with a comprehensive overview of all expenses within the system. Developers will implement a GET endpoint, "/expense", which displays a list of all expenses present. If no expenses are found, the API responds with an appropriate message.

Example Response (When Expenses Exist):

    [     
        {         
            "id": 1,         
            "title": "RoomRent",         
            "groupId": 1,         
            "amount": 7000.00,         
            "paidBy": "Abhilasha",         
            "forWhom": [             
                "Purnima",             
                "Nikki",             
                "Abhilasha",             
                "Riya"         
            ],         
            "paymentDate": "2023-08-09"     
        } 
    ]

Example Response (When No Expenses Exist):

    {     
        "message": "No expenses found.",     
        "success": false 
    }

By completing this task, you will learn to build endpoints for displaying aggregated data. You will acquire skills in fetching and presenting large datasets, and structuring responses in a user-friendly format. This experience will be valuable when designing APIs for displaying data across different scenarios.

## Task 8: View Expense by ID

This task facilitates the targeted exploration of individual expenses by their unique ID. Developers will implement a GET endpoint, "/expense/{expenseId}", which allows users to view a specific expense's details based on its ID. If no expense is found with the provided ID, the API responds with an appropriate error message.

Example Response (When Expense ID Exists):

    {     
        "id": 1,     
        "title": "RoomRent",     
        "groupId": 1,     
        "amount": 7000.00,     
        "paidBy": "Abhilasha",     
        "forWhom": [         
            "Purnima",         
            "Nikki",         
            "Abhilasha",         
            "Riya"     
        ],     
        "paymentDate": "2023-07-14" 
    }

Example Response (When Expense ID Does Not Exist):

    {     
        "message": "Expense not found with ID: {expenseId}",     
        "success": false 
    }

By completing this task, you will gain practical experience in building APIs for retrieving specific data entries. You will enhance their skills in handling dynamic parameters in URLs, querying databases based on user input, and generating well-structured responses. This experience will be valuable when designing APIs for exploring specific data entries within a system.

## Task 9: View Group Expenses
This task emphasizes providing users with a consolidated view of expenses associated with a specific group. Developers will implement a GET endpoint, "/expense/group/{groupId}", designed to retrieve all expenses linked to a particular group. If no expenses are found for the group or if the group itself is not found, the API responds with appropriate error messages.

Example Response (When Group Expenses Exist):

    [     
        {         
            "id": 1,         
            "title": "RoomRent",         
            "groupId": 1,         
            "amount": 7000.00,         
            "paidBy": "Abhilasha",         
            "forWhom": [             
                "Purnima",             
                "Nikki",             
                "Abhilasha",             
                "Riya"         
            ],         
            "paymentDate": "2023-07-14"     
        } 
    ]

Example Response (When No Group Expenses Exist/No group exist):

    {     
        "message": "No expenses found for group ID: {groupId}",     
        "success": false 
    }

By completing this task, you will enhance their expertise in building APIs tailored for specific data exploration scenarios. You will learn to handle dynamic parameters, query databases based on specific criteria, and generate well-structured responses. This experience will contribute to your skills in designing APIs that cater to diverse user needs within a financial system.


## Task 10: Update Expense Details	
This task empowers users to modify expense details within the expense sharing system. Developers will implement a POST endpoint, "/expense/update/{expense_id}", enabling users to update expense information.

The input JSON object contains the modified expense attributes, such as title, amount, payer, beneficiaries, and payment date.

The API validates for various scenarios such as  , "Participant '{participant}' is not found in the participants list" and "Paid by participant '{paidBy}' is not found in the participants list".

Example Input:

    {   
        "title": "RoomRent",   
        "amount": 8000.0,   
        "paidBy": "Abhilasha",   
        "forWhom": [
            "Purnima", 
            "Nikki", 
            "Abhilasha",
            "Riya"
        ],   
        "paymentDate": "2023-08-09" 
    }

The entered data in '/expense/group/{groupId}/addExpense' will undergo thorough validation to ensure accuracy and completeness. Special attention will be given to the:

1)"Expense id {expense_id} not found"- If the {expense_id} is not found in the expenses table. 2)"No changes found. Expense details remain the same."-If no updation as the input details are same as existing one. 3)"Title of the group should not be null or blank."- The title of the input should not be null or blank 4)"Participants list should contain more than 1 non-blank participant."-The "forWhom" list should be List and not String, and the "forWhom" list should not be empty ,null or should not have only one name in "forWhom" list. 5)"Paid By name should be there" 6)"Paid by participant '" + paidBy + "' is not found in the participants list"-If the paid by name is not there in the participants list of the group Id 7)"Participant '" + participant + "' is not found in the participants list"-If any name in the "forWhom" list is not there in the participants list of the group Id

Upon successful update in the "expenses" table, the response returns the updated expense details, including the expense ID, title,groupId, amount, paidBy,list of forWhom  and the paymentDate.

Example Response (Successful Update):

    {     
        "id": 1,     
        "title": "RoomRent",     
        "groupId": 1,     
        "amount": 8000.0,     
        "paidBy": "Abhilasha",     
        "forWhom": [         
            "Purnima",         
            "Nikki",         
            "Abhilasha",         
            "Riya"     
        ],     
        "paymentDate": "2023-08-09" 
    }

This task extends the functionality of updating expenses by implementing calculations and updates for individual contributions. Similar to the previously mentioned calculation and update process (in task 6), the system recalculates individual contributions based on the modified expense details. It clears existing transaction entries associated with the expense ID and stores the recalculated contributions in the "expense_transactions" table, along with corresponding transaction entries in the "transaction_entries" table.

By accomplishing this task, you will enhance their skillset in building APIs for data modification. You will gain hands-on experience in handling dynamic parameters, validating and updating data, and maintaining data integrity in a financial system. This expertise can be applied to create more comprehensive and user-friendly APIs.You will also  gain insights into how to orchestrate the recalculation process while maintaining data consistency and accuracy. This knowledge is valuable when managing data updates in financial systems.


## Task 11: Delete Expense
This task enables users to delete an expense from the "expenses" table by its ID. Developers will implement a POST endpoint, "/expense/delete/{expense_Id}", facilitating the deletion process. All associated transaction entries are also removed when an expense is deleted. If the expense ID is not found, the API responds with an appropriate error message. The response of successful deletion includes a JSON format response indicating the success of the operation.

Example Response (on successful deletion):

    {
        "success": true
    }

Example Response (when expense ID is not found):

    {
        "message": "Expense not found with ID {expense_Id}",
        "success": false
    }

By completing this task, you will gain valuable experience in building APIs for data deletion. You will learn how to ensure data integrity during deletion, handle associated data removal, and generate meaningful responses to communicate the outcome of the operation. This knowledge is vital for maintaining the accuracy and reliability of financial systems.


## Task 12: View Calculated Individual Contributions
This task centers around displaying the computed individual contributions through a designated endpoint. Displaying Individual Contributions: (GET) "/expense/transaction/{expenseId}"

Users can access the GET endpoint "/expense/transaction/{expenseId}" to view calculated individual contributions. The system validates the provided expense ID and ensures the presence of the associated expense transaction.

The response from the endpoint furnishes comprehensive information about the expense, encompassing details like the expense ID, group ID, amount, payer, and participants for whom the expense is shared. Additionally, it presents a collection of transaction entries that outline the debtor, creditor, and the respective contribution amount for each participant.

Example Response:

    {     
        "expenseId": 1,     
        "groupId": 1,     
        "amount": 8000.00,     
        "paidBy": "Abhilasha",     
        "forWhom": [         
            "Purnima",         
            "Nikki",         
            "Abhilasha",         
            "Raj"     
        ],     
        "transactionEntries": [         
            {             
                "debtor": "Purnima",             
                "creditor": "Abhilasha",             
                "amount": 2000.00         
            },         
            {             
                "debtor": "Nikki",             
                "creditor": "Abhilasha",             
                "amount": 2000.00         
            },         
            {             
                "debtor": "Riya",             
                "creditor": "Abhilasha",             
                "amount": 2000.00         
            }     
        ] 
    }

By completing this task, you will enrich their proficiency in crafting endpoints that provide essential data insights. You will learn to structure responses to showcase both overall expense information and detailed transaction entries. This experience contributes to your skills in presenting complex financial calculations and data in a user-friendly manner.


## Task 13: Calculate Group Expenses and Participant Balances
This task involves the calculation of all the expenses within a specific expense sharing group. It provides the functionality to determine the individual balances for each participant in the group. The GET endpoint used for this task is "/expense/group/{groupId}/balance".

Upon invoking the endpoint, the system undertakes the following steps:

1)Retrieves the expense sharing group based on the provided group ID.

2)Collects the list of participants within the group.

3)Fetches the expense transactions associated with the group.

4)Calculates the individual balances for each participant based on the expense transactions.

5)Prepares a response in the form of a DTO (Data Transfer Object), containing the group ID, participants list, and individual balance information.

The response encompasses an array of participant balances, where each balance is presented as either a positive or negative value. A negative balance signifies indebtedness to other participants, whereas a positive balance signifies owed funds from other participants.

The response for above is:

    {
        "groupId": 1,
        "participants": [
            "Nikki",
            "Abhilasha",
            "Purnima",
            "Riya"
        ],
        "totalBalance": [
            {
                "participant": "Nikki",
                "balance": -2000.00,
                "givenBy": [],
                "givenTo": [
                    {
                        "participant": "Abhilasha",
                        "amount": 2000.00
                    }
                ]
            },
            {
                "participant": "Abhilasha",
                "balance": 6000.00,
                "givenBy": [
                    {
                        "participant": "Nikki",
                        "amount": 2000.00
                    },
                    {
                        "participant": "Purnima",
                        "amount": 2000.00
                    },
                    {
                        "participant": "Riya",
                        "amount": 2000.00
                    }
                ],
                "givenTo": []
            },
            {
                "participant": "Purnima",
                "balance": -2000.00,
                "givenBy": [],
                "givenTo": [
                    {
                        "participant": "Abhilasha",
                        "amount": 2000.00
                    }
                ]
            },
            {
                "participant": "Riya",
                "balance": -2000.00,
                "givenBy": [],
                "givenTo": [
                    {
                        "participant": "Abhilasha",
                        "amount": 2000.00
                    }
                ]
            }
        ]
    }

Additionally, the response provides detailed information for each participant, including the debts owed and credits received. The "givenBy" field lists the participants who owe money to the current participant, along with the corresponding debt amounts. The "givenTo" field lists the participants to whom the current participant owes money, along with the respective credit amounts.

By implementing this task, users can easily track and manage the group's expenses, ensuring transparency and fair distribution of financial obligations among the participants.






