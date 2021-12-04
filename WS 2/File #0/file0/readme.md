Is this markdown hard to read? Go to https://dillinger.io/, then copy and paste all text within this document in the markdown panel.

# Peer review
---
Sequence diagram for **Get Member Details** is located at
* [Sequence Diagram - Infrastructure](https://sequencediagram.org/index.html?presentationMode=readOnly#initialData=C4S2BsFMAIE0EMDGALYBhcBXARtAtNAJIB2AZgE7wDOw5miwm5kAUAA7zmiIgfHDQARAC4ACuQD2Ac0oBbQdGrRx0ue07de8fkOEBBNm3AhE8UBOIKlBoybMgL6ria06RAUQAeiSG3PEAWRAAE2CoAHdOSCsqaACARidNPgERACUJTGBIINCIqJi4gCYklxTdPSzkSH47f1ywyEjmQoCAZlKeco9iYLYJEH4G-JbFWICAFk7XVOF3XuGmgrG4gFZp7uEAyFlsSHI0C1oJcChyQsP+SVP9lngsi0xd25YAbTwAPmVJGXhZYTi8EGAAoaORBlJXgBdRTkKRUACUdwYIAAbmYYCpfrIWFi5J8bMZTP4AWlMMQ9FQAJ7ERDApFIUDo7LQQl1BzEFhs4kcgmGIn2Cyk8n05FMjGs-nsxzwcACYgSASmWmQG7BFjgCQSNjQcLIEBQLlSnkWPm2E3EUmQeDBAAyg0gosZaIlCSN5sFxE+CQBAAltI0nSjmTAAiUEt6in6A1BRWHIwCAMqQYDzPoDfhB8Us9oseMfdrR3qxhlyxRVGrcT3QECxBXyyCQYJNvNtb1tAGEKiVYDVWrEptZl05qbtb0TIuBpGqqgwe69yvS4g1uuN5vqsdmgUk6AAFWoAGsWDV1bKBP7Yif+oNgHmJp9LscbuQAQBxFPAkJIx-XM54cdWow5DLoQABqIBNHeAHQGkJ77NA4GQSeLBQe2AL7lQR7Ns6IZxKObYJnuh4sNhwauh08bevE6HEaR2ahuG8T-h83KejRmEkdaZE5okx69JxOESqx-jHuAs7QMqPhqu6268ixxpsdAibANqlI0nSSKvAAPAQwkcgCkCeGAAncTAemOHRw6Yj8ajISwQA)
* [Sequence Diagram - Get Member Details](https://sequencediagram.org/index.html?presentationMode=readOnly#initialData=C4S2BsFMAIE0EMDGALYBhcBXARtAtNAOKTDQCykAttpAE7QAiJ8I4AzgFAAO8toiIHgDtSAIgBcFanTQB7EbVngotUdHhtochUpXde-QfBHQJUmrQDKdAG4hEkNRujXadh-r72jJs1QsASpBcsmxgsrQAnk6aQSFhwBGRnobCYuIIKOhY2NrAkAAewDFa8vlFHAAm8MDw2BowEgwAQiUtHPCYiUKY0rQcHADaeAB8pTrKdOJEJAAUIJUAlB2IoDY1MHmKk-1bunSjru6Q08TA80sraxsutvaQA-DgpABqTws1IPLQbJiIDmw2AAzTDgDhHe54Q53BzTN7gD75WbLCEOUZxULhKKnOYLZZIa75aAYhJJDgkrGRUZ5QrAaYAMRAQkqAEE2JEhIgADzmOgjC741YgdZEmkVMXAUYtabWKCrZFXYU3dotKEjCXTIK-Z7WYBVSAEpVE9oStUUxLY4kkTC0ITkfx0fWGkWbMq08nBTEWqnQtz3TXW232vpOoUuq3xSngmGQNV7HYB4A2u28-qDLkEeMqaappi1VhsF4gSAAd1DhNdEz0kHYMHhiK+dqBLCglUV4azjtRsepZW22egAFFaIp+pUDWGbt2hhnxsB+1MhyOIkXS+WjZX5-t+pBmQMgA)

The class diagram is located in a folder named ```class-diagram```.
The executable file is located [here](https://www.dropbox.com/s/4qjx4n8oq6iqgiq/win-x64.zip?dl=0)

**A friendly reminder**
There are still a lot of ```TODOs``` in both the code and diagrams. Some code is still pretty crappy and not commented (```WIP```).

# Getting Started
---
These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

## Prerequisites
*  Install [.NET Core SDK 3.1](https://dotnet.microsoft.com/download/)
-_or_-
*  Use an IDE which supports .NET, e.g. [Rider](https://www.jetbrains.com/rider/) or [Visual Studio](https://visualstudio.microsoft.com/)

## Run application

* Download the `win-x64.zip` (click [here](https://www.dropbox.com/s/4qjx4n8oq6iqgiq/win-x64.zip?dl=0)), unzip and double-click on the `UI.exe`
-_or_-
* Publish and execute the dll via  [.NET CLI tools](https://docs.microsoft.com/en-us/dotnet/core/tools/)
`dotnet publish -c Release -r <RID> --self-contained true` and run `dotnet UI.dll`
-_or_-
* Use the .NET friendly IDE and press _Run_ (F5)

**Attention**
You need to log in, in order to use the application.
```login -u admin -p password```
```
COMMAND              ARGUMENT(S)                                DESCRIPTION
login                -u (username) -p (password) -c (2fa code)  Login
logout                                                          Logout
setup2fa                                                        Setup 2FA
enable2fa            -c (verification code)                     Enable 2FA
boat-register        -id (member id) -t (type) -l (length)      Register boat
boat-update          -id (member id) -t (type) -l (length)      Update boat
boat-delete          -id (boat id)                              Delete boat
member-get           -id (member id)                            Get member details
member-list                                                     List members
member-register      -n (name) -pin (pers.id)                   Register member
member-update        -id (member id) -n (name) -pin (pers.id)   Update member
member-delete        -id (member id)                            Delete member
user-list                                                       List application user
```

# Workshop 2
----
- [x] Create a new member with a name, personal number, a unique member id should
   be created and assigned to the new member.
    * The member id should be something that could be printed on a small
      membership-card and handled by a human mind, I.e. no superlong GUID like
      stuff.
    
- [x] Show lists of all members in two different ways:
    * [x] “Compact List”; name, member id and number of boats
    * [ ] “Verbose List”; name, personal number, member id and boats with boat
      information
- [x] Delete a member
- [x] Change a member’s information
- [x] Look at a specific member’s information
- [x] Register a new boat for a member the boat should have a type (Sailboat, Motorsailer, kayak/Canoe, Other) and a length.
- [x] Delete a boat
- [x] Change a boat’s information
- [x] Persistence (the registry should be saved and loaded for example from a text file.)
- [x] Strict Model-View separation:
    The model should not depend on the view or user interface in any way (direct or indirect)
    The model should not have user interface responsibilities
    The user interface (view) should not implement domain functionality
- [ ] Good quality of code (for example naming, standards, duplication)
- [ ] An object oriented design and implementation. This includes but is not limited to:
    * Objects are connected using associations and not with keys/ids.
    * Classes have high cohesion and are not too large or have too much responsibility.
    * Classes have low coupling and are not too connected to other entities.
    * Avoid the use of static variables and operations as well as global variables.
    * Avoid hidden dependencies.
    * Informations should be encapsulated.
    * Use a natural design, the domain model should inspire the design.
- [x] Simple error handling. The application should not crash but it does not need to be user friendly.
- [x] Participate in the peer review process