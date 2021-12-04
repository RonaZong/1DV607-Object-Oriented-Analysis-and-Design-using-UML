README:

This is a companion to the different files and tries to be as brief as possible just like the diagrams and focuses on understanding and following concepts like GRASP, CRUD and Model-view sepration instead of going into grainular detail which can easily been found in the java files.

1.0 Notes on the Class Diagram:

- The domain classes are at the top, the UI elements at the bottom, and to the bottom right you find the main class and technical services.

- The class MemberManager takes inspiration from Craig Larman's class Register in figure 17.24. It follows the GRASP Controller pattern.

- All classes have been following Information Expert to the best of my knowledge.

- There was a time when I thought I'd introduce a BoatManager class to make better cohesive classes but it would just mean more coupling which didn't seem to be worth the trade of since MemberManager wasn't bloated and all methods still relevant since Boats are owned by Members.

- The many ConsoleTextUI classes may seem a bit many, however, can be viewed as UI elements and better than a super bloated YachtClubTextUI.

1.1. Notes on the Sequence Diagram:

As per requirement the Sequence Diagram covers a single input requirement and one output requirement and named as aforementioned requirements.

I've kept the details in the diagram to a minimum as in my humble opinion the specific internals can be found in the code and not as important as understanding and showing that we preserve the Model-view separation.

Notes on 01 Retrieve Member Information.png:

- An actor selects to retrieve a members information in point 1. and the RetrieveMemberUI is shown. We ask for the member ID of the member with the scanner and print stream objects in 1.1 to 1.3. After that we contact the Controller MemberManager at 1.4 to retrieve the member from the HashMap it's stored in (1.4.1). We ask for the information on the Member in 1.4.2 and in turn the Member compiles everything it has including any Boats if available as seen in 1.4.2.1 and 1.4.2.2. This is all returned to be printed on the screen.

Notes on 02 Create Member.png:

So starting at point 1. an actor selects to create a new member. In 1.1 and 1.2 we prompt the information with a Scanner class. Once we have the information we contact the Controller or in this case the MemberManager that creates a member and saves it in a map where the key value is the member ID described in section 1.2 of this document.

1.2 Assumptions Made in Regards to Requirements:

- Please note that GRASP patterns has always been kept in the back of the mind when producing this especially Controller, Information Expert, High Cohesion, Low Coupling and more.

- The MVC does not follow naming of Model View Controller but follows the course books UI, Domain, Technical Services.

- Three is proper formatting of user input but did not validate the data.

- Medium amount of error handling has been implemented.

- There is no search functionality as it's a higher grade requirement, although one can select members.

- There are no external dependencies for compiling the java source. To the run the executable java -jar YachtClub.jar.

- All folders in the zip are self-explanatory e.g. Source Code, Executable, UML Class Diagram, Sequence Diagram and so on.

- Initial UUID was used but since the requirements stated to use something simpler a unique member ID was used incrementally. An example where it was taken from: "Craig Silverstein was Google's 3rd hire". Craig Silverstein will always be the 3rd employee and members will always own the unique member id even if not a member any longer.

Changes:

Version 0.1:

- Initial hand in for peer-review created.
